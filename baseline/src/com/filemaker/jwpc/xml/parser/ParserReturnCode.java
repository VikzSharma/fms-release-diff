/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.xml.parser;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;

public class ParserReturnCode {
    RetCode code;
    int error;
    String text;
    public static ParserReturnCode PROCESSED = new ParserReturnCode(RetCode.PROCESSED);
    public static ParserReturnCode NOT_PROCESSED = new ParserReturnCode(RetCode.NOT_PROCESSED);

    public ParserReturnCode(RetCode retCode, int n, String string) {
        this.code = retCode;
        this.error = n;
        this.text = string;
    }

    public ParserReturnCode(RetCode retCode, int n) {
        this(retCode, n, null);
    }

    public ParserReturnCode(RetCode retCode) {
        this.code = retCode;
        this.error = ErrorCode.None.getErrorCode();
        this.text = null;
    }

    public boolean hasError() {
        return this.code == RetCode.ERROR;
    }

    public int getErrorCode() {
        return this.error;
    }

    public String getErrorText() {
        return this.text;
    }

    public boolean processed() {
        return this.code == RetCode.PROCESSED;
    }

    public static enum RetCode {
        PROCESSED,
        NOT_PROCESSED,
        ERROR;

    }
}

