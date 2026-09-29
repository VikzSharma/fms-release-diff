/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NodeList
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPanelContainerControl;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import java.util.List;

public class VCustomTabControl
extends VCustomPanelContainerControl {
    public void setTabsStyle(List<String> list) {
        NodeList nodeList = this.tabs.getElementsByTagName("td");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element;
            Object object;
            String string;
            String string2;
            Element element2 = (Element)nodeList.getItem(i);
            if (element2 == null) continue;
            String string3 = list.get(i);
            if (i == 0 && string3.indexOf("padding-left:") == 0) {
                int n = string3.indexOf(";");
                string2 = string3.substring(0, n + 1);
                string = element2.getAttribute("style");
                object = this.updateStyle(string, string2, "padding-left:", ";");
                element2.setAttribute("style", (String)object);
                string3 = string3.substring(n + 1, string3.length());
            }
            if ((element = element2.getFirstChildElement()) == null) continue;
            string2 = element.getAttribute("style");
            string = this.updateStyle(string2, string3, "width:", ";");
            element.setAttribute("style", string);
            object = element.getFirstChildElement();
            if (object == null) continue;
            String string4 = object.getAttribute("style");
            String string5 = this.updateStyle(string4, string3, "width:", ";");
            object.setAttribute("style", string5);
        }
    }

    private String updateStyle(String string, String string2, String string3, String string4) {
        if (string == null || string.trim().length() == 0) {
            return string2;
        }
        int n = string.indexOf(string3);
        if (n < 0) {
            return string2;
        }
        int n2 = string.indexOf(string4, n);
        if (n2 <= 0) {
            return string + string2;
        }
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.replace(n, n2 + string4.length(), string2);
        return stringBuffer.toString();
    }
}

