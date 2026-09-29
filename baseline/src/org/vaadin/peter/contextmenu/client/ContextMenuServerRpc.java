/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package org.vaadin.peter.contextmenu.client;

import com.vaadin.shared.communication.ServerRpc;

public interface ContextMenuServerRpc
extends ServerRpc {
    public void itemClicked(String var1, boolean var2);

    public void onContextMenuOpenRequested(int var1, int var2, String var3);

    public void contextMenuClosed();
}

