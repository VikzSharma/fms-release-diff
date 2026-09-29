/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.fields.client.datefield.PopupDateFieldState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class FMCustomDateFieldState
extends PopupDateFieldState {
    @DelegateToWidget
    public int cdbs = 0;
    public boolean hasPortalFocus = false;

    public static enum BooleanState {
        hasScript,
        hasTooltip,
        hasModifyTrigger,
        waitForServerOnEnter,
        waitForServerOnExit,
        exitOnTAB,
        exitOnRETURN,
        exitOnENTER,
        isNumberField,
        hideZeroesOn,
        CLIENT_SIDE_AUTO_SIZING;

    }
}

