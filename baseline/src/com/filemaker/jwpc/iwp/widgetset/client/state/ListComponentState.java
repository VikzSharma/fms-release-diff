/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.grid.GridState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.grid.GridState;

public class ListComponentState
extends GridState {
    @DelegateToWidget
    public boolean dynamicRowHeight = false;
    @DelegateToWidget
    public boolean debugLogEnabled = false;
    @DelegateToWidget
    public int maxTouchMoveOffset = 0;
    @DelegateToWidget
    public boolean scrollPositionEnabled = false;
}

