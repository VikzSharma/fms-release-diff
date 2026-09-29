/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;

public class PanelSwitchEvent
extends UIEvent {
    private final int panelContainerId;
    private final int visiblePanelId;

    public PanelSwitchEvent(int n, int n2) {
        super(EventType.VISIBLE_PANEL_CHANGE);
        this.panelContainerId = n;
        this.visiblePanelId = n2;
    }

    public int getPanelContainerId() {
        return this.panelContainerId;
    }

    public int getVisiblePanelId() {
        return this.visiblePanelId;
    }
}

