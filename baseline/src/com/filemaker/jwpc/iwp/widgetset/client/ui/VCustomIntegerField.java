/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.user.client.Event
 *  com.vaadin.v7.client.ui.VTextField
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.LogUtilities;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.v7.client.ui.VTextField;

public class VCustomIntegerField
extends VTextField {
    private static final String INTEGER_CHARS = "0123456789";
    private int defaultValue = 0;
    private int minValue = 0;
    private boolean allowZero = true;

    public VCustomIntegerField() {
        this.addKeyPressHandler(new KeyPressHandler(){

            public void onKeyPress(KeyPressEvent keyPressEvent) {
                if (!VCustomIntegerField.INTEGER_CHARS.contains(String.valueOf(keyPressEvent.getCharCode()))) {
                    VCustomIntegerField.this.cancelKey();
                }
            }
        });
        this.sinkEvents(528384);
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case 524288: {
                event.stopPropagation();
                event.preventDefault();
                break;
            }
            case 4096: {
                super.setText(this.validateText(this.getText()));
                break;
            }
        }
    }

    private String validateText(String string) {
        int n = 0;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            string = "";
        }
        int n2 = n;
        if (string == null || string.isEmpty()) {
            n2 = this.defaultValue;
        } else if (n2 == 0 && !this.allowZero) {
            n2 = this.defaultValue;
        } else if (n2 < this.minValue) {
            n2 = this.minValue;
        }
        if (n2 != n) {
            string = String.valueOf(n2);
        }
        return string;
    }

    public void setText(String string) {
        String string2 = this.validateText(string);
        if (string != string2) {
            string = string2;
        }
        super.setText(string);
    }

    public void setFocus() {
        String string;
        String string2 = this.getText();
        if (string2 != (string = this.validateText(string2))) {
            super.setText(string);
        }
        this.getElement().focus();
        VCustomIntegerField.nativeSelect((Element)this.getElement());
    }

    private static native void nativeSelect(Element var0);

    public void setDefaultValue(int n) {
        this.defaultValue = n;
        this.minValue = n;
    }

    public void setMinValue(int n) {
        LogUtilities.warn("MinValue = " + n);
        this.minValue = n;
    }

    public void setAllowZero(boolean bl) {
        this.allowZero = bl;
    }
}

