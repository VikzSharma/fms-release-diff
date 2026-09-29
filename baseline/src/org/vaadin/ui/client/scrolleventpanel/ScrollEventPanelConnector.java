/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.ui.panel.PanelConnector
 *  com.vaadin.shared.ui.Connect
 */
package org.vaadin.ui.client.scrolleventpanel;

import com.google.gwt.core.client.GWT;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.panel.PanelConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.ui.ScrollEventPanel;
import org.vaadin.ui.client.scrolleventpanel.ScrollEventPanelServerRpc;
import org.vaadin.ui.client.scrolleventpanel.ScrollEventPanelState;
import org.vaadin.ui.client.scrolleventpanel.VScrollEventPanel;

@Connect(value=ScrollEventPanel.class)
public class ScrollEventPanelConnector
extends PanelConnector
implements VScrollEventPanel.ScrollListener {
    public ScrollEventPanelConnector() {
        this.getWidget().addScrollListener(this);
    }

    protected VScrollEventPanel createWidget() {
        return (VScrollEventPanel)((Object)GWT.create(VScrollEventPanel.class));
    }

    public VScrollEventPanel getWidget() {
        return (VScrollEventPanel)super.getWidget();
    }

    @Override
    public void onScroll(VScrollEventPanel.ScrollEvent scrollEvent) {
        ((ScrollEventPanelServerRpc)RpcProxy.create(ScrollEventPanelServerRpc.class, (ServerConnector)this)).onScroll(scrollEvent.getScrollPosition());
    }

    public ScrollEventPanelState getState() {
        return (ScrollEventPanelState)super.getState();
    }
}

