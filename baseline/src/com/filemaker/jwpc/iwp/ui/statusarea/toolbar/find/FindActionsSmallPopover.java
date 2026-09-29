/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindSetConstrainer;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindSetExtender;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

class FindActionsSmallPopover
extends ToolbarPopover {
    FindActionsSmallPopover(App app) {
        super(app);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FindActionsSmallLayout();
    }

    private class FindActionsSmallLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 206;

        private FindActionsSmallLayout() {
        }

        @Override
        protected void initLayout() {
            this.addComponent((Component)new ToolbarMenuItem(FindActionsSmallPopover.this.app, IWPI18N.get(FindActionsSmallPopover.this.app, "PERFORM_FIND", new Object[0]), FindActionsSmallPopover.this.app.getAM().getAction(UIActionType.PERFORM_FIND)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("find-performer");
                }
            });
            this.addComponent((Component)new FindSetConstrainer(FindActionsSmallPopover.this.app));
            this.addComponent((Component)new FindSetExtender(FindActionsSmallPopover.this.app));
            this.addComponent((Component)new ToolbarMenuItem(FindActionsSmallPopover.this.app, IWPI18N.get(FindActionsSmallPopover.this.app, "EXIT_FIND_MODE", new Object[0]), FindActionsSmallPopover.this.app.getAM().getAction(UIActionType.CANCEL_FIND)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("find-canceler");
                }
            });
            this.setHeight(206.0f, Sizeable.Unit.PIXELS);
        }
    }
}

