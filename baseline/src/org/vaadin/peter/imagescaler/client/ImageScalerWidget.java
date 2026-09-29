/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ApplicationConnection
 */
package org.vaadin.peter.imagescaler.client;

import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;

public class ImageScalerWidget
extends Widget {
    public static final String CLASSNAME = "v-imagescaler";
    protected String paintableId;
    protected ApplicationConnection client;
    private final Element root;
    private final Element image;
    private int imageWidth;
    private int imageHeight;

    public ImageScalerWidget() {
        this.sinkEvents(124);
        this.root = DOM.createDiv();
        this.root.setClassName(CLASSNAME);
        this.image = DOM.createImg();
        this.root.appendChild((Node)this.image);
        this.setElement(this.root);
    }

    public void setWidth(String string) {
        super.setWidth(string);
        if (this.isSizeSet()) {
            this.refreshSize();
        }
    }

    public void setHeight(String string) {
        super.setHeight(string);
        if (this.isSizeSet()) {
            this.refreshSize();
        }
    }

    void refreshSize() {
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"top", (String)"0px");
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"left", (String)"0px");
        if (this.isPhotoSmallerThanContainer()) {
            int n = this.root.getOffsetWidth();
            int n2 = this.root.getOffsetHeight();
            int n3 = (n - this.imageWidth) / 2;
            int n4 = (n2 - this.imageHeight) / 2;
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"top", (String)(n4 + "px"));
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"left", (String)(n3 + "px"));
            this.image.setPropertyString("width", Integer.toString(this.imageWidth));
            this.image.setPropertyString("height", Integer.toString(this.imageHeight));
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"width", (String)(this.imageWidth + "px"));
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)this.image, (String)"height", (String)(this.imageHeight + "px"));
        } else {
            float f = (float)this.imageWidth / (float)this.imageHeight;
            if (f > 1.0f) {
                this.scaleHorizontalImage(this.image, f, Math.min(this.root.getOffsetWidth(), this.imageWidth), Math.min(this.root.getOffsetHeight(), this.imageHeight));
            } else {
                this.scaleVerticalImage(this.image, f, Math.min(this.root.getOffsetWidth(), this.imageWidth), Math.min(this.root.getOffsetHeight(), this.imageHeight));
            }
        }
    }

    public void onBrowserEvent(Event event) {
        if (this.paintableId == null || this.client == null) {
            return;
        }
        switch (DOM.eventGetType((Event)event)) {
            case 4: {
                event.preventDefault();
            }
        }
    }

    private void scaleHorizontalImage(Element element, float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f2 / f;
        if (f5 > f3) {
            f4 = f3 * f;
            f5 = f4 / f;
            int n = (int)(((float)this.root.getOffsetWidth() - f4) / 2.0f) - 5;
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"left", (String)(n + "px"));
        } else {
            int n = (int)(((float)this.root.getOffsetHeight() - f2 / f) / 2.0f) - 5;
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"top", (String)(n + "px"));
        }
        DOM.setElementAttribute((com.google.gwt.dom.client.Element)element, (String)"width", (String)Integer.toString((int)f4));
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"width", (String)((int)f4 + "px"));
        DOM.setElementAttribute((com.google.gwt.dom.client.Element)element, (String)"height", (String)Integer.toString((int)f5));
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"height", (String)((int)f5 + "px"));
    }

    private void scaleVerticalImage(Element element, float f, float f2, float f3) {
        float f4 = f3 * f;
        float f5 = f3;
        if (f4 > f2) {
            f5 = f2 / f;
            f4 = f5 * f;
            int n = (int)(((float)this.root.getOffsetHeight() - f5) / 2.0f);
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"top", (String)(n + "px"));
        } else {
            int n = (int)(((float)this.root.getOffsetWidth() - f3 * f) / 2.0f);
            DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"left", (String)(n + "px"));
        }
        DOM.setElementAttribute((com.google.gwt.dom.client.Element)element, (String)"width", (String)Integer.toString((int)f4));
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"width", (String)((int)f4 + "px"));
        DOM.setElementAttribute((com.google.gwt.dom.client.Element)element, (String)"height", (String)Integer.toString((int)f5));
        DOM.setStyleAttribute((com.google.gwt.dom.client.Element)element, (String)"height", (String)((int)f5 + "px"));
    }

    private boolean isPhotoSmallerThanContainer() {
        return this.root.getOffsetWidth() > this.imageWidth && this.root.getOffsetHeight() > this.imageHeight;
    }

    private boolean isSizeSet() {
        return this.root.getOffsetWidth() != 0 && this.root.getOffsetHeight() != 0 && this.imageWidth != 0 && this.imageHeight != 0;
    }

    public void setImageURL(String string) {
        DOM.setImgSrc((com.google.gwt.dom.client.Element)this.image, (String)string);
    }

    public void setOriginalImageWidth(int n) {
        this.imageWidth = n;
    }

    public void setOriginalImageHeight(int n) {
        this.imageHeight = n;
    }
}

