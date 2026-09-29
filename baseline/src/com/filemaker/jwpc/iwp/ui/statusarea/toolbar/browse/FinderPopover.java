/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordsFinder;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;

public class FinderPopover
extends ToolbarPopover {
    private RecordsFinder.FindRequestCreatorMenuItem requestCreator;
    private RecordsFinder.LastFindModifierMenuItem lastFindModifier;

    public FinderPopover(App app, RecordsFinder.FindRequestCreatorMenuItem findRequestCreatorMenuItem, RecordsFinder.LastFindModifierMenuItem lastFindModifierMenuItem) {
        this(app);
        this.requestCreator = findRequestCreatorMenuItem;
        this.lastFindModifier = lastFindModifierMenuItem;
    }

    public FinderPopover(App app) {
        super(app);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FinderPopoverLayout();
    }

    public class FinderPopoverLayout
    extends ToolbarPopover.ToolbarPopoverLayout
    implements StatusAreaComponent {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 162;
        private static final int LAYOUT_HEIGHT_SHORTER_IN_PIXEL = 118;
        private static final int LAYOUT_HEIGHT_SHORTEST_IN_PIXEL = 74;

        @Override
        protected void initLayout() {
            this.addQuickFindIfRequired();
            if (FinderPopover.this.requestCreator != null) {
                this.addComponent((Component)FinderPopover.this.requestCreator);
            }
            if (FinderPopover.this.lastFindModifier != null) {
                this.addComponent((Component)FinderPopover.this.lastFindModifier);
            }
            FinderPopover.this.app.subscribe(this, EventType.BROWSER_WIDTH_CHANGE);
        }

        private void addQuickFindIfRequired() {
            if (FinderPopover.this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions().getWidth() < 700) {
                this.setHeight(162.0f, Sizeable.Unit.PIXELS);
                Object object = null;
                int n = this.getComponentCount();
                if (n > 0) {
                    object = this.getComponent(0);
                }
                if (n == 0 || !(object instanceof QuickFindMenuItem)) {
                    object = new QuickFindMenuItem(FinderPopover.this.app);
                }
                this.addComponent((Component)object, 0);
            } else {
                this.setHeight(118.0f, Sizeable.Unit.PIXELS);
            }
        }

        @Override
        public void onEvent(UIEvent uIEvent) {
            switch (uIEvent.getType()) {
                case BROWSER_WIDTH_CHANGE: {
                    if (!FinderPopover.this.app.isBrowseMode()) break;
                    this.addQuickFindIfRequired();
                    break;
                }
            }
        }

        @Override
        public void refresh() {
        }

        public class QuickFindMenuItem
        extends QuickFind {
            public QuickFindMenuItem(App app) {
                super(app);
                this.combo.setDescription("", ContentMode.HTML);
            }

            @Override
            public void addClickListener() {
                this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

                    public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                        if (BrowserInfoHandler.isAndroidDevice(FinderPopover.this.app)) {
                            FinderPopover.this.displayHeight = 74.0f;
                        }
                    }
                });
            }
        }
    }
}

