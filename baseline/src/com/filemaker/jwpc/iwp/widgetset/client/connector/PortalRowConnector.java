/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalRowClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PortalRowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPortalRow;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=PortalRowProperty.class)
public class PortalRowConnector
extends CssLayoutConnector {
    public PortalRowConnector() {
        this.registerRpc(PortalRowClientRpc.class, new PortalRowClientRpc(){

            @Override
            public void setStyleCSS(boolean bl) {
                PortalRowConnector.this.getWidget().setStyleCSS(bl);
            }
        });
    }

    public VCustomPortalRow getWidget() {
        return (VCustomPortalRow)super.getWidget();
    }

    public PortalRowState getState() {
        return (PortalRowState)super.getState();
    }
}

