/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fmi.security.DecryptedInputStream
 */
package com.filemaker.jwpc.config;

import com.filemaker.jwpc.log.JWPCLogger;
import com.fmi.security.DecryptedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ConfigurationHandler {
    private static volatile ConfigurationHandler sRef = null;
    private DocumentBuilder mDocBuilder;
    private Document mConfigDocument;
    private XPath mXPath;
    private XPathFactory mXPathFactory;
    private String mConfFilePath = null;
    private AtomicBoolean mEnabled = new AtomicBoolean(false);
    private AtomicBoolean mIWPEnabled = new AtomicBoolean(false);
    private AtomicReference<String> mIWPLanguage = new AtomicReference();
    private AtomicReference<String> mCustomHomeurl = new AtomicReference();
    private AtomicBoolean mHomeurlEnabled = new AtomicBoolean(false);
    private AtomicReference<String> mServerId = new AtomicReference();
    private AtomicInteger mChunksize = new AtomicInteger(10);
    private AtomicBoolean mMWPERouting = new AtomicBoolean(true);
    private AtomicBoolean mPullToRefreshEnabled = new AtomicBoolean(true);
    private AtomicBoolean mKeystrokeEnabled = new AtomicBoolean(false);
    private AtomicBoolean mAriaCompliantControlEnabled = new AtomicBoolean(false);
    private static String sProductName = null;
    private static String sVersion = null;
    private static String sBuildDate = null;
    private static JWPCLogger logger = JWPCLogger.getLogger(ConfigurationHandler.class);

    public static ConfigurationHandler getInstance(String string) {
        if (sRef == null) {
            return ConfigurationHandler.createInstance(string);
        }
        return sRef;
    }

    private static synchronized ConfigurationHandler createInstance(String string) {
        if (sRef == null) {
            sRef = new ConfigurationHandler(string);
        }
        return sRef;
    }

    private ConfigurationHandler(String string) {
        this.mXPathFactory = XPathFactory.newInstance();
        this.mXPath = this.mXPathFactory.newXPath();
        this.setupPaths(string);
        this.getDocumentBuilder();
        this.getConfiguration();
    }

    public boolean isEnabled() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mEnabled.get();
        }
        return true;
    }

    public boolean isIWPEnabled() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mIWPEnabled.get();
        }
        return true;
    }

    public boolean isHomeurlEnabled() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mHomeurlEnabled.get();
        }
        return true;
    }

    public String getCustomHomeurl() {
        return this.mCustomHomeurl.get();
    }

    public String getIWPLanguage() {
        return this.mIWPLanguage.get();
    }

    public String getServerId() {
        return this.mServerId.get();
    }

    public static String getProductName() {
        return sProductName;
    }

    public static String getProductVersion() {
        return sVersion;
    }

    public static String getBuildDate() {
        return sBuildDate;
    }

    public int getChunksize() {
        return this.mChunksize.get();
    }

    public boolean isMWPERouting() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mMWPERouting.get();
        }
        return true;
    }

    public boolean isPullToRefreshEnabled() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mPullToRefreshEnabled.get();
        }
        return true;
    }

    public boolean isKeystrokeEnabled() {
        return this.mKeystrokeEnabled.get();
    }

    public boolean isAriaCompliantControlEnabled() {
        if (System.getProperty("fmEnableAll") == null) {
            return this.mAriaCompliantControlEnabled.get();
        }
        return true;
    }

    private void setupPaths(String string) {
        try {
            File file = new File(string);
            String string2 = file.getCanonicalPath();
            File file2 = new File(string2).getParentFile().getParentFile().getParentFile();
            File file3 = new File(file2.getCanonicalPath() + File.separator + "conf");
            if (!file3.exists()) {
                file2 = new File(string2).getParentFile().getParentFile();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file2.getCanonicalPath());
            stringBuilder.append(File.separator);
            stringBuilder.append("conf");
            stringBuilder.append(File.separator);
            stringBuilder.append("jwpc_prefs.xml");
            this.mConfFilePath = stringBuilder.toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
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

    public synchronized void getConfiguration() {
        File file = new File(this.mConfFilePath);
        if (!file.exists() || file.length() <= 0L) {
            return;
        }
        this.mConfigDocument = this.parseXMLDocument(this.mDocBuilder, this.mConfFilePath);
        if (this.mConfigDocument != null) {
            sProductName = this.getNodeTextValue(this.mXPath, "/jwpcconfig/build-settings/parameter[@name='product']", this.mConfigDocument);
            sVersion = this.getNodeTextValue(this.mXPath, "/jwpcconfig/build-settings/parameter[@name='product-version']", this.mConfigDocument);
            sBuildDate = this.getNodeTextValue(this.mXPath, "/jwpcconfig/build-settings/parameter[@name='build-date']", this.mConfigDocument);
            String string = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='homeurlenabled']", this.mConfigDocument);
            this.mHomeurlEnabled.set("yes".equalsIgnoreCase(string));
            String string2 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='enabled']", this.mConfigDocument);
            this.mEnabled.set("yes".equalsIgnoreCase(string2));
            String string3 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwpenabled']", this.mConfigDocument);
            this.mIWPEnabled.set("yes".equalsIgnoreCase(string3));
            this.mIWPLanguage.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwplanguage']", this.mConfigDocument));
            this.mCustomHomeurl.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='customhomeurl']", this.mConfigDocument));
            this.mServerId.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='serverid']", this.mConfigDocument));
            String string4 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='chunksize']", this.mConfigDocument);
            try {
                int n = Integer.parseInt(string4);
                this.mChunksize.set(n);
            }
            catch (Exception exception) {
                this.mChunksize.set(10);
            }
            String string5 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='mwperouting']", this.mConfigDocument);
            this.mMWPERouting.set("yes".equalsIgnoreCase(string5));
            String string6 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='pulltorefreshenabled']", this.mConfigDocument);
            this.mPullToRefreshEnabled.set("yes".equalsIgnoreCase(string6));
            String string7 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='keystrokeenabled']", this.mConfigDocument);
            this.mKeystrokeEnabled.set("yes".equalsIgnoreCase(string7));
            String string8 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='ariaCompliantControlEnabled']", this.mConfigDocument);
            this.mAriaCompliantControlEnabled.set("yes".equalsIgnoreCase(string8));
        }
    }

    public synchronized void updateConfiguration() {
        File file = new File(this.mConfFilePath);
        if (!file.exists() || file.length() <= 0L) {
            return;
        }
        this.mConfigDocument = this.parseXMLDocument(this.mDocBuilder, this.mConfFilePath);
        if (this.mConfigDocument != null) {
            String string = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='enabled']", this.mConfigDocument);
            this.mEnabled.set("yes".equalsIgnoreCase(string));
            String string2 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwpenabled']", this.mConfigDocument);
            this.mIWPEnabled.set("yes".equalsIgnoreCase(string2));
            this.mIWPLanguage.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='iwplanguage']", this.mConfigDocument));
            this.mServerId.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='serverid']", this.mConfigDocument));
            String string3 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='chunksize']", this.mConfigDocument);
            try {
                int n = Integer.parseInt(string3);
                this.mChunksize.set(n);
            }
            catch (Exception exception) {
                this.mChunksize.set(10);
            }
            String string4 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='mwperouting']", this.mConfigDocument);
            this.mMWPERouting.set("yes".equalsIgnoreCase(string4));
            String string5 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='pulltorefreshenabled']", this.mConfigDocument);
            this.mPullToRefreshEnabled.set("yes".equalsIgnoreCase(string5));
            String string6 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='homeurlenabled']", this.mConfigDocument);
            this.mHomeurlEnabled.set("yes".equalsIgnoreCase(string6));
            this.mCustomHomeurl.set(this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='customhomeurl']", this.mConfigDocument));
            String string7 = this.getNodeTextValue(this.mXPath, "/jwpcconfig/settings/parameter[@name='ariaCompliantControlEnabled']", this.mConfigDocument);
            this.mAriaCompliantControlEnabled.set("yes".equalsIgnoreCase(string7));
        }
    }

    public Document parseXMLDocument(DocumentBuilder documentBuilder, String string) {
        Document document = null;
        try {
            DecryptedInputStream decryptedInputStream = new DecryptedInputStream((InputStream)new FileInputStream(string));
            document = this.parseXMLStream(documentBuilder, (InputStream)decryptedInputStream);
        }
        catch (FileNotFoundException fileNotFoundException) {
            logger.debug(fileNotFoundException.getMessage(), fileNotFoundException);
        }
        return document;
    }

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
            }
        }
        catch (IOException iOException) {
            logger.debug(iOException.getMessage(), iOException);
        }
        return document;
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
}

