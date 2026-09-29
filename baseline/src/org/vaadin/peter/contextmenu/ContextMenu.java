/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.AbstractClientConnector
 *  com.vaadin.server.AbstractExtension
 *  com.vaadin.server.Resource
 *  com.vaadin.shared.MouseEventDetails$MouseButton
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 *  com.vaadin.util.ReflectTools
 *  com.vaadin.v7.event.ItemClickEvent
 *  com.vaadin.v7.event.ItemClickEvent$ItemClickListener
 *  com.vaadin.v7.ui.Table
 *  com.vaadin.v7.ui.Table$FooterClickEvent
 *  com.vaadin.v7.ui.Table$FooterClickListener
 *  com.vaadin.v7.ui.Table$HeaderClickEvent
 *  com.vaadin.v7.ui.Table$HeaderClickListener
 *  com.vaadin.v7.ui.Tree
 */
package org.vaadin.peter.contextmenu;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.util.ReflectTools;
import com.vaadin.v7.event.ItemClickEvent;
import com.vaadin.v7.ui.Table;
import com.vaadin.v7.ui.Tree;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import org.vaadin.peter.contextmenu.client.ContextMenuClientRpc;
import org.vaadin.peter.contextmenu.client.ContextMenuServerRpc;
import org.vaadin.peter.contextmenu.client.ContextMenuState;

public class ContextMenu
extends AbstractExtension {
    private static final long serialVersionUID = 4275181115413786498L;
    private final Map<String, ContextMenuItem> items;
    private final ContextMenuServerRpc serverRPC = new ContextMenuServerRpc(){
        private static final long serialVersionUID = 5622864428554337992L;

        @Override
        public void itemClicked(String string, boolean bl) {
            ContextMenuItem contextMenuItem = (ContextMenuItem)ContextMenu.this.items.get(string);
            if (contextMenuItem == null) {
                return;
            }
            contextMenuItem.notifyClickListeners();
            ContextMenu.this.fireEvent(new ContextMenuItemClickEvent(contextMenuItem));
        }

        @Override
        public void onContextMenuOpenRequested(int n, int n2, String string) {
            ContextMenu.this.fireEvent(new ContextMenuOpenedOnComponentEvent(ContextMenu.this, n, n2, (Component)UI.getCurrent().getConnectorTracker().getConnector(string)));
        }

        @Override
        public void contextMenuClosed() {
            ContextMenu.this.fireEvent(new ContextMenuClosedEvent(ContextMenu.this));
        }
    };

    public ContextMenu() {
        this.registerRpc(this.serverRPC);
        this.items = new HashMap<String, ContextMenuItem>();
        this.setOpenAutomatically(true);
        this.setHideAutomatically(true);
    }

    protected String getNextId() {
        return UUID.randomUUID().toString();
    }

    public void setOpenAutomatically(boolean bl) {
        this.getState().setOpenAutomatically(bl);
    }

    public boolean isOpenAutomatically() {
        return this.getState().isOpenAutomatically();
    }

    public void setHideAutomatically(boolean bl) {
        this.getState().setHideAutomatically(bl);
    }

    public boolean isHideAutomatically() {
        return this.getState().isHideAutomatically();
    }

    public ContextMenuItem addItem(String string) {
        ContextMenuState.ContextMenuItemState contextMenuItemState = this.getState().addChild(string, this.getNextId());
        ContextMenuItem contextMenuItem = new ContextMenuItem(null, contextMenuItemState);
        this.items.put(contextMenuItemState.id, contextMenuItem);
        return contextMenuItem;
    }

    public ContextMenuItem addItem(Resource resource) {
        ContextMenuItem contextMenuItem = this.addItem("");
        contextMenuItem.setIcon(resource);
        return contextMenuItem;
    }

    public ContextMenuItem addItem(String string, Resource resource) {
        ContextMenuItem contextMenuItem = this.addItem(string);
        contextMenuItem.setIcon(resource);
        return contextMenuItem;
    }

    public void removeItem(ContextMenuItem contextMenuItem) {
        Object object;
        if (!this.hasMenuItem(contextMenuItem)) {
            return;
        }
        if (contextMenuItem.isRootItem()) {
            this.getState().getRootItems().remove(contextMenuItem.state);
        } else {
            object = contextMenuItem.getParent();
            ((ContextMenuItem)object).state.getChildren().remove(contextMenuItem.state);
        }
        object = contextMenuItem.getAllChildren();
        this.items.remove(((ContextMenuItem)contextMenuItem).state.id);
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            ContextMenuItem contextMenuItem2 = (ContextMenuItem)iterator.next();
            this.items.remove(((ContextMenuItem)contextMenuItem2).state.id);
        }
        this.markAsDirty();
    }

    private boolean hasMenuItem(ContextMenuItem contextMenuItem) {
        return this.items.containsKey(((ContextMenuItem)contextMenuItem).state.id);
    }

    public void removeAllItems() {
        this.items.clear();
        this.getState().getRootItems().clear();
    }

    public void setAsTableContextMenu(final Table table) {
        this.extend((AbstractClientConnector)table);
        this.setOpenAutomatically(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener(){
            private static final long serialVersionUID = -348059189217149508L;

            public void itemClick(ItemClickEvent itemClickEvent) {
                if (itemClickEvent.getButton() == MouseEventDetails.MouseButton.RIGHT) {
                    ContextMenu.this.fireEvent(new ContextMenuOpenedOnTableRowEvent(ContextMenu.this, table, itemClickEvent.getItemId(), itemClickEvent.getPropertyId()));
                    ContextMenu.this.open(itemClickEvent.getClientX(), itemClickEvent.getClientY());
                }
            }
        });
        table.addHeaderClickListener(new Table.HeaderClickListener(){
            private static final long serialVersionUID = -5880755689414670581L;

            public void headerClick(Table.HeaderClickEvent headerClickEvent) {
                if (headerClickEvent.getButton() == MouseEventDetails.MouseButton.RIGHT) {
                    ContextMenu.this.fireEvent(new ContextMenuOpenedOnTableHeaderEvent(ContextMenu.this, table, headerClickEvent.getPropertyId()));
                    ContextMenu.this.open(headerClickEvent.getClientX(), headerClickEvent.getClientY());
                }
            }
        });
        table.addFooterClickListener(new Table.FooterClickListener(){
            private static final long serialVersionUID = 2884227013964132482L;

            public void footerClick(Table.FooterClickEvent footerClickEvent) {
                if (footerClickEvent.getButton() == MouseEventDetails.MouseButton.RIGHT) {
                    ContextMenu.this.fireEvent(new ContextMenuOpenedOnTableHeaderEvent(ContextMenu.this, table, footerClickEvent.getPropertyId()));
                    ContextMenu.this.open(footerClickEvent.getClientX(), footerClickEvent.getClientY());
                }
            }
        });
    }

    public void setAsTreeContextMenu(final Tree tree) {
        this.extend((AbstractClientConnector)tree);
        this.setOpenAutomatically(false);
        tree.addItemClickListener(new ItemClickEvent.ItemClickListener(){
            private static final long serialVersionUID = 338499886052623304L;

            public void itemClick(ItemClickEvent itemClickEvent) {
                if (itemClickEvent.getButton() == MouseEventDetails.MouseButton.RIGHT) {
                    ContextMenu.this.fireEvent(new ContextMenuOpenedOnTreeItemEvent(ContextMenu.this, tree, itemClickEvent.getItemId()));
                    ContextMenu.this.open(itemClickEvent.getClientX(), itemClickEvent.getClientY());
                }
            }
        });
    }

    public void setAsContextMenuOf(AbstractClientConnector abstractClientConnector) {
        if (abstractClientConnector instanceof Table) {
            this.setAsTableContextMenu((Table)abstractClientConnector);
        } else if (abstractClientConnector instanceof Tree) {
            this.setAsTreeContextMenu((Tree)abstractClientConnector);
        } else {
            super.extend(abstractClientConnector);
        }
    }

    public void open(int n, int n2) {
        ((ContextMenuClientRpc)this.getRpcProxy(ContextMenuClientRpc.class)).showContextMenu(n, n2);
    }

    public void open(Component component) {
        ((ContextMenuClientRpc)this.getRpcProxy(ContextMenuClientRpc.class)).showContextMenuRelativeTo(component.getConnectorId());
    }

    public void hide() {
        ((ContextMenuClientRpc)this.getRpcProxy(ContextMenuClientRpc.class)).hide();
    }

    protected ContextMenuState getState() {
        return (ContextMenuState)super.getState();
    }

    public void addItemClickListener(ContextMenuItemClickListener contextMenuItemClickListener) {
        this.addListener(ContextMenuItemClickEvent.class, contextMenuItemClickListener, ContextMenuItemClickListener.ITEM_CLICK_METHOD);
    }

    public void addContextMenuTableListener(ContextMenuOpenedListener.TableListener tableListener) {
        this.addListener(ContextMenuOpenedOnTableRowEvent.class, tableListener, ContextMenuOpenedListener.TableListener.MENU_OPENED_FROM_TABLE_ROW_METHOD);
        this.addListener(ContextMenuOpenedOnTableHeaderEvent.class, tableListener, ContextMenuOpenedListener.TableListener.MENU_OPENED_FROM_TABLE_HEADER_METHOD);
        this.addListener(ContextMenuOpenedOnTableFooterEvent.class, tableListener, ContextMenuOpenedListener.TableListener.MENU_OPENED_FROM_TABLE_FOOTER_METHOD);
    }

    public void addContextMenuTreeListener(ContextMenuOpenedListener.TreeListener treeListener) {
        this.addListener(ContextMenuOpenedOnTreeItemEvent.class, treeListener, ContextMenuOpenedListener.TreeListener.MENU_OPENED_FROM_TREE_ITEM_METHOD);
    }

    public void addContextMenuCloseListener(ContextMenuClosedListener contextMenuClosedListener) {
        this.addListener(ContextMenuClosedEvent.class, contextMenuClosedListener, ContextMenuClosedListener.MENU_CLOSED);
    }

    public void addContextMenuComponentListener(ContextMenuOpenedListener.ComponentListener componentListener) {
        this.addListener(ContextMenuOpenedOnComponentEvent.class, componentListener, ContextMenuOpenedListener.ComponentListener.MENU_OPENED_FROM_COMPONENT);
    }

    public static class ContextMenuOpenedOnComponentEvent
    extends EventObject {
        private static final long serialVersionUID = 947108059398706966L;
        private final ContextMenu contextMenu;
        private final int x;
        private final int y;

        public ContextMenuOpenedOnComponentEvent(ContextMenu contextMenu, int n, int n2, Component component) {
            super(component);
            this.contextMenu = contextMenu;
            this.x = n;
            this.y = n2;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }

        public Component getRequestSourceComponent() {
            return (Component)this.getSource();
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static class ContextMenuOpenedOnTableRowEvent
    extends EventObject {
        private static final long serialVersionUID = -470218301318358912L;
        private final ContextMenu contextMenu;
        private final Object propertyId;
        private final Object itemId;

        public ContextMenuOpenedOnTableRowEvent(ContextMenu contextMenu, Table table, Object object, Object object2) {
            super(table);
            this.contextMenu = contextMenu;
            this.itemId = object;
            this.propertyId = object2;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }

        public Object getItemId() {
            return this.itemId;
        }

        public Object getPropertyId() {
            return this.propertyId;
        }
    }

    public static class ContextMenuOpenedOnTableFooterEvent
    extends EventObject {
        private static final long serialVersionUID = 1999781663913723438L;
        private final Object propertyId;
        private final ContextMenu contextMenu;

        public ContextMenuOpenedOnTableFooterEvent(ContextMenu contextMenu, Table table, Object object) {
            super(table);
            this.contextMenu = contextMenu;
            this.propertyId = object;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }

        public Object getPropertyId() {
            return this.propertyId;
        }
    }

    public static class ContextMenuOpenedOnTableHeaderEvent
    extends EventObject {
        private static final long serialVersionUID = -1220618848356241248L;
        private final Object propertyId;
        private final ContextMenu contextMenu;

        public ContextMenuOpenedOnTableHeaderEvent(ContextMenu contextMenu, Table table, Object object) {
            super(table);
            this.contextMenu = contextMenu;
            this.propertyId = object;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }

        public Object getPropertyId() {
            return this.propertyId;
        }
    }

    public static class ContextMenuOpenedOnTreeItemEvent
    extends EventObject {
        private static final long serialVersionUID = -7705205542849351984L;
        private final Object itemId;
        private final ContextMenu contextMenu;

        public ContextMenuOpenedOnTreeItemEvent(ContextMenu contextMenu, Tree tree, Object object) {
            super(tree);
            this.contextMenu = contextMenu;
            this.itemId = object;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }

        public Object getItemId() {
            return this.itemId;
        }
    }

    public static interface ContextMenuOpenedListener
    extends EventListener {

        public static interface TreeListener
        extends ContextMenuOpenedListener {
            public static final Method MENU_OPENED_FROM_TREE_ITEM_METHOD = ReflectTools.findMethod(TreeListener.class, (String)"onContextMenuOpenFromTreeItem", (Class[])new Class[]{ContextMenuOpenedOnTreeItemEvent.class});

            public void onContextMenuOpenFromTreeItem(ContextMenuOpenedOnTreeItemEvent var1);
        }

        public static interface TableListener
        extends ContextMenuOpenedListener {
            public static final Method MENU_OPENED_FROM_TABLE_ROW_METHOD = ReflectTools.findMethod(TableListener.class, (String)"onContextMenuOpenFromRow", (Class[])new Class[]{ContextMenuOpenedOnTableRowEvent.class});
            public static final Method MENU_OPENED_FROM_TABLE_HEADER_METHOD = ReflectTools.findMethod(TableListener.class, (String)"onContextMenuOpenFromHeader", (Class[])new Class[]{ContextMenuOpenedOnTableHeaderEvent.class});
            public static final Method MENU_OPENED_FROM_TABLE_FOOTER_METHOD = ReflectTools.findMethod(TableListener.class, (String)"onContextMenuOpenFromFooter", (Class[])new Class[]{ContextMenuOpenedOnTableFooterEvent.class});

            public void onContextMenuOpenFromRow(ContextMenuOpenedOnTableRowEvent var1);

            public void onContextMenuOpenFromHeader(ContextMenuOpenedOnTableHeaderEvent var1);

            public void onContextMenuOpenFromFooter(ContextMenuOpenedOnTableFooterEvent var1);
        }

        public static interface ComponentListener
        extends ContextMenuOpenedListener {
            public static final Method MENU_OPENED_FROM_COMPONENT = ReflectTools.findMethod(ComponentListener.class, (String)"onContextMenuOpenFromComponent", (Class[])new Class[]{ContextMenuOpenedOnComponentEvent.class});

            public void onContextMenuOpenFromComponent(ContextMenuOpenedOnComponentEvent var1);
        }
    }

    public static class ContextMenuClosedEvent
    extends EventObject {
        private static final long serialVersionUID = -5705205542849351984L;
        private final ContextMenu contextMenu;

        public ContextMenuClosedEvent(ContextMenu contextMenu) {
            super((Object)contextMenu);
            this.contextMenu = contextMenu;
        }

        public ContextMenu getContextMenu() {
            return this.contextMenu;
        }
    }

    public static interface ContextMenuClosedListener
    extends EventListener {
        public static final Method MENU_CLOSED = ReflectTools.findMethod(ContextMenuClosedListener.class, (String)"onContextMenuClosed", (Class[])new Class[]{ContextMenuClosedEvent.class});

        public void onContextMenuClosed(ContextMenuClosedEvent var1);
    }

    public static class ContextMenuItemClickEvent
    extends EventObject {
        private static final long serialVersionUID = -3301204853129409248L;

        public ContextMenuItemClickEvent(Object object) {
            super(object);
        }
    }

    public static interface ContextMenuItemClickListener
    extends EventListener {
        public static final Method ITEM_CLICK_METHOD = ReflectTools.findMethod(ContextMenuItemClickListener.class, (String)"contextMenuItemClicked", (Class[])new Class[]{ContextMenuItemClickEvent.class});

        public void contextMenuItemClicked(ContextMenuItemClickEvent var1);
    }

    public class ContextMenuItem
    implements Serializable {
        private static final long serialVersionUID = -6514832427611690050L;
        private ContextMenuItem parent;
        private final ContextMenuState.ContextMenuItemState state;
        private final List<ContextMenuItemClickListener> clickListeners;
        private Object data;

        protected ContextMenuItem(ContextMenuItem contextMenuItem, ContextMenuState.ContextMenuItemState contextMenuItemState) {
            this.parent = contextMenuItem;
            if (contextMenuItemState == null) {
                throw new NullPointerException("Context menu item state must not be null");
            }
            this.clickListeners = new ArrayList<ContextMenuItemClickListener>();
            this.state = contextMenuItemState;
        }

        protected Set<ContextMenuItem> getAllChildren() {
            HashSet<ContextMenuItem> hashSet = new HashSet<ContextMenuItem>();
            for (ContextMenuState.ContextMenuItemState contextMenuItemState : this.state.getChildren()) {
                ContextMenuItem contextMenuItem = (ContextMenuItem)ContextMenu.this.items.get(contextMenuItemState.id);
                hashSet.add(contextMenuItem);
                hashSet.addAll(contextMenuItem.getAllChildren());
            }
            return hashSet;
        }

        protected ContextMenuItem getParent() {
            return this.parent;
        }

        protected void notifyClickListeners() {
            for (ContextMenuItemClickListener contextMenuItemClickListener : this.clickListeners) {
                contextMenuItemClickListener.contextMenuItemClicked(new ContextMenuItemClickEvent(this));
            }
        }

        public void setData(Object object) {
            this.data = object;
        }

        public Object getData() {
            return this.data;
        }

        public ContextMenuItem addItem(String string) {
            ContextMenuState.ContextMenuItemState contextMenuItemState = this.state.addChild(string, ContextMenu.this.getNextId());
            ContextMenuItem contextMenuItem = new ContextMenuItem(this, contextMenuItemState);
            ContextMenu.this.items.put(contextMenuItemState.id, contextMenuItem);
            ContextMenu.this.markAsDirty();
            return contextMenuItem;
        }

        public ContextMenuItem addItem(Resource resource) {
            ContextMenuItem contextMenuItem = this.addItem("");
            contextMenuItem.setIcon(resource);
            return contextMenuItem;
        }

        public ContextMenuItem addItem(String string, Resource resource) {
            ContextMenuItem contextMenuItem = this.addItem(string);
            contextMenuItem.setIcon(resource);
            return contextMenuItem;
        }

        public void setIcon(Resource resource) {
            ContextMenu.this.setResource(this.state.id, resource);
        }

        public Resource getIcon() {
            return ContextMenu.this.getResource(this.state.id);
        }

        public void setSeparatorVisible(boolean bl) {
            this.state.separator = bl;
            ContextMenu.this.markAsDirty();
        }

        public boolean hasSeparator() {
            return this.state.separator;
        }

        public void setEnabled(boolean bl) {
            this.state.enabled = bl;
            ContextMenu.this.markAsDirty();
        }

        public boolean isEnabled() {
            return this.state.enabled;
        }

        public boolean hasSubMenu() {
            return this.state.getChildren().size() > 0;
        }

        public boolean isRootItem() {
            return this.parent == null;
        }

        public void addItemClickListener(ContextMenuItemClickListener contextMenuItemClickListener) {
            this.clickListeners.add(contextMenuItemClickListener);
        }

        public void removeItemClickListener(ContextMenuItemClickListener contextMenuItemClickListener) {
            this.clickListeners.remove(contextMenuItemClickListener);
        }

        public void addStyleName(String string) {
            if (string == null || string.isEmpty()) {
                return;
            }
            if (string.contains(" ")) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    this.addStyleName(stringTokenizer.nextToken());
                }
                return;
            }
            this.state.getStyles().add(string);
            ContextMenu.this.markAsDirty();
        }

        public void removeStyleName(String string) {
            if (this.state.getStyles().isEmpty()) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
            while (stringTokenizer.hasMoreTokens()) {
                this.state.getStyles().remove(stringTokenizer.nextToken());
            }
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof ContextMenuItem) {
                return this.state.id.equals(((ContextMenuItem)object).state.id);
            }
            return false;
        }

        public int hashCode() {
            return this.state.id.hashCode();
        }

        public void setCaption(String string) {
            this.state.caption = string;
            ContextMenu.this.markAsDirty();
        }
    }
}

