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

public enum ValidationRule implements TEnum
{
    Empty(0),
    NotEmpty(1),
    MaxChar(2);

    private final int value;

    private ValidationRule(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ValidationRule findByValue(int n) {
        switch (n) {
            case 0: {
                return Empty;
            }
            case 1: {
                return NotEmpty;
            }
            case 2: {
                return MaxChar;
            }
        }
        return null;
    }
}

