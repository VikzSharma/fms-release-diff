/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.cache;

import com.filemaker.jwpc.iwp.util.LRUCache;

public final class CSSCacheManager {
    private static final int RECOMMENDED_MAX_CACHED_CSS_ENTRIES = 30;
    final LRUCache<String, String> cachedCSS = new LRUCache(30, LRUCache.CacheEvictPolicy.EVICTPOLICY_DEFAULT);

    public String getCSS(String string) {
        return this.cachedCSS.get(string);
    }

    public void removeCSS(String string) {
        this.cachedCSS.remove(string);
    }

    public void addCSS(String string, String string2) {
        this.cachedCSS.put(string, string2);
    }

    public void clear() {
        this.cachedCSS.removeAll();
    }

    public synchronized String getCacheStatistics() {
        Object[] objectArray = this.cachedCSS.GetKeys();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b style=\"color: blue;\"><br>CSS CACHE STATISTICS").append("&nbsp;&nbsp;&nbsp;&nbsp;(Total Files Cached: ").append(this.cachedCSS.size()).append(")</b><br>");
        for (Object object : objectArray) {
            stringBuilder.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(object).append("<br>\n");
        }
        return stringBuilder.toString();
    }
}

