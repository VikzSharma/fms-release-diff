/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PortalMetaData
extends ObjectMetaData {
    public PortalMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public int getInitialRowIndex() {
        return this.getIntForKey("c18");
    }

    public int getDisplayRowCount() {
        return this.getIntForKey("c5");
    }

    public boolean isAllowCreate() {
        return this.getBoolForAttribute(2);
    }

    public boolean isAllowDelete() {
        return this.getBoolForAttribute(3);
    }

    public boolean isShowScrollbar() {
        return this.getBoolForAttribute(45);
    }

    public boolean isAltBackground() {
        return this.getBoolForAttribute(4);
    }

    public boolean hasActiveStyle() {
        return this.getBoolForAttribute(1);
    }

    public boolean hasGrayHighlight() {
        return this.getBoolForAttribute(22);
    }

    public boolean hasRetainScroll() {
        return this.getBoolForAttribute(36);
    }

    public boolean hasPlaceholderTextInFindMode() {
        return this.getBoolForAttribute(25);
    }

    public boolean useCurrentFoundSet() {
        return this.getBoolForAttribute(60);
    }
}

