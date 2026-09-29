/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.vaadin.client.ui.VCssLayout;

public class VCustomWebViewer
extends VCssLayout {
    public VCustomWebViewer() {
        if (FMCUtilities.useAriaCompliantControl()) {
            this.getElement().setTabIndex(0);
        }
    }
}

