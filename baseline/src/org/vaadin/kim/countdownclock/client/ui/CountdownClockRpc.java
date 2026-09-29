/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.communication.ServerRpc
 */
package org.vaadin.kim.countdownclock.client.ui;

import com.vaadin.shared.communication.ServerRpc;

public interface CountdownClockRpc
extends ServerRpc {
    public void countdownEnded();
}

