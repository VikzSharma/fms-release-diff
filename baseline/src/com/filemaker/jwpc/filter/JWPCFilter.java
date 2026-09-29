/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison
 *  jakarta.servlet.Filter
 *  jakarta.servlet.FilterChain
 *  jakarta.servlet.FilterConfig
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.ServletRequest
 *  jakarta.servlet.ServletResponse
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc.filter;

import com.filemaker.jwpc.context.JWPCContextHandler;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison;
import com.filemaker.jwpc.http.HttpRequestWrapper;
import com.filemaker.jwpc.http.HttpResponseWrapper;
import com.filemaker.jwpc.iwp.notification.server.NotificationServer;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.log.LogMessages;
import com.filemaker.jwpc.log.LoggerManager;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWPCFilter
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        NotificationServer.getInstance().start();
        LoggerManager.setupDefaultLogging();
        LogMessages.loadLogMessages();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpResponseWrapper httpResponseWrapper = new HttpResponseWrapper((HttpServletResponse)servletResponse);
            HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse);
            JWPCContextHandler.createContext((HttpServletRequest)httpRequestWrapper);
            filterChain.doFilter((ServletRequest)httpRequestWrapper, (ServletResponse)httpResponseWrapper);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            JWPCContextHandler.destroyContext();
        }
    }

    public void destroy() {
        NotificationServer.getInstance().stop();
        Service service = Service.getInstance();
        if (service != null) {
            try {
                service.ping("stop");
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        ServiceClientPoolLiaison.shutdown();
        CWPClientProxyPoolLiaison.shutdown();
        LoggerManager.shutdownDefaultLogging();
    }
}

