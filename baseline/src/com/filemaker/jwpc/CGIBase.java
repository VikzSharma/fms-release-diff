/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.ServletConfig
 *  jakarta.servlet.ServletContext
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.http.HttpServlet
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.config.ConfigurationHandler;
import com.filemaker.jwpc.util.Utilities;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class CGIBase
extends HttpServlet {
    private static final int MIN_AUTH_INFO_VALUES_LENGTH = 2;
    private static final int MAX_AUTH_INFO_VALUES_LENGTH = 6;
    private ConfigurationHandler mConfigHandler = null;

    protected void storeAuthenticationInformation(HttpServletRequest httpServletRequest, ConfigXMLRequest configXMLRequest) {
        String string;
        String[] stringArray = Utilities.getUserNameAndPassword(httpServletRequest);
        if (stringArray != null) {
            configXMLRequest.setUserName(stringArray[0]);
            configXMLRequest.setPassword(stringArray[1]);
            if (stringArray.length > 2) {
                configXMLRequest.setIsOAuth(Boolean.parseBoolean(stringArray[2]));
                if (stringArray.length == 6) {
                    configXMLRequest.setEmail(stringArray[3]);
                    configXMLRequest.setPasscode(stringArray[4]);
                    configXMLRequest.setIsAppleID(Boolean.parseBoolean(stringArray[5]));
                }
            }
        }
        if (!Utilities.isValidText(string = httpServletRequest.getHeader("X-Forwarded-For"))) {
            string = httpServletRequest.getRemoteAddr();
        }
        if (string.contains(":") && !string.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            string = string.substring(0, string.lastIndexOf(":"));
        }
        configXMLRequest.setClientIP(string);
        configXMLRequest.setUserAgent(httpServletRequest.getHeader("User-Agent"));
        String string2 = httpServletRequest.getHeader("X-Forwarded-Host");
        if (string2 != null && string2.contains(":") && !string2.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            string2 = string2.substring(0, string2.lastIndexOf(":"));
        }
        configXMLRequest.setClientHostname(string2);
    }

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.processRequest(httpServletRequest, httpServletResponse);
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.processRequest(httpServletRequest, httpServletResponse);
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        if (servletConfig != null) {
            ServletContext servletContext = servletConfig.getServletContext();
            this.mConfigHandler = ConfigurationHandler.getInstance(servletContext.getRealPath("/"));
        }
    }

    public boolean isEnabled() {
        return this.mConfigHandler.isEnabled();
    }

    public boolean isIWPEnabled() {
        return this.mConfigHandler.isIWPEnabled();
    }

    public boolean isHomeUrlEnabled() {
        return this.mConfigHandler.isHomeurlEnabled();
    }

    public String getCustomHomeUrl() {
        return this.mConfigHandler.getCustomHomeurl();
    }

    public String getServerId() {
        return this.mConfigHandler.getServerId();
    }

    public int getChunksize() {
        return this.mConfigHandler.getChunksize();
    }

    public static String getProductName() {
        return ConfigurationHandler.getProductName();
    }

    public static String getProductVersion() {
        return ConfigurationHandler.getProductVersion();
    }

    public static String getBuildDate() {
        return ConfigurationHandler.getBuildDate();
    }

    protected abstract void processRequest(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException;

    protected abstract String getExtendedPrivilege();

    protected abstract String getMIMEType();

    public boolean isAriaCompliantControlEnabled() {
        return this.mConfigHandler.isAriaCompliantControlEnabled();
    }
}

