/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.HttpResponseData;
import com.fmi.net.NameValuePair;
import java.util.Enumeration;
import java.util.Vector;

public class HttpByteArray
implements HttpResponseData {
    private byte[] mData = null;
    private Vector mHeaders = null;

    public HttpByteArray(byte[] data) {
        this.mData = data;
        this.mHeaders = new Vector();
    }

    public void addHeader(String name, String value) {
        NameValuePair nvpair = new NameValuePair(name, value);
        this.mHeaders.add(nvpair);
    }

    public NameValuePair[] getHeader(String name) {
        Vector<NameValuePair> headerMatches = new Vector<NameValuePair>();
        Enumeration headers = this.mHeaders.elements();
        while (headers.hasMoreElements()) {
            NameValuePair header = (NameValuePair)headers.nextElement();
            if (!header.getName().equals(name)) continue;
            headerMatches.add(header);
        }
        int headerCount = headerMatches.size();
        NameValuePair[] returnArray = new NameValuePair[headerCount];
        int i = 0;
        while (i < headerCount) {
            returnArray[i] = (NameValuePair)headerMatches.get(i);
            ++i;
        }
        return returnArray;
    }

    public NameValuePair[] getHeaders() {
        int headerCount = this.mHeaders.size();
        NameValuePair[] returnArray = new NameValuePair[headerCount];
        int i = 0;
        while (i < headerCount) {
            returnArray[i] = (NameValuePair)this.mHeaders.get(i);
            ++i;
        }
        return returnArray;
    }

    public byte[] getBytes() {
        return this.mData;
    }
}

