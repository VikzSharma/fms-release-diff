/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.Element
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.window.WindowConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDialog;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Element;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.window.WindowConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=Dialog.class)
public class DialogConnector
extends WindowConnector {
    public VCustomDialog getWidget() {
        return (VCustomDialog)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    Element element = DialogConnector.this.getWidget().getElement();
                    com.google.gwt.dom.client.Element element2 = FMCUtilities.querySelector((com.google.gwt.dom.client.Element)element, ".v-scrollable");
                    if (element2 != null) {
                        String string;
                        String string2;
                        com.google.gwt.dom.client.Element element3 = FMCUtilities.querySelector((com.google.gwt.dom.client.Element)element, ".v-panel-content > .v-label, .v-slot > .v-label");
                        String string3 = DialogConnector.this.getState().caption;
                        String string4 = string2 = element3 != null ? element3.getInnerText().trim() : "";
                        String string5 = string3.isEmpty() ? string2 : (string = string2.isEmpty() ? string3 : string3 + ", " + string2);
                        if (!string.isEmpty()) {
                            element2.setAttribute("aria-label", string);
                        }
                    }
                }
            });
        }
    }
}

