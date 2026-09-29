/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.browserframe.BrowserFrameState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.browserframe.BrowserFrameState;

public class WDBrowserFrameState
extends BrowserFrameState {
    @DelegateToWidget
    public String uid;
    @DelegateToWidget
    public boolean allowJSCommunication = false;
    @DelegateToWidget
    public String frameLabel;
}

