/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.ui.VWindow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.ui.VWindow;

public class VCustomDialog
extends VWindow {
    private Element caller;

    protected void onAttach() {
        super.onAttach();
        this.caller = FMCUtilities.getLastActiveElement();
    }

    protected void onDetach() {
        super.onDetach();
        if (FMCUtilities.useAriaCompliantControl() && this.caller != null) {
            this.caller.focus();
        }
    }
}

