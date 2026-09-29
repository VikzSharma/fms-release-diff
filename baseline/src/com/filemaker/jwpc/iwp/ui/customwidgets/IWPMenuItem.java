/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ThemeResource
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.action.ActionSupport;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.menu.Menu;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import java.beans.PropertyChangeEvent;

public abstract class IWPMenuItem
implements ActionSupport {
    protected static final ThemeResource CHECKBOX = new ThemeResource("images/check-arrow.gif");
    protected final App app;
    protected Menu.MenuItem menuItem;
    protected UIAction action;

    public IWPMenuItem(App app, Menu.MenuItem menuItem) {
        this.app = app;
        this.menuItem = menuItem;
    }

    public void invalidate() {
        if (this.action != null) {
            this.action.removePropertyChangeListener(this);
            this.action = null;
        }
    }

    public abstract IWPMenuItem addItem(String var1, Menu.Command var2);

    public abstract IWPMenuItem getParent();

    @Override
    public void setAction(UIAction uIAction) {
        this.menuItem.setText(this.menuItem.getText());
        this.setActionWithoutShortCutString(uIAction);
    }

    public void setActionWithoutShortCutString(UIAction uIAction) {
        this.action = uIAction;
        uIAction.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        boolean bl = (Boolean)propertyChangeEvent.getNewValue();
        if (this.menuItem.isEnabled() != bl) {
            this.menuItem.setEnabled(bl);
        }
    }

    public void addSeparator() {
        this.menuItem.addSeparator();
    }

    public void setIcon(Resource resource) {
        this.menuItem.setIcon(resource);
    }

    public String getText() {
        return this.menuItem.getText();
    }

    public void setText(String string) {
        this.menuItem.setText(string);
    }

    public void setCommand(Menu.Command command) {
        this.menuItem.setCommand(command);
    }

    public void setVisible(boolean bl) {
        this.menuItem.setVisible(bl);
    }

    public Menu.MenuItem getMenuItem() {
        return this.menuItem;
    }

    public void setCheckable(boolean bl) {
        this.menuItem.setCheckable(bl);
    }

    public boolean isCheckable() {
        return this.menuItem.isCheckable();
    }

    public void setChecked(boolean bl) {
        if (this.menuItem.isChecked() != bl) {
            this.menuItem.setChecked(bl);
        }
    }

    public boolean isChecked() {
        return this.menuItem.isChecked();
    }

    @Override
    public void performAction(Object[] objectArray) {
        if (this.action != null) {
            this.action.perform(this.app, null);
        }
    }

    public boolean isVisible() {
        return this.menuItem.isVisible();
    }

    public int getID() {
        return this.menuItem.getId();
    }

    public void refresh() {
        if (this.action != null && this.menuItem.isEnabled() != this.action.isEnabledFor(this.app)) {
            this.menuItem.setEnabled(this.action.isEnabledFor(this.app));
        }
    }
}

