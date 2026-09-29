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

public enum ImportAction implements TEnum
{
    ADD(0),
    UPDATE(1),
    UPDATE_MATCH(2);

    private final int value;

    private ImportAction(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ImportAction findByValue(int n) {
        switch (n) {
            case 0: {
                return ADD;
            }
            case 1: {
                return UPDATE;
            }
            case 2: {
                return UPDATE_MATCH;
            }
        }
        return null;
    }
}

