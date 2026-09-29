/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ServerRpc;

public interface FMCommunicationServerRpc
extends ServerRpc {
    public void performBrowserResize(int var1, int var2);

    public void setIsPlayingFullScreen(boolean var1);

    public void onCssUpdated();

    public void onOverrideCssUpdated();
}

