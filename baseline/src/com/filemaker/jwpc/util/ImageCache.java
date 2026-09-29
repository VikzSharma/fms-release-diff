/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.util;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class ImageCache<K, V> {
    private ConcurrentHashMap<K, SoftReference<V>> map = new ConcurrentHashMap();

    public V get(K k) {
        SoftReference<V> softReference = this.map.get(k);
        if (softReference == null) {
            this.map.remove(k);
            return null;
        }
        return softReference.get();
    }

    public V put(K k, V v) {
        SoftReference<V> softReference = this.map.put(k, new SoftReference<V>(v));
        if (softReference == null) {
            return null;
        }
        V v2 = softReference.get();
        softReference.clear();
        return v2;
    }

    public V remove(K k) {
        SoftReference<V> softReference = this.map.remove(k);
        if (softReference == null) {
            return null;
        }
        V v = softReference.get();
        softReference.clear();
        return v;
    }

    public int size() {
        return this.map.size();
    }

    public void clear() {
        this.map.clear();
    }
}

