/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.ScrollEvent
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.common.FMWidget;
import com.filemaker.jwpc.iwp.widgetset.client.connector.FMCommunicationConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PortalTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTable;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class VCustomPortalTable
extends VCustomTable {
    private FMClientEventManager eventManager;
    private PortalTableServerRpc rpc;
    private int ptbs = 0;
    private boolean hasNewRows = false;
    private int[] newRowSelectionRange;

    public void setPtbs(int n) {
        this.ptbs = n;
        if (this.getBooleanState(PortalTableState.BooleanState.hasScript) && this.eventManager == null) {
            this.eventManager = new FMClientEventManager(this.getElement(), false, true);
        }
    }

    private boolean getBooleanState(PortalTableState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.ptbs, booleanState.ordinal());
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.eventManager != null) {
            this.eventManager.handleEvent(event, this.getParent().getParent());
        }
        if (event.getTypeInt() == 4) {
            this.checkNewRows(null);
        }
    }

    @Override
    public void onFocus(FocusEvent focusEvent) {
        super.onFocus(focusEvent);
        this.checkNewRows(null);
    }

    protected boolean willHaveScrollbars() {
        if (this.getBooleanState(PortalTableState.BooleanState.showScrollbar)) {
            return super.willHaveScrollbars();
        }
        return false;
    }

    public void registerServerRpc(PortalTableServerRpc portalTableServerRpc) {
        this.rpc = portalTableServerRpc;
    }

    public void checkNewRows(int[] nArray) {
        this.newRowSelectionRange = nArray;
        this.rpc.checkNewRows();
    }

    public void notifyNewRows() {
        this.hasNewRows = true;
    }

    public boolean hasNewRows() {
        return this.hasNewRows;
    }

    public int[] processNewRows() {
        int[] nArray = this.newRowSelectionRange;
        this.newRowSelectionRange = null;
        this.hasNewRows = false;
        return nArray;
    }

    @Override
    public void onScroll(ScrollEvent scrollEvent) {
        FMCTextField fMCTextField;
        FMCommunicationConnector fMCommunicationConnector = FMCFieldEventManager.getCommunicationConnector();
        if (fMCommunicationConnector != null && (fMCTextField = fMCommunicationConnector.getActiveTextField()) != null && FMCUtilities.isInPortal((Widget)((FMWidget)((Object)fMCTextField)), (Widget)this) && fMCTextField.flushTextChangeOnScroll()) {
            this.client.getServerRpcQueue().flush();
        }
        super.onScroll(scrollEvent);
    }

    public boolean isScrollable() {
        return this.scrollBody.getElement().getClientHeight() > this.getElement().getClientHeight();
    }
}

