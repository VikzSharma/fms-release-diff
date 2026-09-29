/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.fields.client.datefield.PopupDateFieldConnector;
import com.filemaker.jwpc.iwp.ui.layout.component.FMCustomDateField;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMCustomDateFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomCalendar;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=FMCustomDateField.class)
public class FMCustomDateFieldConnector
extends PopupDateFieldConnector {
    public FMCustomDateFieldConnector() {
        this.getWidget().registerTextFieldServerRpc((TextFieldServerRpc)RpcProxy.create(TextFieldServerRpc.class, (ServerConnector)this));
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public VCustomCalendar getWidget() {
        return (VCustomCalendar)super.getWidget();
    }

    @Override
    public FMCustomDateFieldState getState() {
        return (FMCustomDateFieldState)super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (this.getState().hasPortalFocus) {
            this.getWidget().setPortalFocus();
        }
    }
}

