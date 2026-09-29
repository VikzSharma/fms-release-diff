/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.AppleIDSendEmailButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDSendEmailButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AppleIDSendEmailButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomAppleIDSendEmailButton;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=AppleIDSendEmailButton.class)
public class AppleIDSendEmailButtonConnector
extends CssLayoutConnector {
    private AppleIDSendEmailButtonServerRpc rpc = (AppleIDSendEmailButtonServerRpc)RpcProxy.create(AppleIDSendEmailButtonServerRpc.class, (ServerConnector)this);

    public AppleIDSendEmailButtonConnector() {
        this.getWidget().registerCallback(new AppleIDSendEmailCallback(){

            @Override
            public void onAppleIDSendEmail() {
                AppleIDSendEmailButtonConnector.this.rpc.onAppleIDSendEmail();
            }
        });
    }

    public VCustomAppleIDSendEmailButton getWidget() {
        return (VCustomAppleIDSendEmailButton)super.getWidget();
    }

    public AppleIDSendEmailButtonState getState() {
        return (AppleIDSendEmailButtonState)super.getState();
    }

    public static interface AppleIDSendEmailCallback {
        public void onAppleIDSendEmail();
    }
}

