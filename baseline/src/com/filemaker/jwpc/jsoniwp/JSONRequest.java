/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.WPEService$Client
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.jsoniwp;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.exceptions.AuthenticationException;
import com.filemaker.jwpc.fmwp.api.thrift.service.WPEService;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DatabaseNamesResult;
import com.filemaker.jwpc.request.WPCRequest;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.XMLResult;
import org.apache.thrift.TException;

public class JSONRequest
extends WPCRequest {
    public static WPCResult performRequest(ConfigXMLRequest configXMLRequest) throws AuthenticationException {
        if (logger.isDebugLoggingEnabled()) {
            logger.debugEntering("performRequest");
            logger.debug("The request info = " + Utilities.getRequestInfoToLog(configXMLRequest));
        }
        XMLResult xMLResult = null;
        CmdCode cmdCode = CmdCode.fromValue((int)configXMLRequest.getCmdCode());
        CWPClientProxy cWPClientProxy = CWPClientProxyPoolLiaison.getClient();
        WPEService.Client client = cWPClientProxy.getClient();
        Credentials credentials = new Credentials(configXMLRequest.getUserName(), configXMLRequest.getPassword(), "", "", false, false, false, false, true, configXMLRequest.getDatabaseName(), configXMLRequest.getPrivilegeExtension());
        switch (cmdCode) {
            case DBNAMES: {
                try {
                    DatabaseNamesResult databaseNamesResult = client.getDatabaseNames(credentials);
                    int n = databaseNamesResult.getError().getErrorCode();
                    logger.debug("Info: Get database names error code: " + n);
                    if (n == ErrorCode.None.getErrorCode()) {
                        xMLResult = new XMLResult(databaseNamesResult.getDatabaseNames());
                        break;
                    }
                    if (n == ErrorCode.AccessDenied.getErrorCode() || n == ErrorCode.LoginRequired.getErrorCode()) {
                        throw new AuthenticationException(ErrorCode.fromValue((int)n), configXMLRequest.getUserName(), configXMLRequest.getPassword());
                    }
                    xMLResult = new XMLResult(ErrorCode.fromValue((int)n));
                    break;
                }
                catch (TException tException) {
                    cWPClientProxy.setReset();
                    tException.printStackTrace();
                    logger.debug("Exception calling WPEService.getDatabaseNames()");
                }
            }
        }
        CWPClientProxyPoolLiaison.putClient((CWPClientProxy)cWPClientProxy);
        logger.debugExiting("performRequest");
        return xMLResult;
    }
}

