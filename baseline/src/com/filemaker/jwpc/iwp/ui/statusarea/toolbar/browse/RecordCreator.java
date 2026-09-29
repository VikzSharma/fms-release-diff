/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

public class RecordCreator
extends ToolbarButton {
    public RecordCreator(App app) {
        super(app, app.getAM().getAction(UIActionType.CREATE_NEW_ROW));
        String string = IWPI18N.get(app, "NEW_RECORD_TOOLTIP", new Object[0]);
        this.setToolTip(string);
        this.addStyleName("record-creator");
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }
}

