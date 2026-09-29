/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.Event$NativePreviewHandler
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.menu.widgetset.client.AbstractMenuOverlay;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuClosedEvent;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuClosedEventHandler;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuOpenedEvent;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuOpenedEventHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

public class OverlayCloseNativePreviewHandler
implements Event.NativePreviewHandler {
    private final AbstractMenuOverlay menuOverlay;
    private List<Element> elements = new ArrayList<Element>();

    public OverlayCloseNativePreviewHandler(EventBus eventBus, Widget widget, AbstractMenuOverlay abstractMenuOverlay) {
        this.menuOverlay = abstractMenuOverlay;
        this.elements.add((Element)widget.getElement());
        this.elements.add((Element)abstractMenuOverlay.getElement());
        eventBus.addHandler(DesktopSubMenuOpenedEvent.TYPE, (EventHandler)new DesktopSubMenuOpenedEventHandler(){

            @Override
            public void desktopSubMenuOpened(DesktopSubMenuOpenedEvent desktopSubMenuOpenedEvent) {
                OverlayCloseNativePreviewHandler.this.elements.add((Element)desktopSubMenuOpenedEvent.getDesktopSubMenu().getElement());
            }
        });
        eventBus.addHandler(DesktopSubMenuClosedEvent.TYPE, (EventHandler)new DesktopSubMenuClosedEventHandler(){

            @Override
            public void desktopSubMenuClosed(DesktopSubMenuClosedEvent desktopSubMenuClosedEvent) {
                OverlayCloseNativePreviewHandler.this.elements.remove(desktopSubMenuClosedEvent.getDesktopSubMenu().getElement());
            }
        });
    }

    public void onPreviewNativeEvent(Event.NativePreviewEvent nativePreviewEvent) {
        if (!this.menuOverlay.isShowing()) {
            return;
        }
        Element element = Element.as((JavaScriptObject)nativePreviewEvent.getNativeEvent().getEventTarget());
        if (nativePreviewEvent.getTypeInt() == 1 && !this.elementInListIsOrHasChild(element)) {
            this.menuOverlay.hide();
        }
    }

    private boolean elementInListIsOrHasChild(Element element) {
        for (Element element2 : this.elements) {
            if (!element2.isOrHasChild((Node)element)) continue;
            return true;
        }
        return false;
    }
}

