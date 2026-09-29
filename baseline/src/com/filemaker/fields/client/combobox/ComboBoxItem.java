/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.client.combobox;

import java.io.Serializable;

public final class ComboBoxItem
implements Serializable {
    private String id;
    private String fieldValue;
    private String popupPresentation;

    public ComboBoxItem() {
    }

    public ComboBoxItem(String string, String string2, String string3) {
        this.id = string;
        this.fieldValue = string2;
        this.popupPresentation = string3;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(String string) {
        this.fieldValue = string;
    }

    public String getPopupPresentation() {
        return this.popupPresentation;
    }

    public void setPopupPresentation(String string) {
        this.popupPresentation = string;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof ComboBoxItem) {
            ComboBoxItem comboBoxItem = (ComboBoxItem)object;
            if (this.id != null) {
                return this.id.equals(comboBoxItem.id);
            }
            if (this.fieldValue != null) {
                return this.fieldValue.equals(comboBoxItem.fieldValue);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : this.fieldValue.hashCode();
    }
}

