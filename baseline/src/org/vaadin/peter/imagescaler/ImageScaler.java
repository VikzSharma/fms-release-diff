/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Resource
 *  com.vaadin.shared.communication.SharedState
 *  com.vaadin.ui.AbstractComponent
 */
package org.vaadin.peter.imagescaler;

import com.vaadin.server.Resource;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.AbstractComponent;
import org.vaadin.peter.imagescaler.client.ImageScalerState;

public class ImageScaler
extends AbstractComponent {
    private static final long serialVersionUID = 622245469298827150L;

    public ImageScaler() {
        this.setSizeFull();
        this.setRecalculateOnSizeChangeEnabled(true);
    }

    public void setImage(Resource resource, int n, int n2) {
        this.setResource("image_resource", resource);
        this.getState().setImageWidth(n);
        this.getState().setImageHeight(n2);
    }

    public void setRecalculateOnSizeChangeEnabled(boolean bl) {
        this.getState().setRecalculateOnSizeChangeEnabled(bl);
    }

    public boolean isRecalculateOnSizeChangeEnabled() {
        return this.getState().isRecalculateOnSizeChangeEnabled();
    }

    public Resource getImage() {
        return this.getResource("image_resource");
    }

    public int getImageWidth() {
        return this.getState().getImageWidth();
    }

    public int getImageHeight() {
        return this.getState().getImageHeight();
    }

    public Class<? extends SharedState> getStateType() {
        return ImageScalerState.class;
    }

    protected ImageScalerState getState() {
        return (ImageScalerState)super.getState();
    }
}

