/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;

public class ActiveObjectChangeEvent
extends UIEvent {
    private final LayoutObject layoutObject;

    public ActiveObjectChangeEvent(LayoutObject layoutObject) {
        super(EventType.ACTIVE_OBJECT_CHANGE);
        this.layoutObject = layoutObject;
    }

    public LayoutObject getLayoutObject() {
        return this.layoutObject;
    }
}

