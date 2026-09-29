/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.StaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;

public class BusyDialog
extends StaticDialog {
    private boolean allowAbort;
    private boolean isLongScript = false;
    Label msgLabel;

    public BusyDialog(App app, boolean bl) {
        super(app, IWPI18N.get(app, "BUSY_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT);
        this.setResizable(false);
        this.update(bl);
    }

    @Override
    protected void initButtons(String string, String string2, String string3) {
        super.initButtons(string, string2, string3);
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setSpacing(false);
        verticalLayout.setMargin(false);
        this.msgLabel = new Label();
        verticalLayout.addComponent((Component)this.msgLabel);
        verticalLayout.setComponentAlignment((Component)this.msgLabel, Alignment.MIDDLE_CENTER);
        Label label = new Label("<div class=\"fm-progress-indeterminate\"></div>", ContentMode.HTML);
        label.setSizeFull();
        verticalLayout.addComponent((Component)label);
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    public void close() {
        if (this.allowAbort) {
            this.performAbort();
        }
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.performAbort();
    }

    public void showDialog(boolean bl, boolean bl2, String string) {
        this.msgLabel.setValue(string);
        this.showDialog(bl, bl2);
    }

    private void showDialog(boolean bl, boolean bl2) {
        if (this.isLongScript != bl) {
            this.isLongScript = bl;
        }
        this.getLeftButton().setVisible(bl2);
        if (this.allowAbort != bl2) {
            this.update(bl2);
        }
        this.showDialog();
    }

    private void update(boolean bl) {
        this.allowAbort = bl;
    }

    private void performAbort() {
        this.getLeftButton().setVisible(false);
        this.msgLabel.setValue(IWPI18N.get(this.app, "BUSY_DIALOG_WAIT", new Object[0]));
        App app = this.getApplicationRoot();
        if (this.isLongScript) {
            GlobalUIActionHandlers.ABORT_LONG_SCRIPT.perform(app, null);
        } else {
            GlobalUIActionHandlers.ABORT_LONG_OPERATION.perform(app, null);
        }
    }
}

