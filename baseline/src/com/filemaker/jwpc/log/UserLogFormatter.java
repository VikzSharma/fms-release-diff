/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class UserLogFormatter
extends Formatter {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private File file;

    public UserLogFormatter(File file) {
        this.file = file;
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.df.format(new Date(logRecord.getMillis()))).append(" ").append(this.formatMessage(logRecord)).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String getHead(Handler handler) {
        if (this.file.exists() && this.file.length() == 0L) {
            return "[TIMESTAMP_GMT]\t[WPC_HOSTNAME]\t[CLIENT_IP:PORT]\t[ACCOUNT_NAME]\t[MODULE_TYPE]\t[SEVERITY]\t[FM_ERRORCODE]\t[RETURN_BYTES]\t[MESSAGE]\n";
        }
        return "";
    }
}

