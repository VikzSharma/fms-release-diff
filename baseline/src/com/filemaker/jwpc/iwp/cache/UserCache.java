/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.cache;

import com.filemaker.jwpc.iwp.cache.LayoutCache;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.util.LRUCache;
import com.filemaker.jwpc.iwp.util.LRUCacheEntry;
import java.io.Serializable;
import java.util.Collection;

public class UserCache
implements Serializable,
LRUCacheEntry {
    private static final int MAX_CACHED_LAYOUT_ENTRIES = 5;
    private final LRUCache<String, LayoutCache> cachedLayouts = new LRUCache(5, LRUCache.CacheEvictPolicy.EVICTPOLICY_DEFAULT);
    private int userId;

    public UserCache(int n) {
        this.userId = n;
    }

    public void addLayoutView(String string, long l, LayoutView layoutView, LayoutUI layoutUI, Dimensions dimensions) {
        LayoutCache layoutCache = this.cachedLayouts.get(string);
        if (layoutCache == null) {
            layoutCache = new LayoutCache(string, l);
            this.cachedLayouts.put(string, layoutCache);
        }
        layoutCache.addLayoutView(this.userId, l, layoutView, layoutUI, dimensions);
    }

    public LayoutView getLayoutView(String string, long l, LayoutViewStyle layoutViewStyle, Dimensions dimensions) {
        LayoutView layoutView = null;
        LayoutCache layoutCache = this.cachedLayouts.get(string);
        if (layoutCache != null) {
            layoutView = layoutCache.getLayoutView(l, layoutViewStyle, dimensions);
        }
        return layoutView;
    }

    @Override
    public void cleanupMemory() {
        this.cachedLayouts.removeAll();
    }

    public String getCacheStatistics() {
        Collection<LayoutCache> collection = this.cachedLayouts.GetValues();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b style=\"color: #7247DE;\">USER ").append(this.userId).append("&nbsp;&nbsp;(Total Layouts Cached: ").append(collection.size()).append(")</b><br>");
        for (LayoutCache layoutCache : collection) {
            stringBuilder.append(layoutCache.getCacheStatistics());
        }
        return stringBuilder.toString();
    }
}

