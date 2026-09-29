/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.client.obscuredtext;

import com.filemaker.fields.client.common.FMState;

public class ObscuredTextBoxState
extends FMState {
    public String text;

    public ObscuredTextBoxState() {
        this.primaryStyleName = "fm-obscuredtext";
        this.text = null;
    }
}

