/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.HasMultiNavigableItems;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VCssLayout;

public class VCustomToolbarPopoverLayout
extends VCssLayout {
    private Widget closeButton;

    public void setFocusToFirstElement() {
        Widget widget = this.getFocusableWidget(0);
        if (widget != null) {
            if (widget instanceof HasMultiNavigableItems) {
                ((HasMultiNavigableItems)widget).setFocus(false);
            } else {
                widget.getElement().focus();
            }
        }
    }

    public void setFocusToCloseButton() {
        if (this.closeButton != null) {
            this.closeButton.getElement().focus();
        }
    }

    public void onLoad() {
        super.onLoad();
        this.getElement().setAttribute("role", "menu");
    }

    public void add(final Widget widget) {
        super.add(widget);
        if (FMCUtilities.useAriaCompliantControl()) {
            final int n = this.getWidgetCount() - 1;
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
                final /* synthetic */ VCustomToolbarPopoverLayout this$0;
                {
                    this.this$0 = vCustomToolbarPopoverLayout;
                }

                public void execute() {
                    this.this$0.initNavigationControl(n, widget);
                }
            });
        }
    }

    private void initNavigationControl(int n, Widget widget) {
        if (n == 0) {
            this.initFirstElement();
        } else if (widget.getStyleName().contains("popover-closer")) {
            this.initCloseButton(n, widget);
        } else {
            this.initMenuItem(n, widget);
        }
    }

    private void initFirstElement() {
        Widget widget = this.getFocusableWidget(0);
        if (widget != null) {
            if (widget instanceof HasMultiNavigableItems) {
                HasMultiNavigableItems hasMultiNavigableItems = (HasMultiNavigableItems)widget;
                hasMultiNavigableItems.setPrev(this.getWidget(this.getWidgetCount() - 1));
                for (int i = 1; i < this.getWidgetCount() - 1; ++i) {
                    Widget widget2 = this.getWidget(i);
                    if (widget2.getStyleName().contains("v-disabled")) continue;
                    hasMultiNavigableItems.setNext(widget2);
                    break;
                }
            } else {
                widget.addDomHandler((EventHandler)new KeyDownHandler(){

                    public void onKeyDown(KeyDownEvent keyDownEvent) {
                        switch (keyDownEvent.getNativeKeyCode()) {
                            case 9: {
                                if (!keyDownEvent.isShiftKeyDown()) break;
                                keyDownEvent.preventDefault();
                                keyDownEvent.stopPropagation();
                                VCustomToolbarPopoverLayout.this.setFocusToCloseButton();
                                break;
                            }
                            case 37: 
                            case 38: {
                                VCustomToolbarPopoverLayout.this.setFocusToCloseButton();
                                break;
                            }
                            case 39: 
                            case 40: {
                                VCustomToolbarPopoverLayout.this.navigateDown(0);
                                break;
                            }
                        }
                    }
                }, KeyDownEvent.getType());
            }
        }
    }

    private void initCloseButton(final int n, Widget widget) {
        widget.addDomHandler((EventHandler)new KeyDownHandler(){
            final /* synthetic */ VCustomToolbarPopoverLayout this$0;
            {
                this.this$0 = vCustomToolbarPopoverLayout;
            }

            public void onKeyDown(KeyDownEvent keyDownEvent) {
                switch (keyDownEvent.getNativeKeyCode()) {
                    case 9: {
                        if (keyDownEvent.isShiftKeyDown()) break;
                        keyDownEvent.preventDefault();
                        keyDownEvent.stopPropagation();
                        this.this$0.setFocusToFirstElement();
                        break;
                    }
                    case 37: 
                    case 38: {
                        this.this$0.navigateUp(n);
                        break;
                    }
                    case 39: 
                    case 40: {
                        this.this$0.setFocusToFirstElement();
                        break;
                    }
                }
            }
        }, KeyDownEvent.getType());
        this.closeButton = widget;
    }

    private void initMenuItem(final int n, Widget widget) {
        widget.addDomHandler((EventHandler)new KeyDownHandler(){
            final /* synthetic */ VCustomToolbarPopoverLayout this$0;
            {
                this.this$0 = vCustomToolbarPopoverLayout;
            }

            public void onKeyDown(KeyDownEvent keyDownEvent) {
                switch (keyDownEvent.getNativeKeyCode()) {
                    case 37: 
                    case 38: {
                        this.this$0.navigateUp(n);
                        break;
                    }
                    case 39: 
                    case 40: {
                        this.this$0.navigateDown(n);
                        break;
                    }
                }
            }
        }, KeyDownEvent.getType());
    }

    public void setFocusToParent() {
        Element element;
        String string;
        Element element2 = FMCUtilities.getClosestElement((Element)this.getElement(), ".fm-toolbar-popover");
        if (element2 != null && !(string = this.getParentId(element2.getId())).isEmpty() && (element = FMCUtilities.getElementById(string)) != null) {
            element.focus();
        }
    }

    private String getPopoverId() {
        String string = "";
        Element element = FMCUtilities.getClosestElement((Element)this.getElement(), ".fm-toolbar-popover");
        if (element != null) {
            string = element.getId();
        }
        return string;
    }

    private Widget getFocusableWidget(int n) {
        switch (this.getPopoverId()) {
            case "b0foundsetpopover": {
                if (n == 0) {
                    return FMCUtilities.getWidget(FMCUtilities.querySelector(null, ".records-piecharter button"));
                }
                if (n == 1) {
                    return FMCUtilities.getWidget(FMCUtilities.querySelector(null, ".toolbar-slider .toolbar-slider-bar"));
                }
            }
            case "f0findoperatormenu": {
                if (n == 0) {
                    return FMCUtilities.getWidget(FMCUtilities.querySelector(null, ".findrequest-operator-1"));
                }
            }
            case "f0findactionslargepopover": {
                if (n == 0) {
                    return FMCUtilities.getWidget(FMCUtilities.querySelector(null, ".findset-constrainer"));
                }
            }
            case "b0recordmenu": {
                if (n != 0) break;
                for (int i = 0; i < this.getWidgetCount(); ++i) {
                    Widget widget = this.getWidget(i);
                    if (widget.getElement().getTabIndex() == -1) continue;
                    return widget;
                }
                break;
            }
        }
        return super.getWidget(n);
    }

    private String getParentId(String string) {
        switch (string) {
            case "b0foundsetpopover": {
                return "foundsetpiechart";
            }
            case "b0finderpopover": {
                return "findmenu";
            }
            case "f0findrequestsetpopover": {
                return "findrequests-settings";
            }
            case "f0findoperatormenu": {
                return "findoperatormenubutton";
            }
            case "f0findactionslargepopover": 
            case "f0findactionssmallpopover": {
                return "show-actions";
            }
            case "b0recordmenu": {
                return "recordmenu";
            }
        }
        return "";
    }

    private void navigateUp(int n) {
        for (int i = n - 1; i >= 0; --i) {
            Widget widget = this.getWidget(i);
            if (widget.getStyleName().contains("v-disabled")) continue;
            this.navigateTo(n, i);
            break;
        }
    }

    private void navigateDown(int n) {
        for (int i = n + 1; i < this.getWidgetCount(); ++i) {
            Widget widget = this.getWidget(i);
            if (widget.getStyleName().contains("v-disabled")) continue;
            this.navigateTo(n, i);
            break;
        }
    }

    private void navigateTo(int n, int n2) {
        Widget widget;
        if (n2 == 0 && (widget = this.getFocusableWidget(0)) != null && widget instanceof HasMultiNavigableItems) {
            HasMultiNavigableItems hasMultiNavigableItems = (HasMultiNavigableItems)widget;
            hasMultiNavigableItems.setFocus(n > n2);
            return;
        }
        if (n2 < 0) {
            this.setFocusToCloseButton();
        } else if (n2 >= this.getWidgetCount()) {
            this.setFocusToFirstElement();
        } else {
            this.getFocusableWidget(n2).getElement().focus();
        }
    }
}

