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

public enum BrowserClientInfoParameter implements TEnum
{
    INVALID_PARAMETER(0),
    QUICK_FIND_TEXT(1),
    CURRENT_TIMESTAMP_STD(2);

    private final int value;

    private BrowserClientInfoParameter(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static BrowserClientInfoParameter findByValue(int n) {
        switch (n) {
            case 0: {
                return INVALID_PARAMETER;
            }
            case 1: {
                return QUICK_FIND_TEXT;
            }
            case 2: {
                return CURRENT_TIMESTAMP_STD;
            }
        }
        return null;
    }
}

