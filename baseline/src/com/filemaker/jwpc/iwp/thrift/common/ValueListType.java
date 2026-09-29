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

public enum ValueListType implements TEnum
{
    FIRSTONLY(0),
    SECONDONLY(1),
    BOTH(2);

    private final int value;

    private ValueListType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ValueListType findByValue(int n) {
        switch (n) {
            case 0: {
                return FIRSTONLY;
            }
            case 1: {
                return SECONDONLY;
            }
            case 2: {
                return BOTH;
            }
        }
        return null;
    }
}

