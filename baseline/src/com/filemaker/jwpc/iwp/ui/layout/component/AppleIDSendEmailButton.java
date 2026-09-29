/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.ui.common.AppleIDLoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDSendEmailButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AppleIDSendEmailButtonState;
import com.vaadin.ui.CssLayout;

public class AppleIDSendEmailButton
extends CssLayout {
    private AppleIDLoginDialogBase parent;

    public AppleIDSendEmailButton(AppleIDLoginDialogBase appleIDLoginDialogBase, String string) {
        this.parent = appleIDLoginDialogBase;
        this.addStyleName("fm-appleid-login-dialog-send-button-wrapper");
        this.registerServerRpc();
        this.getState().buttonText = string;
    }

    private void registerServerRpc() {
        this.registerRpc(new AppleIDSendEmailButtonServerRpcImpl(), AppleIDSendEmailButtonServerRpc.class);
    }

    protected AppleIDSendEmailButtonState getState() {
        return (AppleIDSendEmailButtonState)super.getState();
    }

    public void setText(String string) {
        this.getState().buttonText = string;
    }

    private class AppleIDSendEmailButtonServerRpcImpl
    implements AppleIDSendEmailButtonServerRpc {
        private AppleIDSendEmailButtonServerRpcImpl() {
        }

        @Override
        public void onAppleIDSendEmail() {
            AppleIDSendEmailButton.this.parent.sendEmailForAppleID();
        }
    }
}

