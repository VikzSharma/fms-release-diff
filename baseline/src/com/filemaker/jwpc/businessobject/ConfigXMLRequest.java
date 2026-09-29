/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.AuthInfo
 *  com.filemaker.jwpc.fmwp.api.thrift.service.BasicParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldsParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.NVPair
 *  com.filemaker.jwpc.fmwp.api.thrift.service.PortalFilterType
 *  com.filemaker.jwpc.fmwp.api.thrift.service.RequestParam
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ComplexParam
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.FieldsParam
 *  com.filemaker.jwpc.fmwp.datatype.RequestOptionSet$RequestOptionBit
 *  com.filemaker.jwpc.fmwp.datatype.WPCError
 *  com.filemaker.jwpc.fmwp.util.DataConverter
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.fmwp.api.thrift.service.AuthInfo;
import com.filemaker.jwpc.fmwp.api.thrift.service.BasicParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldsParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
import com.filemaker.jwpc.fmwp.api.thrift.service.PortalFilterType;
import com.filemaker.jwpc.fmwp.api.thrift.service.RequestParam;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.FieldsParam;
import com.filemaker.jwpc.fmwp.datatype.RequestOptionSet;
import com.filemaker.jwpc.fmwp.datatype.WPCError;
import com.filemaker.jwpc.fmwp.util.DataConverter;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.xml.parser.ParserReturnCode;
import com.filemaker.jwpc.xml.response.XMLResponse;
import java.util.ArrayList;
import java.util.List;

public class ConfigXMLRequest {
    private static JWPCLogger logger = JWPCLogger.getLogger(ConfigXMLRequest.class);
    private RequestParam requestParam = new RequestParam();
    private CmdCode cmdCode = CmdCode.INVALID;
    private String databaseName;
    private String layoutName;
    private String responseLayoutName;
    private String recordId;
    private String keyName;
    private String portalFilter;
    private String containerFileName;
    private String userName;
    private String password;
    private String email;
    private String passcode;
    private String privExt;
    private String clientIP;
    private String clientHostname;
    private String userAgent;
    private String mStyleHref;
    private String mStyleType;
    private boolean oauth;
    private boolean appleid;
    private List<FieldsParam> fields;
    private FieldsParam globalFields;
    private WPCError mWPCError;
    private short mRepetition;
    private LopType lopType;
    private XMLResponse.ResponseType responseType;

    public ConfigXMLRequest() {
        this.requestParam.setCmdCode(CmdCode.INVALID.value());
        this.requestParam.setParam(new BasicParam(0, "", new AuthInfo("", "", "", "", "", "", false, "", "", false), "", "", "", "", -1L, 0L, -1L));
        this.mRepetition = 1;
        this.requestParam.setPreScript(new NVPair());
        this.requestParam.setPreSortScript(new NVPair());
        this.requestParam.setPostScript(new NVPair());
        this.requestParam.setFields(new ArrayList());
        this.requestParam.setGlobalFields(new IDLFieldsParam());
        this.requestParam.setSortParams(new ArrayList());
        this.requestParam.setResponseLayoutName("");
        this.requestParam.setDeleteRelated(new ArrayList());
        this.mWPCError = new WPCError(ErrorCode.None);
        this.fields = new ArrayList<FieldsParam>();
        this.globalFields = new FieldsParam();
        this.portalFilter = "none";
        this.requestParam.setPortalFilter(PortalFilterType.DefaultFilter);
        this.requestParam.setPortalMax(-1L);
        this.lopType = LopType.None;
        this.mStyleType = "";
        this.mStyleHref = "";
        this.userAgent = "";
        this.clientHostname = "";
        this.clientIP = "";
        this.privExt = "";
        this.password = "";
        this.userName = "";
        this.containerFileName = "";
        this.keyName = "";
        this.recordId = "";
        this.responseLayoutName = "";
        this.layoutName = "";
        this.requestParam.setOptions(0);
        this.responseType = XMLResponse.ResponseType.FMRESULTSET;
    }

    public ConfigXMLRequest(CmdCode cmdCode) {
        this();
        this.setCmdCode(cmdCode);
    }

    public RequestParam getRequestParam() {
        return this.requestParam;
    }

    public String getUserName() {
        this.userName = this.requestParam.getParam().getAuthInfo().getUserName();
        return this.userName;
    }

    public synchronized void setUserName(String string) {
        this.userName = string;
        this.requestParam.getParam().getAuthInfo().setUserName(this.userName);
    }

    public String getPassword() {
        this.password = this.requestParam.getParam().getAuthInfo().getPassword();
        return this.password;
    }

    public synchronized void setPassword(String string) {
        this.password = string;
        this.requestParam.getParam().getAuthInfo().setPassword(this.password);
    }

    public String getEmail() {
        this.email = this.requestParam.getParam().getAuthInfo().getEmail();
        return this.email;
    }

    public synchronized void setEmail(String string) {
        this.email = string;
        this.requestParam.getParam().getAuthInfo().setEmail(this.email);
    }

    public String getPasscode() {
        this.passcode = this.requestParam.getParam().getAuthInfo().getPasscode();
        return this.passcode;
    }

    public synchronized void setPasscode(String string) {
        this.passcode = string;
        this.requestParam.getParam().getAuthInfo().setPasscode(this.passcode);
    }

    public boolean getIsAppleID() {
        this.appleid = this.requestParam.getParam().getAuthInfo().isAppleid();
        return this.appleid;
    }

    public synchronized void setIsAppleID(boolean bl) {
        this.appleid = bl;
        this.requestParam.getParam().getAuthInfo().setAppleid(this.appleid);
    }

    public boolean getIsOAuth() {
        this.oauth = this.requestParam.getParam().getAuthInfo().isOauth();
        return this.oauth;
    }

    public synchronized void setIsOAuth(boolean bl) {
        this.oauth = bl;
        this.requestParam.getParam().getAuthInfo().setOauth(this.oauth);
    }

    public String getPrivilegeExtension() {
        this.privExt = this.requestParam.getParam().getAuthInfo().getPrivExt();
        return this.privExt;
    }

    public synchronized void setPrivilegeExtension(String string) {
        this.privExt = string;
        this.requestParam.getParam().getAuthInfo().setPrivExt(this.privExt);
    }

    public String getClientIP() {
        this.clientIP = this.requestParam.getParam().getAuthInfo().getClientIP();
        return this.clientIP;
    }

    public synchronized void setClientIP(String string) {
        this.clientIP = string;
        this.requestParam.getParam().getAuthInfo().setClientIP(this.clientIP);
    }

    public String getClientHostname() {
        this.clientHostname = this.requestParam.getParam().getAuthInfo().getClientHostname();
        return this.clientHostname;
    }

    public synchronized void setClientHostname(String string) {
        this.clientHostname = string;
        this.requestParam.getParam().getAuthInfo().setClientHostname(this.clientHostname);
    }

    public String getUserAgent() {
        this.userAgent = this.requestParam.getParam().getAuthInfo().getUserAgent();
        return this.userAgent;
    }

    public synchronized void setUserAgent(String string) {
        this.userAgent = string;
        this.requestParam.getParam().getAuthInfo().setUserAgent(this.userAgent);
    }

    public String getDatabaseName() {
        this.databaseName = this.requestParam.getParam().getDatabaseName();
        return this.databaseName;
    }

    public synchronized void setDatabaseName(String string) {
        this.databaseName = string;
        this.requestParam.getParam().setDatabaseName(this.databaseName);
    }

    public String getLayoutName() {
        this.layoutName = this.requestParam.getParam().getLayoutName();
        return this.layoutName;
    }

    public synchronized void setLayoutName(String string) {
        this.layoutName = string;
        this.requestParam.getParam().setLayoutName(this.layoutName);
    }

    public String getResponseLayoutName() {
        this.responseLayoutName = this.requestParam.getResponseLayoutName();
        return this.responseLayoutName;
    }

    public synchronized void setResponseLayoutName(String string) {
        this.responseLayoutName = string;
        this.requestParam.setResponseLayoutName(string);
    }

    public long getMaxItems() {
        return this.requestParam.getParam().getMaxReturn();
    }

    public synchronized void setMaxItems(long l) {
        this.requestParam.getParam().setMaxReturn(l);
    }

    public long getItemsToSkip() {
        return this.requestParam.getParam().getSkip();
    }

    public synchronized void setItemsToSkip(long l) {
        this.requestParam.getParam().setSkip(l);
    }

    public String getRecordId() {
        this.recordId = this.requestParam.getParam().getRecordId();
        return this.recordId;
    }

    public synchronized void setRecordId(String string) {
        this.recordId = string;
        this.requestParam.getParam().setRecordId(string);
    }

    public List<FieldsParam> getFields() {
        return this.fields;
    }

    public ComplexParam getFirstRelatedField() {
        List list;
        FieldsParam fieldsParam;
        ComplexParam complexParam = null;
        List<FieldsParam> list2 = this.fields;
        if (list2 != null && !list2.isEmpty() && (fieldsParam = list2.get(0)) != null && (list = fieldsParam.getRelatedFields()) != null && !list.isEmpty()) {
            complexParam = (ComplexParam)list.get(0);
        }
        return complexParam;
    }

    public synchronized void setGlobalFields(FieldsParam fieldsParam) {
        this.globalFields = fieldsParam;
        this.requestParam.setGlobalFields(DataConverter.convertToIDLFieldsParam((FieldsParam)fieldsParam));
    }

    public synchronized void setFields(List<FieldsParam> list) {
        this.fields = list;
        this.requestParam.setFields(DataConverter.fromFieldsParamListToIDLFieldsParamList(this.fields));
    }

    public synchronized void setFields(FieldsParam fieldsParam) {
        ArrayList<FieldsParam> arrayList = new ArrayList<FieldsParam>();
        arrayList.add(fieldsParam);
        this.setFields(arrayList);
    }

    public synchronized void setField(ComplexParam complexParam) {
        FieldsParam fieldsParam = new FieldsParam();
        fieldsParam.addRelatedField(complexParam);
        this.setFields(fieldsParam);
    }

    public List<NVPair> getDeleteRelatedFields() {
        return this.requestParam.getDeleteRelated();
    }

    public synchronized void setDeleteRelatedFields(List<NVPair> list) {
        this.requestParam.setDeleteRelated(list);
    }

    public List<IDLComplexParam> getSortFields() {
        return this.requestParam.getSortParams();
    }

    public synchronized void setSortFields(List<ComplexParam> list) {
        List list2 = DataConverter.fromComplexParamListToIDLComplexParamList(list);
        this.requestParam.setSortParams(list2);
    }

    public synchronized void setSessionID(int n) {
        BasicParam basicParam = this.requestParam.getParam();
        basicParam.setSessionID(n);
    }

    public int getSessionID() {
        return this.requestParam.getParam().getSessionID();
    }

    public synchronized void setSessionHash(String string) {
        BasicParam basicParam = this.requestParam.getParam();
        basicParam.setSessionHash(string);
    }

    public String getSessionHash() {
        return this.requestParam.getParam().getSessionHash();
    }

    public int getCmdCode() {
        return this.cmdCode.value();
    }

    public synchronized void setCmdCode(CmdCode cmdCode) {
        this.cmdCode = cmdCode;
        this.requestParam.setCmdCode(cmdCode.value());
    }

    public synchronized void setOptions(int n) {
        this.requestParam.setOptions(n);
    }

    public int getOptions() {
        return this.requestParam.getOptions();
    }

    public long getModId() {
        return this.requestParam.getParam().getModId();
    }

    public synchronized void setModId(long l) {
        BasicParam basicParam = this.requestParam.getParam();
        basicParam.setModId(l);
    }

    public synchronized void setWPCError(ErrorCode errorCode, String string) {
        this.mWPCError = new WPCError(errorCode, string);
    }

    public synchronized void setWPCError(int n, String string) {
        this.mWPCError = new WPCError(n, string);
    }

    public synchronized void setWPCError(ErrorCode errorCode) {
        this.mWPCError = new WPCError(errorCode);
    }

    public synchronized void setWPCError(ParserReturnCode parserReturnCode) {
        this.mWPCError = new WPCError(parserReturnCode.getErrorCode(), parserReturnCode.getErrorText());
    }

    public boolean hasError() {
        return this.mWPCError.hasError();
    }

    public WPCError getError() {
        return this.mWPCError;
    }

    public ErrorCode getErrorCode() {
        return this.mWPCError.getErrorCode();
    }

    public synchronized void setStyleHref(String string) {
        this.mStyleHref = string;
    }

    public String getStyleHref() {
        return this.mStyleHref;
    }

    public synchronized void setStyleType(String string) {
        this.mStyleType = string;
    }

    public String getStyleType() {
        return this.mStyleType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addCompoundQuery(FieldsParam fieldsParam) {
        if (fieldsParam != null) {
            if (this.fields == null) {
                this.fields = new ArrayList<FieldsParam>();
            }
            List<FieldsParam> list = this.fields;
            synchronized (list) {
                this.fields.add(fieldsParam);
            }
        }
    }

    public String getContainerFileName() {
        return this.containerFileName;
    }

    public synchronized void setContainerFileName(String string) {
        this.containerFileName = string;
    }

    public short getRepetition() {
        return this.mRepetition;
    }

    public synchronized void setRepetition(short s) {
        this.mRepetition = s;
    }

    public String getKeyName() {
        this.keyName = this.requestParam.getParam().getKey();
        return this.keyName;
    }

    public synchronized void setKeyName(String string) {
        this.keyName = string;
        BasicParam basicParam = this.requestParam.getParam();
        basicParam.setKey(string);
    }

    public String getPortalFilterType() {
        return this.portalFilter;
    }

    public synchronized void setPortalFilterType(String string) {
        this.portalFilter = string;
        this.requestParam.setPortalFilter(string.equalsIgnoreCase("layout") ? PortalFilterType.LayoutFilter : PortalFilterType.DefaultFilter);
    }

    public long getPortalMax() {
        return this.requestParam.getPortalMax();
    }

    public synchronized void setPortalMax(long l) {
        this.requestParam.setPortalMax(l);
    }

    public LopType getLop() {
        return this.lopType;
    }

    public synchronized void setLop(LopType lopType) {
        this.lopType = lopType;
    }

    public XMLResponse.ResponseType getResponseType() {
        return this.responseType;
    }

    public synchronized void setResponseType(XMLResponse.ResponseType responseType) {
        this.responseType = responseType;
    }

    private synchronized void setScript(String string, NVPair nVPair, int n) {
        nVPair.setKey(string);
        this.requestParam.setOptions(this.requestParam.getOptions() | n);
    }

    private synchronized void setParam(String string, NVPair nVPair, int n) {
        nVPair.setValue(string);
        this.requestParam.setOptions(this.requestParam.getOptions() | n);
    }

    public String getPreScriptName() {
        return this.requestParam.getPreScript().getKey();
    }

    public void setPreScriptName(String string) {
        this.setScript(string, this.requestParam.getPreScript(), RequestOptionSet.RequestOptionBit.HasPreScript.value());
        logger.debug("setPreScriptName() pre script name = " + this.getPreScriptName());
    }

    public String getPreScriptParam() {
        return this.requestParam.getPreScript().getValue();
    }

    public void setPreScriptParam(String string) {
        this.setParam(string, this.requestParam.getPreScript(), RequestOptionSet.RequestOptionBit.HasPreScriptParam.value());
        logger.debug("setPreScriptParam() pre script param = " + this.getPreScriptParam());
    }

    public String getPreSortScriptName() {
        return this.requestParam.getPreSortScript().getKey();
    }

    public void setPreSortScriptName(String string) {
        this.setScript(string, this.requestParam.getPreSortScript(), RequestOptionSet.RequestOptionBit.HasPreSortScript.value());
        logger.debug("setPreSortScriptName() pre sort script name = " + this.getPreSortScriptName());
    }

    public String getPreSortScriptParam() {
        return this.requestParam.getPreSortScript().getValue();
    }

    public void setPreSortScriptParam(String string) {
        this.setParam(string, this.requestParam.getPreSortScript(), RequestOptionSet.RequestOptionBit.HasPreSortScriptParam.value());
        logger.debug("setPreSortScriptParam() pre sort script param = " + this.getPreSortScriptParam());
    }

    public String getScriptName() {
        return this.requestParam.getPostScript().getKey();
    }

    public void setScriptName(String string) {
        this.setScript(string, this.requestParam.getPostScript(), RequestOptionSet.RequestOptionBit.HasScript.value());
    }

    public String getScriptParam() {
        return this.requestParam.getPostScript().getValue();
    }

    public void setScriptParam(String string) {
        this.setParam(string, this.requestParam.getPostScript(), RequestOptionSet.RequestOptionBit.HasScriptParam.value());
        logger.debug("setScriptParam() script param = " + this.getScriptParam());
    }

    public static enum LopType {
        None,
        And,
        Or;

    }
}

