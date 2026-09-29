/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PartMetaData
extends ObjectMetaData {
    public PartMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public boolean isAltBackground() {
        return this.getBoolForAttribute(4);
    }

    public boolean hasActiveStyle() {
        return this.getBoolForAttribute(1);
    }
}

