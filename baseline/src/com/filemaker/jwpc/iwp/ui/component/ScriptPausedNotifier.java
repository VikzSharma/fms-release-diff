/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.customwidgets.OverlayNotification;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;

public class ScriptPausedNotifier
extends CssLayout {
    private final App appRoot;

    public ScriptPausedNotifier(App app, boolean bl) {
        this.appRoot = app;
        this.addComponent((Component)new ScriptPausedNotifique(bl));
        this.setSizeUndefined();
    }

    public boolean isAllowAbort() {
        return ((ScriptPausedNotifique)this.getComponent(0)).isAllowAbort();
    }

    public void update(boolean bl) {
        ((ScriptPausedNotifique)this.getComponent(0)).update(bl);
    }

    public void setVisible(boolean bl) {
        ((ScriptPausedNotifique)this.getComponent(0)).setVisible(bl);
    }

    private class ScriptPausedNotifique
    extends OverlayNotification {
        boolean allowAbort = true;
        final Button cancelBtn;

        private ScriptPausedNotifique(boolean bl) {
            this.cancelBtn = new Button(IWPI18N.get(ScriptPausedNotifier.this.appRoot, "CANCEL", new Object[0]));
            this.allowAbort = bl;
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setMargin(false);
            horizontalLayout.setSpacing(false);
            horizontalLayout.setWidth("100%");
            horizontalLayout.setHeight("30px");
            Label label = new Label(IWPI18N.get(ScriptPausedNotifier.this.appRoot, "SCRIPT_PAUSED_MESSAGE", new Object[0]));
            horizontalLayout.addComponent((Component)label);
            horizontalLayout.setComponentAlignment((Component)label, Alignment.MIDDLE_LEFT);
            Button button = new Button(IWPI18N.get(ScriptPausedNotifier.this.appRoot, "CONTINUE", new Object[0]));
            button.setStyleName("small");
            button.addStyleName("fm-small-button");
            button.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    ScriptPausedNotifique.this.performContinue(clickEvent);
                }
            });
            horizontalLayout.addComponent((Component)button);
            horizontalLayout.setComponentAlignment((Component)button, Alignment.MIDDLE_RIGHT);
            this.cancelBtn.setStyleName("small");
            this.cancelBtn.addStyleName("fm-small-button");
            this.cancelBtn.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    ScriptPausedNotifique.this.performCancel(clickEvent);
                }
            });
            horizontalLayout.addComponent((Component)this.cancelBtn);
            horizontalLayout.setComponentAlignment((Component)this.cancelBtn, Alignment.MIDDLE_RIGHT);
            if (!bl) {
                this.cancelBtn.setVisible(false);
            }
            Label label2 = new Label("");
            label2.setWidth("9px");
            horizontalLayout.addComponent((Component)label2);
            horizontalLayout.setExpandRatio((Component)label, 1.0f);
            this.addComponent((Component)horizontalLayout);
        }

        private boolean isAllowAbort() {
            return this.allowAbort;
        }

        private void update(boolean bl) {
            if (this.allowAbort != bl) {
                this.allowAbort = bl;
                this.cancelBtn.setVisible(bl);
            }
        }

        private void performContinue(Button.ClickEvent clickEvent) {
            GlobalUIActionHandlers.RESUME_SCRIPT.perform(ScriptPausedNotifier.this.appRoot, null);
            this.setVisible(false);
        }

        private void performCancel(Button.ClickEvent clickEvent) {
            ScriptPausedNotifier.this.appRoot.getAM().perform(ScriptPausedNotifier.this.appRoot, UIActionType.EXIT_SCRIPT);
            this.setVisible(false);
        }
    }
}

