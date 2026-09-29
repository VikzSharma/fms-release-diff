/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Panel
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.AbstractTextField
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.PasswordField
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.CustomDialogResult;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogButtonObject;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogData;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogFieldObject;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogSizeAndPos;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.statusarea.StatusAreaContainer;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.AbstractTextField;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.PasswordField;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomDialog
extends ServerInvokedDialog {
    private static final int DIALOG_WIDTH = 440;
    private final Map<Integer, String> inputFields = new HashMap<Integer, String>(3);
    private short selectedButtonIdx = 0;
    private Map<Integer, AbstractTextField> textFields;
    private boolean hasDefaultButton = true;

    public CustomDialog(App app, DialogData dialogData) {
        super(app, dialogData.getTitle());
        Iterator<Map.Entry<Integer, AbstractTextField>> iterator;
        this.removeAllCloseShortcuts();
        if (this.isTouchUI()) {
            this.setDialogWidth();
        } else {
            this.initSizeAndPos(dialogData.getSizeAndPos());
            this.setResizable(true);
        }
        this.initContent(this.getContentLayout(dialogData));
        this.initButtons(dialogData.getButtonObjects());
        if (this.textFields != null && !this.textFields.isEmpty() && (iterator = this.textFields.entrySet().iterator()).hasNext()) {
            this.setInitialFocusedField(iterator.next().getValue());
        }
    }

    private Component getContentLayout(DialogData dialogData) {
        Panel panel;
        Label label;
        String string;
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.setMargin(false);
        if (this.getHeight() == -1.0f) {
            verticalLayout.setHeightUndefined();
        }
        if ((string = dialogData.getMessage()) != null) {
            string = Utilities.encodeHTML(string);
            label = new Label(string, ContentMode.HTML);
            panel = new Panel((Component)label);
            panel.setStyleName("light");
            if (this.getHeight() != -1.0f) {
                float f = this.getHeight() - 200.0f;
                String string2 = Float.toString(f) + "px";
                panel.setHeight(string2);
            }
            verticalLayout.addComponent((Component)panel);
        }
        label = new Label("");
        label.setHeight("15px");
        verticalLayout.addComponent((Component)label);
        if (dialogData.getFieldObjectsSize() > 0) {
            this.textFields = new HashMap<Integer, AbstractTextField>(3);
            panel = new VerticalLayout();
            panel.setSpacing(true);
            List<DialogFieldObject> list = dialogData.getFieldObjects();
            for (DialogFieldObject dialogFieldObject : list) {
                switch (dialogFieldObject.getType()) {
                    case EDIT_BOX: {
                        this.inputFields.put(dialogFieldObject.getFieldIndex(), dialogFieldObject.getFieldValue());
                        AbstractTextField abstractTextField = this.createTextField(dialogFieldObject);
                        abstractTextField.setSizeFull();
                        if (this.isTouchUI()) {
                            abstractTextField.addStyleName("field-label");
                        }
                        this.textFields.put(dialogFieldObject.getFieldIndex(), abstractTextField);
                        panel.addComponent((Component)abstractTextField);
                        panel.setComponentAlignment((Component)abstractTextField, Alignment.MIDDLE_LEFT);
                        break;
                    }
                }
            }
            verticalLayout.addComponent((Component)panel);
            verticalLayout.setComponentAlignment((Component)panel, Alignment.MIDDLE_LEFT);
        }
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    private void initButtons(List<DialogButtonObject> list) {
        String string = "";
        String string2 = "";
        String string3 = "";
        switch (list.size()) {
            case 1: {
                this.buttonOption = Dialog.ButtonOption.LEFT;
                string = list.get(0).getLabel();
                break;
            }
            case 2: {
                this.buttonOption = Dialog.ButtonOption.LEFT_RIGHT;
                string = list.get(1).getLabel();
                string2 = list.get(0).getLabel();
                break;
            }
            case 3: {
                this.buttonOption = Dialog.ButtonOption.LEFT_MIDDLE_RIGHT;
                string = list.get(2).getLabel();
                string3 = list.get(1).getLabel();
                string2 = list.get(0).getLabel();
                break;
            }
            default: {
                this.buttonOption = Dialog.ButtonOption.LEFT;
                string = IWPI18N.get(this.app, "OK", new Object[0]);
            }
        }
        if (list.size() == 0 || !list.get(0).isDefaultButton()) {
            this.hasDefaultButton = false;
        }
        super.initButtons(string, string3, string2);
        switch (list.size()) {
            case 1: {
                this.getLeftButton().setData(list.get(0));
                break;
            }
            case 2: {
                this.getLeftButton().setData(list.get(1));
                this.getRightButton().setData(list.get(0));
                break;
            }
            case 3: {
                this.getLeftButton().setData(list.get(2));
                this.getMiddleButton().setData(list.get(1));
                this.getRightButton().setData(list.get(0));
                break;
            }
            default: {
                DialogButtonObject dialogButtonObject = new DialogButtonObject();
                dialogButtonObject.setIndex((short)1);
                dialogButtonObject.setCommit(false);
                this.getLeftButton().setData(dialogButtonObject);
            }
        }
        if (this.isTouchUI()) {
            this.getLeftButton().makeFitCaption();
            if (list.size() < 4) {
                if (list.size() > 1) {
                    this.getRightButton().makeFitCaption();
                }
                if (list.size() > 2) {
                    this.getMiddleButton().makeFitCaption();
                }
            }
        }
    }

    @Override
    protected void setButtonDefaults() {
        if (this.hasDefaultButton) {
            switch (this.buttonOption) {
                case LEFT: {
                    this.setLeftButtonDefault();
                    break;
                }
                case LEFT_RIGHT: 
                case LEFT_MIDDLE_RIGHT: {
                    this.setRightButtonDefault();
                    break;
                }
            }
        } else {
            this.clearButtonStyles();
        }
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.performButtonAction(clickEvent);
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performMiddleButtonAction(Button.ClickEvent clickEvent) {
        this.performButtonAction(clickEvent);
        super.performMiddleButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.performButtonAction(clickEvent);
        super.performRightButtonAction(clickEvent);
    }

    private void performButtonAction(Button.ClickEvent clickEvent) {
        if (clickEvent != null) {
            this.selectedButtonIdx = ((DialogButtonObject)clickEvent.getButton().getData()).getIndex();
            boolean bl = ((DialogButtonObject)clickEvent.getButton().getData()).isCommit();
            if (bl) {
                if (this.textFields != null) {
                    for (int n : this.textFields.keySet()) {
                        String string = this.inputFields.get(n);
                        String string2 = (String)this.textFields.get(n).getValue();
                        if (string2 != null && !string2.equals(string)) {
                            this.inputFields.put(n, string2);
                            continue;
                        }
                        this.inputFields.remove(n);
                    }
                }
            } else {
                this.inputFields.clear();
            }
        }
    }

    @Override
    public final CustomDialogResult getResult() {
        CustomDialogResult customDialogResult = new CustomDialogResult();
        customDialogResult.setUpdatedFields(this.inputFields);
        customDialogResult.setButtonIdx(this.selectedButtonIdx);
        return customDialogResult;
    }

    private AbstractTextField createTextField(DialogFieldObject dialogFieldObject) {
        if (dialogFieldObject.isUsePwdChar()) {
            return new PasswordField(dialogFieldObject.getFieldLabel(), dialogFieldObject.getFieldValue());
        }
        return new TextField(dialogFieldObject.getFieldLabel(), dialogFieldObject.getFieldValue());
    }

    private void initSizeAndPos(List<DialogSizeAndPos> list) {
        int n = list.get(0).getLeft();
        int n2 = list.get(0).getTop();
        int n3 = list.get(0).getWidth();
        int n4 = list.get(0).getHeight();
        if (n != -1) {
            this.setPositionX(n);
        }
        if (n2 != -1) {
            StatusAreaContainer statusAreaContainer = this.app.getStatusAreaContainer();
            if (statusAreaContainer != null && statusAreaContainer.isVisible()) {
                n2 += 44;
            }
            this.setPositionY(n2);
        }
        if (n3 != -1) {
            this.setDialogWidth(n3);
        } else {
            this.setDialogWidth(440);
        }
        if (n4 != -1) {
            this.setDialogHeight(n4);
        }
    }
}

