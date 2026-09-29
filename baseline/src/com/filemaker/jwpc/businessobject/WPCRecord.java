/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLField
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortal
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLRecord
 *  com.filemaker.jwpc.fmwp.api.thrift.service.SimpleRecord
 *  com.filemaker.jwpc.fmwp.datatype.PortalRecord
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.businessobject.DataSource;
import com.filemaker.jwpc.businessobject.MetaData;
import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLField;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortal;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLRecord;
import com.filemaker.jwpc.fmwp.api.thrift.service.SimpleRecord;
import com.filemaker.jwpc.fmwp.datatype.PortalRecord;
import com.filemaker.jwpc.util.MultiLinkedHashMap;
import com.filemaker.jwpc.util.Utilities;
import java.util.List;

public class WPCRecord
extends IDLRecord {
    WPCRecord(IDLRecord iDLRecord) {
        super(iDLRecord.getRecord(), iDLRecord.getPortals());
    }

    WPCRecord(SimpleRecord simpleRecord) {
        super(simpleRecord, null);
    }

    public String getRecordId() {
        return this.getRecord().getRecordId();
    }

    public long getModCount() {
        return this.getRecord().getModCount();
    }

    public int getNumFields() {
        return this.getRecord().getFieldsSize();
    }

    public MultiLinkedHashMap<String, String[]> getFieldsValues(MetaData metaData, DataSource dataSource) {
        List list = this.getRecord().getFields();
        MultiLinkedHashMap<String, String[]> multiLinkedHashMap = new MultiLinkedHashMap<String, String[]>();
        for (int i = 0; i < list.size(); ++i) {
            String[] stringArray = null;
            IDLField iDLField = (IDLField)list.get(i);
            if (iDLField == null) continue;
            int n = iDLField.getValuesSize();
            stringArray = new String[n];
            for (int j = 0; j < n; ++j) {
                String string;
                stringArray[j] = (String)iDLField.getValues().get(j);
                if (stringArray[j].length() == 0) continue;
                if (metaData.isFieldTime(iDLField.getName())) {
                    string = WPCRecord.getValidInputFormat(stringArray[j], "hh:mm:ss a", "hh:mm a");
                    stringArray[j] = Utilities.ConvertDateTime(stringArray[j], string, dataSource.mTimeOutputFormat);
                    continue;
                }
                if (!metaData.isTimeStampField(iDLField.getName())) continue;
                string = WPCRecord.getValidInputFormat(stringArray[j], "MM/dd/yyyy hh:mm:ss a", "MM/dd/yyyy hh:mm a");
                String[] stringArray2 = WPCRecord.dettachTimestampAndDecimal(stringArray[j]);
                String string2 = Utilities.ConvertDateTime(stringArray2[0], string, dataSource.mTimestampOutputFormat);
                stringArray[j] = WPCRecord.attachTimestampAndDecimal(string2, stringArray2[1]);
            }
            multiLinkedHashMap.put(iDLField.getName(), stringArray);
        }
        return multiLinkedHashMap;
    }

    private static String getValidInputFormat(String string, String string2, String string3) {
        String[] stringArray = string.split(":");
        String string4 = stringArray.length == 2 ? string3 : string2;
        return string4;
    }

    private static String[] dettachTimestampAndDecimal(String string) {
        String string2;
        String[] stringArray = new String[2];
        String[] stringArray2 = string.split("\\.", 2);
        stringArray[0] = stringArray2[0];
        String string3 = string2 = stringArray2.length == 2 ? stringArray2[1] : null;
        if (string2 != null) {
            stringArray2 = string2.trim().split(" ", 2);
            stringArray[1] = stringArray2[0];
            if (stringArray2.length == 2) {
                stringArray[0] = stringArray[0] + " " + stringArray2[1];
            }
        }
        return stringArray;
    }

    private static String attachTimestampAndDecimal(String string, String string2) {
        String string3 = string2 == null ? string : string + "." + string2;
        return string3;
    }

    public MultiLinkedHashMap<String, PortalRecord> getPortalsMap() {
        MultiLinkedHashMap<String, PortalRecord> multiLinkedHashMap = new MultiLinkedHashMap<String, PortalRecord>();
        if (this.getPortals() != null) {
            for (IDLPortal iDLPortal : super.getPortals()) {
                multiLinkedHashMap.put(iDLPortal.getTable(), new PortalRecord(iDLPortal));
            }
        }
        return multiLinkedHashMap;
    }

    public static WPCRecord[] convertFromIDLRecordList(List<IDLRecord> list) {
        WPCRecord[] wPCRecordArray = new WPCRecord[list.size()];
        int n = 0;
        for (IDLRecord iDLRecord : list) {
            wPCRecordArray[n++] = new WPCRecord(iDLRecord);
        }
        return wPCRecordArray;
    }

    public static WPCRecord[] convertFromSimpleRecordList(List<SimpleRecord> list) {
        WPCRecord[] wPCRecordArray = new WPCRecord[list.size()];
        int n = 0;
        for (SimpleRecord simpleRecord : list) {
            wPCRecordArray[n++] = new WPCRecord(simpleRecord);
        }
        return wPCRecordArray;
    }

    public String toString() {
        return DataObject.toString((Object)this);
    }
}

