/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Window$CloseEvent
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.IDialogResult;
import com.filemaker.jwpc.iwp.ui.common.StaticDialog;
import com.vaadin.ui.Window;

public abstract class ServerInvokedStaticDialog
extends StaticDialog
implements IDialogResult {
    public ServerInvokedStaticDialog(App app, String string) {
        this(app, string, Dialog.ButtonOption.LEFT);
    }

    public ServerInvokedStaticDialog(App app, String string, Dialog.ButtonOption buttonOption) {
        super(app, string, buttonOption);
    }

    @Override
    public boolean showDialog() {
        this.app.getMessenger().setBusyDialogInvisible();
        return super.showDialog();
    }

    @Override
    protected void onWindowClose(Window.CloseEvent closeEvent) {
        super.onWindowClose(closeEvent);
        this.app.getMessenger().setBusyDialogVisible();
    }
}

