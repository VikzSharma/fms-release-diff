/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.fields.client.datefield;

import com.filemaker.fields.client.common.FMState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class PopupDateFieldState
extends FMState {
    public String text;
    public String locale;
    @DelegateToWidget
    public int pdbs;

    public PopupDateFieldState() {
        this.primaryStyleName = "fm-datefield";
        this.text = null;
        this.locale = null;
        this.pdbs = 0;
    }

    public static enum BooleanState {
        calendarIconVisible;

    }
}

