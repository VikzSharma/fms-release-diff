/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Encodings {
    private static Map m_mimeToJava;
    private static Map m_javaToMime;
    private static final String[][] JAVA_MIME_ENCODING;

    static {
        JAVA_MIME_ENCODING = new String[][]{{"ASCII", "US-ASCII"}, {"ISO2022KR", "ISO-2022-KR"}, {"EUC_KR", "EUC-KR"}, {"ISO2022JP", "ISO-2022-JP"}, {"ISO8859_1", "ISO-8859-1"}, {"ISO8859_2", "ISO-8859-2"}, {"ISO8859_3", "ISO-8859-3"}, {"ISO8859_4", "ISO-8859-4"}, {"ISO8859_5", "ISO-8859-5"}, {"ISO8859_6", "ISO-8859-6"}, {"ISO8859_7", "ISO-8859-7"}, {"ISO8859_8", "ISO-8859-8"}, {"ISO8859_9", "ISO-8859-9"}, {"ISO8859_15", "ISO-8859-15"}, {"KOI8_R", "KOI8-R"}, {"SJIS", "Shift_JIS"}, {"EUC_JP", "EUC-JP"}, {"EUC_CN", "GB2312"}, {"Big5", "Big5"}, {"UTF8", "UTF-8"}};
        int encodings = JAVA_MIME_ENCODING.length;
        m_javaToMime = new HashMap(encodings);
        m_mimeToJava = new HashMap(encodings);
        int i = 0;
        while (i < encodings) {
            m_javaToMime.put(JAVA_MIME_ENCODING[i][0], JAVA_MIME_ENCODING[i][1]);
            m_mimeToJava.put(JAVA_MIME_ENCODING[i][1], JAVA_MIME_ENCODING[i][0]);
            ++i;
        }
    }

    private Encodings() {
    }

    public static String convertJavaToMimeEncoding(String encoding) throws UnsupportedEncodingException {
        String mimeEncoding = (String)m_javaToMime.get(encoding);
        if (mimeEncoding != null) {
            return mimeEncoding;
        }
        throw new UnsupportedEncodingException(encoding);
    }

    public static String convertMimeToJavaEncoding(String encoding) throws UnsupportedEncodingException {
        String javaEncoding = (String)m_mimeToJava.get(encoding);
        if (javaEncoding != null) {
            return javaEncoding;
        }
        throw new UnsupportedEncodingException(encoding);
    }

    public static boolean isSupportedMimeEnccoding(String encoding) {
        String javaEncoding = (String)m_mimeToJava.get(encoding);
        return javaEncoding != null;
    }
}

