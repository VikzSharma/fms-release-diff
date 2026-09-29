/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FinderPopover;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomQuickFindMenuItem;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=FinderPopover.FinderPopoverLayout.QuickFindMenuItem.class)
public class QuickFindMenuItemConnector
extends CssLayoutConnector {
    public VCustomQuickFindMenuItem getWidget() {
        return (VCustomQuickFindMenuItem)super.getWidget();
    }
}

