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

public enum ScriptState implements TEnum
{
    RUNNING(0),
    PAUSE(1),
    RESUME(2),
    EXIT(3);

    private final int value;

    private ScriptState(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static ScriptState findByValue(int n) {
        switch (n) {
            case 0: {
                return RUNNING;
            }
            case 1: {
                return PAUSE;
            }
            case 2: {
                return RESUME;
            }
            case 3: {
                return EXIT;
            }
        }
        return null;
    }
}

