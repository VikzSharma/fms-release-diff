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

public enum DatabaseState implements TEnum
{
    Open(0),
    Error(1);

    private final int value;

    private DatabaseState(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static DatabaseState findByValue(int n) {
        switch (n) {
            case 0: {
                return Open;
            }
            case 1: {
                return Error;
            }
        }
        return null;
    }
}

