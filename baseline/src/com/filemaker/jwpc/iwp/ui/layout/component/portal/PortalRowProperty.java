/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.data.Property$ValueChangeNotifier
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PortalMetaData;
import com.filemaker.jwpc.iwp.model.PortalObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbstractLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalRowClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PortalRowState;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import java.util.UUID;

public class PortalRowProperty
extends AbstractLayout
implements Property.ValueChangeNotifier {
    private final Portal portal;
    private boolean isSelected;
    private PortalObjectsModel portalObjectsModel = new PortalObjectsModel();
    private boolean isNewRelatedRecordRow = false;

    public PortalRowProperty(App app, PortalMetaData portalMetaData, Portal portal, ObjectAttributes objectAttributes, boolean bl) {
        super(app, portalMetaData, objectAttributes);
        this.portal = portal;
        this.setId(UUID.randomUUID().toString());
        this.setHeight(PortalRowProperty.getPortalRowHeight(portalMetaData) + "px");
        this.setWidth("100%");
        this.isNewRelatedRecordRow = bl;
        this.initUI();
    }

    private void initUI() {
        PortalRowProperty portalRowProperty = this;
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)portalRowProperty, null);
        this.addStyleName("iwp-portal-row");
    }

    @Override
    public void cleanupMemory() {
        super.cleanupMemory();
        this.portalObjectsModel.cleanupMemory();
        this.getState().childCss.clear();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(PortalRowState.BooleanState.hasEnterTriggers, this.portal.getMetaData().hasEnterTriggers());
        this.updateBooleanState(PortalRowState.BooleanState.validRow, this.getAttributes().getObjectSpec().getPortalRowIndex() != 0);
        this.markAsDirty();
    }

    private void updateBooleanState(PortalRowState.BooleanState booleanState, boolean bl) {
        this.getState().prbs = IWPUtilities.applyBooleanValue(this.getState().prbs, booleanState.ordinal(), bl);
    }

    public PortalRowState getState() {
        return (PortalRowState)super.getState();
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    public boolean isNewRelatedRecordRow() {
        return this.isNewRelatedRecordRow;
    }

    public void updateNewRelatedRecordRow(boolean bl) {
        this.isNewRelatedRecordRow = bl;
    }

    public int getPortalRecordIndex() {
        return this.getAttributes().getPortalRecordIndex();
    }

    public Portal getPortal() {
        return this.portal;
    }

    public static int getPortalRowHeight(PortalMetaData portalMetaData) {
        return portalMetaData.getPortalRowHeight();
    }

    @Override
    public Object getValue() {
        return this;
    }

    public void setSelected(boolean bl, boolean bl2) {
        if (bl) {
            this.setActiveStyleCss();
        } else if (bl2) {
            this.addStyleName("fm-gray-highlight");
        }
        this.isSelected = true;
    }

    public void unsetSelected() {
        this.unsetActiveStyleCss();
        this.removeStyleName("fm-gray-highlight");
        this.isSelected = false;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public PortalObjectsModel getPortalObjectsModel() {
        return this.portalObjectsModel;
    }

    @Override
    public LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        return this.portalObjectsModel.getLayoutObject(this.app, objectSpec);
    }

    public LayoutObject getLayoutObject(int n, short s) {
        return this.portalObjectsModel.getLayoutObject(n, s);
    }

    public void addListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void removeListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void addValueChangeListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void removeValueChangeListener(Property.ValueChangeListener valueChangeListener) {
    }

    @Override
    public void addCFStyle(String string) {
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    private void setActiveStyleCss() {
        ((PortalRowClientRpc)this.getRpcProxy(PortalRowClientRpc.class)).setStyleCSS(true);
    }

    private void unsetActiveStyleCss() {
        ((PortalRowClientRpc)this.getRpcProxy(PortalRowClientRpc.class)).setStyleCSS(false);
    }
}

