/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.NameValueHandler;
import com.fmi.net.NameValueParserException;
import java.util.StringTokenizer;

public class NameValueParser {
    private NameValueHandler m_nameValueHandler = null;

    public NameValueParser(NameValueHandler nameValueHandler) {
        this.m_nameValueHandler = nameValueHandler;
    }

    public void parse(String nameValuePairs, char assignmentChar, char separatorChar) throws NameValueParserException {
        if (nameValuePairs != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameValuePairs, new String(new char[]{separatorChar}));
            while (tokenizer.hasMoreTokens()) {
                String value;
                String name;
                String pair = tokenizer.nextToken();
                int assignmentIndex = pair.indexOf(assignmentChar);
                if (assignmentIndex != -1) {
                    name = pair.substring(0, assignmentIndex);
                    value = pair.substring(assignmentIndex + 1);
                } else {
                    name = pair;
                    value = "";
                }
                if (this.m_nameValueHandler != null && !this.m_nameValueHandler.process(name, value)) break;
            }
        }
    }

    public void setHandler(NameValueHandler nameValueHandler) {
        this.m_nameValueHandler = nameValueHandler;
    }
}

