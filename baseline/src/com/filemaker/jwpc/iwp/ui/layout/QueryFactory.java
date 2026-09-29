/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.vaadin.addons.lazyquerycontainer.Query
 *  org.vaadin.addons.lazyquerycontainer.QueryDefinition
 *  org.vaadin.addons.lazyquerycontainer.QueryFactory
 */
package com.filemaker.jwpc.iwp.ui.layout;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

public class QueryFactory
implements org.vaadin.addons.lazyquerycontainer.QueryFactory {
    private final Query query;

    public QueryFactory(Query query) {
        this.query = query;
    }

    public Query constructQuery(QueryDefinition queryDefinition) {
        return this.query;
    }
}

