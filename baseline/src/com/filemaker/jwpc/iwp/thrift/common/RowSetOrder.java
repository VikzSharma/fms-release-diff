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

public enum RowSetOrder implements TEnum
{
    SORTED(0),
    SEMI_SORTED(1),
    UNSORTED(2);

    private final int value;

    private RowSetOrder(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static RowSetOrder findByValue(int n) {
        switch (n) {
            case 0: {
                return SORTED;
            }
            case 1: {
                return SEMI_SORTED;
            }
            case 2: {
                return UNSORTED;
            }
        }
        return null;
    }
}

