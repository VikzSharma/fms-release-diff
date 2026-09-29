/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Resource
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.Embedded
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.Label;

public class MobileTouchControl
extends CssLayout {
    private Type type = Type.NONE;
    private Label text = null;
    private Label leftIcon = null;
    private Label rightIcon = null;
    private int customId = 0;
    private Object data = null;
    private Embedded leftIconImage = null;
    private static final String LIST_STYLE = "fm-touch-list";
    private static final String LIST_ITEM_STYLE = "fm-touch-list-item";
    private static final String CONTAINER_STYLE = "fm-touch-container";
    private static final String LABEL_STYLE = "fm-touch-label";
    private static final String BUTTON_STYLE = "fm-touch-button";
    private static final String TEXT_BUTTON_STYLE = "fm-touch-text-button";
    private static final String DISABLED_STYLE = "fm-touch-disabled";
    private static final String NOWRAP_LABEL_STYLE = "nowrap-label";
    private static final String WRAP_LABEL_STYLE = "wrap-label";
    private static final String CONTROL_BORDER_STYLE = "fm-touch-control-border";
    private static final String LEFT_ICON_STYLE = "left-icon";
    private static final String RIGHT_ICON_STYLE = "right-icon";
    private static final String RIGHT_ITEM_STYLE = "right-item";

    public MobileTouchControl(Type type) {
        this.type = type;
        boolean bl = true;
        String string = null;
        if (type != Type.NONE) {
            if (type == Type.LIST) {
                string = LIST_STYLE;
            } else if (type == Type.CONTAINER) {
                string = CONTAINER_STYLE;
            } else {
                this.text = new Label();
                this.text.setContentMode(ContentMode.HTML);
                this.text.setStyleName("text");
                this.text.addStyleName(NOWRAP_LABEL_STYLE);
                this.addComponent((Component)this.text);
                if (type == Type.LABEL) {
                    string = LABEL_STYLE;
                } else if (type == Type.BUTTON) {
                    string = BUTTON_STYLE;
                } else if (type == Type.TEXT_BUTTON) {
                    string = TEXT_BUTTON_STYLE;
                    bl = false;
                } else if (type == Type.LIST_ITEM) {
                    string = LIST_ITEM_STYLE;
                }
            }
        }
        this.setStyleName(string);
        if (bl) {
            this.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        } else {
            this.setSizeUndefined();
        }
    }

    public void copyFrom(MobileTouchControl mobileTouchControl) {
        this.customId = mobileTouchControl.customId;
        this.setText(mobileTouchControl.getText());
        this.setData(mobileTouchControl.getData());
    }

    public void setData(Object object) {
        this.data = object;
    }

    public Object getData() {
        return this.data;
    }

    protected String getCss(Component component) {
        return null;
    }

    public Type getType() {
        return this.type;
    }

    public void setText(String string) {
        if (this.text != null) {
            this.text.setValue(string);
        }
    }

    public String getText() {
        if (this.text != null) {
            return this.text.getValue();
        }
        return null;
    }

    public void setTextColor(String string) {
        this.addStyleName(string);
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        if (bl) {
            this.removeStyleName(DISABLED_STYLE);
        } else {
            this.addStyleName(DISABLED_STYLE);
        }
    }

    public void setCustomId(int n) {
        this.customId = n;
    }

    public int getCustomId() {
        return this.customId;
    }

    public void setHasBorder() {
        if (this.type == Type.LABEL || this.type == Type.BUTTON) {
            this.addStyleName(CONTROL_BORDER_STYLE);
        }
    }

    public void setLeftIconAsResource(String string) {
        if (this.leftIconImage != null) {
            this.removeComponent((Component)this.leftIconImage);
            this.leftIconImage = null;
        }
        ThemeResource themeResource = new ThemeResource("images/" + string);
        this.leftIconImage = new Embedded(null, (Resource)themeResource);
        this.leftIconImage.setStyleName(LEFT_ICON_STYLE);
        this.addComponentAsFirst((Component)this.leftIconImage);
    }

    public void setLeftIcon(String string) {
        if (this.leftIcon != null) {
            this.removeComponent((Component)this.leftIcon);
            this.leftIcon = null;
        }
        this.leftIcon = new Label();
        this.leftIcon.setContentMode(ContentMode.HTML);
        this.leftIcon.setWidth(1.0f, Sizeable.Unit.EM);
        this.leftIcon.setStyleName(LEFT_ICON_STYLE);
        this.leftIcon.addStyleName(string);
        this.addComponent((Component)this.leftIcon);
    }

    public void setRightIcon(String string) {
        if (this.rightIcon != null) {
            this.removeComponent((Component)this.rightIcon);
            this.rightIcon = null;
        }
        this.rightIcon = new Label();
        this.rightIcon.setContentMode(ContentMode.HTML);
        this.rightIcon.setWidth(1.0f, Sizeable.Unit.EM);
        this.rightIcon.setStyleName(RIGHT_ICON_STYLE);
        this.rightIcon.addStyleName(string);
        this.addComponent((Component)this.rightIcon);
    }

    public void addLabelRightItem(MobileTouchControl mobileTouchControl) {
        if (this.type == Type.LABEL) {
            mobileTouchControl.setSizeUndefined();
            this.addComponent((Component)mobileTouchControl);
            this.addStyleName(RIGHT_ITEM_STYLE);
        }
    }

    public void setTextWrap(boolean bl) {
        if (this.text != null) {
            if (bl) {
                this.text.removeStyleName(NOWRAP_LABEL_STYLE);
                this.text.addStyleName(WRAP_LABEL_STYLE);
            } else {
                this.text.removeStyleName(WRAP_LABEL_STYLE);
                this.text.addStyleName(NOWRAP_LABEL_STYLE);
            }
        }
    }

    public static enum Type {
        NONE,
        LABEL,
        BUTTON,
        TEXT_BUTTON,
        LIST,
        LIST_ITEM,
        CONTAINER;

    }
}

