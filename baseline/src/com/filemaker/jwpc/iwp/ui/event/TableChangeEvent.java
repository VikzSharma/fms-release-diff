/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;

public class TableChangeEvent
extends UIEvent {
    private int tableId;

    public TableChangeEvent(int n) {
        super(EventType.TABLE_CHANGE);
        this.tableId = n;
    }

    public int getTableId() {
        return this.tableId;
    }
}

