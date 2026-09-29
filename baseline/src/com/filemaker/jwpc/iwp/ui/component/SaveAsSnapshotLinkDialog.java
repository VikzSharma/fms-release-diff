/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.GridLayout
 *  com.vaadin.v7.event.FieldEvents$TextChangeEvent
 *  com.vaadin.v7.event.FieldEvents$TextChangeListener
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.SaveAsSsLinkDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.SaveRecordsOption;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class SaveAsSnapshotLinkDialog
extends ServerInvokedStaticDialog {
    private final String DIALOG_WIDTH = "460px";
    private final String FILE_EXT = ".fmpsl";
    private LinkedHashMap<String, SaveRecordsOption> SAVE_OPTIONS;
    private TextField fileName;
    private NativeSelect<String> saveOption;
    private SaveAsSsLinkDialogResult result = new SaveAsSsLinkDialogResult();
    private static final String CAPTION_CSS_STYLE = "v-caption-sr-only-caption-dialog-fields";

    public SaveAsSnapshotLinkDialog(App app, SaveRecordsOption saveRecordsOption) {
        super(app, IWPI18N.get(app, "SAVEAS_SNAPSHOT_LINK_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        if (saveRecordsOption != null) {
            this.saveOption.setValue(this.SAVE_OPTIONS.keySet().toArray()[saveRecordsOption.getValue()]);
        }
        this.setRightButtonDefault();
        this.setWidth("460px");
        this.setResizable(false);
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "SAVEAS_SNAPSHOT_LINK_DIALOG_MESSAGE", new Object[0]));
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
        this.fileName = new TextField("", this.app.getCurrentDatabaseName() + ".fmpsl");
        this.fileName.setCaption(IWPI18N.get(this.app, "SAVE_AS_COLON", new Object[0]));
        this.fileName.addStyleName(CAPTION_CSS_STYLE);
        this.fileName.setImmediate(true);
        this.fileName.addTextChangeListener(new FieldEvents.TextChangeListener(){

            public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                SaveAsSnapshotLinkDialog.this.performFileNameChange(textChangeEvent);
            }
        });
        gridLayout.addComponent((Component)this.fileName);
        gridLayout.setComponentAlignment((Component)this.fileName, Alignment.BOTTOM_LEFT);
        Label label2 = new Label(IWPI18N.get(this.app, "SAVE_COLON", new Object[0]));
        gridLayout.addComponent((Component)label2);
        gridLayout.setComponentAlignment((Component)label2, Alignment.TOP_RIGHT);
        this.SAVE_OPTIONS = new LinkedHashMap();
        this.SAVE_OPTIONS.put(IWPI18N.get(this.app, "RECORDS_BEING_BROWSED", new Object[0]), SaveRecordsOption.BROWSED_RECORDS);
        this.SAVE_OPTIONS.put(IWPI18N.get(this.app, "CURRENT_RECORD", new Object[0]), SaveRecordsOption.CURRENT_RECORD);
        this.saveOption = new NativeSelect();
        this.saveOption.setCaption(IWPI18N.get(this.app, "SAVE_COLON", new Object[0]));
        this.saveOption.addStyleName(CAPTION_CSS_STYLE);
        this.saveOption.setNullSelectionAllowed(false);
        this.saveOption.setImmediate(true);
        Iterator<String> iterator = this.SAVE_OPTIONS.keySet().iterator();
        while (iterator.hasNext()) {
            this.saveOption.addItem(iterator.next());
        }
        this.saveOption.setValue(this.SAVE_OPTIONS.keySet().toArray()[0]);
        gridLayout.addComponent(this.saveOption);
        gridLayout.setComponentAlignment(this.saveOption, Alignment.TOP_LEFT);
        return gridLayout;
    }

    @Override
    public final SaveAsSsLinkDialogResult getResult() {
        return this.result;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.setSsLinkFileName("");
        this.result.setSaveOption(SaveRecordsOption.BROWSED_RECORDS);
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        if (!((String)this.fileName.getValue()).toString().trim().isEmpty()) {
            this.result.setSsLinkFileName(((String)this.fileName.getValue()).toString());
            this.result.setSaveOption(this.SAVE_OPTIONS.get(this.saveOption.getValue()));
            super.performRightButtonAction(clickEvent);
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
}

