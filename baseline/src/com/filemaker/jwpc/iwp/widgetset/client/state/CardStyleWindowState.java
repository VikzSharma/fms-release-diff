/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.window.WindowState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.window.WindowState;

public class CardStyleWindowState
extends WindowState {
    @DelegateToWidget
    public int pwbs = 0;

    public static enum BooleanState {
        hasParentDim;

    }
}

