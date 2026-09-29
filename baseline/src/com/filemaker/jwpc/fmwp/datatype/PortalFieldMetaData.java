/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.DataObject
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortalFieldSpec;
import com.filemaker.jwpc.fmwp.datatype.FieldMetaData;
import java.util.ArrayList;
import java.util.List;

public class PortalFieldMetaData
extends DataObject {
    private IDLPortalFieldSpec mPortalMetaData;
    private List<FieldMetaData> fields = new ArrayList<FieldMetaData>();
    private List<String> containerFieldNames = new ArrayList<String>();
    private List<String> timeFieldNames = new ArrayList<String>();
    private List<String> timeStampFieldNames = new ArrayList<String>();

    public PortalFieldMetaData(IDLPortalFieldSpec iDLPortalFieldSpec) {
        this.mPortalMetaData = iDLPortalFieldSpec;
        for (IDLFieldSpec iDLFieldSpec : this.mPortalMetaData.getFields()) {
            switch (iDLFieldSpec.getDataType()) {
                case DTContainer: {
                    this.containerFieldNames.add(iDLFieldSpec.getName());
                    break;
                }
                case DTTime: {
                    this.timeFieldNames.add(iDLFieldSpec.getName());
                    break;
                }
                case DTTimestamp: {
                    this.timeStampFieldNames.add(iDLFieldSpec.getName());
                }
            }
            this.fields.add(new FieldMetaData(iDLFieldSpec));
        }
    }

    public String getTableName() {
        return this.mPortalMetaData.getTableName();
    }

    public List<FieldMetaData> getFields() {
        return this.fields;
    }

    public List<String> getContainerFieldNames() {
        return this.containerFieldNames;
    }

    public List<String> getTimeFieldNames() {
        return this.timeFieldNames;
    }

    public List<String> getTimeStampFieldNames() {
        return this.timeStampFieldNames;
    }
}

