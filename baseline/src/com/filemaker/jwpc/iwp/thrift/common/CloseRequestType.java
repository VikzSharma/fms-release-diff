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

public enum CloseRequestType implements TEnum
{
    CLOSE(0),
    MESSAGE(1);

    private final int value;

    private CloseRequestType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static CloseRequestType findByValue(int n) {
        switch (n) {
            case 0: {
                return CLOSE;
            }
            case 1: {
                return MESSAGE;
            }
        }
        return null;
    }
}

