/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArray
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Style$Display
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPanelContainerControl;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

public class VCustomDotControl
extends VCustomPanelContainerControl {
    private com.google.gwt.dom.client.Element pressedTab = null;

    public VCustomDotControl() {
        Element element = this.getElement();
        DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)(DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | 4 | 8 | 0x20));
        if (FMCUtilities.isMobile()) {
            DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)(DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | 0x100000 | 0x400000));
        }
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (DOM.eventGetType((Event)event)) {
            case 4: 
            case 0x100000: {
                com.google.gwt.dom.client.Element element = this.getTabItemCellTargeted((com.google.gwt.dom.client.Element)DOM.eventGetTarget((Event)event));
                if (element == null) break;
                element.addClassName("fm-pressed");
                this.pressedTab = element;
                break;
            }
            case 8: 
            case 32: 
            case 0x400000: {
                if (this.pressedTab == null) break;
                this.pressedTab.removeClassName("fm-pressed");
                break;
            }
        }
    }

    private com.google.gwt.dom.client.Element getTabItemCellTargeted(com.google.gwt.dom.client.Element element) {
        com.google.gwt.dom.client.Element element2;
        com.google.gwt.dom.client.Element element3 = null;
        if (element != null && element.getClassName().equalsIgnoreCase("v-caption") && (element2 = element.getParentElement()) != null) {
            element3 = element2.getParentElement();
        }
        return element3;
    }

    public void adjustTabs() {
        com.google.gwt.dom.client.Element element = FMCUtilities.querySelector((com.google.gwt.dom.client.Element)this.getElement(), ".v-tabsheet-tabs > tbody");
        element.getStyle().setDisplay(Style.Display.FLEX);
        element.getStyle().setProperty("justifyContent", "center");
        JsArray<com.google.gwt.dom.client.Element> jsArray = FMCUtilities.querySelectorAll(element, ".v-tabsheet-tabitemcell");
        if (jsArray.length() > 0) {
            ((com.google.gwt.dom.client.Element)jsArray.get(0)).getStyle().setPaddingLeft(0.0, Style.Unit.PX);
        }
    }
}

