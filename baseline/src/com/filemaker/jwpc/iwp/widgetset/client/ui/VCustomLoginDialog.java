/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomUserAndPWDDialog;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;

public class VCustomLoginDialog
extends VCustomUserAndPWDDialog {
    private static final String LOGIN_HEADER_ID = "login_header_msg";
    private static final int LOGIN_HEADER_LINE_HEIGHT = 20;

    @Override
    public void show() {
        super.show();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (FMCUtilities.isMobile()) {
                    boolean bl = VCustomLoginDialog.this.performOrientationCheck();
                    VCustomLoginDialog.this.setupOrientationQuery(VCustomLoginDialog.this.getOrientationQuery(), bl);
                }
            }
        });
    }

    private native boolean performOrientationCheck();

    private native void setupOrientationQuery(JavaScriptObject var1, boolean var2);

    private native JavaScriptObject getOrientationQuery();

    public native void updateLoginHeader(String var1, String var2, String var3);
}

