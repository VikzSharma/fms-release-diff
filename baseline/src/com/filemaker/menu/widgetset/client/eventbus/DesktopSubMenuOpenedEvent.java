/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package com.filemaker.menu.widgetset.client.eventbus;

import com.filemaker.menu.widgetset.client.desktop.DesktopSubMenu;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuOpenedEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DesktopSubMenuOpenedEvent
extends GwtEvent<DesktopSubMenuOpenedEventHandler> {
    public static final GwtEvent.Type<DesktopSubMenuOpenedEventHandler> TYPE = new GwtEvent.Type();
    private final DesktopSubMenu subMenu;

    public DesktopSubMenuOpenedEvent(DesktopSubMenu desktopSubMenu) {
        this.subMenu = desktopSubMenu;
    }

    public GwtEvent.Type<DesktopSubMenuOpenedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DesktopSubMenuOpenedEventHandler desktopSubMenuOpenedEventHandler) {
        desktopSubMenuOpenedEventHandler.desktopSubMenuOpened(this);
    }

    public DesktopSubMenu getDesktopSubMenu() {
        return this.subMenu;
    }
}

