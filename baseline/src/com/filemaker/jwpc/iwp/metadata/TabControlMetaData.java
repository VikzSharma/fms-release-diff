/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.PanelContainerControlMetaData;
import java.util.LinkedHashMap;

public class TabControlMetaData
extends PanelContainerControlMetaData {
    public TabControlMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public boolean isTabWidthCalcNeeded() {
        return this.getBoolForAttribute(46);
    }
}

