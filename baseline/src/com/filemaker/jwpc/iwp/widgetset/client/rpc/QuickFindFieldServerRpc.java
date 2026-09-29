/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface QuickFindFieldServerRpc
extends ServerRpc {
    public void onTabToExit();

    public void onEnter(String var1);

    public void onFocus();
}

