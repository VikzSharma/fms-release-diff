/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.api.thrift.service.ErrorData;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import java.util.HashMap;
import java.util.Map;

public class WPCError {
    private static final Map<ErrorCode, ErrorCode> WPC_ERRORS = new HashMap<ErrorCode, ErrorCode>();
    private ErrorCode mErrorCode;
    private ErrorCode mWPCErrorCode;
    private String mErrorText;
    private boolean mIsScriptError;
    private String mFileName;
    private String mScriptName;
    private String mScriptStepName;
    private String mTimestamp;

    public WPCError(ErrorCode errorCode, String string, boolean bl, String string2, String string3, String string4, String string5) {
        this.mErrorCode = errorCode;
        this.mErrorText = string;
        this.setWPCErrorCode();
        this.mIsScriptError = bl;
        this.mFileName = string2;
        this.mScriptName = string3;
        this.mScriptStepName = string4;
        this.mTimestamp = string5;
    }

    public WPCError(ErrorCode errorCode, String string) {
        this(errorCode, string, false, null, null, null, null);
    }

    public WPCError(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public WPCError(int n, String string) {
        this.mErrorCode = ErrorCode.fromValue(n);
        this.mErrorText = string;
        this.setWPCErrorCode();
    }

    public WPCError(int n) {
        this(n, null);
    }

    public WPCError(ErrorData errorData) {
        this.mErrorCode = ErrorCode.fromValue(errorData.getError());
        this.mErrorText = null;
        this.setWPCErrorCode();
        this.mIsScriptError = errorData.isScriptError();
        this.mFileName = errorData.getFileName();
        this.mScriptName = errorData.getScriptName();
        this.mScriptStepName = errorData.getScriptStepName();
        this.mTimestamp = errorData.getTimestamp();
    }

    public ErrorCode getErrorCode() {
        return this.mErrorCode;
    }

    public ErrorCode getWPCErrorCode() {
        if (this.mWPCErrorCode == null) {
            this.setWPCErrorCode();
        }
        return this.mWPCErrorCode;
    }

    public int getErrorCodeValue() {
        return this.mErrorCode.getErrorCode();
    }

    public int getWPCErrorCodeValue() {
        if (this.mWPCErrorCode == null) {
            this.setWPCErrorCode();
        }
        return this.mWPCErrorCode.getErrorCode();
    }

    public String getErrorText() {
        return this.mErrorText != null ? this.mErrorText : "";
    }

    public boolean hasError() {
        return this.mErrorCode != ErrorCode.None;
    }

    public boolean isScriptError() {
        return this.hasError() && this.mIsScriptError;
    }

    public String getFileName() {
        return this.mFileName != null ? this.mFileName : "";
    }

    public String getScriptName() {
        return this.mScriptName != null ? this.mScriptName : "";
    }

    public String getScriptStepName() {
        return this.mScriptStepName != null ? this.mScriptStepName : "";
    }

    public String getTimestamp() {
        return this.mTimestamp != null ? this.mTimestamp : "";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.getErrorCode());
        return stringBuilder.toString();
    }

    private void setWPCErrorCode() {
        this.mWPCErrorCode = this.mErrorCode != null && WPC_ERRORS.containsKey((Object)this.mErrorCode) ? WPC_ERRORS.get((Object)this.mErrorCode) : this.mErrorCode;
    }

    static {
        WPC_ERRORS.put(ErrorCode.NonIndexableField, ErrorCode.IndexMissing);
    }
}

