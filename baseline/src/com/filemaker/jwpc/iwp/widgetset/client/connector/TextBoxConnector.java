/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.label.LabelConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.Label;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMLabelState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomLabel;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.label.LabelConnector;

@Connect(value=Label.class)
public class TextBoxConnector
extends LabelConnector {
    public VCustomLabel getWidget() {
        return (VCustomLabel)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (this.getState().mergeField && BrowserInfo.get().isSafari()) {
            this.getWidget().forceRepaint(this.getWidget().getElement().getId());
        }
    }

    public FMLabelState getState() {
        return (FMLabelState)super.getState();
    }
}

