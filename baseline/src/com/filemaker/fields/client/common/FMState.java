/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.v7.shared.AbstractFieldState
 */
package com.filemaker.fields.client.common;

import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.fields.client.common.Padding;
import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.v7.shared.AbstractFieldState;

public class FMState
extends AbstractFieldState {
    @DelegateToWidget
    public String inputPrompt = null;
    public FocusMode focusMode = FocusMode.INSTANT;
    @DelegateToWidget
    public Padding padding = new Padding();
    @DelegateToWidget
    public int fmbs = 0;
    @DelegateToWidget
    public int touchKeyboardType = 0;

    public static enum BooleanState {
        newLineAllowed,
        wordwrap,
        selectContentsOnEdit,
        resetScrollPositionOnExit;

    }
}

