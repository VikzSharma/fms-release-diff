/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.Table
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.AbstractBaseTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.AbstractBaseTableState;
import com.vaadin.v7.ui.Table;
import java.util.ArrayList;
import java.util.Collections;

public class AbstractBaseTable
extends Table {
    private TableEventCallback callback;

    public AbstractBaseTable() {
        this.registerServerRpc();
    }

    private void registerServerRpc() {
        AbstractBaseTableServerRpc abstractBaseTableServerRpc = new AbstractBaseTableServerRpc(){

            @Override
            public void onNavFocus(int n) {
                if (AbstractBaseTable.this.callback != null) {
                    AbstractBaseTable.this.callback.onNavFocus(n);
                }
            }

            @Override
            public void onNavSelect(int n) {
                if (AbstractBaseTable.this.callback != null) {
                    AbstractBaseTable.this.callback.onNavSelect(n);
                }
            }

            @Override
            public void onNavMove(int n, int n2) {
                if (AbstractBaseTable.this.callback != null) {
                    AbstractBaseTable.this.callback.onNavMove(n, n2);
                }
            }

            @Override
            public void syncAriaDone() {
                AbstractBaseTable.this.getState().shouldSyncAria = false;
            }
        };
        this.registerRpc(abstractBaseTableServerRpc);
    }

    public void registerTableEventCallback(TableEventCallback tableEventCallback) {
        this.callback = tableEventCallback;
    }

    public Object getIdByIndex(int n) {
        return super.getIdByIndex(n);
    }

    public void swapItems(int n, int n2) {
        ArrayList arrayList = new ArrayList(this.getItemIds());
        if (n >= 0 && n2 >= 0 && n < arrayList.size() && n2 < arrayList.size()) {
            Collections.swap(arrayList, n, n2);
            this.removeAllItems();
            this.addItems(arrayList);
        }
    }

    protected AbstractBaseTableState getState() {
        return (AbstractBaseTableState)super.getState();
    }

    public void syncAria() {
        this.getState().shouldSyncAria = true;
    }

    public static interface TableEventCallback {
        public void onNavFocus(int var1);

        public void onNavSelect(int var1);

        public void onNavMove(int var1, int var2);
    }
}

