/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.AbstractComponentState
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.jwpc.iwp.widgetset.client.state.LayoutLinksBean;
import com.vaadin.shared.AbstractComponentState;

public class FMCommunicationState
extends AbstractComponentState {
    public static final String LAYOUT_LINK_ID = "fm-lc";
    public static final String OVERRIDES_LINK_ID = "fm-oc";
    public static final String CARD_LAYOUT_LINK_ID = "fm-ca-lc";
    public static final String CARD_OVERRIDES_LINK_ID = "fm-ca-oc";
    public LayoutLinksBean layoutLinks = new LayoutLinksBean();
}

