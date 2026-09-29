/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.AbstractComponentState
 */
package org.vaadin.kim.countdownclock.client.ui;

import com.vaadin.shared.AbstractComponentState;

public class CountdownClockState
extends AbstractComponentState {
    private static final long serialVersionUID = -2111850091485279585L;
    private String timeFormat;
    private long countdownTarget;
    private boolean neglectHigherUnits;

    public void setNeglectHigherUnits(boolean bl) {
        this.neglectHigherUnits = bl;
    }

    public boolean isNeglectHigherUnits() {
        return this.neglectHigherUnits;
    }

    public String getTimeFormat() {
        return this.timeFormat;
    }

    public void setTimeFormat(String string) {
        this.timeFormat = string;
    }

    public long getCountdownTarget() {
        return this.countdownTarget;
    }

    public void setCountdownTarget(long l) {
        this.countdownTarget = l;
    }
}

