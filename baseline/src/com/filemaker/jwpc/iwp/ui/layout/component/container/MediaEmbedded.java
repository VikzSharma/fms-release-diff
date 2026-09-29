/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.ClientConnector
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ResourceReference
 *  com.vaadin.ui.Embedded
 */
package com.filemaker.jwpc.iwp.ui.layout.component.container;

import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.MediaEmbeddedState;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ResourceReference;
import com.vaadin.ui.Embedded;

public class MediaEmbedded
extends Embedded {
    private static final long serialVersionUID = 1L;
    protected String height;
    protected String width;
    protected String filename;

    public MediaEmbedded(String string, String string2, ExternalResource externalResource, boolean bl, String string3, String string4) {
        super(null, (Resource)externalResource);
        this.setMimeType(string);
        this.updateBooleanState(MediaEmbeddedState.BooleanState.autoPlay, bl);
        this.height = this.normalizeSize(string3);
        this.width = this.normalizeSize(string4);
        this.filename = string2;
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(MediaEmbeddedState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateParameters();
    }

    private void updateBooleanState(MediaEmbeddedState.BooleanState booleanState, boolean bl) {
        this.getState().mebs = IWPUtilities.applyBooleanValue(this.getState().mebs, booleanState.ordinal(), bl);
    }

    private boolean getBooleanState(MediaEmbeddedState.BooleanState booleanState) {
        return IWPUtilities.getBooleanValue(this.getState().mebs, booleanState.ordinal());
    }

    private void updateParameters() {
        this.setParameter("autoplay", Boolean.toString(this.getBooleanState(MediaEmbeddedState.BooleanState.autoPlay)));
        this.setParameter("height", this.height);
        this.setParameter("width", this.width);
        if (this.filename != null && this.filename.length() > 0) {
            this.setParameter("filename", this.filename);
        }
        if (this.getSource() != null) {
            Resource resource = this.getSource();
            ClientConnector clientConnector = this.getUI().getConnectorTracker().getConnector(this.getConnectorId());
            this.getUI().getSession().getGlobalResourceHandler(true).register(resource, clientConnector);
            ResourceReference resourceReference = ResourceReference.create((Resource)this.getSource(), (ClientConnector)clientConnector, (String)"src");
            this.setParameter("src", resourceReference.getURL());
        }
        if (this.getMimeType() != null) {
            this.setParameter("mimetype", this.getMimeType());
        }
    }

    private String normalizeSize(String string) {
        if (string.endsWith("px")) {
            return string.substring(0, string.length() - 2);
        }
        return string;
    }

    public MediaEmbeddedState getState() {
        return (MediaEmbeddedState)super.getState();
    }
}

