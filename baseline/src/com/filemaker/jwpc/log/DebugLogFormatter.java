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

public class DebugLogFormatter
extends Formatter {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private File file;

    public DebugLogFormatter(File file) {
        this.file = file;
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.df.format(new Date(logRecord.getMillis()))).append(" ").append("[" + this.getThreadNameById(logRecord.getThreadID()) + "]").append(" ").append(logRecord.getSourceClassName()).append(" - ").append(this.formatMessage(logRecord)).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String getHead(Handler handler) {
        if (this.file.exists() && this.file.length() == 0L) {
            return "[TIMESTAMP_GMT]\t[THREAD_NAME]\t[CLASSNAME]\t[MESSAGE]\n";
        }
        return "";
    }

    private String getThreadNameById(int n) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getId() != (long)n) continue;
            return thread.getName();
        }
        return Integer.toString(n);
    }
}

