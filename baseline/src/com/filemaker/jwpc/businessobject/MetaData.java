/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortalFieldSpec
 *  com.filemaker.jwpc.fmwp.datatype.FieldMetaData
 *  com.filemaker.jwpc.fmwp.datatype.PortalFieldMetaData
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortalFieldSpec;
import com.filemaker.jwpc.fmwp.datatype.FieldMetaData;
import com.filemaker.jwpc.fmwp.datatype.PortalFieldMetaData;
import java.util.ArrayList;
import java.util.List;

public class MetaData
extends DataObject {
    List<FieldMetaData> mFieldDefs;
    List<PortalFieldMetaData> mPortalDefs;
    private ArrayList<String> containerFieldNames = new ArrayList();
    private ArrayList<String> timeFieldNames = new ArrayList();
    private ArrayList<String> timeStampFieldNames = new ArrayList();

    public MetaData() {
        this.mFieldDefs = new ArrayList<FieldMetaData>();
    }

    public MetaData(List<IDLFieldSpec> list, List<IDLPortalFieldSpec> list2) {
        this.mFieldDefs = new ArrayList<FieldMetaData>();
        this.mPortalDefs = new ArrayList<PortalFieldMetaData>();
        if (list != null) {
            for (IDLFieldSpec iDLFieldSpec : list) {
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
                this.mFieldDefs.add(new FieldMetaData(iDLFieldSpec));
            }
        }
        if (list2 != null) {
            for (IDLPortalFieldSpec iDLPortalFieldSpec : list2) {
                PortalFieldMetaData portalFieldMetaData = new PortalFieldMetaData(iDLPortalFieldSpec);
                this.mPortalDefs.add(portalFieldMetaData);
                this.containerFieldNames.addAll(portalFieldMetaData.getContainerFieldNames());
                this.timeFieldNames.addAll(portalFieldMetaData.getTimeFieldNames());
                this.timeStampFieldNames.addAll(portalFieldMetaData.getTimeStampFieldNames());
            }
        }
    }

    public List<FieldMetaData> getFieldDefinitions() {
        return this.mFieldDefs;
    }

    public List<PortalFieldMetaData> getPortalDefinitions() {
        return this.mPortalDefs;
    }

    public boolean isFieldContainer(String string) {
        return this.mFieldDefs != null && this.containerFieldNames.contains(string);
    }

    public boolean isFieldTime(String string) {
        if (string != null) {
            return this.timeFieldNames.contains(string);
        }
        return false;
    }

    public boolean isTimeStampField(String string) {
        if (string != null) {
            return this.timeStampFieldNames.contains(string);
        }
        return false;
    }
}

