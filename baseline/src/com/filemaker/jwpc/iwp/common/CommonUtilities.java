/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.common;

public final class CommonUtilities {
    private CommonUtilities() {
    }

    public static String updateStyle(String string, String string2, String string3, String string4) {
        if (string == null || string.trim().length() == 0) {
            return string2;
        }
        int n = string.indexOf(string3);
        if (n < 0) {
            return string2;
        }
        int n2 = string.indexOf(string4, n);
        if (n2 <= 0) {
            return string + string2;
        }
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.replace(n, n2 + string4.length(), string2);
        return stringBuffer.toString();
    }

    public static int getIntegerFromSubstring(String string, String string2, String string3) {
        int n = string.indexOf(string2);
        if (n < 0) {
            return 0;
        }
        int n2 = string.indexOf(string3, n += string2.length());
        if (n2 <= 0) {
            return 0;
        }
        String string4 = string.substring(n, n2);
        if (string4.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(string4);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }
}

