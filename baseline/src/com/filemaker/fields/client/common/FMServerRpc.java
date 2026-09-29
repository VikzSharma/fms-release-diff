/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package com.filemaker.fields.client.common;

import com.vaadin.shared.communication.ServerRpc;

public interface FMServerRpc
extends ServerRpc {
    public void handleFocus();

    public void handleBlur();

    public void updateSelectionRange(int var1, int var2);

    public void handleBlockedLineBreak();
}

