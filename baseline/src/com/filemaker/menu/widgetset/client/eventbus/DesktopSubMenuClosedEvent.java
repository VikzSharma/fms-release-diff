/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package com.filemaker.menu.widgetset.client.eventbus;

import com.filemaker.menu.widgetset.client.desktop.DesktopSubMenu;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuClosedEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DesktopSubMenuClosedEvent
extends GwtEvent<DesktopSubMenuClosedEventHandler> {
    public static final GwtEvent.Type<DesktopSubMenuClosedEventHandler> TYPE = new GwtEvent.Type();
    private final DesktopSubMenu subMenu;

    public DesktopSubMenuClosedEvent(DesktopSubMenu desktopSubMenu) {
        this.subMenu = desktopSubMenu;
    }

    public GwtEvent.Type<DesktopSubMenuClosedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DesktopSubMenuClosedEventHandler desktopSubMenuClosedEventHandler) {
        desktopSubMenuClosedEventHandler.desktopSubMenuClosed(this);
    }

    public DesktopSubMenu getDesktopSubMenu() {
        return this.subMenu;
    }
}

