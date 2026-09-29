/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.table.TableConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AbstractBaseTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractBaseTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomBaseTable;
import com.google.gwt.core.client.Scheduler;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.table.TableConnector;

@Connect(value=AbstractBaseTable.class)
public class AbstractBaseTableConnector
extends TableConnector {
    public AbstractBaseTableConnector() {
        this.getWidget().registerServerRpc((AbstractBaseTableServerRpc)RpcProxy.create(AbstractBaseTableServerRpc.class, (ServerConnector)this));
    }

    public VCustomBaseTable getWidget() {
        return (VCustomBaseTable)super.getWidget();
    }

    public AbstractBaseTableState getState() {
        return (AbstractBaseTableState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (FMCUtilities.useAriaCompliantControl() && this.getState().shouldSyncAria) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    AbstractBaseTableConnector.this.getWidget().syncAria(true);
                }
            });
        }
    }
}

