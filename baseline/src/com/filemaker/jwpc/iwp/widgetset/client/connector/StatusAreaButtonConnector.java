/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.customwidgets.StatusAreaButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.StatusAreaButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomStatusAreaButton;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=StatusAreaButton.class)
public class StatusAreaButtonConnector
extends CssLayoutConnector {
    public StatusAreaButtonConnector() {
        this.getWidget().setServerRpc((StatusAreaButtonServerRpc)RpcProxy.create(StatusAreaButtonServerRpc.class, (ServerConnector)this));
    }

    public VCustomStatusAreaButton getWidget() {
        return (VCustomStatusAreaButton)super.getWidget();
    }

    public StatusAreaButtonState getState() {
        return (StatusAreaButtonState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        String string;
        super.onStateChanged(stateChangeEvent);
        if (stateChangeEvent.hasPropertyChanged("ariaLabel") && !(string = this.getState().ariaLabel.trim()).isEmpty()) {
            this.getWidget().getElement().getFirstChildElement().setAttribute("aria-label", string);
        }
        this.getWidget().updateState(this.getConnection());
    }
}

