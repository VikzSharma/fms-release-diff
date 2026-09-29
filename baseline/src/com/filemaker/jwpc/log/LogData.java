/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

public class LogData {
    private Integer fmErrorCode;
    private Integer httpErrorCode;
    private Long returnBytes;
    private String strMessage;

    public void setFMErrorCode(Integer n) {
        this.fmErrorCode = n;
    }

    public Integer getFMErrorCode() {
        return this.fmErrorCode;
    }

    public void setHttpErrorCode(Integer n) {
        this.httpErrorCode = n;
    }

    public Integer getHttpErrorCode() {
        return this.httpErrorCode;
    }

    public void setReturnBytes(Long l) {
        this.returnBytes = l;
    }

    public Long getReturnBytes() {
        return this.returnBytes;
    }

    public void setMessage(String string) {
        this.strMessage = string;
    }

    public String getMessage() {
        return this.strMessage;
    }
}

