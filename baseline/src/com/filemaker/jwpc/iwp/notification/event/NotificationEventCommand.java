/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.notification.event;

import com.filemaker.jwpc.iwp.application.ActiveUIHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.SessionContext;
import com.filemaker.jwpc.iwp.model.LayoutDataModel;
import com.filemaker.jwpc.iwp.notification.event.NotificationEvent;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.layout.FieldData;
import com.filemaker.jwpc.iwp.thrift.notification.ActivateSegmentNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.thrift.notification.DownloadFileNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ELOChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.EnterButtonNotification;
import com.filemaker.jwpc.iwp.thrift.notification.EnterFieldNotification;
import com.filemaker.jwpc.iwp.thrift.notification.FieldObjectDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutModeChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoadCachedLayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MenubarStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MoveResizeCardWindowNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ObjectsChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenDatabaseNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenPopoverNotification;
import com.filemaker.jwpc.iwp.thrift.notification.PortalRowVisibleNotification;
import com.filemaker.jwpc.iwp.thrift.notification.PrivilegesNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ReloginNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSelectionChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsPDFNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.TableChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ToolbarStatusAreaStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.VisiblePanelChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowNameChangeNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.PanelSwitchEvent;
import com.filemaker.jwpc.iwp.ui.event.ScriptStateChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.TableChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.PDFSupport;
import com.filemaker.jwpc.util.Utilities;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class NotificationEventCommand {
    private final NotificationEvent event;

    public NotificationEventCommand(NotificationEvent notificationEvent) {
        this.event = notificationEvent;
    }

    public NotificationEvent getEvent() {
        return this.event;
    }

    public App getApplicationRoot() {
        return this.event.getApp();
    }

    public void execute() {
        Object object;
        App app = this.event.getApp();
        if (app.getDeveloperTools().isNotificationDebuggingSelected()) {
            app.getDeveloperTools().showNotificationDebugging(app, this.event.getType().toString(), this.event.toString());
        }
        this.process(app);
        UIEvent uIEvent = switch (this.event.getType()) {
            case EventType.TABLE_CHANGE -> {
                object = (TableChangeNotification)this.event.getNotification();
                yield new TableChangeEvent(((TableChangeNotification)object).getTableId());
            }
            case EventType.VISIBLE_PANEL_CHANGE -> {
                object = (VisiblePanelChangeNotification)this.event.getNotification();
                yield new PanelSwitchEvent(((VisiblePanelChangeNotification)object).getPanelContainerId(), ((VisiblePanelChangeNotification)object).getVisiblePanelId());
            }
            case EventType.SCRIPT_STATE_CHANGE -> {
                object = (ScriptStateChangeNotification)this.event.getNotification();
                yield new ScriptStateChangeEvent(((ScriptStateChangeNotification)object).isAllowAbort());
            }
            default -> new UIEvent(this.event.getType());
        };
        object = app.getLayoutDataModel();
        List<UIEvent> list = ((LayoutDataModel)object).getPendingEvents();
        boolean bl = false;
        while (list.size() > 0) {
            UIEvent uIEvent2 = list.remove(0);
            this.notify(app, uIEvent2);
            if (uIEvent2.getType() != this.event.getType()) continue;
            bl = true;
        }
        if (!bl && !((LayoutDataModel)object).isEventEffectingModel(uIEvent.getType())) {
            this.notify(app, uIEvent);
        }
    }

    private void process(App app) {
        try {
            this.updateContext(app);
            switch (this.event.getType()) {
                case OPEN_DATABASE: {
                    this.processOpenDatabaseNotification(app, this.event.getContext(), (OpenDatabaseNotification)this.event.getNotification());
                    break;
                }
                case LAYOUT_CHANGE: {
                    this.processLayoutChange(app, (LayoutNotification)this.event.getNotification());
                    break;
                }
                case RELOGIN_CHANGE: {
                    this.processReloginChange(app, (ReloginNotification)this.event.getNotification());
                    break;
                }
                case WINDOW_CHANGE: {
                    this.processWindowChange(app, (WindowChangeNotification)this.event.getNotification());
                    break;
                }
                case LOAD_CACHED_LAYOUT: {
                    this.processLoadCachedLayout(app, (LoadCachedLayoutNotification)this.event.getNotification());
                    break;
                }
                case ROW_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processRowChange(app, (RowChangeNotification)this.event.getNotification());
                    break;
                }
                case ROW_SET_DATA_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processRowSetDataChange(app, (RowSetDataChangeNotification)this.event.getNotification());
                    break;
                }
                case FIELD_OBJECT_DATA_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processFieldObjectDataChange(app, (FieldObjectDataChangeNotification)this.event.getNotification());
                    break;
                }
                case OBJECTS_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processObjectsChange(app, (ObjectsChangeNotification)this.event.getNotification());
                    break;
                }
                case ELO_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processELOChange(app, (ELOChangeNotification)this.event.getNotification());
                    break;
                }
                case ROW_SET_CHANGE: {
                    if (!this.isLayoutNameValid(app, this.event.getContext())) break;
                    this.processRowSetChange(app, (RowSetChangeNotification)this.event.getNotification(), this.event.getContext());
                    break;
                }
                case ROW_SELECTION_CHANGE: {
                    this.processRowSelectionChange(app, (RowSelectionChangeNotification)this.event.getNotification());
                    break;
                }
                case LAYOUT_NAMES_LIST_CHANGE: {
                    this.processLayoutNamesChange(app, (LayoutNamesChangeNotification)this.event.getNotification());
                    break;
                }
                case SCRIPT_NAMES_CHANGE: {
                    this.processScriptNamesChange(app, (ScriptNamesChangeNotification)this.event.getNotification());
                    break;
                }
                case SCRIPT_STATE_CHANGE: {
                    this.processScriptStateChange(app, (ScriptStateChangeNotification)this.event.getNotification());
                    break;
                }
                case MENUBAR_STATE_CHANGE: {
                    this.processMenubarStateChange(app, (MenubarStateChangeNotification)this.event.getNotification());
                    break;
                }
                case TOOLBAR_STATUSAREA_STATE_CHANGE: {
                    this.processToolbarStatusAreaStateChange(app, (ToolbarStatusAreaStateChangeNotification)this.event.getNotification());
                    break;
                }
                case DOWNLOAD_FILE: {
                    this.processDownloadFile(app, (DownloadFileNotification)this.event.getNotification());
                    break;
                }
                case MODE_CHANGE: {
                    this.processLayoutModeChange(app, (LayoutModeChangeNotification)this.event.getNotification());
                    break;
                }
                case WINDOW_NAME_CHANGE: {
                    this.processWindowNameChange(app, (WindowNameChangeNotification)this.event.getNotification());
                    break;
                }
                case OPEN_POPOVER: {
                    this.processOpenPopover(app, (OpenPopoverNotification)this.event.getNotification());
                    break;
                }
                case CLOSE_POPOVER: {
                    this.processClosePopover(app);
                    break;
                }
                case ACTIVE_ROW_STATE: {
                    this.processActiveRowState(app, (ActiveRowStateNotification)this.event.getNotification());
                    break;
                }
                case UPDATE_PRIVILEGES: {
                    this.processUpdatePrivileges(app, (PrivilegesNotification)this.event.getNotification());
                    break;
                }
                case LONG_OPERATION_DONE: {
                    this.processLongOperationDone(app, this.event.getContext().getTaskId());
                    break;
                }
                case ENTER_FIELD: {
                    this.processEnterField(app, (EnterFieldNotification)this.event.getNotification());
                    break;
                }
                case SKIP_ACTIVE_UI_REFRESH: {
                    this.processSkipActiveUIRefresh(app);
                    break;
                }
                case PORTAL_ROWS_VISIBLE: {
                    this.processPortalRowsVisible(app, (PortalRowVisibleNotification)this.event.getNotification());
                    break;
                }
                case SAVE_AS_PDF: {
                    this.processSaveAsPDFResult(app, (SaveAsPDFNotification)this.event.getNotification());
                    break;
                }
                case ACTIVATE_SEGMENT: {
                    this.processActivateSegment(app, (ActivateSegmentNotification)this.event.getNotification());
                    break;
                }
                case MOVE_RESIZE_CARD_STYLE_WINDOW: {
                    this.processMoveResizeCardStyleWindow(app, (MoveResizeCardWindowNotification)this.event.getNotification());
                    break;
                }
                case CLOSE_CARD_STYLE_WINDOW: {
                    this.processCloseCardStyleWindow(app);
                    break;
                }
                case ENTER_BUTTON: {
                    this.processEnterButton(app, (EnterButtonNotification)this.event.getNotification());
                    break;
                }
            }
        }
        catch (AppException appException) {
            throw new AppRuntimeException(appException);
        }
    }

    private void updateContext(App app) {
        Session session = app.getAppSession();
        if (session != null && this.event != null && this.event.getContext() != null) {
            session.updateContext(session.isLoggedIn(), this.event.getContext());
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("NULL pointer in Notification Process!");
        }
    }

    private void notify(App app, UIEvent uIEvent) {
        app.notify(uIEvent);
    }

    private void processOpenDatabaseNotification(App app, Context context, OpenDatabaseNotification openDatabaseNotification) {
        app.openDatabaseComplete(context, openDatabaseNotification);
    }

    private void processRowChange(App app, RowChangeNotification rowChangeNotification) throws AppException {
        app.getNotificationProcessor().processRowChangeNotification(rowChangeNotification);
    }

    private void processRowSetDataChange(App app, RowSetDataChangeNotification rowSetDataChangeNotification) throws AppException {
        app.getNotificationProcessor().processRowSetDataChangeNotification(rowSetDataChangeNotification);
    }

    private void processFieldObjectDataChange(App app, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws AppException {
        if (app.getActiveUIHandler().hasPendingTabbing()) {
            app.getActiveUIHandler().setPendingTabbing(false);
            LayoutObject layoutObject = app.getLayoutContainer().getCurrentView().getLayoutObject(fieldObjectDataChangeNotification.getFieldObjectData().getObjectSpec());
            if (layoutObject != null && !layoutObject.getMetaData().isSelectAllOnEntry()) {
                FieldData fieldData = fieldObjectDataChangeNotification.getFieldObjectData().getFieldData();
                int n = fieldData.getData().getStringValue().getValue().length();
                fieldData.setUpdateSelection(true);
                fieldData.setSelectionStart(n);
                fieldData.setSelectionEnd(n);
            }
        }
        app.getNotificationProcessor().processFieldObjectDataChangeNotification(fieldObjectDataChangeNotification);
    }

    private void processObjectsChange(App app, ObjectsChangeNotification objectsChangeNotification) throws AppException {
        app.getNotificationProcessor().processObjectsChangeNotification(objectsChangeNotification);
    }

    private void processELOChange(App app, ELOChangeNotification eLOChangeNotification) throws AppException {
        app.getNotificationProcessor().processELOChangeNotification(eLOChangeNotification);
    }

    private void processLayoutChange(App app, LayoutNotification layoutNotification) throws AppException {
        app.getLayoutDataModel().update(layoutNotification, true);
        app.getDatabaseDataModel().update(layoutNotification);
        app.getNotificationProcessor().processLayoutNotification(layoutNotification);
    }

    private void processReloginChange(App app, ReloginNotification reloginNotification) throws AppException {
        app.getLayoutDataModel().update(reloginNotification, true);
        app.getDatabaseDataModel().update(reloginNotification);
        app.getNotificationProcessor().processReloginNotification(reloginNotification);
    }

    private void processWindowChange(App app, WindowChangeNotification windowChangeNotification) throws AppException {
        app.getLayoutDataModel().update(windowChangeNotification, true);
        app.getDatabaseDataModel().update(windowChangeNotification);
        app.getNotificationProcessor().processWindowChangeNotification(windowChangeNotification);
    }

    private void processLoadCachedLayout(App app, LoadCachedLayoutNotification loadCachedLayoutNotification) throws AppException {
        boolean bl;
        boolean bl2 = bl = !app.getDatabaseDataModel().getSortState().getSortQueries().equals(loadCachedLayoutNotification.getSortQueries());
        if (loadCachedLayoutNotification.getSortQueries().size() > 0) {
            app.getDatabaseDataModel().updateSortQueries(loadCachedLayoutNotification.getSortQueries());
            app.getDatabaseDataModel().getSortState().setSortCriteriaOnColumns(true);
        }
        app.getLayoutDataModel().update(loadCachedLayoutNotification, true);
        app.getNotificationProcessor().processLoadCachedLayoutNotification(loadCachedLayoutNotification, bl);
    }

    private void processLayoutNamesChange(App app, LayoutNamesChangeNotification layoutNamesChangeNotification) {
        app.getDatabaseDataModel().update(layoutNamesChangeNotification);
    }

    private void processScriptNamesChange(App app, ScriptNamesChangeNotification scriptNamesChangeNotification) {
        app.getDatabaseDataModel().update(scriptNamesChangeNotification);
    }

    private void processScriptStateChange(App app, ScriptStateChangeNotification scriptStateChangeNotification) throws AppException {
        app.getDatabaseDataModel().update(scriptStateChangeNotification);
        app.getNotificationProcessor().processScriptStateChangeNotification(scriptStateChangeNotification);
    }

    private void processMenubarStateChange(App app, MenubarStateChangeNotification menubarStateChangeNotification) throws AppException {
        app.getDatabaseDataModel().update(menubarStateChangeNotification);
    }

    private void processToolbarStatusAreaStateChange(App app, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws AppException {
        app.getDatabaseDataModel().update(toolbarStatusAreaStateChangeNotification);
    }

    private void processRowSetChange(App app, RowSetChangeNotification rowSetChangeNotification, Context context) throws AppException {
        boolean bl;
        app.getLayoutDataModel().update(rowSetChangeNotification, false);
        boolean bl2 = bl = !app.getDatabaseDataModel().getSortState().getSortQueries().equals(rowSetChangeNotification.getSortQueries());
        if (rowSetChangeNotification.getSortQueries().size() > 0) {
            app.getDatabaseDataModel().updateSortQueries(rowSetChangeNotification.getSortQueries());
            app.getDatabaseDataModel().getSortState().setSortCriteriaOnColumns(true);
        }
        boolean bl3 = app.getLayoutDataModel().updateRowId(rowSetChangeNotification.getWindowState().getRowId());
        app.getNotificationProcessor().processRowSetChangeNotification(rowSetChangeNotification, bl3, bl);
    }

    private void processRowSelectionChange(App app, RowSelectionChangeNotification rowSelectionChangeNotification) throws AppException {
        app.getLayoutDataModel().update(rowSelectionChangeNotification, false);
        boolean bl = app.getLayoutDataModel().updateRowId(rowSelectionChangeNotification.getWindowState().getRowId());
        app.getNotificationProcessor().processRowSelectionChangeNotification(rowSelectionChangeNotification, bl);
    }

    private void processDownloadFile(App app, DownloadFileNotification downloadFileNotification) throws AppException {
        app.getNotificationProcessor().processDownloadFileNotification(downloadFileNotification);
    }

    private boolean isLayoutNameValid(App app, Context context) {
        String string = app.getAppSession().getLayoutName();
        return context.getLayoutName().equals(string);
    }

    private void processLayoutModeChange(App app, LayoutModeChangeNotification layoutModeChangeNotification) {
        app.getLayoutDataModel().update(layoutModeChangeNotification, true);
        app.getNotificationProcessor().processLayoutModeChange(layoutModeChangeNotification);
    }

    private void processWindowNameChange(App app, WindowNameChangeNotification windowNameChangeNotification) {
        app.getPage().setTitle(windowNameChangeNotification.getWindowName());
    }

    private void processOpenPopover(App app, OpenPopoverNotification openPopoverNotification) throws AppException {
        app.getNotificationProcessor().processOpenPopoverNotification(openPopoverNotification);
    }

    private void processClosePopover(App app) {
        app.getLayoutContainer().getPopoverHandler().exitPopover(false);
    }

    private void processCloseCardStyleWindow(App app) {
        app.getAppController().getCardStyleWindowHandler().exitWindow(false);
    }

    private void processMoveResizeCardStyleWindow(App app, MoveResizeCardWindowNotification moveResizeCardWindowNotification) {
        app.getAppController().getCardStyleWindowHandler().moveResizeWindow(moveResizeCardWindowNotification.getPosition(), moveResizeCardWindowNotification.getDimensions());
    }

    private void processActiveRowState(App app, ActiveRowStateNotification activeRowStateNotification) {
        if (BrowserInfoHandler.isiOSDevice(app)) {
            app.getActiveUIHandler().setSkipRefresh(false);
        }
        app.getLayoutContainer().setActiveRowState(activeRowStateNotification);
    }

    private void processUpdatePrivileges(App app, PrivilegesNotification privilegesNotification) {
        boolean bl;
        app.getPrivileges().update(privilegesNotification.getPrivs());
        SessionContext sessionContext = app.getSessionContext();
        if (sessionContext != null && !Utilities.isEmptyString(sessionContext.getFMID()) && (bl = privilegesNotification.getPrivs().getLayoutAccess() == DBAccessLevel.ReadWrite & app.getAppView().getQAAEnabled()) != sessionContext.canEditLayout()) {
            sessionContext.setCanEditLayout(bl);
            if (app.getAppView().getLayoutEditor() != null) {
                app.getAppView().getLayoutEditor().setVisible(bl);
            }
        }
    }

    private void processLongOperationDone(App app, long l) {
        LayoutView layoutView;
        app.getMessenger().closeBusyDialog();
        LayoutContainer layoutContainer = app.getLayoutContainer();
        if (layoutContainer != null && (layoutView = layoutContainer.getCurrentView()) != null) {
            ActiveUIHandler activeUIHandler = app.getActiveUIHandler();
            if (activeUIHandler.hasPendingRefresh() && !layoutView.refreshingViewData()) {
                activeUIHandler.refreshActiveUI();
            }
            if (activeUIHandler.getPendingTabbingTaskId() > 0L && activeUIHandler.getPendingTabbingTaskId() <= l) {
                app.getAppView().tryEnableTabKeyHandlingInBrowser();
                activeUIHandler.clearPendingTabbingTaskId();
            }
        }
        app.pushChanges();
    }

    private void processEnterField(App app, EnterFieldNotification enterFieldNotification) {
        if ((BrowserInfoHandler.isMobile(app) || app.getBrowserInfoHandler().isIE()) && !enterFieldNotification.isResult() && app.getActiveUIHandler().getActiveField(false, false) == null) {
            app.getAppView().tryRemoveActiveFieldInBrowser();
        }
    }

    private void processActivateSegment(App app, ActivateSegmentNotification activateSegmentNotification) {
        app.getLayoutContainer().activateSegment();
    }

    private void processSkipActiveUIRefresh(App app) {
        if (BrowserInfoHandler.isiOSDevice(app)) {
            app.getActiveUIHandler().setSkipRefresh(true);
        }
    }

    private void processPortalRowsVisible(App app, PortalRowVisibleNotification portalRowVisibleNotification) {
        for (ObjectSpec objectSpec : portalRowVisibleNotification.getRowObjectSpecs()) {
            LayoutObject layoutObject = app.getLayoutContainer().getCurrentView().getLayoutObjectFromPortal(objectSpec, true);
            if (layoutObject == null) continue;
            Portal portal = layoutObject instanceof Portal ? (Portal)layoutObject : layoutObject.getAttributes().getOwningPortal();
            portal.getPortalTable().makeRowVisible(objectSpec.getPortalRowIndex(), null);
        }
    }

    private void processSaveAsPDFResult(App app, SaveAsPDFNotification saveAsPDFNotification) {
        if (!PDFSupport.handlePDFResult(app, saveAsPDFNotification)) {
            // empty if block
        }
    }

    private void processEnterButton(App app, EnterButtonNotification enterButtonNotification) {
        LayoutObject layoutObject = null;
        layoutObject = app.getLayoutContainer().getPopoverHandler().isPopoverOpen() ? app.getLayoutContainer().getPopoverHandler().getPopoverWindow().getPopover().getLayoutObject(enterButtonNotification.getObjectSpec()) : app.getLayoutContainer().getCurrentView().getLayoutObject(enterButtonNotification.getObjectSpec());
        if (layoutObject != null && layoutObject instanceof Button) {
            final Button button = (Button)layoutObject;
            Timer timer = new Timer();
            timer.schedule(new TimerTask(this){

                @Override
                public void run() {
                    button.focus();
                }
            }, 50L);
        }
    }

    public String toString() {
        return String.format("[event=%s]", this.event);
    }
}

