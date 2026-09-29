/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.TabSheet$Tab
 *  javolution.util.FastList
 */
package com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PanelContainerPanelMetaData;
import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javolution.util.FastList;

public abstract class PanelContainerPanel
extends CssLayoutObject
implements LayoutContainerObject {
    private TabSheet.Tab tab;
    private String mainTabStyleId;
    private List<String> cfTabStyleNames;
    private List<LayoutObject> childs = new ArrayList<LayoutObject>();
    private boolean added = false;
    private boolean isDefaultPanel = false;

    public PanelContainerPanel(App app, PanelContainerPanelMetaData panelContainerPanelMetaData, ObjectAttributes objectAttributes) {
        super(app, panelContainerPanelMetaData, objectAttributes);
        this.isDefaultPanel = panelContainerPanelMetaData.isDefaultPanel();
        this.setSizeFull();
    }

    @Override
    public void cleanupMemory() {
        if (this.cfTabStyleNames != null) {
            this.cfTabStyleNames.clear();
            this.cfTabStyleNames = null;
        }
        if (this.childs != null) {
            for (LayoutObject layoutObject : this.childs) {
                layoutObject.cleanupMemory();
            }
            this.childs.clear();
            this.childs = null;
        }
    }

    public boolean isDefault() {
        return this.isDefaultPanel;
    }

    @Override
    public Collection<LayoutObject> getChilds() {
        return this.childs;
    }

    @Override
    public void addChild(RepetitionContainer repetitionContainer) {
        for (LayoutFieldObject layoutFieldObject : repetitionContainer.getRepetitionObjects().values()) {
            this.childs.add(layoutFieldObject);
            this.attachComponentAsNeeded(repetitionContainer.getWrappedObject());
        }
    }

    @Override
    public void addChild(LayoutObject layoutObject) {
        layoutObject.setParentComponent(this);
        this.childs.add(layoutObject);
        this.attachComponentAsNeeded(layoutObject.getWrappedObject());
        if (layoutObject instanceof HasGlassPane) {
            ((HasGlassPane)((Object)layoutObject)).setGlassPaneParent(this);
        }
    }

    public void setTab(TabSheet.Tab tab, String string) {
        this.tab = tab;
        this.mainTabStyleId = string;
        this.updateTabHeaderStyleName();
    }

    public void clearComponents() {
    }

    public void initComponents() {
        if (this.added) {
            return;
        }
        for (LayoutObject layoutObject : this.childs) {
            this.attachComponent(layoutObject.getWrappedObject());
        }
    }

    private void attachComponent(Component component) {
        this.addComponent(component);
        this.added = true;
    }

    private void attachComponentAsNeeded(Component component) {
        LayoutObject layoutObject = this.getParentComponent();
        if (layoutObject != null && layoutObject instanceof PanelContainerControl) {
            PanelContainerControl panelContainerControl = (PanelContainerControl)layoutObject;
            if (panelContainerControl.getMetaData().getSelectedPanelId() != -1) {
                if (panelContainerControl.getMetaData().getSelectedPanelId() == this.getMetaData().getObjectId()) {
                    this.attachComponent(component);
                }
            } else if (this.isDefaultPanel) {
                this.attachComponent(component);
            }
            this.attachComponent(component);
        } else if (this.isDefaultPanel) {
            this.attachComponent(component);
        }
    }

    public void refreshDependentUI() {
        ObjectMetaData objectMetaData = this.getMetaData();
        if (objectMetaData.hasMergeTooltip()) {
            this.app.getAppSession().getLayoutObjectTooltip(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    PanelContainerPanel.this.registerToolTip(Utilities.encodeHTML((String)object));
                }
            }, this.getAttributes().getObjectSpec());
        }
        if (objectMetaData.hasConditionalFormatting()) {
            this.app.getAppSession().getConditionalFormatting(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    LayoutObjectUtilities.updateCSSForConditionalFormatting(PanelContainerPanel.this.app, PanelContainerPanel.this, (CFObject)object);
                }
            }, this.getAttributes().getObjectSpec());
        }
    }

    @Override
    public void registerToolTip(String string) {
        if (this.getMetaData().getType() == LayoutObjectType.DOT_PANEL) {
            this.setDescription(string, ContentMode.HTML);
        }
        if (this.tab != null) {
            this.tab.setDescription(string, ContentMode.HTML);
        }
    }

    @Override
    public void addCFStyle(String string) {
        if (this.cfTabStyleNames == null) {
            this.cfTabStyleNames = new FastList();
        }
        this.cfTabStyleNames.add(string);
        this.updateTabHeaderStyleName();
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        if (this.cfTabStyleNames != null) {
            this.cfTabStyleNames.remove(string);
        }
        this.updateTabHeaderStyleName();
        this.removeStyleName(string);
    }

    @Override
    public void addChild(HiddenObject hiddenObject) {
        this.addComponent((Component)hiddenObject);
    }

    private void updateTabHeaderStyleName() {
        if (this.tab != null) {
            StringBuilder stringBuilder = new StringBuilder(this.mainTabStyleId);
            if (this.cfTabStyleNames != null) {
                for (String string : this.cfTabStyleNames) {
                    stringBuilder.append(" ").append(string);
                }
            }
            this.tab.setStyleName(stringBuilder.toString());
        }
    }
}

