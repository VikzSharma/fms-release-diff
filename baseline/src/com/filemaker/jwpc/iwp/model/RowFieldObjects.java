/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import java.util.LinkedHashMap;
import java.util.Map;

public class RowFieldObjects {
    private Map<Integer, LayoutFieldObject> fieldObjects = new LinkedHashMap<Integer, LayoutFieldObject>();

    public void addFieldObject(Integer n, LayoutFieldObject layoutFieldObject) {
        this.fieldObjects.put(n, layoutFieldObject);
    }

    public Map<Integer, LayoutFieldObject> getFieldObjects() {
        return this.fieldObjects;
    }
}

