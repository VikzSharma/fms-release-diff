/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

public class FindRequestSetPopover
extends ToolbarPopover {
    public FindRequestSetPopover(App app) {
        super(app);
        this.addStyleName("findrequest-set");
        this.generatePopover();
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FindRequestSetPopoverLayout();
    }

    public class FindRequestSetPopoverLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 206;

        @Override
        protected void initLayout() {
            this.setHeight(206.0f, Sizeable.Unit.PIXELS);
            FindRequestIncludeOmit findRequestIncludeOmit = new FindRequestIncludeOmit(FindRequestSetPopover.this.app);
            this.addComponent((Component)findRequestIncludeOmit);
            FindRequestDeleter findRequestDeleter = new FindRequestDeleter(FindRequestSetPopover.this.app);
            this.addComponent((Component)findRequestDeleter);
            FindRequestDuplicator findRequestDuplicator = new FindRequestDuplicator(FindRequestSetPopover.this.app);
            this.addComponent((Component)findRequestDuplicator);
        }

        public class FindRequestIncludeOmit
        extends CssLayout
        implements StatusAreaComponent {
            private static final String INCLUDE_CSS_SELECTOR_NAME = "findrequest-include";
            private static final String OMIT_CSS_SELECTOR_NAME = "findrequest-omit";
            private static final String SELECTED_CSS_SELECTOR_NAME = "selected";
            private static final String UNSELECTED_CSS_SELECTOR_NAME = "unselected";
            private static final String INCLUDE_SELECTED_CSS_SELECTOR_NAME = "findrequest-include selected";
            private static final String OMIT_UNSELECTED_CSS_SELECTOR_NAME = "findrequest-omit unselected";
            private final App app;
            private final FindRequestInclude reqInclude;
            private final FindRequestOmit reqOmit;

            FindRequestIncludeOmit(App app) {
                this.app = app;
                this.addStyleName("findrequest-includeomit");
                this.reqInclude = new FindRequestInclude(app);
                this.addComponent((Component)this.reqInclude);
                this.reqOmit = new FindRequestOmit(app);
                this.addComponent((Component)this.reqOmit);
                this.refresh();
                this.app.subscribe(this, EventType.OMIT_REQUEST_STATE_CHANGE, EventType.MODE_CHANGE);
            }

            @Override
            public void onEvent(UIEvent uIEvent) {
                if (this.app.isFindMode()) {
                    switch (uIEvent.getType()) {
                        case MODE_CHANGE: 
                        case OMIT_REQUEST_STATE_CHANGE: {
                            this.refresh();
                            break;
                        }
                    }
                }
            }

            @Override
            public void refresh() {
                if (this.app.getLayoutDataModel().isOmitRequest()) {
                    this.reqOmit.removeStyleName(UNSELECTED_CSS_SELECTOR_NAME);
                    this.reqOmit.addStyleName(SELECTED_CSS_SELECTOR_NAME);
                    this.reqInclude.removeStyleName(SELECTED_CSS_SELECTOR_NAME);
                    this.reqInclude.addStyleName(UNSELECTED_CSS_SELECTOR_NAME);
                } else {
                    this.reqInclude.removeStyleName(UNSELECTED_CSS_SELECTOR_NAME);
                    this.reqInclude.addStyleName(SELECTED_CSS_SELECTOR_NAME);
                    this.reqOmit.removeStyleName(SELECTED_CSS_SELECTOR_NAME);
                    this.reqOmit.addStyleName(UNSELECTED_CSS_SELECTOR_NAME);
                }
            }

            private class FindRequestInclude
            extends ToolbarMenuItem {
                FindRequestInclude(App app) {
                    super(app, IWPI18N.get(app, "INCLUDE", new Object[0]), GlobalUIActionHandlers.TOGGLE_OMIT_STATE);
                    this.setWidth(250.0f, Sizeable.Unit.PIXELS);
                    this.setHeight(34.0f, Sizeable.Unit.PIXELS);
                    this.addStyleName(FindRequestIncludeOmit.INCLUDE_SELECTED_CSS_SELECTOR_NAME);
                }

                @Override
                public void performAction(Object[] objectArray) {
                    super.performAction(objectArray);
                    this.app.getLayoutDataModel().updateOmitRequest(false);
                }
            }

            private class FindRequestOmit
            extends ToolbarMenuItem {
                FindRequestOmit(App app) {
                    super(app, IWPI18N.get(app, "OMIT", new Object[0]), GlobalUIActionHandlers.TOGGLE_OMIT_STATE);
                    this.setWidth(250.0f, Sizeable.Unit.PIXELS);
                    this.setHeight(34.0f, Sizeable.Unit.PIXELS);
                    this.addStyleName(FindRequestIncludeOmit.OMIT_UNSELECTED_CSS_SELECTOR_NAME);
                }

                @Override
                public void performAction(Object[] objectArray) {
                    super.performAction(objectArray);
                    this.app.getLayoutDataModel().updateOmitRequest(true);
                }
            }
        }

        private class FindRequestDeleter
        extends ToolbarMenuItem {
            FindRequestDeleter(App app) {
                super(app, IWPI18N.get(app, "DELETE_FIND_REQUEST", new Object[0]), app.getAM().getAction(UIActionType.DELETE_ROW));
                this.addStyleName("findrequest-deleter");
            }
        }

        private class FindRequestDuplicator
        extends ToolbarMenuItem {
            private FindRequestDuplicator(App app) {
                super(app, IWPI18N.get(app, "DUPLICATE_REQUEST", new Object[0]), app.getAM().getAction(UIActionType.DUP_ROW));
                this.addStyleName("findrequest-duplicator");
            }
        }
    }
}

