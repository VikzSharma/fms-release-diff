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

import com.filemaker.jwpc.iwp.ui.layout.component.OAuthButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.OAuthButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.OAuthButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomOAuthButton;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=OAuthButton.class)
public class OAuthButtonConnector
extends CssLayoutConnector {
    private OAuthButtonServerRpc rpc = (OAuthButtonServerRpc)RpcProxy.create(OAuthButtonServerRpc.class, (ServerConnector)this);

    public OAuthButtonConnector() {
        this.getWidget().registerCallback(new OAuthSignInCallback(){

            @Override
            public void onOAuthSignIn(String string, String string2, String string3) {
                OAuthButtonConnector.this.rpc.onOAuthSignIn(string, string2, string3);
                OAuthButtonConnector.this.getConnection().getHeartbeat().send();
            }
        });
    }

    public VCustomOAuthButton getWidget() {
        return (VCustomOAuthButton)super.getWidget();
    }

    public OAuthButtonState getState() {
        return (OAuthButtonState)super.getState();
    }

    public static interface OAuthSignInCallback {
        public void onOAuthSignIn(String var1, String var2, String var3);
    }
}

