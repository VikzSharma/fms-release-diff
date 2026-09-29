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

public enum LayoutFieldType implements TEnum
{
    INVALID(0),
    NORMAL(1),
    CALCULATED(2),
    SUMMARY(3);

    private final int value;

    private LayoutFieldType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static LayoutFieldType findByValue(int n) {
        switch (n) {
            case 0: {
                return INVALID;
            }
            case 1: {
                return NORMAL;
            }
            case 2: {
                return CALCULATED;
            }
            case 3: {
                return SUMMARY;
            }
        }
        return null;
    }
}

