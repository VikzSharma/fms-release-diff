/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.WebViewer;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomWebViewer;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=WebViewer.class)
public class WebViewerConnector
extends CssLayoutConnector {
    public VCustomWebViewer getWidget() {
        return (VCustomWebViewer)super.getWidget();
    }
}

