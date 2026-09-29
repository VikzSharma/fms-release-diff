/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component.repetition;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.GlassPane;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.xml.UIGenerator;
import com.vaadin.ui.Component;
import java.util.HashMap;
import java.util.Map;

public abstract class RepetitionContainer
extends AbsoluteCssLayout {
    protected final App app;
    protected final LayoutView view;
    protected final ObjectMetaData metaData;
    private final Map<Short, LayoutFieldObject> repetitionObjects = new HashMap<Short, LayoutFieldObject>();
    private final String positionCss;
    private final int partIndex;
    private final int recordIndex;
    private final int rowId;
    private final int portalIndex;

    public RepetitionContainer(App app, LayoutView layoutView, ObjectMetaData objectMetaData, int n, int n2, int n3, int n4) {
        super(true);
        this.app = app;
        this.view = layoutView;
        this.metaData = objectMetaData;
        this.partIndex = n;
        this.recordIndex = n2;
        this.rowId = n3;
        this.portalIndex = n4;
        this.positionCss = this.metaData.getPositionCss();
        this.initUI();
    }

    private void initUI() {
        LayoutObjectUtilities.setWidthAndHeight(this.view.isClientSideAutoSizing(), this.metaData, (Component)this, null);
        this.addStyleName("fm-repetition");
    }

    public Component getWrappedObject() {
        return this;
    }

    public ObjectMetaData getMetaData() {
        return this.metaData;
    }

    public Map<Short, LayoutFieldObject> getRepetitionObjects() {
        return this.repetitionObjects;
    }

    public String getPositionCss() {
        return this.positionCss;
    }

    @Override
    protected String getCss(Component component) {
        if (component instanceof LayoutFieldObject) {
            return ((LayoutFieldObject)component).getMetaData().getPositionCss();
        }
        if (component instanceof GlassPane) {
            return ((GlassPane)component).getPositionCss();
        }
        if (component instanceof LOWrapper) {
            return ((LOWrapper)component).getPositionCss();
        }
        return null;
    }

    protected abstract ObjectMetaData createObjectMetaData(int var1, int var2);

    protected abstract String getRepetitionObjectSelector(int var1, int var2);

    public LayoutFieldObject createRepetitionObject(UIGenerator uIGenerator, LayoutContainerObject layoutContainerObject, short s, int n, int n2) {
        ObjectMetaData objectMetaData = this.createObjectMetaData(n, n2);
        LayoutFieldObject layoutFieldObject = (LayoutFieldObject)uIGenerator.createLayoutObject(objectMetaData, this.partIndex, this.recordIndex, this.rowId, this.portalIndex, s);
        this.addChild(layoutContainerObject, layoutFieldObject, s, n, n2);
        return layoutFieldObject;
    }

    private void addChild(LayoutContainerObject layoutContainerObject, LayoutFieldObject layoutFieldObject, short s, int n, int n2) {
        this.repetitionObjects.put(s, layoutFieldObject);
        String string = this.getRepetitionObjectSelector(n, n2);
        layoutFieldObject.addRepetitionObject(this, string);
        this.addComponent(layoutFieldObject.getWrappedObject());
    }
}

