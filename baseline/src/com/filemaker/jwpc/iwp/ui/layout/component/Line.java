/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.LineOrientation;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.ShapeLayoutObject;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.Component;

public class Line
extends ShapeLayoutObject {
    public Line(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, objectMetaData, objectAttributes);
        this.setWidth(objectMetaData.getWidth());
        this.setHeight(objectMetaData.getHeight());
        LineOrientation lineOrientation = objectMetaData.getLineOrientation();
        switch (lineOrientation) {
            case DIAGONAL: {
                this.addStyleName("iwps_diagonal_line");
                break;
            }
            case VERTICAL: {
                this.addStyleName("iwps_vertical_line");
                break;
            }
            default: {
                this.addStyleName("iwps_horizontal_line");
            }
        }
    }

    @Override
    protected void initUI() {
        this.selfComponent = this;
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, null);
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        super.setGlassPaneParent(absoluteCssLayout);
        if (this.metaData.getLineOrientation() == LineOrientation.DIAGONAL) {
            this.glassPaneHandler.addStyleNameToGlassPane(this.metaData.getUniqueObjectSelector());
        }
    }
}

