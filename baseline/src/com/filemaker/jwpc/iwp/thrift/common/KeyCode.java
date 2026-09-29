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

public enum KeyCode implements TEnum
{
    ENTER_KEY(13),
    ESCAPE_KEY(27);

    private final int value;

    private KeyCode(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static KeyCode findByValue(int n) {
        switch (n) {
            case 13: {
                return ENTER_KEY;
            }
            case 27: {
                return ESCAPE_KEY;
            }
        }
        return null;
    }
}

