/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortState {
    private final App appRoot;
    private final Map<String, List<SortQuery>> sortQueries;
    private boolean isUnsort;
    private boolean applySortCriteriaOnColumns;

    public SortState(App app) {
        this.appRoot = app;
        this.sortQueries = new HashMap<String, List<SortQuery>>();
    }

    public void addSortQueries(List<SortQuery> list) {
        this.sortQueries.put(this.appRoot.getAppSession().getLayoutName(), list);
    }

    public List<SortQuery> getSortQueries() {
        String string = this.appRoot.getAppSession().getLayoutName();
        List<SortQuery> list = this.sortQueries.get(string);
        if (list == null) {
            list = new ArrayList<SortQuery>();
            this.addSortQueries(list);
        }
        return list;
    }

    public void setUnsort(Boolean bl) {
        this.isUnsort = bl;
    }

    public boolean isUnsort() {
        return this.isUnsort;
    }

    public void setSortCriteriaOnColumns(boolean bl) {
        this.applySortCriteriaOnColumns = bl;
    }

    public boolean applySortCriteriaOnColumns() {
        return this.applySortCriteriaOnColumns;
    }
}

