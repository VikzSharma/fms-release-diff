/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomToolbarPopoverLayout;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ToolbarPopover.ToolbarPopoverLayout.class)
public class ToolbarPopoverLayoutConnector
extends CssLayoutConnector {
    public VCustomToolbarPopoverLayout getWidget() {
        return (VCustomToolbarPopoverLayout)super.getWidget();
    }
}

