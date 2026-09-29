/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.http.HttpServletRequest
 */
package com.filemaker.jwpc.context;

import com.filemaker.jwpc.context.JWPCContext;
import com.filemaker.jwpc.util.Utilities;
import jakarta.servlet.http.HttpServletRequest;

public class JWPCContextHandler {
    private static ThreadLocal<JWPCContext> tl = new ThreadLocal();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void createContext(HttpServletRequest httpServletRequest) {
        Object object;
        JWPCContext jWPCContext = new JWPCContext();
        if (httpServletRequest != null) {
            String string;
            object = httpServletRequest.getHeader("X-Forwarded-For");
            if (!Utilities.isValidText((String)object)) {
                object = httpServletRequest.getRemoteAddr();
            }
            if (((String)object).contains(":") && !((String)object).equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
                object = ((String)object).substring(0, ((String)object).lastIndexOf(":"));
            }
            if ((string = httpServletRequest.getServerName()) == null || string.equalsIgnoreCase("localhost") || string.equalsIgnoreCase("127.0.0.1")) {
                string = Utilities.getHostIpAddress();
            }
            jWPCContext.setWPCHostName(string);
            jWPCContext.setClientIP((String)object);
            jWPCContext.setClientPort(httpServletRequest.getRemotePort());
            jWPCContext.setAccountName(JWPCContextHandler.getAccountName(httpServletRequest));
            jWPCContext.setModuleType(Utilities.getModuleType(httpServletRequest));
        }
        object = tl;
        synchronized (object) {
            tl.set(jWPCContext);
        }
    }

    public static JWPCContext currentContext() {
        return tl.get();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void destroyContext() {
        ThreadLocal<JWPCContext> threadLocal = tl;
        synchronized (threadLocal) {
            tl.remove();
        }
    }

    private static String getAccountName(HttpServletRequest httpServletRequest) {
        String[] stringArray = Utilities.getUserNameAndPassword(httpServletRequest);
        if (stringArray != null) {
            return stringArray[0];
        }
        return "";
    }
}

