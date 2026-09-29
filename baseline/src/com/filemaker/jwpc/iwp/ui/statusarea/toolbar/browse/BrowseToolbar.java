/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.RecordsNavigator;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.Toolbar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseRecordsNavigatorLarge;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseRecordsNavigatorSmall;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FoundSetPieCharter;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.LayoutEditor;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordCreator;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordDeleter;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordMenuButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordsFinder;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.RecordsSorter;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.ShareButton;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;

public class BrowseToolbar
extends Toolbar {
    static final int WIDTH_500_DIPS = 500;
    static final int WIDTH_700_DIPS = 700;
    static final int WIDTH_800_DIPS = 800;
    private RecordsNavigator recordsNavigatorSmall;
    private RecordsNavigator recordsNavigatorLarge;
    private FoundSetPieCharter foundsetPieCharter;
    private RecordCreator recordCreator;
    private RecordDeleter recordDeleter;
    private RecordsSorter recordsSorter;
    private RecordMenuButton recordsMenubar;
    private RecordsFinder finderMenuButton;
    private QuickFind quickFind;
    private ShareButton share;
    private LayoutEditor layoutEditor;

    public BrowseToolbar(App app) throws AppRuntimeException {
        super(app);
        this.addStyleName("browse");
        this.constructToolbar(app.getPage().getBrowserWindowWidth());
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    public void invalidate() {
        if (this.recordsNavigatorLarge != null) {
            this.recordsNavigatorLarge.invalidate();
        }
        if (this.recordsNavigatorSmall != null) {
            this.recordsNavigatorSmall.invalidate();
        }
        if (this.foundsetPieCharter != null) {
            this.foundsetPieCharter.invalidate();
        }
        this.removeAllComponents();
    }

    @Override
    public boolean isReconstructNeeded(int n, int n2) {
        boolean bl = true;
        bl = n >= 800 ? n2 < 800 : (n >= 700 ? n2 < 700 || n2 >= 800 : (n >= 500 ? n2 < 500 || n2 >= 700 : n2 >= 500));
        return bl;
    }

    @Override
    public void constructToolbar(int n) {
        super.constructToolbar(n);
        this.renderRecordsNavigator(n);
        if (n >= 800) {
            this.renderFoundSetMenubar();
            this.renderFullRecordsToolbar();
            this.renderFullFindToolbar();
        } else if (n >= 700) {
            this.renderFoundSetMenubar();
            this.renderRecordsMenubar();
            this.renderFullFindToolbar();
        } else if (n >= 500) {
            this.renderFoundSetMenubar();
            this.renderRecordsMenubar();
            this.renderFinderMenubar();
        } else {
            this.renderRecordsMenubar();
            this.renderFinderMenubar();
        }
        Label label = new Label();
        this.addComponent((Component)label);
        this.setExpandRatio((Component)label, 1.0f);
        if (!BrowserInfoHandler.isMobile(this.app)) {
            this.renderLayoutEditor();
            this.layoutEditor.setVisible(IWPUtilities.isLayoutEditorAvailable(this.app));
        }
    }

    private void renderRecordsNavigator(int n) {
        if (n >= 500) {
            if (this.recordsNavigatorLarge == null) {
                this.recordsNavigatorLarge = new BrowseRecordsNavigatorLarge(this.app);
            }
            this.addComponent((Component)this.recordsNavigatorLarge);
        } else {
            if (this.recordsNavigatorSmall == null) {
                this.recordsNavigatorSmall = new BrowseRecordsNavigatorSmall(this.app);
            }
            this.addComponent((Component)this.recordsNavigatorSmall);
        }
    }

    private void renderFoundSetMenubar() {
        if (this.foundsetPieCharter == null) {
            this.foundsetPieCharter = new FoundSetPieCharter(this.app);
        }
        this.addComponent((Component)this.foundsetPieCharter);
    }

    private void renderFullRecordsToolbar() {
        if (this.recordCreator == null) {
            this.recordCreator = new RecordCreator(this.app);
        }
        this.addComponent((Component)this.recordCreator);
        if (this.recordDeleter == null) {
            this.recordDeleter = new RecordDeleter(this.app);
        }
        this.addComponent((Component)this.recordDeleter);
        if (this.recordsSorter == null) {
            this.recordsSorter = new RecordsSorter(this.app);
        }
        this.addComponent((Component)this.recordsSorter);
    }

    private void renderRecordsMenubar() {
        if (this.recordsMenubar == null) {
            this.recordsMenubar = new RecordMenuButton(this.app);
        }
        this.addComponent((Component)this.recordsMenubar);
    }

    private void renderShareButton() {
        if (this.share == null) {
            this.share = new ShareButton(this.app);
        }
        this.addComponent((Component)this.share);
    }

    private void renderLayoutEditor() {
        this.layoutEditor = this.getLayoutEditor();
        this.addComponent((Component)this.layoutEditor);
    }

    private void renderFinderMenubar() {
        if (this.finderMenuButton == null) {
            this.finderMenuButton = new RecordsFinder(this.app);
        }
        this.addComponent((Component)this.finderMenuButton);
    }

    private void renderFullFindToolbar() {
        this.renderFinderMenubar();
        this.quickFind = this.getQuickFind();
        this.addComponent((Component)this.quickFind);
    }

    @Override
    public QuickFind getQuickFind() {
        if (this.quickFind == null) {
            this.quickFind = new QuickFind(this.app);
        }
        return this.quickFind;
    }

    @Override
    public LayoutEditor getLayoutEditor() {
        if (this.layoutEditor == null) {
            this.layoutEditor = new LayoutEditor(this.app);
        }
        return this.layoutEditor;
    }
}

