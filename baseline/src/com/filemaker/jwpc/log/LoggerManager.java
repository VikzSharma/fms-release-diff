/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

import com.filemaker.jwpc.exceptions.LoggerException;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.log.DebugLogFormatter;
import com.filemaker.jwpc.log.JWPCLogHandler;
import com.filemaker.jwpc.log.LoggerPreference;
import com.filemaker.jwpc.log.UserLogFormatter;
import com.filemaker.jwpc.util.Utilities;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerManager {
    static boolean s_IsInfoEnabled = true;
    static boolean s_IsErrorEnabled = true;
    static boolean s_IsDebugEnabled = false;
    private static Level USER_LOG_LEVEL = Level.SEVERE;
    private static Level DEBUG_LOG_LEVEL = Level.OFF;
    private static String USER_LOG_MAX_SIZE = "40MB";
    private static String DEBUG_LOG_MAX_SIZE = "10GB";
    private static Level JWPC_LOGGER_LEVEL = Level.INFO;

    public static void setupDefaultLogging() {
        LoggerManager.setupJWPCLogger(USER_LOG_LEVEL, USER_LOG_MAX_SIZE, DEBUG_LOG_LEVEL, JWPC_LOGGER_LEVEL);
    }

    private static void setupJWPCLogger(Level level, String string, Level level2, Level level3) {
        LoggerManager.resetJWPCLogger();
        if (IWPUtilities.isDebugMode()) {
            for (Handler object : Logger.getLogger("").getHandlers()) {
                if (!(object instanceof ConsoleHandler)) continue;
                object.setLevel(Level.FINE);
            }
            Logger.getLogger("com.filemaker.jwpc").setLevel(Level.FINE);
            Logger.getLogger("com.filemaker.jwpc").setUseParentHandlers(true);
        } else {
            for (Handler handler : Logger.getLogger("").getHandlers()) {
                if (!(handler instanceof ConsoleHandler)) continue;
                handler.setLevel(Level.INFO);
            }
            Logger.getLogger("com.filemaker.jwpc").setLevel(level3);
            Logger.getLogger("com.filemaker.jwpc").setUseParentHandlers(false);
        }
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> list = runtimeMXBean.getInputArguments();
        for (String string2 : list) {
            if (!string2.contains("catalina.base")) continue;
            String string3 = string2.split("=")[1];
            String string4 = string3 + "/../../../Logs";
            File file = new File(string4);
            if (!file.exists()) {
                file.mkdir();
            }
            LoggerManager.setupUserLogHandler(string4, level, string);
            LoggerManager.setupDebugLogHandler(string4, level2);
        }
    }

    public static void shutdownDefaultLogging() {
        LogManager.getLogManager().reset();
    }

    private static void resetJWPCLogger() {
        Logger logger = Logger.getLogger("com.filemaker.jwpc");
        for (Handler handler : logger.getHandlers()) {
            handler.flush();
            handler.close();
            logger.removeHandler(handler);
        }
    }

    public static synchronized void updateLogger(LoggerPreference loggerPreference) throws LoggerException {
        Level level = USER_LOG_LEVEL;
        String string = USER_LOG_MAX_SIZE;
        Level level2 = DEBUG_LOG_LEVEL;
        Level level3 = JWPC_LOGGER_LEVEL;
        String string2 = loggerPreference.getUserLogEnabled();
        String string3 = loggerPreference.getUserLogLevel();
        String string4 = loggerPreference.getUserLogSize();
        String string5 = loggerPreference.getDebugLogEnabled();
        if (!Utilities.isEmptyString(string2)) {
            if ("yes".equalsIgnoreCase(string2)) {
                if (!Utilities.isEmptyString(string3)) {
                    if ("info".equalsIgnoreCase(string3)) {
                        level = Level.INFO;
                        s_IsInfoEnabled = true;
                    } else if ("error".equalsIgnoreCase(string3)) {
                        level = Level.SEVERE;
                        s_IsInfoEnabled = false;
                    }
                }
                s_IsErrorEnabled = true;
            } else if ("no".equalsIgnoreCase(string2)) {
                level = Level.OFF;
                s_IsInfoEnabled = false;
                s_IsErrorEnabled = false;
            }
        } else if (!Utilities.isEmptyString(string3)) {
            if ("info".equalsIgnoreCase(string3)) {
                level = Level.INFO;
                s_IsInfoEnabled = true;
            } else if ("error".equalsIgnoreCase(string3)) {
                level = Level.SEVERE;
                s_IsInfoEnabled = false;
            }
        }
        if (!Utilities.isEmptyString(string4)) {
            string = string4;
        }
        if (!Utilities.isEmptyString(string5) && "yes".equalsIgnoreCase(string5)) {
            level3 = Level.FINE;
            level2 = Level.FINE;
            s_IsDebugEnabled = true;
        }
        LoggerManager.setupJWPCLogger(level, string, level2, level3);
    }

    private static void setupUserLogHandler(String string, Level level, String string2) {
        try {
            String string3 = string + "/wpe%g.log";
            JWPCLogHandler jWPCLogHandler = new JWPCLogHandler(string3, LoggerManager.getLimit(string2), 2, true);
            jWPCLogHandler.setLevel(level);
            jWPCLogHandler.setEncoding("UTF-8");
            jWPCLogHandler.setFormatter(new UserLogFormatter(jWPCLogHandler.getFile()));
            Logger.getLogger("com.filemaker.jwpc").addHandler(jWPCLogHandler);
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static void setupDebugLogHandler(String string, Level level) {
        try {
            String string2 = string + "/wpe_debug.log";
            JWPCLogHandler jWPCLogHandler = new JWPCLogHandler(string2, LoggerManager.getLimit(DEBUG_LOG_MAX_SIZE), 1, true);
            jWPCLogHandler.setLevel(level);
            jWPCLogHandler.setEncoding("UTF-8");
            jWPCLogHandler.setFormatter(new DebugLogFormatter(jWPCLogHandler.getFile()));
            Logger.getLogger("com.filemaker.jwpc").addHandler(jWPCLogHandler);
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static int getLimit(String string) {
        long l = 0L;
        if (string != null) {
            String string2 = string.trim().toUpperCase();
            l = string2.contains("KB") ? Long.parseLong(string2.replace("KB", "")) * 1024L : (string2.contains("MB") ? Long.parseLong(string2.replace("MB", "")) * 1024L * 1024L : (string2.contains("GB") ? Long.parseLong(string2.replace("GB", "")) * 1024L * 1024L * 1024L : Long.parseLong(string2)));
        }
        return l > Integer.MAX_VALUE ? 0 : (int)l;
    }
}

