/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Notification
 *  com.vaadin.ui.Notification$Type
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.ScriptState;
import com.filemaker.jwpc.iwp.thrift.common.ToolbarStatusAreaState;
import com.filemaker.jwpc.iwp.ui.common.BusyDialog;
import com.filemaker.jwpc.iwp.ui.common.ErrorDialog;
import com.filemaker.jwpc.iwp.ui.component.CloseRequestNotifier;
import com.filemaker.jwpc.iwp.ui.component.ScriptPausedNotifier;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import java.util.Locale;

public final class Messenger {
    private static final String defaultErrorMessageKey = "e_default";
    private ScriptPausedNotifier scriptPauseNotifier;
    private BusyDialog busyNotifier;
    private CloseRequestNotifier closeRequestNotifier;
    private App appRoot = null;

    public Messenger(App app) {
        this.appRoot = app;
    }

    public void showErrorDialog(String string) {
        ErrorDialog errorDialog = new ErrorDialog(this.appRoot, string);
        errorDialog.showDialog();
    }

    public void showError(String string) {
        new Notification(string, Notification.Type.ERROR_MESSAGE).show(this.appRoot.getPage());
    }

    public void showError(String string, String string2) {
        new Notification(string, string2, Notification.Type.ERROR_MESSAGE).show(this.appRoot.getPage());
    }

    public void showMessageImmediate(String string) {
        new Notification(string).show(this.appRoot.getPage());
    }

    public void showTrayMessage(String string) {
        new Notification(string, Notification.Type.TRAY_NOTIFICATION).show(this.appRoot.getPage());
    }

    public void showTrayMessage(String string, String string2) {
        new Notification(string, string2, Notification.Type.TRAY_NOTIFICATION).show(this.appRoot.getPage());
    }

    public void showWarning(String string) {
        new Notification(string, Notification.Type.WARNING_MESSAGE).show(this.appRoot.getPage());
    }

    public void showWarning(String string, String string2) {
        new Notification(string, string2, Notification.Type.WARNING_MESSAGE).show(this.appRoot.getPage());
    }

    public void closeAllUI() {
        if (this.closeRequestNotifier != null) {
            this.appRoot.getAppContainer().removeComponent((Component)this.closeRequestNotifier);
            this.closeRequestNotifier = null;
        }
        if (this.scriptPauseNotifier != null) {
            this.appRoot.getAppContainer().removeComponent((Component)this.scriptPauseNotifier);
            this.scriptPauseNotifier = null;
        }
        this.closeBusyDialog();
    }

    public void showScriptStateNotifier(boolean bl) {
        Object object;
        boolean bl2 = this.appRoot.getDatabaseDataModel().isScriptPaused();
        if (this.scriptPauseNotifier == null && bl2) {
            this.scriptPauseNotifier = new ScriptPausedNotifier(this.appRoot, bl);
            this.appRoot.getAppContainer().addComponent((Component)this.scriptPauseNotifier, 1);
        }
        if (this.scriptPauseNotifier != null) {
            boolean bl3;
            object = this.appRoot.getDatabaseDataModel().getToolbarStatusAreaState();
            boolean bl4 = bl3 = bl2 && ((ToolbarStatusAreaState)object).isShow();
            if (bl3 && bl != this.scriptPauseNotifier.isAllowAbort()) {
                this.scriptPauseNotifier.update(bl);
            }
            this.scriptPauseNotifier.setVisible(bl3);
        }
        object = this.appRoot.getDatabaseDataModel().getScriptState();
        switch (1.$SwitchMap$com$filemaker$jwpc$iwp$thrift$common$ScriptState[((Enum)object).ordinal()]) {
            case 1: 
            case 2: {
                this.closeBusyDialog();
                break;
            }
        }
    }

    public void showCloseRequestNotifier(int n, int n2) {
        this.closeRequestNotifier = new CloseRequestNotifier(this.appRoot, n, n2);
        if (this.scriptPauseNotifier != null && this.scriptPauseNotifier.isVisible()) {
            this.appRoot.getAppContainer().addComponent((Component)this.closeRequestNotifier, 2);
        } else {
            this.appRoot.getAppContainer().addComponent((Component)this.closeRequestNotifier, 1);
        }
        this.closeRequestNotifier.setVisible(true);
    }

    public void closeBusyDialog() {
        if (this.busyNotifier != null && this.busyNotifier.isVisible()) {
            this.busyNotifier.closeDialog();
        }
    }

    public void showLongScriptBusyDialog(boolean bl, String string) {
        this.busyNotifier = this.getBusyDialog(bl);
        this.busyNotifier.showDialog(true, bl, string);
    }

    public void showBusyDialog(boolean bl, String string) {
        this.busyNotifier = this.getBusyDialog(bl);
        this.busyNotifier.showDialog(false, bl, string);
    }

    private final BusyDialog getBusyDialog(boolean bl) {
        if (this.busyNotifier == null) {
            this.busyNotifier = new BusyDialog(this.appRoot, bl);
        }
        return this.busyNotifier;
    }

    public final BusyDialog getCurrentBusyDialog() {
        return this.busyNotifier;
    }

    public void showBusyPleaseWaitDialog() {
        this.showBusyDialog(false, IWPI18N.get(this.appRoot, "BUSY_DIALOG_WAIT", new Object[0]));
    }

    public void setBusyDialogVisible() {
        ScriptState scriptState = this.appRoot.getDatabaseDataModel().getScriptState();
        if (scriptState != ScriptState.EXIT && scriptState != ScriptState.PAUSE && this.busyNotifier != null && !this.busyNotifier.isVisible()) {
            this.busyNotifier.setVisible(true);
        }
    }

    public void setBusyDialogInvisible() {
        if (this.busyNotifier != null && this.busyNotifier.isVisible()) {
            this.busyNotifier.setVisible(false);
        }
    }

    public String getUserFriendlyErrorMessage(IWPError iWPError, Locale locale) {
        Object object = "";
        boolean bl = IWPUtilities.hasError(iWPError);
        if (bl) {
            int n = 0;
            if (iWPError.getErrorCode() != iWPError.getExtendedErrorCode()) {
                n = iWPError.getExtendedErrorCode();
            }
            Object object2 = this.getErrorStringKey(iWPError.getErrorCode(), n);
            ErrorCode errorCode = ErrorCode.fromValue((int)iWPError.getErrorCode());
            switch (errorCode) {
                case OAuthRequestAccessTokenFailed: 
                case OAuthSendMailFailed: {
                    if (iWPError.getMessage() != null && !iWPError.getMessage().isEmpty()) {
                        object = iWPError.getMessage();
                        String[] stringArray = this.parseOAuthMailJsonError(iWPError.getErrorCode(), (String)object);
                        String string = stringArray[0];
                        String string2 = stringArray[1];
                        object = IWPI18N.get(locale, (String)object2, string, string2);
                        break;
                    }
                    object2 = (String)object2 + "_alt";
                    object = IWPI18N.get(locale, (String)object2, new Object[0]);
                    break;
                }
                case ODBCExtendedError: {
                    object = iWPError.getMessage();
                    break;
                }
                case InvalidOmit: {
                    object = IWPI18N.get(locale, (String)object2, iWPError.getMessage());
                    break;
                }
                case NoDependentLookup: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.FIELDNAME);
                    object = IWPI18N.get(locale, (String)object2, string);
                    break;
                }
                case UserAbort: {
                    object2 = this.getErrorStringKey(n, 0);
                    object = IWPI18N.get(locale, (String)object2, new Object[0]);
                    break;
                }
                case RecordLocked: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.LOCKCONFLICT_USERNAME);
                    if (string == null) {
                        object2 = (String)object2 + "_alt";
                        object = IWPI18N.get(locale, (String)object2, new Object[0]);
                        break;
                    }
                    object = IWPI18N.get(locale, (String)object2, string, string);
                    break;
                }
                case FileLocked: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.LOCKCONFLICT_USERNAME);
                    object = IWPI18N.get(locale, (String)object2, string, string);
                    break;
                }
                case LockConflict: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.LOCKCONFLICT_USERNAME);
                    object = IWPI18N.get(locale, (String)object2, string, string);
                    break;
                }
                case AccessDenied: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.FILENAME);
                    if (string != null) {
                        object2 = (String)object2 + "_file";
                        object = IWPI18N.get(locale, (String)object2, string);
                        break;
                    }
                    object = IWPI18N.get(locale, (String)object2, new Object[0]);
                    break;
                }
                case MinPasswordLength: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.MINPASSWORDLEN);
                    object = IWPI18N.get(locale, (String)object2, string);
                    break;
                }
                case CannotFindLLMAccountError: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.LLMACCOUNTNAME);
                    object = IWPI18N.get(locale, (String)object2, string);
                    break;
                }
                case kCannotFindLLMClarisRAGAccountError: {
                    String string = iWPError.getErrorAttributes().get((Object)Attribute.RAGACCOUNTNAME);
                    object = IWPI18N.get(locale, (String)object2, string);
                    break;
                }
                case BlockNewUsers: 
                case SetLLMAccountEndpointMissingError: 
                case CannotFindTblInLayoutError: 
                case LLMRequestOptionsJSONFormatParseError: 
                case LLMRequestParametersJSONFormatParseError: 
                case LLMOtherLLMEndpointError: 
                case NonIndexableFieldClient: 
                case SemanticFindNoRecordsFound: 
                case LLMFindNoFieldsEnabled: 
                case LLMTrainInvalidAlgorithmError: 
                case LLMTrainInvalidParameterError: 
                case kLLMFineTuneFailedJSONLFileError: 
                case LLMRepetitionFieldsNotSupported: 
                case PrintContainerPDFErrorNotContainer: 
                case PrintContainerPDFErrorEmpty: 
                case PrintContainerPDFErrorUnsupportedType: 
                case PrintContainerPDFErrorPasswordRequired: 
                case PrintContainerPDFErrorPrintingNotAllowed: 
                case InvalidPDFFileID: 
                case InvalidPDFFile: 
                case InvalidPDFPassword: 
                case PDFPagesModifyNotAllowed: 
                case PDFFileAlreadyOpen: {
                    object = IWPI18N.get(locale, (String)object2, new Object[0]);
                    break;
                }
                case LLMExtendedError: {
                    object = IWPI18N.get(locale, "e_882_0", new Object[0]) + iWPError.getMessage();
                    break;
                }
                case LLMInvalidRequest: {
                    object = IWPI18N.get(locale, "e_886_0", new Object[0]) + iWPError.getMessage();
                    break;
                }
                case LLMClarisRAGSpaceError: {
                    object = IWPI18N.get(locale, "e_887_0", new Object[0]) + iWPError.getMessage();
                    break;
                }
                case LLMEmbeddingInvalidRequestError: {
                    object = IWPI18N.get(locale, "EMBEDDING_ERROR_PREFIX", new Object[0]) + iWPError.getMessage();
                    break;
                }
                case LLMEmbeddingError: 
                case LLMOtherLLMExtendError: {
                    object = iWPError.getMessage();
                    object = ((String)object).replaceAll("\r", "<br/>");
                    break;
                }
                default: {
                    if (iWPError.getErrorCode() >= 5000 && iWPError.getErrorCode() < 5500) {
                        object = IWPI18N.get(locale, "CUSTOM_SCRIPT_ERROR", iWPError.getMessage());
                        break;
                    }
                    object = IWPI18N.get(locale, (String)object2, new Object[0]);
                    if (!((String)object).equals(object2)) break;
                    object = IWPI18N.get(locale, defaultErrorMessageKey, iWPError.getErrorCode());
                }
            }
        }
        return object;
    }

    private String[] parseOAuthMailJsonError(int n, String string) {
        String string2 = "";
        String string3 = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(string);
        if (n == ErrorCode.OAuthRequestAccessTokenFailed.getErrorCode()) {
            if (jsonObject.has("error")) {
                string2 = jsonObject.get("error").getAsString();
            }
            if (jsonObject.has("error_description")) {
                string3 = jsonObject.get("error_description").getAsString();
            }
        } else if (n == ErrorCode.OAuthSendMailFailed.getErrorCode()) {
            JsonElement jsonElement;
            JsonObject jsonObject2 = jsonObject.get("error").getAsJsonObject();
            if (jsonObject2.has("code")) {
                jsonElement = jsonObject2.get("code");
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                    string2 = jsonElement.getAsString();
                } else if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                    string2 = String.valueOf(jsonElement.getAsInt());
                }
            }
            if (jsonObject2.has("message") && (jsonElement = jsonObject2.get("message")).isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                string3 = jsonElement.getAsString();
            }
        }
        return new String[]{string2, string3};
    }

    public String getUserFriendlyErrorMessage(IWPError iWPError) {
        Locale locale = this.appRoot != null ? this.appRoot.getLocale() : Locale.getDefault();
        return this.getUserFriendlyErrorMessage(iWPError, locale);
    }

    private String getErrorStringKey(int n, int n2) {
        return "e_" + n + "_" + n2;
    }

    public boolean showDebugMessage(IWPError iWPError) {
        boolean bl = IWPUtilities.hasError(iWPError);
        if (bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getErrorStringKey(iWPError.getErrorCode(), iWPError.getExtendedErrorCode()));
            stringBuilder.append(" Message:");
            stringBuilder.append(IWPUtilities.getErrorString(iWPError));
            IWPUtilities.showDebugMessage(this.appRoot, stringBuilder.toString());
            this.appRoot.pushChanges();
        }
        return bl;
    }
}

