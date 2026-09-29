/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.component.StatusAreaLabel;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.FoundSetPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import java.text.NumberFormat;
import java.util.Locale;

class FoundSetPieCharter
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION = 260;
    private static final String CSS_SELECTOR_NAME = "foundset";
    private static final String LABEL_CSS_SELECTOR_NAME = "label";
    static final int WIDTH_IN_PIXEL = 140;
    private final StatusAreaLabel numOfRecordsLabel;
    private final StatusAreaLabel descriptionLabel;
    private static final String PIE_CHART_ALL_PATH = "pie_s_100";
    private static String[] PIE_ARRAY = new String[]{"pie_s_0", "pie_s_5", "pie_s_10", "pie_s_15", "pie_s_20", "pie_s_25", "pie_s_30", "pie_s_35", "pie_s_40", "pie_s_45", "pie_s_50", "pie_s_55", "pie_s_60", "pie_s_65", "pie_s_70", "pie_s_75", "pie_s_80", "pie_s_85", "pie_s_90", "pie_s_95", "pie_s_100"};
    private static EventType[] EVENT_TYPES = new EventType[]{EventType.ROW_SET_CHANGE, EventType.FOUND_RECORDS_CHANGE, EventType.TOTAL_RECORDS_CHANGE, EventType.MASTER_ROW_STATE_CHANGE, EventType.SORTING_STATE_CHANGE, EventType.REFRESH_STATUS_AREA};

    public FoundSetPieCharter(App app) throws AppRuntimeException {
        super(app, null);
        this.setWidth(140.0f, Sizeable.Unit.PIXELS);
        this.setHeight(44.0f, Sizeable.Unit.PIXELS);
        this.addStyleName(CSS_SELECTOR_NAME);
        this.addStyleName(PIE_CHART_ALL_PATH);
        this.descriptionLabel = new StatusAreaLabel(app, this.generateStatusString());
        this.descriptionLabel.setStyleName(LABEL_CSS_SELECTOR_NAME);
        this.descriptionLabel.setSizeUndefined();
        this.addComponent((Component)this.descriptionLabel);
        this.numOfRecordsLabel = new StatusAreaLabel(app, String.valueOf(app.getLayoutDataModel().getTotalRecords()));
        this.numOfRecordsLabel.setStyleName(LABEL_CSS_SELECTOR_NAME);
        this.numOfRecordsLabel.setSizeUndefined();
        this.addComponent((Component)this.numOfRecordsLabel);
        this.setToolTip(IWPI18N.get(app, "FOUND_SET_MENU", new Object[0]));
        this.app.subscribe(this, EVENT_TYPES);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    @Override
    public void invalidate() {
        this.app.unsubscribeAllType(this);
    }

    protected String getCss(Component component) {
        if (this.getComponentCount() >= 3) {
            if (this.getComponentIndex(component) == 1) {
                return "position:absolute; left:45px; top:5px;";
            }
            if (this.getComponentIndex(component) == 2) {
                return "position:absolute; left:45px; top:20px;";
            }
        }
        return super.getCss(component);
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof FoundSetPopover)) {
            toolbarPopover = new FoundSetPopover(this.app);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            toolbarPopover.show(260);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }

    private void displayFoundSetUI() {
        this.descriptionLabel.setValue(this.generateStatusString());
        int n = this.app.getLayoutDataModel().getTotalRecords();
        int n2 = this.app.getLayoutDataModel().getFoundRecords();
        this.setStyleName(this.calculatePieChart());
        StringBuilder stringBuilder = new StringBuilder();
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        stringBuilder.append(NumberFormat.getNumberInstance(locale).format(n2)).append(" ").append("/").append(" ").append(NumberFormat.getNumberInstance(locale).format(n));
        if (stringBuilder.length() > 17) {
            this.numOfRecordsLabel.setValue(stringBuilder.toString().substring(0, 17) + "...");
        } else {
            this.numOfRecordsLabel.setValue(stringBuilder.toString());
        }
    }

    private String calculatePieChart() {
        int n = 0;
        int n2 = PIE_ARRAY.length - 1;
        int n3 = this.app.getLayoutDataModel().getTotalRecords();
        int n4 = this.app.getLayoutDataModel().getFoundRecords();
        String string = null;
        if (n4 >= n3) {
            string = PIE_CHART_ALL_PATH;
        } else {
            n = Math.round((float)n4 / (float)n3 * (float)n2);
            if (n == 0 && n4 != 0) {
                n = 1;
            } else if (n == n2 && n4 != n3) {
                n = n2 - 1;
            }
            string = PIE_ARRAY[n];
        }
        return string;
    }

    private void displayShowAllUI() {
        this.setStyleName(PIE_CHART_ALL_PATH);
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.numOfRecordsLabel.setValue(NumberFormat.getNumberInstance(locale).format(this.app.getLayoutDataModel().getTotalRecords()));
        this.descriptionLabel.setValue(this.generateStatusString());
    }

    private String generateStatusString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = this.app.getLayoutDataModel().isMasterRecordSet();
        if (bl) {
            stringBuilder.append(IWPI18N.get(this.app, "PIECHART_TOTAL_LABEL", new Object[0]));
        } else {
            stringBuilder.append(IWPI18N.get(this.app, "PIECHART_FOUND_LABEL", new Object[0]));
        }
        return stringBuilder.toString();
    }

    @Override
    public void setToolTip(String string) {
        String string2 = IWPI18N.get(this.app, string, new Object[0]);
        super.setToolTip(string2);
        this.descriptionLabel.setDescription(string2);
        this.numOfRecordsLabel.setDescription(string2);
        this.getButton().setId("foundsetpiechart");
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case ROW_SET_CHANGE: 
            case TOTAL_RECORDS_CHANGE: 
            case FOUND_RECORDS_CHANGE: 
            case SORTING_STATE_CHANGE: 
            case MASTER_ROW_STATE_CHANGE: 
            case REFRESH_STATUS_AREA: {
                this.refresh();
                break;
            }
        }
    }

    @Override
    public void refresh() {
        if (this.app.getLayoutDataModel().isMasterRecordSet()) {
            this.displayShowAllUI();
        } else {
            this.displayFoundSetUI();
        }
    }

    @Override
    protected void performServerAction() {
        super.performServerAction();
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.app.getStatusAreaContainer().setShouldExitPopover(true);
        }
    }
}

