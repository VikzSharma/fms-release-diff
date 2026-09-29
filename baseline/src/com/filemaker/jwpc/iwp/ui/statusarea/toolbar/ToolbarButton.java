/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.customwidgets.StatusAreaButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

public class ToolbarButton
extends StatusAreaButton {
    public static final int HEIGHT_IN_PIXEL = 44;
    public static final int WIDTH_IN_PIXEL = 50;
    public static final String TOOLBAR_ITEM_CSS_SELECTOR_NAME = "fm-toolbar-item";
    protected static final String LABEL_CSS_SELECTOR_NAME = "label";
    private static final String SELECTED_CSS_SELECTOR_NAME = "selected";

    public ToolbarButton(App app, UIAction uIAction) {
        this(app, null, uIAction);
    }

    public ToolbarButton(App app, String string, UIAction uIAction) {
        super(app, string, uIAction);
        this.setStyleName(TOOLBAR_ITEM_CSS_SELECTOR_NAME);
        this.setHeight(44.0f, Sizeable.Unit.PIXELS);
        this.getButton().setSizeFull();
    }

    @Override
    protected void addListeners() {
        this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                ToolbarButton.this.performAction(null, layoutClickEvent);
            }
        });
    }

    private void performAction(Object[] objectArray, LayoutEvents.LayoutClickEvent layoutClickEvent) {
        if (!layoutClickEvent.isDoubleClick()) {
            Component component = this.app.getStatusAreaContainer().getSelectedControl();
            if (component != null) {
                component.removeStyleName(SELECTED_CSS_SELECTOR_NAME);
            }
            this.performAction(objectArray);
            ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
            if (component != this || toolbarPopover != null && toolbarPopover.isVisible()) {
                this.app.getStatusAreaContainer().setSelectedControl((Component)this);
                this.addStyleName(SELECTED_CSS_SELECTOR_NAME);
            }
        }
    }
}

