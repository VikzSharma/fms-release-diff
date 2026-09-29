/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.ui.MarginInfo
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.NativeSelect
 *  com.vaadin.v7.ui.OptionGroup
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.FieldObjectMetaDataModel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.SortAction;
import com.filemaker.jwpc.iwp.thrift.common.SortDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import com.filemaker.jwpc.iwp.thrift.common.SortQueryCriteria;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.DialogButton;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.layout.component.MobileTouchControl;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.NativeSelect;
import com.vaadin.v7.ui.OptionGroup;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MobileSortDialog
extends ServerInvokedDialog {
    private final List<String> orderOptions;
    private final SortDialogResult result;
    private VerticalLayout addFieldPanel;
    private VerticalLayout fieldSettingsPanel;
    private DialogButton fieldSettingsOKButton;
    private OptionGroup sortOrderSelect;
    private NativeSelect valueList;
    private MobileTouchControl fieldSettingsField;
    private MobileTouchControl sortList;
    private MobileTouchControl fieldsList;
    private MobileTouchControl addFieldButton;
    private MobileTouchControl clearButton;
    private int currentSortFieldIndex;
    private Map<Integer, String> valueListData;
    private boolean hasValueLists;
    private static final int TOUCH_ITEM_HEIGHT = 32;
    private static final int SORT_LIST_HEIGHT = 128;
    private static final int FIELDS_LIST_HEIGHT = 192;
    private static final String DIALOG_STYLE = "fm-sort-dialog";
    private static final String SORT_FIELDS_STYLE = "fm-touch-sort-fields";
    private static final String SELECT_STYLE = "fm-select";
    private static final String CENTERED_BOX_STYLE = "fm-sort-centered-box";
    private static final String ORDER_OPTIONS_STYLE = "fm-order-options";
    private static final String ASCENDING_ORDER_ICON = "sort_ascending";
    private static final String DESCENDING_ORDER_ICON = "sort_descending";
    private static final String CUSTOM_ORDER_ICON = "sort_custom";

    public MobileSortDialog(App app, Map<Integer, String> map) {
        super(app, app.getLocalizedString("SORT_RECORDS_DIALOG_TITLE"), Dialog.ButtonOption.LEFT_RIGHT);
        this.orderOptions = Arrays.asList(this.app.getLocalizedString("SORT_ASCENDING_ORDER"), this.app.getLocalizedString("SORT_DESCENDING_ORDER"), this.app.getLocalizedString("SORT_CUSTOM_ORDER"));
        this.addFieldPanel = null;
        this.fieldSettingsPanel = null;
        this.fieldSettingsOKButton = null;
        this.sortOrderSelect = null;
        this.valueList = null;
        this.fieldSettingsField = null;
        this.sortList = null;
        this.fieldsList = null;
        this.addFieldButton = null;
        this.clearButton = null;
        this.currentSortFieldIndex = -1;
        this.valueListData = null;
        this.hasValueLists = false;
        this.valueListData = map;
        this.hasValueLists = this.valueListData != null && !this.valueListData.isEmpty();
        this.initContent(this.getContentLayout(map));
        this.initButtons(this.getLeftButtonText(), null, this.getRightButtonText());
        this.setRightButtonDefault();
        this.updateSortButton();
        this.setDialogWidth();
        this.result = new SortDialogResult();
        this.result.setAction(SortAction.Cancel);
        this.addStyleName(DIALOG_STYLE);
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    private Component getContentLayout(Map<Integer, String> map) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.setStyleName(SORT_FIELDS_STYLE);
        verticalLayout.addComponent((Component)verticalLayout2);
        MobileTouchControl mobileTouchControl = new MobileTouchControl(MobileTouchControl.Type.LABEL);
        mobileTouchControl.setText(this.app.getLocalizedString("SORT_SELECTED_FIELDS"));
        this.clearButton = new MobileTouchControl(MobileTouchControl.Type.TEXT_BUTTON);
        this.clearButton.setText(this.app.getLocalizedString("CLEAR"));
        this.clearButton.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                if (MobileSortDialog.this.clearButton.isEnabled()) {
                    MobileSortDialog.this.onRemoveAllFieldsFromSortList();
                }
            }
        });
        mobileTouchControl.addLabelRightItem(this.clearButton);
        verticalLayout2.addComponent((Component)mobileTouchControl);
        this.sortList = new MobileTouchControl(MobileTouchControl.Type.LIST);
        this.sortList.setHeight(128.0f, Sizeable.Unit.PIXELS);
        verticalLayout2.addComponent((Component)this.sortList);
        this.addFieldButton = new MobileTouchControl(MobileTouchControl.Type.TEXT_BUTTON);
        this.addFieldButton.setText(this.app.getLocalizedString("SORT_ADD_FIELD"));
        this.addFieldButton.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                if (MobileSortDialog.this.addFieldButton.isEnabled()) {
                    MobileSortDialog.this.onOpenAddFieldPanel();
                }
            }
        });
        MobileTouchControl mobileTouchControl2 = new MobileTouchControl(MobileTouchControl.Type.CONTAINER);
        mobileTouchControl2.addComponent((Component)this.addFieldButton);
        verticalLayout2.addComponent((Component)mobileTouchControl2);
        this.initAddFieldPanel();
        this.updateClearButton();
        this.updateAddFieldButton();
        return verticalLayout;
    }

    private void initAddFieldPanel() {
        Object object;
        Iterator iterator;
        this.addFieldPanel = new VerticalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setStyleName(SORT_FIELDS_STYLE);
        this.addFieldPanel.addComponent((Component)verticalLayout);
        this.fieldsList = new MobileTouchControl(MobileTouchControl.Type.LIST);
        this.fieldsList.setHeight(192.0f, Sizeable.Unit.PIXELS);
        ArrayList<FieldModel> arrayList = new ArrayList<FieldModel>();
        Map<Integer, FieldObjectMetaDataModel> map = this.getApplicationRoot().getLayoutDataModel().getSortableFieldNames(false);
        int n = 0;
        for (FieldObjectMetaDataModel horizontalLayout2 : map.values()) {
            String string = horizontalLayout2.getFieldName(false);
            iterator = horizontalLayout2.getFieldNameAliasForSort(false);
            if (string.endsWith("<No Access>") || horizontalLayout2.getFieldType() == LayoutFieldType.SUMMARY || FieldModelHelpers.nameExists(string, arrayList)) continue;
            object = new FieldModel();
            ((SortQuery)object).setFieldName(string);
            ((SortQuery)object).setFieldNameAliasForSort((String)((Object)iterator));
            ((SortQuery)object).setCriteria(SortQueryCriteria.ASC);
            ((SortQuery)object).setFieldId(horizontalLayout2.getFieldId());
            ((SortQuery)object).setTableId(horizontalLayout2.getTableId());
            arrayList.add((FieldModel)object);
        }
        List<SortQuery> list = this.getApplicationRoot().getDatabaseDataModel().getSortQueries();
        if (!list.isEmpty()) {
            for (SortQuery sortQuery : list) {
                if (FieldModelHelpers.nameExists(sortQuery.getFieldName(), arrayList) || FieldModelHelpers.nameAliasExists(sortQuery.getFieldNameAliasForSort(), arrayList)) continue;
                iterator = new FieldModel(sortQuery);
                arrayList.add((FieldModel)((Object)iterator));
            }
        }
        Collections.sort(arrayList, FieldModelHelpers.nameComparator);
        for (FieldModel fieldModel : arrayList) {
            iterator = fieldModel.getFieldName();
            object = fieldModel.getFieldNameAliasForSort();
            MobileTouchControl mobileTouchControl = new MobileTouchControl(MobileTouchControl.Type.LIST_ITEM);
            if (object != null && !((String)object).isEmpty()) {
                mobileTouchControl.setText((String)object);
            } else {
                mobileTouchControl.setText((String)((Object)iterator));
            }
            mobileTouchControl.setCustomId(++n);
            mobileTouchControl.setData(fieldModel);
            mobileTouchControl.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

                public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                    MobileSortDialog.this.onCloseAddFieldPanel((MobileTouchControl)layoutClickEvent.getComponent());
                }
            });
            this.fieldsList.addComponent((Component)mobileTouchControl);
        }
        verticalLayout.addComponent((Component)this.fieldsList);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setMargin(new MarginInfo(true, false, false, false));
        DialogButton dialogButton = new DialogButton(this.app, this.app.getLocalizedString("CANCEL"), this);
        dialogButton.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                MobileSortDialog.this.onCloseAddFieldPanel(null);
            }
        });
        dialogButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        horizontalLayout.addComponent((Component)dialogButton);
        horizontalLayout.setExpandRatio((Component)dialogButton, 1.0f);
        horizontalLayout.setSizeFull();
        this.addFieldPanel.addComponent((Component)horizontalLayout);
        this.addFieldPanel.setComponentAlignment((Component)horizontalLayout, Alignment.BOTTOM_CENTER);
        this.addFieldPanel.setSpacing(true);
        this.addFieldPanel.setMargin(true);
        if (!list.isEmpty()) {
            iterator = list.iterator();
            while (iterator.hasNext()) {
                this.addFieldToSortList((SortQuery)iterator.next());
            }
        }
    }

    private void onOpenAddFieldPanel() {
        this.setContent((Component)this.addFieldPanel);
        this.setCaption(this.app.getLocalizedString("SORT_ADD_FIELD"));
        this.clearButtonStyles();
        this.removeCloseShortcut();
    }

    private void onCloseAddFieldPanel(MobileTouchControl mobileTouchControl) {
        if (mobileTouchControl != null) {
            this.addFieldToSortList(mobileTouchControl, null);
        }
        this.switchToRootPanel();
    }

    private void addFieldToSortList(SortQuery sortQuery) {
        MobileTouchControl mobileTouchControl = null;
        for (int i = 0; i < this.fieldsList.getComponentCount(); ++i) {
            MobileTouchControl mobileTouchControl2 = (MobileTouchControl)this.fieldsList.getComponent(i);
            if (!mobileTouchControl2.getText().equals(sortQuery.getFieldName()) && !mobileTouchControl2.getText().equals(sortQuery.getFieldNameAliasForSort())) continue;
            mobileTouchControl = mobileTouchControl2;
            break;
        }
        if (mobileTouchControl != null) {
            this.addFieldToSortList(mobileTouchControl, sortQuery);
        }
    }

    private void addFieldToSortList(MobileTouchControl mobileTouchControl, SortQuery sortQuery) {
        MobileTouchControl mobileTouchControl2 = new MobileTouchControl(MobileTouchControl.Type.LIST_ITEM);
        mobileTouchControl2.copyFrom(mobileTouchControl);
        String string = ASCENDING_ORDER_ICON;
        if (sortQuery != null) {
            mobileTouchControl2.setData(sortQuery);
            SortQueryCriteria sortQueryCriteria = sortQuery.getCriteria();
            if (sortQueryCriteria == SortQueryCriteria.DESC) {
                string = DESCENDING_ORDER_ICON;
            } else if (sortQueryCriteria == SortQueryCriteria.CUSTOM) {
                string = CUSTOM_ORDER_ICON;
            }
        } else {
            sortQuery = (SortQuery)mobileTouchControl2.getData();
            sortQuery.setCriteria(SortQueryCriteria.ASC);
            sortQuery.setValue("");
        }
        mobileTouchControl2.setLeftIconAsResource(string + ".png");
        mobileTouchControl2.setRightIcon("icon-subitem");
        mobileTouchControl2.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                MobileSortDialog.this.onOpenFieldSettingsPanel((MobileTouchControl)layoutClickEvent.getComponent());
            }
        });
        this.sortList.addComponent((Component)mobileTouchControl2, this.sortList.getComponentCount());
        mobileTouchControl.setVisible(false);
    }

    private void onOpenFieldSettingsPanel(MobileTouchControl mobileTouchControl) {
        this.currentSortFieldIndex = this.sortList.getComponentIndex((Component)mobileTouchControl);
        if (this.fieldSettingsPanel == null) {
            this.initFieldsSettingsPanel();
        }
        this.fieldSettingsField.setText(mobileTouchControl.getText());
        SortQuery sortQuery = (SortQuery)mobileTouchControl.getData();
        if (sortQuery != null) {
            SortQueryCriteria sortQueryCriteria = sortQuery.getCriteria();
            switch (sortQueryCriteria) {
                case ASC: {
                    this.sortOrderSelect.select((Object)this.app.getLocalizedString("SORT_ASCENDING_ORDER"));
                    if (!this.hasValueLists) break;
                    this.valueList.setValue(this.valueListData.values().toArray()[0]);
                    break;
                }
                case DESC: {
                    this.sortOrderSelect.select((Object)this.app.getLocalizedString("SORT_DESCENDING_ORDER"));
                    if (!this.hasValueLists) break;
                    this.valueList.setValue(this.valueListData.values().toArray()[0]);
                    break;
                }
                case CUSTOM: {
                    this.sortOrderSelect.select((Object)this.app.getLocalizedString("SORT_CUSTOM_ORDER"));
                    if (!this.hasValueLists) break;
                    this.valueList.setValue((Object)sortQuery.getValue());
                }
            }
        }
        this.setContent((Component)this.fieldSettingsPanel);
        this.setCaption(this.app.getLocalizedString("SORT_FIELD_SETTINGS_TITLE"));
        this.clearButtonStyles();
        this.fieldSettingsOKButton.addStyleName("primary");
        this.fieldSettingsOKButton.setEnabled(false);
        this.removeCloseShortcut();
    }

    private void initFieldsSettingsPanel() {
        this.fieldSettingsPanel = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        this.fieldSettingsField = new MobileTouchControl(MobileTouchControl.Type.LABEL);
        this.fieldSettingsField.setHasBorder();
        this.fieldSettingsField.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        horizontalLayout.addComponent((Component)this.fieldSettingsField);
        horizontalLayout.setSizeFull();
        this.fieldSettingsPanel.addComponent((Component)horizontalLayout);
        this.sortOrderSelect = new OptionGroup(null, this.orderOptions);
        this.sortOrderSelect.addStyleName(ORDER_OPTIONS_STYLE);
        this.sortOrderSelect.setNullSelectionAllowed(false);
        this.sortOrderSelect.select((Object)this.app.getLocalizedString("SORT_ASCENDING_ORDER"));
        this.sortOrderSelect.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                MobileSortDialog.this.onSortOrderChanged(valueChangeEvent);
            }
        });
        this.fieldSettingsPanel.addComponent((Component)this.sortOrderSelect);
        this.valueList = new NativeSelect();
        this.valueList.setNullSelectionAllowed(false);
        this.valueList.setSizeUndefined();
        if (this.valueListData == null || this.valueListData.isEmpty()) {
            this.valueList.setEnabled(false);
        } else {
            for (String object2 : this.valueListData.values()) {
                this.valueList.addItem((Object)object2);
            }
            this.valueList.setValue(this.valueListData.values().toArray()[0]);
        }
        this.valueList.addStyleName(SELECT_STYLE);
        this.valueList.setEnabled(false);
        this.valueList.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                MobileSortDialog.this.onSortValueListChanged(valueChangeEvent);
            }
        });
        this.fieldSettingsPanel.addComponent((Component)this.valueList);
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName(CENTERED_BOX_STYLE);
        MobileTouchControl mobileTouchControl = new MobileTouchControl(MobileTouchControl.Type.TEXT_BUTTON);
        mobileTouchControl.setText(this.app.getLocalizedString("SORT_REMOVE_FIELD_BUTTON"));
        mobileTouchControl.setTextWrap(true);
        mobileTouchControl.addLayoutClickListener(new LayoutEvents.LayoutClickListener(){

            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                MobileTouchControl mobileTouchControl = (MobileTouchControl)MobileSortDialog.this.sortList.getComponent(MobileSortDialog.this.currentSortFieldIndex);
                MobileSortDialog.this.onRemoveFieldFromSortList(mobileTouchControl);
            }
        });
        cssLayout.addComponent((Component)mobileTouchControl);
        this.fieldSettingsPanel.addComponent((Component)cssLayout);
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.setSpacing(true);
        horizontalLayout2.setMargin(new MarginInfo(true, false, false, false));
        DialogButton dialogButton = new DialogButton(this.app, this.app.getLocalizedString("CANCEL"), this);
        dialogButton.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                MobileSortDialog.this.onCloseFieldSettingsPanel(false);
            }
        });
        dialogButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        horizontalLayout2.addComponent((Component)dialogButton);
        horizontalLayout2.setExpandRatio((Component)dialogButton, 1.0f);
        this.fieldSettingsOKButton = new DialogButton(this.app, this.app.getLocalizedString("OK"), this);
        this.fieldSettingsOKButton.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                MobileSortDialog.this.onCloseFieldSettingsPanel(true);
            }
        });
        this.fieldSettingsOKButton.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        horizontalLayout2.addComponent((Component)this.fieldSettingsOKButton);
        horizontalLayout2.setExpandRatio((Component)this.fieldSettingsOKButton, 1.0f);
        horizontalLayout2.setSizeFull();
        this.fieldSettingsPanel.addComponent((Component)horizontalLayout2);
        this.fieldSettingsPanel.setComponentAlignment((Component)horizontalLayout2, Alignment.BOTTOM_CENTER);
        this.fieldSettingsPanel.setMargin(true);
    }

    private void onSortOrderChanged(Property.ValueChangeEvent valueChangeEvent) {
        String string = (String)valueChangeEvent.getProperty().getValue();
        if (!string.equals("[]")) {
            boolean bl = this.app.getLocalizedString("SORT_CUSTOM_ORDER").equalsIgnoreCase(string);
            this.valueList.setEnabled(this.hasValueLists && bl);
            this.updateFieldSettingsButtonState();
        }
    }

    private void onSortValueListChanged(Property.ValueChangeEvent valueChangeEvent) {
        if (!valueChangeEvent.getProperty().getValue().equals("[]")) {
            this.updateFieldSettingsButtonState();
        }
    }

    private void updateFieldSettingsButtonState() {
        boolean bl = false;
        String string = (String)this.sortOrderSelect.getValue();
        MobileTouchControl mobileTouchControl = (MobileTouchControl)this.sortList.getComponent(this.currentSortFieldIndex);
        SortQuery sortQuery = (SortQuery)mobileTouchControl.getData();
        SortQueryCriteria sortQueryCriteria = SortQueryCriteria.ASC;
        if (this.app.getLocalizedString("SORT_DESCENDING_ORDER").equals(string)) {
            sortQueryCriteria = SortQueryCriteria.DESC;
        } else if (this.app.getLocalizedString("SORT_CUSTOM_ORDER").equals(string)) {
            sortQueryCriteria = SortQueryCriteria.CUSTOM;
        }
        if (sortQuery.getCriteria() != sortQueryCriteria) {
            bl = true;
        }
        if (sortQueryCriteria == SortQueryCriteria.CUSTOM) {
            if (!this.hasValueLists) {
                bl = false;
            } else if (!bl) {
                boolean bl2 = bl = !this.valueList.getValue().equals(sortQuery.getValue());
            }
        }
        if (bl != this.fieldSettingsOKButton.isEnabled()) {
            this.fieldSettingsOKButton.setEnabled(bl);
        }
    }

    private void onCloseFieldSettingsPanel(boolean bl) {
        if (bl) {
            this.saveFieldSettings();
        }
        this.switchToRootPanel();
    }

    private void saveFieldSettings() {
        MobileTouchControl mobileTouchControl = (MobileTouchControl)this.sortList.getComponent(this.currentSortFieldIndex);
        SortQuery sortQuery = (SortQuery)mobileTouchControl.getData();
        SortQueryCriteria sortQueryCriteria = SortQueryCriteria.ASC;
        String string = ASCENDING_ORDER_ICON;
        String string2 = (String)this.sortOrderSelect.getValue();
        if (this.app.getLocalizedString("SORT_DESCENDING_ORDER").equals(string2)) {
            sortQueryCriteria = SortQueryCriteria.DESC;
            string = DESCENDING_ORDER_ICON;
        } else if (this.app.getLocalizedString("SORT_CUSTOM_ORDER").equals(string2)) {
            sortQueryCriteria = SortQueryCriteria.CUSTOM;
            string = CUSTOM_ORDER_ICON;
        }
        sortQuery.setCriteria(sortQueryCriteria);
        sortQuery.setValue((String)this.valueList.getValue());
        mobileTouchControl.setData(sortQuery);
        mobileTouchControl.setLeftIconAsResource(string + ".png");
    }

    private void onRemoveFieldFromSortList(MobileTouchControl mobileTouchControl) {
        int n = mobileTouchControl.getCustomId();
        this.sortList.removeComponent((Component)mobileTouchControl);
        mobileTouchControl = null;
        for (int i = 0; i < this.fieldsList.getComponentCount(); ++i) {
            MobileTouchControl mobileTouchControl2 = (MobileTouchControl)this.fieldsList.getComponent(i);
            if (mobileTouchControl2.getCustomId() != n) continue;
            mobileTouchControl2.setVisible(true);
            break;
        }
        this.switchToRootPanel();
    }

    private void onRemoveAllFieldsFromSortList() {
        int n = this.sortList.getComponentCount();
        if (n > 0) {
            MobileTouchControl mobileTouchControl;
            int n2;
            for (n2 = n - 1; n2 > -1; --n2) {
                mobileTouchControl = (MobileTouchControl)this.sortList.getComponent(n2);
                this.sortList.removeComponent((Component)mobileTouchControl);
                mobileTouchControl = null;
            }
            for (n2 = 0; n2 < this.fieldsList.getComponentCount(); ++n2) {
                mobileTouchControl = (MobileTouchControl)this.fieldsList.getComponent(n2);
                if (mobileTouchControl.isVisible()) continue;
                mobileTouchControl.setVisible(true);
            }
            this.updateClearButton();
            this.updateAddFieldButton();
            this.updateSortButton();
        }
    }

    private void updateSortButton() {
        this.getRightButton().setEnabled(this.sortList.getComponentCount() > 0);
    }

    private void updateAddFieldButton() {
        boolean bl = false;
        for (int i = 0; i < this.fieldsList.getComponentCount(); ++i) {
            MobileTouchControl mobileTouchControl = (MobileTouchControl)this.fieldsList.getComponent(i);
            if (!mobileTouchControl.isVisible()) continue;
            bl = true;
            break;
        }
        this.addFieldButton.setEnabled(bl);
    }

    private void updateClearButton() {
        this.clearButton.setEnabled(this.sortList.getComponentCount() > 0);
    }

    private void switchToRootPanel() {
        this.setContent((Component)this.root);
        this.setCaption(this.app.getLocalizedString("SORT_RECORDS_DIALOG_TITLE"));
        this.clearButtonStyles();
        this.setRightButtonDefault();
        this.updateClearButton();
        this.updateAddFieldButton();
        this.updateSortButton();
        this.setCloseShortcut(27, new int[0]);
    }

    private List<SortQuery> getSelectedSortQueries() {
        ArrayList<SortQuery> arrayList = new ArrayList<SortQuery>();
        for (int i = 0; i < this.sortList.getComponentCount(); ++i) {
            MobileTouchControl mobileTouchControl = (MobileTouchControl)this.sortList.getComponent(i);
            SortQuery sortQuery = (SortQuery)mobileTouchControl.getData();
            arrayList.add(sortQuery);
        }
        return arrayList;
    }

    @Override
    protected String getLeftButtonText() {
        return this.app.getLocalizedString("CANCEL");
    }

    @Override
    protected String getRightButtonText() {
        return this.app.getLocalizedString("SORT");
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.result.setAction(SortAction.Sort);
        List<SortQuery> list = this.getSelectedSortQueries();
        this.result.setQueries(list);
        this.app.getDatabaseDataModel().getSortState().setUnsort(false);
        this.app.getDatabaseDataModel().getSortState().setSortCriteriaOnColumns(true);
        this.app.getDatabaseDataModel().updateSortQueries(list);
        super.performRightButtonAction(clickEvent);
    }

    @Override
    public Object getResult() {
        return this.result;
    }

    public static class FieldModelHelpers {
        public static Comparator<FieldModel> nameComparator = new Comparator<FieldModel>(){

            @Override
            public int compare(FieldModel fieldModel, FieldModel fieldModel2) {
                return fieldModel.getFieldName().compareTo(fieldModel2.getFieldName());
            }
        };

        public static boolean nameExists(String string, List<FieldModel> list) {
            boolean bl = false;
            for (FieldModel fieldModel : list) {
                if (!fieldModel.getFieldName().equals(string)) continue;
                bl = true;
                break;
            }
            return bl;
        }

        public static boolean nameAliasExists(String string, List<FieldModel> list) {
            boolean bl = false;
            for (FieldModel fieldModel : list) {
                if (fieldModel.getFieldNameAliasForSort() == null || fieldModel.getFieldNameAliasForSort().isEmpty() || !fieldModel.getFieldNameAliasForSort().equals(string)) continue;
                bl = true;
                break;
            }
            return bl;
        }
    }

    private class FieldModel
    extends SortQuery {
        public FieldModel() {
        }

        public FieldModel(SortQuery sortQuery) {
            super(sortQuery);
        }
    }
}

