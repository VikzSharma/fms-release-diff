/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.vaadin.shared.communication.ServerRpc;

public interface ComboBoxServerRpc
extends ServerRpc {
    public void requestOptions(String var1, int var2, int var3, boolean var4);

    public void updateSelection(ComboBoxItem var1, boolean var2);
}

