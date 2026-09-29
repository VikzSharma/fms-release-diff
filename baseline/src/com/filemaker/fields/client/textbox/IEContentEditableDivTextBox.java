/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArrayNumber
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.safehtml.shared.SafeHtmlUtils
 *  com.google.gwt.user.client.Event
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Event;

public class IEContentEditableDivTextBox
extends ContentEditableDivTextBox {
    private int storedCursorPosition = -1;

    public IEContentEditableDivTextBox() {
        this.attachCopyAndCutHandlers((Element)this.getElement());
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getKeyCode() == 13) {
            this.setText(this.getText());
        }
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case 128: {
                if (event.getKeyCode() != 65 || !event.getCtrlKey()) break;
                event.preventDefault();
                this.selectAll();
            }
        }
    }

    @Override
    protected void handlePasteEvent(Event event) {
        event.preventDefault();
        int[] nArray = this.getSelectionRange();
        this.pastePlainText(event);
        this.setSelectionRange((Element)this.getElement(), nArray[0] + IEContentEditableDivTextBox.getClipboardData().replace("\r\n", "\n").length(), 0);
    }

    public static native String getClipboardData();

    private native void pastePlainText(Event var1);

    private native void attachCopyAndCutHandlers(Element var1);

    private void handleCopyEvent() {
        String string = this.getSelectedText();
        this.postProcessCutAndCopyText(string.replaceAll("\n", "\r\n"));
    }

    private void handleCutEvent() {
        this.handleCopyEvent();
        int[] nArray = this.getSelectionRange();
        StringBuffer stringBuffer = new StringBuffer(this.getText());
        stringBuffer.delete(nArray[0], nArray[0] + nArray[1]);
        this.setText(stringBuffer.toString());
        this.setSelectionRange((Element)this.getElement(), nArray[0], 0);
    }

    private native void postProcessCutAndCopyText(String var1);

    @Override
    public void selectAll() {
        this.setSelectionRange(0, this.getText().length());
    }

    @Override
    protected void toggleContentEditableMode(boolean bl) {
        if (this.pendingClick) {
            this.storedCursorPosition = this.getSelectionRange()[0];
            this.setCursorPosition(this.storedCursorPosition);
        }
        if (bl) {
            this.setTextIE(this.getText());
        } else {
            super.setText(this.getText());
        }
        this.contentEditable = bl;
        super.toggleContentEditableMode(bl);
        if (bl) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    IEContentEditableDivTextBox.this.blurFocusToEnableIME();
                }
            });
        }
    }

    @Override
    public void setText(String string) {
        if (super.isContentEditable()) {
            this.setTextIE(string);
        } else {
            super.setText(string);
        }
    }

    @Override
    public void storeCurrentCursorPosition() {
        super.storeCurrentCursorPosition();
        if (this.storedCursorPosition >= 0) {
            this.setCursorPosition(this.storedCursorPosition);
            this.storedCursorPosition = -1;
        }
    }

    private void setTextIE(String string) {
        int[] nArray = null;
        if (FMCUtilities.hasFocus((Element)this.getElement())) {
            nArray = this.getSelectionRange();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string != null) {
            String[] stringArray;
            for (String string2 : stringArray = string.replaceAll("\r", "\n").split("\n", -1)) {
                if (stringArray.length > 1) {
                    stringBuilder.append("<p>");
                    stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string2));
                    if (FMCUtilities.isIE11()) {
                        stringBuilder.append("<br/>");
                    }
                    stringBuilder.append("</p>");
                    continue;
                }
                stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string2));
            }
        }
        this.htmlText = stringBuilder.toString();
        this.plainText = string;
        this.getElement().setInnerHTML(stringBuilder.toString());
        if (nArray != null) {
            int n = nArray[0];
            int n2 = nArray[1];
            if (n >= 0 && n <= string.length() && n2 >= 0 && n + n2 <= string.length()) {
                this.setSelectionRange((Element)this.getElement(), n, n2);
            }
        }
    }

    @Override
    protected void setSelectionRangeInternal(int n, int n2) {
        if (this.isContentEditable()) {
            this.setSelectionRange((Element)this.getElement(), n, n2);
        } else {
            super.setSelectionRangeInternal(n, n2);
        }
    }

    @Override
    protected JsArrayNumber getSelectionRangeInternal() {
        if (this.isContentEditable()) {
            return this.getSelectionRange((Element)this.getElement());
        }
        return super.getSelectionRangeInternal();
    }

    @Override
    protected native void setSelectionRangeNatively(Element var1, int var2, int var3);

    @Override
    protected native JsArrayNumber getSelectionRange(Element var1);
}

