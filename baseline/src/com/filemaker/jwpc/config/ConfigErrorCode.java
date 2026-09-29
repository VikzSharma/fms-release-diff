/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigErrorCode {
    private static Map<Integer, String> errDescr = new HashMap<Integer, String>();
    public static final int UNKNOWN_ERROR = -1;
    public static final int NO_ERROR = 0;
    public static final int INVALID_PARAM = 105;
    public static final int LOGGER_UPDATE_FAILED = 110;
    public static final String UNKNOWN_ERROR_DESCR = "Unknown Error";
    public static final String NO_ERROR_DESCR = "";
    public static final String INVALID_PARAM_DESCR = "Invalid Parameter";
    public static final String LOGGER_UPDATE_FAILED_DESCR = "Logger update failed";

    public static String getDescr(int n) {
        String string = errDescr.get(n);
        if (string == null) {
            return UNKNOWN_ERROR_DESCR;
        }
        return string;
    }

    static {
        errDescr.put(0, NO_ERROR_DESCR);
        errDescr.put(105, INVALID_PARAM_DESCR);
        errDescr.put(110, LOGGER_UPDATE_FAILED_DESCR);
    }
}

