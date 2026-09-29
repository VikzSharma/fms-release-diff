/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;

public class MobileContentEditableDivTextBox
extends ContentEditableDivTextBox {
    private JavaScriptObject scrollIntoViewHandler = null;
    private boolean clickToFocus = false;
    private boolean shouldCheckNavigationFocus = false;

    public MobileContentEditableDivTextBox() {
        DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80000 | 0x80 | 0x100 | 0x200 | 0x100000));
        this.scrollIntoViewHandler = this.getScrollIntoViewHandler(this);
        if (BrowserInfo.get().isAndroid()) {
            this.attachResizeHandler(this.scrollIntoViewHandler);
        }
    }

    protected void onUnload() {
        super.onUnload();
        if (BrowserInfo.get().isAndroid()) {
            this.detachResizeHandler(this.scrollIntoViewHandler);
        }
    }

    private native JavaScriptObject getScrollIntoViewHandler(MobileContentEditableDivTextBox var1);

    private native void attachResizeHandler(JavaScriptObject var1);

    private native void detachResizeHandler(JavaScriptObject var1);

    private void onWindowResize() {
        ContentEditableDivTextBox contentEditableDivTextBox;
        if (this.communicationConnector != null && (contentEditableDivTextBox = this.communicationConnector.getTextBoxToScrollIntoView()) == this && !MobileContentEditableDivTextBox.isClickInView(this.communicationConnector.getPendingClickX(), this.communicationConnector.getPendingClickY())) {
            this.getElement().scrollIntoView();
        }
    }

    @Override
    protected void toggleContentEditableMode(boolean bl) {
        if (bl) {
            this.handleCursorPosition();
        }
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (BrowserInfo.get().isIOS()) {
            if (event.getTypeInt() == 2048) {
                this.shouldCheckNavigationFocus = true;
                this.connector.setPendingNavigationFocus();
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                    public void execute() {
                        if (MobileContentEditableDivTextBox.this.shouldCheckNavigationFocus) {
                            MobileContentEditableDivTextBox.this.connector.checkNavigationFocus();
                        }
                    }
                });
                if (this.clickToFocus && !FMCUtilities.getHasVirtualKeyboard()) {
                    FMCUtilities.setHasVirtualKeyboard(true);
                }
                this.clickToFocus = false;
            }
            if (event.getTypeInt() == 4096) {
                this.shouldCheckNavigationFocus = false;
                FMCUtilities.setHasVirtualKeyboard(false);
                this.clickToFocus = false;
            }
            if (event.getTypeInt() == 4) {
                this.clickToFocus = true;
            }
            if (event.getTypeInt() == 0x100000) {
                this.blockTextInput(false);
            }
        }
        if (this.isBlockedEventType(event) && !this.isContentEditable()) {
            event.preventDefault();
        } else {
            super.onBrowserEvent(event);
        }
    }

    private boolean isBlockedEventType(Event event) {
        int n = event.getTypeInt();
        return n == 524288 || n == 128 || n == 512 || n == 256;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        super.onClick(clickEvent);
        this.setTextBoxToScrollIntoView(clickEvent);
    }

    @Override
    public void onInnerBorderClick(ClickEvent clickEvent) {
        super.onInnerBorderClick(clickEvent);
        this.setTextBoxToScrollIntoView(clickEvent);
    }

    @Override
    public void onNavigationFocus() {
        if (BrowserInfo.get().isIOS()) {
            this.connector.attemptFocus();
            this.getElement().scrollIntoView();
            FMCUtilities.setHasVirtualKeyboard(true);
        }
    }

    private void setTextBoxToScrollIntoView(ClickEvent clickEvent) {
        if (BrowserInfo.get().isAndroid() && this.communicationConnector != null) {
            this.communicationConnector.setTextBoxToScrollIntoView(this, clickEvent.getClientX(), clickEvent.getClientY());
        }
    }

    @Override
    public void storeCurrentCursorPosition() {
        this.selectionRange = this.getSelectionRange();
    }

    @Override
    public void setTextInputAllowed(boolean bl) {
        super.setTextInputAllowed(bl);
        this.blockTextInput(!bl);
    }

    @Override
    public void blockTextInput(boolean bl) {
        if (!bl && this.textInputAllowed) {
            this.getElement().setAttribute("contenteditable", "true");
        } else {
            this.getElement().removeAttribute("contenteditable");
            if (BrowserInfo.get().isIOS()) {
                FMCUtilities.setHasVirtualKeyboard(false);
            }
        }
    }

    @Override
    public void blockTabbing(boolean bl) {
        if (BrowserInfo.get().isIOS()) {
            this.tabbingAllowed = !bl;
        }
    }

    @Override
    public void setTabIndex(int n) {
        if (BrowserInfo.get().isIOS() && !this.tabbingAllowed) {
            super.setTabIndex(-1);
        } else {
            super.setTabIndex(n);
        }
    }

    private static native boolean isClickInView(int var0, int var1);
}

