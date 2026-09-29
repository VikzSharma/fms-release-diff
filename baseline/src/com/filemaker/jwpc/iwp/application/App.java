/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.vaadin.annotations.Theme
 *  com.vaadin.event.Action$Handler
 *  com.vaadin.server.ClientConnector
 *  com.vaadin.server.ClientConnector$ConnectorErrorEvent
 *  com.vaadin.server.DefaultErrorHandler
 *  com.vaadin.server.ErrorEvent
 *  com.vaadin.server.ErrorHandler
 *  com.vaadin.server.ErrorHandlingRunnable
 *  com.vaadin.server.Extension
 *  com.vaadin.server.Page
 *  com.vaadin.server.Page$BrowserWindowResizeEvent
 *  com.vaadin.server.Page$BrowserWindowResizeListener
 *  com.vaadin.server.SystemMessagesProvider
 *  com.vaadin.server.VaadinRequest
 *  com.vaadin.server.VaadinResponse
 *  com.vaadin.server.VaadinService
 *  com.vaadin.server.VaadinServlet
 *  com.vaadin.server.VaadinServletRequest
 *  com.vaadin.server.VaadinServletResponse
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.VaadinSession$State
 *  com.vaadin.server.WebBrowser
 *  com.vaadin.shared.Connector
 *  com.vaadin.shared.communication.PushMode
 *  com.vaadin.shared.ui.ui.Transport
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Notification
 *  com.vaadin.ui.Notification$Type
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 *  jakarta.servlet.http.Cookie
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.action.ActionManager;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.ActiveUIHandler;
import com.filemaker.jwpc.iwp.application.AppContainer;
import com.filemaker.jwpc.iwp.application.AppController;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.application.AppSystemMessagesProvider;
import com.filemaker.jwpc.iwp.application.AppView;
import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.application.MySemaphore;
import com.filemaker.jwpc.iwp.application.SessionContext;
import com.filemaker.jwpc.iwp.application.URIHandler;
import com.filemaker.jwpc.iwp.css.FMCommunicationComponent;
import com.filemaker.jwpc.iwp.model.DatabaseDataModel;
import com.filemaker.jwpc.iwp.model.LayoutDataModel;
import com.filemaker.jwpc.iwp.model.Privileges;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.notification.processor.NotificationProcessor;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.SessionDisconnectType;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.notification.OpenDatabaseNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ErrorDialog;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImageResource;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.statusarea.StatusAreaContainer;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.ui.statusarea.listener.StatusAreaListenerInitiator;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.Messenger;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperTools;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.Utilities;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.annotations.Theme;
import com.vaadin.event.Action;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorEvent;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorHandlingRunnable;
import com.vaadin.server.Extension;
import com.vaadin.server.Page;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.VaadinServletResponse;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.Connector;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Theme(value="default")
public class App
extends UI {
    private static JWPCLogger logger = JWPCLogger.getLogger(App.class);
    private static final Pattern HOMEURL_SCRIPT_PATTERN = Pattern.compile("javascript:.*", 2);
    private static final Pattern HOMEURL_DOMAIN_PATTERN = Pattern.compile("^(?:http:\\/\\/|www\\.|https:\\/\\/)([^\\/]+)", 2);
    private final List<Action.Handler> actionHandlers = new ArrayList<Action.Handler>();
    private WeakReference<AppView> appView;
    private String persistentID = "";
    private URIHandler uriHandler;
    private String userLogOutURL = null;
    private BrowserInfoHandler browserInfo;
    public MySemaphore pendingPush = new MySemaphore(1, true);
    private AtomicBoolean isDetached = new AtomicBoolean(false);
    private ConcurrentHashMap<String, WDImage> imageMap = new ConcurrentHashMap();
    private ConcurrentHashMap<String, WDImage> containerImageMap = new ConcurrentHashMap();
    private ConcurrentHashMap<ObjectSpec, String> setWebViewerCache = new ConcurrentHashMap();
    private boolean needWebDVirtualDir = false;
    private int currentErrorCode = ErrorCode.None.getErrorCode();
    private int lastAuthErrorCode = 0;
    private boolean selfSignedCertificateInstalled = false;
    private boolean firstTimeLoadDatabaseView = true;
    private boolean isVideoPlayingFullScreen = false;
    private boolean nativeLogin = false;
    private int loginErrorCode = 0;
    private boolean isGuestEnabled = true;
    private boolean hideLocalAccountEntry = true;
    private boolean customLoginHandler = false;
    private ErrorDialog logoutDialog = null;
    private boolean displayLogoutDialog = true;
    private SessionContext sessionContext = null;
    private boolean pwdExpired = false;
    private String clientOrigin = "";
    private ScheduledExecutorService fmidTimer = null;

    protected void init(VaadinRequest vaadinRequest) {
        AppServlet appServlet = (AppServlet)VaadinServlet.getCurrent();
        this.setLogoutURL(vaadinRequest.getParameter("homeurl"), AppServlet.getCustomHomeurl());
        if (this.userLogOutURL != null && vaadinRequest.getParameter("homelogin") != null) {
            this.customLoginHandler = vaadinRequest.getParameter("homelogin").equals("1");
        }
        if (vaadinRequest.getParameter("pwx") != null) {
            this.pwdExpired = vaadinRequest.getParameter("pwx").equals("1");
        }
        this.getLoadingIndicatorConfiguration().setFirstDelay(1000);
        this.initAppResources(vaadinRequest.getLocale());
        if (!AppServlet.isEnabled()) {
            this.setContent((Component)IWPUtilities.getTechnologyDisabledScreen(this));
        } else if (!IWPUtilities.isSupportedBrowser(this.getWebBrowser())) {
            this.setContent((Component)IWPUtilities.getUnsupportedBrowserScreen(this));
        } else if (!this.validPath()) {
            this.setContent((Component)IWPUtilities.getUnsupportedPageError(this));
        } else {
            this.uriHandler = new URIHandler(this);
            this.configurePush();
            AppView appView = new AppView(this);
            this.setSizeFull();
            this.setStyleName("app-style");
            this.setContent((Component)appView);
            this.enableTouchScroll(true);
            this.appView = new WeakReference<AppView>(appView);
            this.handleCookies(vaadinRequest, VaadinService.getCurrentResponse());
            this.sessionContext = appServlet.getSessionContext(vaadinRequest);
            if (this.sessionContext != null && this.sessionContext.getRefreshToken() != "") {
                this.setFMIDCookie(this.sessionContext.getFMID());
                this.fmidTimer = Executors.newSingleThreadScheduledExecutor();
                this.fmidTimer.scheduleAtFixedRate(new Runnable(){

                    @Override
                    public void run() {
                        logger.debug("FMID token exchange timer is triggered");
                        String string = App.this.sessionContext.getRefreshToken();
                        String string2 = App.this.exchangeFMIDToken(string);
                        if (string2 != "") {
                            App.this.sessionContext.setFMID(string2);
                            App.this.setFMIDCookie(string2);
                            App.this.pushChanges();
                            logger.debug("FMID token exchange succeeded");
                        } else {
                            logger.debug("FMID token exchange failed");
                        }
                    }
                }, 2400L, 2400L, TimeUnit.SECONDS);
                logger.debug("FMID token exchange timer is running");
            }
            this.browserInfo = new BrowserInfoHandler(this, this.sessionContext != null ? this.sessionContext.getLocale() : null);
            if (!BrowserInfoHandler.isTouchDevice(this)) {
                this.addBrowserResizeListener();
            }
            Locale locale = this.browserInfo.getSupportedBrowserLocale();
            String string = locale.getLanguage();
            this.getPage().getJavaScript().execute("document.documentElement.setAttribute('lang', '" + string + "');");
            if (!this.uriHandler.handleURI(vaadinRequest)) {
                try {
                    FMRequestManager.handleLoginError(this, null);
                }
                catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            } else {
                ((VaadinServletRequest)vaadinRequest).getHttpServletRequest().changeSessionId();
            }
        }
        if (IWPUtilities.isDebugMode()) {
            this.dump();
        }
        appServlet.clearSessionContext(vaadinRequest, this);
        this.setOverlayContainerLabel("");
        boolean bl = AppServlet.isAriaCompliantControlEnabled();
        this.getAppView().updateAriaCompliantControl(bl);
        if (bl) {
            this.getState().tabIndex = 0;
        }
    }

    public SessionContext getSessionContext() {
        return this.sessionContext;
    }

    private void configurePush() {
        if (Utilities.isIIS7()) {
            this.getPushConfiguration().setTransport(Transport.LONG_POLLING);
            this.getSession().getService().setLongPollingSuspendTimeout(110000);
        } else if (App.getCurrent().getWebBrowser().isIOS()) {
            this.getPushConfiguration().setTransport(Transport.WEBSOCKET_XHR);
        } else {
            this.getPushConfiguration().setTransport(Transport.WEBSOCKET);
        }
        this.getPushConfiguration().setPushMode(PushMode.MANUAL);
    }

    public boolean getRetinaDisplay() {
        return this.getAppView().getRetinaDisplay();
    }

    private boolean validPath() {
        if (this.getPage().getLocation() != null && this.getPage().getLocation().getPath() != null) {
            String string = this.getPage().getLocation().getPath().toLowerCase();
            if (string.equals("/fmi/webd")) {
                this.needWebDVirtualDir = true;
                return true;
            }
            if (string.startsWith("/fmi/webd/")) {
                return true;
            }
        }
        return false;
    }

    public Locale getSupportedBrowserLocale() {
        return this.browserInfo.getSupportedBrowserLocale();
    }

    public void addExtension(Extension extension) {
        super.addExtension(extension);
    }

    public void focus() {
        VaadinSession vaadinSession = this.getSession();
        if (vaadinSession != null && vaadinSession.getState() == VaadinSession.State.OPEN && !this.isClosing()) {
            super.focus();
            this.pushChanges();
        }
    }

    public void setLogoutURL(String string, String string2) {
        if (Utilities.isValidText(string)) {
            this.userLogOutURL = App.validateHomeurl(string, string2);
        }
    }

    public static String validateHomeurl(String string, String string2) {
        if (!Utilities.isValidText(string)) {
            return null;
        }
        if (HOMEURL_SCRIPT_PATTERN.matcher(string).matches() || !AppServlet.isHomeurlEnabled()) {
            return null;
        }
        if (!Utilities.isValidText(string2)) {
            return null;
        }
        List<String> list = Arrays.asList(string2.split(","));
        Matcher matcher = HOMEURL_DOMAIN_PATTERN.matcher(string);
        if (matcher.find() && list.contains(matcher.group())) {
            return string;
        }
        return null;
    }

    public String getLogoutURL() {
        return this.userLogOutURL;
    }

    private void addBrowserResizeListener() {
        this.getUI().setResizeLazy(true);
        this.getUI().getPage().addBrowserWindowResizeListener(new Page.BrowserWindowResizeListener(){

            public void browserWindowResized(Page.BrowserWindowResizeEvent browserWindowResizeEvent) {
                int n = browserWindowResizeEvent.getWidth();
                int n2 = browserWindowResizeEvent.getHeight();
                if (App.this.getAppView().getAppSession().isLoggedIn() && App.this.getLayoutContainer().getCurrentView() != null && App.this.getLayoutContainer().getCurrentView().getLayoutMetaData().hasAutoSizingObjects()) {
                    Dimensions dimensions;
                    if (!(App.this.isPlayingFullScreen() || (dimensions = App.this.browserInfo.getBrowserClientInfo().getBrowserDimensions()).getHeight() == n2 && dimensions.getWidth() == n)) {
                        App.this.getCommunicationComponent().performBrowserResize(n, n2);
                    }
                } else {
                    App.this.browserResized(n, n2);
                }
            }
        });
    }

    public void mobileBrowserOrientationChanged(int n, int n2) {
        if (this.getAppView().getAppSession().isLoggedIn()) {
            this.getCommunicationComponent().performBrowserResize(n, n2);
        } else {
            this.browserResized(n, n2);
        }
    }

    public void browserResized(int n, int n2) {
        if (IWPUtilities.isDebugMode()) {
            Notification.show((String)("Browser resized - height: " + n2 + " and width: " + n), (Notification.Type)Notification.Type.TRAY_NOTIFICATION);
        }
        this.browserInfo.getBrowserClientInfo().setBrowserDimensions(new Dimensions(n2, n));
        if (this.getAppView().getAppSession().isLoggedIn()) {
            this.getAppView().getAppSession().browserResized();
            this.getStatusAreaContainer().browserResized();
        }
    }

    public void browserResizedWithActiveField(int n, int n2, FieldObjectData fieldObjectData) {
        if (IWPUtilities.isDebugMode()) {
            Notification.show((String)("Browser resized - height: " + n2 + " and width: " + n), (Notification.Type)Notification.Type.TRAY_NOTIFICATION);
        }
        this.browserInfo.getBrowserClientInfo().setBrowserDimensions(new Dimensions(n2, n));
        if (this.getAppView().getAppSession().isLoggedIn()) {
            this.getAppView().getAppSession().browserResizedWithActiveField(fieldObjectData);
            this.getStatusAreaContainer().browserResized();
        }
    }

    protected void internal_pushChanges() {
        this.access((Runnable)new ErrorHandlingRunnable(){

            public void run() {
                App.this.push();
            }

            public void handleError(Exception exception) {
                try {
                    ClientConnector.ConnectorErrorEvent connectorErrorEvent = new ClientConnector.ConnectorErrorEvent((Connector)App.this, (Throwable)exception);
                    ErrorHandler errorHandler = ErrorEvent.findErrorHandler((ClientConnector)App.this);
                    if (errorHandler == null) {
                        errorHandler = new DefaultErrorHandler();
                    }
                    errorHandler.error((ErrorEvent)connectorErrorEvent);
                }
                catch (Exception exception2) {
                    logger.debug(exception2.getMessage(), exception2);
                }
            }
        });
    }

    public void pushChanges() {
        block2: {
            try {
                this.internal_pushChanges();
            }
            catch (Exception exception) {
                if (!IWPUtilities.isDebugMode()) break block2;
                System.err.println(" pushChanges exception:" + exception.getMessage());
            }
        }
    }

    public URIHandler getURIHandler() {
        return this.uriHandler;
    }

    public AppView getAppView() {
        if (this.appView != null && this.appView.get() != null) {
            return (AppView)this.appView.get();
        }
        return null;
    }

    public BrowserInfoHandler getBrowserInfoHandler() {
        return this.browserInfo;
    }

    private void initAppResources(Locale locale) {
        this.getPage().setTitle(IWPI18N.get(locale, "TITLE", new Object[0]));
        this.getSession().getService().setSystemMessagesProvider((SystemMessagesProvider)new AppSystemMessagesProvider());
    }

    public String getLanguage() {
        return IWPUtilities.mapISO6392CodeToISO6391(this.getWebBrowser().getLocale().getISO3Language());
    }

    public WebBrowser getWebBrowser() {
        return this.getPage().getWebBrowser();
    }

    public static App getApp(int n) {
        return AppController.getAllActiveApp().get(n);
    }

    public static App getCurrent() {
        return (App)UI.getCurrent();
    }

    public void addActionHandler(Action.Handler handler) {
        this.actionHandlers.add(handler);
        super.addActionHandler(handler);
    }

    public void removeActionHandler(Action.Handler handler) {
        this.actionHandlers.remove(handler);
        super.removeActionHandler(handler);
    }

    public void removeActionHandlers() {
        for (Action.Handler handler : this.actionHandlers) {
            super.removeActionHandler(handler);
        }
        this.actionHandlers.clear();
    }

    public String getPersistentID() {
        return this.persistentID;
    }

    private static String getUUID() {
        String string = UUID.randomUUID().toString();
        return string.toUpperCase().replace("-", "");
    }

    public String getHiddenIFrameTargetName() {
        return "iframe_target" + this.getUIId();
    }

    public String getHiddenIFrameTargetId() {
        return "PID_Siframe_target" + this.getUIId();
    }

    public void redirectToLogoutURL(SessionDisconnectType sessionDisconnectType) {
        this.getPage().setLocation(FMRequestManager.getUserLogoutURL(this, sessionDisconnectType));
    }

    public int getTabIndex() {
        return 0;
    }

    public void setTabIndex(int n) {
    }

    public void detach() {
        this.forceClose(true, false, null);
        if (this.getSession() == null) {
            this.appView = null;
            this.browserInfo = null;
            this.uriHandler = null;
        }
        super.detach();
        this.imageMap = null;
        this.containerImageMap = null;
        this.setWebViewerCache = null;
        this.shutDownFMIDTimer();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceClose(boolean bl, boolean bl2, SessionDisconnectType sessionDisconnectType) {
        VaadinSession vaadinSession = this.getSession();
        if (vaadinSession != null) {
            vaadinSession.lock();
            try {
                if (this.getSession() == vaadinSession) {
                    if (!this.isDetached() && this.getAppView() != null) {
                        Session session;
                        boolean bl3;
                        if (!bl2) {
                            this.isDetached.set(true);
                            int bl32 = this.getCurrentSessionID();
                            if (IWPUtilities.isValidSessionID(bl32)) {
                                AppController.getAllActiveApp().remove(bl32);
                            }
                        }
                        boolean bl4 = bl3 = this.hasValidSession() && this.isLoggedIn();
                        if (bl && (session = this.getAppView().getAppSession()) != null && session.hasValidSession()) {
                            session.forceDBSessionClose();
                        }
                        this.getAppView().onSessionCloseSuccess(bl2, bl3, sessionDisconnectType);
                        if (bl2) {
                            this.pushChanges();
                        }
                    }
                    this.clearImageMap();
                    this.clearContainerImageMap();
                    this.setWebViewerCache.clear();
                    this.shutDownFMIDTimer();
                }
            }
            finally {
                vaadinSession.unlock();
            }
        }
    }

    public void dump() {
        Object object3;
        Iterator iterator;
        Object object2;
        VaadinRequest vaadinRequest = VaadinService.getCurrentRequest();
        VaadinService vaadinService = VaadinService.getCurrent();
        logger.info("===== App dump");
        logger.info(String.format("App: %s", this.toString()));
        if (vaadinRequest != null) {
            logger.info("VaadinRequest.getContextPath=" + vaadinRequest.getContextPath());
            logger.info("VaadinRequest.getPathInfo=" + vaadinRequest.getPathInfo());
            object2 = vaadinRequest.getAttributeNames();
            while (object2.hasMoreElements()) {
                iterator = (String)object2.nextElement();
                logger.info(String.format("VaadinRequest Attribute: name=%s, value=%s", iterator, vaadinRequest.getAttribute(iterator)));
            }
            object2 = vaadinRequest.getHeaderNames();
            while (object2.hasMoreElements()) {
                iterator = (String)object2.nextElement();
                logger.info(String.format("VaadinRequest header: name=%s, value=%s", iterator, vaadinRequest.getHeader(iterator)));
            }
            object2 = vaadinRequest.getParameterMap();
            for (Object object3 : object2.keySet()) {
                logger.info(String.format("VaadinRequest parameterMap: key=%s, value=%s", object3, vaadinRequest.getParameter((String)object3)));
            }
        }
        if (vaadinService != null) {
            logger.info("VaadinService.getBaseDirectory=" + String.valueOf(vaadinService.getBaseDirectory()));
        }
        object2 = System.getProperties();
        for (Object object3 : ((Properties)object2).keySet()) {
            logger.info(String.format("Java system property: key=%s, value=%s", object3, ((Properties)object2).get(object3)));
        }
        iterator = System.getenv();
        for (String string : iterator.keySet()) {
            logger.info(String.format("Environment variable: key=%s, value=%s", string, iterator.get(string)));
        }
        object3 = Runtime.getRuntime();
        logger.info("Available processors: " + ((Runtime)object3).availableProcessors());
        logger.info(String.format("JVM free memory: %s MB", ((Runtime)object3).freeMemory() / 0x100000L));
        logger.info(String.format("JVM total memory: %s MB", ((Runtime)object3).totalMemory() / 0x100000L));
        logger.info(String.format("JVM maximum memory: %s MB", ((Runtime)object3).maxMemory() / 0x100000L));
    }

    public void browserScrolled() {
        this.getLayoutContainer().getPopoverHandler().exitPopover(true);
    }

    public void loginDatabase(Credentials credentials, boolean bl, boolean bl2, int n) {
        this.nativeLogin = bl2;
        this.getAppView().loginDatabase(credentials, bl, n);
    }

    public void openDatabaseComplete(Context context, OpenDatabaseNotification openDatabaseNotification) {
        this.getAppView().openDatabaseComplete(context, openDatabaseNotification);
    }

    public void attemptSessionLogout() {
        this.getAppView().attemptSessionLogout();
    }

    public void initContextMenu(boolean bl) {
        this.getAppView().initContextMenu(bl);
    }

    public boolean isDialogOn() {
        return this.getAppView().isDialogOn();
    }

    public void setDialogOn(boolean bl, Dialog dialog) {
        this.getAppView().setDialogOn(bl, dialog);
    }

    public void updateShortcutHandlingOnClient(boolean bl) {
        this.getAppView().updateShortcutHandlingOnClient(bl);
    }

    public void setUsername(String string) {
        this.getAppView().setUsername(string);
    }

    public void setPassword(String string) {
        this.getAppView().setPassword(string);
    }

    public String getUsername() {
        return this.getAppView().getUsername();
    }

    public String getPassword() {
        return this.getAppView().getPassword();
    }

    public Credentials getCredentials() {
        return this.getAppView().getCredentials();
    }

    public void setCredentials(Credentials credentials) {
        this.getAppView().setCredentials(credentials);
    }

    public Service getAppService() {
        return this.getAppView().getAppService();
    }

    public Session getAppSession() {
        return this.getAppView().getAppSession();
    }

    public AppContainer getAppContainer() {
        return this.getAppView().getAppContainer();
    }

    public int getCurrentSessionID() {
        return this.getAppView().getCurrentSessionID();
    }

    public ActiveUIHandler getActiveUIHandler() {
        return this.getAppView().getActiveUIHandler();
    }

    public static Set<Integer> getAllClientIDs() {
        return AppView.getAllClientIDs();
    }

    public NotificationProcessor getNotificationProcessor() {
        return this.getAppView().getNotificationProcessor();
    }

    public Messenger getMessenger() {
        return this.getAppView().getMessenger();
    }

    public void subscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        this.getAppView().subscribe(uIEventListener, eventTypeArray);
    }

    public void subscribeAllType(UIEventListener uIEventListener) {
        this.getAppView().subscribeAllType(uIEventListener);
    }

    public void unsubscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        this.getAppView().unsubscribe(uIEventListener, eventTypeArray);
    }

    public void unsubscribeAllType(UIEventListener uIEventListener) {
        this.getAppView().unsubscribeAllType(uIEventListener);
    }

    public void unsubscribeAllListeners() {
        this.getAppView().unsubscribeAllListeners();
    }

    public void clearUIEventListeners() {
        this.getAppView().clearUIEventListeners();
    }

    public void notify(UIEvent uIEvent) {
        this.getAppView().notify(uIEvent);
    }

    public String getCurrentDatabaseName() {
        return this.getAppView().getCurrentDatabaseName();
    }

    public QuickFind getQuickFind() {
        return this.getAppView().getQuickFind();
    }

    public Object getNotificationExecutorLock() {
        return this.getAppView().getNotificationExecutorLock();
    }

    public String getCurrentUserName() {
        return this.getAppView().getCurrentUserName();
    }

    public String getCurrentAccountName() {
        return this.getAppView().getCurrentAccountName();
    }

    public AppController getAppController() {
        return this.getAppView().getAppController();
    }

    public FMCommunicationComponent getCommunicationComponent() {
        return this.getAppView().getCommunicationComponent();
    }

    public boolean showStatusArea() {
        return this.getAppView().showStatusArea();
    }

    public boolean hasValidSession() {
        if (this.getAppView() != null) {
            return this.getAppView().hasValidSession();
        }
        return false;
    }

    public boolean isLoggedIn() {
        return this.getAppView().isLoggedIn();
    }

    public boolean isDatabaseOpen() {
        return this.getAppView().isDatabaseOpen();
    }

    public ActionManager getAM() {
        return this.getAppView().getAM();
    }

    public StatusAreaContainer getStatusAreaContainer() {
        return this.getAppView().appContainer.getStatusAreaContainer();
    }

    public LayoutContainer getLayoutContainer() {
        return this.getAppView().getLayoutContainer();
    }

    public LayoutDataModel getLayoutDataModel() {
        return this.getAppView().getLayoutDataModel();
    }

    public DatabaseDataModel getDatabaseDataModel() {
        return this.getAppView().getDatabaseDataModel();
    }

    public Privileges getPrivileges() {
        return this.getAppView().getPrivileges();
    }

    public StatusAreaListenerInitiator getStatusAreaListenerInitiator() {
        return this.getAppView().getStatusAreaListenerInitiator();
    }

    public String getURIFragment() {
        return this.getAppView().getURIFragment();
    }

    public boolean isBrowseMode() {
        return this.getAppView().isBrowseMode();
    }

    public boolean isFindMode() {
        return this.getAppView().isFindMode();
    }

    public LayoutMode getCurrentLayoutMode() {
        return this.getAppView().getCurrentLayoutMode();
    }

    public String getApplicationURL() {
        return this.getAppView().getApplicationURL();
    }

    public boolean isListView() {
        return this.getAppView().isListView();
    }

    public boolean isFormView() {
        return this.getAppView().isFormView();
    }

    public DeveloperTools getDeveloperTools() {
        return this.getAppView().getDeveloperTools();
    }

    public Container getActiveContainerField(boolean bl) {
        return this.getAppView().getActiveContainerField(bl);
    }

    public void positionContextMenu(int n, int n2, LayoutFieldObject layoutFieldObject) {
        this.getAppView().positionContextMenu(n, n2, layoutFieldObject);
    }

    public void showContextMenu(LayoutFieldObject layoutFieldObject) {
        this.getAppView().showContextMenu(layoutFieldObject);
    }

    private void handleCookies(VaadinRequest vaadinRequest, VaadinResponse vaadinResponse) {
        VaadinServletRequest vaadinServletRequest = (VaadinServletRequest)vaadinRequest;
        VaadinServletResponse vaadinServletResponse = (VaadinServletResponse)vaadinResponse;
        if (Utilities.isEmptyString(this.persistentID)) {
            this.persistentID = App.getPersistentID(vaadinServletRequest.getHttpServletRequest(), vaadinServletResponse.getHttpServletResponse());
        }
    }

    public static String getPersistentID(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String string = "";
        Cookie[] cookieArray = httpServletRequest.getCookies();
        boolean bl = false;
        if (cookieArray != null) {
            for (int i = 0; i < cookieArray.length; ++i) {
                if (!"WebD_ID".equals(cookieArray[i].getName())) continue;
                string = cookieArray[i].getValue();
                bl = true;
                break;
            }
        }
        if (!bl) {
            string = App.getUUID();
        }
        Cookie cookie = new Cookie("WebD_ID", string);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(31536000);
        cookie.setPath("/fmi");
        String string2 = App.getDomainName();
        if (Utilities.isValidHostName(string2)) {
            cookie.setDomain(string2);
        }
        httpServletResponse.addCookie(cookie);
        return string;
    }

    public String toString() {
        return String.format("[id=%s, uri=%s, browserInfo=%s, view=%s]", this.getPersistentID(), this.getURIFragment(), this.getBrowserInfoHandler(), this.getAppView());
    }

    public void showCommunicationError() {
        Window window = new Window(IWPI18N.get(this, "COMMUNICATION_ERROR_CAPTION", new Object[0]));
        window.setClosable(false);
        window.setModal(true);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(true);
        window.setContent((Component)verticalLayout);
        verticalLayout.addComponent((Component)new Label(IWPI18N.get(this, "COMMUNICATION_ERROR_MESSAGE_ALT", new Object[0])));
        this.addWindow(window);
    }

    public boolean hasLayoutMode() {
        return this.getAppView().getLayoutDataModel().getMode() != null;
    }

    public WDImage getFromImageMap(String string) {
        if (this.imageMap != null) {
            return this.imageMap.get(string);
        }
        return null;
    }

    public boolean containsKeyInImageMap(String string) {
        if (this.imageMap != null) {
            return this.imageMap.containsKey(string);
        }
        return false;
    }

    public void addToImageMap(String string, WDImage wDImage) {
        if (!this.isDetached() && this.imageMap != null) {
            this.imageMap.put(string, wDImage);
            wDImage.setVisible(false);
            WDImageResource wDImageResource = (WDImageResource)wDImage.getSource();
            if (wDImageResource != null) {
                wDImageResource.setApp(this);
            }
            this.getAppContainer().addComponent((Component)wDImage);
            this.getAppContainer().markAsDirty();
        }
    }

    public void clearImageMap() {
        if (this.imageMap != null) {
            for (WDImage wDImage : this.imageMap.values()) {
                this.removeCachedImageFromApp(wDImage);
            }
            this.imageMap.clear();
        }
    }

    public void notifyImageSentToClient(String string) {
        WDImage wDImage;
        if (this.imageMap != null && (wDImage = this.getFromImageMap(string)) != null) {
            this.removeCachedImageFromApp(wDImage);
        }
    }

    private void removeCachedImageFromApp(WDImage wDImage) {
        if (wDImage != null) {
            WDImageResource wDImageResource = (WDImageResource)wDImage.getSource();
            if (wDImageResource != null) {
                wDImageResource.setApp(null);
            }
            if (this.getAppContainer() != null && this.getAppContainer().getComponentIndex((Component)wDImage) != -1) {
                this.getAppContainer().removeComponent((Component)wDImage);
            }
            wDImage = null;
        }
    }

    public WDImage getFromContainerImageMap(String string) {
        if (this.containerImageMap != null) {
            return this.containerImageMap.get(string);
        }
        return null;
    }

    public boolean containsKeyInContainerImageMap(String string) {
        if (this.containerImageMap != null) {
            return this.containerImageMap.containsKey(string);
        }
        return false;
    }

    public void addToContainerImageMap(String string, WDImage wDImage) {
        if (!this.isDetached() && this.containerImageMap != null) {
            this.containerImageMap.put(string, wDImage);
            wDImage.setVisible(false);
            WDImageResource wDImageResource = (WDImageResource)wDImage.getSource();
            if (wDImageResource != null) {
                wDImageResource.setApp(this);
            }
            this.getAppContainer().addComponent((Component)wDImage);
            this.getAppContainer().markAsDirty();
        }
    }

    public void clearContainerImageMap() {
        if (this.containerImageMap != null) {
            for (WDImage wDImage : this.containerImageMap.values()) {
                this.removeCachedImageFromApp(wDImage);
            }
            this.containerImageMap.clear();
        }
    }

    public void notifyContainerImageSentToClient(String string) {
        WDImage wDImage;
        if (this.containerImageMap != null && (wDImage = this.getFromContainerImageMap(string)) != null) {
            this.removeCachedContainerImageFromApp(wDImage);
        }
    }

    private void removeCachedContainerImageFromApp(WDImage wDImage) {
        if (wDImage != null) {
            WDImageResource wDImageResource = (WDImageResource)wDImage.getSource();
            if (wDImageResource != null) {
                wDImageResource.setApp(null);
            }
            if (this.getAppContainer() != null && this.getAppContainer().getComponentIndex((Component)wDImage) != -1) {
                this.getAppContainer().removeComponent((Component)wDImage);
            }
            wDImage = null;
        }
    }

    public boolean need_webd_VirtualDir() {
        return this.needWebDVirtualDir;
    }

    public boolean isDetached() {
        return this.isDetached.get();
    }

    private void checkForHTTPSWithSelfSignedCert() {
        if (this.firstTimeLoadDatabaseView && this.getBrowserInfoHandler().getBrowserClientInfo().isSecureConnection() && this.isSelfSignedCertificateInstalled()) {
            this.getSession().getLockInstance().lock();
            this.getMessenger().showError(IWPI18N.get(this, "SELF_SIGNED_CERT_ERROR", new Object[0]));
            this.getSession().getLockInstance().unlock();
        }
        this.firstTimeLoadDatabaseView = false;
    }

    public void setCurrentErrorCode(int n) {
        this.currentErrorCode = n;
    }

    public int getCurrentErrorCode() {
        return this.currentErrorCode;
    }

    public void setLastAuthErrorCode(int n) {
        this.lastAuthErrorCode = n;
    }

    public int getLastAuthErrorCode() {
        return this.lastAuthErrorCode;
    }

    public boolean isSelfSignedCertificateInstalled() {
        return this.selfSignedCertificateInstalled;
    }

    public void setSelfSignedCertificateInstalled(boolean bl) {
        this.selfSignedCertificateInstalled = bl;
        this.checkForHTTPSWithSelfSignedCert();
    }

    public boolean isTouchUI() {
        return BrowserInfoHandler.isMobile(this);
    }

    public String getLocalizedString(String string) {
        return IWPI18N.get(this, string, new Object[0]);
    }

    public void setIsPlayingFullScreen(boolean bl) {
        this.isVideoPlayingFullScreen = bl;
    }

    public boolean isPlayingFullScreen() {
        return this.isVideoPlayingFullScreen;
    }

    public void enableTouchScroll(boolean bl) {
        if (BrowserInfoHandler.isiOSDevice(this)) {
            if (bl) {
                this.addStyleName("fm-touch-scroll");
            } else {
                this.removeStyleName("fm-touch-scroll");
            }
        }
    }

    public void onEnterPressed(boolean bl) {
        if (this.appView.get() != null) {
            ((AppView)this.appView.get()).onEnterPressed(this.getCurrentLayoutMode(), bl);
        }
    }

    public boolean isNativeLogin() {
        return this.nativeLogin;
    }

    public void setNativeLogin(boolean bl) {
        this.nativeLogin = bl;
    }

    public int getLoginErrorCode() {
        return this.loginErrorCode;
    }

    public boolean isGuestEnabled() {
        return this.isGuestEnabled;
    }

    public boolean hideLocalAccountEntry() {
        return this.hideLocalAccountEntry;
    }

    public void setLoginError(int n) {
        this.loginErrorCode = n;
    }

    public void setLoginError(int n, boolean bl) {
        this.loginErrorCode = n;
        this.isGuestEnabled = bl;
    }

    public void setLoginError(int n, boolean bl, boolean bl2) {
        this.loginErrorCode = n;
        this.isGuestEnabled = bl;
        this.hideLocalAccountEntry = bl2;
    }

    public void handleAdminLogout(String string) {
        this.logoutDialog = new ErrorDialog(this, this.getLocalizedString("TITLE"), string);
        this.logoutDialog.setModal(true);
        this.addWindow(this.logoutDialog);
        this.logoutDialog.setVisible(true);
        this.logoutDialog.focus();
        this.pushChanges();
        long l = System.currentTimeMillis();
        while (this != null && !this.isDetached() && this.isLogoutDialogUp()) {
            try {
                Thread.sleep(500L);
                long l2 = System.currentTimeMillis();
                if ((l2 - l) / 1000L <= 60L) continue;
                break;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
                break;
            }
        }
        this.removeWindow(this.logoutDialog);
        this.logoutDialog = null;
    }

    public boolean isLogoutDialogUp() {
        return this.logoutDialog != null && this.logoutDialog.isVisible();
    }

    public void setDisplayLogoutDialog(boolean bl) {
        this.displayLogoutDialog = bl;
    }

    public boolean shouldDisplayLogoutDialog() {
        return this.displayLogoutDialog;
    }

    public boolean hasCustomLoginHandler() {
        return this.customLoginHandler;
    }

    public boolean hasPasswordExpired() {
        return this.pwdExpired;
    }

    public void setStreamingCookie(String string) {
        String string2 = App.getDomainName();
        boolean bl = this.getBrowserInfoHandler().getBrowserClientInfo().isSecureConnection();
        int n = 43200;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("document.cookie = '");
        stringBuilder.append("X-FMS-Session-Key=%s; Path=%s; Max-Age=%s");
        if (Utilities.isValidHostName(string2)) {
            stringBuilder.append("; Domain=" + string2);
        }
        if (bl) {
            stringBuilder.append("; Secure");
        }
        stringBuilder.append("'");
        String string3 = stringBuilder.toString();
        string3 = bl ? String.format(string3, string, "/Streaming_SSL", n) : String.format(string3, string, "/Streaming", n);
        this.getPage().getJavaScript().execute(string3);
    }

    public void setClientOrigin(String string) {
        this.clientOrigin = string;
    }

    public boolean openShareDialog() {
        boolean bl = false;
        if (IWPUtilities.isShareButtonAvailable(this)) {
            SessionContext sessionContext = this.getSessionContext();
            String string = sessionContext != null ? sessionContext.getRefreshToken() : "";
            String string2 = this.getAppSession().getDatabaseName();
            String string3 = this.clientOrigin + "/fmi/sharing/#dbname=" + Utilities.encodeURI(string2) + "&refresh=" + Utilities.encodeURI(string);
            this.getAppController().getSharingWindowHandler().openWindow(string3);
            bl = true;
        }
        return bl;
    }

    public boolean openLayoutEditor(String string, boolean bl) {
        boolean bl2 = false;
        if (bl || IWPUtilities.isLayoutEditorAvailable(this)) {
            SessionContext sessionContext = this.getSessionContext();
            String string2 = sessionContext != null ? sessionContext.getRefreshToken() : "";
            String string3 = Utilities.encodeURI(string) + "#refresh=" + Utilities.encodeURI(string2) + "&layoutID=" + this.getAppSession().getLayoutID();
            if (!bl) {
                GlobalUIActionHandlers.COMMIT_RECORD.perform(this, null);
            }
            String string4 = "window.open(window.location.origin+'/fmi/layoutbuilder/" + string3 + "', '_self');";
            this.getPage().getJavaScript().execute(string4);
            bl2 = true;
        }
        return bl2;
    }

    public void addCachedSetWebViewerUrl(ObjectSpec objectSpec, String string) {
        if (this.setWebViewerCache != null) {
            this.setWebViewerCache.put(objectSpec.deepCopy(), string);
        }
    }

    public void removeCachedSetWebViewerUrl(ObjectSpec objectSpec) {
        if (this.setWebViewerCache != null && this.setWebViewerCache.containsKey(objectSpec)) {
            this.setWebViewerCache.remove(objectSpec);
        }
    }

    public String getCachedSetWebViewerUrl(ObjectSpec objectSpec) {
        if (this.setWebViewerCache != null && this.setWebViewerCache.containsKey(objectSpec)) {
            return this.setWebViewerCache.get(objectSpec);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String exchangeFMIDToken(String string) {
        String string2 = "";
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR("https://localhost/fmi/sharing/api/exchangetoken", "POST", true);
            if (httpURLConnection != null) {
                String string3 = "{\"refreshtoken\": \"" + Utilities.encodeURI(string) + "\"}";
                byte[] byArray = string3.getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("charset", "utf-8");
                httpURLConnection.setRequestProperty("Content-Length", Integer.toString(byArray.length));
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(byArray);
                dataOutputStream.flush();
                dataOutputStream.close();
                int n = httpURLConnection.getResponseCode();
                if (n == 200) {
                    String string4;
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((string4 = bufferedReader.readLine()) != null) {
                        stringBuffer.append(string4);
                    }
                    JsonParser jsonParser = new JsonParser();
                    String string5 = stringBuffer.toString();
                    JsonObject jsonObject = (JsonObject)jsonParser.parse(string5);
                    if (jsonObject.has("jwt")) {
                        string2 = jsonObject.get("jwt").getAsString();
                    }
                } else {
                    string2 = Integer.toString(n);
                }
            }
        }
        catch (Exception exception) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return string2;
    }

    private void setFMIDCookie(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("document.cookie = '");
        stringBuilder.append("WebD_Token=%s; Max-Age=%s; Secure");
        stringBuilder.append("'");
        String string2 = stringBuilder.toString();
        string2 = String.format(string2, string, 3600);
        this.getPage().getJavaScript().execute(string2);
    }

    public void shutDownFMIDTimer() {
        if (this.fmidTimer != null) {
            this.fmidTimer.shutdown();
            this.fmidTimer = null;
            logger.debug("FMID token exchange timer is terminated");
        }
    }

    public void printWpeConfigLog() {
        String string = IWPConstants.WPE_CONFIG_LOG;
        if (string != null && string.length() > 0) {
            this.getPage().getJavaScript().execute("console.log('Custom parameters loaded:" + string + "');");
        }
    }

    public static String getDomainName() {
        String string = "";
        if (UI.getCurrent() != null) {
            Page page = UI.getCurrent().getPage();
            try {
                string = page.getLocation().toURL().getHost();
            }
            catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
            catch (IllegalStateException illegalStateException) {
                illegalStateException.printStackTrace();
            }
        }
        return string;
    }

    public void enableKeystrokeListener() {
        ((AppView)this.appView.get()).enableKeystrokeListener();
    }

    public void disableKeystrokeListener() {
        ((AppView)this.appView.get()).disableKeystrokeListener();
    }

    public void setKeystrokeScriptTriggerListenerAtLayout(boolean bl) {
        ((AppView)this.appView.get()).setKeystrokeScriptTriggerListenerAtLayout(bl);
    }

    public boolean isKeystrokeEnabled() {
        return AppServlet.isKeystrokeEnabled();
    }

    public void onKeystroke(String string, int n, boolean bl) {
        if (this.isKeystrokeEnabled()) {
            if (string == null) {
                if (this.getLayoutDataModel().hasKeyTrigger()) {
                    ((AppView)this.appView.get()).onKeystroke(string, n, bl);
                }
            } else {
                ((AppView)this.appView.get()).onKeystroke(string, n, bl);
            }
        }
    }

    public void revertActiveObjectValue(LayoutTextFieldObject layoutTextFieldObject, String string) {
        String string2 = null;
        if (layoutTextFieldObject != null) {
            switch (layoutTextFieldObject.getMetaData().getType()) {
                case EDIT_BOX: {
                    string2 = layoutTextFieldObject.getUniqueId();
                    break;
                }
            }
            if (string2 != null) {
                ((AppView)this.appView.get()).revertActiveObjectValue(string2, string);
            }
        }
    }

    public LayoutFieldObject getActiveField(boolean bl) {
        return this.getAppView().getActiveField(bl);
    }
}

