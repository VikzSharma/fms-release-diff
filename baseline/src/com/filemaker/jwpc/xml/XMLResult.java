/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLNameSet
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet
 *  com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.xml;

import com.filemaker.jwpc.businessobject.DataSource;
import com.filemaker.jwpc.businessobject.LayoutMetaData;
import com.filemaker.jwpc.businessobject.MetaData;
import com.filemaker.jwpc.businessobject.ValueLists;
import com.filemaker.jwpc.businessobject.WPCRecord;
import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLNameSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.MultiLinkedHashMap;
import com.filemaker.jwpc.util.Utilities;
import java.util.List;

public class XMLResult
extends WPCResult {
    private DataSource mDataSource;
    private MetaData mFieldsMetaData;
    private LayoutMetaData layoutMetaData;
    private ValueLists valueLists;
    private static String DBNAMES = "DBNAMES";

    public XMLResult(IDLResultSet iDLResultSet) {
        super(iDLResultSet);
        this.mFieldsMetaData = new MetaData(iDLResultSet.getLayout().getFieldSpecs(), iDLResultSet.getLayout().getPortalFieldSpecs());
        this.mDataSource = new DataSource(iDLResultSet.getLayout());
        this.layoutMetaData = new LayoutMetaData(iDLResultSet.getLayout().getFieldLaySpecs());
        this.valueLists = new ValueLists(iDLResultSet.getLayout().getValueLists());
    }

    public MultiLinkedHashMap<String, MultiLinkedHashMap<String, String>> getValueLists() {
        if (this.valueLists != null) {
            return this.valueLists.getValueLists();
        }
        return new MultiLinkedHashMap<String, MultiLinkedHashMap<String, String>>();
    }

    public XMLResult(List<String> list) {
        super(list, WPCResult.ResultType.DATABASE_NAME);
        this.mFieldsMetaData = new MetaData();
        this.mDataSource = new DataSource(list.size());
        this.mDataSource.setDatabaseName(DBNAMES);
    }

    public LayoutMetaData getLayoutMetaData() {
        return this.layoutMetaData;
    }

    public XMLResult(IDLNameSet iDLNameSet, WPCResult.ResultType resultType, String string) {
        super(iDLNameSet, resultType);
        this.mFieldsMetaData = new MetaData();
        this.mDataSource = new DataSource(iDLNameSet.getNamesSize());
        this.mDataSource.setDatabaseName(string);
    }

    public XMLResult(ReplyStatus replyStatus) {
        super(replyStatus);
        this.mDataSource = new DataSource(0L);
    }

    public XMLResult(ReplyStatus replyStatus, ErrorCode errorCode) {
        super(replyStatus, errorCode);
        this.mDataSource = new DataSource(0L);
    }

    public XMLResult(ErrorCode errorCode) {
        super(errorCode);
        this.mDataSource = new DataSource(0L);
    }

    public MetaData getMetaData() {
        return this.mFieldsMetaData;
    }

    public void setMetaData(MetaData metaData) {
        this.mFieldsMetaData = metaData;
    }

    public void setDataSource(DataSource dataSource) {
        this.mDataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.mDataSource;
    }

    public WPCRecord[] getRecords() {
        if (this.resultSet != null && this.resultSet.getRecords() != null) {
            List list = this.resultSet.getRecords();
            return WPCRecord.convertFromIDLRecordList(list);
        }
        return new WPCRecord[0];
    }

    @Override
    public String toString() {
        String string = Utilities.getLineBreak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName()).append('[').append(string);
        stringBuilder.append("mDataSource=").append(DataObject.toString(this.mDataSource)).append(string);
        stringBuilder.append("mFieldsMetaData=").append(DataObject.toString(this.mFieldsMetaData)).append(string);
        stringBuilder.append("layoutMetaData=").append(DataObject.toString(this.layoutMetaData)).append(string);
        stringBuilder.append("valueLists=").append(DataObject.toString(this.valueLists)).append(string);
        stringBuilder.append(super.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

