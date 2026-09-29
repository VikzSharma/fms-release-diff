/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$BlurListener
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.shared.ui.window.WindowMode
 *  com.vaadin.ui.Button$ClickEvent
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.notification.LoginDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.LoginDialogBase;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Button;

public class UserLoginDialog
extends LoginDialogBase {
    public UserLoginDialog(App app, LoginDialogNotification loginDialogNotification) {
        super(app, IWPI18N.get(app, "LOGIN", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        this.getState().header = IWPI18N.get(app, "LOGIN_INFO", new Object[0]);
        this.getState().dbName = loginDialogNotification.getDatabaseName();
        this.getState().ellipsis = IWPI18N.get(app, "LOGIN_INFO_ELLIPSIS", new Object[0]);
        if (BrowserInfoHandler.isMobile(app)) {
            this.useCustomCloseButton();
            this.setWindowMode(WindowMode.MAXIMIZED);
            this.setHeaderVisible(false);
            this.setHasWidthConstraint(false);
        } else {
            this.setClosable(true);
        }
        if (IWPUtilities.hasError(loginDialogNotification.getError())) {
            if (this.app.getLastAuthErrorCode() == -1) {
                this.app.setLastAuthErrorCode(0);
                IWPError iWPError = new IWPError();
                iWPError.setErrorCode(ErrorCode.URLConnectionAuthenticationFalied.getErrorCode());
                this.errorMessage.setValue(app.getMessenger().getUserFriendlyErrorMessage(iWPError));
            } else if (loginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdNotFoundErrorStrID.getErrorCode() && loginDialogNotification.getError().getErrorCode() != ErrorCode.InvalidAppleIdTypeAccountErrorStrID.getErrorCode() && loginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdPasscodeExpireErrorStrID.getErrorCode() && loginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdPasscodeNotFoundErrorStrID.getErrorCode() && loginDialogNotification.getError().getErrorCode() != ErrorCode.InvalidEmailFormatError.getErrorCode() && loginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdAccountDisabledErrorStrID.getErrorCode()) {
                this.errorMessage.setValue(app.getMessenger().getUserFriendlyErrorMessage(loginDialogNotification.getError()));
                this.acctNameTF.addStyleName("error");
                this.passwordTF.addStyleName("error");
                this.acctNameTF.addFocusListener(new FieldEvents.FocusListener(){

                    public void focus(FieldEvents.FocusEvent focusEvent) {
                        UserLoginDialog.this.acctNameTF.removeStyleName("error");
                    }
                });
                this.acctNameTF.addBlurListener(new FieldEvents.BlurListener(){

                    public void blur(FieldEvents.BlurEvent blurEvent) {
                        if (((String)UserLoginDialog.this.acctNameTF.getValue()).isEmpty()) {
                            UserLoginDialog.this.acctNameTF.addStyleName("error");
                        }
                    }
                });
                this.passwordTF.addFocusListener(new FieldEvents.FocusListener(){

                    public void focus(FieldEvents.FocusEvent focusEvent) {
                        UserLoginDialog.this.passwordTF.removeStyleName("error");
                    }
                });
                this.passwordTF.addBlurListener(new FieldEvents.BlurListener(){

                    public void blur(FieldEvents.BlurEvent blurEvent) {
                        if (((String)UserLoginDialog.this.passwordTF.getValue()).isEmpty()) {
                            UserLoginDialog.this.passwordTF.addStyleName("error");
                        }
                    }
                });
            }
            IWPUtilities.setAttributeById(app, "login_name", "aria-describedby", "login_error_msg");
        } else {
            this.errorMessage.setVisible(false);
        }
        this.guestLogin.setVisible(loginDialogNotification.isGuestEnabled());
        if (this.getApplicationRoot().getBrowserInfoHandler().getBrowserClientInfo().isSecureConnection() && loginDialogNotification.isHosted()) {
            this.initOAuthUI(loginDialogNotification.isHideLocalAccountEntry());
        }
        this.setRightButtonDefault();
        this.registerServerRPC();
    }

    @Override
    protected void setHasWidthConstraint(boolean bl) {
        super.setHasWidthConstraint(bl);
        if (this.isTouchUI()) {
            if (bl) {
                this.addStyleName("fm-touch-minmax");
            } else {
                this.removeStyleName("fm-touch-minmax");
            }
        }
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "OK", new Object[0]);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.response.setConfirm(true);
        this.response.setGuestLogin(this.isGuest);
        this.response.setOauthLogin(this.isOAuth);
        if (this.isOAuth) {
            this.response.setUsername(this.oauthRequestId);
            this.response.setPassword(this.oauthIdentifier);
        } else {
            this.response.setUsername((String)this.acctNameTF.getValue());
            this.response.setPassword((String)this.passwordTF.getValue());
        }
        super.performRightButtonAction(clickEvent);
    }
}

