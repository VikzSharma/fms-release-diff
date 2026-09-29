/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

public class LoggerPreference {
    private String strUserLogEnabled;
    private String strUserLogLevel;
    private String strUserLogSize;
    private String strDebugLogEnabled;

    public String getUserLogEnabled() {
        return this.strUserLogEnabled;
    }

    public void setUserLogEnabled(String string) {
        this.strUserLogEnabled = string;
    }

    public String getUserLogLevel() {
        return this.strUserLogLevel;
    }

    public void setUserLogLevel(String string) {
        this.strUserLogLevel = string;
    }

    public String getUserLogSize() {
        return this.strUserLogSize;
    }

    public void setUserLogSize(String string) {
        this.strUserLogSize = string;
    }

    public String getDebugLogEnabled() {
        return this.strDebugLogEnabled;
    }

    public void setDebugLogEnabled(String string) {
        this.strDebugLogEnabled = string;
    }
}

