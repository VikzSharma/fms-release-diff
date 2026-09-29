/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.Image;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.state.ChartState;

public class Chart
extends Image {
    public Chart(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.getState().chartLabel = IWPI18N.get(app, "CHART_LABEL", new Object[0]);
    }

    public ChartState getState() {
        return (ChartState)super.getState();
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return false;
    }
}

