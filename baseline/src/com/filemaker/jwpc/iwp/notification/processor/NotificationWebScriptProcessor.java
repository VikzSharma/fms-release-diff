/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.VaadinSession$State
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.notification.processor;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.notification.PerformWebScriptNotification;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.filemaker.jwpc.iwp.ui.layout.component.WebViewer;
import com.vaadin.server.VaadinSession;
import org.apache.thrift.TException;

public class NotificationWebScriptProcessor {
    private static int CHECK_MILLIS = 100;
    private static int MAX_MILLIS = 5000;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WDBrowserFrame.PerformWebScriptResult performWebScript(App app, PerformWebScriptNotification performWebScriptNotification) throws TException {
        WebViewer webViewer = null;
        WDBrowserFrame.PerformWebScriptResult performWebScriptResult = new WDBrowserFrame.PerformWebScriptResult(performWebScriptNotification.getMethodName(), false, "Client session not available", null);
        if (app != null) {
            Object object = app.getNotificationExecutorLock();
            synchronized (object) {
                block9: {
                    VaadinSession vaadinSession = app.getSession();
                    if (vaadinSession != null && vaadinSession.getState() == VaadinSession.State.OPEN) {
                        vaadinSession.lock();
                        try {
                            if (app.getSession() != vaadinSession || app.isClosing()) break block9;
                            for (LayoutObject layoutObject : app.getLayoutContainer().getCurrentView().getLayoutObjects()) {
                                if (!performWebScriptNotification.getObjectName().equals(layoutObject.getMetaData().getName()) || !LayoutObjectType.WEB_VIEWER.equals((Object)layoutObject.getMetaData().getType())) continue;
                                webViewer = (WebViewer)layoutObject;
                                webViewer.performWebScript(performWebScriptNotification.getMethodName(), performWebScriptNotification.getParameters().toArray(new String[0]));
                                break;
                            }
                        }
                        finally {
                            vaadinSession.unlock();
                        }
                    }
                }
                performWebScriptResult = webViewer == null ? new WDBrowserFrame.PerformWebScriptResult(performWebScriptNotification.getMethodName(), false, "Object not found", null) : (!this.waitForResponse(webViewer) ? new WDBrowserFrame.PerformWebScriptResult(performWebScriptNotification.getMethodName(), false, "Javascript timed out", null) : webViewer.getPerformWebScriptResult());
            }
        }
        return performWebScriptResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean waitForResponse(WebViewer webViewer) {
        boolean bl = false;
        WDBrowserFrame wDBrowserFrame = webViewer.getFrame();
        try {
            long l = System.currentTimeMillis();
            boolean bl2 = false;
            WDBrowserFrame wDBrowserFrame2 = wDBrowserFrame;
            synchronized (wDBrowserFrame2) {
                while (wDBrowserFrame.getPerformWebScriptResult() == null) {
                    boolean bl3 = bl2 = System.currentTimeMillis() - l >= (long)MAX_MILLIS;
                    if (bl2) break;
                    ((Object)((Object)wDBrowserFrame)).wait(CHECK_MILLIS);
                }
            }
            bl = !bl2 && wDBrowserFrame.getPerformWebScriptResult() != null;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return bl;
    }
}

