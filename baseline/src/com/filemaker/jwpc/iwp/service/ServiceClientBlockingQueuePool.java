/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.service;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ServiceClientBlockingQueuePool
implements ClientPool<ServiceClient> {
    private static BlockingDeque<ServiceClient> pool;
    private static boolean bDebugLeak;

    public ServiceClientBlockingQueuePool() {
        if (!IWPConstants.WPE_CONFIG_INITIALIZED) {
            IWPUtilities.initConfigConstants();
        }
        pool = new LinkedBlockingDeque<ServiceClient>(IWPConstants.THRIFT_CLIENT_WORKER_COUNT);
        for (int i = 0; i < IWPConstants.THRIFT_CLIENT_WORKER_COUNT; ++i) {
            try {
                pool.put(new ServiceClient(true));
                continue;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        this.shutdown();
        super.finalize();
    }

    @Override
    public int availableClientCount() {
        return pool.size();
    }

    @Override
    public ServiceClient getClient(int n) {
        ServiceClient serviceClient = null;
        try {
            serviceClient = pool.take();
            if (bDebugLeak) {
                System.err.println("***-**-*** getClient:" + serviceClient.hashCode() + " dbxIdx:" + n + " available:" + pool.size());
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return serviceClient;
    }

    @Override
    public void putClient(ServiceClient serviceClient) {
        if (pool != null) {
            try {
                if (serviceClient.doesNeedReset()) {
                    serviceClient.closeClient();
                    this.closeOpenClients();
                    pool.putLast(serviceClient);
                } else {
                    pool.putFirst(serviceClient);
                }
                if (bDebugLeak) {
                    System.err.println("***-**-*** putClient:" + serviceClient.hashCode() + " available:" + pool.size());
                }
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    @Override
    public void shutdown() {
        if (!IWPConstants.WPE_CONFIG_INITIALIZED) {
            IWPUtilities.initConfigConstants();
        }
        ArrayList arrayList = new ArrayList(IWPConstants.THRIFT_CLIENT_WORKER_COUNT);
        pool.drainTo(arrayList);
        for (ServiceClient serviceClient : arrayList) {
            if (serviceClient == null) continue;
            serviceClient.closeClient();
        }
    }

    private void closeOpenClients() {
        ServiceClient serviceClient = null;
        ArrayList<ServiceClient> arrayList = new ArrayList<ServiceClient>();
        boolean bl = true;
        while ((serviceClient = pool.poll()) != null && serviceClient.isOpen()) {
            bl = false;
            serviceClient.closeClient();
            arrayList.add(serviceClient);
        }
        try {
            if (bl && serviceClient != null) {
                pool.putFirst(serviceClient);
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        if (bDebugLeak && arrayList.size() > 0) {
            System.err.println("***-**-*** Client Leaks from Exception count:" + arrayList.size());
        }
        try {
            for (ServiceClient serviceClient2 : arrayList) {
                pool.putLast(serviceClient2);
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    static {
        bDebugLeak = false;
    }
}

