/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractBaseTableState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class AbstractTableState
extends AbstractBaseTableState {
    @DelegateToWidget
    public int atbs = 0;

    public static enum BooleanState {
        hasTooltip;

    }
}

