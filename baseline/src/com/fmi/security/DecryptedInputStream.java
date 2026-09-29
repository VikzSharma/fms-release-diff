/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.security;

import java.io.IOException;
import java.io.InputStream;

public class DecryptedInputStream
extends InputStream {
    private InputStream m_in;
    private boolean m_readHeader = true;
    private byte[] m_bytes;
    private int m_byteIndex = 0;
    private int m_byteCount;
    private int m_padding = 0;
    private int m_xorByte = 100;
    private boolean m_decrypt = false;
    private static final byte[] FORMAT_ID = new byte[]{70, 77, 73, 69};
    private static final byte[] VERSION = new byte[]{48, 49};
    private static final int HEADER_LENGTH = 128;
    private static final char[] BASE64_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final int[] CHARACTER_TO_VALUE = new int[256];
    private static final int IGNORE = -1;
    private static final int PAD = -2;

    static {
        int i = 0;
        while (i < CHARACTER_TO_VALUE.length) {
            DecryptedInputStream.CHARACTER_TO_VALUE[i] = -1;
            ++i;
        }
        i = 0;
        while (i < BASE64_ALPHABET.length) {
            DecryptedInputStream.CHARACTER_TO_VALUE[DecryptedInputStream.BASE64_ALPHABET[i]] = i;
            ++i;
        }
        DecryptedInputStream.CHARACTER_TO_VALUE[61] = -2;
    }

    public DecryptedInputStream(InputStream in) {
        this.m_in = in;
        this.m_bytes = new byte[FORMAT_ID.length];
    }

    public int read() throws IOException {
        if (this.m_readHeader) {
            this.m_byteCount = this.m_in.read(this.m_bytes);
            int i = 0;
            while (i < FORMAT_ID.length && i < this.m_byteCount) {
                if (this.m_bytes[i] != FORMAT_ID[i]) break;
                ++i;
            }
            if (i == FORMAT_ID.length) {
                if (this.m_in.read() != VERSION[0] || this.m_in.read() != VERSION[1]) {
                    throw new IOException("Unsupported encryption version");
                }
                this.m_in.skip(128 - (FORMAT_ID.length + VERSION.length));
                this.m_decrypt = true;
                this.m_byteCount = 0;
            }
            this.m_readHeader = false;
        }
        if (this.m_decrypt) {
            return this.readAndDecrypt();
        }
        if (this.m_byteIndex < this.m_byteCount) {
            byte data = this.m_bytes[this.m_byteIndex];
            ++this.m_byteIndex;
            return data;
        }
        return this.m_in.read();
    }

    private int readAndDecrypt() throws IOException {
        if (this.m_byteIndex >= this.m_byteCount) {
            int combined = 0;
            int position = 0;
            this.m_byteCount = -1;
            while (position < 4) {
                int c = this.m_in.read();
                if (c == -1) {
                    if (position == 0) break;
                    throw new IOException("File is not properly encrypted");
                }
                int base64 = this.m_xorByte ^ c;
                this.m_xorByte = c;
                int value = base64 <= 255 ? CHARACTER_TO_VALUE[base64] : -1;
                block0 : switch (value) {
                    case -1: {
                        break;
                    }
                    case -2: {
                        ++this.m_padding;
                        value = 0;
                    }
                    default: {
                        switch (position) {
                            case 0: {
                                combined = value;
                                ++position;
                                break block0;
                            }
                            case 1: {
                                combined <<= 6;
                                combined |= value;
                                ++position;
                                break block0;
                            }
                            case 2: {
                                combined <<= 6;
                                combined |= value;
                                ++position;
                                break block0;
                            }
                            case 3: {
                                combined <<= 6;
                                this.m_bytes[2] = (byte)(combined |= value);
                                this.m_bytes[1] = (byte)(combined >>>= 8);
                                this.m_bytes[0] = (byte)(combined >>>= 8);
                                this.m_byteCount = 3 - this.m_padding;
                                this.m_byteIndex = 0;
                                ++position;
                            }
                        }
                    }
                }
            }
        }
        if (this.m_byteCount > 0) {
            byte data = this.m_bytes[this.m_byteIndex];
            ++this.m_byteIndex;
            return data;
        }
        return -1;
    }

    public long skip(long n) throws IOException {
        return this.m_in.skip(n);
    }

    public synchronized void mark(int readlimit) {
        this.m_in.mark(readlimit);
    }

    public boolean markSupported() {
        return this.m_in.markSupported();
    }

    public int available() throws IOException {
        return this.m_in.available();
    }

    public synchronized void reset() throws IOException {
        this.m_in.reset();
    }

    public void close() throws IOException {
        this.m_in.close();
    }
}

