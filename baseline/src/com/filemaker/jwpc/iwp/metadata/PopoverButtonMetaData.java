/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.metadata;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import java.util.LinkedHashMap;

public class PopoverButtonMetaData
extends ObjectMetaData {
    private int popoverObjectId = 0;

    public PopoverButtonMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        super(linkedHashMap);
    }

    public int getPopoverObjectId() {
        return this.getIntForKey("c30");
    }
}

