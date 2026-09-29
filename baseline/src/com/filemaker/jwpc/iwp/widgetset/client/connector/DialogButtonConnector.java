/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.annotations.OnStateChange
 *  com.vaadin.client.ui.button.ButtonConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.DialogButton;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDialogButton;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.button.ButtonConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=DialogButton.class)
public class DialogButtonConnector
extends ButtonConnector {
    public VCustomDialogButton getWidget() {
        return (VCustomDialogButton)super.getWidget();
    }

    @OnStateChange(value={"caption", "captionAsHtml"})
    void setCaption() {
        if (this.getState().captionAsHtml) {
            this.getWidget().setHtml(this.getState().caption);
        } else {
            this.getWidget().setText(this.getState().caption);
        }
    }
}

