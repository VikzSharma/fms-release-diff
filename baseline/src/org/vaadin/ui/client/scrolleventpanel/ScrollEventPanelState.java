/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.panel.PanelState
 */
package org.vaadin.ui.client.scrolleventpanel;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.panel.PanelState;

public class ScrollEventPanelState
extends PanelState {
    @DelegateToWidget(value="setScrollEventThreshold")
    public int scrollEventThreshold = 1000;
}

