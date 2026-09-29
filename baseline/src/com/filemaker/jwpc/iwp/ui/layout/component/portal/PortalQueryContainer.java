/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.data.Property
 *  org.vaadin.addons.lazyquerycontainer.LazyQueryContainer
 *  org.vaadin.addons.lazyquerycontainer.LazyQueryView
 *  org.vaadin.addons.lazyquerycontainer.QueryView
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRow;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.data.Property;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;
import org.vaadin.addons.lazyquerycontainer.LazyQueryView;
import org.vaadin.addons.lazyquerycontainer.QueryView;

public class PortalQueryContainer
extends LazyQueryContainer {
    private final Map<Property, Item> propertyItemCacheMap = new PropertyItemMap<Property, Item>();
    private final ConcurrentHashMap<Integer, PortalRow> cachedRowMap = new ConcurrentHashMap();

    public PortalQueryContainer(LazyQueryView lazyQueryView) {
        super((QueryView)lazyQueryView);
        lazyQueryView.setPropertyItemCacheMap(this.propertyItemCacheMap);
        int n = lazyQueryView.getBatchSize() < 50 ? 50 : lazyQueryView.getBatchSize();
        lazyQueryView.setMaxCacheSize(n);
    }

    public Collection<PortalRow> getCachedPortalRows() {
        return this.cachedRowMap.values();
    }

    public PortalRow getCachedPortalRow(int n) {
        return this.cachedRowMap.get(n);
    }

    private class PropertyItemMap<K, V>
    extends ConcurrentHashMap<K, V> {
        @Override
        public V put(K k, V v) {
            PortalRow portalRow = (PortalRow)((Object)v);
            PortalQueryContainer.this.cachedRowMap.put(portalRow.getPortalRecordIndex(), portalRow);
            return super.put(k, v);
        }

        @Override
        public V remove(Object object) {
            PortalRow portalRow = (PortalRow)((Object)super.remove(object));
            if (portalRow != null) {
                PortalQueryContainer.this.cachedRowMap.remove(portalRow.getPortalRecordIndex());
            }
            return (V)((Object)portalRow);
        }

        @Override
        public void clear() {
            PortalQueryContainer.this.cachedRowMap.clear();
            super.clear();
        }
    }
}

