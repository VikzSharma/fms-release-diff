/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.menu.Menu;

public class IWPMenu
extends Menu {
    protected final App app;

    public IWPMenu(App app) {
        super(app);
        this.app = app;
        this.setBackItemText(IWPI18N.get(app, "BACK", new Object[0]));
    }
}

