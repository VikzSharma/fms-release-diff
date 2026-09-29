/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.executor;

import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Executors {
    private static ThreadPoolExecutor notificationExecutor;
    private static ExecutorService nonBlockingSessionExecutor;
    private static ThreadPoolExecutor fixedExec;

    public static void runNotificationTask(Runnable runnable) {
        notificationExecutor.execute(runnable);
    }

    public static void runSessionTask(Runnable runnable) {
        nonBlockingSessionExecutor.execute(runnable);
    }

    public static void runTask(Runnable runnable) {
        fixedExec.execute(runnable);
    }

    public static final void shutdown() {
        notificationExecutor.shutdown();
        notificationExecutor = null;
        nonBlockingSessionExecutor.shutdown();
        nonBlockingSessionExecutor = null;
        fixedExec.shutdown();
        fixedExec = null;
    }

    static {
        if (!IWPConstants.WPE_CONFIG_INITIALIZED) {
            IWPUtilities.initConfigConstants();
        }
        int n = IWPConstants.THRIFT_SERVER_WORKER_MAX_COUNT;
        notificationExecutor = new ThreadPoolExecutor(10, n, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), java.util.concurrent.Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        notificationExecutor.allowCoreThreadTimeOut(true);
        nonBlockingSessionExecutor = java.util.concurrent.Executors.newCachedThreadPool();
        fixedExec = new ThreadPoolExecutor(10, n, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), java.util.concurrent.Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        fixedExec.allowCoreThreadTimeOut(true);
    }
}

