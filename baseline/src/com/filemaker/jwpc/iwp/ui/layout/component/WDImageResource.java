/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.DownloadStream
 *  com.vaadin.server.StreamResource
 *  com.vaadin.server.StreamResource$StreamSource
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.vaadin.server.DownloadStream;
import com.vaadin.server.StreamResource;

public class WDImageResource
extends StreamResource {
    private App app;

    public WDImageResource(StreamResource.StreamSource streamSource, String string) {
        super(streamSource, string);
    }

    public DownloadStream getStream() {
        if (this.app != null) {
            this.app.notifyImageSentToClient(this.getFilename());
        }
        return super.getStream();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

