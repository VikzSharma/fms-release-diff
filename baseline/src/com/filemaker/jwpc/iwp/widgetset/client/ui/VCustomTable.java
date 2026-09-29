/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ScrollEvent
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Timer
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomBaseTable;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

public class VCustomTable
extends VCustomBaseTable {
    private int atbs = 0;
    private Timer timer;

    public VCustomTable() {
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
        this.timer = new Timer(){

            public void run() {
                if (VCustomTable.this.client != null && VCustomTable.this.client.getServerRpcQueue() != null) {
                    VCustomTable.this.client.getServerRpcQueue().flush();
                }
            }
        };
    }

    public void setAtbs(int n) {
        this.atbs = n;
    }

    private boolean getBooleanState(AbstractTableState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.atbs, booleanState.ordinal());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.getBooleanState(AbstractTableState.BooleanState.hasTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }

    @Override
    public boolean handleNavigation(int n, boolean bl, boolean bl2) {
        if (n == 38 || n == 40) {
            return false;
        }
        return super.handleNavigation(n, bl, bl2);
    }

    public boolean isFocusable() {
        return false;
    }

    public void onScroll(ScrollEvent scrollEvent) {
        super.onScroll(scrollEvent);
        this.timer.cancel();
        this.timer.schedule(500);
    }
}

