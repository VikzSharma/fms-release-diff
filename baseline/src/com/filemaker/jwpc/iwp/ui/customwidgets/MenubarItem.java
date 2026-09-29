/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenuItem;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.menubar.MenubarComponent;
import com.filemaker.menu.Menu;
import java.beans.PropertyChangeEvent;

public class MenubarItem
extends IWPMenuItem
implements MenubarComponent {
    public MenubarItem(App app, Menu.MenuItem menuItem) {
        super(app, menuItem);
    }

    @Override
    public IWPMenuItem addItem(String string, Menu.Command command) {
        return new MenubarItem(this.app, this.menuItem.addItem(string, command));
    }

    @Override
    public IWPMenuItem getParent() {
        Menu.MenuItem menuItem = this.menuItem.getParent();
        if (menuItem != null) {
            return new MenubarItem(this.app, menuItem);
        }
        return null;
    }

    @Override
    public void setActionWithoutShortCutString(UIAction uIAction) {
        super.setActionWithoutShortCutString(uIAction);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!this.app.getAppView().isCardStyleWindow() && this.app.getAppContainer() != null && this.app.getAppContainer().hasVisibleMenubarState()) {
            super.propertyChange(propertyChangeEvent);
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
    }
}

