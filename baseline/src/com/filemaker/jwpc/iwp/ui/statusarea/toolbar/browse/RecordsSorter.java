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

class RecordsSorter
extends ToolbarButton {
    public RecordsSorter(App app) {
        super(app, app.getAM().getAction(UIActionType.SORT_RECORDS));
        this.addStyleName("records-sorter");
        String string = IWPI18N.get(app, "SORT_TOOLTIP", new Object[0]);
        this.setToolTip(string);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }
}

