/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.application;

import java.util.concurrent.Semaphore;

public class MySemaphore
extends Semaphore {
    public MySemaphore(int n, boolean bl) {
        super(n, bl);
    }

    @Override
    public boolean tryAcquire() {
        boolean bl = super.tryAcquire();
        return bl;
    }

    @Override
    public void release() {
        super.release();
    }
}

