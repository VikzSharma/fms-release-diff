/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindRequestSetPopover;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomFindRequestIncludeOmit;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=FindRequestSetPopover.FindRequestSetPopoverLayout.FindRequestIncludeOmit.class)
public class FindRequestIncludeOmitConnector
extends CssLayoutConnector {
    public VCustomFindRequestIncludeOmit getWidget() {
        return (VCustomFindRequestIncludeOmit)super.getWidget();
    }
}

