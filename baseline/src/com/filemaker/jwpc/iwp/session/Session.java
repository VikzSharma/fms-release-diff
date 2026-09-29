/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.ActionResultHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientFaucet;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.service.ServiceConfig;
import com.filemaker.jwpc.iwp.session.ActionTask;
import com.filemaker.jwpc.iwp.session.ActionTaskHelper;
import com.filemaker.jwpc.iwp.session.GetterActionTask;
import com.filemaker.jwpc.iwp.session.SessionActionTaskFactory;
import com.filemaker.jwpc.iwp.session.SessionBlockingTasks;
import com.filemaker.jwpc.iwp.session.SessionGetterActionTaskFactory;
import com.filemaker.jwpc.iwp.thrift.common.BinaryDataOptions;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DateTime;
import com.filemaker.jwpc.iwp.thrift.common.FieldSpec;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.KeystrokeEvent;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.SessionInfo;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.log.JWPCLogger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.TException;

public final class Session {
    private static JWPCLogger logger = JWPCLogger.getLogger(Session.class);
    private boolean hasBeenForcedClosed = false;
    private final ServiceConfig config;
    protected Context currentContext;
    protected final ActionTaskHelper helper;
    private boolean hasSession = false;
    private boolean hasLoggedIn = false;
    protected boolean hasReceivedCloseRequestNotification = false;
    protected SessionActionTaskFactory taskFactory;
    protected SessionGetterActionTaskFactory getterTaskFactory;
    private final SessionBlockingTasks sessionBlocking;
    private String uploadDirPath;
    private App app;
    private static long timeout = -1L;
    private long taskId = 0L;

    public Session(App app, ServiceConfig serviceConfig) {
        this.app = app;
        this.config = serviceConfig;
        this.sessionBlocking = new SessionBlockingTasks(app);
        this.taskFactory = new SessionActionTaskFactory(app, this);
        this.getterTaskFactory = new SessionGetterActionTaskFactory(app, this);
        this.helper = new ActionTaskHelper(app);
        this.updateContext(false, new Context(0, 0, "", "", "", "", -1, -1L, LayoutViewStyle.FORM, LayoutMode.BROWSE, true, true, 0L, false, 8998, "", false));
    }

    public void updateContext(boolean bl, Context context) {
        this.currentContext = context;
        this.hasLoggedIn = bl;
    }

    public void updateSession(int n, long l, String string) {
        this.updateContext(false, new Context(n, 0, "", "", "", "", -1, -1L, LayoutViewStyle.FORM, LayoutMode.BROWSE, true, true, 0L, false, 8998, "", false));
        this.hasSession = true;
        timeout = l;
        this.uploadDirPath = string;
    }

    public Context getCurrentContext() {
        return this.currentContext;
    }

    public Context getNextActionContext() {
        Context context = new Context(this.currentContext);
        context.setTaskId(++this.taskId);
        return context;
    }

    public static long getTimeout() {
        return timeout;
    }

    public boolean isLoggedIn() {
        return this.hasSession && this.hasLoggedIn;
    }

    public ActionTaskHelper getActionTaskHelper() {
        return this.helper;
    }

    public boolean hasValidSession() {
        return this.hasSession && IWPUtilities.isValidSessionID(this.getSessionID());
    }

    public int getSessionID() {
        return this.getContext().getSessionID();
    }

    public int getWindowID() {
        return this.getContext().getWindowID();
    }

    public String getDatabaseName() {
        return this.getContext().getDatabaseName();
    }

    public String getLayoutName() {
        return this.getContext().getLayoutName();
    }

    public int getLayoutID() {
        return this.getContext().getLayoutID();
    }

    public long getLayoutModCount() {
        return this.getContext().getLayoutModCount();
    }

    public String getUserName() {
        return this.getContext().getUserName();
    }

    public String getAccountName() {
        String string = this.getContext().getAccountName();
        if ("[\ue002]".equals(string)) {
            string = "[ Guest ]";
        }
        return string;
    }

    protected Context getContext() {
        if (this.currentContext == null) {
            throw new AppRuntimeException("There is no context available. Call open(auth, databaseName) first to establish the context.");
        }
        return this.currentContext;
    }

    public void shutDown() {
        this.helper.setCloseComplete();
        this.taskFactory.shutDown();
        this.getterTaskFactory.shutDown();
        this.sessionBlocking.close();
        this.hasSession = false;
        this.currentContext = null;
        this.hasLoggedIn = false;
        this.app = null;
    }

    private void executeTask(ActionTask actionTask, boolean bl) {
        if (logger.isDebugLoggingEnabled()) {
            logger.debug(String.format("executeTask(ActionTask=%s,  deferred=%s)", actionTask, bl));
        }
        if (this.helper.available()) {
            this.helper.execute(actionTask, null, false);
        } else if (bl) {
            this.helper.queue(actionTask);
        } else {
            this.helper.warn(actionTask.getName());
        }
    }

    public IWPError enterContainerObject(ObjectSpec objectSpec, boolean bl) throws AppRuntimeException {
        return this.sessionBlocking.enterContainerObject(this.currentContext, objectSpec, bl);
    }

    public boolean hasReceivedCloseRequestNotification() {
        return this.hasReceivedCloseRequestNotification;
    }

    public void setReceivedCloseRequestNotification(boolean bl) {
        this.hasReceivedCloseRequestNotification = bl;
    }

    public boolean isBlockingActionRunning() {
        return this.sessionBlocking.isBlockingActionRunning();
    }

    public String toString() {
        return String.format("[context=%s, config=%s, timeout=%s]", this.currentContext, this.config, timeout);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SessionInfo createSession() {
        ServiceClient serviceClient;
        if (this.app != null) {
            ServiceClient serviceClient2 = serviceClient = this.app.getSessionContext() != null ? this.app.getSessionContext().getSessionInfo() : null;
            if (serviceClient != null) {
                return serviceClient;
            }
        }
        serviceClient = ServiceClientPoolLiaison.getClient(5600);
        try {
            SessionInfo sessionInfo = serviceClient.getClient().createSession();
            return sessionInfo;
        }
        catch (TException tException) {
            serviceClient.setReset();
            this.app.showCommunicationError();
            SessionInfo sessionInfo = null;
            return sessionInfo;
        }
        finally {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    public void open(ActionResultGetterHandler actionResultGetterHandler, Credentials credentials, boolean bl, int n) throws AppRuntimeException {
        int n2 = this.getSessionID();
        GetterActionTask getterActionTask = this.getterTaskFactory.openTask(actionResultGetterHandler, n2, credentials, bl, n);
        this.executeTask(getterActionTask, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceDBSessionClose() {
        if (!this.hasBeenForcedClosed) {
            this.hasBeenForcedClosed = true;
            ServiceClient serviceClient = null;
            ServiceClientFaucet serviceClientFaucet = null;
            if (ServiceClientPoolLiaison.availableClientCount() > 3) {
                serviceClient = ServiceClientPoolLiaison.getClient(5601);
            } else {
                serviceClientFaucet = new ServiceClientFaucet();
                serviceClient = serviceClientFaucet.getClient(5701);
            }
            boolean bl = false;
            try {
                serviceClient.getClient().forceSessionClose(this.getCurrentContext());
                if (serviceClientFaucet != null) {
                    serviceClientFaucet.putClient(serviceClient);
                } else {
                    ServiceClientPoolLiaison.putClient(serviceClient);
                }
                bl = true;
            }
            catch (TException tException) {
                if (serviceClient != null) {
                    serviceClient.setReset();
                }
                this.app.showCommunicationError();
            }
            finally {
                if (!bl) {
                    if (serviceClientFaucet != null) {
                        serviceClientFaucet.putClient(serviceClient);
                        serviceClientFaucet = null;
                    } else {
                        ServiceClientPoolLiaison.putClient(serviceClient);
                    }
                }
            }
        }
    }

    public void attemptSessionLogOut() throws AppRuntimeException {
        if (!this.hasBeenForcedClosed) {
            ActionTask actionTask = this.taskFactory.attemptSessionCloseTask(this.currentContext);
            this.executeTask(actionTask, true);
        }
    }

    public void patchZombieSessionToClose(int n) {
        Context context = this.getCurrentContext();
        context.setSessionID(n);
        this.hasLoggedIn = true;
        this.hasSession = true;
    }

    public void onUIAction(UIActionType uIActionType, boolean bl) throws AppRuntimeException {
        Context context = null;
        switch (uIActionType) {
            case GOTO_NEXT_FIELD: 
            case GOTO_PREV_FIELD: {
                context = this.getNextActionContext();
                this.app.getActiveUIHandler().setPendingTabbingTaskId(context.getTaskId());
                break;
            }
            default: {
                context = this.currentContext;
            }
        }
        ActionTask actionTask = this.taskFactory.onUIActionTask(context, uIActionType);
        this.executeTask(actionTask, bl);
    }

    public void gotoLayout(String string, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.gotoLayoutTask(string);
        this.executeTask(actionTask, bl);
    }

    public void gotoLayoutById(int n, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.gotoLayoutByIdTask(n);
        this.executeTask(actionTask, bl);
    }

    public void enterField(ObjectSpec objectSpec, boolean bl, boolean bl2) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.enterFieldTask(objectSpec, bl);
        this.executeTask(actionTask, bl2);
    }

    public void processClick(ObjectSpec objectSpec, boolean bl, boolean bl2, boolean bl3, int n, int n2, boolean bl4) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.processClickTask(objectSpec, bl, bl2, bl3, n, n2);
        this.executeTask(actionTask, bl4);
    }

    public void commitRecord(boolean bl, boolean bl2) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.commitRecordTask(bl);
        this.executeTask(actionTask, bl2);
    }

    public void gotoRow(int n, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.gotoRowTask(n);
        this.executeTask(actionTask, bl);
    }

    public void modifyNonContainerField(FieldObjectData fieldObjectData, boolean bl, boolean bl2) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.modifyNonContainerFieldTask(this.currentContext, fieldObjectData, bl);
        this.executeTask(actionTask, bl2);
    }

    public void insertDateFromCalendar(ObjectSpec objectSpec, DateTime dateTime, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.insertDateFromCalendarTask(this.currentContext, objectSpec, dateTime);
        this.executeTask(actionTask, bl);
    }

    public void insertDate(ObjectSpec objectSpec, String string, int n, int n2, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.insertDateTask(this.currentContext, objectSpec, string, n, n2);
        this.executeTask(actionTask, bl);
    }

    public void insertTime(ObjectSpec objectSpec, String string, int n, int n2, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.insertTimeTask(this.currentContext, objectSpec, string, n, n2);
        this.executeTask(actionTask, bl);
    }

    public void insertCurrentUsername(ObjectSpec objectSpec, int n, int n2, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.insertCurrentUsernameTask(this.currentContext, objectSpec, n, n2);
        this.executeTask(actionTask, bl);
    }

    public void clearFieldContents(ObjectSpec objectSpec, int n, int n2, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.clearFieldContentsTask(this.currentContext, objectSpec, n, n2);
        this.executeTask(actionTask, bl);
    }

    public void executeButtonScript(int n, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.executeButtonScriptTask(n);
        this.executeTask(actionTask, bl);
    }

    public void executeScriptById(int n, int n2, int n3, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.executeScriptByIdTask(n, n2, n3);
        this.executeTask(actionTask, bl);
    }

    public void executeScriptByName(String string, String string2, String string3, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.executeScriptByNameTask(string, string2, string3);
        this.executeTask(actionTask, bl);
    }

    public void quickFind(String string, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.quickFindTask(string);
        this.executeTask(actionTask, bl);
    }

    public void switchTabs(ActionResultHandler actionResultHandler, ObjectSpec objectSpec, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.switchTabsTask(actionResultHandler, objectSpec);
        this.executeTask(actionTask, bl);
    }

    public synchronized void abortLongOperation() throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.abortLongOperationTask();
        Executors.runSessionTask(actionTask);
    }

    public synchronized void abortLongRunningScript() throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.abortLongRunningScriptTask();
        Executors.runSessionTask(actionTask);
    }

    public void getCurrentRow(ActionResultGetterHandler actionResultGetterHandler, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getCurrentRowTask(actionResultGetterHandler, bl);
        this.executeTask(getterActionTask, true);
    }

    public void getDataForCurrentPart(ActionResultGetterHandler actionResultGetterHandler, int n, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getDataForCurrentPartTask(actionResultGetterHandler, n, bl);
        this.executeTask(getterActionTask, true);
    }

    public void getValueListSubset(ActionResultGetterHandler actionResultGetterHandler, ValueListSubsetRequest valueListSubsetRequest) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getValueListSubsetTask(actionResultGetterHandler, valueListSubsetRequest);
        this.executeTask(getterActionTask, true);
    }

    public void getValueListSubsets(ActionResultGetterHandler actionResultGetterHandler, List<ValueListSubsetRequest> list) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getValueListSubsetsTask(actionResultGetterHandler, list);
        this.executeTask(getterActionTask, true);
    }

    public void getFilteredValueListSubset(ActionResultGetterHandler actionResultGetterHandler, FilteredValueListSubsetRequest filteredValueListSubsetRequest) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getFilteredValueListSubset(actionResultGetterHandler, filteredValueListSubsetRequest);
        this.executeTask(getterActionTask, true);
    }

    public void getFilteredValueListSubsets(ActionResultGetterHandler actionResultGetterHandler, List<FilteredValueListSubsetRequest> list) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getFilteredValueListSubset(actionResultGetterHandler, list);
        this.executeTask(getterActionTask, true);
    }

    public void getValueListItemByValue(ActionResultGetterHandler actionResultGetterHandler, ValueListItemRequest valueListItemRequest) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getValueListItemByValue(actionResultGetterHandler, valueListItemRequest);
        this.executeTask(getterActionTask, true);
    }

    public void getValueListItemsByValues(ActionResultGetterHandler actionResultGetterHandler, List<ValueListItemRequest> list) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getValueListItemsByValues(actionResultGetterHandler, list);
        this.executeTask(getterActionTask, true);
    }

    public void getListRows(ActionResultGetterHandler actionResultGetterHandler, int n, int n2, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getListRowsTask(actionResultGetterHandler, n, n2, bl);
        this.executeTask(getterActionTask, true);
    }

    public void getPortalRowsCount(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, boolean bl, int n, int n2) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getPortalRowsCountTask(actionResultGetterHandler, objectSpec, bl, n, n2);
        this.executeTask(getterActionTask, true);
    }

    public void getPortalRows(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, int n, int n2, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getPortalRowsTask(actionResultGetterHandler, objectSpec, n, n2, bl);
        this.executeTask(getterActionTask, true);
    }

    public void getLayoutObjectsData(ActionResultGetterHandler actionResultGetterHandler, int n, int n2, Set<Integer> set) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getLayoutObjectsDataTask(actionResultGetterHandler, n, n2, set);
        this.executeTask(getterActionTask, true);
    }

    public void getPortalLayoutObjectsData(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, int n, int n2, boolean bl, Set<Integer> set) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getPortalLayoutObjectsDataTask(actionResultGetterHandler, objectSpec, n, n2, bl, set);
        this.executeTask(getterActionTask, true);
    }

    public void getLayoutObjectTooltip(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getLayoutObjectTooltipTask(actionResultGetterHandler, objectSpec);
        this.executeTask(getterActionTask, true);
    }

    public void getFieldObjectData(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, FieldSpec fieldSpec, BinaryDataOptions binaryDataOptions, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getFieldObjectDataTask(actionResultGetterHandler, objectSpec, fieldSpec, binaryDataOptions, bl);
        this.executeTask(getterActionTask, true);
    }

    public void getSelectedPanel(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, int n) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getSelectedPanelTask(actionResultGetterHandler, objectSpec, n);
        this.executeTask(getterActionTask, true);
    }

    public void getTabWidthsAndStartPosition(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec, Map<Integer, Integer> map, int n, int n2, int n3, boolean bl) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getTabWidthsAndStartPositionTask(actionResultGetterHandler, objectSpec, map, n, n2, n3);
        this.executeTask(getterActionTask, bl);
    }

    public void getConditionalFormatting(ActionResultGetterHandler actionResultGetterHandler, ObjectSpec objectSpec) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getConditionalFormattingTask(actionResultGetterHandler, objectSpec);
        this.executeTask(getterActionTask, true);
    }

    public void getDataForCurrentPopover(ActionResultGetterHandler actionResultGetterHandler, int n, int n2, int n3) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getDataForCurrentPopoverTask(actionResultGetterHandler, n, n2, n3);
        this.executeTask(getterActionTask, true);
    }

    public void insertUploadedFileIntoContainer(String string, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.insertUploadedFileIntoContainerTask(string, bl);
        this.executeTask(actionTask, true);
    }

    public void browserResized() throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.browserResizedTask();
        this.executeTask(actionTask, true);
    }

    public void browserResizedWithActiveField(FieldObjectData fieldObjectData) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.browserResizedWithActiveFieldTask(fieldObjectData);
        this.executeTask(actionTask, true);
    }

    public String getUploadDirPath() {
        return this.uploadDirPath;
    }

    public void clientStartProcessing(ActionResultHandler actionResultHandler, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.clientStartProcessingTask(actionResultHandler);
        this.executeTask(actionTask, bl);
    }

    public void clientDoneProcessing(ActionResultHandler actionResultHandler, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.clientDoneProcessingTask(actionResultHandler);
        this.executeTask(actionTask, bl);
    }

    public void refreshWindow(int n, int n2, boolean bl) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.refreshWindowTask(this.currentContext, n, n2);
        this.executeTask(actionTask, bl);
    }

    public void getActiveRowState(boolean bl, boolean bl2) throws AppRuntimeException {
        GetterActionTask getterActionTask = this.getterTaskFactory.getActiveRowState(bl, bl2);
        this.executeTask(getterActionTask, true);
    }

    public void handleKeystroke(ActionResultHandler actionResultHandler, KeystrokeEvent keystrokeEvent) throws AppRuntimeException {
        ActionTask actionTask = this.taskFactory.handleKeystrokeTask(keystrokeEvent, actionResultHandler);
        this.executeTask(actionTask, true);
    }
}

