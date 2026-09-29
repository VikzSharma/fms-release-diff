/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;

public interface ListComponentClientRpc
extends ClientRpc {
    public void updatePageLength(int var1, double var2, double var4);

    public void onDataLoaded();

    public void scrollToDynamicHeightRow(int var1);

    public void recalculateScrollbarsForVirtualViewport();

    public void resetScrollPosition();
}

