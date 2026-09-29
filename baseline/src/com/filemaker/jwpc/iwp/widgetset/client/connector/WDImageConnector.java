/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.image.ImageConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.widgetset.client.state.WDImageState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.image.ImageConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=WDImage.class)
public class WDImageConnector
extends ImageConnector {
    public WDImageState getState() {
        return (WDImageState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().getElement().setAttribute("role", this.getState().role);
    }
}

