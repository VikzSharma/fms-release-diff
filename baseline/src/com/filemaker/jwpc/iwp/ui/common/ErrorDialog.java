/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.fields.FMField;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;

public class ErrorDialog
extends ServerInvokedDialog {
    private static final int DIALOG_WIDTH = 400;
    private int errorCode = ErrorCode.None.getErrorCode();

    public ErrorDialog(App app, String string, int n) {
        this(app, IWPI18N.get(app, "ERROR", new Object[0]), string, n);
    }

    public ErrorDialog(App app, String string) {
        this(app, IWPI18N.get(app, "ERROR", new Object[0]), string, ErrorCode.None.getErrorCode());
    }

    public ErrorDialog(App app, String string, String string2) {
        this(app, string, string2, ErrorCode.None.getErrorCode());
    }

    public ErrorDialog(App app, String string, String string2, int n) {
        super(app, string, Dialog.ButtonOption.LEFT);
        this.errorCode = n;
        this.configureDialog(string2, n);
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    public void closeDialog() {
        super.closeDialog();
        this.app.setCurrentErrorCode(ErrorCode.None.getErrorCode());
        if (this.app.getActiveUIHandler().getActiveObjectMetaData() != null && this.app.getActiveUIHandler().getActiveObjectMetaData().isField()) {
            LayoutFieldObject layoutFieldObject;
            if ((this.app.getActiveUIHandler().getActiveObjectMetaData().getFieldType() == LayoutFieldType.CALCULATED || this.app.getActiveUIHandler().getActiveObjectMetaData().getFieldType() == LayoutFieldType.SUMMARY) && (layoutFieldObject = this.app.getActiveUIHandler().getActiveField(false, false)) instanceof FMField) {
                ((FMField)((Object)layoutFieldObject)).syncServerValue();
            }
            if (this.app.getActiveUIHandler().getActiveObjectMetaData().getFieldType() == LayoutFieldType.NORMAL && (layoutFieldObject = this.app.getActiveUIHandler().getActiveField(false, false)) instanceof LayoutTextFieldObject) {
                ((LayoutTextFieldObject)layoutFieldObject).syncSelectionOnCommitFailure();
            }
        }
    }

    @Override
    public boolean showDialog() {
        boolean bl = false;
        if (this.shouldShowDialog()) {
            bl = super.showDialog();
            this.app.setCurrentErrorCode(this.errorCode);
        }
        return bl;
    }

    private boolean shouldShowDialog() {
        if (this.errorCode < 3000) {
            return true;
        }
        if (this.errorCode == ErrorCode.LockConflict.getErrorCode() || this.errorCode == ErrorCode.NonIndexableField.getErrorCode() || this.errorCode == ErrorCode.Err_MustHaveFieldSelected.getErrorCode() || this.errorCode == ErrorCode.CallbackScriptFailed.getErrorCode()) {
            return true;
        }
        return this.errorCode >= 5000 && this.errorCode < 5500;
    }

    protected void configureDialog(String string, int n) {
        this.setDialogWidth(400);
        this.setResizable(false);
        this.initContent(this.getContentLayout(string, n));
        this.initButtons(IWPI18N.get(this.app, "OK", new Object[0]), "", "");
    }

    protected Component getContentLayout(String string, int n) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = n == ErrorCode.OAuthRequestAccessTokenFailed.getErrorCode() || n == ErrorCode.OAuthSendMailFailed.getErrorCode() || n == ErrorCode.LLMExtendedError.getErrorCode() || n == ErrorCode.LLMEmbeddingInvalidRequestError.getErrorCode() || n == ErrorCode.LLMInvalidRequest.getErrorCode() || n == ErrorCode.LLMClarisRAGSpaceError.getErrorCode() ? new Label(string, Label.CONTENT_XHTML) : new Label(string);
        verticalLayout.addComponent((Component)label);
        return verticalLayout;
    }

    @Override
    public Object getResult() {
        return null;
    }
}

