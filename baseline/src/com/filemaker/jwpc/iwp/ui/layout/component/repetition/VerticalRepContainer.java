/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component.repetition;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.RepetitionMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;

public class VerticalRepContainer
extends RepetitionContainer {
    public VerticalRepContainer(App app, LayoutView layoutView, ObjectMetaData objectMetaData, int n, int n2, int n3, int n4) {
        super(app, layoutView, objectMetaData, n, n2, n3, n4);
    }

    @Override
    protected ObjectMetaData createObjectMetaData(int n, int n2) {
        RepetitionMetaData repetitionMetaData = new RepetitionMetaData(this.metaData);
        if (this.view.isClientSideAutoSizing() && this.metaData.isAutoResizeVertical()) {
            this.addStyleName("fm-relative");
            float f = 100.0f / (float)n;
            repetitionMetaData.setHeight(f + "%");
            repetitionMetaData.setTop(0);
        } else {
            int n3 = this.metaData.getHeightAsInt() / n;
            repetitionMetaData.setHeight(n3 + "px");
            if (repetitionMetaData.containsKey("e1")) {
                repetitionMetaData.setTop(n3 * n2);
            } else {
                repetitionMetaData.setBottom(this.metaData.getHeightAsInt() - n3 * (n2 + 1));
            }
        }
        if (repetitionMetaData.containsKey("e2")) {
            repetitionMetaData.setLeft(0);
        } else {
            repetitionMetaData.setRight(0);
        }
        return repetitionMetaData;
    }

    @Override
    protected String getRepetitionObjectSelector(int n, int n2) {
        String string = n2 == 0 ? "fm-vertrep-first" : (n2 == n - 1 ? "fm-vertrep-last" : "fm-vertrep-middle");
        return string;
    }
}

