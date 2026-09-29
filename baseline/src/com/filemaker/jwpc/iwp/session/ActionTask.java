/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.action.ActionsCompleteHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.session.Session;

public abstract class ActionTask
implements Runnable {
    private String name;
    private boolean oneOffExecution;
    private ActionsCompleteHandler handler;
    protected final App app;
    protected final Session session;

    public ActionTask(App app, Session session, String string) {
        this.app = app;
        this.session = session;
        this.name = string;
    }

    public String getName() {
        return this.name;
    }

    public Session getSession() {
        return this.session;
    }

    public App getApp() {
        return this.app;
    }

    public boolean isOneOffExecution() {
        return this.oneOffExecution;
    }

    public void setOneOffExecution(boolean bl) {
        this.oneOffExecution = bl;
    }

    public void setHandler(ActionsCompleteHandler actionsCompleteHandler) {
        this.handler = actionsCompleteHandler;
    }

    public ActionsCompleteHandler getHandler() {
        return this.handler;
    }

    public String toString() {
        return String.format("[name=%s, session=%s, oneOff=%s, handler=%s]", this.name, this.session, this.oneOffExecution, this.handler);
    }
}

