/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import java.io.Serializable;

public class ValueListItem
implements Serializable {
    private String stored;
    private String displayed;

    public ValueListItem(String string, String string2) {
        this.stored = string;
        this.displayed = string2;
    }

    public String getStored() {
        return this.stored;
    }

    public void setStored(String string) {
        this.stored = string;
    }

    public String getDisplayed() {
        return this.displayed;
    }

    public void setDisplayed(String string) {
        this.displayed = string;
    }

    public String toString() {
        return this.displayed;
    }
}

