/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gwt.thirdparty.json.JSONException
 *  com.google.gwt.thirdparty.json.JSONObject
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 */
package com.filemaker.jwpc.jsoniwp;

import com.filemaker.jwpc.CGIBase;
import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.exceptions.AuthenticationException;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.request.XMLRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gwt.thirdparty.json.JSONException;
import com.google.gwt.thirdparty.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class JSONIWPCGIBase
extends CGIBase {
    private static final String JSON_RESULT = "result";
    private static final String JSON_DATA = "data";

    @Override
    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (httpServletRequest.getRequestURL().toString().contains("fmi/webd/dbnames") && this.isIWPEnabled()) {
            if (FMRequestManager.getFMIDInfo(httpServletRequest)) {
                FMRequestManager.redirectToFMID(httpServletResponse);
                return;
            }
            boolean bl = httpServletRequest.getParameter("customfilterlogin") != null ? httpServletRequest.getParameter("customfilterlogin").equals("1") : false;
            boolean bl2 = httpServletRequest.getParameter("homelogin") != null ? httpServletRequest.getParameter("homelogin").equals("1") : false;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            ConfigXMLRequest configXMLRequest = new ConfigXMLRequest();
            configXMLRequest.setPrivilegeExtension(this.getExtendedPrivilege());
            this.storeAuthenticationInformation(httpServletRequest, configXMLRequest);
            configXMLRequest.setCmdCode(CmdCode.DBNAMES);
            try {
                httpServletResponse.setContentType(this.getMIMEType());
                WPCResult wPCResult = XMLRequest.performRequest(configXMLRequest);
                String string = httpServletRequest.getHeader("Referer");
                if (Utilities.isValidText(string) && string.indexOf("loginerr=") > -1) {
                    string = string.substring(0, string.lastIndexOf("?"));
                }
                PrintWriter printWriter = httpServletResponse.getWriter();
                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                if (wPCResult.getErrorCode() == ErrorCode.AppleIdNotFoundErrorStrID.getErrorCode()) {
                    printWriter.write(gson.toJson((Object)wPCResult.getErrorCode()));
                } else if (wPCResult.getErrorCode() == ErrorCode.AppleIdPasscodeNotFoundErrorStrID.getErrorCode() || wPCResult.getErrorCode() == ErrorCode.AppleIdPasscodeExpireErrorStrID.getErrorCode() || wPCResult.getErrorCode() == ErrorCode.InvalidAppleIdTypeAccountErrorStrID.getErrorCode() || wPCResult.getErrorCode() == ErrorCode.AppleIdAccountDisabledErrorStrID.getErrorCode()) {
                    IWPError iWPError = new IWPError();
                    iWPError.setErrorCode(wPCResult.getErrorCode());
                    String string2 = "e_" + iWPError.getErrorCode() + "_0";
                    Locale locale = httpServletRequest.getLocale();
                    JSONObject jSONObject = new JSONObject();
                    String string3 = null;
                    String string4 = null;
                    string3 = String.valueOf(wPCResult.getErrorCode());
                    string4 = IWPI18N.get(locale, string2, new Object[0]);
                    try {
                        jSONObject.put(JSON_RESULT, (Object)string3);
                        if (string4 != null) {
                            jSONObject.put(JSON_DATA, (Object)string4);
                        }
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                    printWriter.write(jSONObject.toString());
                } else {
                    List<String> list = wPCResult.getDBNames();
                    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
                    for (String string5 : list) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("/fmi/webd");
                        stringBuilder.append("/");
                        stringBuilder.append(URLEncoder.encode(string5, "UTF-8").replace("+", "%20"));
                        if (Utilities.isValidText(string)) {
                            stringBuilder.append("?");
                            stringBuilder.append("homeurl");
                            stringBuilder.append("=");
                            stringBuilder.append(Utilities.encodeURI(string));
                            if (bl2) {
                                stringBuilder.append("&");
                                stringBuilder.append("homelogin");
                                stringBuilder.append("=1");
                            }
                        }
                        linkedHashMap.put(string5, stringBuilder.toString());
                    }
                    printWriter.write(gson.toJson(linkedHashMap));
                }
                printWriter.close();
            }
            catch (AuthenticationException authenticationException) {
                if (!bl) {
                    String string = "Basic realm=\"FileMaker\"";
                    httpServletResponse.setHeader("WWW-Authenticate", string);
                }
                httpServletResponse.sendError(401, "");
            }
        } else {
            httpServletResponse.sendError(501, "Service may not be enabled.");
        }
    }

    @Override
    public String getExtendedPrivilege() {
        return "fmwebdirect";
    }

    @Override
    public String getMIMEType() {
        return "application/json";
    }
}

