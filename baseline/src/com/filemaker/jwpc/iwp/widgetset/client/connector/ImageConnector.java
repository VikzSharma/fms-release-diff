/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.Image;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomImage;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=Image.class)
public class ImageConnector
extends CssLayoutConnector {
    public VCustomImage getWidget() {
        return (VCustomImage)super.getWidget();
    }
}

