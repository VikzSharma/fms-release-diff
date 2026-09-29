/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.action.ActionResultHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.KeystrokeEvent;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.listener.KeystrokeListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;

public class KeystrokeScriptTriggerListener
implements KeystrokeListener {
    private boolean isEnabled = false;

    @Override
    public void onKeystroke(String string, int n, boolean bl) {
        if (this.isEnabled()) {
            this.performKeyStroke(string, n, bl);
        }
    }

    private void performKeyStroke(String string, int n, boolean bl) {
        final App app = App.getCurrent();
        if (app.isDialogOn()) {
            return;
        }
        KeystrokeEvent keystrokeEvent = new KeystrokeEvent(n, bl, "");
        final LayoutFieldObject layoutFieldObject = app.getActiveUIHandler().getActiveField(false, false);
        if (layoutFieldObject != null) {
            if (layoutFieldObject.getMetaData().isEditBox()) {
                final String string2 = string != null ? string : (String)layoutFieldObject.getFieldData();
                keystrokeEvent.setCurrentText(string2);
                app.getAppView().setFlagForKeystrokeResult(false);
                app.getAppSession().handleKeystroke(new ActionResultHandler(){

                    @Override
                    public void onFinish(UIActionType uIActionType, Result result) {
                        if (IWPUtilities.hasError(result.getError()) && app != null && !app.getAppView().shouldIgnoreKeystrokeErrorForCardWin() && layoutFieldObject.hasDelegate()) {
                            StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(new StringData(string2, false, null, false), DBAccessLevel.UnknownAccess, false, false, "", false, false, 0, 0, false);
                            layoutFieldObject.updateFieldObjectData(stringDataUpdateParameters, false);
                            if (layoutFieldObject instanceof LayoutTextFieldObject) {
                                LayoutTextFieldObject layoutTextFieldObject = (LayoutTextFieldObject)layoutFieldObject;
                                app.revertActiveObjectValue(layoutTextFieldObject, string2);
                            }
                        }
                    }
                }, keystrokeEvent);
            }
        } else {
            app.getAppSession().handleKeystroke(null, keystrokeEvent);
        }
    }

    @Override
    public synchronized boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public synchronized void setEnabled(boolean bl) {
        this.isEnabled = bl;
    }
}

