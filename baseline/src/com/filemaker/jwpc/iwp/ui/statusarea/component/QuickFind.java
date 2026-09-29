/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.shared.ui.combobox.FilteringMode
 */
package com.filemaker.jwpc.iwp.ui.statusarea.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFindField;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.shared.ui.combobox.FilteringMode;

public class QuickFind
extends CssLayout
implements StatusAreaComponent {
    private final App app;
    protected QuickFindField combo;
    private static final String QUICK_FIND_CLASS_NAME = "quickfind-searchbox";

    public QuickFind(App app) {
        this.app = app;
        this.setStyleName("quickfind");
        this.setSizeUndefined();
        this.addComboBox();
        LayoutContainer layoutContainer = app.getLayoutContainer();
        if (layoutContainer != null && layoutContainer.getCurrentView().getLayoutMetaData().quickFindDisabled()) {
            this.setEnabled(false);
        }
        this.addListeners();
        this.app.subscribe(this, EventType.LAYOUT_CHANGE, EventType.REFRESH_STATUS_AREA, EventType.WINDOW_CHANGE, EventType.RELOGIN_CHANGE, EventType.LOAD_CACHED_LAYOUT);
    }

    public void focus() {
        this.combo.focus();
    }

    private void addComboBox() {
        this.createComboBox();
        this.addComponent((Component)this.combo);
    }

    private void createComboBox() {
        this.combo = new QuickFindField(this.app);
        this.combo.setStyleName(QUICK_FIND_CLASS_NAME);
        this.combo.setImmediate(true);
        this.combo.setNewItemsAllowed(true);
        this.combo.setFilteringMode(FilteringMode.STARTSWITH);
        this.combo.getItemIds();
        this.combo.setInputPrompt(IWPI18N.get(this.app, "QUICK_FIND", new Object[0]));
        if (!AppServlet.isAriaCompliantControlEnabled()) {
            this.combo.setTabIndex(-1);
        }
        String string = IWPI18N.get(this.app, "QUICKSEARCH_TOOLTIP", new Object[0]);
        this.combo.setDescription(string, ContentMode.HTML);
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            this.setDescription(string, ContentMode.HTML);
        }
    }

    private void addListeners() {
        this.addClickListener();
    }

    protected void addClickListener() {
        this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                if (QuickFind.this.app.getActiveUIHandler().hasActiveField()) {
                    QuickFind.this.app.getActiveUIHandler().setQuickFindFocus(true);
                    QuickFind.this.app.getAppSession().onUIAction(UIActionType.PROCESS_QUICKFIND_CLICK, true);
                } else if (QuickFind.this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen()) {
                    QuickFind.this.app.getActiveUIHandler().setQuickFindFocus(true);
                    QuickFind.this.app.getLayoutContainer().getPopoverHandler().exitPopover(true);
                }
            }
        });
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case WINDOW_CHANGE: 
            case RELOGIN_CHANGE: 
            case LAYOUT_CHANGE: 
            case REFRESH_STATUS_AREA: 
            case LOAD_CACHED_LAYOUT: {
                this.refresh();
                break;
            }
        }
    }

    @Override
    public void refresh() {
        LayoutView layoutView = this.app.getLayoutContainer().getCurrentView();
        if (layoutView != null) {
            this.setEnabled(!layoutView.getLayoutMetaData().quickFindDisabled());
        }
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.combo.setEnabled(bl);
    }

    public void clearQuickFindSearchString() {
        if (this.combo != null) {
            this.combo.setValue(null);
        }
    }

    public String getQuickFindSeachString() {
        if (this.combo != null && this.combo.getValue() != null) {
            return this.combo.getValue().toString();
        }
        return "";
    }
}

