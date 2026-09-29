/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;

public class Body
extends LayoutPart {
    private final PartMetaData partMetaData;
    private final String typeSelector;

    public Body(App app, LayoutView layoutView, PartMetaData partMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, partMetaData, objectAttributes);
        this.partMetaData = partMetaData;
        this.typeSelector = this.partMetaData.isAltBackground() && this.app.isListView() && this.getAttributes().getRecordIndex() % 2 == 0 ? "iwps_body_alt" : "iwps_body";
        this.selfComponent.addStyleName(this.typeSelector);
    }

    @Override
    public void cleanupMemory() {
        super.cleanupMemory();
        this.removeAllComponents();
    }

    @Override
    public Object getValue() {
        return this;
    }

    public void onActive() {
        if (this.partMetaData.hasActiveStyle()) {
            this.selfComponent.addStyleName("iwps_body_active");
            this.selfComponent.removeStyleName(this.typeSelector);
        }
    }

    public void onInactive() {
        if (this.partMetaData.hasActiveStyle()) {
            this.selfComponent.removeStyleName("iwps_body_active");
            this.selfComponent.addStyleName(this.typeSelector);
        }
    }
}

