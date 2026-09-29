/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import java.util.concurrent.atomic.AtomicInteger;

public class LRUCacheValue {
    private Object valObj;
    private AtomicInteger refCount;

    public LRUCacheValue(Object object) {
        this.valObj = object;
        this.refCount.set(0);
    }

    public Object getValObj() {
        return this.valObj;
    }

    public void addRef() {
        this.refCount.incrementAndGet();
    }

    public void removeRef() {
        this.refCount.decrementAndGet();
    }

    public boolean canEvict() {
        return this.refCount.get() == 0;
    }

    public int getRefCount() {
        return this.refCount.get();
    }
}

