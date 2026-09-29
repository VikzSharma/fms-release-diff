/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.interfaces;

import com.filemaker.fields.interfaces.DateProvider;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.util.Date;
import java.util.Locale;

public interface DatePresenter {
    public void setValue(String var1);

    public String getValue();

    public void setDateProvider(DateProvider var1);

    public DateProvider getDateProvider();

    public Resolution getResolution();

    public void setResolution(Resolution var1);

    public void showCalendarPopup(Date var1);

    public void setRangeStart(Date var1);

    public Date getRangeStart();

    public void setRangeEnd(Date var1);

    public Date getRangeEnd();

    public Locale getLocale();
}

