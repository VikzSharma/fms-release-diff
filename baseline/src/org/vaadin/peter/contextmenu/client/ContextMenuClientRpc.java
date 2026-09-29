/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package org.vaadin.peter.contextmenu.client;

import com.vaadin.shared.communication.ClientRpc;

public interface ContextMenuClientRpc
extends ClientRpc {
    public void showContextMenu(int var1, int var2);

    public void showContextMenuRelativeTo(String var1);

    public void hide();
}

