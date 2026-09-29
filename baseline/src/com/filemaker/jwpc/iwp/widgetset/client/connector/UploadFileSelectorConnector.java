/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.UIDL
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.upload.UploadConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.component.UploadFileSelector;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.upload.UploadConnector;

@Connect(value=UploadFileSelector.class)
public class UploadFileSelectorConnector
extends UploadConnector {
    public void updateFromUIDL(UIDL uIDL, ApplicationConnection applicationConnection) {
        super.updateFromUIDL(uIDL, applicationConnection);
        if (FMCUtilities.useAriaCompliantControl() && UploadFileSelectorConnector.isRealUpdate((UIDL)uIDL) && uIDL.hasAttribute("tabindex")) {
            this.getWidget().fu.setTabIndex(uIDL.getIntAttribute("tabindex"));
        }
    }
}

