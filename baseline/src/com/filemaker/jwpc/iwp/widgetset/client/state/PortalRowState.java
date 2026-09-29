/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.csslayout.CssLayoutState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.csslayout.CssLayoutState;

public class PortalRowState
extends CssLayoutState {
    @DelegateToWidget
    public int prbs = 0;

    public static enum BooleanState {
        hasEnterTriggers,
        validRow;

    }
}

