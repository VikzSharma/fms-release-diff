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
 *  org.vaadin.kim.countdownclock.CountdownClock
 *  org.vaadin.kim.countdownclock.CountdownClock$EndEventListener
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.customwidgets.OverlayNotification;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.ui.HorizontalLayout;
import java.util.Calendar;
import org.vaadin.kim.countdownclock.CountdownClock;

public class CloseRequestNotifier
extends CssLayout {
    private App app;

    public CloseRequestNotifier(App app, int n, int n2) {
        this.app = app;
        this.addComponent((Component)new CloseRequestNotifique(n2));
        this.setSizeUndefined();
    }

    public int getTimeout() {
        return ((CloseRequestNotifique)this.getComponent(0)).getTimeout();
    }

    public void update(int n) {
        ((CloseRequestNotifique)this.getComponent(0)).update(n);
    }

    public void setVisible(boolean bl) {
        ((CloseRequestNotifique)this.getComponent(0)).setVisible(bl);
    }

    private class CloseRequestNotifique
    extends OverlayNotification {
        int timeout = 0;

        private CloseRequestNotifique(int n) {
            this.timeout = n;
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setMargin(false);
            horizontalLayout.setSpacing(true);
            horizontalLayout.setSizeFull();
            horizontalLayout.setHeight("20px");
            CountdownClock countdownClock = new CountdownClock();
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, n);
            countdownClock.setDate(calendar.getTime());
            countdownClock.setFormat(IWPI18N.get(CloseRequestNotifier.this.app, "SESSION_TIMEOUT_TIMER", new Object[0]));
            countdownClock.setHeight("40px");
            countdownClock.addListener(new CountdownClock.EndEventListener(){

                public void countDownEnded(CountdownClock countdownClock) {
                    CloseRequestNotifier.this.app.forceClose(true, true, null);
                }
            });
            horizontalLayout.addComponent((Component)countdownClock);
            horizontalLayout.setComponentAlignment((Component)countdownClock, Alignment.MIDDLE_LEFT);
            Button button = new Button(IWPI18N.get(CloseRequestNotifier.this.app, "LOG_OUT", new Object[0]));
            button.setStyleName("small");
            button.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    CloseRequestNotifier.this.app.attemptSessionLogout();
                }
            });
            horizontalLayout.addComponent((Component)button);
            horizontalLayout.setComponentAlignment((Component)button, Alignment.MIDDLE_RIGHT);
            Button button2 = new Button(IWPI18N.get(CloseRequestNotifier.this.app, "DISMISS", new Object[0]));
            button2.setStyleName("small");
            button2.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    CloseRequestNotifique.this.performClose(clickEvent);
                }
            });
            horizontalLayout.addComponent((Component)button2);
            horizontalLayout.setComponentAlignment((Component)button2, Alignment.MIDDLE_RIGHT);
            horizontalLayout.setExpandRatio((Component)countdownClock, 1.0f);
            this.addComponent((Component)horizontalLayout);
        }

        private int getTimeout() {
            return this.timeout;
        }

        private void update(int n) {
            this.timeout = n;
        }

        private void performClose(Button.ClickEvent clickEvent) {
            this.setVisible(false);
        }
    }
}

