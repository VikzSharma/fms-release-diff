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

public enum LayoutObjectType implements TEnum
{
    TITLE_HEADER(0),
    HEADER(1),
    LEADING_GRAND_SUM(2),
    LEADING_SUB_SUM(3),
    BODY(4),
    TRAILING_SUB_SUM(5),
    TRAILING_GRAND_SUM(6),
    FOOTER(7),
    TITLE_FOOTER(8),
    TABLE_HEADER(9),
    EMPTY_TABLE_ROW(10),
    TOP_NAV_PART(11),
    BOTTOM_NAV_PART(12),
    UNKNOWN(13),
    BUTTON(14),
    CALENDAR(15),
    CHART(16),
    CHECKBOX_SET(17),
    CONTAINER(18),
    DOT_CONTROL(19),
    DOT_PANEL(20),
    DROP_DOWN(21),
    EDIT_BOX(22),
    GROUP(23),
    IMAGE(24),
    LABEL(25),
    LAYOUT(26),
    LINE(27),
    OVAL(28),
    POP_UP(29),
    POPOVER(30),
    POPOVER_BUTTON(31),
    PORTAL(32),
    RADIO_SET(33),
    RECTANGLE(34),
    ROUNDED_RECTANGLE(35),
    TAB_CONTROL(36),
    TAB_ITEM(37),
    VIDEO(38),
    WEB_VIEWER(39),
    SEGMENTED_BAR(40),
    SECURE_TEXT(41);

    private final int value;

    private LayoutObjectType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static LayoutObjectType findByValue(int n) {
        switch (n) {
            case 0: {
                return TITLE_HEADER;
            }
            case 1: {
                return HEADER;
            }
            case 2: {
                return LEADING_GRAND_SUM;
            }
            case 3: {
                return LEADING_SUB_SUM;
            }
            case 4: {
                return BODY;
            }
            case 5: {
                return TRAILING_SUB_SUM;
            }
            case 6: {
                return TRAILING_GRAND_SUM;
            }
            case 7: {
                return FOOTER;
            }
            case 8: {
                return TITLE_FOOTER;
            }
            case 9: {
                return TABLE_HEADER;
            }
            case 10: {
                return EMPTY_TABLE_ROW;
            }
            case 11: {
                return TOP_NAV_PART;
            }
            case 12: {
                return BOTTOM_NAV_PART;
            }
            case 13: {
                return UNKNOWN;
            }
            case 14: {
                return BUTTON;
            }
            case 15: {
                return CALENDAR;
            }
            case 16: {
                return CHART;
            }
            case 17: {
                return CHECKBOX_SET;
            }
            case 18: {
                return CONTAINER;
            }
            case 19: {
                return DOT_CONTROL;
            }
            case 20: {
                return DOT_PANEL;
            }
            case 21: {
                return DROP_DOWN;
            }
            case 22: {
                return EDIT_BOX;
            }
            case 23: {
                return GROUP;
            }
            case 24: {
                return IMAGE;
            }
            case 25: {
                return LABEL;
            }
            case 26: {
                return LAYOUT;
            }
            case 27: {
                return LINE;
            }
            case 28: {
                return OVAL;
            }
            case 29: {
                return POP_UP;
            }
            case 30: {
                return POPOVER;
            }
            case 31: {
                return POPOVER_BUTTON;
            }
            case 32: {
                return PORTAL;
            }
            case 33: {
                return RADIO_SET;
            }
            case 34: {
                return RECTANGLE;
            }
            case 35: {
                return ROUNDED_RECTANGLE;
            }
            case 36: {
                return TAB_CONTROL;
            }
            case 37: {
                return TAB_ITEM;
            }
            case 38: {
                return VIDEO;
            }
            case 39: {
                return WEB_VIEWER;
            }
            case 40: {
                return SEGMENTED_BAR;
            }
            case 41: {
                return SECURE_TEXT;
            }
        }
        return null;
    }
}

