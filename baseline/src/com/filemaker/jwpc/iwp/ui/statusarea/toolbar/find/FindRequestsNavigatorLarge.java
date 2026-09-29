/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.RecordsNavigator;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;

class FindRequestsNavigatorLarge
extends RecordsNavigator {
    public FindRequestsNavigatorLarge(App app) {
        super(app);
        this.setStyleName("navigator large");
        this.previous.setWidth(70.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.previous);
        this.next.setWidth(70.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.next);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }
}

