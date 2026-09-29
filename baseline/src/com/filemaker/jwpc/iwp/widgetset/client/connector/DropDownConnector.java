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

import com.filemaker.jwpc.iwp.ui.layout.component.DropDown;
import com.filemaker.jwpc.iwp.widgetset.client.connector.PopupConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.DropDownClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.DropDownState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDropDown;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=DropDown.class)
public class DropDownConnector
extends PopupConnector {
    public DropDownConnector() {
        this.getWidget().registerTextFieldServerRpc((TextFieldServerRpc)RpcProxy.create(TextFieldServerRpc.class, (ServerConnector)this));
        this.registerRpc(DropDownClientRpc.class, new DropDownClientRpc(){

            @Override
            public void setActive(boolean bl) {
                DropDownConnector.this.getWidget().setServerActive(bl);
                if (bl) {
                    DropDownConnector.this.getWidget().prepareForFocus();
                } else {
                    DropDownConnector.this.getWidget().prepareForExit();
                    DropDownConnector.this.getWidget().hideOptions();
                }
            }
        });
    }

    @Override
    public VCustomDropDown getWidget() {
        return (VCustomDropDown)super.getWidget();
    }

    @Override
    public DropDownState getState() {
        return (DropDownState)super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (this.getState().hasPortalFocus) {
            this.getWidget().setPortalFocus();
        }
    }
}

