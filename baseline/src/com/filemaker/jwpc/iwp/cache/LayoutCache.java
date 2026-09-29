/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.cache;

import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.css.FMCommunicationComponent;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.form.LayoutFormView;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.util.LRUCacheEntry;
import java.io.Serializable;

public final class LayoutCache
implements Serializable,
LRUCacheEntry {
    private final String layKey;
    private long layModCount;
    private LayoutFormView form;
    private LayoutListView list;
    private Dimensions browserSize = null;
    protected ObjectMetaData metaData;
    private String layoutCSSFileId;
    private String overridesCSSFileId;
    private String layoutCSSFilePath;
    private String overridesCSSFilePath;
    private boolean isClassicTheme = false;

    public LayoutCache(String string, long l) {
        this.layKey = string;
        this.layModCount = l;
    }

    void addLayoutView(int n, long l, LayoutView layoutView, LayoutUI layoutUI, Dimensions dimensions) {
        boolean bl;
        boolean bl2 = bl = this.layModCount != l;
        if (!bl) {
            bl = this.needToInvalidateView(dimensions);
        }
        if (bl) {
            if (this.form != null && this.form != layoutView) {
                this.form.cleanupMemory();
                this.form = null;
            }
            if (this.list != null && this.list != layoutView) {
                this.list.cleanupMemory();
                this.list = null;
            }
        }
        switch (layoutView.getViewStyle()) {
            case FORM: {
                if (this.form != null && this.form != layoutView) {
                    this.form.cleanupMemory();
                }
                this.form = (LayoutFormView)layoutView;
                break;
            }
            case LIST: {
                if (this.list != null && this.list != layoutView) {
                    this.list.cleanupMemory();
                }
                this.list = (LayoutListView)layoutView;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        this.layModCount = l;
        this.browserSize = dimensions;
        if (layoutUI != null) {
            String string = layoutUI.getLayoutCSSKey();
            String string2 = "over_" + string;
            this.layoutCSSFileId = string;
            this.overridesCSSFileId = string2;
            this.layoutCSSFilePath = FMCommunicationComponent.getCSSUriPath(string);
            this.overridesCSSFilePath = FMCommunicationComponent.getCSSUriPath(string2);
            this.metaData = ObjectMetaData.generateLayoutMetaData(layoutView.getApp(), layoutUI.getMetaData(), layoutUI.getDateFormat());
            this.isClassicTheme = layoutUI.isClassicTheme();
            this.addCSSToCache(layoutUI);
        }
        layoutView.updateLayoutUI(this.metaData, this.layoutCSSFilePath, this.overridesCSSFilePath, this.isClassicTheme);
    }

    private void removeCSSFromCache() {
        if (this.layoutCSSFilePath != null && !this.layoutCSSFilePath.isEmpty()) {
            CacheManager.CSS_RESOURCE_CACHE_MANAGER.removeCSS(this.layoutCSSFileId);
            this.layoutCSSFilePath = null;
        }
        if (this.overridesCSSFilePath != null && !this.overridesCSSFilePath.isEmpty()) {
            CacheManager.CSS_RESOURCE_CACHE_MANAGER.removeCSS(this.overridesCSSFileId);
            this.overridesCSSFilePath = null;
        }
    }

    private void addCSSToCache(LayoutUI layoutUI) {
        if (!(this.layoutCSSFilePath == null || this.layoutCSSFilePath.isEmpty() || CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.layoutCSSFileId) != null && CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.layoutCSSFileId) != "" && CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.layoutCSSFileId).hashCode() == layoutUI.getLayoutCSS().hashCode())) {
            CacheManager.CSS_RESOURCE_CACHE_MANAGER.addCSS(this.layoutCSSFileId, layoutUI.getLayoutCSS());
        }
        if (!(this.overridesCSSFilePath == null || this.overridesCSSFilePath.isEmpty() || CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.overridesCSSFileId) != null && CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.overridesCSSFileId) != "" && CacheManager.CSS_RESOURCE_CACHE_MANAGER.getCSS(this.overridesCSSFileId).hashCode() == layoutUI.getObjectOverrides().hashCode())) {
            CacheManager.CSS_RESOURCE_CACHE_MANAGER.addCSS(this.overridesCSSFileId, layoutUI.getObjectOverrides());
        }
    }

    public LayoutView getLayoutView(long l, LayoutViewStyle layoutViewStyle, Dimensions dimensions) {
        LayoutView layoutView = null;
        if (this.layModCount == l) {
            switch (layoutViewStyle) {
                case FORM: {
                    layoutView = this.form;
                    break;
                }
                case LIST: {
                    layoutView = this.list;
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
            if (dimensions != null && this.needToInvalidateView(dimensions)) {
                layoutView = null;
            }
        }
        return layoutView;
    }

    public boolean needToInvalidateView(Dimensions dimensions) {
        boolean bl = false;
        LayoutView layoutView = this.getCachedLayoutView();
        if (layoutView != null && (layoutView.getLayoutMetaData().hasAutoSizingObjects() || layoutView.isClassicTheme())) {
            bl = !dimensions.equals(this.browserSize);
        }
        return bl;
    }

    public LayoutView getCachedLayoutView() {
        return this.form != null ? this.form : this.list;
    }

    @Override
    public void cleanupMemory() {
        if (this.form != null) {
            this.form.cleanupMemory();
            this.form = null;
        }
        if (this.list != null) {
            this.list.cleanupMemory();
            this.list = null;
        }
    }

    public String getCacheStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&nbsp;&nbsp;&nbsp;&nbsp;<b style=\"color: #B337A4;\">Layout ").append(this.layKey).append(" with Mod Count ").append(this.layModCount).append(" - Cached Views [");
        if (this.form != null) {
            stringBuilder.append("&nbsp;&nbsp;FORM ");
        }
        if (this.list != null) {
            stringBuilder.append("&nbsp;&nbsp;LIST ");
        }
        stringBuilder.append("&nbsp;&nbsp;]</b><br>\n");
        return stringBuilder.toString();
    }
}

