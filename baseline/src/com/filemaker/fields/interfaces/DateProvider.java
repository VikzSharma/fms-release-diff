/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.interfaces;

import java.util.Date;

public interface DateProvider {
    public Date convertValueToDate(String var1);

    public void handlePopupSelection(Date var1);
}

