/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.Label;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SegmentedBar
extends CssLayoutObject
implements LayoutContainerObject,
UIEventListener {
    private LayoutView view;
    private List<LayoutObject> childs = new ArrayList<LayoutObject>();
    private List<Label> dividers = new ArrayList<Label>();
    private int prevNumOfSegment = 0;

    public SegmentedBar(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.view = layoutView;
        this.initUI();
        this.view.getUIEventBus().subscribe(this, EventType.CACHED_LAYOUT_RENDERED);
    }

    private void initUI() {
        SegmentedBar segmentedBar = this;
        segmentedBar.setWidth(this.metaData.getWidth());
        segmentedBar.setHeight(this.metaData.getHeight());
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)segmentedBar, null);
        ArrayList<String> arrayList = this.metaData.getCustomStyles();
        if (arrayList != null && !this.metaData.hasLocalStyles()) {
            this.addStyleName(this.metaData.getUniqueObjectSelector());
        }
    }

    @Override
    public void cleanupMemory() {
        if (this.childs != null) {
            for (LayoutObject layoutObject : this.childs) {
                layoutObject.cleanupMemory();
            }
            this.childs.clear();
            this.childs = null;
        }
        this.prevNumOfSegment = 0;
        this.removeDividersIfNeeded();
        if (this.view != null) {
            if (this.view.getUIEventBus() != null) {
                this.view.getUIEventBus().unsubscribe(this, EventType.CACHED_LAYOUT_RENDERED);
            }
            this.view = null;
        }
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    @Override
    public void addChild(RepetitionContainer repetitionContainer) {
        this.addComponent(repetitionContainer.getWrappedObject());
        for (LayoutFieldObject layoutFieldObject : repetitionContainer.getRepetitionObjects().values()) {
            this.childs.add(layoutFieldObject);
            ++this.prevNumOfSegment;
        }
    }

    @Override
    public void addChild(LayoutObject layoutObject) {
        layoutObject.setParentComponent(this);
        this.addComponent(layoutObject.getWrappedObject());
        if (layoutObject instanceof HasGlassPane) {
            ((HasGlassPane)((Object)layoutObject)).setGlassPaneParent(this);
        }
        this.childs.add(layoutObject);
        ++this.prevNumOfSegment;
    }

    @Override
    public Collection<LayoutObject> getChilds() {
        return this.childs;
    }

    @Override
    public void addCFStyle(String string) {
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
        if (bl) {
            this.removeDividersIfNeeded();
        }
    }

    private void removeDividersIfNeeded() {
        if (this.dividers != null) {
            for (Label label : this.dividers) {
                this.removeComponent((Component)label);
            }
            this.dividers.clear();
        }
    }

    public void rebuildSegmentsIfNeeded() {
        if (this.isHideConditionOn()) {
            return;
        }
        int n = 0;
        boolean bl = false;
        for (LayoutObject layoutObject : this.childs) {
            if (!(layoutObject instanceof Button)) continue;
            if (!((Button)layoutObject).isHideConditionOn()) {
                ++n;
                continue;
            }
            bl = true;
        }
        if (n == 0) {
            this.getWrappedObject().setVisible(false);
            return;
        }
        this.getWrappedObject().setVisible(true);
        boolean bl2 = true;
        boolean bl3 = false;
        boolean bl4 = true;
        if (n == this.prevNumOfSegment) {
            if (this.dividers.size() == n - 1) {
                bl3 = true;
            }
            if (!this.getMetaData().hasAutoSizingObjects() && !bl) {
                bl2 = false;
            }
            bl4 = false;
        }
        this.prevNumOfSegment = n;
        if (!bl3) {
            this.removeDividersIfNeeded();
        }
        Rectangle rectangle = this.metaData.getSegmentedBarBounds();
        boolean bl5 = this.metaData.isSegmentedBarVertical();
        int n2 = (int)rectangle.getWidth();
        int n3 = (int)rectangle.getHeight();
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        Rectangle rectangle2 = this.metaData.getSegmentedDividerBounds();
        if (rectangle2 != null) {
            n4 = bl5 ? (int)rectangle2.getHeight() : (int)rectangle2.getWidth();
            n5 = (int)rectangle2.getX();
            n6 = (int)rectangle2.getY();
        }
        int n7 = bl5 ? n3 / n : n2 / n;
        int n8 = bl5 ? n3 % n : n2 % n;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = n10;
        int n13 = n11;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        for (LayoutObject layoutObject : this.childs) {
            int n18;
            Button button;
            if (!(layoutObject instanceof Button) || (button = (Button)layoutObject).isHideConditionOn()) continue;
            int n19 = n7 + (n8 > 0 ? 1 : 0);
            int n20 = n18 = n9 == 0 ? 0 : n19;
            if (bl5) {
                n3 = n19;
                if (bl2 && n9 > 0 && (n11 += n18) < n17) {
                    n11 = n17;
                }
                n17 = n11 + n3;
            } else {
                n2 = n19;
                if (bl2 && n9 > 0 && (n10 += n18) < n17) {
                    n10 = n17;
                }
                n17 = n10 + n2;
            }
            if (bl2) {
                button.rebuild(n10, n11, n2, n3);
            } else if (bl3) {
                button.resizeGlyph(n10, n11, n2, n3, bl4);
            }
            if (!bl3 && n9 > 0) {
                n12 = n10 - 1;
                n13 = n11;
                n14 = n2;
                n15 = n3;
                n16 = n4 / 2;
                if (bl5) {
                    n13 -= n16;
                    n12 += n5;
                    n14 = (int)rectangle.getWidth() - (n5 + n6);
                    n15 = n4;
                } else {
                    n12 -= n16;
                    n13 += n5;
                    n14 = n4;
                    n15 = (int)rectangle.getHeight() - (n5 + n6);
                }
                String string = String.format("<div class=\"%s\" style=\"position:absolute;left:%dpx;top:%dpx;width:%dpx;height:%dpx;\"></div>", bl5 ? "button_bar_divider_v" : "button_bar_divider_h", n12, n13, n14, n15);
                Label label = new Label(string, ContentMode.HTML);
                this.addComponent((Component)label);
                this.dividers.add(label);
            }
            --n8;
            ++n9;
        }
    }

    public void setActiveSegment(LayoutObject layoutObject) {
        if (this.childs != null && !this.childs.isEmpty()) {
            for (LayoutObject layoutObject2 : this.childs) {
                if (!(layoutObject2 instanceof Button)) continue;
                ((Button)layoutObject2).setAsActiveSegment(false);
            }
        }
        if (layoutObject != null) {
            ((Button)layoutObject).setAsActiveSegment(true);
        }
    }

    public boolean hasActiveSegment() {
        for (LayoutObject layoutObject : this.childs) {
            if (!(layoutObject instanceof Button) || !((Button)layoutObject).isCurrentActiveSegment()) continue;
            return true;
        }
        return false;
    }

    public boolean isCurrentActiveSegmentDefault() {
        for (LayoutObject layoutObject : this.childs) {
            Button button;
            if (!(layoutObject instanceof Button) || !(button = (Button)layoutObject).isCurrentActiveSegment() || !button.isDefaultActiveSegment()) continue;
            return true;
        }
        return false;
    }

    public boolean hasHiddenSegment() {
        for (LayoutObject layoutObject : this.childs) {
            if (!(layoutObject instanceof Button) || ((Button)layoutObject).isHideConditionOn()) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case CACHED_LAYOUT_RENDERED: {
                if (uIEvent.getType() == EventType.ROW_SELECTION_CHANGE && this.app.isListView() || this.isCurrentActiveSegmentDefault()) break;
                this.setActiveSegment(null);
                break;
            }
        }
    }

    @Override
    public void addChild(HiddenObject hiddenObject) {
        this.addComponent((Component)hiddenObject);
    }
}

