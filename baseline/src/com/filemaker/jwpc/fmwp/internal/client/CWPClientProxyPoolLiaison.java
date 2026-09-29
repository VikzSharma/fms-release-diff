/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.ClientPool
 */
package com.filemaker.jwpc.fmwp.internal.client;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxy;
import com.filemaker.jwpc.fmwp.internal.client.CWPClientProxyBlockingQueuePool;

public class CWPClientProxyPoolLiaison {
    private static ClientPool<CWPClientProxy> pool = null;

    public static CWPClientProxy getClient() {
        return (CWPClientProxy)PoolHolder.INSTANCE.getClient(6000);
    }

    public static void putClient(CWPClientProxy cWPClientProxy) {
        PoolHolder.INSTANCE.putClient((Object)cWPClientProxy);
    }

    private static ClientPool<CWPClientProxy> initPool() {
        pool = new CWPClientProxyBlockingQueuePool();
        return pool;
    }

    public static void shutdown() {
        if (pool != null) {
            pool.shutdown();
        }
    }

    private static class PoolHolder {
        private static final ClientPool<CWPClientProxy> INSTANCE = CWPClientProxyPoolLiaison.initPool();

        private PoolHolder() {
        }
    }
}

