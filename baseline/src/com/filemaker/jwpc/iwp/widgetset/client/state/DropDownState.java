/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.jwpc.iwp.widgetset.client.state.PopupState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class DropDownState
extends PopupState {
    @DelegateToWidget
    public int ddbs = 0;
    public String placeholderText = null;
    public boolean hasPortalFocus = false;

    public static enum BooleanState {
        hasIcon,
        hasModifyTrigger,
        isNumberField,
        useAutoComplete,
        hideZeroesOn;

    }
}

