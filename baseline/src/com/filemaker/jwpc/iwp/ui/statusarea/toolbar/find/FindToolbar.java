/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.RecordsNavigator;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.Toolbar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.LayoutEditor;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindActionsLarge;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindActionsSmall;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindCanceler;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindOperatorMenuButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindRequestCreator;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindRequestSettings;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindRequestsNavigatorSmall;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;

public class FindToolbar
extends Toolbar {
    static final int WIDTH_2_DIPS = 540;
    static final int WIDTH_3_DIPS = 590;
    private final RecordsNavigator requestsNavigator;
    private final FindRequestSettings requestSettings;
    private final FindRequestCreator requestCreator;
    private FindOperatorMenuButton operatorsMenubar;
    private FindCanceler findCanceler;
    private FindActionsLarge findActionsLarge;
    private FindActionsSmall findActionsSmall;

    public FindToolbar(App app) throws AppRuntimeException {
        super(app);
        this.addStyleName("find");
        this.requestsNavigator = new FindRequestsNavigatorSmall(this.app);
        this.requestSettings = new FindRequestSettings(app);
        this.requestCreator = new FindRequestCreator(app);
        this.constructToolbar(app.getPage().getBrowserWindowWidth());
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    public void invalidate() {
        if (this.requestsNavigator != null) {
            this.requestsNavigator.invalidate();
        }
        this.removeAllComponents();
    }

    @Override
    public boolean isReconstructNeeded(int n, int n2) {
        boolean bl = true;
        bl = n >= 590 ? n2 < 590 : (n >= 540 ? n2 < 540 || n2 >= 590 : n2 >= 540);
        return bl;
    }

    @Override
    public void constructToolbar(int n) {
        super.constructToolbar(n);
        this.addComponent((Component)this.requestsNavigator);
        this.addComponent((Component)this.requestSettings);
        this.addComponent((Component)this.requestCreator);
        if (n >= 590) {
            this.renderOperatorsMenubar();
            this.renderFindAllActionLarge();
            this.renderFindCanceler();
        } else if (n >= 540) {
            this.renderOperatorsMenubar();
            this.renderFindAllActionLarge();
            this.renderFindCanceler();
        } else {
            this.renderFindAllActionSmall();
        }
        Label label = new Label();
        this.addComponent((Component)label);
        this.setExpandRatio((Component)label, 1.0f);
    }

    private void renderOperatorsMenubar() {
        if (this.operatorsMenubar == null) {
            this.operatorsMenubar = new FindOperatorMenuButton(this.app);
        }
        this.addComponent((Component)this.operatorsMenubar);
    }

    private void renderFindCanceler() {
        if (this.findCanceler == null) {
            this.findCanceler = new FindCanceler(this.app);
        }
        this.addComponent((Component)this.findCanceler);
    }

    private void renderFindAllActionLarge() {
        if (this.findActionsLarge == null) {
            this.findActionsLarge = new FindActionsLarge(this.app);
        }
        this.addComponent((Component)this.findActionsLarge);
    }

    private void renderFindAllActionSmall() {
        if (this.findActionsSmall == null) {
            this.findActionsSmall = new FindActionsSmall(this.app);
        }
        this.addComponent((Component)this.findActionsSmall);
    }

    @Override
    public QuickFind getQuickFind() {
        return null;
    }

    @Override
    public LayoutEditor getLayoutEditor() {
        return null;
    }
}

