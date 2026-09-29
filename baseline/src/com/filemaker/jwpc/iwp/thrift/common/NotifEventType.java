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

public enum NotifEventType implements TEnum
{
    OPEN_HELP(0);

    private final int value;

    private NotifEventType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static NotifEventType findByValue(int n) {
        switch (n) {
            case 0: {
                return OPEN_HELP;
            }
        }
        return null;
    }
}

