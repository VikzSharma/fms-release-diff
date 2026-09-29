/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.service;

public class ServiceConfig {
    private String host;
    private int port;
    private static final ServiceConfig CONFIG = new ServiceConfig("localhost", 9889);

    private ServiceConfig(String string, int n) {
        this.host = string;
        this.port = n;
    }

    public static ServiceConfig getConfig() {
        return CONFIG;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String toString() {
        return String.format("[host=%s, port=%s]", this.host, this.port);
    }
}

