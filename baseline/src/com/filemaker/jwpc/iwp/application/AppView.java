/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.AbstractClientConnector
 *  com.vaadin.server.VaadinService
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.Label
 *  com.vaadin.ui.Notification
 *  com.vaadin.ui.Window
 *  org.vaadin.peter.contextmenu.ContextMenu$ContextMenuClosedEvent
 *  org.vaadin.peter.contextmenu.ContextMenu$ContextMenuClosedListener
 *  org.vaadin.peter.contextmenu.ContextMenu$ContextMenuItem
 *  org.vaadin.peter.contextmenu.ContextMenu$ContextMenuItemClickEvent
 *  org.vaadin.peter.contextmenu.ContextMenu$ContextMenuItemClickListener
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.fields.FMField;
import com.filemaker.jwpc.iwp.action.ActionManager;
import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.ActiveUIHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.application.AppContainer;
import com.filemaker.jwpc.iwp.application.AppController;
import com.filemaker.jwpc.iwp.application.AppJavaScriptComponent;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.css.FMCommunicationComponent;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.DatabaseDataModel;
import com.filemaker.jwpc.iwp.model.LayoutDataModel;
import com.filemaker.jwpc.iwp.model.Privileges;
import com.filemaker.jwpc.iwp.notification.processor.NotificationProcessor;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.ContextResult;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DatabaseState;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.SessionDisconnectType;
import com.filemaker.jwpc.iwp.thrift.common.SessionInfo;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.notification.OpenDatabaseNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.component.FileDownloadDialog;
import com.filemaker.jwpc.iwp.ui.component.IWPContextMenu;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventBus;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.event.UIEventSubscriber;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.ObscuredEditBox;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.layout.listener.KeystrokeScriptTriggerListener;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.listener.StatusAreaListenerInitiator;
import com.filemaker.jwpc.iwp.ui.statusarea.menubar.MenubarComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.LayoutEditor;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.Messenger;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperTools;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationClientRpc;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.log.LogData;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Set;
import org.vaadin.peter.contextmenu.ContextMenu;

public class AppView
extends CssLayout
implements UIEventSubscriber {
    protected static final JWPCLogger LOGGER = JWPCLogger.getLogger(AppView.class);
    protected final Object notificationExecutorLock = new Object();
    protected final App app;
    private boolean bCardStyleWindow = false;
    private boolean bIgnoreKeystrokeErrorForCardWin = false;
    protected AppContainer appContainer = null;
    protected AppCardWindowContainer appCardStyleContainer = null;
    private final AppJavaScriptComponent appJavaScriptComponent;
    private final FMCommunicationComponent communicationComponent;
    protected int sessionId;
    protected ActiveUIHandler activeUIHandler;
    protected AppController appController;
    protected Messenger messenger;
    protected FileDownloadDialog fileDownloadDialog;
    protected Service service;
    protected Session session;
    protected String currentDatabaseName = "";
    protected String currentUserName = "";
    protected String currentAccountName = "";
    protected boolean showStatusArea = true;
    private boolean isDialogOn = false;
    private boolean isDatabaseSwitch = false;
    protected int dbOption;
    protected final DeveloperTools developerTools;
    private Credentials cred = null;
    protected IWPContextMenu contextMenu;
    private IWPContextMenu fieldContextMenu;
    private ContextMenu.ContextMenuItem copyMenuItem;
    private ContextMenu.ContextMenuItem pasteMenuItem;
    protected ContextMenu.ContextMenuItem insertMenuItem;
    protected ContextMenu.ContextMenuItem exportMenuItem;
    protected ContextMenu.ContextMenuItem viewZoomedMenuItem;
    protected ContextMenu.ContextMenuItem clearMenuItem;
    private boolean isPasteEnabled = false;
    private boolean isCopyEnabled = false;
    public static final String COPY_STYLE_NAME = "Copy";
    public static final String PASTE_STYLE_NAME = "Paste";
    private Dialog currentVisibleDialog;
    private KeystrokeScriptTriggerListener keyTriggerListener;
    private boolean keystrokeScriptTriggerListenerAtLayout = false;

    public AppView(App app) {
        this.app = app;
        this.appJavaScriptComponent = new AppJavaScriptComponent(this.app);
        this.communicationComponent = new FMCommunicationComponent(app);
        this.developerTools = new DeveloperTools(this.app);
        this.addComponent((Component)this.appJavaScriptComponent);
        this.addComponent((Component)this.communicationComponent);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            Label label = new Label("<h1>hidden h1 header</h1>", ContentMode.HTML);
            label.addStyleName("v-caption-sr-only-caption-title-and-help");
            this.addComponent((Component)label);
        }
        this.setSizeFull();
        this.init();
        if (VaadinService.getCurrentRequest().getParameter("-hidestatusarea") == "") {
            this.showStatusArea = false;
        }
    }

    protected void init() {
        this.initWidgets();
        this.initSession();
    }

    private void initWidgets() {
        this.activeUIHandler = new ActiveUIHandler(this.app);
        this.messenger = new Messenger(this.app);
        this.appController = new AppController(this.app);
    }

    private void initSession() {
        this.service = Service.getInstance();
        this.session = this.service.getSession(this.app);
    }

    protected void loginDatabase(Credentials credentials, boolean bl, int n) {
        if (!this.hasValidSession()) {
            this.createSessionAndOpenDatabase(credentials, bl, n);
        } else {
            this.openDatabase(credentials, bl, n);
        }
    }

    private void createSessionAndOpenDatabase(Credentials credentials, boolean bl, int n) {
        SessionInfo sessionInfo = this.session.createSession();
        if (sessionInfo != null) {
            if (!IWPUtilities.isValidSessionID(sessionInfo.getSessionId())) {
                throw new AppRuntimeException("Could not create session for this user");
            }
            AppController.getAllActiveApp().put(sessionInfo.getSessionId(), this.app);
            this.session.updateSession(sessionInfo.getSessionId(), sessionInfo.getTimeout(), sessionInfo.getUploadDirectoryPath());
            this.openDatabase(credentials, bl, n);
        }
    }

    public boolean getRetinaDisplay() {
        return this.appJavaScriptComponent.getRetinaDisplay();
    }

    private void openDatabase(final Credentials credentials, boolean bl, int n) {
        if (!this.hasValidSession()) {
            throw new AppRuntimeException("Not authenticated yet. Call authenticate() first");
        }
        this.session.open(new ActionResultGetterHandler(){
            final /* synthetic */ AppView this$0;
            {
                this.this$0 = appView;
            }

            @Override
            public void onFinish(Object object) {
                int n = ((ContextResult)object).getError().getErrorCode();
                if (n != 0) {
                    if (this.this$0.app.getLogoutURL() != null && !this.this$0.app.hasCustomLoginHandler()) {
                        this.this$0.app.getPage().setLocation(this.this$0.app.getLogoutURL());
                    } else {
                        try {
                            this.this$0.app.setLoginError(n, ((ContextResult)object).getContext().isGuestEnabled());
                            FMRequestManager.handleLoginError(this.this$0.app, credentials);
                        }
                        catch (MalformedURLException malformedURLException) {
                            malformedURLException.printStackTrace();
                        }
                    }
                } else {
                    this.this$0.app.setNativeLogin(false);
                    this.this$0.app.setLoginError(0, false);
                }
            }
        }, credentials, bl, n);
    }

    protected void openDatabaseComplete(Context context, OpenDatabaseNotification openDatabaseNotification) {
        if (openDatabaseNotification.getState() != DatabaseState.Open) {
            throw new AppRuntimeException("The database " + context.getDatabaseName() + " is not in open state at server!");
        }
        this.setStreamingCookie(openDatabaseNotification.getStreamSessionKey());
        this.setConfirmLogout(true);
        this.session.updateContext(true, context);
        this.sessionId = this.session.getSessionID();
        this.dbOption = openDatabaseNotification.getOption();
        this.getDatabaseDataModel().updateToolbarsVisiblity(context.isStatusAreaToolbarVisible(), context.isMenubarVisible());
        this.showAppScreen(context.getDatabaseName(), false);
        this.app.getPage().setTitle(IWPUtilities.getTitle(this.app, context.getDatabaseName(), this.session.getSessionID()));
        this.app.getURIHandler().performPostLogin(context.getDatabaseName());
        this.performPostLogin();
        this.app.focus();
        this.app.printWpeConfigLog();
        this.logData("User " + this.currentUserName + "(" + this.currentAccountName + ") has been signed in to database " + this.currentDatabaseName + ".");
    }

    private void performPostLogin() {
        this.currentDatabaseName = this.session.getDatabaseName();
        this.currentUserName = this.session.getUserName();
        this.currentAccountName = this.session.getAccountName();
        this.appJavaScriptComponent.setClientId(this.sessionId);
        this.updateShortcutHandlingOnClient(true);
        this.updateIsFindModeOnClient(false);
        this.appController.start();
        if (IWPUtilities.isDebugMode() && this.app.getLayoutDataModel().isModeSet()) {
            this.developerTools.registerDeveloperMenu(this, this.appContainer.getStatusAreaContainer().getMainMenuBar().getAccountMenu());
        }
    }

    protected void attemptSessionLogout() {
        if (this.session != null) {
            this.session.attemptSessionLogOut();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onSessionCloseSuccess(boolean bl, boolean bl2, SessionDisconnectType sessionDisconnectType) {
        VaadinSession vaadinSession = this.app.getSession();
        if (vaadinSession != null) {
            vaadinSession.lock();
            try {
                if (this.app.getSession() != vaadinSession) return;
                if (bl) {
                    LayoutContainer layoutContainer;
                    this.closeCurrentDialog();
                    this.closeAllDialogs();
                    this.messenger.closeAllUI();
                    if (this.appContainer != null && (layoutContainer = this.getLayoutContainer()) != null) {
                        layoutContainer.getPopoverHandler().exitPopover(false);
                    }
                }
                this.closeDBSession();
                if (this.appCardStyleContainer != null) {
                    this.appCardStyleContainer.cleanupMemory();
                    this.appContainer = null;
                }
                if (this.appContainer != null) {
                    this.removeComponent((Component)this.appContainer);
                    this.appContainer.cleanupMemory();
                    this.appContainer = null;
                }
                if (bl) {
                    this.performPostLogout();
                    this.app.redirectToLogoutURL(sessionDisconnectType);
                }
                this.disableKeystrokeListener();
                return;
            }
            catch (AppRuntimeException appRuntimeException) {
                if (!bl) return;
                Notification.show((String)appRuntimeException.getMessage());
                return;
            }
            finally {
                vaadinSession.unlock();
            }
        } else {
            this.closeDBSession();
        }
    }

    private void performPostLogout() {
        this.appJavaScriptComponent.setClientId(-1);
        this.updateShortcutHandlingOnClient(false);
        this.updateIsFindModeOnClient(false);
        ((FMCommunicationClientRpc)this.getRpcProxy(FMCommunicationClientRpc.class)).reset();
        this.initWidgets();
        this.initSession();
    }

    public void showAppScreen(String string, boolean bl) {
        this.bCardStyleWindow = bl;
        if (!bl) {
            if (this.getComponentIndex((Component)this.appContainer) == -1) {
                this.appContainer = new AppContainer(this.app, string);
                this.appContainer.initUI();
                this.addComponent((Component)this.appContainer);
            }
        } else if (this.appCardStyleContainer == null) {
            this.appCardStyleContainer = new AppCardWindowContainer(this.app, string);
            this.appCardStyleContainer.initUI();
        }
    }

    public boolean isCardStyleWindow() {
        return this.bCardStyleWindow;
    }

    public void setCardStyleWindow(boolean bl) {
        this.bCardStyleWindow = bl;
    }

    private void closeDBSession() {
        if (this.isDatabaseOpen()) {
            int n = this.session.getSessionID();
            this.appController.clear(n);
            this.session.shutDown();
            this.session = null;
            this.appCardStyleContainer = null;
            this.destroyContextMenu();
            this.destroyfieldContextMenu();
            this.logData("User " + this.currentUserName + "(" + this.currentAccountName + ") has been signed out from database " + this.currentDatabaseName + ".");
        }
    }

    protected void logData(String string) {
        LogData logData = new LogData();
        logData.setMessage(string);
        LOGGER.info(logData);
    }

    public void closeContextMenu() {
        if (this.contextMenu != null) {
            this.contextMenu.hide();
        }
        if (this.fieldContextMenu != null) {
            this.fieldContextMenu.hide();
        }
    }

    protected void initContextMenu(boolean bl) {
        if (!bl) {
            if (this.contextMenu == null) {
                this.contextMenu = new IWPContextMenu();
                this.insertMenuItem = this.contextMenu.addItem(IWPI18N.get(this.app, "INSERT_INTO_CONTAINER", new Object[0]));
                this.exportMenuItem = this.contextMenu.addItem(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS", new Object[0]));
                this.viewZoomedMenuItem = this.contextMenu.addItem(IWPI18N.get(this.app, "VIEW_ZOOMED_IMAGE", new Object[0]));
                this.clearMenuItem = this.contextMenu.addItem(IWPI18N.get(this.app, "CLEAR", new Object[0]));
                this.contextMenu.addItemClickListener(new ContextMenu.ContextMenuItemClickListener(){

                    public void contextMenuItemClicked(ContextMenu.ContextMenuItemClickEvent contextMenuItemClickEvent) {
                        ContextMenu.ContextMenuItem contextMenuItem = (ContextMenu.ContextMenuItem)contextMenuItemClickEvent.getSource();
                        if (contextMenuItem == AppView.this.insertMenuItem) {
                            GlobalUIActionHandlers.ContainerInsertAction containerInsertAction = GlobalUIActionHandlers.SHOW_INSERT_INTO_CONTAINER_DIALOG;
                            containerInsertAction.perform(AppView.this.app, null);
                        } else if (contextMenuItem == AppView.this.exportMenuItem) {
                            UIAction uIAction = AppView.this.getAM().getAction(UIActionType.EXPORT_FIELD_CONTENTS);
                            uIAction.perform(AppView.this.app, null);
                        } else if (contextMenuItem == AppView.this.viewZoomedMenuItem) {
                            GlobalUIActionHandlers.ShowZoomedImageAction showZoomedImageAction = GlobalUIActionHandlers.VIEW_ZOOMED_IMAGE;
                            showZoomedImageAction.perform(AppView.this.app, null);
                        } else if (contextMenuItem == AppView.this.clearMenuItem) {
                            GlobalUIActionHandlers.ClearAction clearAction = GlobalUIActionHandlers.CLEAR_FIELD_CONTENTS;
                            clearAction.perform(AppView.this.app, null);
                        } else {
                            AppView.this.app.getMessenger().showTrayMessage("Unwired Action : " + contextMenuItem.toString());
                        }
                    }
                });
            }
            this.contextMenu.setAsContextMenuOf((AbstractClientConnector)this);
        } else {
            if (this.fieldContextMenu == null) {
                this.fieldContextMenu = new IWPContextMenu();
                this.copyMenuItem = this.fieldContextMenu.addItem(IWPI18N.get(this.app, "COPY", new Object[0]));
                this.copyMenuItem.addStyleName(COPY_STYLE_NAME);
                this.pasteMenuItem = this.fieldContextMenu.addItem(IWPI18N.get(this.app, "PASTE", new Object[0]));
                this.pasteMenuItem.addStyleName(PASTE_STYLE_NAME);
                this.fieldContextMenu.addContextMenuCloseListener(new ContextMenu.ContextMenuClosedListener(){

                    public void onContextMenuClosed(ContextMenu.ContextMenuClosedEvent contextMenuClosedEvent) {
                        FMField fMField;
                        LayoutFieldObject layoutFieldObject = AppView.this.app.getActiveUIHandler().getActiveField(false, false);
                        if (layoutFieldObject instanceof FMField && (fMField = (FMField)((Object)layoutFieldObject)) != null) {
                            fMField.setResetScrollPositionOnExit(true);
                        }
                    }
                });
            }
            this.fieldContextMenu.setAsContextMenuOf((AbstractClientConnector)this);
        }
    }

    protected void destroyContextMenu() {
        this.insertMenuItem = null;
        this.exportMenuItem = null;
        this.viewZoomedMenuItem = null;
        this.clearMenuItem = null;
        if (this.contextMenu != null) {
            this.contextMenu.remove();
            this.contextMenu = null;
        }
    }

    protected void destroyfieldContextMenu() {
        this.copyMenuItem = null;
        this.pasteMenuItem = null;
        if (this.fieldContextMenu != null) {
            this.fieldContextMenu.remove();
            this.fieldContextMenu = null;
        }
    }

    public void updatedContextMenuEnabledness() {
        Container container;
        Privileges privileges = this.app.getPrivileges();
        boolean bl = privileges.isCommandEnabled(34);
        GlobalUIActionHandlers.ClearAction clearAction = GlobalUIActionHandlers.CLEAR_FIELD_CONTENTS;
        boolean bl2 = ((UIAction)clearAction).isEnabledFor(this.app);
        boolean bl3 = false;
        boolean bl4 = false;
        ObjectMetaData objectMetaData = this.app.getActiveUIHandler().getActiveObjectMetaData();
        if (objectMetaData != null && objectMetaData.isContainer() && (container = this.app.getActiveContainerField(true)) != null) {
            bl3 = bl2;
            boolean bl5 = bl4 = bl && container.isImageZoomEnabled();
            if (bl && container.isFileReference()) {
                bl = false;
            }
        }
        if (this.contextMenu != null) {
            this.insertMenuItem.setEnabled(bl3);
            this.exportMenuItem.setEnabled(bl);
            this.viewZoomedMenuItem.setEnabled(bl4);
            this.clearMenuItem.setEnabled(bl2);
        }
        if (!this.bCardStyleWindow) {
            this.appContainer.getMenubar().findMenuItem(IWPI18N.get(this.app, "INSERT_INTO_CONTAINER", new Object[0])).getMenuItem().setEnabled(bl3);
            this.appContainer.getMenubar().findMenuItem(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS", new Object[0])).getMenuItem().setEnabled(bl);
            this.appContainer.getMenubar().findMenuItem(IWPI18N.get(this.app, "VIEW_ZOOMED_IMAGE", new Object[0])).getMenuItem().setEnabled(bl4);
            this.appContainer.getMenubar().findMenuItem(IWPI18N.get(this.app, "CLEAR", new Object[0])).getMenuItem().setEnabled(bl2);
        }
    }

    public void updatedFieldContextMenuState(LayoutFieldObject layoutFieldObject, int n) {
        this.isPasteEnabled = false;
        this.isCopyEnabled = false;
        Privileges privileges = this.app.getPrivileges();
        this.handleMenuState(layoutFieldObject, privileges, n);
    }

    private void handleMenuState(LayoutFieldObject layoutFieldObject, Privileges privileges, int n) {
        boolean bl = false;
        if (layoutFieldObject instanceof ObscuredEditBox) {
            bl = true;
        }
        boolean bl2 = false;
        if (layoutFieldObject != null && layoutFieldObject.getMetaData() != null && (layoutFieldObject.getMetaData().getFieldType() == LayoutFieldType.CALCULATED || layoutFieldObject.getMetaData().getFieldType() == LayoutFieldType.SUMMARY)) {
            bl2 = true;
        }
        this.handleMenuItemState(bl, n, privileges, bl2);
    }

    private void handleMenuItemState(boolean bl, int n, Privileges privileges, boolean bl2) {
        if (bl) {
            this.isCopyEnabled = false;
        } else {
            boolean bl3 = n == 0;
            this.isCopyEnabled = privileges.hasBrowseAccess() && !bl3;
        }
        this.isPasteEnabled = privileges.hasEditAccess() && !bl2;
        if (this.fieldContextMenu != null && this.copyMenuItem != null && this.pasteMenuItem != null) {
            this.copyMenuItem.setEnabled(this.isCopyEnabled);
            this.pasteMenuItem.setEnabled(this.isPasteEnabled);
        }
    }

    protected void setUsername(String string) {
        if (this.cred == null) {
            this.cred = new Credentials();
        }
        this.cred.setUsername(string);
    }

    protected void setPassword(String string) {
        if (this.cred == null) {
            this.cred = new Credentials();
        }
        this.cred.setPassword(string);
    }

    protected String getUsername() {
        return this.cred == null ? null : this.cred.getUsername();
    }

    protected String getPassword() {
        return this.cred == null ? null : this.cred.getPassword();
    }

    protected Credentials getCredentials() {
        return this.cred;
    }

    protected void setCredentials(Credentials credentials) {
        this.cred = credentials;
    }

    protected Service getAppService() {
        return this.service;
    }

    protected Session getAppSession() {
        return this.session;
    }

    protected AppContainer getAppContainer() {
        return this.bCardStyleWindow ? this.appCardStyleContainer : this.appContainer;
    }

    public int getCurrentSessionID() {
        return this.sessionId;
    }

    protected ActiveUIHandler getActiveUIHandler() {
        return this.activeUIHandler;
    }

    protected static Set<Integer> getAllClientIDs() {
        return AppController.getAllActiveApp().keySet();
    }

    protected NotificationProcessor getNotificationProcessor() {
        return this.appController.getNotificationProcessor();
    }

    protected Messenger getMessenger() {
        return this.messenger;
    }

    public FileDownloadDialog getFileDownloadDialog() {
        if (this.fileDownloadDialog == null) {
            this.fileDownloadDialog = new FileDownloadDialog(this.app);
        }
        return this.fileDownloadDialog;
    }

    public boolean isDialogOn() {
        return this.isDialogOn;
    }

    public void setDialogOn(boolean bl, Dialog dialog) {
        this.isDialogOn = bl;
        if (bl) {
            this.currentVisibleDialog = dialog;
            this.app.getActiveUIHandler().trySuspendActiveComboBox();
        } else {
            this.currentVisibleDialog = null;
            this.app.getActiveUIHandler().tryResumeComboBox();
        }
    }

    public void centerCurrentDialog() {
        if (this.isDialogOn() && this.currentVisibleDialog != null && this.currentVisibleDialog.isVisible()) {
            this.currentVisibleDialog.center();
        }
    }

    public void closeCurrentDialog() {
        if (this.isDialogOn() && this.currentVisibleDialog != null && this.currentVisibleDialog.isVisible()) {
            this.currentVisibleDialog.closeAndCancelDialog();
        }
    }

    public void closeAllDialogs() {
        ArrayList<Dialog> arrayList = new ArrayList<Dialog>();
        for (Window window : this.app.getWindows()) {
            if (!(window instanceof Dialog)) continue;
            arrayList.add((Dialog)window);
        }
        while (arrayList.size() > 0) {
            Dialog dialog = (Dialog)((Object)arrayList.remove(0));
            dialog.closeAndCancelDialog();
        }
    }

    public void setDatabaseSwitch(boolean bl) {
        this.isDatabaseSwitch = bl;
    }

    public boolean isDatabaseSwitch() {
        return this.isDatabaseSwitch;
    }

    @Override
    public void subscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        if (!(uIEventListener instanceof LayoutObject)) {
            if (uIEventListener instanceof StatusAreaComponent) {
                this.appController.getStatusAreaUIEventBus().subscribe(uIEventListener, eventTypeArray);
            } else if (uIEventListener instanceof MenubarComponent) {
                this.appController.getMenubarUIEventBus().subscribe(uIEventListener, eventTypeArray);
            } else {
                this.appController.getGlobalUIEventBus().subscribe(uIEventListener, eventTypeArray);
            }
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("ERROR: Should not be calling AppView.subscribe(UIEventListener listener, EventType... types)");
            Thread.dumpStack();
        }
    }

    @Override
    public void subscribeAllType(UIEventListener uIEventListener) {
        if (!(uIEventListener instanceof LayoutObject)) {
            if (uIEventListener instanceof StatusAreaComponent) {
                this.appController.getStatusAreaUIEventBus().subscribeAllType(uIEventListener);
            } else if (uIEventListener instanceof MenubarComponent) {
                this.appController.getMenubarUIEventBus().subscribeAllType(uIEventListener);
            } else {
                this.appController.getGlobalUIEventBus().subscribeAllType(uIEventListener);
            }
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("ERROR: Should not be calling AppView.subscribeAllType(UIEventListener listener)");
            Thread.dumpStack();
        }
    }

    @Override
    public void unsubscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        if (!(uIEventListener instanceof LayoutObject)) {
            if (uIEventListener instanceof StatusAreaComponent) {
                this.appController.getStatusAreaUIEventBus().unsubscribe(uIEventListener, eventTypeArray);
            } else if (uIEventListener instanceof MenubarComponent) {
                this.appController.getMenubarUIEventBus().unsubscribe(uIEventListener, eventTypeArray);
            } else {
                this.appController.getGlobalUIEventBus().unsubscribe(uIEventListener, eventTypeArray);
            }
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("ERROR: Should not be calling AppView.unsubscribe(UIEventListener listener, EventType... types)");
            Thread.dumpStack();
        }
    }

    @Override
    public void unsubscribeAllType(UIEventListener uIEventListener) {
        if (!(uIEventListener instanceof LayoutObject)) {
            if (uIEventListener instanceof StatusAreaComponent) {
                this.appController.getStatusAreaUIEventBus().unsubscribeAllType(uIEventListener);
            } else if (uIEventListener instanceof MenubarComponent) {
                this.appController.getMenubarUIEventBus().unsubscribeAllType(uIEventListener);
            } else {
                this.appController.getGlobalUIEventBus().unsubscribeAllType(uIEventListener);
            }
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("ERROR: Should not be calling AppView.unsubscribe(UIEventListener listener, EventType... types)");
            Thread.dumpStack();
        }
    }

    @Override
    public void unsubscribeAllListeners() {
        this.appController.getGlobalUIEventBus().unsubscribeAllListeners();
        this.appController.getStatusAreaUIEventBus().unsubscribeAllListeners();
        this.appController.getMenubarUIEventBus().unsubscribeAllListeners();
        UIEventBus uIEventBus = this.getCurrentViewEventBus();
        if (uIEventBus != null) {
            uIEventBus.unsubscribeAllListeners();
        }
    }

    @Override
    public void clearUIEventListeners() {
        this.appController.getGlobalUIEventBus().clearUIEventListeners();
        this.appController.getStatusAreaUIEventBus().clearUIEventListeners();
        this.appController.getMenubarUIEventBus().clearUIEventListeners();
        UIEventBus uIEventBus = this.getCurrentViewEventBus();
        if (uIEventBus != null) {
            uIEventBus.clearUIEventListeners();
        }
    }

    @Override
    public void notify(UIEvent uIEvent) {
        UIEventBus uIEventBus;
        this.appController.getGlobalUIEventBus().notify(uIEvent);
        if (!this.bCardStyleWindow) {
            if (this.app.getAppContainer() != null && this.app.getAppContainer().hasVisibleToolbarStatusAreaState()) {
                this.appController.getStatusAreaUIEventBus().notify(uIEvent);
            }
            if (this.app.getAppContainer() != null && this.app.getAppContainer().hasVisibleMenubarState()) {
                this.appController.getMenubarUIEventBus().notify(uIEvent);
            }
        }
        if ((uIEventBus = this.getCurrentViewEventBus()) != null) {
            uIEventBus.notify(uIEvent);
        }
    }

    private UIEventBus getCurrentViewEventBus() {
        if (this.getLayoutContainer() != null && this.getLayoutContainer().getCurrentView() != null) {
            return this.getLayoutContainer().getCurrentView().getUIEventBus();
        }
        return null;
    }

    protected String getCurrentDatabaseName() {
        return this.currentDatabaseName;
    }

    public QuickFind getQuickFind() {
        return this.appContainer.getStatusAreaContainer().getToolbar().getQuickFind();
    }

    public LayoutEditor getLayoutEditor() {
        return this.appContainer.getStatusAreaContainer().getToolbar().getLayoutEditor();
    }

    protected Object getNotificationExecutorLock() {
        return this.notificationExecutorLock;
    }

    protected String getCurrentUserName() {
        return this.getAppSession().getUserName();
    }

    protected String getCurrentAccountName() {
        return this.getAppSession().getAccountName();
    }

    protected AppController getAppController() {
        return this.appController;
    }

    protected FMCommunicationComponent getCommunicationComponent() {
        return this.communicationComponent;
    }

    protected boolean showStatusArea() {
        return this.showStatusArea;
    }

    protected boolean hasValidSession() {
        return this.session != null && this.session.hasValidSession();
    }

    protected boolean isLoggedIn() {
        return this.session != null && this.session.isLoggedIn();
    }

    public void updateShortcutHandlingOnClient(boolean bl) {
        this.appJavaScriptComponent.updateShortcutHandlingOnClient(bl);
    }

    protected boolean isDatabaseOpen() {
        return this.appContainer != null && this.hasValidSession() && this.isLoggedIn();
    }

    protected ActionManager getAM() {
        return this.appController.getAM();
    }

    protected LayoutContainer getLayoutContainer() {
        AppContainer appContainer = this.getAppContainer();
        if (appContainer != null) {
            return appContainer.getLayoutContainer();
        }
        return null;
    }

    protected LayoutDataModel getLayoutDataModel() {
        return this.appController.getLayoutDataModel();
    }

    protected DatabaseDataModel getDatabaseDataModel() {
        return this.appController.getDatabaseDataModel();
    }

    protected Privileges getPrivileges() {
        return this.appController.getPrivileges();
    }

    protected StatusAreaListenerInitiator getStatusAreaListenerInitiator() {
        return this.appController.getStatusAreaListenerInitiator();
    }

    protected String getURIFragment() {
        return this.app.getPage().getUriFragment();
    }

    protected boolean isBrowseMode() {
        return this.getCurrentLayoutMode().equals((Object)LayoutMode.BROWSE);
    }

    protected boolean isFindMode() {
        return this.getCurrentLayoutMode().equals((Object)LayoutMode.FIND);
    }

    protected LayoutMode getCurrentLayoutMode() {
        return this.getLayoutDataModel().getMode();
    }

    protected String getApplicationURL() {
        URI uRI = this.app.getPage().getLocation();
        String string = uRI.toString();
        if (string.indexOf(38) > 0) {
            string = string.substring(0, string.indexOf(38));
        }
        return string;
    }

    protected boolean isListView() {
        return this.getLayoutDataModel().getViewStyle().equals((Object)LayoutViewStyle.LIST);
    }

    protected boolean isFormView() {
        return this.getLayoutDataModel().getViewStyle().equals((Object)LayoutViewStyle.FORM);
    }

    protected DeveloperTools getDeveloperTools() {
        return this.developerTools;
    }

    protected Container getActiveContainerField(boolean bl) {
        LayoutFieldObject layoutFieldObject = this.getActiveUIHandler().getActiveField(false, bl);
        if (layoutFieldObject != null && layoutFieldObject instanceof Container) {
            return (Container)layoutFieldObject;
        }
        return null;
    }

    protected void positionContextMenu(int n, int n2, LayoutFieldObject layoutFieldObject) {
        if (this.getContextMenu() != null && layoutFieldObject instanceof Container) {
            this.getContextMenu().prepareToShow(n, n2, layoutFieldObject);
        } else if (this.getfieldContextMenu() != null) {
            this.getfieldContextMenu().prepareToShow(n, n2, layoutFieldObject);
        }
    }

    protected void showContextMenu(LayoutFieldObject layoutFieldObject) {
        if (this.getLayoutDataModel().getMode() == LayoutMode.BROWSE) {
            if (this.getContextMenu() != null && layoutFieldObject instanceof Container) {
                this.getContextMenu().show((Container)layoutFieldObject);
            } else if (this.getfieldContextMenu() != null) {
                this.getfieldContextMenu().show(layoutFieldObject);
            }
        }
    }

    protected IWPContextMenu getContextMenu() {
        return this.contextMenu;
    }

    protected IWPContextMenu getfieldContextMenu() {
        return this.fieldContextMenu;
    }

    public void updateIsFindModeOnClient(boolean bl) {
        this.appJavaScriptComponent.updateIsFindModeOnClient(bl);
    }

    public void tryRemoveActiveFieldInBrowser() {
        this.appJavaScriptComponent.tryRemoveActiveFieldInBrowser();
    }

    public void tryEnableTabKeyHandlingInBrowser() {
        this.appJavaScriptComponent.tryEnableTabKeyHandlingInBrowser();
    }

    public void deselectTextInBrowser() {
        this.appJavaScriptComponent.deselectTextInBrowser();
    }

    public void onEnterPressed(LayoutMode layoutMode, boolean bl) {
        switch (layoutMode) {
            case BROWSE: {
                if (!bl) break;
                GlobalUIActionHandlers.COMMIT_RECORD.perform(this.app, null);
                break;
            }
            case FIND: {
                this.app.getAM().perform(this.app, UIActionType.PERFORM_FIND);
                break;
            }
        }
    }

    public String getLastDatabaseName() {
        return this.currentDatabaseName;
    }

    public String getLastAccountName() {
        return this.currentAccountName;
    }

    private void setStreamingCookie(String string) {
        this.app.setStreamingCookie(string);
    }

    public boolean getQAAEnabled() {
        return (this.dbOption & 1) == 1;
    }

    public boolean isKeystrokeListenerEnabled() {
        return this.keyTriggerListener != null ? this.keyTriggerListener.isEnabled() : false;
    }

    protected void enableKeystrokeListener() {
        if (this.app.isKeystrokeEnabled()) {
            if (this.keyTriggerListener == null) {
                this.keyTriggerListener = new KeystrokeScriptTriggerListener();
            }
            this.keyTriggerListener.setEnabled(true);
            this.appJavaScriptComponent.enableKeyStroke(true);
            this.markAsDirty();
        }
    }

    protected void disableKeystrokeListener() {
        if (this.keyTriggerListener != null) {
            this.keyTriggerListener.setEnabled(false);
            this.appJavaScriptComponent.enableKeyStroke(false);
            this.markAsDirty();
            this.keyTriggerListener = null;
        }
    }

    protected void onKeystroke(String string, int n, boolean bl) {
        if (this.keyTriggerListener != null) {
            this.keyTriggerListener.onKeystroke(string, n, bl);
        }
    }

    protected void setKeystrokeScriptTriggerListenerAtLayout(boolean bl) {
        this.keystrokeScriptTriggerListenerAtLayout = bl;
    }

    protected boolean isKeystrokeScriptTriggerListenerAtLayout() {
        return this.keystrokeScriptTriggerListenerAtLayout;
    }

    protected void revertActiveObjectValue(String string, String string2) {
        this.appJavaScriptComponent.revertActiveObjectValue(string, string2);
    }

    public boolean shouldIgnoreKeystrokeErrorForCardWin() {
        return this.bIgnoreKeystrokeErrorForCardWin;
    }

    public void setFlagForKeystrokeResult(boolean bl) {
        this.bIgnoreKeystrokeErrorForCardWin = bl;
    }

    public void setConfirmLogout(boolean bl) {
        this.appJavaScriptComponent.setConfirmLogout(bl);
    }

    public LayoutFieldObject getActiveField(boolean bl) {
        LayoutFieldObject layoutFieldObject = this.getActiveUIHandler().getActiveField(false, bl);
        if (layoutFieldObject != null && layoutFieldObject instanceof LayoutFieldObject) {
            return layoutFieldObject;
        }
        return null;
    }

    public void updateAriaCompliantControl(boolean bl) {
        this.appJavaScriptComponent.updateAriaCompliantControl(bl);
    }
}

