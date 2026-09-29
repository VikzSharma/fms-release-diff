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

public enum FindType implements TEnum
{
    Find_None(0),
    Find_Include(1),
    Find_Omit(2);

    private final int value;

    private FindType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static FindType findByValue(int n) {
        switch (n) {
            case 0: {
                return Find_None;
            }
            case 1: {
                return Find_Include;
            }
            case 2: {
                return Find_Omit;
            }
        }
        return null;
    }
}

