/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Page$UriFragmentChangedEvent
 *  com.vaadin.server.Page$UriFragmentChangedListener
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.action.ActionManager;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.model.DatabaseDataModel;
import com.filemaker.jwpc.iwp.model.LayoutDataModel;
import com.filemaker.jwpc.iwp.model.Privileges;
import com.filemaker.jwpc.iwp.notification.event.NotificationEventBus;
import com.filemaker.jwpc.iwp.notification.processor.NotificationDialogProcessor;
import com.filemaker.jwpc.iwp.notification.processor.NotificationProcessor;
import com.filemaker.jwpc.iwp.notification.processor.NotificationWebScriptProcessor;
import com.filemaker.jwpc.iwp.ui.cardstylewindow.CardStyleWindowHandler;
import com.filemaker.jwpc.iwp.ui.event.UIEventBus;
import com.filemaker.jwpc.iwp.ui.sharing.SharingWindowHandler;
import com.filemaker.jwpc.iwp.ui.statusarea.listener.StatusAreaListenerInitiator;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.Page;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AppController {
    private static final Map<Integer, App> ALL_ACTIVE_APPS = new ConcurrentHashMap<Integer, App>();
    private final NotificationEventBus notificationEventBus;
    private final NotificationProcessor responseProcessor;
    private final NotificationDialogProcessor dialogProcessor;
    private final NotificationWebScriptProcessor webScriptProcessor;
    private ActionManager actions;
    private UIEventBus globalEventBus;
    private UIEventBus statusAreaEventBus;
    private UIEventBus menubarEventBus;
    private Page.UriFragmentChangedListener fragmentChangedListener;
    private StatusAreaListenerInitiator saListenerInitiator;
    private Privileges privilegeSet;
    private LayoutDataModel layoutDataModel;
    private DatabaseDataModel databaseDataModel;
    private CardStyleWindowHandler cardStyleWindowHandler;
    private SharingWindowHandler sharingWindowHandler;
    private App app;

    public AppController(App app) {
        this.app = app;
        this.notificationEventBus = new NotificationEventBus(app);
        this.responseProcessor = new NotificationProcessor(app);
        this.dialogProcessor = new NotificationDialogProcessor();
        this.webScriptProcessor = new NotificationWebScriptProcessor();
        this.initialize();
    }

    public void initialize() {
        this.actions = new ActionManager(new WeakReference<App>(this.app));
        this.globalEventBus = new UIEventBus();
        this.statusAreaEventBus = new UIEventBus();
        this.menubarEventBus = new UIEventBus();
        this.fragmentChangedListener = new FragmentChangedListenerImpl();
        this.saListenerInitiator = new StatusAreaListenerInitiator();
        this.privilegeSet = new Privileges();
        this.layoutDataModel = new LayoutDataModel();
        this.databaseDataModel = new DatabaseDataModel(this.app);
        this.app.getPage().addUriFragmentChangedListener(this.fragmentChangedListener);
    }

    public NotificationEventBus getNotificationEventBus() {
        return this.notificationEventBus;
    }

    public Privileges getPrivileges() {
        return this.privilegeSet;
    }

    public ActionManager getAM() {
        return this.actions;
    }

    public CardStyleWindowHandler getCardStyleWindowHandler() {
        if (this.cardStyleWindowHandler == null) {
            this.cardStyleWindowHandler = new CardStyleWindowHandler(this.app);
        }
        return this.cardStyleWindowHandler;
    }

    public SharingWindowHandler getSharingWindowHandler() {
        if (this.sharingWindowHandler == null) {
            this.sharingWindowHandler = new SharingWindowHandler(this.app);
        }
        return this.sharingWindowHandler;
    }

    public DatabaseDataModel getDatabaseDataModel() {
        return this.databaseDataModel;
    }

    public LayoutDataModel getLayoutDataModel() {
        return this.layoutDataModel;
    }

    public StatusAreaListenerInitiator getStatusAreaListenerInitiator() {
        return this.saListenerInitiator;
    }

    public NotificationProcessor getNotificationProcessor() {
        return this.responseProcessor;
    }

    public NotificationDialogProcessor getNotificationDialogProcessor() {
        return this.dialogProcessor;
    }

    public NotificationWebScriptProcessor getNotificationWebScriptProcessor() {
        return this.webScriptProcessor;
    }

    UIEventBus getGlobalUIEventBus() {
        return this.globalEventBus;
    }

    UIEventBus getStatusAreaUIEventBus() {
        return this.statusAreaEventBus;
    }

    UIEventBus getMenubarUIEventBus() {
        return this.menubarEventBus;
    }

    public static Map<Integer, App> getAllActiveApp() {
        return ALL_ACTIVE_APPS;
    }

    public void start() {
        this.globalEventBus.subscribeAllType(this.actions);
    }

    public void clear(int n) {
        this.app.getAppSession().getActionTaskHelper().clearQueue();
        this.app.clearUIEventListeners();
        this.notificationEventBus.clear();
        if (IWPUtilities.isDebugMode()) {
            this.app.getDeveloperTools().closeAllWindows();
        }
        if (!this.app.getAppView().isCardStyleWindow()) {
            this.app.getStatusAreaContainer().logout();
        }
        this.app.getLayoutContainer().logout(n);
        this.app.removeActionHandlers();
        this.app.getPage().removeUriFragmentChangedListener(this.fragmentChangedListener);
        ALL_ACTIVE_APPS.remove(n);
        CacheManager.clearUserCache(n);
    }

    private class FragmentChangedListenerImpl
    implements Page.UriFragmentChangedListener {
        private FragmentChangedListenerImpl() {
        }

        public void uriFragmentChanged(Page.UriFragmentChangedEvent uriFragmentChangedEvent) {
            String string = uriFragmentChangedEvent.getUriFragment();
            if (AppController.this.app.getURIHandler().updateUriFragment(string, false)) {
                if (AppController.this.app.hasValidSession() && !Utilities.isValidText(string)) {
                    AppController.this.app.attemptSessionLogout();
                } else if (!AppController.this.app.getCurrentDatabaseName().equals(IWPUtilities.getDatabaseNameFromFragment(string))) {
                    AppController.this.app.getAppView().setDatabaseSwitch(true);
                    AppController.this.app.attemptSessionLogout();
                } else {
                    AppController.this.app.getURIHandler().handleURI(null);
                }
            }
        }
    }
}

