/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.interfaces;

import com.filemaker.fields.FMDateField;
import com.filemaker.fields.interfaces.PopupDateFieldActionHandler;

public class DefaultPopupDateFieldActionHandler
implements PopupDateFieldActionHandler {
    @Override
    public void onCalendarPopupClicked(FMDateField fMDateField, String string) {
        if (fMDateField.isCalendarPopupShown()) {
            fMDateField.hideCalendarPopup();
        } else if (fMDateField.isEnabled() && !fMDateField.isReadOnly()) {
            fMDateField.onIconClicked(string);
        }
    }
}

