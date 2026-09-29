/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Element
 *  com.vaadin.client.ui.VWindow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.CardStyleWindowState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.user.client.Element;
import com.vaadin.client.ui.VWindow;

public class VCustomCardStyleWindow
extends VWindow {
    private int pwbs = 0;

    public void setPwbs(int n) {
        this.pwbs = n;
    }

    private boolean getBooleanState(CardStyleWindowState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.pwbs, booleanState.ordinal());
    }

    protected Element getModalityCurtain() {
        Element element = super.getModalityCurtain();
        if (!this.getBooleanState(CardStyleWindowState.BooleanState.hasParentDim)) {
            element.addClassName("translucent");
        } else {
            element.removeClassName("translucent");
        }
        return element;
    }
}

