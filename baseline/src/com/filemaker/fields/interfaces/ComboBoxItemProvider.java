/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.fields.interfaces;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import java.util.List;
import java.util.Set;

public interface ComboBoxItemProvider {
    public ItemProviderResult provideItems(String var1, int var2, int var3, boolean var4);

    public ComboBoxItem mapToItem(String var1);

    public static class ItemProviderResult {
        public List<ComboBoxItem> items;
        public int totalNumberOfItems;
        public Set<Integer> separators;
        public int pageIndexOverride;
    }
}

