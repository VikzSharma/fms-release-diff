/*
 * Decompiled with CFR 0.152.
 */
package com.fmi.net;

import com.fmi.net.NameValueHandler;
import com.fmi.net.NameValueParser;
import com.fmi.net.NameValueParserException;
import com.fmi.net.URLDecoder;
import java.util.Properties;

public class URI {
    public static final int DEFAULT_PORT = -1;
    private String m_uri;
    private String m_scheme;
    private String m_schemeSpecificPart;
    private String m_authority;
    private String m_userInfo;
    private String m_user;
    private String m_password;
    private String m_host;
    private int m_port;
    private String m_path;
    private String m_query;
    private String m_fragment;
    private boolean m_useSession = false;
    private String m_sessionKey;

    public URI(String spec) {
        this.m_uri = spec;
        this.parseURI(spec);
    }

    public URI() {
    }

    public String getAuthority() {
        return this.m_authority;
    }

    public String getHost() {
        return this.m_host;
    }

    public void setHost(String host) {
        this.m_host = host;
    }

    public String getFragment() {
        return this.m_fragment;
    }

    public String getPassword() {
        return this.m_password;
    }

    public void setPassword(String password) {
        this.m_password = password;
    }

    public String getPath() {
        return this.m_path;
    }

    public void setPath(String path) {
        this.m_path = path;
    }

    public int getPort() {
        return this.m_port;
    }

    public void setPort(int port) {
        this.m_port = port;
    }

    public String getQuery() {
        return this.m_query;
    }

    public void setQuery(String query) {
        this.m_query = query;
    }

    public Properties getQueryParameters() {
        if (this.m_query != null) {
            try {
                QueryParameterHandler queryParameterHandler = new QueryParameterHandler();
                NameValueParser parser = new NameValueParser(queryParameterHandler);
                parser.parse(this.m_query, '=', '&');
                return queryParameterHandler.getParameters();
            }
            catch (NameValueParserException nameValueParser) {
                return null;
            }
        }
        return null;
    }

    public String getScheme() {
        return this.m_scheme;
    }

    public String getSchemeSpecificPart() {
        return this.m_schemeSpecificPart;
    }

    public String getURI() {
        return this.m_uri;
    }

    public String getUser() {
        return this.m_user;
    }

    public void setUser(String user) {
        this.m_user = user;
    }

    public String getUserInfo() {
        return this.m_userInfo;
    }

    private void initialize() {
        this.m_scheme = null;
        this.m_schemeSpecificPart = null;
        this.m_authority = null;
        this.m_userInfo = null;
        this.m_user = null;
        this.m_password = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_query = null;
        this.m_fragment = null;
        this.m_sessionKey = null;
    }

    public boolean isRelative() {
        return this.m_scheme == null && this.m_authority == null;
    }

    private void parseURI(String spec) {
        int authorityEnd;
        this.initialize();
        int schemeEnd = spec.indexOf(":");
        if (schemeEnd > 0) {
            this.m_scheme = spec.substring(0, schemeEnd);
        } else {
            schemeEnd = -1;
        }
        this.m_schemeSpecificPart = spec.substring(schemeEnd + 1);
        int authorityStart = spec.indexOf("//", schemeEnd + 1);
        if (authorityStart != -1) {
            int hostEnd;
            authorityEnd = spec.indexOf(47, authorityStart += 2);
            if (authorityEnd == -1 && (authorityEnd = spec.indexOf(63, authorityStart)) == -1) {
                authorityEnd = spec.length();
            }
            this.m_authority = spec.substring(authorityStart, authorityEnd);
            int userInfoEnd = this.m_authority.indexOf(64);
            if (userInfoEnd != -1) {
                this.m_userInfo = this.m_authority.substring(0, userInfoEnd);
                int userEnd = this.m_userInfo.indexOf(58);
                if (userEnd != -1) {
                    this.m_user = this.m_userInfo.substring(0, userEnd);
                    this.m_password = this.m_userInfo.substring(userEnd + 1);
                }
            }
            if ((hostEnd = this.m_authority.indexOf(58, userInfoEnd + 1)) != -1) {
                if (hostEnd + 1 < this.m_authority.length()) {
                    this.m_port = Integer.parseInt(this.m_authority.substring(hostEnd + 1));
                }
            } else {
                hostEnd = this.m_authority.length();
            }
            this.m_host = this.m_authority.substring(userInfoEnd + 1, hostEnd);
        } else {
            authorityEnd = schemeEnd + 1;
        }
        if (authorityEnd != spec.length()) {
            int poundIndex;
            int pathEnd = spec.indexOf(63, authorityEnd);
            if (pathEnd != -1) {
                this.m_query = spec.substring(pathEnd + 1);
            } else {
                pathEnd = spec.length();
            }
            this.m_path = spec.substring(authorityEnd, pathEnd);
            if (this.m_path != null && (poundIndex = this.m_path.lastIndexOf(35)) != -1) {
                this.m_fragment = this.m_path.substring(poundIndex + 1);
            }
        }
    }

    public String toString() {
        StringBuffer uri = new StringBuffer();
        if (this.m_scheme != null) {
            uri.append(this.m_scheme);
            uri.append(':');
        }
        if (this.m_authority != null) {
            uri.append("//");
            uri.append(this.m_authority);
        }
        if (this.m_path != null) {
            uri.append(this.m_path);
        }
        if (this.m_query != null) {
            uri.append('?');
            uri.append(this.m_query);
        }
        if (this.m_fragment != null) {
            uri.append('#');
            uri.append(this.m_fragment);
        }
        return uri.toString();
    }

    private class QueryParameterHandler
    implements NameValueHandler {
        private Properties m_parameters = new Properties();

        public Properties getParameters() {
            return this.m_parameters;
        }

        public boolean process(String name, String value) {
            this.m_parameters.put(URLDecoder.decode(name).toLowerCase(), URLDecoder.decode(value));
            return true;
        }
    }
}

