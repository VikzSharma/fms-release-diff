/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.MultiColumnListSelect;
import com.filemaker.jwpc.iwp.widgetset.client.connector.AbstractBaseTableConnector;
import com.filemaker.jwpc.iwp.widgetset.client.state.MultiColumnListSelectTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomMultiColumnListSelectTable;
import com.vaadin.shared.ui.Connect;

@Connect(value=MultiColumnListSelect.MultiColumnListSelectTable.class)
public class MultiColumnListSelectTableConnector
extends AbstractBaseTableConnector {
    @Override
    public VCustomMultiColumnListSelectTable getWidget() {
        return (VCustomMultiColumnListSelectTable)super.getWidget();
    }

    @Override
    public MultiColumnListSelectTableState getState() {
        return (MultiColumnListSelectTableState)super.getState();
    }
}

