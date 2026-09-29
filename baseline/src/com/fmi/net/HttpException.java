/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

public class HttpException
extends Exception {
    private int m_statusCode = -1;

    public HttpException(String statusMessage, int statusCode) {
        super(statusMessage);
        this.m_statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.m_statusCode;
    }
}

