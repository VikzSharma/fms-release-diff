/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLConfigParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.WPEService$Client
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.WPCError
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison
 *  com.fmi.net.URLDecoder
 *  jakarta.servlet.ServletConfig
 *  jakarta.servlet.ServletContext
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.http.Cookie
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  org.apache.commons.codec.digest.DigestUtils
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc;

import com.filemaker.jwpc.CGIBase;
import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.exceptions.AuthenticationException;
import com.filemaker.jwpc.exceptions.UnSupportedXMLGrammarException;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLConfigParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.WPEService;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.WPCError;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison;
import com.filemaker.jwpc.http.HttpResponseWrapper;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.log.LogData;
import com.filemaker.jwpc.log.LogMessages;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Encrypter;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.XMLDocument;
import com.filemaker.jwpc.xml.XMLResult;
import com.filemaker.jwpc.xml.parser.XMLCGIParser;
import com.filemaker.jwpc.xml.request.XMLRequest;
import com.filemaker.jwpc.xml.response.FMPXMLLAYOUTDocument;
import com.filemaker.jwpc.xml.response.FMPXMLRESULTDocument;
import com.filemaker.jwpc.xml.response.FMResultSetDocument;
import com.filemaker.jwpc.xml.response.XMLResponse;
import com.fmi.net.URLDecoder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.thrift.TException;

public class XMLCGIBase
extends CGIBase {
    private static final long serialVersionUID = 1L;
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLCGIBase.class);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        logger.debugEntering("processRequest");
        LinkedHashMap<String, ArrayList<String>> linkedHashMap = null;
        String string = this.getQueryString(httpServletRequest);
        linkedHashMap = this.getRequestParameterMap(string);
        String string2 = httpServletRequest.getParameter("-max_cwp_sessions");
        if (string2 != null) {
            LogData logData = new LogData();
            try {
                logData.setMessage("New session limit: " + string2);
                int n = Integer.parseInt(string2);
                CWPClientProxy cWPClientProxy = CWPClientProxyPoolLiaison.getClient();
                WPEService.Client client = cWPClientProxy.getClient();
                IDLConfigParam iDLConfigParam = new IDLConfigParam(n);
                try {
                    client.configure(iDLConfigParam);
                }
                catch (TException tException) {
                    cWPClientProxy.setReset();
                    tException.printStackTrace();
                }
                finally {
                    CWPClientProxyPoolLiaison.putClient((CWPClientProxy)cWPClientProxy);
                }
            }
            catch (NumberFormatException numberFormatException) {
                logData.setFMErrorCode(ErrorCode.InvalidNumber.getErrorCode());
                logData.setMessage("Invalid session limit value: " + string2);
            }
            finally {
                logger.debug(logData);
                logger.debugExiting("processRequest");
            }
            return;
        }
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/plain");
        String string3 = httpServletRequest.getHeader("X-Forwarded-Proto");
        if (Utilities.isEmptyString(string3)) {
            string3 = httpServletRequest.getScheme();
        }
        String string4 = Utilities.getRequestUrl(httpServletRequest);
        String string5 = httpServletRequest.getPathInfo();
        WPCResult wPCResult = null;
        XMLDocument xMLDocument = null;
        if (!this.isEnabled()) {
            if (httpServletRequest.getRequestURL().toString().endsWith("dtd")) {
                httpServletResponse.sendError(403);
            } else {
                ErrorCode errorCode = ErrorCode.TechnologyDisabled;
                httpServletResponse.setContentType(this.getMIMEType());
                PrintWriter printWriter = httpServletResponse.getWriter();
                XMLResponse.ResponseType responseType = XMLCGIParser.getResponseType(string5);
                wPCResult = XMLResponse.generateWPCError(errorCode, responseType == XMLResponse.ResponseType.CONTAINER ? XMLResponse.ResponseType.FMRESULTSET : responseType, printWriter, string3, string4);
            }
            return;
        }
        if (httpServletRequest.getRequestURL().toString().endsWith("fmresultset.dtd")) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            xMLDocument = new FMResultSetDocument(printWriter);
            xMLDocument.getDTD(printWriter);
            printWriter.close();
        } else if (httpServletRequest.getRequestURL().toString().toLowerCase().endsWith("fmpxmllayout.dtd")) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            xMLDocument = new FMPXMLLAYOUTDocument();
            xMLDocument.getDTD(printWriter);
            printWriter.close();
        } else if (httpServletRequest.getRequestURL().toString().toLowerCase().endsWith("fmpxmlresult.dtd")) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            xMLDocument = new FMPXMLRESULTDocument();
            xMLDocument.getDTD(printWriter);
            printWriter.close();
        } else {
            Object object;
            httpServletResponse.setContentType(this.getMIMEType());
            XMLCGIParser xMLCGIParser = null;
            try {
                xMLCGIParser = XMLCGIParser.getInstance(string5, linkedHashMap);
            }
            catch (UnSupportedXMLGrammarException unSupportedXMLGrammarException) {
                logger.debug("processRequest() unknown request " + unSupportedXMLGrammarException.getInvalidGrammar(), unSupportedXMLGrammarException);
                object = httpServletResponse.getWriter();
                wPCResult = XMLResponse.generateWPCError(ErrorCode.UnsupportedXMLGrammar, XMLResponse.ResponseType.FMRESULTSET, (PrintWriter)object, string3, string4);
                ((PrintWriter)object).close();
            }
            if (xMLCGIParser != null) {
                ErrorCode errorCode = ErrorCode.None;
                object = xMLCGIParser.parse();
                if (!((ConfigXMLRequest)object).hasError()) {
                    this.storeAuthenticationInformation(httpServletRequest, (ConfigXMLRequest)object);
                    String string6 = new String(((ConfigXMLRequest)object).getUserAgent() + ((ConfigXMLRequest)object).getClientIP() + ((ConfigXMLRequest)object).getUserName() + ((ConfigXMLRequest)object).getPassword());
                    string6 = DigestUtils.md5Hex((byte[])string6.getBytes());
                    ((ConfigXMLRequest)object).setSessionHash(string6);
                    if (((ConfigXMLRequest)object).getRequestParam().getCmdCode() != CmdCode.DBNAMES.value()) {
                        this.setSessionId(httpServletRequest, (ConfigXMLRequest)object);
                    }
                    if (Utilities.getExtendedPrivilege(httpServletRequest) != null) {
                        ((ConfigXMLRequest)object).setPrivilegeExtension("fmphp");
                    } else {
                        ((ConfigXMLRequest)object).setPrivilegeExtension(this.getExtendedPrivilege());
                    }
                    try {
                        if (((ConfigXMLRequest)object).getCmdCode() == CmdCode.CONTAINER.value()) {
                            ServletContext servletContext = this.getServletContext();
                            String string7 = servletContext.getMimeType(((ConfigXMLRequest)object).getContainerFileName());
                            httpServletResponse.setContentType(string7);
                            errorCode = XMLResponse.generateResponse((ConfigXMLRequest)object, ((ConfigXMLRequest)object).getResponseType(), httpServletResponse);
                            if (!errorCode.ok() && !httpServletResponse.isCommitted()) {
                                if (errorCode.getErrorCode() == ErrorCode.CannotOpenFile.getErrorCode()) {
                                    httpServletResponse.sendError(400, httpServletRequest.getRequestURL().toString() + "?" + httpServletRequest.getQueryString());
                                } else {
                                    httpServletResponse.sendError(404, httpServletRequest.getRequestURL().toString() + "?" + httpServletRequest.getQueryString());
                                }
                            }
                            wPCResult = new XMLResult(errorCode);
                        } else {
                            wPCResult = XMLRequest.performRequest((ConfigXMLRequest)object);
                            if (wPCResult != null) {
                                errorCode = ErrorCode.fromValue((int)wPCResult.getErrorCode());
                                if (errorCode != ErrorCode.ExceedsHostCapacity && ((ConfigXMLRequest)object).getRequestParam().getCmdCode() != CmdCode.DBNAMES.value()) {
                                    XMLCGIBase.createCookie(httpServletResponse, wPCResult.getSessionID());
                                }
                                wPCResult.setProtocol(string3);
                                wPCResult.setHostNamePort(string4);
                                PrintWriter printWriter = httpServletResponse.getWriter();
                                XMLResponse.generateResponse(wPCResult, ((ConfigXMLRequest)object).getResponseType(), printWriter);
                                printWriter.close();
                            }
                        }
                    }
                    catch (AuthenticationException authenticationException) {
                        Object object2 = null;
                        String string8 = httpServletRequest.getParameter("-dbnames");
                        object2 = string8 != null ? "Basic realm=\"FileMaker\"" : "Basic realm=\"Database " + httpServletRequest.getParameter("-db") + "\"";
                        httpServletResponse.setHeader("WWW-Authenticate", (String)object2);
                        httpServletResponse.sendError(401, "");
                    }
                    catch (IllegalStateException illegalStateException) {
                        logger.debug("processRequest() caught an IllegalStateException, WPError = " + String.valueOf(errorCode), illegalStateException);
                    }
                } else {
                    errorCode = ((ConfigXMLRequest)object).getErrorCode();
                    logger.debug("processRequest() parsing error: " + errorCode.name());
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    wPCResult = XMLResponse.generateWPCError(errorCode, ((ConfigXMLRequest)object).getResponseType(), printWriter, string3, string4);
                    printWriter.close();
                }
            }
        }
        this.log(httpServletResponse, wPCResult, string, httpServletRequest.getRequestURI());
        logger.debugExiting("processRequest");
    }

    public String getQueryString(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getQueryString();
        if (string == null) {
            try {
                BufferedReader bufferedReader = httpServletRequest.getReader();
                StringBuffer stringBuffer = new StringBuffer();
                String string2 = bufferedReader.readLine();
                while (string2 != null) {
                    stringBuffer.append(string2);
                    string2 = bufferedReader.readLine();
                }
                string = stringBuffer.toString();
            }
            catch (Exception exception) {
                string = "";
            }
        }
        return string;
    }

    public LinkedHashMap<String, ArrayList<String>> getRequestParameterMap(String string) {
        LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<String, ArrayList<String>>();
        if (!Utilities.isEmptyString(string)) {
            String[] stringArray;
            for (String string2 : stringArray = string.split("&")) {
                String string3;
                String[] stringArray2 = string2.split("=", 2);
                if (stringArray2 == null || stringArray2.length <= 0 || Utilities.isEmptyString(string3 = stringArray2[0])) continue;
                string3 = string3.trim();
                String string4 = stringArray2.length < 2 ? "" : stringArray2[1].trim();
                try {
                    string3 = URLDecoder.decode((String)string3, (String)"UTF-8");
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    string4 = URLDecoder.decode((String)string4, (String)"UTF-8");
                }
                catch (Exception exception) {
                    // empty catch block
                }
                ArrayList<Object> arrayList = null;
                if (!linkedHashMap.containsKey(string3)) {
                    arrayList = new ArrayList<String>();
                    arrayList.add(string4);
                    linkedHashMap.put(string3, arrayList);
                    continue;
                }
                arrayList = linkedHashMap.get(string3);
                arrayList.add(string4);
            }
        }
        return linkedHashMap;
    }

    private void setSessionId(HttpServletRequest httpServletRequest, ConfigXMLRequest configXMLRequest) {
        Cookie[] cookieArray = httpServletRequest.getCookies();
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                if (!cookie.getName().equals("WPCSessionID")) continue;
                try {
                    configXMLRequest.setSessionID(Integer.parseInt(Encrypter.decodeString(cookie.getValue())));
                    break;
                }
                catch (NumberFormatException numberFormatException) {
                    logger.debug("setSessionId() session ID is malformed, set to 0.", numberFormatException);
                    configXMLRequest.setSessionID(0);
                }
            }
        } else {
            logger.debug("setSessionId() " + httpServletRequest.getRemoteHost() + " does not have session cookie.");
        }
    }

    private void log(HttpServletResponse httpServletResponse, WPCResult wPCResult, String string, String string2) {
        LogData logData;
        int n = 404;
        long l = 0L;
        if (httpServletResponse instanceof HttpResponseWrapper) {
            n = ((HttpResponseWrapper)httpServletResponse).getStatus();
            l = ((HttpResponseWrapper)httpServletResponse).getContentLength();
        }
        if ((logger.isErrorLoggingEnabled() || logger.isDebugLoggingEnabled()) && wPCResult != null && wPCResult.hasScriptErrors()) {
            for (WPCError wPCError : wPCResult.getScriptErrors()) {
                logData = this.constructLogData(wPCError.getErrorCodeValue(), n, l, this.constructScriptErrorLogMessage(wPCError), true);
                logger.errorAndDebug(logData);
            }
        }
        if (!logger.isDebugLoggingEnabled()) {
            if (!logger.isErrorLoggingEnabled()) {
                return;
            }
            if (!logger.isInfoLoggingEnabled() && wPCResult != null && wPCResult.getErrorCode() == ErrorCode.None.getErrorCode()) {
                return;
            }
        }
        int n2 = wPCResult != null ? wPCResult.getErrorCode() : ErrorCode.None.getErrorCode();
        logData = this.constructLogData(n2, n, l, this.constructRequestLogMessage(string, string2), wPCResult != null);
        if (wPCResult != null && wPCResult.getErrorCode() != ErrorCode.None.getErrorCode() || logData.getHttpErrorCode() != null && logData.getHttpErrorCode() >= 400) {
            logger.errorAndDebug(logData);
        } else {
            logger.infoAndDebug(logData);
        }
    }

    private void logServerStarted() {
        this.logServerStartedOrStopped(LogMessages.get("SERVER_STARTED"));
    }

    private void logServerStopped() {
        this.logServerStartedOrStopped(LogMessages.get("SERVER_STOPPED"));
    }

    private void logServerStartedOrStopped(String string) {
        if (logger.isInfoLoggingEnabled()) {
            LogData logData = new LogData();
            logData.setMessage(string);
            logger.info(logData);
        }
    }

    private LogData constructLogData(int n, int n2, long l, String string, boolean bl) {
        LogData logData = new LogData();
        if (bl) {
            logData.setFMErrorCode(n);
        } else if (n2 >= 400) {
            logData.setHttpErrorCode(n2);
        }
        logData.setReturnBytes(l);
        logData.setMessage(string);
        return logData;
    }

    private String constructRequestLogMessage(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append(string2);
        if (!Utilities.isEmptyString(string)) {
            try {
                string = URLDecoder.decode((String)string, (String)"UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                logger.debug(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
            }
            stringBuilder.append("?").append(string);
        }
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }

    private String constructScriptErrorLogMessage(WPCError wPCError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LogMessages.get("WEB_SCRIPTING_ERROR")).append(" ").append(wPCError.getWPCErrorCodeValue()).append(", ");
        stringBuilder.append(LogMessages.get("DB_FILE")).append(" \"").append(wPCError.getFileName()).append("\", ");
        stringBuilder.append(LogMessages.get("SCRIPT")).append(" \"").append(wPCError.getScriptName()).append("\", ");
        stringBuilder.append(LogMessages.get("SCRIPT_STEP")).append(" \"").append(wPCError.getScriptStepName()).append("\"");
        return stringBuilder.toString();
    }

    public static void createCookie(HttpServletResponse httpServletResponse, int n) {
        if (httpServletResponse != null) {
            if (n > 0) {
                logger.debug("createCookie() set cookie with session ID = " + n);
                Cookie cookie = new Cookie("WPCSessionID", Encrypter.encodeString(Integer.toString(n)));
                cookie.setPath("/fmi/xml");
                cookie.setHttpOnly(true);
                httpServletResponse.addCookie(cookie);
            } else {
                logger.debug("createCookie() invalid session ID " + n);
            }
        } else {
            logger.debug("createCookie() HTTP response is null.");
        }
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.logServerStarted();
    }

    public void destroy() {
        this.logServerStopped();
    }

    @Override
    public String getExtendedPrivilege() {
        return "fmxml";
    }

    @Override
    public String getMIMEType() {
        return "text/xml";
    }
}

