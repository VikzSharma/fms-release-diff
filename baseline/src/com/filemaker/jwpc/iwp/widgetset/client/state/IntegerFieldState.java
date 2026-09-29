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

public class IntegerFieldState
extends AbstractTextFieldState {
    @DelegateToWidget
    public int defaultValue = 0;
    @DelegateToWidget
    public int minValue = 0;
    @DelegateToWidget
    public boolean allowZero = true;
}

