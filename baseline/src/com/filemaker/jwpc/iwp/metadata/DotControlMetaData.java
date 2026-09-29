/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.PanelContainerControlMetaData;
import java.util.LinkedHashMap;

public class DotControlMetaData
extends PanelContainerControlMetaData {
    public DotControlMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public boolean isDotsHidden() {
        return this.getBoolForAttribute(12);
    }
}

