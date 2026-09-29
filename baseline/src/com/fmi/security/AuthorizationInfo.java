/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.security;

public class AuthorizationInfo {
    private String m_authenticationScheme;
    private String m_domain;
    private String m_realm;

    public AuthorizationInfo(String authenticationScheme, String domain, String realm) {
        this.m_authenticationScheme = authenticationScheme;
        this.m_domain = domain;
        this.m_realm = realm;
    }

    public String getAuthenticationScheme() {
        return this.m_authenticationScheme;
    }

    public String getDomain() {
        return this.m_domain;
    }

    public String getRealm() {
        return this.m_realm;
    }
}

