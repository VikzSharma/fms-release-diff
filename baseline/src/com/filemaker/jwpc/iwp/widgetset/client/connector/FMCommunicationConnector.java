/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.ComponentConnector
 *  com.vaadin.client.ConnectorMap
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.annotations.OnStateChange
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.ui.AbstractComponentConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.fields.client.common.FMWidget;
import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.css.FMCommunicationComponent;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMCommunicationState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCommunicationWidget;
import com.filemaker.jwpc.iwp.widgetset.client.ui.LogUtilities;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorMap;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import java.util.ArrayList;

@Connect(value=FMCommunicationComponent.class)
public class FMCommunicationConnector
extends AbstractComponentConnector {
    private ArrayList<FMCFieldObject> tabbableFieldObjects = new ArrayList();
    private FMCommunicationServerRpc rpc = (FMCommunicationServerRpc)RpcProxy.create(FMCommunicationServerRpc.class, (ServerConnector)this);
    private FMCFieldObject activeFieldObject = null;
    private ContentEditableDivTextBox textBoxToScrollIntoView = null;
    private int pendingClickX = 0;
    private int pendingClickY = 0;

    public FMCommunicationConnector() {
        this.getWidget().registerCommunicationServerRpc(this.rpc);
        this.registerRpc(FMCommunicationClientRpc.class, new FMCommunicationClientRpc(){

            @Override
            public void reset() {
                FMCommunicationConnector.this.tabbableFieldObjects.clear();
                FMCommunicationConnector.this.activeFieldObject = null;
                FMCommunicationConnector.this.textBoxToScrollIntoView = null;
                FMCommunicationConnector.this.pendingClickX = 0;
                FMCommunicationConnector.this.pendingClickY = 0;
            }

            @Override
            public void updateTabOrdering(ArrayList<String> arrayList) {
                FMCommunicationConnector.this.updateTabOrdering(arrayList);
            }

            @Override
            public void clearActiveField() {
                FMCommunicationConnector.this.setActiveFieldObject(null);
            }

            @Override
            public void performBrowserResize(int n, int n2) {
                boolean bl = false;
                if (FMCommunicationConnector.this.activeFieldObject != null) {
                    bl = FMCommunicationConnector.this.activeFieldObject.performBrowserResize(n, n2);
                }
                if (!bl) {
                    FMCommunicationConnector.this.rpc.performBrowserResize(n, n2);
                }
            }

            @Override
            public void enableLayoutTabOrder(boolean bl) {
                for (FMCFieldObject fMCFieldObject : FMCommunicationConnector.this.tabbableFieldObjects) {
                    if (!(fMCFieldObject instanceof FMWidget)) continue;
                    ((FMWidget)((Object)fMCFieldObject)).enableTabFocus(bl);
                }
            }
        });
        FMCUtilities.exportMethods();
        FMCInputUtilities.startGlobalPreview();
        this.initContextMenuClickCallback();
    }

    public void init() {
        super.init();
        FMCFieldEventManager.setAsCommunicationConnector(this);
    }

    public void onUnregister() {
        super.onUnregister();
        FMCFieldEventManager.removeCommunicationConnector(this);
    }

    public FMCommunicationWidget getWidget() {
        return (FMCommunicationWidget)super.getWidget();
    }

    public FMCommunicationState getState() {
        return (FMCommunicationState)super.getState();
    }

    @OnStateChange(value={"layoutLinks"})
    void updateLayoutLinks() {
        String string = this.getState().layoutLinks.cardLayoutLinkPath;
        if (string != null) {
            this.getWidget().updateCssLink("fm-ca-lc", string, false);
            String string2 = this.getState().layoutLinks.cardOverridesLinkPath;
            if (string2 != null) {
                this.getWidget().updateCssLink("fm-ca-oc", string2, true);
            } else {
                this.getWidget().removeCssLink("fm-ca-oc");
            }
        } else {
            this.getWidget().removeCssLink("fm-ca-lc");
            this.getWidget().removeCssLink("fm-ca-oc");
            String string3 = this.getState().layoutLinks.layoutLinkPath;
            if (string3 != null) {
                this.getWidget().updateCssLink("fm-lc", string3, false);
                String string4 = this.getState().layoutLinks.overridesLinkPath;
                if (string4 != null) {
                    this.getWidget().updateCssLink("fm-oc", string4, true);
                } else {
                    this.getWidget().removeCssLink("fm-oc");
                }
            } else {
                this.getWidget().removeCssLink("fm-lc");
                this.getWidget().removeCssLink("fm-oc");
            }
        }
    }

    public void removeActiveFieldObject(FMCFieldObject fMCFieldObject) {
        if (this.activeFieldObject == fMCFieldObject) {
            this.activeFieldObject = null;
            this.textBoxToScrollIntoView = null;
            this.pendingClickX = 0;
            this.pendingClickY = 0;
        }
    }

    public void setActiveFieldObject(FMCFieldObject fMCFieldObject) {
        if (this.activeFieldObject != fMCFieldObject) {
            if (!(this.activeFieldObject == null || !this.activeFieldObject.hasUniqueId() || fMCFieldObject != null && fMCFieldObject.hasUniqueId() && this.activeFieldObject.getUniqueId().equals(fMCFieldObject.getUniqueId()))) {
                this.activeFieldObject.removeActiveState();
            }
            this.activeFieldObject = fMCFieldObject;
        }
    }

    public void setTextBoxToScrollIntoView(ContentEditableDivTextBox contentEditableDivTextBox, int n, int n2) {
        this.textBoxToScrollIntoView = contentEditableDivTextBox;
        this.pendingClickX = n;
        this.pendingClickY = n2;
    }

    public ContentEditableDivTextBox getTextBoxToScrollIntoView() {
        return this.textBoxToScrollIntoView;
    }

    public int getPendingClickX() {
        return this.pendingClickX;
    }

    public int getPendingClickY() {
        return this.pendingClickY;
    }

    public void updateTabOrdering(ArrayList<String> arrayList) {
        this.tabbableFieldObjects.clear();
        ConnectorMap connectorMap = ConnectorMap.get((ApplicationConnection)this.getConnection());
        for (String string : arrayList) {
            Widget widget;
            ServerConnector serverConnector = connectorMap.getConnector(string);
            if (!(serverConnector instanceof ComponentConnector) || !((widget = ((ComponentConnector)serverConnector).getWidget()) instanceof FMCFieldObject)) continue;
            this.tabbableFieldObjects.add((FMCFieldObject)widget);
        }
    }

    public FMCFieldObject getNextTabbableField(FMCFieldObject fMCFieldObject) {
        FMCFieldObject fMCFieldObject2 = null;
        int n = this.tabbableFieldObjects.indexOf(fMCFieldObject);
        fMCFieldObject2 = n < this.tabbableFieldObjects.size() - 1 ? this.tabbableFieldObjects.get(n + 1) : this.tabbableFieldObjects.get(0);
        return fMCFieldObject2;
    }

    public FMCFieldObject getPrevTabbableField(FMCFieldObject fMCFieldObject) {
        FMCFieldObject fMCFieldObject2 = null;
        int n = this.tabbableFieldObjects.indexOf(fMCFieldObject);
        fMCFieldObject2 = n > 0 ? this.tabbableFieldObjects.get(n - 1) : this.tabbableFieldObjects.get(this.tabbableFieldObjects.size() - 1);
        return fMCFieldObject2;
    }

    public void printTabbableFieldObjects() {
        LogUtilities.log("CSSInjectorConnector.printTabbableFieldObjects()");
        StringBuilder stringBuilder = new StringBuilder(" Widgets elements: [");
        for (FMCFieldObject fMCFieldObject : this.tabbableFieldObjects) {
            stringBuilder.append("element id " + fMCFieldObject.getElement().getId() + ", ");
        }
        stringBuilder.append("]");
        LogUtilities.log(stringBuilder.toString());
    }

    public void setIsPlayingFullScreen(boolean bl) {
        this.rpc.setIsPlayingFullScreen(bl);
    }

    public FMCTextField getActiveTextField() {
        if (this.activeFieldObject != null && this.activeFieldObject instanceof FMCTextField) {
            return (FMCTextField)this.activeFieldObject;
        }
        return null;
    }

    private native void initContextMenuClickCallback();

    private void handleContextMenuCopy() {
        if (this.activeFieldObject != null) {
            this.activeFieldObject.handleContextMenuCopy();
        }
    }

    private void handleContextMenuPaste(String string) {
        if (this.activeFieldObject != null) {
            this.activeFieldObject.handleContextMenuPaste(string);
        }
    }
}

