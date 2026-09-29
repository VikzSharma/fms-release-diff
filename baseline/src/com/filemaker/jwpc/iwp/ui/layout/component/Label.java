/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.util.ObjectProperty
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMLabelState;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.ObjectProperty;

public class Label
extends com.vaadin.v7.ui.Label
implements LayoutObject,
HasGlassPane {
    private final App app;
    private final LayoutView layoutView;
    private LayoutObject parent;
    private final ObjectMetaData metaData;
    private final ObjectAttributes attributes;
    private boolean hideConditionOn = false;
    private AbstractComponent selfComponent;
    protected GlassPaneHandler glassPaneHandler;

    public Label(App app, LayoutView layoutView, String string, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(string);
        this.app = app;
        this.layoutView = layoutView;
        this.setContentMode(com.vaadin.v7.shared.ui.label.ContentMode.HTML);
        this.metaData = objectMetaData;
        this.attributes = objectAttributes;
        this.initUI();
    }

    public Label(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this(app, layoutView, IWPUtilities.convertSpacesToNbsp(objectMetaData.getName()), objectMetaData, objectAttributes);
        this.initUI();
    }

    private void initUI() {
        this.selfComponent = new LOWrapper(this, this.getMetaData().getPositionCss());
        LayoutObjectUtilities.setWidthAndHeight(this.layoutView.isClientSideAutoSizing(), this.metaData, (Component)this.selfComponent, this);
        this.addStyleName("text");
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, (AbstractComponent)this);
    }

    @Override
    public void cleanupMemory() {
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.cleanupMemory();
            this.glassPaneHandler = null;
        }
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.getState().mergeField = this.getMetaData().isMergeField();
    }

    public FMLabelState getState() {
        return (FMLabelState)super.getState();
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    @Override
    public int getObjectId() {
        return this.metaData.getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.getId();
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.metaData;
    }

    @Override
    public void updateUniqueId() {
        this.setId(IWPUtilities.generateUniqueId(this.app, this));
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        if (!String.class.isInstance(object)) {
            throw new UnsupportedOperationException();
        }
        String string = IWPUtilities.convertSpacesToNbsp((String)object);
        super.setPropertyDataSource((Property)new ObjectProperty((Object)string, String.class));
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
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
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.updateGlassPane();
        }
    }

    public void setValue(String string) {
        String string2 = IWPUtilities.convertSpacesToNbsp(string);
        super.setValue(string2);
    }

    @Override
    public void addCFStyle(String string) {
        this.selfComponent.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.selfComponent.removeStyleName(string);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        if (this.glassPaneHandler == null) {
            this.glassPaneHandler = new GlassPaneHandler(this, absoluteCssLayout);
        }
        this.glassPaneHandler.updateGlassPane();
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return !this.getMetaData().hasValidAndExecutableScript();
    }

    @Override
    public void registerAccTitle(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    @Override
    public void registerAccHelp(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    @Override
    public void registerAccLabel(String string) {
        this.setDescription(string, ContentMode.HTML);
    }
}

