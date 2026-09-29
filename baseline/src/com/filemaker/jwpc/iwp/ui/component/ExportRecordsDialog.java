/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.GridLayout
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.event.FieldEvents$TextChangeEvent
 *  com.vaadin.v7.event.FieldEvents$TextChangeListener
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.DownloadFileInfo;
import com.filemaker.jwpc.iwp.thrift.notification.ExportRecordsDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ExportRecordsDialog
extends ServerInvokedStaticDialog {
    private LinkedHashMap<String, String> FILE_TYPES;
    private static final String DIALOG_WIDTH = "460px";
    private static final String ID_FILE_NAME_FIELD = "file_name_field";
    private TextField fileName;
    private NativeSelect<String> fileType;
    private DownloadFileInfo result = new DownloadFileInfo();

    public ExportRecordsDialog(App app, ExportRecordsDialogNotification exportRecordsDialogNotification) {
        super(app, IWPI18N.get(app, "EXPORT_RECORDS_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        this.setRightButtonDefault();
        this.fileType.setValue(this.getFileTypeId(exportRecordsDialogNotification.getFileType()));
        this.setWidth(DIALOG_WIDTH);
        this.setResizable(false);
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "EXPORT_RECORDS_DIALOG_MESSAGE", new Object[0]));
        verticalLayout.addComponent((Component)label);
        Label label2 = new Label();
        label2.setHeight("3px");
        verticalLayout.addComponent((Component)label2);
        GridLayout gridLayout = this.getFileInfoLayout();
        verticalLayout.addComponent((Component)gridLayout);
        verticalLayout.setComponentAlignment((Component)gridLayout, Alignment.BOTTOM_CENTER);
        return verticalLayout;
    }

    private GridLayout getFileInfoLayout() {
        GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "SAVE_AS_COLON", new Object[0]));
        gridLayout.addComponent((Component)label);
        gridLayout.setComponentAlignment((Component)label, Alignment.BOTTOM_RIGHT);
        this.fileName = new TextField(null, IWPI18N.get(this.app, "EXPORT_RECORDS_DEFAULT_FILE_NAME", new Object[0]));
        this.fileName.setImmediate(true);
        this.fileName.addTextChangeListener(new FieldEvents.TextChangeListener(){

            public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                ExportRecordsDialog.this.performFileNameChange(textChangeEvent);
            }
        });
        gridLayout.addComponent((Component)this.fileName);
        gridLayout.setComponentAlignment((Component)this.fileName, Alignment.BOTTOM_LEFT);
        Label label2 = new Label(IWPI18N.get(this.app, "TYPE_COLON", new Object[0]));
        gridLayout.addComponent((Component)label2);
        gridLayout.setComponentAlignment((Component)label2, Alignment.TOP_RIGHT);
        this.FILE_TYPES = new LinkedHashMap();
        this.FILE_TYPES.put(IWPI18N.get(this.app, "FILE_TAB_DESC", new Object[0]), ".tab");
        this.FILE_TYPES.put(IWPI18N.get(this.app, "FILE_CSV_DESC", new Object[0]), ".csv");
        this.FILE_TYPES.put(IWPI18N.get(this.app, "FILE_DBF_DESC", new Object[0]), ".dbf");
        this.FILE_TYPES.put(IWPI18N.get(this.app, "FILE_MER_DESC", new Object[0]), ".mer");
        this.FILE_TYPES.put(IWPI18N.get(this.app, "FILE_HTM_DESC", new Object[0]), ".htm");
        this.fileType = new NativeSelect();
        this.fileType.setNullSelectionAllowed(false);
        this.fileType.setImmediate(true);
        Iterator<String> iterator = this.FILE_TYPES.keySet().iterator();
        while (iterator.hasNext()) {
            this.fileType.addItem(iterator.next());
        }
        this.fileType.setValue(this.FILE_TYPES.keySet().toArray()[0]);
        this.fileType.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                ExportRecordsDialog.this.performFileTypeChange(valueChangeEvent);
            }
        });
        gridLayout.addComponent(this.fileType);
        gridLayout.setComponentAlignment(this.fileType, Alignment.TOP_LEFT);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.fileName.setId(ID_FILE_NAME_FIELD);
            IWPUtilities.setAriaLabelById(this.app, this.fileName.getId(), label.getValue());
            this.fileType.setDescription(label2.getValue());
        }
        return gridLayout;
    }

    @Override
    public final DownloadFileInfo getResult() {
        return this.result;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.setDownloadFileName("");
        this.result.setFileType("");
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        String string = ((String)this.fileName.getValue()).toString();
        if (IWPUtilities.isAllowedFileName(string)) {
            this.result.setDownloadFileName(string);
            this.result.setFileType(this.FILE_TYPES.get(this.fileType.getValue()));
            super.performRightButtonAction(clickEvent);
        } else {
            this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "EXPORT_FILENAME_ERROR", new Object[0]));
        }
    }

    private void performFileNameChange(FieldEvents.TextChangeEvent textChangeEvent) {
        String string = textChangeEvent.getText();
        if (string == null || string.trim().isEmpty()) {
            if (this.getRightButton().isEnabled()) {
                this.getRightButton().setEnabled(false);
            }
        } else if (!this.getRightButton().isEnabled()) {
            this.getRightButton().setEnabled(true);
        }
    }

    private void performFileTypeChange(Property.ValueChangeEvent valueChangeEvent) {
        String string = this.FILE_TYPES.get((String)valueChangeEvent.getProperty().getValue());
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)this.fileName.getValue());
            int n = stringBuilder.lastIndexOf(".");
            if (n > 0) {
                stringBuilder.delete(n, stringBuilder.length());
            }
            this.fileName.setValue(stringBuilder.toString());
        }
    }

    private String getFileTypeId(String string) {
        String string2 = "";
        if (string.equals(".tab")) {
            string2 = IWPI18N.get(this.app, "FILE_TAB_DESC", new Object[0]);
        } else if (string.equals(".csv")) {
            string2 = IWPI18N.get(this.app, "FILE_CSV_DESC", new Object[0]);
        } else if (string.equals(".dbf")) {
            string2 = IWPI18N.get(this.app, "FILE_DBF_DESC", new Object[0]);
        } else if (string.equals(".mer")) {
            string2 = IWPI18N.get(this.app, "FILE_MER_DESC", new Object[0]);
        } else if (string.equals(".htm")) {
            string2 = IWPI18N.get(this.app, "FILE_HTM_DESC", new Object[0]);
        }
        return string2;
    }
}

