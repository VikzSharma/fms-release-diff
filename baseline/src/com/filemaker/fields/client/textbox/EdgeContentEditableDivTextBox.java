/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArrayNumber
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.NodeList
 *  com.google.gwt.safehtml.shared.SafeHtmlUtils
 *  com.google.gwt.user.client.Event
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Event;

public class EdgeContentEditableDivTextBox
extends ContentEditableDivTextBox {
    private String oldText;
    private int[] oldRange;

    public EdgeContentEditableDivTextBox() {
        this.attachBeforePasteHandler((Element)this.getElement());
        this.attachCopyAndCutHandlers((Element)this.getElement());
    }

    @Override
    protected void toggleContentEditableMode(boolean bl) {
        super.toggleContentEditableMode(bl);
        if (bl) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    EdgeContentEditableDivTextBox.this.blurFocusToEnableIME();
                }
            });
        }
    }

    private native void attachBeforePasteHandler(Element var1);

    private native void attachCopyAndCutHandlers(Element var1);

    private void handleBeforePasteEvent() {
        this.oldText = this.getText();
        this.oldRange = this.getSelectionRange();
    }

    private String postProcessCopyText() {
        return this.getSelectedText().replaceAll("\n", "\r\n");
    }

    private void postProcessCutText() {
        int[] nArray = this.getSelectionRange();
        StringBuffer stringBuffer = new StringBuffer(this.getText());
        stringBuffer.delete(nArray[0], nArray[0] + nArray[1]);
        this.setText(stringBuffer.toString());
        this.setSelectionRange((Element)this.getElement(), nArray[0], 0);
    }

    @Override
    public String getText() {
        if (!this.getElement().getInnerHTML().equals(this.htmlText)) {
            this.htmlText = this.getElement().getInnerHTML();
            StringBuilder stringBuilder = new StringBuilder();
            this.collectTextNodes((Element)this.getElement(), stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            this.plainText = stringBuilder.toString();
        }
        return this.plainText;
    }

    @Override
    protected void handlePasteEvent(Event event) {
        event.preventDefault();
        this.pastePlainText(event);
    }

    private static native String getClipboardData(Event var0);

    private void pastePlainText(Event event) {
        String string = EdgeContentEditableDivTextBox.getClipboardData(event).replace("\r\n", "\n");
        this.setText(this.oldText.substring(0, this.oldRange[0]) + string + this.oldText.substring(this.oldRange[0] + this.oldRange[1], this.oldText.length()));
        this.setSelectionRange((Element)this.getElement(), this.oldRange[0] + string.length(), 0);
    }

    @Override
    protected void collectTextNodes(Element element, StringBuilder stringBuilder) {
        NodeList nodeList = element.getChildNodes();
        int n = 0;
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.getItem(i);
            if (node.getNodeType() == 3) {
                stringBuilder.append(node.getNodeValue());
                n = stringBuilder.length();
                continue;
            }
            if (node.getNodeName().equalsIgnoreCase("br")) {
                if (nodeList.getLength() != 1) continue;
                stringBuilder.append("\n");
                continue;
            }
            if (node.getNodeType() != 1) continue;
            this.collectTextNodes((Element)node, stringBuilder);
        }
        if (n != 0) {
            stringBuilder.insert(n, "\n");
        }
        if (nodeList.getLength() == 0 && element.getInnerHTML().equalsIgnoreCase("<br>")) {
            stringBuilder.append("\n");
        }
    }

    @Override
    public void setText(String string) {
        int[] nArray = null;
        if (this.isContentEditable() && FMCUtilities.hasFocus((Element)this.getElement())) {
            nArray = this.getSelectionRange();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string != null) {
            String[] stringArray;
            for (String string2 : stringArray = string.replaceAll("\r", "\n").split("\n", -1)) {
                if (stringArray.length > 1) {
                    stringBuilder.append("<div>");
                    if (string2.length() == 0) {
                        stringBuilder.append("<br>");
                    } else {
                        stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string2));
                    }
                    stringBuilder.append("</div>");
                    continue;
                }
                stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string2));
            }
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

    @Override
    protected native void setSelectionRangeNatively(Element var1, int var2, int var3);

    @Override
    protected JsArrayNumber getSelectionRangeInternal() {
        return this.getSelectionRange((Element)this.getElement(), this.getText().length());
    }

    protected native JsArrayNumber getSelectionRange(Element var1, int var2);

    @Override
    public void storeCurrentCursorPosition() {
        this.selectionRange = this.getSelectionRange();
    }
}

