/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class FMClientEventManager {
    private boolean handleHover = false;
    protected boolean handlePressed = false;
    private boolean isHovering = false;

    public FMClientEventManager(Element element, boolean bl, boolean bl2) {
        if (FMCUtilities.isMobile()) {
            if (bl2) {
                this.handlePressed = bl2;
                int n = DOM.getEventsSunk((com.google.gwt.dom.client.Element)element);
                n = n | 0x100000 | 0x400000 | 0x800000;
                DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)n);
            }
        } else if (bl || bl2) {
            this.handleHover = bl;
            this.handlePressed = bl2;
            int n = DOM.getEventsSunk((com.google.gwt.dom.client.Element)element);
            n = n | 8 | 4 | 0x10 | 0x20;
            DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)n);
        }
    }

    protected void handleEvent(Event event, Widget widget) {
        if (FMCUtilities.isMobile()) {
            this.handleTouchEvent(event, widget);
        } else {
            this.handleMouseEvent(event, widget);
        }
    }

    protected void handleMouseEvent(Event event, Widget widget) {
        switch (DOM.eventGetType((Event)event)) {
            case 16: {
                if (!this.handleHover) break;
                this.isHovering = true;
                widget.addStyleName("fm-hover");
                break;
            }
            case 32: {
                if (this.handleHover) {
                    this.isHovering = false;
                    widget.removeStyleName("fm-hover");
                }
                if (!this.handlePressed) break;
                widget.removeStyleName("fm-pressed");
                break;
            }
            case 4: {
                if (this.handleHover) {
                    widget.removeStyleName("fm-hover");
                }
                if (!this.handlePressed) break;
                widget.addStyleName("fm-pressed");
                break;
            }
            case 8: {
                if (this.handlePressed) {
                    widget.removeStyleName("fm-pressed");
                }
                if (!this.handleHover || !this.isHovering) break;
                widget.addStyleName("fm-hover");
                break;
            }
        }
    }

    protected void handleTouchEvent(Event event, Widget widget) {
        switch (DOM.eventGetType((Event)event)) {
            case 0x100000: {
                if (!this.handlePressed) break;
                widget.addStyleName("fm-pressed");
                break;
            }
            case 0x400000: 
            case 0x800000: {
                if (!this.handlePressed) break;
                widget.removeStyleName("fm-pressed");
            }
        }
    }

    public static void registerEvents(Element element, int n) {
        int n2 = DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | n;
        DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)n2);
    }
}

