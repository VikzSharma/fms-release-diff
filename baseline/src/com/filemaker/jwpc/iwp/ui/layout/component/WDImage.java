/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.StreamResource$StreamSource
 *  com.vaadin.ui.Image
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.ui.layout.component.WDImageResource;
import com.filemaker.jwpc.iwp.widgetset.client.state.WDImageState;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class WDImage
extends Image {
    private String positionCss;

    public void setPositionCss(String string) {
        this.positionCss = string;
    }

    public String getPositionCss() {
        return this.positionCss;
    }

    public boolean isSameImage(BinaryData binaryData) {
        if (binaryData == null || binaryData.getData() == null) {
            return false;
        }
        WDImageResource wDImageResource = (WDImageResource)this.getSource();
        if (wDImageResource == null) {
            return false;
        }
        StreamResource.StreamSource streamSource = wDImageResource.getStreamSource();
        if (streamSource == null) {
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream)streamSource.getStream();
        if (byteArrayInputStream == null) {
            return false;
        }
        byteArrayInputStream.reset();
        int n = byteArrayInputStream.available();
        if (n != binaryData.getData().length) {
            return false;
        }
        try {
            byte[] byArray = new byte[n];
            byteArrayInputStream.read(byArray);
            if (Arrays.equals(byArray, binaryData.getData())) {
                return true;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return false;
    }

    public WDImageState getState() {
        return (WDImageState)super.getState();
    }

    public void setRole(String string) {
        this.getState().role = string;
    }
}

