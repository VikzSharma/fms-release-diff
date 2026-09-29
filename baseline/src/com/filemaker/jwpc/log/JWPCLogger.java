/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

import com.filemaker.jwpc.context.JWPCContext;
import com.filemaker.jwpc.context.JWPCContextHandler;
import com.filemaker.jwpc.log.LogData;
import com.filemaker.jwpc.log.LogMessages;
import com.filemaker.jwpc.log.LoggerManager;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JWPCLogger {
    private static Map<String, JWPCLogger> loggers = new HashMap<String, JWPCLogger>(5);
    private static final String EMPTY_LOG_FIELD = "-";
    private Logger logger;

    private JWPCLogger(Logger logger, boolean bl, String string) {
        this.logger = logger;
    }

    public static JWPCLogger getLogger(Class clazz) {
        String string = clazz.getCanonicalName();
        JWPCLogger jWPCLogger = loggers.get(string);
        if (jWPCLogger == null) {
            jWPCLogger = JWPCLogger.createLogger(string);
        }
        return jWPCLogger;
    }

    private static synchronized JWPCLogger createLogger(String string) {
        JWPCLogger jWPCLogger = loggers.get(string);
        if (jWPCLogger == null) {
            jWPCLogger = new JWPCLogger(Logger.getLogger(string), false, string);
            loggers.put(string, jWPCLogger);
        }
        return jWPCLogger;
    }

    public boolean isInfoLoggingEnabled() {
        return LoggerManager.s_IsInfoEnabled;
    }

    public boolean isErrorLoggingEnabled() {
        return LoggerManager.s_IsErrorEnabled;
    }

    public boolean isDebugLoggingEnabled() {
        return LoggerManager.s_IsDebugEnabled;
    }

    public void info(LogData logData) {
        if (this.isInfoLoggingEnabled()) {
            this.logger.info(this.constructLogEntry(logData, Level.INFO));
        }
    }

    public void info(String string) {
        if (this.isInfoLoggingEnabled()) {
            this.logger.info(string);
        }
    }

    public void warn(LogData logData) {
        if (this.isInfoLoggingEnabled()) {
            this.logger.warning(this.constructLogEntry(logData, Level.WARNING));
        }
    }

    public void warn(String string) {
        if (this.isInfoLoggingEnabled()) {
            this.logger.warning(string);
        }
    }

    public void error(LogData logData) {
        if (this.isErrorLoggingEnabled()) {
            this.logger.severe(this.constructLogEntry(logData, Level.SEVERE));
        }
    }

    public void error(String string) {
        if (this.isErrorLoggingEnabled()) {
            this.logger.severe(string);
        }
    }

    public void error(String string, Throwable throwable) {
        if (this.isErrorLoggingEnabled()) {
            this.logger.log(Level.SEVERE, string, throwable);
        }
    }

    public void debug(LogData logData) {
        if (this.isDebugLoggingEnabled()) {
            this.logger.fine(this.constructLogEntry(logData, null));
        }
    }

    public void infoAndDebug(LogData logData) {
        String string = null;
        if (this.isInfoLoggingEnabled()) {
            string = this.constructLogEntry(logData, Level.INFO);
            this.logger.info(string);
        }
        if (this.isDebugLoggingEnabled()) {
            if (string == null) {
                string = this.constructLogEntry(logData, null);
            }
            this.logger.fine(string);
        }
    }

    public void errorAndDebug(LogData logData) {
        String string = null;
        if (this.isErrorLoggingEnabled()) {
            string = this.constructLogEntry(logData, Level.SEVERE);
            this.logger.severe(string);
        }
        if (this.isDebugLoggingEnabled()) {
            if (string == null) {
                string = this.constructLogEntry(logData, null);
            }
            this.logger.fine(string);
        }
    }

    public void debugEntering(String string) {
        if (this.isDebugLoggingEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(string).append("() ").append(LogMessages.get("METHOD_ENTERING"));
            this.logger.fine(stringBuffer.toString());
        }
    }

    public void debugExiting(String string) {
        if (this.isDebugLoggingEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(string).append("() ").append(LogMessages.get("METHOD_EXITING"));
            this.logger.fine(stringBuffer.toString());
        }
    }

    public void debug(String string) {
        if (this.isDebugLoggingEnabled()) {
            this.logger.fine(string);
        }
    }

    public void debug(String string, Throwable throwable) {
        if (this.isDebugLoggingEnabled()) {
            this.logger.log(Level.FINE, string, throwable);
        }
    }

    private String constructLogEntry(LogData logData, Level level) {
        Integer n;
        JWPCContext jWPCContext = JWPCContextHandler.currentContext();
        if (jWPCContext == null) {
            jWPCContext = new JWPCContext();
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('\t');
        stringBuilder.append(this.getStringForLogging(jWPCContext.getWPCHostName()));
        stringBuilder.append('\t');
        stringBuilder.append(this.getClientIPAndPortForLogging(jWPCContext));
        stringBuilder.append('\t');
        stringBuilder.append(this.getStringForLogging(jWPCContext.getAccountName()));
        stringBuilder.append('\t');
        stringBuilder.append(this.getStringForLogging(jWPCContext.getModuleType()));
        stringBuilder.append('\t');
        if (level != null) {
            stringBuilder.append(level);
            stringBuilder.append('\t');
        }
        if ((n = logData.getFMErrorCode()) != null) {
            stringBuilder.append(this.getStringForLogging(n));
        } else if (logData.getHttpErrorCode() != null) {
            stringBuilder.append("HTTP:").append(this.getStringForLogging(logData.getHttpErrorCode()));
        } else {
            stringBuilder.append(EMPTY_LOG_FIELD);
        }
        stringBuilder.append('\t');
        stringBuilder.append(this.getStringForLogging(logData.getReturnBytes()));
        stringBuilder.append('\t');
        stringBuilder.append(this.getStringForLogging(logData.getMessage()));
        return stringBuilder.toString();
    }

    private String getClientIPAndPortForLogging(JWPCContext jWPCContext) {
        String string = this.getStringForLogging(jWPCContext.getClientIP());
        if (EMPTY_LOG_FIELD.equalsIgnoreCase(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        if (jWPCContext.getClientPort() >= 0) {
            stringBuilder.append(':');
            stringBuilder.append(jWPCContext.getClientPort());
        }
        return stringBuilder.toString();
    }

    private String getStringForLogging(Object object) {
        if (object == null) {
            return EMPTY_LOG_FIELD;
        }
        if (object instanceof String) {
            String string = ((String)object).trim();
            return string.length() > 0 ? string : EMPTY_LOG_FIELD;
        }
        return object.toString();
    }
}

