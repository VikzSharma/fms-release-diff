/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface PopupServerRpc
extends ServerRpc {
    public void enterField();

    public void deleteKeyPressed(String var1);

    public void onTabPress(boolean var1);

    public void onEnterPress(boolean var1);

    public void onShowContextMenu(int var1, int var2, int var3);

    public void insertData(String var1);
}

