/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.client.datefield;

import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.util.Map;

public interface PopupDateFieldServerRpc
extends ServerRpc {
    public void onCalendarPopupRequest(String var1);

    public void onUserInput(String var1);

    public void onDatePicked(Map<Resolution, Integer> var1);

    public void onCalendarPopupOpen(boolean var1);
}

