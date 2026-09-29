/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.NameValuePair;

public interface HttpResponseData {
    public NameValuePair[] getHeader(String var1);

    public NameValuePair[] getHeaders();
}

