/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.combobox.ComboBoxConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFindField;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.QuickFindFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomQuickFindField;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.combobox.ComboBoxConnector;

@Connect(value=QuickFindField.class)
public class QuickFindFieldConnector
extends ComboBoxConnector {
    public QuickFindFieldConnector() {
        this.getWidget().registerServerRpc((QuickFindFieldServerRpc)RpcProxy.create(QuickFindFieldServerRpc.class, (ServerConnector)this));
    }

    public VCustomQuickFindField getWidget() {
        return (VCustomQuickFindField)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setDescription(this.getState().description);
    }
}

