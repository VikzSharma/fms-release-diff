/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.EventBus
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.HTML
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.menu.widgetset.client.desktop;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class UserInfoWidget
extends FlowPanel {
    private HTML loggedInHTML;
    private Widget logoutWidget;
    private String userName;
    private String loggedInText;

    public UserInfoWidget(EventBus eventBus) {
        this.setStyleName("fm-user-info");
        this.loggedInHTML = new HTML("");
        this.loggedInHTML.setStyleName("fm-loggedin");
        this.add((Widget)this.loggedInHTML);
    }

    public void setLoggedInText(String string) {
        this.loggedInText = string;
        this.loggedInHTML.setHTML("<div>" + string + "</div><div class='fm-username'>" + this.userName + "</div>");
    }

    public void setUserName(String string) {
        this.userName = string;
        this.loggedInHTML.setHTML("<div>" + this.loggedInText + "</div><div class='fm-username'>" + string + "</div>");
    }

    public void setLogoutButton(Widget widget) {
        if (this.logoutWidget != null) {
            this.logoutWidget.removeFromParent();
        }
        this.logoutWidget = widget;
        if (widget != null) {
            this.add(widget);
        }
    }
}

