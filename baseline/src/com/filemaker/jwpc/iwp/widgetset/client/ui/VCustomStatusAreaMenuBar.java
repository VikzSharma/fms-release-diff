/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.ui.VHorizontalLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaMenubarState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ui.VHorizontalLayout;

public class VCustomStatusAreaMenuBar
extends VHorizontalLayout {
    private ApplicationConnection ac;
    private int smbs = 0;

    public VCustomStatusAreaMenuBar() {
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
    }

    public void setSmbs(int n) {
        this.smbs = n;
    }

    private boolean getBooleanState(StatusAreaMenubarState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.smbs, booleanState.ordinal());
    }

    public void updateState(ApplicationConnection applicationConnection) {
        this.ac = applicationConnection;
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.getBooleanState(StatusAreaMenubarState.BooleanState.showTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.ac);
        }
    }
}

