/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client.mobile;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.ItemWidget;
import com.filemaker.menu.widgetset.client.mobile.MobileMenuOverlay;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class MobileSubMenu
extends FlowPanel {
    private Item menuItem;
    private ItemWidget back;

    public MobileSubMenu(EventBus eventBus, final MobileMenuOverlay mobileMenuOverlay, Item item, final NavigateBackHandler navigateBackHandler, final SetFocusToCloseButtonHandler setFocusToCloseButtonHandler) {
        this.menuItem = item;
        this.back = new ItemWidget(mobileMenuOverlay.getBackItemText());
        this.back.addStyleName("fm-back-item");
        this.back.getElement().setAttribute("role", "button");
        this.back.addClickHandler(new ClickHandler(){

            public void onClick(ClickEvent clickEvent) {
                navigateBackHandler.navigateBack();
            }
        });
        if (FMCUtilities.useAriaCompliantControl()) {
            this.back.getElement().setTabIndex(0);
            this.back.addDomHandler((EventHandler)new KeyPressHandler(){

                public void onKeyPress(KeyPressEvent keyPressEvent) {
                    switch (keyPressEvent.getCharCode()) {
                        case '\r': 
                        case ' ': {
                            navigateBackHandler.navigateBack();
                            break;
                        }
                    }
                }
            }, KeyPressEvent.getType());
            this.back.addDomHandler((EventHandler)new KeyDownHandler(){
                final /* synthetic */ MobileSubMenu this$0;
                {
                    this.this$0 = mobileSubMenu;
                }

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 9: {
                            if (!keyDownEvent.isShiftKeyDown()) break;
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            setFocusToCloseButtonHandler.setFocusToCloseButton();
                            break;
                        }
                        case 37: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            navigateBackHandler.navigateBack();
                            break;
                        }
                        case 38: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            setFocusToCloseButtonHandler.setFocusToCloseButton();
                            break;
                        }
                        case 40: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            this.this$0.navigateDown(0, setFocusToCloseButtonHandler);
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        }
        this.add((Widget)this.back);
        for (final Item item2 : item.subItems) {
            if (!item2.visible) continue;
            final ItemWidget itemWidget = new ItemWidget(eventBus, item2);
            if (!item2.subItems.isEmpty() && item2.enabled) {
                itemWidget.addClickHandler(new ClickHandler(){

                    public void onClick(ClickEvent clickEvent) {
                        mobileMenuOverlay.openSubMenu(item2);
                    }
                });
            }
            this.add((Widget)itemWidget);
            if (!FMCUtilities.useAriaCompliantControl() || !item2.enabled) continue;
            itemWidget.getElement().setTabIndex(0);
            if (!item2.subItems.isEmpty()) {
                itemWidget.addDomHandler((EventHandler)new KeyPressHandler(){

                    public void onKeyPress(KeyPressEvent keyPressEvent) {
                        switch (keyPressEvent.getCharCode()) {
                            case '\r': 
                            case ' ': {
                                mobileMenuOverlay.openSubMenu(item2);
                                break;
                            }
                        }
                    }
                }, KeyPressEvent.getType());
                itemWidget.addDomHandler((EventHandler)new KeyDownHandler(){

                    public void onKeyDown(KeyDownEvent keyDownEvent) {
                        if (keyDownEvent.getNativeKeyCode() == 39) {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            mobileMenuOverlay.openSubMenu(item2);
                        }
                    }
                }, KeyDownEvent.getType());
            }
            itemWidget.addDomHandler((EventHandler)new KeyDownHandler(){
                final /* synthetic */ MobileSubMenu this$0;
                {
                    this.this$0 = mobileSubMenu;
                }

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    int n = this.this$0.getWidgetIndex((Widget)itemWidget);
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 38: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            this.this$0.navigateUp(n);
                            break;
                        }
                        case 40: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            this.this$0.navigateDown(n, setFocusToCloseButtonHandler);
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    protected void onAttach() {
        super.onAttach();
        if (FMCUtilities.useAriaCompliantControl()) {
            new Timer(){

                public void run() {
                    MobileSubMenu.this.back.getElement().focus();
                }
            }.schedule(100);
        }
    }

    public void setFocus() {
        this.back.getElement().focus();
    }

    public void navigateDown(int n, SetFocusToCloseButtonHandler setFocusToCloseButtonHandler) {
        for (int i = n + 1; i <= this.getWidgetCount() - 1; ++i) {
            Widget widget = this.getWidget(i);
            if (widget.getElement().hasClassName("fm-disabled") || !widget.isAttached()) continue;
            widget.getElement().focus();
            return;
        }
        setFocusToCloseButtonHandler.setFocusToCloseButton();
    }

    public void navigateUp(int n) {
        int n2;
        for (int i = n2 = n == -1 ? this.getWidgetCount() - 1 : n - 1; i >= 0; --i) {
            Widget widget = this.getWidget(i);
            if (widget.getElement().hasClassName("fm-disabled") || !widget.isAttached()) continue;
            widget.getElement().focus();
            return;
        }
    }

    public Item getMenuItem() {
        return this.menuItem;
    }

    public static interface NavigateBackHandler {
        public void navigateBack();
    }

    public static interface SetFocusToCloseButtonHandler {
        public void setFocusToCloseButton();
    }
}

