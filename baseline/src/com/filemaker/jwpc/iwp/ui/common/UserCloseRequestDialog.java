/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ConfirmationChoice;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;

public class UserCloseRequestDialog
extends ServerInvokedStaticDialog {
    private Label content;
    private ConfirmationChoice result = ConfirmationChoice.ConfirmYes;

    public UserCloseRequestDialog(App app, String string) {
        super(app, "", Dialog.ButtonOption.LEFT);
        String string2 = IWPI18N.get(app, "LOG_OUT", new Object[0]);
        super.setCaption(string2);
        if (string == null || string.trim().length() == 0) {
            string = IWPI18N.get(app, "EMPTY_CLOSE_NOTIFICATION", new Object[0]);
        }
        this.content.addStyleName("close-request-dlg-label");
        this.content.setValue(string);
        this.setResizable(false);
    }

    @Override
    protected Component getContentLayout() {
        this.content = new Label();
        return this.content;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result = ConfirmationChoice.ConfirmNo;
        super.performRightButtonAction(clickEvent);
    }

    public final ConfirmationChoice getResult() {
        return this.result;
    }
}

