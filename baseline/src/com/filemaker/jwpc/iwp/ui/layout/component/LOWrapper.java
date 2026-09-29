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
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

public class LOWrapper
extends CssLayout {
    private String positionCss;
    private final Component childComponent;

    public LOWrapper(Component component, String string) {
        this.positionCss = string;
        this.childComponent = component;
        this.addComponent(component);
    }

    public String getPositionCss() {
        return this.positionCss;
    }

    public void setPositionCss(String string) {
        this.positionCss = string;
    }

    public LayoutObject getWrappedLayoutObject() {
        Component component = this.childComponent;
        if (component == null || component instanceof LayoutObject) {
            return (LayoutObject)component;
        }
        if (component instanceof LOWrapper) {
            return ((LOWrapper)component).getWrappedLayoutObject();
        }
        return null;
    }

    protected String getCss(Component component) {
        if (component instanceof GlassPane) {
            return ((GlassPane)component).getPositionCss();
        }
        return null;
    }
}

