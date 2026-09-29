/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.ui.Embedded
 */
package com.filemaker.jwpc.iwp.ui.layout.component.container;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.widgetset.client.state.ContainerEmbeddedState;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Embedded;

public class ContainerEmbedded
extends Embedded {
    private String fileName;
    private final ObjectMetaData metaData;
    private final ObjectAttributes attributes;
    private boolean genericContainerType = false;

    public ContainerEmbedded(ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.metaData = objectMetaData;
        this.attributes = objectAttributes;
    }

    public void setConnectorResource(String string, String string2) {
        ExternalResource externalResource = new ExternalResource(string, string2);
        this.setSource((Resource)externalResource);
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public ObjectMetaData getMetaData() {
        return this.metaData;
    }

    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    public boolean isGenericContainerType() {
        return this.genericContainerType;
    }

    public void setGenericContainerType(boolean bl) {
        this.genericContainerType = bl;
    }

    public ContainerEmbeddedState getState() {
        return (ContainerEmbeddedState)super.getState();
    }

    public void setRole(String string) {
        this.getState().role = string;
    }
}

