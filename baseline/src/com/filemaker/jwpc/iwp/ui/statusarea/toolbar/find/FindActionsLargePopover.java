/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindSetConstrainer;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindSetExtender;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

class FindActionsLargePopover
extends ToolbarPopover {
    FindActionsLargePopover(App app) {
        super(app);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FindActionsLargeLayout();
    }

    private class FindActionsLargeLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private FindActionsLargeLayout() {
        }

        @Override
        protected void initLayout() {
            FindSetConstrainer findSetConstrainer = new FindSetConstrainer(FindActionsLargePopover.this.app);
            findSetConstrainer.setWidth(280.0f, Sizeable.Unit.PIXELS);
            this.addComponent((Component)findSetConstrainer);
            FindSetExtender findSetExtender = new FindSetExtender(FindActionsLargePopover.this.app);
            findSetExtender.setWidth(280.0f, Sizeable.Unit.PIXELS);
            this.addComponent((Component)findSetExtender);
        }
    }
}

