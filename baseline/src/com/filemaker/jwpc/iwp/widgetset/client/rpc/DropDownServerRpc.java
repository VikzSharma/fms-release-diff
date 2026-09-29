/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface DropDownServerRpc
extends ServerRpc {
    public void onTabPress(boolean var1, String var2);

    public void onTextChange(String var1, boolean var2);

    public void enterField(boolean var1);

    public void clearPendingClick();

    public void getValueListDataRPC();

    public void onPopupVisibleChange(boolean var1, String var2);

    public void printthis(String var1);

    public void onEnterPress(boolean var1, String var2);
}

