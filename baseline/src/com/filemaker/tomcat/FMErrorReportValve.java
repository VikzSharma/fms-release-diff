/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.ServletException
 *  org.apache.catalina.connector.Request
 *  org.apache.catalina.connector.Response
 *  org.apache.catalina.valves.ValveBase
 *  org.apache.tomcat.util.ExceptionUtils
 *  org.apache.tomcat.util.res.StringManager
 *  org.apache.tomcat.util.security.Escape
 */
package com.filemaker.tomcat;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.tomcat.util.ExceptionUtils;
import org.apache.tomcat.util.res.StringManager;
import org.apache.tomcat.util.security.Escape;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class FMErrorReportValve
extends ValveBase {
    static final String cNameSpace_XMLProperties = "http://www.filemaker.com/xmlproperties";
    static final String cTag_Properties = "properties";
    static final String cTag_Property = "property";
    static final String cTagAttr_Name = "name";
    private Hashtable<String, String> mProperties;
    private static final String info = "org.apache.catalina.valves.ErrorReportValve/1.0";
    protected static StringManager sm = StringManager.getManager((String)"org.apache.catalina.valves");

    public FMErrorReportValve() {
        super(true);
    }

    public String getInfo() {
        return info;
    }

    public void invoke(Request request, Response response) throws IOException, ServletException {
        this.getNext().invoke(request, response);
        if (response.isCommitted()) {
            return;
        }
        if (request.isAsyncStarted()) {
            return;
        }
        Throwable throwable = (Throwable)request.getAttribute("jakarta.servlet.error.exception");
        if (throwable != null) {
            response.setError();
            try {
                response.reset();
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
            response.sendError(500);
        }
        response.setSuspended(false);
        try {
            this.report(request, response, throwable);
        }
        catch (Throwable throwable2) {
            ExceptionUtils.handleThrowable((Throwable)throwable2);
        }
    }

    private void loadProperties() {
        String string;
        InputStream inputStream = null;
        ClassLoader classLoader = ((Object)((Object)this)).getClass().getClassLoader();
        inputStream = classLoader.getResourceAsStream(string = "com/filemaker/tomcat/tomcat_errors_" + Locale.getDefault().getLanguage() + ".xml");
        if (inputStream == null) {
            string = "com/filemaker/tomcat/tomcat_errors_en.xml";
            inputStream = classLoader.getResourceAsStream(string);
        }
        try {
            DocumentBuilder documentBuilder = null;
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            NodeList nodeList = document.getElementsByTagNameNS(cNameSpace_XMLProperties, cTag_Property);
            int n = nodeList.getLength();
            this.mProperties = new Hashtable((int)((double)n * 1.5));
            for (int i = 0; i < n; ++i) {
                try {
                    Element element = (Element)nodeList.item(i);
                    String string2 = element.getAttribute(cTagAttr_Name);
                    String string3 = element.getFirstChild().getNodeValue();
                    if (this.mProperties.containsKey(string2)) continue;
                    this.mProperties.put(string2, string3);
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
            }
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    protected void report(Request request, Response response, Throwable throwable) {
        int n;
        if (this.mProperties == null) {
            this.loadProperties();
        }
        if ((n = response.getStatus()) < 400 || response.getContentWritten() > 0L) {
            return;
        }
        String string = Escape.htmlElementContent((String)response.getMessage());
        if (string == null) {
            string = "";
        }
        String string2 = null;
        try {
            string2 = sm.getString("http." + n, new Object[]{string});
        }
        catch (Throwable throwable2) {
            ExceptionUtils.handleThrowable((Throwable)throwable2);
        }
        if (string2 == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>");
        stringBuilder.append(this.mProperties.get("title"));
        stringBuilder.append("</title>");
        stringBuilder.append("<style><!--");
        stringBuilder.append("H1 {font-family:Arial,sans-serif;color:white;background-color:#BEBEBE;font-size:22px;}");
        stringBuilder.append("H2 {font-family:Arial,sans-serif;color:white;background-color:#BEBEBE;font-size:16px;}");
        stringBuilder.append("H3 {font-family:Arial,sans-serif;color:white;background-color:#BEBEBE;font-size:14px;font-weight:bold;}");
        stringBuilder.append("H4 {font-family:Arial,sans-serif;font-size:14px;font-weight:bold;}");
        stringBuilder.append("BODY {font-family:Arial,sans-serif;color:black;background-color:white;}");
        stringBuilder.append("P {font-family:Arial,sans-serif;background:white;color:black;font-size:12px;}");
        stringBuilder.append("A {color : black;}A.name {color : black;}HR {color : #BEBEBE;}");
        stringBuilder.append("--></style> ");
        stringBuilder.append("</head><body>");
        stringBuilder.append("<h1>");
        stringBuilder.append(sm.getString("errorReportValve.statusHeader", new Object[]{"" + n, string})).append("</h1>");
        stringBuilder.append("<HR size=\"1\" noshade=\"noshade\">");
        stringBuilder.append("<h4>");
        stringBuilder.append(this.mProperties.get("error_label"));
        stringBuilder.append("<br/>");
        stringBuilder.append(string2);
        stringBuilder.append("<br/><br/></h4>");
        stringBuilder.append("<h4>");
        stringBuilder.append(this.mProperties.get("error_suggestion"));
        stringBuilder.append("</h4>");
        stringBuilder.append("<HR size=\"1\" noshade=\"noshade\">");
        stringBuilder.append("<h3>").append(this.mProperties.get("product_title")).append("</h3>");
        stringBuilder.append("</body></html>");
        try {
            block12: {
                try {
                    response.setContentType("text/html");
                    response.setCharacterEncoding("utf-8");
                }
                catch (Throwable throwable3) {
                    if (!this.container.getLogger().isDebugEnabled()) break block12;
                    this.container.getLogger().debug((Object)"status.setContentType", throwable3);
                }
            }
            PrintWriter printWriter = response.getReporter();
            if (printWriter != null) {
                ((Writer)printWriter).write(stringBuilder.toString());
            }
        }
        catch (IOException iOException) {
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
    }

    protected String getPartialServletStackTrace(Throwable throwable) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(throwable.toString()).append('\n');
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        int n2 = stackTraceElementArray.length;
        for (n = 0; n < stackTraceElementArray.length; ++n) {
            if (!stackTraceElementArray[n].getClassName().startsWith("org.apache.catalina.core.ApplicationFilterChain") || !stackTraceElementArray[n].getMethodName().equals("internalDoFilter")) continue;
            n2 = n;
        }
        for (n = 0; n < n2; ++n) {
            if (stackTraceElementArray[n].getClassName().startsWith("org.apache.catalina.core.")) continue;
            stringBuilder.append('\t').append(stackTraceElementArray[n].toString()).append('\n');
        }
        return stringBuilder.toString();
    }
}

