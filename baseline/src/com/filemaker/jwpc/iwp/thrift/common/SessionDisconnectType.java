/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TEnum
 *  org.apache.thrift.annotation.Nullable
 */
package com.filemaker.jwpc.iwp.thrift.common;

import org.apache.thrift.TEnum;
import org.apache.thrift.annotation.Nullable;

public enum SessionDisconnectType implements TEnum
{
    USER_LOGOUT(0),
    ADMIN_CLOSE(1),
    SESSION_TIMEOUT(2);

    private final int value;

    private SessionDisconnectType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static SessionDisconnectType findByValue(int n) {
        switch (n) {
            case 0: {
                return USER_LOGOUT;
            }
            case 1: {
                return ADMIN_CLOSE;
            }
            case 2: {
                return SESSION_TIMEOUT;
            }
        }
        return null;
    }
}

