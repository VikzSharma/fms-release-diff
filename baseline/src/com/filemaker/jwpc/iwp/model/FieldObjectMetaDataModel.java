/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.util.Utilities;

public class FieldObjectMetaDataModel {
    private final ObjectMetaData fieldMetaData;
    private final String fieldName;
    private final String fieldNameAliasForExport;
    private final String fieldNameAliasForSort;

    public FieldObjectMetaDataModel(ObjectMetaData objectMetaData, boolean bl) {
        this.fieldMetaData = objectMetaData;
        this.fieldName = objectMetaData.getFieldName(bl);
        this.fieldNameAliasForExport = objectMetaData.getFieldNameAliasForExport(bl);
        this.fieldNameAliasForSort = objectMetaData.getFieldNameAliasForSort(bl);
    }

    public String getFieldName(boolean bl) {
        return bl ? Utilities.encodeHTML(this.fieldName) : this.fieldName;
    }

    public int getFieldId() {
        return this.fieldMetaData.getFieldId();
    }

    public int getTableId() {
        return this.fieldMetaData.getTableId();
    }

    public LayoutFieldType getFieldType() {
        return this.fieldMetaData.getFieldType();
    }

    public String getFieldNameAliasForExport(boolean bl) {
        return bl ? Utilities.encodeHTML(this.fieldNameAliasForExport) : this.fieldNameAliasForExport;
    }

    public String getFieldNameAliasForSort(boolean bl) {
        return bl ? Utilities.encodeHTML(this.fieldNameAliasForSort) : this.fieldNameAliasForSort;
    }
}

