/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$BlurListener
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.ui.JavaScript
 *  com.vaadin.v7.ui.HorizontalLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.StatusAreaComponent;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.JavaScript;
import com.vaadin.v7.ui.HorizontalLayout;

public abstract class RecordsNavigator
extends HorizontalLayout
implements StatusAreaComponent {
    private static final String NAVIGATOR_CSS_SELECTOR_NAME = "navigator";
    public static final int IMAGE_SMALL_WIDTH = 60;
    public static final int IMAGE_LARGE_WIDTH = 70;
    public static final String NAVIGATOR_SMALL_CSS_SELECTOR_NAME = "navigator small";
    public static final String NAVIGATOR_LARGE_CSS_SELECTOR_NAME = "navigator large";
    protected App app;
    protected final ToolbarButton previous;
    protected final ToolbarButton next;
    protected int currentRecordIndex;
    private boolean hasPrevFocus = false;
    private boolean hasNextFocus = false;

    public RecordsNavigator(App app) {
        this.app = app;
        this.setSpacing(false);
        this.setMargin(false);
        this.setSizeUndefined();
        this.setStyleName(NAVIGATOR_CSS_SELECTOR_NAME);
        JavaScript javaScript = app.getPage().getJavaScript();
        this.previous = new ToolbarButton(app, GlobalUIActionHandlers.GOTO_PREV_ROW);
        this.previous.addStyleName("previousbutton");
        this.previous.getButton().setId("previousbutton");
        String string = IWPI18N.get(app, "NAVIGATOR_PREVIOUS_TOOLTIP", new Object[0]);
        this.previous.setToolTip(string);
        String string2 = String.format("document.getElementById('previousbutton').setAttribute('aria-label', '%s');", string);
        javaScript.execute(string2);
        this.next = new ToolbarButton(app, GlobalUIActionHandlers.GOTO_NEXT_ROW);
        this.next.addStyleName("nextbutton");
        this.next.getButton().setId("nextbutton");
        String string3 = IWPI18N.get(app, "NAVIGATOR_NEXT_TOOLTIP", new Object[0]);
        this.next.setToolTip(string3);
        String string4 = String.format("document.getElementById('nextbutton').setAttribute('aria-label', '%s');", string3);
        javaScript.execute(string4);
        this.updateButtonStatus();
        this.currentRecordIndex = app.getLayoutDataModel().getRecordIndex();
        app.subscribe(this, EventType.FOUND_RECORDS_CHANGE, EventType.RECORD_INDEX_CHANGE, EventType.REFRESH_STATUS_AREA);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.previous.getButton().addFocusListener(new FieldEvents.FocusListener(){

                public void focus(FieldEvents.FocusEvent focusEvent) {
                    RecordsNavigator.this.hasPrevFocus = true;
                    RecordsNavigator.this.hasNextFocus = false;
                }
            });
            this.previous.getButton().addBlurListener(new FieldEvents.BlurListener(){

                public void blur(FieldEvents.BlurEvent blurEvent) {
                    RecordsNavigator.this.hasPrevFocus = false;
                }
            });
            this.next.getButton().addFocusListener(new FieldEvents.FocusListener(){

                public void focus(FieldEvents.FocusEvent focusEvent) {
                    RecordsNavigator.this.hasPrevFocus = false;
                    RecordsNavigator.this.hasNextFocus = true;
                }
            });
            this.next.getButton().addBlurListener(new FieldEvents.BlurListener(){

                public void blur(FieldEvents.BlurEvent blurEvent) {
                    RecordsNavigator.this.hasNextFocus = false;
                }
            });
        }
    }

    public void invalidate() {
        this.previous.invalidate();
        this.next.invalidate();
        this.hasPrevFocus = false;
        this.hasNextFocus = false;
        this.app.unsubscribeAllType(this);
        this.app = null;
    }

    private void updateButtonStatus() {
        this.next.refresh();
        this.previous.refresh();
        if (this.hasPrevFocus && !this.previous.isEnabled()) {
            this.hasPrevFocus = false;
            this.next.getButton().focus();
        } else if (this.hasNextFocus && !this.next.isEnabled()) {
            this.hasNextFocus = false;
            this.previous.getButton().focus();
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case FOUND_RECORDS_CHANGE: 
            case RECORD_INDEX_CHANGE: 
            case REFRESH_STATUS_AREA: {
                this.currentRecordIndex = this.app.getLayoutDataModel().getRecordIndex();
                this.updateButtonStatus();
                break;
            }
        }
    }

    @Override
    public void refresh() {
    }
}

