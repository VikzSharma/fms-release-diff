/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListDataSource;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListItem;
import java.util.List;

public class RadioSetValueListDataSource
extends ValueListDataSource {
    @Override
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
            if (string == null || string.length() <= 0 || string.equals("-")) continue;
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

    @Override
    public ValueListItem lookupStored(Object object) {
        if (object instanceof String) {
            for (ValueListItem valueListItem : this.getOriginalValues()) {
                if (!valueListItem.getStored().equalsIgnoreCase((String)object)) continue;
                return valueListItem;
            }
            return null;
        }
        return (ValueListItem)object;
    }

    public ValueListItem lookupStored(Object object, int n) {
        int n2 = 0;
        if (object instanceof String) {
            for (ValueListItem valueListItem : this.getOriginalValues()) {
                if (!valueListItem.getStored().equalsIgnoreCase((String)object)) continue;
                if (n2 == n) {
                    return valueListItem;
                }
                ++n2;
            }
            return null;
        }
        return (ValueListItem)object;
    }
}

