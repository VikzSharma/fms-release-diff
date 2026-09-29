/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindActionsSmallPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

class FindActionsSmall
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION = 270;

    FindActionsSmall(App app) {
        super(app, null);
        this.setToolTip(IWPI18N.get(app, "FIND_ACTIONS_MENU", new Object[0]));
        this.addStyleName("find-all-actions");
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
        this.getButton().setId("show-actions");
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof FindActionsSmallPopover)) {
            toolbarPopover = new FindActionsSmallPopover(this.app);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            toolbarPopover.show(270);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }
}

