/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.vaadin.client.ui.JavaScriptComponentConnector
 *  com.vaadin.client.ui.button.ButtonConnector
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.client.ui.customlayout.CustomLayoutConnector
 *  com.vaadin.client.ui.image.ImageConnector
 *  com.vaadin.client.ui.orderedlayout.HorizontalLayoutConnector
 *  com.vaadin.client.ui.orderedlayout.VerticalLayoutConnector
 *  com.vaadin.client.ui.ui.UIConnector
 *  com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.shared.ui.Connect$LoadStyle
 *  com.vaadin.v7.client.ui.combobox.ComboBoxConnector
 *  com.vaadin.v7.client.ui.label.LabelConnector
 *  com.vaadin.v7.client.ui.textfield.TextFieldConnector
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.jwpc.iwp.widgetset.client.connector.EditBoxConnector;
import com.filemaker.jwpc.iwp.widgetset.client.connector.FMCommunicationConnector;
import com.filemaker.jwpc.iwp.widgetset.client.connector.ObscuredEditBoxConnector;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.vaadin.client.ui.JavaScriptComponentConnector;
import com.vaadin.client.ui.button.ButtonConnector;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.client.ui.customlayout.CustomLayoutConnector;
import com.vaadin.client.ui.image.ImageConnector;
import com.vaadin.client.ui.orderedlayout.HorizontalLayoutConnector;
import com.vaadin.client.ui.orderedlayout.VerticalLayoutConnector;
import com.vaadin.client.ui.ui.UIConnector;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.combobox.ComboBoxConnector;
import com.vaadin.v7.client.ui.label.LabelConnector;
import com.vaadin.v7.client.ui.textfield.TextFieldConnector;
import java.util.HashSet;
import java.util.Set;

public class MyConnectorBundleLoaderFactory
extends ConnectorBundleLoaderFactory {
    private Set<String> eagerConnectors = new HashSet<String>();

    public MyConnectorBundleLoaderFactory() {
        this.eagerConnectors.add(UIConnector.class.getName());
        this.eagerConnectors.add(CustomLayoutConnector.class.getName());
        this.eagerConnectors.add(TextFieldConnector.class.getName());
        this.eagerConnectors.add(CssLayoutConnector.class.getName());
        this.eagerConnectors.add(ImageConnector.class.getName());
        this.eagerConnectors.add(LabelConnector.class.getName());
        this.eagerConnectors.add(VerticalLayoutConnector.class.getName());
        this.eagerConnectors.add(JavaScriptComponentConnector.class.getName());
        this.eagerConnectors.add(HorizontalLayoutConnector.class.getName());
        this.eagerConnectors.add(FMCommunicationConnector.class.getName());
        this.eagerConnectors.add(ButtonConnector.class.getName());
        this.eagerConnectors.add(EditBoxConnector.class.getName());
        this.eagerConnectors.add(ObscuredEditBoxConnector.class.getName());
        this.eagerConnectors.add(ComboBoxConnector.class.getName());
    }

    protected Connect.LoadStyle getLoadStyle(JClassType jClassType) {
        Connect connect = (Connect)jClassType.getAnnotation(Connect.class);
        Connect.LoadStyle loadStyle = connect.loadStyle();
        if (loadStyle == Connect.LoadStyle.LAZY) {
            return loadStyle;
        }
        if (this.eagerConnectors.contains(jClassType.getQualifiedBinaryName())) {
            return Connect.LoadStyle.EAGER;
        }
        return Connect.LoadStyle.DEFERRED;
    }
}

