/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.context;

public class JWPCContext {
    private String wpcHostName;
    private String clientIP;
    private Integer clientPort;
    private String accountName;
    private String moduleType;

    public String getWPCHostName() {
        return this.wpcHostName;
    }

    void setWPCHostName(String string) {
        this.wpcHostName = string;
    }

    public String getClientIP() {
        return this.clientIP;
    }

    void setClientIP(String string) {
        this.clientIP = string;
    }

    public Integer getClientPort() {
        return this.clientPort;
    }

    void setClientPort(Integer n) {
        this.clientPort = n;
    }

    public String getAccountName() {
        return this.accountName;
    }

    void setAccountName(String string) {
        this.accountName = string;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    void setModuleType(String string) {
        this.moduleType = string;
    }
}

