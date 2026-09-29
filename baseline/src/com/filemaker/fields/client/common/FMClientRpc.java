/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.fields.client.common;

import com.vaadin.shared.communication.ClientRpc;

public interface FMClientRpc
extends ClientRpc {
    public void setSelectionRange(int var1, int var2);

    public void setSelectionRangeImmediately(int var1, int var2);

    public void selectAll();

    public void startEdit();

    public void performModify();

    public void performNavigationFocus();

    public void syncServerValue();

    public void resyncServerValue(String var1);

    public void blockTabbing();

    public void unblockTabbing();
}

