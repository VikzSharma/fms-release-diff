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
 *  com.vaadin.server.Resource
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.shared.MouseEventDetails
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Embedded
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.data.util.BeanItem
 *  com.vaadin.v7.data.util.BeanItemContainer
 *  com.vaadin.v7.event.DataBoundTransferable
 *  com.vaadin.v7.event.ItemClickEvent
 *  com.vaadin.v7.ui.AbstractSelect$AcceptItem
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.NativeSelect
 *  com.vaadin.v7.ui.OptionGroup
 *  com.vaadin.v7.ui.Table
 *  com.vaadin.v7.ui.Table$ColumnGenerator
 *  com.vaadin.v7.ui.Table$TableDragMode
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.FieldObjectMetaDataModel;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.SortAction;
import com.filemaker.jwpc.iwp.thrift.common.SortDialogResult;
import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import com.filemaker.jwpc.iwp.thrift.common.SortQueryCriteria;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.ui.common.TwinListSelect;
import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.event.dd.acceptcriteria.ClientSideCriterion;
import com.vaadin.event.dd.acceptcriteria.SourceIs;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.BeanItem;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.event.DataBoundTransferable;
import com.vaadin.v7.event.ItemClickEvent;
import com.vaadin.v7.ui.AbstractSelect;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.NativeSelect;
import com.vaadin.v7.ui.OptionGroup;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SortDialog
extends ServerInvokedDialog {
    private final String DIALOG_WIDTH = "560px";
    private final List<String> orderOptions = Arrays.asList(IWPI18N.get(this.app, "SORT_ASCENDING_ORDER", new Object[0]), IWPI18N.get(this.app, "SORT_DESCENDING_ORDER", new Object[0]), IWPI18N.get(this.app, "SORT_CUSTOM_ORDER", new Object[0]));
    private final Object FIELD_NAME_PROPERTY = "fieldName";
    private final Object FIELD_ORDER_PROPERTY = "order";
    private final Object UP_AND_DOWN_PROPERTY = "upAndDown";
    private final ThemeResource ASCENDING_ORDER_ICON = new ThemeResource("images/sort_ascending.png");
    private final ThemeResource DESCENDING_ORDER_ICON = new ThemeResource("images/sort_descending.png");
    private final ThemeResource CUSTOM_ORDER_ICON = new ThemeResource("images/sort_custom.png");
    private final ThemeResource UP_AND_DOWN_ICON = new ThemeResource("images/up_and_down.png");
    private SortTwinListSelect fieldsTCS;
    private SortOrderOptionGroup sortOrderSelect;
    private CustomOrderValueSelect<String> valueList;
    private final SortDialogResult result;

    public SortDialog(App app, Map<Integer, String> map) {
        super(app, IWPI18N.get(app, "SORT_RECORDS_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_MIDDLE_RIGHT);
        this.setWidth("560px");
        this.setResizable(true);
        this.initContent(this.getContentLayout(map));
        this.initButtons(this.getLeftButtonText(), this.getMiddleButtonText(), this.getRightButtonText());
        this.updateSortButtonState();
        this.result = new SortDialogResult();
        this.result.setAction(SortAction.Cancel);
    }

    private Component getContentLayout(Map<Integer, String> map) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setSpacing(true);
        this.addSelectFieldsLayout(verticalLayout);
        this.addOrderOptionsLayout(verticalLayout, map);
        return verticalLayout;
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "UNSORT", new Object[0]);
    }

    @Override
    protected String getRightButtonText() {
        return IWPI18N.get(this.app, "SORT", new Object[0]);
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.setAction(SortAction.Unsort);
        this.result.setQueries(this.getSelectedSortQueries());
        this.app.getDatabaseDataModel().getSortState().setUnsort(true);
        this.app.getDatabaseDataModel().getSortState().setSortCriteriaOnColumns(true);
        super.performLeftButtonAction(clickEvent);
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

    private void addSelectFieldsLayout(VerticalLayout verticalLayout) {
        SortTwinListSelect sortTwinListSelect;
        this.fieldsTCS = sortTwinListSelect = new SortTwinListSelect(this.app);
        verticalLayout.addComponent((Component)sortTwinListSelect);
        verticalLayout.setComponentAlignment((Component)sortTwinListSelect, Alignment.TOP_LEFT);
        verticalLayout.setExpandRatio((Component)sortTwinListSelect, 1.0f);
    }

    private void addOrderOptionsLayout(VerticalLayout verticalLayout, Map<Integer, String> map) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        Label label = new Label();
        label.setWidth("60px");
        horizontalLayout.addComponent((Component)label);
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.setSpacing(true);
        Embedded embedded = new Embedded(null, (Resource)this.ASCENDING_ORDER_ICON);
        embedded.setAlternateText(IWPI18N.get(this.app, "SORT_ASCENDING_ORDER", new Object[0]));
        verticalLayout2.addComponent((Component)embedded);
        verticalLayout2.setComponentAlignment((Component)embedded, Alignment.MIDDLE_LEFT);
        Embedded embedded2 = new Embedded(null, (Resource)this.DESCENDING_ORDER_ICON);
        embedded2.setAlternateText(IWPI18N.get(this.app, "SORT_DESCENDING_ORDER", new Object[0]));
        verticalLayout2.addComponent((Component)embedded2);
        verticalLayout2.setComponentAlignment((Component)embedded2, Alignment.MIDDLE_LEFT);
        Embedded embedded3 = new Embedded(null, (Resource)this.CUSTOM_ORDER_ICON);
        embedded3.setAlternateText(IWPI18N.get(this.app, "SORT_CUSTOM_ORDER", new Object[0]));
        verticalLayout2.addComponent((Component)embedded3);
        verticalLayout2.setComponentAlignment((Component)embedded3, Alignment.MIDDLE_LEFT);
        horizontalLayout.addComponent((Component)verticalLayout2);
        horizontalLayout.setComponentAlignment((Component)verticalLayout2, Alignment.BOTTOM_LEFT);
        SortOrderOptionGroup sortOrderOptionGroup = new SortOrderOptionGroup("", this.orderOptions);
        sortOrderOptionGroup.setNullSelectionAllowed(false);
        sortOrderOptionGroup.select(IWPI18N.get(this.app, "SORT_ASCENDING_ORDER", new Object[0]));
        sortOrderOptionGroup.setImmediate(true);
        sortOrderOptionGroup.attachListener(new SortOrderOptionGroupListener());
        sortOrderOptionGroup.setEnabled(false);
        horizontalLayout.addComponent((Component)sortOrderOptionGroup);
        horizontalLayout.setComponentAlignment((Component)sortOrderOptionGroup, Alignment.TOP_LEFT);
        this.sortOrderSelect = sortOrderOptionGroup;
        Label label2 = new Label();
        label2.setWidth("8px");
        horizontalLayout.addComponent((Component)label2);
        CustomOrderValueSelect customOrderValueSelect = new CustomOrderValueSelect();
        customOrderValueSelect.setNullSelectionAllowed(false);
        customOrderValueSelect.setSizeUndefined();
        customOrderValueSelect.setCaption(IWPI18N.get(this.app, "SORT_CUSTOM_ORDER", new Object[0]));
        customOrderValueSelect.addStyleName("v-caption-sr-only-caption-dialog-fields");
        if (map == null || map.isEmpty()) {
            customOrderValueSelect.setEnabled(false);
        } else {
            for (String string : map.values()) {
                customOrderValueSelect.addItem(string);
            }
            customOrderValueSelect.setValue(map.values().toArray()[0]);
        }
        customOrderValueSelect.attachListener(new CustomOrderValueSelectListener());
        customOrderValueSelect.setEnabled(false);
        horizontalLayout.addComponent(customOrderValueSelect);
        horizontalLayout.setComponentAlignment(customOrderValueSelect, Alignment.BOTTOM_LEFT);
        this.valueList = customOrderValueSelect;
        Label label3 = new Label();
        horizontalLayout.addComponent((Component)label3);
        horizontalLayout.setExpandRatio((Component)label3, 1.0f);
        verticalLayout.addComponent((Component)horizontalLayout);
        verticalLayout.setComponentAlignment((Component)horizontalLayout, Alignment.MIDDLE_LEFT);
    }

    private void performSortOrderChange(Property.ValueChangeEvent valueChangeEvent) {
        AbstractBaseTable abstractBaseTable;
        SortOrder sortOrder;
        SortQueryCriteria sortQueryCriteria = this.getCurrentSortOrder();
        this.updateCustomValueSelectState(sortQueryCriteria);
        if (!this.fieldsTCS.isMoveToTarget() && (sortOrder = (SortOrder)(abstractBaseTable = this.fieldsTCS.getTarget()).getValue()) != null) {
            BeanItemContainer beanItemContainer = (BeanItemContainer)abstractBaseTable.getContainerDataSource();
            int n = beanItemContainer.indexOfId((Object)sortOrder);
            BeanItem beanItem = beanItemContainer.getItem((Object)sortOrder);
            if (beanItem != null) {
                beanItemContainer.removeItem((Object)sortOrder);
                ((SortOrder)beanItem.getBean()).setOrder(sortQueryCriteria);
                if (SortQueryCriteria.CUSTOM.equals((Object)sortQueryCriteria)) {
                    ((SortOrder)beanItem.getBean()).setValue((String)this.valueList.getValue());
                }
                beanItemContainer.addItemAt(n, (Object)sortOrder);
                abstractBaseTable.select(sortOrder);
            }
        }
    }

    private void performCustomOrderValueChange(Property.ValueChangeEvent valueChangeEvent) {
        BeanItemContainer beanItemContainer;
        BeanItem beanItem;
        AbstractBaseTable abstractBaseTable;
        SortOrder sortOrder;
        if (!this.fieldsTCS.isMoveToTarget() && (sortOrder = (SortOrder)(abstractBaseTable = this.fieldsTCS.getTarget()).getValue()) != null && (beanItem = (beanItemContainer = (BeanItemContainer)abstractBaseTable.getContainerDataSource()).getItem((Object)sortOrder)) != null) {
            ((SortOrder)beanItem.getBean()).setValue((String)this.valueList.getValue());
        }
    }

    private List<SortQuery> getSelectedSortQueries() {
        ArrayList<SortQuery> arrayList = new ArrayList<SortQuery>();
        Collection<SortOrder> collection = this.fieldsTCS.getSortOrderList();
        Iterator<SortOrder> iterator = collection.iterator();
        while (iterator.hasNext()) {
            SortQuery sortQuery = new SortQuery();
            SortOrder sortOrder = iterator.next();
            sortQuery.setFieldName(sortOrder.getFieldName());
            sortQuery.setFieldNameAliasForSort(sortOrder.getFieldNameAlias());
            sortQuery.setFieldId(sortOrder.getFieldId());
            sortQuery.setCriteria(sortOrder.getOrder());
            sortQuery.setTableId(sortOrder.getTableId());
            if (SortQueryCriteria.CUSTOM.equals((Object)sortOrder.getOrder())) {
                if (Utilities.isValidText(sortOrder.getValue())) {
                    sortQuery.setValue(sortOrder.getValue());
                } else {
                    sortQuery.setCriteria(SortQueryCriteria.ASC);
                }
            }
            arrayList.add(sortQuery);
        }
        return arrayList;
    }

    private SortQueryCriteria getCurrentSortOrder() {
        String string = (String)this.sortOrderSelect.getValue();
        SortQueryCriteria sortQueryCriteria = IWPI18N.get(this.app, "SORT_DESCENDING_ORDER", new Object[0]).equals(string) ? SortQueryCriteria.DESC : (IWPI18N.get(this.app, "SORT_CUSTOM_ORDER", new Object[0]).equals(string) ? SortQueryCriteria.CUSTOM : SortQueryCriteria.ASC);
        return sortQueryCriteria;
    }

    private void updateSortButtonState() {
        this.getRightButton().setEnabled(!this.fieldsTCS.isSortOrderListEmpty());
        if (this.fieldsTCS.isSortOrderListEmpty()) {
            this.setMiddleButtonDefault();
        } else {
            this.setRightButtonDefault();
        }
    }

    private void updateOrderSelectState(ItemClickEvent itemClickEvent) {
        boolean bl = this.fieldsTCS.hasSelectedItem(itemClickEvent);
        if (this.sortOrderSelect.isEnabled() && !bl) {
            this.sortOrderSelect.setEnabled(false);
        } else if (!this.sortOrderSelect.isEnabled() && bl) {
            this.sortOrderSelect.setEnabled(true);
        }
    }

    private void updateCustomValueSelectState(SortQueryCriteria sortQueryCriteria) {
        if (SortQueryCriteria.CUSTOM.equals((Object)sortQueryCriteria) && !this.valueList.isEnabled()) {
            this.valueList.setEnabled(true);
        } else if (!SortQueryCriteria.CUSTOM.equals((Object)sortQueryCriteria) && this.valueList.isEnabled()) {
            this.valueList.setEnabled(false);
        }
    }

    private final class SortTwinListSelect
    extends TwinListSelect {
        SortTwinListSelect(final App app) {
            super(app, IWPI18N.get(app, "SORT_CHOOSE_FIELDS", new Object[0]), IWPI18N.get(app, "SORT_SELECTED_FIELDS", new Object[0]));
            final AbstractBaseTable abstractBaseTable = this.getSource();
            abstractBaseTable.setColumnExpandRatio(SortDialog.this.FIELD_NAME_PROPERTY, 1.0f);
            final AbstractBaseTable abstractBaseTable2 = this.getTarget();
            abstractBaseTable2.setColumnExpandRatio(SortDialog.this.FIELD_NAME_PROPERTY, 1.0f);
            abstractBaseTable2.addGeneratedColumn(SortDialog.this.UP_AND_DOWN_PROPERTY, new Table.ColumnGenerator(){

                public Component generateCell(Table table, Object object, Object object2) {
                    Embedded embedded = new Embedded("", (Resource)SortDialog.this.UP_AND_DOWN_ICON);
                    embedded.setAlternateText("");
                    return embedded;
                }
            });
            abstractBaseTable2.addGeneratedColumn(SortDialog.this.FIELD_ORDER_PROPERTY, new Table.ColumnGenerator(){
                final /* synthetic */ SortTwinListSelect this$1;
                {
                    this.this$1 = sortTwinListSelect;
                }

                public Component generateCell(Table table, Object object, Object object2) {
                    ThemeResource themeResource;
                    SortQueryCriteria sortQueryCriteria = ((SortOrder)object).getOrder();
                    String string = switch (sortQueryCriteria) {
                        case SortQueryCriteria.ASC -> {
                            themeResource = this.this$1.SortDialog.this.ASCENDING_ORDER_ICON;
                            yield IWPI18N.get(app, "SORT_ASCENDING_ORDER", new Object[0]);
                        }
                        case SortQueryCriteria.DESC -> {
                            themeResource = this.this$1.SortDialog.this.DESCENDING_ORDER_ICON;
                            yield IWPI18N.get(app, "SORT_DESCENDING_ORDER", new Object[0]);
                        }
                        case SortQueryCriteria.CUSTOM -> {
                            themeResource = this.this$1.SortDialog.this.CUSTOM_ORDER_ICON;
                            yield IWPI18N.get(app, "SORT_CUSTOM_ORDER", new Object[0]);
                        }
                        default -> {
                            themeResource = this.this$1.SortDialog.this.ASCENDING_ORDER_ICON;
                            yield IWPI18N.get(app, "SORT_ASCENDING_ORDER", new Object[0]);
                        }
                    };
                    Embedded embedded = new Embedded("", (Resource)themeResource);
                    embedded.setAlternateText(string);
                    return embedded;
                }
            });
            if (!BrowserInfoHandler.isTouchDevice(app)) {
                abstractBaseTable2.setDragMode(Table.TableDragMode.ROW);
            }
            abstractBaseTable2.setDropHandler(new DropHandler(){
                final /* synthetic */ SortTwinListSelect this$1;
                {
                    this.this$1 = sortTwinListSelect;
                }

                public void drop(DragAndDropEvent dragAndDropEvent) {
                    this.this$1.dropToOrWithinTargetList(dragAndDropEvent);
                }

                public AcceptCriterion getAcceptCriterion() {
                    return new And(new ClientSideCriterion[]{new SourceIs(new Component[]{abstractBaseTable, abstractBaseTable2}), AbstractSelect.AcceptItem.ALL});
                }
            });
        }

        protected BeanItemContainer<SortOrder> getSourceDataContainer() {
            BeanItemContainer beanItemContainer = new BeanItemContainer(SortOrder.class);
            ArrayList<String> arrayList = new ArrayList<String>();
            Map<Integer, FieldObjectMetaDataModel> map = SortDialog.this.getApplicationRoot().getLayoutDataModel().getSortableFieldNames(false);
            List<SortQuery> list = SortDialog.this.getApplicationRoot().getDatabaseDataModel().getSortQueries();
            ArrayList<String> arrayList2 = null;
            if (!list.isEmpty()) {
                arrayList2 = new ArrayList<String>(list.size());
                for (SortQuery object : list) {
                    if (object.getFieldNameAliasForSort() != null || !object.getFieldNameAliasForSort().isEmpty()) {
                        arrayList2.add(object.getFieldNameAliasForSort());
                    }
                    arrayList2.add(object.getFieldName());
                }
            }
            for (FieldObjectMetaDataModel fieldObjectMetaDataModel : map.values()) {
                String string = fieldObjectMetaDataModel.getFieldName(false);
                int n = fieldObjectMetaDataModel.getFieldId();
                int n2 = fieldObjectMetaDataModel.getTableId();
                String string2 = fieldObjectMetaDataModel.getFieldNameAliasForSort(false);
                if (arrayList2 != null && (arrayList2.contains(string) || arrayList2.contains(string2)) || arrayList.contains(string) || arrayList.contains(string2) || string.endsWith("<No Access>") || fieldObjectMetaDataModel.getFieldType() == LayoutFieldType.SUMMARY) continue;
                arrayList.add(string);
                arrayList.add(string2);
                if (string2 != null) {
                    beanItemContainer.addBean((Object)new SortOrder(string2, n, SortQueryCriteria.ASC, "", n2, string));
                    continue;
                }
                beanItemContainer.addBean((Object)new SortOrder(string, n, SortQueryCriteria.ASC, "", n2, string2));
            }
            beanItemContainer.sort(new Object[]{SortDialog.this.FIELD_NAME_PROPERTY}, new boolean[]{true});
            return beanItemContainer;
        }

        @Override
        protected Container getTargetDataContainer() {
            BeanItemContainer beanItemContainer = new BeanItemContainer(SortOrder.class);
            List<SortQuery> list = SortDialog.this.getApplicationRoot().getDatabaseDataModel().getSortQueries();
            for (SortQuery sortQuery : list) {
                if (sortQuery.getFieldNameAliasForSort() != null && !sortQuery.getFieldNameAliasForSort().isEmpty()) {
                    beanItemContainer.addBean((Object)new SortOrder(sortQuery.getFieldNameAliasForSort(), sortQuery.getFieldId(), sortQuery.getCriteria(), sortQuery.getValue(), sortQuery.getTableId(), sortQuery.getFieldName()));
                    continue;
                }
                beanItemContainer.addBean((Object)new SortOrder(sortQuery.getFieldName(), sortQuery.getFieldId(), sortQuery.getCriteria(), sortQuery.getValue(), sortQuery.getTableId(), ""));
            }
            return beanItemContainer;
        }

        @Override
        protected void setSourceVisibleColumns() {
            this.getSource().setVisibleColumns(new Object[]{SortDialog.this.FIELD_NAME_PROPERTY});
        }

        @Override
        protected void setTargetVisibleColumns() {
            AbstractBaseTable abstractBaseTable = this.getTarget();
            abstractBaseTable.setVisibleColumns(new Object[]{SortDialog.this.UP_AND_DOWN_PROPERTY, SortDialog.this.FIELD_NAME_PROPERTY, SortDialog.this.FIELD_ORDER_PROPERTY});
        }

        @Override
        protected void performSourceItemSelected(ItemClickEvent itemClickEvent) {
            SortDialog.this.updateOrderSelectState(itemClickEvent);
            super.performSourceItemSelected(itemClickEvent);
        }

        @Override
        protected void performTargetItemSelected(ItemClickEvent itemClickEvent) {
            SortDialog.this.sortOrderSelect.disableListener();
            SortDialog.this.valueList.disableListener();
            SortOrder sortOrder = (SortOrder)itemClickEvent.getItemId();
            SortQueryCriteria sortQueryCriteria = sortOrder.getOrder();
            switch (sortQueryCriteria) {
                case ASC: {
                    SortDialog.this.sortOrderSelect.select(IWPI18N.get(SortDialog.this.app, "SORT_ASCENDING_ORDER", new Object[0]));
                    break;
                }
                case DESC: {
                    SortDialog.this.sortOrderSelect.select(IWPI18N.get(SortDialog.this.app, "SORT_DESCENDING_ORDER", new Object[0]));
                    break;
                }
                case CUSTOM: {
                    SortDialog.this.sortOrderSelect.select(IWPI18N.get(SortDialog.this.app, "SORT_CUSTOM_ORDER", new Object[0]));
                    SortDialog.this.valueList.setValue(sortOrder.getValue());
                }
            }
            SortDialog.this.updateOrderSelectState(itemClickEvent);
            SortDialog.this.updateCustomValueSelectState(sortQueryCriteria);
            super.performTargetItemSelected(itemClickEvent);
            SortDialog.this.sortOrderSelect.enableListener();
            SortDialog.this.valueList.enableListener();
        }

        private boolean hasSelectedItem(ItemClickEvent itemClickEvent) {
            boolean bl = false;
            if (itemClickEvent != null) {
                Object object = this.getSelectedItem();
                Object object2 = itemClickEvent.getItemId();
                if (object == null || !object.equals(object2)) {
                    bl = true;
                } else if (!(itemClickEvent.isMetaKey() || itemClickEvent.isDoubleClick() || ((Table)itemClickEvent.getSource()).isSelected(object2))) {
                    bl = true;
                }
            }
            return bl;
        }

        @Override
        protected void performMoveTo() {
            SortOrder sortOrder;
            if (this.isMoveToTarget()) {
                sortOrder = (SortOrder)this.getSelectedItem();
                SortQueryCriteria sortQueryCriteria = SortDialog.this.getCurrentSortOrder();
                sortOrder.setOrder(sortQueryCriteria);
                if (SortQueryCriteria.CUSTOM.equals((Object)sortQueryCriteria)) {
                    sortOrder.setValue((String)SortDialog.this.valueList.getValue());
                }
            }
            super.performMoveTo();
            if (!this.isMoveToTarget()) {
                sortOrder = (BeanItemContainer)this.getSource().getContainerDataSource();
                sortOrder.sort(new Object[]{SortDialog.this.FIELD_NAME_PROPERTY}, new boolean[]{true});
            }
            this.updateOrderSelectAndSortButtonStates();
        }

        @Override
        protected void performClearAll(Button.ClickEvent clickEvent) {
            super.performClearAll(clickEvent);
            BeanItemContainer beanItemContainer = (BeanItemContainer)this.getSource().getContainerDataSource();
            beanItemContainer.sort(new Object[]{SortDialog.this.FIELD_NAME_PROPERTY}, new boolean[]{true});
            this.updateOrderSelectAndSortButtonStates();
        }

        protected void dropToOrWithinTargetList(DragAndDropEvent dragAndDropEvent) {
            BeanItemContainer beanItemContainer;
            DataBoundTransferable dataBoundTransferable = (DataBoundTransferable)dragAndDropEvent.getTransferable();
            BeanItemContainer beanItemContainer2 = (BeanItemContainer)dataBoundTransferable.getSourceContainer();
            boolean bl = !beanItemContainer2.equals(beanItemContainer = (BeanItemContainer)this.getTarget().getContainerDataSource());
            SortOrder sortOrder = (SortOrder)dataBoundTransferable.getItemId();
            if (bl) {
                SortQueryCriteria sortQueryCriteria = SortDialog.this.getCurrentSortOrder();
                sortOrder.setOrder(sortQueryCriteria);
                if (SortQueryCriteria.CUSTOM.equals((Object)sortQueryCriteria)) {
                    sortOrder.setValue((String)SortDialog.this.valueList.getValue());
                }
            }
            super.dropToTargetList(dragAndDropEvent);
            if (!bl) {
                this.performTargetItemSelected(sortOrder);
                this.getTarget().select(sortOrder);
            }
            this.updateOrderSelectAndSortButtonStates();
        }

        @Override
        protected void dropToSourceList(DragAndDropEvent dragAndDropEvent) {
            super.dropToSourceList(dragAndDropEvent);
            BeanItemContainer beanItemContainer = (BeanItemContainer)this.getSource().getContainerDataSource();
            beanItemContainer.sort(new Object[]{SortDialog.this.FIELD_NAME_PROPERTY}, new boolean[]{true});
            this.updateOrderSelectAndSortButtonStates();
        }

        private void updateOrderSelectAndSortButtonStates() {
            SortDialog.this.updateOrderSelectState(null);
            SortDialog.this.updateSortButtonState();
        }

        private Collection<SortOrder> getSortOrderList() {
            return ((BeanItemContainer)this.getTarget().getContainerDataSource()).getItemIds();
        }

        private boolean isSortOrderListEmpty() {
            return this.getSortOrderList().isEmpty();
        }

        @Override
        protected void onNavFocus(boolean bl, int n) {
            Object object;
            AbstractBaseTable abstractBaseTable = bl ? this.getSource() : this.getTarget();
            if (!abstractBaseTable.isSelected(object = abstractBaseTable.getIdByIndex(n))) {
                this.removeSelection();
                ItemClickEvent itemClickEvent = new ItemClickEvent((Component)abstractBaseTable, abstractBaseTable.getItem(object), object, null, new MouseEventDetails());
                if (bl) {
                    this.performSourceItemSelected(itemClickEvent);
                } else {
                    this.performTargetItemSelected(itemClickEvent);
                }
            }
            super.onNavFocus(bl, n);
        }
    }

    private class SortOrderOptionGroup
    extends OptionGroup {
        private SortOrderOptionGroupListener listener;

        SortOrderOptionGroup(String string, Collection<?> collection) {
            super(string, collection);
        }

        void attachListener(SortOrderOptionGroupListener sortOrderOptionGroupListener) {
            this.listener = sortOrderOptionGroupListener;
            this.enableListener();
        }

        void enableListener() {
            if (this.listener != null) {
                this.addValueChangeListener(this.listener);
            }
        }

        void disableListener() {
            if (this.listener != null) {
                this.removeValueChangeListener(this.listener);
            }
        }
    }

    private class SortOrderOptionGroupListener
    implements Property.ValueChangeListener {
        private SortOrderOptionGroupListener() {
        }

        public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
            SortDialog.this.performSortOrderChange(valueChangeEvent);
        }
    }

    private class CustomOrderValueSelect<String>
    extends NativeSelect {
        private CustomOrderValueSelectListener listener;

        CustomOrderValueSelect() {
        }

        void attachListener(CustomOrderValueSelectListener customOrderValueSelectListener) {
            this.listener = customOrderValueSelectListener;
            this.enableListener();
        }

        void disableListener() {
            if (this.listener != null) {
                this.removeValueChangeListener(this.listener);
            }
        }

        void enableListener() {
            if (this.listener != null) {
                this.addValueChangeListener(this.listener);
            }
        }
    }

    private class CustomOrderValueSelectListener
    implements Property.ValueChangeListener {
        private CustomOrderValueSelectListener() {
        }

        public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
            SortDialog.this.performCustomOrderValueChange(valueChangeEvent);
        }
    }

    public final class SortOrder
    implements Serializable {
        private final String fieldName;
        private final int fieldId;
        private SortQueryCriteria order;
        private String value;
        private String upAndDown;
        private int tableId;
        private final String fieldNameAlias;

        public SortOrder(String string, int n, SortQueryCriteria sortQueryCriteria, String string2, int n2, String string3) {
            this.fieldName = string;
            this.fieldId = n;
            this.order = sortQueryCriteria;
            this.value = string2;
            this.tableId = n2;
            this.fieldNameAlias = string3;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public int getFieldId() {
            return this.fieldId;
        }

        public int getTableId() {
            return this.tableId;
        }

        public void setOrder(SortQueryCriteria sortQueryCriteria) {
            this.order = sortQueryCriteria;
        }

        public SortQueryCriteria getOrder() {
            return this.order;
        }

        public void setValue(String string) {
            this.value = string;
        }

        public String getValue() {
            return this.value;
        }

        public void setUpAndDown(String string) {
            this.upAndDown = string;
        }

        public String getUpAndDown() {
            return this.upAndDown;
        }

        public String getFieldNameAlias() {
            return this.fieldNameAlias;
        }
    }
}

