/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.ActiveUIHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;

public class FieldListener {
    protected final App app;
    protected final LayoutFieldObject fieldObject;

    public FieldListener(App app, LayoutFieldObject layoutFieldObject) {
        this.app = app;
        this.fieldObject = layoutFieldObject;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void onFieldObjectClick(boolean bl) {
        if (!this.app.isDialogOn()) {
            ActiveUIHandler activeUIHandler;
            ActiveUIHandler activeUIHandler2 = activeUIHandler = this.app.getActiveUIHandler();
            synchronized (activeUIHandler2) {
                if (!activeUIHandler.isActiveObject(this.fieldObject)) {
                    if (!this.fieldObject.getMetaData().isCheckBox() && !this.fieldObject.getMetaData().isRadioSet()) {
                        GlobalUIActionHandlers.ENTER_FIELD.perform(this.app, new Object[]{this.fieldObject, bl});
                    }
                } else {
                    activeUIHandler.refreshActiveUI(this.fieldObject);
                }
            }
        }
    }
}

