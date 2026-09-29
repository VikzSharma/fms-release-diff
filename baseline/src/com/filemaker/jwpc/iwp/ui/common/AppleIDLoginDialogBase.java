/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.event.ShortcutListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.ui.window.WindowMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.AppleIDLoginResponse;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.layout.component.AppleIDSendEmailButton;
import com.filemaker.jwpc.iwp.ui.layout.component.AppleIDSignInButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDLoginDialogServerRpc;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;

public abstract class AppleIDLoginDialogBase
extends ServerInvokedStaticDialog {
    private static final String APPLEID_LOGIN_DIALOG_WRAPPER_ID = "appleid_login_dialog_wrapper";
    private static final String APPLEID_LOGIN_DIALOG_BODY_ID = "appleid_login_dialog_body";
    private static final String APPLEID_EAMIL_HEADER_ID = "appleid_email_header_msg";
    private static final String APPLEID_PASSCODE_HEADER_ID = "appleid_passcode_header_msg";
    private static final String APPLEID_EAMIL_TEXTFIELD_ID = "login_appleid_email";
    private static final String APPLEID_PASSCODE_TEXTFIELD_ID = "login_appleid_passcode";
    private static final String CSS_CLASS_APPLEID_LOGIN = "fm-appleid-login-dialog-overlay";
    private static final String CSS_CLASS_APPLEID_MOBILE = "fm-mobile-appleid-login-dialog";
    private static final String CSS_CLASS_APPLEID_BODY_WRAPPER = "fm-appleid-login-dialog-body-wrapper";
    private static final String CSS_CLASS_APPLEID_BODY = "fm-appleid-login-dialog-body";
    private static final String CSS_CLASS_AUTH_PANEL = "fm-appleid-login-dialog-auth-panel";
    private static final String CSS_CLASS_APPLEID_TEXTFIELD = "fm-appleid-login-dialog-textfield";
    private static final String CSS_CLASS_APPLEID_CLOSE_BUTTON = "fm-appleid-login-dialog-close-button";
    private static final String CSS_CLASS_APPLEID_PASSCODE = "fm-appleid-login-dialog-passcode";
    protected static final int DIALOG_WIDTH = 400;
    protected static final int DEFAULT_COMPONENT_WIDTH = 298;
    protected static final int PASSCODE_ITEM_WIDTH = 42;
    protected static final int EMAIL_MAX_INPUT_LEN = 100;
    protected static final int PASSCODE_MAX_INPUT_LEN = 6;
    protected static final int PASSCODE_MAX_ITEM_LEN = 1;
    protected static final String APPLEID_INFO_CSS_CLASS_NAME = "appleid_login_header";
    protected static final String APPLEID_ERROR_CSS_CLASS_NAME = "appleid_login_error";
    protected AppleIDLoginResponse response = null;
    protected boolean isConfirm;
    protected boolean isSend;
    protected TextField emailTF;
    protected TextField[] tabTextFields;
    protected CssLayout bodyWrapper;
    protected CssLayout body;
    protected CssLayout appleidLayout;
    protected Label emailHeaderMsg;
    protected Label passcodeHeaderMsg;
    protected Label emailErrorMsg;
    protected Label loginErrorMsg;
    protected AppleIDSendEmailButton bSendEmail;
    protected AppleIDSignInButton bSignIn;
    protected boolean rpcRegistered = false;

    public AppleIDLoginDialogBase(App app, String string, Dialog.ButtonOption buttonOption) {
        super(app, string, buttonOption);
        this.addStyleName(CSS_CLASS_APPLEID_LOGIN);
        this.emailTF.setValue("");
        this.response = new AppleIDLoginResponse(false, false, false, "", "");
        this.setDialogWidth(400);
        this.setResizable(false);
        this.hideButtons();
    }

    @Override
    protected void init() {
        super.init();
        this.root.setSpacing(false);
    }

    @Override
    protected String getMiddleButtonText() {
        return IWPI18N.get(this.app, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]);
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "LOGIN_APPLEID_OK_INFO", new Object[0]);
    }

    protected void registerServerRPC() {
        if (!this.rpcRegistered) {
            AppleIDLoginDialogServerRpc appleIDLoginDialogServerRpc = new AppleIDLoginDialogServerRpc(){

                @Override
                public void handleEmailPaste(String string) {
                    AppleIDLoginDialogBase.this.emailTF.setValue(string);
                }

                @Override
                public void handlePasscodePaste(String string) {
                    if (string.length() > 6) {
                        string = string.substring(0, 6);
                    }
                    for (int i = 0; i < string.length(); ++i) {
                        AppleIDLoginDialogBase.this.tabTextFields[i].setValue(String.valueOf(string.charAt(i)));
                    }
                    AppleIDLoginDialogBase.this.changeSignInButtonStatus();
                }

                @Override
                public void handleOnKeyUpEvent(boolean bl, boolean bl2, int n, String string) {
                    if (n != -1 && string != null) {
                        if (bl2) {
                            if (n != 0) {
                                AppleIDLoginDialogBase.this.tabTextFields[n - 1].selectAll();
                            } else {
                                AppleIDLoginDialogBase.this.tabTextFields[0].selectAll();
                            }
                            if (bl) {
                                AppleIDLoginDialogBase.this.tabTextFields[n].setValue("");
                            }
                        } else {
                            AppleIDLoginDialogBase.this.tabTextFields[n].setValue(string);
                            if (n != 5) {
                                AppleIDLoginDialogBase.this.tabTextFields[n + 1].selectAll();
                            }
                        }
                    }
                    AppleIDLoginDialogBase.this.changeSignInButtonStatus();
                }
            };
            this.registerRpc(appleIDLoginDialogServerRpc);
            this.rpcRegistered = true;
        }
    }

    @Override
    protected Component getContentLayout() {
        this.bodyWrapper = new CssLayout();
        this.bodyWrapper.setId(APPLEID_LOGIN_DIALOG_WRAPPER_ID);
        this.bodyWrapper.addStyleName(CSS_CLASS_APPLEID_BODY_WRAPPER);
        this.bodyWrapper.setSizeUndefined();
        this.body = new CssLayout();
        this.body.setId(APPLEID_LOGIN_DIALOG_BODY_ID);
        this.body.addStyleName(CSS_CLASS_APPLEID_BODY);
        this.body.setSizeUndefined();
        this.bodyWrapper.addComponent((Component)this.body);
        this.appleidLayout = this.addAuthInfoLayout();
        this.appleidLayout.addShortcutListener(new ShortcutListener(null, 13, null){

            public void handleAction(Object object, Object object2) {
                AppleIDLoginDialogBase.this.triggerDefaultButton();
            }
        });
        this.body.addComponent((Component)this.appleidLayout);
        CssLayout cssLayout = new CssLayout();
        cssLayout.setHeight(5.0f, Sizeable.Unit.PIXELS);
        this.bodyWrapper.addComponent((Component)cssLayout);
        return this.bodyWrapper;
    }

    private CssLayout addAuthInfoLayout() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.setStyleName(CSS_CLASS_AUTH_PANEL);
        cssLayout.setWidthUndefined();
        this.emailHeaderMsg = new Label(IWPI18N.get(this.app, "LOGIN_APPLEID_INFO", new Object[0]));
        this.emailHeaderMsg.setId(APPLEID_EAMIL_HEADER_ID);
        this.emailHeaderMsg.setStyleName(APPLEID_INFO_CSS_CLASS_NAME);
        this.emailHeaderMsg.addStyleName("visible");
        this.emailHeaderMsg.setWidthUndefined();
        cssLayout.addComponent((Component)this.emailHeaderMsg);
        this.emailErrorMsg = new Label();
        this.emailErrorMsg.setStyleName(APPLEID_ERROR_CSS_CLASS_NAME);
        this.emailErrorMsg.setWidthUndefined();
        cssLayout.addComponent((Component)this.emailErrorMsg);
        this.emailTF = new TextField();
        this.emailTF.setId(APPLEID_EAMIL_TEXTFIELD_ID);
        this.emailTF.setStyleName(CSS_CLASS_APPLEID_TEXTFIELD);
        this.emailTF.setWidth(298.0f, Sizeable.Unit.PIXELS);
        this.emailTF.setMaxLength(100);
        cssLayout.addComponent((Component)this.emailTF);
        this.bSendEmail = new AppleIDSendEmailButton(this, IWPI18N.get(this.app, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
        cssLayout.addComponent((Component)this.bSendEmail);
        this.passcodeHeaderMsg = new Label(IWPI18N.get(this.app, "LOGIN_APPLEID_PASSCODE_INFO", new Object[0]));
        this.passcodeHeaderMsg.setId(APPLEID_PASSCODE_HEADER_ID);
        this.passcodeHeaderMsg.setStyleName(APPLEID_INFO_CSS_CLASS_NAME);
        this.passcodeHeaderMsg.addStyleName("visible");
        this.passcodeHeaderMsg.setWidthUndefined();
        cssLayout.addComponent((Component)this.passcodeHeaderMsg);
        this.loginErrorMsg = new Label();
        this.loginErrorMsg.setStyleName(APPLEID_ERROR_CSS_CLASS_NAME);
        this.loginErrorMsg.setWidthUndefined();
        cssLayout.addComponent((Component)this.loginErrorMsg);
        this.tabTextFields = new TextField[6];
        for (int i = 0; i < 6; ++i) {
            this.tabTextFields[i] = new TextField();
            this.tabTextFields[i].setWidth(42.0f, Sizeable.Unit.PIXELS);
            this.tabTextFields[i].setMaxLength(1);
            this.tabTextFields[i].setId(APPLEID_PASSCODE_TEXTFIELD_ID + i);
            this.tabTextFields[i].setStyleName(CSS_CLASS_APPLEID_PASSCODE);
            cssLayout.addComponent((Component)this.tabTextFields[i]);
        }
        this.bSignIn = new AppleIDSignInButton(this, IWPI18N.get(this.app, "LOGIN_APPLEID_OK_INFO", new Object[0]));
        cssLayout.addComponent((Component)this.bSignIn);
        return cssLayout;
    }

    private void changeSignInButtonStatus() {
        if (!(((String)this.tabTextFields[0].getValue()).trim().isEmpty() || ((String)this.tabTextFields[1].getValue()).trim().isEmpty() || ((String)this.tabTextFields[2].getValue()).trim().isEmpty() || ((String)this.tabTextFields[3].getValue()).trim().isEmpty() || ((String)this.tabTextFields[4].getValue()).trim().isEmpty() || ((String)this.tabTextFields[5].getValue()).trim().isEmpty())) {
            if (!this.bSignIn.isEnabled()) {
                this.bSignIn.setEnabled(true);
                this.setRightButtonDefault();
            }
        } else if (this.bSignIn.isEnabled()) {
            this.bSignIn.setEnabled(false);
            this.setMiddleButtonDefault();
        }
    }

    public void signInWithAppleID() {
        if (this.getRightButton() != null && this.getRightButton().isEnabled()) {
            this.getRightButton().click();
        }
    }

    public void triggerDefaultButton() {
        if (this.getMiddleButton().getStyleName().contains("primary")) {
            this.sendEmailForAppleID();
        } else if (this.getRightButton().getStyleName().contains("primary")) {
            this.signInWithAppleID();
        }
    }

    public void sendEmailForAppleID() {
        if (this.getMiddleButton() != null && this.getMiddleButton().isEnabled()) {
            this.getMiddleButton().click();
        }
    }

    protected void useCustomCloseButton() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName(CSS_CLASS_APPLEID_CLOSE_BUTTON);
        cssLayout.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                if (AppleIDLoginDialogBase.this.getLeftButton() != null) {
                    AppleIDLoginDialogBase.this.getLeftButton().click();
                }
            }
        });
        this.root.addComponentAsFirst((Component)cssLayout);
    }

    @Override
    public Object getResult() {
        return this.response;
    }

    public void setWindowMode(WindowMode windowMode) {
        super.setWindowMode(windowMode);
        if (windowMode == WindowMode.MAXIMIZED) {
            this.root.addStyleName(CSS_CLASS_APPLEID_MOBILE);
        } else {
            this.root.removeStyleName(CSS_CLASS_APPLEID_MOBILE);
        }
    }
}

