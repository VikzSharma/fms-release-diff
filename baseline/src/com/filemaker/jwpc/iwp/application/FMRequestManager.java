/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.fmi.net.URLEncoder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gwt.thirdparty.json.JSONException
 *  com.google.gwt.thirdparty.json.JSONObject
 *  com.vaadin.server.VaadinRequest
 *  com.vaadin.server.VaadinServletRequest
 *  com.vaadin.server.WebBrowser
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 *  org.jsoup.nodes.Document$OutputSettings
 *  org.jsoup.nodes.Element
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.config.ConfigurationHandler;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.application.OAuthRequestHandler;
import com.filemaker.jwpc.iwp.application.SessionContext;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.ContextResult;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DatabaseData;
import com.filemaker.jwpc.iwp.thrift.common.DatabasesDataResult;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.SessionDisconnectType;
import com.filemaker.jwpc.iwp.thrift.common.SessionInfo;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.Messenger;
import com.filemaker.jwpc.util.Utilities;
import com.fmi.net.URLEncoder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gwt.thirdparty.json.JSONException;
import com.google.gwt.thirdparty.json.JSONObject;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.WebBrowser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FMRequestManager {
    public static final String ROOT_PATH = "VAADIN/launchcenter/";
    private String contextPath = null;
    private boolean isPost = false;
    private Messenger messenger = null;
    private Locale locale = null;
    private HashMap<String, SessionContext> sessionContextMap = new HashMap();
    private static final int MAX_DB_LOGIN_ATTEMPT = 5;
    private static final int MAX_DB_APPLEID_LOGIN_ATTEMPT = 3;
    private static final int MAX_INPUT_LEN = 100;
    private static final String API_PARAM = "api";
    private static final String LOGIN_LIST_API = "login_list";
    private static final String LOGIN_ERROR_QUERY = "loginerr";
    private static final String LOGIN_GUEST_ENABLED = "guesten";
    private static final String LOGIN_HIDELOCALACCOUNTENTRY = "hidelocalaccountentry";
    private static final String LOGIN_DB_QUERY = "db";
    private static final String LOGIN_HEADER_QUERY = "login_header";
    private static final String LOGIN_HEADER_ELLIPSIS_QUERY = "login_header_ellipsis";
    private static final String LAUNCH_CENTER_TEMPLATE = "VAADIN/launchcenter/home.html";
    private static final String LOGIN_TEMPLATE = "VAADIN/launchcenter/login.html";
    private static final String APPLEID_LOGIN_TEMPLATE = "VAADIN/launchcenter/appleidlogin.html";
    private static final String LOGOUT_TEMPLATE = "VAADIN/launchcenter/logout.html";
    private static final String ERROR_TEMPLATE = "VAADIN/launchcenter/error.html";
    private static final String SYSTEM_TEMPLATE = "VAADIN/launchcenter/system.html";
    private static final String INFO_PAGE_TEMPLATE = "VAADIN/launchcenter/info-page.html";
    private static final String FMID_REDIRECT_TEMPLATE = "VAADIN/launchcenter/fmid-redir.html";
    private static final String WA_OPEN_TEMPLATE = "VAADIN/launchcenter/wa-open.html";
    private static final String FMID_ERROR_TEMPLATE = "VAADIN/launchcenter/fmid-error.html";
    private static final String DEFAULT_IMAGEURL = "/fmi/VAADIN/themes/default/images/iwp_db@3x.png";
    private static final String DB_ELEMENT_TEMPLATE = "<div class=\"db_container v-csslayout v-layout v-widget\"><div class=\"v-csslayout v-layout v-widget imagebox\"><img class=\"image v-widget\" src=\"%s\" alt=\"\" aria-label=\"%s\" onClick=\"openDB(event, this);\" tabindex=\"0\"></div><button class=\"v-label v-widget v-has-width home-db-btn\" style=\"width: 100%%;\" onClick=\"openDB(event, this);\" tabindex=\"-1\">%s</button></div>";
    private static final String DOM_VIEW_LIST = "view_list";
    private static final String DOM_VIEW_GRID = "view_grid";
    private static final String DOM_FILTER_TEXT = "filter_text";
    private static final String DOM_LOGIN_CONTAINER = "login_container";
    private static final String DOM_APPLEID_LOGIN_CONTAINER = "appleid_login_container";
    private static final String DOM_DB_LIST = "db_list";
    private static final String DOM_LOGIN_HEADER_MSG = "login_header_msg";
    private static final String DOM_LOGIN_ERROR_MSG = "login_error_msg";
    private static final String DOM_OAUTH_REQUIRED_MSG = "login_dialog_separator_text";
    private static final String DOM_LOGIN_CANCEL_BUTTON = "login_cancel_button";
    private static final String DOM_LOGIN_DIALOG = "login_dialog_wrapper";
    private static final String DOM_LOGIN_GUEST_WRAPPER = "login_guest_wrapper";
    private static final String DOM_LOGIN_GUEST_BUTTON = "<button id='login_guest' class='fm-native-login-dialog-guest-signin' onclick='onGuestOK()' type='button'  aria-label='%LOGIN_GUEST%' style='border-style: none; background-color: transparent'>%LOGIN_GUEST%</button>";
    private static final String DOM_LOGIN_GUEST = "login_guest";
    private static final String DOM_LOGIN_NONGUEST = "login_nonguest";
    private static final String DOM_LOGIN_NAME = "login_name";
    private static final String DOM_LOGIN_PWD = "login_pwd";
    private static final String DOM_LOGIN_COUNT = "login_count";
    private static final String DOM_MASTER_ADDR = "master_addr";
    private static final String DOM_BANNER_CONTAINER = "banner_container";
    private static final String DOM_BANNER_CONTENT = "banner_content";
    private static final String DOM_BANNER_MSG = "banner_msg";
    private static final String DOM_NO_JS_CONTAINER = "no_js_container";
    private static final String DOM_NO_COOKIE_CONTAINER = "no_cookie_container";
    private static final String DOM_HIDDEN_CLASS = "hidden";
    private static final String DOM_ERROR_CLASS = "error";
    private static final String DOM_LOGIN_NO_CANCEL_CLASS = "login-no-cancel";
    private static final String DOM_CERTIFICATE_CLASS = "cert";
    private static final String DOM_INFO_PAGE_MSG = "msg";
    private static final String DOM_APPLEID_EMAIL_ERROR_MSG = "appleid_sendemail_error_msg";
    private static final String DOM_APPLEID_LOGIN_ERROR_MSG = "login_appleid_error_msg";
    private static final String DOM_APPLEID_PASSCODE_MSG = "login_appleid_passcode_msg";
    private static final String DOM_APPLEID_HEADER_MSG = "login_appleid_header_msg";
    private static final String DOM_APPLEID_OK = "login_appleid_ok";
    private static final String DOM_APPLEID_EMAIL = "login_appleid_email";
    private static final String DOM_APPLEID_SENDEMAIL = "login_appleid_sendemail";
    public static final String PARAM_PID = "pid";
    public static final String PARAM_GUEST = "guest";
    public static final String PARAM_OAUTH = "oauth";
    public static final String PARAM_APPLEID = "appleid";
    public static final String PARAM_APPLEID_EMAIL = "appleidemail";
    public static final String PARAM_APPLEID_PASSCODE = "appleidpasscode";
    public static final String PARAM_FMID = "fmid";
    public static final String PARAM_RELOGIN = "relogin";
    public static final String PARAM_USER = "user";
    public static final String PARAM_PWD = "pwd";
    public static final String PARAM_WA = "wa";
    public static final String PARAM_LAYOUT_ID = "layoutID";
    public static final String PARAM_AUTH_ERROR = "autherr";
    public static final String PARAM_DB = "db";
    public static final String PARAM_FORCE_LOGIN = "force";
    public static final String PARAM_LOGIN_COUNT = "lgcnt";
    public static final String PARAM_LOGOUT = "logout";
    public static final String PARAM_LOGIN_ATTEMPT_FAIL_TYPE = "-1";
    public static final String PARAM_CUSTOM_LOGIN = "homelogin";
    public static final String PARAM_CUSTOM_FILTER_LOGIN = "customfilterlogin";
    public static final String PARAM_PWD_EXPIRED = "pwx";
    public static final String PARAM_HOST_NAME = "hostname";
    private static final String JSON_RESULT = "result";
    private static final String JSON_DATA = "data";
    private static final String JSON_CERTIFICATE = "cert";
    private static final String JSON_LOGIN_COUNT = "lgcnt";
    private static final String JSON_REDIRECT_RESULT = "result";
    private static final String JSON_REDIRECT_URL = "webdredirect";
    private static final String JSON_REDIRECT_PORT_HTTP = "httpPort";
    private static final String JSON_REDIRECT_PORT_HTTPS = "httpsPort";
    private static final String JSON_JWT_TOKEN = "jwt";
    private static final String JSON_REFRESH_TOKEN = "refresh";
    private static final String JSON_APPLEID_EMAIL_HEADERMSG = "appleidEmailHeaderMsg";
    private static final String JSON_APPLEID_EMAIL_SENDBTN = "appleidEmailSendBtn";
    private static final int DEFAULT_LOGIN_ERROR_CODE = 212;
    private static final int DEFAULT_DB_FILTER_ERROR_CODE = 18;
    private static final int APPLEID_DB_FILTER_ERROR_CODE = 9;
    private static final int APPLEID_LOGIN_ERROR_CODE = 20801;
    private static final int APPLEID_PASSCODE_NOT_FOUND_ERROR_CODE = 20802;
    private static final int APPLEID_PASSCODE_EXPIRE_ERROR_CODE = 20803;
    private static final int APPLEID_INVALID_TYPE_ACCOUNT_ERROR = 20804;
    private static final int APPLEID_INVALID_EMAIL_FORMAT_ERROR_CODE = 20805;
    private static final int APPLEID_ACCOUNT_DISABLED_ERROR = 20810;
    private static final String REDIRECT_API = "http://localhost:16002/fmswpew/webdredirect";
    private static final String TOKENEXCHANGE_API = "http://localhost:16002/fmsadminapi/fmid/tokenexchange";
    private static final String SECURITY_MGMT_INFO_API = "http://localhost:1895/fmws/database/securitymgmtinfo";
    private static final String FMID_APP_VER = "18";
    private boolean redirectEnabled = true;
    private boolean bReDirectToWA = false;
    public static String fmidURL = null;
    public static String clientID = null;
    private boolean emailSended = false;
    private String storedUserName = null;
    private String storedPwd = null;
    private String storedEmail = null;
    private int sessionid = 0;
    private static Set<String> trustDomains = new HashSet<String>();

    public FMRequestManager(String string) {
        this.contextPath = string;
        this.redirectEnabled = System.getProperty("fmDebugDisableMWPE") != null ? false : ConfigurationHandler.getInstance(this.contextPath).isMWPERouting();
    }

    public boolean processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        App app;
        String string;
        int n;
        boolean bl = false;
        if (!this.isRequestValid(httpServletRequest, httpServletResponse)) {
            return true;
        }
        if (this.isWpeStatusRequest(httpServletRequest, httpServletResponse)) {
            return true;
        }
        if (!this.shouldHandleRequest(httpServletRequest)) {
            return bl;
        }
        if (OAuthRequestHandler.processRequest(this.contextPath, httpServletRequest, httpServletResponse)) {
            return true;
        }
        String string2 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_EMAIL);
        String string3 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_PASSCODE);
        String string4 = IWPUtilities.getCaseInsensitiveURI(httpServletRequest.getRequestURI());
        String string5 = IWPUtilities.getDatabaseNameFromPath(string4);
        this.isPost = httpServletRequest.getMethod().equalsIgnoreCase("POST");
        String string6 = httpServletRequest.getQueryString();
        String string7 = httpServletRequest.getParameter(LOGIN_ERROR_QUERY);
        int n2 = n = string7 != null ? Integer.valueOf(string7) : 0;
        if (string4.startsWith("/fmi/webd") && string4.endsWith("/browser/close/")) {
            string = httpServletRequest.getQueryString();
            if (string != null && string.contains("clientId=")) {
                try {
                    int n3 = Integer.parseInt(string.replace("clientId=", ""));
                    app = App.getApp(n3);
                    if (app != null) {
                        app.forceClose(true, false, null);
                    }
                }
                catch (NumberFormatException numberFormatException) {}
            }
        } else if (httpServletRequest.getParameter(PARAM_APPLEID) != null && Utilities.isEmptyString(string2) && httpServletRequest.getParameter(PARAM_PID) == null || (string4.endsWith("/fmi/webd") || string4.endsWith("/fmi/webd/")) && Utilities.isEmptyString(string6) && Utilities.isEmptyString(string5)) {
            this.handleLaunchCenter(httpServletRequest, httpServletResponse);
            bl = true;
        } else if (!Utilities.isEmptyString(string2) && Utilities.isEmptyString(string3) || n == 20802 || n == 20803) {
            if (Utilities.isEmptyString(string3)) {
                this.emailSended = false;
                this.handleLaunchCenter(httpServletRequest, httpServletResponse);
                bl = true;
            } else {
                this.handleLaunchCenter(httpServletRequest, httpServletResponse);
                bl = true;
            }
        } else if (httpServletRequest.getParameter(PARAM_APPLEID) == null && (Utilities.isValidText(string7) || Utilities.isValidText(httpServletRequest.getParameter(PARAM_LOGOUT)))) {
            this.handleLaunchCenter(httpServletRequest, httpServletResponse);
            bl = true;
        } else {
            string = httpServletRequest.getParameter(API_PARAM);
            if (Utilities.isValidText(string)) {
                if (string.equals(LOGIN_LIST_API)) {
                    if (string6.equals("api=login_list")) {
                        this.handleLoginList(httpServletRequest, httpServletResponse);
                    } else {
                        httpServletResponse.sendError(404);
                    }
                    bl = true;
                }
            } else if (!string4.endsWith("/fmi/webd") && !string4.endsWith("/fmi/webd/")) {
                if (!string4.contains("/fmi/webd/") || string4.endsWith("/fmi/") || string4.endsWith("/fmi") && !string4.contains("/fmi/webd/fmi")) {
                    httpServletResponse.sendError(404);
                    bl = true;
                }
            } else if (!Utilities.isEmptyString(string6)) {
                this.handleLaunchCenter(httpServletRequest, httpServletResponse);
                bl = true;
            }
        }
        if (this.redirectEnabled && !bl && httpServletRequest.getParameter("redirected") == null) {
            string = this.getRedirectJson();
            try {
                JsonParser jsonParser = new JsonParser();
                app = (JsonObject)jsonParser.parse(string);
                if (this.isValidRedirectResponse((JsonObject)app)) {
                    Object object = app.get(JSON_REDIRECT_URL).getAsString();
                    if (!((String)object).startsWith("[") && !((String)object).endsWith("]") && Utilities.isIPv6Address((String)object)) {
                        object = "[" + (String)object + "]";
                    }
                    if (!((String)object).equals("localhost")) {
                        String string8 = "https".equals(httpServletRequest.getHeader("X-Forwarded-Proto")) ? "https://" + (String)object + ":" + app.get(JSON_REDIRECT_PORT_HTTPS).getAsInt() + string4 + "?redirected=true" : "http://" + (String)object + ":" + app.get(JSON_REDIRECT_PORT_HTTP).getAsInt() + string4 + "?redirected=true";
                        if (Utilities.isValidText(string6)) {
                            string8 = string8 + "&" + string6;
                        }
                        httpServletResponse.setHeader("Location", string8);
                        httpServletResponse.setStatus(307);
                        bl = true;
                    }
                } else {
                    int n4 = app.get("result").getAsInt();
                    httpServletResponse.sendError(503, this.getMWPEErrorMsg(httpServletRequest, n4));
                    bl = true;
                }
            }
            catch (Exception exception) {
                httpServletResponse.sendError(503);
                bl = true;
            }
        }
        if (!bl) {
            bl = this.handleFMIDLogin(httpServletRequest, httpServletResponse) ? true : this.handleOpenDatabase(httpServletRequest, httpServletResponse);
        }
        return bl;
    }

    private boolean isValidRedirectResponse(JsonObject jsonObject) {
        if (!(jsonObject.has("result") && jsonObject.has(JSON_REDIRECT_URL) && jsonObject.has(JSON_REDIRECT_PORT_HTTP) && jsonObject.has(JSON_REDIRECT_PORT_HTTPS))) {
            return false;
        }
        JsonElement jsonElement = jsonObject.get("result");
        JsonElement jsonElement2 = jsonObject.get(JSON_REDIRECT_URL);
        JsonElement jsonElement3 = jsonObject.get(JSON_REDIRECT_PORT_HTTP);
        JsonElement jsonElement4 = jsonObject.get(JSON_REDIRECT_PORT_HTTPS);
        if (jsonElement.isJsonNull() || jsonElement2.isJsonNull() || jsonElement3.isJsonNull() || jsonElement4.isJsonNull()) {
            return false;
        }
        return jsonElement.getAsInt() == 0 && Utilities.isValidText(jsonElement2.getAsString());
    }

    private String getMWPEErrorMsg(HttpServletRequest httpServletRequest, int n) {
        String string = "";
        switch (n) {
            case 11404: {
                string = "WORKER_NOT_AVAILABLE";
                break;
            }
            case 11405: {
                string = "WORKER_HAS_MAX_CLIENTS";
                break;
            }
            case 11406: {
                string = "WORKER_NOT_RUNNING";
                break;
            }
            case 11407: {
                string = "WORKER_NOT_CONFIGURED";
                break;
            }
        }
        return IWPI18N.get(httpServletRequest.getLocale(), string, new Object[0]);
    }

    private void handleLaunchCenter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Object object;
        String string;
        int n;
        if (FMRequestManager.getFMIDInfo(httpServletRequest)) {
            int n2;
            String string2 = httpServletRequest.getParameter(LOGIN_ERROR_QUERY);
            int n3 = n2 = Utilities.isValidText(string2) ? Integer.valueOf(string2) : 0;
            if (n2 != 0 && this.handleFMIDError(httpServletRequest, httpServletResponse, n2)) {
                return;
            }
            FMRequestManager.redirectToFMID(httpServletResponse);
            return;
        }
        this.locale = httpServletRequest.getLocale();
        httpServletResponse.setCharacterEncoding("UTF-8");
        Document document = FMRequestManager.loadDocument(this.contextPath, LAUNCH_CENTER_TEMPLATE, true);
        this.InsertNoJSContent(document);
        this.InsertNoCookieContent(document);
        Document document2 = FMRequestManager.loadDocument(this.contextPath, LOGIN_TEMPLATE, false);
        document.getElementById(DOM_LOGIN_CONTAINER).html(document2.body().html());
        Document document3 = FMRequestManager.loadDocument(this.contextPath, APPLEID_LOGIN_TEMPLATE, false);
        document.getElementById(DOM_APPLEID_LOGIN_CONTAINER).html(document3.body().html());
        Service service = Service.getInstance();
        boolean bl = false;
        boolean bl2 = true;
        Credentials credentials = null;
        boolean bl3 = false;
        boolean bl4 = false;
        DatabasesDataResult databasesDataResult = service.getDatabasesData(credentials);
        if (databasesDataResult != null) {
            n = databasesDataResult.getError().getErrorCode();
            if (n != ErrorCode.AccessDenied.getErrorCode() && n != ErrorCode.LoginRequired.getErrorCode()) {
                bl2 = false;
                string = this.getDBListDOM(httpServletRequest, databasesDataResult);
                if (string.isEmpty()) {
                    string = "&nbsp;";
                }
                object = document.getElementById(DOM_DB_LIST);
                object.html(string);
                if (n == ErrorCode.BlockNewUsers.getErrorCode()) {
                    bl4 = true;
                }
            }
            bl3 = databasesDataResult.isFmSelfSignedCertInstalled();
        } else {
            bl2 = false;
            bl = true;
        }
        this.setLocalizedStrings(document);
        this.setAriaLabels(document);
        if (this.showLoginElements(document, bl2, httpServletRequest)) {
            bl3 = false;
        }
        if (bl) {
            this.insertServerErrorContent(document);
        } else if (bl4) {
            this.InsertBlockNewUsersContent(document);
        } else {
            n = this.handleLogoutElements(document, httpServletRequest) ? 1 : 0;
            if (n == 0 && (bl3 || bl2)) {
                this.insertSelfSignedCertificateContent(document);
                n = 1;
            }
            if (n == 0 && document.getElementById(DOM_BANNER_CONTAINER) != null) {
                document.getElementById(DOM_BANNER_CONTAINER).remove();
            }
        }
        if (this.isMobile(httpServletRequest)) {
            this.insertMobileContent(document);
        }
        String string3 = null;
        string = PARAM_LOGIN_ATTEMPT_FAIL_TYPE;
        if (httpServletRequest.getParameter(PARAM_APPLEID) != null) {
            object = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_EMAIL);
            if (Utilities.isEmptyString((String)object)) {
                document.getElementById(DOM_APPLEID_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]));
                document.getElementById(DOM_APPLEID_SENDEMAIL).attr("value", IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
                document.getElementById(DOM_APPLEID_OK).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_OK_INFO", new Object[0]));
            } else if (httpServletRequest.getParameter(PARAM_APPLEID) != null && !this.emailSended) {
                if (this.isValidEmail((String)object)) {
                    var16_19 = Service.getInstance().sendAppleIDPasscodeEmail(this.sessionid, (String)object, this.locale.getLanguage());
                    if (var16_19 != null) {
                        this.emailSended = true;
                        IWPError iWPError = ((Result)var16_19).getError();
                        iWPError.setErrorCode(iWPError.getErrorCode());
                        int n4 = iWPError.getErrorCode();
                        if (iWPError.getErrorCode() != ErrorCode.None.getErrorCode()) {
                            String string4 = this.getErrorMsg(iWPError);
                            if (httpServletRequest.getParameter(PARAM_CUSTOM_FILTER_LOGIN) != null) {
                                string3 = string4;
                                string = String.valueOf(n4);
                            } else {
                                String string5 = this.getQueryParameter(httpServletRequest, "db");
                                document.getElementById(DOM_LOGIN_CONTAINER).attr("db", Utilities.normalizeHtmlText(string5));
                                document.getElementById(DOM_APPLEID_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]));
                                document.getElementById(DOM_APPLEID_EMAIL_ERROR_MSG).html(string4);
                                document.getElementById(DOM_APPLEID_EMAIL_ERROR_MSG).removeClass(DOM_HIDDEN_CLASS);
                                document.getElementById(DOM_APPLEID_SENDEMAIL).attr("value", IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
                            }
                        } else if (httpServletRequest.getParameter(PARAM_CUSTOM_FILTER_LOGIN) != null) {
                            string = String.valueOf(n4);
                        } else {
                            document.getElementById(DOM_APPLEID_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]));
                            document.getElementById(DOM_APPLEID_EMAIL).attr("value", (String)object);
                            document.getElementById(DOM_APPLEID_PASSCODE_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_PASSCODE_INFO", new Object[0]));
                            document.getElementById(DOM_APPLEID_SENDEMAIL).attr("value", IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
                            document.getElementById(DOM_APPLEID_OK).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_OK_INFO", new Object[0]));
                            document.getElementById(DOM_LOGIN_COUNT).html(httpServletRequest.getParameter("lgcnt"));
                        }
                    }
                } else if (httpServletRequest.getParameter(PARAM_CUSTOM_FILTER_LOGIN) != null) {
                    var16_19 = new IWPError();
                    ((IWPError)var16_19).setErrorCode(20805);
                    string3 = this.getErrorMsg((IWPError)var16_19);
                    string = String.valueOf(((IWPError)var16_19).getErrorCode());
                } else {
                    var16_19 = new IWPError();
                    ((IWPError)var16_19).setErrorCode(20805);
                    String string6 = this.getErrorMsg((IWPError)var16_19);
                    document.getElementById(DOM_APPLEID_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]));
                    document.getElementById(DOM_APPLEID_EMAIL_ERROR_MSG).html(string6);
                    document.getElementById(DOM_APPLEID_SENDEMAIL).attr("value", IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
                }
            }
        } else if (httpServletRequest.getParameter(PARAM_APPLEID_PASSCODE) != null) {
            object = httpServletRequest.getParameter(LOGIN_ERROR_QUERY);
            int n5 = Integer.valueOf((String)object);
            IWPError iWPError = new IWPError();
            iWPError.setErrorCode(n5);
            String string7 = this.getErrorMsg(iWPError);
            document.getElementById(DOM_APPLEID_LOGIN_ERROR_MSG).html(string7);
            document.getElementById(DOM_APPLEID_LOGIN_ERROR_MSG).removeClass(DOM_HIDDEN_CLASS);
            String string8 = this.getQueryParameter(httpServletRequest, "db");
            document.getElementById(DOM_LOGIN_CONTAINER).attr("db", Utilities.normalizeHtmlText(string8));
            document.getElementById(DOM_APPLEID_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]));
            document.getElementById(DOM_APPLEID_EMAIL).attr("value", this.storedEmail);
            document.getElementById(DOM_APPLEID_PASSCODE_MSG).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_PASSCODE_INFO", new Object[0]));
            document.getElementById(DOM_APPLEID_SENDEMAIL).attr("value", IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]));
            document.getElementById(DOM_APPLEID_OK).html(IWPI18N.get(this.locale, "LOGIN_APPLEID_OK_INFO", new Object[0]));
        }
        if (httpServletRequest.getParameter(PARAM_CUSTOM_FILTER_LOGIN) == null) {
            FMRequestManager.sendHtml(httpServletResponse, document.toString());
        } else {
            object = new JSONObject();
            try {
                object.put("result", (Object)string);
                if (string3 != null) {
                    object.put(JSON_DATA, string3);
                }
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            this.sendJson(httpServletResponse, object.toString());
        }
    }

    private boolean isValidEmail(String string) {
        String string2 = "([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean isSecureConnection(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getRequestURL().toString();
        String string2 = httpServletRequest.getHeader("Referer");
        String string3 = "" + httpServletRequest.getServerPort();
        if (IWPUtilities.isDebugMode() && string3.equals("16021")) {
            return true;
        }
        return string3.equals("443") || httpServletRequest.isSecure() || httpServletRequest.getProtocol().toLowerCase().indexOf("https") > -1 || !Utilities.isEmptyString(string) && string.startsWith("https") || !Utilities.isEmptyString(string2) && string2.startsWith("https");
    }

    private String getDBListDOM(HttpServletRequest httpServletRequest, DatabasesDataResult databasesDataResult) {
        Object object = "";
        String string = "";
        Object object2 = "";
        boolean bl = this.isSecureConnection(httpServletRequest) && databasesDataResult.isFmSelfSignedCertInstalled();
        List<Object> list = new ArrayList();
        list = databasesDataResult.getDatabasesData();
        for (DatabaseData databaseData : list) {
            String string2 = databaseData.getName();
            if (string2 == null) continue;
            object2 = databaseData.getUrlImage();
            if (!Utilities.isEmptyString((String)object2)) {
                int n = ((String)object2).indexOf("/docws");
                if (n == -1) {
                    object2 = null;
                } else if (IWPUtilities.isDebugMode()) {
                    System.out.println("DEBUG [Launch Center] --- " + string2 + " uses a custom icon which is expected to NOT show up with the development environment.  To ensure that custom icons are fully working, please make sure to test in installed version.");
                    String string3 = ((String)object2).substring(n);
                    object2 = "http://" + httpServletRequest.getServerName() + string3;
                } else {
                    object2 = ((String)object2).substring(n);
                }
            }
            if (Utilities.isEmptyString((String)object2) || bl) {
                object2 = DEFAULT_IMAGEURL;
            }
            string = String.format(DB_ELEMENT_TEMPLATE, object2, Utilities.normalizeHtmlText(string2), Utilities.normalizeHtmlText(string2));
            object = (String)object + string;
        }
        return object;
    }

    private boolean showLoginElements(Document document, boolean bl, HttpServletRequest httpServletRequest) {
        String string;
        Object object;
        String string2 = httpServletRequest.getParameter(LOGIN_ERROR_QUERY);
        String string3 = this.getQueryParameter(httpServletRequest, "db");
        boolean bl2 = httpServletRequest.getParameter(LOGIN_GUEST_ENABLED) != null ? httpServletRequest.getParameter(LOGIN_GUEST_ENABLED).equals("1") : true;
        int n = string2 != null ? Integer.valueOf(string2) : 0;
        boolean bl3 = httpServletRequest.getParameter(PARAM_APPLEID) != null;
        Credentials credentials = null;
        Service service = Service.getInstance();
        DatabasesDataResult databasesDataResult = service.getDatabasesData(credentials);
        if (databasesDataResult != null) {
            int n2 = databasesDataResult.getError().getErrorCode();
            if (n2 == ErrorCode.BlockNewUsers.getErrorCode()) {
                bl = false;
            } else if (Utilities.isValidText(string2) && n != ErrorCode.CannotOpenFile.getErrorCode() && n != ErrorCode.BlockNewUsers.getErrorCode()) {
                if (n == 0 || n == 20801 || n == 20802 || n == 20803) {
                    var13_14 = new IWPError();
                    var13_14.setErrorCode(212);
                    object = this.getErrorMsg(var13_14);
                    document.getElementById(DOM_LOGIN_ERROR_MSG).html((String)object);
                    document.getElementById(DOM_LOGIN_ERROR_MSG).addClass(DOM_HIDDEN_CLASS);
                    document.getElementById(DOM_LOGIN_NAME).removeClass(DOM_ERROR_CLASS);
                    document.getElementById(DOM_LOGIN_PWD).removeClass(DOM_ERROR_CLASS);
                } else {
                    var13_14 = new IWPError();
                    var13_14.setErrorCode(n);
                    var13_14.putToErrorAttributes(Attribute.FILENAME, string3);
                    object = this.getErrorMsg(var13_14);
                    document.getElementById(DOM_LOGIN_ERROR_MSG).html(Utilities.htmlSpecialChar((String)object));
                    document.getElementById(DOM_LOGIN_ERROR_MSG).removeClass(DOM_HIDDEN_CLASS);
                    document.getElementById(DOM_LOGIN_NAME).addClass(DOM_ERROR_CLASS);
                    document.getElementById(DOM_LOGIN_PWD).addClass(DOM_ERROR_CLASS);
                }
                if (Utilities.isValidText(string3)) {
                    document.getElementById(DOM_LOGIN_CONTAINER).attr("db", string3);
                    document.getElementById(DOM_LOGIN_CONTAINER).attr(LOGIN_HEADER_QUERY, IWPI18N.get(this.locale, "LOGIN_INFO", new Object[0]));
                    int n3 = 0;
                    object = httpServletRequest.getParameter("lgcnt");
                    if (Utilities.isValidText((String)object) && !bl3) {
                        n3 = Integer.parseInt((String)object) + 1;
                    }
                    document.getElementById(DOM_LOGIN_COUNT).html(String.valueOf(n3));
                }
                document.getElementById(DOM_LOGIN_CANCEL_BUTTON).removeClass(DOM_HIDDEN_CLASS);
                document.getElementById(DOM_LOGIN_DIALOG).removeClass(DOM_LOGIN_NO_CANCEL_CLASS);
                if (Service.getHostAllowGuestSignIn() && bl2) {
                    document.getElementById(DOM_LOGIN_GUEST_WRAPPER).removeClass(DOM_HIDDEN_CLASS);
                    document.getElementById(DOM_LOGIN_GUEST_WRAPPER).html(DOM_LOGIN_GUEST_BUTTON);
                    document.getElementById(DOM_LOGIN_GUEST).html(IWPI18N.get(this.locale, "LOGIN_GUEST", new Object[0]));
                    document.getElementById(DOM_LOGIN_GUEST).attr("aria-label", IWPI18N.get(this.locale, "LOGIN_GUEST", new Object[0]));
                } else {
                    document.getElementById(DOM_LOGIN_GUEST_WRAPPER).addClass(DOM_HIDDEN_CLASS);
                }
                bl = true;
            } else {
                IWPError iWPError = new IWPError();
                iWPError.setErrorCode(18);
                object = this.getErrorMsg(iWPError);
                document.getElementById(DOM_LOGIN_ERROR_MSG).html((String)object);
                document.getElementById(DOM_LOGIN_ERROR_MSG).addClass(DOM_HIDDEN_CLASS);
                document.getElementById(DOM_LOGIN_CANCEL_BUTTON).addClass(DOM_HIDDEN_CLASS);
                document.getElementById(DOM_LOGIN_DIALOG).addClass(DOM_LOGIN_NO_CANCEL_CLASS);
                document.getElementById(DOM_LOGIN_NAME).removeClass(DOM_ERROR_CLASS);
                document.getElementById(DOM_LOGIN_PWD).removeClass(DOM_ERROR_CLASS);
                document.getElementById(DOM_LOGIN_CONTAINER).attr("db", "");
                if (Service.getHostAllowGuestSignIn()) {
                    document.getElementById(DOM_LOGIN_GUEST_WRAPPER).html(DOM_LOGIN_GUEST_BUTTON);
                    document.getElementById(DOM_LOGIN_GUEST).html(IWPI18N.get(this.locale, "LOGIN_GUEST", new Object[0]));
                    document.getElementById(DOM_LOGIN_GUEST).attr("aria-label", IWPI18N.get(this.locale, "LOGIN_GUEST", new Object[0]));
                }
                bl = false;
            }
        }
        if (!((string = Service.getMasterAddr()).isEmpty() || string.equals("127.0.0.1") || string.equals("localhost"))) {
            document.getElementById(DOM_MASTER_ADDR).html(string);
        }
        Element element = document.getElementById(DOM_LOGIN_CONTAINER);
        object = document.getElementById(DOM_APPLEID_LOGIN_CONTAINER);
        object.addClass(DOM_HIDDEN_CLASS);
        if (bl) {
            element.removeClass(DOM_HIDDEN_CLASS);
        } else {
            element.addClass(DOM_HIDDEN_CLASS);
        }
        document.getElementById(DOM_LOGIN_HEADER_MSG).addClass("invisible");
        return bl;
    }

    public static Document loadDocument(String string, String string2, boolean bl) throws IOException {
        String string3 = string + string2;
        String string4 = new String(Files.readAllBytes(Paths.get(string3, new String[0])));
        if (bl) {
            string4 = string4.replaceAll("\\.\\./\\.\\./VAADIN/", "/fmi/VAADIN/");
        }
        Document document = Jsoup.parse((String)string4);
        Document.OutputSettings outputSettings = new Document.OutputSettings();
        outputSettings.prettyPrint(false);
        document.outputSettings(outputSettings);
        return document;
    }

    private void InsertNoJSContent(Document document) throws IOException {
        Document document2 = FMRequestManager.loadDocument(this.contextPath, SYSTEM_TEMPLATE, false);
        String string = IWPI18N.get(this.locale, "JS_OFF_ERROR", new Object[0]);
        document2.getElementById(DOM_BANNER_MSG).html(string);
        document.getElementById(DOM_NO_JS_CONTAINER).html(document2.body().html());
    }

    private void InsertNoCookieContent(Document document) throws IOException {
        Document document2 = FMRequestManager.loadDocument(this.contextPath, SYSTEM_TEMPLATE, false);
        String string = IWPI18N.get(this.locale, "COOKIES_DISABLED_CAPTION", new Object[0]);
        String string2 = IWPI18N.get(this.locale, "COOKIES_DISABLED_MESSAGE", new Object[0]);
        String string3 = String.format("<h1>%s</h1><p>%s</p>", string, string2);
        document2.getElementById(DOM_BANNER_CONTENT).html(string3);
        document.getElementById(DOM_NO_COOKIE_CONTAINER).html(document2.body().html());
    }

    private void insertMobileContent(Document document) {
        Element element = document.getElementById("fm-styles");
        if (element != null) {
            String string = element.attr("href");
            element.attr("href", string.replaceAll("styles-desktop.css", "styles-mobile.css"));
        }
    }

    private boolean handleLogoutElements(Document document, HttpServletRequest httpServletRequest) throws IOException {
        int n;
        int n2 = n = httpServletRequest.getParameter(PARAM_LOGOUT) != null ? Integer.parseInt(httpServletRequest.getParameter(PARAM_LOGOUT)) : SessionDisconnectType.SESSION_TIMEOUT.getValue();
        if (httpServletRequest.getParameter(PARAM_LOGOUT) != null) {
            if (n == Integer.valueOf(PARAM_LOGIN_ATTEMPT_FAIL_TYPE)) {
                return true;
            }
            Document document2 = FMRequestManager.loadDocument(this.contextPath, LOGOUT_TEMPLATE, false);
            String string = httpServletRequest.getParameter("db") != null ? this.getQueryParameter(httpServletRequest, "db") : "";
            String string2 = String.format(IWPI18N.get(this.locale, "USER_LOGGED_OUT", new Object[0]), Utilities.normalizeHtmlText(string));
            document2.getElementById(DOM_BANNER_MSG).html(string2);
            document.getElementById(DOM_BANNER_CONTAINER).html(document2.body().html());
            return true;
        }
        return false;
    }

    private void insertSelfSignedCertificateContent(Document document) throws IOException {
        if (document.getElementById(DOM_BANNER_CONTAINER) != null) {
            Document document2 = FMRequestManager.loadDocument(this.contextPath, ERROR_TEMPLATE, false);
            String string = IWPI18N.get(this.locale, "SELF_SIGNED_CERT_ERROR", new Object[0]);
            document2.getElementById(DOM_BANNER_MSG).html(string);
            document.getElementById(DOM_BANNER_CONTAINER).html(document2.body().html());
            document.getElementById(DOM_BANNER_CONTAINER).addClass("cert hidden");
        }
    }

    private void insertServerErrorContent(Document document) throws IOException {
        if (document.getElementById(DOM_BANNER_CONTAINER) != null) {
            Document document2 = FMRequestManager.loadDocument(this.contextPath, ERROR_TEMPLATE, false);
            String string = IWPI18N.get(this.locale, "COMMUNICATION_ERROR_CAPTION", new Object[0]);
            String string2 = IWPI18N.get(this.locale, "COMMUNICATION_ERROR_MESSAGE_ALT", new Object[0]);
            String string3 = String.format("<h1>%s</h1><br/><p>%s</p>", string, string2);
            document2.getElementById(DOM_BANNER_CONTENT).html(string3);
            document.getElementById(DOM_BANNER_CONTAINER).html(document2.body().html());
        }
    }

    private void InsertBlockNewUsersContent(Document document) throws IOException {
        if (document.getElementById(DOM_BANNER_CONTAINER) != null) {
            Document document2 = FMRequestManager.loadDocument(this.contextPath, ERROR_TEMPLATE, false);
            String string = IWPI18N.get(this.locale, "e_1638_0", new Object[0]);
            String string2 = String.format("<h1>%s</h1><br/>", string);
            document2.getElementById(DOM_BANNER_CONTENT).html(string2);
            document.getElementById(DOM_BANNER_CONTAINER).html(document2.body().html());
        }
    }

    private void setLocalizedStrings(Document document) {
        document.getElementById(DOM_FILTER_TEXT).attr("placeholder", IWPI18N.get(this.locale, "FILTER", new Object[0]));
        document.getElementById(DOM_LOGIN_HEADER_MSG).html(IWPI18N.get(this.locale, "LOGIN_INST", new Object[0]));
        document.getElementById(DOM_OAUTH_REQUIRED_MSG).html(IWPI18N.get(this.locale, "LOGIN_OAUTH_REQUIRED", new Object[0]));
        document.getElementById(DOM_LOGIN_NAME).attr("placeholder", IWPI18N.get(this.locale, "LOGIN_NAME_PLACEHOLDER", new Object[0]));
        document.getElementById(DOM_LOGIN_PWD).attr("placeholder", IWPI18N.get(this.locale, "LOGIN_PASSWORD_PLACEHOLDER", new Object[0]));
        document.getElementById(DOM_LOGIN_NONGUEST).html(IWPI18N.get(this.locale, "LOGIN_NONGUEST", new Object[0]));
        document.getElementById(DOM_LOGIN_CONTAINER).attr(LOGIN_HEADER_QUERY, IWPI18N.get(this.locale, "LOGIN_INST", new Object[0]));
        document.getElementById(DOM_LOGIN_CONTAINER).attr(LOGIN_HEADER_ELLIPSIS_QUERY, IWPI18N.get(this.locale, "LOGIN_INFO_ELLIPSIS", new Object[0]));
    }

    private void setElementAriaLabel(Document document, String string, String string2) {
        Element element = document.getElementById(string);
        if (element != null) {
            element.attr("aria-label", IWPI18N.get(this.locale, string2, new Object[0]));
        }
    }

    private void setAriaLabels(Document document) {
        this.setElementAriaLabel(document, DOM_VIEW_GRID, "TILE_VIEW_ARIA_LABEL");
        this.setElementAriaLabel(document, DOM_VIEW_LIST, "LIST_VIEW_ARIA_LABEL");
        this.setElementAriaLabel(document, DOM_LOGIN_CANCEL_BUTTON, "CLOSE");
        this.setElementAriaLabel(document, DOM_FILTER_TEXT, "FILTER");
        this.setElementAriaLabel(document, DOM_LOGIN_NAME, "LOGIN_NAME_PLACEHOLDER");
        this.setElementAriaLabel(document, DOM_LOGIN_PWD, "LOGIN_PASSWORD_PLACEHOLDER");
        this.setElementAriaLabel(document, DOM_APPLEID_EMAIL, "LOGIN_APPLEID_INFO");
        this.setElementAriaLabel(document, DOM_APPLEID_SENDEMAIL, "LOGIN_APPLEID_SENDEMAIL_INFO");
        this.setElementAriaLabel(document, "codeBox1", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, "codeBox2", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, "codeBox3", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, "codeBox4", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, "codeBox5", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, "codeBox6", "LOGIN_APPLEID_PASSCODE_INFO");
        this.setElementAriaLabel(document, DOM_APPLEID_OK, "LOGIN_APPLEID_OK_INFO");
    }

    private void handleLoginList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Credentials credentials;
        DatabasesDataResult databasesDataResult;
        boolean bl = httpServletRequest.getParameter(PARAM_GUEST).equals("1");
        boolean bl2 = httpServletRequest.getParameter(PARAM_OAUTH).equals("1");
        boolean bl3 = httpServletRequest.getParameter(PARAM_APPLEID) != null ? httpServletRequest.getParameter(PARAM_APPLEID).equals("1") : false;
        boolean bl4 = httpServletRequest.getParameter(PARAM_FMID).equals("1");
        String string = this.getPostDataAsUTF8(httpServletRequest, PARAM_USER);
        String string2 = this.getPostDataAsUTF8(httpServletRequest, PARAM_PWD);
        String string3 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_EMAIL);
        String string4 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_PASSCODE);
        int n = Integer.valueOf(httpServletRequest.getParameter("lgcnt"));
        String string5 = PARAM_LOGIN_ATTEMPT_FAIL_TYPE;
        String string6 = null;
        boolean bl5 = false;
        String string7 = null;
        String string8 = null;
        this.locale = httpServletRequest.getLocale();
        JSONObject jSONObject = new JSONObject();
        Service service = Service.getInstance();
        if (bl4) {
            string = this.getFMIDTokens(string, string2)[0];
            string2 = "";
        } else {
            string = this.validateInputStringLength(string);
            string2 = this.validateInputStringLength(string2);
        }
        if (bl3) {
            string = this.storedUserName;
            string2 = this.storedPwd;
        }
        if ((databasesDataResult = service.getDatabasesData(credentials = new Credentials(string, string2, string3, string4, bl, bl2, bl3, bl4, true, "", "fmwebdirect"))) != null) {
            IWPError iWPError = databasesDataResult.getError();
            int n2 = iWPError.getErrorCode();
            if (n2 == ErrorCode.None.getErrorCode()) {
                string6 = this.getDBListDOM(httpServletRequest, databasesDataResult);
            } else if (n2 == ErrorCode.AppleIdNotFoundErrorStrID.getErrorCode()) {
                Session session = service.getSession(null);
                SessionInfo sessionInfo = session.createSession();
                this.sessionid = sessionInfo.getSessionId();
                this.locale = httpServletRequest.getLocale();
                string7 = IWPI18N.get(this.locale, "LOGIN_APPLEID_INFO", new Object[0]);
                string8 = IWPI18N.get(this.locale, "LOGIN_APPLEID_SENDEMAIL_INFO", new Object[0]);
                this.storedUserName = string;
                this.storedPwd = string2;
            } else if (n2 == ErrorCode.AppleIdPasscodeNotFoundErrorStrID.getErrorCode() || n2 == ErrorCode.AppleIdPasscodeExpireErrorStrID.getErrorCode() || n2 == ErrorCode.InvalidAppleIdTypeAccountErrorStrID.getErrorCode() || n2 == ErrorCode.AppleIdAccountDisabledErrorStrID.getErrorCode()) {
                if (n > 2) {
                    IWPError iWPError2 = new IWPError();
                    iWPError2.setErrorCode(9);
                    String string9 = "e_" + iWPError2.getErrorCode() + "_0";
                    string6 = IWPI18N.get(this.locale, string9, new Object[0]);
                } else {
                    string6 = this.getErrorMsg(iWPError);
                }
            } else {
                string6 = this.getErrorMsg(iWPError);
            }
            string5 = String.valueOf(n2);
            bl5 = this.isSecureConnection(httpServletRequest) && databasesDataResult.isFmSelfSignedCertInstalled();
        }
        try {
            jSONObject.put("result", (Object)string5);
            jSONObject.put("lgcnt", (Object)String.valueOf(++n));
            jSONObject.put(JSON_APPLEID_EMAIL_HEADERMSG, string7);
            jSONObject.put(JSON_APPLEID_EMAIL_SENDBTN, string8);
            if (string6 != null) {
                jSONObject.put(JSON_DATA, (Object)string6);
            }
            jSONObject.put("cert", (Object)(bl5 ? "1" : "0"));
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.sendJson(httpServletResponse, jSONObject.toString());
    }

    private String getErrorMsg(IWPError iWPError) {
        if (this.messenger == null) {
            this.messenger = new Messenger(null);
        }
        return this.messenger.getUserFriendlyErrorMessage(iWPError, this.locale);
    }

    private boolean handleOpenDatabase(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String string = IWPUtilities.getCaseInsensitiveURI(httpServletRequest.getRequestURI());
        if (string.contains("/fmi/webd") && !string.endsWith("/fmi/webd") && !string.endsWith("/fmi/webd/")) {
            String string2;
            String string3 = httpServletRequest.getParameter(PARAM_PID);
            String string4 = this.getPostDataAsUTF8(httpServletRequest, PARAM_USER);
            String string5 = this.getPostDataAsUTF8(httpServletRequest, PARAM_PWD);
            String string6 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_EMAIL);
            String string7 = this.getPostDataAsUTF8(httpServletRequest, PARAM_APPLEID_PASSCODE);
            boolean bl = httpServletRequest.getParameter(PARAM_FMID) != null ? httpServletRequest.getParameter(PARAM_FMID).equals("1") : false;
            boolean bl2 = this.bReDirectToWA = httpServletRequest.getParameter(PARAM_WA) != null ? httpServletRequest.getParameter(PARAM_WA).equals("1") : false;
            if (bl) {
                if (string3 == null ? !Utilities.isValidText(string4) || !Utilities.isValidText(string5) : this.getSessionInfo(string3) == null) {
                    return this.doFMIDLogin(httpServletRequest, httpServletResponse);
                }
                string2 = this.getPostDataAsUTF8(httpServletRequest, PARAM_HOST_NAME);
                if (string2 != null && string2.length() > 0) {
                    trustDomains.add(string2.toLowerCase());
                }
            }
            if (string3 == null) {
                boolean bl3;
                string2 = URLDecoder.decode(this.preservePlusSignInDatabaseName(IWPUtilities.getDatabaseNameFromPath(string)), "UTF-8");
                boolean bl4 = httpServletRequest.getParameter(PARAM_GUEST) != null ? httpServletRequest.getParameter(PARAM_GUEST).equals("1") : false;
                boolean bl5 = httpServletRequest.getParameter(PARAM_OAUTH) != null ? httpServletRequest.getParameter(PARAM_OAUTH).equals("1") : false;
                int n = httpServletRequest.getParameter(PARAM_AUTH_ERROR) != null ? Integer.parseInt(httpServletRequest.getParameter(PARAM_AUTH_ERROR)) : 0;
                boolean bl6 = httpServletRequest.getParameter(PARAM_FORCE_LOGIN) != null ? httpServletRequest.getParameter(PARAM_FORCE_LOGIN).equals("1") : false;
                boolean bl7 = bl3 = httpServletRequest.getParameter(PARAM_APPLEID) != null ? httpServletRequest.getParameter(PARAM_APPLEID).equals("1") : false;
                if (Utilities.isValidText(string2) && Utilities.isValidText(string4)) {
                    Object object;
                    Object object2;
                    Object object3;
                    if (!this.isPost) {
                        httpServletResponse.sendError(400);
                        return true;
                    }
                    Service service = Service.getInstance();
                    Session session = service.getSession(null);
                    SessionInfo sessionInfo = session.createSession();
                    session.updateSession(sessionInfo.getSessionId(), sessionInfo.getTimeout(), sessionInfo.getUploadDirectoryPath());
                    String string8 = null;
                    SessionContext sessionContext = null;
                    if (bl) {
                        boolean bl8 = FMRequestManager.getAllowCredentials(string2);
                        object3 = httpServletRequest.getParameter(PARAM_RELOGIN);
                        if (bl8 || "true".equalsIgnoreCase((String)object3)) {
                            object2 = this.getFMIDTokens(string4, string5);
                            string4 = object2[0];
                            string5 = "";
                            sessionContext = new SessionContext(sessionInfo, httpServletRequest.getLocale());
                            if (!Utilities.isEmptyString(string4)) {
                                sessionContext.setFMID(string4);
                                sessionContext.setRefreshToken(object2[1]);
                                this.setCanShare(sessionContext, string4, string2);
                                if (this.bReDirectToWA) {
                                    this.openWebAuthoring(string2, object2[1], httpServletResponse);
                                    this.setDirectToWA(false);
                                    return true;
                                }
                            }
                            string8 = UUID.randomUUID().toString();
                            this.sessionContextMap.put(string8, sessionContext);
                        } else {
                            string4 = "";
                            string5 = "";
                        }
                    } else {
                        string4 = this.validateInputStringLength(string4);
                        string5 = this.validateInputStringLength(string5);
                    }
                    if (bl3) {
                        string4 = this.storedUserName;
                        string5 = this.storedPwd;
                    }
                    Credentials credentials = new Credentials(string4, string5, string6, string7, bl4, bl5, bl3, bl, true, string2, "fmwebdirect");
                    object3 = new BrowserInfoHandler(httpServletRequest);
                    ((BrowserInfoHandler)object3).setPersistentID(App.getPersistentID(httpServletRequest, httpServletResponse));
                    object2 = Service.getInstance().openDatabase(sessionInfo.getSessionId(), credentials, bl6, ((BrowserInfoHandler)object3).getBrowserClientInfo(), null, false, false);
                    int n2 = object2 != null ? ((ContextResult)object2).getError().getErrorCode() : -1;
                    n2 = n == -1 ? ErrorCode.URLConnectionAuthenticationFalied.getErrorCode() : n2;
                    Object object4 = IWPUtilities.getCaseInsensitiveURI(httpServletRequest.getRequestURI());
                    if (n2 != 0 && n2 != 20801 && httpServletRequest.getParameter("homeurl") != null) {
                        if (FMRequestManager.getFMIDInfo(httpServletRequest) && this.handleFMIDError(httpServletRequest, httpServletResponse, n2)) {
                            return true;
                        }
                        object = App.validateHomeurl(httpServletRequest.getParameter("homeurl"), AppServlet.getCustomHomeurl());
                        if (object != null) {
                            object4 = object;
                        }
                    }
                    object = "";
                    String string9 = httpServletRequest.getQueryString();
                    if (string9 != null) {
                        try {
                            object4 = FMRequestManager.appendUrlQuery((String)object4, string9);
                        }
                        catch (URISyntaxException uRISyntaxException) {
                            uRISyntaxException.printStackTrace();
                            object4 = (String)object4 + "?" + string9;
                        }
                    }
                    if (n2 == 0 || n2 == ErrorCode.PasswordExpired.getErrorCode()) {
                        session.updateContext(true, ((ContextResult)object2).getContext());
                        if (sessionContext != null) {
                            sessionContext.setLocale(httpServletRequest.getLocale());
                        } else {
                            string8 = UUID.randomUUID().toString();
                            sessionContext = new SessionContext(sessionInfo, httpServletRequest.getLocale());
                            this.sessionContextMap.put(string8, sessionContext);
                        }
                        object = String.format("%s=%s", PARAM_PID, string8);
                        if (n2 == ErrorCode.PasswordExpired.getErrorCode()) {
                            object = String.format("%s&%s=1", object, PARAM_PWD_EXPIRED);
                        }
                        object4 = FMRequestManager.removeQueryParameter((String)object4, "lgcnt");
                    } else if (bl3 && n2 == ErrorCode.URLConnectionAuthenticationFalied.getErrorCode()) {
                        object4 = FMRequestManager.removeQueryParameter((String)object4, PARAM_APPLEID);
                    } else {
                        int n3;
                        int n4 = n3 = httpServletRequest.getParameter("lgcnt") != null ? Integer.valueOf(httpServletRequest.getParameter("lgcnt")) : 0;
                        if (n3 < 5 && httpServletRequest.getParameter(PARAM_APPLEID) == null || n3 < 2 && httpServletRequest.getParameter(PARAM_APPLEID) != null) {
                            int n5;
                            int n6 = ((ContextResult)object2).getContext().isGuestEnabled() ? 1 : 0;
                            int n7 = n5 = ((ContextResult)object2).getContext().isHideLocalAccountEntry() ? 1 : 0;
                            if (Utilities.isEmptyString(credentials.getUsername()) && Utilities.isEmptyString(credentials.getPassword())) {
                                n2 = 0;
                            }
                            object = String.format("%s=%s&%s=%d&%s=%d&%s=%d", "db", FMRequestManager.encodeString(string2), LOGIN_ERROR_QUERY, n2, LOGIN_GUEST_ENABLED, n6, LOGIN_HIDELOCALACCOUNTENTRY, n5);
                            if (n2 == 20801) {
                                object = (String)object + "&appleid=1";
                                this.storedUserName = string4;
                                this.storedPwd = string5;
                                this.sessionid = sessionInfo.getSessionId();
                            } else if (n2 == 20802 || n2 == 20803 || n2 == 20804 || n2 == 20810) {
                                this.storedEmail = string6;
                                object4 = FMRequestManager.removeQueryParameter((String)object4, LOGIN_ERROR_QUERY);
                                object4 = FMRequestManager.removeQueryParameter((String)object4, PARAM_APPLEID);
                                object = (String)object + "&appleidpasscode=1";
                            }
                            if (httpServletRequest.getParameter("homeurl") == null && ((String)object4).indexOf("lgcnt") == -1) {
                                object = (String)object + "&lgcnt=" + n3;
                            }
                        } else {
                            object4 = IWPUtilities.getCaseInsensitiveURI(httpServletRequest.getRequestURI());
                            int n8 = ((String)object4).indexOf(IWPUtilities.getDatabaseNameFromPath(string));
                            if (n8 > -1) {
                                object4 = ((String)object4).substring(0, n8 - 1);
                                try {
                                    object4 = FMRequestManager.appendUrlQuery((String)object4, "logout=-1");
                                }
                                catch (URISyntaxException uRISyntaxException) {
                                    uRISyntaxException.printStackTrace();
                                }
                                httpServletResponse.sendRedirect(this.resolveRelativePath(httpServletRequest, (String)object4));
                                return true;
                            }
                        }
                    }
                    try {
                        object4 = FMRequestManager.appendUrlQuery((String)object4, (String)object);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        uRISyntaxException.printStackTrace();
                        object4 = string9 != null ? (String)object4 + "&" + (String)object : (String)object4 + "?" + (String)object;
                    }
                    httpServletResponse.sendRedirect(this.resolveRelativePath(httpServletRequest, (String)object4));
                    return true;
                }
            }
        }
        return false;
    }

    private String resolveRelativePath(HttpServletRequest httpServletRequest, String string) {
        boolean bl;
        Object object = "";
        boolean bl2 = bl = !string.startsWith("https") && !string.startsWith("http");
        if (Utilities.isWindows() && bl) {
            object = "https".equals(httpServletRequest.getHeader("X-Forwarded-Proto")) ? "https://" + httpServletRequest.getHeader("X-Forwarded-Host") : "http://" + httpServletRequest.getHeader("X-Forwarded-Host");
        }
        return (String)object + string;
    }

    public static String appendUrlQuery(String string, String string2) throws URISyntaxException {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (string.indexOf("?") > -1) {
            stringBuilder.append("&");
        } else {
            stringBuilder.append("?");
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private String getPostDataAsUTF8(HttpServletRequest httpServletRequest, String string) {
        String string2;
        String string3 = httpServletRequest.getParameter(string);
        String string4 = string2 = httpServletRequest.getCharacterEncoding() != null ? httpServletRequest.getCharacterEncoding().toUpperCase() : "";
        if (string3 != null && !string2.equals("UTF-8")) {
            try {
                byte[] byArray = string3.getBytes("ISO-8859-1");
                return new String(byArray, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        return string3;
    }

    private String getQueryParameter(HttpServletRequest httpServletRequest, String string) {
        String string2 = httpServletRequest.getQueryString();
        if (string2 != null) {
            String[] stringArray;
            for (String string3 : stringArray = string2.split("&")) {
                String[] stringArray2 = string3.split("=");
                if (stringArray2 == null || stringArray2.length != 2 || !stringArray2[0].equals(string)) continue;
                return FMRequestManager.decodeString(stringArray2[1]);
            }
        }
        return "";
    }

    public static String encodeString(String string) {
        String string2;
        try {
            string2 = URLEncoder.encode((String)string, (String)"UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            string2 = string;
        }
        return string2;
    }

    public static String decodeString(String string) {
        String string2;
        try {
            string2 = URLDecoder.decode(string, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            string2 = string;
        }
        return string2;
    }

    public static String removeQueryParameter(String object, String string) {
        String string2;
        String[] stringArray = ((String)object).split("\\?", 2);
        if (stringArray != null && stringArray.length == 2 && (string2 = stringArray[1]) != null) {
            String string3 = String.format("(&%s=[^&]*|%s=[^&]*?(&|$))", string, string);
            string2 = string2.replaceAll(string3, "");
            object = stringArray[0];
            if (!string2.isEmpty()) {
                object = (String)object + "?" + string2;
            }
        }
        return object;
    }

    public static void replaceBrowserUrl(App app, String string) {
        String string2 = "window.history.replaceState(null, null, \"" + string + "\");";
        app.getPage().getJavaScript().execute(string2);
    }

    public boolean isDirectToWA() {
        return this.bReDirectToWA;
    }

    public void setDirectToWA(boolean bl) {
        this.bReDirectToWA = bl;
    }

    public SessionContext getSessionContext(VaadinRequest vaadinRequest) {
        return this.getSessionContext(vaadinRequest.getParameter(PARAM_PID));
    }

    private SessionContext getSessionContext(String string) {
        return string != null ? this.sessionContextMap.get(string) : null;
    }

    private SessionInfo getSessionInfo(String string) {
        SessionContext sessionContext = this.getSessionContext(string);
        return sessionContext != null ? sessionContext.getSessionInfo() : null;
    }

    public void clearSessionContext(VaadinRequest vaadinRequest, App app) {
        String string = app.getPage().getLocation().toString();
        boolean bl = false;
        String string2 = vaadinRequest.getParameter(PARAM_PID);
        if (string2 != null) {
            this.sessionContextMap.remove(string2);
            string = FMRequestManager.removeQueryParameter(string, PARAM_PID);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_PWD_EXPIRED) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_PWD_EXPIRED);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_GUEST) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_GUEST);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_OAUTH) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_OAUTH);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_FMID) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_FMID);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_AUTH_ERROR) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_AUTH_ERROR);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_RELOGIN) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_RELOGIN);
            bl = true;
        }
        if (vaadinRequest.getParameter("lgcnt") != null) {
            string = FMRequestManager.removeQueryParameter(string, "lgcnt");
            bl = true;
        }
        if (vaadinRequest.getParameter("redirected") != null) {
            string = FMRequestManager.removeQueryParameter(string, "redirected");
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_APPLEID) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_APPLEID);
            bl = true;
        }
        if (vaadinRequest.getParameter(PARAM_APPLEID_PASSCODE) != null) {
            string = FMRequestManager.removeQueryParameter(string, PARAM_APPLEID_PASSCODE);
            bl = true;
        }
        if (vaadinRequest.getParameter("db") != null) {
            string = FMRequestManager.removeQueryParameter(string, "db");
            bl = true;
        }
        if (vaadinRequest.getParameter(LOGIN_ERROR_QUERY) != null) {
            string = FMRequestManager.removeQueryParameter(string, LOGIN_ERROR_QUERY);
            bl = true;
        }
        if (bl) {
            FMRequestManager.replaceBrowserUrl(app, string);
        }
    }

    private boolean isRequestValid(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            if (!ConfigurationHandler.getInstance(this.contextPath).isIWPEnabled()) {
                httpServletResponse.sendError(404);
                return false;
            }
            if (!this.isSupportedBrowser(httpServletRequest)) {
                this.sendMessagePageToBrowser(httpServletRequest, httpServletResponse, "UNSUPPORTED_BROWSER_ERROR");
                return false;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return true;
    }

    private void sendMessagePageToBrowser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String string) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        Document document = FMRequestManager.loadDocument(this.contextPath, INFO_PAGE_TEMPLATE, false);
        String string2 = IWPI18N.get(httpServletRequest.getLocale(), string, new Object[0]);
        document.getElementById(DOM_INFO_PAGE_MSG).html(string2);
        FMRequestManager.sendHtml(httpServletResponse, document.toString());
    }

    private boolean isSupportedBrowser(HttpServletRequest httpServletRequest) {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.updateRequestDetails((VaadinRequest)new VaadinServletRequest(httpServletRequest, null));
        return IWPUtilities.isSupportedBrowser(webBrowser);
    }

    private boolean isMobile(HttpServletRequest httpServletRequest) {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.updateRequestDetails((VaadinRequest)new VaadinServletRequest(httpServletRequest, null));
        return webBrowser.isIOS() || webBrowser.isAndroid();
    }

    public boolean shouldHandleRequest(HttpServletRequest httpServletRequest) {
        if (this.isPushRequest(httpServletRequest)) {
            return false;
        }
        if ("post".equals(httpServletRequest.getMethod().toLowerCase()) && httpServletRequest.getParameter("v-browserDetails") != null) {
            return false;
        }
        String string = httpServletRequest.getPathInfo();
        if (string != null && string.startsWith("/APP/connector/")) {
            return false;
        }
        if (this.isUIDLRequest(httpServletRequest)) {
            return false;
        }
        if (this.isFileUploadRequest(httpServletRequest)) {
            return false;
        }
        if (this.isHeartbeatRequest(httpServletRequest)) {
            return false;
        }
        if (this.isPublishedFileRequest(httpServletRequest)) {
            return false;
        }
        if (this.isAppRequest(httpServletRequest)) {
            return false;
        }
        String string2 = httpServletRequest.getRequestURI();
        return string2 == null || !string2.startsWith("/fmi/VAADIN");
    }

    private boolean isPushRequest(HttpServletRequest httpServletRequest) {
        return this.isPathInfo(httpServletRequest, "PUSH");
    }

    private boolean isUIDLRequest(HttpServletRequest httpServletRequest) {
        return this.hasPathPrefix(httpServletRequest, "UIDL/");
    }

    private boolean isFileUploadRequest(HttpServletRequest httpServletRequest) {
        return this.hasPathPrefix(httpServletRequest, "APP/UPLOAD/");
    }

    private boolean isHeartbeatRequest(HttpServletRequest httpServletRequest) {
        return this.hasPathPrefix(httpServletRequest, "HEARTBEAT/");
    }

    private boolean isPublishedFileRequest(HttpServletRequest httpServletRequest) {
        return this.hasPathPrefix(httpServletRequest, "APP/PUBLISHED/");
    }

    private boolean isAppRequest(HttpServletRequest httpServletRequest) {
        return this.hasPathPrefix(httpServletRequest, "APP/");
    }

    private boolean hasPathPrefix(HttpServletRequest httpServletRequest, String object) {
        String string = httpServletRequest.getPathInfo();
        if (string == null) {
            return false;
        }
        if (!((String)object).startsWith("/")) {
            object = "/" + (String)object;
        }
        return string.startsWith((String)object);
    }

    private boolean isPathInfo(HttpServletRequest httpServletRequest, String object) {
        String string = httpServletRequest.getPathInfo();
        if (string == null) {
            return false;
        }
        if (!((String)object).startsWith("/")) {
            object = "/" + (String)object;
        }
        return string.equals(object);
    }

    public static void handleLoginError(App app, Credentials credentials) throws MalformedURLException {
        int n;
        Object object;
        Object object2 = object = app.getLogoutURL() != null ? app.getLogoutURL() : "/fmi/webd";
        if (((String)object).endsWith("/")) {
            object = ((String)object).substring(0, ((String)object).length() - 1);
        }
        if ((n = app.getLoginErrorCode()) != ErrorCode.UserAbort.getErrorCode()) {
            String string = new URL(app.getPage().getLocation().toString()).getQuery();
            if (Utilities.isValidText(string)) {
                object = (String)object + "?" + string;
            }
            if (credentials != null) {
                int n2 = app.isGuestEnabled() ? 1 : 0;
                int n3 = app.hideLocalAccountEntry() ? 1 : 0;
                String string2 = FMRequestManager.encodeString(credentials.getDatabase());
                if (Utilities.isEmptyString(credentials.getUsername()) && Utilities.isEmptyString(credentials.getPassword()) && n != ErrorCode.CannotOpenFile.getErrorCode() && n != ErrorCode.AccessDenied.getErrorCode() && n != ErrorCode.BlockNewUsers.getErrorCode()) {
                    n = 0;
                }
                String string3 = String.format("%s=%s&%s=%d&%s=%d&%s=%d", "db", string2, LOGIN_ERROR_QUERY, n, LOGIN_GUEST_ENABLED, n2, LOGIN_HIDELOCALACCOUNTENTRY, n3);
                try {
                    object = FMRequestManager.appendUrlQuery((String)object, string3);
                }
                catch (URISyntaxException uRISyntaxException) {
                    uRISyntaxException.printStackTrace();
                    if (Utilities.isEmptyString(string)) {
                        object = (String)object + "?";
                    }
                    object = (String)object + string3;
                }
            }
        }
        app.getPage().setLocation((String)object);
    }

    public static String getUserLogoutURL(App app, SessionDisconnectType sessionDisconnectType) {
        Object object;
        if (sessionDisconnectType == null) {
            sessionDisconnectType = SessionDisconnectType.USER_LOGOUT;
        }
        if ((object = app.getLogoutURL()) == null) {
            object = "/fmi/webd?logout=" + sessionDisconnectType.getValue();
            switch (sessionDisconnectType) {
                case USER_LOGOUT: 
                case ADMIN_CLOSE: 
                case SESSION_TIMEOUT: {
                    String string = FMRequestManager.encodeString(app.getAppView().getLastDatabaseName());
                    object = (String)object + "&db=" + string;
                    break;
                }
            }
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getRedirectJson() {
        String string = "{}";
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        try {
            int n;
            httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR(REDIRECT_API, "GET");
            if (httpURLConnection != null && (n = httpURLConnection.getResponseCode()) == 200) {
                String string2;
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while ((string2 = bufferedReader.readLine()) != null) {
                    stringBuffer.append(string2);
                }
                string = stringBuffer.toString();
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
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return string;
    }

    private void sendJson(HttpServletResponse httpServletResponse, String string) throws IOException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.getWriter().write(string);
    }

    public static void sendHtml(HttpServletResponse httpServletResponse, String string) throws IOException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(string);
    }

    private String validateInputStringLength(String string) {
        if (Utilities.isValidText(string) && string.length() > 100) {
            return string.substring(0, 100);
        }
        return string;
    }

    private boolean isWpeStatusRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String string = httpServletRequest.getRequestURI().toLowerCase();
        if (string.startsWith("/fmi/webd") && string.endsWith("/api/status")) {
            DatabasesDataResult databasesDataResult = Service.getInstance().getDatabasesData((Credentials)null);
            if (databasesDataResult != null) {
                httpServletResponse.setStatus(200);
            } else {
                httpServletResponse.setStatus(400);
            }
            return true;
        }
        return false;
    }

    private String preservePlusSignInDatabaseName(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                if (c == '+') {
                    stringBuffer.append("%2B");
                    continue;
                }
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String[] getFMIDTokens(String string, String string2) {
        String[] stringArray = new String[]{"", ""};
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR(TOKENEXCHANGE_API, "POST");
            if (httpURLConnection != null) {
                String string3 = "code=" + string + "&redirectUrl=" + string2;
                byte[] byArray = string3.getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("charset", "utf-8");
                httpURLConnection.setRequestProperty("Content-Length", Integer.toString(byArray.length));
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(byArray);
                dataOutputStream.flush();
                dataOutputStream.close();
                int n = httpURLConnection.getResponseCode();
                if (n == 200) {
                    String string4;
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((string4 = bufferedReader.readLine()) != null) {
                        stringBuffer.append(string4);
                    }
                    JsonParser jsonParser = new JsonParser();
                    String string5 = stringBuffer.toString();
                    JsonObject jsonObject = (JsonObject)jsonParser.parse(string5);
                    if (jsonObject.has(JSON_JWT_TOKEN)) {
                        stringArray[0] = jsonObject.get(JSON_JWT_TOKEN).getAsString();
                    }
                    if (jsonObject.has(JSON_REFRESH_TOKEN)) {
                        stringArray[1] = jsonObject.get(JSON_REFRESH_TOKEN).getAsString();
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
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return stringArray;
    }

    private void openWebAuthoring(String string, String string2, HttpServletResponse httpServletResponse) {
        try {
            String string3 = FMRequestManager.loadDocument(this.contextPath, WA_OPEN_TEMPLATE, true).toString().replace("param_db", string).replace("param_rToken", string2);
            FMRequestManager.sendHtml(httpServletResponse, string3);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void setCanShare(SessionContext sessionContext, String string, String string2) {
        boolean bl;
        block5: {
            bl = false;
            String string3 = this.getSecurityMgmtInfo(string, string2);
            try {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(string3);
                JsonElement jsonElement = jsonObject.get(JSON_DATA);
                if (jsonElement == null || jsonElement.isJsonNull()) break block5;
                JsonObject jsonObject2 = jsonObject.getAsJsonObject(JSON_DATA);
                JsonArray jsonArray = jsonObject2.getAsJsonArray("availablePrivilege");
                for (int i = 0; i < jsonArray.size(); ++i) {
                    String string4 = jsonArray.get(i).getAsString();
                    if (!bl && (string4.equals("[Full Access]") || string4.equals("[Data Entry Only]"))) {
                        bl = true;
                    }
                    if (!bl) {
                        continue;
                    }
                    break;
                }
            }
            catch (Exception exception) {
                System.err.println("FMRequestManager::canUserShareFile(): error = " + String.valueOf(exception));
            }
        }
        sessionContext.setCanShareFile(bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getSecurityMgmtInfo(String string, String string2) {
        String string3 = "{}";
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String string4 = "http://localhost:1895/fmws/database/securitymgmtinfo?dbname=" + Utilities.encodeURI(string2 + ".fmp12") + "&stats=1";
        try {
            httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR(string4, "GET");
            httpURLConnection.setRequestProperty("X-FMS-JWT", string);
            if (httpURLConnection != null) {
                int n = httpURLConnection.getResponseCode();
                if (n == 200) {
                    String string5;
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((string5 = bufferedReader.readLine()) != null) {
                        stringBuffer.append(string5);
                    }
                    string3 = stringBuffer.toString();
                } else {
                    System.err.println("FMRequestManager::getSecurityMgmtInfo(): responseCode = " + n);
                }
            }
        }
        catch (Exception exception) {
            System.err.println("FMRequestManager::getSecurityMgmtInfo(): error = " + String.valueOf(exception));
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return string3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean getFMIDInfo(HttpServletRequest httpServletRequest) {
        boolean bl;
        block18: {
            if (fmidURL != null && clientID != null) {
                return !fmidURL.isEmpty() && !clientID.isEmpty();
            }
            bl = false;
            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;
            try {
                boolean bl2 = System.getProperty("fmDebugForceFMID") != null;
                String string = Service.getMasterAddr();
                if (string == null || string.length() == 0) {
                    string = "127.0.0.1";
                }
                if (!bl2) {
                    String string2;
                    int n = OAuthRequestHandler.getMasterHttpsPort(httpServletRequest);
                    String string3 = String.format("https://%s:%d/fmws/oauthproviderinfo", string, n);
                    httpURLConnection = (HttpsURLConnection)IWPUtilities.getXHR(string3, "GET", true);
                    if (httpURLConnection == null) break block18;
                    httpURLConnection.setRequestProperty("x-fms-application-version", FMID_APP_VER);
                    int n2 = httpURLConnection.getResponseCode();
                    if (n2 != 200) break block18;
                    fmidURL = "";
                    clientID = "";
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((string2 = bufferedReader.readLine()) != null) {
                        stringBuffer.append(string2);
                    }
                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = (JsonObject)jsonParser.parse(stringBuffer.toString());
                    JsonElement jsonElement = jsonObject.get(JSON_DATA);
                    if (jsonElement == null || jsonElement.isJsonNull()) break block18;
                    JsonObject jsonObject2 = jsonObject.getAsJsonObject(JSON_DATA);
                    JsonArray jsonArray = jsonObject2.getAsJsonArray("Provider");
                    for (int i = 0; i < jsonArray.size(); ++i) {
                        JsonObject jsonObject3 = jsonArray.get(i).getAsJsonObject();
                        String string4 = jsonObject3.get("ProviderID").getAsString();
                        if (string4 == null || !string4.equalsIgnoreCase("5")) continue;
                        fmidURL = jsonObject3.get("AuthCodeEndpoint").getAsString();
                        clientID = jsonObject3.get("ClientID").getAsString();
                        bl = true;
                        break block18;
                    }
                    break block18;
                }
                fmidURL = "fmid.test.filemaker-cloud.com";
                clientID = "ac160ef9a6fcbbd1049da25b941f33f067e14b3e";
                string = "fc-cjnmb3-20180831-071832.org.test.filemaker-cloud.com";
                bl = true;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    }
                    catch (IOException iOException) {}
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        return bl;
    }

    private boolean handleFMIDLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (httpServletRequest.getParameter(PARAM_FMID) != null && httpServletRequest.getParameter(PARAM_FMID).equalsIgnoreCase("1")) {
            return false;
        }
        return this.doFMIDLogin(httpServletRequest, httpServletResponse);
    }

    private boolean doFMIDLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean bl = false;
        String string = IWPUtilities.getCaseInsensitiveURI(httpServletRequest.getRequestURI());
        String string2 = IWPUtilities.getDatabaseNameFromPath(string);
        if (string.contains("/fmi/webd") && !string.endsWith("/fmi/webd") && !string.endsWith("/fmi/webd/") && Utilities.isValidText(string2) && FMRequestManager.getFMIDInfo(httpServletRequest) && !fmidURL.isEmpty() && !clientID.isEmpty()) {
            try {
                String string3;
                String string4 = FMRequestManager.getAllowCredentials(string2) ? "0" : "1";
                String string5 = FMRequestManager.loadDocument(this.contextPath, FMID_REDIRECT_TEMPLATE, true).toString().replace("param_db", string2).replace("param_fmid", fmidURL).replace("param_relogin", string4).replace("param_cid", clientID);
                String string6 = httpServletRequest.getParameter(PARAM_LAYOUT_ID);
                if (!Utilities.isEmptyString(string6)) {
                    string5 = string5.replace("param_layid", Utilities.htmlSpecialChar(string6));
                }
                if (Utilities.isValidText(string3 = httpServletRequest.getQueryString())) {
                    string3 = string3.replace("&param", "&amp;param");
                }
                string5 = string5.replace("param_query", Utilities.isValidText(string3) ? string3 : "");
                FMRequestManager.sendHtml(httpServletResponse, string5);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return bl;
    }

    public static void redirectToFMID(HttpServletResponse httpServletResponse) throws IOException {
        try {
            Object object = fmidURL.startsWith("https://") ? fmidURL : "https://" + fmidURL;
            httpServletResponse.sendRedirect((String)object);
        }
        catch (IOException iOException) {
            httpServletResponse.sendError(503);
            iOException.printStackTrace();
        }
    }

    private boolean handleFMIDError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int n) throws IOException {
        boolean bl = false;
        if (n == ErrorCode.UserIsUnlicensed.getErrorCode()) {
            bl = true;
        }
        if (bl) {
            IWPError iWPError = new IWPError();
            iWPError.setErrorCode(n);
            this.locale = httpServletRequest.getLocale();
            String string = FMRequestManager.loadDocument(this.contextPath, FMID_ERROR_TEMPLATE, true).toString().replace("param_fmid", fmidURL).replace("param_msg", this.getErrorMsg(iWPError));
            FMRequestManager.sendHtml(httpServletResponse, string);
            return true;
        }
        return false;
    }

    public static boolean isTrustOrigin(String string) {
        if (trustDomains.size() == 0) {
            return true;
        }
        if (string == null || string.length() == 0) {
            return true;
        }
        return trustDomains.contains(string.toLowerCase().replaceAll("http://", "").replaceAll("https://", ""));
    }

    private static boolean getAllowCredentials(String string) {
        return true;
    }
}

