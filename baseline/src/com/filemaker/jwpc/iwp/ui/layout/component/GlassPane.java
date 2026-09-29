/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;

public class GlassPane
extends CssLayout {
    private final LayoutObject nonInteractiveObject;
    private String positionCss;

    public GlassPane(LayoutObject layoutObject, String string) {
        this.setHeight(layoutObject.getMetaData().getHeight());
        this.setWidth(layoutObject.getMetaData().getWidth());
        this.nonInteractiveObject = layoutObject;
        this.showHandCursor(layoutObject.getMetaData().useHandCursor());
        this.setDescription(layoutObject.getMetaData().getTooltip(), ContentMode.HTML);
        this.setDescription(layoutObject.getMetaData().getAccLabel(), ContentMode.HTML);
        this.setDescription(layoutObject.getMetaData().getAccTitle(), ContentMode.HTML);
        this.setDescription(layoutObject.getMetaData().getAccHelp(), ContentMode.HTML);
        this.addStyleName("iwp-glass-pane");
        this.positionCss = string;
        this.positionCss = this.positionCss.replace("position:absolute;", "");
    }

    public void showHandCursor(boolean bl) {
        if (bl) {
            this.addStyleName("hand-cursor");
        } else {
            this.removeStyleName("hand-cursor");
        }
    }

    public LayoutObject getNonInteractiveLayoutObject() {
        return this.nonInteractiveObject;
    }

    public String getPositionCss() {
        return this.positionCss;
    }

    public void setPositionCss(String string) {
        this.positionCss = string;
        this.positionCss = this.positionCss.replace("position:absolute;", "");
        this.markAsDirty();
    }
}

