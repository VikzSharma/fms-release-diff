/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.PortalRowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCPortalRowEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VCssLayout;

public class VCustomPortalRow
extends VCssLayout {
    private FMCPortalRowEventManager eventManager;
    private int prbs = 0;

    public void setPrbs(int n) {
        this.prbs = n;
        if (this.eventManager == null) {
            boolean bl = this.getBooleanState(PortalRowState.BooleanState.validRow);
            this.eventManager = new FMCPortalRowEventManager(this.getElement(), bl, bl && this.getBooleanState(PortalRowState.BooleanState.hasEnterTriggers));
        }
    }

    private boolean getBooleanState(PortalRowState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.prbs, booleanState.ordinal());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.eventManager != null) {
            this.eventManager.handleEvent(event, (Widget)this);
        }
    }

    public void setStyleCSS(boolean bl) {
        if (bl) {
            this.addStyleName("iwp-portal-selected-row");
            this.addStyleName("fm-selected");
        } else {
            this.removeStyleName("iwp-portal-selected-row");
            this.removeStyleName("fm-selected");
            this.removeStyleName("fm-hover");
        }
    }
}

