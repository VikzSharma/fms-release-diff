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

public enum DBAccessLevel implements TEnum
{
    UnknownAccess(0),
    NoAccess(1),
    ReadOnly(2),
    ReadWrite(3);

    private final int value;

    private DBAccessLevel(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static DBAccessLevel findByValue(int n) {
        switch (n) {
            case 0: {
                return UnknownAccess;
            }
            case 1: {
                return NoAccess;
            }
            case 2: {
                return ReadOnly;
            }
            case 3: {
                return ReadWrite;
            }
        }
        return null;
    }
}

