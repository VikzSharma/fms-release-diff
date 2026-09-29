/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.notification.event;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.ui.event.EventType;

public final class NotificationEvent {
    private EventType type;
    private App app;
    private Context context;
    private Object notification;

    public NotificationEvent(EventType eventType, App app, Context context, Object object) {
        this.type = eventType;
        this.app = app;
        this.context = context;
        this.notification = object;
    }

    public EventType getType() {
        return this.type;
    }

    public Object getNotification() {
        return this.notification;
    }

    public Context getContext() {
        return this.context;
    }

    public App getApp() {
        return this.app;
    }

    public String toString() {
        return "[type: " + String.valueOf((Object)this.type) + "], [context: " + String.valueOf(this.context) + "]";
    }
}

