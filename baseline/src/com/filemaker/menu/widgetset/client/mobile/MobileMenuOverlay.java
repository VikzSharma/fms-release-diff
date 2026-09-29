/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Style
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client.mobile;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.menu.widgetset.client.AbstractMenuOverlay;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.ItemWidget;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEvent;
import com.filemaker.menu.widgetset.client.eventbus.ItemClickedEventHandler;
import com.filemaker.menu.widgetset.client.mobile.MobileSubMenu;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

public class MobileMenuOverlay
extends AbstractMenuOverlay
implements MobileSubMenu.NavigateBackHandler,
MobileSubMenu.SetFocusToCloseButtonHandler {
    private FlowPanel itemsPanel = new FlowPanel();
    private int level = 0;
    private int mainPanelNormalHeight = 0;

    public MobileMenuOverlay(EventBus eventBus) {
        super(eventBus);
        this.addStyleName("fm-mobile");
        this.panel.add((Widget)this.itemsPanel);
        this.getEventBus().addHandler(ItemClickedEvent.TYPE, (EventHandler)new ItemClickedEventHandler(){

            @Override
            public void onItemClicked(ItemClickedEvent itemClickedEvent) {
                if (itemClickedEvent.getItem().subItems.isEmpty()) {
                    MobileMenuOverlay.this.hide();
                }
            }
        });
    }

    @Override
    public void setItems(List<Item> list) {
        this.itemsPanel.clear();
        for (final Item item : list) {
            if (!item.visible) continue;
            final ItemWidget itemWidget = new ItemWidget(this.getEventBus(), item);
            if (!item.subItems.isEmpty() && item.enabled) {
                itemWidget.addDomHandler((EventHandler)new ClickHandler(){
                    final /* synthetic */ MobileMenuOverlay this$0;
                    {
                        this.this$0 = mobileMenuOverlay;
                    }

                    public void onClick(ClickEvent clickEvent) {
                        this.this$0.openSubMenu(item);
                    }
                }, ClickEvent.getType());
            }
            this.itemsPanel.add((Widget)itemWidget);
            if (!FMCUtilities.useAriaCompliantControl() || !item.enabled) continue;
            itemWidget.getElement().setTabIndex(0);
            if (this.itemsPanel.getWidgetCount() == 1) {
                itemWidget.addDomHandler((EventHandler)new KeyDownHandler(){

                    public void onKeyDown(KeyDownEvent keyDownEvent) {
                        switch (keyDownEvent.getNativeKeyCode()) {
                            case 9: {
                                if (!keyDownEvent.isShiftKeyDown()) break;
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                MobileMenuOverlay.this.setFocusToCloseButton();
                                break;
                            }
                            case 38: {
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                MobileMenuOverlay.this.setFocusToCloseButton();
                                break;
                            }
                            case 40: {
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                Widget widget = MobileMenuOverlay.this.itemsPanel.getWidget(1);
                                widget.getElement().focus();
                                break;
                            }
                        }
                    }
                }, KeyDownEvent.getType());
            } else {
                itemWidget.addDomHandler((EventHandler)new KeyDownHandler(){
                    final /* synthetic */ MobileMenuOverlay this$0;
                    {
                        this.this$0 = mobileMenuOverlay;
                    }

                    public void onKeyDown(KeyDownEvent keyDownEvent) {
                        int n = this.this$0.itemsPanel.getWidgetIndex((Widget)itemWidget);
                        switch (keyDownEvent.getNativeKeyCode()) {
                            case 38: {
                                if (n <= 0) break;
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                int n2 = n - 1;
                                Widget widget = this.this$0.itemsPanel.getWidget(n2);
                                widget.getElement().focus();
                                break;
                            }
                            case 40: {
                                if (n < 0) {
                                    return;
                                }
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                if (n < this.this$0.itemsPanel.getWidgetCount() - 1) {
                                    Widget widget = this.this$0.itemsPanel.getWidget(n + 1);
                                    widget.getElement().focus();
                                    break;
                                }
                                this.this$0.setFocusToCloseButton();
                                break;
                            }
                        }
                    }
                }, KeyDownEvent.getType());
            }
            if (item.subItems.isEmpty()) continue;
            itemWidget.addDomHandler((EventHandler)new KeyPressHandler(){
                final /* synthetic */ MobileMenuOverlay this$0;
                {
                    this.this$0 = mobileMenuOverlay;
                }

                public void onKeyPress(KeyPressEvent keyPressEvent) {
                    switch (keyPressEvent.getCharCode()) {
                        case '\r': 
                        case ' ': {
                            this.this$0.openSubMenu(item);
                            break;
                        }
                    }
                }
            }, KeyPressEvent.getType());
            itemWidget.addDomHandler((EventHandler)new KeyDownHandler(){
                final /* synthetic */ MobileMenuOverlay this$0;
                {
                    this.this$0 = mobileMenuOverlay;
                }

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    if (keyDownEvent.getNativeKeyCode() == 39) {
                        keyDownEvent.preventDefault();
                        keyDownEvent.stopPropagation();
                        this.this$0.openSubMenu(item);
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    @Override
    public void navigateBack() {
        int n = this.level--;
        this.panel.getElement().getStyle().setMarginLeft((double)(this.level * -260), Style.Unit.PX);
        this.adjustHeight(this.getAbsoluteTop());
        if (FMCUtilities.useAriaCompliantControl()) {
            this.setNavigationBackFocus(n);
        }
        this.panel.remove(n);
    }

    @Override
    public void setFocusToCloseButton() {
        super.setFocusToCloseButton();
    }

    public void openSubMenu(Item item) {
        this.clearOldSubMenus();
        MobileSubMenu mobileSubMenu = new MobileSubMenu(this.getEventBus(), this, item, this, this);
        this.panel.add((Widget)mobileSubMenu);
        this.panel.getElement().getStyle().setMarginLeft((double)(++this.level * -260), Style.Unit.PX);
        this.adjustHeight(this.getAbsoluteTop());
    }

    @Override
    public void hide() {
        super.hide();
        Widget widget = this.panel.getWidget(0);
        this.panel.clear();
        this.panel.add(widget);
        this.panel.getElement().getStyle().clearMarginLeft();
        this.level = 0;
    }

    private void clearOldSubMenus() {
        while (this.level + 1 < this.panel.getWidgetCount()) {
            this.panel.remove(this.panel.getWidgetCount() - 1);
        }
    }

    @Override
    public void adjustHeight(int n) {
        int n2 = Window.getClientHeight() + Window.getScrollTop();
        Style style = this.panel.getElement().getStyle();
        style.clearHeight();
        style.clearOverflowY();
        Widget widget = this.panel.getWidget(this.level);
        widget.getElement().getStyle().clearHeight();
        int n3 = this.userInfoWidget.getOffsetHeight() + widget.getOffsetHeight() + this.closeButton.getOffsetHeight();
        int n4 = n + n3 - n2;
        if (n4 > 0) {
            this.reduceHeight(n4);
        } else {
            int n5 = widget.getOffsetHeight();
            if (this.level == 0 && this.mainPanelNormalHeight != 0) {
                n5 = this.mainPanelNormalHeight;
                widget.setHeight(n5 + "px");
                this.mainPanelNormalHeight = 0;
            }
            this.panel.setHeight(n5 + "px");
        }
    }

    @Override
    protected void reduceHeight(int n) {
        if (this.level == 0 && this.mainPanelNormalHeight == 0) {
            this.mainPanelNormalHeight = this.panel.getWidget(this.level).getOffsetHeight();
        }
        int n2 = this.panel.getWidget(this.level).getOffsetHeight() - n;
        this.panel.setHeight(n2 + "px");
        this.panel.getWidget(this.level).setHeight(n2 + "px");
    }

    @Override
    protected void setFocus() {
        int n = this.panel.getWidgetCount();
        if (n >= 1) {
            if (n == 1) {
                Widget widget = this.itemsPanel.getWidget(0);
                widget.getElement().focus();
            } else {
                Widget widget = this.panel.getWidget(n - 1);
                ((MobileSubMenu)widget).setFocus();
            }
        }
    }

    @Override
    protected void navigateUp() {
        int n = this.panel.getWidgetCount();
        if (n == 1) {
            for (int i = this.itemsPanel.getWidgetCount() - 1; i >= 0; --i) {
                Widget widget = this.itemsPanel.getWidget(i);
                if (widget.getElement().hasClassName("fm-disabled") || !widget.isAttached()) continue;
                widget.getElement().focus();
                return;
            }
        } else {
            Widget widget = this.panel.getWidget(n - 1);
            ((MobileSubMenu)widget).navigateUp(-1);
        }
    }

    private void setNavigationBackFocus(int n) {
        Widget widget = this.panel.getWidget(n);
        Item item = ((MobileSubMenu)widget).getMenuItem();
        if (n == 1) {
            for (int i = 0; i < this.itemsPanel.getWidgetCount(); ++i) {
                ItemWidget itemWidget = (ItemWidget)this.itemsPanel.getWidget(i);
                if (!item.equals(itemWidget.getWidgetItem())) continue;
                itemWidget.getElement().focus();
                break;
            }
        } else {
            MobileSubMenu mobileSubMenu = (MobileSubMenu)this.panel.getWidget(n - 1);
            for (int i = 0; i < mobileSubMenu.getWidgetCount(); ++i) {
                ItemWidget itemWidget = (ItemWidget)mobileSubMenu.getWidget(i);
                if (!item.equals(itemWidget.getWidgetItem())) continue;
                itemWidget.getElement().focus();
                break;
            }
        }
    }
}

