/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.notification.processor;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.thrift.common.CardWindowSettings;
import com.filemaker.jwpc.iwp.thrift.common.DownloadFileInfo;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.thrift.notification.DownloadFileNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ELOChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.FieldObjectDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutModeChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoadCachedLayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ObjectsChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.OpenPopoverNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ReloginNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSelectionChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeType;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetDataChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowChangeNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.ScriptStateChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.util.FileDownloadHandler;
import java.util.Map;

public final class NotificationProcessor {
    private final App app;

    public NotificationProcessor(App app) {
        this.app = app;
    }

    public void processLoadCachedLayoutNotification(LoadCachedLayoutNotification loadCachedLayoutNotification, boolean bl) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateLayout(null, false, bl, true, false);
    }

    public void processLayoutNotification(LayoutNotification layoutNotification) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateLayout(layoutNotification.getLayoutUI(), layoutNotification.isForceRedraw(), false, true, false);
    }

    public void processReloginNotification(ReloginNotification reloginNotification) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateLayout(reloginNotification.getLayoutUI(), true, false, true, false);
        if (this.app.getAppView().isCardStyleWindow()) {
            this.app.getStatusAreaContainer().getMainMenuBar().updateAccountName();
        }
    }

    public void processWindowChangeNotification(WindowChangeNotification windowChangeNotification) throws AppException {
        this.app.getActiveUIHandler().reset();
        this.app.getLayoutContainer().getPopoverHandler().exitPopover(false);
        if (!windowChangeNotification.isCardStyleWindow()) {
            boolean bl = this.app.getAppView().isCardStyleWindow();
            if (bl) {
                if (this.app.getAppView().isKeystrokeListenerEnabled()) {
                    this.app.getAppView().setFlagForKeystrokeResult(true);
                }
                this.app.getAppView().setCardStyleWindow(false);
                this.app.notify(new UIEvent(EventType.REFRESH_STATUS_AREA));
                this.app.notify(new ScriptStateChangeEvent(true));
            }
            this.app.getLayoutContainer().updateLayout(windowChangeNotification.getLayoutUI(), !bl, false, true, bl);
        } else {
            this.app.getAppView().showAppScreen(this.app.getCurrentDatabaseName(), true);
            AppCardWindowContainer appCardWindowContainer = (AppCardWindowContainer)this.app.getAppContainer();
            CardWindowSettings cardWindowSettings = windowChangeNotification.getCardWindowSettings();
            appCardWindowContainer.setWindowSettings(cardWindowSettings);
            this.app.getLayoutContainer().updateLayout(windowChangeNotification.getLayoutUI(), true, false, true, false);
            this.app.getAppController().getCardStyleWindowHandler().openWindow(cardWindowSettings.isHasCloseButton());
        }
    }

    public void processRowChangeNotification(RowChangeNotification rowChangeNotification) throws AppException {
        Map<Integer, SingleRowPartsData> map = rowChangeNotification.getRowData();
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateRow(map);
    }

    public void processRowSetDataChangeNotification(RowSetDataChangeNotification rowSetDataChangeNotification) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.refreshRowSetData(rowSetDataChangeNotification.isRelatedRowDataChange());
    }

    public void processFieldObjectDataChangeNotification(FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws AppException {
        FieldObjectData fieldObjectData = fieldObjectDataChangeNotification.getFieldObjectData();
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateFieldObject(fieldObjectData);
    }

    public void processObjectsChangeNotification(ObjectsChangeNotification objectsChangeNotification) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.refreshObjects(objectsChangeNotification.getObjects(), objectsChangeNotification.getPortals());
    }

    public void processELOChangeNotification(ELOChangeNotification eLOChangeNotification) throws AppException {
        this.app.getLayoutContainer().updateELO(eLOChangeNotification.getSoData());
    }

    public void processRowSetChangeNotification(RowSetChangeNotification rowSetChangeNotification, boolean bl, boolean bl2) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateRowSet(rowSetChangeNotification.getWindowState().getRowIndex(), rowSetChangeNotification.getAffectedRowIndex(), bl, bl2, rowSetChangeNotification.getChangeType() == RowSetChangeType.ROWSET_CHANGE);
    }

    public void processRowSelectionChangeNotification(RowSelectionChangeNotification rowSelectionChangeNotification, boolean bl) throws AppException {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        layoutContainer.updateRowSelection(bl);
    }

    public void processScriptStateChangeNotification(ScriptStateChangeNotification scriptStateChangeNotification) throws AppException {
        if (!this.app.getAppView().isCardStyleWindow()) {
            this.app.getMessenger().showScriptStateNotifier(scriptStateChangeNotification.isAllowAbort());
        }
    }

    public void processDownloadFileNotification(DownloadFileNotification downloadFileNotification) throws AppException {
        DownloadFileInfo downloadFileInfo = downloadFileNotification.getFileInfo();
        FileDownloadHandler fileDownloadHandler = new FileDownloadHandler(this.app, downloadFileInfo.getFilePath(), downloadFileInfo.getDownloadFileName());
        fileDownloadHandler.downloadAndDelete();
    }

    public void processOpenPopoverNotification(OpenPopoverNotification openPopoverNotification) throws AppException {
        this.app.getLayoutContainer().getPopoverHandler().openPopover(openPopoverNotification.getPopoverId(), openPopoverNotification.getButtonObjectSpec());
    }

    public void processLayoutModeChange(LayoutModeChangeNotification layoutModeChangeNotification) {
        this.app.getLayoutContainer().layoutModeChanged();
    }
}

