/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.vaadin.v7.client.ui.VTextField
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaTextFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.v7.client.ui.VTextField;

public class VCustomStatusAreaTextField
extends VTextField {
    private int stbs = 0;

    public VCustomStatusAreaTextField() {
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
    }

    public void setStbs(int n) {
        this.stbs = n;
    }

    private boolean getBooleanState(StatusAreaTextFieldState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.stbs, booleanState.ordinal());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.getBooleanState(StatusAreaTextFieldState.BooleanState.showTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }
}

