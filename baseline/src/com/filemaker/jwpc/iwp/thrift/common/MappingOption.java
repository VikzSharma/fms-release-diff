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

public enum MappingOption implements TEnum
{
    IMPORT(0),
    NO_IMPORT(1),
    MATCH(2),
    UNIMPORTABLE(3);

    private final int value;

    private MappingOption(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static MappingOption findByValue(int n) {
        switch (n) {
            case 0: {
                return IMPORT;
            }
            case 1: {
                return NO_IMPORT;
            }
            case 2: {
                return MATCH;
            }
            case 3: {
                return UNIMPORTABLE;
            }
        }
        return null;
    }
}

