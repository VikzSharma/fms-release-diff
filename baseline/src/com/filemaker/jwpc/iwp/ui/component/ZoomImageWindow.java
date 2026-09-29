/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Embedded
 *  org.vaadin.peter.imagescaler.ImageScaler
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import org.vaadin.peter.imagescaler.ImageScaler;

public class ZoomImageWindow
extends Dialog {
    private static final long serialVersionUID = 862515365847162179L;
    private static final int MARGIN_SIZE = 18;
    private static final int HEADER_SIZE = 37;
    private static final int HEADER_SIZE_TOUCH = 45;
    private static final int HEIGHT_BUFFER = 10;

    public ZoomImageWindow(App app, Embedded embedded, String string, int n, int n2, int n3) {
        super(app, string);
        this.setSizeUndefined();
        if (this.isTouchUI()) {
            this.setHasWidthConstraint(false);
        }
        Dimensions dimensions = app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        int n4 = this.isTouchUI() ? 37 : 45;
        int n5 = dimensions.getHeight() - (36 + n4) - 10;
        int n6 = dimensions.getWidth() - 36;
        if (n > n5 || n2 > n6) {
            ImageScaler imageScaler = new ImageScaler();
            imageScaler.setImage(embedded.getSource(), n2, n);
            imageScaler.setSizeFull();
            int n7 = n;
            int n8 = n2;
            if (n7 > n5) {
                n7 = n5;
                n8 = (int)((float)n7 * (float)n2 / (float)n);
            }
            if (n8 > n6) {
                n8 = n6;
                n7 = (int)((float)n8 * (float)n / (float)n2);
            }
            imageScaler.setHeight((float)n7, Sizeable.Unit.PIXELS);
            imageScaler.setWidth((float)n8, Sizeable.Unit.PIXELS);
            if (AppServlet.isAriaCompliantControlEnabled()) {
                String string2 = IWPUtilities.toSafeAltText(string);
                String string3 = String.format("document.querySelector('.v-imagescaler img').setAttribute('alt', '%s');", string2);
                this.app.getPage().getJavaScript().execute(string3);
            }
            this.initContent((Component)imageScaler);
        } else {
            embedded.setHeight((float)n, Sizeable.Unit.PIXELS);
            embedded.setWidth((float)n2, Sizeable.Unit.PIXELS);
            if (AppServlet.isAriaCompliantControlEnabled()) {
                String string4 = IWPUtilities.toSafeAltText(string);
                embedded.setAlternateText(string4);
            }
            this.initContent((Component)embedded);
        }
    }
}

