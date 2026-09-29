/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface TextFieldServerRpc
extends ServerRpc {
    public void onTabPress(boolean var1, String var2);

    public void onTextChange(String var1, boolean var2);

    public void enterField();

    public void printthis(String var1);

    public void onEnterPress(boolean var1, String var2);

    public void onBrowserResize(int var1, int var2, String var3);

    public void setPendingNavigationFocus();

    public void checkNavigationFocus();

    public void onKeystroke(String var1, int var2, boolean var3);

    public void onShowContextMenu(int var1, int var2, int var3);
}

