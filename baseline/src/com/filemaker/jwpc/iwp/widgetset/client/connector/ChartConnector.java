/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.Chart;
import com.filemaker.jwpc.iwp.widgetset.client.connector.ImageConnector;
import com.filemaker.jwpc.iwp.widgetset.client.state.ChartState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomChart;
import com.vaadin.shared.ui.Connect;

@Connect(value=Chart.class)
public class ChartConnector
extends ImageConnector {
    @Override
    public VCustomChart getWidget() {
        return (VCustomChart)super.getWidget();
    }

    public ChartState getState() {
        return (ChartState)super.getState();
    }
}

