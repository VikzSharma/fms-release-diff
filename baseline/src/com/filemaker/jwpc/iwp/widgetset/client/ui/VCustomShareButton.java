/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.user.client.DOM
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.vaadin.client.ui.VCssLayout;

public class VCustomShareButton
extends VCssLayout {
    private Element button;

    public VCustomShareButton() {
        this.initButton();
    }

    private void initButton() {
        this.button = DOM.createButton();
        this.button.setClassName("v-nativebutton");
        this.getElement().appendChild((Node)this.button);
    }
}

