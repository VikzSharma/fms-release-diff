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
 *  com.filemaker.jwpc.fmwp.datatype.RequestOptionSet$RequestOptionBit
 */
package com.filemaker.jwpc.xml.parser;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.exceptions.UnSupportedXMLGrammarException;
import com.filemaker.jwpc.fmwp.api.thrift.service.FindType;
import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.FieldParam;
import com.filemaker.jwpc.fmwp.datatype.FieldsParam;
import com.filemaker.jwpc.fmwp.datatype.RequestOptionSet;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.parser.FieldValues;
import com.filemaker.jwpc.xml.parser.ParserReturnCode;
import com.filemaker.jwpc.xml.parser.XMLContainerParser;
import com.filemaker.jwpc.xml.parser.XMLLayoutParser;
import com.filemaker.jwpc.xml.parser.XMLResultSetParser;
import com.filemaker.jwpc.xml.response.XMLResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class XMLCGIParser {
    protected static String FMRESULTSET = "fmresultset.xml";
    protected static String FMPXMLRESULT = "FMPXMLRESULT.xml";
    protected static String FMPXMLLAYOUT = "FMPXMLLAYOUT.xml";
    protected static String CONTAINER = "cnt";
    protected LinkedHashMap<String, ArrayList<String>> mQueryMap = null;
    private static final List<String> ignoreFindList = Arrays.asList("");
    private static final List<String> ignoreEditList = Arrays.asList("-max", "-skip", "-lop");
    private static final List<String> ignoreAddList = Arrays.asList("-max", "-skip", "-lop", "-delete.related");
    private static final List<String> ignoreDeleteList = Arrays.asList("-max", "-skip", "-lop", "-delete.related", "-relatedsets.max", "-relatedsets.filter", "-modid", "-field", "-query");
    private static final List<String> ignoreDupList = Arrays.asList("-max", "-skip", "-lop", "-delete.related");
    private static final List<String> ignoreViewList = Arrays.asList("-max", "-skip", "-lop", "-script", "-script.param", "-script.presort", "-script.presort.param", "-script.prefind", "-script.prefind.param", "-modid", "-lay.response", "-query", "-delete.related", "-relatedsets.filter", "-relatedsets.max", "-query", "-field", "-delete.related", "-recid");
    private static final List<String> ignoreContainerList = Arrays.asList("-max", "-skip", "-lop", "-script", "-script.param", "-script.presort", "-script.presort.param", "-script.prefind", "-script.prefind.param", "-modid", "-lay.response", "-query", "-delete.related", "-relatedsets.filter", "-relatedsets.max");
    private static final List<String> ignoreNamesList = Arrays.asList("-max", "-skip", "-lay", "-lop", "-script", "-script.param", "-script.presort", "-script.presort.param", "-script.prefind", "-script.prefind.param", "-modid", "-lay.response", "-query", "-delete.related", "-relatedsets.filter", "-relatedsets.max", "-recid", "-modid", "-query", "-field");
    private static final List<String> commandList = Arrays.asList("-find", "-findall", "-findany", "-findquery", "-dbnames", "-layoutnames", "-scriptnames", "-new", "-edit", "-delete", "-dup", "-view");
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLCGIParser.class);

    public static XMLCGIParser getInstance(String string, LinkedHashMap<String, ArrayList<String>> linkedHashMap) throws UnSupportedXMLGrammarException {
        if (string == null || string.trim().length() == 0) {
            throw new UnSupportedXMLGrammarException("");
        }
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        if (string.contentEquals(FMRESULTSET)) {
            return new XMLResultSetParser(linkedHashMap, XMLResponse.ResponseType.FMRESULTSET);
        }
        if (string.contentEquals(FMPXMLRESULT)) {
            return new XMLResultSetParser(linkedHashMap, XMLResponse.ResponseType.FMPXMLRESULT);
        }
        if (string.contentEquals(FMPXMLLAYOUT)) {
            return new XMLLayoutParser(linkedHashMap);
        }
        if (string.startsWith(CONTAINER)) {
            return new XMLContainerParser(linkedHashMap, string);
        }
        throw new UnSupportedXMLGrammarException(string);
    }

    public abstract ConfigXMLRequest parse();

    public boolean setCmdCode(ConfigXMLRequest configXMLRequest) {
        boolean bl = false;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : this.mQueryMap.keySet()) {
            if (!commandList.contains(string)) continue;
            arrayList.add(string.toLowerCase());
        }
        if (arrayList.size() == 1) {
            String string;
            bl = true;
            String string2 = (String)arrayList.get(0);
            string = CmdCode.fromString((String)string2);
            switch (configXMLRequest.getResponseType()) {
                case FMPXMLLAYOUT: {
                    if (string == CmdCode.VIEW) {
                        configXMLRequest.setOptions(RequestOptionSet.RequestOptionBit.IncludeFieldLaySpec.value());
                        configXMLRequest.setCmdCode((CmdCode)string);
                        break;
                    }
                    configXMLRequest.setWPCError(ErrorCode.InvalidCommand);
                    break;
                }
                case FMPXMLRESULT: 
                case FMRESULTSET: {
                    configXMLRequest.setOptions(RequestOptionSet.RequestOptionBit.GroupPortalFields.value() | RequestOptionSet.RequestOptionBit.IncludeFieldSpec.value());
                    configXMLRequest.setCmdCode((CmdCode)string);
                    break;
                }
                default: {
                    configXMLRequest.setWPCError(ErrorCode.InvalidCommand);
                    break;
                }
            }
        } else if (arrayList.size() == 0) {
            configXMLRequest.setWPCError(ErrorCode.UnknownCommand);
        } else {
            configXMLRequest.setWPCError(ErrorCode.ConflictingCommands);
        }
        return bl;
    }

    protected ParserReturnCode checkDB(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-db")) {
            String string2 = this.mQueryMap.get(string).get(0);
            configXMLRequest.setDatabaseName(string2);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkDBNames(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-dbnames")) {
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkLayout(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-lay")) {
            String string2 = this.mQueryMap.get(string).get(0);
            configXMLRequest.setLayoutName(string2);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkLayResponse(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-lay.response")) {
            String string2 = this.mQueryMap.get(string).get(0);
            configXMLRequest.setResponseLayoutName(string2);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkField(String string, ConfigXMLRequest configXMLRequest, Map<String, FieldValues> map, Map<String, FieldValues> map2, Map<String, String> map3, boolean bl) {
        String string2 = string.trim().toLowerCase();
        if (!Utilities.isEmptyString(string2) && string2.charAt(0) != '-') {
            FieldValues fieldValues;
            int n;
            if (string2.endsWith(".op")) {
                String string3 = string2.substring(0, string2.length() - 3);
                if (bl) {
                    string3 = XMLCGIParser.getFieldName(string3, true, true);
                }
                ArrayList<String> arrayList = this.mQueryMap.get(string);
                n = 1;
                if (arrayList != null) {
                    for (String string4 : arrayList) {
                        if (XMLCGIParser.isValidFieldOp(string4)) continue;
                        n = 0;
                        break;
                    }
                    if (n == 0) {
                        return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string);
                    }
                    String string5 = arrayList == null ? "" : arrayList.get(0);
                    map3.put(string3, string5);
                    return ParserReturnCode.PROCESSED;
                }
            }
            boolean bl2 = false;
            int n2 = ".global".length();
            n = string2.length();
            if (string2.endsWith(".global") && n > n2) {
                bl2 = true;
                string2 = string2.substring(0, n - n2);
                string2 = XMLCGIParser.getFieldName(string2, true, false);
            } else if (bl) {
                string2 = XMLCGIParser.getFieldName(string2, true, true);
            }
            FieldValues fieldValues2 = fieldValues = bl2 ? map.get(string2) : map2.get(string2);
            if (fieldValues == null) {
                ArrayList<String> arrayList = this.mQueryMap.get(string);
                if (arrayList == null) {
                    arrayList = new ArrayList<String>();
                }
                fieldValues = new FieldValues(string.trim(), arrayList);
                if (bl2) {
                    map.put(string2, fieldValues);
                } else {
                    map2.put(string2, fieldValues);
                }
            }
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    private static boolean isValidFieldOp(String string) {
        String string2;
        return !Utilities.isEmptyString(string) && ((string2 = string.toLowerCase()).equals("cn") || string2.equals("eq") || string2.equals("bw") || string2.equals("gt") || string2.equals("gte") || string2.equals("lt") || string2.equals("lte") || string2.equals("neq") || string2.equals("ew"));
    }

    protected ParserReturnCode ignoreField(String string) {
        if (Utilities.isEmptyString(string) || string.charAt(0) != '-') {
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkRecordId(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-recid")) {
            String string2 = this.mQueryMap.get(string).get(0);
            configXMLRequest.setRecordId(string2);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkModId(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-modid")) {
            String string2 = this.mQueryMap.get(string).get(0);
            long l = Utilities.getLongValue(string2);
            if (l < 0L) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setModId(l);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkLOP(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-lop")) {
            String string2 = this.mQueryMap.get(string).get(0).toLowerCase();
            ConfigXMLRequest.LopType lopType = XMLCGIParser.convertLopType(string2);
            if (lopType == ConfigXMLRequest.LopType.None) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setLop(lopType);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    private static ConfigXMLRequest.LopType convertLopType(String string) {
        ConfigXMLRequest.LopType lopType = ConfigXMLRequest.LopType.None;
        if (string != null && string.trim().length() > 0) {
            String string2 = string.toLowerCase();
            if (string2.equals("and")) {
                lopType = ConfigXMLRequest.LopType.And;
            } else if (string2.equals("or")) {
                lopType = ConfigXMLRequest.LopType.Or;
            }
        }
        return lopType;
    }

    protected ParserReturnCode checkMax(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-max")) {
            int n = -1;
            String string2 = this.mQueryMap.get(string).get(0).toLowerCase();
            if (!string2.equalsIgnoreCase("all") && (n = Utilities.getNumValue(string2)) < 0) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setMaxItems(n);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkSkip(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-skip")) {
            String string2 = this.mQueryMap.get(string).get(0).toLowerCase();
            int n = Utilities.getNumValue(string2);
            if (n < 0) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setItemsToSkip(n);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkSortField(String string, String[] stringArray) {
        if (string.startsWith("-sortfield.")) {
            String string2 = this.mQueryMap.get(string).get(0).toLowerCase();
            string2 = XMLCGIParser.getFieldName(string2, true, true);
            ParserReturnCode parserReturnCode = this.parseSort(string, string2, stringArray);
            return parserReturnCode;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    private ParserReturnCode parseSort(String string, String string2, String[] stringArray) {
        String string3 = string.substring(string.indexOf(".") + 1);
        int n = Utilities.getNumValue(string3);
        if (n <= 0 || n >= 10) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidSort.getErrorCode(), string);
        }
        stringArray[n - 1] = string2;
        return ParserReturnCode.PROCESSED;
    }

    protected ParserReturnCode checkSortOrder(String string, String[] stringArray) {
        if (string.startsWith("-sortorder.")) {
            String string2 = this.mQueryMap.get(string).get(0).toLowerCase();
            this.parseSort(string, string2, stringArray);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkScripts(String string, ConfigXMLRequest configXMLRequest) {
        ParserReturnCode parserReturnCode = ParserReturnCode.PROCESSED;
        ArrayList<String> arrayList = this.mQueryMap.get(string);
        if (string.equalsIgnoreCase("-script.prefind")) {
            configXMLRequest.setPreScriptName(arrayList.get(0));
        } else if (string.equalsIgnoreCase("-script.prefind.param")) {
            configXMLRequest.setPreScriptParam(arrayList.get(0));
        } else if (string.equalsIgnoreCase("-script.presort")) {
            configXMLRequest.setPreSortScriptName(arrayList.get(0));
        } else if (string.equalsIgnoreCase("-script.presort.param")) {
            configXMLRequest.setPreSortScriptParam(arrayList.get(0));
        } else if (string.equalsIgnoreCase("-script")) {
            configXMLRequest.setScriptName(arrayList.get(0));
        } else if (string.equalsIgnoreCase("-script.param")) {
            configXMLRequest.setScriptParam(arrayList.get(0));
        } else {
            parserReturnCode = ParserReturnCode.NOT_PROCESSED;
        }
        return parserReturnCode;
    }

    protected ParserReturnCode checkRelatedSetsFilter(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-relatedsets.filter")) {
            String string2 = this.mQueryMap.get(string).get(0);
            if (!XMLCGIParser.isValidRelatedSetsFilter(string2)) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setPortalFilterType(string2);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    private static boolean isValidRelatedSetsFilter(String string) {
        String string2 = string.toLowerCase();
        return string2.equals("none") || string2.equals("layout");
    }

    protected ParserReturnCode checkRelatedSetsMax(String string, ConfigXMLRequest configXMLRequest) {
        if (string.equalsIgnoreCase("-relatedsets.max")) {
            int n = -1;
            String string2 = this.mQueryMap.get(string).get(0);
            if (!string2.equalsIgnoreCase("all") && (n = Utilities.getNumValue(string2)) < 0) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            configXMLRequest.setPortalMax(n);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkDeleteRelated(String string, ConfigXMLRequest configXMLRequest, List<NVPair> list) {
        if (string.equalsIgnoreCase("-delete.related")) {
            String string2 = this.mQueryMap.get(string).get(0);
            NVPair nVPair = XMLCGIParser.parseDeleteRelatedField(string2);
            if (nVPair == null) {
                return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidParameter.getErrorCode(), string2);
            }
            list.add(nVPair);
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkNames(String string) {
        String string2 = string.toLowerCase();
        if (string2.equals("-layoutnames") || string2.equals("-scriptnames")) {
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkFind(String string) {
        String string2 = string.toLowerCase();
        if (string2.equals("-find") || string2.equals("-findall") || string2.equals("-findany")) {
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkFindQuery(String string) {
        String string2 = string.toLowerCase();
        if (string2.equals("-findquery") || string2.equals("-query")) {
            return ParserReturnCode.PROCESSED;
        }
        return ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkDelete(String string) {
        return string.equalsIgnoreCase("-delete") ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkEdit(String string) {
        return string.equalsIgnoreCase("-edit") ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkDup(String string) {
        return string.equalsIgnoreCase("-dup") ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkAdd(String string) {
        return string.equalsIgnoreCase("-new") ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode checkView(String string) {
        return string.equalsIgnoreCase("-view") ? ParserReturnCode.PROCESSED : ParserReturnCode.NOT_PROCESSED;
    }

    protected ParserReturnCode validateSortParams(ArrayList<ComplexParam> arrayList, String[] stringArray, String[] stringArray2) {
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < 10; ++i) {
            if (stringArray[i] != null) {
                ComplexParam complexParam;
                ParserReturnCode parserReturnCode;
                if (bl) {
                    return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidSort.getErrorCode(), stringArray[i]);
                }
                String string = stringArray[i];
                String string2 = "ascend";
                if (stringArray2[i] != null) {
                    string2 = stringArray2[i];
                }
                if ((parserReturnCode = XMLCGIParser.validateField(complexParam = XMLCGIParser.parseField(string, string2, ""))).hasError()) {
                    return parserReturnCode;
                }
                arrayList.add(n++, complexParam);
                continue;
            }
            bl = true;
            if (stringArray2[i] == null) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidSort.getErrorCode(), stringArray2[i]);
        }
        return ParserReturnCode.PROCESSED;
    }

    protected ParserReturnCode validateFindFields(ConfigXMLRequest configXMLRequest, List<FieldsParam> list, Map<String, FieldValues> map, Map<String, String> map2, boolean bl) {
        ParserReturnCode parserReturnCode;
        block4: {
            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
            parserReturnCode = this.validateFieldOps(configXMLRequest, map, map2, hashMap);
            if (parserReturnCode.hasError()) {
                return parserReturnCode;
            }
            if (list == null) break block4;
            if (bl) {
                parserReturnCode = this.getFindFieldsParamList(configXMLRequest, list, hashMap);
            } else {
                String string;
                ComplexParam complexParam;
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext() && !(parserReturnCode = XMLCGIParser.validateField(complexParam = XMLCGIParser.parseField(string = iterator.next(), "", ""))).hasError()) {
                }
            }
        }
        return parserReturnCode;
    }

    protected ParserReturnCode validateFieldOps(ConfigXMLRequest configXMLRequest, Map<String, FieldValues> map, Map<String, String> map2, Map<String, List<String>> map3) {
        FieldValues fieldValues;
        ParserReturnCode parserReturnCode = ParserReturnCode.PROCESSED;
        for (String string : map.keySet()) {
            fieldValues = map.get(string);
            List<String> list = fieldValues.getValues();
            String string2 = map2.get(string);
            ArrayList<String> arrayList = new ArrayList<String>();
            Object object = null;
            for (int i = 0; i < list.size(); ++i) {
                String string3 = list.get(i);
                if (string2 == null) {
                    object = string3;
                } else if (string2.equalsIgnoreCase("cn")) {
                    object = "*" + string3 + "*";
                } else if (string2.equalsIgnoreCase("eq")) {
                    object = "=" + string3;
                } else if (string2.equalsIgnoreCase("bw")) {
                    object = string3 + "*";
                } else if (string2.equalsIgnoreCase("ew")) {
                    object = "*" + string3;
                } else if (string2.equalsIgnoreCase("neq")) {
                    object = "^" + string3;
                } else if (string2.equalsIgnoreCase("gt")) {
                    object = ">" + string3;
                } else if (string2.equalsIgnoreCase("gte")) {
                    object = ">=" + string3;
                } else if (string2.equalsIgnoreCase("lt")) {
                    object = "<" + string3;
                } else if (string2.equalsIgnoreCase("lte")) {
                    object = "<=" + string3;
                } else {
                    return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidCommand.getErrorCode(), string2);
                }
                if (object == null) continue;
                arrayList.add((String)object);
            }
            if (arrayList.size() <= 0) continue;
            map3.put(string, arrayList);
        }
        for (String string : map2.keySet()) {
            fieldValues = map.get(string);
            if (fieldValues != null && fieldValues.getValues().size() != 0) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidCommand.getErrorCode(), string);
        }
        return parserReturnCode;
    }

    protected ParserReturnCode getFindFieldsParamList(ConfigXMLRequest configXMLRequest, List<FieldsParam> list, Map<String, List<String>> map) {
        ArrayList<FieldParam> arrayList = new ArrayList<FieldParam>();
        ArrayList<ComplexParam> arrayList2 = new ArrayList<ComplexParam>();
        ArrayList<FieldParam> arrayList3 = new ArrayList<FieldParam>();
        ArrayList<ComplexParam> arrayList4 = new ArrayList<ComplexParam>();
        ParserReturnCode parserReturnCode = XMLCGIParser.convertFindFieldsMapToList(map, arrayList, arrayList2, arrayList3, arrayList4);
        if (!parserReturnCode.hasError()) {
            if (configXMLRequest.getLop() == ConfigXMLRequest.LopType.Or) {
                this.addMultipleFindRequests(list, arrayList, arrayList2, FindType.Find_Include);
            } else {
                parserReturnCode = this.checkForDuplicateFields(map);
                if (!parserReturnCode.hasError()) {
                    FieldsParam fieldsParam = new FieldsParam(FindType.Find_Include);
                    fieldsParam.setFields(arrayList);
                    fieldsParam.setRelatedFields(arrayList2);
                    list.add(fieldsParam);
                }
            }
            this.addMultipleFindRequests(list, arrayList3, arrayList4, FindType.Find_Omit);
        }
        return parserReturnCode;
    }

    protected ParserReturnCode getEditFieldsParamList(ConfigXMLRequest configXMLRequest, List<FieldsParam> list, Map<String, FieldValues> map) {
        ArrayList<FieldParam> arrayList = new ArrayList<FieldParam>();
        ArrayList<ComplexParam> arrayList2 = new ArrayList<ComplexParam>();
        ParserReturnCode parserReturnCode = XMLCGIParser.convertEditFieldsMapToList(map, arrayList, arrayList2);
        if (!parserReturnCode.hasError()) {
            FieldsParam fieldsParam = new FieldsParam(FindType.Find_None);
            fieldsParam.setFields(arrayList);
            fieldsParam.setRelatedFields(arrayList2);
            list.add(fieldsParam);
        }
        return parserReturnCode;
    }

    protected ParserReturnCode getGlobalFieldsParamList(ConfigXMLRequest configXMLRequest, FieldsParam fieldsParam, Map<String, FieldValues> map) {
        ArrayList<FieldParam> arrayList = new ArrayList<FieldParam>();
        ArrayList<ComplexParam> arrayList2 = new ArrayList<ComplexParam>();
        ParserReturnCode parserReturnCode = XMLCGIParser.convertGlobalFieldsMapToList(map, arrayList, arrayList2);
        if (!parserReturnCode.hasError()) {
            fieldsParam.setFields(arrayList);
            fieldsParam.setRelatedFields(arrayList2);
        }
        return parserReturnCode;
    }

    protected void addMultipleFindRequests(List<FieldsParam> list, List<FieldParam> list2, List<ComplexParam> list3, FindType findType) {
        FieldsParam fieldsParam;
        for (FieldParam fieldParam : list2) {
            fieldsParam = new FieldsParam(findType);
            fieldsParam.addField(fieldParam);
            list.add(fieldsParam);
        }
        for (ComplexParam complexParam : list3) {
            fieldsParam = new FieldsParam(findType);
            fieldsParam.addRelatedField(complexParam);
            list.add(fieldsParam);
        }
    }

    protected ParserReturnCode checkForDuplicateFields(Map<String, List<String>> map) {
        ParserReturnCode parserReturnCode = ParserReturnCode.PROCESSED;
        if (map == null || map.size() == 0) {
            return parserReturnCode;
        }
        for (String string : map.keySet()) {
            List<String> list = map.get(string);
            if (list == null || list.size() <= 1) continue;
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.NoRecordsFound.getErrorCode());
        }
        return parserReturnCode;
    }

    protected ParserReturnCode validateStyle(String string, String string2) {
        String string3;
        boolean bl = Utilities.isEmptyString(string);
        boolean bl2 = Utilities.isEmptyString(string2);
        if (bl2 && !bl) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode(), "-stylehref");
        }
        if (!bl2 && bl) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.ParameterMissing.getErrorCode(), "-styletype");
        }
        if (string2 == null && string == null) {
            return ParserReturnCode.PROCESSED;
        }
        if (string.length() < 4 || string2.length() < 4) {
            return ParserReturnCode.PROCESSED;
        }
        String string4 = string.substring(string.length() - 3).toLowerCase();
        if (!string4.equals(string3 = string2.substring(string2.length() - 3).toLowerCase())) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidCommand.getErrorCode(), "-stylehref/-styletype");
        }
        return ParserReturnCode.PROCESSED;
    }

    protected static NVPair parseDeleteRelatedField(String string) {
        NVPair nVPair = null;
        String[] stringArray = string.split("\\.");
        if (stringArray.length == 2) {
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            if (XMLCGIParser.isValidRecordId(string3)) {
                nVPair = new NVPair(string2, string3);
            }
        }
        return nVPair;
    }

    protected static String getFieldName(String object, boolean bl, boolean bl2) {
        if (!Utilities.isEmptyString((String)object) && (bl || bl2)) {
            String string;
            String string2 = "";
            int n = ((String)object).lastIndexOf(".");
            int n2 = ((String)object).length() - 1;
            if (n > 0 && n < n2 && XMLCGIParser.isValidRecordId(string = ((String)object).substring(n + 1))) {
                string2 = string;
                object = ((String)object).substring(0, n);
            }
            if (bl2) {
                int n3 = ((String)object).lastIndexOf("(");
                int n4 = ((String)object).lastIndexOf(")");
                int n5 = ((String)object).length() - 1;
                if (n3 > 0 && n3 < n4 && n4 == n5) {
                    try {
                        Short.parseShort(((String)object).substring(n3 + 1, n4));
                        object = ((String)object).substring(0, n3);
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
            }
            if (!bl) {
                object = (String)object + "." + string2;
            }
        }
        return object;
    }

    protected static ComplexParam parseField(String string, String string2) {
        String string3 = "";
        if (!Utilities.isEmptyString(string)) {
            String string4;
            int n = string.lastIndexOf(".");
            int n2 = string.length() - 1;
            if (n > 0 && n < n2 && XMLCGIParser.isValidRecordId(string4 = string.substring(n + 1))) {
                string = string.substring(0, n);
                string3 = string4;
            }
        }
        return XMLCGIParser.parseField(string, string2, string3);
    }

    protected static ComplexParam parseField(String string, String string2, String string3) {
        String string4 = null;
        int n = 1;
        int n2 = string.indexOf("::");
        if (n2 > 0 && n2 < string.length() - 2) {
            string4 = string.substring(0, n2);
            string = string.substring(n2 + 2);
        }
        int n3 = string.lastIndexOf("(");
        int n4 = string.lastIndexOf(")");
        int n5 = string.length() - 1;
        if (n3 > 0 && n3 < n4 && n4 == n5) {
            try {
                n = Short.parseShort(string.substring(n3 + 1, n4));
                if (n == 0) {
                    n = 1;
                }
            }
            catch (NumberFormatException numberFormatException) {
                n = -1;
            }
            string = string.substring(0, n3);
        }
        return new ComplexParam(new FieldParam(string, string2, (short)n), string4, string3);
    }

    protected static boolean okToIgnoreFind(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreFindList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreNames(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreNamesList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreEdit(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreEditList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreAdd(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreAddList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreDelete(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreDeleteList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreDup(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreDupList.indexOf(string2) >= 0;
    }

    protected static boolean okToIgnoreView(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreViewList.indexOf(string2) >= 0;
    }

    protected boolean okToIgnoreContainer(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        String string2 = string.toLowerCase();
        return ignoreContainerList.indexOf(string2) >= 0;
    }

    protected static ParserReturnCode validateField(ComplexParam complexParam) {
        if (complexParam == null) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.FieldMissing.getErrorCode());
        }
        if (complexParam.getRepetition() < 0) {
            return new ParserReturnCode(ParserReturnCode.RetCode.ERROR, ErrorCode.InvalidRepetition.getErrorCode(), complexParam.getName());
        }
        return ParserReturnCode.PROCESSED;
    }

    private static boolean isValidRecordId(String string) {
        boolean bl = false;
        if (!Utilities.isEmptyString(string)) {
            try {
                Integer.parseInt(string);
                bl = true;
            }
            catch (NumberFormatException numberFormatException) {
                bl = string.startsWith("RID_");
            }
        }
        return bl;
    }

    private static ParserReturnCode convertEditFieldsMapToList(Map<String, FieldValues> map, List<FieldParam> list, List<ComplexParam> list2) {
        for (String string : map.keySet()) {
            FieldValues fieldValues = map.get(string);
            String string2 = fieldValues.getQueryFieldKey();
            List<String> list3 = fieldValues.getValues();
            if (list3 == null) continue;
            for (int i = 0; i < list3.size(); ++i) {
                String string3 = list3.get(i);
                ComplexParam complexParam = XMLCGIParser.parseField(string2, string3);
                ParserReturnCode parserReturnCode = XMLCGIParser.validateField(complexParam);
                if (parserReturnCode.hasError()) {
                    return parserReturnCode;
                }
                FieldParam fieldParam = complexParam.getField();
                String string4 = complexParam.getTableName();
                if (Utilities.isEmptyString(string4)) {
                    list.add(fieldParam);
                    continue;
                }
                list2.add(complexParam);
            }
        }
        return ParserReturnCode.PROCESSED;
    }

    private static ParserReturnCode convertGlobalFieldsMapToList(Map<String, FieldValues> map, List<FieldParam> list, List<ComplexParam> list2) {
        for (String string : map.keySet()) {
            FieldValues fieldValues = map.get(string);
            List<String> list3 = fieldValues.getValues();
            if (list3 == null) continue;
            for (int i = 0; i < list3.size(); ++i) {
                String string2 = list3.get(i);
                ComplexParam complexParam = XMLCGIParser.parseField(string, string2, "");
                ParserReturnCode parserReturnCode = XMLCGIParser.validateField(complexParam);
                if (parserReturnCode.hasError()) {
                    return parserReturnCode;
                }
                FieldParam fieldParam = complexParam.getField();
                String string3 = complexParam.getTableName();
                if (Utilities.isEmptyString(string3)) {
                    list.add(fieldParam);
                    continue;
                }
                list2.add(complexParam);
            }
        }
        return ParserReturnCode.PROCESSED;
    }

    private static ParserReturnCode convertFindFieldsMapToList(Map<String, List<String>> map, List<FieldParam> list, List<ComplexParam> list2, List<FieldParam> list3, List<ComplexParam> list4) {
        for (String string : map.keySet()) {
            List<String> list5 = map.get(string);
            if (list5 == null) continue;
            for (int i = 0; i < list5.size(); ++i) {
                boolean bl;
                String string2 = list5.get(i);
                ComplexParam complexParam = XMLCGIParser.parseField(string, string2, "");
                ParserReturnCode parserReturnCode = XMLCGIParser.validateField(complexParam);
                if (parserReturnCode.hasError()) {
                    return parserReturnCode;
                }
                FieldParam fieldParam = complexParam.getField();
                String string3 = complexParam.getTableName();
                boolean bl2 = bl = (list3 != null || list4 != null) && XMLCGIParser.isOmitFieldCriteria(string2);
                if (bl) {
                    fieldParam.setValue(XMLCGIParser.invertFindFieldValue(fieldParam.getValue()));
                }
                if (Utilities.isEmptyString(string3)) {
                    if (!bl) {
                        list.add(fieldParam);
                        continue;
                    }
                    list3.add(fieldParam);
                    continue;
                }
                if (!bl) {
                    list2.add(complexParam);
                    continue;
                }
                list4.add(complexParam);
            }
        }
        return ParserReturnCode.PROCESSED;
    }

    private static boolean isOmitFieldCriteria(String string) {
        return string.startsWith("^");
    }

    private static String invertFindFieldValue(String string) {
        Object object = null;
        object = XMLCGIParser.isOmitFieldCriteria(string) ? "==" + string.substring("^".length()) : string;
        return object;
    }

    public static XMLResponse.ResponseType getResponseType(String string) {
        XMLResponse.ResponseType responseType = XMLResponse.ResponseType.FMRESULTSET;
        if (string == null || string.trim().length() == 0) {
            return responseType;
        }
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        if (string.contentEquals(FMPXMLRESULT)) {
            responseType = XMLResponse.ResponseType.FMPXMLRESULT;
        } else if (string.contentEquals(FMPXMLLAYOUT)) {
            responseType = XMLResponse.ResponseType.FMPXMLLAYOUT;
        } else if (string.startsWith(CONTAINER)) {
            responseType = XMLResponse.ResponseType.CONTAINER;
        }
        return responseType;
    }
}

