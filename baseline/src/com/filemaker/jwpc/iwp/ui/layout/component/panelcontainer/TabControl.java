/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.TabSheet$Tab
 */
package com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.TabControlMetaData;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TabControlClientRPC;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import java.awt.FontMetrics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TabControl
extends PanelContainerControl {
    private TabControlMetaData metaData;
    private Map<Component, String> tabsCaptions;
    private FontMetrics fontMetrics;
    List<String> tabsStyle = null;

    public TabControl(App app, LayoutView layoutView, TabControlMetaData tabControlMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, tabControlMetaData, objectAttributes);
        this.metaData = tabControlMetaData;
        this.initUI();
    }

    private void initUI() {
        TabControl tabControl = this;
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)tabControl, null);
        this.fontMetrics = IWPUtilities.getFontMetrcs(this.metaData.getFontName(), this.metaData.IsFontBold(), this.metaData.IsFontItalic(), this.metaData.getFontSize());
    }

    public void attach() {
        this.setClientsideTabsStyle(this.tabsStyle);
        super.attach();
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    @Override
    public TabControlMetaData getMetaData() {
        return this.metaData;
    }

    @Override
    protected void refreshPosition() {
        ((TabControlClientRPC)this.getRpcProxy(TabControlClientRPC.class)).refreshPosition();
    }

    @Override
    protected void reapplyPosition() {
        this.setClientsideTabsStyle(this.tabsStyle);
    }

    @Override
    public synchronized void updateLayoutObjectData(Object object, boolean bl) {
        Map map;
        if (this.getMetaData().isTabWidthCalcNeeded() && (map = (Map)object) != null && !map.isEmpty()) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(map.size());
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int n = (Integer)iterator.next();
                String string = ((StringData)map.get(n)).getValue();
                hashMap.put(n, this.fontMetrics.stringWidth(string));
            }
            this.app.getAppSession().getTabWidthsAndStartPosition(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    TabControl.this.tabsStyle = (List)object;
                    TabControl.this.setClientsideTabsStyle(TabControl.this.tabsStyle);
                }
            }, this.getAttributes().getObjectSpec(), hashMap, this.getObjectId(), this.fontMetrics.getAscent(), this.fontMetrics.getDescent(), true);
        }
    }

    private void setClientsideTabsStyle(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ((TabControlClientRPC)this.getRpcProxy(TabControlClientRPC.class)).setTabsStyle(list);
        }
    }

    @Override
    protected void updateDynamicCation(TabSheet.Tab tab, Component component) {
        String string = this.getTabsCaption().get(component);
        if (tab != null && string != null) {
            tab.setCaption(string);
        }
    }

    synchronized void addTabsCaption(Component component, String string) {
        TabSheet.Tab tab = this.getTab(component);
        if (tab != null) {
            tab.setCaption(string);
        }
        this.getTabsCaption().put(component, string);
    }

    private Map<Component, String> getTabsCaption() {
        if (this.tabsCaptions == null) {
            this.tabsCaptions = new HashMap<Component, String>();
        }
        return this.tabsCaptions;
    }

    @Override
    public void registerAccTitle(String string) {
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

