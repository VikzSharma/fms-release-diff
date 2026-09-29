/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.vaadin.ui.Component;

public abstract class StaticDialog
extends Dialog {
    public StaticDialog(App app, String string, Dialog.ButtonOption buttonOption) {
        super(app, string, buttonOption);
        this.initContent(this.getContentLayout());
        String string2 = this.getLeftButtonText();
        String string3 = this.getMiddleButtonText();
        String string4 = this.getRightButtonText();
        this.initButtons(string2, string3, string4);
    }

    protected abstract Component getContentLayout();
}

