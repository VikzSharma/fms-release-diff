/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.v7.client.ui.AbstractFieldConnector
 */
package com.filemaker.fields.client.common;

import com.filemaker.fields.client.common.FMClientRpc;
import com.filemaker.fields.client.common.FMServerRpc;
import com.filemaker.fields.client.common.FMState;
import com.filemaker.fields.client.common.FMWidget;
import com.filemaker.fields.client.common.LineBreakBlockedListener;
import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPortalTable;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.v7.client.ui.AbstractFieldConnector;

public class FMConnector
extends AbstractFieldConnector
implements LineBreakBlockedListener,
FocusBlurHandler {
    private Timer cursorPositionUpdater;

    protected void init() {
        super.init();
        this.registerRpc(FMClientRpc.class, new FMClientRpcImpl());
        this.getWidget().setFMConnector(this);
        this.getWidget().addTextBoxFocusHandler(this);
        this.getWidget().addLineBreakBlockedListener(this);
    }

    public FMState getState() {
        return (FMState)super.getState();
    }

    public FMWidget getWidget() {
        return (FMWidget)super.getWidget();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setReadOnly(this.isReadOnly());
        this.getWidget().setInputPrompt(this.getState().inputPrompt);
        this.updateEnabledState(this.getState().enabled);
    }

    public void attemptFocus() {
        if (this.isEnabled() && !this.isReadOnly() && !this.getWidget().isEditable() && this.getWidget().attemptFocus()) {
            this.startEdit();
        }
    }

    public void onFocus(FocusEvent focusEvent) {
        if (BrowserInfo.get().isSafari() || BrowserInfo.get().isChrome()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    FMConnector.this.attemptScrollIntoView();
                }
            });
        }
    }

    private void attemptScrollIntoView() {
        if (!FMCUtilities.isElementPartiallyInViewport((Element)this.getWidget().getElement())) {
            this.getWidget().getElement().scrollIntoView();
        }
    }

    public void onBlur(BlurEvent blurEvent) {
        if (!this.getWidget().hasFocus()) {
            this.getWidget().removeStyleName("focused");
            this.stopCursorPositionUpdater();
            this.getWidget().setEditable(false);
            if (this.isEnabled() && !this.isReadOnly() && this.hasEventListener("blur")) {
                ((FMServerRpc)this.getRpcProxy(FMServerRpc.class)).handleBlur();
            }
            if (this.getWidget().isResetScrollPositionOnExit()) {
                this.getWidget().resetScrollPosition();
            }
        }
    }

    @Override
    public void lineBreakBlocked() {
        ((FMServerRpc)this.getRpcProxy(FMServerRpc.class)).handleBlockedLineBreak();
    }

    public void setSelectionRange(int n, int n2) {
        this.getWidget().setSelectionRange(n, n2);
    }

    public void selectAll() {
        this.getWidget().selectAll();
        int[] nArray = this.getWidget().getSelectionRange();
        ((FMServerRpc)this.getRpcProxy(FMServerRpc.class)).updateSelectionRange(nArray[0], nArray[1]);
    }

    public void startEdit() {
        if (!this.isReadOnly() && this.isEnabled() && !this.getWidget().isEditable()) {
            this.getWidget().prepareForFocus();
            this.getWidget().setEditable(true);
            this.startCursorPositionUpdater();
            VCustomPortalTable vCustomPortalTable = (VCustomPortalTable)FMCUtilities.getOwningPortal((Widget)this.getWidget());
            if (vCustomPortalTable != null) {
                if (!vCustomPortalTable.hasNewRows()) {
                    int[] nArray = this.getWidget().getSelectionRange();
                    vCustomPortalTable.checkNewRows(nArray);
                } else {
                    int[] nArray = vCustomPortalTable.processNewRows();
                    if (nArray != null) {
                        this.getWidget().setSelectionRange(nArray[0], nArray[1]);
                    }
                }
            }
        }
        FMCUtilities.setCanHandleTabKeyDown(true);
    }

    private void stopCursorPositionUpdater() {
        if (this.cursorPositionUpdater != null) {
            this.cursorPositionUpdater.cancel();
            this.cursorPositionUpdater = null;
        }
    }

    private void startCursorPositionUpdater() {
        if (this.cursorPositionUpdater == null) {
            this.cursorPositionUpdater = new Timer(){
                private int lastPos = -1;
                private int lastLength = 0;

                public void run() {
                    int[] nArray = FMConnector.this.getWidget().getSelectionRange();
                    if (this.lastPos != nArray[0] || this.lastLength != nArray[1]) {
                        this.lastPos = nArray[0];
                        this.lastLength = nArray[1];
                        ((FMServerRpc)FMConnector.this.getRpcProxy(FMServerRpc.class)).updateSelectionRange(nArray[0], nArray[1]);
                    }
                }
            };
            this.cursorPositionUpdater.scheduleRepeating(300);
        }
    }

    public void setPendingNavigationFocus() {
        this.getWidget().setPendingNavigationFocus();
    }

    public void checkNavigationFocus() {
        this.getWidget().checkNavigationFocus();
    }

    public class FMClientRpcImpl
    implements FMClientRpc {
        @Override
        public void setSelectionRange(final int n, final int n2) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
                final /* synthetic */ FMClientRpcImpl this$1;
                {
                    this.this$1 = fMClientRpcImpl;
                }

                public void execute() {
                    this.this$1.FMConnector.this.setSelectionRange(n, n2);
                }
            });
        }

        @Override
        public void setSelectionRangeImmediately(int n, int n2) {
            FMConnector.this.setSelectionRange(n, n2);
        }

        @Override
        public void selectAll() {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    FMConnector.this.selectAll();
                }
            });
        }

        @Override
        public void startEdit() {
            FMConnector.this.getWidget().setFocus(true);
            FMConnector.this.startEdit();
        }

        @Override
        public void performModify() {
            FMConnector.this.getWidget().performModify();
        }

        @Override
        public void performNavigationFocus() {
            FMConnector.this.getWidget().performNavigationFocus();
        }

        @Override
        public void syncServerValue() {
            FMConnector.this.getWidget().syncServerValue();
        }

        @Override
        public void blockTabbing() {
            if (BrowserInfo.get().isIOS()) {
                FMConnector.this.getWidget().blockTabbing();
            }
        }

        @Override
        public void unblockTabbing() {
            if (BrowserInfo.get().isIOS()) {
                FMConnector.this.getWidget().unblockTabbing();
            }
        }

        @Override
        public void resyncServerValue(String string) {
            FMConnector.this.getWidget().resyncServerValue(string);
        }
    }
}

