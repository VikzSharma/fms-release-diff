/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.internal.client;

public class CWPServiceConfig {
    private String host;
    private int port;
    private static final CWPServiceConfig CONFIG = new CWPServiceConfig("localhost", 9898);

    private CWPServiceConfig(String string, int n) {
        this.host = string;
        this.port = n;
    }

    public static CWPServiceConfig getConfig() {
        return CONFIG;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}

