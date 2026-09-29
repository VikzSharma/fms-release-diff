/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;

public class ScriptStateChangeEvent
extends UIEvent {
    private boolean allowAbort;

    public ScriptStateChangeEvent(boolean bl) {
        super(EventType.SCRIPT_STATE_CHANGE);
        this.allowAbort = bl;
    }

    public boolean allowAbort() {
        return this.allowAbort;
    }
}

