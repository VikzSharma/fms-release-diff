/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.MarginInfo
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.data.Validator
 *  com.vaadin.v7.data.util.BeanItem
 *  com.vaadin.v7.data.validator.StringLengthValidator
 *  com.vaadin.v7.event.FieldEvents$TextChangeEvent
 *  com.vaadin.v7.event.FieldEvents$TextChangeListener
 *  com.vaadin.v7.ui.AbstractTextField$TextChangeEventMode
 *  com.vaadin.v7.ui.DefaultFieldFactory
 *  com.vaadin.v7.ui.Field
 *  com.vaadin.v7.ui.Form
 *  com.vaadin.v7.ui.FormFieldFactory
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.PasswordField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ChangePasswordResponse;
import com.filemaker.jwpc.iwp.thrift.notification.ChangePasswordDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.EARPasswordStrength;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogServerRPC;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.data.Validator;
import com.vaadin.v7.data.util.BeanItem;
import com.vaadin.v7.data.validator.StringLengthValidator;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.ui.AbstractTextField;
import com.vaadin.v7.ui.DefaultFieldFactory;
import com.vaadin.v7.ui.Field;
import com.vaadin.v7.ui.Form;
import com.vaadin.v7.ui.FormFieldFactory;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.PasswordField;
import com.vaadin.v7.ui.VerticalLayout;
import java.io.Serializable;
import java.util.Arrays;

public class ChangePasswordDialog
extends ServerInvokedStaticDialog {
    private ChangePasswordResponse response;
    private static final int DIALOG_WIDTH = 450;
    private Account changePassAcct;
    private Label message;
    private VerticalLayout root;
    private Form cpForm;
    private boolean rpcRegistered = false;

    public ChangePasswordDialog(App app, ChangePasswordDialogNotification changePasswordDialogNotification) {
        super(app, IWPI18N.get(app, "CHANGE_PASSWORD_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        super.getRightButton().setCaption(IWPI18N.get(app, "OK", new Object[0]));
        this.setRightButtonDefault();
        this.setDialogWidth(450);
        this.setResizable(false);
        this.changePassAcct = new Account(changePasswordDialogNotification.getUserName());
        this.changePassAcct.setOldPassword(changePasswordDialogNotification.getOldPassword());
        this.changePassAcct.setNewPassword(changePasswordDialogNotification.getNewPassword());
        this.changePassAcct.setConfirmNewPassword(changePasswordDialogNotification.getNewPassword());
        BeanItem beanItem = new BeanItem((Object)this.changePassAcct);
        this.cpForm.setInvalidCommitted(true);
        this.cpForm.setFormFieldFactory((FormFieldFactory)new AccountFieldFactory());
        this.cpForm.setItemDataSource((Item)beanItem);
        this.cpForm.setVisibleItemProperties(Arrays.asList("accountName", "oldPassword", "newPassword", "confirmNewPassword", "strength"));
        if (changePasswordDialogNotification.isPasswordExpired()) {
            this.message.setValue(IWPI18N.get(app, "PASS_EXPIRED_DIALOG_MESSAGE", new Object[0]));
            this.cpForm.getField((Object)"oldPassword").setReadOnly(true);
        } else {
            this.message.setValue(IWPI18N.get(app, "CHANGE_PASSWORD_DIALOG_MESSAGE", new Object[0]));
        }
        this.response = new ChangePasswordResponse(false, "", "");
        this.registerServerRPC();
        ((UserAndPasswordDialogClientRPC)this.getRpcProxy(UserAndPasswordDialogClientRPC.class)).turnOffAutoComplete();
    }

    @Override
    protected Component getContentLayout() {
        this.root = new VerticalLayout();
        this.root.setMargin(new MarginInfo(false, false, false, true));
        this.message = new Label();
        this.root.addComponent((Component)this.message);
        this.cpForm = new Form();
        this.root.addComponent((Component)this.cpForm);
        this.root.setComponentAlignment((Component)this.cpForm, Alignment.BOTTOM_CENTER);
        return this.root;
    }

    private void registerServerRPC() {
        if (!this.rpcRegistered) {
            this.registerRpc(new UserAndPasswordDialogServerRPC(){

                @Override
                public void setDefaultFocus() {
                    ChangePasswordDialog.this.cpForm.getField((Object)"oldPassword").focus();
                }
            });
            this.rpcRegistered = true;
        }
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        if (this.cpForm.isValid()) {
            if (!this.changePassAcct.getNewPassword().equals(this.changePassAcct.getConfirmNewPassword())) {
                this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "CHANGE_PASSWORD_CONFIRM_ERROR", new Object[0]));
            } else if (this.changePassAcct.getOldPassword().equals(this.changePassAcct.getNewPassword())) {
                this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "PASS_EXPIRED_ERROR", new Object[0]));
            } else {
                this.response.setConfirm(true);
                this.response.setOldPass(this.changePassAcct.getOldPassword());
                this.response.setNewPass(this.changePassAcct.getNewPassword());
                super.performRightButtonAction(clickEvent);
            }
        }
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.response.setConfirm(false);
        super.performRightButtonAction(clickEvent);
    }

    @Override
    public Object getResult() {
        return this.response;
    }

    private PasswordField createPasswordField(String string) {
        int n = 100;
        PasswordField passwordField = new PasswordField();
        passwordField.setCaption(IWPI18N.get(this.app, string, new Object[0]));
        passwordField.addValidator((Validator)new StringLengthValidator(IWPI18N.get(this.app, "LENGTH_VALIDTOR", n), Integer.valueOf(0), Integer.valueOf(n), true));
        passwordField.setValidationVisible(true);
        passwordField.setImmediate(true);
        return passwordField;
    }

    public class Account
    implements Serializable {
        private String oldPassword = "";
        private String newPassword = "";
        private String confirmNewPassword = "";
        private String accountName;
        private String strength = "";

        public Account(String string) {
            this.accountName = string;
        }

        public String getOldPassword() {
            return this.oldPassword;
        }

        public void setOldPassword(String string) {
            this.oldPassword = string;
        }

        public String getNewPassword() {
            return this.newPassword;
        }

        public void setNewPassword(String string) {
            this.newPassword = string;
            this.setStrength(EARPasswordStrength.EARPaswordQualityDescription(ChangePasswordDialog.this.app, this.getNewPassword()));
        }

        public String getConfirmNewPassword() {
            return this.confirmNewPassword;
        }

        public void setConfirmNewPassword(String string) {
            this.confirmNewPassword = string;
        }

        public String getAccountName() {
            return this.accountName;
        }

        public String getStrength() {
            return this.strength;
        }

        public void setStrength(String string) {
            this.strength = string;
        }
    }

    private class AccountFieldFactory
    extends DefaultFieldFactory {
        private Field strengthField;

        private AccountFieldFactory() {
        }

        public Field createField(Item item, Object object, Component component) {
            Field field;
            if ("accountName".equals(object)) {
                field = super.createField(item, object, component);
                field.setCaption(IWPI18N.get(ChangePasswordDialog.this.app, "CHANGE_PASSWORD_ACCOUNT", new Object[0]));
            } else if ("oldPassword".equals(object)) {
                field = new PasswordField();
                field.setCaption(IWPI18N.get(ChangePasswordDialog.this.app, "CHANGE_PASSWORD_OLD", new Object[0]));
            } else if ("newPassword".equals(object)) {
                field = ChangePasswordDialog.this.createPasswordField("CHANGE_PASSWORD_NEW");
                ((PasswordField)field).setTextChangeEventMode(AbstractTextField.TextChangeEventMode.LAZY);
                ((PasswordField)field).addTextChangeListener(new FieldEvents.TextChangeListener(){

                    public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                        AccountFieldFactory.this.strengthField.setReadOnly(false);
                        AccountFieldFactory.this.strengthField.setValue((Object)EARPasswordStrength.EARPaswordQualityDescription(ChangePasswordDialog.this.app, textChangeEvent.getText()));
                        AccountFieldFactory.this.strengthField.setReadOnly(true);
                    }
                });
            } else if ("strength".equals(object)) {
                field = super.createField(item, object, component);
                field.setReadOnly(true);
                field.setCaption(IWPI18N.get(ChangePasswordDialog.this.app, "PASSWORD_QUALITY", new Object[0]));
                this.strengthField = field;
            } else {
                field = ChangePasswordDialog.this.createPasswordField("CHANGE_PASSWORD_CONFIRM");
            }
            return field;
        }
    }
}

