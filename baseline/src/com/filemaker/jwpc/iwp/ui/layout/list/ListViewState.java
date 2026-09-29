/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.filemaker.jwpc.iwp.ui.layout.list.ListRow;

public final class ListViewState {
    private ListRow currentActiveRow;
    private boolean loading;
    private boolean initialLoad;

    public void cleanupMemory() {
        if (this.currentActiveRow != null) {
            this.currentActiveRow.cleanupMemory();
            this.currentActiveRow = null;
        }
    }

    public ListRow getCurrentActiveRow() {
        return this.currentActiveRow;
    }

    public void setCurrentActiveRow(ListRow listRow) {
        this.currentActiveRow = listRow;
    }

    public boolean isListLoading() {
        return this.loading;
    }

    public void setListLoading(boolean bl) {
        this.loading = bl;
    }

    public void setInitialLoad(boolean bl) {
        this.initialLoad = bl;
    }

    public boolean isInitialLoad() {
        return this.initialLoad;
    }
}

