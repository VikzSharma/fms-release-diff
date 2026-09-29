/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.AbstractComponentState
 */
package org.vaadin.peter.imagescaler.client;

import com.vaadin.shared.AbstractComponentState;

public class ImageScalerState
extends AbstractComponentState {
    private static final long serialVersionUID = 1955253345689337996L;
    public static final String IMAGE_RESOURCE = "image_resource";
    private int imageWidth;
    private int imageHeight;
    private boolean recalculateOnSizeChange;

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int n) {
        this.imageWidth = n;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int n) {
        this.imageHeight = n;
    }

    public void setRecalculateOnSizeChangeEnabled(boolean bl) {
        this.recalculateOnSizeChange = bl;
    }

    public boolean isRecalculateOnSizeChangeEnabled() {
        return this.recalculateOnSizeChange;
    }
}

