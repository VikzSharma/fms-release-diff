/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.AppleIDLoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.connector.UserAndPasswordDialogConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDLoginDialogServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomAppleIDLoginDialog;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;

@Connect(value=AppleIDLoginDialogBase.class)
public class AppleIDLoginDialogConnector
extends UserAndPasswordDialogConnector {
    public AppleIDLoginDialogConnector() {
        AppleIDLoginDialogServerRpc appleIDLoginDialogServerRpc = (AppleIDLoginDialogServerRpc)RpcProxy.create(AppleIDLoginDialogServerRpc.class, (ServerConnector)this);
        this.getWidget().setServerRpc(appleIDLoginDialogServerRpc);
    }

    @Override
    public VCustomAppleIDLoginDialog getWidget() {
        return (VCustomAppleIDLoginDialog)super.getWidget();
    }
}

