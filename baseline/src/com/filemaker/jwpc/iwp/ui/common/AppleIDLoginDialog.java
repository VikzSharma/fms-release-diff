/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.shared.ui.window.WindowMode
 *  com.vaadin.ui.Button$ClickEvent
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.notification.AppleIDLoginDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.AppleIDLoginDialogBase;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Button;
import java.util.Timer;
import java.util.TimerTask;

public class AppleIDLoginDialog
extends AppleIDLoginDialogBase {
    public AppleIDLoginDialog(App app, AppleIDLoginDialogNotification appleIDLoginDialogNotification) {
        super(app, IWPI18N.get(app, "OAUTH_PROVIDER_APPLEID_BUTTON_STR", new Object[0]), Dialog.ButtonOption.LEFT_MIDDLE_RIGHT);
        if (appleIDLoginDialogNotification.isIsFirstTime()) {
            this.setPasscodeUIVisible(false);
        } else {
            this.emailTF.setValue(appleIDLoginDialogNotification.getEmail());
            this.bSignIn.setEnabled(false);
            if (appleIDLoginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdPasscodeExpireErrorStrID.getErrorCode() && appleIDLoginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdPasscodeNotFoundErrorStrID.getErrorCode() && appleIDLoginDialogNotification.getError().getErrorCode() != ErrorCode.InvalidAppleIdTypeAccountErrorStrID.getErrorCode() && appleIDLoginDialogNotification.getError().getErrorCode() != ErrorCode.AppleIdAccountDisabledErrorStrID.getErrorCode()) {
                this.bSendEmail.setEnabled(false);
                this.addTimer();
            }
        }
        if (IWPUtilities.hasError(appleIDLoginDialogNotification.getError())) {
            if (appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.SendPasscodeEmailFailedError.getErrorCode() || appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.SMTPEmailSendFailed.getErrorCode() || appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.InvalidEmailFormatError.getErrorCode()) {
                this.emailErrorMsg.setValue(app.getMessenger().getUserFriendlyErrorMessage(appleIDLoginDialogNotification.getError()));
            } else if (appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.AppleIdPasscodeExpireErrorStrID.getErrorCode() || appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.AppleIdPasscodeNotFoundErrorStrID.getErrorCode() || appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.InvalidAppleIdTypeAccountErrorStrID.getErrorCode() || appleIDLoginDialogNotification.getError().getErrorCode() == ErrorCode.AppleIdAccountDisabledErrorStrID.getErrorCode()) {
                this.loginErrorMsg.setValue(app.getMessenger().getUserFriendlyErrorMessage(appleIDLoginDialogNotification.getError()));
            }
        }
        if (BrowserInfoHandler.isMobile(app)) {
            this.useCustomCloseButton();
            this.setWindowMode(WindowMode.MAXIMIZED);
            this.setHeaderVisible(false);
            this.setHasWidthConstraint(false);
        } else {
            this.setClosable(true);
        }
        this.registerServerRPC();
    }

    private void addTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            private int countDown = 30;

            @Override
            public void run() {
                if (this.countDown > 0) {
                    AppleIDLoginDialog.this.bSendEmail.setText("" + this.countDown);
                } else {
                    AppleIDLoginDialog.this.bSendEmail.setText(IWPI18N.get(AppleIDLoginDialog.this.app, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
                    AppleIDLoginDialog.this.bSendEmail.setEnabled(true);
                    this.cancel();
                }
                AppleIDLoginDialog.this.app.pushChanges();
                --this.countDown;
            }
        }, 0L, 1000L);
    }

    private void setPasscodeUIVisible(boolean bl) {
        this.passcodeHeaderMsg.setVisible(bl);
        for (int i = 0; i < 6; ++i) {
            this.tabTextFields[i].setVisible(bl);
        }
        this.loginErrorMsg.setVisible(bl);
        this.bSignIn.setVisible(bl);
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
    protected void performMiddleButtonAction(Button.ClickEvent clickEvent) {
        if (!((String)this.emailTF.getValue()).isEmpty()) {
            this.response.setConfirm(true);
            this.response.setSend(true);
            this.response.setEmail((String)this.emailTF.getValue());
            super.performMiddleButtonAction(clickEvent);
        }
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.response.setConfirm(true);
        this.response.setLogin(true);
        this.response.setEmail((String)this.emailTF.getValue());
        this.response.setPasscode((String)this.tabTextFields[0].getValue() + (String)this.tabTextFields[1].getValue() + (String)this.tabTextFields[2].getValue() + (String)this.tabTextFields[3].getValue() + (String)this.tabTextFields[4].getValue() + (String)this.tabTextFields[5].getValue());
        super.performRightButtonAction(clickEvent);
    }
}

