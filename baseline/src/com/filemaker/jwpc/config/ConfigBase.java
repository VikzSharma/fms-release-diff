/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.fmi.security.DecryptedInputStream
 *  com.fmi.security.EncryptedOutputStream
 *  jakarta.servlet.ServletConfig
 *  jakarta.servlet.ServletContext
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.ServletRequest
 *  jakarta.servlet.ServletResponse
 *  jakarta.servlet.http.HttpServlet
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  org.apache.xml.serialize.OutputFormat
 *  org.apache.xml.serialize.XMLSerializer
 */
package com.filemaker.jwpc.config;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.config.ConfigErrorCode;
import com.filemaker.jwpc.config.ConfigurationHandler;
import com.filemaker.jwpc.exceptions.LoggerException;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.log.LogData;
import com.filemaker.jwpc.log.LogMessages;
import com.filemaker.jwpc.log.LoggerManager;
import com.filemaker.jwpc.log.LoggerPreference;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.request.XMLRequest;
import com.fmi.security.DecryptedInputStream;
import com.fmi.security.EncryptedOutputStream;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ConfigBase
extends HttpServlet {
    private DocumentBuilder mDocBuilder;
    private Document mConfigDocument;
    private XPath mXPath;
    private XPathFactory mXPathFactory;
    private ConfigurationHandler mConfigHandler = null;
    private String mRootPath = null;
    private String mConfFilePath = null;
    private String mEnabled = null;
    private String mPHPEnabled = null;
    private String mIWPEnabled = null;
    private String mIWPLanguage = null;
    private String mServerId = null;
    private String mUserLogEnabled = null;
    private String mUserLogLevel = null;
    private String mUserLogSize = null;
    private String mDebugLogEnabled = null;
    private String mChunksize = null;
    private String mMWPERouting = null;
    private String mHomeUrlEnabled = null;
    private String mCustomHomeUrl = null;
    private String mAriaCompliantControlEnabled = null;
    private static final long serialVersionUID = 1L;
    private static JWPCLogger logger = JWPCLogger.getLogger(ConfigBase.class);

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ServletContext servletContext = servletConfig.getServletContext();
        this.mXPathFactory = XPathFactory.newInstance();
        this.mXPath = this.mXPathFactory.newXPath();
        this.setupPaths(servletContext.getRealPath("/"));
        this.mConfigHandler = ConfigurationHandler.getInstance(servletContext.getRealPath("/"));
        this.getDocumentBuilder();
        this.getConfiguration();
        this.updateLogger();
    }

    private void setupPaths(String string) {
        try {
            File file = new File(string);
            this.mRootPath = file.getCanonicalPath();
            File file2 = new File(this.mRootPath).getParentFile().getParentFile().getParentFile();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file2.getCanonicalPath());
            stringBuilder.append(File.separator).append("conf").append(File.separator).append("jwpc_prefs.xml");
            this.mConfFilePath = stringBuilder.toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void updateLogger() {
        try {
            LoggerManager.updateLogger(this.getLoggerPreference());
        }
        catch (LoggerException loggerException) {
            String string = "Logger update failed during server startup: " + loggerException.getMessage();
            System.err.println(string);
            logger.debug(string, loggerException);
        }
    }

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.processRequest(httpServletRequest, httpServletResponse);
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.processRequest(httpServletRequest, httpServletResponse);
    }

    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = httpServletRequest.getQueryString();
        if (string != null && string.toLowerCase().indexOf("-max_cwp_sessions") > -1) {
            this.getServletContext().getRequestDispatcher("/xml").include((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        }
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/xml");
        int n = this.handleCGIMessages(httpServletRequest.getParameterMap());
        int n2 = this.getCWPCStatus();
        Document document = this.getStatusDoc(n, ConfigErrorCode.getDescr(n), n2, ConfigErrorCode.getDescr(n2));
        if (document != null) {
            this.serializeXMLDocument(document, httpServletResponse.getWriter());
        }
        this.log(httpServletRequest.getParameterMap(), n);
    }

    protected int getCWPCStatus() {
        try {
            ConfigXMLRequest configXMLRequest = new ConfigXMLRequest(CmdCode.PING);
            WPCResult wPCResult = XMLRequest.performRequest(configXMLRequest);
            return wPCResult.getErrorCode();
        }
        catch (Exception exception) {
            return ErrorCode.InternalError.getErrorCode();
        }
    }

    public int handleCGIMessages(Map<String, String[]> map) {
        Object object;
        int n = 0;
        Iterator<String> iterator = map.keySet().iterator();
        boolean bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        while (iterator.hasNext()) {
            object = iterator.next();
            String string = map.get(object)[0];
            if (((String)object).equalsIgnoreCase("-xml_enabled")) {
                bl = this.setEnabled(string);
            } else if (((String)object).equalsIgnoreCase("-guid")) {
                bl = bl && this.setServerId(string);
            } else if (((String)object).equalsIgnoreCase("-userlog")) {
                bl2 = this.setLog(1, string);
                bl = bl && bl2;
            } else if (((String)object).equalsIgnoreCase("-userloglevel")) {
                bl2 = this.setLog(2, string);
                bl = bl && bl2;
            } else if (((String)object).equalsIgnoreCase("-userlogsize")) {
                bl2 = this.setLog(3, string);
                bl = bl && bl2;
            } else if (((String)object).equalsIgnoreCase("-debuglog")) {
                bl2 = this.setLog(4, string);
                bl3 = "off".equalsIgnoreCase(string);
                bl = bl && bl2;
            } else if (((String)object).equalsIgnoreCase("-chunksize")) {
                bl = bl && this.setChunksize(string);
            } else if (((String)object).equalsIgnoreCase("-php_enabled")) {
                bl = this.setPHPEnabled(string);
            } else if (((String)object).equalsIgnoreCase("-iwp_enabled")) {
                bl = this.setIWPEnabled(string);
            } else if (((String)object).equalsIgnoreCase("-iwp_language")) {
                bl = this.setIWPLanguage(string);
            } else if (((String)object).equalsIgnoreCase("-mwperouting")) {
                bl = this.setMWPERouting(string);
            } else if (((String)object).equalsIgnoreCase("-homeurl_enabled")) {
                bl = this.setHomeUrlEnabled(string);
            } else if (((String)object).equalsIgnoreCase("-customhomeurl")) {
                bl = bl && this.setCustomHomeUrl(string);
            } else if (((String)object).equalsIgnoreCase("-aria_compliant_control_enabled")) {
                bl = this.setAriaCompliantControlEnabled(string);
            }
            if (bl) continue;
            n = 105;
        }
        if (n == 0) {
            this.saveConfiguration();
            if (bl2) {
                try {
                    object = this.getLoggerPreference();
                    if ("no".equalsIgnoreCase(((LoggerPreference)object).getUserLogEnabled()) || !"info".equalsIgnoreCase(((LoggerPreference)object).getUserLogLevel()) || bl3) {
                        this.log(map, n);
                    }
                    LoggerManager.updateLogger((LoggerPreference)object);
                }
                catch (LoggerException loggerException) {
                    n = 110;
                    logger.debug(loggerException.getMessage(), loggerException);
                }
            }
        } else {
            this.getConfiguration();
        }
        return n;
    }

    public Document getStatusDoc(int n, String string, int n2, String string2) {
        Document document = this.mDocBuilder.newDocument();
        Element element = document.createElement("fmi-web-config");
        element.setAttribute("version", "1.0");
        Element element2 = document.createElement("error");
        element2.setAttribute("code", Integer.toString(n));
        element2.setAttribute("description", string);
        element.appendChild(element2);
        Element element3 = document.createElement("cwpc-error");
        element3.setAttribute("code", Integer.toString(n2));
        element3.setAttribute("description", string2);
        element.appendChild(element3);
        Element element4 = document.createElement("product");
        element4.setAttribute("name", "JWPC");
        element.appendChild(element4);
        Element element5 = document.createElement("parameters");
        element4.appendChild(element5);
        Element element6 = document.createElement("parameter");
        element6.setAttribute("name", "enabled");
        Text text = document.createTextNode(this.mEnabled);
        element5.appendChild(element6);
        element6.appendChild(text);
        Element element7 = document.createElement("parameter");
        element7.setAttribute("name", "draco-identifier");
        Text text2 = document.createTextNode("fmsadmin");
        element5.appendChild(element7);
        element7.appendChild(text2);
        Element element8 = document.createElement("parameter");
        element8.setAttribute("name", "chunksize");
        Text text3 = document.createTextNode(this.mChunksize);
        element5.appendChild(element8);
        element8.appendChild(text3);
        Element element9 = document.createElement("parameter");
        element9.setAttribute("name", "draco-passphrase");
        Text text4 = document.createTextNode(this.mServerId);
        element5.appendChild(element9);
        element9.appendChild(text4);
        Element element10 = document.createElement("parameter");
        element10.setAttribute("name", "php-enabled");
        Text text5 = document.createTextNode(this.mPHPEnabled);
        element5.appendChild(element10);
        element10.appendChild(text5);
        Element element11 = document.createElement("parameter");
        element11.setAttribute("name", "iwp-enabled");
        Text text6 = document.createTextNode(this.mIWPEnabled);
        element5.appendChild(element11);
        element11.appendChild(text6);
        Element element12 = document.createElement("parameter");
        element12.setAttribute("name", "iwp-language");
        Text text7 = document.createTextNode(this.mIWPLanguage);
        element5.appendChild(element12);
        element12.appendChild(text7);
        Element element13 = document.createElement("parameter");
        element13.setAttribute("name", "mwperouting");
        Text text8 = document.createTextNode(this.mMWPERouting);
        element5.appendChild(element13);
        element13.appendChild(text8);
        Element element14 = document.createElement("parameter");
        element14.setAttribute("name", "homeurl-enabled");
        Text text9 = document.createTextNode(this.mHomeUrlEnabled);
        element5.appendChild(element14);
        element14.appendChild(text9);
        Element element15 = document.createElement("parameter");
        element15.setAttribute("name", "customhomeurl");
        Text text10 = document.createTextNode(this.mCustomHomeUrl);
        element5.appendChild(element15);
        element9.appendChild(text10);
        Element element16 = document.createElement("parameter");
        element16.setAttribute("name", "aria-compliant-control-enabled");
        Text text11 = document.createTextNode(this.mAriaCompliantControlEnabled);
        element5.appendChild(element16);
        element16.appendChild(text11);
        Element element17 = document.createElement("logs");
        Element element18 = document.createElement("log");
        element18.setAttribute("name", "user");
        element18.setAttribute("enabled", this.mUserLogEnabled);
        element18.setAttribute("level", this.mUserLogLevel);
        element18.setAttribute("size", this.mUserLogSize);
        element17.appendChild(element18);
        Element element19 = document.createElement("log");
        element19.setAttribute("name", "debug");
        element19.setAttribute("enabled", this.mDebugLogEnabled);
        element17.appendChild(element19);
        element.appendChild(element17);
        document.appendChild(element);
        return document;
    }

    public synchronized void getConfiguration() {
        File file = new File(this.mConfFilePath);
        if (!file.exists() || file.length() <= 0L) {
            this.mConfigDocument = this.getDefaultConfigDoc();
            this.serializeXMLDocument(this.mConfigDocument, this.mConfFilePath, false);
        } else {
            this.mConfigDocument = this.parseXMLDocument(this.mDocBuilder, this.mConfFilePath);
        }
        if (this.mConfigDocument != null) {
            this.mEnabled = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='enabled']", this.mConfigDocument);
            this.mServerId = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='serverid']", this.mConfigDocument);
            this.mChunksize = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='chunksize']", this.mConfigDocument);
            this.mPHPEnabled = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='phpenabled']", this.mConfigDocument);
            this.mIWPEnabled = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwpenabled']", this.mConfigDocument);
            this.mIWPLanguage = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwplanguage']", this.mConfigDocument);
            this.mMWPERouting = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='mwperouting']", this.mConfigDocument);
            this.mHomeUrlEnabled = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='homeurlenabled']", this.mConfigDocument);
            this.mCustomHomeUrl = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='customhomeurl']", this.mConfigDocument);
            this.mAriaCompliantControlEnabled = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='ariaCompliantControlEnabled']", this.mConfigDocument);
            this.mUserLogEnabled = this.getNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@enabled", this.mConfigDocument);
            this.mUserLogLevel = this.getNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@level", this.mConfigDocument);
            this.mUserLogSize = this.getNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@size", this.mConfigDocument);
            this.mDebugLogEnabled = this.getNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='debug']/@enabled", this.mConfigDocument);
        }
    }

    public Document getDefaultConfigDoc() {
        Document document = null;
        ClassLoader classLoader = ConfigBase.class.getClassLoader();
        DecryptedInputStream decryptedInputStream = null;
        InputStream inputStream = classLoader.getResourceAsStream("jwpc_prefs.xml");
        if (inputStream != null) {
            decryptedInputStream = new DecryptedInputStream((InputStream)new BufferedInputStream(inputStream));
        }
        if (decryptedInputStream != null) {
            document = this.parseXMLStream(this.mDocBuilder, (InputStream)decryptedInputStream);
        }
        return document;
    }

    public void destroy() {
    }

    public boolean setEnabled(String string) {
        if (this.isYesOrNo(string)) {
            this.mEnabled = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setServerId(String string) {
        if (string != null) {
            this.mServerId = string;
            return true;
        }
        return false;
    }

    public boolean setChunksize(String string) {
        if (string != null && this.isValidChunksize(string)) {
            this.mChunksize = string;
            return true;
        }
        return false;
    }

    public boolean setPHPEnabled(String string) {
        if (this.isYesOrNo(string)) {
            this.mPHPEnabled = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setIWPEnabled(String string) {
        if (this.isYesOrNo(string)) {
            this.mIWPEnabled = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setIWPLanguage(String string) {
        this.mIWPLanguage = string;
        return true;
    }

    public boolean setMWPERouting(String string) {
        if (this.isYesOrNo(string)) {
            this.mMWPERouting = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setHomeUrlEnabled(String string) {
        if (this.isYesOrNo(string)) {
            this.mHomeUrlEnabled = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setCustomHomeUrl(String string) {
        if (string != null) {
            this.mCustomHomeUrl = string;
            return true;
        }
        return false;
    }

    public boolean setAriaCompliantControlEnabled(String string) {
        if (this.isYesOrNo(string)) {
            this.mAriaCompliantControlEnabled = this.convertToYesOrNo(string.toLowerCase());
            return true;
        }
        return false;
    }

    public boolean setLog(int n, String string) {
        if (n == 1) {
            this.mUserLogEnabled = this.convertToYesNo(string);
            return true;
        }
        if (n == 2 && this.isValidLogLevel(string)) {
            this.mUserLogLevel = string;
            return true;
        }
        if (n == 3 && this.isValidLogSize(string)) {
            this.mUserLogSize = string;
            return true;
        }
        if (n == 4) {
            this.mDebugLogEnabled = this.convertToYesNo(string);
            return true;
        }
        return false;
    }

    private boolean isValidLogLevel(String string) {
        return "trace".equalsIgnoreCase(string) || "debug".equalsIgnoreCase(string) || "info".equalsIgnoreCase(string) || "warn".equalsIgnoreCase(string) || "error".equalsIgnoreCase(string) || "fatal".equalsIgnoreCase(string);
    }

    private boolean isValidChunksize(String string) {
        if (string == null || string.trim().length() == 0) {
            return false;
        }
        try {
            int n = Integer.parseInt(string);
            return n > 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private boolean isYesOrNo(String string) {
        if ("no".equalsIgnoreCase(string) || "yes".equalsIgnoreCase(string)) {
            return true;
        }
        if ("true".equalsIgnoreCase(string) || "false".equalsIgnoreCase(string)) {
            return true;
        }
        return "on".equalsIgnoreCase(string) || "off".equalsIgnoreCase(string);
    }

    private String convertToYesOrNo(String string) {
        if ("no".equals(string) || "false".equals(string) || "off".equals(string)) {
            return "no";
        }
        if ("yes".equals(string) || "true".equals(string) || "on".equals(string)) {
            return "yes";
        }
        return "no";
    }

    private boolean isOnOrOff(String string) {
        return "on".equalsIgnoreCase(string) || "off".equalsIgnoreCase(string);
    }

    private boolean isValidLogSize(String string) {
        if (string == null || string.trim().length() == 0) {
            return false;
        }
        String string2 = string.trim().toUpperCase();
        try {
            if (string2.endsWith("KB") || string2.endsWith("MB") || string2.endsWith("GB")) {
                int n = string2.length();
                string2 = string2.substring(0, n - 2);
            }
            return Long.parseLong(string2) > 0L;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private String convertToYesNo(String string) {
        if ("on".equalsIgnoreCase(string) || "true".equalsIgnoreCase(string) || "yes".equalsIgnoreCase(string)) {
            return "yes";
        }
        if ("off".equalsIgnoreCase(string) || "false".equalsIgnoreCase(string) || "no".equalsIgnoreCase(string)) {
            return "no";
        }
        return "no";
    }

    private LoggerPreference getLoggerPreference() {
        LoggerPreference loggerPreference = new LoggerPreference();
        loggerPreference.setUserLogEnabled(this.mUserLogEnabled);
        loggerPreference.setUserLogLevel(this.mUserLogLevel);
        loggerPreference.setUserLogSize(this.mUserLogSize);
        loggerPreference.setDebugLogEnabled(this.mDebugLogEnabled);
        return loggerPreference;
    }

    private void log(Map<String, String[]> map, int n) {
        if (!logger.isDebugLoggingEnabled()) {
            if (!logger.isErrorLoggingEnabled()) {
                return;
            }
            if (!logger.isInfoLoggingEnabled() && n == 0) {
                return;
            }
        }
        for (String string : map.keySet()) {
            if (string == null) continue;
            if (string.equalsIgnoreCase("-no_status")) break;
            if (string.equalsIgnoreCase("-action") || string.equalsIgnoreCase("-max_cwp_sessions")) continue;
            LogData logData = new LogData();
            logData.setMessage(this.getLogMessage(n, map, string));
            if ("-debuglog".equalsIgnoreCase(string)) {
                logger.debug(logData);
                continue;
            }
            if (n == 0) {
                logger.infoAndDebug(logData);
                continue;
            }
            logger.errorAndDebug(logData);
        }
    }

    private String getLogMessage(int n, Map<String, String[]> map, String string) {
        String string2;
        if (n == 0) {
            String string3 = this.getLogMessageKey(map, string);
            String[] stringArray = null;
            if ("-userlogsize".equalsIgnoreCase(string) || "-iwp_language".equalsIgnoreCase(string) || "-browser_session_timeout".equalsIgnoreCase(string)) {
                stringArray = new String[]{map.get(string)[0]};
            }
            string2 = LogMessages.get(string3.toString(), stringArray);
        } else {
            string2 = ConfigErrorCode.getDescr(n);
        }
        return string2;
    }

    private String getLogMessageKey(Map<String, String[]> map, String string) {
        String string2 = "";
        String string3 = map.get(string)[0];
        if (Utilities.isEmptyString(string3)) {
            return string2;
        }
        boolean bl = ConfigBase.getBoolean(string3);
        if ("-userlog".equalsIgnoreCase(string)) {
            string2 = bl ? "USERLOG_ON" : "USERLOG_OFF";
        } else if ("-userloglevel".equalsIgnoreCase(string)) {
            if ("error".equalsIgnoreCase(string3)) {
                string2 = "USERLOGLEVEL_ERROR";
            } else if ("info".equalsIgnoreCase(string3)) {
                string2 = "USERLOGLEVEL_INFO";
            }
        } else if ("-userlogsize".equalsIgnoreCase(string)) {
            string2 = "USERLOGSIZE";
        } else if ("-debuglog".equalsIgnoreCase(string)) {
            string2 = bl ? "DEBUGLOG_ON" : "DEBUGLOG_OFF";
        } else if ("-xml_enabled".equalsIgnoreCase(string)) {
            string2 = bl ? "XML_ENABLED_YES" : "XML_ENABLED_NO";
        } else if ("-php_enabled".equalsIgnoreCase(string)) {
            string2 = bl ? "PHP_ENABLED_YES" : "PHP_ENABLED_NO";
        } else if ("-iwp_enabled".equalsIgnoreCase(string)) {
            string2 = bl ? "IWP_ENABLED_YES" : "IWP_ENABLED_NO";
        } else if ("-iwp_language".equalsIgnoreCase(string)) {
            string2 = "IWP_LANGUAGE";
        } else if ("-browser_session_timeout".equalsIgnoreCase(string)) {
            string2 = "IWP_SESSION_TIMEOUT";
        } else if ("-mwperouting".equalsIgnoreCase(string)) {
            string2 = bl ? "MWPE_ROUTING_YES" : "MWPE_ROUTING_NO";
        } else if ("-homeurl_enabled".equalsIgnoreCase(string)) {
            string2 = bl ? "HOMEURL_ENABLED_YES" : "HOMEURL_ENABLED_NO";
        } else if ("-aria_compliant_control_enabled".equalsIgnoreCase(string)) {
            string2 = bl ? "ARIA_COMPLIANT_CONTROL_ENABLED_YES" : "ARIA_COMPLIANT_CONTROL_ENABLED_NO";
        }
        return string2;
    }

    public static boolean getBoolean(String string) {
        String string2;
        return string != null && !string.isEmpty() && ((string2 = string.toLowerCase()).equals("yes") || string2.equals("on") || string2.equals("true"));
    }

    public void serializeXMLDocument(Document document, String string, boolean bl) {
        try {
            if (document != null) {
                if (bl) {
                    EncryptedOutputStream encryptedOutputStream = new EncryptedOutputStream(Files.newOutputStream(Paths.get(string, new String[0]), new OpenOption[0]));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)encryptedOutputStream);
                    this.serializeXMLDocument(document, outputStreamWriter);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                } else {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(Paths.get(string, new String[0]), new OpenOption[0]));
                    this.serializeXMLDocument(document, outputStreamWriter);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                }
            }
        }
        catch (Exception exception) {
            logger.debug(exception.getMessage(), exception);
        }
    }

    public void serializeXMLDocument(Document document, Writer writer) {
        try {
            if (document != null) {
                OutputFormat outputFormat = new OutputFormat(document);
                outputFormat.setLineSeparator("\r\n");
                outputFormat.setIndent(4);
                outputFormat.setLineWidth(0);
                XMLSerializer xMLSerializer = new XMLSerializer(writer, outputFormat);
                xMLSerializer.serialize(document);
            }
        }
        catch (IOException iOException) {
            logger.debug(iOException.getMessage(), iOException);
        }
    }

    public Document parseXMLDocument(DocumentBuilder documentBuilder, String string) {
        Document document = null;
        try {
            DecryptedInputStream decryptedInputStream = new DecryptedInputStream(Files.newInputStream(Paths.get(string, new String[0]), new OpenOption[0]));
            document = this.parseXMLStream(documentBuilder, (InputStream)decryptedInputStream);
        }
        catch (IOException iOException) {
            logger.debug(iOException.getMessage(), iOException);
        }
        return document;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Document parseXMLStream(DocumentBuilder documentBuilder, InputStream inputStream) {
        Document document = null;
        try {
            if (documentBuilder != null && inputStream != null) {
                document = documentBuilder.parse(inputStream);
            }
        }
        catch (SAXException sAXException) {
            logger.debug(sAXException.getMessage(), sAXException);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String string = null;
                while ((string = bufferedReader.readLine()) != null) {
                    logger.debug(string);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        catch (IOException iOException) {
            logger.debug(iOException.getMessage(), iOException);
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {
                logger.debug(iOException.getMessage(), iOException);
            }
        }
        return document;
    }

    public void getDocumentBuilder() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            String string = null;
            string = "http://apache.org/xml/features/disallow-doctype-decl";
            documentBuilderFactory.setFeature(string, true);
            string = "http://xml.org/sax/features/external-general-entities";
            documentBuilderFactory.setFeature(string, false);
            string = "http://xml.org/sax/features/external-parameter-entities";
            documentBuilderFactory.setFeature(string, false);
            string = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            documentBuilderFactory.setFeature(string, false);
            documentBuilderFactory.setXIncludeAware(false);
            documentBuilderFactory.setExpandEntityReferences(false);
            this.mDocBuilder = documentBuilderFactory.newDocumentBuilder();
        }
        catch (Exception exception) {
            logger.debug(exception.getMessage(), exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void saveConfiguration() {
        if (this.mConfigDocument != null) {
            Document document = this.mConfigDocument;
            synchronized (document) {
                this.updateConfiguration();
                this.serializeXMLDocument(this.mConfigDocument, this.mConfFilePath, false);
                this.mConfigHandler.updateConfiguration();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateConfiguration() {
        if (this.mConfigDocument != null) {
            Document document = this.mConfigDocument;
            synchronized (document) {
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='enabled']", this.mConfigDocument, this.mEnabled);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='serverid']", this.mConfigDocument, this.mServerId);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='chunksize']", this.mConfigDocument, this.mChunksize);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='phpenabled']", this.mConfigDocument, this.mPHPEnabled);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwpenabled']", this.mConfigDocument, this.mIWPEnabled);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwplanguage']", this.mConfigDocument, this.mIWPLanguage);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='mwperouting']", this.mConfigDocument, this.mMWPERouting);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='homeurlenabled']", this.mConfigDocument, this.mHomeUrlEnabled);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='customhomeurl']", this.mConfigDocument, this.mCustomHomeUrl);
                this.setNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='ariaCompliantControlEnabled']", this.mConfigDocument, this.mAriaCompliantControlEnabled);
                this.setNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@enabled", this.mConfigDocument, this.mUserLogEnabled);
                this.setNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@level", this.mConfigDocument, this.mUserLogLevel);
                this.setNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='user']/@size", this.mConfigDocument, this.mUserLogSize);
                this.setNodeValue(this.mXPath, "/jwpcconfig/logs/log[@name='debug']/@enabled", this.mConfigDocument, this.mDebugLogEnabled);
            }
        }
    }

    public String getNodeTextValue(XPath xPath, String string, Document document) {
        Node node;
        Node node2 = this.getNode(xPath, string, document);
        if (node2 != null && (node = node2.getFirstChild()) != null) {
            return node.getNodeValue();
        }
        return null;
    }

    public String getNodeValue(XPath xPath, String string, Document document) {
        Node node = this.getNode(xPath, string, document);
        if (node != null) {
            return node.getNodeValue();
        }
        return null;
    }

    public Node getNode(XPath xPath, String string, Document document) {
        try {
            if (xPath != null) {
                Node node = (Node)xPath.evaluate(string, document, XPathConstants.NODE);
                return node;
            }
        }
        catch (Exception exception) {
            logger.debug(exception.getMessage(), exception);
        }
        return null;
    }

    public boolean setNodeValue(XPath xPath, String string, Document document, String string2) {
        Node node = this.getNode(xPath, string, document);
        if (node != null) {
            node.setNodeValue(string2);
            return true;
        }
        logger.debug("DOM document is null!");
        return false;
    }

    public boolean setNodeTextValue(XPath xPath, String string, Document document, String string2) {
        Node node = this.getNode(xPath, string, document);
        if (node != null) {
            Node node2 = node.getFirstChild();
            if (node2 == null) {
                node2 = document.createTextNode(string2);
                node.appendChild(node2);
            } else {
                node2.setNodeValue(string2);
            }
            return true;
        }
        logger.debug("DOM document is null!");
        return false;
    }
}

