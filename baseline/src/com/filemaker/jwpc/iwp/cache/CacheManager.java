/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.cache;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppController;
import com.filemaker.jwpc.iwp.cache.CSSCacheManager;
import com.filemaker.jwpc.iwp.cache.UserCacheManager;
import java.util.Map;

public class CacheManager {
    public static CSSCacheManager CSS_RESOURCE_CACHE_MANAGER = new CSSCacheManager();
    public static UserCacheManager USER_CACHE_MANAGER = new UserCacheManager();

    public static void clearUserCache(int n) {
        USER_CACHE_MANAGER.removeUser(n);
    }

    public static void clearCSSCache() {
        CSS_RESOURCE_CACHE_MANAGER.clear();
    }

    public static void shutdown() {
        CSS_RESOURCE_CACHE_MANAGER.clear();
        USER_CACHE_MANAGER.removeAllUsers();
    }

    public static String getCacheStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CacheManager.getAppStatistics());
        stringBuilder.append(USER_CACHE_MANAGER.getCacheStatistics());
        stringBuilder.append(CSS_RESOURCE_CACHE_MANAGER.getCacheStatistics());
        return stringBuilder.toString();
    }

    private static String getAppStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, App> map = AppController.getAllActiveApp();
        stringBuilder.append("<b style=\"color: blue;\"><br>APP STATISTICS").append("&nbsp;&nbsp;&nbsp;&nbsp;(Total Apps Active: ").append(map.size()).append(")</b><br>");
        stringBuilder.append("<b style=\"color: #7247DE;\">[");
        for (Integer n : map.keySet()) {
            stringBuilder.append("&nbsp;&nbsp;APP ").append(n).append("&nbsp;&nbsp;");
        }
        stringBuilder.append("]</b><br>");
        return stringBuilder.toString();
    }
}

