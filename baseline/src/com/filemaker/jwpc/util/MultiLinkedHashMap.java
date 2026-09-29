/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javolution.util.FastList
 */
package com.filemaker.jwpc.util;

import java.util.List;
import javolution.util.FastList;

public class MultiLinkedHashMap<T, S> {
    List<NVPair<T, S>> values = new FastList();

    public void put(T t, S s) {
        this.values.add(new NVPair<T, S>(t, s));
    }

    public List<NVPair<T, S>> getData() {
        return this.values;
    }

    public static class NVPair<T, S> {
        T key;
        S value;

        public NVPair(T t, S s) {
            this.key = t;
            this.value = s;
        }

        public T getKey() {
            return this.key;
        }

        public S getValue() {
            return this.value;
        }
    }
}

