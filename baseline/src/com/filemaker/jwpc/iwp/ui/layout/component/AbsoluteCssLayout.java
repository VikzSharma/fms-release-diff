/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.GlassPane;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage2;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

public class AbsoluteCssLayout
extends CssLayout {
    public AbsoluteCssLayout(boolean bl) {
        if (bl) {
            this.setStyleName("iwp-css-layout-common-style");
        }
    }

    protected String getCss(Component component) {
        if (component instanceof GlassPane) {
            return ((GlassPane)component).getPositionCss();
        }
        if (component instanceof RepetitionContainer) {
            return ((RepetitionContainer)component).getPositionCss();
        }
        if (component instanceof LayoutObject) {
            return ((LayoutObject)component).getMetaData() != null ? ((LayoutObject)component).getMetaData().getPositionCss() : null;
        }
        if (component instanceof WDBrowserFrame) {
            return ((WDBrowserFrame)component).getPositionCss();
        }
        if (component instanceof WDImage) {
            return ((WDImage)component).getPositionCss();
        }
        if (component instanceof WDImage2) {
            return ((WDImage2)component).getPositionCss();
        }
        if (component instanceof LOWrapper) {
            return ((LOWrapper)component).getPositionCss();
        }
        return null;
    }
}

