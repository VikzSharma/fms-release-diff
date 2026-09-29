/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;

public interface AppClientRpc
extends ClientRpc {
    public void setClientId(int var1);

    public void tryRemoveActiveField();

    public void tryEnableTabKeyHandling();

    public void deselectText();

    public void revertActiveObjectValue(String var1, String var2);
}

