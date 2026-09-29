/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.StringData;

public class StringDataUpdateParameters {
    private final StringData data;
    private final boolean disableListeners;
    private final boolean needsFormatting;
    private final DBAccessLevel access;
    private final String errorMessage;
    private final boolean hasError;
    private final boolean updateSelection;
    private final int selectionStart;
    private final int selectionEnd;
    private final boolean streamOn;

    public StringDataUpdateParameters(StringData stringData, DBAccessLevel dBAccessLevel, boolean bl, boolean bl2, String string, boolean bl3, boolean bl4, int n, int n2, boolean bl5) {
        this.data = stringData;
        this.disableListeners = bl;
        this.needsFormatting = bl2;
        this.access = dBAccessLevel;
        this.errorMessage = string;
        this.hasError = bl3;
        this.updateSelection = bl4;
        this.selectionStart = n;
        this.selectionEnd = n2;
        this.streamOn = bl5;
    }

    public StringData getData() {
        return this.data;
    }

    public boolean disableListeners() {
        return this.disableListeners;
    }

    public boolean needsFormatting() {
        return this.needsFormatting;
    }

    public DBAccessLevel getAccess() {
        return this.access;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public boolean updateSelection() {
        return this.updateSelection;
    }

    public int selectionStart() {
        return this.selectionStart;
    }

    public int selectionEnd() {
        return this.selectionEnd;
    }

    public boolean hasStreamOn() {
        return this.streamOn;
    }
}

