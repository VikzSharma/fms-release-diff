/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util.developertool;

public enum DeveloperToolType {
    UI_ACTION("Debug UI Actions"),
    SERVER_NOTIFICATION("Debug Server Notification"),
    UI_EVENT("Debug UI Event"),
    THREAD_DUMP("Thread Dump"),
    THREAD_DIAGNOSTICS("Thread Diagnostics"),
    CACHE_DIAGNOSTICS("Cache Diagnostics");

    private String value;

    private DeveloperToolType(String string2) {
        this.value = string2;
    }

    public String toString() {
        return this.value;
    }
}

