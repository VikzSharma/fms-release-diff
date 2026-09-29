/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import java.io.UnsupportedEncodingException;

public class URLEncoder {
    static boolean[] m_dontNeedEncoding;
    static final char[] m_numberChars;

    static {
        m_numberChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        m_dontNeedEncoding = new boolean[256];
        int i = 0;
        while (i < 256) {
            URLEncoder.m_dontNeedEncoding[i] = false;
            ++i;
        }
        i = 97;
        while (i <= 122) {
            URLEncoder.m_dontNeedEncoding[i] = true;
            ++i;
        }
        i = 65;
        while (i <= 90) {
            URLEncoder.m_dontNeedEncoding[i] = true;
            ++i;
        }
        i = 48;
        while (i <= 57) {
            URLEncoder.m_dontNeedEncoding[i] = true;
            ++i;
        }
        URLEncoder.m_dontNeedEncoding[32] = true;
        URLEncoder.m_dontNeedEncoding[45] = true;
        URLEncoder.m_dontNeedEncoding[95] = true;
        URLEncoder.m_dontNeedEncoding[46] = true;
        URLEncoder.m_dontNeedEncoding[42] = true;
        URLEncoder.m_dontNeedEncoding[40] = true;
        URLEncoder.m_dontNeedEncoding[41] = true;
    }

    private URLEncoder() {
    }

    public static String encode(byte[] bytes) {
        int numberOfBytes = bytes.length;
        StringBuffer out = new StringBuffer(numberOfBytes);
        int i = 0;
        while (i < numberOfBytes) {
            char c = (char)(bytes[i] & 0xFF);
            if (m_dontNeedEncoding[c]) {
                if (c == ' ') {
                    c = '+';
                }
                out.append(c);
            } else {
                out.append('%');
                out.append(m_numberChars[c >> 4 & 0xF]);
                out.append(m_numberChars[c & 0xF]);
            }
            ++i;
        }
        return out.toString();
    }

    public static String encode(String s, String encoding) throws UnsupportedEncodingException {
        return URLEncoder.encode(s.getBytes(encoding));
    }
}

