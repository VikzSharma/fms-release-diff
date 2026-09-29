/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.datatype.FieldParam;

public class ComplexParam
extends IDLComplexParam {
    public ComplexParam(FieldParam fieldParam, String string, String string2) {
        super(fieldParam, string, string2);
    }

    @Override
    public FieldParam getField() {
        return new FieldParam(super.getField().getName(), super.getField().getValue(), super.getField().getRepetition());
    }

    public String getName() {
        return super.getField().getName();
    }

    public String getValue() {
        return super.getField().getValue();
    }

    public void setValue(String string) {
        super.getField().setValue(string);
    }

    public short getRepetition() {
        return super.getField().getRepetition();
    }

    public String getTableName() {
        return this.getTable();
    }

    @Override
    public String toString() {
        return " name: " + this.getName() + " rep: " + this.getRepetition() + " value: " + this.getValue() + " table: " + this.getTableName() + " record: " + this.getRecordId() + " \n";
    }
}

