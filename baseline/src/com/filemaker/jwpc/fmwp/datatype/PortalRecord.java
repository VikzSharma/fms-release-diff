/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.businessobject.WPCRecord
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.businessobject.WPCRecord;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortal;

public class PortalRecord {
    private IDLPortal portal;

    public PortalRecord(IDLPortal iDLPortal) {
        this.portal = iDLPortal;
    }

    public String getTableName() {
        return this.portal.getTable();
    }

    public WPCRecord[] getRecords() {
        return WPCRecord.convertFromSimpleRecordList(this.portal.getRecords());
    }

    public long getTotalRecords() {
        return this.portal.getTotalRecords();
    }
}

