/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.api.thrift.service.FindType;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.FieldParam;
import java.util.ArrayList;
import java.util.List;

public class FieldsParam {
    protected List<FieldParam> fields;
    protected List<ComplexParam> relatedFields;
    protected FindType findType = FindType.Find_None;

    public FieldsParam() {
        this.fields = new ArrayList<FieldParam>();
        this.relatedFields = new ArrayList<ComplexParam>();
    }

    public FieldsParam(FindType findType) {
        this();
        this.findType = findType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addField(FieldParam fieldParam) {
        List<FieldParam> list = this.fields;
        synchronized (list) {
            this.fields.add(fieldParam);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addRelatedField(ComplexParam complexParam) {
        List<ComplexParam> list = this.relatedFields;
        synchronized (list) {
            this.relatedFields.add(complexParam);
        }
    }

    public List<FieldParam> getFields() {
        return this.fields;
    }

    public void setFields(List<FieldParam> list) {
        this.fields = list;
    }

    public List<ComplexParam> getRelatedFields() {
        return this.relatedFields;
    }

    public void setRelatedFields(List<ComplexParam> list) {
        this.relatedFields = list;
    }

    public FindType getFindType() {
        return this.findType;
    }

    public void setFindType(FindType findType) {
        this.findType = findType;
    }
}

