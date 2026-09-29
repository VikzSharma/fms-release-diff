/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppContainer;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.thrift.common.CardWindowSettings;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.vaadin.ui.Component;

public class AppCardWindowContainer
extends AppContainer {
    private CardWindowSettings settings;

    public AppCardWindowContainer(App app, String string) throws AppRuntimeException {
        super(app, string);
    }

    @Override
    public void initUI() {
        this.layoutMainContainer = new LayoutContainer(this.app);
        this.layoutMainContainer.setSizeFull();
        this.addComponent((Component)this.layoutMainContainer);
        this.setExpandRatio((Component)this.layoutMainContainer, 1.0f);
    }

    public void setWindowSettings(CardWindowSettings cardWindowSettings) {
        this.settings = cardWindowSettings;
    }

    public CardWindowSettings getWindowSettings() {
        return this.settings;
    }

    @Override
    protected void addListeners() {
    }

    @Override
    public void cleanupMemory() {
        this.unsubscribeForUIEvents();
        if (this.layoutMainContainer != null) {
            this.layoutMainContainer.cleanupMemory();
            this.layoutMainContainer.removeComponent((Component)this.layoutMainContainer);
            this.layoutMainContainer = null;
        }
    }
}

