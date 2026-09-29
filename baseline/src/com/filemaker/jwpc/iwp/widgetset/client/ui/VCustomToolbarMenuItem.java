/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.ToolbarMenuItemServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VCssLayout;

public class VCustomToolbarMenuItem
extends VCssLayout {
    private ToolbarMenuItemServerRpc rpc;

    public VCustomToolbarMenuItem() {
        if (FMCUtilities.useAriaCompliantControl()) {
            DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80));
        }
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (DOM.eventGetType((Event)event)) {
            case 128: {
                if (event.getKeyCode() != 13 && event.getKeyCode() != 32 || this.rpc == null) break;
                this.rpc.performServerAction();
                break;
            }
        }
    }

    public void onLoad() {
        super.onLoad();
        this.getElement().setAttribute("role", "menuitem");
    }

    public void setServerRpc(ToolbarMenuItemServerRpc toolbarMenuItemServerRpc) {
        this.rpc = toolbarMenuItemServerRpc;
    }
}

