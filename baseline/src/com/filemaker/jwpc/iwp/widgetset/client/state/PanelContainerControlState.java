/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.tabsheet.TabsheetState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.tabsheet.TabsheetState;

public class PanelContainerControlState
extends TabsheetState {
    @DelegateToWidget
    public int pcbs = 0;

    public static enum BooleanState {
        hasTooltip;

    }
}

