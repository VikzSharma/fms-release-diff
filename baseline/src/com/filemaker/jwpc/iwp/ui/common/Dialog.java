/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.server.VaadinSession
 *  com.vaadin.server.VaadinSession$State
 *  com.vaadin.shared.Registration
 *  com.vaadin.shared.ui.MarginInfo
 *  com.vaadin.ui.AbstractOrderedLayout
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseEvent
 *  com.vaadin.ui.Window$CloseListener
 *  com.vaadin.ui.Window$CloseShortcut
 *  com.vaadin.v7.data.Validator
 *  com.vaadin.v7.data.Validator$InvalidValueException
 *  com.vaadin.v7.ui.AbstractTextField
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.common.DialogButton;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.event.Action;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.v7.data.Validator;
import com.vaadin.v7.ui.AbstractTextField;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;

public abstract class Dialog
extends Window {
    public static final int DEFAULT_DIALOG_WIDTH = 450;
    public final long checkMillis = 100L;
    protected App app;
    protected VerticalLayout root;
    private AbstractOrderedLayout buttons;
    protected ButtonOption buttonOption;
    private DialogButton leftButton;
    private DialogButton middleButton;
    private DialogButton rightButton;
    private boolean isGetterTaskInProgress;
    private boolean hasWidthConstraint = true;
    private Registration initFocusListenerReg = null;
    protected boolean enableTouchUI = false;

    public Dialog(App app, String string) {
        this(app, string, ButtonOption.LEFT);
    }

    public Dialog(App app, String string, ButtonOption buttonOption) {
        super(string);
        this.app = app;
        this.buttonOption = buttonOption;
        this.init();
        this.addCloseListener(new Window.CloseListener(){

            public void windowClose(Window.CloseEvent closeEvent) {
                Dialog.this.onWindowClose(closeEvent);
            }
        });
    }

    protected void init() {
        this.onInitDialog();
        this.setModal(true);
        this.setClosable(false);
        this.setResizable(false);
        if (this.app.isTouchUI()) {
            this.setDraggable(false);
        }
        this.setDialogWidth();
        this.root = new VerticalLayout();
        this.root.setSpacing(true);
        this.root.setMargin(true);
        this.setContent((Component)this.root);
        this.addCloseShortcut(27, new int[0]);
    }

    public void addCloseShortcut(int n, int ... nArray) {
        this.addAction((Action)new Window.CloseShortcut(this, n, nArray){

            public void handleAction(Object object, Object object2) {
                Dialog.this.closeDialog();
            }
        });
    }

    protected void onInitDialog() {
        this.enableTouchUI = false;
    }

    protected void setHasWidthConstraint(boolean bl) {
        this.hasWidthConstraint = bl;
    }

    protected void setDialogWidth(int n) {
        int n2;
        int n3 = n2 = n > 0 ? n : 450;
        if (this.isTouchUI()) {
            this.setWidth(95.0f, Sizeable.Unit.PERCENTAGE);
        } else {
            this.setWidth(n2, Sizeable.Unit.PIXELS);
        }
    }

    protected void setDialogHeight(int n) {
        int n2 = n;
        this.setHeight(n2, Sizeable.Unit.PIXELS);
    }

    protected void setDialogWidth() {
        this.setDialogWidth(450);
    }

    protected void initContent(Component component) {
        this.root.addComponent(component);
        this.root.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        this.root.setExpandRatio(component, 1.0f);
        this.setStyles();
    }

    protected void setStyles() {
        this.addStyleName("fm-modal-dialog");
        if (this.isTouchUI()) {
            this.addStyleName("fm-touch-dialog");
            if (this.hasWidthConstraint) {
                this.addStyleName("fm-touch-minmax");
            }
        }
    }

    protected void initButtons(String string, String string2, String string3) {
        if (this.buttons == null && !this.buttonOption.equals((Object)ButtonOption.NONE)) {
            this.buttons = new HorizontalLayout();
            this.buttons.setSpacing(true);
            this.buttons.setMargin(new MarginInfo(true, false, false, !this.isTouchUI()));
            this.leftButton = new DialogButton(this.app, string, this);
            switch (this.buttonOption.ordinal()) {
                case 1: {
                    this.rightButton = new DialogButton(this.app, string3, this);
                    break;
                }
                case 2: {
                    this.middleButton = new DialogButton(this.app, string2, this);
                    this.rightButton = new DialogButton(this.app, string3, this);
                    break;
                }
            }
            this.setButtonDefaults();
            this.addButtonListeners();
            if (this.getPositionX() != -1 || this.getPositionY() != -1) {
                this.root.setSizeFull();
            }
            this.root.addComponent((Component)this.buttons);
            Alignment alignment = Alignment.BOTTOM_RIGHT;
            if (this.isTouchUI()) {
                this.buttons.setSizeFull();
                alignment = Alignment.BOTTOM_CENTER;
            }
            this.root.setComponentAlignment((Component)this.buttons, alignment);
        }
    }

    protected void setButtonDefaults() {
        switch (this.buttonOption.ordinal()) {
            case 0: {
                this.setLeftButtonDefault();
                break;
            }
            case 1: {
                this.setLeftButtonDefault();
                break;
            }
            case 2: {
                this.setMiddleButtonDefault();
                break;
            }
        }
    }

    protected void hideButtons() {
        if (this.buttons != null) {
            this.buttons.setVisible(false);
            this.root.setComponentAlignment((Component)this.buttons, Alignment.BOTTOM_CENTER);
        }
    }

    private void addButtonListeners() {
        if (this.leftButton != null) {
            this.leftButton.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    Dialog.this.performLeftButtonAction(clickEvent);
                }
            });
            this.buttons.addComponent((Component)this.leftButton);
            if (this.isTouchUI()) {
                this.leftButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
                this.buttons.setExpandRatio((Component)this.leftButton, 1.0f);
            }
        }
        if (this.middleButton != null) {
            this.middleButton.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    Dialog.this.performMiddleButtonAction(clickEvent);
                }
            });
            this.buttons.addComponent((Component)this.middleButton);
            if (this.isTouchUI()) {
                this.middleButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
                this.buttons.setExpandRatio((Component)this.middleButton, 1.0f);
            }
        }
        if (this.rightButton != null) {
            this.rightButton.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    Dialog.this.performRightButtonAction(clickEvent);
                }
            });
            this.buttons.addComponent((Component)this.rightButton);
            if (this.isTouchUI()) {
                this.rightButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
                this.buttons.setExpandRatio((Component)this.rightButton, 1.0f);
            }
        }
    }

    protected final App getApplicationRoot() {
        return this.app;
    }

    public final void setApplicationRoot(App app) {
        this.app = app;
    }

    protected final DialogButton getLeftButton() {
        return this.leftButton;
    }

    protected final DialogButton getMiddleButton() {
        return this.middleButton;
    }

    protected final DialogButton getRightButton() {
        return this.rightButton;
    }

    protected void setLeftButtonDisabled() {
        if (this.leftButton != null) {
            this.leftButton.setEnabled(false);
            this.app.pushChanges();
        }
    }

    protected void setLeftButtonDefault() {
        this.clearButtonStyles();
        Utilities.makeDefaultButton(this.leftButton);
    }

    protected void setMiddleButtonDefault() {
        this.clearButtonStyles();
        if (this.middleButton != null) {
            Utilities.makeDefaultButton(this.middleButton);
        }
    }

    protected void setRightButtonDefault() {
        this.clearButtonStyles();
        if (this.rightButton != null) {
            this.rightButton.setEnabled(true);
            Utilities.makeDefaultButton(this.rightButton);
        }
    }

    protected void setRightButtonDisabled() {
        if (this.rightButton != null) {
            this.rightButton.setEnabled(false);
            this.app.pushChanges();
        }
    }

    protected void setRightButtonEnabled() {
        if (this.rightButton != null) {
            this.rightButton.setEnabled(true);
            this.app.pushChanges();
        }
    }

    protected void clearButtonStyles() {
        if (this.leftButton != null) {
            this.leftButton.removeStyleName("primary");
            this.leftButton.removeClickShortcut();
        }
        if (this.rightButton != null) {
            this.rightButton.removeStyleName("primary");
            this.rightButton.removeClickShortcut();
        }
        if (this.middleButton != null) {
            this.middleButton.removeStyleName("primary");
            this.middleButton.removeClickShortcut();
        }
    }

    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.closeDialog();
    }

    protected void performMiddleButtonAction(Button.ClickEvent clickEvent) {
        this.closeDialog();
    }

    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.closeDialog();
    }

    protected String getLeftButtonText() {
        String string = null;
        switch (this.buttonOption.ordinal()) {
            case 0: {
                string = IWPI18N.get(this.app, "OK", new Object[0]);
                break;
            }
            case 1: {
                string = IWPI18N.get(this.app, "CANCEL", new Object[0]);
                break;
            }
            case 2: {
                string = IWPI18N.get(this.app, "CLOSE", new Object[0]);
            }
        }
        return string;
    }

    protected String getMiddleButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "OK", new Object[0]);
    }

    protected void onWindowClose(Window.CloseEvent closeEvent) {
        this.enableLayoutTabOrder(true);
        this.setVisible(false);
    }

    public void closeDialog() {
        this.app.enableTouchScroll(true);
        this.setVisible(false);
        if (this.getParent() != null) {
            ((UI)this.getParent()).removeWindow((Window)this);
        }
        this.app.pushChanges();
    }

    public void setVisible(boolean bl) {
        if (this.app.isDatabaseOpen()) {
            this.app.updateShortcutHandlingOnClient(!bl);
        }
        super.setVisible(bl);
        this.app.setDialogOn(bl, this);
    }

    public void closeAndCancelDialog() {
        this.performLeftButtonAction(null);
        this.closeDialog();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean showDialog() {
        boolean bl = false;
        VaadinSession vaadinSession = this.app.getSession();
        if (this.app != null && this.app.getSession() != null && vaadinSession.getState() == VaadinSession.State.OPEN) {
            boolean bl2;
            boolean bl3 = bl2 = !vaadinSession.hasLock();
            if (bl2) {
                vaadinSession.lock();
            }
            try {
                if (this.app.isDatabaseOpen()) {
                    this.app.updateShortcutHandlingOnClient(false);
                }
                this.app.getAppView().closeContextMenu();
                if (this.getPositionX() == -1 || this.getPositionY() == -1) {
                    this.center();
                }
                this.setVisible(false);
                if (this.app.getWindows().contains((Object)this)) {
                    this.app.removeWindow(this);
                }
                this.app.addWindow(this);
                this.enableLayoutTabOrder(false);
                this.app.enableTouchScroll(false);
                bl = true;
                this.setVisible(true);
                this.focus();
                this.app.pushChanges();
                this.app.getActiveUIHandler().setPendingRefresh();
            }
            catch (Exception exception) {
            }
            finally {
                if (bl2) {
                    vaadinSession.unlock();
                }
            }
        }
        return bl;
    }

    public void setGetterTaskInProgress(boolean bl) {
        this.isGetterTaskInProgress = bl;
    }

    public boolean isDialogWaitingForGetterTasksToFinish() {
        return this.isGetterTaskInProgress;
    }

    protected void addNumberValidator(TextField textField) {
        if (textField != null) {
            textField.addValidator((Validator)new NumberValidator());
        }
    }

    public boolean isTouchUI() {
        return this.enableTouchUI ? this.app.isTouchUI() : false;
    }

    private void enableLayoutTabOrder(boolean bl) {
        if (BrowserInfoHandler.isMobile(this.app) && this.app.getWebBrowser().isSafari()) {
            this.app.getCommunicationComponent().enableLayoutTabOrder(bl);
        }
    }

    public void setInitialFocusedField(final AbstractTextField abstractTextField) {
        if (abstractTextField != null) {
            this.initFocusListenerReg = this.addFocusListener(new FieldEvents.FocusListener(){
                final /* synthetic */ Dialog this$0;
                {
                    this.this$0 = dialog;
                }

                public void focus(FieldEvents.FocusEvent focusEvent) {
                    abstractTextField.selectAll();
                    this.this$0.removeFocusListener();
                }
            });
        }
    }

    protected void removeFocusListener() {
        if (this.initFocusListenerReg != null) {
            this.initFocusListenerReg.remove();
            this.initFocusListenerReg = null;
        }
    }

    public void setHeaderVisible(boolean bl) {
        if (bl) {
            this.removeStyleName("fm-modal-dialog-invisible-header");
        } else {
            this.addStyleName("fm-modal-dialog-invisible-header");
        }
    }

    public static enum ButtonOption {
        LEFT,
        LEFT_RIGHT,
        LEFT_MIDDLE_RIGHT,
        NONE;

    }

    private class NumberValidator
    implements Validator {
        private NumberValidator() {
        }

        public void validate(Object object) throws Validator.InvalidValueException {
            if (!this.isValid(object)) {
                throw new Validator.InvalidValueException(IWPI18N.get(Dialog.this.app, "INVALID_NUMBER", new Object[0]));
            }
        }

        public boolean isValid(Object object) {
            if (object == null || !(object instanceof String)) {
                return false;
            }
            return ((String)object).matches("[0-9]+");
        }
    }
}

