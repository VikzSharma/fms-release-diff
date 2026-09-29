/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.Label;

public class Separator
extends CssLayout {
    public Separator(String string) {
        this.setId("login_dialog_separator");
        this.addStyleName("fm-separator");
        Label label = new Label();
        label.setWidthUndefined();
        label.setHeightUndefined();
        label.addStyleName("fm-separator-line");
        this.addComponent((Component)label);
        Label label2 = new Label();
        label2.setId("login_dialog_separator_text");
        label2.setWidthUndefined();
        label2.addStyleName("fm-separator-text");
        label2.setValue(string);
        this.addComponent((Component)label2);
        Label label3 = new Label();
        label3.setWidthUndefined();
        label3.setHeightUndefined();
        label3.addStyleName("fm-separator-line");
        this.addComponent((Component)label3);
    }
}

