/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.VaadinSession$State
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.notification.processor;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.action.ActionsCompleteHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.session.ActionTaskHelper;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.ConfirmationChoice;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.notification.AppleIDLoginDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ChangePasswordDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.CloseRequestNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ConfirmationNotification;
import com.filemaker.jwpc.iwp.thrift.notification.CustomDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ErrorDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportFieldContentsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportMappingDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportRecordsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.GoToRecordDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ImportMappingDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ImportRecordsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.InsertFromURLNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoginDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OmitDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenURLNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsPDFNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsSsLinkDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SortDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ValidationErrorDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.AppleIDLoginDialog;
import com.filemaker.jwpc.iwp.ui.common.ChangePasswordDialog;
import com.filemaker.jwpc.iwp.ui.common.ConfirmationDialog;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ErrorDialog;
import com.filemaker.jwpc.iwp.ui.common.IDialogResult;
import com.filemaker.jwpc.iwp.ui.common.MessageDialog;
import com.filemaker.jwpc.iwp.ui.common.PDFDialog;
import com.filemaker.jwpc.iwp.ui.common.UserCloseRequestDialog;
import com.filemaker.jwpc.iwp.ui.common.UserLoginDialog;
import com.filemaker.jwpc.iwp.ui.component.CustomDialog;
import com.filemaker.jwpc.iwp.ui.component.ExportFieldContentsDialog;
import com.filemaker.jwpc.iwp.ui.component.ExportMappingDialog;
import com.filemaker.jwpc.iwp.ui.component.ExportRecordsDialog;
import com.filemaker.jwpc.iwp.ui.component.GetURLDialog;
import com.filemaker.jwpc.iwp.ui.component.GoToRecordDialog;
import com.filemaker.jwpc.iwp.ui.component.ImportMappingDialog;
import com.filemaker.jwpc.iwp.ui.component.ImportRecordsDialog;
import com.filemaker.jwpc.iwp.ui.component.MobileSortDialog;
import com.filemaker.jwpc.iwp.ui.component.OmitMultipleDialog;
import com.filemaker.jwpc.iwp.ui.component.SaveAsSnapshotLinkDialog;
import com.filemaker.jwpc.iwp.ui.component.SortDialog;
import com.filemaker.jwpc.iwp.ui.component.ValidationErrorDialog;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.layout.component.container.InsertFileDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.VaadinSession;
import org.apache.thrift.TException;

public class NotificationDialogProcessor {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getDialogResponse(final App app, Context context, EventType eventType, Object object, long l) throws TException {
        Object object2 = null;
        if (app != null) {
            Object object3 = app.getNotificationExecutorLock();
            synchronized (object3) {
                Dialog dialog = this.getDialog(app, eventType, object);
                if (dialog != null) {
                    dialog.setApplicationRoot(app);
                    ActionTaskHelper actionTaskHelper = app.getAppSession().getActionTaskHelper();
                    actionTaskHelper.scheduleQueuedGetterTasks(new ActionsCompleteHandler(this){

                        @Override
                        public void onComplete() {
                        }
                    });
                    boolean bl = false;
                    VaadinSession vaadinSession = app.getSession();
                    if (vaadinSession != null && vaadinSession.getState() == VaadinSession.State.OPEN) {
                        vaadinSession.lock();
                        try {
                            if (app.getSession() == vaadinSession && !app.isClosing()) {
                                bl = dialog.showDialog();
                            }
                        }
                        finally {
                            vaadinSession.unlock();
                        }
                    }
                    if (bl) {
                        long l2 = l;
                        if (l == -1L) {
                            l2 = Session.getTimeout() - 60L;
                            if (l2 <= 0L) {
                                l2 = Session.getTimeout();
                            }
                        } else {
                            l2 = Session.getTimeout() > l ? l : Session.getTimeout();
                        }
                        boolean bl2 = this.waitForDialogResponse(app, dialog, l2);
                        object2 = ((IDialogResult)((Object)dialog)).getResult();
                        if (eventType == EventType.USER_TIMEDOUT && !bl2 && object2 == ConfirmationChoice.ConfirmYes) {
                            bl2 = true;
                        }
                        if (!bl2 && l2 >= Session.getTimeout() - 60L) {
                            Runnable runnable = new Runnable(){

                                @Override
                                public void run() {
                                    app.forceClose(true, true, null);
                                }
                            };
                            Executors.runTask(runnable);
                        }
                    } else {
                        object2 = ((IDialogResult)((Object)dialog)).getResult();
                    }
                }
            }
        }
        return object2;
    }

    private Dialog getDialog(App app, EventType eventType, Object object) {
        Dialog dialog = null;
        switch (eventType) {
            case LOGIN_DIALOG: {
                dialog = new UserLoginDialog(app, (LoginDialogNotification)object);
                break;
            }
            case APPLEID_LOGIN_DIALOG: {
                dialog = new AppleIDLoginDialog(app, (AppleIDLoginDialogNotification)object);
                break;
            }
            case CHANGE_PASSWORD_DIALOG: {
                dialog = new ChangePasswordDialog(app, (ChangePasswordDialogNotification)object);
                break;
            }
            case CONFIRMATION_DIALOG: {
                ConfirmationNotification confirmationNotification = (ConfirmationNotification)object;
                ErrorCode errorCode = ErrorCode.fromValue((int)confirmationNotification.getAlertCode());
                Dialog.ButtonOption buttonOption = Dialog.ButtonOption.LEFT_RIGHT;
                switch (errorCode) {
                    case WarnCommitRecord: {
                        buttonOption = Dialog.ButtonOption.LEFT_MIDDLE_RIGHT;
                        break;
                    }
                    case NoRecordsFound: 
                    case InvalidQueryValue: 
                    case EmptyQuery: {
                        String string;
                        String string2 = confirmationNotification.getNotificationAttributes().get((Object)Attribute.CONTINUE_SCRIPT);
                        if (Utilities.isEmptyString(string2) || !string2.equals("true") || Utilities.isEmptyString(string = confirmationNotification.getNotificationAttributes().get((Object)Attribute.CAN_ABORT)) || !string.equals("true")) break;
                        buttonOption = Dialog.ButtonOption.LEFT_MIDDLE_RIGHT;
                        break;
                    }
                    default: {
                        buttonOption = Dialog.ButtonOption.LEFT_RIGHT;
                    }
                }
                dialog = new ConfirmationDialog(app, confirmationNotification, buttonOption);
                break;
            }
            case VALIDATION_ERROR_DIALOG: {
                dialog = new ValidationErrorDialog(app, (ValidationErrorDialogNotification)object);
                break;
            }
            case EXPORT_FIELD_CONTENTS_DIALOG: {
                dialog = new ExportFieldContentsDialog(app, (ExportFieldContentsDialogNotification)object);
                break;
            }
            case EXPORT_RECORDS_DIALOG: {
                dialog = new ExportRecordsDialog(app, (ExportRecordsDialogNotification)object);
                break;
            }
            case EXPORT_MAPPING_DIALOG: {
                dialog = new ExportMappingDialog(app, (ExportMappingDialogNotification)object);
                break;
            }
            case IMPORT_RECORDS_DIALOG: {
                dialog = new ImportRecordsDialog(app, ((ImportRecordsDialogNotification)object).getImportFolderPath());
                break;
            }
            case IMPORT_MAPPING_DIALOG: {
                dialog = new ImportMappingDialog(app, (ImportMappingDialogNotification)object);
                break;
            }
            case CUSTOM_DIALOG: {
                dialog = new CustomDialog(app, ((CustomDialogNotification)object).getDialogData());
                break;
            }
            case OMIT_DIALOG: {
                dialog = new OmitMultipleDialog(app, ((OmitDialogNotification)object).getOmitCount());
                break;
            }
            case GO_TO_RECORD_DIALOG: {
                dialog = new GoToRecordDialog(app, ((GoToRecordDialogNotification)object).getRecordNumber(), ((GoToRecordDialogNotification)object).getMaxNumber());
                break;
            }
            case SORT_DIALOG: {
                app.getDatabaseDataModel().update((SortDialogNotification)object);
                dialog = app.isTouchUI() ? new MobileSortDialog(app, ((SortDialogNotification)object).getValueListNames()) : new SortDialog(app, ((SortDialogNotification)object).getValueListNames());
                break;
            }
            case OPEN_URL: {
                dialog = new GetURLDialog(app, IWPI18N.get(app, "OPEN_URL_DIALOG_TITLE", new Object[0]), ((OpenURLNotification)object).getUrl());
                break;
            }
            case INSERT_FROM_URL: {
                dialog = new GetURLDialog(app, IWPI18N.get(app, "INSERT_FROM_URL_DIALOG_TITLE", new Object[0]), ((InsertFromURLNotification)object).getUrl());
                break;
            }
            case SAVEAS_SNAPSHOT_LINK_DIALOG: {
                dialog = new SaveAsSnapshotLinkDialog(app, ((SaveAsSsLinkDialogNotification)object).getSaveOption());
                break;
            }
            case ERROR_DIALOG: {
                IWPError iWPError = ((ErrorDialogNotification)object).getError();
                dialog = new ErrorDialog(app, app.getMessenger().getUserFriendlyErrorMessage(iWPError), iWPError.getErrorCode());
                break;
            }
            case ADMIN_CLOSE_REQUEST: {
                dialog = new UserCloseRequestDialog(app, ((CloseRequestNotification)object).getReason());
                break;
            }
            case USER_TIMEDOUT: {
                dialog = new UserCloseRequestDialog(app, IWPI18N.get(app, "SESSION_TIMEDOUT_DIALOG_MESSAGE", new Object[0]));
                break;
            }
            case IMPORT_FILE_DIALOG: {
                ImportRecordsDialogNotification importRecordsDialogNotification = (ImportRecordsDialogNotification)object;
                int n = importRecordsDialogNotification.getDialogType();
                String string = n == 1 ? IWPI18N.get(app, "OPEN_PDF", new Object[0]) : (n == 2 ? IWPI18N.get(app, "APPEND_PDF", new Object[0]) : IWPI18N.get(app, "INSERT", new Object[0]));
                dialog = new InsertFileDialog(app, importRecordsDialogNotification.getImportFolderPath(), string);
                break;
            }
            case MESSAGE_DIALOG: {
                CloseRequestNotification closeRequestNotification = (CloseRequestNotification)object;
                dialog = new MessageDialog(app, IWPI18N.get(app, "MESSAGE_FROM", closeRequestNotification.getAcctName()), closeRequestNotification.getReason());
                break;
            }
            case SAVE_AS_PDF: {
                dialog = new PDFDialog(app, (SaveAsPDFNotification)object);
                break;
            }
            default: {
                System.err.println("No server invoke implementation for this dialog type: " + String.valueOf((Object)eventType));
                return null;
            }
        }
        return dialog;
    }

    private boolean waitForDialogResponse(App app, Dialog dialog, long l) {
        boolean bl = false;
        try {
            long l2 = System.currentTimeMillis();
            boolean bl2 = l != -1L;
            long l3 = bl2 ? l * 1000L : -1L;
            boolean bl3 = false;
            while (dialog.isVisible() && !app.isDetached()) {
                if (bl2) {
                    boolean bl4 = bl3 = System.currentTimeMillis() - l2 >= l3;
                }
                if (!bl3) {
                    Thread.sleep(dialog.checkMillis);
                    continue;
                }
                dialog.closeDialog();
            }
            bl = !bl3 && !app.isDetached();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return bl;
    }
}

