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

class FindSetConstrainer
extends ToolbarMenuItem {
    public FindSetConstrainer(App app) {
        super(app, IWPI18N.get(app, "CONSTRAIN_FOUND_SET", new Object[0]), app.getAM().getAction(UIActionType.CONSTRAIN_FOUNDSET));
        this.addStyleName("findset-constrainer");
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }
}

