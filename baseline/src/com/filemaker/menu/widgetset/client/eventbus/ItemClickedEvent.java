/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package com.filemaker.menu.widgetset.client.eventbus;

import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ItemClickedEvent
extends GwtEvent<ItemClickedEventHandler> {
    public static final GwtEvent.Type<ItemClickedEventHandler> TYPE = new GwtEvent.Type();
    private final Item item;

    public ItemClickedEvent(Item item) {
        this.item = item;
    }

    public GwtEvent.Type<ItemClickedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ItemClickedEventHandler itemClickedEventHandler) {
        itemClickedEventHandler.onItemClicked(this);
    }

    public Item getItem() {
        return this.item;
    }
}

