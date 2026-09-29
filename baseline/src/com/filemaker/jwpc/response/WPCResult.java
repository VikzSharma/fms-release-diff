/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.ErrorData
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLNameSet
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet
 *  com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.WPCError
 *  com.filemaker.jwpc.fmwp.util.DataConverter
 */
package com.filemaker.jwpc.response;

import com.filemaker.jwpc.XMLCGIBase;
import com.filemaker.jwpc.businessobject.ProductInfo;
import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.ErrorData;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLNameSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.WPCError;
import com.filemaker.jwpc.fmwp.util.DataConverter;
import com.filemaker.jwpc.util.Utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class WPCResult {
    ProductInfo mProductInfo;
    long mCount = 0L;
    long mFetchSize = 0L;
    private String hostNamePort = "";
    private String protocol = "http";
    private List<String> dbNames;
    private List<IDLItemInfo> items;
    private ResultType resultType = ResultType.RECORDS;
    private WPCError error;
    protected IDLResultSet resultSet;
    ReplyStatus status;

    public WPCResult(IDLResultSet iDLResultSet) {
        this.initProductInfo();
        this.mCount = iDLResultSet.getTotalFound();
        this.mFetchSize = iDLResultSet.getRecordsSize();
        this.resultSet = iDLResultSet;
        this.status = iDLResultSet.getStatus();
        this.resultType = ResultType.RECORDS;
        this.setErrorCode();
    }

    public WPCResult(List<String> list, ResultType resultType) {
        this.initProductInfo();
        this.mCount = 0L;
        this.mFetchSize = 0L;
        this.resultType = resultType;
        this.dbNames = list;
        this.resultSet = null;
        this.setErrorCode();
    }

    public WPCResult(IDLNameSet iDLNameSet, ResultType resultType) {
        this.initProductInfo();
        this.items = iDLNameSet.getNames();
        this.status = iDLNameSet.getStatus();
        this.resultType = resultType;
        this.setErrorCode();
    }

    public WPCResult(ReplyStatus replyStatus) {
        this.initProductInfo();
        this.resultSet = new IDLResultSet(replyStatus, 0L, null, null);
        this.status = this.resultSet.getStatus();
        this.setErrorCode();
    }

    public WPCResult(ErrorCode errorCode) {
        this.initProductInfo();
        ErrorData errorData = DataConverter.initErrorData();
        errorData.setError(errorCode.getErrorCode());
        this.status = new ReplyStatus(errorData, null, 0);
        this.resultSet = new IDLResultSet(this.status, 0L, null, null);
        this.setErrorCode();
    }

    public WPCResult(ReplyStatus replyStatus, ErrorCode errorCode) {
        this.initProductInfo();
        this.resultSet = new IDLResultSet(replyStatus, 0L, null, null);
        this.status = this.resultSet.getStatus();
        ErrorData errorData = DataConverter.initErrorData();
        errorData.setError(errorCode.getErrorCode());
        this.setErrorCode();
    }

    public WPCResult() {
        this.initProductInfo();
        this.setErrorCode();
    }

    private void initProductInfo() {
        Object object;
        Object object2;
        String string = XMLCGIBase.getBuildDate();
        if (string == null) {
            object2 = new SimpleDateFormat("MM/dd/yyyy");
            object = new Date();
            string = ((DateFormat)object2).format((Date)object);
        }
        if ((object2 = XMLCGIBase.getProductName()) == null) {
            object2 = "FileMaker Web Publishing Engine";
        }
        if ((object = XMLCGIBase.getProductVersion()) == null) {
            object = "13.0.0";
        }
        this.mProductInfo = new ProductInfo(string, (String)object2, (String)object);
    }

    private void setErrorCode() {
        this.error = this.status != null ? new WPCError(this.status.getError().getError()) : new WPCError(ErrorCode.None);
    }

    public String getHostNamePort() {
        return this.hostNamePort;
    }

    public void setHostNamePort(String string) {
        this.hostNamePort = string;
    }

    public List<String> getDBNames() {
        return this.dbNames;
    }

    public List<IDLItemInfo> getItems() {
        return this.items;
    }

    public ResultType getResultType() {
        return this.resultType;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.mProductInfo = productInfo;
    }

    public ProductInfo getProductInfo() {
        return this.mProductInfo;
    }

    public long getCount() {
        return this.mCount;
    }

    public long getFetchSize() {
        return this.mFetchSize;
    }

    public int getSessionID() {
        if (this.status != null) {
            return this.status.getSession();
        }
        return 0;
    }

    public int getErrorCode() {
        if (this.error == null) {
            this.setErrorCode();
        }
        return this.error.getErrorCodeValue();
    }

    public int getWPCErrorCode() {
        if (this.error == null) {
            this.setErrorCode();
        }
        return this.error.getWPCErrorCodeValue();
    }

    public boolean hasScriptErrors() {
        if (this.status != null && this.status.getScriptErrors() != null) {
            return this.status.getScriptErrorsSize() > 0;
        }
        return false;
    }

    public List<WPCError> getScriptErrors() {
        return this.hasScriptErrors() ? DataConverter.fromErrorDataListToWPCErrorList((List)this.status.getScriptErrors()) : new ArrayList();
    }

    public void setProtocol(String string) {
        this.protocol = string;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String toString() {
        String string = Utilities.getLineBreak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mProductInfo=").append(this.mProductInfo).append(string);
        stringBuilder.append("mCount=").append(this.mCount).append(string);
        stringBuilder.append("mFetchSize=").append(this.mFetchSize).append(string);
        stringBuilder.append("hostNamePort=").append(this.hostNamePort).append(string);
        stringBuilder.append("protocol=").append(this.protocol).append(string);
        stringBuilder.append("dbNames=");
        if (this.dbNames != null && this.dbNames.size() > 0) {
            stringBuilder.append(DataObject.toString(this.dbNames.toArray()));
        }
        stringBuilder.append(string);
        stringBuilder.append("resultType=").append((Object)this.resultType).append(string);
        stringBuilder.append("status=").append(DataObject.toString(this.status)).append(string);
        return stringBuilder.toString();
    }

    public static enum ResultType {
        DATABASE_NAME,
        LAYOUT_NAME,
        SCRIPT_NAME,
        RECORDS,
        IWPEXCEEDLIMITCOUNT;

    }
}

