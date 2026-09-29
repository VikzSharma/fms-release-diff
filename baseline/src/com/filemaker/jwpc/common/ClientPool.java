/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.common;

public interface ClientPool<T> {
    public int availableClientCount();

    public T getClient(int var1);

    public void putClient(T var1);

    public void shutdown();
}

