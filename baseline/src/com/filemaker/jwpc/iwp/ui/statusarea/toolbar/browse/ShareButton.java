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

public class ShareButton
extends CssLayout {
    final App app;

    public ShareButton(final App app) {
        this.app = app;
        this.addStyleName("file-sharer");
        this.setDescription(IWPI18N.get(app, "SHARE", new Object[0]), ContentMode.HTML);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
        this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){
            final /* synthetic */ ShareButton this$0;
            {
                this.this$0 = shareButton;
            }

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                app.openShareDialog();
            }
        });
    }
}

