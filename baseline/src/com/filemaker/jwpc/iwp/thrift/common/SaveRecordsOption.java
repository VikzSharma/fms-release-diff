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

public enum SaveRecordsOption implements TEnum
{
    BROWSED_RECORDS(0),
    CURRENT_RECORD(1);

    private final int value;

    private SaveRecordsOption(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static SaveRecordsOption findByValue(int n) {
        switch (n) {
            case 0: {
                return BROWSED_RECORDS;
            }
            case 1: {
                return CURRENT_RECORD;
            }
        }
        return null;
    }
}

