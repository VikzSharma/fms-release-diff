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

public enum HAlign implements TEnum
{
    LEFT_ALIGN(0),
    CENTER_ALIGN(1),
    RIGHT_ALIGN(2);

    private final int value;

    private HAlign(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static HAlign findByValue(int n) {
        switch (n) {
            case 0: {
                return LEFT_ALIGN;
            }
            case 1: {
                return CENTER_ALIGN;
            }
            case 2: {
                return RIGHT_ALIGN;
            }
        }
        return null;
    }
}

