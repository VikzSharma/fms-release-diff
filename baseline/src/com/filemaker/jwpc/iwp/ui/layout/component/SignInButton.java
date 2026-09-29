/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.ui.common.LoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.SignInButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.SignInButtonState;
import com.vaadin.ui.CssLayout;

public class SignInButton
extends CssLayout {
    private LoginDialogBase parent;

    public SignInButton(LoginDialogBase loginDialogBase, String string) {
        this.parent = loginDialogBase;
        this.addStyleName("fm-login-dialog-signin-button-wrapper");
        this.registerServerRpc();
        this.getState().buttonText = string;
    }

    private void registerServerRpc() {
        this.registerRpc(new SignInButtonServerRpcImpl(), SignInButtonServerRpc.class);
    }

    protected SignInButtonState getState() {
        return (SignInButtonState)super.getState();
    }

    private class SignInButtonServerRpcImpl
    implements SignInButtonServerRpc {
        private SignInButtonServerRpcImpl() {
        }

        @Override
        public void onSigningIn() {
            SignInButton.this.parent.signIn();
        }
    }
}

