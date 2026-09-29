/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.HierarchicalNamesModel;
import com.filemaker.jwpc.iwp.model.SortState;
import com.filemaker.jwpc.iwp.thrift.common.ScriptState;
import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import com.filemaker.jwpc.iwp.thrift.common.ToolbarStatusAreaState;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.MenubarStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ReloginNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptNamesChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ScriptStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.SortDialogNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ToolbarStatusAreaStateChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowChangeNotification;
import com.filemaker.jwpc.iwp.xml.XmlHierarchicalNamesGenerator;
import java.util.List;

public class DatabaseDataModel {
    private List<HierarchicalNamesModel> layoutNames;
    private List<HierarchicalNamesModel> scriptNames;
    private final SortState sortState;
    private ScriptState scriptState;
    private ToolbarStatusAreaState statusareaState;
    private boolean menubarVisible;

    public DatabaseDataModel(App app) {
        this.sortState = new SortState(app);
        this.scriptState = ScriptState.EXIT;
        this.statusareaState = new ToolbarStatusAreaState(true, false);
        this.menubarVisible = true;
    }

    public void update(LayoutNamesChangeNotification layoutNamesChangeNotification) {
        this.layoutNames = XmlHierarchicalNamesGenerator.processNames(layoutNamesChangeNotification.getLayoutNames().getHierarchicalNamesXml());
    }

    public void update(ScriptNamesChangeNotification scriptNamesChangeNotification) {
        this.scriptNames = XmlHierarchicalNamesGenerator.processNames(scriptNamesChangeNotification.getScriptNames().getHierarchicalNamesXml());
    }

    public void update(ScriptStateChangeNotification scriptStateChangeNotification) {
        this.scriptState = scriptStateChangeNotification.getScriptState();
    }

    public SortState getSortState() {
        return this.sortState;
    }

    public void update(LayoutNotification layoutNotification) {
        this.layoutNames = XmlHierarchicalNamesGenerator.processNames(layoutNotification.getLayoutNames().getHierarchicalNamesXml());
        this.scriptNames = XmlHierarchicalNamesGenerator.processNames(layoutNotification.getScriptNames().getHierarchicalNamesXml());
    }

    public void update(ReloginNotification reloginNotification) {
        this.layoutNames = XmlHierarchicalNamesGenerator.processNames(reloginNotification.getLayoutNames().getHierarchicalNamesXml());
        this.scriptNames = XmlHierarchicalNamesGenerator.processNames(reloginNotification.getScriptNames().getHierarchicalNamesXml());
    }

    public void update(WindowChangeNotification windowChangeNotification) {
        this.layoutNames = XmlHierarchicalNamesGenerator.processNames(windowChangeNotification.getLayoutNames().getHierarchicalNamesXml());
        this.scriptNames = XmlHierarchicalNamesGenerator.processNames(windowChangeNotification.getScriptNames().getHierarchicalNamesXml());
    }

    public void update(SortDialogNotification sortDialogNotification) {
        this.updateSortQueries(sortDialogNotification.getQueries());
    }

    public void updateSortQueries(List<SortQuery> list) {
        this.sortState.addSortQueries(list);
    }

    public void update(MenubarStateChangeNotification menubarStateChangeNotification) {
        this.menubarVisible = menubarStateChangeNotification.isVisible();
    }

    public void update(ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) {
        this.statusareaState = toolbarStatusAreaStateChangeNotification.getToolbarStatusareaState();
    }

    public void updateToolbarsVisiblity(boolean bl, boolean bl2) {
        this.statusareaState.setShow(bl);
        this.menubarVisible = bl2;
    }

    public List<HierarchicalNamesModel> getLayoutNames() {
        return this.layoutNames;
    }

    public List<HierarchicalNamesModel> getScriptNames() {
        return this.scriptNames;
    }

    public boolean isScriptInExecutingState() {
        return this.isScriptPaused() || this.isScriptRunning();
    }

    public boolean isScriptPaused() {
        return this.scriptState == ScriptState.PAUSE;
    }

    public boolean isScriptRunning() {
        return this.scriptState == ScriptState.RESUME;
    }

    public ScriptState getScriptState() {
        return this.scriptState;
    }

    public List<SortQuery> getSortQueries() {
        return this.sortState.getSortQueries();
    }

    public ToolbarStatusAreaState getToolbarStatusAreaState() {
        return this.statusareaState;
    }

    public boolean isMenubarVisible() {
        return this.menubarVisible;
    }
}

