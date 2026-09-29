/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface AppServerRpc
extends ServerRpc {
    public void onOrientationChange(int var1, int var2);

    public void setRetinaDisplay(boolean var1);

    public void closePreviousSession(int var1);

    public void attemptLogout();

    public void tabPressed(boolean var1);

    public void enterPressed(boolean var1);

    public void performScript(String var1, String var2, String var3);

    public void setClientOrigin(String var1);

    public void closeSharingWindow();

    public void performOnKeyDown(String var1, int var2, boolean var3);
}

