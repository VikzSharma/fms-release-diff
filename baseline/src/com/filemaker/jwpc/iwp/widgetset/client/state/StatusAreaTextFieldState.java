/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.v7.shared.ui.textfield.AbstractTextFieldState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.v7.shared.ui.textfield.AbstractTextFieldState;

public class StatusAreaTextFieldState
extends AbstractTextFieldState {
    @DelegateToWidget
    public int stbs = 0;

    public static enum BooleanState {
        showTooltip;

    }
}

