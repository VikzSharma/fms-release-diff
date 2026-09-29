/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.orderedlayout.HorizontalLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.MainMenubar;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaMenubarState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomStatusAreaMenuBar;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.orderedlayout.HorizontalLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=MainMenubar.class)
public class StatusAreaMenuBarConnector
extends HorizontalLayoutConnector {
    public VCustomStatusAreaMenuBar getWidget() {
        return (VCustomStatusAreaMenuBar)super.getWidget();
    }

    public StatusAreaMenubarState getState() {
        return (StatusAreaMenubarState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().updateState(this.getConnection());
    }
}

