/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.UIDL
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalTable;
import com.filemaker.jwpc.iwp.widgetset.client.connector.AbstractTableConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalTableClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PortalTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPortalTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.UIDL;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;

@Connect(value=PortalTable.class)
public class PortalTableConnector
extends AbstractTableConnector {
    public PortalTableConnector() {
        this.registerRpc(PortalTableClientRpc.class, new PortalTableClientRpcImpl());
        this.getWidget().registerServerRpc((PortalTableServerRpc)RpcProxy.create(PortalTableServerRpc.class, (ServerConnector)this));
    }

    protected VCustomPortalTable createWidget() {
        return (VCustomPortalTable)((Object)GWT.create(VCustomPortalTable.class));
    }

    @Override
    public VCustomPortalTable getWidget() {
        return (VCustomPortalTable)super.getWidget();
    }

    @Override
    public PortalTableState getState() {
        return (PortalTableState)super.getState();
    }

    public void postLayout() {
        this.doPostLayout();
    }

    private void doPostLayout() {
        if (this.getWidget().scrollBody.getNumRows() > 0) {
            if (this.getState().isListView) {
                this.getWidget().scrollBody.getRowHeight(true);
                if (!this.getWidget().sizeNeedsInit) {
                    this.getWidget().sizeInit();
                }
            }
            super.postLayout();
        } else {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    PortalTableConnector.this.postLayout();
                }
            });
        }
    }

    public void updateFromUIDL(UIDL uIDL, ApplicationConnection applicationConnection) {
        super.updateFromUIDL(uIDL, applicationConnection);
        if (FMCUtilities.useAriaCompliantControl()) {
            FMCUtilities.fixLayoutTableAlert((Element)this.getWidget().getElement());
        }
    }

    public class PortalTableClientRpcImpl
    implements PortalTableClientRpc {
        @Override
        public void notifyNewRows() {
            PortalTableConnector.this.getWidget().notifyNewRows();
        }
    }
}

