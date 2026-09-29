/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.VerticalSplitPanel
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDVerticalSplitPanelClientRpc;
import com.vaadin.ui.VerticalSplitPanel;

public final class WDVerticalSplitPanel
extends VerticalSplitPanel
implements UIEventListener {
    protected final App app;

    public WDVerticalSplitPanel(App app) {
        this.app = app;
        this.app.subscribe(this, EventType.CSS_UPDATED, EventType.OVERRIDE_CSS_UPDATED);
    }

    public void cleanupMemory() {
        this.app.unsubscribe(this, EventType.CSS_UPDATED, EventType.OVERRIDE_CSS_UPDATED);
    }

    public void updateSizes() {
        ((WDVerticalSplitPanelClientRpc)this.getRpcProxy(WDVerticalSplitPanelClientRpc.class)).updateSizes();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case CSS_UPDATED: 
            case OVERRIDE_CSS_UPDATED: {
                this.updateSizes();
                break;
            }
        }
    }
}

