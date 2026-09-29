/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.widgetset.client.connector.NavigableOptionGroupConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.RadioSetClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.RadioSetServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.RadioSetState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomRadioSet;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;

@Connect(value=RadioSet.class)
public class RadioSetConnector
extends NavigableOptionGroupConnector {
    public RadioSetConnector() {
        this.getWidget().registerRadioSetServerRpc((RadioSetServerRpc)RpcProxy.create(RadioSetServerRpc.class, (ServerConnector)this));
        this.registerRpc(RadioSetClientRpc.class, new RadioSetClientRpc(){

            @Override
            public void setActive(boolean bl) {
                RadioSetConnector.this.getWidget().setActiveStyles(bl);
                if (bl) {
                    RadioSetConnector.this.getWidget().focus();
                } else {
                    RadioSetConnector.this.getWidget().getElement().blur();
                }
            }

            @Override
            public void setSelectionAllowed(boolean bl) {
                RadioSetConnector.this.getWidget().setSelectionAllowed(bl);
            }
        });
    }

    @Override
    public VCustomRadioSet getWidget() {
        return (VCustomRadioSet)super.getWidget();
    }

    public RadioSetState getState() {
        return (RadioSetState)super.getState();
    }
}

