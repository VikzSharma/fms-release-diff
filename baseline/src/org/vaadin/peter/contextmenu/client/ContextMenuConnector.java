/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.EventTarget
 *  com.google.gwt.event.dom.client.ContextMenuEvent
 *  com.google.gwt.event.dom.client.ContextMenuHandler
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.ComponentConnector
 *  com.vaadin.client.ConnectorMap
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.Util
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.extensions.AbstractExtensionConnector
 *  com.vaadin.client.ui.AbstractComponentConnector
 *  com.vaadin.shared.ui.Connect
 */
package org.vaadin.peter.contextmenu.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorMap;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.Util;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.client.ContextMenuClientRpc;
import org.vaadin.peter.contextmenu.client.ContextMenuServerRpc;
import org.vaadin.peter.contextmenu.client.ContextMenuState;
import org.vaadin.peter.contextmenu.client.ContextMenuWidget;

@Connect(value=ContextMenu.class)
public class ContextMenuConnector
extends AbstractExtensionConnector {
    private static final long serialVersionUID = 3830712282306785118L;
    private ContextMenuWidget widget;
    private Widget extensionTarget;
    private ContextMenuServerRpc clientToServerRPC = (ContextMenuServerRpc)RpcProxy.create(ContextMenuServerRpc.class, (ServerConnector)this);
    private CloseHandler<PopupPanel> contextMenuCloseHandler = new CloseHandler<PopupPanel>(){

        public void onClose(CloseEvent<PopupPanel> closeEvent) {
            ContextMenuConnector.this.clientToServerRPC.contextMenuClosed();
        }
    };
    private final ContextMenuHandler contextMenuHandler = new ContextMenuHandler(){

        public void onContextMenu(ContextMenuEvent contextMenuEvent) {
            contextMenuEvent.preventDefault();
            contextMenuEvent.stopPropagation();
            EventTarget eventTarget = contextMenuEvent.getNativeEvent().getEventTarget();
            ComponentConnector componentConnector = Util.getConnectorForElement((ApplicationConnection)ContextMenuConnector.this.getConnection(), (Widget)ContextMenuConnector.this.getConnection().getUIConnector().getWidget(), (Element)((Element)eventTarget.cast()));
            Widget widget = componentConnector.getWidget();
            if (ContextMenuConnector.this.extensionTarget.equals(widget)) {
                if (ContextMenuConnector.this.getState().isOpenAutomatically()) {
                    ContextMenuConnector.this.widget.showContextMenu(contextMenuEvent.getNativeEvent().getClientX(), contextMenuEvent.getNativeEvent().getClientY());
                } else {
                    ContextMenuConnector.this.clientToServerRPC.onContextMenuOpenRequested(contextMenuEvent.getNativeEvent().getClientX(), contextMenuEvent.getNativeEvent().getClientY(), componentConnector.getConnectorId());
                }
            }
        }
    };
    private HandlerRegistration contextMenuCloseHandlerRegistration;
    private HandlerRegistration contextMenuHandlerRegistration;
    private ContextMenuClientRpc serverToClientRPC = new ContextMenuClientRpc(){

        @Override
        public void showContextMenu(int n, int n2) {
            ContextMenuConnector.this.widget.showContextMenu(n, n2);
        }

        @Override
        public void showContextMenuRelativeTo(String string) {
            ServerConnector serverConnector = ConnectorMap.get((ApplicationConnection)ContextMenuConnector.this.getConnection()).getConnector(string);
            if (serverConnector instanceof AbstractComponentConnector) {
                AbstractComponentConnector abstractComponentConnector = (AbstractComponentConnector)serverConnector;
                abstractComponentConnector.getWidget();
                ContextMenuConnector.this.widget.showContextMenu(abstractComponentConnector.getWidget());
            }
        }

        @Override
        public void hide() {
            ContextMenuConnector.this.widget.hide();
        }
    };

    protected void init() {
        this.widget = (ContextMenuWidget)((Object)GWT.create(ContextMenuWidget.class));
        this.contextMenuCloseHandlerRegistration = this.widget.addCloseHandler(this.contextMenuCloseHandler);
        this.registerRpc(ContextMenuClientRpc.class, this.serverToClientRPC);
    }

    public ContextMenuState getState() {
        return (ContextMenuState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.widget.clearItems();
        this.widget.setHideAutomatically(this.getState().isHideAutomatically());
        for (ContextMenuState.ContextMenuItemState contextMenuItemState : this.getState().getRootItems()) {
            this.widget.addRootMenuItem(contextMenuItemState, this);
        }
    }

    protected void extend(ServerConnector serverConnector) {
        this.extensionTarget = ((ComponentConnector)serverConnector).getWidget();
        this.widget.setExtensionTarget(this.extensionTarget);
        this.contextMenuHandlerRegistration = this.extensionTarget.addDomHandler((EventHandler)this.contextMenuHandler, ContextMenuEvent.getType());
    }

    public void onUnregister() {
        this.contextMenuCloseHandlerRegistration.removeHandler();
        this.contextMenuHandlerRegistration.removeHandler();
        this.widget.unregister();
        super.onUnregister();
    }
}

