/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;
import java.util.ArrayList;

public interface FMCommunicationClientRpc
extends ClientRpc {
    public void reset();

    public void updateTabOrdering(ArrayList<String> var1);

    public void clearActiveField();

    public void performBrowserResize(int var1, int var2);

    public void enableLayoutTabOrder(boolean var1);
}

