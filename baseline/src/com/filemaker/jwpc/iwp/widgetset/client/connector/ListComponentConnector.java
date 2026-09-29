/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.connectors.grid.GridConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.list.ListComponent;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ListComponentClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ListComponentServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ListComponentState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomListComponent;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.connectors.grid.GridConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ListComponent.class)
public class ListComponentConnector
extends GridConnector {
    private ListComponentServerRpc serverRpc = (ListComponentServerRpc)RpcProxy.create(ListComponentServerRpc.class, (ServerConnector)this);

    public ListComponentConnector() {
        this.registerRpc(ListComponentClientRpc.class, new ListComponentClientRpc(){

            @Override
            public void updatePageLength(int n, double d, double d2) {
                ListComponentConnector.this.getWidget().updatePageLength(n, d, d2);
            }

            @Override
            public void onDataLoaded() {
                ListComponentConnector.this.getWidget().onDataLoaded();
            }

            @Override
            public void scrollToDynamicHeightRow(int n) {
                ListComponentConnector.this.getWidget().scrollToDynamicHeightRow(n);
            }

            @Override
            public void recalculateScrollbarsForVirtualViewport() {
                ListComponentConnector.this.getWidget().recalculateScrollbarsForVirtualViewport();
            }

            @Override
            public void resetScrollPosition() {
                ListComponentConnector.this.getWidget().resetScrollPosition();
            }
        });
        this.getWidget().setServerRpc(this.serverRpc);
    }

    protected void init() {
        super.init();
        this.getWidget().init(this.getConnection());
    }

    public VCustomListComponent getWidget() {
        return (VCustomListComponent)super.getWidget();
    }

    public ListComponentState getState() {
        return (ListComponentState)super.getState();
    }
}

