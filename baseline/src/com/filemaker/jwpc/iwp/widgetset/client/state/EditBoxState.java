/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.fields.client.textarea.TextAreaState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class EditBoxState
extends TextAreaState {
    public String placeholderText = null;
    @DelegateToWidget
    public int ebbs = 0;
    public boolean hasPortalFocus = false;

    public static enum BooleanState {
        hasScript,
        hasModifyTrigger,
        waitForServerOnEnter,
        waitForServerOnExit,
        hasTooltip,
        exitOnTAB,
        exitOnRETURN,
        exitOnENTER,
        isNumberField,
        hideZeroesOn,
        isCalcOrSummary,
        isTextyField,
        hasObjectKeyTrigger,
        isKeyStrokeEnabled,
        hasLayoutKeyTrigger;

    }
}

