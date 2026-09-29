/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.server.Resource
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.NativeButton
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.action.ActionSupport;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ToolbarMenuItemServerRpc;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.v7.ui.Label;
import java.beans.PropertyChangeEvent;

public class ToolbarMenuItem
extends CssLayout
implements ActionSupport,
StatusAreaComponent {
    public static final int ITEM_HEIGHT_IN_PIXEL = 44;
    private static final int ITEM_WIDTH_IN_PIXEL = 280;
    private static final String CSS_SELECTOR_NAME = "toolbar-menuitem";
    protected final App app;
    private UIAction action;
    private NativeButton buttonImage;
    private Label caption;
    private String label;

    public ToolbarMenuItem(App app, UIAction uIAction) {
        this(app, null, uIAction);
    }

    public ToolbarMenuItem(App app, String string, UIAction uIAction) {
        this.label = string;
        this.app = app;
        this.init(uIAction);
        if (uIAction != null) {
            this.app.subscribe(this, EventType.REFRESH_TOOLBAR_MENU);
        }
        this.registerRpc(new ToolbarMenuItemServerRpc(){

            @Override
            public void performServerAction() {
                ToolbarMenuItem.this.performServerAction();
            }
        });
    }

    protected void init(UIAction uIAction) {
        this.setWidth(280.0f, Sizeable.Unit.PIXELS);
        this.addStyleName(CSS_SELECTOR_NAME);
        this.buttonImage = new NativeButton();
        this.buttonImage.setTabIndex(-1);
        this.addComponent((Component)this.buttonImage);
        if (Utilities.isValidText(this.label)) {
            this.caption = new Label(this.label);
            this.caption.setSizeUndefined();
            this.addComponent((Component)this.caption);
        }
        this.setAction(uIAction);
        this.addListeners();
    }

    public void setToolTip(String string) {
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            this.buttonImage.setDescription(string, ContentMode.HTML);
        }
    }

    public void setDescription(String string) {
        this.setToolTip(string);
    }

    private void addListeners() {
        this.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                ToolbarMenuItem.this.performAction(null, layoutClickEvent);
                ToolbarMenuItem.this.app.getStatusAreaContainer().exitPopover();
            }
        });
    }

    @Override
    public final void setAction(UIAction uIAction) {
        if (uIAction != null) {
            this.action = uIAction;
        }
    }

    @Override
    public void performAction(Object[] objectArray) {
        if (this.action != null) {
            this.action.perform(this.app, null);
        }
    }

    public void performAction(Object[] objectArray, LayoutEvents.LayoutClickEvent layoutClickEvent) {
        this.performAction(objectArray);
    }

    public boolean hasAction() {
        return this.action != null;
    }

    @Override
    public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!this.hasAction() || !this.app.getAppView().isCardStyleWindow() && this.app.getAppContainer().hasVisibleToolbarStatusAreaState()) {
            this.setEnabled((Boolean)propertyChangeEvent.getNewValue());
        }
    }

    public void setSource(ThemeResource themeResource) {
        this.buttonImage.setIcon((Resource)themeResource);
    }

    public NativeButton getButton() {
        return this.buttonImage;
    }

    public String getMenuText() {
        return this.label;
    }

    @Override
    public void refresh() {
        if (this.hasAction()) {
            boolean bl = this.action.isEnabledFor(this.app);
            if (this.isEnabled() != bl) {
                this.setEnabled(bl);
            }
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case REFRESH_TOOLBAR_MENU: {
                this.refresh();
                break;
            }
        }
    }

    protected void performServerAction() {
        this.performAction(null);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }
}

