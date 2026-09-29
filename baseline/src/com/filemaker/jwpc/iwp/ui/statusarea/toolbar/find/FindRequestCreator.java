/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

class FindRequestCreator
extends ToolbarButton {
    public FindRequestCreator(App app) {
        super(app, app.getAM().getAction(UIActionType.CREATE_NEW_ROW));
        this.setToolTip(IWPI18N.get(app, "NEW_FIND_REQUEST_TOOLTIP", new Object[0]));
        this.addStyleName("findrequest-creator");
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }
}

