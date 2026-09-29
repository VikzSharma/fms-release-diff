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

public enum ValidationErrorAction implements TEnum
{
    OVERRIDE(0),
    REVERT(1),
    MODIFY(2);

    private final int value;

    private ValidationErrorAction(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ValidationErrorAction findByValue(int n) {
        switch (n) {
            case 0: {
                return OVERRIDE;
            }
            case 1: {
                return REVERT;
            }
            case 2: {
                return MODIFY;
            }
        }
        return null;
    }
}

