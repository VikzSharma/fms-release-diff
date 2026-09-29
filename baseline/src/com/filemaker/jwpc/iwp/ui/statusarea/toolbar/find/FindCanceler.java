/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.component.StatusAreaLabel;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

class FindCanceler
extends ToolbarButton {
    public FindCanceler(App app) {
        super(app, app.getAM().getAction(UIActionType.CANCEL_FIND));
        this.setToolTip(IWPI18N.get(this.app, "CANCEL_FIND_TOOLTIP", new Object[0]));
        this.addStyleName("find-canceler");
        StatusAreaLabel statusAreaLabel = new StatusAreaLabel(app, IWPI18N.get(app, "CANCEL", new Object[0]));
        statusAreaLabel.setDescription(IWPI18N.get(app, "CANCEL_FIND_TOOLTIP", new Object[0]));
        statusAreaLabel.setSizeUndefined();
        statusAreaLabel.addStyleName("label");
        statusAreaLabel.addStyleName(this.app.getLanguage());
        this.addComponent((Component)statusAreaLabel);
        this.app.subscribe(this, EventType.MODE_CHANGE);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        super.onEvent(uIEvent);
        switch (uIEvent.getType()) {
            case MODE_CHANGE: {
                if (!this.app.isFindMode()) break;
                super.refresh();
                break;
            }
        }
    }
}

