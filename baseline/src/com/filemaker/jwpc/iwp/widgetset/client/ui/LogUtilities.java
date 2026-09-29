/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

public final class LogUtilities {
    private LogUtilities() {
    }

    public static void alertSC(String string) {
        LogUtilities.alert(LogUtilities.getStringWithSpecialCharacters(string));
    }

    public static void logSC(String string) {
        LogUtilities.log(LogUtilities.getStringWithSpecialCharacters(string));
    }

    public static void warnSC(String string) {
        LogUtilities.warn(LogUtilities.getStringWithSpecialCharacters(string));
    }

    public static void errorSC(String string) {
        LogUtilities.error(LogUtilities.getStringWithSpecialCharacters(string));
    }

    public static void debugSC(String string) {
        LogUtilities.debug(LogUtilities.getStringWithSpecialCharacters(string));
    }

    private static String getStringWithSpecialCharacters(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\r') {
                stringBuilder.append("\\r");
                continue;
            }
            if (c == '\n') {
                stringBuilder.append("\\n");
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static native void alert(String var0);

    public static native void log(String var0);

    public static native void warn(String var0);

    public static native void error(String var0);

    public static native void debug(String var0);
}

