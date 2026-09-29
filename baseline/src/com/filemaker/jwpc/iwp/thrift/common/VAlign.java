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

public enum VAlign implements TEnum
{
    TOP_ALIGN(0),
    MIDDLE_ALIGN(1),
    BOTTOM_ALIGN(2);

    private final int value;

    private VAlign(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static VAlign findByValue(int n) {
        switch (n) {
            case 0: {
                return TOP_ALIGN;
            }
            case 1: {
                return MIDDLE_ALIGN;
            }
            case 2: {
                return BOTTOM_ALIGN;
            }
        }
        return null;
    }
}

