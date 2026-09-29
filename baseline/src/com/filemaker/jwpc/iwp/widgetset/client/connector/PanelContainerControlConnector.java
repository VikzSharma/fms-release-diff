/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.ui.tabsheet.TabsheetConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PanelContainerControlServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PanelContainerControlState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPanelContainerControl;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.tabsheet.TabsheetConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=PanelContainerControl.class)
public class PanelContainerControlConnector
extends TabsheetConnector {
    public PanelContainerControlConnector() {
        this.getWidget().registerPanelContainerControlServerRpc((PanelContainerControlServerRpc)RpcProxy.create(PanelContainerControlServerRpc.class, (ServerConnector)this));
    }

    public VCustomPanelContainerControl getWidget() {
        return (VCustomPanelContainerControl)super.getWidget();
    }

    public PanelContainerControlState getState() {
        return (PanelContainerControlState)super.getState();
    }
}

