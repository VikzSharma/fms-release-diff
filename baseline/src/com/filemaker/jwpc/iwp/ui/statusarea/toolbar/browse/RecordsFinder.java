/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FinderPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

public class RecordsFinder
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION_1 = 270;
    private static final int POPOVER_LEFT_POSITION_2 = 450;
    private static final int POPOVER_LEFT_POSITION_3 = 550;
    private final FindRequestCreatorMenuItem requestCreator;
    private final LastFindModifierMenuItem lastFindModifier;

    public RecordsFinder(App app) {
        super(app, null);
        this.addStyleName("records-finder");
        String string = IWPI18N.get(app, "FIND_MENU", new Object[0]);
        this.setToolTip(string);
        this.getButton().setId("findmenu");
        this.requestCreator = new FindRequestCreatorMenuItem(app);
        this.lastFindModifier = new LastFindModifierMenuItem(app);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof FinderPopover)) {
            toolbarPopover = new FinderPopover(this.app, this.requestCreator, this.lastFindModifier);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            int n = 270;
            int n2 = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions().getWidth();
            if (n2 >= 800) {
                n = 550;
            } else if (n2 >= 500) {
                n = 450;
            }
            toolbarPopover.show(n);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }

    class FindRequestCreatorMenuItem
    extends ToolbarMenuItem {
        FindRequestCreatorMenuItem(App app) {
            super(app, IWPI18N.get(app, "ENTER_FIND_MODE", new Object[0]), GlobalUIActionHandlers.GOTO_FIND_MODE);
            this.addStyleName("findrequest-creator");
            this.setEnabled(app.getPrivileges().isCommandEnabled(16));
        }
    }

    class LastFindModifierMenuItem
    extends ToolbarMenuItem {
        LastFindModifierMenuItem(App app) {
            super(app, IWPI18N.get(app, "MODIFY_LAST_FIND", new Object[0]), app.getAM().getAction(UIActionType.MODIFY_LAST_FIND));
            this.addStyleName("lastfind-modifier");
            this.setEnabled(app.getPrivileges().isCommandEnabled(24));
        }
    }
}

