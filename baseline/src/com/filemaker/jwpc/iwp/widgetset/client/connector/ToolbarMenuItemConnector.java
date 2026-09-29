/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ToolbarMenuItemServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomToolbarMenuItem;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ToolbarMenuItem.class)
public class ToolbarMenuItemConnector
extends CssLayoutConnector {
    public ToolbarMenuItemConnector() {
        this.getWidget().setServerRpc((ToolbarMenuItemServerRpc)RpcProxy.create(ToolbarMenuItemServerRpc.class, (ServerConnector)this));
    }

    public VCustomToolbarMenuItem getWidget() {
        return (VCustomToolbarMenuItem)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            this.getWidget().getElement().setTabIndex(this.getState().enabled ? 0 : -1);
        }
    }
}

