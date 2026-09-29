/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.common.CommonUtilities;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.GlassPane;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;

public class GlassPaneHandler {
    private final LayoutObject object;
    private GlassPane glassPane;

    public GlassPaneHandler(LayoutObject layoutObject, AbsoluteCssLayout absoluteCssLayout) {
        HasGlassPane hasGlassPane;
        this.object = layoutObject;
        if (layoutObject instanceof HasGlassPane && (hasGlassPane = (HasGlassPane)((Object)layoutObject)).allowGlassPaneActivation()) {
            this.glassPane = new GlassPane(this.object, this.object.getMetaData().getPositionCss());
            absoluteCssLayout.addComponent((Component)this.glassPane);
        }
    }

    public void cleanupMemory() {
        if (this.glassPane != null && this.glassPane.getParent() != null) {
            ((AbsoluteCssLayout)this.glassPane.getParent()).removeComponent((Component)this.glassPane);
        }
    }

    public void deactivateGlassPane() {
        if (this.glassPane != null) {
            this.glassPane.setVisible(false);
        }
    }

    public void activateGlassPane() {
        if (this.glassPane != null && !this.object.isHideConditionOn()) {
            this.glassPane.setVisible(true);
        }
    }

    public void updateGlassPane() {
        if (this.object.isHideConditionOn()) {
            this.deactivateGlassPane();
        } else {
            this.activateGlassPane();
        }
    }

    public void resizeGlassPane(int n, int n2) {
        if (this.glassPane != null) {
            this.glassPane.setWidth(Double.toString(n) + "px");
            this.glassPane.setHeight(Double.toString(n2) + "px");
        }
    }

    public void repositionGlassPane(int n, int n2) {
        if (this.glassPane != null) {
            String string = this.glassPane.getPositionCss();
            string = CommonUtilities.updateStyle(string, "left:" + Integer.toString(n) + "px;", "left:", "px;");
            string = CommonUtilities.updateStyle(string, "top:" + Integer.toString(n2) + "px;", "top:", "px;");
            this.glassPane.setPositionCss(string);
        }
    }

    public void addStyleNameToGlassPane(String string) {
        if (this.glassPane != null) {
            this.glassPane.addStyleName(string);
        }
    }

    public void registerTooltipToGlassPane(String string) {
        if (this.glassPane != null) {
            this.glassPane.setDescription(string, ContentMode.HTML);
        }
    }

    public void registerAccTitleToGlassPane(String string) {
        if (this.glassPane != null) {
            this.glassPane.setDescription(string, ContentMode.HTML);
        }
    }

    public void registerAccHelpToGlassPane(String string) {
        if (this.glassPane != null) {
            this.glassPane.setDescription(string, ContentMode.HTML);
        }
    }

    public void registerAccLabelToGlassPane(String string) {
        if (this.glassPane != null) {
            this.glassPane.setDescription(string, ContentMode.HTML);
        }
    }
}

