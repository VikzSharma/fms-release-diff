/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface ListComponentServerRpc
extends ServerRpc {
    public void onRowVisibilityChange(int var1, int var2);

    public void onBrowserWindowResized(int var1, int var2);
}

