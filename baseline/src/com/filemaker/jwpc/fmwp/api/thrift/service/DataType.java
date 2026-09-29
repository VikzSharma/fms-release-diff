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

public enum DataType implements TEnum
{
    DTUnknown(0),
    DTText(1),
    DTNumber(2),
    DTDate(3),
    DTTime(4),
    DTTimestamp(5),
    DTContainer(6),
    DTBoolean(7);

    private final int value;

    private DataType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static DataType findByValue(int n) {
        switch (n) {
            case 0: {
                return DTUnknown;
            }
            case 1: {
                return DTText;
            }
            case 2: {
                return DTNumber;
            }
            case 3: {
                return DTDate;
            }
            case 4: {
                return DTTime;
            }
            case 5: {
                return DTTimestamp;
            }
            case 6: {
                return DTContainer;
            }
            case 7: {
                return DTBoolean;
            }
        }
        return null;
    }
}

