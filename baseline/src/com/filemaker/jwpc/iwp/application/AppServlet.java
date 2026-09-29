/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.thirdparty.guava.common.io.Files
 *  com.googlecode.webutilities.util.Utils
 *  com.vaadin.server.BootstrapFragmentResponse
 *  com.vaadin.server.BootstrapListener
 *  com.vaadin.server.BootstrapPageResponse
 *  com.vaadin.server.DefaultErrorHandler
 *  com.vaadin.server.ErrorEvent
 *  com.vaadin.server.ErrorHandler
 *  com.vaadin.server.RequestHandler
 *  com.vaadin.server.ServiceException
 *  com.vaadin.server.SessionInitEvent
 *  com.vaadin.server.SessionInitListener
 *  com.vaadin.server.UnsupportedBrowserHandler
 *  com.vaadin.server.VaadinRequest
 *  com.vaadin.server.VaadinResponse
 *  com.vaadin.server.VaadinServlet
 *  com.vaadin.server.VaadinSession
 *  jakarta.servlet.ServletConfig
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.ServletOutputStream
 *  jakarta.servlet.ServletRequest
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  jakarta.servlet.http.HttpSession
 *  org.jsoup.nodes.Element
 *  org.jsoup.select.Elements
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.config.ConfigurationHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.FMRequestManager;
import com.filemaker.jwpc.iwp.application.SessionContext;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.PDFSupport;
import com.google.gwt.thirdparty.guava.common.io.Files;
import com.googlecode.webutilities.util.Utils;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorEvent;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.UnsupportedBrowserHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AppServlet
extends VaadinServlet {
    private static final long serialVersionUID = 1L;
    public static final String INIT_PARAM_EXPIRES_MINUTES = "expiresMinutes";
    public static final String INIT_PARAM_CACHE_CONTROL = "cacheControl";
    public static final String INIT_PARAM_AUTO_CORRECT_URLS_IN_CSS = "autoCorrectUrlsInCSS";
    public static final String MAX_AGE_100_DAYS = "max-age=8640000";
    private long expiresMinutes = 10080L;
    private String cacheControl = "public";
    private boolean autoCorrectUrlsInCSS = true;
    private String mContextPath = null;
    private static ConfigurationHandler mConfigHandler = null;
    private FMRequestManager requestManager = null;
    private String docDir = "";
    private static AppServlet thisServlet = null;

    public AppServlet() {
        thisServlet = this;
    }

    public static AppServlet getInstance() {
        return thisServlet;
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.mContextPath = servletConfig.getServletContext().getRealPath("/");
        mConfigHandler = ConfigurationHandler.getInstance(this.mContextPath);
        this.expiresMinutes = Utils.readLong((String)servletConfig.getInitParameter(INIT_PARAM_EXPIRES_MINUTES), (long)this.expiresMinutes);
        this.cacheControl = servletConfig.getInitParameter(INIT_PARAM_CACHE_CONTROL) != null ? servletConfig.getInitParameter(INIT_PARAM_CACHE_CONTROL) : this.cacheControl;
        this.autoCorrectUrlsInCSS = Utils.readBoolean((String)servletConfig.getInitParameter(INIT_PARAM_AUTO_CORRECT_URLS_IN_CSS), (boolean)this.autoCorrectUrlsInCSS);
        IWPI18N.setDefaultLanguage(this.mContextPath);
        this.requestManager = new FMRequestManager(this.mContextPath);
    }

    public static boolean isEnabled() {
        return mConfigHandler.isIWPEnabled();
    }

    public static boolean isHomeurlEnabled() {
        return mConfigHandler.isHomeurlEnabled();
    }

    public static String getCustomHomeurl() {
        return mConfigHandler.getCustomHomeurl();
    }

    public static String getLanguage() {
        return mConfigHandler.getIWPLanguage();
    }

    public static boolean isPullToRefreshEnabled() {
        return mConfigHandler.isPullToRefreshEnabled();
    }

    public static boolean isKeystrokeEnabled() {
        return mConfigHandler.isKeystrokeEnabled();
    }

    public static boolean isAriaCompliantControlEnabled() {
        return mConfigHandler.isAriaCompliantControlEnabled();
    }

    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        this.getService().addSessionInitListener((SessionInitListener)new CustomHandler());
    }

    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.fixEncoding((ServletRequest)httpServletRequest);
        String string = httpServletRequest.getRequestURI();
        if (this.requestManager.processRequest(httpServletRequest, httpServletResponse)) {
            return;
        }
        if (string.endsWith("jpg") || string.endsWith("png") || string.endsWith("gif") || string.endsWith("ico")) {
            if (string.startsWith("/fmi/VAADIN/themes")) {
                httpServletResponse.addHeader("Cache-Control", MAX_AGE_100_DAYS);
            }
        } else if (string.endsWith(".js")) {
            httpServletResponse.addHeader("Cache-Control", MAX_AGE_100_DAYS);
            httpServletResponse.addHeader("Content-Type", "application/javascript");
        } else if (string.endsWith(".css")) {
            httpServletResponse.addHeader("Cache-Control", MAX_AGE_100_DAYS);
            httpServletResponse.addHeader("Content-Type", "text/css");
        } else if (string.contains("/VAADIN/") && !string.contains("fontawesome-webfont")) {
            httpServletResponse.sendRedirect("/fmi/webd");
        }
        super.service(httpServletRequest, httpServletResponse);
    }

    protected void fixEncoding(ServletRequest servletRequest) {
        if (servletRequest.getCharacterEncoding() == null) {
            try {
                servletRequest.setCharacterEncoding("utf-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
        }
    }

    public SessionContext getSessionContext(VaadinRequest vaadinRequest) {
        return this.requestManager.getSessionContext(vaadinRequest);
    }

    public void clearSessionContext(VaadinRequest vaadinRequest, App app) {
        app.getAppView().setConfirmLogout(false);
        this.requestManager.clearSessionContext(vaadinRequest, app);
    }

    public FMRequestManager getRequestManager() {
        return this.requestManager;
    }

    public void setDocumentsDirectory(String string) {
        if (this.docDir.isEmpty()) {
            this.docDir = string;
        }
    }

    public void servePDF(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            int n;
            PDFSupport.PDFInputStream pDFInputStream2;
            Object object;
            boolean bl = false;
            String string = "";
            String string2 = httpServletRequest.getParameter("path");
            if (!(this.docDir.isEmpty() || string2 == null || string2.isEmpty() || string2.contains("..") || (string = Files.simplifyPath((String)(this.docDir + string2))).isEmpty() || !string.startsWith(this.docDir) || (object = httpServletRequest.getParameter("pid")) == null || ((String)object).isEmpty())) {
                for (PDFSupport.PDFInputStream pDFInputStream2 : VaadinSession.getAllSessions((HttpSession)httpServletRequest.getSession())) {
                    String string3 = pDFInputStream2.getSession().getId();
                    if (!string3.equals(object)) continue;
                    bl = true;
                    break;
                }
            }
            if (!bl) {
                httpServletResponse.sendError(404);
                return;
            }
            object = httpServletRequest.getParameter("name");
            if (!((String)object).toLowerCase().endsWith(".pdf")) {
                object = (String)object + ".pdf";
            }
            String string4 = httpServletRequest.getParameter("key");
            pDFInputStream2 = PDFSupport.getInputStream(string, string4);
            int n2 = pDFInputStream2.getContentLength();
            httpServletResponse.addHeader("Content-disposition", "inline; filename=" + (String)object);
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(n2);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            while ((n = pDFInputStream2.read()) != -1) {
                servletOutputStream.write(n);
            }
            pDFInputStream2.close();
            servletOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            httpServletResponse.sendError(404);
        }
    }

    private class CustomHandler
    extends UnsupportedBrowserHandler
    implements SessionInitListener {
        private CustomHandler() {
        }

        public void sessionInit(final SessionInitEvent sessionInitEvent) throws ServiceException {
            sessionInitEvent.getSession().addBootstrapListener(new BootstrapListener(){
                String userAgent = null;
                final /* synthetic */ CustomHandler this$1;
                {
                    this.this$1 = customHandler;
                }

                public void modifyBootstrapPage(BootstrapPageResponse bootstrapPageResponse) {
                    String string;
                    Element element;
                    if (this.userAgent == null) {
                        this.userAgent = sessionInitEvent.getRequest().getHeader("User-Agent") != null ? sessionInitEvent.getRequest().getHeader("User-Agent").toLowerCase() : bootstrapPageResponse.getRequest().getHeader("User-Agent");
                    }
                    StringBuilder stringBuilder = new StringBuilder("<meta name=\"viewport\" content=\"initial-scale=1, minimum-scale=1, maximum-scale=5, width=device-width");
                    if (this.userAgent != null && this.userAgent.toLowerCase().contains("iphone")) {
                        stringBuilder.append(", user-scalable=no");
                    }
                    stringBuilder.append("\" />");
                    bootstrapPageResponse.getDocument().head().append(stringBuilder.toString());
                    Element element2 = bootstrapPageResponse.getDocument().head();
                    Elements elements = element2.getElementsByAttributeValue("http-equiv", "X-UA-Compatible");
                    if (!elements.isEmpty()) {
                        element = (Element)elements.get(0);
                        element.attr("content", "IE=Edge;chrome=1");
                    } else {
                        bootstrapPageResponse.getDocument().head().append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge;chrome=1\" />");
                    }
                    element = bootstrapPageResponse.getDocument().body().getElementsByTag("noscript");
                    if (element != null) {
                        string = (Element)element.get(0);
                        String string2 = "Enable JavaScript in your browser to use this application.";
                        try {
                            string2 = IWPI18N.get(sessionInitEvent.getRequest().getLocale(), "JS_OFF_ERROR", new Object[0]);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        string.text(string2);
                    }
                    string = "desktop";
                    if (this.userAgent != null && (this.userAgent.contains("mobile") || this.userAgent.contains("android"))) {
                        string = "mobile";
                    }
                    this.this$1.addCssLink(element2, "styles", string);
                }

                public void modifyBootstrapFragment(BootstrapFragmentResponse bootstrapFragmentResponse) {
                }
            });
            sessionInitEvent.getSession().addRequestHandler((RequestHandler)this);
            sessionInitEvent.getSession().setErrorHandler((ErrorHandler)new DefaultErrorHandler(){

                public void error(ErrorEvent errorEvent) {
                    errorEvent.getThrowable().printStackTrace();
                }
            });
        }

        protected void writeBrowserTooOldPage(VaadinRequest vaadinRequest, VaadinResponse vaadinResponse) throws IOException {
            PrintWriter printWriter = vaadinResponse.getWriter();
            String string = "The web browser you are using is too old or not supported. Please use a supported web browser.";
            try {
                string = IWPI18N.get(vaadinRequest.getLocale(), "UNSUPPORTED_BROWSER_ERROR", new Object[0]);
            }
            catch (Exception exception) {
                // empty catch block
            }
            ((Writer)printWriter).write(string);
        }

        private void addCssLink(Element element, String string, String string2) {
            element.append(String.format("<link rel=\"stylesheet\" type=\"text/css\" id=\"fm-%s\" href=\"/fmi/VAADIN/themes/default/styles-%s.css\">", string, string2));
        }
    }
}

