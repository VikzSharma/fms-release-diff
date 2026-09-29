/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.command.CmdCode
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy
 *  com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.xml.request;

import com.filemaker.jwpc.businessobject.ConfigXMLRequest;
import com.filemaker.jwpc.exceptions.AuthenticationException;
import com.filemaker.jwpc.fmwp.command.CmdCode;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyPoolLiaison;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.request.WPCRequest;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.XMLResult;
import org.apache.thrift.TException;

public class XMLRequest
extends WPCRequest {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    public static WPCResult performRequest(ConfigXMLRequest var0) throws AuthenticationException {
        if (XMLRequest.logger.isDebugLoggingEnabled()) {
            XMLRequest.logger.debugEntering("performRequest");
            XMLRequest.logger.debug("The request info = " + Utilities.getRequestInfoToLog(var0));
        }
        var1_1 = null;
        var2_2 = CmdCode.fromValue((int)var0.getCmdCode());
        var4_3 = CWPClientProxyPoolLiaison.getClient();
        try {
            var5_4 = var4_3.getClient();
            var6_5 = new Credentials(var0.getUserName(), var0.getPassword(), var0.getEmail(), var0.getPasscode(), false, var0.getIsOAuth(), var0.getIsAppleID(), false, true, var0.getDatabaseName(), var0.getPrivilegeExtension());
            switch (1.$SwitchMap$com$filemaker$jwpc$fmwp$command$CmdCode[var2_2.ordinal()]) {
                case 1: {
                    try {
                        var7_6 = var5_4.getDatabaseNames(var6_5);
                        var8_13 = var7_6.getError().getErrorCode();
                        XMLRequest.logger.debug("Info: Get database names error code: " + var8_13);
                        if (var8_13 == ErrorCode.None.getErrorCode()) {
                            var1_1 = new XMLResult(var7_6.getDatabaseNames());
                            ** break;
lbl19:
                            // 1 sources

                            break;
                        }
                        if (var8_13 == ErrorCode.AccessDenied.getErrorCode() || var8_13 == ErrorCode.LoginRequired.getErrorCode()) {
                            throw new AuthenticationException(ErrorCode.fromValue((int)var8_13), var0.getUserName(), var0.getPassword());
                        }
                        var1_1 = new XMLResult(ErrorCode.fromValue((int)var8_13));
                        ** break;
lbl24:
                        // 1 sources

                    }
                    catch (TException var7_7) {
                        var4_3.setReset();
                        var7_7.printStackTrace();
                        XMLRequest.logger.debug("Exception calling WPEService.getDatabaseNames()");
                        ** break;
                    }
lbl30:
                    // 1 sources

                    break;
                }
                case 2: {
                    try {
                        var7_8 = var5_4.getLayoutNames(var0.getRequestParam());
                        var8_14 = var7_8.getStatus().getError();
                        XMLRequest.logger.debug("Info: Get layout names error code: " + String.valueOf(var8_14));
                        if (var8_14.getError() == ErrorCode.None.getErrorCode()) {
                            var1_1 = new XMLResult(var7_8, WPCResult.ResultType.LAYOUT_NAME, var0.getDatabaseName());
                            ** break;
lbl39:
                            // 1 sources

                            break;
                        }
                        if (var8_14.getError() == ErrorCode.AccessDenied.getErrorCode() || var8_14.getError() == ErrorCode.LoginRequired.getErrorCode() || var8_14.getError() == ErrorCode.InvalidAuthentication.getErrorCode()) {
                            throw new AuthenticationException(ErrorCode.fromValue((int)var8_14.getError()), var0.getUserName(), var0.getPassword());
                        }
                        var1_1 = new XMLResult(ErrorCode.fromValue((int)var8_14.getError()));
                        ** break;
lbl44:
                        // 1 sources

                    }
                    catch (TException var7_9) {
                        var4_3.setReset();
                        var7_9.printStackTrace();
                        XMLRequest.logger.debug("Exception calling WPEService.getLayoutNames()");
                        ** break;
                    }
lbl50:
                    // 1 sources

                    break;
                }
                case 3: {
                    try {
                        var7_10 = var5_4.getScriptNames(var0.getRequestParam());
                        var8_15 = var7_10.getStatus().getError();
                        XMLRequest.logger.debug("Info: Get script names error code: " + String.valueOf(var8_15));
                        if (var8_15.getError() == ErrorCode.None.getErrorCode()) {
                            var1_1 = new XMLResult(var7_10, WPCResult.ResultType.SCRIPT_NAME, var0.getDatabaseName());
                            ** break;
lbl59:
                            // 1 sources

                            break;
                        }
                        if (var8_15.getError() == ErrorCode.AccessDenied.getErrorCode() || var8_15.getError() == ErrorCode.LoginRequired.getErrorCode() || var8_15.getError() == ErrorCode.InvalidAuthentication.getErrorCode()) {
                            throw new AuthenticationException(ErrorCode.fromValue((int)var8_15.getError()), var0.getUserName(), var0.getPassword());
                        }
                        var1_1 = new XMLResult(ErrorCode.fromValue((int)var8_15.getError()));
                        ** break;
lbl64:
                        // 1 sources

                    }
                    catch (TException var7_11) {
                        var4_3.setReset();
                        var7_11.printStackTrace();
                        XMLRequest.logger.debug("Exception calling WPEService.getScriptNames()");
                        ** break;
                    }
lbl70:
                    // 1 sources

                    break;
                }
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: {
                    try {
                        var7_12 = var5_4.performRecordRequest(var0.getRequestParam());
                        var8_16 = var7_12.getStatus().getError();
                        var9_20 = ErrorCode.fromValue((int)var8_16.getError());
                        if (var9_20 == ErrorCode.None) {
                            var1_1 = new XMLResult(var7_12);
                            ** break;
lbl79:
                            // 1 sources

                            break;
                        }
                        if (var9_20.isAuthenticationError()) {
                            throw new AuthenticationException(var9_20, var0.getUserName(), var0.getPassword(), var0.getDatabaseName());
                        }
                        if (var7_12.getRecords().size() > 0) {
                            var1_1 = new XMLResult(var7_12.getStatus());
                            ** break;
lbl85:
                            // 1 sources

                            break;
                        }
                        var1_1 = new XMLResult(var7_12.getStatus(), var9_20);
                        ** break;
lbl88:
                        // 1 sources

                    }
                    catch (TException var8_17) {
                        var4_3.setReset();
                        var8_17.printStackTrace();
                        XMLRequest.logger.debug("Exception calling WPEService.performRecordRequest()");
                        ** break;
                    }
lbl94:
                    // 1 sources

                    break;
                }
                case 13: {
                    try {
                        var8_18 = var5_4.ping();
                        var1_1 = new XMLResult(ErrorCode.None);
                        ** break;
lbl100:
                        // 1 sources

                    }
                    catch (TException var8_19) {
                        var4_3.setReset();
                        var8_19.printStackTrace();
                        XMLRequest.logger.debug("Exception calling WPEService.ping()");
                        ** break;
                    }
lbl106:
                    // 1 sources

                    break;
                }
                default: {
                    var3_21 = ErrorCode.InvalidCommand;
                    var1_1 = new XMLResult(var3_21);
                    break;
                }
            }
        }
        finally {
            CWPClientProxyPoolLiaison.putClient((CWPClientProxy)var4_3);
        }
        if (var1_1 != null) {
            XMLRequest.logger.debug("Result for the request = " + var1_1.toString());
        }
        XMLRequest.logger.debugExiting("performRequest");
        return var1_1;
    }
}

