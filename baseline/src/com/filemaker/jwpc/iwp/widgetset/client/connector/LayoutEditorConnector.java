/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.LayoutEditor;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomLayoutEditor;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=LayoutEditor.class)
public class LayoutEditorConnector
extends CssLayoutConnector {
    public VCustomLayoutEditor getWidget() {
        return (VCustomLayoutEditor)super.getWidget();
    }
}

