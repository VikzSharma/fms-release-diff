/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.textbox.ObscuredTextBoxWidget;
import com.filemaker.jwpc.iwp.widgetset.client.state.ObscuredEditBoxState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCObscuredFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomEditBox;
import com.google.gwt.core.client.GWT;

public class VCustomObscuredEditBox
extends VCustomEditBox {
    private int oebs = 0;

    @Override
    protected FMCObscuredFieldEventManager initEventManager() {
        return new FMCObscuredFieldEventManager(this.getElement(), this);
    }

    @Override
    protected ObscuredTextBoxWidget initTextBox() {
        return (ObscuredTextBoxWidget)((Object)GWT.create(ObscuredTextBoxWidget.class));
    }

    public ObscuredTextBoxWidget getTextBox() {
        return (ObscuredTextBoxWidget)this.textBox;
    }

    public void setOebs(int n) {
        this.oebs = n;
    }

    private boolean getBooleanState(ObscuredEditBoxState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.oebs, booleanState.ordinal());
    }

    public void onErrorMessageDisplay() {
        this.textBox.removeFromParent();
        this.placeHolder.setClassName("text");
    }

    public void setObscuredEditBoxDescription(String string) {
        this.textBox.getElement().setAttribute("aria-label", string);
    }
}

