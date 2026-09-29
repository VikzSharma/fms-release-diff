/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.shared.ui.ContentMode;

public abstract class CssLayoutObject
extends AbsoluteCssLayout
implements LayoutObject {
    protected final App app;
    protected LayoutObject parent;
    protected ObjectMetaData metaData;
    protected final ObjectAttributes attributes;
    protected boolean hideConditionOn = false;

    public CssLayoutObject(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(true);
        this.app = app;
        this.metaData = objectMetaData;
        this.attributes = objectAttributes;
        this.setSizeFull();
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
    public void updateUniqueId() {
        this.setId(IWPUtilities.generateUniqueId(this.app, this));
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.metaData;
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
    }

    @Override
    public void registerAccLabel(String string) {
    }

    @Override
    public void registerAccTitle(String string) {
    }

    @Override
    public void registerAccHelp(String string) {
    }
}

