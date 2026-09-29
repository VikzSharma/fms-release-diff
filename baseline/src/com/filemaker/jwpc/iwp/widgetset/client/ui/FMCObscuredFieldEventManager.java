/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Element
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomObscuredEditBox;
import com.google.gwt.user.client.Element;

public class FMCObscuredFieldEventManager
extends FMCTextFieldEventManager {
    private VCustomObscuredEditBox textField;

    public FMCObscuredFieldEventManager(Element element, FMCTextField fMCTextField) {
        super(element, fMCTextField);
        this.textField = (VCustomObscuredEditBox)fMCTextField;
    }

    @Override
    protected void handleTabInsertion() {
    }

    @Override
    protected void prepareForFocus() {
        super.prepareForFocus();
        if (!FMCUtilities.isMobile()) {
            this.textField.getTextBox().getElement().removeAttribute("readonly");
        }
    }

    @Override
    protected void removeActiveState() {
        super.removeActiveState();
        if (!FMCUtilities.isMobile()) {
            this.textField.getTextBox().getElement().setAttribute("readonly", "true");
        }
    }
}

