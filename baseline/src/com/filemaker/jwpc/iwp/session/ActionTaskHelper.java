/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.VaadinSession
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.ActionResultHandler;
import com.filemaker.jwpc.iwp.action.ActionsCompleteHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.executor.Executors;
import com.filemaker.jwpc.iwp.session.ActionTask;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.log.JWPCLogger;
import com.vaadin.server.VaadinSession;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ActionTaskHelper {
    private static JWPCLogger logger = JWPCLogger.getLogger(ActionTaskHelper.class);
    private final App app;
    private final ConcurrentLinkedQueue<ActionTask> queuedTasks = new ConcurrentLinkedQueue();
    private boolean closeComplete = false;
    private String runningActionName;
    private boolean isRunning = false;

    protected ActionTaskHelper(App app) {
        this.app = app;
    }

    public void clearQueue() {
        this.queuedTasks.clear();
    }

    protected boolean available() {
        if (!this.isRunning) {
            this.isRunning = true;
            return true;
        }
        return false;
    }

    protected void onTaskCompleted(ActionTask actionTask) {
        if (logger.isDebugLoggingEnabled()) {
            logger.debug(String.format("onTaskComplete(ActionTask=%s)", actionTask));
        }
        this.log("Action task '" + actionTask.getName() + "' is completed.");
        if (actionTask.isOneOffExecution()) {
            this.scheduleQueuedGetterTasks(actionTask.getHandler());
        } else {
            this.performQueuedTask();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated
    protected void handleResult(App app, UIActionType uIActionType, ActionResultHandler actionResultHandler, Result result) {
        if (actionResultHandler == null) return;
        VaadinSession vaadinSession = app.getSession();
        if (vaadinSession != null) {
            vaadinSession.lock();
            boolean bl = false;
            try {
                if (this.app.getSession() != vaadinSession || this.app.isClosing()) return;
                bl = app.pendingPush.tryAcquire();
                actionResultHandler.onFinish(uIActionType, result);
                if (!bl) return;
                app.pushChanges();
                return;
            }
            finally {
                if (bl) {
                    app.pendingPush.release();
                }
                vaadinSession.unlock();
            }
        } else {
            if (IWPUtilities.isDebugMode()) {
                System.out.println("[Info] No session was available when the task " + String.valueOf((Object)uIActionType) + " was performed.");
            }
            actionResultHandler.onFinish(uIActionType, result);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void handleResult(App app, ActionResultGetterHandler actionResultGetterHandler, Object object) {
        if (actionResultGetterHandler != null) {
            if (app == null) {
                actionResultGetterHandler.onFinish(object);
            } else {
                VaadinSession vaadinSession = app.getSession();
                if (vaadinSession != null) {
                    vaadinSession.lock();
                    boolean bl = false;
                    try {
                        if (this.app.getSession() == vaadinSession && !this.app.isClosing() && !this.closeComplete) {
                            bl = app.pendingPush.tryAcquire();
                            actionResultGetterHandler.onFinish(object);
                            if (bl) {
                                app.pushChanges();
                            }
                        }
                    }
                    catch (NullPointerException nullPointerException) {
                        if (logger.isDebugLoggingEnabled()) {
                            nullPointerException.printStackTrace();
                            logger.debug("Exception calling ActionTaskHelper::handleResult()");
                        }
                    }
                    finally {
                        if (bl) {
                            app.pendingPush.release();
                        }
                        vaadinSession.unlock();
                    }
                }
            }
        }
    }

    protected void queue(ActionTask actionTask) {
        this.queuedTasks.add(actionTask);
        this.log("Action task '" + String.valueOf(actionTask) + "' is queued because currently '" + this.runningActionName + "' is running.");
    }

    protected void execute(ActionTask actionTask, ActionsCompleteHandler actionsCompleteHandler, boolean bl) {
        actionTask.setHandler(actionsCompleteHandler);
        actionTask.setOneOffExecution(bl);
        if (IWPUtilities.isDebugMode()) {
            this.log("Action task '" + String.valueOf(actionTask) + "' is running.");
        }
        if (!bl) {
            this.runningActionName = actionTask.getName();
        }
        if (logger.isDebugLoggingEnabled()) {
            logger.debug(String.format("execute(ActionTask=%s, ActionsCompleteHander=%s, oneOff=%s)", actionTask, actionsCompleteHandler, bl));
        }
        Executors.runSessionTask(actionTask);
    }

    private void performQueuedTask() {
        ActionTask actionTask = this.queuedTasks.poll();
        if (actionTask != null) {
            this.execute(actionTask, null, false);
        } else {
            this.isRunning = false;
        }
    }

    public void scheduleQueuedGetterTasks(ActionsCompleteHandler actionsCompleteHandler) {
        ActionTask actionTask = this.queuedTasks.poll();
        if (actionTask != null) {
            this.execute(actionTask, actionsCompleteHandler, true);
        } else if (actionsCompleteHandler != null) {
            actionsCompleteHandler.onComplete();
        }
    }

    public void setCloseComplete() {
        this.closeComplete = true;
        this.queuedTasks.clear();
    }

    protected void warn(String string) {
        if (IWPUtilities.isDebugMode()) {
            String string2 = "Requested action '" + string + "'is ignored because '" + this.runningActionName + "' is running and this action is not deferrable.";
            if (this.app.getDeveloperTools().isActionDebuggingSelected()) {
                this.app.getDeveloperTools().showUIActionsDebugging(this.app, "Warning: Action " + string + " ignored!", string2);
            }
        }
    }

    private void log(String string) {
        if (IWPUtilities.isDebugMode() && this.app != null && this.app.getDeveloperTools().isActionDebuggingSelected()) {
            this.app.getDeveloperTools().showUIActionsDebugging(this.app, null, string);
        }
    }
}

