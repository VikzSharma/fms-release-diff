/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.HttpException;
import com.fmi.security.AuthorizationInfo;

public class HttpAuthorizationException
extends HttpException {
    private AuthorizationInfo m_authorizationInfo;

    public HttpAuthorizationException(String statusMessage, int statusCode, AuthorizationInfo info) {
        super(statusMessage, statusCode);
        this.m_authorizationInfo = info;
    }

    public AuthorizationInfo getAuthorizationInfo() {
        return this.m_authorizationInfo;
    }
}

