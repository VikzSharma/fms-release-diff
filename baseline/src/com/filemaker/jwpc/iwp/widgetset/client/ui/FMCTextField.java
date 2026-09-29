/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;

public interface FMCTextField
extends FMCFieldObject {
    public String getText();

    public void setFocus(boolean var1);

    public int getCursorPos();

    public int getSelectionLength();

    public void setText(String var1);

    public void setCursorPos(int var1);

    public void setSelectionRange(int var1, int var2);

    public void startTabFocus();

    public void setEditable(boolean var1);

    public boolean flushTextChangeOnScroll();

    public void setPortalFocus();

    public void exitField();
}

