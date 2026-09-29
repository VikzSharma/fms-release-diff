/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.dom.client.MouseDownHandler
 *  com.google.gwt.event.dom.client.MouseUpEvent
 *  com.google.gwt.event.dom.client.MouseUpHandler
 *  com.google.gwt.event.dom.client.TouchStartEvent
 *  com.google.gwt.event.dom.client.TouchStartHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Window
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VCssLayout;

public class VCustomLayoutPart
extends VCssLayout {
    private boolean wasTouchOnTextBox = false;
    private int layoutMinHeight = -1;
    private int defaultBottom = -1;
    private String style;
    private JavaScriptObject windowResizeHandler = null;

    public VCustomLayoutPart() {
        this.addDomHandler((EventHandler)new TouchStartHandler(){

            public void onTouchStart(TouchStartEvent touchStartEvent) {
                VCustomLayoutPart.this.handleTouchStartEvent(touchStartEvent);
            }
        }, TouchStartEvent.getType());
        this.addDomHandler((EventHandler)new MouseDownHandler(){

            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                VCustomLayoutPart.this.handleMouseDownEvent(mouseDownEvent);
            }
        }, MouseDownEvent.getType());
        this.addDomHandler((EventHandler)new MouseUpHandler(){

            public void onMouseUp(MouseUpEvent mouseUpEvent) {
                VCustomLayoutPart.this.handleMouseUpEvent(mouseUpEvent);
            }
        }, MouseUpEvent.getType());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (event.getTypeInt() == 4096) {
            this.wasTouchOnTextBox = false;
        }
    }

    private void handleTouchStartEvent(TouchStartEvent touchStartEvent) {
        if (BrowserInfo.get().isIOS()) {
            this.wasTouchOnTextBox = FMCUtilities.isOrHasTextArea(touchStartEvent.getNativeEvent().getEventTarget().cast());
        }
    }

    private void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        if (BrowserInfo.get().isIOS() && this.wasTouchOnTextBox && !FMCUtilities.isOrHasTextArea(mouseDownEvent.getNativeEvent().getEventTarget().cast())) {
            mouseDownEvent.preventDefault();
            mouseDownEvent.stopPropagation();
        }
    }

    private void handleMouseUpEvent(MouseUpEvent mouseUpEvent) {
        if (BrowserInfo.get().isIOS() && !this.wasTouchOnTextBox && !FMCUtilities.isOrHasTextArea(mouseUpEvent.getNativeEvent().getEventTarget().cast())) {
            FMCUtilities.removeFocus();
        }
        this.wasTouchOnTextBox = false;
    }

    public void setLayoutAndPartInfo(int n, int n2) {
        this.layoutMinHeight = n;
        this.defaultBottom = n2;
    }

    public void setStyle(String string) {
        String string2 = this.getElement().getAttribute("style");
        string2 = string2.length() > 0 ? string2 + string : string;
        this.getElement().setAttribute("style", string2);
    }

    public void attachWindowResizeHandler() {
        if (this.windowResizeHandler == null) {
            this.windowResizeHandler = this.getWindowResizeHandler(this);
            FMCUtilities.attachResizeHandler(this.windowResizeHandler);
        }
    }

    private native JavaScriptObject getWindowResizeHandler(VCustomLayoutPart var1);

    private void onWindowResize() {
        if (this.layoutMinHeight > -1) {
            int n = Window.getClientHeight() - 44;
            if (n < this.layoutMinHeight) {
                this.setBottom(this.defaultBottom + (n - this.layoutMinHeight));
            } else {
                this.setBottom(this.defaultBottom);
            }
        }
    }

    private void setBottom(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.getElement().getAttribute("style");
        int n2 = string.indexOf("bottom:");
        if (n2 > -1) {
            int n3 = string.indexOf("px;", n2);
            stringBuilder.append(string, 0, n2).append(string, n3 + "px;".length(), string.length());
        } else {
            stringBuilder.append(string);
        }
        stringBuilder.append("bottom:").append(n).append("px;");
        this.getElement().setAttribute("style", stringBuilder.toString());
    }

    protected void onUnload() {
        super.onUnload();
        if (this.windowResizeHandler != null) {
            FMCUtilities.detachResizeHandler(this.windowResizeHandler);
            this.windowResizeHandler = null;
        }
    }

    public void setMinHeight(int n) {
        String string = this.getElement().getAttribute("style");
        String[] stringArray = string.split("min-height:");
        if (stringArray.length > 1) {
            this.getElement().setAttribute("style", stringArray[0] + "min-height:" + n + "px;");
        } else {
            this.getElement().setAttribute("style", string + "min-height:" + n + "px;");
        }
    }
}

