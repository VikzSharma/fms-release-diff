/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.optiongroup.OptionGroupConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.NavigableOptionGroup;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomNavigableOptionGroup;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.optiongroup.OptionGroupConnector;

@Connect(value=NavigableOptionGroup.class)
public class NavigableOptionGroupConnector
extends OptionGroupConnector {
    public VCustomNavigableOptionGroup getWidget() {
        return (VCustomNavigableOptionGroup)super.getWidget();
    }
}

