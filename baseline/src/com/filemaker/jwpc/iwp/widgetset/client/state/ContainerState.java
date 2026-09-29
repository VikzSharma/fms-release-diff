/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.draganddropwrapper.DragAndDropWrapperState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.draganddropwrapper.DragAndDropWrapperState;

public class ContainerState
extends DragAndDropWrapperState {
    @DelegateToWidget
    public int ctbs = 0;

    public static enum BooleanState {
        hasTooltip;

    }
}

