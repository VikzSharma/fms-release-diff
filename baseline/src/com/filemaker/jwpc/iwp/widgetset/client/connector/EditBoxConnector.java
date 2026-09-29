/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.fields.client.textarea.TextAreaConnector;
import com.filemaker.jwpc.iwp.ui.layout.component.EditBox;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.EditBoxServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.EditBoxState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomEditBox;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=EditBox.class)
public class EditBoxConnector
extends TextAreaConnector {
    public EditBoxConnector() {
        this.getWidget().registerTextFieldServerRpc((EditBoxServerRpc)RpcProxy.create(EditBoxServerRpc.class, (ServerConnector)this));
    }

    @Override
    public VCustomEditBox getWidget() {
        return (VCustomEditBox)super.getWidget();
    }

    @Override
    public EditBoxState getState() {
        return (EditBoxState)super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (BrowserInfo.get().isIOS() && this.getState().tabIndex > -1) {
            this.getWidget().setTabIndex(this.getState().tabIndex);
        }
        if (this.getState().hasPortalFocus) {
            this.getWidget().setPortalFocus();
        }
        if (BrowserInfo.get().isSafari() && this.getWidget().isWordwrap() && !this.getWidget().hasFocus()) {
            this.getWidget().forceRepaint(this.getWidget().getElement().getId());
        }
    }
}

