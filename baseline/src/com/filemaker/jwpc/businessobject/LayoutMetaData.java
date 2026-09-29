/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.DisplayType
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldLaySpec
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.DisplayType;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldLaySpec;
import java.util.ArrayList;
import java.util.List;

public class LayoutMetaData
extends DataObject {
    List<FieldLayoutInfo> layoutInfo = new ArrayList<FieldLayoutInfo>();

    public LayoutMetaData(List<IDLFieldLaySpec> list) {
        for (IDLFieldLaySpec iDLFieldLaySpec : list) {
            this.layoutInfo.add(new FieldLayoutInfo(this, iDLFieldLaySpec.getName(), iDLFieldLaySpec.getValueList(), iDLFieldLaySpec.getDisplayType()));
        }
    }

    public List<FieldLayoutInfo> getLayoutInfo() {
        return this.layoutInfo;
    }

    public class FieldLayoutInfo
    extends DataObject {
        String fieldName = "";
        String valueListName = "";
        DisplayType styleType;

        FieldLayoutInfo(LayoutMetaData layoutMetaData, String string, String string2, DisplayType displayType) {
            this.fieldName = string;
            this.valueListName = string2;
            this.styleType = displayType;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setFieldName(String string) {
            this.fieldName = string;
        }

        public String getValueListName() {
            return this.valueListName;
        }

        public void setValueListName(String string) {
            this.valueListName = string;
        }

        public String getStyleType() {
            if (this.styleType != null) {
                return this.styleType.toString().toUpperCase();
            }
            return "";
        }

        public boolean isValueListDisplayed() {
            return this.styleType != DisplayType.EditText && this.styleType != DisplayType.Calendar;
        }

        public void setStyleType(DisplayType displayType) {
            this.styleType = displayType;
        }
    }
}

