/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.dom.client.Style$Position
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ui.VTabsheet
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.PanelContainerControlServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PanelContainerControlState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VTabsheet;

public class VCustomPanelContainerControl
extends VTabsheet {
    private PanelContainerControlServerRpc rpc;
    private int pcbs = 0;

    public VCustomPanelContainerControl() {
        Element element = this.getElement();
        DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)(DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | 1));
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
        if (FMCUtilities.useAriaCompliantControl()) {
            this.addDomHandler((EventHandler)new KeyDownHandler(this){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    if (!keyDownEvent.isAnyModifierKeyDown() && keyDownEvent.getNativeKeyCode() == 13) {
                        NativeEvent nativeEvent = Document.get().createKeyDownEvent(false, false, false, false, 32);
                        com.google.gwt.dom.client.Element element = com.google.gwt.dom.client.Element.as((JavaScriptObject)keyDownEvent.getNativeEvent().getEventTarget());
                        element.dispatchEvent(nativeEvent);
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    public void setPcbs(int n) {
        this.pcbs = n;
    }

    private boolean getBooleanState(PanelContainerControlState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.pcbs, booleanState.ordinal());
    }

    public void registerPanelContainerControlServerRpc(PanelContainerControlServerRpc panelContainerControlServerRpc) {
        this.rpc = panelContainerControlServerRpc;
    }

    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == 1) {
            this.rpc.onClick();
        }
        super.onBrowserEvent(event);
        if (this.getBooleanState(PanelContainerControlState.BooleanState.hasTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }

    public void refreshPosition() {
        this.getElement().getStyle().setPosition(Style.Position.RELATIVE);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                VCustomPanelContainerControl.this.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
            }
        });
    }
}

