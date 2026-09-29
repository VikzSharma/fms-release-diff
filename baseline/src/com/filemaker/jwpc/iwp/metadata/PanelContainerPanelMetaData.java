/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PanelContainerPanelMetaData
extends ObjectMetaData {
    public PanelContainerPanelMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public boolean isDefaultPanel() {
        return this.getBoolForAttribute(10);
    }
}

