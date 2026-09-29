/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.Event$NativePreviewHandler
 */
package com.filemaker.menu.widgetset.client;

import com.filemaker.menu.widgetset.client.AbstractMenuOverlay;
import com.google.gwt.user.client.Event;

public class EscKeyNativePreviewHandler
implements Event.NativePreviewHandler {
    private final AbstractMenuOverlay menuOverlay;

    public EscKeyNativePreviewHandler(AbstractMenuOverlay abstractMenuOverlay) {
        this.menuOverlay = abstractMenuOverlay;
    }

    public void onPreviewNativeEvent(Event.NativePreviewEvent nativePreviewEvent) {
        if (nativePreviewEvent.getNativeEvent().getKeyCode() == 27) {
            this.menuOverlay.hide();
        }
    }
}

