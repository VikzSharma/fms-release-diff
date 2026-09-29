/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TEnum
 *  org.apache.thrift.annotation.Nullable
 */
package com.filemaker.jwpc.iwp.thrift.notification;

import org.apache.thrift.TEnum;
import org.apache.thrift.annotation.Nullable;

public enum RowSetChangeType implements TEnum
{
    ROWSET_CHANGE(0),
    ROW_ADDITION_DELETION(1);

    private final int value;

    private RowSetChangeType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static RowSetChangeType findByValue(int n) {
        switch (n) {
            case 0: {
                return ROWSET_CHANGE;
            }
            case 1: {
                return ROW_ADDITION_DELETION;
            }
        }
        return null;
    }
}

