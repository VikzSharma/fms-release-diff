/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.session.ActionTask;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.context.Context;

public abstract class GetterActionTask
extends ActionTask {
    protected final Context context;

    public GetterActionTask(String string, App app, Session session) {
        super(app, session, string);
        this.context = session.getCurrentContext();
    }
}

