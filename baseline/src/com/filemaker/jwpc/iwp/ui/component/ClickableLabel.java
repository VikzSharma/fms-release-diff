/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.shared.Registration
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.Label;

public class ClickableLabel
extends CssLayout {
    protected CssLayout clickableLayout;
    protected Label label;

    public ClickableLabel(String string, String string2) {
        this.addStyleName("fm-clickable-label");
        this.clickableLayout = new CssLayout();
        this.addComponent((Component)this.clickableLayout);
        this.label = new Label(string);
        this.label.addStyleName(string2);
        this.clickableLayout.addComponent((Component)this.label);
    }

    public void setWidthUndefined() {
        super.setWidthUndefined();
        this.clickableLayout.setWidthUndefined();
        this.label.setWidthUndefined();
    }

    public Registration addLayoutClickListener(LayoutEvents.LayoutClickListener layoutClickListener) {
        return this.clickableLayout.addLayoutClickListener(layoutClickListener);
    }

    public void removeLayoutClickListener(LayoutEvents.LayoutClickListener layoutClickListener) {
        this.clickableLayout.removeLayoutClickListener(layoutClickListener);
    }
}

