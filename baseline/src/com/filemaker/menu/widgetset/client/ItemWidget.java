/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ItemWidget
extends FlowPanel {
    private static String ITEM = "fm-item";
    private static String HAS_SUB_ITEMS = "fm-has-sub-items";
    private static String WRAPPER = "fm-item-wrapper";
    private static String CAPTION = "fm-caption";
    private FlowPanel wrapper;
    private Label captionlabel;
    private Item widgetItem;

    public ItemWidget(final EventBus eventBus, final Item item) {
        this(item.text);
        if (item.styleName != null) {
            this.addStyleName(item.styleName);
        }
        this.setChecked(item.checked);
        this.setEnabled(item.enabled);
        this.setHasSubItems(!item.subItems.isEmpty());
        Label label = new Label();
        label.setStyleName("fm-icon");
        this.wrapper.add((Widget)label);
        if (item.iconURL != null) {
            label.getElement().getStyle().setBackgroundImage("url(" + item.iconURL + ")");
        }
        if (item.enabled) {
            this.addClickHandler(new ClickHandler(){

                public void onClick(ClickEvent clickEvent) {
                    eventBus.fireEvent((GwtEvent)new ItemClickedEvent(item));
                }
            });
            if (FMCUtilities.useAriaCompliantControl()) {
                this.addDomHandler((EventHandler)new KeyPressHandler(){

                    public void onKeyPress(KeyPressEvent keyPressEvent) {
                        switch (keyPressEvent.getCharCode()) {
                            case '\r': 
                            case ' ': {
                                eventBus.fireEvent((GwtEvent)new ItemClickedEvent(item));
                                break;
                            }
                        }
                    }
                }, KeyPressEvent.getType());
            }
        }
        this.widgetItem = item;
    }

    public ItemWidget(String string) {
        this.addWrapperAndCaption(string);
    }

    private void addWrapperAndCaption(String string) {
        this.setStyleName(ITEM);
        this.getElement().setAttribute("aria-label", string);
        this.wrapper = new FlowPanel();
        this.wrapper.setStyleName(WRAPPER);
        this.add((Widget)this.wrapper);
        this.captionlabel = new Label(string);
        this.captionlabel.setStyleName(CAPTION);
        this.wrapper.add((Widget)this.captionlabel);
    }

    private void setEnabled(boolean bl) {
        if (bl) {
            this.removeStyleName("fm-disabled");
        } else {
            this.addStyleName("fm-disabled");
        }
    }

    private void setChecked(boolean bl) {
        if (bl) {
            this.addStyleName("fm-checked");
        } else {
            this.removeStyleName("fm-checked");
        }
    }

    private void setHasSubItems(boolean bl) {
        if (bl) {
            this.addStyleName(HAS_SUB_ITEMS);
            this.getElement().setAttribute("role", "menu");
        } else {
            this.removeStyleName(HAS_SUB_ITEMS);
            this.getElement().setAttribute("role", "menuitem");
        }
    }

    public HandlerRegistration addClickHandler(ClickHandler clickHandler) {
        return this.addDomHandler((EventHandler)clickHandler, ClickEvent.getType());
    }

    public void setCaption(String string) {
        this.captionlabel.setText(string);
    }

    public Item getWidgetItem() {
        return this.widgetItem;
    }
}

