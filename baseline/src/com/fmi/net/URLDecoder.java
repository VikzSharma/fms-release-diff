/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class URLDecoder {
    private static int[] m_hexToDecimal = new int[128];

    static {
        int i = 0;
        while (i < m_hexToDecimal.length) {
            URLDecoder.m_hexToDecimal[i] = -1;
            ++i;
        }
        int decimal = 0;
        i = 48;
        while (i <= 57) {
            URLDecoder.m_hexToDecimal[i] = decimal++;
            ++i;
        }
        decimal = 10;
        i = 97;
        while (i <= 102) {
            URLDecoder.m_hexToDecimal[i] = decimal++;
            ++i;
        }
        decimal = 10;
        i = 65;
        while (i <= 70) {
            URLDecoder.m_hexToDecimal[i] = decimal++;
            ++i;
        }
    }

    protected URLDecoder() {
    }

    public static String decode(InputStream in, String encoding, int length) throws IOException, UnsupportedEncodingException {
        int currentByte;
        ByteArrayOutputStream out = length > 0 ? new ByteArrayOutputStream(length) : new ByteArrayOutputStream(1024);
        while ((currentByte = in.read()) != -1) {
            if (currentByte == 43) {
                out.write(32);
                continue;
            }
            if (currentByte == 37) {
                out.write(m_hexToDecimal[in.read()] * 16 + m_hexToDecimal[in.read()]);
                continue;
            }
            out.write(currentByte);
        }
        return out.toString(encoding);
    }

    public static String decode(String s) {
        StringBuffer decoded = new StringBuffer(s.length());
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            if (currentChar == '+') {
                decoded.append(" ");
                ++i;
                continue;
            }
            if (currentChar == '%') {
                char decodedChar = (char)(m_hexToDecimal[s.charAt(i + 1)] * 16 + m_hexToDecimal[s.charAt(i + 2)]);
                decoded.append(decodedChar);
                i += 3;
                continue;
            }
            decoded.append(currentChar);
            ++i;
        }
        String decodedString = decoded.toString();
        return decodedString;
    }

    public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        String decodedString = new String(URLDecoder.decode(s).getBytes("ISO8859_1"), encoding);
        return decodedString;
    }
}

