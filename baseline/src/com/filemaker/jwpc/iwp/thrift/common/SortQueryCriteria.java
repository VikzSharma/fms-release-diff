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

public enum SortQueryCriteria implements TEnum
{
    ASC(0),
    DESC(1),
    CUSTOM(2);

    private final int value;

    private SortQueryCriteria(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static SortQueryCriteria findByValue(int n) {
        switch (n) {
            case 0: {
                return ASC;
            }
            case 1: {
                return DESC;
            }
            case 2: {
                return CUSTOM;
            }
        }
        return null;
    }
}

