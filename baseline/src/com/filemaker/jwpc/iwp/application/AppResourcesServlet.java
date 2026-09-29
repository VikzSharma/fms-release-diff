/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.http.HttpServlet
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppResourcesServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = httpServletRequest.getRequestURI();
        if (string != null && string.startsWith("/fmi/iwp-resources/css/")) {
            try {
                String string2 = string.substring("/fmi/iwp-resources/css/".length());
                int n = string2.indexOf(".css");
                if (n > 0) {
                    String string3 = CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(string2 = FMRequestManager.decodeString(string2.substring(0, n)));
                    if (string3 == null || string3.isEmpty()) {
                        string3 = Service.getInstance().retrieveCSS(string2);
                        CacheManager.CSS_RESOURCE_CACHE_MANAGER.addCSS(string2, string3);
                    }
                    this.writeHeader(httpServletResponse);
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    printWriter.print(string3);
                    printWriter.close();
                }
            }
            catch (Exception exception) {
                System.err.print("Warning: No CSS was found in cache for the requested CSS URL as " + string + "!");
            }
        }
    }

    private void writeHeader(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "max-age=8640000");
        httpServletResponse.setHeader("Content-Type", "text/css");
        httpServletResponse.setCharacterEncoding("UTF-8");
    }
}

