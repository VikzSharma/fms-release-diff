/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.common.FMState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class ComboBoxState
extends FMState {
    public int pageLength;
    public ComboBoxItem selectedItem;
    @DelegateToWidget
    public int cbbs;

    public ComboBoxState() {
        this.primaryStyleName = "fm-combobox";
        this.pageLength = 10;
        this.selectedItem = null;
        this.cbbs = 0;
    }

    public static enum BooleanState {
        arrowVisible;

    }
}

