/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javolution.util.FastMap
 *  javolution.util.FastSet
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.interfaces.ComboBoxItemProvider;
import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javolution.util.FastMap;
import javolution.util.FastSet;

public class PopupComboBoxItemProvider
implements ComboBoxItemProvider {
    protected String mSeparator;
    protected ValueListType mValueListType;
    protected boolean mHasMoreValues = false;
    protected boolean mCustomList = false;
    protected boolean mValidValues = false;
    public static final Object[] NATURAL_COL_ORDER = new Object[]{"primary", "secondary"};
    public static final String[] COL_HEADERS_ENGLISH = new String[]{"Primary", "Secondary"};
    protected List<ComboBoxItem> originalValues = new ArrayList<ComboBoxItem>();
    protected Set<Integer> dividerIndices = new FastSet();
    protected Map<String, ComboBoxItem> storedValuesMap = new FastMap();
    protected Map<String, ComboBoxItem> displayedValuesMap = new FastMap();
    private int itemId = 0;
    private int valueCount = 0;
    private int pageIndexOverride = -1;

    private String getNextItemId() {
        ++this.itemId;
        return "" + (this.itemId - 1);
    }

    public void setSeparator(String string) {
        this.mSeparator = string;
    }

    public String getSeparator() {
        return this.mSeparator;
    }

    public void setType(ValueListType valueListType) {
        this.mValueListType = valueListType;
    }

    public ValueListType getType() {
        return this.mValueListType;
    }

    public boolean isCustomList() {
        return this.mCustomList;
    }

    public boolean hasValidValues() {
        return this.mValidValues;
    }

    public void reset() {
        this.mValidValues = false;
        this.mValueListType = ValueListType.FIRSTONLY;
        this.mHasMoreValues = false;
        this.mSeparator = " ";
        this.mCustomList = false;
        this.originalValues.clear();
        this.dividerIndices.clear();
        this.storedValuesMap.clear();
        this.displayedValuesMap.clear();
    }

    public ComboBoxItem getErrorItem(String string) {
        this.reset();
        return new ComboBoxItem(this.getNextItemId(), string, string);
    }

    public void addOriginalValues(ValueListData valueListData) {
        this.reset();
        if (valueListData != null && valueListData.getValuesSize() > 0) {
            this.mValidValues = true;
            this.mValueListType = valueListData.getDisplayType();
            this.mHasMoreValues = valueListData.isHasMoreValues();
            this.mSeparator = valueListData.getSeparator();
            this.mCustomList = valueListData.isCustomList();
            List<ValueListEntry> list = valueListData.getValues();
            int n = -1;
            for (ValueListEntry valueListEntry : list) {
                String string = valueListEntry.getStored();
                String string2 = valueListEntry.getDisplayed();
                if (string == null) continue;
                if (!string.equals("-")) {
                    String string3;
                    this.addItem(string3, switch (this.mValueListType) {
                        case ValueListType.SECONDONLY -> {
                            string3 = string;
                            yield string2;
                        }
                        case ValueListType.FIRSTONLY -> {
                            string3 = string;
                            yield string;
                        }
                        default -> {
                            string3 = string;
                            yield string + this.mSeparator + string2;
                        }
                    });
                    ++n;
                    continue;
                }
                this.dividerIndices.add(n);
            }
        }
    }

    private void addItem(String string, String string2) {
        ComboBoxItem comboBoxItem = new ComboBoxItem(this.getNextItemId(), string, string2);
        this.originalValues.add(comboBoxItem);
        this.storedValuesMap.put(string, comboBoxItem);
        this.displayedValuesMap.put(string2, comboBoxItem);
    }

    @Override
    public ComboBoxItemProvider.ItemProviderResult provideItems(String string, int n, int n2, boolean bl) {
        ComboBoxItemProvider.ItemProviderResult itemProviderResult = new ComboBoxItemProvider.ItemProviderResult();
        itemProviderResult.items = this.originalValues;
        itemProviderResult.totalNumberOfItems = this.valueCount;
        itemProviderResult.separators = this.dividerIndices;
        itemProviderResult.pageIndexOverride = this.pageIndexOverride;
        return itemProviderResult;
    }

    @Override
    public ComboBoxItem mapToItem(String string) {
        return this.getItemFromDisplayedValue(string);
    }

    public ComboBoxItem getItemFromStoredValue(String string) {
        ComboBoxItem comboBoxItem = this.storedValuesMap.get(string);
        if (comboBoxItem == null) {
            comboBoxItem = new ComboBoxItem(this.getNextItemId(), string, string);
        }
        return comboBoxItem;
    }

    public ComboBoxItem getItemFromDisplayedValue(String string) {
        ComboBoxItem comboBoxItem = this.displayedValuesMap.get(string);
        if (comboBoxItem == null) {
            comboBoxItem = new ComboBoxItem(this.getNextItemId(), string, string);
        }
        return comboBoxItem;
    }

    public void setValueCount(int n) {
        this.valueCount = n;
    }

    public void setPageIndexOverride(int n) {
        this.pageIndexOverride = n;
    }
}

