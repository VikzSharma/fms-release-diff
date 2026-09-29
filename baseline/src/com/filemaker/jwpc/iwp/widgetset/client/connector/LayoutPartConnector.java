/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.LayoutPartClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.state.LayoutPartState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomLayoutPart;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=LayoutPart.class)
public class LayoutPartConnector
extends CssLayoutConnector {
    public LayoutPartConnector() {
        this.registerRpc(LayoutPartClientRPC.class, new LayoutPartClientRPC(){

            @Override
            public void setMinHeight(int n) {
                LayoutPartConnector.this.getWidget().setMinHeight(n);
            }

            @Override
            public void setLayoutAndPartInfo(int n, int n2) {
                VCustomLayoutPart vCustomLayoutPart = LayoutPartConnector.this.getWidget();
                vCustomLayoutPart.setLayoutAndPartInfo(n, n2);
                vCustomLayoutPart.attachWindowResizeHandler();
            }
        });
    }

    public VCustomLayoutPart getWidget() {
        return (VCustomLayoutPart)super.getWidget();
    }

    public LayoutPartState getState() {
        return (LayoutPartState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        LayoutPartState layoutPartState = this.getState();
        if (!layoutPartState.style.isEmpty()) {
            this.getWidget().setStyle(layoutPartState.style);
        }
    }
}

