/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Group
extends CssLayoutObject
implements LayoutContainerObject {
    private List<LayoutObject> childs = new ArrayList<LayoutObject>();

    public Group(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.initUI();
    }

    private void initUI() {
        Group group = this;
        group.setWidth(this.metaData.getWidth());
        group.setHeight(this.metaData.getHeight());
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)group, null);
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

    @Override
    public Component getWrappedObject() {
        return this;
    }

    @Override
    public void addChild(RepetitionContainer repetitionContainer) {
        this.addComponent(repetitionContainer.getWrappedObject());
        for (LayoutFieldObject layoutFieldObject : repetitionContainer.getRepetitionObjects().values()) {
            this.childs.add(layoutFieldObject);
        }
    }

    @Override
    public void addChild(LayoutObject layoutObject) {
        layoutObject.setParentComponent(this);
        this.addComponent(layoutObject.getWrappedObject());
        if (layoutObject instanceof HasGlassPane) {
            ((HasGlassPane)((Object)layoutObject)).setGlassPaneParent(this);
        }
        this.childs.add(layoutObject);
    }

    @Override
    public Collection<LayoutObject> getChilds() {
        return this.childs;
    }

    @Override
    public void addCFStyle(String string) {
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    @Override
    public void addChild(HiddenObject hiddenObject) {
        this.addComponent((Component)hiddenObject);
    }
}

