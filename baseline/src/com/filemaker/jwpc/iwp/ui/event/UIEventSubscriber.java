/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;

public interface UIEventSubscriber {
    public void subscribe(UIEventListener var1, EventType ... var2);

    public void subscribeAllType(UIEventListener var1);

    public void unsubscribe(UIEventListener var1, EventType ... var2);

    public void unsubscribeAllType(UIEventListener var1);

    public void unsubscribeAllListeners();

    public void notify(UIEvent var1);

    public void clearUIEventListeners();
}

