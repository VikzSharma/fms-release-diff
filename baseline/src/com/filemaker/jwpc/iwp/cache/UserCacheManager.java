/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.cache;

import com.filemaker.jwpc.iwp.cache.UserCache;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.util.LRUCache;
import java.util.Collection;

public class UserCacheManager {
    private static final int RECOMMENDED_MAX_CACHED_USER_ENTRIES = 25;
    private final LRUCache<Integer, UserCache> cachedUsers = new LRUCache(25, LRUCache.CacheEvictPolicy.EVICTPOLICY_IGNORE);

    public void addLayoutView(int n, String string, long l, LayoutView layoutView, LayoutUI layoutUI, Dimensions dimensions) {
        UserCache userCache = this.cachedUsers.get(n);
        if (userCache == null) {
            userCache = new UserCache(n);
            this.cachedUsers.put(n, userCache);
        }
        userCache.addLayoutView(string, l, layoutView, layoutUI, dimensions);
    }

    public LayoutView getLayoutView(int n, String string, long l, LayoutViewStyle layoutViewStyle, Dimensions dimensions) {
        LayoutView layoutView = null;
        UserCache userCache = this.cachedUsers.get(n);
        if (userCache != null) {
            layoutView = userCache.getLayoutView(string, l, layoutViewStyle, dimensions);
        }
        return layoutView;
    }

    public LayoutView getAnyCachedView(int n, String string, long l, LayoutViewStyle layoutViewStyle, Dimensions dimensions) {
        LayoutView layoutView = null;
        UserCache userCache = this.cachedUsers.get(n);
        if (userCache != null) {
            layoutView = userCache.getLayoutView(string, l, layoutViewStyle, dimensions);
        }
        return layoutView;
    }

    public void removeUser(int n) {
        this.cachedUsers.remove(n);
    }

    public void removeAllUsers() {
        this.cachedUsers.removeAll();
    }

    public String getCacheStatistics() {
        Collection<UserCache> collection = this.cachedUsers.GetValues();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b style=\"color: blue;\"><br>USER CACHE STATISTICS").append("&nbsp;&nbsp;&nbsp;&nbsp;(Total Users Cached: ").append(collection.size()).append(")</b><br>");
        for (UserCache userCache : collection) {
            stringBuilder.append(userCache.getCacheStatistics());
        }
        return stringBuilder.toString();
    }
}

