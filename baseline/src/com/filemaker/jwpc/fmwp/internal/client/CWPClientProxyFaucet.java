/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.ClientPool
 *  org.apache.thrift.transport.TTransportException
 */
package com.filemaker.jwpc.fmwp.internal.client;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import org.apache.thrift.transport.TTransportException;

public class CWPClientProxyFaucet
implements ClientPool<CWPClientProxy> {
    public int availableClientCount() {
        return 1;
    }

    public CWPClientProxy getClient(int n) {
        try {
            return new CWPClientProxy();
        }
        catch (TTransportException tTransportException) {
            tTransportException.printStackTrace();
            return null;
        }
    }

    public void putClient(CWPClientProxy cWPClientProxy) {
        cWPClientProxy.close();
    }

    public void shutdown() {
    }
}

