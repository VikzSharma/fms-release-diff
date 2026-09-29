/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.embedded.EmbeddedConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.container.MediaEmbedded;
import com.filemaker.jwpc.iwp.widgetset.client.state.MediaEmbeddedState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomMediaEmbedded;
import com.google.gwt.core.client.GWT;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.embedded.EmbeddedConnector;
import com.vaadin.shared.ui.Connect;
import java.util.Map;

@Connect(value=MediaEmbedded.class)
public class MediaEmbeddedConnector
extends EmbeddedConnector {
    protected VCustomMediaEmbedded createWidget() {
        return (VCustomMediaEmbedded)((Object)GWT.create(VCustomMediaEmbedded.class));
    }

    public VCustomMediaEmbedded getWidget() {
        return (VCustomMediaEmbedded)super.getWidget();
    }

    public MediaEmbeddedState getState() {
        return (MediaEmbeddedState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        Map map = this.getState().parameters;
        this.getWidget().updateParameters((String)map.get("autoplay"), (String)map.get("height"), (String)map.get("width"), (String)map.get("filename"), this.getWidget().getSrc((String)map.get("src"), this.getConnection()), (String)map.get("mimetype"));
    }
}

