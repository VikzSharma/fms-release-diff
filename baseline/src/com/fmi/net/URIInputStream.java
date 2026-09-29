/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.URI;
import com.fmi.net.UnsupportedSchemeException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class URIInputStream
extends InputStream {
    private InputStream m_inputStream;
    private URI m_uri;

    public URIInputStream(URI uri) throws UnsupportedSchemeException, IOException {
        this.m_uri = uri;
        this.initializeInputStream();
    }

    public int read() throws IOException {
        return this.m_inputStream.read();
    }

    public long skip(long n) throws IOException {
        return this.m_inputStream.skip(n);
    }

    public synchronized void mark(int readlimit) {
        this.m_inputStream.mark(readlimit);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return this.m_inputStream.read(b, off, len);
    }

    public boolean markSupported() {
        return this.m_inputStream.markSupported();
    }

    public int available() throws IOException {
        return this.m_inputStream.available();
    }

    public synchronized void reset() throws IOException {
        this.m_inputStream.reset();
    }

    public void close() throws IOException {
        this.m_inputStream.close();
    }

    public int read(byte[] b) throws IOException {
        return this.m_inputStream.read(b);
    }

    public URI getURI() {
        return this.m_uri;
    }

    private void initializeInputStream() throws UnsupportedSchemeException, IOException {
        String scheme = this.m_uri.getScheme();
        if (scheme.equalsIgnoreCase("file")) {
            this.m_inputStream = new FileInputStream(this.m_uri.getPath());
        } else if (scheme.equalsIgnoreCase("resource")) {
            this.m_inputStream = this.getClass().getResourceAsStream(this.m_uri.getPath());
            if (this.m_inputStream == null) {
                throw new FileNotFoundException(this.m_uri.getPath());
            }
        } else {
            throw new UnsupportedSchemeException(scheme);
        }
    }
}

