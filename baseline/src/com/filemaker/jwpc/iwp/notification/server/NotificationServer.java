/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TProcessor
 *  org.apache.thrift.TProcessorFactory
 *  org.apache.thrift.protocol.TBinaryProtocol$Factory
 *  org.apache.thrift.protocol.TProtocolFactory
 *  org.apache.thrift.server.TServer
 *  org.apache.thrift.server.TThreadedSelectorServer
 *  org.apache.thrift.server.TThreadedSelectorServer$Args
 *  org.apache.thrift.transport.TNonblockingServerSocket
 *  org.apache.thrift.transport.TNonblockingServerTransport
 *  org.apache.thrift.transport.TTransport
 *  org.apache.thrift.transport.TTransportException
 *  org.apache.thrift.transport.TTransportFactory
 *  org.apache.thrift.transport.layered.TFramedTransport$Factory
 */
package com.filemaker.jwpc.iwp.notification.server;

import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.notification.service.NotificationServiceImpl;
import com.filemaker.jwpc.iwp.thrift.service.IWPNotificationService;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.apache.thrift.transport.layered.TFramedTransport;

public final class NotificationServer {
    private NotificationServerThread serverThread;
    private TProcessorFactory processorfactory;

    private NotificationServer(TProcessorFactory tProcessorFactory) {
        this.processorfactory = tProcessorFactory;
    }

    public static NotificationServer getInstance() {
        return NotificationServerHolder.INSTANCE;
    }

    public synchronized void start() {
        if (this.serverThread != null && !this.serverThread.isRunning()) {
            return;
        }
        this.serverThread = new NotificationServerThread(this, this.processorfactory);
        this.serverThread.start();
    }

    public synchronized void stop() {
        if (this.serverThread != null) {
            this.serverThread.stopServer();
            this.serverThread.interrupt();
            this.serverThread = null;
        }
        Executors.shutdown();
        CacheManager.shutdown();
    }

    private static class NotificationServerHolder {
        private static final NotificationServer INSTANCE = new NotificationServer(null);

        private NotificationServerHolder() {
        }
    }

    public final class NotificationServerThread
    extends Thread {
        private boolean isRunning;
        private int port;
        private TNonblockingServerSocket serverTransport;
        private TServer server;
        private TProcessorFactory processorfactory;

        NotificationServerThread(NotificationServer notificationServer, TProcessorFactory tProcessorFactory) {
            this.processorfactory = tProcessorFactory;
            this.isRunning = false;
            this.setDaemon(true);
            this.setName("iwp-thrift-server");
            this.port = 8998;
        }

        void stopServer() {
            if (this.server != null) {
                this.server.stop();
                this.server = null;
            }
            this.serverTransport.interrupt();
            this.isRunning = false;
        }

        boolean isRunning() {
            return this.isRunning;
        }

        @Override
        public void run() {
            this.isRunning = false;
            int n = 32768000;
            try {
                this.serverTransport = new TNonblockingServerSocket(this.port, 0, n);
            }
            catch (TTransportException tTransportException) {
                tTransportException.printStackTrace();
                System.out.println("Tomcat is shutting down!");
                System.exit(0);
            }
            if (!IWPConstants.WPE_CONFIG_INITIALIZED) {
                IWPUtilities.initConfigConstants();
            }
            if (this.processorfactory == null) {
                this.processorfactory = new NotificationProcessorFactory(this);
            }
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args((TNonblockingServerTransport)this.serverTransport);
            args = (TThreadedSelectorServer.Args)args.processorFactory(this.processorfactory);
            args = (TThreadedSelectorServer.Args)args.protocolFactory((TProtocolFactory)new TBinaryProtocol.Factory());
            args = (TThreadedSelectorServer.Args)args.transportFactory((TTransportFactory)new TFramedTransport.Factory(n));
            args = args.workerThreads(IWPConstants.THRIFT_SERVER_WORKER_EXECUTOR_COUNT);
            args = args.selectorThreads(5);
            this.server = new TThreadedSelectorServer(args);
            this.isRunning = true;
            System.out.println("IWP notification server started on port " + this.port + "...");
            this.server.serve();
            System.out.println("IWP notification server stopped on port " + this.port + "...");
        }

        private class NotificationProcessorFactory
        extends TProcessorFactory {
            private TProcessor mProcessor = new IWPNotificationService.Processor<NotificationServiceImpl>(new NotificationServiceImpl());

            protected NotificationProcessorFactory(NotificationServerThread notificationServerThread) {
                super(null);
            }

            public TProcessor getProcessor(TTransport tTransport) {
                return this.mProcessor;
            }
        }
    }
}

