/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.service;

import com.filemaker.jwpc.common.ClientPool;
import com.filemaker.jwpc.iwp.service.ServiceClient;

public class ServiceClientFaucet
implements ClientPool<ServiceClient> {
    @Override
    public int availableClientCount() {
        return 1;
    }

    @Override
    public ServiceClient getClient(int n) {
        try {
            return new ServiceClient();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void putClient(ServiceClient serviceClient) {
        serviceClient.closeClient();
    }

    @Override
    public void shutdown() {
    }
}

