/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;

public class UIEvent {
    private EventType type;

    public UIEvent(EventType eventType) {
        this.type = eventType;
    }

    public EventType getType() {
        return this.type;
    }
}

