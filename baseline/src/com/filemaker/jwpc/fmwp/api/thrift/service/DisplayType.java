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

public enum DisplayType implements TEnum
{
    EditText(0),
    PopupList(1),
    PopupMenu(2),
    Checkbox(3),
    RadioButtons(4),
    SelectionList(5),
    Calendar(6),
    ScrollText(7);

    private final int value;

    private DisplayType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static DisplayType findByValue(int n) {
        switch (n) {
            case 0: {
                return EditText;
            }
            case 1: {
                return PopupList;
            }
            case 2: {
                return PopupMenu;
            }
            case 3: {
                return Checkbox;
            }
            case 4: {
                return RadioButtons;
            }
            case 5: {
                return SelectionList;
            }
            case 6: {
                return Calendar;
            }
            case 7: {
                return ScrollText;
            }
        }
        return null;
    }
}

