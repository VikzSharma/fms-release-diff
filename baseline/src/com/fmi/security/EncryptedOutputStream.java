/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.security;

import java.io.IOException;
import java.io.OutputStream;

public class EncryptedOutputStream
extends OutputStream {
    private OutputStream m_out;
    private boolean m_writeHeader = true;
    private int[] m_bytes;
    private int m_byteCount = 0;
    private int m_xorByte = 100;
    private static final byte[] FORMAT_ID = new byte[]{70, 77, 73, 69};
    private static final byte[] VERSION = new byte[]{48, 49};
    private static final byte[] COPYRIGHT = new String("Copyright (c) 2001 - 2002 FileMaker, Inc. All Rights Reserved.").getBytes();
    private static final int HEADER_LENGTH = 128;
    private static final char[] BASE64_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public EncryptedOutputStream(OutputStream out) {
        this.m_out = out;
        this.m_bytes = new int[3];
    }

    public void write(int b) throws IOException {
        if (this.m_writeHeader) {
            this.m_out.write(FORMAT_ID);
            this.m_out.write(VERSION);
            this.m_out.write(COPYRIGHT);
            int padLength = 128 - (FORMAT_ID.length + VERSION.length + COPYRIGHT.length);
            int i = 0;
            while (i < padLength) {
                this.m_out.write(32);
                ++i;
            }
            this.m_writeHeader = false;
        }
        this.m_bytes[this.m_byteCount] = b;
        ++this.m_byteCount;
        if (this.m_byteCount == 3) {
            this.writeEncrypted();
        }
    }

    private void writeEncrypted() throws IOException {
        switch (this.m_byteCount) {
            case 3: {
                int bits24 = (this.m_bytes[0] & 0xFF) << 16;
                bits24 |= (this.m_bytes[1] & 0xFF) << 8;
                int bits6 = ((bits24 |= (this.m_bytes[2] & 0xFF) << 0) & 0xFC0000) >> 18;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = (bits24 & 0x3F000) >> 12;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = (bits24 & 0xFC0) >> 6;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = bits24 & 0x3F;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                break;
            }
            case 2: {
                int bits24 = (this.m_bytes[0] & 0xFF) << 16;
                int bits6 = ((bits24 |= (this.m_bytes[1] & 0xFF) << 8) & 0xFC0000) >> 18;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = (bits24 & 0x3F000) >> 12;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = (bits24 & 0xFC0) >> 6;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                this.m_xorByte ^= 0x3D;
                this.m_out.write(this.m_xorByte);
                break;
            }
            case 1: {
                int bits24 = (this.m_bytes[0] & 0xFF) << 16;
                int bits6 = (bits24 & 0xFC0000) >> 18;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                bits6 = (bits24 & 0x3F000) >> 12;
                this.m_xorByte ^= BASE64_ALPHABET[bits6];
                this.m_out.write(this.m_xorByte);
                this.m_xorByte ^= 0x3D;
                this.m_out.write(this.m_xorByte);
                this.m_xorByte ^= 0x3D;
                this.m_out.write(this.m_xorByte);
            }
        }
        this.m_byteCount = 0;
    }

    public void close() throws IOException {
        this.writeEncrypted();
        this.m_out.close();
    }

    public void flush() throws IOException {
        this.m_out.flush();
    }
}

