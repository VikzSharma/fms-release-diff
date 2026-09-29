/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;

public interface ButtonClientRpc
extends ClientRpc {
    public void sendButtonInfo();

    public void updateBounds(int var1, int var2, int var3, int var4, boolean var5, boolean var6);
}

