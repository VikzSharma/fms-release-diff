/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.ContainerParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLContainerData
 *  com.filemaker.jwpc.fmwp.api.thrift.service.WPEService$Client
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison
 *  jakarta.servlet.http.HttpServletResponse
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.xml.response;

import com.filemaker.jwpc.XMLCGIBase;
import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.exceptions.AuthenticationException;
import com.filemaker.jwpc.fmwp.api.thrift.service.ContainerParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLContainerData;
import com.filemaker.jwpc.fmwp.api.thrift.service.WPEService;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.response.Document;
import com.filemaker.jwpc.response.WPCResponse;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.XMLResult;
import com.filemaker.jwpc.xml.response.FMPXMLLAYOUTDocument;
import com.filemaker.jwpc.xml.response.FMPXMLRESULTDocument;
import com.filemaker.jwpc.xml.response.FMResultSetDocument;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import org.apache.thrift.TException;

public class XMLResponse
implements WPCResponse {
    private static JWPCLogger logger = JWPCLogger.getLogger(XMLResponse.class);

    public static void generateResponse(WPCResult wPCResult, ResponseType responseType, Writer writer) {
        Document document = null;
        switch (responseType.ordinal()) {
            case 0: {
                if (!(wPCResult instanceof XMLResult)) break;
                document = new FMResultSetDocument(writer, (XMLResult)wPCResult);
                break;
            }
            case 1: {
                document = new FMPXMLLAYOUTDocument(writer, (XMLResult)wPCResult);
                break;
            }
            case 3: {
                document = new FMPXMLRESULTDocument(writer, (XMLResult)wPCResult);
            }
        }
        if (document != null) {
            document.generateResponse();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ErrorCode generateResponse(ConfigXMLRequest configXMLRequest, ResponseType responseType, HttpServletResponse httpServletResponse) throws AuthenticationException {
        if (logger.isDebugLoggingEnabled()) {
            logger.debugEntering("generateResponse");
            logger.debug("The request info = " + Utilities.getRequestInfoToLog(configXMLRequest));
        }
        ErrorCode errorCode = ErrorCode.None;
        try {
            IDLContainerData iDLContainerData = null;
            ContainerParam containerParam = new ContainerParam(configXMLRequest.getRequestParam().getParam(), (IDLComplexParam)configXMLRequest.getFirstRelatedField());
            boolean bl = true;
            OutputStream outputStream = null;
            do {
                CWPClientProxy cWPClientProxy = CWPClientProxyPoolLiaison.getClient();
                WPEService.Client client = cWPClientProxy.getClient();
                logger.debug("Mod id = " + configXMLRequest.getModId() + ", skip = " + configXMLRequest.getItemsToSkip());
                try {
                    iDLContainerData = client.getContainerData(containerParam);
                    errorCode = ErrorCode.fromValue((int)iDLContainerData.getStatus().getError().getError());
                    logger.debug("Info: Get contaner data error code: " + errorCode.getErrorCode());
                    if (!errorCode.ok()) break;
                    configXMLRequest.setModId(iDLContainerData.getModId());
                    if (bl) {
                        configXMLRequest.setSessionID(iDLContainerData.getStatus().getSession());
                        XMLCGIBase.createCookie(httpServletResponse, iDLContainerData.getStatus().getSession());
                        outputStream = new BufferedOutputStream((OutputStream)httpServletResponse.getOutputStream());
                        httpServletResponse.setContentLength((int)iDLContainerData.getTotal());
                        bl = false;
                    }
                    logger.debug("Result for the request = " + XMLResponse.getResultInfoToLog(iDLContainerData));
                    outputStream.write(iDLContainerData.getData());
                    configXMLRequest.setItemsToSkip(configXMLRequest.getItemsToSkip() + configXMLRequest.getMaxItems());
                }
                catch (TException tException) {
                    cWPClientProxy.setReset();
                    tException.printStackTrace();
                }
                finally {
                    CWPClientProxyPoolLiaison.putClient((CWPClientProxy)cWPClientProxy);
                }
            } while (iDLContainerData.getRemain() > 0L);
            if (outputStream != null) {
                outputStream.close();
            }
        }
        catch (Exception exception) {
            logger.debug("generateResponse() caught an exception " + exception.getLocalizedMessage(), exception);
        }
        if (errorCode.isAuthenticationError()) {
            throw new AuthenticationException(errorCode, configXMLRequest.getUserName(), configXMLRequest.getPassword(), configXMLRequest.getDatabaseName());
        }
        logger.debugExiting("generateResponse");
        return errorCode;
    }

    public static XMLResult generateWPCError(ErrorCode errorCode, ResponseType responseType, PrintWriter printWriter, String string, String string2) {
        XMLResult xMLResult = new XMLResult(errorCode);
        xMLResult.setHostNamePort(string2);
        xMLResult.setProtocol(string);
        XMLResponse.generateResponse(xMLResult, responseType, printWriter);
        return xMLResult;
    }

    private static String getResultInfoToLog(IDLContainerData iDLContainerData) {
        String string = Utilities.getLineBreak();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(iDLContainerData.getClass().getName()).append('[').append(string);
        stringBuilder.append("mStatus=").append(DataObject.toString(iDLContainerData.getStatus())).append(string);
        stringBuilder.append("mModId=").append(iDLContainerData.getModId()).append(string);
        stringBuilder.append("mType=").append(iDLContainerData.getType()).append(string);
        stringBuilder.append("mTotal=").append(iDLContainerData.getTotal()).append(string);
        stringBuilder.append("mRemain=").append(iDLContainerData.getRemain()).append(string);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static enum ResponseType {
        FMRESULTSET,
        FMPXMLLAYOUT,
        CONTAINER,
        FMPXMLRESULT;

    }
}

