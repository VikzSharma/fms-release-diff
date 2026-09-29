/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.component.StatusAreaLabel;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindRequestSetPopover;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import java.text.NumberFormat;
import java.util.Locale;

class FindRequestSettings
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION_SMALL = 170;
    private static final String CSS_SELECTOR_NAME_LARGE = "findrequests-settings-l";
    private static final String CSS_SELECTOR_NAME_SMALL = "findrequests-settings-s";
    static final int LARGE_WIDTH_IN_PIXEL = 100;
    private final StatusAreaLabel descriptionLabel;
    private final StatusAreaLabel totalRequestsLabel;
    private int prevBrowserWidth = -1;

    public FindRequestSettings(App app) throws AppRuntimeException {
        super(app, null);
        this.descriptionLabel = new StatusAreaLabel(app, IWPI18N.get(app, "REQUEST", new Object[0]));
        this.descriptionLabel.setSizeUndefined();
        this.descriptionLabel.setStyleName("label");
        Locale locale = app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.totalRequestsLabel = new StatusAreaLabel(app, String.valueOf(NumberFormat.getNumberInstance(locale).format(app.getLayoutDataModel().getFoundRecords())));
        this.totalRequestsLabel.setSizeUndefined();
        this.totalRequestsLabel.setStyleName("label");
        this.setToolTip(IWPI18N.get(app, "FIND_REQUESTS", new Object[0]));
        this.refreshUI();
        this.app.subscribe(this, EventType.FOUND_RECORDS_CHANGE, EventType.RECORD_INDEX_CHANGE, EventType.MODE_CHANGE, EventType.REFRESH_STATUS_AREA, EventType.BROWSER_WIDTH_CHANGE);
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
        this.getButton().setId("findrequests-settings");
    }

    private void refreshUI() {
        int n = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions().getWidth();
        if (this.prevBrowserWidth == -1) {
            this.addComponent((Component)this.totalRequestsLabel);
            if (n < 590) {
                this.setStyleName(CSS_SELECTOR_NAME_SMALL);
            } else {
                this.addComponent((Component)this.descriptionLabel);
                this.setStyleName(CSS_SELECTOR_NAME_LARGE);
            }
        } else if (this.prevBrowserWidth >= 590) {
            if (n < 590) {
                this.removeComponent((Component)this.descriptionLabel);
                this.setStyleName(CSS_SELECTOR_NAME_SMALL);
            }
        } else if (n >= 590) {
            this.addComponent((Component)this.descriptionLabel);
            this.setStyleName(CSS_SELECTOR_NAME_LARGE);
        }
        this.prevBrowserWidth = n;
    }

    @Override
    public void setToolTip(String string) {
        String string2 = IWPI18N.get(this.app, string, new Object[0]);
        super.setToolTip(string2);
        this.descriptionLabel.setDescription(string2);
        this.totalRequestsLabel.setDescription(string2);
    }

    protected String getCss(Component component) {
        if (this.getComponentCount() == 2) {
            if (this.getComponentIndex(component) == 1) {
                return "position:absolute; left:28px; top:18px;";
            }
        } else if (this.getComponentCount() == 3) {
            if (this.getComponentIndex(component) == 1) {
                return "position:absolute; left:34px; top:21px;";
            }
            if (this.getComponentIndex(component) == 2) {
                return "position:absolute; left:34px; top:6px;";
            }
        }
        return super.getCss(component);
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof FindRequestSetPopover)) {
            toolbarPopover = new FindRequestSetPopover(this.app);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            toolbarPopover.show(170);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }

    @Override
    public void refresh() {
        this.refreshData(this.app.getLayoutDataModel().getRecordIndex());
    }

    private void refreshData(int n) {
        Locale locale = this.app.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.totalRequestsLabel.setValue(String.valueOf(NumberFormat.getNumberInstance(locale).format(n)));
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case ROW_SET_CHANGE: 
            case RECORD_INDEX_CHANGE: 
            case FOUND_RECORDS_CHANGE: {
                this.refresh();
                break;
            }
            case REFRESH_STATUS_AREA: {
                if (this.app.isFindMode()) {
                    this.refreshUI();
                }
                this.refresh();
                break;
            }
            case BROWSER_WIDTH_CHANGE: {
                if (!this.app.isFindMode()) break;
                this.refreshUI();
                break;
            }
        }
    }
}

