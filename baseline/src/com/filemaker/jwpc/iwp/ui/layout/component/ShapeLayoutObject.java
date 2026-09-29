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
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public abstract class ShapeLayoutObject
extends CssLayoutObject
implements HasGlassPane {
    private final LayoutView layoutView;
    protected AbstractComponent selfComponent;
    protected GlassPaneHandler glassPaneHandler;

    public ShapeLayoutObject(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.layoutView = layoutView;
        this.initUI();
    }

    protected void initUI() {
        this.selfComponent = new LOWrapper(this, this.getMetaData().getPositionCss());
        LayoutObjectUtilities.setWidthAndHeight(this.layoutView.isClientSideAutoSizing(), this.metaData, (Component)this.selfComponent, null);
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, (AbstractComponent)this);
    }

    @Override
    public void cleanupMemory() {
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.cleanupMemory();
            this.glassPaneHandler = null;
        }
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
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
    public void setHideConditionOn(boolean bl) {
        super.setHideConditionOn(bl);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.updateGlassPane();
        }
    }

    @Override
    public void registerToolTip(String string) {
        super.registerToolTip(string);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.registerTooltipToGlassPane(string);
        }
    }

    @Override
    public void registerAccTitle(String string) {
        super.registerAccTitle(string);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.registerAccTitleToGlassPane(string);
        }
    }

    @Override
    public void registerAccHelp(String string) {
        super.registerAccHelp(string);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.registerAccHelpToGlassPane(string);
        }
    }

    @Override
    public void registerAccLabel(String string) {
        super.registerAccLabel(string);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.registerAccLabelToGlassPane(string);
        }
    }
}

