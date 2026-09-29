/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.ShareButton;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomShareButton;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ShareButton.class)
public class ShareButtonConnector
extends CssLayoutConnector {
    public VCustomShareButton getWidget() {
        return (VCustomShareButton)super.getWidget();
    }
}

