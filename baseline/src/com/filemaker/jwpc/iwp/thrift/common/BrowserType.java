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

public enum BrowserType implements TEnum
{
    kSafariClient(0),
    kIEClient(1),
    kChromeClient(2),
    kEdgeClient(3),
    kOtherClient(4);

    private final int value;

    private BrowserType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static BrowserType findByValue(int n) {
        switch (n) {
            case 0: {
                return kSafariClient;
            }
            case 1: {
                return kIEClient;
            }
            case 2: {
                return kChromeClient;
            }
            case 3: {
                return kEdgeClient;
            }
            case 4: {
                return kOtherClient;
            }
        }
        return null;
    }
}

