/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.window.WindowConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.widgetset.client.state.PopoverWindowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPopoverWindow;
import com.vaadin.client.ui.window.WindowConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=PopoverWindow.class)
public class PopoverWindowConnector
extends WindowConnector {
    public VCustomPopoverWindow getWidget() {
        return (VCustomPopoverWindow)super.getWidget();
    }

    public PopoverWindowState getState() {
        return (PopoverWindowState)super.getState();
    }
}

