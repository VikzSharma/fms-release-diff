/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.action.ActionResultHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.session.ActionTask;
import com.filemaker.jwpc.iwp.session.ActionTaskHelper;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.DateTime;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.KeystrokeEvent;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import org.apache.thrift.TException;

public class SessionActionTaskFactory {
    private final App app;
    private final Session session;

    public SessionActionTaskFactory(App app, Session session) {
        this.app = app;
        this.session = session;
    }

    private ActionTaskHelper getActionTaskHelper() {
        return this.session.getActionTaskHelper();
    }

    public void shutDown() {
    }

    private ServiceClient getClient() {
        return ServiceClientPoolLiaison.getClient(5700);
    }

    private void onTaskCompleted(ActionTask actionTask, ServiceClient serviceClient) {
        this.getActionTaskHelper().onTaskCompleted(actionTask);
        ServiceClientPoolLiaison.putClient(serviceClient);
    }

    ActionTask gotoLayoutTask(final String string) {
        return new ActionTask(this, this.app, this.session, "gotoLayout"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string3);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().gotoLayout(this.getSession().getCurrentContext(), string);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask gotoLayoutByIdTask(final int n) {
        return new ActionTask(this, this.app, this.session, "gotoLayoutById"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().gotoLayoutById(this.getSession().getCurrentContext(), n);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask enterFieldTask(final ObjectSpec objectSpec, final boolean bl) {
        return new ActionTask(this, this.app, this.session, "enterField"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().enterField(this.getSession().getCurrentContext(), objectSpec, bl);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask processClickTask(final ObjectSpec objectSpec, final boolean bl, final boolean bl2, final boolean bl3, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "processClick"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().processClick(this.getSession().getCurrentContext(), objectSpec, bl, bl2, bl3, n, n2);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask commitRecordTask(final boolean bl) {
        return new ActionTask(this, this.app, this.session, "commitRecord"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().commitRecord(this.getSession().getCurrentContext(), bl);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask gotoRowTask(final int n) {
        return new ActionTask(this, this.app, this.session, "gotoRow"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().gotoRow(this.getSession().getCurrentContext(), n);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    Thread.dumpStack();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask onUIActionTask(final Context context, final UIActionType uIActionType) {
        return new ActionTask(this, this.app, this.session, uIActionType.toString()){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().onAction(context, uIActionType);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask attemptSessionCloseTask(final Context context) {
        return new ActionTask(this, this.app, this.session, "attemptSessionClose"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().attemptLogout(context);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask modifyNonContainerFieldTask(final Context context, final FieldObjectData fieldObjectData, final boolean bl) {
        return new ActionTask(this, this.app, this.session, "modifyNonContainerField"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().modifyNonContainerField(context, fieldObjectData, bl);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask insertDateFromCalendarTask(final Context context, final ObjectSpec objectSpec, final DateTime dateTime) {
        return new ActionTask(this, this.app, this.session, "insertDateFromCalendar"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().insertDateFromCalendar(context, objectSpec, dateTime);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask insertDateTask(final Context context, final ObjectSpec objectSpec, final String string, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "insertDate"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string3);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().insertDate(context, objectSpec, string, n, n2);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask insertTimeTask(final Context context, final ObjectSpec objectSpec, final String string, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "insertTime"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string3);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().insertTime(context, objectSpec, string, n, n2);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask insertCurrentUsernameTask(final Context context, final ObjectSpec objectSpec, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "insertCurrentUsername"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().insertCurrentUsername(context, objectSpec, n, n2);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask clearFieldContentsTask(final Context context, final ObjectSpec objectSpec, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "clearFieldContents"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().clearFieldContents(context, objectSpec, n, n2);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask executeButtonScriptTask(final int n) {
        return new ActionTask(this, this.app, this.session, "executeScript"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().executeButtonScript(this.getSession().getCurrentContext(), n);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask executeScriptByIdTask(final int n, final int n2, final int n3) {
        return new ActionTask(this, this.app, this.session, "executeScriptById"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().executeScriptById(this.getSession().getCurrentContext(), n, n2, n3);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask executeScriptByNameTask(final String string, final String string2, final String string3) {
        return new ActionTask(this, this.app, this.session, "executeScriptByName"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string5);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().executeScriptByName(this.getSession().getCurrentContext(), string, string2, string3);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask quickFindTask(final String string) {
        return new ActionTask(this, this.app, this.session, "quickFind"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string3);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().quickFind(this.getSession().getCurrentContext(), string);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask switchTabsTask(final ActionResultHandler actionResultHandler, final ObjectSpec objectSpec) {
        return new ActionTask(this, this.app, this.session, "switchTabs"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    Result result = serviceClient.getClient().switchTabs(this.getSession().getCurrentContext(), objectSpec);
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), UIActionType.SWITCH_TABS, actionResultHandler, result);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask abortLongOperationTask() {
        return new ActionTask(this, this.app, this.session, "abortLongOperation"){

            @Override
            public void run() {
                ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(6002);
                try {
                    serviceClient.getClient().abortLongOperation(this.getSession().getCurrentContext());
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    ServiceClientPoolLiaison.putClient(serviceClient);
                }
            }
        };
    }

    ActionTask abortLongRunningScriptTask() {
        return new ActionTask(this, this.app, this.session, "abortLongRunningScript"){

            @Override
            public void run() {
                ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(6003);
                try {
                    serviceClient.getClient().abortLongRunningScript(this.getSession().getCurrentContext());
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    ServiceClientPoolLiaison.putClient(serviceClient);
                }
            }
        };
    }

    ActionTask insertUploadedFileIntoContainerTask(final String string, final boolean bl) {
        return new ActionTask(this, this.app, this.session, "insertUploadedFileIntoContainer"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string3);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().insertIntoContainer(this.getSession().getCurrentContext(), string, bl);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask browserResizedTask() {
        return new ActionTask(this.app, this.session, "browserResized"){

            @Override
            public void run() {
                ServiceClient serviceClient = SessionActionTaskFactory.this.getClient();
                try {
                    Dimensions dimensions = this.getApp().getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
                    serviceClient.getClient().browserResized(this.getSession().getCurrentContext(), dimensions);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    SessionActionTaskFactory.this.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask browserResizedWithActiveFieldTask(final FieldObjectData fieldObjectData) {
        return new ActionTask(this, this.app, this.session, "browserResizedWithActiveField"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    Dimensions dimensions = this.getApp().getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
                    serviceClient.getClient().browserResizedWithActiveField(this.getSession().getCurrentContext(), dimensions, fieldObjectData);
                }
                catch (TException tException) {
                    serviceClient.closeClient();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask clientStartProcessingTask(ActionResultHandler actionResultHandler) {
        return new ActionTask(this.app, this.session, "clientStartProcessing"){

            @Override
            public void run() {
                ServiceClient serviceClient = SessionActionTaskFactory.this.getClient();
                try {
                    serviceClient.getClient().clientStartProcessing(this.getSession().getCurrentContext());
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    SessionActionTaskFactory.this.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask clientDoneProcessingTask(ActionResultHandler actionResultHandler) {
        return new ActionTask(this.app, this.session, "clientDoneProcessing"){

            @Override
            public void run() {
                ServiceClient serviceClient = SessionActionTaskFactory.this.getClient();
                try {
                    serviceClient.getClient().clientDoneProcessing(this.getSession().getCurrentContext());
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    SessionActionTaskFactory.this.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask refreshWindowTask(final Context context, final int n, final int n2) {
        return new ActionTask(this, this.app, this.session, "refreshWindow"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    serviceClient.getClient().refreshWindow(context, n, n2);
                }
                catch (TException tException) {
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }

    ActionTask handleKeystrokeTask(final KeystrokeEvent keystrokeEvent, final ActionResultHandler actionResultHandler) {
        return new ActionTask(this, this.app, this.session, "handleKeystroke"){
            final /* synthetic */ SessionActionTaskFactory this$0;
            {
                this.this$0 = sessionActionTaskFactory;
                super(app, session, string);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient();
                try {
                    Result result = serviceClient.getClient().handleKeystroke(this.getSession().getCurrentContext(), keystrokeEvent);
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), UIActionType.HANDLE_KEY_STROKE, actionResultHandler, result);
                }
                catch (TException tException) {
                    serviceClient.setReset();
                    this.app.showCommunicationError();
                }
                finally {
                    this.this$0.onTaskCompleted(this, serviceClient);
                }
            }
        };
    }
}

