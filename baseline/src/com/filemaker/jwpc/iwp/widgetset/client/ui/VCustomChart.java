/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomImage;

public class VCustomChart
extends VCustomImage {
    public VCustomChart() {
        if (FMCUtilities.useAriaCompliantControl()) {
            this.getElement().setTabIndex(0);
            this.getElement().setAttribute("role", "img");
        }
    }

    public void setChartLabel(String string) {
        this.getElement().setAttribute("aria-label", string);
    }
}

