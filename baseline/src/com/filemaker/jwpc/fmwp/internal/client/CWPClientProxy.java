/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.iwp.application.AppRuntimeException
 *  com.filemaker.jwpc.iwp.util.IWPConstants
 *  org.apache.thrift.protocol.TBinaryProtocol
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.transport.TSocket
 *  org.apache.thrift.transport.TTransport
 *  org.apache.thrift.transport.TTransportException
 *  org.apache.thrift.transport.layered.TFramedTransport
 */
package com.filemaker.jwpc.fmwp.internal.client;

import com.filemaker.jwpc.fmwp.api.thrift.service.WPEService;
import com.filemaker.jwpc.fmwp.internal.client.CWPServiceConfig;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import java.net.Socket;
import java.net.SocketException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class CWPClientProxy {
    private TSocket transport;
    private WPEService.Client client;
    private boolean bNeedReset = false;
    private int customizedMaxFrameSize = IWPConstants.THRIFT_CLIENT_MAX_FRAME_SIZE;

    CWPClientProxy() throws TTransportException {
        this.transport = new TSocket(CWPServiceConfig.getConfig().getHost(), CWPServiceConfig.getConfig().getPort());
        this.client = new WPEService.Client((TProtocol)new TBinaryProtocol((TTransport)new TFramedTransport((TTransport)this.transport, this.customizedMaxFrameSize)));
    }

    CWPClientProxy(boolean bl) throws TTransportException {
        this.transport = new TSocket(CWPServiceConfig.getConfig().getHost(), CWPServiceConfig.getConfig().getPort());
        if (bl) {
            Socket socket = this.transport.getSocket();
            try {
                socket.setKeepAlive(true);
            }
            catch (SocketException socketException) {
                socketException.printStackTrace();
            }
        }
        this.client = new WPEService.Client((TProtocol)new TBinaryProtocol((TTransport)new TFramedTransport((TTransport)this.transport, this.customizedMaxFrameSize)));
    }

    public WPEService.Client getClient() throws AppRuntimeException {
        if (!this.transport.isOpen()) {
            try {
                this.transport.open();
            }
            catch (TTransportException tTransportException) {
                throw new AppRuntimeException((Throwable)tTransportException);
            }
        }
        return this.client;
    }

    void close() {
        if (this.transport.isOpen()) {
            this.transport.close();
        }
    }

    public boolean isOpen() {
        return this.transport.isOpen();
    }

    public void setReset() {
        this.bNeedReset = true;
    }

    public boolean doesNeedReset() {
        return this.bNeedReset;
    }
}

