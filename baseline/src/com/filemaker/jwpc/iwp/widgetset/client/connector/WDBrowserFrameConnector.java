/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.ui.browserframe.BrowserFrameConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDBrowserFrameClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDBrowserFrameServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.WDBrowserFrameState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomWDBrowserFrame;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.browserframe.BrowserFrameConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=WDBrowserFrame.class)
public class WDBrowserFrameConnector
extends BrowserFrameConnector {
    private WDBrowserFrameServerRpc rpc;

    public void init() {
        super.init();
        this.registerRpc();
    }

    public VCustomWDBrowserFrame getWidget() {
        return (VCustomWDBrowserFrame)super.getWidget();
    }

    public WDBrowserFrameState getState() {
        return (WDBrowserFrameState)super.getState();
    }

    private void registerRpc() {
        this.registerRpc(WDBrowserFrameClientRpc.class, new WDBrowserFrameClientRpcImpl());
        this.rpc = (WDBrowserFrameServerRpc)RpcProxy.create(WDBrowserFrameServerRpc.class, (ServerConnector)this);
        this.getWidget().registerRpc(this.rpc);
    }

    public class WDBrowserFrameClientRpcImpl
    implements WDBrowserFrameClientRpc {
        @Override
        public void performWebScript(String string, String[] stringArray) {
            if (!WDBrowserFrameConnector.this.getWidget().isContentLoaded()) {
                WDBrowserFrameConnector.this.getWidget().addWebScriptRequest(string, stringArray);
            } else if (!WDBrowserFrameConnector.this.getWidget().hasWebScript((Element)WDBrowserFrameConnector.this.getWidget().getFrame(), string)) {
                WDBrowserFrameConnector.this.rpc.performWebScriptDone(string, false, "Script not found", null);
            } else {
                WDBrowserFrameConnector.this.getWidget().performWebScript((Element)WDBrowserFrameConnector.this.getWidget().getFrame(), string, stringArray);
            }
        }
    }
}

