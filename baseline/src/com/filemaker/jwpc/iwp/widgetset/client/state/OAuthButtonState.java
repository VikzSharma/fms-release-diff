/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.csslayout.CssLayoutState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.csslayout.CssLayoutState;

public class OAuthButtonState
extends CssLayoutState {
    @DelegateToWidget
    public String providerName = "";
    @DelegateToWidget
    public String providerButtonName = "";
    @DelegateToWidget
    public String providerId = "";
    @DelegateToWidget
    public String iconUrl = "";
    @DelegateToWidget
    public String masterAddr = "";
}

