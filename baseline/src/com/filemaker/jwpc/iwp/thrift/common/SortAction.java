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

public enum SortAction implements TEnum
{
    Sort(0),
    Unsort(1),
    Cancel(2);

    private final int value;

    private SortAction(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static SortAction findByValue(int n) {
        switch (n) {
            case 0: {
                return Sort;
            }
            case 1: {
                return Unsort;
            }
            case 2: {
                return Cancel;
            }
        }
        return null;
    }
}

