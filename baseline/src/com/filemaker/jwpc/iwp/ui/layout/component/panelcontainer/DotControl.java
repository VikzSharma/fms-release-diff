/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.TabSheet$Tab
 */
package com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.DotControlMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.DotControlClientRPC;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public class DotControl
extends PanelContainerControl {
    private DotControlMetaData metaData;

    public DotControl(App app, LayoutView layoutView, DotControlMetaData dotControlMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, dotControlMetaData, objectAttributes);
        this.metaData = dotControlMetaData;
        this.initUI();
    }

    private void initUI() {
        DotControl dotControl = this;
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)dotControl, null);
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    @Override
    public DotControlMetaData getMetaData() {
        return this.metaData;
    }

    @Override
    public void initTabs() {
        super.initTabs();
        if (this.metaData.isDotsHidden()) {
            this.hideTabs(true);
        }
    }

    @Override
    protected void updateDynamicCation(TabSheet.Tab tab, Component component) {
    }

    @Override
    protected void refreshPosition() {
        ((DotControlClientRPC)this.getRpcProxy(DotControlClientRPC.class)).refreshPosition();
    }

    @Override
    protected void reapplyPosition() {
    }

    @Override
    public void registerAccTitle(String string) {
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

