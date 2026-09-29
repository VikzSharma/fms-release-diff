/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.ComboBox
 */
package com.filemaker.jwpc.iwp.ui.statusarea.component;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.QuickFindFieldServerRpc;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.v7.ui.ComboBox;

public class QuickFindField
extends ComboBox {
    private final App app;
    private boolean tabbedOut;

    public QuickFindField(App app) {
        this.app = app;
        this.registerServerRpc();
    }

    private void performQuickFind(String string) {
        if (AppServlet.isAriaCompliantControlEnabled() && this.tabbedOut) {
            return;
        }
        if (Utilities.isValidText(string)) {
            GlobalUIActionHandlers.PERFORM_QUICK_FIND.perform(this.app, new Object[]{string});
        }
    }

    private void registerServerRpc() {
        QuickFindFieldServerRpc quickFindFieldServerRpc = new QuickFindFieldServerRpc(){

            @Override
            public void onTabToExit() {
                QuickFindField.this.tabbedOut = true;
            }

            @Override
            public void onEnter(String string) {
                QuickFindField.this.performQuickFind(string);
            }

            @Override
            public void onFocus() {
                QuickFindField.this.tabbedOut = false;
            }
        };
        this.registerRpc(quickFindFieldServerRpc);
    }
}

