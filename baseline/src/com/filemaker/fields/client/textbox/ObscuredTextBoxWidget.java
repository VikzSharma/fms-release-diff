/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArrayNumber
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.fields.client.textbox.IEContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;

public class ObscuredTextBoxWidget
extends ContentEditableDivTextBox {
    public ObscuredTextBoxWidget() {
        super((Element)DOM.createInputPassword(), "text");
    }

    @Override
    public void selectAll() {
        this.selectAll((Element)this.getElement(), this.plainText.length());
    }

    private final native void selectAll(Element var1, int var2);

    private final native String getElementValue(Element var1);

    private final native void setElementValue(Element var1, String var2);

    @Override
    protected native JsArrayNumber getSelectionRange(Element var1);

    @Override
    protected native void setSelectionRange(Element var1, int var2, int var3);

    @Override
    public String getText() {
        if (this.plainText == null || !this.plainText.equals(this.getElementValue((Element)this.getElement()))) {
            this.plainText = this.getElementValue((Element)this.getElement());
        }
        return this.plainText;
    }

    @Override
    public void setText(String string) {
        int[] nArray = null;
        if (FMCUtilities.hasFocus((Element)this.getElement())) {
            nArray = this.getSelectionRange();
        }
        this.plainText = string;
        this.setElementValue((Element)this.getElement(), this.plainText);
        if (nArray != null) {
            int n = nArray[0];
            int n2 = nArray[1];
            if (n >= 0 && n <= string.length() && n2 >= 0 && n + n2 <= string.length()) {
                this.setSelectionRange((Element)this.getElement(), n, n2);
            }
        }
    }

    @Override
    public void moveCursorToEndOfText() {
        int n = this.getText().length();
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (BrowserInfo.get().isIOS() && event.getTypeInt() == 2048) {
            this.connector.setPendingNavigationFocus();
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    ObscuredTextBoxWidget.this.connector.checkNavigationFocus();
                }
            });
        }
    }

    @Override
    protected void handlePasteEvent(Event event) {
        if (BrowserInfo.get().isIE()) {
            event.preventDefault();
            String string = this.getText();
            int[] nArray = this.getSelectionRange();
            String string2 = IEContentEditableDivTextBox.getClipboardData().replace("\r\n", "\n");
            this.setText(string.substring(0, nArray[0]) + string2 + string.substring(nArray[0] + nArray[1], string.length()));
        } else {
            super.handlePasteEvent(event);
        }
    }

    @Override
    public void onNavigationFocus() {
        if (BrowserInfo.get().isIOS()) {
            this.connector.attemptFocus();
            this.getElement().scrollIntoView();
        }
    }

    @Override
    protected void toggleContentEditableAttribute(boolean bl) {
    }
}

