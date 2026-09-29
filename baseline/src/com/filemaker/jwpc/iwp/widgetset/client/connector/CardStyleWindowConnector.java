/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.window.WindowConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.cardstylewindow.CardStyleWindow;
import com.filemaker.jwpc.iwp.widgetset.client.state.CardStyleWindowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomCardStyleWindow;
import com.vaadin.client.ui.window.WindowConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=CardStyleWindow.class)
public class CardStyleWindowConnector
extends WindowConnector {
    public VCustomCardStyleWindow getWidget() {
        return (VCustomCardStyleWindow)super.getWidget();
    }

    public CardStyleWindowState getState() {
        return (CardStyleWindowState)super.getState();
    }
}

