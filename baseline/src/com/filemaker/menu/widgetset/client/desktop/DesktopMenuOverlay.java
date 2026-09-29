/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.MouseOverEvent
 *  com.google.gwt.event.dom.client.MouseOverHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client.desktop;

import com.filemaker.menu.widgetset.client.AbstractMenuOverlay;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.ItemWidget;
import com.filemaker.menu.widgetset.client.desktop.DesktopSubMenu;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEvent;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEventHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

public class DesktopMenuOverlay
extends AbstractMenuOverlay {
    private DesktopSubMenu subMenu;

    public DesktopMenuOverlay(EventBus eventBus) {
        super(eventBus);
        this.getEventBus().addHandler(ItemClickedEvent.TYPE, (EventHandler)new ItemClickedEventHandler(){

            @Override
            public void onItemClicked(ItemClickedEvent itemClickedEvent) {
                DesktopMenuOverlay.this.hide();
            }
        });
    }

    @Override
    public void setItems(List<Item> list) {
        this.panel.clear();
        for (final Item item : list) {
            if (!item.visible) continue;
            final ItemWidget itemWidget = new ItemWidget(this.getEventBus(), item);
            itemWidget.addDomHandler((EventHandler)new MouseOverHandler(){
                final /* synthetic */ DesktopMenuOverlay this$0;
                {
                    this.this$0 = desktopMenuOverlay;
                }

                public void onMouseOver(MouseOverEvent mouseOverEvent) {
                    if (this.this$0.subMenu == null) {
                        this.this$0.subMenu = new DesktopSubMenu(this.this$0.getEventBus());
                        this.this$0.subMenu.setOwner(this.this$0.getOwner());
                    }
                    if (this.this$0.subMenu.isShowing()) {
                        this.this$0.subMenu.hide();
                    }
                    if (!item.subItems.isEmpty() && item.enabled) {
                        this.this$0.subMenu.setItems(item.subItems);
                        this.this$0.subMenu.showRelativeTo(itemWidget);
                    }
                }
            }, MouseOverEvent.getType());
            this.panel.add((Widget)itemWidget);
        }
    }

    @Override
    public void hide() {
        super.hide();
        if (this.subMenu != null) {
            this.subMenu.hide();
        }
    }
}

