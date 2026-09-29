/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event
 *  com.vaadin.v7.client.ui.VLabel
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.google.gwt.user.client.Event;
import com.vaadin.v7.client.ui.VLabel;

public class VCustomLabel
extends VLabel {
    private final FMClientEventManager eventManager = new FMClientEventManager(this.getElement(), true, true);

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.eventManager.handleEvent(event, this.getParent());
    }

    public native void forceRepaint(String var1);
}

