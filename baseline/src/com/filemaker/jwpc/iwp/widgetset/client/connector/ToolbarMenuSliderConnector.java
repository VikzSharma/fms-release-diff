/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuSlider;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=ToolbarMenuSlider.class)
public class ToolbarMenuSliderConnector
extends CssLayoutConnector {
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            if (this.getState().enabled) {
                this.getWidget().getElement().removeAttribute("inert");
            } else {
                this.getWidget().getElement().setAttribute("inert", "");
            }
        }
    }
}

