/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.listener.AppContainerListener;
import com.filemaker.jwpc.iwp.ui.statusarea.StatusAreaContainer;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.MainMenubar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseStatusAreaContainer;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindStatusAreaContainer;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.VerticalLayout;

public class AppContainer
extends VerticalLayout {
    protected final App app;
    private static final String CSS_CLASS_NAME = "appContainer";
    public static final int TOOLBAR_HEIGHT_IN_PIXELS = 44;
    private BrowseStatusAreaContainer browse = null;
    private FindStatusAreaContainer finder = null;
    private MainMenubar mainMenubar = null;
    protected LayoutContainer layoutMainContainer;
    protected UIEventListener uiEventListener;
    private AppContainerListener layoutClickListener;
    private boolean useAriaCompliantControl = AppServlet.isAriaCompliantControlEnabled();

    public AppContainer(App app, String string) throws AppRuntimeException {
        this.app = app;
        this.setStyleName(CSS_CLASS_NAME);
        this.setMargin(false);
        this.setSpacing(false);
        this.setSizeFull();
        this.addListeners();
    }

    protected void addListeners() {
        this.layoutClickListener = new AppContainerListener(this.app);
        this.addLayoutClickListener(this.layoutClickListener);
    }

    public void initUI() {
        if (this.app.showStatusArea()) {
            this.mainMenubar = new MainMenubar(this.app);
            if (this.browse == null) {
                this.createBrowseAppChrome();
            }
            if (this.finder != null) {
                this.finder.setVisible(false);
            }
        } else {
            if (this.browse != null) {
                this.browse.setVisible(false);
            }
            if (this.finder != null) {
                this.finder.setVisible(false);
            }
        }
        this.layoutMainContainer = new LayoutContainer(this.app);
        this.layoutMainContainer.setSizeFull();
        this.addComponent((Component)this.layoutMainContainer);
        this.setExpandRatio((Component)this.layoutMainContainer, 1.0f);
        this.subscribeForUIEvents();
        if (this.useAriaCompliantControl) {
            this.setId("app-container");
            IWPUtilities.setAttributeById(this.app, this.getId(), "role", "main");
        }
    }

    protected void subscribeForUIEvents() {
        this.uiEventListener = new UIEventListener(){

            @Override
            public void onEvent(UIEvent uIEvent) {
                block0 : switch (uIEvent.getType()) {
                    case MODE_CHANGE: {
                        LayoutMode layoutMode = AppContainer.this.app.getLayoutDataModel().getMode();
                        switch (layoutMode) {
                            case BROWSE: {
                                AppContainer.this.switchToBrowseMode();
                                AppContainer.this.app.getAppView().updateIsFindModeOnClient(false);
                                break block0;
                            }
                            case FIND: {
                                AppContainer.this.switchToFindMode();
                                AppContainer.this.app.getAppView().updateIsFindModeOnClient(true);
                                break block0;
                            }
                        }
                        break;
                    }
                    case MENUBAR_STATE_CHANGE: {
                        AppContainer.this.updateApplicationChromeVisibility();
                        break;
                    }
                    case TOOLBAR_STATUSAREA_STATE_CHANGE: {
                        AppContainer.this.updateApplicationChromeVisibility();
                        break;
                    }
                }
            }
        };
        this.app.subscribe(this.uiEventListener, EventType.MODE_CHANGE, EventType.TOOLBAR_STATUSAREA_STATE_CHANGE, EventType.MENUBAR_STATE_CHANGE);
    }

    protected void unsubscribeForUIEvents() {
        this.app.unsubscribeAllType(this.uiEventListener);
        this.uiEventListener = null;
    }

    public void cleanupMemory() {
        if (this.mainMenubar != null) {
            this.mainMenubar.invalidate();
        }
        if (this.browse != null) {
            this.browse.invalidate();
        }
        if (this.finder != null) {
            this.finder.invalidate();
        }
        this.unsubscribeForUIEvents();
        this.removeLayoutClickListener(this.layoutClickListener);
        if (this.layoutMainContainer != null) {
            this.layoutMainContainer.cleanupMemory();
        }
    }

    public StatusAreaContainer getStatusAreaContainer() {
        LayoutMode layoutMode = this.app.getLayoutDataModel().getMode();
        if (layoutMode == LayoutMode.FIND) {
            return this.finder;
        }
        return this.browse;
    }

    public LayoutContainer getLayoutContainer() {
        return this.layoutMainContainer;
    }

    public MainMenubar getMenubar() {
        return this.mainMenubar;
    }

    private void updateApplicationChromeVisibility() {
        boolean bl = this.hasVisibleMenubarState();
        boolean bl2 = this.hasVisibleToolbarStatusAreaState();
        if (this.isMenubarVisible() != bl) {
            this.getMenubar().setVisible(bl);
            if (bl) {
                this.app.notify(new UIEvent(EventType.REFRESH_MENUBAR));
            }
        }
        boolean bl3 = false;
        if (this.isToolbarVisible() != bl2) {
            this.getStatusAreaContainer().getToolbar().setVisible(bl2);
            if (bl2) {
                bl3 = true;
            }
        }
        boolean bl4 = bl3 = this.showHideStatusArea(bl || bl2) || bl3;
        if (bl3) {
            this.app.notify(new UIEvent(EventType.REFRESH_STATUS_AREA));
        }
    }

    private boolean showHideStatusArea(boolean bl) {
        boolean bl2 = false;
        if (this.isStatusAreaVisible() != bl) {
            StatusAreaContainer statusAreaContainer = this.getStatusAreaContainer();
            if (statusAreaContainer != null) {
                statusAreaContainer.setVisible(bl);
            }
            this.getLayoutContainer().statusAreaVisibilityChanged();
            this.getLayoutContainer().getPopoverHandler().exitPopover(true);
            if (bl) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean isStatusAreaVisible() {
        StatusAreaContainer statusAreaContainer = this.getStatusAreaContainer();
        if (statusAreaContainer != null) {
            return statusAreaContainer.isVisible();
        }
        return false;
    }

    public boolean isMenubarVisible() {
        return this.getMenubar().isVisible();
    }

    public boolean isToolbarVisible() {
        return this.getStatusAreaContainer().getToolbar().isVisible();
    }

    public boolean hasVisibleToolbarStatusAreaState() {
        return this.app.getDatabaseDataModel().getToolbarStatusAreaState().isShow();
    }

    public boolean hasVisibleMenubarState() {
        return this.app.getDatabaseDataModel().isMenubarVisible();
    }

    protected void switchToFindMode() {
        if (this.finder == null) {
            this.createFinderAppChrome();
        } else {
            this.addComponent((Component)this.finder, 0);
        }
        this.finder.addMenuAtHead();
        this.finder.setVisible(true);
        this.browse.setVisible(false);
        this.removeComponent((Component)this.browse);
        this.updateApplicationChromeVisibility();
    }

    protected void switchToBrowseMode() {
        boolean bl = true;
        if (this.browse == null) {
            bl = false;
            this.createBrowseAppChrome();
        }
        if (!this.browse.isVisible()) {
            if (bl) {
                this.addComponent((Component)this.browse, 0);
            }
            this.browse.addMenuAtHead();
            this.browse.setVisible(true);
            if (this.finder != null) {
                this.finder.setVisible(false);
                this.removeComponent((Component)this.finder);
            }
        }
        this.updateApplicationChromeVisibility();
    }

    private void createBrowseAppChrome() {
        this.browse = new BrowseStatusAreaContainer(this.app, this.mainMenubar);
        this.addComponent((Component)this.browse);
        this.setComponentAlignment((Component)this.browse, Alignment.TOP_CENTER);
        this.browse.setHeight(44.0f, Sizeable.Unit.PIXELS);
    }

    private void createFinderAppChrome() {
        this.finder = new FindStatusAreaContainer(this.app, this.mainMenubar);
        this.addComponent((Component)this.finder, 0);
        this.setComponentAlignment((Component)this.finder, Alignment.TOP_CENTER);
        this.finder.setHeight(44.0f, Sizeable.Unit.PIXELS);
    }
}

