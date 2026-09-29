/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TException
 *  org.apache.thrift.transport.TTransportException
 */
package com.filemaker.jwpc.iwp.session;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.service.ServiceClient;
import com.filemaker.jwpc.iwp.service.ServiceClientPoolLiaison;
import com.filemaker.jwpc.iwp.session.ActionTask;
import com.filemaker.jwpc.iwp.session.ActionTaskHelper;
import com.filemaker.jwpc.iwp.session.GetterActionTask;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.BinaryDataOptions;
import com.filemaker.jwpc.iwp.thrift.common.BrowserClientInfo;
import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.thrift.common.ContextResult;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.FieldSpec;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListData;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetResult;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemResult;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetResult;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.PartDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.PortalDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.PortalRowCount;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

public class SessionGetterActionTaskFactory {
    private final App app;
    private final Session session;

    public SessionGetterActionTaskFactory(App app, Session session) {
        this.app = app;
        this.session = session;
    }

    private ActionTaskHelper getActionTaskHelper() {
        return this.session.getActionTaskHelper();
    }

    public void shutDown() {
    }

    private ServiceClient getClient(int n) {
        return ServiceClientPoolLiaison.getClient(n);
    }

    private void onTaskCompleted(ActionTask actionTask, ServiceClient serviceClient) {
        this.getActionTaskHelper().onTaskCompleted(actionTask);
        if (serviceClient != null) {
            ServiceClientPoolLiaison.putClient(serviceClient);
        }
    }

    GetterActionTask openTask(final ActionResultGetterHandler actionResultGetterHandler, final int n, final Credentials credentials, final boolean bl, final int n2) {
        return new GetterActionTask(this, "open", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                ServiceClient serviceClient = ServiceClientPoolLiaison.getClient(6004);
                boolean bl2 = false;
                try {
                    if (this.app == null) {
                        ContextResult contextResult = serviceClient.getClient().openDatabaseWithLayout(n, credentials, bl, null, null, true, false, n2);
                        ServiceClientPoolLiaison.putClient(serviceClient);
                        bl2 = true;
                        this.this$0.getActionTaskHelper().handleResult(null, actionResultGetterHandler, contextResult);
                    } else {
                        BrowserClientInfo browserClientInfo = this.getApp().getBrowserInfoHandler().getBrowserClientInfo();
                        browserClientInfo.setRetinaDisplay(this.app.getRetinaDisplay());
                        ContextResult contextResult = serviceClient.getClient().openDatabaseWithLayout(n, credentials, bl, browserClientInfo, this.getApp().getURIHandler().getScriptInfo(), true, this.app.hasPasswordExpired(), n2);
                        ServiceClientPoolLiaison.putClient(serviceClient);
                        bl2 = true;
                        this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, contextResult);
                    }
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                    return;
                }
                catch (TTransportException tTransportException) {
                    try {
                        if (bl2) throw new AppRuntimeException(tTransportException);
                        serviceClient.setReset();
                        throw new AppRuntimeException(tTransportException);
                        catch (TException tException) {
                            if (bl2) throw new AppRuntimeException(tException);
                            serviceClient.setReset();
                            throw new AppRuntimeException(tException);
                        }
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getCurrentRowTask(final ActionResultGetterHandler actionResultGetterHandler, final boolean bl) {
        return new GetterActionTask(this, "getCurrentRow", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6902);
                boolean bl2 = false;
                try {
                    LayoutDataResult layoutDataResult = serviceClient.getClient().getCurrentRow(this.context, bl);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, layoutDataResult);
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getDataForCurrentPartTask(final ActionResultGetterHandler actionResultGetterHandler, final int n, final boolean bl) {
        return new GetterActionTask(this, "getDataForCurrentPart", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6903);
                boolean bl2 = false;
                try {
                    PartDataResult partDataResult = serviceClient.getClient().getDataForCurrentPart(this.context, n, bl);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, partDataResult);
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getListRowsTask(final ActionResultGetterHandler actionResultGetterHandler, final int n, final int n2, final boolean bl) {
        return new GetterActionTask(this, "getListRows", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6909);
                boolean bl2 = false;
                try {
                    LayoutDataResult layoutDataResult = serviceClient.getClient().getListRows(this.context, n, n2, bl);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, layoutDataResult);
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getPortalRowsCountTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final boolean bl, final int n, final int n2) {
        return new GetterActionTask(this, "getPortalRowsCount", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6911);
                boolean bl2 = false;
                try {
                    PortalRowCount portalRowCount = serviceClient.getClient().getPortalRowsCount(this.context, objectSpec, bl, n, n2);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, portalRowCount);
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getPortalRowsTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final int n, final int n2, final boolean bl) {
        return new GetterActionTask(this, "getPortalRows", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6912);
                boolean bl2 = false;
                try {
                    PortalDataResult portalDataResult = serviceClient.getClient().getPortalRows(this.context, objectSpec, n, n2, bl);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, portalDataResult.getPortalData());
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getValueListSubsetTask(final ActionResultGetterHandler actionResultGetterHandler, final ValueListSubsetRequest valueListSubsetRequest) {
        return new GetterActionTask(this, "getValueListSubset", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6913);
                boolean bl = false;
                try {
                    ValueListData valueListData = serviceClient.getClient().getValueListSubset(this.context, valueListSubsetRequest);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, valueListData);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getValueListSubsetsTask(final ActionResultGetterHandler actionResultGetterHandler, final List<ValueListSubsetRequest> list) {
        return new GetterActionTask(this, "getValueListSubsets", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6913);
                boolean bl = false;
                try {
                    List<ValueListSubsetResult> list2 = serviceClient.getClient().getValueListSubsets(this.context, list);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, list2);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getFilteredValueListSubset(final ActionResultGetterHandler actionResultGetterHandler, final FilteredValueListSubsetRequest filteredValueListSubsetRequest) {
        return new GetterActionTask(this, "getFilteredValueListSubset", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6906);
                boolean bl = false;
                try {
                    FilteredValueListData filteredValueListData = serviceClient.getClient().getFilteredValueListSubset(this.context, filteredValueListSubsetRequest);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, filteredValueListData);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getFilteredValueListSubset(final ActionResultGetterHandler actionResultGetterHandler, final List<FilteredValueListSubsetRequest> list) {
        return new GetterActionTask(this, "getFilteredValueListSubsets", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6906);
                boolean bl = false;
                try {
                    List<FilteredValueListSubsetResult> list2 = serviceClient.getClient().getFilteredValueListSubsets(this.context, list);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, list2);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getValueListItemByValue(final ActionResultGetterHandler actionResultGetterHandler, final ValueListItemRequest valueListItemRequest) {
        return new GetterActionTask(this, "getValueListItemByValue", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6914);
                boolean bl = false;
                try {
                    FilteredValueListData filteredValueListData = serviceClient.getClient().getValueListItemByValue(this.context, valueListItemRequest);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, filteredValueListData);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getValueListItemsByValues(final ActionResultGetterHandler actionResultGetterHandler, final List<ValueListItemRequest> list) {
        return new GetterActionTask(this, "getValueListItemsByValues", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6914);
                boolean bl = false;
                try {
                    List<ValueListItemResult> list2 = serviceClient.getClient().getValueListItemsByValues(this.context, list);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, list2);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getLayoutObjectsDataTask(final ActionResultGetterHandler actionResultGetterHandler, final int n, final int n2, final Set<Integer> set) {
        return new GetterActionTask(this, "getLayoutObjectsDataTask", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6907);
                boolean bl = false;
                try {
                    LayoutDataResult layoutDataResult = serviceClient.getClient().getLayoutObjectsData(this.context, n, n2, set);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, layoutDataResult.getLayoutData());
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getPortalLayoutObjectsDataTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final int n, final int n2, final boolean bl, final Set<Integer> set) {
        return new GetterActionTask(this, "getPortalLayoutObjectsDataTask", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6910);
                boolean bl2 = false;
                try {
                    PortalDataResult portalDataResult = serviceClient.getClient().getPortalLayoutObjectsData(this.context, objectSpec, n, n2, bl, set);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, portalDataResult.getPortalData());
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getLayoutObjectTooltipTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec) {
        return new GetterActionTask(this, "getLayoutObjectTooltip", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6908);
                boolean bl = false;
                try {
                    String string = serviceClient.getClient().getLayoutObjectTooltip(this.context, objectSpec);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, string);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getFieldObjectDataTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final FieldSpec fieldSpec, final BinaryDataOptions binaryDataOptions, final boolean bl) {
        return new GetterActionTask(this, "getFieldObjectData", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6905);
                boolean bl2 = false;
                try {
                    FieldObjectData fieldObjectData = serviceClient.getClient().getFieldObjectData(this.context, objectSpec, fieldSpec, binaryDataOptions, bl);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl2 = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, fieldObjectData);
                    this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl2) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl2 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getConditionalFormattingTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec) {
        return new GetterActionTask(this, "getConditionalFormatting", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6901);
                boolean bl = false;
                try {
                    CFObject cFObject = serviceClient.getClient().getConditionalFormatting(this.context, objectSpec);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, cFObject);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getSelectedPanelTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final int n) {
        return new GetterActionTask(this, "getSelectedPanel", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6912);
                boolean bl = false;
                try {
                    int n2 = serviceClient.getClient().getSelectedPanel(this.context, objectSpec, n);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, n2);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getTabWidthsAndStartPositionTask(final ActionResultGetterHandler actionResultGetterHandler, final ObjectSpec objectSpec, final Map<Integer, Integer> map, final int n, final int n2, final int n3) {
        return new GetterActionTask(this, "getTabWidthsAndStartPosition", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6920);
                boolean bl = false;
                try {
                    List<String> list = serviceClient.getClient().getTabWidthsAndStartPosition(this.context, objectSpec, map, n, n2, n3);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, list);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getDataForCurrentPopoverTask(final ActionResultGetterHandler actionResultGetterHandler, final int n, final int n2, final int n3) {
        return new GetterActionTask(this, "getDataForCurrentPopoverTask", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6904);
                boolean bl = false;
                try {
                    LayoutDataResult layoutDataResult = serviceClient.getClient().getDataForCurrentPopover(this.context, n, n2, n3);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl = true;
                    this.this$0.getActionTaskHelper().handleResult(this.getApp(), actionResultGetterHandler, layoutDataResult);
                    this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }

    GetterActionTask getActiveRowState(final boolean bl, final boolean bl2) {
        return new GetterActionTask(this, "updateActiveRowState", this.app, this.session){
            final /* synthetic */ SessionGetterActionTaskFactory this$0;
            {
                this.this$0 = sessionGetterActionTaskFactory;
                super(string, app, session);
            }

            @Override
            public void run() {
                ServiceClient serviceClient = this.this$0.getClient(6900);
                boolean bl3 = false;
                try {
                    serviceClient.getClient().getActiveRowState(this.context, bl, bl2);
                    ServiceClientPoolLiaison.putClient(serviceClient);
                    bl3 = true;
                    this.this$0.onTaskCompleted(this, bl3 ? null : serviceClient);
                }
                catch (TException tException) {
                    try {
                        if (!bl3) {
                            serviceClient.setReset();
                        }
                        throw new AppRuntimeException(tException);
                    }
                    catch (Throwable throwable) {
                        this.this$0.onTaskCompleted(this, bl3 ? null : serviceClient);
                        throw throwable;
                    }
                }
            }
        };
    }
}

