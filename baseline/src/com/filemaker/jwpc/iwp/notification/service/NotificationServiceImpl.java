/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.notification.service;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.notification.event.NotificationEvent;
import com.filemaker.jwpc.iwp.notification.event.NotificationEventCommand;
import com.filemaker.jwpc.iwp.notification.service.AbstractNotificationService;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.AppleIDLoginResponse;
import com.filemaker.jwpc.iwp.thrift.common.ChangePasswordResponse;
import com.filemaker.jwpc.iwp.thrift.common.CloseRequestType;
import com.filemaker.jwpc.iwp.thrift.common.ConfirmationChoice;
import com.filemaker.jwpc.iwp.thrift.common.CustomDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.DownloadFileInfo;
import com.filemaker.jwpc.iwp.thrift.common.ExportMappingInfo;
import com.filemaker.jwpc.iwp.thrift.common.GoToRecordDialogResponse;
import com.filemaker.jwpc.iwp.thrift.common.ImportMappingInfo;
import com.filemaker.jwpc.iwp.thrift.common.ImportRecordsFileInfo;
import com.filemaker.jwpc.iwp.thrift.common.InsertFromURLResponse;
import com.filemaker.jwpc.iwp.thrift.common.LoadCachedLayoutResult;
import com.filemaker.jwpc.iwp.thrift.common.LoginResponse;
import com.filemaker.jwpc.iwp.thrift.common.NotifEventType;
import com.filemaker.jwpc.iwp.thrift.common.OmitDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.PerformWebScriptResponse;
import com.filemaker.jwpc.iwp.thrift.common.SaveAsPDFResponse;
import com.filemaker.jwpc.iwp.thrift.common.SaveAsPDFSettings;
import com.filemaker.jwpc.iwp.thrift.common.SaveAsSsLinkDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.SessionDisconnectType;
import com.filemaker.jwpc.iwp.thrift.common.SortAction;
import com.filemaker.jwpc.iwp.thrift.common.SortDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.ValidationErrorAction;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.notification.ActivateSegmentNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.thrift.notification.AppleIDLoginDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.BrowserClientInfoRequestNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ChangePasswordDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ClosePopoverNotification;
import com.filemaker.jwpc.iwp.thrift.notification.CloseRequestNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ConfirmationNotification;
import com.filemaker.jwpc.iwp.thrift.notification.CustomDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.DownloadFileNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ELOChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.EnterButtonNotification;
import com.filemaker.jwpc.iwp.thrift.notification.EnterFieldNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ErrorDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportFieldContentsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportFieldContentsDownloadFileNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportMappingDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ExportRecordsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.FieldObjectDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.GoToRecordDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ImportMappingDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ImportRecordsDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.InsertFromURLNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutModeChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoadCachedLayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoginDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LongOperationNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LongScriptNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MenubarStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MessageDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MoveResizeCardWindowNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ObjectsChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OmitDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenDatabaseNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenLayoutEditorNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenPopoverNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenShareDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenURLNotification;
import com.filemaker.jwpc.iwp.thrift.notification.PerformWebScriptNotification;
import com.filemaker.jwpc.iwp.thrift.notification.PortalRowVisibleNotification;
import com.filemaker.jwpc.iwp.thrift.notification.PrivilegesNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ReloginNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSelectionChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsPDFNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsSsLinkDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SendMailNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SessionDisconnectNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SessionExpiredNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SortDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.TableChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ToolbarStatusAreaStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.UserNameChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ValidationErrorDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.VisiblePanelChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowNameChangeNotification;
import com.filemaker.jwpc.iwp.ui.common.PDFDialog;
import com.filemaker.jwpc.iwp.ui.component.GetURLDialog;
import com.filemaker.jwpc.iwp.ui.component.GoToRecordDialog;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.thrift.TException;

public class NotificationServiceImpl
extends AbstractNotificationService {
    @Override
    public void notifyEvent(Context context, NotifEventType notifEventType) throws TException {
        NotificationEventCommand notificationEventCommand = null;
        switch (notifEventType) {
            case OPEN_HELP: {
                notificationEventCommand = this.getCommand(context, EventType.OPEN_HELP, null);
                break;
            }
        }
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyOpenDatabase(Context context, OpenDatabaseNotification openDatabaseNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.OPEN_DATABASE, openDatabaseNotification);
        if (notificationEventCommand != null) {
            notificationEventCommand.getApplicationRoot().getAppController().getNotificationEventBus().process(notificationEventCommand);
        }
    }

    @Override
    public void notifyFieldObjectDataChange(Context context, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.FIELD_OBJECT_DATA_CHANGE, fieldObjectDataChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyObjectsChange(Context context, ObjectsChangeNotification objectsChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.OBJECTS_CHANGE, objectsChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyTableChange(Context context, TableChangeNotification tableChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.TABLE_CHANGE, tableChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyRowChange(Context context, RowChangeNotification rowChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ROW_CHANGE, rowChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyELOChange(Context context, ELOChangeNotification eLOChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ELO_CHANGE, eLOChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyWindowChange(Context context, WindowChangeNotification windowChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.WINDOW_CHANGE, windowChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public LoadCachedLayoutResult loadCachedLayout(Context context, LoadCachedLayoutNotification loadCachedLayoutNotification) throws TException {
        LoadCachedLayoutResult loadCachedLayoutResult = new LoadCachedLayoutResult(false, false);
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null) {
            this.processNoReceiver(context, EventType.LOAD_CACHED_LAYOUT);
            loadCachedLayoutResult.setCachedLayoutLoaded(true);
        } else {
            String string = IWPUtilities.generateLayoutKey(loadCachedLayoutNotification.getLayId(), app.getAppView().isCardStyleWindow());
            LayoutView layoutView = CacheManager.USER_CACHE_MANAGER.getAnyCachedView(n, string, loadCachedLayoutNotification.getModCount(), loadCachedLayoutNotification.getWindowState().getViewStyle(), app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions());
            if (layoutView != null) {
                loadCachedLayoutResult.setCachedLayoutLoaded(true);
                loadCachedLayoutResult.setAutoresizeLayout(layoutView.getLayoutMetaData().hasAutoSizingObjects());
                NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.LOAD_CACHED_LAYOUT, loadCachedLayoutNotification);
                if (notificationEventCommand != null) {
                    this.processCommand(notificationEventCommand);
                }
            }
        }
        return loadCachedLayoutResult;
    }

    @Override
    public void notifyLayoutChange(Context context, LayoutNotification layoutNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.LAYOUT_CHANGE, layoutNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyReloginChange(Context context, ReloginNotification reloginNotification) throws TException {
        NotificationEventCommand notificationEventCommand;
        NotificationEventCommand notificationEventCommand2 = this.getCommand(context, EventType.RELOGIN_CHANGE, reloginNotification);
        if (notificationEventCommand2 != null) {
            this.processCommand(notificationEventCommand2);
        }
        if ((notificationEventCommand = this.getCommand(context, EventType.ACCOUNTNAME_CHANGE, new UserNameChangeNotification())) != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyLayoutNamesChange(Context context, LayoutNamesChangeNotification layoutNamesChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.LAYOUT_NAMES_LIST_CHANGE, layoutNamesChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyScriptNamesChange(Context context, ScriptNamesChangeNotification scriptNamesChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.SCRIPT_NAMES_CHANGE, scriptNamesChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyScriptStateChange(Context context, ScriptStateChangeNotification scriptStateChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.SCRIPT_STATE_CHANGE, scriptStateChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyMenubarStateChange(Context context, MenubarStateChangeNotification menubarStateChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.MENUBAR_STATE_CHANGE, menubarStateChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyToolbarStatusAreaStateChange(Context context, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.TOOLBAR_STATUSAREA_STATE_CHANGE, toolbarStatusAreaStateChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyRowSelectionChange(Context context, RowSelectionChangeNotification rowSelectionChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ROW_SELECTION_CHANGE, rowSelectionChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyRowSetChange(Context context, RowSetChangeNotification rowSetChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ROW_SET_CHANGE, rowSetChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyRowSetDataChange(Context context, RowSetDataChangeNotification rowSetDataChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ROW_SET_DATA_CHANGE, rowSetDataChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyMessageDialog(Context context, MessageDialogNotification messageDialogNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.MESSAGE_DIALOG, messageDialogNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public OmitDialogResult notifyOmitDialog(Context context, OmitDialogNotification omitDialogNotification) throws TException {
        OmitDialogResult omitDialogResult = (OmitDialogResult)this.getResponseFromDialog(context, EventType.OMIT_DIALOG, omitDialogNotification);
        if (omitDialogResult == null) {
            omitDialogResult = new OmitDialogResult(false, 0);
        }
        return omitDialogResult;
    }

    @Override
    public GoToRecordDialogResponse notifyGoToRecordDialog(Context context, GoToRecordDialogNotification goToRecordDialogNotification) throws TException {
        GoToRecordDialogResponse goToRecordDialogResponse = new GoToRecordDialogResponse(false, goToRecordDialogNotification.getRecordNumber());
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.GO_TO_RECORD_DIALOG);
        } else {
            GoToRecordDialog.RecordNumberDialogResult recordNumberDialogResult = (GoToRecordDialog.RecordNumberDialogResult)this.getResponseFromDialog(context, EventType.GO_TO_RECORD_DIALOG, goToRecordDialogNotification);
            goToRecordDialogResponse.setConfirm(recordNumberDialogResult.confirm);
            goToRecordDialogResponse.setRecordNumber(recordNumberDialogResult.number);
        }
        return goToRecordDialogResponse;
    }

    @Override
    public SortDialogResult notifySortDialog(Context context, SortDialogNotification sortDialogNotification) throws TException {
        SortDialogResult sortDialogResult = (SortDialogResult)this.getResponseFromDialog(context, EventType.SORT_DIALOG, sortDialogNotification);
        if (sortDialogResult == null) {
            sortDialogResult = new SortDialogResult(SortAction.Cancel, null);
        }
        return sortDialogResult;
    }

    @Override
    public CustomDialogResult notifyCustomDialog(Context context, CustomDialogNotification customDialogNotification) throws TException {
        CustomDialogResult customDialogResult = (CustomDialogResult)this.getResponseFromDialog(context, EventType.CUSTOM_DIALOG, customDialogNotification);
        if (customDialogResult == null) {
            customDialogResult = new CustomDialogResult(new HashMap<Integer, String>(), 0);
        }
        return customDialogResult;
    }

    @Override
    public ValidationErrorAction notifyValidationErrorDialog(Context context, ValidationErrorDialogNotification validationErrorDialogNotification) throws TException {
        ValidationErrorAction validationErrorAction = (ValidationErrorAction)((Object)this.getResponseFromDialog(context, EventType.VALIDATION_ERROR_DIALOG, validationErrorDialogNotification));
        if (validationErrorAction == null) {
            validationErrorAction = ValidationErrorAction.REVERT;
        }
        return validationErrorAction;
    }

    @Override
    public DownloadFileInfo notifyExportRecordsDialog(Context context, ExportRecordsDialogNotification exportRecordsDialogNotification) throws TException {
        DownloadFileInfo downloadFileInfo = (DownloadFileInfo)this.getResponseFromDialog(context, EventType.EXPORT_RECORDS_DIALOG, exportRecordsDialogNotification);
        if (downloadFileInfo == null) {
            downloadFileInfo = new DownloadFileInfo();
        }
        return downloadFileInfo;
    }

    @Override
    public String notifyExportFieldContentsDialog(Context context, ExportFieldContentsDialogNotification exportFieldContentsDialogNotification) throws TException {
        String string = (String)this.getResponseFromDialog(context, EventType.EXPORT_FIELD_CONTENTS_DIALOG, exportFieldContentsDialogNotification);
        if (string == null) {
            string = "";
        }
        return string;
    }

    @Override
    public void notifyExportFieldContentsDownloadFile(Context context, ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.EXPORT_FIELD_CONTENTS_DOWNLOAD_FILE);
        } else {
            ByteArrayInputStream byteArrayInputStream = null;
            String string = exportFieldContentsDownloadFileNotification.getFileName();
            switch (exportFieldContentsDownloadFileNotification.getDataType()) {
                case STRING_DATA: {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(exportFieldContentsDownloadFileNotification.getTextData().getBytes("UTF-8"));
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {}
                    break;
                }
                case BINARY_DATA_URL: {
                    IWPUtilities.showFileDownloadDialog(app, exportFieldContentsDownloadFileNotification.getBinaryDataURL(), exportFieldContentsDownloadFileNotification.getStreamSessionKey(), IWPUtilities.getMimeTypeFromFilename(string), string);
                    break;
                }
                case BINARY_DATA: {
                    byteArrayInputStream = new ByteArrayInputStream(exportFieldContentsDownloadFileNotification.getBinaryData());
                    break;
                }
            }
            if (byteArrayInputStream != null) {
                IWPUtilities.showFileDownloadDialog(app, byteArrayInputStream, IWPUtilities.getMimeTypeFromFilename(string), string);
            }
        }
    }

    @Override
    public ExportMappingInfo notifyExportMappingDialog(Context context, ExportMappingDialogNotification exportMappingDialogNotification) throws TException {
        ExportMappingInfo exportMappingInfo = (ExportMappingInfo)this.getResponseFromDialog(context, EventType.EXPORT_MAPPING_DIALOG, exportMappingDialogNotification);
        if (exportMappingInfo == null) {
            exportMappingInfo = new ExportMappingInfo();
        }
        return exportMappingInfo;
    }

    @Override
    public ImportRecordsFileInfo notifyImportRecordsDialog(Context context, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
        ImportRecordsFileInfo importRecordsFileInfo = (ImportRecordsFileInfo)this.getResponseFromDialog(context, EventType.IMPORT_RECORDS_DIALOG, importRecordsDialogNotification);
        if (importRecordsFileInfo == null) {
            importRecordsFileInfo = new ImportRecordsFileInfo();
        }
        return importRecordsFileInfo;
    }

    @Override
    public ImportMappingInfo notifyImportMappingDialog(Context context, ImportMappingDialogNotification importMappingDialogNotification) throws TException {
        ImportMappingInfo importMappingInfo = (ImportMappingInfo)this.getResponseFromDialog(context, EventType.IMPORT_MAPPING_DIALOG, importMappingDialogNotification);
        if (importMappingInfo == null) {
            importMappingInfo = new ImportMappingInfo();
        }
        return importMappingInfo;
    }

    @Override
    public ConfirmationChoice notifyConfirmationDialog(Context context, ConfirmationNotification confirmationNotification) throws TException {
        ConfirmationChoice confirmationChoice = (ConfirmationChoice)((Object)this.getResponseFromDialog(context, EventType.CONFIRMATION_DIALOG, confirmationNotification));
        if (confirmationChoice == null) {
            confirmationChoice = ConfirmationChoice.ConfirmNo;
        }
        return confirmationChoice;
    }

    @Override
    public boolean notifyOpenURL(Context context, OpenURLNotification openURLNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.OPEN_URL);
            return false;
        }
        String string = openURLNotification.getUrl();
        if (openURLNotification.isShowDialog()) {
            GetURLDialog.GetURLResult getURLResult = (GetURLDialog.GetURLResult)this.getResponseFromDialog(context, EventType.OPEN_URL, openURLNotification);
            if (getURLResult.confirm) {
                string = getURLResult.url;
            } else {
                return false;
            }
        }
        IWPUtilities.openURL(app, string);
        return true;
    }

    @Override
    public InsertFromURLResponse notifyInsertFromURL(Context context, InsertFromURLNotification insertFromURLNotification) throws TException {
        InsertFromURLResponse insertFromURLResponse = new InsertFromURLResponse(false, "");
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.INSERT_FROM_URL);
        } else {
            GetURLDialog.GetURLResult getURLResult = (GetURLDialog.GetURLResult)this.getResponseFromDialog(context, EventType.INSERT_FROM_URL, insertFromURLNotification);
            insertFromURLResponse.setConfirm(getURLResult.confirm);
            insertFromURLResponse.setUrl(getURLResult.url);
        }
        return insertFromURLResponse;
    }

    @Override
    public SaveAsSsLinkDialogResult notifySaveAsSsLinkDialog(Context context, SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) throws TException {
        SaveAsSsLinkDialogResult saveAsSsLinkDialogResult = (SaveAsSsLinkDialogResult)this.getResponseFromDialog(context, EventType.SAVEAS_SNAPSHOT_LINK_DIALOG, saveAsSsLinkDialogNotification);
        if (saveAsSsLinkDialogResult == null) {
            saveAsSsLinkDialogResult = new SaveAsSsLinkDialogResult();
        }
        return saveAsSsLinkDialogResult;
    }

    @Override
    public void notifyDownloadFile(Context context, DownloadFileNotification downloadFileNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.DOWNLOAD_FILE, downloadFileNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifySessionDisconnect(Context context, final SessionDisconnectNotification sessionDisconnectNotification) throws TException {
        final int n = context.getSessionID();
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                App app = App.getApp(n);
                if (app != null && !app.isLogoutDialogUp()) {
                    switch (sessionDisconnectNotification.getType()) {
                        case USER_LOGOUT: 
                        case SESSION_TIMEOUT: {
                            break;
                        }
                        case ADMIN_CLOSE: {
                            if (app.shouldDisplayLogoutDialog()) {
                                app.handleAdminLogout(IWPI18N.get(app, "SESSION_DISCONNECTED", sessionDisconnectNotification.getReason()));
                                break;
                            }
                            sessionDisconnectNotification.setType(SessionDisconnectType.USER_LOGOUT);
                            break;
                        }
                    }
                    app.getAppView().setConfirmLogout(false);
                    app.forceClose(false, true, sessionDisconnectNotification.getType());
                }
            }
        };
        Executors.runTask(runnable);
    }

    @Override
    public void notifyCloseRequest(Context context, CloseRequestNotification closeRequestNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app != null) {
            Session session = app.getAppSession();
            if (closeRequestNotification.getType() == CloseRequestType.MESSAGE) {
                this.getResponseFromDialog(context, EventType.MESSAGE_DIALOG, closeRequestNotification);
            } else {
                boolean bl = session.hasReceivedCloseRequestNotification();
                if (!bl) {
                    session.setReceivedCloseRequestNotification(true);
                    Object object = this.getResponseFromDialog(context, EventType.ADMIN_CLOSE_REQUEST, closeRequestNotification, 45L);
                    if (object == null) {
                        app.attemptSessionLogout();
                    } else {
                        ConfirmationChoice confirmationChoice = (ConfirmationChoice)((Object)object);
                        if (confirmationChoice == ConfirmationChoice.ConfirmYes) {
                            app.setDisplayLogoutDialog(false);
                            app.attemptSessionLogout();
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean notifySessionExpired(Context context, SessionExpiredNotification sessionExpiredNotification) throws TException {
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.USER_TIMEDOUT);
            return true;
        }
        ConfirmationChoice confirmationChoice = (ConfirmationChoice)((Object)this.getResponseFromDialog(context, EventType.USER_TIMEDOUT, sessionExpiredNotification, sessionExpiredNotification.getDuration()));
        if (confirmationChoice == ConfirmationChoice.ConfirmYes) {
            app.attemptSessionLogout();
            return true;
        }
        return false;
    }

    @Override
    public void notifyPing(String string) {
        System.out.println("Ping received : " + string);
    }

    @Override
    public void notifyLayoutModeChange(Context context, LayoutModeChangeNotification layoutModeChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.MODE_CHANGE, layoutModeChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    private Object getResponseFromDialog(Context context, EventType eventType, Object object) throws TException {
        return this.getResponseFromDialog(context, eventType, object, IWPConstants.DIALOG_MAX_DURATION);
    }

    private Object getResponseFromDialog(Context context, EventType eventType, Object object, long l) throws TException {
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null) {
            if (eventType == EventType.LOGIN_DIALOG) {
                return new LoginResponse(false, false, false, "", "", true);
            }
            this.processNoReceiver(context, eventType);
            return null;
        }
        return app.getAppController().getNotificationDialogProcessor().getDialogResponse(app, context, eventType, object, l);
    }

    @Override
    public void notifyVisiblePanelChange(Context context, VisiblePanelChangeNotification visiblePanelChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.VISIBLE_PANEL_CHANGE, visiblePanelChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public ChangePasswordResponse notifyChangePasswordDialog(Context context, ChangePasswordDialogNotification changePasswordDialogNotification) throws TException {
        ChangePasswordResponse changePasswordResponse = (ChangePasswordResponse)this.getResponseFromDialog(context, EventType.CHANGE_PASSWORD_DIALOG, changePasswordDialogNotification);
        if (changePasswordResponse == null) {
            changePasswordResponse = new ChangePasswordResponse();
        }
        return changePasswordResponse;
    }

    @Override
    public void notifySendMail(Context context, SendMailNotification sendMailNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.SEND_MAIL);
        } else {
            IWPUtilities.openMailTo(app, Utilities.getMailToString(sendMailNotification.getToString(), sendMailNotification.getCcString(), sendMailNotification.getBccString(), sendMailNotification.getSubjectString(), sendMailNotification.getBodyString(), app.getBrowserInfoHandler().isIE()));
        }
    }

    @Override
    public LoginResponse notifyLoginDialog(Context context, LoginDialogNotification loginDialogNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (loginDialogNotification.isMainFile() && app != null && app.isNativeLogin() && (app.getLogoutURL() == null || app.hasCustomLoginHandler())) {
            app.setLoginError(loginDialogNotification.getError().getErrorCode(), loginDialogNotification.isGuestEnabled(), loginDialogNotification.isHideLocalAccountEntry());
            return new LoginResponse();
        }
        LoginResponse loginResponse = (LoginResponse)this.getResponseFromDialog(context, EventType.LOGIN_DIALOG, loginDialogNotification);
        if (loginResponse == null) {
            loginResponse = new LoginResponse();
        }
        return loginResponse;
    }

    @Override
    public AppleIDLoginResponse notifyAppleIDLoginDialog(Context context, AppleIDLoginDialogNotification appleIDLoginDialogNotification) throws TException {
        AppleIDLoginResponse appleIDLoginResponse = (AppleIDLoginResponse)this.getResponseFromDialog(context, EventType.APPLEID_LOGIN_DIALOG, appleIDLoginDialogNotification);
        if (appleIDLoginResponse == null) {
            appleIDLoginResponse = new AppleIDLoginResponse();
        }
        return appleIDLoginResponse;
    }

    @Override
    public void notifyLongScript(Context context, LongScriptNotification longScriptNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.SCRIPT_RUNNING_DIALOG);
        } else {
            app.getMessenger().showLongScriptBusyDialog(longScriptNotification.isAllowAbort(), IWPI18N.get(app, "BUSY_DIALOG_MSG", new Object[0]));
        }
    }

    @Override
    public void notifyWindowNameChange(Context context, WindowNameChangeNotification windowNameChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.WINDOW_NAME_CHANGE, windowNameChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyErrorDialog(Context context, ErrorDialogNotification errorDialogNotification) throws TException {
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null || app.getCurrentErrorCode() != errorDialogNotification.getError().getErrorCode()) {
            this.getResponseFromDialog(context, EventType.ERROR_DIALOG, errorDialogNotification);
        }
    }

    @Override
    public String notifyBrowserClientInfoRequest(Context context, BrowserClientInfoRequestNotification browserClientInfoRequestNotification) throws TException {
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null) {
            this.processNoReceiver(context, EventType.GET_CLIENT_INFO);
            return "";
        }
        return app.getBrowserInfoHandler().getDynamicBrowserClientInfo(browserClientInfoRequestNotification);
    }

    @Override
    public void notifyOpenPopover(Context context, OpenPopoverNotification openPopoverNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.OPEN_POPOVER, openPopoverNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyClosePopover(Context context, ClosePopoverNotification closePopoverNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.CLOSE_POPOVER, closePopoverNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyUserNameChange(Context context, UserNameChangeNotification userNameChangeNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ACCOUNTNAME_CHANGE, userNameChangeNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyEnterField(Context context, EnterFieldNotification enterFieldNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ENTER_FIELD, enterFieldNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    private NotificationEventCommand getCommand(Context context, EventType eventType, Object object) throws TException {
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, eventType);
            return null;
        }
        return new NotificationEventCommand(new NotificationEvent(eventType, app, context, object));
    }

    private void processCommand(NotificationEventCommand notificationEventCommand) {
        notificationEventCommand.getApplicationRoot().getAppController().getNotificationEventBus().schedule(notificationEventCommand);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processNoReceiver(Context context, EventType eventType) {
        App app;
        int n = context.getSessionID();
        if (IWPUtilities.isDebugMode()) {
            System.err.println("[Warning] There is no receiver for the event " + String.valueOf((Object)eventType) + " for client id " + n + ". This server has these client id : " + String.valueOf(App.getAllClientIDs()));
        }
        if ((app = App.getApp(context.getSessionID())) == null) {
            ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(6001);
            try {
                serviceClient.getClient().forceSessionClose(context);
            }
            catch (TException tException) {
                serviceClient.setReset();
            }
            finally {
                ServiceClientPoolLiaison.putClient(serviceClient);
            }
        }
    }

    @Override
    public ImportRecordsFileInfo notifyInsertFileDialog(Context context, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
        ImportRecordsFileInfo importRecordsFileInfo = (ImportRecordsFileInfo)this.getResponseFromDialog(context, EventType.IMPORT_FILE_DIALOG, importRecordsDialogNotification);
        if (importRecordsFileInfo == null) {
            importRecordsFileInfo = new ImportRecordsFileInfo();
        }
        return importRecordsFileInfo;
    }

    @Override
    public void notifyLongOperation(Context context, LongOperationNotification longOperationNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.LONG_OPERATION);
        } else {
            app.getMessenger().showBusyDialog(longOperationNotification.isAllowAbort(), IWPI18N.get(app, "BUSY_DIALOG_WAIT", new Object[0]));
        }
    }

    @Override
    public void notifyLongOperationDone(Context context) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.LONG_OPERATION_DONE, null);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyActiveRowState(Context context, ActiveRowStateNotification activeRowStateNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ACTIVE_ROW_STATE, activeRowStateNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyPrivileges(Context context, PrivilegesNotification privilegesNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.UPDATE_PRIVILEGES, privilegesNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifySkipActiveUIRefresh(Context context) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.SKIP_ACTIVE_UI_REFRESH, null);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyPortalRowsVisible(Context context, PortalRowVisibleNotification portalRowVisibleNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.PORTAL_ROWS_VISIBLE, portalRowVisibleNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public SaveAsPDFResponse notifySaveAsPDF(Context context, SaveAsPDFNotification saveAsPDFNotification) throws TException {
        SaveAsPDFResponse saveAsPDFResponse = new SaveAsPDFResponse(false, new SaveAsPDFSettings());
        App app = App.getApp(context.getSessionID());
        if (app == null || !app.hasValidSession()) {
            this.processNoReceiver(context, EventType.SAVE_AS_PDF);
        } else if (saveAsPDFNotification.getOutputPath().isEmpty()) {
            PDFDialog.SaveAsPDFResult saveAsPDFResult = (PDFDialog.SaveAsPDFResult)this.getResponseFromDialog(context, EventType.SAVE_AS_PDF, saveAsPDFNotification);
            saveAsPDFResponse.setConfirm(saveAsPDFResult.confirm);
            saveAsPDFResponse.getSettings().setDocSaveType(saveAsPDFResult.docSaveType);
            saveAsPDFResponse.getSettings().setPagesFrom(saveAsPDFResult.pagesFrom);
            saveAsPDFResponse.getSettings().setPageOrientation(saveAsPDFResult.pageOrientation);
            saveAsPDFResponse.getSettings().setScaling(saveAsPDFResult.scaling);
            saveAsPDFResponse.getSettings().setPaperSize(saveAsPDFResult.paperSize);
        } else {
            NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.SAVE_AS_PDF, saveAsPDFNotification);
            if (notificationEventCommand != null) {
                this.processCommand(notificationEventCommand);
                saveAsPDFResponse.setConfirm(false);
            }
        }
        return saveAsPDFResponse;
    }

    @Override
    public void notifyActivateSegment(Context context, ActivateSegmentNotification activateSegmentNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ACTIVATE_SEGMENT, activateSegmentNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public PerformWebScriptResponse notifyPerformWebScript(Context context, PerformWebScriptNotification performWebScriptNotification) throws TException {
        PerformWebScriptResponse performWebScriptResponse = new PerformWebScriptResponse();
        int n = context.getSessionID();
        App app = App.getApp(n);
        if (app == null) {
            this.processNoReceiver(context, EventType.PERFORM_WEB_SCRIPT);
        } else {
            WDBrowserFrame.PerformWebScriptResult performWebScriptResult = app.getAppController().getNotificationWebScriptProcessor().performWebScript(app, performWebScriptNotification);
            performWebScriptResponse.setMethodName(performWebScriptResult.methodName);
            performWebScriptResponse.setSuccess(performWebScriptResult.success);
            performWebScriptResponse.setResult(performWebScriptResult.result);
            performWebScriptResponse.setPendingRequests(performWebScriptResult.pendingRequests);
        }
        return performWebScriptResponse;
    }

    @Override
    public void notifyMoveResizeCardStyleWindow(Context context, MoveResizeCardWindowNotification moveResizeCardWindowNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.MOVE_RESIZE_CARD_STYLE_WINDOW, moveResizeCardWindowNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public void notifyCloseCardStyleWindow(Context context) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.CLOSE_CARD_STYLE_WINDOW, null);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }

    @Override
    public boolean notifyOpenShareDialog(Context context, OpenShareDialogNotification openShareDialogNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        boolean bl = false;
        if (app != null && app.hasValidSession()) {
            bl = app.openShareDialog();
        }
        if (!bl) {
            this.processNoReceiver(context, EventType.OPEN_SHARE_DIALOG);
        }
        return bl;
    }

    @Override
    public void notifyOpenLayoutEditor(Context context, OpenLayoutEditorNotification openLayoutEditorNotification) throws TException {
        App app = App.getApp(context.getSessionID());
        boolean bl = false;
        if (app != null && app.hasValidSession()) {
            bl = app.openLayoutEditor(app.getAppSession().getDatabaseName(), false);
        }
        if (!bl) {
            this.processNoReceiver(context, EventType.OPEN_LAYOUT_EDITOR);
        }
    }

    @Override
    public void notifyEnterButton(Context context, EnterButtonNotification enterButtonNotification) throws TException {
        NotificationEventCommand notificationEventCommand = this.getCommand(context, EventType.ENTER_BUTTON, enterButtonNotification);
        if (notificationEventCommand != null) {
            this.processCommand(notificationEventCommand);
        }
    }
}

