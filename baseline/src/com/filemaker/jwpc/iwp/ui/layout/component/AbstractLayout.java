/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.Property$ReadOnlyException
 *  com.vaadin.v7.data.util.converter.Converter$ConversionException
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.converter.Converter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractLayout
extends CssLayoutObject
implements LayoutContainerObject,
Property {
    private List<LayoutObject> childs = new ArrayList<LayoutObject>();
    private String layoutName;

    public AbstractLayout(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.layoutName = objectMetaData.getName();
    }

    @Override
    public void cleanupMemory() {
        if (this.childs != null) {
            for (LayoutObject layoutObject : this.childs) {
                layoutObject.cleanupMemory();
            }
            this.childs.clear();
            this.childs = null;
        }
    }

    public String getLayoutName() {
        return this.layoutName;
    }

    @Override
    public void addChild(RepetitionContainer repetitionContainer) {
        this.addChildAsComponent(repetitionContainer);
        for (LayoutFieldObject layoutFieldObject : repetitionContainer.getRepetitionObjects().values()) {
            this.childs.add(layoutFieldObject);
        }
    }

    @Override
    public void addChild(HiddenObject hiddenObject) {
        this.addComponent((Component)hiddenObject);
    }

    protected void addChildAsComponent(RepetitionContainer repetitionContainer) {
        this.addComponent(repetitionContainer.getWrappedObject());
    }

    @Override
    public void addChild(LayoutObject layoutObject) {
        ObjectMetaData objectMetaData = layoutObject.getMetaData();
        this.addChildAsComponent(layoutObject, null);
        layoutObject.setParentComponent(this);
        if (layoutObject instanceof HasGlassPane) {
            AbstractLayout abstractLayout = this instanceof Popover && objectMetaData.isInsidePopoverContent() ? ((Popover)this).getGlassPaneHost() : this;
            ((HasGlassPane)((Object)layoutObject)).setGlassPaneParent(abstractLayout);
        }
        this.childs.add(layoutObject);
    }

    protected void addChildAsComponent(LayoutObject layoutObject, Component component) {
        if (component == null) {
            this.addComponent(layoutObject.getWrappedObject());
        } else {
            this.addComponent(component);
        }
    }

    @Override
    public Collection<LayoutObject> getChilds() {
        return this.childs;
    }

    public abstract Object getValue();

    public void setValue(Object object) throws Property.ReadOnlyException, Converter.ConversionException {
        throw new UnsupportedOperationException();
    }

    public Class<?> getType() {
        throw new UnsupportedOperationException();
    }

    public abstract LayoutObject getLayoutObject(ObjectSpec var1);

    public void setReadOnly(boolean bl) {
        super.setReadOnly(bl);
    }

    public boolean isReadOnly() {
        return super.isReadOnly();
    }
}

