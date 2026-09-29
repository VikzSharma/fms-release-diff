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

public enum DateOrder implements TEnum
{
    DATEORDER_MDY(0),
    DATEORDER_DMY(1),
    DATEORDER_YMD(2),
    DATEORDER_MYD(3),
    DATEORDER_DYM(4),
    DATEORDER_YDM(5);

    private final int value;

    private DateOrder(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static DateOrder findByValue(int n) {
        switch (n) {
            case 0: {
                return DATEORDER_MDY;
            }
            case 1: {
                return DATEORDER_DMY;
            }
            case 2: {
                return DATEORDER_YMD;
            }
            case 3: {
                return DATEORDER_MYD;
            }
            case 4: {
                return DATEORDER_DYM;
            }
            case 5: {
                return DATEORDER_YDM;
            }
        }
        return null;
    }
}

