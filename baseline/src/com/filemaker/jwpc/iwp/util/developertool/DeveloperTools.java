/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.event.Action$Handler
 *  com.vaadin.event.ShortcutAction
 *  com.vaadin.ui.MenuBar$Command
 *  com.vaadin.ui.MenuBar$MenuItem
 */
package com.filemaker.jwpc.iwp.util.developertool;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppView;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenuItem;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperToolType;
import com.filemaker.jwpc.iwp.util.developertool.DeveloperToolWindow;
import com.vaadin.event.Action;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.MenuBar;

public class DeveloperTools
implements Action.Handler {
    protected final App app;
    private IWPMenuItem item;
    private final Action showDevTools = new ShortcutAction("Alt+1", 49, new int[]{18});
    private IWPMenuItem uiEventDebugging;
    private DeveloperToolWindow uiEventDebuggingWindow;
    private IWPMenuItem uiActionsDebugging;
    private DeveloperToolWindow uiActionsDebuggingWindow;
    private IWPMenuItem notificationDebugging;
    private DeveloperToolWindow notificationDebuggingWindow;
    private IWPMenuItem threadDumpDebugging;
    private DeveloperToolWindow threadDumpDebuggingWindow;
    private IWPMenuItem threadDiagnostics;
    private DeveloperToolWindow threadDiagnosticsWindow;
    private IWPMenuItem cacheDiagnostics;
    private DeveloperToolWindow cacheDiagnosticsWindow;
    private MenuBar.Command menuCommand = new MenuBar.Command(){

        public void menuSelected(MenuBar.MenuItem menuItem) {
            if (menuItem.isCheckable()) {
                if (menuItem.isChecked()) {
                    if (menuItem.getText().equals(DeveloperToolType.UI_ACTION.toString())) {
                        DeveloperTools.this.closeUIActionsWindow(false);
                        DeveloperTools.this.uiActionsDebuggingWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.UI_ACTION);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.uiActionsDebuggingWindow);
                    } else if (menuItem.getText().equals(DeveloperToolType.SERVER_NOTIFICATION.toString())) {
                        DeveloperTools.this.closeNotificationsWindow(false);
                        DeveloperTools.this.notificationDebuggingWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.SERVER_NOTIFICATION);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.notificationDebuggingWindow);
                    } else if (menuItem.getText().equals(DeveloperToolType.UI_EVENT.toString())) {
                        DeveloperTools.this.closeUIEventWindow(false);
                        DeveloperTools.this.uiEventDebuggingWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.UI_EVENT);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.uiEventDebuggingWindow);
                    } else if (menuItem.getText().equals(DeveloperToolType.THREAD_DUMP.toString())) {
                        DeveloperTools.this.closeThreadDumpWindow(false);
                        DeveloperTools.this.threadDumpDebuggingWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.THREAD_DUMP);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.threadDumpDebuggingWindow);
                    } else if (menuItem.getText().equals(DeveloperToolType.THREAD_DIAGNOSTICS.toString())) {
                        DeveloperTools.this.closeThreadDiagnosticsWindow(false);
                        DeveloperTools.this.threadDiagnosticsWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.THREAD_DIAGNOSTICS);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.threadDiagnosticsWindow);
                    } else if (menuItem.getText().equals(DeveloperToolType.CACHE_DIAGNOSTICS.toString())) {
                        DeveloperTools.this.closeCacheDiagnosticsWindow(false);
                        DeveloperTools.this.cacheDiagnosticsWindow = new DeveloperToolWindow(DeveloperTools.this, DeveloperToolType.CACHE_DIAGNOSTICS);
                        DeveloperTools.this.app.addWindow(DeveloperTools.this.cacheDiagnosticsWindow);
                    }
                } else if (menuItem.getText().equals(DeveloperToolType.UI_ACTION.toString())) {
                    DeveloperTools.this.closeUIActionsWindow(true);
                } else if (menuItem.getText().equals(DeveloperToolType.SERVER_NOTIFICATION.toString())) {
                    DeveloperTools.this.closeNotificationsWindow(true);
                } else if (menuItem.getText().equals(DeveloperToolType.UI_EVENT.toString())) {
                    DeveloperTools.this.closeUIEventWindow(true);
                } else if (menuItem.getText().equals(DeveloperToolType.THREAD_DUMP.toString())) {
                    DeveloperTools.this.closeThreadDumpWindow(true);
                } else if (menuItem.getText().equals(DeveloperToolType.THREAD_DIAGNOSTICS.toString())) {
                    DeveloperTools.this.closeThreadDiagnosticsWindow(true);
                } else if (menuItem.getText().equals(DeveloperToolType.CACHE_DIAGNOSTICS.toString())) {
                    DeveloperTools.this.closeCacheDiagnosticsWindow(true);
                }
            }
        }
    };

    public DeveloperTools(App app) {
        this.app = app;
    }

    public void registerDeveloperMenu(AppView appView, IWPMenuItem iWPMenuItem) {
        if (iWPMenuItem != null) {
            this.item = iWPMenuItem.addItem("Developer Tools", null);
            this.item.setVisible(false);
            this.addDebugMenuItems();
            this.app.addActionHandler(this);
        }
    }

    private void addDebugMenuItems() {
        this.uiActionsDebugging = this.generateMenuItem(DeveloperToolType.UI_ACTION.toString(), this.menuCommand);
        this.notificationDebugging = this.generateMenuItem(DeveloperToolType.SERVER_NOTIFICATION.toString(), this.menuCommand);
        this.uiEventDebugging = this.generateMenuItem(DeveloperToolType.UI_EVENT.toString(), this.menuCommand);
        this.threadDumpDebugging = this.generateMenuItem(DeveloperToolType.THREAD_DUMP.toString(), this.menuCommand);
        this.threadDiagnostics = this.generateMenuItem(DeveloperToolType.THREAD_DIAGNOSTICS.toString(), this.menuCommand);
        this.cacheDiagnostics = this.generateMenuItem(DeveloperToolType.CACHE_DIAGNOSTICS.toString(), this.menuCommand);
    }

    private IWPMenuItem generateMenuItem(String string, MenuBar.Command command) {
        return null;
    }

    private boolean validAndVisibleItem() {
        return this.item != null && this.item.isVisible();
    }

    public boolean isUIEventDebuggingSelected() {
        if (this.uiEventDebugging == null) {
            return false;
        }
        return this.uiEventDebugging.isChecked() && this.validAndVisibleItem();
    }

    public boolean isNotificationDebuggingSelected() {
        if (this.notificationDebugging == null) {
            return false;
        }
        return this.notificationDebugging.isChecked() && this.validAndVisibleItem();
    }

    public boolean isActionDebuggingSelected() {
        if (this.uiActionsDebugging == null) {
            return false;
        }
        return this.uiActionsDebugging.isChecked() && this.validAndVisibleItem();
    }

    public final Action[] getActions(Object object, Object object2) {
        return new Action[]{this.showDevTools};
    }

    public final void handleAction(Action action, Object object, Object object2) {
        if (action == this.showDevTools && this.item != null) {
            this.item.setVisible(!this.item.isVisible());
            if (!this.item.isVisible()) {
                this.closeAllWindows();
            }
        }
    }

    public void closeAllWindows() {
        this.closeUIEventWindow(true);
        this.closeUIActionsWindow(true);
        this.closeNotificationsWindow(true);
        this.closeThreadDumpWindow(true);
        this.closeThreadDiagnosticsWindow(true);
        this.closeCacheDiagnosticsWindow(true);
    }

    public void closeUIActionsWindow(boolean bl) {
        if (this.uiActionsDebuggingWindow != null) {
            this.uiActionsDebuggingWindow.close();
        }
        this.uiActionsDebuggingWindow = null;
        if (bl && this.uiActionsDebugging != null) {
            this.uiActionsDebugging.setChecked(false);
        }
    }

    public void closeNotificationsWindow(boolean bl) {
        if (this.notificationDebuggingWindow != null) {
            this.notificationDebuggingWindow.close();
        }
        this.notificationDebuggingWindow = null;
        if (bl && this.notificationDebugging != null) {
            this.notificationDebugging.setChecked(false);
        }
    }

    public void closeUIEventWindow(boolean bl) {
        if (this.uiEventDebuggingWindow != null) {
            this.uiEventDebuggingWindow.close();
        }
        this.uiEventDebuggingWindow = null;
        if (bl && this.uiEventDebugging != null) {
            this.uiEventDebugging.setChecked(false);
        }
    }

    public void closeThreadDumpWindow(boolean bl) {
        if (this.threadDumpDebuggingWindow != null) {
            this.threadDumpDebuggingWindow.close();
        }
        this.threadDumpDebuggingWindow = null;
        if (bl && this.threadDumpDebugging != null) {
            this.threadDumpDebugging.setChecked(false);
        }
    }

    public void closeThreadDiagnosticsWindow(boolean bl) {
        if (this.threadDiagnosticsWindow != null) {
            this.threadDiagnosticsWindow.close();
        }
        this.threadDiagnosticsWindow = null;
        if (bl && this.threadDiagnostics != null) {
            this.threadDiagnostics.setChecked(false);
        }
    }

    public void closeCacheDiagnosticsWindow(boolean bl) {
        if (this.cacheDiagnosticsWindow != null) {
            this.cacheDiagnosticsWindow.close();
        }
        this.cacheDiagnosticsWindow = null;
        if (bl && this.cacheDiagnostics != null) {
            this.cacheDiagnostics.setChecked(false);
        }
    }

    public DeveloperToolWindow getUIActionsWindow() {
        return this.uiActionsDebuggingWindow;
    }

    public DeveloperToolWindow getNitificationsWindow() {
        return this.notificationDebuggingWindow;
    }

    public DeveloperToolWindow getUIEventWindow() {
        return this.uiEventDebuggingWindow;
    }

    public void showUIActionsDebugging(App app, String string, String string2) {
        DeveloperToolWindow developerToolWindow;
        DeveloperTools developerTools = app.getDeveloperTools();
        if (developerTools.isActionDebuggingSelected() && (developerToolWindow = developerTools.getUIActionsWindow()) != null) {
            developerToolWindow.addMessage(string, string2);
        }
    }

    public void showNotificationDebugging(App app, String string, String string2) {
        DeveloperToolWindow developerToolWindow;
        DeveloperTools developerTools = app.getDeveloperTools();
        if (developerTools.isNotificationDebuggingSelected() && (developerToolWindow = developerTools.getNitificationsWindow()) != null) {
            developerToolWindow.addMessage(string, string2);
        }
    }

    public void showUIEventsDebugging(App app, String string, String string2) {
        DeveloperToolWindow developerToolWindow;
        DeveloperTools developerTools = app.getDeveloperTools();
        if (developerTools.isUIEventDebuggingSelected() && (developerToolWindow = developerTools.getUIEventWindow()) != null) {
            developerToolWindow.addMessage(string, string2);
        }
    }
}

