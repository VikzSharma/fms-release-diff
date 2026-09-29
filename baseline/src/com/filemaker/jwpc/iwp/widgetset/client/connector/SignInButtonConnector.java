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

import com.filemaker.jwpc.iwp.ui.layout.component.SignInButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.SignInButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.SignInButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomSignInButton;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=SignInButton.class)
public class SignInButtonConnector
extends CssLayoutConnector {
    private SignInButtonServerRpc rpc = (SignInButtonServerRpc)RpcProxy.create(SignInButtonServerRpc.class, (ServerConnector)this);

    public SignInButtonConnector() {
        this.getWidget().registerCallback(new SignInCallback(){

            @Override
            public void onSigningIn() {
                SignInButtonConnector.this.rpc.onSigningIn();
            }
        });
    }

    public VCustomSignInButton getWidget() {
        return (VCustomSignInButton)super.getWidget();
    }

    public SignInButtonState getState() {
        return (SignInButtonState)super.getState();
    }

    public static interface SignInCallback {
        public void onSigningIn();
    }
}

