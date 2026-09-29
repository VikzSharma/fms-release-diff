/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.MouseOverEvent
 *  com.google.gwt.event.dom.client.MouseOverHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VOverlay
 */
package com.filemaker.menu.widgetset.client.desktop;

import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.ItemWidget;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuClosedEvent;
import com.filemaker.menu.widgetset.client.eventbus.DesktopSubMenuOpenedEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VOverlay;
import java.util.List;

public class DesktopSubMenu
extends VOverlay {
    private final FlowPanel panel;
    private final EventBus eventBus;
    private DesktopSubMenu subMenu = null;

    public DesktopSubMenu(EventBus eventBus) {
        this.eventBus = eventBus;
        this.setStyleName("fm-menu-overlay");
        this.addStyleName("fm-sub-menu");
        this.panel = new FlowPanel();
        this.setWidget((Widget)this.panel);
    }

    public void setItems(List<Item> list) {
        this.panel.clear();
        for (final Item item : list) {
            if (!item.visible) continue;
            final ItemWidget itemWidget = new ItemWidget(this.eventBus, item);
            itemWidget.addDomHandler((EventHandler)new MouseOverHandler(){
                final /* synthetic */ DesktopSubMenu this$0;
                {
                    this.this$0 = desktopSubMenu;
                }

                public void onMouseOver(MouseOverEvent mouseOverEvent) {
                    if (this.this$0.subMenu == null) {
                        this.this$0.subMenu = new DesktopSubMenu(this.this$0.eventBus);
                        this.this$0.subMenu.setOwner(this.this$0.getOwner());
                    }
                    this.this$0.subMenu.hide();
                    if (!item.subItems.isEmpty() && item.enabled) {
                        this.this$0.subMenu.setItems(item.subItems);
                        this.this$0.subMenu.showRelativeTo(itemWidget);
                    }
                }
            }, MouseOverEvent.getType());
            this.panel.add((Widget)itemWidget);
        }
    }

    public void showRelativeTo(ItemWidget itemWidget) {
        int n = itemWidget.getOffsetWidth() + itemWidget.getAbsoluteLeft();
        int n2 = itemWidget.getAbsoluteTop();
        this.setPopupPosition(n, n2);
        this.show();
    }

    public void show() {
        super.show();
        this.eventBus.fireEvent((GwtEvent)new DesktopSubMenuOpenedEvent(this));
    }

    public void hide() {
        super.hide();
        this.eventBus.fireEvent((GwtEvent)new DesktopSubMenuClosedEvent(this));
        if (this.subMenu != null) {
            this.subMenu.hide();
        }
    }
}

