/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

public class PortalState {
    private boolean isValid = false;
    private int portalRowCount = 0;
    private boolean hasNewPortalRow = false;

    public void setValid(boolean bl) {
        this.isValid = bl;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setPortalRowCount(int n) {
        this.portalRowCount = n;
    }

    public int getPortalRowCount() {
        return this.portalRowCount;
    }

    public void setNewPortalRow(boolean bl) {
        this.hasNewPortalRow = bl;
    }

    public boolean hasNewPortalRow() {
        return this.hasNewPortalRow;
    }
}

