/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.textfield.TextFieldConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseRecordsNavigatorLarge;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaTextFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomStatusAreaTextField;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.textfield.TextFieldConnector;

@Connect(value=BrowseRecordsNavigatorLarge.RecordIndexField.class)
public class StatusAreaRecordIndexFieldConnector
extends TextFieldConnector {
    public VCustomStatusAreaTextField getWidget() {
        return (VCustomStatusAreaTextField)super.getWidget();
    }

    public StatusAreaTextFieldState getState() {
        return (StatusAreaTextFieldState)super.getState();
    }
}

