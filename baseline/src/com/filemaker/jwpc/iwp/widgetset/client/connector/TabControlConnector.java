/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.TabControl;
import com.filemaker.jwpc.iwp.widgetset.client.connector.PanelContainerControlConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TabControlClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTabControl;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import java.util.List;

@Connect(value=TabControl.class)
public class TabControlConnector
extends PanelContainerControlConnector {
    public TabControlConnector() {
        this.registerRpc(TabControlClientRPC.class, new TabControlClientRPC(){

            @Override
            public void setTabsStyle(List<String> list) {
                TabControlConnector.this.getWidget().setTabsStyle(list);
            }

            @Override
            public void refreshPosition() {
                TabControlConnector.this.getWidget().refreshPosition();
            }
        });
    }

    @Override
    public VCustomTabControl getWidget() {
        return (VCustomTabControl)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            FMCUtilities.fixLayoutTableAlert((Element)this.getWidget().getElement());
        }
    }
}

