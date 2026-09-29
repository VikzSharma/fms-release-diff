/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.widgetset.client.connector.DialogConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogServerRPC;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomUserAndPWDDialog;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;

public abstract class UserAndPasswordDialogConnector
extends DialogConnector {
    private UserAndPasswordDialogServerRPC rpc = (UserAndPasswordDialogServerRPC)RpcProxy.create(UserAndPasswordDialogServerRPC.class, (ServerConnector)this);

    public UserAndPasswordDialogConnector() {
        this.getWidget().setRPC(this.rpc);
        this.registerRpc(UserAndPasswordDialogClientRPC.class, new UserAndPasswordDialogClientRPC(){

            @Override
            public void turnOffAutoComplete() {
                UserAndPasswordDialogConnector.this.getWidget().turnOffAutoComplete();
            }

            @Override
            public void setPlaceholderText(String string, String string2) {
                UserAndPasswordDialogConnector.this.getWidget().setPlaceholderText(string, string2);
            }

            @Override
            public void setAriaLabel(String string, String string2) {
                UserAndPasswordDialogConnector.this.getWidget().setAriaLabel(string, string2);
            }
        });
    }

    @Override
    public VCustomUserAndPWDDialog getWidget() {
        return (VCustomUserAndPWDDialog)super.getWidget();
    }
}

