/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.util.PropertysetItem
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.PropertysetItem;

public class PortalRow
extends PropertysetItem {
    private PortalRowProperty rowProperty;

    public void cleanupMemory() {
        this.rowProperty.cleanupMemory();
    }

    public boolean addItemProperty(Property property) {
        this.rowProperty = (PortalRowProperty)property;
        return super.addItemProperty((Object)"PORTAL_CELL_ID", property);
    }

    public PortalRowProperty getRowProperty() {
        return this.rowProperty;
    }

    public int getPortalRecordIndex() {
        return this.rowProperty.getAttributes().getPortalRecordIndex();
    }
}

