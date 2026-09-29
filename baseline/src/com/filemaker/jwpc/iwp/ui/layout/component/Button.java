/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.NativeButton
 *  org.apache.commons.lang3.StringUtils
 *  org.jsoup.Jsoup
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.common.CommonUtilities;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ButtonState;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.NativeButton;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

public class Button
extends NativeButton
implements LayoutObject,
HasGlassPane {
    private final App app;
    private final LayoutView layoutView;
    private LayoutObject parent;
    protected ObjectMetaData metaData;
    private final ObjectAttributes attributes;
    private boolean hideConditionOn = false;
    protected AbstractComponent selfComponent = null;
    protected GlassPaneHandler glassPaneHandler;
    private boolean isActiveSegment = false;
    private int singleLineHeight = 10;
    private boolean useAriaCompliantControl = AppServlet.isAriaCompliantControlEnabled();

    public Button(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(objectMetaData.getName());
        Object object;
        this.setPrimaryStyleName("fm-widget");
        this.app = app;
        this.layoutView = layoutView;
        this.setHtmlContentAllowed(true);
        this.metaData = objectMetaData;
        this.attributes = objectAttributes;
        if (objectMetaData.useHandCursor()) {
            this.addStyleName("hand-cursor");
        }
        if (this.useAriaCompliantControl) {
            object = this.getButtonLabelFromHTML(objectMetaData.getName());
            this.setAriaLabel((String)object);
        }
        this.setSizeFull();
        this.initUI();
        this.registerButtonRpc();
        object = IWPUtilities.getFontMetrcs(objectMetaData.getFontName(), objectMetaData.IsFontBold(), objectMetaData.IsFontItalic(), objectMetaData.getFontSize());
        Rectangle2D rectangle2D = ((FontMetrics)object).getStringBounds("button", null);
        this.singleLineHeight = (int)rectangle2D.getHeight();
    }

    protected void initUI() {
        this.selfComponent = new LOWrapper(this, this.getMetaData().getPositionCss());
        LayoutObjectUtilities.setWidthAndHeight(this.layoutView.isClientSideAutoSizing(), this.metaData, (Component)this.selfComponent, null);
        this.addStyleName("text");
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, (AbstractComponent)this);
    }

    @Override
    public void cleanupMemory() {
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.cleanupMemory();
            this.glassPaneHandler = null;
        }
    }

    public String getButtonLabelFromHTML(String string) {
        String string2 = null;
        if (string != null && string.contains("fm-text-character")) {
            string2 = Jsoup.parse((String)string).text();
        }
        return string2 != null ? string2 : IWPI18N.get(this.app, "BUTTON_ARIA_LABEL", new Object[0]);
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    @Override
    public int getObjectId() {
        return this.metaData.getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.getId();
    }

    @Override
    public void updateUniqueId() {
        this.setId(IWPUtilities.generateUniqueId(this.app, this));
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.metaData;
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    public void setCaption(String string) {
        if (string == null) {
            super.setCaption(null);
            return;
        }
        if (!string.isEmpty() && this.selfComponent != null && this.metaData.isSegmentedObject() && this.isVisible()) {
            string = this.ResizeCaptionIfNeeded(string);
        }
        String string2 = IWPUtilities.convertSpacesToNbsp(string);
        string2 = string2.replaceAll("&#9;", "&nbsp;&nbsp;&nbsp;&nbsp;");
        super.setCaption(string2);
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        NonFieldObjectData nonFieldObjectData = (NonFieldObjectData)object;
        if (this.metaData.isSegmentedObject()) {
            this.isActiveSegment = nonFieldObjectData.isButtonBarActiveSegment();
            if (!this.isHideConditionOn()) {
                boolean bl2 = ((SegmentedBar)this.parent).getMetaData().isSegmentedBarCalc();
                if (this.isActiveSegment) {
                    if (bl2 || !((SegmentedBar)this.parent).hasActiveSegment()) {
                        ((SegmentedBar)this.parent).setActiveSegment(this);
                    }
                } else if (bl2 && this.isCurrentActiveSegment()) {
                    this.setAsActiveSegment(false);
                }
            }
            if (this.useAriaCompliantControl) {
                String string = this.getButtonLabelFromHTML(nonFieldObjectData.getData().getStringValue().getValue());
                this.setAriaLabel(string);
            }
        }
        this.setCaption(nonFieldObjectData.getData().getStringValue().getValue());
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
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
        if (this.metaData.isSegmentedObject() && this.hideConditionOn != bl && this.parent != null) {
            this.hideConditionOn = bl;
            ((SegmentedBar)this.parent).rebuildSegmentsIfNeeded();
            if (this.isCurrentActiveSegment() && bl) {
                this.setAsActiveSegment(false);
            }
        }
        this.hideConditionOn = bl;
        if (this.glassPaneHandler != null) {
            this.glassPaneHandler.updateGlassPane();
        }
    }

    @Override
    public void addCFStyle(String string) {
        this.selfComponent.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.selfComponent.removeStyleName(string);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        if (this.glassPaneHandler == null) {
            this.glassPaneHandler = new GlassPaneHandler(this, absoluteCssLayout);
        }
        this.glassPaneHandler.updateGlassPane();
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return !this.getMetaData().hasValidAndExecutableScript();
    }

    public ButtonState getState() {
        return (ButtonState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        boolean bl2;
        super.beforeClientResponse(bl);
        this.getState().glyphPos = this.metaData.getGlyphPosition();
        this.getState().singleLineHeight = this.singleLineHeight;
        this.updateBooleanState(ButtonState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateBooleanState(ButtonState.BooleanState.isSegmentedObject, this.metaData.isSegmentedObject());
        if (this.parent instanceof SegmentedBar && this.metaData.isSegmentedObject()) {
            this.updateBooleanState(ButtonState.BooleanState.hasAutoResize, ((SegmentedBar)this.parent).metaData.hasAutoSizingObjects());
            this.updateBooleanState(ButtonState.BooleanState.isSegmentedBarVertical, ((SegmentedBar)this.parent).getMetaData().isSegmentedBarVertical());
        }
        if (bl2 = this.layoutView.isClientSideAutoSizing()) {
            this.updateBooleanState(ButtonState.BooleanState.CLIENT_SIDE_AUTO_SIZING, bl2);
        }
    }

    private void updateBooleanState(ButtonState.BooleanState booleanState, boolean bl) {
        this.getState().bnbs = IWPUtilities.applyBooleanValue(this.getState().bnbs, booleanState.ordinal(), bl);
    }

    protected void registerButtonRpc() {
        ButtonServerRpc buttonServerRpc = new ButtonServerRpc(){

            @Override
            public void send(int n, int n2) {
                Button.this.OnServerRpcSend(n, n2);
            }

            @Override
            public void click() {
                Button.this.performClick();
            }
        };
        this.registerRpc(buttonServerRpc);
    }

    public void OnServerRpcSend(int n, int n2) {
    }

    public void rebuild(int n, int n2, int n3, int n4) {
        if (!(this.parent instanceof SegmentedBar)) {
            return;
        }
        LOWrapper lOWrapper = (LOWrapper)this.selfComponent;
        String string = lOWrapper.getPositionCss();
        String string2 = StringUtils.substringBetween((String)string, (String)"left:", (String)"px;");
        String string3 = StringUtils.substringBetween((String)string, (String)"top:", (String)"px;");
        int n5 = string2 == null ? 0 : Integer.parseInt(string2);
        int n6 = string3 == null ? 0 : Integer.parseInt(string3);
        boolean bl = false;
        if (this.isVisible() && n3 > 0 && n4 > 0) {
            if (this.selfComponent.getWidth() != (float)n3 || this.selfComponent.getHeight() != (float)n4) {
                this.selfComponent.setWidth(Double.toString(n3) + "px");
                this.selfComponent.setHeight(Double.toString(n4) + "px");
                this.setWidth(Double.toString(n3) + "px");
                this.setHeight(Double.toString(n4) + "px");
                this.ResizeCaptionIfNeeded(null);
                if (this.glassPaneHandler != null) {
                    this.glassPaneHandler.resizeGlassPane(n3, n4);
                }
                bl = true;
            }
            if (n5 != n || n6 != n2) {
                string = CommonUtilities.updateStyle(string, "left:" + Integer.toString(n) + "px;", "left:", "px;");
                string = CommonUtilities.updateStyle(string, "top:" + Integer.toString(n2) + "px;", "top:", "px;");
                lOWrapper.setPositionCss(string);
                if (this.glassPaneHandler != null) {
                    this.glassPaneHandler.repositionGlassPane(n, n2);
                }
                bl = true;
            }
            if (bl) {
                ((ButtonClientRpc)this.getRpcProxy(ButtonClientRpc.class)).updateBounds(n, n2, n3 -= this.metaData.getLeftBorderWidthAsInt() + this.metaData.getRightBorderWidthAsInt(), n4 -= this.metaData.getTopBorderWidthAsInt() + this.metaData.getBottomBorderWidthAsInt(), true, ((SegmentedBar)this.parent).getMetaData().isSegmentedBarVertical());
            }
        }
    }

    public void resizeGlyph(int n, int n2, int n3, int n4, boolean bl) {
        if (!(this.parent instanceof SegmentedBar)) {
            return;
        }
        if (this.isVisible() && n3 > 0 && n4 > 0) {
            ((ButtonClientRpc)this.getRpcProxy(ButtonClientRpc.class)).updateBounds(n, n2, n3, n4, bl, ((SegmentedBar)this.parent).getMetaData().isSegmentedBarVertical());
        }
    }

    private String ResizeCaptionIfNeeded(String string) {
        int n;
        boolean bl = false;
        if (string == null) {
            string = this.getCaption();
            bl = true;
        }
        if ((n = this.metaData.getGlyphPosition()) == 1) {
            return string;
        }
        if (bl) {
            super.setCaption(string);
        }
        return string;
    }

    public void setAsActiveSegment(boolean bl) {
        if (this.parent instanceof SegmentedBar && this.metaData.isSegmentedObject() && this.isVisible()) {
            boolean bl2;
            boolean bl3 = bl2 = this.selfComponent.getStyleName().indexOf("fm-selected") > -1;
            if (bl && !bl2) {
                this.selfComponent.addStyleName("fm-selected");
            } else if (!bl && bl2) {
                this.selfComponent.removeStyleName("fm-selected");
            }
        }
    }

    public boolean isDefaultActiveSegment() {
        return this.isActiveSegment;
    }

    public boolean isCurrentActiveSegment() {
        return this.selfComponent.getStyleName().indexOf("fm-selected") > -1 && !this.isHideConditionOn();
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

    private void performClick() {
        boolean bl = false;
        PopoverWindow popoverWindow = this.app.getLayoutContainer().getPopoverWindow();
        if (popoverWindow != null && popoverWindow.isVisible()) {
            bl = true;
        }
        boolean bl2 = true;
        ObjectMetaData objectMetaData = this.getMetaData();
        if (objectMetaData.hasValidAndExecutableScript()) {
            bl2 = false;
        } else if (objectMetaData.getType() == LayoutObjectType.POPOVER_BUTTON) {
            bl2 = false;
        }
        GlobalUIActionHandlers.PROCESS_CLICK.perform(this.app, new Object[]{this, bl, bl2});
    }

    public void setAriaLabel(String string) {
        this.getState().buttonAriaLabel = string;
    }
}

