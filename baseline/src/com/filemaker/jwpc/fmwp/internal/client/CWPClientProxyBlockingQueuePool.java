/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.ClientPool
 */
package com.filemaker.jwpc.fmwp.internal.client;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class CWPClientProxyBlockingQueuePool
implements ClientPool<CWPClientProxy> {
    private static final int QUEUE_SIZE = 50;
    private static BlockingDeque<CWPClientProxy> pool = null;

    public int availableClientCount() {
        return pool.size();
    }

    public CWPClientProxyBlockingQueuePool() {
        pool = new LinkedBlockingDeque<CWPClientProxy>(50);
        for (int i = 0; i < 50; ++i) {
            try {
                pool.put(new CWPClientProxy(true));
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        this.shutdown();
        super.finalize();
    }

    public CWPClientProxy getClient(int n) {
        CWPClientProxy cWPClientProxy = null;
        try {
            cWPClientProxy = pool.take();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return cWPClientProxy;
    }

    public void putClient(CWPClientProxy cWPClientProxy) {
        if (pool != null) {
            try {
                if (cWPClientProxy.doesNeedReset()) {
                    cWPClientProxy.close();
                    this.closeOpenClients();
                    pool.putLast(cWPClientProxy);
                } else {
                    pool.putFirst(cWPClientProxy);
                }
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void shutdown() {
        ArrayList arrayList = new ArrayList(50);
        pool.drainTo(arrayList);
        for (CWPClientProxy cWPClientProxy : arrayList) {
            if (cWPClientProxy == null) continue;
            cWPClientProxy.close();
        }
    }

    private void closeOpenClients() {
        CWPClientProxy cWPClientProxy = null;
        while ((cWPClientProxy = pool.poll()) != null && cWPClientProxy.isOpen()) {
            cWPClientProxy.close();
        }
    }
}

