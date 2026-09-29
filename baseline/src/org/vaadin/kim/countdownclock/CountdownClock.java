/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 */
package org.vaadin.kim.countdownclock;

import com.vaadin.ui.AbstractComponent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.vaadin.kim.countdownclock.client.ui.CountdownClockRpc;
import org.vaadin.kim.countdownclock.client.ui.CountdownClockState;

public class CountdownClock
extends AbstractComponent {
    private static final long serialVersionUID = -4093579148150450057L;
    protected Date date = new Date();
    protected boolean sendEvent = false;
    protected String format = "%dD %hH %mM %sS";
    protected List<EndEventListener> listeners = new ArrayList<EndEventListener>();

    public CountdownClock() {
        CountdownClockRpc countdownClockRpc = new CountdownClockRpc(){
            private static final long serialVersionUID = -7392569455421206075L;

            @Override
            public void countdownEnded() {
                for (EndEventListener endEventListener : CountdownClock.this.listeners) {
                    endEventListener.countDownEnded(CountdownClock.this);
                }
            }
        };
        this.registerRpc(countdownClockRpc);
    }

    public void setDate(Date date) {
        this.date = date;
        this.sendEvent = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long l = calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        this.getState().setCountdownTarget(l);
    }

    public Date getDate() {
        return this.date;
    }

    public CountdownClockState getState() {
        return (CountdownClockState)super.getState();
    }

    public void setFormat(String string) {
        this.getState().setTimeFormat(string);
    }

    public String getFormat() {
        return this.getState().getTimeFormat();
    }

    @Deprecated
    public void addListener(EndEventListener endEventListener) {
        this.addEndEventListener(endEventListener);
    }

    public void addEndEventListener(EndEventListener endEventListener) {
        if (endEventListener != null) {
            this.listeners.add(endEventListener);
        }
    }

    @Deprecated
    public void removeListener(EndEventListener endEventListener) {
        this.removeEndEventListener(endEventListener);
    }

    public void removeEndEventListener(EndEventListener endEventListener) {
        if (endEventListener != null) {
            this.listeners.remove(endEventListener);
        }
    }

    public void setNeglectHigherUnits(boolean bl) {
        this.getState().setNeglectHigherUnits(bl);
    }

    public boolean getNeglectHigherUnits() {
        return this.getState().isNeglectHigherUnits();
    }

    public static interface EndEventListener {
        public void countDownEnded(CountdownClock var1);
    }
}

