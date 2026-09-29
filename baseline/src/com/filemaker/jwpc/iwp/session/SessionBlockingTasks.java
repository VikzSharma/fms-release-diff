/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.ModifyFieldObjectResult;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import org.apache.thrift.TException;

public final class SessionBlockingTasks {
    private final App app;
    private boolean blockingActionRunning = false;
    private static final ModifyFieldObjectResult OK_ERROR_RESULT = new ModifyFieldObjectResult();

    public SessionBlockingTasks(App app) {
        this.app = app;
    }

    public void close() {
    }

    public boolean isBlockingActionRunning() {
        return this.blockingActionRunning;
    }

    public IWPError enterContainerObject(Context context, ObjectSpec objectSpec, boolean bl) throws AppRuntimeException {
        IWPError iWPError;
        ServiceClient serviceClient = null;
        boolean bl2 = false;
        try {
            this.blockingActionRunning = true;
            serviceClient = ServiceClientPoolLiaison.getClient(5800);
            Result result = serviceClient.getClient().enterContainerObject(context, objectSpec, bl);
            ServiceClientPoolLiaison.putClient(serviceClient);
            bl2 = true;
            iWPError = result.getError();
            this.app.getMessenger().showDebugMessage(iWPError);
        }
        catch (TException tException) {
            if (serviceClient != null && !bl2) {
                serviceClient.setReset();
            }
            throw new AppRuntimeException(tException);
        }
        finally {
            this.blockingActionRunning = false;
            if (serviceClient != null && !bl2) {
                ServiceClientPoolLiaison.putClient(serviceClient);
            }
        }
        return iWPError;
    }

    static {
        Result result = new Result();
        result.setError(new IWPError());
        OK_ERROR_RESULT.setResult(result);
    }
}

