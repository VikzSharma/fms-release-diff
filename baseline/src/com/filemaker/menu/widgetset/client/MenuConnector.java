/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.vaadin.client.ComponentConnector
 *  com.vaadin.client.ConnectorHierarchyChangeEvent
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.AbstractSingleComponentContainerConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.menu.Menu;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.MenuWidget;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEvent;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEventHandler;
import com.filemaker.menu.widgetset.shared.MenuClientRpc;
import com.filemaker.menu.widgetset.shared.MenuServerRpc;
import com.filemaker.menu.widgetset.shared.MenuState;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import com.vaadin.shared.ui.Connect;
import java.util.List;

@Connect(value=Menu.class)
public class MenuConnector
extends AbstractSingleComponentContainerConnector {
    private MenuServerRpc menuServerRpc = (MenuServerRpc)RpcProxy.create(MenuServerRpc.class, (ServerConnector)this);

    protected void init() {
        super.init();
        EventBus eventBus = this.getWidget().getEventBus();
        eventBus.addHandler(ItemClickedEvent.TYPE, (EventHandler)new ItemClickedEventHandler(){

            @Override
            public void onItemClicked(ItemClickedEvent itemClickedEvent) {
                MenuConnector.this.menuServerRpc.menuItemClicked(itemClickedEvent.getItem().id);
            }
        });
        this.registerRpc(MenuClientRpc.class, new MenuClientRpc(){

            @Override
            public void closeMenu() {
                MenuConnector.this.getWidget().closePopup();
            }
        });
    }

    protected MenuWidget createWidget() {
        return (MenuWidget)((Object)GWT.create(MenuWidget.class));
    }

    public MenuWidget getWidget() {
        return (MenuWidget)super.getWidget();
    }

    public MenuState getState() {
        return (MenuState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (stateChangeEvent.hasPropertyChanged("items")) {
            this.resolveIconUrls(this.getState().items);
            this.getWidget().setItems(this.getState().items);
        }
        this.getWidget().getElement().setAttribute("aria-label", this.getState().description);
        this.getWidget().getElement().setAttribute("role", "button");
    }

    private void resolveIconUrls(List<Item> list) {
        for (Item item : list) {
            item.iconURL = this.getResourceUrl("" + item.id);
            this.resolveIconUrls(item.subItems);
        }
    }

    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        if (this.getContent() != null) {
            this.getWidget().setLogoutWidget(this.getContent().getWidget());
        } else {
            this.getWidget().setLogoutWidget(null);
        }
    }

    public void updateCaption(ComponentConnector componentConnector) {
    }
}

