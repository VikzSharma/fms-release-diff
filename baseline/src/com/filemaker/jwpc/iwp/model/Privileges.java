/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.UserPrivileges;

public class Privileges {
    public static final int NoAccess = 0;
    public static final int Create = 1;
    public static final int Browse = 2;
    public static final int Edit = 4;
    public static final int Delete = 8;
    public static final int NoViewAccess = 0;
    public static final int FormViewAccess = 1;
    public static final int ListViewAccess = 2;
    private int recordAccess = 0;
    private DBAccessLevel fieldAccess = DBAccessLevel.UnknownAccess;
    private DBAccessLevel layoutAccess = DBAccessLevel.UnknownAccess;
    private DBAccessLevel valueListAccess = DBAccessLevel.UnknownAccess;
    private DBAccessLevel scriptAccess = DBAccessLevel.UnknownAccess;
    private int viewAccess = 0;
    private boolean exportAccess = false;
    private boolean printAccess = false;
    private boolean pwAccess = false;
    private int recordPrivSet = 0;
    private int modePrivSet = 0;
    private int findPrivSet = 0;
    private int miscPrivSet = 0;
    public static final int NEW_RECORD = 0;
    public static final int DUPLICATE_RECORD = 1;
    public static final int REVERT_RECORD = 2;
    public static final int DELETE_RECORD = 3;
    public static final int DELETE_ALL_RECORDS = 4;
    public static final int PREVIOUS_RECORD = 5;
    public static final int NEXT_RECORD = 6;
    public static final int INSERT_CURRENT_USER = 7;
    public static final int INSERT_TIME = 8;
    public static final int INSERT_DATE = 9;
    public static final int EXPORT_RECORDS = 10;
    public static final int IMPORT_RECORDS = 11;
    public static final int GOTO_FORM_VIEW = 12;
    public static final int GOTO_LIST_VIEW = 13;
    public static final int GOTO_TABLE_VIEW = 14;
    public static final int GOTO_BROWSE_MODE = 15;
    public static final int GOTO_FIND_MODE = 16;
    public static final int SORT_RECORDS = 17;
    public static final int UNSORT_RECORDS = 18;
    public static final int SHOW_ALL_RECORDS = 19;
    public static final int OMIT_RECORD = 20;
    public static final int OMIT_MULTIPLE_RECORDS = 21;
    public static final int GOTO_RECORD = 22;
    public static final int PERFORM_FIND = 23;
    public static final int MODIFY_LAST_FIND = 24;
    public static final int CONSTRAIN_FOUND_SET = 25;
    public static final int EXTEND_FOUND_SET = 26;
    public static final int RELOOKUP_FIELD = 27;
    public static final int SHOW_OMITTED_RECORDS = 28;
    public static final int CHANGE_PASSWORD = 29;
    public static final int SAVEAS_SNAPSHOT_LINK = 30;
    public static final int SEND_LINK = 31;
    public static final int CLEAR = 32;
    public static final int REFRESH_WINDOW = 33;
    public static final int EXPORT_FIELD_CONTENTS = 34;
    public static final int NEW_RECORD_BIT = 1;
    public static final int DUPLICATE_RECORD_BIT = 2;
    public static final int REVERT_RECORD_BIT = 4;
    public static final int DELETE_RECORD_BIT = 8;
    public static final int DELETE_ALL_RECORDS_BIT = 16;
    public static final int PREVIOUS_RECORD_BIT = 32;
    public static final int NEXT_RECORD_BIT = 64;
    public static final int INSERT_CURRENT_USER_BIT = 128;
    public static final int INSERT_TIME_BIT = 256;
    public static final int INSERT_DATE_BIT = 512;
    public static final int EXPORT_RECORDS_BIT = 1024;
    public static final int IMPORT_RECORDS_BIT = 2048;
    public static final int EXPORT_FIELD_CONTENTS_BIT = 4096;
    public static final int GOTO_FORM_VIEW_BIT = 1;
    public static final int GOTO_LIST_VIEW_BIT = 2;
    public static final int GOTO_TABLE_VIEW_BIT = 4;
    public static final int GOTO_BROWSE_MODE_BIT = 8;
    public static final int GOTO_FIND_MODE_BIT = 16;
    public static final int SORT_RECORDS_BIT = 1;
    public static final int UNSORT_RECORDS_BIT = 2;
    public static final int SHOW_ALL_RECORDS_BIT = 4;
    public static final int OMIT_RECORD_BIT = 8;
    public static final int OMIT_MULTIPLE_RECORDS_BIT = 16;
    public static final int GOTO_RECORD_BIT = 32;
    public static final int PERFORM_FIND_BIT = 64;
    public static final int MODIFY_LAST_FIND_BIT = 128;
    public static final int CONSTRAIN_FOUND_SET_BIT = 256;
    public static final int EXTEND_FOUND_SET_BIT = 512;
    public static final int RELOOKUP_FIELD_BIT = 1024;
    public static final int SHOW_OMITTED_RECORDS_BIT = 2048;
    public static final int CHANGE_PASSWORD_BIT = 1;
    public static final int SAVEAS_SNAPSHOT_LINK_BIT = 2;
    public static final int SEND_LINK_BIT = 4;
    public static final int CLEAR_BIT = 8;
    public static final int REFRESH_WINDOW_BIT = 16;
    public static final int[] enabledArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 1, 2, 4, 8, 16, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 28, 1, 2, 4, 8, 16, 4096};

    public void update(UserPrivileges userPrivileges) {
        if (userPrivileges != null) {
            this.layoutAccess = userPrivileges.getLayoutAccess();
            this.recordAccess = userPrivileges.getRecordAccess();
            this.fieldAccess = userPrivileges.getFieldAccess();
            this.valueListAccess = userPrivileges.getValueListAccess();
            this.scriptAccess = userPrivileges.getScriptAccess();
            this.viewAccess = userPrivileges.getViewStyleAccess();
            this.exportAccess = userPrivileges.isExportAccess();
            this.printAccess = userPrivileges.isPrintAccess();
            this.pwAccess = userPrivileges.isPwAccess();
            this.recordPrivSet = userPrivileges.getRecordPrivSet();
            this.modePrivSet = userPrivileges.getModePrivSet();
            this.findPrivSet = userPrivileges.getFindPrivSet();
            this.miscPrivSet = userPrivileges.getMiscPrivSet();
        }
    }

    public DBAccessLevel getActiveFieldAccess() {
        return this.fieldAccess;
    }

    public DBAccessLevel getLayoutAccess() {
        return this.layoutAccess;
    }

    public boolean hasLayoutAccess() {
        return this.getLayoutAccess() != DBAccessLevel.NoAccess;
    }

    public boolean hasExportAccess() {
        return this.exportAccess;
    }

    public boolean hasPrintAccess() {
        return this.printAccess;
    }

    public boolean hasPasswordAccess() {
        return this.pwAccess;
    }

    public int getRecordAccess() {
        return this.recordAccess;
    }

    public boolean hasCreateAccess() {
        return (this.recordAccess & 1) > 0;
    }

    public boolean hasBrowseAccess() {
        return (this.recordAccess & 2) > 0;
    }

    public boolean hasFindAccess() {
        return true;
    }

    public boolean hasEditAccess() {
        return (this.recordAccess & 4) > 0;
    }

    public boolean hasDeleteAccess() {
        return (this.recordAccess & 8) > 0;
    }

    public boolean hasNoAccess() {
        return this.recordAccess == 0;
    }

    public DBAccessLevel getValueListAccess() {
        return this.valueListAccess;
    }

    public DBAccessLevel getScriptAccess() {
        return this.scriptAccess;
    }

    public int getViewStyleAccess() {
        return this.viewAccess;
    }

    public boolean hasFormViewAccess() {
        return (this.viewAccess & 1) > 0;
    }

    public boolean hasListViewAccess() {
        return (this.viewAccess & 2) > 0;
    }

    public void setLayoutAccess(DBAccessLevel dBAccessLevel) {
        this.layoutAccess = dBAccessLevel;
    }

    public void setRecordAccess(int n) {
        this.recordAccess = n;
    }

    public void setValueListAccess(DBAccessLevel dBAccessLevel) {
        this.valueListAccess = dBAccessLevel;
    }

    public void setScriptAccess(DBAccessLevel dBAccessLevel) {
        this.scriptAccess = dBAccessLevel;
    }

    public boolean isCommandEnabled(int n) {
        boolean bl = false;
        boolean bl2 = false;
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 34: {
                bl2 = true;
                boolean bl3 = bl = (this.recordPrivSet & enabledArray[n]) > 0;
            }
        }
        if (bl2) {
            return bl;
        }
        switch (n) {
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                bl2 = true;
                boolean bl4 = bl = (this.modePrivSet & enabledArray[n]) > 0;
            }
        }
        if (bl2) {
            return bl;
        }
        switch (n) {
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: {
                boolean bl5 = bl = (this.findPrivSet & enabledArray[n]) > 0;
            }
        }
        if (bl2) {
            return bl;
        }
        switch (n) {
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: {
                bl = (this.miscPrivSet & enabledArray[n]) > 0;
            }
        }
        return bl;
    }
}

