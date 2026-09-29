/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbstractLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.component.BottomNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.Footer;
import com.filemaker.jwpc.iwp.ui.layout.component.Header;
import com.filemaker.jwpc.iwp.ui.layout.component.LeadingGrandSum;
import com.filemaker.jwpc.iwp.ui.layout.component.LeadingSubSum;
import com.filemaker.jwpc.iwp.ui.layout.component.TitleFooter;
import com.filemaker.jwpc.iwp.ui.layout.component.TitleHeader;
import com.filemaker.jwpc.iwp.ui.layout.component.TopNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.TrailingGrandSum;
import com.filemaker.jwpc.iwp.ui.layout.component.TrailingSubSum;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.LayoutPartClientRPC;
import com.filemaker.jwpc.iwp.widgetset.client.state.LayoutPartState;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import java.util.Collection;

public abstract class LayoutPart
extends AbstractLayout {
    private PartObjectsModel objectsModel;
    protected AbstractComponent selfComponent = null;
    private final LayoutView layoutView;

    public LayoutPart(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, objectMetaData, objectAttributes);
        this.layoutView = layoutView;
        this.objectsModel = new PartObjectsModel();
        this.initUI();
    }

    public void initUI() {
        this.selfComponent = this;
        if (this.layoutView.isClientSideAutoSizing()) {
            this.addStyleName("fm-absolute");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("min-width:").append(this.metaData.getMinWidthAsInt()).append("px;");
            LayoutObjectType layoutObjectType = this.getPartType();
            if (layoutObjectType == LayoutObjectType.BODY && this.layoutView.getLayoutMetaData().layoutVerticalAutoSizing()) {
                this.setHeight(-1.0f, Sizeable.Unit.PIXELS);
                stringBuilder.append("min-height:").append(this.metaData.getMinHeightAsInt()).append("px;");
            } else {
                this.setHeight(this.metaData.getHeight());
            }
            switch (layoutObjectType) {
                case TITLE_HEADER: 
                case HEADER: 
                case LEADING_GRAND_SUM: 
                case LEADING_SUB_SUM: {
                    stringBuilder.append("top:").append(this.metaData.getTopAsInt()).append("px;");
                    break;
                }
                case BODY: {
                    stringBuilder.append("top:").append(this.metaData.getTopAsInt()).append("px;").append("bottom:").append(this.metaData.getBottomAsInt()).append("px;");
                    break;
                }
                case TRAILING_SUB_SUM: 
                case TRAILING_GRAND_SUM: 
                case FOOTER: 
                case TITLE_FOOTER: {
                    int n = this.metaData.getBottomAsInt();
                    if (this.layoutView.getLayoutMetaData().layoutVerticalAutoSizing()) {
                        int n2;
                        int n3 = this.app.getBrowserInfoHandler().getContentHeight();
                        if (n3 < (n2 = this.layoutView.getLayoutMetaData().getMinHeightAsInt())) {
                            n += n3 - n2;
                        }
                        this.setLayoutAndPartInfo();
                    }
                    stringBuilder.append("bottom:").append(n).append("px;");
                    break;
                }
            }
            this.getState().style = stringBuilder.toString();
        } else {
            this.removeStyleName("fm-absolute");
            this.setHeight(this.metaData.getHeight());
            if (this.metaData.getType() != LayoutObjectType.TOP_NAV_PART && this.metaData.getType() != LayoutObjectType.BOTTOM_NAV_PART) {
                this.setWidth(this.metaData.getParent().getWidth());
            }
        }
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, null);
    }

    public LayoutPartState getState() {
        return (LayoutPartState)super.getState();
    }

    @Override
    public void cleanupMemory() {
        super.cleanupMemory();
        this.objectsModel.clear();
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    public LayoutObjectType getPartType() {
        return this.metaData.getType();
    }

    public PartObjectsModel getPartObjectsModel() {
        return this.objectsModel;
    }

    public void setObjectsModel(PartObjectsModel partObjectsModel) {
        this.objectsModel = partObjectsModel;
    }

    @Override
    public LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        return this.getLayoutObject(objectSpec, false);
    }

    public LayoutObject getLayoutObject(ObjectSpec objectSpec, boolean bl) {
        PopoverWindow popoverWindow = this.app.getLayoutContainer().getPopoverWindow();
        return this.objectsModel.getLayoutObject(popoverWindow, objectSpec, bl);
    }

    public Collection<LayoutObject> getLayoutObjects() {
        return this.objectsModel.getLayoutObjects();
    }

    public static Class getPartClass(LayoutObjectType layoutObjectType) {
        switch (layoutObjectType) {
            case TOP_NAV_PART: {
                return TopNavigation.class;
            }
            case TITLE_HEADER: {
                return TitleHeader.class;
            }
            case HEADER: {
                return Header.class;
            }
            case LEADING_GRAND_SUM: {
                return LeadingGrandSum.class;
            }
            case LEADING_SUB_SUM: {
                return LeadingSubSum.class;
            }
            case BODY: {
                return Body.class;
            }
            case TRAILING_SUB_SUM: {
                return TrailingSubSum.class;
            }
            case TRAILING_GRAND_SUM: {
                return TrailingGrandSum.class;
            }
            case FOOTER: {
                return Footer.class;
            }
            case TITLE_FOOTER: {
                return TitleFooter.class;
            }
            case BOTTOM_NAV_PART: {
                return BottomNavigation.class;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasHideCondition() {
        return false;
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return false;
    }

    @Override
    public boolean isHideConditionOn() {
        return false;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
    }

    @Override
    public void addCFStyle(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeCFStyle(String string) {
        throw new UnsupportedOperationException();
    }

    public void setHeight(String string) {
        super.setHeight(string);
    }

    public void setMinHeight(int n) {
        ((LayoutPartClientRPC)this.getRpcProxy(LayoutPartClientRPC.class)).setMinHeight(n);
    }

    private void setLayoutAndPartInfo() {
        ((LayoutPartClientRPC)this.getRpcProxy(LayoutPartClientRPC.class)).setLayoutAndPartInfo(this.layoutView.getLayoutMetaData().getMinHeightAsInt(), this.metaData.getBottomAsInt());
    }
}

