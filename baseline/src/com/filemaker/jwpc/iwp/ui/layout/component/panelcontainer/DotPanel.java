/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PanelContainerPanelMetaData;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerPanel;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public class DotPanel
extends PanelContainerPanel {
    private boolean hideConditionOn = false;

    public DotPanel(App app, PanelContainerPanelMetaData panelContainerPanelMetaData, ObjectAttributes objectAttributes) {
        super(app, panelContainerPanelMetaData, objectAttributes);
        this.initUI();
    }

    private void initUI() {
        DotPanel dotPanel = this;
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)dotPanel, null);
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
    }
}

