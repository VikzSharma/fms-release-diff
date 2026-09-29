/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.LayoutEvents$LayoutClickEvent
 *  com.vaadin.event.LayoutEvents$LayoutClickListener
 *  com.vaadin.shared.MouseEventDetails$MouseButton
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.HasComponents
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.common.ErrorDialog;
import com.filemaker.jwpc.iwp.ui.layout.AbstractTable;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObjectBuildingBlock;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.GlassPane;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.listener.PopoverLayoutListener;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;

public class LayoutListener
implements LayoutEvents.LayoutClickListener {
    protected final App appRoot;

    public LayoutListener(App app) {
        this.appRoot = app;
    }

    public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
        PopoverWindow popoverWindow;
        if (layoutClickEvent.isDoubleClick()) {
            return;
        }
        this.appRoot.getActiveUIHandler().setQuickFindFocus(false);
        this.appRoot.getActiveUIHandler().clearContextMenuPosition();
        Component component = layoutClickEvent.getClickedComponent();
        if (component != null && component instanceof PopoverButton && !((PopoverButton)component).isEnabled()) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = true;
        if (!(component != null && this instanceof PopoverLayoutListener || (popoverWindow = this.appRoot.getLayoutContainer().getPopoverWindow()) == null || !popoverWindow.isVisible() || this.isFieldFocus(component))) {
            bl = true;
            if (component != null && component instanceof PopoverButton && popoverWindow.getPopover() != null && (PopoverButton)component == popoverWindow.getPopover().getOwningPopoverButton()) {
                bl3 = false;
            }
        }
        if (component == null) {
            bl3 = false;
        }
        if (bl3) {
            Object object;
            boolean bl4;
            HasComponents hasComponents;
            popoverWindow = component.getParent();
            HasComponents hasComponents2 = hasComponents = popoverWindow != null ? popoverWindow.getParent() : null;
            Container container = component instanceof Container ? (Container)component : (popoverWindow != null && popoverWindow instanceof Container ? (Container)((Object)popoverWindow) : (hasComponents != null && hasComponents instanceof Container ? (Container)hasComponents : null));
            if (container != null) {
                boolean bl5 = bl4 = container == this.appRoot.getActiveContainerField(true);
                if (MouseEventDetails.MouseButton.RIGHT == layoutClickEvent.getButton() || MouseEventDetails.MouseButton.LEFT == layoutClickEvent.getButton() && BrowserInfoHandler.isMacOSClient(this.appRoot) && layoutClickEvent.isCtrlKey()) {
                    boolean bl6;
                    int n = layoutClickEvent.getClientX();
                    int n2 = layoutClickEvent.getClientY();
                    object = container.getMetaData();
                    boolean bl7 = ((ObjectMetaData)object).isContextMenuDisabled();
                    boolean bl8 = container.getBinData().isFieldIsWebContainer();
                    boolean bl9 = false;
                    if (bl8) {
                        bl9 = container.getBinData().getMasterType().equalsIgnoreCase("application/pdf");
                    }
                    boolean bl10 = bl6 = !bl8 || bl8 && (!bl9 || bl9 && !bl7);
                    if (!bl4) {
                        if (bl6) {
                            this.appRoot.getActiveUIHandler().setContextMenuPosition(container, n, n2);
                        }
                    } else if (bl6) {
                        container.showContextMenu(n, n2);
                    }
                }
                if (!bl4) {
                    GlobalUIActionHandlers.ENTER_FIELD.perform(this.appRoot, new Object[]{container, true});
                    bl2 = true;
                }
            }
            bl4 = false;
            if (component instanceof LayoutObjectBuildingBlock) {
                if (component instanceof AbstractTable) {
                    bl3 = false;
                } else if (!(component instanceof LayoutObject)) {
                    component = LayoutObjectUtilities.getLayoutObject(component);
                }
            } else if (component instanceof GlassPane) {
                component = ((GlassPane)component).getNonInteractiveLayoutObject();
                bl4 = true;
            } else if (component instanceof LOWrapper) {
                component = ((LOWrapper)component).getWrappedLayoutObject();
            }
            if (bl3 && !(component instanceof LayoutObject)) {
                LayoutObject layoutObject = LayoutObjectUtilities.getLayoutObject(component);
                if (layoutObject != null) {
                    component = layoutObject;
                } else {
                    if (!(component instanceof com.vaadin.ui.Button) && this.appRoot.isBrowseMode()) {
                        GlobalUIActionHandlers.COMMIT_RECORD.perform(this.appRoot, new Object[]{bl});
                        bl2 = true;
                    }
                    bl3 = false;
                }
            }
            if (bl3 && component instanceof LayoutObject) {
                LayoutObject layoutObject = (LayoutObject)component;
                if (layoutObject.getMetaData().isField() && !layoutObject.getMetaData().isGlobalField() && this.appRoot.getLayoutDataModel().getFoundRecords() == 0 && this.appRoot.getPrivileges().isCommandEnabled(0) && !layoutObject.getMetaData().hasValidAndExecutableScript()) {
                    new ErrorDialog(this.appRoot, IWPI18N.get(this.appRoot, "NO_REC_PRESENT", new Object[0])).showDialog();
                }
                if (layoutObject.getMetaData().isField() && this.appRoot.getActiveUIHandler().isActiveObject(layoutObject)) {
                    bl3 = false;
                }
                if (bl3 && !this.isFieldFocus(layoutObject)) {
                    Button button;
                    if (layoutObject instanceof PanelContainerControl) {
                        ((PanelContainerControl)layoutObject).setProcessTabBarClick(true);
                    } else {
                        PortalRowProperty portalRowProperty = Portal.getPortalCell(layoutObject);
                        if (portalRowProperty != null && (this.appRoot.isBrowseMode() || portalRowProperty.getPortal().getMetaData().useCurrentFoundSet())) {
                            GlobalUIActionHandlers.PROCESS_CLICK.perform(this.appRoot, new Object[]{layoutObject, bl, portalRowProperty.getPortalRecordIndex() == 0});
                        } else if (!this.isSameRecord(layoutObject)) {
                            GlobalUIActionHandlers.PROCESS_CLICK.perform(this.appRoot, new Object[]{layoutObject, bl, false});
                        } else {
                            GlobalUIActionHandlers.PROCESS_CLICK.perform(this.appRoot, new Object[]{layoutObject, bl, this.shouldCommit(layoutObject, bl4)});
                        }
                        bl2 = true;
                    }
                    if (layoutObject instanceof Button && !bl4 && (button = (Button)layoutObject) != null && (object = button.getParentComponent()) != null && object instanceof SegmentedBar) {
                        this.appRoot.getLayoutContainer().getContainerState().setPendingActivatedSegmentBar(layoutObject);
                    }
                }
            }
        }
        if (bl && !bl2) {
            this.appRoot.getLayoutContainer().getPopoverHandler().exitPopover(true);
        }
    }

    private boolean isFieldFocus(Component component) {
        boolean bl = false;
        if (component != null && component instanceof LayoutObject) {
            LayoutObject layoutObject = (LayoutObject)component;
            bl = layoutObject.getMetaData().isField() && LayoutObjectUtilities.allowDataEntry(this.appRoot, (LayoutFieldObject)layoutObject, ((LayoutFieldObject)layoutObject).getAccess()) && !layoutObject.getMetaData().hasValidAndExecutableScript();
        }
        return bl;
    }

    private boolean isSameRecord(LayoutObject layoutObject) {
        int n;
        int n2 = this.appRoot.getLayoutDataModel().getRecordIndex();
        return n2 == (n = layoutObject.getAttributes().getRecordIndex());
    }

    private boolean shouldCommit(LayoutObject layoutObject, boolean bl) {
        boolean bl2 = true;
        if (layoutObject != null) {
            ObjectMetaData objectMetaData = layoutObject.getMetaData();
            if (objectMetaData.hasValidAndExecutableScript()) {
                bl2 = false;
            } else if (layoutObject.getMetaData().isField() && bl) {
                bl2 = true;
            } else {
                LayoutObjectType layoutObjectType = layoutObject.getMetaData().getType();
                bl2 = !objectMetaData.isField() && layoutObjectType != LayoutObjectType.POPOVER_BUTTON && (layoutObjectType != LayoutObjectType.POPOVER || layoutObject.getAttributes().getOwningPortal() == null) && layoutObjectType != LayoutObjectType.WEB_VIEWER && layoutObjectType != LayoutObjectType.CHART;
            }
        }
        return bl2;
    }
}

