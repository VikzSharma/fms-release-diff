/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenu;
import com.vaadin.event.LayoutEvents;

public class AppContainerListener
implements LayoutEvents.LayoutClickListener {
    private final App app;

    public AppContainerListener(App app) {
        this.app = app;
    }

    public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
        if (this.app.getAppView().isCardStyleWindow()) {
            return;
        }
        if (this.app.getStatusAreaContainer().shouldExitPopover()) {
            this.app.getStatusAreaContainer().exitPopover();
        } else {
            this.app.getStatusAreaContainer().setShouldExitPopover(true);
        }
        if (!(layoutClickEvent.getClickedComponent() instanceof IWPMenu)) {
            this.app.getStatusAreaContainer().getMainMenuBar().closeMenu();
        }
    }
}

