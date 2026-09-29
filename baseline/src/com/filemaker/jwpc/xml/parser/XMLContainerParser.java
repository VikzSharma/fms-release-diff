/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ComplexParam
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.xml.parser;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.xml.parser.ParserReturnCode;
import com.filemaker.jwpc.xml.parser.XMLCGIParser;
import com.filemaker.jwpc.xml.response.XMLResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class XMLContainerParser
extends XMLCGIParser {
    private String mGrammar = null;
    private static String JPEG = "jpeg";
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLContainerParser.class);
    private static final long MAX_DATA_SIZE = 10240000L;

    public XMLContainerParser(LinkedHashMap<String, ArrayList<String>> linkedHashMap, String string) {
        this.mGrammar = string;
        this.mQueryMap = linkedHashMap;
    }

    @Override
    public ConfigXMLRequest parse() {
        Object object;
        ConfigXMLRequest configXMLRequest = new ConfigXMLRequest();
        configXMLRequest.setResponseType(XMLResponse.ResponseType.CONTAINER);
        configXMLRequest.setCmdCode(CmdCode.CONTAINER);
        configXMLRequest.getRequestParam().getParam().setModId(-1L);
        int n = this.mGrammar.lastIndexOf("/");
        if (n > -1) {
            object = this.mGrammar.substring(n + 1);
            configXMLRequest.setContainerFileName((String)object);
        }
        if (((ParserReturnCode)(object = this.verify(configXMLRequest))).hasError()) {
            configXMLRequest.setWPCError((ParserReturnCode)object);
        }
        return configXMLRequest;
    }

    public String getContainerType() {
        String string = JPEG;
        if (this.mGrammar == null || this.mGrammar.trim().length() == 0) {
            return string;
        }
        int n = this.mGrammar.indexOf(CONTAINER);
        if (n < 0) {
            return string;
        }
        string = this.mGrammar.substring(n + CONTAINER.length());
        return string;
    }

    public ParserReturnCode verify(ConfigXMLRequest configXMLRequest) {
        Iterator iterator = this.mQueryMap.keySet().iterator();
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            parserReturnCode = this.checkDB(string, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout(string, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField(string, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRecordId(string, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || this.okToIgnoreContainer(string)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode());
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        return parserReturnCode;
    }

    public ParserReturnCode checkField(String string, ConfigXMLRequest configXMLRequest) {
        String string2;
        ComplexParam complexParam;
        ArrayList arrayList;
        if (string.equalsIgnoreCase("-field") && (arrayList = (ArrayList)this.mQueryMap.get(string)) != null && (complexParam = XMLContainerParser.parseContainerField(string2 = (String)arrayList.get(0))) != null) {
            configXMLRequest.setField(complexParam);
            configXMLRequest.setKeyName(complexParam.getName());
            configXMLRequest.setRepetition(complexParam.getRepetition());
            configXMLRequest.setItemsToSkip(0L);
            configXMLRequest.setMaxItems(10240000L);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected static ComplexParam parseContainerField(String string) {
        ComplexParam complexParam = null;
        int n = string.lastIndexOf("(");
        int n2 = string.lastIndexOf(").");
        int n3 = string.length() - 1;
        String string2 = "";
        if (n > 0 && n2 > n + 1 && n2 + 1 != n3) {
            string2 = string.substring(n2 + 2);
            string = string.substring(0, n2 + 1);
        }
        complexParam = XMLContainerParser.parseField(string, "", string2);
        return complexParam;
    }
}

