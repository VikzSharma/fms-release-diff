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

public enum Attribute implements TEnum
{
    LOCKCONFLICT_USERNAME(0),
    FIELDNAME(1),
    SCRIPTNAME(2),
    FILENAME(3),
    MINPASSWORDLEN(4),
    VALUE_RANGE_MIN(5),
    VALUE_RANGE_MAX(6),
    DATA_LENGTH_MAX(7),
    CONTINUE_SCRIPT(8),
    CAN_ABORT(9),
    LLMACCOUNTNAME(10),
    RAGACCOUNTNAME(11);

    private final int value;

    private Attribute(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static Attribute findByValue(int n) {
        switch (n) {
            case 0: {
                return LOCKCONFLICT_USERNAME;
            }
            case 1: {
                return FIELDNAME;
            }
            case 2: {
                return SCRIPTNAME;
            }
            case 3: {
                return FILENAME;
            }
            case 4: {
                return MINPASSWORDLEN;
            }
            case 5: {
                return VALUE_RANGE_MIN;
            }
            case 6: {
                return VALUE_RANGE_MAX;
            }
            case 7: {
                return DATA_LENGTH_MAX;
            }
            case 8: {
                return CONTINUE_SCRIPT;
            }
            case 9: {
                return CAN_ABORT;
            }
            case 10: {
                return LLMACCOUNTNAME;
            }
            case 11: {
                return RAGACCOUNTNAME;
            }
        }
        return null;
    }
}

