/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenuItem;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.menu.Menu;
import java.beans.PropertyChangeEvent;

public class StatusAreaMenuItem
extends IWPMenuItem
implements StatusAreaComponent {
    public StatusAreaMenuItem(App app, Menu.MenuItem menuItem) {
        super(app, menuItem);
    }

    @Override
    public IWPMenuItem addItem(String string, Menu.Command command) {
        return new StatusAreaMenuItem(this.app, this.menuItem.addItem(string, command));
    }

    @Override
    public IWPMenuItem getParent() {
        Menu.MenuItem menuItem = this.menuItem.getParent();
        if (menuItem != null) {
            return new StatusAreaMenuItem(this.app, menuItem);
        }
        return null;
    }

    @Override
    public void setActionWithoutShortCutString(UIAction uIAction) {
        super.setActionWithoutShortCutString(uIAction);
        if (this.action != null) {
            this.app.subscribe(this, EventType.REFRESH_STATUS_AREA);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!this.app.getAppView().isCardStyleWindow() && this.app.getAppContainer().hasVisibleToolbarStatusAreaState()) {
            super.propertyChange(propertyChangeEvent);
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case REFRESH_STATUS_AREA: {
                this.refresh();
            }
        }
    }
}

