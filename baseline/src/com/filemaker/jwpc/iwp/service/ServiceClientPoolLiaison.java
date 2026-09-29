/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.service;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientBlockingQueuePool;

public class ServiceClientPoolLiaison {
    private static ClientPool<ServiceClient> pool;

    public static int availableClientCount() {
        return pool.availableClientCount();
    }

    public static ServiceClient getClient(int n) {
        return pool.getClient(n);
    }

    public static void putClient(ServiceClient serviceClient) {
        pool.putClient(serviceClient);
    }

    private static void initPool() {
        pool = new ServiceClientBlockingQueuePool();
        Service.getInstance().onJwpcStart();
    }

    public static void shutdown() {
        pool.shutdown();
    }

    static {
        ServiceClientPoolLiaison.initPool();
    }
}

