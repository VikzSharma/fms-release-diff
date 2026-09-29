/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.nativeselect.NativeSelectConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=NativeSelect.class)
public class NativeSelectConnector
extends com.vaadin.v7.client.ui.nativeselect.NativeSelectConnector {
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        Element element;
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl() && (element = FMCUtilities.querySelector((Element)this.getWidget().getElement(), "select")) != null) {
            element.setAttribute("aria-label", this.getState().description);
            if (!element.hasAttribute("name")) {
                String string = this.getState().caption;
                String string2 = string != null && !string.isEmpty() ? string + "-" + this.getConnectorId() : this.getConnectorId();
                element.setAttribute("name", string2);
            }
        }
    }
}

