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

public enum PortalFilterType implements TEnum
{
    DefaultFilter(0),
    LayoutFilter(1);

    private final int value;

    private PortalFilterType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static PortalFilterType findByValue(int n) {
        switch (n) {
            case 0: {
                return DefaultFilter;
            }
            case 1: {
                return LayoutFilter;
            }
        }
        return null;
    }
}

