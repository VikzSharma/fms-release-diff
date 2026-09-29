/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;

public interface LayoutTextFieldObject
extends LayoutFieldObject {
    public void setTextValue(String var1);

    public void setTextValue(String var1, Boolean var2);

    public String getTextValue();

    public void setHideZeroesOn(boolean var1);

    public void performModify();

    public void cacheSelectionOnCommit();

    public void syncSelectionOnCommitFailure();
}

