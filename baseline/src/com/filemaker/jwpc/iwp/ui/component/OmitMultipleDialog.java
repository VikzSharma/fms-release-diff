/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.OmitDialogResult;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;

public class OmitMultipleDialog
extends ServerInvokedStaticDialog {
    private TextField number;
    private OmitDialogResult data;

    public OmitMultipleDialog(App app, int n) {
        super(app, IWPI18N.get(app, "OMIT_MULT", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        this.number.setValue(String.valueOf(n));
        this.setRightButtonDefault();
        this.setResizable(false);
        this.data = new OmitDialogResult(false, 0);
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "OMIT", new Object[0]);
    }

    @Override
    protected Component getContentLayout() {
        this.number = new TextField();
        this.number.setValue("1");
        this.number.setMaxLength(20);
        this.number.setCaption(IWPI18N.get(this.app, "OMIT_NUMBER_ARIA_LABEL", new Object[0]));
        this.number.addStyleName("v-caption-sr-only-caption-dialog-fields");
        if (this.isTouchUI()) {
            this.number.setWidth(100.0f, Sizeable.Unit.PIXELS);
        }
        Label label = new Label(IWPI18N.get(this.app, "OMIT_INSTRUCTION", new Object[0]));
        Label label2 = new Label(IWPI18N.get(this.app, "OMIT_DIALOG_OMIT", new Object[0]));
        Label label3 = new Label(IWPI18N.get(this.app, "OMIT_DIALOG_RECORDS_PERIOD", new Object[0]));
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.addComponent((Component)label);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent((Component)label2);
        horizontalLayout.setComponentAlignment((Component)label2, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent((Component)this.number);
        horizontalLayout.setComponentAlignment((Component)this.number, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent((Component)label3);
        horizontalLayout.setComponentAlignment((Component)label3, Alignment.MIDDLE_CENTER);
        if (this.isTouchUI()) {
            horizontalLayout.addStyleName("expand-height");
        }
        verticalLayout.addComponent((Component)horizontalLayout);
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        IWPError iWPError = new IWPError();
        int n = this.app.getLayoutDataModel().getFoundRecords();
        int n2 = n > 0 ? n - this.app.getLayoutDataModel().getRecordIndex() + 1 : 0;
        iWPError.setErrorCode(ErrorCode.InvalidOmit.getErrorCode());
        iWPError.setMessage(String.valueOf(n2));
        try {
            long l = Long.parseLong(((String)this.number.getValue()).trim());
            if (l <= (long)n2 && l >= 0L) {
                this.data.setApprove(true);
                this.data.setOmitCount((int)l);
                super.performRightButtonAction(clickEvent);
            } else {
                this.app.getMessenger().showErrorDialog(this.app.getMessenger().getUserFriendlyErrorMessage(iWPError));
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.app.getMessenger().showErrorDialog(this.app.getMessenger().getUserFriendlyErrorMessage(iWPError));
        }
    }

    @Override
    public Object getResult() {
        return this.data;
    }
}

