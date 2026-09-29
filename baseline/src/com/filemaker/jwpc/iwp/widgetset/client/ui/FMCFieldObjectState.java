/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;

public class FMCFieldObjectState {
    protected final FMCFieldObject fieldObject;
    protected boolean hasTooltip = false;
    protected boolean waitForServerOnEnter = false;
    protected boolean waitForServerOnExit = false;
    protected boolean exitOnTab = false;
    protected boolean exitOnEnter = false;
    protected boolean exitOnReturn = false;
    protected boolean isNumberField = false;
    protected boolean hasObjectKeyTrigger = false;
    protected boolean isKeyStrokeEnabled = false;
    protected boolean hasLayoutKeyTrigger = false;

    public FMCFieldObjectState(FMCFieldObject fMCFieldObject) {
        this.fieldObject = fMCFieldObject;
    }
}

