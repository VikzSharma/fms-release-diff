/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.util;

public class ExceptionProxy
extends Exception {
    private Throwable mRootCause = null;

    public ExceptionProxy() {
    }

    public ExceptionProxy(String message) {
        super(message);
    }

    public ExceptionProxy(Throwable rootCause) {
        this(rootCause.getMessage());
        this.mRootCause = rootCause;
    }

    public ExceptionProxy(Throwable rootCause, String message) {
        super(message);
        this.mRootCause = rootCause;
    }

    public Throwable getRootCause() {
        return this.mRootCause;
    }
}

