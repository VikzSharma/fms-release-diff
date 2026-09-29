/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.application;

public class AppRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 6828236568046249593L;

    public AppRuntimeException(String string) {
        super(string);
    }

    public AppRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public AppRuntimeException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

