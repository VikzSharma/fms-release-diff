/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpResponse
extends InputStream {
    private HttpURLConnection m_connection = null;
    private InputStream m_inputStream = null;
    private Object m_initialize = new Object();

    public int available() throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        return this.m_inputStream.available();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void initializeInputStream() throws IOException {
        if (this.m_connection == null) {
            throw new IOException();
        }
        Object object = this.m_initialize;
        synchronized (object) {
            if (this.m_inputStream == null) {
                this.m_inputStream = this.m_connection.getInputStream();
            }
        }
    }

    public HttpResponse(HttpURLConnection connection) {
        this.m_connection = connection;
    }

    public long skip(long n) throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        return this.m_inputStream.skip(n);
    }

    public synchronized void reset() throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        this.m_inputStream.reset();
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        return this.m_inputStream.read(b, off, len);
    }

    public int read(byte[] b) throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        return this.m_inputStream.read(b);
    }

    public boolean markSupported() {
        try {
            if (this.m_inputStream == null) {
                this.initializeInputStream();
            }
            return this.m_inputStream.markSupported();
        }
        catch (IOException ioException) {
            return false;
        }
    }

    public synchronized void mark(int readlimit) {
        try {
            if (this.m_inputStream == null) {
                this.initializeInputStream();
            }
            this.m_inputStream.mark(readlimit);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public void close() throws IOException {
        if (this.m_inputStream != null) {
            this.m_inputStream.close();
            this.m_inputStream = null;
        }
        if (this.m_connection != null) {
            this.m_connection.disconnect();
            this.m_connection = null;
        }
    }

    public int read() throws IOException {
        if (this.m_inputStream == null) {
            this.initializeInputStream();
        }
        return this.m_inputStream.read();
    }
}

