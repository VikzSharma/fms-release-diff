/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbsoluteLayout
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.component.StatusAreaLabel;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindActionsLargePopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;

class FindActionsLarge
extends AbsoluteLayout {
    private static final int DROPDOWN_WIDTH_IN_PIXEL = 35;
    private static final int WIDTH_IN_PIXEL = 130;
    private final ShowActionsButton actionsButton;

    FindActionsLarge(App app) {
        this.addStyleName("find-all-actions-large");
        this.setWidth(130.0f, Sizeable.Unit.PIXELS);
        this.setHeight(44.0f, Sizeable.Unit.PIXELS);
        FindPerformer findPerformer = new FindPerformer(app);
        this.addComponent((Component)findPerformer, "top: 0px; left: 0px;");
        this.actionsButton = new ShowActionsButton(app);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("top: 0px; left: ").append(95).append("px;");
        this.addComponent((Component)this.actionsButton, stringBuilder.toString());
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    private class FindPerformer
    extends ToolbarButton {
        static final int WIDTH_IN_PIXEL = 95;

        public FindPerformer(App app) {
            super(app, app.getAM().getAction(UIActionType.PERFORM_FIND));
            this.setToolTip(IWPI18N.get(app, "PERFORM_FIND_TOOLTIP", new Object[0]));
            this.addStyleName("find-performer");
            StatusAreaLabel statusAreaLabel = new StatusAreaLabel(app, IWPI18N.get(app, "PERFORM", new Object[0]));
            statusAreaLabel.setDescription(IWPI18N.get(app, "PERFORM_FIND_TOOLTIP", new Object[0]));
            statusAreaLabel.addStyleName("label");
            statusAreaLabel.setSizeUndefined();
            this.addComponent((Component)statusAreaLabel);
            this.app.subscribe(this, EventType.MODE_CHANGE);
            IWPUtilities.assignUniqueId(this.app, "f", (Component)this);
        }

        @Override
        public void onEvent(UIEvent uIEvent) {
            super.onEvent(uIEvent);
            switch (uIEvent.getType()) {
                case MODE_CHANGE: {
                    if (!this.app.isFindMode()) break;
                    super.refresh();
                    break;
                }
            }
        }

        @Override
        public void setEnabled(boolean bl) {
            super.setEnabled(bl);
            FindActionsLarge.this.actionsButton.setEnabled(bl);
        }
    }

    private class ShowActionsButton
    extends ToolbarButton {
        private static final int POPOVER_LEFT_POSITION_1 = 270;
        private static final int POPOVER_LEFT_POSITION_2 = 415;
        private static final int POPOVER_LEFT_POSITION_3 = 465;

        ShowActionsButton(App app) {
            super(app, null);
            this.setToolTip(IWPI18N.get(app, "FIND_ACTIONS_MENU", new Object[0]));
            this.addStyleName("show-actions");
            this.getButton().setId("show-actions");
        }

        @Override
        public void performAction(Object[] objectArray) {
            super.performAction(objectArray);
            ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
            if (toolbarPopover == null || !(toolbarPopover instanceof FindActionsLargePopover)) {
                toolbarPopover = new FindActionsLargePopover(this.app);
                this.app.getStatusAreaContainer().setPopover(toolbarPopover);
                int n = 270;
                int n2 = this.app.getPage().getBrowserWindowWidth();
                if (n2 >= 590) {
                    n = 465;
                } else if (n2 >= 540) {
                    n = 415;
                }
                toolbarPopover.show(n);
            } else {
                this.app.getStatusAreaContainer().exitPopover();
            }
        }
    }
}

