/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.HorizontalLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.LayoutEditor;
import com.vaadin.v7.ui.HorizontalLayout;

public abstract class Toolbar
extends HorizontalLayout {
    private static final String CSS_SELECTOR_NAME = "fm-toolbar";
    protected final App app;
    protected ToolbarPopover popover;

    public Toolbar(App app) throws AppRuntimeException {
        this.app = app;
        this.setMargin(false);
        this.setSpacing(false);
        this.setStyleName(CSS_SELECTOR_NAME);
        this.setSizeFull();
        if (!app.getDatabaseDataModel().getToolbarStatusAreaState().isShow()) {
            this.setVisible(false);
        }
    }

    public abstract boolean isReconstructNeeded(int var1, int var2);

    public void constructToolbar(int n) {
    }

    public abstract void invalidate();

    public abstract QuickFind getQuickFind();

    public abstract LayoutEditor getLayoutEditor();
}

