/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Page
 *  com.vaadin.server.VaadinRequest
 *  com.vaadin.server.VaadinService
 *  com.vaadin.server.VaadinServletRequest
 *  com.vaadin.server.WebBrowser
 *  jakarta.servlet.http.HttpServletRequest
 */
package com.filemaker.jwpc.iwp.notification.processor;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.BrowserClientInfo;
import com.filemaker.jwpc.iwp.thrift.common.BrowserType;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.notification.BrowserClientInfoRequestNotification;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.WebBrowser;
import jakarta.servlet.http.HttpServletRequest;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;

public class BrowserInfoHandler {
    private static final int TOTAL_SUPPORTED_LANGUAGES = 10;
    private static HashMap<String, String> languageToCountryMap = new HashMap(10);
    private static short DEV_OTHER;
    private static short DEV_MACOSX;
    private static short DEV_WINDOWS;
    private static short DEV_IPAD;
    private static short DEV_IPHONE_IPOD;
    private static short DEV_ANDROID;
    private static short DEV_LINUX;
    private final App app;
    private final BrowserClientInfo clientInfo = new BrowserClientInfo();
    private Locale supportedBrowserLocale = Locale.ENGLISH;

    public BrowserInfoHandler(App app, Locale locale) {
        this.app = app;
        if (locale != null) {
            this.setBrowserClientInfo(app, Page.getCurrent().getWebBrowser(), VaadinService.getCurrentRequest(), locale);
        } else {
            this.setBrowserClientInfo(app, Page.getCurrent().getWebBrowser(), VaadinService.getCurrentRequest(), Page.getCurrent().getWebBrowser().getLocale());
        }
    }

    public BrowserInfoHandler(HttpServletRequest httpServletRequest) {
        this.app = null;
        VaadinServletRequest vaadinServletRequest = new VaadinServletRequest(httpServletRequest, null);
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.updateRequestDetails((VaadinRequest)vaadinServletRequest);
        this.setBrowserClientInfo(this.app, webBrowser, (VaadinRequest)vaadinServletRequest, webBrowser.getLocale());
    }

    private void setBrowserClientInfo(App app, WebBrowser webBrowser, VaadinRequest vaadinRequest, Locale locale) {
        this.clientInfo.setHostIP(Utilities.getHostIpAddress());
        this.clientInfo.setClientIP(this.getClientIpAddress(vaadinRequest.getRemoteAddr(), vaadinRequest.getHeader("X-Forwarded-For")));
        String string = vaadinRequest.getHeader("Origin");
        String string2 = vaadinRequest.getHeader("Referer");
        boolean bl = webBrowser.isSecureConnection() || !Utilities.isEmptyString(string) && string.startsWith("https") || !Utilities.isEmptyString(string2) && string2.startsWith("https");
        this.clientInfo.setSecureConnection(bl);
        this.clientInfo.setUserAgent(vaadinRequest.getHeader("User-Agent"));
        this.supportedBrowserLocale = this.getBrowserLocale(locale);
        this.clientInfo.setBrowserCountry(this.supportedBrowserLocale.getCountry());
        this.clientInfo.setBrowserLanguage(this.supportedBrowserLocale.getLanguage());
        this.clientInfo.setBrowserType(BrowserInfoHandler.getClientType(webBrowser));
        this.clientInfo.setClientSystemVersion(BrowserInfoHandler.getClientSystemVersion(webBrowser));
        this.clientInfo.setClientDevice(BrowserInfoHandler.getClientDevice(webBrowser));
        this.clientInfo.setScreenHeight(webBrowser.getScreenHeight());
        this.clientInfo.setScreenWidth(webBrowser.getScreenWidth());
        if (app != null) {
            if (IWPUtilities.isDebugMode()) {
                this.clientInfo.setServerIP(this.getServerIpAddress(app, vaadinRequest));
            } else if (bl) {
                this.clientInfo.setServerIP("https://" + vaadinRequest.getHeader("X-Forwarded-Host"));
            } else {
                this.clientInfo.setServerIP("http://" + vaadinRequest.getHeader("X-Forwarded-Host"));
            }
            this.clientInfo.setPersistentID(App.getCurrent().getPersistentID());
            this.clientInfo.setBrowserDimensions(new Dimensions(app.getPage().getBrowserWindowHeight(), app.getPage().getBrowserWindowWidth()));
            this.clientInfo.setStatusAreaHeight(44);
        }
        this.clientInfo.setHighContrastColor("");
        this.clientInfo.setHighContrastState(false);
        this.clientInfo.setScreenDepth(32);
    }

    public void setPersistentID(String string) {
        this.clientInfo.setPersistentID(string);
    }

    public BrowserClientInfo getBrowserClientInfo() {
        return this.clientInfo;
    }

    public Locale getSupportedBrowserLocale() {
        return this.supportedBrowserLocale;
    }

    private String getClientIpAddress(String string, String string2) {
        String string3 = null;
        string3 = string2 != null && string2.trim().length() > 0 ? string2 : string;
        if (Utilities.isEmptyString(string3)) {
            string3 = "127.0.0.1";
        } else {
            try {
                InetAddress inetAddress = InetAddress.getByName(string3);
                if (inetAddress.isLoopbackAddress()) {
                    string3 = "127.0.0.1";
                } else {
                    string3 = inetAddress.getHostAddress();
                    if (inetAddress instanceof Inet6Address) {
                        int n = string3.indexOf(37);
                        if (n > 0) {
                            string3 = string3.substring(0, n);
                        }
                        string3 = "[" + string3 + "]";
                    }
                }
            }
            catch (UnknownHostException unknownHostException) {
                // empty catch block
            }
        }
        return string3;
    }

    private String getRequestIpAddress(VaadinRequest vaadinRequest) {
        String string = null;
        if (vaadinRequest instanceof VaadinServletRequest) {
            VaadinServletRequest vaadinServletRequest = (VaadinServletRequest)vaadinRequest;
            HttpServletRequest httpServletRequest = vaadinServletRequest.getHttpServletRequest();
            StringBuffer stringBuffer = httpServletRequest.getRequestURL();
            int n = stringBuffer.indexOf("://");
            String string2 = stringBuffer.substring(n + 3);
            if ((n = string2.indexOf(":")) == -1) {
                n = string2.indexOf("/");
            }
            if (!(string2 = string2.substring(0, n)).equals("127.0.0.1") && !string2.equals("localhost")) {
                string = string2;
            }
        }
        return string;
    }

    private String getServerIpAddress(App app, VaadinRequest vaadinRequest) {
        int n;
        String string = app.getPage().getLocation().toString().toLowerCase();
        if (!Utilities.isEmptyString(string)) {
            n = string.indexOf("://");
            if (n > -1) {
                string = string.substring(n + 3);
            }
            if ((n = string.indexOf("/")) > -1) {
                string = string.substring(0, n);
            }
        } else {
            string = vaadinRequest.getHeader("Origin");
            if (!Utilities.isEmptyString(string) && (n = string.indexOf("://")) > -1) {
                string = string.substring(n + 3);
            }
        }
        if (Utilities.isEmptyString(string)) {
            string = vaadinRequest.getHeader("host");
        }
        if (Utilities.isEmptyString(string)) {
            string = this.getRequestIpAddress(vaadinRequest);
        }
        if (Utilities.isEmptyString(string)) {
            string = Utilities.getHostIpAddress();
        }
        if ((n = string.indexOf(":")) > -1) {
            string = string.substring(0, n);
        }
        return string;
    }

    private Locale getBrowserLocale(Locale locale) {
        Locale locale2 = Locale.US;
        String string = locale.getLanguage();
        String string2 = languageToCountryMap.get(string);
        if (string2 != null) {
            locale2 = new Locale(string, string2);
        } else {
            string = AppServlet.getLanguage();
            string = string == null ? "en" : (string.equals("por") ? "pt" : (string.equals("deu") ? "de" : (string.equals("fre") ? "fr" : (string.equals("ita") ? "it" : (string.equals("nld") ? "nl" : (string.equals("spa") ? "es" : (string.equals("swe") ? "sv" : (string.equals("zho") ? "zh" : (string.equals("kor") ? "ko" : (string.equals("jpn") ? "ja" : "en"))))))))));
            string2 = languageToCountryMap.get(string);
            locale2 = new Locale(string, string2);
        }
        return locale2;
    }

    public boolean isWebKit() {
        boolean bl = false;
        switch (this.clientInfo.getBrowserType()) {
            case kChromeClient: 
            case kSafariClient: {
                bl = true;
                break;
            }
        }
        return bl;
    }

    public boolean isIE() {
        return this.clientInfo.getBrowserType() == BrowserType.kIEClient;
    }

    public boolean isEdge() {
        return this.clientInfo.getBrowserType() == BrowserType.kEdgeClient;
    }

    public boolean isSafari() {
        return this.clientInfo.getBrowserType() == BrowserType.kSafariClient;
    }

    public boolean isChrome() {
        return this.clientInfo.getBrowserType() == BrowserType.kChromeClient;
    }

    public static boolean isTouchDevice(App app) {
        boolean bl = false;
        bl = BrowserInfoHandler.isWin(app) || BrowserInfoHandler.isMacOSClient(app) || BrowserInfoHandler.isLinux(app) ? false : app.getPage().getWebBrowser().isTouchDevice();
        return bl;
    }

    public static boolean isMacOSClient(App app) {
        return app.getPage().getWebBrowser().isMacOSX();
    }

    public static boolean isWin(App app) {
        return app.getPage().getWebBrowser().isWindows();
    }

    public static boolean isLinux(App app) {
        return app.getPage().getWebBrowser().isLinux();
    }

    public static boolean isMobile(App app) {
        DeviceType deviceType = BrowserInfoHandler.getClientDeviceType(app.getWebBrowser());
        return deviceType == DeviceType.IPAD || deviceType == DeviceType.IPHONE || deviceType == DeviceType.IPOD || deviceType == DeviceType.ANDROID;
    }

    public static boolean isPhone(App app) {
        String string = app.getWebBrowser().getBrowserApplication();
        return string.contains("iPhone") || string.contains("iPod") || string.contains("Android") && string.contains("Mobile");
    }

    private static BrowserType getClientType(WebBrowser webBrowser) {
        BrowserType browserType = BrowserType.kOtherClient;
        if (webBrowser.isChrome()) {
            browserType = BrowserType.kChromeClient;
        } else if (webBrowser.isSafari()) {
            browserType = BrowserType.kSafariClient;
        } else if (webBrowser.isIE()) {
            browserType = BrowserType.kIEClient;
        } else if (webBrowser.isEdge()) {
            browserType = BrowserType.kEdgeClient;
        }
        return browserType;
    }

    public static boolean isiOSDevice(App app) {
        DeviceType deviceType = BrowserInfoHandler.getClientDeviceType(app.getWebBrowser());
        return deviceType == DeviceType.IPAD || deviceType == DeviceType.IPHONE || deviceType == DeviceType.IPOD;
    }

    public static boolean isAndroidDevice(App app) {
        DeviceType deviceType = BrowserInfoHandler.getClientDeviceType(app.getWebBrowser());
        return deviceType == DeviceType.ANDROID;
    }

    private static DeviceType getClientDeviceType(WebBrowser webBrowser) {
        if (webBrowser.isWindows()) {
            return DeviceType.WINDOWS;
        }
        if (webBrowser.isMacOSX()) {
            return DeviceType.MACOSX;
        }
        if (webBrowser.isLinux()) {
            return DeviceType.LINUX;
        }
        if (webBrowser.isTouchDevice() || webBrowser.isIOS() || webBrowser.isAndroid()) {
            String string = webBrowser.getBrowserApplication();
            if (string.contains("iPad")) {
                return DeviceType.IPAD;
            }
            if (string.contains("iPhone")) {
                return DeviceType.IPHONE;
            }
            if (string.contains("iPod")) {
                return DeviceType.IPOD;
            }
            if (string.contains("Android")) {
                return DeviceType.ANDROID;
            }
        }
        return DeviceType.OTHER;
    }

    private static String getClientSystemVersion(WebBrowser webBrowser) {
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        DeviceType deviceType = BrowserInfoHandler.getClientDeviceType(webBrowser);
        switch (deviceType.ordinal()) {
            case 3: {
                stringBuilder.append("iPad");
                break;
            }
            case 4: {
                stringBuilder.append("iPhone");
                break;
            }
            case 5: {
                stringBuilder.append("iPod");
                break;
            }
            case 0: {
                stringBuilder.append("Win");
                break;
            }
            case 1: {
                stringBuilder.append("Mac");
                break;
            }
            case 2: {
                stringBuilder.append("Linux");
                break;
            }
            case 6: {
                stringBuilder.append("Android");
                break;
            }
            default: {
                stringBuilder.append("Other");
            }
        }
        stringBuilder.append(" ");
        if (webBrowser.isEdge() || webBrowser.isChrome() && webBrowser.getBrowserApplication().contains("Edg") || webBrowser.isSafari() && webBrowser.getBrowserApplication().contains("Edg")) {
            stringBuilder.append("Edge");
        } else if (webBrowser.isChrome()) {
            stringBuilder.append("Chrome");
        } else if (webBrowser.isSafari()) {
            stringBuilder.append("Safari");
        } else if (webBrowser.isIE()) {
            stringBuilder.append("IE");
        } else if (webBrowser.isIOS() && !webBrowser.getBrowserApplication().contains("iOS")) {
            stringBuilder.append("Safari");
            bl = false;
        } else {
            stringBuilder.append("Other");
        }
        if (bl) {
            stringBuilder.append(" ");
            int n = webBrowser.getBrowserMajorVersion();
            if (n >= 0) {
                stringBuilder.append(n);
                int n2 = webBrowser.getBrowserMinorVersion();
                if (n2 >= 0) {
                    stringBuilder.append(".");
                    stringBuilder.append(n2);
                }
            } else {
                stringBuilder.append("-1");
            }
        }
        return stringBuilder.toString();
    }

    private static short getClientDevice(WebBrowser webBrowser) {
        short s = DEV_OTHER;
        DeviceType deviceType = BrowserInfoHandler.getClientDeviceType(webBrowser);
        switch (deviceType.ordinal()) {
            case 1: {
                s = DEV_MACOSX;
                break;
            }
            case 0: {
                s = DEV_WINDOWS;
                break;
            }
            case 3: {
                s = DEV_IPAD;
                break;
            }
            case 4: 
            case 5: {
                s = DEV_IPHONE_IPOD;
                break;
            }
            case 6: {
                s = DEV_ANDROID;
                break;
            }
            case 2: {
                s = DEV_LINUX;
                break;
            }
        }
        return s;
    }

    public int getContentWidth() {
        return this.app.getPage().getBrowserWindowWidth();
    }

    public int getContentHeight() {
        return this.app.getPage().getBrowserWindowHeight() - 44;
    }

    public String getDynamicBrowserClientInfo(BrowserClientInfoRequestNotification browserClientInfoRequestNotification) {
        String string = null;
        if (this.app != null) {
            switch (browserClientInfoRequestNotification.getParameter()) {
                case QUICK_FIND_TEXT: {
                    QuickFind quickFind2 = this.app.getQuickFind();
                    if (quickFind2 == null) break;
                    string = quickFind2.getQuickFindSeachString();
                    break;
                }
                case CURRENT_TIMESTAMP_STD: {
                    string = IWPUtilities.getStandardizedClientTimestamp(this.app);
                    break;
                }
            }
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    static {
        languageToCountryMap.put("en", "US");
        languageToCountryMap.put("de", "DE");
        languageToCountryMap.put("fr", "FR");
        languageToCountryMap.put("it", "IT");
        languageToCountryMap.put("nl", "NL");
        languageToCountryMap.put("ja", "JP");
        languageToCountryMap.put("sv", "SE");
        languageToCountryMap.put("es", "ES");
        languageToCountryMap.put("ko", "KR");
        languageToCountryMap.put("zh", "CN");
        languageToCountryMap.put("pt", "PT");
        DEV_OTHER = 0;
        DEV_MACOSX = 1;
        DEV_WINDOWS = (short)2;
        DEV_IPAD = (short)3;
        DEV_IPHONE_IPOD = (short)4;
        DEV_ANDROID = (short)5;
        DEV_LINUX = (short)6;
    }

    private static enum DeviceType {
        WINDOWS,
        MACOSX,
        LINUX,
        IPAD,
        IPHONE,
        IPOD,
        ANDROID,
        OTHER;

    }
}

