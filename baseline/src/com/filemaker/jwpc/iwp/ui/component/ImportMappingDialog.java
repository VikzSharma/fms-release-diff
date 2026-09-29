/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.MarginInfo
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.data.util.BeanItem
 *  com.vaadin.v7.data.util.BeanItemContainer
 *  com.vaadin.v7.event.ItemClickEvent
 *  com.vaadin.v7.event.ItemClickEvent$ItemClickListener
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.NativeSelect
 *  com.vaadin.v7.ui.Table$ColumnHeaderMode
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.thrift.common.ImportAction;
import com.filemaker.jwpc.iwp.thrift.common.ImportMappingDefinition;
import com.filemaker.jwpc.iwp.thrift.common.ImportMappingInfo;
import com.filemaker.jwpc.iwp.thrift.common.MappingOption;
import com.filemaker.jwpc.iwp.thrift.notification.ImportMappingDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.MultiColumnListSelect;
import com.filemaker.jwpc.iwp.ui.common.NavigableOptionGroup;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.BeanItem;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.event.ItemClickEvent;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.NativeSelect;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImportMappingDialog
extends ServerInvokedDialog {
    private static final Object SOURCE_DATA_PROPERTY = "sourceData";
    private static final Object MAPPING_OPTION_PROPERTY = "mappingOption";
    private static final Object FIELD_NAME_SELECT = "fieldNameSelect";
    private String INVALID_IMPORT_FIELD;
    private ImportListSelect listSelect;
    private final ImportMappingInfo result;
    private List<ImportMappingDefinition> initialMappingList;
    private NavigableOptionGroup addRemainingAsNewOptionGroup;
    private NavigableOptionGroup dontAddFirstRecordOptionGroup;
    private List<String> fieldNameList;
    private Map<String, ImportMappingDefinition> fieldNameToImportMappingDefinitionMap;
    private ImportAction importAction;
    protected boolean addRemainingRecordsAsNew;
    protected boolean firstSourceRowIsData;
    protected boolean firstRowIsDataSelectionEnabled;
    private List<NativeSelect> targetFields = new ArrayList<NativeSelect>();

    public ImportMappingDialog(App app, ImportMappingDialogNotification importMappingDialogNotification) {
        super(app, IWPI18N.get(app, "IMPORT_MAPPING_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        if (this.INVALID_IMPORT_FIELD == null) {
            this.INVALID_IMPORT_FIELD = IWPI18N.get(app, "IMPORT_MAPPING_INVALID_FIELD", new Object[0]);
        }
        this.setResizable(true);
        this.setSizeUndefined();
        this.fieldNameToImportMappingDefinitionMap = new HashMap<String, ImportMappingDefinition>();
        this.firstSourceRowIsData = importMappingDialogNotification.getMappingInfo().isFirstRowData();
        this.firstRowIsDataSelectionEnabled = importMappingDialogNotification.getMappingInfo().isFirstRowIsDataSelectionEnabled();
        this.addRemainingRecordsAsNew = importMappingDialogNotification.getMappingInfo().isAddRemainingNew();
        this.importAction = importMappingDialogNotification.getMappingInfo().getAction();
        this.initContent(this.getContentLayout(importMappingDialogNotification.getMappingInfo().getMappingList()));
        this.initButtons(this.getLeftButtonText(), this.getMiddleButtonText(), this.getRightButtonText());
        this.result = new ImportMappingInfo();
    }

    private Component getContentLayout(List<ImportMappingDefinition> list) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setSpacing(true);
        this.initialMappingList = list;
        this.fieldNameList = new ArrayList<String>();
        this.createFieldList(list);
        this.addFields(verticalLayout);
        return verticalLayout;
    }

    private void createFieldList(List<ImportMappingDefinition> list) {
        for (ImportMappingDefinition importMappingDefinition : list) {
            if (importMappingDefinition.getMappingOption() == MappingOption.UNIMPORTABLE && importMappingDefinition.getTargetField().length() <= 0) continue;
            this.fieldNameList.add(importMappingDefinition.getTargetField());
            this.fieldNameToImportMappingDefinitionMap.put(importMappingDefinition.getTargetField(), importMappingDefinition);
        }
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "IMPORT_RECORDS_UPLOAD_BUTTON_TEXT", new Object[0]);
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.clear();
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl = false;
        boolean bl2 = true;
        MultiColumnListSelect.MultiColumnListSelectTable multiColumnListSelectTable = this.listSelect.getTable();
        Container container = multiColumnListSelectTable.getContainerDataSource();
        Collection collection = container.getItemIds();
        for (ImportMapping importMapping : collection) {
            NativeSelect nativeSelect = (NativeSelect)importMapping.getFieldNameSelect();
            if (nativeSelect.getValue() == null || nativeSelect.getValue().toString().isEmpty()) continue;
            String string = nativeSelect.getValue().toString();
            if (this.isInvalidField(string)) {
                string = this.getFieldNameFromInvalidFieldName(string);
            } else {
                bl2 = false;
            }
            if (arrayList.contains(string)) {
                this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "IMPORT_MAPPING_CONFLICT", string));
                bl = true;
                break;
            }
            arrayList.add(string);
        }
        if (bl2) {
            this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "IMPORT_MAPPING_NO_FIELDS_SELECTED", new Object[0]));
        } else if (!bl && !bl2) {
            this.app.getMessenger().showBusyDialog(true, IWPI18N.get(this.app, "BUSY_DIALOG_WAIT", new Object[0]));
            this.result.setMappingList(this.getMappingList());
            this.result.setFirstRowData(this.firstSourceRowIsData);
            this.result.setAction(this.getImportAction());
            this.result.setAddRemainingNew(this.addRemainingRecordsAsNew);
            super.performRightButtonAction(clickEvent);
        }
    }

    @Override
    public Object getResult() {
        return this.result;
    }

    private void addFields(VerticalLayout verticalLayout) {
        ImportListSelect importListSelect;
        this.listSelect = importListSelect = new ImportListSelect(null);
        this.initListSelectTable(this.listSelect);
        this.listSelect.setSizeFull();
        verticalLayout.addComponent((Component)this.listSelect);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(IWPI18N.get(this.app, "IMPORT_RECORDS_ADD_NEW_RECORDS", new Object[0]));
        arrayList.add(IWPI18N.get(this.app, "IMPORT_RECORDS_UPDATE_EXISTING_RECORDS", new Object[0]));
        arrayList.add(IWPI18N.get(this.app, "IMPORT_RECORDS_MATCHING_RECORDS", new Object[0]));
        NavigableOptionGroup navigableOptionGroup = new NavigableOptionGroup(IWPI18N.get(this.app, "IMPORT_RECORDS_IMPORT_ACTION", new Object[0]), arrayList);
        if (this.app.getLayoutDataModel().getTotalRecords() == 0) {
            navigableOptionGroup.setItemEnabled(IWPI18N.get(this.app, "IMPORT_RECORDS_UPDATE_EXISTING_RECORDS", new Object[0]), false);
            navigableOptionGroup.setItemEnabled(IWPI18N.get(this.app, "IMPORT_RECORDS_MATCHING_RECORDS", new Object[0]), false);
        }
        navigableOptionGroup.select(this.actionToActionItemOption(this.importAction));
        navigableOptionGroup.setImmediate(true);
        navigableOptionGroup.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                String string = (String)valueChangeEvent.getProperty().getValue();
                ImportMappingDialog.this.updateImportMode(string);
            }
        });
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.setSpacing(true);
        verticalLayout2.setMargin(new MarginInfo(false, true, false, true));
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add(IWPI18N.get(this.app, "IMPORT_RECORDS_ADD_REMAINING_DATA_AS_NEW", new Object[0]));
        this.addRemainingAsNewOptionGroup = new NavigableOptionGroup("", arrayList2);
        this.addRemainingAsNewOptionGroup.setMultiSelect(true);
        this.addRemainingAsNewOptionGroup.setImmediate(true);
        if (this.getImportAction() != ImportAction.ADD) {
            this.addRemainingAsNewOptionGroup.setEnabled(true);
        } else {
            this.addRemainingAsNewOptionGroup.setEnabled(false);
        }
        if (this.addRemainingRecordsAsNew) {
            this.addRemainingAsNewOptionGroup.select(IWPI18N.get(this.app, "IMPORT_RECORDS_ADD_REMAINING_DATA_AS_NEW", new Object[0]));
        }
        this.addRemainingAsNewOptionGroup.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Set set = (Set)valueChangeEvent.getProperty().getValue();
                if (set.size() == 0) {
                    ImportMappingDialog.this.addRemainingRecordsAsNew = false;
                } else if (set.toArray()[0].equals(IWPI18N.get(ImportMappingDialog.this.app, "IMPORT_RECORDS_ADD_REMAINING_DATA_AS_NEW", new Object[0]))) {
                    ImportMappingDialog.this.addRemainingRecordsAsNew = true;
                }
            }
        });
        ArrayList<String> arrayList3 = new ArrayList<String>();
        arrayList3.add(IWPI18N.get(this.app, "IMPORT_RECORDS_DONT_IMPORT_FIRST_RECORD", new Object[0]));
        this.dontAddFirstRecordOptionGroup = new NavigableOptionGroup("", arrayList3);
        this.dontAddFirstRecordOptionGroup.setMultiSelect(true);
        this.dontAddFirstRecordOptionGroup.setImmediate(true);
        if (!this.firstSourceRowIsData) {
            this.dontAddFirstRecordOptionGroup.select(IWPI18N.get(this.app, "IMPORT_RECORDS_DONT_IMPORT_FIRST_RECORD", new Object[0]));
        }
        this.dontAddFirstRecordOptionGroup.setEnabled(this.firstRowIsDataSelectionEnabled);
        this.dontAddFirstRecordOptionGroup.addValueChangeListener(new Property.ValueChangeListener(){

            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Set set = (Set)valueChangeEvent.getProperty().getValue();
                if (set.size() == 0) {
                    ImportMappingDialog.this.firstSourceRowIsData = true;
                } else if (set.toArray()[0].equals(IWPI18N.get(ImportMappingDialog.this.app, "IMPORT_RECORDS_DONT_IMPORT_FIRST_RECORD", new Object[0]))) {
                    ImportMappingDialog.this.firstSourceRowIsData = false;
                }
            }
        });
        this.updateImportMode(this.actionToActionItemOption(this.importAction));
        verticalLayout2.setWidth("280px");
        verticalLayout2.addComponent((Component)this.addRemainingAsNewOptionGroup);
        verticalLayout2.addComponent((Component)this.dontAddFirstRecordOptionGroup);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent((Component)navigableOptionGroup);
        horizontalLayout.addComponent((Component)verticalLayout2);
        verticalLayout.addComponent((Component)horizontalLayout);
        verticalLayout.setExpandRatio((Component)horizontalLayout, 1.0f);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            navigableOptionGroup.setTabIndex(-1);
            this.addRemainingAsNewOptionGroup.setTabIndex(-1);
            this.dontAddFirstRecordOptionGroup.setTabIndex(-1);
        }
    }

    private String actionToActionItemOption(ImportAction importAction) {
        switch (importAction) {
            case ADD: {
                return IWPI18N.get(this.app, "IMPORT_RECORDS_ADD_NEW_RECORDS", new Object[0]);
            }
            case UPDATE: {
                return IWPI18N.get(this.app, "IMPORT_RECORDS_UPDATE_EXISTING_RECORDS", new Object[0]);
            }
            case UPDATE_MATCH: {
                return IWPI18N.get(this.app, "IMPORT_RECORDS_MATCHING_RECORDS", new Object[0]);
            }
        }
        return null;
    }

    protected void updateImportMode(String string) {
        if (string.equals(IWPI18N.get(this.app, "IMPORT_RECORDS_ADD_NEW_RECORDS", new Object[0]))) {
            this.gotoAddMode();
        } else if (string.equals(IWPI18N.get(this.app, "IMPORT_RECORDS_UPDATE_EXISTING_RECORDS", new Object[0]))) {
            this.gotoUpdateMode();
        } else if (string.equals(IWPI18N.get(this.app, "IMPORT_RECORDS_MATCHING_RECORDS", new Object[0]))) {
            this.gotoMatchMode();
        }
    }

    private void gotoMatchMode() {
        this.setImportAction(ImportAction.UPDATE_MATCH);
        this.listSelect.getTable().setMatchMode(true);
        this.listSelect.getTable().setVisibleColumns(new Object[]{SOURCE_DATA_PROPERTY, MAPPING_OPTION_PROPERTY, FIELD_NAME_SELECT});
        this.listSelect.getTable().setColumnHeader(MAPPING_OPTION_PROPERTY, "=");
        this.addRemainingAsNewOptionGroup.setEnabled(true);
    }

    private void gotoUpdateMode() {
        this.setImportAction(ImportAction.UPDATE);
        this.listSelect.getTable().setMatchMode(false);
        this.listSelect.getTable().setVisibleColumns(new Object[]{SOURCE_DATA_PROPERTY, FIELD_NAME_SELECT});
        this.addRemainingAsNewOptionGroup.setEnabled(true);
    }

    private void gotoAddMode() {
        this.setImportAction(ImportAction.ADD);
        this.listSelect.getTable().setMatchMode(false);
        this.listSelect.getTable().setVisibleColumns(new Object[]{SOURCE_DATA_PROPERTY, FIELD_NAME_SELECT});
        this.addRemainingAsNewOptionGroup.setEnabled(false);
    }

    private void initListSelectTable(ImportListSelect importListSelect) {
        final MultiColumnListSelect.MultiColumnListSelectTable multiColumnListSelectTable = importListSelect.getTable();
        importListSelect.setContainerDataSource((Container)this.getContainerDataSource());
        multiColumnListSelectTable.setVisibleColumns(new Object[]{SOURCE_DATA_PROPERTY, FIELD_NAME_SELECT});
        multiColumnListSelectTable.setColumnExpandRatio(SOURCE_DATA_PROPERTY, 0.375f);
        multiColumnListSelectTable.setColumnExpandRatio(MAPPING_OPTION_PROPERTY, 0.025f);
        multiColumnListSelectTable.setColumnExpandRatio(FIELD_NAME_SELECT, 0.6f);
        multiColumnListSelectTable.setColumnHeaderMode(Table.ColumnHeaderMode.EXPLICIT_DEFAULTS_ID);
        multiColumnListSelectTable.addItemClickListener(new ItemClickEvent.ItemClickListener(){
            final /* synthetic */ ImportMappingDialog this$0;
            {
                this.this$0 = importMappingDialog;
            }

            public void itemClick(ItemClickEvent itemClickEvent) {
                if (itemClickEvent.getPropertyId().toString().equals(MAPPING_OPTION_PROPERTY) && this.this$0.getImportAction() == ImportAction.UPDATE_MATCH) {
                    ImportMapping importMapping = (ImportMapping)itemClickEvent.getItemId();
                    if (importMapping.getMappingOptionAsEnum() == MappingOption.IMPORT || importMapping.getMappingOptionAsEnum() == MappingOption.UNIMPORTABLE) {
                        ImportMappingDefinition importMappingDefinition;
                        if (multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).isReadOnly()) {
                            multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).setReadOnly(false);
                        }
                        if ((importMappingDefinition = this.this$0.fieldNameToImportMappingDefinitionMap.get(importMapping.getFieldName())) == null || !importMappingDefinition.isGlobalField()) {
                            multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).setValue((Object)MappingOption.MATCH.toString());
                        }
                        if (importMapping.getMappingOptionAsEnum() == MappingOption.UNIMPORTABLE) {
                            importMapping.setMappingOption(MappingOption.MATCH);
                        }
                    } else if (importMapping.getMappingOptionAsEnum() == MappingOption.MATCH) {
                        if (multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).isReadOnly()) {
                            multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).setReadOnly(false);
                        }
                        multiColumnListSelectTable.getContainerDataSource().getContainerProperty(itemClickEvent.getItemId(), itemClickEvent.getPropertyId()).setValue((Object)MappingOption.IMPORT.toString());
                    }
                }
            }
        });
        multiColumnListSelectTable.setSelectable(false);
        multiColumnListSelectTable.setColumnHeader(SOURCE_DATA_PROPERTY, IWPI18N.get(this.app, "IMPORT_RECORDS_SOURCE_FIELDS", new Object[0]));
        multiColumnListSelectTable.setColumnHeader(FIELD_NAME_SELECT, IWPI18N.get(this.app, "IMPORT_RECORDS_TARGET_FIELDS", new Object[0]));
        multiColumnListSelectTable.setColumnHeader(MAPPING_OPTION_PROPERTY, "=");
    }

    private List<ImportMappingDefinition> getMappingList() {
        ArrayList<ImportMappingDefinition> arrayList = new ArrayList<ImportMappingDefinition>();
        BeanItemContainer beanItemContainer = (BeanItemContainer)this.listSelect.getTable().getContainerDataSource();
        Object object = beanItemContainer.firstItemId();
        while (object != null) {
            BeanItem beanItem = beanItemContainer.getItem(object);
            ImportMapping serializable = (ImportMapping)beanItem.getBean();
            ImportMappingDefinition importMappingDefinition = new ImportMappingDefinition();
            importMappingDefinition.setTargetField(serializable.getFieldName());
            boolean bl = false;
            String string = null;
            if (serializable.getFieldName() != null && serializable.getFieldName().length() > 0) {
                ImportMappingDefinition importMappingDefinition2;
                string = serializable.getFieldName();
                if (this.isInvalidField(string)) {
                    string = this.getFieldNameFromInvalidFieldName(string);
                    if (serializable.getMappingOptionAsEnum() != MappingOption.MATCH) {
                        bl = true;
                    }
                }
                if ((importMappingDefinition2 = this.fieldNameToImportMappingDefinitionMap.get(string)) != null) {
                    if (importMappingDefinition2.getMappingOption() == MappingOption.UNIMPORTABLE && serializable.getMappingOptionAsEnum() != MappingOption.MATCH) {
                        importMappingDefinition.setMappingOption(MappingOption.UNIMPORTABLE);
                    } else {
                        MappingOption mappingOption = serializable.getMappingOptionAsEnum();
                        if (this.getImportAction() != ImportAction.UPDATE_MATCH && mappingOption == MappingOption.MATCH) {
                            mappingOption = MappingOption.IMPORT;
                        }
                        importMappingDefinition.setMappingOption(mappingOption);
                        importMappingDefinition.setTargetFieldFlags(importMappingDefinition2.getTargetFieldFlags());
                    }
                    importMappingDefinition.setFieldKey(importMappingDefinition2.getFieldKey());
                }
            } else {
                importMappingDefinition.setMappingOption(MappingOption.NO_IMPORT);
            }
            if (!bl) {
                arrayList.add(importMappingDefinition);
                if (string != null) {
                    this.fieldNameToImportMappingDefinitionMap.remove(string);
                }
            }
            object = beanItemContainer.nextItemId(object);
        }
        if (this.fieldNameToImportMappingDefinitionMap.size() > 0) {
            for (ImportMappingDefinition importMappingDefinition : this.fieldNameToImportMappingDefinitionMap.values()) {
                importMappingDefinition.setMappingOption(MappingOption.NO_IMPORT);
                arrayList.add(importMappingDefinition);
            }
        }
        return arrayList;
    }

    protected String getFieldNameFromInvalidFieldName(String string) {
        return string.substring(0, string.length() - this.INVALID_IMPORT_FIELD.length() - 1);
    }

    protected BeanItemContainer<ImportMapping> getContainerDataSource() {
        BeanItemContainer beanItemContainer = new BeanItemContainer(ImportMapping.class);
        if (this.initialMappingList != null) {
            for (ImportMappingDefinition importMappingDefinition : this.initialMappingList) {
                if (importMappingDefinition.getMappingOption() == MappingOption.NO_IMPORT || importMappingDefinition.getMappingOption() == MappingOption.UNIMPORTABLE && !importMappingDefinition.isSourceDataPresent()) continue;
                ImportMapping importMapping = new ImportMapping((BeanItemContainer<ImportMapping>)beanItemContainer, importMappingDefinition, false, importMappingDefinition.getMappingOption());
                beanItemContainer.addBean((Object)importMapping);
            }
        }
        return beanItemContainer;
    }

    public ImportAction getImportAction() {
        return this.importAction;
    }

    public void setImportAction(ImportAction importAction) {
        this.importAction = importAction;
    }

    private boolean isInvalidField(String string) {
        return string.endsWith(this.INVALID_IMPORT_FIELD);
    }

    private final class ImportListSelect
    extends MultiColumnListSelect {
        public ImportListSelect(String string) {
            super(string);
        }

        public void setContainerDataSource(Container container) {
            MultiColumnListSelect.MultiColumnListSelectTable multiColumnListSelectTable = this.getTable();
            multiColumnListSelectTable.setContainerDataSource(container);
        }
    }

    public final class ImportMapping
    implements Serializable {
        private BeanItemContainer<ImportMapping> container;
        private ImportMappingDefinition definition;
        private String sourceData;
        private String fieldName;
        private boolean selected;
        private String upAndDown;
        private MappingOption mappingOption;
        private NativeSelect fieldNameSelect;

        public ImportMapping(BeanItemContainer<ImportMapping> beanItemContainer, ImportMappingDefinition importMappingDefinition, boolean bl, MappingOption mappingOption) {
            this.container = beanItemContainer;
            this.definition = importMappingDefinition;
            this.sourceData = importMappingDefinition.getSourceData();
            this.fieldName = importMappingDefinition.getTargetField();
            this.selected = bl;
            this.mappingOption = mappingOption;
            this.initFieldNameSelect();
        }

        private void initFieldNameSelect() {
            NativeSelect nativeSelect = new NativeSelect();
            nativeSelect.setNullSelectionAllowed(false);
            nativeSelect.addItem((Object)"");
            for (String string : ImportMappingDialog.this.fieldNameList) {
                ImportMappingDefinition importMappingDefinition = ImportMappingDialog.this.fieldNameToImportMappingDefinitionMap.get(string);
                MappingOption mappingOption = importMappingDefinition.getMappingOption();
                if (mappingOption != MappingOption.UNIMPORTABLE) {
                    nativeSelect.addItem((Object)string);
                    continue;
                }
                nativeSelect.addItem((Object)this.createInvalidFieldName(string));
            }
            if (this.fieldName != null) {
                nativeSelect.select((Object)this.fieldName);
            }
            nativeSelect.setImmediate(true);
            nativeSelect.addValueChangeListener(new Property.ValueChangeListener(){

                public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                    String string = (String)valueChangeEvent.getProperty().getValue();
                    if (string != null && string.length() > 0) {
                        ImportMapping.this.setFieldName(string);
                        ImportMappingDefinition importMappingDefinition = ImportMappingDialog.this.fieldNameToImportMappingDefinitionMap.get(string);
                        if (importMappingDefinition != null) {
                            Property property = ImportMapping.this.getContainer().getContainerProperty((Object)ImportMapping.this, MAPPING_OPTION_PROPERTY);
                            if (property.isReadOnly()) {
                                property.setReadOnly(false);
                            }
                            property.setValue((Object)MappingOption.IMPORT.toString());
                        }
                    } else {
                        ImportMapping.this.setFieldName("");
                        Property property = ImportMapping.this.getContainer().getContainerProperty((Object)ImportMapping.this, MAPPING_OPTION_PROPERTY);
                        if (property.isReadOnly()) {
                            property.setReadOnly(false);
                        }
                        property.setValue((Object)MappingOption.NO_IMPORT.toString());
                    }
                }
            });
            ImportMappingDialog.this.targetFields.add(nativeSelect);
            this.fieldNameSelect = nativeSelect;
        }

        protected String createInvalidFieldName(String string) {
            return string + " " + ImportMappingDialog.this.INVALID_IMPORT_FIELD;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setFieldName(String string) {
            this.fieldName = string;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean bl) {
            this.selected = bl;
        }

        public String getUpAndDown() {
            return this.upAndDown;
        }

        public void setUpAndDown(String string) {
            this.upAndDown = string;
        }

        public ImportMappingDefinition getMappingDefinition() {
            return this.definition;
        }

        public BeanItemContainer<ImportMapping> getContainer() {
            return this.container;
        }

        public String getSourceData() {
            return this.sourceData;
        }

        public MappingOption getMappingOptionAsEnum() {
            return this.mappingOption;
        }

        public String getMappingOption() {
            if (this.fieldName != null && this.fieldName.length() > 0) {
                return this.mappingOptionToString();
            }
            return null;
        }

        private String mappingOptionToString() {
            switch (this.mappingOption) {
                case MATCH: {
                    return "=";
                }
            }
            return null;
        }

        public void setMappingOption(String string) {
            this.mappingOption = this.stringToMappingOption(string);
        }

        private MappingOption stringToMappingOption(String string) {
            if (string.equalsIgnoreCase(MappingOption.MATCH.toString())) {
                return MappingOption.MATCH;
            }
            if (string.equalsIgnoreCase(MappingOption.IMPORT.toString())) {
                return MappingOption.IMPORT;
            }
            if (string.equalsIgnoreCase(MappingOption.NO_IMPORT.toString())) {
                return MappingOption.NO_IMPORT;
            }
            if (string.equalsIgnoreCase(MappingOption.UNIMPORTABLE.toString())) {
                return MappingOption.UNIMPORTABLE;
            }
            return null;
        }

        public void setMappingOption(MappingOption mappingOption) {
            this.mappingOption = mappingOption;
        }

        public Component getFieldNameSelect() {
            return this.fieldNameSelect;
        }

        public void setFieldNameSelect(NativeSelect nativeSelect) {
            this.fieldNameSelect = nativeSelect;
        }
    }
}

