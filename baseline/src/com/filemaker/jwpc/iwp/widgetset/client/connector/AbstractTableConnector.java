/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.AbstractTable;
import com.filemaker.jwpc.iwp.widgetset.client.connector.AbstractBaseTableConnector;
import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractTableState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTable;
import com.vaadin.shared.ui.Connect;

@Connect(value=AbstractTable.class)
public class AbstractTableConnector
extends AbstractBaseTableConnector {
    @Override
    public VCustomTable getWidget() {
        return (VCustomTable)super.getWidget();
    }

    @Override
    public AbstractTableState getState() {
        return (AbstractTableState)super.getState();
    }
}

