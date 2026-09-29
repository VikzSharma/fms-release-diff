/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;

public class TopNavigation
extends LayoutPart {
    public TopNavigation(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, objectMetaData, objectAttributes);
        objectMetaData.setFixedPart(true);
    }

    @Override
    public Object getValue() {
        return this;
    }
}

