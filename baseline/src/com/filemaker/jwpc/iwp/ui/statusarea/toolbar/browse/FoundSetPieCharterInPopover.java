/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;
import java.text.NumberFormat;
import java.util.Locale;

public class FoundSetPieCharterInPopover
extends CssLayout
implements StatusAreaComponent {
    static final int WIDGET_HEIGHT_IN_PIXEL = 154;
    private static final int WIDGET_WIDTH_IN_PIXEL = 280;
    private static final int WIDGET_TOP_PART_HEIGHT_IN_PIXEL = 124;
    private static final int PIECHART_HEIGHT_IN_PIXEL = 110;
    private static final int WIDGET_BOTTOM_PART_HEIGHT_IN_PIXEL = 30;
    private static final String CSS_SELECTOR_NAME = "foundset";
    private static final String TEXT_LABEL_CSS_SELECTOR_NAME = "text";
    private static final String NUMBER_LABEL_CSS_SELECTOR_NAME = "number";
    private static final String FOUND_LABEL_CSS_SELECTOR_NAME = "found";
    private static final String PIE_CHART_NONE_PATH = "pie_l_none";
    private static String[] PIE_ARRAY = new String[]{"pie_l_0", "pie_l_5", "pie_l_10", "pie_l_15", "pie_l_20", "pie_l_25", "pie_l_30", "pie_l_35", "pie_l_40", "pie_l_45", "pie_l_50", "pie_l_55", "pie_l_60", "pie_l_65", "pie_l_70", "pie_l_75", "pie_l_80", "pie_l_85", "pie_l_90", "pie_l_95", "pie_l_100"};
    private final App app;
    private final ToolbarButton image;
    private final Label numOfOmittedRecordsLabel;
    private final Label numOfFoundRecordsLabel;
    private final Label numOfTotalRecordsLabel;

    public FoundSetPieCharterInPopover(App app) throws AppRuntimeException {
        this.app = app;
        this.setWidth(280.0f, Sizeable.Unit.PIXELS);
        this.setHeight(154.0f, Sizeable.Unit.PIXELS);
        this.setStyleName(CSS_SELECTOR_NAME);
        int n = app.getLayoutDataModel().getTotalRecords();
        int n2 = app.getLayoutDataModel().getFoundRecords();
        int n3 = n - n2;
        Locale locale = app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(false);
        horizontalLayout.setMargin(false);
        horizontalLayout.setWidth(280.0f, Sizeable.Unit.PIXELS);
        horizontalLayout.setHeight(124.0f, Sizeable.Unit.PIXELS);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(false);
        verticalLayout.setMargin(false);
        verticalLayout.setWidth("100px");
        verticalLayout.setHeight(124.0f, Sizeable.Unit.PIXELS);
        Label label = new Label(IWPI18N.get(app, "OMITTED", new Object[0]));
        label.setSizeUndefined();
        label.setStyleName(TEXT_LABEL_CSS_SELECTOR_NAME);
        verticalLayout.addComponent((Component)label);
        verticalLayout.setComponentAlignment((Component)label, Alignment.BOTTOM_CENTER);
        this.numOfOmittedRecordsLabel = new Label(String.valueOf(NumberFormat.getNumberInstance(locale).format(n3)));
        this.numOfOmittedRecordsLabel.setSizeUndefined();
        this.numOfOmittedRecordsLabel.setStyleName(NUMBER_LABEL_CSS_SELECTOR_NAME);
        verticalLayout.addComponent((Component)this.numOfOmittedRecordsLabel);
        verticalLayout.setComponentAlignment((Component)this.numOfOmittedRecordsLabel, Alignment.BOTTOM_CENTER);
        horizontalLayout.addComponent((Component)verticalLayout);
        this.image = new ToolbarButton(app, app.getAM().getAction(UIActionType.SHOW_OMITTED_RECORDS));
        this.image.setWidth("80px");
        this.image.setHeight(110.0f, Sizeable.Unit.PIXELS);
        this.image.addStyleName("records-piecharter");
        this.image.addStyleName(this.calculatePieChart());
        this.image.setId("records-piecharter");
        this.image.getButton().setId("piechart-button");
        IWPUtilities.setAriaLabelById(app, "piechart-button", IWPI18N.get(app, "PIECHART_TOOLTIP", new Object[0]));
        horizontalLayout.addComponent((Component)this.image);
        horizontalLayout.setComponentAlignment((Component)this.image, Alignment.BOTTOM_CENTER);
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.setSpacing(false);
        verticalLayout2.setMargin(false);
        verticalLayout2.setWidth("80px");
        verticalLayout2.setHeight(124.0f, Sizeable.Unit.PIXELS);
        verticalLayout2.setStyleName(FOUND_LABEL_CSS_SELECTOR_NAME);
        Label label2 = new Label(IWPI18N.get(app, "FOUND", new Object[0]));
        label2.setSizeUndefined();
        label2.setStyleName(TEXT_LABEL_CSS_SELECTOR_NAME);
        verticalLayout2.addComponent((Component)label2);
        verticalLayout2.setComponentAlignment((Component)label2, Alignment.BOTTOM_CENTER);
        this.numOfFoundRecordsLabel = new Label(String.valueOf(NumberFormat.getNumberInstance(locale).format(n2)));
        this.numOfFoundRecordsLabel.setSizeUndefined();
        this.numOfFoundRecordsLabel.setStyleName(NUMBER_LABEL_CSS_SELECTOR_NAME);
        verticalLayout2.addComponent((Component)this.numOfFoundRecordsLabel);
        verticalLayout2.setComponentAlignment((Component)this.numOfFoundRecordsLabel, Alignment.BOTTOM_CENTER);
        horizontalLayout.addComponent((Component)verticalLayout2);
        horizontalLayout.setComponentAlignment((Component)verticalLayout2, Alignment.MIDDLE_LEFT);
        this.addComponent((Component)horizontalLayout);
        VerticalLayout verticalLayout3 = new VerticalLayout();
        verticalLayout3.setSpacing(false);
        verticalLayout3.setMargin(false);
        verticalLayout3.setWidth(280.0f, Sizeable.Unit.PIXELS);
        verticalLayout3.setHeight(30.0f, Sizeable.Unit.PIXELS);
        verticalLayout3.setStyleName(TEXT_LABEL_CSS_SELECTOR_NAME);
        this.numOfTotalRecordsLabel = new Label(IWPI18N.get(app, "TOTAL_RECORDS", NumberFormat.getNumberInstance(locale).format(app.getLayoutDataModel().getTotalRecords())));
        this.numOfTotalRecordsLabel.setSizeUndefined();
        verticalLayout3.addComponent((Component)this.numOfTotalRecordsLabel);
        verticalLayout3.setComponentAlignment((Component)this.numOfTotalRecordsLabel, Alignment.TOP_CENTER);
        this.addComponent((Component)verticalLayout3);
        this.app.subscribe(this, EventType.ROW_SET_CHANGE, EventType.FOUND_RECORDS_CHANGE, EventType.TOTAL_RECORDS_CHANGE, EventType.MASTER_ROW_STATE_CHANGE, EventType.SORTING_STATE_CHANGE);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }

    private void updateFoundSetUI() {
        int n = this.app.getLayoutDataModel().getFoundRecords();
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.numOfOmittedRecordsLabel.setValue(String.valueOf(NumberFormat.getNumberInstance(locale).format(this.app.getLayoutDataModel().getTotalRecords() - n)));
        this.numOfFoundRecordsLabel.setValue(String.valueOf(NumberFormat.getNumberInstance(locale).format(n)));
        this.image.setStyleName(this.calculatePieChart());
    }

    private String calculatePieChart() {
        int n = 0;
        int n2 = PIE_ARRAY.length - 1;
        int n3 = this.app.getLayoutDataModel().getTotalRecords();
        int n4 = this.app.getLayoutDataModel().getFoundRecords();
        String string = null;
        if (n4 == n3) {
            string = "pie_l_100";
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

    private void updateShowAllUI() {
        this.image.setStyleName(PIE_CHART_NONE_PATH);
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.numOfFoundRecordsLabel.setValue(NumberFormat.getNumberInstance(locale).format(this.app.getLayoutDataModel().getTotalRecords()));
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case ROW_SET_CHANGE: 
            case TOTAL_RECORDS_CHANGE: 
            case FOUND_RECORDS_CHANGE: 
            case SORTING_STATE_CHANGE: 
            case MASTER_ROW_STATE_CHANGE: {
                this.refresh();
            }
        }
    }

    @Override
    public void refresh() {
        if (this.app.getLayoutDataModel().isMasterRecordSet()) {
            this.updateShowAllUI();
        } else {
            this.updateFoundSetUI();
        }
    }
}

