/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.listener.LayoutListener;
import com.vaadin.event.LayoutEvents;

public class PopoverLayoutListener
extends LayoutListener {
    public PopoverLayoutListener(App app) {
        super(app);
    }

    @Override
    public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
        if (layoutClickEvent.getClickedComponent() != null) {
            super.layoutClick(layoutClickEvent);
        } else {
            GlobalUIActionHandlers.COMMIT_RECORD.perform(this.appRoot, null);
        }
    }
}

