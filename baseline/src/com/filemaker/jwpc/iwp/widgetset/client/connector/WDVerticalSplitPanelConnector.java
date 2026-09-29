/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.splitpanel.VerticalSplitPanelConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.WDVerticalSplitPanel;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDVerticalSplitPanelClientRpc;
import com.vaadin.client.ui.splitpanel.VerticalSplitPanelConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=WDVerticalSplitPanel.class)
public class WDVerticalSplitPanelConnector
extends VerticalSplitPanelConnector {
    private WDVerticalSplitPanelClientRpc rpc = new WDVerticalSplitPanelClientRpcImpl();

    public void init() {
        super.init();
        this.registerRpc();
    }

    private void registerRpc() {
        this.registerRpc(WDVerticalSplitPanelClientRpc.class, this.rpc);
    }

    private class WDVerticalSplitPanelClientRpcImpl
    implements WDVerticalSplitPanelClientRpc {
        private WDVerticalSplitPanelClientRpcImpl() {
        }

        @Override
        public void updateSizes() {
            WDVerticalSplitPanelConnector.this.getWidget().updateSizes();
        }
    }
}

