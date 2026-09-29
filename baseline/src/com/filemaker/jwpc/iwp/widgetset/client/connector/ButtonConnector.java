/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.nativebutton.NativeButtonConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomButton;
import com.google.gwt.core.client.Scheduler;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.nativebutton.NativeButtonConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=Button.class)
public class ButtonConnector
extends NativeButtonConnector {
    private ButtonServerRpc rpc = (ButtonServerRpc)RpcProxy.create(ButtonServerRpc.class, (ServerConnector)this);

    public ButtonConnector() {
        this.getWidget().registerServerRpc(this.rpc);
        this.registerRpc(ButtonClientRpc.class, new ButtonClientRpc(){

            @Override
            public void sendButtonInfo() {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                    public void execute() {
                        ButtonConnector.this.rpc.send(ButtonConnector.this.getWidget().getAbsoluteTop(), ButtonConnector.this.getWidget().getAbsoluteLeft());
                    }
                });
            }

            @Override
            public void updateBounds(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
                if (ButtonConnector.this.getWidget() == null) {
                    return;
                }
                ButtonConnector.this.getWidget().updateBoundsIfNeeded(n, n2, n3, n4, bl, bl2);
                ButtonConnector.this.getState().needToReposition = true;
                ButtonConnector.this.getState().left = n;
                ButtonConnector.this.getState().top = n2;
            }
        });
    }

    public VCustomButton getWidget() {
        return (VCustomButton)super.getWidget();
    }

    public ButtonState getState() {
        return (ButtonState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        VCustomButton vCustomButton = this.getWidget();
        vCustomButton.updateState(this.getState());
        if (vCustomButton.isClientSideAutoSizing()) {
            vCustomButton.attachWindowResizeHandler();
        }
    }
}

