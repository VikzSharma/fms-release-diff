/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.ShapeLayoutObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomShape;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ShapeLayoutObject.class)
public class ShapeConnector
extends CssLayoutConnector {
    public VCustomShape getWidget() {
        return (VCustomShape)super.getWidget();
    }
}

