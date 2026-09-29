/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseRecordsMenuSlider;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FoundSetPieCharterInPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;

public class FoundSetPopover
extends ToolbarPopover {
    public FoundSetPopover(App app) {
        super(app);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FoundSetPopoverLayout();
    }

    private class FoundSetPopoverLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 366;

        private FoundSetPopoverLayout() {
        }

        @Override
        protected void initLayout() {
            this.addComponent((Component)new FoundSetPieCharterInPopover(FoundSetPopover.this.app));
            this.addComponent((Component)new BrowseRecordsMenuSlider(FoundSetPopover.this.app));
            this.addComponent((Component)new ToolbarMenuItem(FoundSetPopover.this.app, IWPI18N.get(FoundSetPopover.this.app, "SHOW_ALL_BROWSE", new Object[0]), FoundSetPopover.this.app.getAM().getAction(UIActionType.SHOW_ALL_RECORDS)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("records-showall");
                    this.app.subscribe(this, EventType.FOUND_RECORDS_CHANGE);
                }

                @Override
                public void onEvent(UIEvent uIEvent) {
                    super.onEvent(uIEvent);
                    switch (uIEvent.getType()) {
                        case FOUND_RECORDS_CHANGE: {
                            this.refresh();
                        }
                    }
                }
            });
            this.addComponent((Component)new ToolbarMenuItem(FoundSetPopover.this.app, IWPI18N.get(FoundSetPopover.this.app, "SHOW_OMITTED", new Object[0]), FoundSetPopover.this.app.getAM().getAction(UIActionType.SHOW_OMITTED_RECORDS)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("records-showomitted");
                }
            });
            this.addComponent((Component)new ToolbarMenuItem(FoundSetPopover.this.app, IWPI18N.get(FoundSetPopover.this.app, "OMIT_RECORD", new Object[0]), FoundSetPopover.this.app.getAM().getAction(UIActionType.OMIT_RECORD)){

                @Override
                protected void init(UIAction uIAction) {
                    super.init(uIAction);
                    this.addStyleName("record-omit");
                    this.app.subscribe(this, EventType.FOUND_RECORDS_CHANGE);
                }

                @Override
                public void onEvent(UIEvent uIEvent) {
                    super.onEvent(uIEvent);
                    switch (uIEvent.getType()) {
                        case FOUND_RECORDS_CHANGE: {
                            this.refresh();
                        }
                    }
                }
            });
            this.setHeight(366.0f, Sizeable.Unit.PIXELS);
        }

        public String getCss(Component component) {
            if (component instanceof Label) {
                return "position: absolute; top: 20px; left: 60px;";
            }
            return super.getCss(component);
        }
    }
}

