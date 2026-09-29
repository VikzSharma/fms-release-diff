/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Button
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;

public class DialogButton
extends Button {
    private int MIN_BUTTON_WIDTH = 75;
    private final App app;
    private boolean isTouchUI = false;

    public DialogButton(App app, String string) {
        this(app, string, null);
    }

    public DialogButton(App app, String string, Dialog dialog) {
        super(string);
        this.app = app;
        this.isTouchUI = dialog != null && dialog.isTouchUI();
        this.setButtonWidth(string);
    }

    public void setCaption(String string) {
        if (!this.isTouchUI) {
            this.setButtonWidth(string);
        }
        this.getState().caption = string;
    }

    private void setButtonWidth(String string) {
        int n = this.getButtonWidthWithCaption(string);
        if (n > 0) {
            this.setWidth(n, Sizeable.Unit.PIXELS);
        }
    }

    private int getButtonWidthWithCaption(String string) {
        int n;
        int n2 = n = this.app != null ? IWPUtilities.getStringPixelLengthForButtons(string, true, this.app.getLanguage()) : this.MIN_BUTTON_WIDTH;
        if (n <= this.MIN_BUTTON_WIDTH) {
            return this.MIN_BUTTON_WIDTH;
        }
        return n;
    }

    public void makeFitCaption() {
        if (this.isTouchUI) {
            this.addStyleName("fm-button-fitcaption");
        }
    }
}

