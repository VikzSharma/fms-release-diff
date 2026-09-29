/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.util;

public class RemoteContainerUtilities {
    private static String CWPC_REMOTE_CONTAINER_PREFIX = "remote:";
    private static final int CWPC_REMOTE_STREAMING_URL_PREFIX_LENGTH = 7;

    public static boolean isCWPCRemoteContainerURL(String string) {
        return string.startsWith(CWPC_REMOTE_CONTAINER_PREFIX);
    }

    public static String createStreamingURL(String string) {
        if (string != null && string.length() > 0 && RemoteContainerUtilities.isCWPCRemoteContainerURL(string)) {
            return string.substring(7);
        }
        return string;
    }
}

