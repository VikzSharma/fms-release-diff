/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

public class RecordDeleter
extends ToolbarButton {
    public RecordDeleter(App app) throws AppRuntimeException {
        super(app, app.getAM().getAction(UIActionType.DELETE_ROW));
        this.addStyleName("record-deleter");
        String string = IWPI18N.get(app, "DELETE_RECORD_TOOLTIP", new Object[0]);
        this.setToolTip(string);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }
}

