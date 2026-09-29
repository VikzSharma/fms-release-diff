/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.RecordsNavigator;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaTextFieldState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;

public class BrowseRecordsNavigatorLarge
extends RecordsNavigator {
    private final RecordIndexField currentField;

    public BrowseRecordsNavigatorLarge(App app) {
        super(app);
        this.setStyleName("navigator large");
        this.previous.setWidth(70.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.previous);
        this.next.setWidth(70.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)this.next);
        this.currentField = new RecordIndexField();
        this.addComponent((Component)this.currentField);
        this.setComponentAlignment((Component)this.currentField, Alignment.MIDDLE_CENTER);
        this.currentField.setValue(String.valueOf(this.currentRecordIndex));
        Label label = new Label();
        label.setWidth(10.0f, Sizeable.Unit.PIXELS);
        this.addComponent((Component)label);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        super.onEvent(uIEvent);
        switch (uIEvent.getType()) {
            case REFRESH_STATUS_AREA: {
                this.currentField.setAriaLabel();
            }
            case FOUND_RECORDS_CHANGE: 
            case RECORD_INDEX_CHANGE: {
                this.currentField.setValue(String.valueOf(this.currentRecordIndex));
                break;
            }
        }
    }

    public class RecordIndexField
    extends TextField {
        private final TextFieldChangeListener textfieldListener;
        private final String tooltip;

        public RecordIndexField() {
            this.textfieldListener = new TextFieldChangeListener();
            this.tooltip = IWPI18N.get(BrowseRecordsNavigatorLarge.this.app, "GOTO_RECORD_TOOLTIP", new Object[0]);
            this.setWidth(60.0f, Sizeable.Unit.PIXELS);
            this.setHeight(26.0f, Sizeable.Unit.PIXELS);
            this.setStyleName("records-navigator-current");
            this.setDescription(this.tooltip);
            this.setId("recordindexfield");
            this.setAriaLabel();
            this.addValueChangeListener(this.textfieldListener);
            this.setImmediate(true);
            if (!AppServlet.isAriaCompliantControlEnabled()) {
                this.setTabIndex(-1);
            }
        }

        public StatusAreaTextFieldState getState() {
            return (StatusAreaTextFieldState)super.getState();
        }

        public void setDescription(String string) {
            if (!BrowserInfoHandler.isTouchDevice(BrowseRecordsNavigatorLarge.this.app)) {
                super.setDescription(string, ContentMode.HTML);
            }
            this.updateBooleanState(StatusAreaTextFieldState.BooleanState.showTooltip, !Utilities.isEmptyString(this.getDescription()) && this.isEnabled());
        }

        public void setAriaLabel() {
            IWPUtilities.setAriaLabelById(BrowseRecordsNavigatorLarge.this.app, "recordindexfield", this.tooltip);
        }

        private void updateBooleanState(StatusAreaTextFieldState.BooleanState booleanState, boolean bl) {
            this.getState().stbs = IWPUtilities.applyBooleanValue(this.getState().stbs, booleanState.ordinal(), bl);
        }
    }

    private class TextFieldChangeListener
    implements Property.ValueChangeListener {
        private TextFieldChangeListener() {
        }

        public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
            try {
                int n = Integer.parseInt(((String)BrowseRecordsNavigatorLarge.this.currentField.getValue()).toString());
                int n2 = BrowseRecordsNavigatorLarge.this.app.getLayoutDataModel().getFoundRecords();
                if (n2 == 0 || n > 0 && n <= n2) {
                    BrowseRecordsNavigatorLarge.this.currentRecordIndex = n;
                } else if (n > n2) {
                    BrowseRecordsNavigatorLarge.this.currentRecordIndex = n2;
                    BrowseRecordsNavigatorLarge.this.currentField.setValue(String.valueOf(n2));
                } else if (n <= 0) {
                    BrowseRecordsNavigatorLarge.this.currentRecordIndex = 1;
                    BrowseRecordsNavigatorLarge.this.currentField.setValue("1");
                }
                if (BrowseRecordsNavigatorLarge.this.app.getLayoutDataModel().getRecordIndex() != BrowseRecordsNavigatorLarge.this.currentRecordIndex) {
                    GlobalUIActionHandlers.GOTO_ROW_BY_INDEX.perform(BrowseRecordsNavigatorLarge.this.app, new Object[]{BrowseRecordsNavigatorLarge.this.currentRecordIndex});
                }
            }
            catch (NumberFormatException numberFormatException) {
                BrowseRecordsNavigatorLarge.this.currentField.setValue(String.valueOf(BrowseRecordsNavigatorLarge.this.currentRecordIndex));
            }
        }
    }
}

