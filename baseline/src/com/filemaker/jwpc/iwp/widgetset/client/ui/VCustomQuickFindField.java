/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.TouchStartEvent
 *  com.google.gwt.event.dom.client.TouchStartHandler
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.menubar.MenuItem
 *  com.vaadin.v7.client.ui.VFilterSelect
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.QuickFindFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.PopupPanel;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.menubar.MenuItem;
import com.vaadin.v7.client.ui.VFilterSelect;

public class VCustomQuickFindField
extends VFilterSelect {
    boolean skipBlur = false;
    private QuickFindFieldServerRpc rpc;
    private FMCInputUtilities.InputPreviewHandler handler;
    private MenuItem lastTracked;

    public VCustomQuickFindField() {
        if (BrowserInfo.get().isIOS()) {
            this.suggestionPopup.menu.addDomHandler((EventHandler)new TouchStartHandler(){

                public void onTouchStart(TouchStartEvent touchStartEvent) {
                    VCustomQuickFindField.this.skipBlur = true;
                }
            }, TouchStartEvent.getType());
        }
        this.suggestionPopup.addHandler((EventHandler)new CloseHandler<PopupPanel>(){

            public void onClose(CloseEvent<PopupPanel> closeEvent) {
                if (VCustomQuickFindField.this.getElement().getAttribute("aria-expanded").equals("true")) {
                    VCustomQuickFindField.this.getElement().setAttribute("aria-expanded", "false");
                }
            }
        }, CloseEvent.getType());
        this.tb.getElement().setId("quickfind-textbox");
        this.getElement().setAttribute("aria-controls", "quickfind-textbox");
        this.getElement().setAttribute("aria-haspopup", "listbox");
        this.getElement().setAttribute("aria-expanded", "false");
        this.handler = new FMCInputUtilities.InputPreviewHandler(){

            @Override
            public void onPreviewInputEvent(Event.NativePreviewEvent nativePreviewEvent) {
                VCustomQuickFindField.this.processPreviewInputEvent(nativePreviewEvent);
            }
        };
        if (FMCUtilities.useAriaCompliantControl()) {
            com.google.gwt.user.client.Element element = this.getSubPartElement("button");
            if (element != null) {
                element.setTabIndex(-1);
            }
            this.suggestionPopup.addAttachHandler(attachEvent -> {
                if (attachEvent.isAttached()) {
                    this.startTracking();
                }
            });
        }
    }

    public void onAttach() {
        super.onAttach();
        FMCInputUtilities.addHandler(this.handler);
    }

    public void onDetach() {
        super.onDetach();
        FMCInputUtilities.removeHandler(this.handler);
    }

    public void onFocus(FocusEvent focusEvent) {
        super.onFocus(focusEvent);
        this.rpc.onFocus();
    }

    public void onBlur(BlurEvent blurEvent) {
        if (!FMCUtilities.hasFocus((Element)this.tb.getElement())) {
            if (BrowserInfo.get().isIOS() && this.skipBlur) {
                this.skipBlur = false;
            } else {
                super.onBlur(blurEvent);
            }
        }
    }

    public void setDescription(String string) {
        this.tb.getElement().setAttribute("aria-label", string);
    }

    public void onClick(ClickEvent clickEvent) {
        super.onClick(clickEvent);
        if (this.popupOpenerClicked && !this.getElement().getAttribute("aria-expanded").equals("true")) {
            this.getElement().setAttribute("aria-expanded", "true");
        }
    }

    private void startTracking() {
        Scheduler.get().scheduleFixedDelay(() -> {
            if (!this.suggestionPopup.isAttached() || !this.suggestionPopup.isShowing()) {
                return false;
            }
            MenuItem menuItem = this.suggestionPopup.menu.getSelectedItem();
            if (menuItem != this.lastTracked && menuItem != null) {
                this.lastTracked = menuItem;
                this.syncAria(menuItem);
            }
            return true;
        }, 50);
    }

    private void syncAria(MenuItem menuItem) {
        com.google.gwt.user.client.Element element = menuItem.getElement();
        if (element.getId() == null || element.getId().isEmpty()) {
            element.setId(DOM.createUniqueId());
        }
        this.tb.getElement().setAttribute("aria-activedescendant", element.getId());
    }

    public void registerServerRpc(QuickFindFieldServerRpc quickFindFieldServerRpc) {
        this.rpc = quickFindFieldServerRpc;
    }

    protected void processPreviewInputEvent(Event.NativePreviewEvent nativePreviewEvent) {
        if (FMCInputUtilities.isKeyboardTab() && Element.as((JavaScriptObject)nativePreviewEvent.getNativeEvent().getEventTarget()).equals((Object)this.getSubPartElement("textbox")) && this.rpc != null) {
            this.rpc.onTabToExit();
        }
        if (FMCInputUtilities.isKeyboardEnter() && Element.as((JavaScriptObject)nativePreviewEvent.getNativeEvent().getEventTarget()).equals((Object)this.getSubPartElement("textbox")) && this.rpc != null) {
            this.rpc.onEnter(this.tb.getText());
        }
    }
}

