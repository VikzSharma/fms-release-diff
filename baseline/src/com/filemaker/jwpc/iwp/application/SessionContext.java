/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.thrift.common.SessionInfo;
import java.util.Locale;

public class SessionContext {
    private SessionInfo sessionInfo;
    private Locale locale;
    private String fmid;
    private String refreshToken;
    private boolean bCanShareFile;
    private boolean bCanEditLayout;

    public SessionContext() {
    }

    public SessionContext(SessionInfo sessionInfo, Locale locale) {
        this.sessionInfo = sessionInfo;
        this.locale = locale;
        this.fmid = "";
        this.refreshToken = "";
        this.bCanShareFile = false;
        this.bCanEditLayout = false;
    }

    public SessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFMID() {
        return this.fmid;
    }

    public void setFMID(String string) {
        this.fmid = string != null ? string : "";
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String string) {
        this.refreshToken = string != null ? string : "";
    }

    public boolean canShareFile() {
        return this.bCanShareFile;
    }

    public void setCanShareFile(boolean bl) {
        this.bCanShareFile = bl;
    }

    public boolean canEditLayout() {
        return this.bCanEditLayout;
    }

    public void setCanEditLayout(boolean bl) {
        this.bCanEditLayout = bl;
    }
}

