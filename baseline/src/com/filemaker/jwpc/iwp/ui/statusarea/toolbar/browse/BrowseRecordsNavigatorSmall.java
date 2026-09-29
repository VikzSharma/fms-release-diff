/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.RecordsNavigator;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FoundSetPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

public class BrowseRecordsNavigatorSmall
extends RecordsNavigator {
    public BrowseRecordsNavigatorSmall(App app) {
        super(app);
        this.setStyleName("navigator small");
        this.previous.setWidth(60.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.previous);
        this.addComponent((Component)new FoundSetButton(app));
        this.next.setWidth(60.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.next);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    private class FoundSetButton
    extends ToolbarButton {
        private static final int POPOVER_LEFT_POSITION = 110;

        FoundSetButton(App app) {
            super(app, null);
            this.addStyleName("middlebutton");
            this.getButton().setId("foundsetpiechart");
            String string = IWPI18N.get(app, "FOUND_SET_MENU", new Object[0]);
            this.setToolTip(string);
        }

        @Override
        public void performAction(Object[] objectArray) {
            super.performAction(objectArray);
            ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
            if (toolbarPopover == null || !(toolbarPopover instanceof FoundSetPopover)) {
                toolbarPopover = new FoundSetPopover(this.app);
                this.app.getStatusAreaContainer().setPopover(toolbarPopover);
                toolbarPopover.show(110);
            } else {
                this.app.getStatusAreaContainer().exitPopover();
            }
        }
    }
}

