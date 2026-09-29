/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuSlider;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;
import java.text.NumberFormat;
import java.util.Locale;

class BrowseRecordsMenuSlider
extends ToolbarMenuSlider
implements StatusAreaComponent {
    static final int HEIGHT_IN_PIXEL = 50;
    private RecordIndexLabel current;

    BrowseRecordsMenuSlider(App app) {
        super(app);
        this.setHeight(50.0f, Sizeable.Unit.PIXELS);
    }

    @Override
    protected void initComponents() {
        this.current = new RecordIndexLabel();
        this.addComponent((Component)this.current);
        super.initComponents();
        this.refresh();
        this.app.subscribe(this, EventType.FOUND_RECORDS_CHANGE, EventType.RECORD_INDEX_CHANGE, EventType.TOOLBAR_STATUSAREA_STATE_CHANGE);
        IWPUtilities.assignUniqueId(this.app, "b", (Component)this);
    }

    @Override
    protected void processItemNumber(int n) {
        super.processItemNumber(n);
        StringBuilder stringBuilder = new StringBuilder();
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        stringBuilder.append(String.valueOf(NumberFormat.getNumberInstance(locale).format(n))).append(" / ").append(NumberFormat.getNumberInstance(locale).format(this.app.getLayoutDataModel().getFoundRecords())).append(" ");
        switch (this.app.getLayoutDataModel().getRowSetOrder()) {
            case SORTED: {
                stringBuilder.append(IWPI18N.get(this.app, "SORTED", new Object[0]));
                break;
            }
            case SEMI_SORTED: {
                stringBuilder.append(IWPI18N.get(this.app, "SEMI_SORTED", new Object[0]));
                break;
            }
            default: {
                stringBuilder.append(IWPI18N.get(this.app, "UNSORTED", new Object[0]));
            }
        }
        this.current.setValue(stringBuilder.toString());
    }

    @Override
    protected void changeItem(int n) {
        if (this.app.getLayoutDataModel().getRecordIndex() != n) {
            GlobalUIActionHandlers.GOTO_ROW_BY_INDEX.perform(this.app, new Object[]{n});
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case FOUND_RECORDS_CHANGE: 
            case TOOLBAR_STATUSAREA_STATE_CHANGE: {
                this.processNumberOfItems(this.app.getLayoutDataModel().getFoundRecords());
                break;
            }
            case RECORD_INDEX_CHANGE: {
                this.processItemNumber(this.app.getLayoutDataModel().getRecordIndex());
            }
        }
    }

    @Override
    public void refresh() {
        int n = this.app.getLayoutDataModel().getFoundRecords();
        this.processNumberOfItems(n);
        int n2 = this.app.getLayoutDataModel().getRecordIndex();
        this.processItemNumber(n2);
    }

    private class RecordIndexLabel
    extends Label {
        RecordIndexLabel() {
            this.setSizeUndefined();
            this.setStyleName("records-navigator-current");
        }
    }
}

