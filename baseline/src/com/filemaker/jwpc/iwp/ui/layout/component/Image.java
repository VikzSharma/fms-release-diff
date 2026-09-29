/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage2;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public class Image
extends CssLayoutObject
implements HasGlassPane {
    private String fileName;
    private int contentLayoutWidth = 0;
    private int contentLayoutHeight = 0;
    protected AbstractComponent selfComponent;
    private AbsoluteCssLayout imageWrapper;
    private WDImage image;
    private WDImage2 embedded_image;
    protected GlassPaneHandler glassPaneHandler;

    public Image(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.contentLayoutHeight = objectMetaData.getHeightAsInt();
        this.contentLayoutWidth = objectMetaData.getWidthAsInt();
        this.initUI();
    }

    protected void initUI() {
        this.selfComponent = new LOWrapper(this, this.getMetaData().getPositionCss());
        this.selfComponent.setWidth(this.getMetaData().getWidth());
        this.selfComponent.setHeight(this.getMetaData().getHeight());
        this.setSizeFull();
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, (AbstractComponent)this);
    }

    @Override
    public void cleanupMemory() {
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.cleanupMemory();
            this.glassPaneHandler = null;
        }
        this.image = null;
        this.embedded_image = null;
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        this.updateData(object);
    }

    private void updateData(Object object) {
        BinaryData binaryData = (BinaryData)object;
        if (binaryData != null) {
            String string = binaryData.getName();
            LayoutObjectType layoutObjectType = this.getMetaData().getType();
            if (layoutObjectType == LayoutObjectType.CHART) {
                if (this.image != null && !this.image.getId().equals(string)) {
                    if (this.imageWrapper != null) {
                        this.imageWrapper.removeComponent((Component)this.image);
                    }
                    this.image = null;
                    this.markAsDirty();
                }
                if (this.image == null && string != null && string.length() > 0) {
                    if (binaryData != null && binaryData.getContentRectHeight() > 0 && binaryData.getContentRectWidth() > 0) {
                        this.contentLayoutHeight = binaryData.getContentRectHeight();
                        this.contentLayoutWidth = binaryData.getContentRectWidth();
                    }
                    this.image = Image.createEmbeddedImage(this.getMetaData(), this.getAttributes(), binaryData);
                    this.image.setId(string);
                    Object object2 = IWPUtilities.computeComponentPositioningCSS(this.getMetaData(), this.contentLayoutWidth, this.contentLayoutHeight, (AbstractComponent)this.image);
                    object2 = (String)object2 + "position:absolute;";
                    this.image.setPositionCss((String)object2);
                    if (this.imageWrapper == null) {
                        this.imageWrapper = new AbsoluteCssLayout(true);
                        this.imageWrapper.setSizeFull();
                        this.addComponent((Component)this.imageWrapper);
                    }
                    this.imageWrapper.removeAllComponents();
                    this.imageWrapper.addComponent((Component)this.image);
                    this.markAsDirty();
                }
            } else if (string != null && string.length() > 0) {
                String string2 = IWPUtilities.getImageCacheName(string, binaryData.getImageWidth(), binaryData.getImageHeight());
                if (!this.app.containsKeyInImageMap(string2)) {
                    WDImage wDImage = Image.createEmbeddedImage(this.getMetaData(), this.getAttributes(), binaryData);
                    wDImage.setId(string2);
                    this.app.addToImageMap(string2, wDImage);
                }
                try {
                    if (this.imageWrapper != null && this.imageWrapper.getComponentCount() > 0) {
                        if (this.embedded_image != null) {
                            this.embedded_image.setWidth(binaryData.getImageWidth() + "px");
                            this.embedded_image.setHeight(binaryData.getImageHeight() + "px");
                            this.embedded_image.setMimeType(binaryData.getDisplayType());
                        }
                        return;
                    }
                    if (binaryData != null && binaryData.getContentRectHeight() > 0 && binaryData.getContentRectWidth() > 0) {
                        this.contentLayoutHeight = binaryData.getContentRectHeight();
                        this.contentLayoutWidth = binaryData.getContentRectWidth();
                    }
                    int n = this.app.getUIId();
                    String string3 = this.app.getFromImageMap(string2).getConnectorId();
                    String string4 = binaryData.getDisplayType();
                    String string5 = IWPUtilities.getResourceConnectorString(this.app.need_webd_VirtualDir(), n, string3, string2);
                    this.embedded_image = new WDImage2(string5, string4);
                    this.embedded_image.setWidth(binaryData.getImageWidth() + "px");
                    this.embedded_image.setHeight(binaryData.getImageHeight() + "px");
                    Object object3 = IWPUtilities.computeComponentPositioningCSS(this.getMetaData(), this.contentLayoutWidth, this.contentLayoutHeight, (AbstractComponent)this.embedded_image);
                    object3 = (String)object3 + "position:absolute;";
                    this.embedded_image.setPositionCss((String)object3);
                    if (AppServlet.isAriaCompliantControlEnabled()) {
                        String string6 = IWPUtilities.toSafeAltText(string);
                        this.embedded_image.setAlternateText(string6);
                    }
                    if (this.imageWrapper == null) {
                        this.imageWrapper = new AbsoluteCssLayout(true);
                        this.imageWrapper.setSizeFull();
                        this.addComponent((Component)this.imageWrapper);
                    }
                    this.imageWrapper.removeAllComponents();
                    this.imageWrapper.addComponent((Component)this.embedded_image);
                    this.markAsDirty();
                }
                catch (Exception exception) {
                    if (IWPUtilities.isDebugMode()) {
                        System.out.println("**** exp:" + exception.getMessage());
                    }
                }
            }
        } else if (IWPUtilities.isDebugMode()) {
            System.out.println("**** binData is null! ****");
        }
    }

    private static WDImage createEmbeddedImage(ObjectMetaData objectMetaData, ObjectAttributes objectAttributes, BinaryData binaryData) {
        WDImage wDImage = new WDImage();
        wDImage.setHeight("100%");
        wDImage.setWidth("100%");
        boolean bl = true;
        if (objectMetaData.getType() == LayoutObjectType.IMAGE) {
            if (binaryData.getImageHeight() > 0) {
                wDImage.setHeight(binaryData.getImageHeight() + "px");
            }
            if (binaryData.getImageWidth() > 0) {
                wDImage.setWidth(binaryData.getImageWidth() + "px");
            }
            bl = false;
        }
        IWPUtilities.updateImage((AbstractComponent)wDImage, binaryData, bl, objectMetaData.isPreservePDFTransparency());
        return wDImage;
    }

    @Override
    public void registerToolTip(String string) {
        if (this.image != null) {
            this.image.setDescription(string, ContentMode.HTML);
        } else if (this.embedded_image != null) {
            this.embedded_image.setDescription(string, ContentMode.HTML);
        }
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
        return !this.getMetaData().hasValidAndExecutableScript();
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        super.setHideConditionOn(bl);
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.updateGlassPane();
        }
    }
}

