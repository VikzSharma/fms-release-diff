/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.SimpleEventBus
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Composite
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.menu.widgetset.client.AbstractMenuOverlay;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.desktop.DesktopMenuOverlay;
import com.filemaker.menu.widgetset.client.mobile.MobileMenuOverlay;
import com.filemaker.menu.widgetset.shared.DisplayMode;
import com.filemaker.menu.widgetset.shared.MenuState;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;

public class MenuWidget
extends Composite {
    private final EventBus eventBus = (EventBus)GWT.create(SimpleEventBus.class);
    private AbstractMenuOverlay popup;
    private ArrayList<Item> items;
    private String loggedInText;
    private DisplayMode displayMode;
    private String userName;
    private Widget logoutWidget;
    private String backItemText;
    private String closeButtonAriaLabel;
    private int mnbs = 0;

    public MenuWidget() {
        Label label = new Label();
        label.addClickHandler(new ClickHandler(){

            public void onClick(ClickEvent clickEvent) {
                MenuWidget.this.togglePopup();
            }
        });
        this.initWidget((Widget)label);
        this.setStyleName("fm-menu");
        if (FMCUtilities.useAriaCompliantControl()) {
            this.getElement().setTabIndex(0);
            DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80));
        }
    }

    public void setMnbs(int n) {
        this.mnbs = n;
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (MenuWidget.this.popup != null) {
                    MenuWidget.this.popup.setUserInfoVisible(MenuWidget.this.getBooleanState(MenuState.BooleanState.userInfoVisible));
                }
            }
        });
    }

    private boolean getBooleanState(MenuState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.mnbs, booleanState.ordinal());
    }

    private AbstractMenuOverlay createMenu(DisplayMode displayMode) {
        AbstractMenuOverlay abstractMenuOverlay = displayMode == DisplayMode.DESKTOP ? new DesktopMenuOverlay(this.eventBus) : new MobileMenuOverlay(this.eventBus);
        abstractMenuOverlay.addCloseHandler((CloseHandler)new CloseHandler<PopupPanel>(){

            public void onClose(CloseEvent<PopupPanel> closeEvent) {
                MenuWidget.this.removeStyleName("fm-popup-visible");
                FMCUtilities.enableTouchScroll(true);
                MenuWidget.this.getElement().focus();
            }
        });
        abstractMenuOverlay.setOwner((Widget)this);
        abstractMenuOverlay.setItems(this.items);
        abstractMenuOverlay.setLoggedInText(this.loggedInText);
        abstractMenuOverlay.setUserName(this.userName);
        abstractMenuOverlay.setUserInfoVisible(this.getBooleanState(MenuState.BooleanState.userInfoVisible));
        abstractMenuOverlay.setBackItemText(this.backItemText);
        abstractMenuOverlay.setLogoutWidget(this.logoutWidget);
        abstractMenuOverlay.setCloseButtonAriaLabel(this.closeButtonAriaLabel);
        return abstractMenuOverlay;
    }

    private void ensurePopup() {
        if (this.popup == null) {
            this.popup = this.createMenu(this.displayMode);
        }
    }

    private void showPopup() {
        FMCUtilities.enableTouchScroll(false);
        this.ensurePopup();
        int n = this.getAbsoluteLeft();
        int n2 = this.getAbsoluteTop() + this.getOffsetHeight();
        this.popup.show(n, n2);
        this.addStyleName("fm-popup-visible");
    }

    public void closePopup() {
        if (this.popup != null) {
            this.popup.hide();
        }
    }

    protected void onDetach() {
        super.onDetach();
        if (this.popup != null) {
            this.popup.hide();
        }
    }

    public void setItems(ArrayList<Item> arrayList) {
        this.items = arrayList;
        if (this.popup != null) {
            this.popup.setItems(arrayList);
        }
    }

    public void setLoggedInText(String string) {
        this.loggedInText = string;
        if (this.popup != null) {
            this.popup.setLoggedInText(string);
        }
    }

    public void setUserName(String string) {
        this.userName = string;
        if (this.popup != null) {
            this.popup.setUserName(string);
        }
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
        this.popup = null;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public void setLogoutWidget(Widget widget) {
        this.logoutWidget = widget;
        if (this.popup != null) {
            this.popup.setLogoutWidget(widget);
        }
    }

    public void setBackItemText(String string) {
        this.backItemText = string;
        if (this.popup != null) {
            this.popup.setBackItemText(string);
        }
    }

    public void setCloseButtonAriaLabel(String string) {
        this.closeButtonAriaLabel = string;
        if (this.popup != null) {
            this.popup.setCloseButtonAriaLabel(string);
        }
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        block0 : switch (DOM.eventGetType((Event)event)) {
            case 128: {
                switch (event.getKeyCode()) {
                    case 13: 
                    case 32: {
                        this.togglePopup();
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private void togglePopup() {
        if (this.popup != null && this.popup.isShowing()) {
            this.popup.hide();
        } else {
            this.showPopup();
        }
    }
}

