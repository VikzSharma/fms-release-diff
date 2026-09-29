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

public enum ExportFieldContentsType implements TEnum
{
    STRING_DATA(0),
    BINARY_DATA_URL(1),
    BINARY_DATA(2),
    INVALID(3);

    private final int value;

    private ExportFieldContentsType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ExportFieldContentsType findByValue(int n) {
        switch (n) {
            case 0: {
                return STRING_DATA;
            }
            case 1: {
                return BINARY_DATA_URL;
            }
            case 2: {
                return BINARY_DATA;
            }
            case 3: {
                return INVALID;
            }
        }
        return null;
    }
}

