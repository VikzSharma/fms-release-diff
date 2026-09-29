/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.ui.Embedded
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Embedded;

public class WDImage2
extends Embedded {
    private String positionCss;

    public WDImage2(String string, String string2) {
        super("", (Resource)new ExternalResource(string, string2));
    }

    public void setPositionCss(String string) {
        this.positionCss = string;
    }

    public String getPositionCss() {
        return this.positionCss;
    }
}

