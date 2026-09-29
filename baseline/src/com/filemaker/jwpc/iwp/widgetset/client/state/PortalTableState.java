/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractTableState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class PortalTableState
extends AbstractTableState {
    @DelegateToWidget
    public int ptbs = 0;
    public boolean isListView = false;

    public static enum BooleanState {
        showScrollbar,
        hasScript;

    }
}

