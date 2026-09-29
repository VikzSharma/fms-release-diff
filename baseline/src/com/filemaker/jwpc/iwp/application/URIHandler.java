/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.VaadinRequest
 *  com.vaadin.server.VaadinServletRequest
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.ScriptInfo;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import java.util.HashMap;
import java.util.Map;

public class URIHandler {
    private final App app;
    private String uriPath = "";
    private ScriptInfo scriptInfo;

    public URIHandler(App app) {
        this.app = app;
        this.init();
    }

    private void init() {
        this.uriPath = IWPUtilities.getCaseInsensitiveURI(this.app.getPage().getLocation().getPath());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean handleURI(VaadinRequest vaadinRequest) {
        if (vaadinRequest == null) {
            return false;
        }
        boolean bl = vaadinRequest.getParameter("guest") != null ? vaadinRequest.getParameter("guest").equals("1") : false;
        boolean bl2 = vaadinRequest.getParameter("oauth") != null ? vaadinRequest.getParameter("oauth").equals("1") : false;
        boolean bl3 = vaadinRequest.getParameter("fmid") != null ? vaadinRequest.getParameter("fmid").equals("1") : false;
        boolean bl4 = !bl && vaadinRequest.getParameter("force") != null ? vaadinRequest.getParameter("force").equals("1") : false;
        int n = -1;
        if (vaadinRequest.getParameter("layoutID") != null) {
            try {
                n = Integer.parseInt(vaadinRequest.getParameter("layoutID"));
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        if (!this.app.hasValidSession()) {
            URIHandler uRIHandler = this;
            synchronized (uRIHandler) {
                Map map;
                Credentials credentials;
                String string = IWPUtilities.getDatabaseNameFromPath(this.uriPath);
                if (Utilities.isValidText(string)) {
                    credentials = this.app.getCredentials();
                    if (credentials == null) {
                        credentials = new Credentials("", "", "", "", bl, bl2, false, bl3, true, string, "fmwebdirect");
                    } else {
                        credentials.setDatabase(string);
                    }
                    map = null;
                    if (vaadinRequest != null) {
                        map = ((VaadinServletRequest)vaadinRequest).getParameterMap();
                    }
                } else {
                    return false;
                }
                this.processForScriptInfo(map);
                this.app.loginDatabase(credentials, bl4, true, n);
            }
        }
        return true;
    }

    public boolean hasUserSpecifiedDatabaseName() {
        return true;
    }

    public void performPostLogin(String string) {
        this.clearScriptInfo();
    }

    public void updateURI(String string, boolean bl) {
        this.updateUriPath(string, bl);
    }

    public boolean updateUriPath(String string, boolean bl) {
        boolean bl2 = false;
        String string2 = IWPUtilities.getDatabaseNameFromPath(this.uriPath);
        if (string != null && !string.equals(string2)) {
            this.uriPath = "/fmi/webd/" + string;
            if (bl) {
                String string3 = IWPUtilities.getCaseInsensitiveURI(this.app.getPage().getLocation().toString());
                int n = string3.indexOf("/fmi/webd/");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3.substring(0, n + "/fmi/webd/".length())).append(string);
                this.app.getPage().setLocation(stringBuilder.toString());
            }
            bl2 = true;
        }
        return bl2;
    }

    public boolean updateUriFragment(String string, boolean bl) {
        return false;
    }

    public ScriptInfo getScriptInfo() {
        if (this.scriptInfo == null) {
            this.scriptInfo = new ScriptInfo();
        }
        return this.scriptInfo;
    }

    private HashMap<String, String[]> getFragmentParamMap(String string) {
        String[] stringArray = string.split("&");
        HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
        for (String string2 : stringArray) {
            String[] stringArray2 = string2.split("\\=");
            if (stringArray2.length != 2 || hashMap.containsKey(stringArray2[0].toLowerCase())) continue;
            String[] stringArray3 = new String[]{stringArray2[1]};
            hashMap.put(stringArray2[0].toLowerCase(), stringArray3);
        }
        return hashMap;
    }

    private void processForScriptInfo(Map<String, String[]> map) {
        String string = this.getParamValue(map, "script");
        if (Utilities.isValidText(string)) {
            ScriptInfo scriptInfo = this.getScriptInfo();
            scriptInfo.setScriptName(string);
            String string2 = this.getParamValue(map, "param");
            if (Utilities.isValidText(string2)) {
                scriptInfo.setParamValue(string2);
            }
            HashMap<String, String> hashMap = new HashMap<String, String>(0);
            for (String string3 : map.keySet()) {
                if (!string3.startsWith("$") || string3.length() < 2 || string3.charAt(1) == '$' || hashMap.containsKey(string3)) continue;
                hashMap.put(string3, this.getParamValue(map, string3));
            }
            if (!hashMap.isEmpty()) {
                scriptInfo.setVariableNVPairs(hashMap);
            }
        }
    }

    private String getParamValue(Map<String, String[]> map, String string) {
        String string2 = "";
        String[] stringArray = map.get(string);
        if (stringArray != null) {
            string2 = stringArray[0];
        }
        return string2;
    }

    private void clearScriptInfo() {
        if (this.scriptInfo != null) {
            this.scriptInfo.setScriptName("");
            this.scriptInfo.setParamValue("");
            Map<String, String> map = this.scriptInfo.getVariableNVPairs();
            if (map != null && !map.isEmpty()) {
                map.clear();
            }
        }
    }
}

