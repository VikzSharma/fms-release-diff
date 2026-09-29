/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.ui.common.LoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.OAuthButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.OAuthButtonState;
import com.vaadin.ui.CssLayout;

public class OAuthButton
extends CssLayout {
    private LoginDialogBase parent;

    public OAuthButton(LoginDialogBase loginDialogBase, String string, String string2, String string3, String string4) {
        this.parent = loginDialogBase;
        this.addStyleName("oauth_button_wrapper");
        this.registerServerRpc();
        this.getState().providerName = string;
        this.getState().providerButtonName = string2;
        this.getState().providerId = string4;
        this.getState().iconUrl = string3;
        String string5 = Service.getMasterAddr();
        if (!(string5.isEmpty() || string5.equals("127.0.0.1") || string5.equals("localhost"))) {
            this.getState().masterAddr = string5;
        }
    }

    private void registerServerRpc() {
        this.registerRpc(new OAuthButtonServerRpcImpl(), OAuthButtonServerRpc.class);
    }

    protected OAuthButtonState getState() {
        return (OAuthButtonState)super.getState();
    }

    private class OAuthButtonServerRpcImpl
    implements OAuthButtonServerRpc {
        private OAuthButtonServerRpcImpl() {
        }

        @Override
        public void onOAuthSignIn(String string, String string2, String string3) {
            OAuthButton.this.parent.signInWithOAuth(string, string2, string3);
        }
    }
}

