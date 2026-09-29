/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fmi.net.Base64
 *  com.vaadin.ui.Button
 *  jakarta.servlet.http.HttpServletRequest
 *  org.apache.commons.text.StringEscapeUtils
 *  org.apache.commons.validator.routines.DomainValidator
 *  org.apache.commons.validator.routines.InetAddressValidator
 */
package com.filemaker.jwpc.util;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.fmi.net.Base64;
import com.vaadin.ui.Button;
import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.InetAddressValidator;

public class Utilities {
    private static String sOS = System.getProperty("os.name");
    private static String MAC_OS_X = "Mac OS X";
    private static final String WINDOWS = "Windows";
    private static final String WINDOWS_SERVER_2012 = "Windows Server 2012";
    private static final String WINDOWS_8 = "Windows 8";
    private static final String WINDOWS_SERVER_2008 = "Windows Server 2008";
    private static final String WINDOWS_7 = "Windows 7";
    private static Pattern linebreakPattern = Pattern.compile("(\r\n)|(\r)|(\n)");

    public static int getNumValue(String string) {
        int n = 0;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            n = -1;
        }
        return n;
    }

    public static long getLongValue(String string) {
        long l = 0L;
        try {
            l = Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            l = -1L;
        }
        return l;
    }

    public static boolean isValidText(String string) {
        return !Utilities.isEmptyString(string);
    }

    public static String ConvertDateTime(String string, String string2, String string3) {
        String string4 = string;
        if (Utilities.isValidText(string) && Utilities.isValidText(string2) && Utilities.isValidText(string3)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(string3);
            try {
                Date date = simpleDateFormat.parse(string);
                string4 = simpleDateFormat2.format(date);
            }
            catch (ParseException parseException) {
                // empty catch block
            }
        }
        return string4;
    }

    public static boolean isFilePathData(String string) {
        String string2 = string.toLowerCase();
        return string2.startsWith("/") || string2.startsWith("http://") || string2.startsWith("https://");
    }

    public static boolean isEmptyString(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static String[] getUserNameAndPassword(HttpServletRequest httpServletRequest) {
        String[] stringArray = null;
        String string = httpServletRequest.getHeader("Authorization");
        if (string != null) {
            try {
                String string2 = new String(Base64.decode((String)string.substring(6)));
                stringArray = string2.split(":");
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                arrayIndexOutOfBoundsException.printStackTrace();
            }
        }
        return stringArray;
    }

    public static String getExtendedPrivilege(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("X-FMI-PE-ExtendedPrivilege");
    }

    public static String getModuleType(HttpServletRequest httpServletRequest) {
        String[] stringArray;
        String string = httpServletRequest.getRequestURI();
        if (string != null && string.length() > 0 && (stringArray = string.split("/")) != null && stringArray.length >= 3 && stringArray[2] != null) {
            String string2 = stringArray[2].toUpperCase();
            ModuleType moduleType = ModuleType.getType(string2);
            if (moduleType != null) {
                return string2;
            }
            if ("VAADIN".equalsIgnoreCase(string2)) {
                return ModuleType.IWP.value;
            }
        }
        return "";
    }

    public static final String getLineBreak() {
        return System.getProperty("line.separator");
    }

    public static String stripInvalidXMLChars(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c < ' ' && c != '\t' && c != '\n' && c != '\r') continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static String getRequestInfoToLog(ConfigXMLRequest configXMLRequest) {
        String string = Utilities.getLineBreak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(configXMLRequest.getRequestParam().getClass().getName()).append('[').append(string);
        stringBuilder.append(" command code=").append(configXMLRequest.getCmdCode()).append(string);
        stringBuilder.append(" database name=").append(configXMLRequest.getDatabaseName()).append(string);
        stringBuilder.append(" layout name=").append(configXMLRequest.getLayoutName()).append(string);
        stringBuilder.append(" record id=").append(configXMLRequest.getRecordId()).append(string);
        stringBuilder.append(" key name=").append(configXMLRequest.getKeyName()).append(string);
        stringBuilder.append(" mod id=").append(configXMLRequest.getModId()).append(string);
        stringBuilder.append(" item to skip=").append(configXMLRequest.getItemsToSkip()).append(string);
        stringBuilder.append(" max return=").append(configXMLRequest.getMaxItems()).append(string);
        stringBuilder.append(" options=").append(configXMLRequest.getOptions()).append(string);
        stringBuilder.append(" prescript name").append('=').append(configXMLRequest.getPreScriptParam()).append(string);
        stringBuilder.append(" presortscript name").append('=').append(configXMLRequest.getPreSortScriptParam()).append(string);
        stringBuilder.append(" script name").append('=').append(configXMLRequest.getScriptParam()).append(string);
        stringBuilder.append(" response layout name=").append(configXMLRequest.getResponseLayoutName()).append(string);
        stringBuilder.append(" portal filter type=").append(configXMLRequest.getPortalFilterType()).append(string);
        stringBuilder.append(" portal max=").append(configXMLRequest.getPortalMax()).append(string);
        stringBuilder.append(" repetiton=").append(configXMLRequest.getRepetition()).append(string);
        stringBuilder.append(']');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static boolean isValidRecordID(String string) {
        return !Utilities.isEmptyString(string);
    }

    public static void makeDefaultButton(Button button) {
        button.focus();
        button.setClickShortcut(13, new int[0]);
        button.addStyleName("primary");
    }

    public static String encodeURI(String string) {
        try {
            string = URLEncoder.encode(string, "UTF-8").replace("+", "%20");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string = null;
        }
        return string;
    }

    public static String htmlSpecialChar(String string) {
        string = string.replaceAll("&", "&amp;");
        string = string.replaceAll("\"", "&quot;");
        string = string.replaceAll("<", "&lt;");
        string = string.replaceAll(">", "&gt;");
        string = string.replaceAll("'", "&apos;");
        return string;
    }

    public static String getMailToString(String string, String string2, String string3, String string4, String string5, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("mailto:");
        string = Utilities.encodeURI(string);
        string2 = Utilities.encodeURI(string2);
        string3 = Utilities.encodeURI(string3);
        string4 = Utilities.encodeURI(string4);
        string5 = Utilities.encodeURI(string5);
        boolean bl2 = true;
        if (!Utilities.isEmptyString(string)) {
            stringBuilder.append(string);
        }
        stringBuilder.append("?");
        if (!Utilities.isEmptyString(string2)) {
            stringBuilder.append("cc=").append(string2);
            bl2 = false;
        }
        if (!Utilities.isEmptyString(string3)) {
            if (!bl2) {
                stringBuilder.append("&");
            } else {
                bl2 = false;
            }
            stringBuilder.append("bcc=").append(string3);
        }
        if (!Utilities.isEmptyString(string4)) {
            if (!bl2) {
                stringBuilder.append("&");
            } else {
                bl2 = false;
            }
            stringBuilder.append("subject=").append(string4);
        }
        if (!Utilities.isEmptyString(string5)) {
            if (!bl2) {
                stringBuilder.append("&");
            } else {
                bl2 = false;
            }
            stringBuilder.append("body=").append(string5);
        }
        String string6 = stringBuilder.toString();
        if (bl) {
            string6 = string6.replaceAll("#", "%23");
        }
        return string6;
    }

    public static String encodeHTML(String string) {
        return Utilities.isValidText(string) ? linebreakPattern.matcher(StringEscapeUtils.escapeHtml4((String)string)).replaceAll("<br/>") : "";
    }

    public static String decodeHTML(String string) {
        return Utilities.isValidText(string) ? StringEscapeUtils.unescapeHtml4((String)string.replaceAll("<br/>", "\n")) : "";
    }

    public static String getOSName() {
        return sOS;
    }

    public static boolean isMac() {
        return Utilities.getOSName().startsWith(MAC_OS_X);
    }

    public static boolean isUnix() {
        String string = Utilities.getOSName().toLowerCase();
        return string.indexOf("nix") >= 0 || string.indexOf("nux") >= 0 || string.indexOf("aix") > 0;
    }

    public static boolean isWindows() {
        return Utilities.getOSName().startsWith(WINDOWS);
    }

    public static boolean isWindowsServer2008() {
        return Utilities.getOSName().startsWith(WINDOWS_SERVER_2008);
    }

    public static boolean isWindowsServer2012() {
        return Utilities.getOSName().startsWith(WINDOWS_SERVER_2012);
    }

    public static boolean isIIS8() {
        return Utilities.getOSName().startsWith(WINDOWS_SERVER_2012) || Utilities.getOSName().startsWith(WINDOWS_8);
    }

    public static boolean isIIS7() {
        return Utilities.isWindowsServer2008() || Utilities.getOSName().startsWith(WINDOWS_7);
    }

    public static String getHostIpAddress() {
        String string = "127.0.0.1";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            string = inetAddress.getHostAddress();
        }
        catch (Exception exception) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) continue;
                    for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                        if (!(inetAddress instanceof Inet4Address) || inetAddress.isLoopbackAddress()) continue;
                        string = inetAddress.getHostAddress();
                    }
                }
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
                string = "127.0.0.1";
            }
        }
        return string;
    }

    public static String getRequestUrl(HttpServletRequest httpServletRequest) {
        Object object = httpServletRequest.getHeader("X-Forwarded-Host");
        if (Utilities.isEmptyString((String)object) && Utilities.isEmptyString((String)(object = httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()))) {
            object = Utilities.getHostIpAddress();
        }
        return object;
    }

    public static String removePortFromHost(String string) {
        int n;
        if (!Utilities.isEmptyString(string) && (n = string.indexOf(":")) != -1) {
            string = string.substring(0, n);
        }
        return string;
    }

    public static boolean isValidHostName(String string) {
        boolean bl = false;
        if (Utilities.isValidText(string)) {
            if (DomainValidator.getInstance((boolean)false).isValid(string)) {
                bl = true;
            } else if (InetAddressValidator.getInstance().isValid(string)) {
                bl = true;
            }
        }
        return bl;
    }

    public static int countLines(String string) {
        if (Utilities.isEmptyString(string)) {
            return 0;
        }
        Matcher matcher = linebreakPattern.matcher(string);
        int n = 1;
        while (matcher.find()) {
            ++n;
        }
        return n;
    }

    public static String normalizeHtmlText(String string) {
        return string.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static boolean isIPv6Address(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(string);
            return inetAddress instanceof Inet6Address && (string.contains(":") || string.contains("%"));
        }
        catch (UnknownHostException unknownHostException) {
            return false;
        }
    }

    private static enum ModuleType {
        XML("XML"),
        PHP("PHP"),
        IWP("IWP");

        private String value;
        private static HashMap<String, ModuleType> sTypeMap;

        private ModuleType(String string2) {
            this.value = string2;
        }

        static ModuleType getType(String string) {
            return sTypeMap.get(string);
        }

        static {
            sTypeMap = new HashMap();
            sTypeMap.put(ModuleType.XML.value, XML);
            sTypeMap.put(ModuleType.PHP.value, PHP);
            sTypeMap.put(ModuleType.IWP.value, IWP);
        }
    }
}

