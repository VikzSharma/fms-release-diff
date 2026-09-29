/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TEnum
 *  org.apache.thrift.annotation.Nullable
 */
package com.filemaker.jwpc.fmwp.api.thrift.service;

import org.apache.thrift.TEnum;
import org.apache.thrift.annotation.Nullable;

public enum FieldType implements TEnum
{
    FTUnknown(0),
    normal(1),
    calculation(2),
    summary(3);

    private final int value;

    private FieldType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static FieldType findByValue(int n) {
        switch (n) {
            case 0: {
                return FTUnknown;
            }
            case 1: {
                return normal;
            }
            case 2: {
                return calculation;
            }
            case 3: {
                return summary;
            }
        }
        return null;
    }
}

