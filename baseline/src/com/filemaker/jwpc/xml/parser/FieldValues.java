/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.xml.parser;

import java.util.List;

public class FieldValues {
    private String queryFieldKey;
    private List<String> values;

    public FieldValues(String string, List<String> list) {
        this.queryFieldKey = string;
        this.values = list;
    }

    public String getQueryFieldKey() {
        return this.queryFieldKey;
    }

    public List<String> getValues() {
        return this.values;
    }
}

