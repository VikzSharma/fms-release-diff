/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.event.BrowserWidthChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.MainMenubar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.Toolbar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;

public abstract class StatusAreaContainer
extends HorizontalLayout
implements UIEventListener {
    private static final String CSS_NAME = "fm-statusarea-container";
    protected final App app;
    protected int browserWidth;
    private final MainMenubar mainMenubar;
    private final Toolbar toolbar;
    private Component selectedControl;
    private ToolbarPopover toolbarPopover;
    private boolean shouldExitPopover;

    public StatusAreaContainer(App app, Toolbar toolbar, MainMenubar mainMenubar) throws AppRuntimeException {
        this.app = app;
        this.toolbar = toolbar;
        this.mainMenubar = mainMenubar;
        this.browserWidth = this.app.getPage().getBrowserWindowWidth();
        this.shouldExitPopover = true;
        this.setStyleName(CSS_NAME);
        this.setMargin(false);
        this.setSpacing(false);
        this.setSizeFull();
        this.addComponent((Component)this.mainMenubar);
        this.addComponent((Component)toolbar);
        this.setExpandRatio((Component)toolbar, 1.0f);
        if (!app.getDatabaseDataModel().isMenubarVisible() && !app.getDatabaseDataModel().getToolbarStatusAreaState().isShow()) {
            this.setVisible(false);
        }
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
        this.app.subscribe(this, EventType.MODE_CHANGE, EventType.TOOLBAR_STATUSAREA_STATE_CHANGE);
    }

    public void invalidate() {
        this.toolbar.invalidate();
    }

    public void addMenuAtHead() {
        if (this.getComponentIndex((Component)this.mainMenubar) < 0) {
            this.addComponent((Component)this.mainMenubar, 0);
        }
    }

    public void browserResized() {
        int n;
        this.exitPopover();
        if (this.mainMenubar != null) {
            this.mainMenubar.closeMenu();
        }
        if ((n = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions().getWidth()) != this.browserWidth) {
            boolean bl = this.toolbar.isReconstructNeeded(n, this.browserWidth);
            if (bl) {
                this.constructToolbar(n);
            }
            this.app.notify(new BrowserWidthChangeEvent(this.browserWidth));
            this.browserWidth = n;
        }
    }

    private void constructToolbar(int n) {
        this.exitPopover();
        if (this.browserWidth != n) {
            if (this.toolbar.getComponentCount() > 0) {
                this.toolbar.removeAllComponents();
            }
            this.toolbar.constructToolbar(n);
        }
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public MainMenubar getMainMenuBar() {
        return this.mainMenubar;
    }

    public void setSelectedControl(Component component) {
        this.selectedControl = component;
    }

    public Component getSelectedControl() {
        return this.selectedControl;
    }

    public void setPopover(ToolbarPopover toolbarPopover) {
        this.toolbarPopover = toolbarPopover;
    }

    public ToolbarPopover getPopover() {
        return this.toolbarPopover;
    }

    public boolean shouldExitPopover() {
        return this.shouldExitPopover;
    }

    public void setShouldExitPopover(boolean bl) {
        this.shouldExitPopover = bl;
    }

    public void exitPopover() {
        if (this.toolbarPopover != null && this.toolbarPopover.isVisible()) {
            this.toolbarPopover.close();
            this.toolbarPopover = null;
            if (this.selectedControl != null) {
                this.selectedControl.removeStyleName("selected");
            }
        }
    }

    public void logout() {
        this.exitPopover();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case MODE_CHANGE: 
            case TOOLBAR_STATUSAREA_STATE_CHANGE: {
                this.constructToolbar(this.app.getUI().getPage().getBrowserWindowWidth());
                break;
            }
        }
    }
}

