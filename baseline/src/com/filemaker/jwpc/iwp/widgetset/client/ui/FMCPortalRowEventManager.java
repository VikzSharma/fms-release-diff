/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class FMCPortalRowEventManager
extends FMClientEventManager {
    boolean isHovering = false;
    boolean shouldHandlePressed = false;

    public FMCPortalRowEventManager(Element element, boolean bl, boolean bl2) {
        super(element, bl, bl2);
    }

    @Override
    protected void handleMouseEvent(Event event, Widget widget) {
        switch (DOM.eventGetType((Event)event)) {
            case 16: {
                this.isHovering = true;
                widget.addStyleName("fm-hover");
                break;
            }
            case 4: {
                this.shouldHandlePressed = this.shouldHandlePressed(event);
                if (!this.shouldHandlePressed) break;
                widget.removeStyleName("fm-hover");
                widget.addStyleName("fm-pressed");
                break;
            }
            case 8: {
                if (this.shouldHandlePressed) {
                    widget.removeStyleName("fm-pressed");
                    this.shouldHandlePressed = false;
                }
                if (!this.isHovering) break;
                widget.addStyleName("fm-hover");
                break;
            }
            case 32: {
                if (this.isHovering) {
                    widget.removeStyleName("fm-hover");
                    this.isHovering = false;
                }
                if (!this.shouldHandlePressed) break;
                widget.removeStyleName("fm-pressed");
                this.shouldHandlePressed = false;
                break;
            }
        }
    }

    @Override
    protected void handleTouchEvent(Event event, Widget widget) {
        switch (DOM.eventGetType((Event)event)) {
            case 0x100000: {
                this.shouldHandlePressed = this.shouldHandlePressed(event);
                if (!this.shouldHandlePressed) break;
                widget.addStyleName("fm-pressed");
                break;
            }
            case 0x400000: 
            case 0x800000: {
                if (!this.shouldHandlePressed) break;
                widget.removeStyleName("fm-pressed");
                this.shouldHandlePressed = false;
            }
        }
    }

    private boolean shouldHandlePressed(Event event) {
        if (this.handlePressed) {
            String string = DOM.eventGetTarget((Event)event).getClassName();
            return string != null && string.indexOf("iwp-portal-row") > -1;
        }
        return this.handlePressed;
    }
}

