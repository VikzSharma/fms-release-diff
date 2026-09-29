/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.embedded.EmbeddedConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerEmbedded;
import com.filemaker.jwpc.iwp.widgetset.client.state.ContainerEmbeddedState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.embedded.EmbeddedConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ContainerEmbedded.class)
public class ContainerEmbeddedConnector
extends EmbeddedConnector {
    public ContainerEmbeddedState getState() {
        return (ContainerEmbeddedState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().getElement().setAttribute("role", this.getState().role);
    }
}

