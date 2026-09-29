/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.client.datefield;

import com.vaadin.shared.communication.ClientRpc;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.util.Map;

public interface PopupDateFieldClientRpc
extends ClientRpc {
    public void hideCalendarPopup();

    public void showCalendarPopup(Map<Resolution, Integer> var1, Resolution var2, Map<Resolution, Integer> var3, Map<Resolution, Integer> var4);
}

