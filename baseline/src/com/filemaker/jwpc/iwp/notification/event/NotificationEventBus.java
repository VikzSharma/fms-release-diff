/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.VaadinSession$State
 */
package com.filemaker.jwpc.iwp.notification.event;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.notification.event.NotificationEventCommand;
import com.filemaker.jwpc.log.JWPCLogger;
import com.vaadin.server.VaadinSession;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NotificationEventBus
implements Runnable {
    private final ConcurrentLinkedQueue<NotificationEventCommand> queue = new ConcurrentLinkedQueue();
    private final App app;
    private AtomicBoolean executing = new AtomicBoolean(false);
    private static JWPCLogger logger = JWPCLogger.getLogger(NotificationEventBus.class);

    public NotificationEventBus(App app) {
        this.app = app;
    }

    public void schedule(NotificationEventCommand notificationEventCommand) {
        if (notificationEventCommand != null) {
            this.queue.add(notificationEventCommand);
        }
        if (this.executing.compareAndSet(false, true)) {
            if (logger.isDebugLoggingEnabled()) {
                logger.debug(String.format("schedule(NotificationEventCommand=%s)", notificationEventCommand));
            }
            Executors.runNotificationTask(this);
        }
    }

    public void process(NotificationEventCommand notificationEventCommand) {
        while (!this.queue.isEmpty()) {
            Thread.yield();
        }
        this.executeCommand(notificationEventCommand);
    }

    @Override
    public void run() {
        NotificationEventCommand notificationEventCommand = null;
        while (true) {
            if (this.queue.isEmpty()) break;
            notificationEventCommand = (NotificationEventCommand)this.queue.remove();
            if (notificationEventCommand == null) continue;
            this.executeCommand(notificationEventCommand);
        }
        this.executing.getAndSet(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void executeCommand(NotificationEventCommand notificationEventCommand) {
        VaadinSession vaadinSession = this.app.getSession();
        if (vaadinSession != null && vaadinSession.getState() == VaadinSession.State.OPEN) {
            vaadinSession.lock();
            try {
                if (this.app.getSession() != vaadinSession || this.app.isClosing()) return;
                logger.debug(String.format("executeCommand(NotificationEventCommand=%s)", notificationEventCommand));
                notificationEventCommand.execute();
                return;
            }
            finally {
                vaadinSession.unlock();
            }
        } else {
            logger.warn(String.format("There is no valid session for this app instance %s The event %s will be ignored", new Object[]{this.app, notificationEventCommand.getEvent().getType()}));
        }
    }

    public void clear() {
        this.executing.getAndSet(false);
        this.queue.clear();
    }
}

