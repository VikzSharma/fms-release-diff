/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletRequestWrapper
 *  jakarta.servlet.http.HttpServletResponse
 *  jakarta.servlet.http.HttpSession
 */
package com.filemaker.jwpc.http;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HttpRequestWrapper
extends HttpServletRequestWrapper {
    public HttpRequestWrapper(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(httpServletRequest);
    }

    public HttpSession getSession(boolean bl) {
        boolean bl2 = false;
        if (bl && super.getSession(false) == null) {
            bl2 = true;
        }
        return super.getSession(bl);
    }
}

