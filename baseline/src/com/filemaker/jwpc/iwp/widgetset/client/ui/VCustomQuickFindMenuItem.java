/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.HasMultiNavigableItems;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomQuickFindField;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VCssLayout;

public class VCustomQuickFindMenuItem
extends VCssLayout
implements HasMultiNavigableItems {
    private Widget prev;
    private Widget next;
    private VCustomQuickFindField field;
    private FMCInputUtilities.InputPreviewHandler handler;

    public VCustomQuickFindMenuItem() {
        if (FMCUtilities.useAriaCompliantControl()) {
            this.handler = new FMCInputUtilities.InputPreviewHandler(){

                @Override
                public void onPreviewInputEvent(Event.NativePreviewEvent nativePreviewEvent) {
                    VCustomQuickFindMenuItem.this.processPreviewInputEvent(nativePreviewEvent);
                }
            };
        }
    }

    public void add(Widget widget) {
        super.add(widget);
        this.field = (VCustomQuickFindField)widget;
    }

    public void onAttach() {
        super.onAttach();
        if (FMCUtilities.useAriaCompliantControl()) {
            FMCInputUtilities.addHandler(this.handler);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (FMCUtilities.useAriaCompliantControl()) {
            FMCInputUtilities.removeHandler(this.handler);
        }
    }

    @Override
    public void setPrev(Widget widget) {
        this.prev = widget;
    }

    @Override
    public void setNext(Widget widget) {
        this.next = widget;
    }

    @Override
    public void setFocus(boolean bl) {
        this.field.getSubPartElement("textbox").focus();
    }

    private void processPreviewInputEvent(Event.NativePreviewEvent nativePreviewEvent) {
        if (FMCInputUtilities.isKeyboardTab() && Element.as((JavaScriptObject)nativePreviewEvent.getNativeEvent().getEventTarget()).equals((Object)this.field.getSubPartElement("textbox"))) {
            nativePreviewEvent.getNativeEvent().preventDefault();
            boolean bl = nativePreviewEvent.getNativeEvent().getShiftKey();
            if (bl) {
                if (this.prev != null) {
                    this.prev.getElement().focus();
                }
            } else if (this.next != null) {
                this.next.getElement().focus();
            }
        }
    }
}

