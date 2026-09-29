/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbstractLayout
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.notification.SaveAsPDFNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.IntegerField;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.HashMap;
import java.util.Map;

public class PDFDialog
extends ServerInvokedStaticDialog {
    private final PaperSizeRec[] paperSizeRecArray = new PaperSizeRec[]{new PaperSizeRec(this, "8.5 x 11", false, "PAPER_SIZE_LETTER"), new PaperSizeRec(this, "11 x 17", false, "PAPER_SIZE_TABLOID"), new PaperSizeRec(this, "8.5 x 14", false, "PAPER_SIZE_LEGAL"), new PaperSizeRec(this, "5.5 x 8.5", false, "PAPER_SIZE_STATEMENT"), new PaperSizeRec(this, "7.25 x 10.5", false, "PAPER_SIZE_EXECUTIVE"), new PaperSizeRec(this, "8.5 x 13", false, "PAPER_SIZE_FOLIO"), new PaperSizeRec(this, "297 x 420", true, "PAPER_SIZE_A3"), new PaperSizeRec(this, "210 x 297", true, "PAPER_SIZE_A4"), new PaperSizeRec(this, "148 x 210", true, "PAPER_SIZE_A5"), new PaperSizeRec(this, "250 x 353", true, "PAPER_SIZE_B4"), new PaperSizeRec(this, "176 x 250", true, "PAPER_SIZE_B5")};
    private VerticalLayout rootContent;
    private boolean viewPDF;
    private SaveAsPDFResult result = null;
    private IntegerField pagesFromField;
    private NativeSelect<String> recordRangeSelect;
    private Map<Integer, String> recordRangeList = null;
    private NativeSelect<String> paperSizeSelect;
    private Map<Integer, String> paperSizeList = null;
    private Label paperSizeText = null;
    private boolean landscapeMode = false;
    private CssLayout portraitIcon = null;
    private CssLayout landscapeIcon = null;
    private IntegerField customScaleField;
    private boolean printContainerPDF = false;
    private static final int DIALOG_WIDTH = 400;
    private static final int INTEGER_FIELD_WIDTH = 70;
    private static final int INTEGER_FIELD_WIDTH_TOUCH = 70;
    private static final String CAPTION_CSS_STYLE = "v-caption-sr-only-caption-dialog-fields";

    public PDFDialog(App app, SaveAsPDFNotification saveAsPDFNotification) {
        super(app, "", Dialog.ButtonOption.LEFT_RIGHT);
        this.viewPDF = saveAsPDFNotification.isViewPDF();
        this.result = new SaveAsPDFResult(this);
        this.result.confirm = false;
        this.result.docSaveType = saveAsPDFNotification.getSettings().getDocSaveType();
        this.result.pagesFrom = saveAsPDFNotification.getSettings().getPagesFrom();
        this.result.pageOrientation = saveAsPDFNotification.getSettings().getPageOrientation();
        this.result.scaling = saveAsPDFNotification.getSettings().getScaling();
        this.result.paperSize = saveAsPDFNotification.getSettings().getPaperSize();
        this.printContainerPDF = this.viewPDF && this.result.docSaveType == -1;
        this.updateLayout();
        this.setCurrentSettings();
        this.setCaption(app.getLocalizedString(this.viewPDF ? "VIEW_AS_PDF" : "SAVE_AS_PDF"));
        this.getLeftButton().setCaption(app.getLocalizedString("CANCEL"));
        this.getRightButton().setCaption(app.getLocalizedString(this.viewPDF ? "VIEW" : "SAVE"));
        this.setRightButtonDefault();
        this.setDialogWidth(400);
        this.setResizable(false);
        this.setClosable(true);
        this.addStyleName("save-as-pdf");
    }

    @Override
    protected Component getContentLayout() {
        this.rootContent = new VerticalLayout();
        return this.rootContent;
    }

    private void updateLayout() {
        if (this.viewPDF) {
            this.rootContent.addComponent((Component)this.buildNumberPagesRow());
            this.rootContent.addComponent((Component)this.buildRecordRangeRow());
            this.rootContent.addComponent((Component)this.buildPaperSizeRow());
            if (!this.isTouchUI()) {
                this.rootContent.addComponent((Component)this.buildPaperSizeTextRow());
            }
            this.rootContent.addComponent((Component)this.buildOrientationRow());
            this.rootContent.addComponent((Component)this.buildScaleRow());
        } else {
            this.rootContent.addComponent((Component)this.buildRecordRangeRow());
        }
    }

    private void setCurrentSettings() {
        if (this.viewPDF) {
            this.pagesFromField.setValue(String.valueOf(this.result.pagesFrom));
            this.pagesFromField.setEnabled(!this.printContainerPDF);
            this.setOrientationMode(this.result.pageOrientation > 1);
            this.customScaleField.setValue(String.valueOf((int)(this.result.scaling * 100.0)));
            String string = this.paperSizeList.get(this.result.paperSize);
            this.paperSizeSelect.setValue(string);
        }
        int n = this.result.docSaveType > 0 ? this.result.docSaveType : 1;
        String string = this.recordRangeList.get(n);
        this.recordRangeSelect.setValue(string);
        this.recordRangeSelect.setEnabled(!this.printContainerPDF);
    }

    private AbstractLayout buildNumberPagesRow() {
        HorizontalLayout horizontalLayout;
        Label label = new Label(this.app.getLocalizedString("NUMBER_PAGES_FROM"));
        if (this.isTouchUI()) {
            horizontalLayout = new HorizontalLayout();
            horizontalLayout.addStyleName("fm-middle-align-box");
            horizontalLayout.addStyleName("row-has-bottom-margin");
            label.addStyleName("label");
            horizontalLayout.addComponent((Component)label);
        } else {
            horizontalLayout = new CssLayout();
            horizontalLayout.addStyleName("fm-dialog-row-container row-tall-bottom-padding fm-middle-align-box");
            horizontalLayout.addStyleName("v-vertical v-margin-bottom");
            horizontalLayout.addComponent((Component)this.createLabelColumn(label));
        }
        this.pagesFromField = this.createIntegerField(6, 1, true);
        this.pagesFromField.setCaption(this.app.getLocalizedString("NUMBER_PAGES_FROM"));
        this.pagesFromField.addStyleName(CAPTION_CSS_STYLE);
        if (this.isTouchUI()) {
            this.pagesFromField.addStyleName("right-align");
        }
        horizontalLayout.addComponent((Component)this.pagesFromField);
        return horizontalLayout;
    }

    private AbstractLayout buildRecordRangeRow() {
        VerticalLayout verticalLayout;
        Label label = new Label(this.app.getLocalizedString("RECORD_RANGE"));
        if (this.isTouchUI()) {
            verticalLayout = new VerticalLayout();
            verticalLayout.addStyleName("row-has-bottom-margin");
            label.addStyleName("label-bottom-margin");
            verticalLayout.addComponent((Component)label);
        } else {
            verticalLayout = new CssLayout();
            verticalLayout.addStyleName("fm-dialog-row-container row-tall-bottom-padding fm-middle-align-box");
            verticalLayout.addStyleName("v-vertical v-margin-bottom");
            verticalLayout.addComponent((Component)this.createLabelColumn(label));
        }
        this.recordRangeList = new HashMap<Integer, String>();
        this.recordRangeList.put(1, this.app.getLocalizedString("RECORDS_BEING_BROWSED"));
        this.recordRangeList.put(2, this.app.getLocalizedString("CURRENT_RECORD"));
        this.recordRangeList.put(3, this.app.getLocalizedString("BLANK_RECORD_AS_FORMATTED"));
        this.recordRangeList.put(4, this.app.getLocalizedString("BLANK_RECORD_WITH_BOXES"));
        this.recordRangeList.put(5, this.app.getLocalizedString("BLANK_RECORD_WITH_UNDERLINES"));
        this.recordRangeList.put(6, this.app.getLocalizedString("BLANK_RECORD_WITH_PLACEHOLDER_TEXT"));
        this.recordRangeSelect = new NativeSelect();
        this.recordRangeSelect.setNullSelectionAllowed(false);
        this.recordRangeSelect.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        this.recordRangeSelect.setImmediate(true);
        this.recordRangeSelect.setCaption(this.app.getLocalizedString("RECORD_RANGE"));
        this.recordRangeSelect.addStyleName(CAPTION_CSS_STYLE);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.recordRangeSelect.setDescription(this.app.getLocalizedString("RECORD_RANGE"));
        }
        for (String string : this.recordRangeList.values()) {
            this.recordRangeSelect.addItem(string);
        }
        this.recordRangeSelect.select(this.recordRangeList.values().toArray()[0]);
        verticalLayout.addComponent(this.recordRangeSelect);
        return verticalLayout;
    }

    private AbstractLayout buildPaperSizeRow() {
        VerticalLayout verticalLayout;
        Label label = new Label(this.app.getLocalizedString("PAPER_SIZE"));
        if (this.isTouchUI()) {
            verticalLayout = new VerticalLayout();
            verticalLayout.addStyleName("row-has-bottom-margin");
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.addStyleName("spread-sides");
            AbstractLayout object = this.buildPaperSizeTextRow();
            object.addStyleName("right-align");
            horizontalLayout.addComponent((Component)label);
            horizontalLayout.addComponent((Component)object);
            verticalLayout.addComponent((Component)horizontalLayout);
        } else {
            verticalLayout = new CssLayout();
            verticalLayout.addStyleName("fm-dialog-row-container fm-middle-align-box");
            verticalLayout.addStyleName("v-vertical");
            verticalLayout.addComponent((Component)this.createLabelColumn(label));
        }
        this.paperSizeList = new HashMap<Integer, String>();
        for (int i = 0; i < this.paperSizeRecArray.length; ++i) {
            this.paperSizeList.put(i, this.app.getLocalizedString(this.paperSizeRecArray[i].nameKey));
        }
        this.paperSizeSelect = new NativeSelect();
        this.paperSizeSelect.setNullSelectionAllowed(false);
        this.paperSizeSelect.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        this.paperSizeSelect.setImmediate(true);
        this.paperSizeSelect.setCaption(this.app.getLocalizedString("PAPER_SIZE"));
        this.paperSizeSelect.addStyleName(CAPTION_CSS_STYLE);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.paperSizeSelect.setDescription(this.app.getLocalizedString("PAPER_SIZE"));
        }
        this.paperSizeSelect.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                PDFDialog.this.onPaperSizeChanged(valueChangeEvent);
            }
        });
        for (String string : this.paperSizeList.values()) {
            this.paperSizeSelect.addItem(string);
        }
        verticalLayout.addComponent(this.paperSizeSelect);
        return verticalLayout;
    }

    private AbstractLayout buildPaperSizeTextRow() {
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName("fm-top-align-box");
        cssLayout.addStyleName("v-vertical");
        if (!this.isTouchUI()) {
            cssLayout.addStyleName("row-mid-bottom-padding");
        }
        if (!this.isTouchUI()) {
            Label label = new Label(" ");
            cssLayout.addComponent((Component)this.createLabelColumn(label));
        }
        this.paperSizeText = new Label("9 x 9 Inches");
        this.paperSizeText.addStyleName("paper-size-text");
        cssLayout.addComponent((Component)this.paperSizeText);
        if (this.paperSizeSelect != null && this.paperSizeList != null) {
            this.paperSizeSelect.select(this.paperSizeList.values().toArray()[0]);
        }
        return cssLayout;
    }

    private AbstractLayout buildOrientationRow() {
        HorizontalLayout horizontalLayout;
        Label label = new Label(this.app.getLocalizedString("ORIENTATION"));
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        if (this.isTouchUI()) {
            horizontalLayout = new HorizontalLayout();
            horizontalLayout.addStyleName("row-has-bottom-margin");
            label.addStyleName("label");
            horizontalLayout.addComponent((Component)label);
            horizontalLayout2.addStyleName("right-align");
        } else {
            horizontalLayout = new CssLayout();
            horizontalLayout.addStyleName("fm-dialog-row-container row-short-bottom-padding");
            horizontalLayout.addComponent((Component)this.createLabelColumn(label));
        }
        horizontalLayout.addStyleName("fm-top-align-box");
        this.portraitIcon = new CssLayout();
        this.portraitIcon.addStyleName("fm-portrait-icon on");
        Button button = new Button("", new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                PDFDialog.this.setOrientationMode(false);
            }
        });
        button.addStyleName("icon");
        this.portraitIcon.addComponent((Component)button);
        this.portraitIcon.setCaption(this.app.getLocalizedString("ORIENTATION_PORTRAIT"));
        this.portraitIcon.addStyleName(CAPTION_CSS_STYLE);
        this.landscapeIcon = new CssLayout();
        this.landscapeIcon.addStyleName("fm-landscape-icon");
        Button button2 = new Button("", new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                PDFDialog.this.setOrientationMode(true);
            }
        });
        button2.addStyleName("icon");
        this.landscapeIcon.addComponent((Component)button2);
        this.landscapeIcon.setCaption(this.app.getLocalizedString("ORIENTATION_LANDSCAPE"));
        this.landscapeIcon.addStyleName(CAPTION_CSS_STYLE);
        Label label2 = new Label("<div style=\"width:10px;\"/>", ContentMode.HTML);
        horizontalLayout2.addComponent((Component)this.portraitIcon);
        horizontalLayout2.addComponent((Component)label2);
        horizontalLayout2.addComponent((Component)this.landscapeIcon);
        horizontalLayout.addComponent((Component)horizontalLayout2);
        return horizontalLayout;
    }

    private AbstractLayout buildScaleRow() {
        HorizontalLayout horizontalLayout;
        Label label = new Label(this.app.getLocalizedString("SCALE_PERCENTAGE"));
        if (this.isTouchUI()) {
            horizontalLayout = new HorizontalLayout();
            horizontalLayout.addStyleName("fm-middle-align-box");
            horizontalLayout.addStyleName("row-has-bottom-margin");
            label.addStyleName("label");
            horizontalLayout.addComponent((Component)label);
        } else {
            horizontalLayout = new CssLayout();
            horizontalLayout.addStyleName("fm-dialog-row-container row-tall-bottom-padding fm-middle-align-box");
            horizontalLayout.addStyleName("v-vertical v-margin-bottom");
            horizontalLayout.addComponent((Component)this.createLabelColumn(label));
        }
        this.customScaleField = this.createIntegerField(6, 100, false);
        this.customScaleField.setCaption(this.app.getLocalizedString("SCALE_PERCENTAGE"));
        this.customScaleField.addStyleName(CAPTION_CSS_STYLE);
        if (this.isTouchUI()) {
            this.customScaleField.addStyleName("right-align");
        }
        horizontalLayout.addComponent((Component)this.customScaleField);
        return horizontalLayout;
    }

    private AbstractLayout createLabelColumn(Label label) {
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName("save-as-pdf-label-column");
        cssLayout.addComponent((Component)label);
        return cssLayout;
    }

    private void setOrientationMode(boolean bl) {
        this.landscapeMode = bl;
        if (bl) {
            this.portraitIcon.removeStyleName("on");
            this.landscapeIcon.addStyleName("on");
        } else {
            this.landscapeIcon.removeStyleName("on");
            this.portraitIcon.addStyleName("on");
        }
    }

    private void onPaperSizeChanged(Property.ValueChangeEvent valueChangeEvent) {
        if (this.paperSizeText == null) {
            return;
        }
        String string = (String)valueChangeEvent.getProperty().getValue();
        if (!string.equals("[]")) {
            for (Map.Entry<Integer, String> entry : this.paperSizeList.entrySet()) {
                if (!entry.getValue().equals(string)) continue;
                PaperSizeRec paperSizeRec = this.paperSizeRecArray[entry.getKey()];
                String string2 = null;
                string2 = paperSizeRec.isMetric ? this.app.getLocalizedString("PAPER_SIZE_UNIT_METRIC") : this.app.getLocalizedString("PAPER_SIZE_UNIT_ENGLISH");
                String string3 = String.format("%s %s", paperSizeRec.size, string2);
                this.paperSizeText.setValue(string3);
                break;
            }
        }
    }

    private IntegerField createIntegerField(int n, int n2, boolean bl) {
        IntegerField integerField = new IntegerField();
        integerField.setWidth(this.isTouchUI() ? 70.0f : 70.0f, Sizeable.Unit.PIXELS);
        integerField.setMaxLength(n);
        integerField.setValue(String.valueOf(n2));
        integerField.setDefaultValue(n2);
        integerField.setAllowZero(bl);
        return integerField;
    }

    private void validateControlValues() {
        if (this.viewPDF) {
            String string = (String)this.pagesFromField.getValue();
            try {
                Integer.parseInt(string);
            }
            catch (NumberFormatException numberFormatException) {
                string = "";
            }
            if (string.isEmpty()) {
                this.pagesFromField.setValue("1");
            }
            String string2 = (String)this.customScaleField.getValue();
            try {
                Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                string2 = "";
            }
            if (string2.isEmpty()) {
                this.customScaleField.setValue("100");
            }
        }
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.validateControlValues();
        this.result.confirm = true;
        super.performRightButtonAction(clickEvent);
    }

    @Override
    public Object getResult() {
        String string;
        if (this.viewPDF) {
            this.result.pagesFrom = Integer.valueOf((String)this.pagesFromField.getValue());
            this.result.pageOrientation = this.landscapeMode ? 2 : 0;
            this.result.scaling = Double.valueOf((String)this.customScaleField.getValue()) / 100.0;
            string = (String)this.paperSizeSelect.getValue();
            for (Map.Entry<Integer, String> entry : this.paperSizeList.entrySet()) {
                if (!entry.getValue().equals(string)) continue;
                this.result.paperSize = entry.getKey();
                break;
            }
        }
        string = (String)this.recordRangeSelect.getValue();
        for (Map.Entry<Integer, String> entry : this.recordRangeList.entrySet()) {
            if (!entry.getValue().equals(string)) continue;
            this.result.docSaveType = entry.getKey();
            break;
        }
        return this.result;
    }

    public class PaperSizeRec {
        public String size;
        public boolean isMetric;
        public String nameKey;

        public PaperSizeRec(PDFDialog pDFDialog, String string, boolean bl, String string2) {
            this.size = string;
            this.isMetric = bl;
            this.nameKey = string2;
        }
    }

    public class SaveAsPDFResult {
        public boolean confirm = false;
        public int docSaveType;
        public int pagesFrom;
        public int pageOrientation;
        public double scaling;
        public int paperSize;

        public SaveAsPDFResult(PDFDialog pDFDialog) {
        }
    }
}

