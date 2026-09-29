/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TEnum
 *  org.apache.thrift.annotation.Nullable
 */
package com.filemaker.jwpc.iwp.thrift.layout;

import org.apache.thrift.TEnum;
import org.apache.thrift.annotation.Nullable;

public enum DataType implements TEnum
{
    BINARY(0),
    BINARY_REPETITION(1),
    STRING(2),
    STRING_REPETITION(3),
    STRING_LAYOUTOBJECTS(4),
    INVALID(5);

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
                return BINARY;
            }
            case 1: {
                return BINARY_REPETITION;
            }
            case 2: {
                return STRING;
            }
            case 3: {
                return STRING_REPETITION;
            }
            case 4: {
                return STRING_LAYOUTOBJECTS;
            }
            case 5: {
                return INVALID;
            }
        }
        return null;
    }
}

