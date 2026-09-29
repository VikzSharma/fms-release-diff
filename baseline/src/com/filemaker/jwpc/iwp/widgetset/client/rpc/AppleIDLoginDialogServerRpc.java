/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface AppleIDLoginDialogServerRpc
extends ServerRpc {
    public void handleEmailPaste(String var1);

    public void handlePasscodePaste(String var1);

    public void handleOnKeyUpEvent(boolean var1, boolean var2, int var3, String var4);
}

