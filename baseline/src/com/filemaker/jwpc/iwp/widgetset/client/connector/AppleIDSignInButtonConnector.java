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

import com.filemaker.jwpc.iwp.ui.layout.component.AppleIDSignInButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDSignInButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AppleIDSignInButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomAppleIDSignInButton;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=AppleIDSignInButton.class)
public class AppleIDSignInButtonConnector
extends CssLayoutConnector {
    private AppleIDSignInButtonServerRpc rpc = (AppleIDSignInButtonServerRpc)RpcProxy.create(AppleIDSignInButtonServerRpc.class, (ServerConnector)this);

    public AppleIDSignInButtonConnector() {
        this.getWidget().registerCallback(new AppleIDSignInCallback(){

            @Override
            public void onAppleIDSigningIn() {
                AppleIDSignInButtonConnector.this.rpc.onAppleIDSigningIn();
            }
        });
    }

    public VCustomAppleIDSignInButton getWidget() {
        return (VCustomAppleIDSignInButton)super.getWidget();
    }

    public AppleIDSignInButtonState getState() {
        return (AppleIDSignInButtonState)super.getState();
    }

    public static interface AppleIDSignInCallback {
        public void onAppleIDSigningIn();
    }
}

