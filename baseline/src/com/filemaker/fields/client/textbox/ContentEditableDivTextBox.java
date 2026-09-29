/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArrayNumber
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.NodeList
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.dom.client.MouseDownHandler
 *  com.google.gwt.safehtml.shared.SafeHtmlUtils
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.TextBoxBase
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.common.FMConnector;
import com.filemaker.fields.client.textbox.ContentEditableFocusHandler;
import com.filemaker.jwpc.iwp.widgetset.client.connector.FMCommunicationConnector;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.vaadin.client.BrowserInfo;

public class ContentEditableDivTextBox
extends TextBoxBase
implements ClickHandler,
MouseDownHandler {
    protected boolean contentEditable = false;
    protected int[] selectionRange = new int[]{-1, 0};
    protected final ContentEditableFocusHandler focusBlurHandler = new ContentEditableFocusHandler();
    protected FMConnector connector = null;
    protected FMCommunicationConnector communicationConnector = null;
    protected boolean pendingClick = false;
    protected boolean textInputAllowed = false;
    protected boolean tabbingAllowed = true;
    protected String htmlText = "";
    protected String plainText = "";
    public boolean pendingMouseRightButton = false;
    private static final int RIGHT_BUTTON = 2;

    public ContentEditableDivTextBox() {
        this((Element)DOM.createDiv(), "text");
    }

    protected ContentEditableDivTextBox(Element element) {
        super(element);
    }

    ContentEditableDivTextBox(Element element, String string) {
        super(element);
        if (string != null) {
            this.setStyleName(string);
        }
        this.addClickHandler(this);
        this.addMouseDownHandler(this);
        DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80000));
        this.addFocusHandler(this.focusBlurHandler);
        this.addBlurHandler(this.focusBlurHandler);
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case 524288: {
                this.handlePasteEvent(event);
                break;
            }
            case 4096: {
                this.pendingClick = false;
                break;
            }
            case 4: {
                this.pendingMouseRightButton = event.getButton() == 2;
            }
        }
    }

    protected void handlePasteEvent(Event event) {
        event.preventDefault();
        String string = SafeHtmlUtils.htmlEscape((String)this.getClipboardData(event));
        this.pastePlainText(string);
        int[] nArray = this.getSelectionRange();
        this.setSelectionRange((Element)this.getElement(), nArray[0], nArray[1]);
    }

    private native String getClipboardData(Event var1);

    protected void pastePlainText(String string) {
        if (!string.isEmpty()) {
            FMCUtilities.insertHTML(string);
        }
    }

    public void setFMConnector(FMConnector fMConnector) {
        this.connector = fMConnector;
    }

    public void setAsCommunicationConnector(FMCommunicationConnector fMCommunicationConnector) {
        this.communicationConnector = fMCommunicationConnector;
    }

    public void setTabIndex(int n) {
        super.setTabIndex(n);
    }

    protected void onAttach() {
        int n = this.getTabIndex();
        super.onAttach();
        if (this.getTabIndex() != n) {
            this.setTabIndex(n);
        }
    }

    private Element getInputElement() {
        return (Element)this.getElement().cast();
    }

    public void setSelectionRange(int n, int n2) {
        this.selectionRange[0] = n;
        this.selectionRange[1] = n2;
        if (!this.isAttached()) {
            this.clearSelection();
            return;
        }
        if (n < 0) {
            this.clearSelection();
            return;
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Length (" + n2 + ") must be a positive integer.");
        }
        int n3 = this.getText().length();
        if (n2 + n > n3) {
            if (n3 == 0) {
                n = 0;
            } else if (n >= n3) {
                n = n3 - 1;
            }
            n2 = this.getText().length() - n;
        }
        this.setSelectionRangeInternal(n, n2);
    }

    protected void setSelectionRangeInternal(int n, int n2) {
        this.setSelectionRange((Element)this.getElement(), n, n2);
    }

    public void selectAll() {
        String string = this.getText();
        if (string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        this.setSelectionRange(0, string.length());
    }

    public String getText() {
        if (!this.getElement().getInnerHTML().equals(this.htmlText)) {
            this.htmlText = this.getElement().getInnerHTML();
            this.plainText = FMCUtilities.getTextContent((Element)this.getElement());
        }
        return this.plainText;
    }

    protected void collectTextNodes(Element element, StringBuilder stringBuilder) {
        NodeList nodeList = element.getChildNodes();
        boolean bl = false;
        if (BrowserInfo.get().isIE() && element.getNodeName().equalsIgnoreCase("p")) {
            bl = true;
        }
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.getItem(i);
            if (node.getNodeType() == 3) {
                stringBuilder.append(node.getNodeValue());
                continue;
            }
            if (node.getNodeName().equalsIgnoreCase("br")) {
                if (bl) continue;
                stringBuilder.append("\n");
                continue;
            }
            if (node.getNodeName().equalsIgnoreCase("p")) {
                if (i > 0) {
                    stringBuilder.append("\n");
                }
                this.collectTextNodes((Element)node, stringBuilder);
                continue;
            }
            if (node.getNodeType() != 1) continue;
            this.collectTextNodes((Element)node, stringBuilder);
        }
    }

    public void setText(String string) {
        int[] nArray = null;
        if (BrowserInfo.get().isIE()) {
            if (this.isContentEditable() && FMCUtilities.hasFocus((Element)this.getElement())) {
                nArray = this.getSelectionRange();
            }
        } else if (FMCUtilities.hasFocus((Element)this.getElement())) {
            nArray = this.getSelectionRange();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string != null) {
            stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string.replaceAll("\r", "\n")));
        }
        this.htmlText = stringBuilder.toString();
        this.plainText = string;
        this.getElement().setInnerHTML(this.htmlText);
        if (nArray != null) {
            int n = nArray[0];
            int n2 = nArray[1];
            if (n >= 0 && n <= string.length() && n2 >= 0 && n + n2 <= string.length()) {
                this.setSelectionRange((Element)this.getElement(), n, n2);
            }
        }
    }

    public void setContentEditable(boolean bl) {
        if (bl != this.contentEditable) {
            this.toggleContentEditableMode(bl);
            this.contentEditable = bl;
        }
    }

    protected void toggleContentEditableMode(boolean bl) {
        this.toggleContentEditableAttribute(bl);
        if (bl) {
            this.handleCursorPosition();
        } else {
            this.getElement().setScrollLeft(0);
        }
    }

    public boolean isContentEditable() {
        return this.contentEditable;
    }

    public native void clearSelection();

    public int[] getSelectionRange() {
        JsArrayNumber jsArrayNumber = this.getSelectionRangeInternal();
        if (jsArrayNumber == null) {
            return this.selectionRange;
        }
        int[] nArray = new int[]{jsArrayNumber.length() > 0 ? (int)jsArrayNumber.get(0) : -1, jsArrayNumber.length() > 1 ? (int)jsArrayNumber.get(1) : 0};
        return nArray;
    }

    protected JsArrayNumber getSelectionRangeInternal() {
        return this.getSelectionRange((Element)this.getElement());
    }

    protected void setSelectionRange(Element element, int n, int n2) {
        if (FMCUtilities.hasFocus((Element)Document.get().getBody())) {
            this.connector.startEdit();
            Scheduler.get().scheduleDeferred(() -> this.setSelectionRangeNatively(element, n, n2));
        } else {
            this.setSelectionRangeNatively(element, n, n2);
        }
    }

    protected native void setSelectionRangeNatively(Element var1, int var2, int var3);

    protected native JsArrayNumber getSelectionRange(Element var1);

    protected void handleCursorPosition() {
        if (!this.pendingClick) {
            int n;
            int n2 = this.selectionRange[0] < 0 ? this.getText().length() : this.selectionRange[0];
            if ((n2 = Math.min(n2, this.getText().length())) + (n = this.selectionRange[1]) > this.getText().length()) {
                n = this.getText().length() - n2;
            }
            this.setSelectionRange(n2, n);
        }
    }

    public void setCursorPosition(int n) {
        this.selectionRange[0] = n;
        this.selectionRange[1] = 0;
        if (this.isContentEditable()) {
            this.handleCursorPosition();
        }
    }

    public void moveCursorToEndOfText() {
        int n = this.getText().length();
        this.setCursorPosition(n);
    }

    public void storeCurrentCursorPosition() {
        boolean bl = this.isContentEditable();
        if (!bl) {
            this.toggleContentEditableAttribute(true);
        }
        this.selectionRange = this.getSelectionRange();
        if (!bl) {
            this.toggleContentEditableAttribute(false);
        }
    }

    public void onClick(ClickEvent clickEvent) {
        this.storeCurrentCursorPosition();
        this.pendingClick = false;
        this.connector.attemptFocus();
    }

    public void startTabFocus() {
        this.selectionRange[0] = this.getText().length();
        this.selectionRange[1] = 0;
        this.connector.startEdit();
    }

    public void onInnerBorderClick(ClickEvent clickEvent) {
        this.connector.attemptFocus();
    }

    public void onNavigationFocus() {
    }

    public ContentEditableFocusHandler getFocusBlurHandler() {
        return this.focusBlurHandler;
    }

    public void onMouseDown(MouseDownEvent mouseDownEvent) {
        this.pendingClick = true;
    }

    public void setTextInputAllowed(boolean bl) {
        this.textInputAllowed = bl;
    }

    public boolean isTextInputAllowed() {
        return this.textInputAllowed;
    }

    public void blockTextInput(boolean bl) {
    }

    public void blockTabbing(boolean bl) {
    }

    public boolean isTabbingAllowed() {
        return this.tabbingAllowed;
    }

    public String getSelectedText() {
        int[] nArray = this.getSelectionRange();
        if (nArray[0] < 0) {
            return "";
        }
        return this.getText().substring(nArray[0], nArray[0] + nArray[1]);
    }

    protected void blurFocusToEnableIME() {
        this.focusBlurHandler.setEnabled(false);
        this.getElement().blur();
        this.getElement().focus();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                ContentEditableDivTextBox.this.focusBlurHandler.setEnabled(true);
            }
        });
    }

    protected void toggleContentEditableAttribute(boolean bl) {
        if (bl) {
            this.getElement().setAttribute("contenteditable", "true");
        } else {
            this.getElement().removeAttribute("contenteditable");
        }
    }

    public void cacheContextMenuSelection() {
        int[] nArray = this.getSelectionRange();
        String string = this.getSelectedText();
        FMCUtilities.cacheContextMenuSelection(string, nArray);
    }

    public int[] getContextMenuSelectionRange() {
        return FMCUtilities.getContextMenuSelectionRange();
    }

    public void handleContextMenuCopy() {
        int[] nArray = this.getContextMenuSelectionRange();
        this.setSelectionRange(nArray[0], nArray[1]);
    }

    public void handleContextMenuPaste(String string) {
        this.setFocus(true);
        this.setContentEditable(true);
        int[] nArray = this.getContextMenuSelectionRange();
        this.setSelectionRange(nArray[0], nArray[1]);
        if (!string.isEmpty()) {
            FMCUtilities.insertHTML(string);
        }
    }

    public void startContextMenuFocus() {
        this.pendingMouseRightButton = true;
        this.connector.startEdit();
    }
}

