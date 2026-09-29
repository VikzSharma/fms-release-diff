/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Timer
 *  com.vaadin.client.ApplicationConnection
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.vaadin.client.ApplicationConnection;

public class FMClientTooltipHandler {
    private static FMClientTooltipHandler instance;
    private Timer tooltipTimer = new Timer(){

        public void run() {
            FMClientTooltipHandler.this.dismissTooltip();
        }
    };
    private ApplicationConnection ac = null;
    private boolean isRunning = false;

    private FMClientTooltipHandler() {
    }

    public static FMClientTooltipHandler getInstance() {
        if (instance == null) {
            instance = new FMClientTooltipHandler();
        }
        return instance;
    }

    public void handleEvent(Event event, ApplicationConnection applicationConnection) {
        switch (DOM.eventGetType((Event)event)) {
            case 16: {
                this.startTimer(applicationConnection);
                break;
            }
            case 32: {
                this.dismissTooltip();
                break;
            }
        }
    }

    private void startTimer(ApplicationConnection applicationConnection) {
        if (this.isRunning) {
            this.dismissTooltip();
        }
        this.ac = applicationConnection;
        this.isRunning = true;
        this.tooltipTimer.schedule(5000);
    }

    private void resetTimer() {
        this.ac = null;
        this.isRunning = false;
        this.tooltipTimer.cancel();
    }

    private void dismissTooltip() {
        if (this.ac != null) {
            this.ac.getVTooltip().hideTooltip();
        }
        this.resetTimer();
    }

    public static void registerMouseEvents(Element element) {
        int n = DOM.getEventsSunk((com.google.gwt.dom.client.Element)element);
        n = n | 0x10 | 0x20;
        DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)n);
    }
}

