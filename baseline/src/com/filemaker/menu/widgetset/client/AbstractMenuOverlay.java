/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Event$NativePreviewHandler
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.Button
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.PopupPanel$PositionCallback
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VOverlay
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.menu.widgetset.client.EscKeyNativePreviewHandler;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.client.OverlayCloseNativePreviewHandler;
import com.filemaker.menu.widgetset.client.desktop.UserInfoWidget;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VOverlay;
import java.util.List;

public abstract class AbstractMenuOverlay
extends VOverlay {
    public static final String CLASSNAME = "fm-menu-overlay";
    public static final String CLOSE_BUTTON = "fm-close-button";
    private final EventBus eventBus;
    protected FlowPanel wrapper;
    protected FlowPanel panel;
    protected UserInfoWidget userInfoWidget;
    protected Button closeButton;
    private HandlerRegistration overlayCloseHandlerRegistration;
    private HandlerRegistration escHandlerRegistration;
    private String backItemText;

    public AbstractMenuOverlay(EventBus eventBus) {
        this.eventBus = eventBus;
        this.setStyleName(CLASSNAME);
        this.wrapper = new FlowPanel();
        this.userInfoWidget = new UserInfoWidget(eventBus);
        this.wrapper.add((Widget)this.userInfoWidget);
        this.panel = new FlowPanel();
        this.panel.setStyleName("fm-items");
        this.wrapper.add((Widget)this.panel);
        this.setWidget((Widget)this.wrapper);
        this.closeButton = new Button();
        this.closeButton.addClickHandler(new ClickHandler(){

            public void onClick(ClickEvent clickEvent) {
                AbstractMenuOverlay.this.hide();
            }
        });
        this.closeButton.setStyleName(CLOSE_BUTTON);
        this.wrapper.add((Widget)this.closeButton);
        if (FMCUtilities.useAriaCompliantControl()) {
            this.closeButton.getElement().setTabIndex(0);
            this.closeButton.addDomHandler((EventHandler)new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 9: {
                            if (keyDownEvent.isShiftKeyDown()) break;
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            AbstractMenuOverlay.this.setFocus();
                            break;
                        }
                        case 38: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            AbstractMenuOverlay.this.navigateUp();
                            break;
                        }
                        case 40: {
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            AbstractMenuOverlay.this.setFocus();
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    public void show(final int n, final int n2) {
        super.show();
        this.setPopupPositionAndShow(new PopupPanel.PositionCallback(){
            final /* synthetic */ AbstractMenuOverlay this$0;
            {
                this.this$0 = abstractMenuOverlay;
            }

            public void setPosition(int n3, int n22) {
                this.this$0.adjustHeight(n2);
                this.this$0.setPopupPosition(n, n2);
            }
        });
    }

    public abstract void setItems(List<Item> var1);

    public void adjustHeight(int n) {
        int n2 = Window.getClientHeight() + Window.getScrollTop();
        Style style = this.panel.getElement().getStyle();
        style.clearHeight();
        style.clearOverflowY();
        int n3 = n + this.getOffsetHeight() - n2;
        if (n3 > 0) {
            this.reduceHeight(n3);
        } else if (BrowserInfo.get().isIE() || BrowserInfo.get().isEdge()) {
            this.panel.addStyleName("ms-noscroll");
        }
    }

    protected void reduceHeight(int n) {
        int n2 = this.panel.getOffsetHeight() - n;
        this.panel.setHeight(n2 + "px");
    }

    public void hide() {
        Element element;
        if (FMCUtilities.useAriaCompliantControl() && FMCUtilities.isSafari() && (element = FMCUtilities.getActiveElement()) != null && this.getElement().isOrHasChild((Node)element)) {
            element.blur();
        }
        super.hide();
        element = this.panel.getElement().getStyle();
        element.clearHeight();
        element.clearOverflowY();
    }

    public void setLoggedInText(String string) {
        this.userInfoWidget.setLoggedInText(string);
    }

    public void setUserName(String string) {
        this.userInfoWidget.setUserName(string);
    }

    public void setLogoutWidget(Widget widget) {
        this.userInfoWidget.setLogoutButton(widget);
    }

    public void setUserInfoVisible(boolean bl) {
        this.userInfoWidget.setVisible(bl);
    }

    public String getBackItemText() {
        return this.backItemText;
    }

    public void setBackItemText(String string) {
        this.backItemText = string;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    protected void onAttach() {
        super.onAttach();
        this.overlayCloseHandlerRegistration = Event.addNativePreviewHandler((Event.NativePreviewHandler)new OverlayCloseNativePreviewHandler(this.eventBus, this.getOwner(), this));
        this.escHandlerRegistration = Event.addNativePreviewHandler((Event.NativePreviewHandler)new EscKeyNativePreviewHandler(this));
        if (FMCUtilities.useAriaCompliantControl()) {
            new Timer(){

                public void run() {
                    AbstractMenuOverlay.this.setFocus();
                }
            }.schedule(100);
        }
    }

    protected void onDetach() {
        super.onDetach();
        this.overlayCloseHandlerRegistration.removeHandler();
        this.overlayCloseHandlerRegistration = null;
        this.escHandlerRegistration.removeHandler();
        this.escHandlerRegistration = null;
    }

    protected void setFocus() {
    }

    protected void navigateUp() {
    }

    protected void setFocusToCloseButton() {
        this.closeButton.getElement().focus();
    }

    protected void setCloseButtonAriaLabel(String string) {
        this.closeButton.getElement().setAttribute("aria-label", string);
    }
}

