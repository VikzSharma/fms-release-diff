/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.fields.client.combobox.ComboBoxConnector;
import com.filemaker.jwpc.iwp.ui.layout.component.Popup;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PopupClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PopupServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PopupState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPopup;
import com.google.gwt.core.client.Scheduler;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;

@Connect(value=Popup.class)
public class PopupConnector
extends ComboBoxConnector {
    public PopupConnector() {
        this.getWidget().registerPopupServerRpc((PopupServerRpc)RpcProxy.create(PopupServerRpc.class, (ServerConnector)this));
        this.registerRpc(PopupClientRpc.class, new PopupClientRpc(){

            @Override
            public void setActive(boolean bl) {
                PopupConnector.this.getWidget().setActiveStyles(bl);
                if (!bl) {
                    PopupConnector.this.getWidget().prepareForExit();
                    PopupConnector.this.getWidget().hideOptions();
                }
            }
        });
    }

    @Override
    public VCustomPopup getWidget() {
        return (VCustomPopup)super.getWidget();
    }

    @Override
    public PopupState getState() {
        return (PopupState)super.getState();
    }

    @Override
    public void initialPageRequested() {
        super.initialPageRequested();
        if (BrowserInfo.get().isIE()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    PopupConnector.this.getWidget().initialPageRequested();
                }
            });
        } else {
            this.getWidget().initialPageRequested();
        }
    }
}

