/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface AbstractBaseTableServerRpc
extends ServerRpc {
    public void syncAriaDone();

    public void onNavFocus(int var1);

    public void onNavSelect(int var1);

    public void onNavMove(int var1, int var2);
}

