/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.component.UploadDialog;
import com.filemaker.jwpc.iwp.widgetset.client.connector.DialogConnector;
import com.filemaker.jwpc.iwp.widgetset.client.state.UploadDialogState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomUploadDialog;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=UploadDialog.class)
public class UploadDialogConnector
extends DialogConnector {
    public UploadDialogState getState() {
        return (UploadDialogState)super.getState();
    }

    @Override
    public VCustomUploadDialog getWidget() {
        return (VCustomUploadDialog)super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().updateState(this.getState());
    }
}

