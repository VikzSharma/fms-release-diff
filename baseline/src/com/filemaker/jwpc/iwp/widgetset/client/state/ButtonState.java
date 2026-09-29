/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.button.NativeButtonState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.button.NativeButtonState;

public class ButtonState
extends NativeButtonState {
    public int glyphSize = 0;
    public int glyphPos = 0;
    public boolean needToReposition = false;
    public int left = 0;
    public int top = 0;
    public int singleLineHeight = 10;
    @DelegateToWidget
    public int bnbs = 0;
    @DelegateToWidget
    public String buttonAriaLabel;

    public static enum BooleanState {
        hasTooltip,
        isSegmentedObject,
        hasAutoResize,
        isSegmentedBarVertical,
        CLIENT_SIDE_AUTO_SIZING;

    }
}

