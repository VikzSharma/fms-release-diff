/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.ui.common.AppleIDLoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDSignInButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AppleIDSignInButtonState;
import com.vaadin.ui.CssLayout;

public class AppleIDSignInButton
extends CssLayout {
    private AppleIDLoginDialogBase parent;

    public AppleIDSignInButton(AppleIDLoginDialogBase appleIDLoginDialogBase, String string) {
        this.parent = appleIDLoginDialogBase;
        this.addStyleName("fm-appleid-login-dialog-signin-button-wrapper");
        this.registerServerRpc();
        this.getState().buttonText = string;
    }

    private void registerServerRpc() {
        this.registerRpc(new AppleIDSignInButtonServerRpcImpl(), AppleIDSignInButtonServerRpc.class);
    }

    protected AppleIDSignInButtonState getState() {
        return (AppleIDSignInButtonState)super.getState();
    }

    private class AppleIDSignInButtonServerRpcImpl
    implements AppleIDSignInButtonServerRpc {
        private AppleIDSignInButtonServerRpcImpl() {
        }

        @Override
        public void onAppleIDSigningIn() {
            AppleIDSignInButton.this.parent.signInWithAppleID();
        }
    }
}

