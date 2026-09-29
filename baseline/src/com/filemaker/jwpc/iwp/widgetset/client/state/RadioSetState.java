/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.v7.shared.ui.optiongroup.OptionGroupState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.v7.shared.ui.optiongroup.OptionGroupState;

public class RadioSetState
extends OptionGroupState {
    @DelegateToWidget
    public int rsbs = 0;

    public static enum BooleanState {
        hasScript,
        hasTooltip,
        exitOnTAB,
        exitOnRETURN,
        exitOnENTER;

    }
}

