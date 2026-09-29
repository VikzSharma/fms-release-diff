/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.data.provider.DataCommunicator
 *  com.vaadin.shared.Range
 *  com.vaadin.v7.data.Item
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.vaadin.data.provider.DataCommunicator;
import com.vaadin.shared.Range;
import com.vaadin.v7.data.Item;
import java.util.Map;

public final class ListDataCommunicator
extends DataCommunicator<Item> {
    public Map<Object, Item> getActiveData() {
        return this.getActiveDataHandler().getActiveData();
    }

    public void beforeClientResponse(boolean bl) {
        if (this.getDataProviderSize() == 0) {
            this.dropAllData();
            this.setPushRows(Range.emptyRange());
        }
        this.sendDataToClient(bl);
    }

    public int getMinPushSize() {
        return Math.min(this.getDataProviderSize(), super.getMinPushSize());
    }
}

