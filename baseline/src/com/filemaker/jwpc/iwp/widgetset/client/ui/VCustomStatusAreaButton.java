/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.StatusAreaButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ui.VCssLayout;

public class VCustomStatusAreaButton
extends VCssLayout {
    private ApplicationConnection ac;
    private StatusAreaButtonServerRpc rpc;
    private int sbbs = 0;

    public VCustomStatusAreaButton() {
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
        if (FMCUtilities.useAriaCompliantControl()) {
            DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80));
        }
    }

    public void setSbbs(int n) {
        this.sbbs = n;
    }

    private boolean getBooleanState(StatusAreaButtonState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.sbbs, booleanState.ordinal());
    }

    public void updateState(ApplicationConnection applicationConnection) {
        this.ac = applicationConnection;
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (DOM.eventGetType((Event)event)) {
            case 128: {
                if (event.getKeyCode() != 13 && event.getKeyCode() != 32) break;
                event.stopPropagation();
                this.rpc.performServerAction();
                break;
            }
        }
        if (this.getBooleanState(StatusAreaButtonState.BooleanState.showTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.ac);
        }
    }

    public void setServerRpc(StatusAreaButtonServerRpc statusAreaButtonServerRpc) {
        this.rpc = statusAreaButtonServerRpc;
    }
}

