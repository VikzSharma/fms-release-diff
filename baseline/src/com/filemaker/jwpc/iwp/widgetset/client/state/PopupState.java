/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.fields.client.combobox.ComboBoxState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class PopupState
extends ComboBoxState {
    @DelegateToWidget
    public int pobs = 0;

    public static enum BooleanState {
        hasScript,
        hasTooltip,
        exitOnTAB,
        exitOnRETURN,
        exitOnENTER,
        dontOverrideFormattingWithValueList,
        CLIENT_SIDE_AUTO_SIZING;

    }
}

