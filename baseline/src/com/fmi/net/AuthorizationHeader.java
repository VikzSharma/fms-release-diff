/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.Base64;
import com.fmi.net.HttpHeader;
import java.io.UnsupportedEncodingException;

public class AuthorizationHeader
extends HttpHeader {
    String mEncoding;
    String m_authenticationScheme;
    String m_user;
    String m_password;

    public AuthorizationHeader(String value) {
        super("Authorization", value);
        this.parseValue();
    }

    public AuthorizationHeader(String scheme, String user, String password) {
        super("Authorization", AuthorizationHeader.constructValue(scheme, user, password));
        this.m_authenticationScheme = scheme;
        this.m_user = user;
        this.m_password = password;
        this.mEncoding = "ISO-8859-1";
    }

    private static String constructValue(String scheme, String user, String password) {
        String value = "";
        if (scheme != null && password != null && scheme.equalsIgnoreCase("Basic")) {
            String authentication = user != null ? String.valueOf(user) + ":" + password : ":" + password;
            try {
                value = String.valueOf(scheme) + " " + Base64.encode(authentication.getBytes("ISO-8859-1"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
        }
        return value;
    }

    public String getScheme() {
        return this.m_authenticationScheme;
    }

    public String getUser() {
        return this.m_user;
    }

    public String getPassword() {
        return this.m_password;
    }

    private void parseValue() {
        String value = this.getValue();
        int separatorIndex = value.indexOf(32);
        this.m_authenticationScheme = value.substring(0, separatorIndex);
        if (this.m_authenticationScheme.equalsIgnoreCase("Basic")) {
            String decodedAuthorization = null;
            try {
                decodedAuthorization = new String(Base64.decode(value.substring(separatorIndex + 1)), "ISO-8859-1");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
            int colonIndex = decodedAuthorization.indexOf(58);
            if (colonIndex != -1) {
                this.m_user = decodedAuthorization.substring(0, colonIndex);
                this.m_password = decodedAuthorization.substring(colonIndex + 1);
            }
        }
    }
}

