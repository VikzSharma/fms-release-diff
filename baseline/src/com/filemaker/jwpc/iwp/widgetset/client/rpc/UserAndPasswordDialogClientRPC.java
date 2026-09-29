/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ClientRpc
 */
package com.filemaker.jwpc.iwp.widgetset.client.rpc;

import com.vaadin.shared.communication.ClientRpc;

public interface UserAndPasswordDialogClientRPC
extends ClientRpc {
    public void turnOffAutoComplete();

    public void setPlaceholderText(String var1, String var2);

    public void setAriaLabel(String var1, String var2);
}

