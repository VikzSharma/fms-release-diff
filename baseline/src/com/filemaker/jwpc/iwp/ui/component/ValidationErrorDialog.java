/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.ValidationErrorAction;
import com.filemaker.jwpc.iwp.thrift.notification.ValidationErrorDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;

public class ValidationErrorDialog
extends ServerInvokedDialog {
    private final App app;
    private static final String TITLE_KEY = "ERROR_DIALOG_TITLE";
    private static final int DIALOG_WIDTH = 450;
    private static final String MAX_CONTAINER_KB = "4000000";
    private static final String MESSAGE_KEY_PREFIX = "VERROR";
    private static final String MESSAGE_KEY_SEPARATOR = "_";
    private static final String STRICT_KEY = "STRICT";
    private static final String GENERIC_KEY = "GENERIC";
    private static final String CONTAINER_KEY = "CONTAINER";
    private static final String ALLOW_INVALID_VALUE_MESSAGE_KEY = "ALLOW_INVALID_VALUE";
    private static final String MUST_ENTER_VALUE_MESSAGE_KEY = "MUST_ENTER_VALUE";
    private static final String USE_ANOTHER_LAYOUT_MESSAGE_KEY = "USE_ANOTHER_LAYOUT";
    private static final String USE_ANOTHER_LAYOUT_GENERIC_MESSAGE_KEY = "USE_ANOTHER_LAYOUT_GENERIC";
    private ValidationErrorAction leftButtonAction;
    private ValidationErrorAction middleButtonAction;
    private ValidationErrorAction rightButtonAction;
    private ValidationErrorAction result;

    public ValidationErrorDialog(App app, ValidationErrorDialogNotification validationErrorDialogNotification) {
        super(app, IWPI18N.get(app, TITLE_KEY, new Object[0]));
        this.removeCloseShortcut();
        this.app = app;
        this.setDialogWidth(450);
        this.setResizable(false);
        String string = this.getMessage(validationErrorDialogNotification);
        this.initContent(this.getContentLayout(string));
        this.initButtons(validationErrorDialogNotification);
    }

    private String getMessage(ValidationErrorDialogNotification validationErrorDialogNotification) {
        String string;
        String string2 = null;
        string2 = validationErrorDialogNotification.isHasMessage() ? validationErrorDialogNotification.getMessage() : (validationErrorDialogNotification.isAnotherLayoutMessage() ? (!Utilities.isEmptyString(string = validationErrorDialogNotification.getError().getErrorAttributes().get((Object)Attribute.FIELDNAME)) ? IWPI18N.get(this.app, USE_ANOTHER_LAYOUT_MESSAGE_KEY, string) : IWPI18N.get(this.app, USE_ANOTHER_LAYOUT_GENERIC_MESSAGE_KEY, new Object[0])) : this.getUserFriendlyValidationErrorMessage(validationErrorDialogNotification));
        return string2;
    }

    private String getUserFriendlyValidationErrorMessage(ValidationErrorDialogNotification validationErrorDialogNotification) {
        StringBuilder stringBuilder = new StringBuilder();
        IWPError iWPError = validationErrorDialogNotification.getError();
        boolean bl = IWPUtilities.hasError(iWPError);
        if (bl) {
            String string = "";
            int n = iWPError.getErrorCode();
            boolean bl2 = validationErrorDialogNotification.isStrictDataType();
            ErrorCode errorCode = ErrorCode.fromValue((int)n);
            switch (errorCode) {
                case InvalidDate: 
                case InvalidTime: {
                    String string2 = validationErrorDialogNotification.getSampleDateTimeFormat();
                    switch (validationErrorDialogNotification.getFieldDataType()) {
                        case DATE: {
                            string = this.getErrorStringKey(ErrorCode.InvalidDate.getErrorCode(), null, bl2);
                            break;
                        }
                        case TIME: {
                            string = this.getErrorStringKey(ErrorCode.InvalidTime.getErrorCode(), null, bl2);
                            break;
                        }
                        case TIMESTAMP: {
                            string = this.getErrorStringKey(ErrorCode.InvalidDate.getErrorCode(), String.valueOf(ErrorCode.InvalidTime.getErrorCode()), bl2);
                            break;
                        }
                        default: {
                            string = errorCode == ErrorCode.InvalidDate ? this.getErrorStringKey(ErrorCode.InvalidDate.getErrorCode(), null, bl2) : this.getErrorStringKey(ErrorCode.InvalidTime.getErrorCode(), null, bl2);
                        }
                    }
                    stringBuilder.append(IWPI18N.get(this.app, string, string2));
                    stringBuilder.append("  ");
                    if (validationErrorDialogNotification.isAllowOverride()) {
                        stringBuilder.append(IWPI18N.get(this.app, ALLOW_INVALID_VALUE_MESSAGE_KEY, new Object[0]));
                        break;
                    }
                    stringBuilder.append(IWPI18N.get(this.app, MUST_ENTER_VALUE_MESSAGE_KEY, new Object[0]));
                    break;
                }
                case ValueOutOfRange: {
                    String string3 = iWPError.getErrorAttributes().get((Object)Attribute.VALUE_RANGE_MIN);
                    String string4 = iWPError.getErrorAttributes().get((Object)Attribute.VALUE_RANGE_MAX);
                    if (Utilities.isEmptyString(string3) || Utilities.isEmptyString(string4)) {
                        string = this.getErrorStringKey(n, GENERIC_KEY, bl2);
                        stringBuilder.append(IWPI18N.get(this.app, string, new Object[0]));
                        break;
                    }
                    string = this.getErrorStringKey(n, null, bl2);
                    stringBuilder.append(IWPI18N.get(this.app, string, string3, string4));
                    break;
                }
                case ExceedsMaximumLength: 
                case ExceedsTheoreticalMaxLength: {
                    int n2 = ErrorCode.ExceedsMaximumLength.getErrorCode();
                    String string5 = validationErrorDialogNotification.getFieldDataType() == LayoutFieldDataType.CONTAINER ? CONTAINER_KEY : GENERIC_KEY;
                    String string6 = validationErrorDialogNotification.getFieldDataType() == LayoutFieldDataType.CONTAINER ? CONTAINER_KEY : null;
                    String string7 = iWPError.getErrorAttributes().get((Object)Attribute.DATA_LENGTH_MAX);
                    if (Utilities.isEmptyString(string7)) {
                        string = this.getErrorStringKey(n2, string5, bl2);
                        if (validationErrorDialogNotification.getFieldDataType() == LayoutFieldDataType.CONTAINER) {
                            stringBuilder.append(IWPI18N.get(this.app, string, MAX_CONTAINER_KB));
                            break;
                        }
                        stringBuilder.append(IWPI18N.get(this.app, string, new Object[0]));
                        break;
                    }
                    string = this.getErrorStringKey(n2, string6, bl2);
                    if (bl2) {
                        stringBuilder.append(IWPI18N.get(this.app, string, string7, string7));
                        break;
                    }
                    stringBuilder.append(IWPI18N.get(this.app, string, string7));
                    break;
                }
                case NotValidValue: 
                case NotMemberValue: 
                case NotUniqueValue: 
                case NotExistingValue: 
                case MissingRequiredValue: {
                    String string8 = validationErrorDialogNotification.getError().getErrorAttributes().get((Object)Attribute.FIELDNAME);
                    if (!Utilities.isEmptyString(string8)) {
                        string = BrowserInfoHandler.isPhone(this.app) && errorCode == ErrorCode.MissingRequiredValue && !bl2 ? IWPI18N.get(this.app, "VERROR_509_PHONE", new Object[0]) : this.getErrorStringKey(n, null, bl2);
                        stringBuilder.append(IWPI18N.get(this.app, string, string8));
                        break;
                    }
                    string = this.getErrorStringKey(n, GENERIC_KEY, bl2);
                    stringBuilder.append(IWPI18N.get(this.app, string, new Object[0]));
                    break;
                }
                default: {
                    string = this.getErrorStringKey(n, null, bl2);
                    stringBuilder.append(IWPI18N.get(this.app, string, new Object[0]));
                }
            }
        }
        return stringBuilder.toString();
    }

    private String getErrorStringKey(int n, String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder(MESSAGE_KEY_PREFIX);
        stringBuilder.append(MESSAGE_KEY_SEPARATOR);
        stringBuilder.append(n);
        if (string != null) {
            stringBuilder.append(MESSAGE_KEY_SEPARATOR);
            stringBuilder.append(string);
        }
        if (bl) {
            stringBuilder.append(MESSAGE_KEY_SEPARATOR);
            stringBuilder.append(STRICT_KEY);
        }
        return stringBuilder.toString();
    }

    private void initButtons(ValidationErrorDialogNotification validationErrorDialogNotification) {
        String string;
        boolean bl = validationErrorDialogNotification.isRecordLevelValidation();
        boolean bl2 = validationErrorDialogNotification.isAllowRevert();
        boolean bl3 = validationErrorDialogNotification.isAllowOverride();
        Dialog.ButtonOption buttonOption = Dialog.ButtonOption.LEFT;
        String string2 = "";
        string2 = bl ? (this.app.isBrowseMode() ? (BrowserInfoHandler.isPhone(this.app) ? IWPI18N.get(this.app, "REVERT", new Object[0]) : IWPI18N.get(this.app, "REVERT_RECORD_BUTTON", new Object[0])) : IWPI18N.get(this.app, "REVERT_REQUEST", new Object[0])) : IWPI18N.get(this.app, "REVERT", new Object[0]);
        String string3 = IWPI18N.get(this.app, "NO", new Object[0]);
        String string4 = IWPI18N.get(this.app, "YES", new Object[0]);
        String string5 = string = IWPI18N.get(this.app, "OK", new Object[0]);
        String string6 = "";
        String string7 = "";
        if (bl2) {
            string5 = string2;
            this.leftButtonAction = ValidationErrorAction.REVERT;
            if (bl3) {
                buttonOption = Dialog.ButtonOption.LEFT_MIDDLE_RIGHT;
                string6 = string3;
                this.middleButtonAction = ValidationErrorAction.MODIFY;
                string7 = string4;
                this.rightButtonAction = ValidationErrorAction.OVERRIDE;
            } else {
                buttonOption = Dialog.ButtonOption.LEFT_RIGHT;
                string7 = string;
                this.rightButtonAction = ValidationErrorAction.MODIFY;
            }
        } else if (bl3) {
            buttonOption = Dialog.ButtonOption.LEFT_RIGHT;
            string5 = string3;
            this.leftButtonAction = ValidationErrorAction.MODIFY;
            string7 = string4;
            this.rightButtonAction = ValidationErrorAction.OVERRIDE;
        } else {
            this.leftButtonAction = ValidationErrorAction.MODIFY;
        }
        this.buttonOption = buttonOption;
        this.initButtons(string5, string6, string7);
        if (this.isTouchUI() && bl2) {
            this.getLeftButton().makeFitCaption();
        }
        switch (buttonOption) {
            case LEFT: {
                this.setLeftButtonDefault();
                break;
            }
            default: {
                this.setRightButtonDefault();
            }
        }
    }

    public final ValidationErrorAction getResult() {
        if (this.result == null) {
            return ValidationErrorAction.REVERT;
        }
        return this.result;
    }

    protected Component getContentLayout(String string) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = new Label(string);
        verticalLayout.addComponent((Component)label);
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result = this.leftButtonAction;
        super.performLeftButtonAction(clickEvent);
        this.performActionOnClient(this.leftButtonAction);
    }

    @Override
    protected void performMiddleButtonAction(Button.ClickEvent clickEvent) {
        this.result = this.middleButtonAction;
        super.performMiddleButtonAction(clickEvent);
        this.performActionOnClient(this.middleButtonAction);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.result = this.rightButtonAction;
        super.performRightButtonAction(clickEvent);
        this.performActionOnClient(this.rightButtonAction);
    }

    private void performActionOnClient(ValidationErrorAction validationErrorAction) {
        LayoutFieldObject layoutFieldObject;
        if (validationErrorAction == ValidationErrorAction.MODIFY && (layoutFieldObject = this.app.getActiveUIHandler().getActiveField(false, false)) != null && layoutFieldObject instanceof LayoutTextFieldObject) {
            ((LayoutTextFieldObject)layoutFieldObject).performModify();
        }
    }
}

