/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

public class DebugTime {
    private long start_ms = System.currentTimeMillis();

    public void stop(String string) {
        long l = System.currentTimeMillis();
        System.out.println(string + ": " + (l - this.start_ms) + "ms");
    }

    public void reset() {
        this.start_ms = System.currentTimeMillis();
    }
}

