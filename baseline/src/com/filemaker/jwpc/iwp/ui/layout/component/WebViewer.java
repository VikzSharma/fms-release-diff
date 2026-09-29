/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.AbstractComponentContainer
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.layout.FocusableLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerState;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

public class WebViewer
extends CssLayoutObject
implements FocusableLayoutObject,
HasGlassPane {
    private WDBrowserFrame browserFrame;
    protected AbstractComponentContainer selfComponent;
    protected GlassPaneHandler glassPaneHandler;
    private String cachedUrl;

    public WebViewer(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.initUI(layoutView);
        this.updateURL(objectMetaData.getSource());
    }

    private void initUI(LayoutView layoutView) {
        this.selfComponent = new LOWrapper(this, this.getMetaData().getPositionCss());
        LayoutObjectUtilities.setWidthAndHeight(layoutView.isClientSideAutoSizing(), this.metaData, (Component)this.selfComponent, null);
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)this.selfComponent, (AbstractComponent)this);
    }

    @Override
    public void cleanupMemory() {
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.cleanupMemory();
            this.glassPaneHandler = null;
        }
    }

    private WDBrowserFrame createBrowserFrame(String string) {
        String string2 = this.app.getAppView().getCurrentSessionID() + "_" + this.app.getLayoutDataModel().getLayoutName() + "_" + this.getMetaData().getObjectId();
        WDBrowserFrame wDBrowserFrame = new WDBrowserFrame(this.app, string, string2, this.getMetaData().allowJSCommunication());
        if (!this.allowGlassPaneActivation()) {
            wDBrowserFrame.addStyleName("v-browserframe-scrollable");
        }
        return wDBrowserFrame;
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        this.updateURL((String)object);
    }

    private void updateURL(String string) {
        string = this.processUrl(string);
        LayoutContainerState.LayoutRefreshState layoutRefreshState = this.app.getLayoutContainer().getContainerState().getLayoutRefreshState();
        if (!layoutRefreshState.isRefreshInProgress()) {
            this.app.removeCachedSetWebViewerUrl(this.attributes.getObjectSpec());
        } else {
            String string2 = this.app.getCachedSetWebViewerUrl(this.attributes.getObjectSpec());
            if (string2 != null) {
                string = string2;
            }
        }
        this.setSource(string);
    }

    private String processUrl(String object) {
        if (!this.app.isFindMode() || this.metaData.displayWebviewerContentInFindMode()) {
            if (Utilities.isEmptyString((String)object) || ((String)object).trim().equals("http://") || ((String)object).trim().equals("https://") || ((String)object).toLowerCase().contains("/fmi/webd")) {
                object = "";
            } else if (!((String)object).startsWith("data:") && !((String)object).toLowerCase().contains("://")) {
                object = "http://" + (String)object;
            } else if (((String)object).trim().startsWith("data:,")) {
                object = ((String)object).replace("data:,", "data:text/html,");
            }
        } else {
            object = "";
        }
        return object;
    }

    @Override
    public void onInactive() {
    }

    @Override
    public void onActive() {
        this.app.getActiveUIHandler().clearFocus();
    }

    @Override
    public void addCFStyle(String string) {
        this.selfComponent.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.selfComponent.removeStyleName(string);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        if (this.glassPaneHandler == null) {
            this.glassPaneHandler = new GlassPaneHandler(this, absoluteCssLayout);
        }
        this.glassPaneHandler.updateGlassPane();
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return this.metaData.isWebViewerReadOnly() || this.metaData.hasValidAndExecutableScript();
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        super.setHideConditionOn(bl);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.updateGlassPane();
        }
    }

    public void performWebScript(String string, String[] stringArray) {
        this.browserFrame.performWebScript(string, stringArray);
    }

    public WDBrowserFrame.PerformWebScriptResult getPerformWebScriptResult() {
        return this.browserFrame.getPerformWebScriptResult();
    }

    public WDBrowserFrame getFrame() {
        return this.browserFrame;
    }

    public void setWebViewer(Object object) {
        String string = this.processUrl((String)object);
        this.setSource(string);
        this.app.addCachedSetWebViewerUrl(this.attributes.getObjectSpec(), string);
    }

    private void setSource(String string) {
        if (!string.equals(this.cachedUrl)) {
            this.cachedUrl = string;
            if (this.browserFrame != null) {
                this.removeComponent((Component)this.browserFrame);
                this.browserFrame = null;
            }
        }
        if (this.browserFrame == null) {
            this.browserFrame = this.createBrowserFrame("");
            this.addComponent((Component)this.browserFrame);
        }
        this.browserFrame.setSource((Resource)new ExternalResource(string));
    }
}

