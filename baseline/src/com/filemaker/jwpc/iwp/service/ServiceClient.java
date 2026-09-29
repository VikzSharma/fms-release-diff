/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.protocol.TBinaryProtocol
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.transport.TSocket
 *  org.apache.thrift.transport.TTransport
 *  org.apache.thrift.transport.TTransportException
 *  org.apache.thrift.transport.layered.TFramedTransport
 */
package com.filemaker.jwpc.iwp.service;

import com.filemaker.jwpc.iwp.service.ServiceConfig;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.service.IWPService;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import java.net.Socket;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class ServiceClient {
    private TSocket transport;
    private IWPService.Client client;
    private boolean bNeedReset = false;
    private int customizedMaxFrameSize = IWPConstants.THRIFT_CLIENT_MAX_FRAME_SIZE;

    ServiceClient() throws TTransportException {
        this.transport = new TSocket(ServiceConfig.getConfig().getHost(), ServiceConfig.getConfig().getPort());
        int n = (int)Session.getTimeout() * 1000;
        if (n < 1) {
            n = 60000;
        }
        this.transport.setTimeout(n);
        this.client = new IWPService.Client((TProtocol)new TBinaryProtocol((TTransport)new TFramedTransport((TTransport)this.transport, this.customizedMaxFrameSize)));
    }

    ServiceClient(boolean bl) {
        try {
            this.transport = new TSocket(ServiceConfig.getConfig().getHost(), ServiceConfig.getConfig().getPort());
            if (bl) {
                Socket socket = this.transport.getSocket();
                socket.setKeepAlive(true);
            }
            this.client = new IWPService.Client((TProtocol)new TBinaryProtocol((TTransport)new TFramedTransport((TTransport)this.transport, this.customizedMaxFrameSize)));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public IWPService.Client getClient() throws TTransportException {
        if (!this.transport.isOpen()) {
            this.transport.open();
        }
        return this.client;
    }

    public void closeClient() {
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

