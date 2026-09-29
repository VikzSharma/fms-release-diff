/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.dd.DragAndDropEvent
 *  com.vaadin.event.dd.DropHandler
 *  com.vaadin.event.dd.acceptcriteria.AcceptCriterion
 *  com.vaadin.event.dd.acceptcriteria.And
 *  com.vaadin.event.dd.acceptcriteria.ClientSideCriterion
 *  com.vaadin.event.dd.acceptcriteria.SourceIs
 *  com.vaadin.server.ClientConnector$AttachEvent
 *  com.vaadin.server.ClientConnector$AttachListener
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Embedded
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.data.util.BeanItemContainer
 *  com.vaadin.v7.event.DataBoundTransferable
 *  com.vaadin.v7.ui.AbstractSelect$AcceptItem
 *  com.vaadin.v7.ui.CheckBox
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.Table
 *  com.vaadin.v7.ui.Table$ColumnGenerator
 *  com.vaadin.v7.ui.Table$TableDragMode
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.model.FieldObjectMetaDataModel;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.ExportGroupByInfo;
import com.filemaker.jwpc.iwp.thrift.common.ExportMappingInfo;
import com.filemaker.jwpc.iwp.thrift.common.FieldDefinition;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.notification.ExportMappingDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.MultiColumnListSelect;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.common.TwinListSelect;
import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.event.dd.acceptcriteria.ClientSideCriterion;
import com.vaadin.event.dd.acceptcriteria.SourceIs;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.event.DataBoundTransferable;
import com.vaadin.v7.ui.AbstractSelect;
import com.vaadin.v7.ui.CheckBox;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class ExportMappingDialog
extends ServerInvokedDialog {
    private static final String DIALOG_WIDTH = "560px";
    private static final Object FIELD_NAME_PROPERTY = "fieldName";
    private static final Object SELECTED_PROPERTY = "selected";
    private static final Object UP_AND_DOWN_PROPERTY = "upAndDown";
    private static final ThemeResource UP_AND_DOWN_ICON = new ThemeResource("images/up_and_down.png");
    private static final String CAPTION_CSS_STYLE = "v-caption-sr-only-caption-dialog-fields";
    private ExportTwinListSelect fieldsTCS;
    private MultiColumnListSelect groupByListSelect;
    private final ExportMappingInfo result;
    private List<FieldDefinition> initialFieldList;
    private Set<String> selectedGroupByFields;
    private Button moveAllButton;

    public ExportMappingDialog(App app, ExportMappingDialogNotification exportMappingDialogNotification) {
        super(app, IWPI18N.get(app, "EXPORT_MAPPING_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        this.setWidth(DIALOG_WIDTH);
        this.setResizable(true);
        this.selectedGroupByFields = new HashSet<String>();
        this.initContent(this.getContentLayout(exportMappingDialogNotification.getFieldList(), exportMappingDialogNotification.getGroupByInfoList()));
        this.initButtons(this.getLeftButtonText(), this.getMiddleButtonText(), this.getRightButtonText());
        this.updateSortButtonState();
        this.fieldsTCS.updateMoveAllButtonState();
        this.result = new ExportMappingInfo();
    }

    private Component getContentLayout(List<FieldDefinition> list, List<ExportGroupByInfo> list2) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setSpacing(true);
        this.initialFieldList = list;
        this.normalizeInitialFieldList();
        this.addFields(verticalLayout, list2);
        return verticalLayout;
    }

    private String removeTableQualifier(String string) {
        String string2;
        String string3 = this.getApplicationRoot().getLayoutDataModel().getLayoutTableName();
        int n = string.indexOf("::");
        if (n != -1 && (string2 = string.substring(0, n)).equals(string3)) {
            string = string.substring(n + 2);
        }
        return string;
    }

    private void normalizeInitialFieldList() {
        for (FieldDefinition fieldDefinition : this.initialFieldList) {
            fieldDefinition.setFieldName(this.removeTableQualifier(fieldDefinition.getFieldName()));
            fieldDefinition.setFieldNameAliasForExport(this.removeTableQualifier(fieldDefinition.getFieldNameAliasForExport()));
        }
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "EXPORT_BUTTON", new Object[0]);
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.clear();
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        this.result.setFieldList(this.getFieldList());
        this.result.setGroupByList(this.getSelectedGroupByList());
        super.performRightButtonAction(clickEvent);
    }

    private List<ExportGroupByInfo> getSelectedGroupByList() {
        ArrayList<ExportGroupByInfo> arrayList = new ArrayList<ExportGroupByInfo>();
        BeanItemContainer beanItemContainer = (BeanItemContainer)this.groupByListSelect.getTable().getContainerDataSource();
        List list = beanItemContainer.getItemIds();
        for (GroupByOrder groupByOrder : list) {
            if (!groupByOrder.isSelected()) continue;
            ExportGroupByInfo exportGroupByInfo = new ExportGroupByInfo();
            exportGroupByInfo.setFieldName(groupByOrder.getFieldName());
            exportGroupByInfo.setFieldChecked(true);
            arrayList.add(exportGroupByInfo);
        }
        return arrayList;
    }

    @Override
    public Object getResult() {
        return this.result;
    }

    private void addFields(VerticalLayout verticalLayout, List<ExportGroupByInfo> list) {
        ExportTwinListSelect exportTwinListSelect;
        this.fieldsTCS = exportTwinListSelect = new ExportTwinListSelect(this.app);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.addComponent((Component)exportTwinListSelect);
        horizontalLayout.setExpandRatio((Component)exportTwinListSelect, 7.0f);
        Label label = new Label();
        horizontalLayout.addComponent((Component)label);
        horizontalLayout.setExpandRatio((Component)label, 0.5f);
        this.groupByListSelect = new MultiColumnListSelect(IWPI18N.get(this.app, "GROUP_BY", new Object[0]), (Container)this.constructGroupByContainer(list));
        MultiColumnListSelect.MultiColumnListSelectTable multiColumnListSelectTable = this.groupByListSelect.getTable();
        multiColumnListSelectTable.setColumnExpandRatio(FIELD_NAME_PROPERTY, 1.0f);
        multiColumnListSelectTable.addGeneratedColumn(SELECTED_PROPERTY, new Table.ColumnGenerator(){

            public Component generateCell(Table table, Object object, Object object2) {
                final Item item = table.getItem(object);
                final CheckBox checkBox = new CheckBox(IWPI18N.get(ExportMappingDialog.this.app, "GROUP_BY_CHECKBOX_LABEL", new Object[0]), item.getItemProperty(SELECTED_PROPERTY));
                checkBox.addStyleName(ExportMappingDialog.CAPTION_CSS_STYLE);
                checkBox.addValueChangeListener(new Property.ValueChangeListener(){
                    final /* synthetic */ 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                        this.this$1.ExportMappingDialog.this.onValueChange(item);
                    }
                });
                checkBox.addAttachListener(new ClientConnector.AttachListener(){
                    final /* synthetic */ 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    public void attach(ClientConnector.AttachEvent attachEvent) {
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask(this){

                            @Override
                            public void run() {
                                checkBox.setTabIndex(-1);
                            }
                        }, 50L);
                    }
                });
                checkBox.setEnabled(true);
                checkBox.setImmediate(true);
                return checkBox;
            }
        });
        multiColumnListSelectTable.setVisibleColumns(new Object[]{SELECTED_PROPERTY, FIELD_NAME_PROPERTY});
        this.groupByListSelect.setHeight("100%");
        horizontalLayout.addComponent((Component)this.groupByListSelect);
        horizontalLayout.setComponentAlignment((Component)this.groupByListSelect, Alignment.TOP_RIGHT);
        horizontalLayout.setExpandRatio((Component)this.groupByListSelect, 2.0f);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            this.groupByListSelect.registerSelectionChangeCallback(new MultiColumnListSelect.SelectionChangeCallback(){

                @Override
                public void onValueChange(Item item) {
                    ExportMappingDialog.this.onValueChange(item);
                }
            });
        }
        horizontalLayout.setWidth("100%");
        verticalLayout.addComponent((Component)horizontalLayout);
        verticalLayout.setComponentAlignment((Component)horizontalLayout, Alignment.TOP_LEFT);
        verticalLayout.setExpandRatio((Component)horizontalLayout, 1.0f);
    }

    private BeanItemContainer<GroupByOrder> constructGroupByContainer(List<ExportGroupByInfo> list) {
        BeanItemContainer beanItemContainer = new BeanItemContainer(GroupByOrder.class);
        for (ExportGroupByInfo exportGroupByInfo : list) {
            GroupByOrder groupByOrder = new GroupByOrder(exportGroupByInfo.getFieldName(), exportGroupByInfo.isFieldChecked());
            beanItemContainer.addBean((Object)groupByOrder);
            if (!exportGroupByInfo.isFieldChecked()) continue;
            this.selectedGroupByFields.add(exportGroupByInfo.getFieldName());
        }
        return beanItemContainer;
    }

    private List<FieldDefinition> getFieldList() {
        ArrayList<FieldDefinition> arrayList = new ArrayList<FieldDefinition>();
        Collection<ExportOrder> collection = this.fieldsTCS.getExportOrderList();
        Iterator<ExportOrder> iterator = collection.iterator();
        while (iterator.hasNext()) {
            FieldDefinition fieldDefinition = new FieldDefinition();
            ExportOrder exportOrder = iterator.next();
            fieldDefinition.setFieldName(exportOrder.getFieldName());
            if (exportOrder.getFieldNameAlias() != null) {
                fieldDefinition.setFieldNameAliasForExport(exportOrder.getFieldNameAlias());
            }
            if (exportOrder.getSumByFieldName() != null) {
                if (exportOrder.getFieldName().contains(IWPI18N.get(this.app, "EXPORT_SUM_BY", new Object[0]))) {
                    String[] stringArray = exportOrder.getFieldName().split(IWPI18N.get(this.app, "EXPORT_SUM_BY", new Object[0]));
                    String string = stringArray[0];
                    fieldDefinition.setFieldName(string.trim());
                }
                fieldDefinition.setSumByField(exportOrder.getSumByFieldName());
            }
            arrayList.add(fieldDefinition);
        }
        return arrayList;
    }

    private void updateSortButtonState() {
        this.getRightButton().setEnabled(!this.fieldsTCS.isExportOrderListEmpty());
        if (this.fieldsTCS.isExportOrderListEmpty()) {
            this.setMiddleButtonDefault();
        } else {
            this.setRightButtonDefault();
        }
    }

    private void onValueChange(Item item) {
        Boolean bl = (Boolean)item.getItemProperty(SELECTED_PROPERTY).getValue();
        String string = (String)item.getItemProperty(FIELD_NAME_PROPERTY).getValue();
        if (bl.booleanValue()) {
            this.selectedGroupByFields.add(string);
        } else {
            this.selectedGroupByFields.remove(string);
            this.fieldsTCS.cleanSumByFieldInTarget(string);
        }
    }

    private final class ExportTwinListSelect
    extends TwinListSelect {
        ExportTwinListSelect(App app) {
            super(app, IWPI18N.get(app, "SORT_CHOOSE_FIELDS", new Object[0]), IWPI18N.get(app, "EXPORT_ORDER", new Object[0]));
            final AbstractBaseTable abstractBaseTable = this.getSource();
            abstractBaseTable.setColumnExpandRatio(FIELD_NAME_PROPERTY, 1.0f);
            final AbstractBaseTable abstractBaseTable2 = this.getTarget();
            abstractBaseTable2.setColumnExpandRatio(FIELD_NAME_PROPERTY, 1.0f);
            abstractBaseTable2.addGeneratedColumn(UP_AND_DOWN_PROPERTY, new Table.ColumnGenerator(){

                public Component generateCell(Table table, Object object, Object object2) {
                    Embedded embedded = new Embedded(null, (Resource)UP_AND_DOWN_ICON);
                    embedded.setAlternateText("");
                    return embedded;
                }
            });
            if (!BrowserInfoHandler.isTouchDevice(app)) {
                abstractBaseTable2.setDragMode(Table.TableDragMode.ROW);
            }
            abstractBaseTable2.setDropHandler(new DropHandler(){
                final /* synthetic */ ExportTwinListSelect this$1;
                {
                    this.this$1 = exportTwinListSelect;
                }

                public void drop(DragAndDropEvent dragAndDropEvent) {
                    this.this$1.dropToOrWithinTargetList(dragAndDropEvent);
                }

                public AcceptCriterion getAcceptCriterion() {
                    return new And(new ClientSideCriterion[]{new SourceIs(new Component[]{abstractBaseTable, abstractBaseTable2}), AbstractSelect.AcceptItem.ALL});
                }
            });
            VerticalLayout verticalLayout = this.getButtonLayout();
            Label label = new Label();
            label.setHeight("5px");
            verticalLayout.addComponent((Component)label);
            ExportMappingDialog.this.moveAllButton = new Button(IWPI18N.get(app, "MOVE_ALL", new Object[0]));
            ExportMappingDialog.this.moveAllButton.addClickListener(new Button.ClickListener(){

                public void buttonClick(Button.ClickEvent clickEvent) {
                    ExportTwinListSelect.this.performMoveAll(clickEvent);
                }
            });
            verticalLayout.addComponent((Component)ExportMappingDialog.this.moveAllButton);
            verticalLayout.setComponentAlignment((Component)ExportMappingDialog.this.moveAllButton, Alignment.MIDDLE_CENTER);
        }

        protected BeanItemContainer<ExportOrder> getSourceDataContainer() {
            BeanItemContainer beanItemContainer = new BeanItemContainer(ExportOrder.class);
            ArrayList<String> arrayList = new ArrayList<String>();
            Map<Integer, FieldObjectMetaDataModel> map = ExportMappingDialog.this.getApplicationRoot().getLayoutDataModel().getSortableFieldNames(false);
            ArrayList<String> arrayList2 = null;
            if (!ExportMappingDialog.this.initialFieldList.isEmpty()) {
                arrayList2 = new ArrayList<String>(ExportMappingDialog.this.initialFieldList.size());
                for (FieldDefinition object : ExportMappingDialog.this.initialFieldList) {
                    if (object.getSumByField() != null && object.getSumByField().length() != 0) continue;
                    if (object.getFieldNameAliasForExport() != null || !object.getFieldNameAliasForExport().isEmpty()) {
                        arrayList2.add(object.getFieldNameAliasForExport());
                        arrayList2.add(object.getFieldName());
                        continue;
                    }
                    arrayList2.add(object.getFieldName());
                }
            }
            for (FieldObjectMetaDataModel fieldObjectMetaDataModel : map.values()) {
                String string = fieldObjectMetaDataModel.getFieldNameAliasForExport(false);
                String string2 = fieldObjectMetaDataModel.getFieldName(false);
                LayoutFieldType layoutFieldType = fieldObjectMetaDataModel.getFieldType();
                if (arrayList2 != null && (arrayList2.contains(string2) || arrayList2.contains(string)) || arrayList.contains(string2) || arrayList.contains(string) || string2.equalsIgnoreCase("<No Access>")) continue;
                arrayList.add(string2);
                arrayList.add(string);
                if (string != null) {
                    beanItemContainer.addBean((Object)new ExportOrder(string, layoutFieldType, string2));
                    continue;
                }
                beanItemContainer.addBean((Object)new ExportOrder(string2, layoutFieldType));
            }
            beanItemContainer.sort(new Object[]{FIELD_NAME_PROPERTY}, new boolean[]{true});
            return beanItemContainer;
        }

        @Override
        protected Container getTargetDataContainer() {
            BeanItemContainer beanItemContainer = new BeanItemContainer(ExportOrder.class);
            if (ExportMappingDialog.this.initialFieldList != null && !ExportMappingDialog.this.initialFieldList.isEmpty()) {
                for (FieldDefinition fieldDefinition : ExportMappingDialog.this.initialFieldList) {
                    String string = fieldDefinition.getFieldName();
                    string = ExportMappingDialog.this.removeTableQualifier(string);
                    String string2 = fieldDefinition.getFieldNameAliasForExport();
                    string2 = ExportMappingDialog.this.removeTableQualifier(string2);
                    String string3 = fieldDefinition.getSumByField();
                    if (string3 != null && string3.length() > 0) {
                        string3 = ExportMappingDialog.this.removeTableQualifier(string3);
                        beanItemContainer.addBean((Object)new ExportOrder(string + " " + IWPI18N.get(ExportMappingDialog.this.app, "EXPORT_SUM_BY", new Object[0]) + " " + string3, string3));
                        continue;
                    }
                    if (!string2.isEmpty() && string2 != null) {
                        beanItemContainer.addBean((Object)new ExportOrder(string2, string, string3));
                        continue;
                    }
                    beanItemContainer.addBean((Object)new ExportOrder(string));
                }
            }
            return beanItemContainer;
        }

        @Override
        protected void setSourceVisibleColumns() {
            this.getSource().setVisibleColumns(new Object[]{FIELD_NAME_PROPERTY});
        }

        @Override
        protected void setTargetVisibleColumns() {
            this.getTarget().setVisibleColumns(new Object[]{UP_AND_DOWN_PROPERTY, FIELD_NAME_PROPERTY});
        }

        @Override
        protected void performMoveTo() {
            ExportOrder exportOrder = (ExportOrder)this.getSelectedItem();
            super.performMoveTo();
            if (this.isMoveToTarget()) {
                this.performAddSummaryBy(exportOrder);
            }
            if (!this.isMoveToTarget()) {
                if (exportOrder.getFieldName().contains(IWPI18N.get(ExportMappingDialog.this.app, "EXPORT_SUM_BY", new Object[0]))) {
                    this.getSource().getContainerDataSource().removeItem((Object)exportOrder);
                }
                BeanItemContainer beanItemContainer = (BeanItemContainer)this.getSource().getContainerDataSource();
                beanItemContainer.sort(new Object[]{FIELD_NAME_PROPERTY}, new boolean[]{true});
            }
            this.updateOrderSelectAndSortButtonStates();
            this.updateMoveAllButtonState();
        }

        private void performAddSummaryBy(ExportOrder exportOrder) {
            if (exportOrder != null && exportOrder.isSummaryField()) {
                this.addSummaryByFields(exportOrder.getFieldName());
            }
        }

        protected void performMoveAll(Button.ClickEvent clickEvent) {
            Container container = this.getSource().getContainerDataSource();
            Object[] objectArray = container.getItemIds().toArray();
            this.setMoveToTarget(true);
            for (Object object : objectArray) {
                this.performMoveItem(object);
                ExportOrder exportOrder = (ExportOrder)object;
                this.performAddSummaryBy(exportOrder);
            }
            ExportMappingDialog.this.moveAllButton.setEnabled(false);
            ExportMappingDialog.this.setRightButtonEnabled();
        }

        private void updateMoveAllButtonState() {
            ExportMappingDialog.this.moveAllButton.setEnabled(this.isSourceListNotEmpty());
        }

        private boolean isSourceListNotEmpty() {
            return this.getSource().getContainerDataSource().size() > 0;
        }

        private void addSummaryByFields(String string) {
            if (string != null) {
                Iterator<String> iterator = ExportMappingDialog.this.selectedGroupByFields.iterator();
                String string2 = string + " " + IWPI18N.get(ExportMappingDialog.this.app, "EXPORT_SUM_BY", new Object[0]) + " ";
                while (iterator.hasNext()) {
                    String string3 = iterator.next();
                    String string4 = string2 + string3;
                    ExportOrder exportOrder = new ExportOrder(string4, string3);
                    if (!this.targetDoesNotContainSummaryByField(string4)) continue;
                    this.getTarget().getContainerDataSource().addItem((Object)exportOrder);
                }
            }
        }

        private boolean targetDoesNotContainSummaryByField(String string) {
            Container container = this.getTarget().getContainerDataSource();
            Collection collection = container.getItemIds();
            for (ExportOrder exportOrder : collection) {
                if (!exportOrder.getFieldName().equals(string)) continue;
                return false;
            }
            return true;
        }

        @Override
        protected boolean putItemBackToSource(Object object) {
            ExportOrder exportOrder = (ExportOrder)object;
            return !exportOrder.getFieldName().contains(IWPI18N.get(ExportMappingDialog.this.app, "EXPORT_SUM_BY", new Object[0]));
        }

        @Override
        protected void performClearAll(Button.ClickEvent clickEvent) {
            super.performClearAll(clickEvent);
            BeanItemContainer beanItemContainer = (BeanItemContainer)this.getSource().getContainerDataSource();
            beanItemContainer.sort(new Object[]{FIELD_NAME_PROPERTY}, new boolean[]{true});
            this.updateOrderSelectAndSortButtonStates();
            this.updateMoveAllButtonState();
            ExportMappingDialog.this.setRightButtonDisabled();
        }

        protected void dropToOrWithinTargetList(DragAndDropEvent dragAndDropEvent) {
            BeanItemContainer beanItemContainer;
            DataBoundTransferable dataBoundTransferable = (DataBoundTransferable)dragAndDropEvent.getTransferable();
            BeanItemContainer beanItemContainer2 = (BeanItemContainer)dataBoundTransferable.getSourceContainer();
            boolean bl = !beanItemContainer2.equals(beanItemContainer = (BeanItemContainer)this.getTarget().getContainerDataSource());
            ExportOrder exportOrder = (ExportOrder)dataBoundTransferable.getItemId();
            super.dropToTargetList(dragAndDropEvent);
            if (!bl) {
                this.performTargetItemSelected(exportOrder);
                this.getTarget().select(exportOrder);
            }
            this.updateOrderSelectAndSortButtonStates();
        }

        @Override
        protected void dropToSourceList(DragAndDropEvent dragAndDropEvent) {
            super.dropToSourceList(dragAndDropEvent);
            BeanItemContainer beanItemContainer = (BeanItemContainer)this.getSource().getContainerDataSource();
            beanItemContainer.sort(new Object[]{FIELD_NAME_PROPERTY}, new boolean[]{true});
            this.updateOrderSelectAndSortButtonStates();
            this.cleanSumByFieldsInSource();
        }

        public void cleanSumByFieldInTarget(String string) {
            Container container = this.getTarget().getContainerDataSource();
            Collection collection = container.getItemIds();
            Iterator iterator = collection.iterator();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            while (iterator.hasNext()) {
                ExportOrder exportOrder = (ExportOrder)iterator.next();
                if (exportOrder.getSumByFieldName() == null || !exportOrder.getSumByFieldName().equals(string)) continue;
                arrayList.add(exportOrder);
            }
            for (ExportOrder exportOrder : arrayList) {
                container.removeItem((Object)exportOrder);
            }
        }

        private void cleanSumByFieldsInSource() {
            Container container = this.getSource().getContainerDataSource();
            Collection collection = container.getItemIds();
            Iterator iterator = collection.iterator();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            while (iterator.hasNext()) {
                ExportOrder exportOrder = (ExportOrder)iterator.next();
                if (!exportOrder.getFieldName().contains(IWPI18N.get(ExportMappingDialog.this.app, "EXPORT_SUM_BY", new Object[0]))) continue;
                arrayList.add(exportOrder);
            }
            for (ExportOrder exportOrder : arrayList) {
                container.removeItem((Object)exportOrder);
            }
        }

        private void updateOrderSelectAndSortButtonStates() {
            ExportMappingDialog.this.updateSortButtonState();
        }

        private Collection<ExportOrder> getExportOrderList() {
            return ((BeanItemContainer)this.getTarget().getContainerDataSource()).getItemIds();
        }

        private boolean isExportOrderListEmpty() {
            return this.getExportOrderList().isEmpty();
        }
    }

    public final class GroupByOrder
    implements Serializable {
        private String fieldName;
        private boolean selected;

        public GroupByOrder(String string, boolean bl) {
            this.fieldName = string;
            this.selected = bl;
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
    }

    public final class ExportOrder
    implements Serializable {
        private String fieldName;
        private String upAndDown;
        private LayoutFieldType fieldType;
        private String sumByFieldName;
        private String fieldNameAlias;

        public ExportOrder(String string) {
            this.fieldName = string;
        }

        public ExportOrder(String string, LayoutFieldType layoutFieldType) {
            this.fieldName = string;
            this.fieldType = layoutFieldType;
        }

        public ExportOrder(String string, LayoutFieldType layoutFieldType, String string2) {
            this.fieldName = string;
            this.fieldType = layoutFieldType;
            this.fieldNameAlias = string2;
        }

        public ExportOrder(String string, String string2) {
            this.fieldName = string;
            this.sumByFieldName = string2;
        }

        public ExportOrder(String string, String string2, String string3) {
            this.fieldName = string;
            this.fieldNameAlias = string2;
            this.sumByFieldName = string3;
        }

        public void setFieldName(String string) {
            this.fieldName = string;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setUpAndDown(String string) {
            this.upAndDown = string;
        }

        public String getUpAndDown() {
            return this.upAndDown;
        }

        public boolean isSummaryField() {
            return this.fieldType == LayoutFieldType.SUMMARY;
        }

        public String getSumByFieldName() {
            return this.sumByFieldName;
        }

        public void setFieldNameAlias(String string) {
            this.fieldNameAlias = string;
        }

        public String getFieldNameAlias() {
            return this.fieldNameAlias;
        }
    }
}

