/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

public class RecordMenu
extends ToolbarPopover {
    public RecordMenu(App app) {
        super(app);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new RecordMenuLayout();
    }

    private class RecordMenuLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 162;

        private RecordMenuLayout() {
        }

        @Override
        protected void initLayout() {
            this.addComponent((Component)new ToolbarMenuItem(RecordMenu.this.app, IWPI18N.get(RecordMenu.this.app, "NEW_RECORD", new Object[0]), RecordMenu.this.app.getAM().getAction(UIActionType.CREATE_NEW_ROW)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("record-creator");
                }
            });
            this.addComponent((Component)new ToolbarMenuItem(RecordMenu.this.app, IWPI18N.get(RecordMenu.this.app, "DELETE_RECORD", new Object[0]), RecordMenu.this.app.getAM().getAction(UIActionType.DELETE_ROW)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("record-deleter");
                }
            });
            this.addComponent((Component)new ToolbarMenuItem(RecordMenu.this.app, IWPI18N.get(RecordMenu.this.app, "SORT_RECORDS", new Object[0]), RecordMenu.this.app.getAM().getAction(UIActionType.SORT_RECORDS)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("records-sorter");
                }
            });
            this.setHeight(162.0f, Sizeable.Unit.PIXELS);
        }
    }
}

