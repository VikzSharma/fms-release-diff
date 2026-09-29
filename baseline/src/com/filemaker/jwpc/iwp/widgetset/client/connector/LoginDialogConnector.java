/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.LoginDialogBase;
import com.filemaker.jwpc.iwp.widgetset.client.connector.UserAndPasswordDialogConnector;
import com.filemaker.jwpc.iwp.widgetset.client.state.LoginDialogBaseState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomLoginDialog;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=LoginDialogBase.class)
public class LoginDialogConnector
extends UserAndPasswordDialogConnector {
    public LoginDialogBaseState getState() {
        return (LoginDialogBaseState)super.getState();
    }

    @Override
    public VCustomLoginDialog getWidget() {
        return (VCustomLoginDialog)super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().updateLoginHeader(this.getState().header, this.getState().dbName, this.getState().ellipsis);
    }
}

