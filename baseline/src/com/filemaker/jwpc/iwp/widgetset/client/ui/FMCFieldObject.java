/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Element
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.google.gwt.user.client.Element;

public interface FMCFieldObject {
    public FMCFieldObjectState getState();

    public void removeActiveState();

    public void performTabFocus();

    public void prepareForExit();

    public void performNextOnServer();

    public void performPrevOnServer();

    public void performCommitOnServer(boolean var1);

    public boolean performBrowserResize(int var1, int var2);

    public Element getElement();

    public boolean hasUniqueId();

    public String getUniqueId();

    public void storeCurrentCursorPosition();

    public void performOnKeyDownOnServer(String var1, int var2, boolean var3);

    public void handleContextMenuOnServer(int var1, int var2);

    public void handleContextMenuCopy();

    public void handleContextMenuPaste(String var1);
}

