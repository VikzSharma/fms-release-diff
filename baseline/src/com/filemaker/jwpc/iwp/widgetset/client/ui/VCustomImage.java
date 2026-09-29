/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VCssLayout;

public class VCustomImage
extends VCssLayout {
    private final FMClientEventManager eventManager = BrowserInfo.get().isIE() ? new FMClientEventManager(this.getElement(), false, true) : null;

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.eventManager != null) {
            this.eventManager.handleEvent(event, this.getParent());
        }
    }
}

