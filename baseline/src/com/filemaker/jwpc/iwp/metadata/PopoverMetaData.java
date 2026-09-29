/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PopoverMetaData
extends ObjectMetaData {
    public PopoverMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public String getTitle() {
        return this.getStringForKey("c31");
    }

    public String getPreferredAnchorEdge() {
        return this.getStringForKey("c29");
    }
}

