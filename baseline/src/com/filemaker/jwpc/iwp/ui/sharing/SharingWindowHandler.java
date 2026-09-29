/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.sharing;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.sharing.SharingWindow;

public class SharingWindowHandler {
    private final App app;
    private SharingWindow sharingWindow;

    public SharingWindowHandler(App app) {
        this.app = app;
    }

    public void setWindow(SharingWindow sharingWindow) {
        if (this.sharingWindow != null && this.app.getWindows().contains((Object)this.sharingWindow)) {
            this.app.removeWindow(this.sharingWindow);
        }
        this.sharingWindow = sharingWindow;
    }

    public void openWindow(String string) {
        this.sharingWindow = new SharingWindow(this.app, string);
        this.setWindow(this.sharingWindow);
        if (this.sharingWindow != null) {
            this.sharingWindow.show();
        }
    }

    public void closeWindow() {
        if (this.sharingWindow != null) {
            this.sharingWindow.clear();
            this.sharingWindow = null;
        }
    }
}

