/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Embedded
 */
package com.filemaker.jwpc.iwp.ui.layout.component.container;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImage;
import com.filemaker.jwpc.iwp.ui.layout.component.container.ContainerEmbedded;
import com.filemaker.jwpc.iwp.ui.layout.component.container.MediaEmbedded;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Embedded;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class ContainerContentFactory {
    public static final ThemeResource GENERIC_DOCUMENT_ICON = new ThemeResource("../runo/icons/32/document.png");
    public static final int GENERIC_DOCUMENT_ICON_SIZE = 32;
    private static final String MIME_TYPE_APPLICATION_OCTET_STREAM = "application/octet-stream";

    public static AbstractComponent createContainerContent(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes, BinaryData binaryData, AbstractComponent abstractComponent) {
        Object object = null;
        if (abstractComponent != null && abstractComponent instanceof ContainerEmbedded) {
            ContainerEmbedded containerEmbedded = (ContainerEmbedded)abstractComponent;
            containerEmbedded.setGenericContainerType(false);
        }
        if (ContainerContentFactory.isImage(binaryData)) {
            object = ContainerContentFactory.createContainerImage(objectMetaData, objectAttributes, binaryData);
        } else if (binaryData.getUrl() != null && binaryData.getUrl().length() > 0) {
            object = ContainerContentFactory.createRemoteContainerContents(objectMetaData, objectAttributes, binaryData, abstractComponent);
            if (object == null) {
                object = ContainerContentFactory.createGenericFileContainerContents(app, objectMetaData, objectAttributes, binaryData);
            }
        } else {
            object = ContainerContentFactory.createGenericFileContainerContents(app, objectMetaData, objectAttributes, binaryData);
        }
        return object;
    }

    private static ContainerEmbedded createGenericFileContainerContents(App app, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes, BinaryData binaryData) {
        ContainerEmbedded containerEmbedded = new ContainerEmbedded(objectMetaData, objectAttributes);
        if (binaryData.getName().length() > 0) {
            ThemeResource themeResource = GENERIC_DOCUMENT_ICON;
            String string = IWPUtilities.getFileExt(binaryData.getName());
            if (string != null && string.endsWith(">")) {
                string = string.substring(0, string.length() - 1);
            }
            if (Utilities.isValidText(string)) {
                if (string.equals("jpeg")) {
                    string = "jpg";
                }
                File file = app.getUI().getSession().getService().getBaseDirectory();
                File file2 = new File(file, "VAADIN/themes/default/images/document_icons/" + string + ".png");
                File file3 = new File(file, "VAADIN/themes/default/images/document_icons/" + string + "-48.png");
                File file4 = new File(file, "VAADIN/themes/default/images/document_icons/" + string + "-64.png");
                File file5 = new File(file, "VAADIN/themes/default/images/document_icons/" + string + "-128.png");
                if (file3.exists()) {
                    themeResource = new ThemeResource("images/document_icons/" + string + "-48.png");
                } else if (file4.exists()) {
                    themeResource = new ThemeResource("images/document_icons/" + string + "-64.png");
                } else if (file5.exists()) {
                    themeResource = new ThemeResource("images/document_icons/" + string + "-128.png");
                } else if (file2.exists()) {
                    themeResource = new ThemeResource("images/document_icons/" + string + ".png");
                }
            }
            containerEmbedded.setWidth("48px");
            containerEmbedded.setHeight("48px");
            containerEmbedded.setSource((Resource)themeResource);
            containerEmbedded.setCaption(binaryData.getName());
            if (AppServlet.isAriaCompliantControlEnabled()) {
                containerEmbedded.setAlternateText("");
            }
            containerEmbedded.setRole("document");
            containerEmbedded.setGenericContainerType(true);
        } else if (binaryData.getData().length > 0 && binaryData.getType().length() > 0 && binaryData.getType().equals("text/plain")) {
            String string = new String(binaryData.getData(), StandardCharsets.UTF_8);
            containerEmbedded.setCaption(string);
        }
        return containerEmbedded;
    }

    private static AbstractComponent createRemoteContainerContents(ObjectMetaData objectMetaData, ObjectAttributes objectAttributes, BinaryData binaryData, AbstractComponent abstractComponent) {
        AbstractComponent abstractComponent2 = null;
        if (binaryData.getMasterType() != null && binaryData.getMasterType().length() > 0 && !binaryData.getMasterType().equals(MIME_TYPE_APPLICATION_OCTET_STREAM) && (abstractComponent2 = ContainerContentFactory.createMediaComponent(binaryData, objectMetaData, IWPUtilities.constructMediaResource(binaryData))) != null) {
            abstractComponent2.setHeight("100%");
            abstractComponent2.setWidth("100%");
        }
        return abstractComponent2;
    }

    private static AbstractComponent createMediaComponent(BinaryData binaryData, ObjectMetaData objectMetaData, ExternalResource externalResource) {
        Embedded embedded = null;
        String string = binaryData.getType();
        String string2 = binaryData.getName();
        if (string == null || string.length() == 0) {
            string = IWPUtilities.getMimeTypeFromFilename(string2.toLowerCase());
        }
        if (IWPUtilities.isStreamingMedia(string) && binaryData.isFieldIsWebContainer()) {
            embedded = new MediaEmbedded(string, string2, externalResource, objectMetaData.isAutoPlayAV(), binaryData.getContentRectHeight() + "px", binaryData.getContentRectWidth() + "px");
        } else if (ContainerContentFactory.isBrowserSupportedImageFormat(string)) {
            Embedded embedded2 = new Embedded(null, (Resource)externalResource);
            embedded2.setType(1);
            if (AppServlet.isAriaCompliantControlEnabled()) {
                String string3 = IWPUtilities.toSafeAltText(string2);
                embedded2.setAlternateText(string3);
            }
            embedded = embedded2;
        }
        return embedded;
    }

    private static boolean isBrowserSupportedImageFormat(String string) {
        return string.equalsIgnoreCase("image/jpeg") || string.equalsIgnoreCase("image/png") || string.equalsIgnoreCase("image/gif") || string.equalsIgnoreCase("image/bmp");
    }

    private static AbstractComponent createContainerImage(ObjectMetaData objectMetaData, ObjectAttributes objectAttributes, BinaryData binaryData) {
        WDImage wDImage = new WDImage();
        if (binaryData.getImageHeight() > 0) {
            wDImage.setHeight(binaryData.getImageHeight() + "px");
        } else {
            wDImage.setHeight("100%");
        }
        if (binaryData.getImageWidth() > 0) {
            wDImage.setWidth(binaryData.getImageWidth() + "px");
        } else {
            wDImage.setWidth("100%");
        }
        if (AppServlet.isAriaCompliantControlEnabled()) {
            String string = IWPUtilities.toSafeAltText(binaryData.getName());
            wDImage.setAlternateText(string);
        }
        wDImage.setRole("img");
        IWPUtilities.updateImage((AbstractComponent)wDImage, binaryData, true, objectMetaData.isPreservePDFTransparency());
        return wDImage;
    }

    public static boolean isImage(BinaryData binaryData) {
        return binaryData != null && binaryData.getData() != null && binaryData.getData().length > 0 && ContainerContentFactory.isBrowserSupportedImageFormat(binaryData.getType());
    }
}

