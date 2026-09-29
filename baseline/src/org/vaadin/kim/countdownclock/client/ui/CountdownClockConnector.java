/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.AbstractComponentConnector
 *  com.vaadin.shared.ui.Connect
 */
package org.vaadin.kim.countdownclock.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.kim.countdownclock.CountdownClock;
import org.vaadin.kim.countdownclock.client.ui.CountdownClockRpc;
import org.vaadin.kim.countdownclock.client.ui.CountdownClockState;
import org.vaadin.kim.countdownclock.client.ui.VCountdownClock;

@Connect(value=CountdownClock.class)
public class CountdownClockConnector
extends AbstractComponentConnector
implements VCountdownClock.CountdownEndedListener {
    private static final long serialVersionUID = -6954184408631921296L;
    private CountdownClockRpc rpc = (CountdownClockRpc)RpcProxy.create(CountdownClockRpc.class, (ServerConnector)this);

    protected Widget createWidget() {
        VCountdownClock vCountdownClock = (VCountdownClock)((Object)GWT.create(VCountdownClock.class));
        vCountdownClock.addListener(this);
        return vCountdownClock;
    }

    public CountdownClockState getState() {
        return (CountdownClockState)super.getState();
    }

    public VCountdownClock getWidget() {
        return (VCountdownClock)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setTime(this.getState().getCountdownTarget());
        this.getWidget().setTimeFormat(this.getState().getTimeFormat());
        this.getWidget().setNeglectHigherUnits(this.getState().isNeglectHigherUnits());
        this.getWidget().startClock();
    }

    @Override
    public void countdownEnded() {
        this.rpc.countdownEnded();
    }
}

