/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PanelContainerControlMetaData
extends ObjectMetaData {
    public static final int DEFAULT_PANEL_ID = -1;
    private int selectedPanelId = -1;

    public PanelContainerControlMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
        this.setSelectedPanelId(this.getIntForKey("c36"));
    }

    public int getSelectedPanelId() {
        return this.selectedPanelId;
    }

    public void setSelectedPanelId(int n) {
        this.selectedPanelId = n;
    }
}

