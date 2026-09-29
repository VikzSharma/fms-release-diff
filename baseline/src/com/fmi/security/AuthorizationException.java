/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.security;

import com.fmi.security.AuthorizationInfo;

public class AuthorizationException
extends Exception {
    private AuthorizationInfo m_authorizationInfo;

    public AuthorizationException(String message, AuthorizationInfo info) {
        super(message);
        this.m_authorizationInfo = info;
    }

    public AuthorizationInfo getAuthorizationInfo() {
        return this.m_authorizationInfo;
    }
}

