/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Window$CloseEvent
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.fields.FMField;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.IDialogResult;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.vaadin.ui.Window;

public abstract class ServerInvokedDialog
extends Dialog
implements IDialogResult {
    private FMField activeField = null;

    public ServerInvokedDialog(App app, String string) {
        this(app, string, Dialog.ButtonOption.LEFT);
    }

    public ServerInvokedDialog(App app, String string, Dialog.ButtonOption buttonOption) {
        super(app, string, buttonOption);
    }

    @Override
    public boolean showDialog() {
        LayoutFieldObject layoutFieldObject;
        this.app.getMessenger().setBusyDialogInvisible();
        if (this.app.getActiveUIHandler().getActiveObjectMetaData() != null && this.app.getActiveUIHandler().getActiveObjectMetaData().isField() && (layoutFieldObject = this.app.getActiveUIHandler().getActiveField(false, false)) instanceof FMField) {
            this.activeField = (FMField)((Object)this.app.getActiveUIHandler().getActiveField(false, false));
            if (this.activeField.isResetScrollPositionOnExit()) {
                this.activeField.setResetScrollPositionOnExit(false);
            } else {
                this.activeField = null;
            }
        }
        return super.showDialog();
    }

    @Override
    protected void onWindowClose(Window.CloseEvent closeEvent) {
        super.onWindowClose(closeEvent);
        this.app.getMessenger().setBusyDialogVisible();
        if (this.activeField != null) {
            this.activeField.setResetScrollPositionOnExit(true);
            this.activeField = null;
        }
    }
}

