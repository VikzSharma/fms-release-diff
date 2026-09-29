/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.ServletOutputStream
 *  jakarta.servlet.http.HttpServletResponse
 *  jakarta.servlet.http.HttpServletResponseWrapper
 */
package com.filemaker.jwpc.http;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpResponseWrapper
extends HttpServletResponseWrapper {
    private int httpStatus;
    private JWPCPrintWriter jpw;
    private Integer m_contentLength = null;

    public HttpResponseWrapper(HttpServletResponse httpServletResponse) throws IOException {
        super(httpServletResponse);
    }

    public void sendError(int n) throws IOException {
        this.httpStatus = n;
        super.sendError(n);
    }

    public void sendError(int n, String string) throws IOException {
        this.httpStatus = n;
        super.sendError(n, string);
    }

    public void setStatus(int n) {
        this.httpStatus = n;
        super.setStatus(n);
    }

    public PrintWriter getWriter() throws IOException {
        if (this.jpw == null) {
            this.jpw = new JWPCPrintWriter(this, super.getWriter());
        }
        return this.jpw;
    }

    public void setContentLength(int n) {
        super.setContentLength(n);
        this.m_contentLength = n;
    }

    public int getStatus() {
        return this.httpStatus;
    }

    public long getContentLength() {
        if (this.m_contentLength != null) {
            return this.m_contentLength.longValue();
        }
        return this.jpw != null ? this.jpw.getContentLength() : 0L;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    private class JWPCPrintWriter
    extends PrintWriter {
        long m_contentLength = 0L;
        static final long MAX_CONTENT_LENGTH = Long.MAX_VALUE;

        JWPCPrintWriter(HttpResponseWrapper httpResponseWrapper, PrintWriter printWriter) {
            super(printWriter);
        }

        @Override
        public void write(String string) {
            super.write(string);
            if (string != null) {
                try {
                    this.m_contentLength = Math.addExact(this.m_contentLength, (long)string.getBytes().length);
                }
                catch (ArithmeticException arithmeticException) {
                    this.m_contentLength = Long.MAX_VALUE;
                    arithmeticException.printStackTrace();
                }
            }
        }

        @Override
        public void write(String string, int n, int n2) {
            super.write(string, n, n2);
            if (string != null) {
                try {
                    this.m_contentLength = Math.addExact(this.m_contentLength, (long)string.substring(n, n + n2).getBytes().length);
                }
                catch (ArithmeticException arithmeticException) {
                    this.m_contentLength = Long.MAX_VALUE;
                    arithmeticException.printStackTrace();
                }
            }
        }

        @Override
        public void write(char[] cArray) {
            if (cArray == null) {
                return;
            }
            this.write(cArray, 0, cArray.length);
        }

        @Override
        public void write(char[] cArray, int n, int n2) {
            super.write(cArray, n, n2);
            try {
                this.m_contentLength = Math.addExact(this.m_contentLength, (long)String.valueOf(cArray, n, n2).getBytes().length);
            }
            catch (ArithmeticException arithmeticException) {
                this.m_contentLength = Long.MAX_VALUE;
                arithmeticException.printStackTrace();
            }
        }

        @Override
        public void write(int n) {
            super.write(n);
            try {
                this.m_contentLength = Math.addExact(this.m_contentLength, (long)String.valueOf(n).getBytes().length);
            }
            catch (ArithmeticException arithmeticException) {
                this.m_contentLength = Long.MAX_VALUE;
                arithmeticException.printStackTrace();
            }
        }

        public long getContentLength() {
            return this.m_contentLength;
        }
    }
}

