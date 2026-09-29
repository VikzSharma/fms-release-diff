/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class ToolbarPopoverCloser
extends ToolbarMenuItem {
    public ToolbarPopoverCloser(App app) throws AppRuntimeException {
        super(app, null, null);
        this.addStyleName("popover-closer");
        this.setId("toolbar-popover-closer-btn");
        IWPUtilities.setAriaLabelById(app, this.getId(), IWPI18N.get(app, "CLOSE", new Object[0]));
    }

    @Override
    protected void performServerAction() {
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.app.getStatusAreaContainer().getPopover().shouldSetFocusOnDetach();
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){

                @Override
                public void run() {
                    ToolbarPopoverCloser.super.performServerAction();
                    ToolbarPopoverCloser.this.app.pushChanges();
                }
            }, 100L);
        } else {
            super.performServerAction();
        }
    }
}

