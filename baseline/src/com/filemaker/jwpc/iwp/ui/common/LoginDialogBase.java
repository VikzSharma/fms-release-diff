/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.event.ShortcutListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.ui.window.WindowMode
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.PasswordField
 *  com.vaadin.v7.ui.TextField
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.thrift.common.LoginResponse;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.component.Separator;
import com.filemaker.jwpc.iwp.ui.layout.component.OAuthButton;
import com.filemaker.jwpc.iwp.ui.layout.component.SignInButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogServerRPC;
import com.filemaker.jwpc.iwp.widgetset.client.state.LoginDialogBaseState;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.PasswordField;
import com.vaadin.v7.ui.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public abstract class LoginDialogBase
extends ServerInvokedStaticDialog {
    private static final String LOGIN_HEADER_ID = "login_header_msg";
    private static final String PARAM_OAUTH_DATA = "data";
    private static final String PARAM_OAUTH_PROVIDER = "Provider";
    private static final String PARAM_OAUTH_NAME = "Name";
    private static final String PARAM_OAUTH_AUTH_TYPE = "AuthType";
    private static final String PARAM_OAUTH_BUTTON_NAME = "ButtonName";
    private static final String PARAM_OAUTH_PROVIDERID = "ProviderID";
    private static final String PARAM_OAUTH_ICON = "Icon";
    private static final String CSS_CLASS_LOGIN = "fm-login-dialog-overlay";
    private static final String CSS_CLASS_MOBILE = "fm-mobile-login-dialog";
    private static final String CSS_CLASS_BODY_WRAPPER = "fm-login-dialog-body-wrapper";
    private static final String CSS_CLASS_BODY = "fm-login-dialog-body";
    private static final String CSS_CLASS_AUTH_PANEL = "fm-login-dialog-auth-panel";
    private static final String CSS_CLASS_TEXTFIELD = "fm-login-dialog-textfield";
    private static final String CSS_CLASS_GUEST_BUTTON = "fm-login-dialog-guest-login";
    private static final String CSS_CLASS_OAUTH_PANEL = "fm-login-dialog-oauth-panel";
    private static final String CSS_CLASS_CLOSE_BUTTON = "fm-login-dialog-close-button";
    private static final String OAUTH_API_PROVIDER_INFO = "/oauthapi/oauthproviderinfo";
    private static final String WPE_STATUS_API = "/api/status";
    protected static final int DIALOG_WIDTH = 400;
    protected static final int DEFAULT_COMPONENT_WIDTH = 307;
    protected static final int MAX_INPUT_LEN = 100;
    protected static final String INFO_CSS_CLASS_NAME = "login_header";
    protected static final String ERROR_CSS_CLASS_NAME = "login_error";
    protected static final String DOM_LOGIN_ERROR_MSG = "login_error_msg";
    protected static final String DOM_LOGIN_NAME = "login_name";
    protected static final String DOM_LOGIN_PWD = "login_pwd";
    protected LoginResponse response = null;
    protected boolean isGuest;
    protected boolean isOAuth;
    protected Button guestLogin;
    protected TextField acctNameTF;
    protected PasswordField passwordTF;
    protected CssLayout bodyWrapper;
    protected CssLayout body;
    protected CssLayout authLayout;
    protected CssLayout oAuthLayout;
    protected Label errorMessage;
    protected Label infoMessage;
    protected SignInButton bSignIn;
    protected Separator separator;
    protected boolean rpcRegistered = false;
    protected JsonArray oauthProviderList = null;
    protected String oauthRequestId;
    protected String oauthIdentifier;

    public LoginDialogBase(App app, String string, Dialog.ButtonOption buttonOption) {
        super(app, string, buttonOption);
        this.addStyleName(CSS_CLASS_LOGIN);
        this.acctNameTF.setValue("");
        this.passwordTF.setValue("");
        this.response = new LoginResponse(false, false, false, "", "", false);
        this.setDialogWidth(400);
        this.setResizable(false);
        this.setOAuthVisible(false, false);
        this.hideButtons();
    }

    @Override
    protected void init() {
        super.init();
        this.root.setSpacing(false);
    }

    protected LoginDialogBaseState getState() {
        return (LoginDialogBaseState)super.getState();
    }

    protected void registerServerRPC() {
        if (!this.rpcRegistered) {
            this.registerRpc(new UserAndPasswordDialogServerRPC(){

                @Override
                public void setDefaultFocus() {
                    LoginDialogBase.this.acctNameTF.focus();
                }
            });
            this.rpcRegistered = true;
        }
    }

    @Override
    protected Component getContentLayout() {
        this.bodyWrapper = new CssLayout();
        this.bodyWrapper.setId("login_dialog_wrapper");
        this.bodyWrapper.addStyleName(CSS_CLASS_BODY_WRAPPER);
        this.bodyWrapper.setSizeUndefined();
        this.body = new CssLayout();
        this.body.setId("login_dialog_body");
        this.body.addStyleName(CSS_CLASS_BODY);
        this.body.setSizeUndefined();
        this.bodyWrapper.addComponent((Component)this.body);
        this.authLayout = this.addAuthInfoLayout();
        this.body.addComponent((Component)this.authLayout);
        this.separator = new Separator(IWPI18N.get(this.app, "LOGIN_OAUTH_REQUIRED", new Object[0]));
        this.body.addComponent((Component)this.separator);
        this.oAuthLayout = this.addOAuthInfoLayout();
        this.body.addComponent((Component)this.oAuthLayout);
        CssLayout cssLayout = new CssLayout();
        cssLayout.setHeight(5.0f, Sizeable.Unit.PIXELS);
        this.bodyWrapper.addComponent((Component)cssLayout);
        ((UserAndPasswordDialogClientRPC)this.getRpcProxy(UserAndPasswordDialogClientRPC.class)).turnOffAutoComplete();
        return this.bodyWrapper;
    }

    private CssLayout addAuthInfoLayout() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.setStyleName(CSS_CLASS_AUTH_PANEL);
        cssLayout.setWidthUndefined();
        this.infoMessage = new Label();
        this.infoMessage.setId(LOGIN_HEADER_ID);
        this.infoMessage.setStyleName(INFO_CSS_CLASS_NAME);
        this.infoMessage.addStyleName("invisible");
        this.infoMessage.setWidthUndefined();
        cssLayout.addComponent((Component)this.infoMessage);
        this.errorMessage = new Label();
        this.errorMessage.setId(DOM_LOGIN_ERROR_MSG);
        this.errorMessage.setStyleName(ERROR_CSS_CLASS_NAME);
        this.errorMessage.setWidthUndefined();
        cssLayout.addComponent((Component)this.errorMessage);
        this.acctNameTF = new TextField();
        this.acctNameTF.setId(DOM_LOGIN_NAME);
        this.acctNameTF.setStyleName(CSS_CLASS_TEXTFIELD);
        this.acctNameTF.setWidth(307.0f, Sizeable.Unit.PIXELS);
        this.acctNameTF.setMaxLength(100);
        cssLayout.addComponent((Component)this.acctNameTF);
        this.passwordTF = new PasswordField();
        this.passwordTF.setId(DOM_LOGIN_PWD);
        this.passwordTF.setStyleName(CSS_CLASS_TEXTFIELD);
        this.passwordTF.setWidth(307.0f, Sizeable.Unit.PIXELS);
        this.passwordTF.setMaxLength(100);
        cssLayout.addComponent((Component)this.passwordTF);
        String string = this.app.getLocalizedString("LOGIN_NAME_PLACEHOLDER");
        String string2 = this.app.getLocalizedString("LOGIN_PASSWORD_PLACEHOLDER");
        this.bSignIn = new SignInButton(this, IWPI18N.get(this.app, "LOGIN_NONGUEST", new Object[0]));
        this.bSignIn.addShortcutListener(new ShortcutListener(null, 13, null){

            public void handleAction(Object object, Object object2) {
                LoginDialogBase.this.signIn();
            }
        });
        cssLayout.addComponent((Component)this.bSignIn);
        this.guestLogin = new Button();
        this.guestLogin.addStyleName("borderless");
        this.guestLogin.addStyleName("fm-button-as-label");
        String string3 = IWPI18N.get(this.app, "LOGIN_GUEST", new Object[0]);
        this.guestLogin.setCaption("<span class='fm-button-as-label'>" + string3 + "</span>");
        this.guestLogin.setCaptionAsHtml(true);
        this.guestLogin.addClickListener((Button.ClickListener & Serializable)clickEvent -> this.signInAsGuest());
        cssLayout.addComponent((Component)this.guestLogin);
        ((UserAndPasswordDialogClientRPC)this.getRpcProxy(UserAndPasswordDialogClientRPC.class)).setPlaceholderText(string, string2);
        ((UserAndPasswordDialogClientRPC)this.getRpcProxy(UserAndPasswordDialogClientRPC.class)).setAriaLabel(string, string2);
        return cssLayout;
    }

    private CssLayout addOAuthInfoLayout() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.setId("login_dialog_oauth_panel");
        cssLayout.setStyleName(CSS_CLASS_OAUTH_PANEL);
        cssLayout.setWidthUndefined();
        return cssLayout;
    }

    public void signIn() {
        if (this.getRightButton() != null) {
            this.isGuest = false;
            this.isOAuth = false;
            this.getRightButton().click();
        }
    }

    protected void signInAsGuest() {
        if (this.getRightButton() != null) {
            this.isGuest = true;
            this.isOAuth = false;
            this.getRightButton().click();
        }
    }

    public void signInWithOAuth(String string, String string2, String string3) {
        if (this.getRightButton() != null) {
            this.isGuest = false;
            this.isOAuth = true;
            this.oauthRequestId = string;
            this.oauthIdentifier = string2;
            this.app.setLastAuthErrorCode(Integer.parseInt(string3));
            this.getRightButton().click();
        }
    }

    protected void useCustomCloseButton() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName(CSS_CLASS_CLOSE_BUTTON);
        cssLayout.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                if (LoginDialogBase.this.getLeftButton() != null) {
                    LoginDialogBase.this.getLeftButton().click();
                }
            }
        });
        this.root.addComponentAsFirst((Component)cssLayout);
    }

    @Override
    public Object getResult() {
        return this.response;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void initOAuthUI(boolean bl) {
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        BufferedReader bufferedReader = null;
        URL uRL = null;
        try {
            String string = Service.getMasterAddr();
            URL uRL2 = new URL("https://" + string + "/fmi/webd/api/status");
            httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR(uRL2.toExternalForm(), "GET", true);
            if (httpURLConnection != null) {
                int n = httpURLConnection.getResponseCode();
                uRL = n != 200 ? new URL(new URL(this.getApplicationRoot().getApplicationURL()), "/fmi/webd/oauthapi/oauthproviderinfo") : new URL("https://" + string + "/fmi/webd/oauthapi/oauthproviderinfo");
                httpURLConnection.disconnect();
            }
            if ((httpURLConnection2 = (HttpURLConnection)IWPUtilities.getXHR(uRL.toExternalForm(), "GET", true)) != null) {
                httpURLConnection2.setRequestProperty("X-FMS-Application-Type", "8");
                httpURLConnection2.setRequestProperty("X-FMS-Application-Version", "17");
                Locale locale = this.app.getLocale();
                httpURLConnection2.setRequestProperty("Accept-Language", locale.getLanguage());
                int n = httpURLConnection2.getResponseCode();
                if (n == 200) {
                    String string2;
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((string2 = bufferedReader.readLine()) != null) {
                        stringBuffer.append(string2);
                    }
                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = (JsonObject)jsonParser.parse(stringBuffer.toString());
                    boolean bl2 = false;
                    if (jsonObject.has(PARAM_OAUTH_DATA) && jsonObject.get(PARAM_OAUTH_DATA).getAsJsonObject().has(PARAM_OAUTH_PROVIDER) && jsonObject.get(PARAM_OAUTH_DATA).getAsJsonObject().get(PARAM_OAUTH_PROVIDER).getAsJsonArray().size() > 0) {
                        this.oauthProviderList = jsonObject.get(PARAM_OAUTH_DATA).getAsJsonObject().get(PARAM_OAUTH_PROVIDER).getAsJsonArray();
                        for (int i = 0; i < this.oauthProviderList.size(); ++i) {
                            JsonObject jsonObject2 = this.oauthProviderList.get(i).getAsJsonObject();
                            int n2 = jsonObject2.get(PARAM_OAUTH_AUTH_TYPE).getAsInt();
                            if (!IWPUtilities.isDBEnabledOAuth(n2)) continue;
                            bl2 = true;
                            OAuthButton oAuthButton = new OAuthButton(this, jsonObject2.get(PARAM_OAUTH_NAME).getAsString(), jsonObject2.get(PARAM_OAUTH_BUTTON_NAME).getAsString(), jsonObject2.get(PARAM_OAUTH_ICON).getAsString(), jsonObject2.get(PARAM_OAUTH_PROVIDERID).getAsString());
                            oAuthButton.setWidthUndefined();
                            oAuthButton.setId(oAuthButton.getDescription());
                            this.oAuthLayout.addComponent((Component)oAuthButton);
                        }
                        if (bl2) {
                            this.setOAuthVisible(true, bl);
                        }
                    }
                }
            }
        }
        catch (Exception exception) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
    }

    private void setOAuthVisible(boolean bl, boolean bl2) {
        if (bl2) {
            this.infoMessage.setVisible(true);
            this.acctNameTF.setVisible(false);
            this.passwordTF.setVisible(false);
            this.bSignIn.setVisible(false);
            this.guestLogin.setVisible(false);
            this.separator.setVisible(false);
        } else {
            this.separator.setVisible(bl);
        }
        this.oAuthLayout.setVisible(bl);
    }

    public void setWindowMode(WindowMode windowMode) {
        super.setWindowMode(windowMode);
        if (windowMode == WindowMode.MAXIMIZED) {
            this.root.addStyleName(CSS_CLASS_MOBILE);
        } else {
            this.root.removeStyleName(CSS_CLASS_MOBILE);
        }
    }
}

