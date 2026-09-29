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

public enum UIActionType implements TEnum
{
    PROCESS_CLICK(0),
    ENTER_FIELD(1),
    GOTO_NEXT_FIELD(2),
    GOTO_PREV_FIELD(3),
    PROCESS_BROWSER_RESIZE(4),
    PROCESS_BROWSER_RESIZE_WITH_ACTIVE_FIELD(5),
    PROCESS_QUICKFIND_CLICK(6),
    GOTO_LAYOUT_BY_NAME(7),
    GOTO_LAYOUT_BY_ID(8),
    GOTO_ROW_BY_INDEX(9),
    SHOW_GOTO_ROW_DIALOG(10),
    GOTO_FORM_VIEW(11),
    GOTO_LIST_VIEW(12),
    GOTO_TABLE_VIEW(13),
    GOTO_FIND_MODE(14),
    GOTO_BROWSE_MODE(15),
    GOTO_NEXT_ROW(16),
    GOTO_PREV_ROW(17),
    TOGGLE_STATUS_AREA(18),
    VIEW_AS_PDF(19),
    MODIFY_FIELD_TEXT(20),
    INSERT_DATE_FROM_CALENDAR(21),
    INSERT_UPLOADED_FILE_INTO_CONTAINER(22),
    INSERT_DATE(23),
    INSERT_TIME(24),
    INSERT_CURRENT_USERNAME(25),
    SHOW_INSERT_INTO_CONTAINER_DIALOG(26),
    CLEAR_FIELD_CONTENTS(27),
    EXECUTE_SCRIPT_BY_ID(28),
    EXECUTE_SCRIPT_BY_NAME(29),
    RESUME_SCRIPT(30),
    EXIT_SCRIPT(31),
    CREATE_NEW_ROW(32),
    REVERT_ROW(33),
    DUP_ROW(34),
    DELETE_ROW(35),
    DELETE_ALL_RECORDS(36),
    OMIT_RECORD(37),
    OMIT_RECORDS(38),
    SHOW_ALL_RECORDS(39),
    SHOW_OMITTED_RECORDS(40),
    SORT_RECORDS(41),
    UNSORT_RECORDS(42),
    RELOOKUP_FIELD(43),
    PERFORM_QUICK_FIND(44),
    PERFORM_FIND(45),
    CANCEL_FIND(46),
    MODIFY_LAST_FIND(47),
    EXTEND_FOUNDSET(48),
    CONSTRAIN_FOUNDSET(49),
    TOGGLE_OMIT_STATE(50),
    EXPORT_FIELD_CONTENTS(51),
    EXPORT_RECORDS(52),
    IMPORT_RECORDS(53),
    SAVEAS_SNAPSHOT_LINK(54),
    REFRESH_WINDOW(55),
    SWITCH_TABS(56),
    CHANGE_PASSWORD(57),
    LOG_OUT(58),
    HANDLE_KEY_STROKE(59),
    ABORT_LONG_SCRIPT(60),
    ABORT_LONG_OPERATION(61),
    SEND_LINK(62),
    VIEW_ZOOMED_IMAGE(63),
    COMMIT_RECORD(64),
    EXIT_POPOVER(65),
    EXECUTE_BUTTON_SCRIPT(66),
    CLOSE_TOPMOST_VISIBLE_WINDOW(67);

    private final int value;

    private UIActionType(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }

    @Nullable
    public static UIActionType findByValue(int n) {
        switch (n) {
            case 0: {
                return PROCESS_CLICK;
            }
            case 1: {
                return ENTER_FIELD;
            }
            case 2: {
                return GOTO_NEXT_FIELD;
            }
            case 3: {
                return GOTO_PREV_FIELD;
            }
            case 4: {
                return PROCESS_BROWSER_RESIZE;
            }
            case 5: {
                return PROCESS_BROWSER_RESIZE_WITH_ACTIVE_FIELD;
            }
            case 6: {
                return PROCESS_QUICKFIND_CLICK;
            }
            case 7: {
                return GOTO_LAYOUT_BY_NAME;
            }
            case 8: {
                return GOTO_LAYOUT_BY_ID;
            }
            case 9: {
                return GOTO_ROW_BY_INDEX;
            }
            case 10: {
                return SHOW_GOTO_ROW_DIALOG;
            }
            case 11: {
                return GOTO_FORM_VIEW;
            }
            case 12: {
                return GOTO_LIST_VIEW;
            }
            case 13: {
                return GOTO_TABLE_VIEW;
            }
            case 14: {
                return GOTO_FIND_MODE;
            }
            case 15: {
                return GOTO_BROWSE_MODE;
            }
            case 16: {
                return GOTO_NEXT_ROW;
            }
            case 17: {
                return GOTO_PREV_ROW;
            }
            case 18: {
                return TOGGLE_STATUS_AREA;
            }
            case 19: {
                return VIEW_AS_PDF;
            }
            case 20: {
                return MODIFY_FIELD_TEXT;
            }
            case 21: {
                return INSERT_DATE_FROM_CALENDAR;
            }
            case 22: {
                return INSERT_UPLOADED_FILE_INTO_CONTAINER;
            }
            case 23: {
                return INSERT_DATE;
            }
            case 24: {
                return INSERT_TIME;
            }
            case 25: {
                return INSERT_CURRENT_USERNAME;
            }
            case 26: {
                return SHOW_INSERT_INTO_CONTAINER_DIALOG;
            }
            case 27: {
                return CLEAR_FIELD_CONTENTS;
            }
            case 28: {
                return EXECUTE_SCRIPT_BY_ID;
            }
            case 29: {
                return EXECUTE_SCRIPT_BY_NAME;
            }
            case 30: {
                return RESUME_SCRIPT;
            }
            case 31: {
                return EXIT_SCRIPT;
            }
            case 32: {
                return CREATE_NEW_ROW;
            }
            case 33: {
                return REVERT_ROW;
            }
            case 34: {
                return DUP_ROW;
            }
            case 35: {
                return DELETE_ROW;
            }
            case 36: {
                return DELETE_ALL_RECORDS;
            }
            case 37: {
                return OMIT_RECORD;
            }
            case 38: {
                return OMIT_RECORDS;
            }
            case 39: {
                return SHOW_ALL_RECORDS;
            }
            case 40: {
                return SHOW_OMITTED_RECORDS;
            }
            case 41: {
                return SORT_RECORDS;
            }
            case 42: {
                return UNSORT_RECORDS;
            }
            case 43: {
                return RELOOKUP_FIELD;
            }
            case 44: {
                return PERFORM_QUICK_FIND;
            }
            case 45: {
                return PERFORM_FIND;
            }
            case 46: {
                return CANCEL_FIND;
            }
            case 47: {
                return MODIFY_LAST_FIND;
            }
            case 48: {
                return EXTEND_FOUNDSET;
            }
            case 49: {
                return CONSTRAIN_FOUNDSET;
            }
            case 50: {
                return TOGGLE_OMIT_STATE;
            }
            case 51: {
                return EXPORT_FIELD_CONTENTS;
            }
            case 52: {
                return EXPORT_RECORDS;
            }
            case 53: {
                return IMPORT_RECORDS;
            }
            case 54: {
                return SAVEAS_SNAPSHOT_LINK;
            }
            case 55: {
                return REFRESH_WINDOW;
            }
            case 56: {
                return SWITCH_TABS;
            }
            case 57: {
                return CHANGE_PASSWORD;
            }
            case 58: {
                return LOG_OUT;
            }
            case 59: {
                return HANDLE_KEY_STROKE;
            }
            case 60: {
                return ABORT_LONG_SCRIPT;
            }
            case 61: {
                return ABORT_LONG_OPERATION;
            }
            case 62: {
                return SEND_LINK;
            }
            case 63: {
                return VIEW_ZOOMED_IMAGE;
            }
            case 64: {
                return COMMIT_RECORD;
            }
            case 65: {
                return EXIT_POPOVER;
            }
            case 66: {
                return EXECUTE_BUTTON_SCRIPT;
            }
            case 67: {
                return CLOSE_TOPMOST_VISIBLE_WINDOW;
            }
        }
        return null;
    }
}

