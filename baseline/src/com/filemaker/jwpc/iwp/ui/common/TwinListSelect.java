/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.ShortcutListener
 *  com.vaadin.event.dd.DragAndDropEvent
 *  com.vaadin.event.dd.DropHandler
 *  com.vaadin.event.dd.acceptcriteria.AcceptCriterion
 *  com.vaadin.event.dd.acceptcriteria.And
 *  com.vaadin.event.dd.acceptcriteria.ClientSideCriterion
 *  com.vaadin.event.dd.acceptcriteria.SourceIs
 *  com.vaadin.server.ClientConnector$DetachEvent
 *  com.vaadin.server.ClientConnector$DetachListener
 *  com.vaadin.shared.Registration
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.util.BeanItemContainer
 *  com.vaadin.v7.event.DataBoundTransferable
 *  com.vaadin.v7.event.ItemClickEvent
 *  com.vaadin.v7.event.ItemClickEvent$ItemClickListener
 *  com.vaadin.v7.ui.AbstractSelect$AbstractSelectTargetDetails
 *  com.vaadin.v7.ui.AbstractSelect$AcceptItem
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.Table
 *  com.vaadin.v7.ui.Table$TableDragMode
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.common.DialogButton;
import com.filemaker.jwpc.iwp.ui.common.MultiColumnListSelect;
import com.filemaker.jwpc.iwp.ui.layout.AbstractBaseTable;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.event.ShortcutListener;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.event.dd.acceptcriteria.ClientSideCriterion;
import com.vaadin.event.dd.acceptcriteria.SourceIs;
import com.vaadin.server.ClientConnector;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.event.DataBoundTransferable;
import com.vaadin.v7.event.ItemClickEvent;
import com.vaadin.v7.ui.AbstractSelect;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Collection;

public abstract class TwinListSelect
extends HorizontalLayout {
    private final App app;
    private final MultiColumnListSelect srcList;
    private final MultiColumnListSelect targetList;
    private final DialogButton moveToBtn;
    private final DialogButton clearAllBtn;
    private Object selectedItem;
    private boolean bMoveToTarget;
    private VerticalLayout buttonLayout;

    public TwinListSelect(App app, String string, String string2) {
        this.app = app;
        this.setSizeFull();
        this.setSpacing(true);
        this.bMoveToTarget = true;
        this.selectedItem = null;
        this.srcList = new MultiColumnListSelect(string, this.getSourceDataContainer());
        this.setSourceVisibleColumns();
        this.srcList.getTable().addItemClickListener(new ItemClickEvent.ItemClickListener(){

            public void itemClick(ItemClickEvent itemClickEvent) {
                TwinListSelect.this.performSourceItemSelected(itemClickEvent);
            }
        });
        this.addComponent((Component)this.srcList);
        this.setComponentAlignment((Component)this.srcList, Alignment.TOP_LEFT);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        this.buttonLayout = verticalLayout;
        Label label = new Label();
        label.setHeight("15px");
        verticalLayout.addComponent((Component)label);
        this.clearAllBtn = new DialogButton(this.app, IWPI18N.get(app, "CLEAR_ALL", new Object[0]));
        this.clearAllBtn.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                TwinListSelect.this.performClearAll(clickEvent);
            }
        });
        verticalLayout.addComponent((Component)this.clearAllBtn);
        verticalLayout.setComponentAlignment((Component)this.clearAllBtn, Alignment.MIDDLE_CENTER);
        this.moveToBtn = new DialogButton(this.app, IWPI18N.get(app, "MOVE_TO", new Object[0]));
        this.moveToBtn.addClickListener(new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                TwinListSelect.this.performMoveTo();
            }
        });
        verticalLayout.addComponent((Component)this.moveToBtn);
        verticalLayout.setComponentAlignment((Component)this.moveToBtn, Alignment.MIDDLE_CENTER);
        this.addComponent((Component)verticalLayout);
        this.setComponentAlignment((Component)verticalLayout, Alignment.TOP_CENTER);
        this.targetList = new MultiColumnListSelect(string2, this.getTargetDataContainer());
        this.setTargetVisibleColumns();
        this.targetList.getTable().addItemClickListener(new ItemClickEvent.ItemClickListener(){

            public void itemClick(ItemClickEvent itemClickEvent) {
                TwinListSelect.this.performTargetItemSelected(itemClickEvent);
            }
        });
        this.addComponent((Component)this.targetList);
        this.moveToBtn.setEnabled(false);
        this.clearAllBtn.setEnabled(!this.getTargetDataContainer().getItemIds().isEmpty());
        final AbstractBaseTable abstractBaseTable = this.getSource();
        final AbstractBaseTable abstractBaseTable2 = this.getTarget();
        if (!BrowserInfoHandler.isTouchDevice(app)) {
            abstractBaseTable.setDragMode(Table.TableDragMode.ROW);
        }
        abstractBaseTable.setDropHandler(new DropHandler(){
            final /* synthetic */ TwinListSelect this$0;
            {
                this.this$0 = twinListSelect;
            }

            public void drop(DragAndDropEvent dragAndDropEvent) {
                this.this$0.dropToSourceList(dragAndDropEvent);
            }

            public AcceptCriterion getAcceptCriterion() {
                return new And(new ClientSideCriterion[]{new SourceIs(new Component[]{abstractBaseTable2}), AbstractSelect.AcceptItem.ALL});
            }
        });
        if (!BrowserInfoHandler.isTouchDevice(app)) {
            abstractBaseTable2.setDragMode(Table.TableDragMode.ROW);
        }
        abstractBaseTable2.setDropHandler(new DropHandler(){
            final /* synthetic */ TwinListSelect this$0;
            {
                this.this$0 = twinListSelect;
            }

            public void drop(DragAndDropEvent dragAndDropEvent) {
                this.this$0.dropToTargetList(dragAndDropEvent);
            }

            public AcceptCriterion getAcceptCriterion() {
                return new And(new ClientSideCriterion[]{new SourceIs(new Component[]{abstractBaseTable}), AbstractSelect.AcceptItem.ALL});
            }
        });
        if (AppServlet.isAriaCompliantControlEnabled()) {
            abstractBaseTable.registerTableEventCallback(new AbstractBaseTable.TableEventCallback(){

                @Override
                public void onNavFocus(int n) {
                    TwinListSelect.this.onNavFocus(true, n);
                }

                @Override
                public void onNavSelect(int n) {
                    TwinListSelect.this.onNavSelect(true, n);
                }

                @Override
                public void onNavMove(int n, int n2) {
                    TwinListSelect.this.onNavMove(true, n, n2);
                }
            });
            abstractBaseTable2.registerTableEventCallback(new AbstractBaseTable.TableEventCallback(){

                @Override
                public void onNavFocus(int n) {
                    TwinListSelect.this.onNavFocus(false, n);
                }

                @Override
                public void onNavSelect(int n) {
                    TwinListSelect.this.onNavSelect(false, n);
                }

                @Override
                public void onNavMove(int n, int n2) {
                    TwinListSelect.this.onNavMove(false, n, n2);
                }
            });
            final Registration registration = this.addShortcutListener(new ShortcutListener(this, "MoveRight", 39, null){
                final /* synthetic */ TwinListSelect this$0;
                {
                    this.this$0 = twinListSelect;
                    super(string, n, nArray);
                }

                public void handleAction(Object object, Object object2) {
                    if (abstractBaseTable.equals(object2)) {
                        this.this$0.performItemSelected();
                    }
                }
            });
            final Registration registration2 = this.addShortcutListener(new ShortcutListener(this, "MoveLeft", 37, null){
                final /* synthetic */ TwinListSelect this$0;
                {
                    this.this$0 = twinListSelect;
                    super(string, n, nArray);
                }

                public void handleAction(Object object, Object object2) {
                    if (abstractBaseTable2.equals(object2)) {
                        this.this$0.performItemSelected();
                    }
                }
            });
            this.addDetachListener(new ClientConnector.DetachListener(){
                final /* synthetic */ TwinListSelect this$0;
                {
                    this.this$0 = twinListSelect;
                }

                public void detach(ClientConnector.DetachEvent detachEvent) {
                    registration.remove();
                    registration2.remove();
                }
            });
        }
    }

    protected abstract Container getSourceDataContainer();

    protected abstract Container getTargetDataContainer();

    protected void setSourceVisibleColumns() {
    }

    protected void setTargetVisibleColumns() {
    }

    public final Object getSelectedItem() {
        return this.selectedItem;
    }

    protected final void setSelectedItem(Object object) {
        this.selectedItem = object;
    }

    public final boolean isMoveToTarget() {
        return this.bMoveToTarget;
    }

    protected final void setMoveToTarget(boolean bl) {
        this.bMoveToTarget = bl;
    }

    public final AbstractBaseTable getSource() {
        return this.srcList.getTable();
    }

    public final AbstractBaseTable getTarget() {
        return this.targetList.getTable();
    }

    public void addSourceListClickedListener(ItemClickEvent.ItemClickListener itemClickListener) {
        this.getSource().addItemClickListener(itemClickListener);
    }

    public void addTargetListClickedListener(ItemClickEvent.ItemClickListener itemClickListener) {
        this.getTarget().addItemClickListener(itemClickListener);
    }

    protected void performMoveTo() {
        this.performMoveItem(this.getSelectedItem());
        this.setSelectedItem(null);
    }

    protected void performMoveItem(Object object) {
        Container container = this.getSource().getContainerDataSource();
        Container container2 = this.getTarget().getContainerDataSource();
        if (this.isMoveToTarget()) {
            container2.addItem(object);
            container.removeItem(object);
        } else {
            container.addItem(object);
            container2.removeItem(object);
        }
        this.srcList.getTable().unselect(object);
        this.targetList.getTable().unselect(object);
        this.moveToBtn.setEnabled(false);
        this.clearAllBtn.setEnabled(!container2.getItemIds().isEmpty());
    }

    protected boolean putItemBackToSource(Object object) {
        return true;
    }

    protected void performClearAll(Button.ClickEvent clickEvent) {
        Container container = this.getTarget().getContainerDataSource();
        Collection collection = container.getItemIds();
        if (!collection.isEmpty()) {
            AbstractBaseTable abstractBaseTable = this.getSource();
            Container container2 = abstractBaseTable.getContainerDataSource();
            Object var6_62 = null;
            for (Object var6_62 : collection) {
                if (!this.putItemBackToSource(var6_62)) continue;
                container2.addItem(var6_62);
            }
            if (abstractBaseTable.isSelected(var6_62)) {
                abstractBaseTable.unselect(var6_62);
            } else if (this.selectedItem != null) {
                if (this.bMoveToTarget) {
                    abstractBaseTable.unselect(this.selectedItem);
                }
                this.selectedItem = null;
            }
            container.removeAllItems();
            this.clearAllBtn.setEnabled(false);
            this.moveToBtn.setEnabled(false);
        }
    }

    protected void dropToSourceList(DragAndDropEvent dragAndDropEvent) {
        this.dropToList(dragAndDropEvent, this.getSource());
    }

    protected void dropToTargetList(DragAndDropEvent dragAndDropEvent) {
        this.dropToList(dragAndDropEvent, this.getTarget());
    }

    protected void performSourceItemSelected(ItemClickEvent itemClickEvent) {
        Object object = itemClickEvent.getItemId();
        if (this.bMoveToTarget) {
            this.performItemSelectInCurrentList(itemClickEvent);
        } else {
            this.bMoveToTarget = true;
            this.moveToBtn.setCaption(IWPI18N.get(this.app, "MOVE_TO", new Object[0]));
            if (this.selectedItem != null && this.getTarget().isSelected(this.selectedItem)) {
                this.getTarget().unselect(this.selectedItem);
            }
            this.selectedItem = object;
            this.moveToBtn.setEnabled(true);
        }
    }

    protected void performTargetItemSelected(ItemClickEvent itemClickEvent) {
        Object object = itemClickEvent.getItemId();
        if (this.bMoveToTarget) {
            this.performTargetItemSelected(object);
        } else {
            this.performItemSelectInCurrentList(itemClickEvent);
        }
    }

    protected void performTargetItemSelected(Object object) {
        this.bMoveToTarget = false;
        this.moveToBtn.setCaption(IWPI18N.get(this.app, "CLEAR", new Object[0]));
        if (this.selectedItem != null && this.getSource().isSelected(this.selectedItem)) {
            this.getSource().unselect(this.selectedItem);
        }
        this.selectedItem = object;
        this.moveToBtn.setEnabled(true);
    }

    private void performItemSelectInCurrentList(ItemClickEvent itemClickEvent) {
        Object object = itemClickEvent.getItemId();
        if (this.selectedItem == null || !this.selectedItem.equals(object)) {
            this.selectedItem = object;
            if (!this.moveToBtn.isEnabled()) {
                this.moveToBtn.setEnabled(true);
            }
        } else if (itemClickEvent.isMetaKey()) {
            this.selectedItem = null;
            this.moveToBtn.setEnabled(false);
        } else if (itemClickEvent.isDoubleClick()) {
            this.performMoveTo();
        } else if (((Table)itemClickEvent.getSource()).isSelected(object)) {
            if (this.moveToBtn.isEnabled()) {
                this.moveToBtn.setEnabled(false);
            }
        } else if (!this.moveToBtn.isEnabled()) {
            this.moveToBtn.setEnabled(true);
        }
    }

    private void unselectCurrentSelectedItem() {
        if (this.selectedItem != null) {
            AbstractBaseTable abstractBaseTable;
            AbstractBaseTable abstractBaseTable2 = abstractBaseTable = this.bMoveToTarget ? this.getSource() : this.getTarget();
            if (abstractBaseTable.isSelected(this.selectedItem)) {
                abstractBaseTable.unselect(this.selectedItem);
                this.selectedItem = null;
                if (this.moveToBtn.isEnabled()) {
                    this.moveToBtn.setEnabled(false);
                }
            }
        }
    }

    private void dropToList(DragAndDropEvent dragAndDropEvent, Table table) {
        this.unselectCurrentSelectedItem();
        DataBoundTransferable dataBoundTransferable = (DataBoundTransferable)dragAndDropEvent.getTransferable();
        BeanItemContainer beanItemContainer = (BeanItemContainer)dataBoundTransferable.getSourceContainer();
        Object object = dataBoundTransferable.getItemId();
        AbstractSelect.AbstractSelectTargetDetails abstractSelectTargetDetails = (AbstractSelect.AbstractSelectTargetDetails)dragAndDropEvent.getTargetDetails();
        Object object2 = abstractSelectTargetDetails.getItemIdOver();
        beanItemContainer.removeItem(object);
        BeanItemContainer beanItemContainer2 = (BeanItemContainer)table.getContainerDataSource();
        if (object2 != null) {
            switch (abstractSelectTargetDetails.getDropLocation()) {
                case BOTTOM: {
                    beanItemContainer2.addItemAfter(object2, object);
                    break;
                }
                case MIDDLE: 
                case TOP: {
                    Object object3 = beanItemContainer2.prevItemId(object2);
                    beanItemContainer2.addItemAfter(object3, object);
                }
            }
        } else {
            beanItemContainer2.addItem(object);
        }
        if (table.isSelected(object)) {
            table.unselect(object);
        }
        this.clearAllBtn.setEnabled(!this.getTarget().getContainerDataSource().getItemIds().isEmpty());
    }

    protected VerticalLayout getButtonLayout() {
        return this.buttonLayout;
    }

    private Object getSrcItemByIndex(int n) {
        Collection collection = this.srcList.getTable().getItemIds();
        if (collection.size() > n) {
            return collection.toArray()[n];
        }
        return null;
    }

    private Object getTargetItemByIndex(int n) {
        Collection collection = this.targetList.getTable().getItemIds();
        if (collection.size() > n) {
            return collection.toArray()[n];
        }
        return null;
    }

    protected void performSourceItemFocused(Object object) {
        if (this.selectedItem == null || !this.selectedItem.equals(object)) {
            this.selectedItem = object;
            if (!this.moveToBtn.isEnabled()) {
                this.moveToBtn.setEnabled(true);
            }
        }
    }

    protected void performItemSelected() {
        this.performMoveTo();
    }

    protected void performTargetItemFocused(Object object) {
        this.performTargetItemSelected(object);
    }

    protected void removeSelection() {
        if (this.selectedItem != null) {
            if (this.getSource().isSelected(this.selectedItem)) {
                this.getSource().unselect(this.selectedItem);
            } else if (this.getTarget().isSelected(this.selectedItem)) {
                this.getTarget().unselect(this.selectedItem);
            }
            this.selectedItem = null;
        }
    }

    protected void onNavFocus(boolean bl, int n) {
        AbstractBaseTable abstractBaseTable;
        AbstractBaseTable abstractBaseTable2 = abstractBaseTable = bl ? this.getSource() : this.getTarget();
        if (n >= 0 && abstractBaseTable.size() > n) {
            Object object = abstractBaseTable.getIdByIndex(n);
            if (bl && !this.bMoveToTarget) {
                this.bMoveToTarget = true;
                this.moveToBtn.setCaption(IWPI18N.get(this.app, "MOVE_TO", new Object[0]));
            } else if (!bl && this.bMoveToTarget) {
                this.bMoveToTarget = false;
                this.moveToBtn.setCaption(IWPI18N.get(this.app, "CLEAR", new Object[0]));
            }
            if (!this.moveToBtn.isEnabled()) {
                this.moveToBtn.setEnabled(true);
            }
            this.removeSelection();
            this.selectedItem = object;
            abstractBaseTable.select(object);
        }
    }

    protected void onNavSelect(boolean bl, int n) {
        this.onNavFocus(bl, n);
        this.performItemSelected();
    }

    protected void onNavMove(boolean bl, int n, int n2) {
        if (!bl && n != n2) {
            this.moveSelected(this.getTarget(), n, n2);
            this.getTarget().syncAria();
        }
    }

    private void moveSelected(AbstractBaseTable abstractBaseTable, int n, int n2) {
        if (n >= 0 && n2 >= 0 && n < abstractBaseTable.size() && n2 < abstractBaseTable.size()) {
            Object object;
            abstractBaseTable.swapItems(n, n2);
            this.removeSelection();
            this.selectedItem = object = abstractBaseTable.getIdByIndex(n2);
            abstractBaseTable.select(object);
        }
    }
}

