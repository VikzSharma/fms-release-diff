/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

class FindSetExtender
extends ToolbarMenuItem {
    public FindSetExtender(App app) {
        super(app, IWPI18N.get(app, "EXTEND_FOUND_SET", new Object[0]), app.getAM().getAction(UIActionType.EXTEND_FOUNDSET));
        this.addStyleName("findset-extender");
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }
}

