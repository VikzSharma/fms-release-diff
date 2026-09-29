/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState;

public class StatusAreaMenubarState
extends HorizontalLayoutState {
    @DelegateToWidget
    public int smbs = 0;

    public static enum BooleanState {
        showTooltip;

    }
}

