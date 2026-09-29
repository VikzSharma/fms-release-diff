/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

public class LayoutEditor
extends CssLayout {
    final App app;

    public LayoutEditor(final App app) {
        this.app = app;
        this.addStyleName("layout-editor");
        this.setDescription(IWPI18N.get(app, "EDIT", new Object[0]), ContentMode.HTML);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
        this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){
            final /* synthetic */ LayoutEditor this$0;
            {
                this.this$0 = layoutEditor;
            }

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                app.openLayoutEditor(app.getAppSession().getDatabaseName(), false);
            }
        });
    }
}

