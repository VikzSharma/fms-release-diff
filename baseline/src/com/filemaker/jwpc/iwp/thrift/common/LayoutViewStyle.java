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

public enum LayoutViewStyle implements TEnum
{
    FORM(0),
    LIST(1),
    TABLE(2),
    UNKNOWN(3);

    private final int value;

    private LayoutViewStyle(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static LayoutViewStyle findByValue(int n) {
        switch (n) {
            case 0: {
                return FORM;
            }
            case 1: {
                return LIST;
            }
            case 2: {
                return TABLE;
            }
            case 3: {
                return UNKNOWN;
            }
        }
        return null;
    }
}

