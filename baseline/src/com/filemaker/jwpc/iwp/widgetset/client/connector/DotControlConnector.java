/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.DotControl;
import com.filemaker.jwpc.iwp.widgetset.client.connector.PanelContainerControlConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.DotControlClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDotControl;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=DotControl.class)
public class DotControlConnector
extends PanelContainerControlConnector {
    public DotControlConnector() {
        this.registerRpc(DotControlClientRPC.class, new DotControlClientRPC(){

            @Override
            public void refreshPosition() {
                DotControlConnector.this.getWidget().refreshPosition();
            }
        });
    }

    @Override
    public VCustomDotControl getWidget() {
        return (VCustomDotControl)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            FMCUtilities.fixLayoutTableAlert((Element)this.getWidget().getElement());
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    DotControlConnector.this.getWidget().adjustTabs();
                }
            });
        }
    }
}

