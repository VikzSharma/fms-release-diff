/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.ConfirmationChoice;
import com.filemaker.jwpc.iwp.thrift.notification.ConfirmationNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;

public class ConfirmationDialog
extends ServerInvokedStaticDialog {
    private ErrorCode errorCode;
    private Label content;
    private ConfirmationChoice result = ConfirmationChoice.ConfirmNo;

    public ConfirmationDialog(App app, ConfirmationNotification confirmationNotification, Dialog.ButtonOption buttonOption) {
        super(app, "", buttonOption);
        super.setCaption(IWPI18N.get(app, "CONFIRMATION_DIALOG_TITLE", new Object[0]));
        this.errorCode = ErrorCode.fromValue((int)confirmationNotification.getAlertCode());
        switch (this.errorCode) {
            case WarnRelookup: {
                String string = confirmationNotification.getNotificationAttributes().get((Object)Attribute.FIELDNAME);
                this.content.setValue(IWPI18N.get(app, "RELOOKUP_FIELD_DIALOG_MESSAGE", String.valueOf(app.getLayoutDataModel().getFoundRecords()), string));
                super.getRightButton().setCaption(IWPI18N.get(app, "OK", new Object[0]));
                break;
            }
            case WarnDeleteRecord: {
                this.content.setValue(IWPI18N.get(app, "DELETE_RECORD_DIALOG_MESSAGE", new Object[0]));
                super.getRightButton().setCaption(IWPI18N.get(app, "DELETE", new Object[0]));
                break;
            }
            case WarnDeleteAll: {
                this.content.setValue(IWPI18N.get(app, "DELETE_ALL_DIALOG_MESSAGE", app.getLayoutDataModel().getFoundRecords()));
                this.getRightButton().setCaption(IWPI18N.get(app, "DELETE", new Object[0]));
                break;
            }
            case WarnDeleteFoundSet: {
                this.content.setValue(IWPI18N.get(app, "DELETE_FOUNDSET_DIALOG_MESSAGE", app.getLayoutDataModel().getFoundRecords()));
                this.getRightButton().setCaption(IWPI18N.get(app, "DELETE", new Object[0]));
                break;
            }
            case WarnFindMode: {
                this.content.setValue(IWPI18N.get(app, "FIND_MODE_DIALOG_MESSAGE", app.getLayoutDataModel().getFoundRecords()));
                this.getLeftButton().setCaption(IWPI18N.get(app, "NO", new Object[0]));
                this.getRightButton().setCaption(IWPI18N.get(app, "YES", new Object[0]));
                this.setRightButtonDefault();
                break;
            }
            case WarnRevertRecord: {
                this.content.setValue(IWPI18N.get(app, "REVERT_RECORD_DIALOG_MESSAGE", new Object[0]));
                this.getRightButton().setCaption(IWPI18N.get(app, "REVERT", new Object[0]));
                if (!this.isTouchUI()) break;
                this.getRightButton().makeFitCaption();
                break;
            }
            case WarnRevertRequest: {
                this.content.setValue(IWPI18N.get(app, "REVERT_REQUEST_DIALOG_MESSAGE", new Object[0]));
                this.getRightButton().setCaption(IWPI18N.get(app, "REVERT", new Object[0]));
                if (!this.isTouchUI()) break;
                this.getRightButton().makeFitCaption();
                break;
            }
            case FileMissing: 
            case UserAbort: 
            case NoFieldReadAccess: {
                this.setCaption(IWPI18N.get(app, "CONTINUE_SCRIPT_DIALOG_TITLE", new Object[0]));
                String string = confirmationNotification.getNotificationAttributes().get((Object)Attribute.SCRIPTNAME);
                this.content.setValue(IWPI18N.get(app, "CONTINUE_SCRIPT_DIALOG_MESSAGE", string));
                this.getRightButton().setCaption(IWPI18N.get(app, "CONTINUE", new Object[0]));
                this.setRightButtonDefault();
                break;
            }
            case InvalidSort: 
            case NoSortAccess: 
            case ScriptMissing: {
                String string = confirmationNotification.getNotificationAttributes().get((Object)Attribute.SCRIPTNAME);
                this.content.setValue(IWPI18N.get(app, "CONTINUE_SCRIPT_WITH_ERROR_DIALOG_MESSAGE", IWPI18N.get(app, string.replace(" ", "_"), new Object[0])));
                this.getRightButton().setCaption(IWPI18N.get(app, "CONTINUE", new Object[0]));
                this.setRightButtonDefault();
                break;
            }
            case WarnDeleteRelatedRecord: {
                this.content.setValue(IWPI18N.get(app, "DELETE_PORTAL_RELATED_RECORD_DIALOG_MESSAGE", new Object[0]));
                super.getRightButton().setCaption(IWPI18N.get(app, "DELETE", new Object[0]));
                break;
            }
            case NoRecordsFound: 
            case InvalidQueryValue: 
            case EmptyQuery: {
                if (this.errorCode == ErrorCode.NoRecordsFound) {
                    this.content.setValue(IWPI18N.get(app, "e_401_0", new Object[0]));
                } else if (this.errorCode == ErrorCode.InvalidQueryValue) {
                    this.content.setValue(IWPI18N.get(app, "e_508_0", new Object[0]));
                } else if (this.errorCode == ErrorCode.EmptyQuery) {
                    this.content.setValue(IWPI18N.get(app, "e_400_0", new Object[0]));
                }
                String string = confirmationNotification.getNotificationAttributes().get((Object)Attribute.CONTINUE_SCRIPT);
                if (!Utilities.isEmptyString(string) && string.equals("true")) {
                    String string2 = confirmationNotification.getNotificationAttributes().get((Object)Attribute.CAN_ABORT);
                    if (!Utilities.isEmptyString(string2) && string2.equals("true")) {
                        this.getLeftButton().setCaption(IWPI18N.get(app, "CANCEL", new Object[0]));
                        this.getMiddleButton().setCaption(IWPI18N.get(app, "CONTINUE", new Object[0]));
                    } else {
                        this.getLeftButton().setCaption(IWPI18N.get(app, "CONTINUE", new Object[0]));
                    }
                } else {
                    this.getLeftButton().setCaption(IWPI18N.get(app, "CANCEL", new Object[0]));
                }
                this.getRightButton().setCaption(IWPI18N.get(app, "MODIFY_FIND", new Object[0]));
                this.setRightButtonDefault();
                break;
            }
            case SortOrderChanged: {
                this.content.setValue(IWPI18N.get(app, "EXPORT_SORT_ORDER_CHANGED", new Object[0]));
                break;
            }
            case WarnCommitRecord: {
                this.content.setValue(IWPI18N.get(app, "WARN_COMMIT_ERROR", new Object[0]));
                this.getRightButton().setCaption(IWPI18N.get(app, "SAVE", new Object[0]));
                this.getLeftButton().setCaption(IWPI18N.get(app, "DONT_SAVE", new Object[0]));
                this.getMiddleButton().setCaption(IWPI18N.get(app, "CANCEL", new Object[0]));
                this.setRightButtonDefault();
                break;
            }
            default: {
                System.err.println("No confirmation dialog implementation for this alert code: " + String.valueOf(this.errorCode));
            }
        }
        this.setResizable(false);
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected Component getContentLayout() {
        this.content = new Label();
        return this.content;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        switch (this.errorCode) {
            case WarnCommitRecord: {
                this.result = ConfirmationChoice.ConfirmOther;
                break;
            }
            default: {
                this.result = ConfirmationChoice.ConfirmNo;
            }
        }
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.result = ConfirmationChoice.ConfirmYes;
        switch (this.errorCode) {
            case WarnDeleteAll: {
                this.app.getMessenger().showBusyDialog(true, IWPI18N.get(this.app, "BUSY_DELETE_ALL_MESSAGE", new Object[0]));
                break;
            }
            case WarnDeleteFoundSet: {
                this.app.getMessenger().showBusyDialog(true, IWPI18N.get(this.app, "BUSY_DELETE_FOUNDSET_MESSAGE", new Object[0]));
            }
        }
        super.performRightButtonAction(clickEvent);
    }

    @Override
    protected void performMiddleButtonAction(Button.ClickEvent clickEvent) {
        switch (this.errorCode) {
            case NoRecordsFound: 
            case InvalidQueryValue: 
            case EmptyQuery: {
                this.result = ConfirmationChoice.ConfirmOther;
                break;
            }
            case WarnCommitRecord: {
                this.result = ConfirmationChoice.ConfirmNo;
            }
        }
        super.performMiddleButtonAction(clickEvent);
    }

    public final ConfirmationChoice getResult() {
        return this.result;
    }
}

