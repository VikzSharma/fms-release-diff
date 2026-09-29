/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;
import java.util.List;

public interface TabControlClientRPC
extends ClientRpc {
    public void setTabsStyle(List<String> var1);

    public void refreshPosition();
}

