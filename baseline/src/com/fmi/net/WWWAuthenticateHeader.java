/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.HttpHeader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class WWWAuthenticateHeader
extends HttpHeader {
    private String m_scheme;
    private String m_realm;

    public WWWAuthenticateHeader(String value) throws NoSuchElementException {
        super("WWW-Authenticate", value);
        this.parse();
    }

    public String getRealm() {
        return this.m_realm;
    }

    public String getScheme() {
        return this.m_scheme;
    }

    private void parse() {
        StringTokenizer tokenizer = new StringTokenizer(this.getValue());
        this.m_scheme = tokenizer.nextToken(" ");
        String realmKeyWord = tokenizer.nextToken("=").trim();
        if (realmKeyWord.equalsIgnoreCase("realm")) {
            tokenizer.nextToken("\"");
            this.m_realm = tokenizer.nextToken("\"");
        }
    }
}

