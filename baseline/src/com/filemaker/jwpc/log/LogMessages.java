/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class LogMessages {
    private static final Properties s_msgProp = new Properties();
    public static final String SERVER_STARTED = "SERVER_STARTED";
    public static final String SERVER_STOPPED = "SERVER_STOPPED";
    public static final String USERLOG_ON = "USERLOG_ON";
    public static final String USERLOG_OFF = "USERLOG_OFF";
    public static final String USERLOGLEVEL_ERROR = "USERLOGLEVEL_ERROR";
    public static final String USERLOGLEVEL_INFO = "USERLOGLEVEL_INFO";
    public static final String USERLOGSIZE = "USERLOGSIZE";
    public static final String IWP_ENABLED_YES = "IWP_ENABLED_YES";
    public static final String IWP_ENABLED_NO = "IWP_ENABLED_NO";
    public static final String IWP_LANGUAGE = "IWP_LANGUAGE";
    public static final String IWP_SESSION_TIMEOUT = "IWP_SESSION_TIMEOUT";
    public static final String DEBUGLOG_ON = "DEBUGLOG_ON";
    public static final String DEBUGLOG_OFF = "DEBUGLOG_OFF";
    public static final String XML_ENABLED_YES = "XML_ENABLED_YES";
    public static final String XML_ENABLED_NO = "XML_ENABLED_NO";
    public static final String PHP_ENABLED_YES = "PHP_ENABLED_YES";
    public static final String PHP_ENABLED_NO = "PHP_ENABLED_NO";
    public static final String MWPE_ROUTING_YES = "MWPE_ROUTING_YES";
    public static final String MWPE_ROUTING_NO = "MWPE_ROUTING_NO";
    public static final String HOMEURL_ENABLED_YES = "HOMEURL_ENABLED_YES";
    public static final String HOMEURL_ENABLED_NO = "HOMEURL_ENABLED_NO";
    public static final String ARIA_COMPLIANT_CONTROL_ENABLED_YES = "ARIA_COMPLIANT_CONTROL_ENABLED_YES";
    public static final String ARIA_COMPLIANT_CONTROL_ENABLED_NO = "ARIA_COMPLIANT_CONTROL_ENABLED_NO";
    public static final String WEB_SCRIPTING_ERROR = "WEB_SCRIPTING_ERROR";
    public static final String DB_FILE = "DB_FILE";
    public static final String SCRIPT = "SCRIPT";
    public static final String SCRIPT_STEP = "SCRIPT_STEP";
    public static final String METHOD_ENTERING = "METHOD_ENTERING";
    public static final String METHOD_EXITING = "METHOD_EXITING";

    public static void loadLogMessages() {
        InputStream inputStream = LogMessages.class.getResourceAsStream("LogMessageStrings.properties");
        if (inputStream != null) {
            try {
                s_msgProp.clear();
                s_msgProp.load(inputStream);
            }
            catch (IOException iOException) {
                System.err.println("Load LogMessageStrings.properties caught IO exception: " + iOException.getMessage());
            }
        } else {
            System.err.println("LogMessageStrings.properties not found.");
        }
    }

    public static String get(String string) {
        return s_msgProp.getProperty(string, string);
    }

    public static String get(String string, Object ... objectArray) {
        String string2 = s_msgProp.getProperty(string, string);
        return MessageFormat.format(string2.replace("'", "''"), objectArray);
    }

    static {
        LogMessages.loadLogMessages();
    }
}

