/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordMenu;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

class RecordMenuButton
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION_1 = 220;
    private static final int POPOVER_LEFT_POSITION_2 = 400;

    public RecordMenuButton(App app) throws AppRuntimeException {
        super(app, null);
        this.addStyleName("record-menubar");
        String string = IWPI18N.get(app, "RECORD_MENU", new Object[0]);
        this.setToolTip(string);
        this.getButton().setId("recordmenu");
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof RecordMenu)) {
            toolbarPopover = new RecordMenu(this.app);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            int n = 220;
            int n2 = this.app.getPage().getBrowserWindowWidth();
            if (n2 >= 500) {
                n = 400;
            }
            toolbarPopover.show(n);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }
}

