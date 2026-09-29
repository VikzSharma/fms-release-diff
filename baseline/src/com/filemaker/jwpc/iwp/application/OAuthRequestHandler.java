/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;

public class OAuthRequestHandler {
    private static final String OAUTH_API_PROVIDER_INFO = "/oauthapi/oauthproviderinfo";
    private static final String OAUTH_API_AUTH_URL = "/oauthapi/getoauthurl";
    private static final String OAUTH_INIT_PATH = "oauth-init.html";
    private static final String OAUTH_INIT_TEMPLATE = "VAADIN/launchcenter/oauth-init.html";
    private static final String OAUTH_LANDING_PATH = "oauth-landing.html";
    private static final String OAUTH_LANDING_NO_CHILD_WINDOW_PATH = "oauth-landing-nocw.html";

    public static boolean processRequest(String string, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String string2 = httpServletRequest.getRequestURI();
        String string3 = httpServletRequest.getQueryString();
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        if (string2.startsWith("/fmi/webd") && string2.endsWith(OAUTH_API_PROVIDER_INFO) && !Utilities.isValidText(string3)) {
            try {
                httpURLConnection = (HttpsURLConnection)IWPUtilities.getXHR("https://" + Service.getMasterAddr() + ":" + OAuthRequestHandler.getMasterHttpsPort(httpServletRequest) + "/fmws/oauthproviderinfo", "GET", true);
                if (httpURLConnection != null) {
                    String string4 = httpServletRequest.getHeader("X-FMS-Application-Type");
                    String string5 = httpServletRequest.getHeader("X-FMS-Application-Version");
                    httpURLConnection.setRequestProperty("X-FMS-Application-Type", string4 != null ? string4 : "8");
                    httpURLConnection.setRequestProperty("X-FMS-Application-Version", string5 != null ? string5 : "17");
                    int n = httpURLConnection.getResponseCode();
                    if (n == 200) {
                        String string6;
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((string6 = bufferedReader.readLine()) != null) {
                            stringBuffer.append(string6);
                        }
                        Locale locale = httpServletRequest.getLocale();
                        String string7 = OAuthRequestHandler.resortOAuthForAppleID(locale, stringBuffer);
                        if (string7 != null) {
                            httpServletResponse.setCharacterEncoding("UTF-8");
                            httpServletResponse.getWriter().write(string7);
                        } else {
                            httpServletResponse.getWriter().write(stringBuffer.toString());
                        }
                    } else {
                        httpServletResponse.getWriter().write("{}");
                    }
                }
                boolean bl = true;
                return bl;
            }
            catch (IOException iOException) {
                throw iOException;
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
        if (string2.startsWith("/fmi/webd") && string2.endsWith(OAUTH_API_AUTH_URL) && Utilities.isValidText(string3)) {
            try {
                httpURLConnection = (HttpsURLConnection)IWPUtilities.getXHR("https://" + Service.getMasterAddr() + ":" + OAuthRequestHandler.getMasterHttpsPort(httpServletRequest) + "/oauth/getoauthurl?" + string3, "GET", true);
                if (httpURLConnection != null) {
                    String string8 = httpServletRequest.getHeader("X-FMS-Application-Type");
                    String string9 = httpServletRequest.getHeader("X-FMS-Application-Version");
                    httpURLConnection.setRequestProperty("X-FMS-Application-Type", string8 != null ? string8 : "8");
                    httpURLConnection.setRequestProperty("X-FMS-Application-Version", string9 != null ? string9 : "17");
                    httpURLConnection.setRequestProperty("X-FMS-Return-URL", httpServletRequest.getHeader("X-FMS-Return-URL"));
                    int n = httpURLConnection.getResponseCode();
                    if (n == 200) {
                        String string10;
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((string10 = bufferedReader.readLine()) != null) {
                            stringBuffer.append(string10);
                        }
                        httpServletResponse.getWriter().write(stringBuffer.toString());
                        httpServletResponse.setHeader("X-FMS-Request-ID", httpURLConnection.getHeaderField("X-FMS-Request-ID"));
                    } else {
                        httpServletResponse.getWriter().write("{}");
                    }
                }
                boolean bl = true;
                return bl;
            }
            catch (IOException iOException) {
                throw iOException;
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
        if (string2.startsWith("/fmi/webd") && string2.endsWith(OAUTH_INIT_PATH) && Utilities.isValidText(string3)) {
            String string11 = FMRequestManager.loadDocument(string, OAUTH_INIT_TEMPLATE, true).toString();
            FMRequestManager.sendHtml(httpServletResponse, string11);
            return true;
        }
        if (string2.startsWith("/fmi/webd") && string2.endsWith(OAUTH_LANDING_PATH) && Utilities.isValidText(string3)) {
            String string12 = FMRequestManager.loadDocument(string, "VAADIN/launchcenter/oauth-landing.html", true).toString();
            FMRequestManager.sendHtml(httpServletResponse, string12);
            return true;
        }
        if (string2.startsWith("/fmi/webd") && string2.endsWith(OAUTH_LANDING_NO_CHILD_WINDOW_PATH) && Utilities.isValidText(string3)) {
            String string13 = FMRequestManager.loadDocument(string, "VAADIN/launchcenter/oauth-landing-nocw.html", true).toString();
            FMRequestManager.sendHtml(httpServletResponse, string13);
            return true;
        }
        return false;
    }

    private static String resortOAuthForAppleID(Locale locale, StringBuffer stringBuffer) {
        String string = null;
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(stringBuffer.toString());
        JsonElement jsonElement = jsonObject.get("data");
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            Object object;
            ArrayList<JsonObject> arrayList = new ArrayList<JsonObject>();
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("data");
            JsonArray jsonArray = jsonObject2.getAsJsonArray("Provider");
            int n = jsonArray.size();
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                object = jsonArray.get(i).getAsJsonObject();
                int n3 = object.get("ProviderID").getAsInt();
                switch (n3) {
                    case 9: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_APPLEID_BUTTON_STR", new Object[0]));
                        n2 = i;
                        break;
                    }
                    case 8: {
                        object.addProperty("ButtonName", jsonArray.get(i).getAsJsonObject().get("Name").getAsString());
                        break;
                    }
                    case 7: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_ADFS_BUTTON_STR", new Object[0]));
                        break;
                    }
                    case 6: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_APPLECONNECT_BUTTON_STR", new Object[0]));
                        break;
                    }
                    case 5: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_FMID_BUTTON_STR", new Object[0]));
                        break;
                    }
                    case 4: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_MICROSOFT_BUTTON_STR", new Object[0]));
                        break;
                    }
                    case 3: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_GOOGLE_BUTTON_STR", new Object[0]));
                        break;
                    }
                    case 2: {
                        object.addProperty("ButtonName", IWPI18N.get(locale, "OAUTH_PROVIDER_AMAZON_BUTTON_STR", new Object[0]));
                        break;
                    }
                }
                arrayList.add((JsonObject)object);
            }
            if (n2 > 0) {
                Collections.swap(arrayList, 0, n2);
            }
            if (n > 0) {
                String string2 = "{\"data\":{\"Provider\":";
                object = "},\"result\": 0";
                String string3 = Service.getMasterAddr();
                if (!(string3.isEmpty() || string3.equals("127.0.0.1") || string3.equals("localhost"))) {
                    object = (String)object + ", \"masterAddr\": \"" + string3 + "\"";
                }
                string = string2 + ((Object)arrayList).toString() + (String)object + "}";
            }
        }
        return string;
    }

    public static int getMasterHttpsPort(HttpServletRequest httpServletRequest) {
        int n = Service.getMasterHttpsPort();
        if (n <= 0) {
            String string = httpServletRequest.getHeader("X-Forwarded-Host");
            int n2 = string.indexOf(":");
            if (n2 != -1) {
                try {
                    n = Integer.parseInt(string.substring(n2 + 1));
                }
                catch (NumberFormatException numberFormatException) {
                    n = 443;
                }
            } else {
                n = 443;
            }
        }
        return n;
    }
}

