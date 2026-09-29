/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.form.LayoutFormView;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.util.IWPUtilities;

final class LayoutViewManager {
    private final App app;
    private final LayoutContainer container;
    protected LayoutView view;

    protected LayoutViewManager(App app, LayoutContainer layoutContainer) {
        this.app = app;
        this.container = layoutContainer;
    }

    public void refreshListView() {
        int n = this.app.getAppSession().getSessionID();
        String string = IWPUtilities.generateLayoutKey(this.app.getAppSession().getLayoutID(), this.app.getAppView().isCardStyleWindow());
        long l = this.app.getAppSession().getLayoutModCount();
        this.view = new LayoutListView(this.app, this.container, string, l);
        CacheManager.USER_CACHE_MANAGER.addLayoutView(n, string, l, this.view, null, this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions());
    }

    protected boolean createView(int n, String string, String string2, long l, LayoutViewStyle layoutViewStyle, Dimensions dimensions) {
        boolean bl = false;
        this.view = CacheManager.USER_CACHE_MANAGER.getLayoutView(n, string, l, layoutViewStyle, dimensions);
        if (this.view == null) {
            this.forceCreateView(null, n, string, string2, l, layoutViewStyle);
        } else {
            bl = true;
        }
        return bl;
    }

    protected void forceCreateView(LayoutUI layoutUI, int n, String string, String string2, long l, LayoutViewStyle layoutViewStyle) {
        switch (layoutViewStyle) {
            case FORM: {
                this.view = new LayoutFormView(this.app, this.container, string, l);
                break;
            }
            case LIST: {
                this.view = new LayoutListView(this.app, this.container, string, l);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        CacheManager.USER_CACHE_MANAGER.addLayoutView(n, string, l, this.view, layoutUI, this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions());
    }
}

