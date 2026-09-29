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

public enum LayoutFieldDataType implements TEnum
{
    INVALID(0),
    TEXT(1),
    NUMBER(2),
    DATE(3),
    TIME(4),
    TIMESTAMP(5),
    CONTAINER(6),
    BOOLEAN(7),
    UNKNOWN(8);

    private final int value;

    private LayoutFieldDataType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static LayoutFieldDataType findByValue(int n) {
        switch (n) {
            case 0: {
                return INVALID;
            }
            case 1: {
                return TEXT;
            }
            case 2: {
                return NUMBER;
            }
            case 3: {
                return DATE;
            }
            case 4: {
                return TIME;
            }
            case 5: {
                return TIMESTAMP;
            }
            case 6: {
                return CONTAINER;
            }
            case 7: {
                return BOOLEAN;
            }
            case 8: {
                return UNKNOWN;
            }
        }
        return null;
    }
}

