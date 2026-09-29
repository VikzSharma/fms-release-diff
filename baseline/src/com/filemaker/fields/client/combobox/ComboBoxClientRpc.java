/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.vaadin.shared.communication.ClientRpc;
import java.util.List;
import java.util.Set;

public interface ComboBoxClientRpc
extends ClientRpc {
    public void hideMenu();

    public void showMenu();

    public void showOptions(List<ComboBoxItem> var1, int var2, int var3, int var4, Set<Integer> var5, String var6);
}

