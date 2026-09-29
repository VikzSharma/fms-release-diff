/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.ObscuredEditBox;
import com.filemaker.jwpc.iwp.widgetset.client.connector.EditBoxConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ObscuredEditBoxClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ObscuredEditBoxState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomObscuredEditBox;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=ObscuredEditBox.class)
public class ObscuredEditBoxConnector
extends EditBoxConnector {
    public ObscuredEditBoxConnector() {
        this.registerRpc(ObscuredEditBoxClientRpc.class, new ObscuredEditBoxClientRpc(){

            @Override
            public void onErrorMessageDisplay() {
                ObscuredEditBoxConnector.this.getWidget().onErrorMessageDisplay();
            }
        });
    }

    @Override
    public VCustomObscuredEditBox getWidget() {
        return (VCustomObscuredEditBox)super.getWidget();
    }

    @Override
    public ObscuredEditBoxState getState() {
        return (ObscuredEditBoxState)super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setServerText(this.getState().text);
    }
}

