/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.filemaker.jwpc.iwp.application.FMRequestManager;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class PushRequestValidator
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        if (this.validateRequest(httpServletRequest)) {
            filterChain.doFilter((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        } else {
            httpServletResponse.sendError(401);
        }
    }

    public void destroy() {
    }

    private boolean validateRequest(HttpServletRequest httpServletRequest) {
        if (!FMRequestManager.isTrustOrigin(httpServletRequest.getHeader("Origin"))) {
            return false;
        }
        Map map = httpServletRequest.getParameterMap();
        for (String string : map.keySet()) {
            if (!string.equalsIgnoreCase("X-Atmosphere-Transport")) continue;
            for (String string2 : (String[])map.get(string)) {
                if (!string2.equalsIgnoreCase("jsonp")) continue;
                return false;
            }
        }
        return true;
    }
}

