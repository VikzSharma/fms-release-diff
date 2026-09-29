/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ui.VWindow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.PopoverWindowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VWindow;

public class VCustomPopoverWindow
extends VWindow {
    private int pwbs = 0;

    public VCustomPopoverWindow() {
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
    }

    public void setPwbs(int n) {
        this.pwbs = n;
    }

    private boolean getBooleanState(PopoverWindowState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.pwbs, booleanState.ordinal());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.getBooleanState(PopoverWindowState.BooleanState.hasTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }

    public void onAttach() {
        FMCUtilities.removeFocus();
        super.onAttach();
    }
}

