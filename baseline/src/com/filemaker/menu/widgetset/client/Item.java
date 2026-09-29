/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.menu.widgetset.client;

import java.io.Serializable;
import java.util.ArrayList;

public class Item
implements Serializable {
    public int id;
    public String text;
    public boolean checkable;
    public boolean checked;
    public boolean enabled = true;
    public boolean visible = true;
    public String styleName;
    public ArrayList<Item> subItems = new ArrayList();
    public String iconURL;

    public Item() {
    }

    public Item(int n) {
        this.id = n;
    }
}

