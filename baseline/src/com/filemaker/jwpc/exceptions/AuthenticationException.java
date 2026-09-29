/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.exceptions;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;

public class AuthenticationException
extends Exception {
    private ErrorCode error;
    private String userName;
    private String password;
    private String databaseName;

    public AuthenticationException(ErrorCode errorCode, String string, String string2, String string3) {
        this.error = errorCode;
        this.userName = string;
        this.password = string2;
        this.databaseName = string3;
    }

    public AuthenticationException(ErrorCode errorCode, String string, String string2) {
        this.error = errorCode;
        this.userName = string;
        this.password = string2;
        this.databaseName = "";
    }
}

