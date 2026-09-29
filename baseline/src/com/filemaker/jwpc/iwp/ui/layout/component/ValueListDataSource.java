/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.util.BeanItemContainer
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListItem;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.v7.data.util.BeanItemContainer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValueListDataSource
extends BeanItemContainer<ValueListItem>
implements Serializable {
    protected String mSeparator;
    protected ValueListType mValueListType;
    protected boolean mHasMoreValues = false;
    protected boolean mCustomList = false;
    protected boolean mValidValues = false;
    public static final Object[] NATURAL_COL_ORDER = new Object[]{"primary", "secondary"};
    public static final String[] COL_HEADERS_ENGLISH = new String[]{"Primary", "Secondary"};
    protected List<ValueListItem> originalValues = new ArrayList<ValueListItem>();
    private ValueListItem currentSelectedValue;

    public ValueListDataSource() {
        super(ValueListItem.class);
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
        this.originalValues.clear();
        this.removeAllItems();
    }

    public void setErrorValue(String string) {
        this.mValidValues = false;
        this.mValueListType = ValueListType.FIRSTONLY;
        this.mHasMoreValues = false;
        this.mSeparator = " ";
        this.mCustomList = false;
        this.originalValues.clear();
        if (!Utilities.isEmptyString(string)) {
            ValueListItem valueListItem = new ValueListItem(string, string);
            this.addBean(valueListItem);
            this.originalValues.add(valueListItem);
        }
    }

    protected List<ValueListItem> getOriginalValues() {
        return this.originalValues;
    }

    public void addOriginalValues(ValueListData valueListData) {
        this.mValidValues = true;
        this.mValueListType = valueListData.getDisplayType();
        this.mHasMoreValues = valueListData.isHasMoreValues();
        this.mSeparator = valueListData.getSeparator();
        this.mCustomList = valueListData.isCustomList();
        this.originalValues.clear();
        List<ValueListEntry> list = valueListData.getValues();
        for (ValueListEntry valueListEntry : list) {
            ValueListItem valueListItem;
            String string = valueListEntry.getStored();
            String string2 = valueListEntry.getDisplayed();
            if (string == null || string.equals("-") || string.isEmpty()) continue;
            if (this.mValueListType == ValueListType.SECONDONLY) {
                valueListItem = new ValueListItem(string, string2);
            } else if (this.mValueListType == ValueListType.FIRSTONLY) {
                valueListItem = new ValueListItem(string, string);
            } else {
                String string3 = string + this.mSeparator + string2;
                valueListItem = new ValueListItem(string, string3);
            }
            this.addBean(valueListItem);
            this.originalValues.add(valueListItem);
        }
    }

    private ValueListItem addCurrentSelectedValue(String string) {
        this.updateCurrentSelectedValue();
        this.currentSelectedValue = new ValueListItem(string, string);
        this.addBean(this.currentSelectedValue);
        return this.currentSelectedValue;
    }

    private void updateCurrentSelectedValue() {
        if (this.currentSelectedValue != null && !this.isOriginalValue(this.currentSelectedValue.getStored())) {
            this.removeItem(this.currentSelectedValue);
        }
    }

    public boolean isOriginalValue(String string) {
        for (ValueListItem valueListItem : this.originalValues) {
            if (!valueListItem.getStored().equals(string)) continue;
            return true;
        }
        return false;
    }

    public boolean containsId(Object object) {
        ValueListItem valueListItem = this.lookupStored(object);
        return super.containsId((Object)valueListItem);
    }

    public ValueListItem lookupStored(Object object) {
        if (object instanceof String) {
            for (ValueListItem valueListItem : this.originalValues) {
                if (!valueListItem.getDisplayed().equalsIgnoreCase((String)object) && !valueListItem.getStored().equalsIgnoreCase((String)object)) continue;
                this.updateCurrentSelectedValue();
                return valueListItem;
            }
            return this.addCurrentSelectedValue((String)object);
        }
        return (ValueListItem)object;
    }

    public ValueListItem lookupDisplayed(Object object) {
        if (object instanceof String) {
            for (ValueListItem valueListItem : this.getItemIds()) {
                if (!valueListItem.getDisplayed().equalsIgnoreCase((String)object)) continue;
                return valueListItem;
            }
            return null;
        }
        return (ValueListItem)object;
    }
}

