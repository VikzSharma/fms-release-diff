/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;

public class BrowserWidthChangeEvent
extends UIEvent {
    private int previousWidth;

    public BrowserWidthChangeEvent(int n) {
        super(EventType.BROWSER_WIDTH_CHANGE);
        this.previousWidth = n;
    }

    public int getPreviousWidth() {
        return this.previousWidth;
    }
}

