/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.embedded.EmbeddedState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.embedded.EmbeddedState;

public class MediaEmbeddedState
extends EmbeddedState {
    @DelegateToWidget
    public int mebs = 0;

    public static enum BooleanState {
        autoPlay,
        hasTooltip;

    }
}

