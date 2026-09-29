/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.TouchStartEvent
 *  com.google.gwt.event.dom.client.TouchStartHandler
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.v7.client.ui.VTextArea
 */
package com.filemaker.fields.client.textarea;

import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.vaadin.client.BrowserInfo;
import com.vaadin.v7.client.ui.VTextArea;

public class VCustomDeprecatedTextArea
extends VTextArea
implements TouchStartHandler {
    public VCustomDeprecatedTextArea() {
        this.addTouchStartHandler(this);
    }

    public void onTouchStart(TouchStartEvent touchStartEvent) {
        if (BrowserInfo.get().isIOS()) {
            touchStartEvent.stopPropagation();
        }
    }
}

