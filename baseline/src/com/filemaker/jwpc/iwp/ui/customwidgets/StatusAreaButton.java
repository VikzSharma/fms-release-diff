/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.NativeButton
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.action.ActionSupport;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.StatusAreaButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaButtonState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.v7.ui.Label;
import java.beans.PropertyChangeEvent;

public class StatusAreaButton
extends CssLayout
implements ActionSupport,
StatusAreaComponent {
    protected final App app;
    private UIAction action;
    private NativeButton currentImage;
    private Label caption;
    private String label;
    private Button.ClickListener clickListener;

    public StatusAreaButton(App app, UIAction uIAction) {
        this(app, null, uIAction);
    }

    public StatusAreaButton(App app, String string, UIAction uIAction) {
        this.label = string;
        this.app = app;
        this.init(uIAction);
        if (uIAction != null) {
            this.app.subscribe(this, EventType.REFRESH_STATUS_AREA);
        }
        this.registerRpc(new StatusAreaButtonServerRpc(){

            @Override
            public void performServerAction() {
                StatusAreaButton.this.performServerAction();
            }
        });
    }

    private void init(UIAction uIAction) {
        this.currentImage = new NativeButton();
        this.addComponent((Component)this.currentImage);
        if (Utilities.isValidText(this.label)) {
            this.caption = new Label(this.label);
            this.caption.setSizeUndefined();
            this.addComponent((Component)this.caption);
        }
        this.setAction(uIAction);
        this.addListeners();
    }

    public void invalidate() {
        if (this.action != null) {
            this.action.removePropertyChangeListener(this);
        }
        if (this.clickListener != null) {
            this.currentImage.removeClickListener(this.clickListener);
        }
    }

    public StatusAreaButtonState getState() {
        return (StatusAreaButtonState)super.getState();
    }

    public void setToolTip(String string) {
        this.getState().ariaLabel = string;
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            this.currentImage.setDescription(string, ContentMode.HTML);
            this.updateBooleanState(StatusAreaButtonState.BooleanState.showTooltip, this.showToolTip());
        }
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.updateBooleanState(StatusAreaButtonState.BooleanState.showTooltip, this.showToolTip());
    }

    private boolean showToolTip() {
        return !Utilities.isEmptyString(this.currentImage.getDescription()) && this.isEnabled();
    }

    public void setDescription(String string) {
        this.setToolTip(string);
    }

    protected void addListeners() {
        this.clickListener = new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                StatusAreaButton.this.performAction(null);
            }
        };
        this.currentImage.addClickListener(this.clickListener);
    }

    @Override
    public final void setAction(UIAction uIAction) {
        if (uIAction != null) {
            this.action = uIAction;
            this.action.addPropertyChangeListener(this);
        }
    }

    @Override
    public void performAction(Object[] objectArray) {
        if (this.action != null) {
            this.action.perform(this.app, null);
        }
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
        this.currentImage.setIcon((Resource)themeResource);
    }

    public NativeButton getButton() {
        return this.currentImage;
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
            case REFRESH_STATUS_AREA: {
                this.refresh();
                break;
            }
        }
    }

    private void updateBooleanState(StatusAreaButtonState.BooleanState booleanState, boolean bl) {
        this.getState().sbbs = IWPUtilities.applyBooleanValue(this.getState().sbbs, booleanState.ordinal(), bl);
    }

    protected void performServerAction() {
        this.performAction(null);
    }
}

