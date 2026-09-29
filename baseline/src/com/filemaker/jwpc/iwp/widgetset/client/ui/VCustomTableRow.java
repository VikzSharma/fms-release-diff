/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.InputElement
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.UIDL
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody$VScrollTableRow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.UIDL;
import com.vaadin.v7.client.ui.VScrollTable;
import java.util.Objects;

public class VCustomTableRow
extends VScrollTable.VScrollTableBody.VScrollTableRow {
    public VCustomTableRow(VScrollTable.VScrollTableBody vScrollTableBody, UIDL uIDL, char[] cArray) {
        VScrollTable.VScrollTableBody vScrollTableBody2 = vScrollTableBody;
        Objects.requireNonNull(vScrollTableBody2);
        super(vScrollTableBody2, uIDL, cArray);
    }

    public void onBrowserEvent(Event event) {
        if (!BrowserInfo.get().isIOS() || !FMCUtilities.isOrHasTextArea(event.getEventTarget().cast())) {
            super.onBrowserEvent(event);
        }
    }

    public void toggleSelection() {
        super.toggleSelection();
        if (FMCUtilities.useAriaCompliantControl()) {
            this.syncAria();
        }
    }

    private void syncAria() {
        InputElement inputElement = (InputElement)FMCUtilities.querySelector((Element)this.getElement(), "input");
        if (inputElement != null && inputElement.getType().equals("checkbox")) {
            this.getElement().setAttribute("aria-checked", inputElement.isChecked() ? "true" : "false");
        }
    }
}

