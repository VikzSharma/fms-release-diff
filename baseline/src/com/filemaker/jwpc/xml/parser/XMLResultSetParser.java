/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.FindType
 *  com.filemaker.jwpc.fmwp.api.thrift.service.NVPair
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ComplexParam
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.FieldParam
 *  com.filemaker.jwpc.fmwp.datatype.FieldsParam
 *  javolution.util.FastList
 */
package com.filemaker.jwpc.xml.parser;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.fmwp.api.thrift.service.FindType;
import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.FieldParam;
import com.filemaker.jwpc.fmwp.datatype.FieldsParam;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.parser.FieldValues;
import com.filemaker.jwpc.xml.parser.ParserReturnCode;
import com.filemaker.jwpc.xml.parser.XMLCGIParser;
import com.filemaker.jwpc.xml.response.XMLResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javolution.util.FastList;

public class XMLResultSetParser
extends XMLCGIParser {
    private ConfigXMLRequest req = new ConfigXMLRequest();
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLResultSetParser.class);

    public XMLResultSetParser(LinkedHashMap<String, ArrayList<String>> linkedHashMap, XMLResponse.ResponseType responseType) {
        this.mQueryMap = linkedHashMap;
        this.req.setResponseType(responseType);
    }

    @Override
    public ConfigXMLRequest parse() {
        ParserReturnCode parserReturnCode;
        logger.debugEntering("parse");
        if (this.setCmdCode(this.req) && (parserReturnCode = this.verify(this.req)).hasError()) {
            this.req.setWPCError(parserReturnCode);
        }
        logger.debugExiting("parse");
        return this.req;
    }

    public ParserReturnCode verify(ConfigXMLRequest configXMLRequest) {
        CmdCode cmdCode = CmdCode.fromValue((int)configXMLRequest.getCmdCode());
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        switch (cmdCode) {
            case FIND: {
                parserReturnCode = this.verifyFind(configXMLRequest, true);
                break;
            }
            case FINDALL: 
            case FINDANY: {
                parserReturnCode = this.verifyFind(configXMLRequest, false);
                break;
            }
            case REMOVE: {
                parserReturnCode = this.verifyDelete(configXMLRequest);
                break;
            }
            case DUPLICATE: {
                parserReturnCode = this.verifyDup(configXMLRequest);
                break;
            }
            case MODIFY: {
                parserReturnCode = this.verifyEdit(configXMLRequest);
                break;
            }
            case ADD: {
                parserReturnCode = this.verifyAdd(configXMLRequest);
                break;
            }
            case VIEW: {
                parserReturnCode = this.verifyView(configXMLRequest);
                break;
            }
            case DBNAMES: {
                parserReturnCode = this.verifyDbNames(configXMLRequest);
                break;
            }
            case LAYOUTNAMES: 
            case SCRIPTNAMES: {
                parserReturnCode = this.verifyNames(configXMLRequest);
                break;
            }
            case FINDQUERY: {
                parserReturnCode = this.verifyFindQuery(configXMLRequest);
                break;
            }
            default: {
                parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode());
            }
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyDbNames(ConfigXMLRequest configXMLRequest) {
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        for (String string : this.mQueryMap.keySet()) {
            parserReturnCode = this.checkDBNames(string, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed()) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode(), string);
        }
        return ParserReturnCode.PROCESSED;
    }

    public ParserReturnCode verifyNames(ConfigXMLRequest configXMLRequest) {
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        for (String string : this.mQueryMap.keySet()) {
            parserReturnCode = this.checkDB(string, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkNames(string);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreNames(string)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode(), string);
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        return ParserReturnCode.PROCESSED;
    }

    public ParserReturnCode verifyFind(ConfigXMLRequest configXMLRequest, boolean bl) {
        ArrayList arrayList2;
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        String[] stringArray = new String[10];
        String[] stringArray2 = new String[10];
        LinkedHashMap<String, FieldValues> linkedHashMap = new LinkedHashMap<String, FieldValues>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        LinkedHashMap<String, FieldValues> linkedHashMap2 = new LinkedHashMap<String, FieldValues>();
        for (ArrayList arrayList2 : this.mQueryMap.keySet()) {
            parserReturnCode = this.checkDB((String)((Object)arrayList2), configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField((String)((Object)arrayList2), configXMLRequest, linkedHashMap2, linkedHashMap, hashMap, true);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRecordId((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLOP((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkMax((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSkip((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSortField((String)((Object)arrayList2), stringArray);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSortOrder((String)((Object)arrayList2), stringArray2);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayResponse((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsFilter((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsMax((String)((Object)arrayList2), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkFind((String)((Object)arrayList2));
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreFind((String)((Object)arrayList2))) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode(), (String)((Object)arrayList2));
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        arrayList2 = new ArrayList();
        parserReturnCode = this.validateSortParams(arrayList2, stringArray, stringArray2);
        if (parserReturnCode.hasError()) {
            return parserReturnCode;
        }
        configXMLRequest.setSortFields(arrayList2);
        ArrayList<FieldsParam> arrayList3 = new ArrayList<FieldsParam>();
        parserReturnCode = this.validateFindFields(configXMLRequest, arrayList3, linkedHashMap, hashMap, bl);
        FieldsParam fieldsParam = new FieldsParam();
        if (!parserReturnCode.hasError()) {
            parserReturnCode = this.getGlobalFieldsParamList(configXMLRequest, fieldsParam, linkedHashMap2);
        }
        if (!parserReturnCode.hasError()) {
            configXMLRequest.setFields(arrayList3);
            configXMLRequest.setGlobalFields(fieldsParam);
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyFindQuery(ConfigXMLRequest configXMLRequest) {
        ArrayList arrayList3;
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        String[] stringArray = new String[10];
        String[] stringArray2 = new String[10];
        HashMap<String, FieldValues> hashMap = new HashMap<String, FieldValues>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        LinkedHashMap<String, FieldValues> linkedHashMap = new LinkedHashMap<String, FieldValues>();
        ArrayList<FieldsParam> arrayList2 = new ArrayList<FieldsParam>();
        HashMap<String, ComplexParam> hashMap3 = new HashMap<String, ComplexParam>();
        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        parserReturnCode = this.parseFindQuery(arrayList2);
        if (parserReturnCode.hasError()) {
            return parserReturnCode;
        }
        for (ArrayList arrayList3 : this.mQueryMap.keySet()) {
            parserReturnCode = this.checkDB((String)((Object)arrayList3), configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkCompQuery((String)((Object)arrayList3), hashMap3, hashMap4);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField((String)((Object)arrayList3), configXMLRequest, linkedHashMap, hashMap, hashMap2, true);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRecordId((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkMax((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSkip((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSortField((String)((Object)arrayList3), stringArray);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkSortOrder((String)((Object)arrayList3), stringArray2);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayResponse((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsFilter((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsMax((String)((Object)arrayList3), configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkFindQuery((String)((Object)arrayList3));
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreFind((String)((Object)arrayList3))) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode(), (String)((Object)arrayList3));
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        arrayList3 = new ArrayList();
        parserReturnCode = this.validateSortParams(arrayList3, stringArray, stringArray2);
        if (parserReturnCode.hasError()) {
            return parserReturnCode;
        }
        configXMLRequest.setSortFields(arrayList3);
        parserReturnCode = this.validateFindQueries(configXMLRequest, arrayList2, hashMap3, hashMap4);
        FieldsParam fieldsParam = new FieldsParam();
        if (!parserReturnCode.hasError()) {
            parserReturnCode = this.getGlobalFieldsParamList(configXMLRequest, fieldsParam, linkedHashMap);
        }
        if (!parserReturnCode.hasError()) {
            configXMLRequest.setFields(arrayList2);
            configXMLRequest.setGlobalFields(fieldsParam);
        }
        return parserReturnCode;
    }

    private ParserReturnCode parseFindQuery(List<FieldsParam> list) {
        ParserReturnCode parserReturnCode = ParserReturnCode.PROCESSED;
        ArrayList arrayList = (ArrayList)this.mQueryMap.get("-query");
        if (arrayList != null && arrayList.size() > 0) {
            String string = (String)arrayList.get(0);
            if (string != null && string.trim().length() > 0) {
                String[] stringArray = string.split(";");
                for (int i = 0; i < stringArray.length; ++i) {
                    boolean bl = false;
                    String string2 = stringArray[i];
                    try {
                        if (string2.charAt(0) == '!') {
                            bl = true;
                            string2 = string2.substring(1);
                        }
                        if (string2.charAt(0) != '(' || string2.charAt(string2.length() - 1) != ')') {
                            parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
                            break;
                        }
                        string2 = string2.substring(1, string2.length() - 1);
                        String[] stringArray2 = string2.split(",");
                        FindType findType = bl ? FindType.Find_Omit : FindType.Find_Include;
                        FieldsParam fieldsParam = new FieldsParam(findType);
                        for (int j = 0; j < stringArray2.length; ++j) {
                            String string3 = stringArray2[j].trim();
                            if (string3.charAt(0) != 'q') {
                                parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string3);
                                break;
                            }
                            String string4 = string3.substring(1);
                            int n = Utilities.getNumValue(string4);
                            if (n < 0) {
                                parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
                                break;
                            }
                            fieldsParam.addField(new FieldParam(string4, "", 1));
                        }
                        if (!parserReturnCode.hasError()) {
                            list.add(fieldsParam);
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
                    }
                    if (!parserReturnCode.hasError()) {
                        continue;
                    }
                    break;
                }
            } else {
                parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.EmptyQuery.getErrorCode());
            }
        } else {
            parserReturnCode = new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode());
        }
        return parserReturnCode;
    }

    public ParserReturnCode checkCompQuery(String string, Map<String, ComplexParam> map, Map<String, String> map2) {
        boolean bl = false;
        String string2 = string;
        if (string != null && string.startsWith("-q")) {
            int n;
            boolean bl2 = false;
            if ((string = string.substring(2)).endsWith(".value")) {
                bl2 = true;
                string = string.substring(0, string.length() - 6);
            }
            if ((n = Utilities.getNumValue(string)) >= 0) {
                String string3 = (String)((ArrayList)this.mQueryMap.get(string2)).get(0);
                if (bl2) {
                    bl = true;
                    map2.put(string, string3);
                } else if (string3 != null && string3.trim().length() > 0) {
                    bl = true;
                    ComplexParam complexParam = XMLResultSetParser.parseField(string3 = XMLResultSetParser.getFieldName(string3, true, true), "", "");
                    ParserReturnCode parserReturnCode = XMLResultSetParser.validateField(complexParam);
                    if (parserReturnCode.hasError()) {
                        return parserReturnCode;
                    }
                    map.put(string, complexParam);
                }
            }
        }
        return bl ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    public ParserReturnCode validateFindQueries(ConfigXMLRequest configXMLRequest, List<FieldsParam> list, Map<String, ComplexParam> map, Map<String, String> map2) {
        ParserReturnCode parserReturnCode = ParserReturnCode.PROCESSED;
        boolean bl = false;
        for (FieldsParam fieldsParam : list) {
            ArrayList<FieldParam> arrayList = new ArrayList<FieldParam>();
            ArrayList<ComplexParam> arrayList2 = new ArrayList<ComplexParam>();
            for (FieldParam fieldParam : fieldsParam.getFields()) {
                boolean bl2;
                ComplexParam complexParam = map.get(fieldParam.getName());
                String string = map2.get(fieldParam.getName());
                if (complexParam == null || Utilities.isEmptyString(complexParam.getName()) || string == null) continue;
                complexParam.setValue(string);
                String string2 = complexParam.getTableName();
                boolean bl3 = bl2 = !Utilities.isEmptyString(string2);
                if (!bl2) {
                    arrayList.add(complexParam.getField());
                    continue;
                }
                arrayList2.add(complexParam);
            }
            if (!bl) {
                fieldsParam.setFields(arrayList);
                fieldsParam.setRelatedFields(arrayList2);
                continue;
            }
            arrayList.clear();
            arrayList2.clear();
            fieldsParam.setFields(arrayList);
            fieldsParam.setRelatedFields(arrayList2);
            break;
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyDelete(ConfigXMLRequest configXMLRequest) {
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        for (String string : this.mQueryMap.keySet()) {
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
                parserReturnCode = this.checkDelete(string);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.ignoreField(string);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreDelete(string)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode(), string);
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        if (configXMLRequest.getRecordId().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode(), "-recid");
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyDup(ConfigXMLRequest configXMLRequest) {
        Object object;
        HashMap<String, FieldValues> hashMap = new HashMap<String, FieldValues>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        LinkedHashMap<String, FieldValues> linkedHashMap = new LinkedHashMap<String, FieldValues>();
        Iterator iterator = this.mQueryMap.keySet().iterator();
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            parserReturnCode = this.checkDB((String)object, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField((String)object, configXMLRequest, linkedHashMap, hashMap, hashMap2, false);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRecordId((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayResponse((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsFilter((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsMax((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkDup((String)object);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreDup((String)object)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode());
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        if (configXMLRequest.getRecordId().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode(), "-recid");
        }
        object = new ArrayList();
        parserReturnCode = this.getEditFieldsParamList(configXMLRequest, (List<FieldsParam>)object, hashMap);
        FieldsParam fieldsParam = new FieldsParam();
        if (!parserReturnCode.hasError()) {
            parserReturnCode = this.getGlobalFieldsParamList(configXMLRequest, fieldsParam, linkedHashMap);
        }
        if (!parserReturnCode.hasError()) {
            configXMLRequest.setFields((List<FieldsParam>)object);
            configXMLRequest.setGlobalFields(fieldsParam);
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyEdit(ConfigXMLRequest configXMLRequest) {
        Object object;
        LinkedHashMap<String, FieldValues> linkedHashMap = new LinkedHashMap<String, FieldValues>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        LinkedHashMap<String, FieldValues> linkedHashMap2 = new LinkedHashMap<String, FieldValues>();
        FastList fastList = new FastList();
        Iterator iterator = this.mQueryMap.keySet().iterator();
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            parserReturnCode = this.checkDB((String)object, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField((String)object, configXMLRequest, linkedHashMap2, linkedHashMap, hashMap, false);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRecordId((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkModId((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayResponse((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkDeleteRelated((String)object, configXMLRequest, (List<NVPair>)fastList);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsFilter((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsMax((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkEdit((String)object);
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreEdit((String)object)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode());
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        if (configXMLRequest.getRecordId().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode(), "-recid");
        }
        object = new ArrayList();
        parserReturnCode = this.getEditFieldsParamList(configXMLRequest, (List<FieldsParam>)object, linkedHashMap);
        FieldsParam fieldsParam = new FieldsParam();
        if (!parserReturnCode.hasError()) {
            parserReturnCode = this.getGlobalFieldsParamList(configXMLRequest, fieldsParam, linkedHashMap2);
        }
        if (!parserReturnCode.hasError()) {
            configXMLRequest.setFields((List<FieldsParam>)object);
            configXMLRequest.setDeleteRelatedFields((List<NVPair>)fastList);
            configXMLRequest.setGlobalFields(fieldsParam);
        }
        return parserReturnCode;
    }

    public ParserReturnCode verifyAdd(ConfigXMLRequest configXMLRequest) {
        Object object;
        LinkedHashMap<String, FieldValues> linkedHashMap = new LinkedHashMap<String, FieldValues>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        LinkedHashMap<String, FieldValues> linkedHashMap2 = new LinkedHashMap<String, FieldValues>();
        Iterator iterator = this.mQueryMap.keySet().iterator();
        ParserReturnCode parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            parserReturnCode = this.checkDB((String)object, configXMLRequest);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayout((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkField((String)object, configXMLRequest, linkedHashMap2, linkedHashMap, hashMap, false);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkLayResponse((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkScripts((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsFilter((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkRelatedSetsMax((String)object, configXMLRequest);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (!parserReturnCode.processed()) {
                parserReturnCode = this.checkAdd((String)object);
            }
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreAdd((String)object)) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.UnknownCommand.getErrorCode());
        }
        if (configXMLRequest.getDatabaseName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoDatabaseName.getErrorCode());
        }
        if (configXMLRequest.getLayoutName().length() == 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.LayoutMissing.getErrorCode());
        }
        object = new ArrayList();
        parserReturnCode = this.getEditFieldsParamList(configXMLRequest, (List<FieldsParam>)object, linkedHashMap);
        FieldsParam fieldsParam = new FieldsParam();
        if (!parserReturnCode.hasError()) {
            parserReturnCode = this.getGlobalFieldsParamList(configXMLRequest, fieldsParam, linkedHashMap2);
        }
        if (!parserReturnCode.hasError()) {
            configXMLRequest.setFields((List<FieldsParam>)object);
            configXMLRequest.setGlobalFields(fieldsParam);
        }
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
            if (parserReturnCode.processed() || XMLResultSetParser.okToIgnoreView(string)) continue;
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

