/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.xml.parser;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.xml.parser.ParserReturnCode;
import com.filemaker.jwpc.xml.parser.XMLCGIParser;
import com.filemaker.jwpc.xml.response.XMLResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class XMLLayoutParser
extends XMLCGIParser {
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLLayoutParser.class);

    public XMLLayoutParser(LinkedHashMap<String, ArrayList<String>> linkedHashMap) {
        this.mQueryMap = linkedHashMap;
    }

    @Override
    public ConfigXMLRequest parse() {
        ParserReturnCode parserReturnCode;
        ConfigXMLRequest configXMLRequest = new ConfigXMLRequest();
        configXMLRequest.setResponseType(XMLResponse.ResponseType.FMPXMLLAYOUT);
        if (this.setCmdCode(configXMLRequest) && (parserReturnCode = this.verify(configXMLRequest)).hasError()) {
            configXMLRequest.setWPCError(parserReturnCode);
        }
        return configXMLRequest;
    }

    public ParserReturnCode verify(ConfigXMLRequest configXMLRequest) {
        int n = configXMLRequest.getCmdCode();
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        if (n != CmdCode.VIEW.value()) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ConflictingCommands.getErrorCode());
        }
        parserReturnCode = this.verifyView(configXMLRequest);
        return parserReturnCode;
    }

    public ParserReturnCode verifyView(ConfigXMLRequest configXMLRequest) {
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
                parserReturnCode = this.checkRecordId(string, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts(string, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkView(string);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLLayoutParser.okToIgnoreView(string)) continue;
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
}

