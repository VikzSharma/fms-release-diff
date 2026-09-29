/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.ui.Table$ColumnHeaderMode
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.widgetset.client.state.MultiColumnListSelectTableState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;

public class MultiColumnListSelect
extends VerticalLayout {
    private static final long serialVersionUID = 1L;
    private static final Object SELECTED_PROPERTY = "selected";
    private final MultiColumnListSelectTable table = new MultiColumnListSelectTable();
    private SelectionChangeCallback callback;

    public MultiColumnListSelect(String string) {
        this(string, null);
    }

    public MultiColumnListSelect(String string, Container container) {
        this.table.setStyleName("iwp-twinlistselect");
        if (Utilities.isValidText(string)) {
            this.table.setCaption(string);
        }
        if (container != null) {
            this.table.setContainerDataSource(container);
        }
        this.table.setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
        this.table.setSelectable(true);
        this.table.setMultiSelect(false);
        this.table.setNullSelectionAllowed(true);
        this.table.setImmediate(true);
        this.table.setSizeFull();
        this.addComponent((Component)this.table);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.table.registerTableEventCallback(new AbstractBaseTable.TableEventCallback(){

                @Override
                public void onNavFocus(int n) {
                    Object object = MultiColumnListSelect.this.table.getIdByIndex(n);
                    if (object != null) {
                        MultiColumnListSelect.this.table.select(object);
                    }
                }

                @Override
                public void onNavSelect(int n) {
                    Object object = MultiColumnListSelect.this.table.getIdByIndex(n);
                    if (object != null) {
                        Item item = MultiColumnListSelect.this.table.getItem(object);
                        Boolean bl = (Boolean)item.getItemProperty(SELECTED_PROPERTY).getValue();
                        item.getItemProperty(SELECTED_PROPERTY).setValue((Object)(bl == false ? 1 : 0));
                        if (MultiColumnListSelect.this.callback != null) {
                            MultiColumnListSelect.this.callback.onValueChange(MultiColumnListSelect.this.table.getItem(object));
                        }
                        MultiColumnListSelect.this.table.select(object);
                    }
                }

                @Override
                public void onNavMove(int n, int n2) {
                }
            });
        }
    }

    public final MultiColumnListSelectTable getTable() {
        return this.table;
    }

    public void registerSelectionChangeCallback(SelectionChangeCallback selectionChangeCallback) {
        this.callback = selectionChangeCallback;
    }

    public final class MultiColumnListSelectTable
    extends AbstractBaseTable {
        @Override
        protected MultiColumnListSelectTableState getState() {
            return (MultiColumnListSelectTableState)super.getState();
        }

        public void setMatchMode(boolean bl) {
            this.getState().isMatchMode = bl;
        }
    }

    public static interface SelectionChangeCallback {
        public void onValueChange(Item var1);
    }
}

