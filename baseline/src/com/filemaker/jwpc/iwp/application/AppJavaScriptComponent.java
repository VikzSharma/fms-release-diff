/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.annotations.JavaScript
 *  com.vaadin.ui.AbstractJavaScriptComponent
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AppJavaScriptState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript(value={"vaadin://launchcenter/AppJavaScript.js"})
public class AppJavaScriptComponent
extends AbstractJavaScriptComponent {
    private final App app;
    private Boolean isRetinaDisplay = null;

    public AppJavaScriptComponent(final App app) {
        this.app = app;
        this.setWidth("0px");
        this.setHeight("0px");
        this.setId("app-javascript-hidden-component");
        this.registerRpc(new AppServerRpc(){
            final /* synthetic */ AppJavaScriptComponent this$0;
            {
                this.this$0 = appJavaScriptComponent;
            }

            @Override
            public void performOnKeyDown(String string, int n, boolean bl) {
                app.onKeystroke(string, n, bl);
            }

            @Override
            public void onOrientationChange(int n, int n2) {
                app.mobileBrowserOrientationChanged(n, n2);
                app.getAppView().centerCurrentDialog();
            }

            @Override
            public void setRetinaDisplay(boolean bl) {
                this.this$0.isRetinaDisplay = bl;
            }

            @Override
            public void closePreviousSession(int n) {
                App app2 = App.getApp(n);
                if (app2 != null) {
                    app2.forceClose(true, false, null);
                }
            }

            @Override
            public void tabPressed(boolean bl) {
                this.this$0.onTabPressed(bl);
            }

            @Override
            public void enterPressed(boolean bl) {
                app.onEnterPressed(bl);
            }

            @Override
            public void attemptLogout() {
                app.attemptSessionLogout();
            }

            @Override
            public void performScript(String string, String string2, String string3) {
                GlobalUIActionHandlers.EXECUTE_SCRIPT_BY_NAME.perform(app, new Object[]{string, string2, string3});
            }

            @Override
            public void setClientOrigin(String string) {
                app.setClientOrigin(string);
            }

            @Override
            public void closeSharingWindow() {
                app.getAppController().getSharingWindowHandler().closeWindow();
            }
        });
    }

    public AppJavaScriptState getState() {
        return (AppJavaScriptState)super.getState();
    }

    public boolean getRetinaDisplay() {
        long l = System.currentTimeMillis();
        while (this.isRetinaDisplay == null) {
            try {
                if (System.currentTimeMillis() - l >= 1000L) break;
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
                break;
            }
        }
        if (this.isRetinaDisplay == null) {
            this.isRetinaDisplay = false;
        }
        return this.isRetinaDisplay;
    }

    public void setClientId(int n) {
        ((AppClientRpc)this.getRpcProxy(AppClientRpc.class)).setClientId(n);
    }

    public void onTabPressed(boolean bl) {
        if (!this.app.isDialogOn()) {
            this.app.getActiveUIHandler().setPendingTabbing(true);
            if (bl) {
                GlobalUIActionHandlers.GOTO_NEXT_FIELD.perform(this.app, null);
            } else {
                GlobalUIActionHandlers.GOTO_PREV_FIELD.perform(this.app, null);
            }
        }
    }

    public void updateShortcutHandlingOnClient(boolean bl) {
        AppJavaScriptState appJavaScriptState = (AppJavaScriptState)this.getState(false);
        if (appJavaScriptState.useFMShortcutHandling != bl) {
            appJavaScriptState.useFMShortcutHandling = bl;
            this.markAsDirty();
        }
    }

    public void updateIsFindModeOnClient(boolean bl) {
        AppJavaScriptState appJavaScriptState = (AppJavaScriptState)this.getState(false);
        if (appJavaScriptState.isFindMode != bl) {
            appJavaScriptState.isFindMode = bl;
            this.markAsDirty();
        }
    }

    public void tryRemoveActiveFieldInBrowser() {
        ((AppClientRpc)this.getRpcProxy(AppClientRpc.class)).tryRemoveActiveField();
    }

    public void tryEnableTabKeyHandlingInBrowser() {
        ((AppClientRpc)this.getRpcProxy(AppClientRpc.class)).tryEnableTabKeyHandling();
    }

    public void deselectTextInBrowser() {
        ((AppClientRpc)this.getRpcProxy(AppClientRpc.class)).deselectText();
    }

    public void enableKeyStroke(boolean bl) {
        this.getState().keyStrokeEnabled = bl;
        this.markAsDirty();
    }

    public void revertActiveObjectValue(String string, String string2) {
        ((AppClientRpc)this.getRpcProxy(AppClientRpc.class)).revertActiveObjectValue(string, string2);
    }

    public void setConfirmLogout(boolean bl) {
        this.getState().confirmLogout = bl;
        this.markAsDirty();
    }

    public void updateAriaCompliantControl(boolean bl) {
        AppJavaScriptState appJavaScriptState = (AppJavaScriptState)this.getState(false);
        if (appJavaScriptState.useAriaCompliantControl != bl) {
            appJavaScriptState.useAriaCompliantControl = bl;
            this.markAsDirty();
        }
    }
}

