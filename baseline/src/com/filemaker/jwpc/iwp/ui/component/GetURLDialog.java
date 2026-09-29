/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.fields.DeprecatedTextArea;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.VerticalLayout;

public class GetURLDialog
extends ServerInvokedStaticDialog {
    private static final int DIALOG_WIDTH = 460;
    private DeprecatedTextArea urlField;
    private GetURLResult result = new GetURLResult(this);

    public GetURLDialog(App app, String string, String string2) {
        super(app, string, Dialog.ButtonOption.LEFT_RIGHT);
        this.setDialogWidth(460);
        this.setRightButtonDefault();
        this.urlField.setValue(string2);
        this.result.url = string2;
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        this.urlField = new DeprecatedTextArea(IWPI18N.get(this.app, "GET_URL_DIALOG_INSTRUCTION", new Object[0]));
        this.urlField.setImmediate(true);
        this.urlField.setSizeFull();
        this.urlField.setRows(3);
        this.urlField.addStyleName("fm-labeled-textarea");
        verticalLayout.addComponent((Component)this.urlField);
        verticalLayout.setExpandRatio((Component)this.urlField, 1.0f);
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.confirm = false;
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.result.confirm = true;
        this.result.url = (String)this.urlField.getValue();
        super.performRightButtonAction(clickEvent);
    }

    @Override
    public Object getResult() {
        return this.result;
    }

    public class GetURLResult {
        public String url = "";
        public boolean confirm = false;

        public GetURLResult(GetURLDialog getURLDialog) {
        }
    }
}

