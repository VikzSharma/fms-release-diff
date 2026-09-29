/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Property$ReadOnlyException
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListItem;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.CheckboxSetServerRpc;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.v7.data.Property;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CheckboxSet
extends RadioSet {
    protected boolean setValueEmpty = false;
    protected LinkedList<String> actualValues;

    public CheckboxSet(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, objectMetaData, objectAttributes);
        super.setMultiSelect(true);
        this.registerCheckboxSetRpc();
        this.actualValues = new LinkedList();
    }

    @Override
    protected void reset() {
        this.actualValues.clear();
        super.reset();
    }

    private void registerCheckboxSetRpc() {
        CheckboxSetServerRpc checkboxSetServerRpc = new CheckboxSetServerRpc(){

            @Override
            public void onClick(String[] stringArray, boolean bl, String string, boolean bl2) {
                ValueListItem valueListItem = CheckboxSet.this.container.lookupDisplayed(string);
                if (!bl || !bl2) {
                    if (bl) {
                        CheckboxSet.this.actualValues.addLast(valueListItem.getStored());
                    } else {
                        CheckboxSet.this.actualValues.removeLastOccurrence(valueListItem.getStored());
                    }
                    CheckboxSet.this.setValueEmpty = stringArray.length == 1 && !bl;
                }
            }
        };
        this.registerRpc(checkboxSetServerRpc);
    }

    public Object getData() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = true;
        Iterator iterator = this.actualValues.iterator();
        while (iterator.hasNext()) {
            String string;
            String string2 = string = (String)iterator.next();
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append("\r");
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    @Override
    protected void setValue(Object object, boolean bl) throws Property.ReadOnlyException {
        if (object instanceof Set && ((Set)object).isEmpty() && !this.setValueEmpty) {
            return;
        }
        super.setValue(object, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void updateData(String string) {
        HashMap hashMap = new HashMap();
        LinkedHashSet<ValueListItem> linkedHashSet = new LinkedHashSet<ValueListItem>();
        if (!Utilities.isEmptyString(string)) {
            this.actualValues = new LinkedList<String>(Arrays.asList(IWPUtilities.splitValues(string)));
            for (String string2 : this.actualValues) {
                if (!hashMap.containsKey(string2)) {
                    hashMap.put(string2, new ArrayList());
                }
                Object object = this.containerLock;
                synchronized (object) {
                    ValueListItem valueListItem = this.container.lookupStored(string2, ((List)hashMap.get(string2)).size());
                    if (valueListItem == null) {
                        valueListItem = this.container.lookupDisplayed(string2);
                    }
                    if (valueListItem == null) {
                        linkedHashSet.add(new ValueListItem(string2, string2));
                    } else {
                        linkedHashSet.add(valueListItem);
                        ((List)hashMap.get(string2)).add(valueListItem);
                    }
                }
            }
        } else {
            this.actualValues = new LinkedList();
        }
        this.setValue(linkedHashSet);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void updateDataImpl(StringDataUpdateParameters stringDataUpdateParameters) {
        String string = stringDataUpdateParameters.getData().getValue();
        Object object = this.containerLock;
        synchronized (object) {
            if (stringDataUpdateParameters.disableListeners()) {
                boolean bl = this.listener.isValueChangeListenerEnabled();
                try {
                    if (bl) {
                        this.listener.disableValueChangeListener();
                    }
                    this.updateData(string);
                }
                finally {
                    if (bl) {
                        this.listener.enableValueChangeListener();
                    }
                }
            } else {
                this.updateData(string);
            }
        }
    }
}

