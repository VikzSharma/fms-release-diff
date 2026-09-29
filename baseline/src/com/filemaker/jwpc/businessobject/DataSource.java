/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLLayoutSpec
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLLayoutSpec;

public class DataSource
extends DataObject {
    static final String mTimeInputFormat = "hh:mm:ss a";
    static final String mTimeNoSecondsInputFormat = "hh:mm a";
    static final String mTimestampInputFormat = "MM/dd/yyyy hh:mm:ss a";
    static final String mTimestampNoSecondsInputFormat = "MM/dd/yyyy hh:mm a";
    final String mDateOutputFormat;
    final String mTimeOutputFormat;
    final String mTimestampOutputFormat;
    String mDatabase = "";
    String mLayout = "";
    String mTable = "";
    long mTotalCount = 0L;

    public DataSource(long l) {
        this.mTotalCount = l;
        this.mDateOutputFormat = "";
        this.mTimeOutputFormat = "";
        this.mTimestampOutputFormat = "";
    }

    public DataSource(IDLLayoutSpec iDLLayoutSpec) {
        this.mDatabase = iDLLayoutSpec.getDatabaseName();
        this.mLayout = iDLLayoutSpec.getLayoutInfo().getItemName();
        this.mTable = iDLLayoutSpec.getTableName();
        this.mTotalCount = iDLLayoutSpec.getTotalRecords();
        this.mDateOutputFormat = "MM/dd/yyyy";
        this.mTimeOutputFormat = "HH:mm:ss";
        this.mTimestampOutputFormat = "MM/dd/yyyy HH:mm:ss";
    }

    public String getDatabase() {
        return this.mDatabase;
    }

    public void setDatabaseName(String string) {
        if (string != null && string.length() > 0) {
            this.mDatabase = string;
        }
    }

    public String getDateFormat() {
        return this.mDateOutputFormat;
    }

    public String getLayout() {
        return this.mLayout;
    }

    public String getTable() {
        return this.mTable;
    }

    public String getTimeFormat() {
        return this.mTimeOutputFormat;
    }

    public String getTimestampFormat() {
        return this.mTimestampOutputFormat;
    }

    public long getTotalCount() {
        return this.mTotalCount;
    }
}

