/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Item
 *  org.vaadin.addons.lazyquerycontainer.Query
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.ui.layout.TableLoadCompleteHandler;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractTableState;
import com.vaadin.v7.data.Item;
import java.util.List;
import org.vaadin.addons.lazyquerycontainer.Query;

public abstract class AbstractTable
extends AbstractBaseTable
implements Query {
    private int totalRows;

    public int size() {
        return this.totalRows;
    }

    public void setSize(int n) {
        this.totalRows = n;
    }

    public Item constructItem() {
        throw new UnsupportedOperationException();
    }

    public boolean deleteAllItems() {
        return true;
    }

    public void saveItems(List<Item> list, List<Item> list2, List<Item> list3) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void makeRowVisible(int n, boolean bl, TableLoadCompleteHandler tableLoadCompleteHandler) {
        try {
            if (!bl) {
                this.setCurrentPageFirstItemIndex(n);
            }
            this.select(n);
        }
        finally {
            if (tableLoadCompleteHandler != null) {
                tableLoadCompleteHandler.loadComplete();
            }
        }
    }

    public void makeRowVisible(int n, TableLoadCompleteHandler tableLoadCompleteHandler) {
        this.makeRowVisible(n, tableLoadCompleteHandler, false);
    }

    public void makeRowVisible(int n, TableLoadCompleteHandler tableLoadCompleteHandler, boolean bl) {
        boolean bl2 = this.isRowVisible(n);
        if (bl) {
            bl2 = false;
        }
        this.makeRowVisible(n - 1, bl2, tableLoadCompleteHandler);
        if (!bl2) {
            this.refreshRenderedCells();
        }
    }

    protected boolean isRowVisible(int n) {
        boolean bl = false;
        int n2 = n;
        int n3 = this.getCurrentPageFirstItemIndex() + 1;
        if (this.getHasPartialFirstRowInViewPort() && n2 == n3 - 1) {
            bl = true;
        } else {
            int n4 = n3;
            if (this.getPageLength() > 1) {
                n4 = n4 + this.getPageLength() - 1;
            }
            bl = n2 >= n3 && n2 <= n4;
        }
        return bl;
    }

    @Override
    public AbstractTableState getState() {
        return (AbstractTableState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(AbstractTableState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
    }

    private void updateBooleanState(AbstractTableState.BooleanState booleanState, boolean bl) {
        this.getState().atbs = IWPUtilities.applyBooleanValue(this.getState().atbs, booleanState.ordinal(), bl);
    }
}

