/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.CheckboxSet;
import com.filemaker.jwpc.iwp.widgetset.client.connector.RadioSetConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.CheckboxSetServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomCheckboxSet;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;

@Connect(value=CheckboxSet.class)
public class CheckboxSetConnector
extends RadioSetConnector {
    public CheckboxSetConnector() {
        this.getWidget().registerCheckboxSetServerRpc((CheckboxSetServerRpc)RpcProxy.create(CheckboxSetServerRpc.class, (ServerConnector)this));
    }

    @Override
    public VCustomCheckboxSet getWidget() {
        return (VCustomCheckboxSet)super.getWidget();
    }
}

