/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.window.WindowConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.widgetset.client.state.ToolbarPopoverState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomToolbarPopover;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.window.WindowConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ToolbarPopover.class)
public class ToolbarPopoverConnector
extends WindowConnector {
    public VCustomToolbarPopover getWidget() {
        return (VCustomToolbarPopover)super.getWidget();
    }

    public ToolbarPopoverState getState() {
        return (ToolbarPopoverState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        float f = this.getState().displayHeight;
        if (f > -1.0f) {
            this.getWidget().setDisplayHeight(f);
        }
        super.onStateChanged(stateChangeEvent);
    }
}

