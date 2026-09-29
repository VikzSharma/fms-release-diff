/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class StatusAreaLabel
extends Label {
    protected final App app;

    public StatusAreaLabel(App app, String string) throws AppRuntimeException {
        super(string);
        this.app = app;
    }

    public void setDescription(String string) {
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            super.setDescription(string, ContentMode.HTML);
        }
    }
}

