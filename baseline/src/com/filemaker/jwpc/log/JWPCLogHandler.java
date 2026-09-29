/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.log;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class JWPCLogHandler
extends FileHandler {
    private String filePattern;

    public JWPCLogHandler() throws IOException, SecurityException {
    }

    public JWPCLogHandler(String string) throws IOException, SecurityException {
        super(string);
        this.filePattern = string;
    }

    public JWPCLogHandler(String string, boolean bl) throws IOException, SecurityException {
        super(string, bl);
        this.filePattern = string;
    }

    public JWPCLogHandler(String string, int n, int n2) throws IOException, SecurityException {
        super(string, n, n2);
        this.filePattern = string;
    }

    public JWPCLogHandler(String string, int n, int n2, boolean bl) throws IOException, SecurityException {
        super(string, n, n2, bl);
        this.filePattern = string;
    }

    public File getFile() throws IOException {
        if (this.filePattern != null) {
            File file = new File(this.filePattern.replace("%g", "0"));
            return file;
        }
        return null;
    }
}

