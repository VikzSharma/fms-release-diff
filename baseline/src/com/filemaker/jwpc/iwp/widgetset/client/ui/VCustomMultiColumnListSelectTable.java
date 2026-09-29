/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JsArray
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.vaadin.client.UIDL
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomBaseTable;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.vaadin.client.UIDL;

public class VCustomMultiColumnListSelectTable
extends VCustomBaseTable {
    private boolean isMatchMode = false;

    public void setIsMatchMode(boolean bl) {
        this.isMatchMode = bl;
        if (FMCUtilities.useAriaCompliantControl() && this.isMatchMode) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    VCustomMultiColumnListSelectTable.this.syncMatchOptions();
                }
            });
        }
    }

    public void syncMatchOptions() {
        JsArray<Element> jsArray = this.getMatchOptions();
        for (int i = 0; i < jsArray.length(); ++i) {
            Element element = (Element)jsArray.get(i);
            String string = element.getAttribute("tabindex");
            if (string != null && string.trim().length() != 0) continue;
            element.setAttribute("tabindex", "0");
            this.addKeyDownListener(element);
        }
    }

    private JsArray<Element> getMatchOptions() {
        return FMCUtilities.querySelectorAll((Element)this.getElement(), ".v-table-table tr td:nth-child(2)");
    }

    private Element getMatchOption(int n) {
        JsArray<Element> jsArray = this.getMatchOptions();
        if (n < 0 || n >= jsArray.length()) {
            return null;
        }
        return (Element)jsArray.get(n);
    }

    private native void resyncMatchOptions(int var1);

    private native void addKeyDownListener(Element var1);

    public void updateBody(UIDL uIDL, int n, int n2) {
        if (FMCUtilities.useAriaCompliantControl() && this.isMatchMode) {
            int n3 = -1;
            JsArray<Element> jsArray = this.getMatchOptions();
            for (int i = 0; i < jsArray.length(); ++i) {
                Element element = (Element)jsArray.get(i);
                if (!element.isOrHasChild((Node)FMCUtilities.getActiveElement())) continue;
                n3 = i;
                break;
            }
            super.updateBody(uIDL, n, n2);
            this.resyncMatchOptions(n3);
        } else {
            super.updateBody(uIDL, n, n2);
        }
    }
}

