/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.NameValueParserException;

public interface NameValueHandler {
    public boolean process(String var1, String var2) throws NameValueParserException;
}

