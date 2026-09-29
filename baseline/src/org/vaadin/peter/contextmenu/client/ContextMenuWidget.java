/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.Event$NativePreviewHandler
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.UIObject
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ServerConnector
 */
package org.vaadin.peter.contextmenu.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ServerConnector;
import java.util.Set;
import org.vaadin.peter.contextmenu.client.ContextMenuConnector;
import org.vaadin.peter.contextmenu.client.ContextMenuItemWidget;
import org.vaadin.peter.contextmenu.client.ContextMenuItemWidgetHandler;
import org.vaadin.peter.contextmenu.client.ContextMenuOverlay;
import org.vaadin.peter.contextmenu.client.ContextMenuState;

public class ContextMenuWidget
extends Widget {
    private final ContextMenuOverlay menuOverlay;
    private final Event.NativePreviewHandler nativeEventHandler = new Event.NativePreviewHandler(){

        public void onPreviewNativeEvent(Event.NativePreviewEvent nativePreviewEvent) {
            Event event;
            boolean bl;
            if (nativePreviewEvent.getNativeEvent().getKeyCode() == 27) {
                ContextMenuWidget.this.hide();
            }
            if (!(bl = ContextMenuWidget.this.eventTargetContextMenu(event = Event.as((NativeEvent)nativePreviewEvent.getNativeEvent())))) {
                int n = event.getTypeInt();
                switch (n) {
                    case 4: {
                        if (!ContextMenuWidget.this.isHideAutomatically()) break;
                        ContextMenuWidget.this.hide();
                    }
                }
            }
        }
    };
    private final HandlerRegistration nativeEventHandlerRegistration;
    private boolean hideAutomatically;
    private Widget extensionTarget;

    public ContextMenuWidget() {
        Element element = DOM.createDiv();
        this.setElement((com.google.gwt.dom.client.Element)element);
        this.nativeEventHandlerRegistration = Event.addNativePreviewHandler((Event.NativePreviewHandler)this.nativeEventHandler);
        this.menuOverlay = new ContextMenuOverlay();
    }

    protected boolean eventTargetContextMenu(Event event) {
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuOverlay.getMenuItems()) {
            if (!contextMenuItemWidget.eventTargetsPopup(event)) continue;
            return true;
        }
        return false;
    }

    protected boolean isShowing() {
        return this.menuOverlay.isShowing();
    }

    public void hide() {
        this.menuOverlay.hide();
    }

    public void addRootMenuItem(ContextMenuState.ContextMenuItemState contextMenuItemState, ContextMenuConnector contextMenuConnector) {
        ContextMenuItemWidget contextMenuItemWidget = this.createEmptyItemWidget(contextMenuItemState.id, contextMenuItemState.caption, contextMenuConnector);
        contextMenuItemWidget.setEnabled(contextMenuItemState.enabled);
        contextMenuItemWidget.setSeparatorVisible(contextMenuItemState.separator);
        this.setStyleNames(contextMenuItemWidget, contextMenuItemState.getStyles());
        this.menuOverlay.addMenuItem(contextMenuItemWidget);
        for (ContextMenuState.ContextMenuItemState contextMenuItemState2 : contextMenuItemState.getChildren()) {
            this.createSubMenu(contextMenuItemWidget, contextMenuItemState2, contextMenuConnector);
        }
    }

    private void setStyleNames(ContextMenuItemWidget contextMenuItemWidget, Set<String> set) {
        for (String string : set) {
            contextMenuItemWidget.addStyleName(string);
        }
    }

    private ContextMenuItemWidget createEmptyItemWidget(String string, String string2, ContextMenuConnector contextMenuConnector) {
        ContextMenuItemWidget contextMenuItemWidget = (ContextMenuItemWidget)((Object)GWT.create(ContextMenuItemWidget.class));
        contextMenuItemWidget.setId(string);
        contextMenuItemWidget.setCaption(string2);
        contextMenuItemWidget.setIcon(contextMenuConnector.getConnection().getIcon(contextMenuConnector.getResourceUrl(string)));
        ContextMenuItemWidgetHandler contextMenuItemWidgetHandler = new ContextMenuItemWidgetHandler(contextMenuItemWidget, (ServerConnector)contextMenuConnector);
        contextMenuItemWidget.addClickHandler(contextMenuItemWidgetHandler);
        contextMenuItemWidget.addMouseOutHandler(contextMenuItemWidgetHandler);
        contextMenuItemWidget.addMouseOverHandler(contextMenuItemWidgetHandler);
        contextMenuItemWidget.addKeyUpHandler(contextMenuItemWidgetHandler);
        contextMenuItemWidget.setRootComponent(this);
        return contextMenuItemWidget;
    }

    private void createSubMenu(ContextMenuItemWidget contextMenuItemWidget, ContextMenuState.ContextMenuItemState contextMenuItemState, ContextMenuConnector contextMenuConnector) {
        ContextMenuItemWidget contextMenuItemWidget2 = this.createEmptyItemWidget(contextMenuItemState.id, contextMenuItemState.caption, contextMenuConnector);
        contextMenuItemWidget2.setEnabled(contextMenuItemState.enabled);
        contextMenuItemWidget2.setSeparatorVisible(contextMenuItemState.separator);
        this.setStyleNames(contextMenuItemWidget2, contextMenuItemState.getStyles());
        contextMenuItemWidget.addSubMenuItem(contextMenuItemWidget2);
        for (ContextMenuState.ContextMenuItemState contextMenuItemState2 : contextMenuItemState.getChildren()) {
            this.createSubMenu(contextMenuItemWidget2, contextMenuItemState2, contextMenuConnector);
        }
    }

    public void clearItems() {
        this.menuOverlay.clearItems();
    }

    public void showContextMenu(int n, int n2) {
        this.menuOverlay.showAt(n, n2);
    }

    public void showContextMenu(Widget widget) {
        this.menuOverlay.showRelativeTo((UIObject)widget);
    }

    public HandlerRegistration addCloseHandler(CloseHandler<PopupPanel> closeHandler) {
        return this.menuOverlay.addCloseHandler(closeHandler);
    }

    public void setHideAutomatically(boolean bl) {
        this.hideAutomatically = bl;
    }

    public boolean isHideAutomatically() {
        return this.hideAutomatically;
    }

    public void unregister() {
        this.nativeEventHandlerRegistration.removeHandler();
        this.menuOverlay.unregister();
    }

    public void setExtensionTarget(Widget widget) {
        this.extensionTarget = widget;
        this.menuOverlay.setOwner(widget);
    }

    public Widget getExtensionTarget() {
        return this.extensionTarget;
    }
}

