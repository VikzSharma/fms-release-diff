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

public enum LineOrientation implements TEnum
{
    HORIZONTAL(0),
    VERTICAL(1),
    DIAGONAL(2);

    private final int value;

    private LineOrientation(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static LineOrientation findByValue(int n) {
        switch (n) {
            case 0: {
                return HORIZONTAL;
            }
            case 1: {
                return VERTICAL;
            }
            case 2: {
                return DIAGONAL;
            }
        }
        return null;
    }
}

