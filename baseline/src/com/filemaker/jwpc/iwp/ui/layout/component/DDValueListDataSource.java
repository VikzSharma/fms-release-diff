/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.data.util.IndexedContainer
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.data.util.IndexedContainer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DDValueListDataSource
extends IndexedContainer
implements Serializable {
    protected String mSeparator;
    protected ValueListType mValueListType;
    protected boolean mHasMoreValues;
    protected boolean mCustomList;
    protected boolean mValidValues;
    public static final Object[] NATURAL_COL_ORDER = new Object[]{"primary", "secondary"};
    public static final String[] COL_HEADERS_ENGLISH = new String[]{"Primary", "Secondary"};
    protected HashMap<String, Item> originalValues = new HashMap();
    protected HashMap<String, String> displayToStoredValues = new HashMap();
    protected HashMap<String, String> storedToDisplayedValues = new HashMap();
    protected Item currentSelectedItem;

    public DDValueListDataSource() {
        this.addContainerProperty("name", String.class, null);
        this.reset();
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
        this.displayToStoredValues.clear();
        this.storedToDisplayedValues.clear();
        this.removeAllItems();
        Item item = this.addItem("");
        if (item != null) {
            item.getItemProperty((Object)"name").setValue((Object)"");
            this.originalValues.put("", item);
        }
    }

    public void setErrorValue(String string) {
        this.reset();
        if (!Utilities.isEmptyString(string)) {
            Item item = this.addItem(string);
            this.addItem(item);
            this.originalValues.put(string, item);
        }
    }

    public String getDisplayedValue(String string) {
        String string2 = this.storedToDisplayedValues.get(string);
        if (string2 == null) {
            string2 = string;
        }
        return string2;
    }

    public String getStoredValue(String string) {
        String string2 = this.displayToStoredValues.get(string);
        if (string2 == null) {
            string2 = string;
        }
        return string2;
    }

    public void updateCurrentSelectedItem(String string, String string2) {
        Item item = this.getItem(string);
        if (item != null) {
            item.getItemProperty((Object)"name").setValue((Object)string2);
        } else {
            if (this.currentSelectedItem != null) {
                this.removeItem(this.currentSelectedItem);
                this.currentSelectedItem = null;
            }
            if (!Utilities.isEmptyString(string) && this.originalValues.get(string) == null) {
                this.currentSelectedItem = this.addItem(string);
                if (this.currentSelectedItem != null) {
                    this.currentSelectedItem.getItemProperty((Object)"name").setValue((Object)string2);
                }
            }
        }
    }

    public Item addItem(Object object) {
        if (object instanceof String) {
            if (Utilities.isEmptyString((String)object) && this.getAllItemIds().contains("")) {
                return null;
            }
            while (this.getAllItemIds().contains(object)) {
                object = "\u0000" + String.valueOf(object);
            }
        }
        return super.addItem(object);
    }

    public void addOriginalValues(ValueListData valueListData) {
        this.reset();
        this.mValidValues = true;
        this.mValueListType = valueListData.getDisplayType();
        this.mHasMoreValues = valueListData.isHasMoreValues();
        this.mSeparator = valueListData.getSeparator();
        this.mCustomList = valueListData.isCustomList();
        List<ValueListEntry> list = valueListData.getValues();
        for (ValueListEntry valueListEntry : list) {
            Item item;
            String string = valueListEntry.getStored();
            String string2 = valueListEntry.getDisplayed();
            if (string.equals("-") || Utilities.isEmptyString(string) || (item = this.addItem(string)) == null) continue;
            Object object = switch (this.mValueListType) {
                case ValueListType.SECONDONLY -> string2;
                case ValueListType.FIRSTONLY -> string;
                default -> string + this.mSeparator + string2;
            };
            item.getItemProperty((Object)"name").setValue(object);
            this.originalValues.put(string, item);
            this.displayToStoredValues.put((String)object, string);
            this.storedToDisplayedValues.put(string, (String)object);
        }
    }
}

