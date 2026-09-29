/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParseException
 *  com.fasterxml.jackson.databind.ObjectMapper
 */
package com.filemaker.jwpc.iwp.metadata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.metadata.DotControlMetaData;
import com.filemaker.jwpc.iwp.metadata.PanelContainerPanelMetaData;
import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.metadata.PopoverButtonMetaData;
import com.filemaker.jwpc.iwp.metadata.PopoverMetaData;
import com.filemaker.jwpc.iwp.metadata.PortalMetaData;
import com.filemaker.jwpc.iwp.metadata.TabControlMetaData;
import com.filemaker.jwpc.iwp.model.FieldObjectMetaDataModel;
import com.filemaker.jwpc.iwp.thrift.common.DateOrder;
import com.filemaker.jwpc.iwp.thrift.common.HAlign;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.LineOrientation;
import com.filemaker.jwpc.iwp.thrift.common.VAlign;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ObjectMetaData {
    protected static final ObjectMapper defaultMapper = new ObjectMapper();
    private List<ObjectMetaData> childs = new ArrayList<ObjectMetaData>();
    protected LinkedHashMap<String, ?> jsonObject;
    private Map<LayoutObjectType, ObjectMetaData> objectTypeToMetaDataMap = new HashMap<LayoutObjectType, ObjectMetaData>();
    private Map<Integer, ObjectMetaData> partIdToMetaDataMap = new HashMap<Integer, ObjectMetaData>();
    private Map<Integer, ObjectMetaData> popoverIdToMetaDataMap = new HashMap<Integer, ObjectMetaData>();
    private Map<Integer, FieldObjectMetaDataModel> sortableFieldNames;
    private List<ObjectMetaData> partsMetaDataList;
    public ObjectMetaData parent;
    public ObjectMetaData layoutRoot;
    private String positionCss;
    private Map<Short, Integer> tabOrders;
    private boolean fixedPart;
    private String uniqueObjectSelector;
    private String objectIdPrefix;
    private LayoutObjectType containingPartType = null;
    private ObjectMetaData cachedScriptObject;
    private boolean cachedScriptObject_resolved;
    private long stateBitwise = -1L;
    private DateOrder dateFormat = null;
    private static LinkedHashMap<String, LayoutObjectType> typeMap = new LinkedHashMap();

    public ObjectMetaData(LinkedHashMap<String, ?> linkedHashMap) {
        if (linkedHashMap.containsKey("d2")) {
            this.jsonObject = (LinkedHashMap)linkedHashMap.get("d2");
            this.layoutRoot = this;
            this.addLayoutParts((ArrayList)linkedHashMap.get("d3"));
            linkedHashMap.remove("d3");
        } else if (linkedHashMap.containsKey("d4")) {
            this.jsonObject = linkedHashMap;
            this.addLayoutObjects((ArrayList)linkedHashMap.get("d4"));
            linkedHashMap.remove("d4");
        } else {
            this.jsonObject = linkedHashMap;
        }
    }

    protected void addLayoutParts(ArrayList<?> arrayList) {
        ObjectMetaData objectMetaData = null;
        for (Object obj : arrayList) {
            LinkedHashMap linkedHashMap = (LinkedHashMap)obj;
            String string = (String)linkedHashMap.get("c43");
            objectMetaData = string.equals("a1") ? new PartMetaData(linkedHashMap) : new ObjectMetaData(linkedHashMap);
            objectMetaData.layoutRoot = this;
            objectMetaData.parent = this;
            this.addChild(objectMetaData);
        }
    }

    protected void addLayoutObjects(ArrayList<?> arrayList) {
        ObjectMetaData objectMetaData = null;
        for (Object obj : arrayList) {
            LinkedHashMap linkedHashMap = (LinkedHashMap)obj;
            String string = (String)linkedHashMap.get("c43");
            objectMetaData = string.equals("b21") ? new PortalMetaData(linkedHashMap) : (string.equals("b25") ? new TabControlMetaData(linkedHashMap) : (string.equals("b26") ? new PanelContainerPanelMetaData(linkedHashMap) : (string.equals("b20") ? new PopoverButtonMetaData(linkedHashMap) : (string.equals("b19") ? new PopoverMetaData(linkedHashMap) : (string.equals("b7") ? new DotControlMetaData(linkedHashMap) : (string.equals("b8") ? new PanelContainerPanelMetaData(linkedHashMap) : new ObjectMetaData(linkedHashMap)))))));
            objectMetaData.layoutRoot = this.layoutRoot;
            objectMetaData.parent = this;
            this.addChild(objectMetaData);
        }
    }

    public boolean useHandCursor() {
        ObjectMetaData objectMetaData = this.getScriptObject();
        if (objectMetaData != null) {
            String string = objectMetaData.getStringForKey("c35");
            return string.equals("e8");
        }
        return false;
    }

    public String getLayoutName() {
        if (this.getType() == LayoutObjectType.LAYOUT) {
            return this.getStringForKey("c25");
        }
        return this.layoutRoot.getLayoutName();
    }

    public ObjectMetaData getParent() {
        return this.parent;
    }

    public void addChild(ObjectMetaData objectMetaData) {
        this.childs.add(objectMetaData);
    }

    public List<ObjectMetaData> getChilds() {
        return this.childs;
    }

    public boolean isContainer() {
        return this.getType() == LayoutObjectType.CONTAINER;
    }

    public boolean isEditBox() {
        return this.getType() == LayoutObjectType.EDIT_BOX;
    }

    public boolean isSecureText() {
        return this.getType() == LayoutObjectType.SECURE_TEXT;
    }

    public boolean isCalendar() {
        return this.getType() == LayoutObjectType.CALENDAR;
    }

    public boolean isDropDown() {
        return this.getType() == LayoutObjectType.DROP_DOWN;
    }

    public boolean isPopup() {
        return this.getType() == LayoutObjectType.POP_UP;
    }

    public boolean isCheckBox() {
        return this.getType() == LayoutObjectType.CHECKBOX_SET;
    }

    public boolean isRadioSet() {
        return this.getType() == LayoutObjectType.RADIO_SET;
    }

    public boolean isPortal() {
        return this.getType() == LayoutObjectType.PORTAL;
    }

    public boolean isPopoverButton() {
        return this.getType() == LayoutObjectType.POPOVER_BUTTON;
    }

    public boolean isPopover() {
        return this.getType() == LayoutObjectType.POPOVER;
    }

    public boolean isContainerComponent() {
        LayoutObjectType layoutObjectType = this.getType();
        if (ObjectMetaData.isPart(layoutObjectType)) {
            return true;
        }
        switch (layoutObjectType) {
            case LAYOUT: 
            case TAB_CONTROL: 
            case TAB_ITEM: 
            case PORTAL: 
            case GROUP: 
            case POPOVER: 
            case DOT_CONTROL: 
            case DOT_PANEL: 
            case SEGMENTED_BAR: {
                return true;
            }
        }
        return false;
    }

    public boolean isPanelContainerPanel() {
        LayoutObjectType layoutObjectType = this.getType();
        switch (layoutObjectType) {
            case TAB_ITEM: 
            case DOT_PANEL: {
                return true;
            }
        }
        return false;
    }

    public boolean isPart() {
        return ObjectMetaData.isPart(this.getType());
    }

    private static boolean isPart(LayoutObjectType layoutObjectType) {
        switch (layoutObjectType) {
            case TOP_NAV_PART: 
            case TITLE_HEADER: 
            case HEADER: 
            case LEADING_GRAND_SUM: 
            case LEADING_SUB_SUM: 
            case BODY: 
            case TRAILING_SUB_SUM: 
            case TRAILING_GRAND_SUM: 
            case FOOTER: 
            case TITLE_FOOTER: 
            case BOTTOM_NAV_PART: {
                return true;
            }
        }
        return false;
    }

    public boolean isKeyboardEditableField() {
        switch (this.getType()) {
            case CALENDAR: 
            case EDIT_BOX: 
            case DROP_DOWN: 
            case SECURE_TEXT: {
                return true;
            }
        }
        return false;
    }

    public boolean isTextDisplayField() {
        switch (this.getType()) {
            case CALENDAR: 
            case EDIT_BOX: 
            case DROP_DOWN: 
            case SECURE_TEXT: 
            case POP_UP: 
            case RADIO_SET: 
            case CHECKBOX_SET: {
                return true;
            }
        }
        return false;
    }

    public boolean isField() {
        switch (this.getType()) {
            case CALENDAR: 
            case EDIT_BOX: 
            case DROP_DOWN: 
            case SECURE_TEXT: 
            case POP_UP: 
            case RADIO_SET: 
            case CHECKBOX_SET: 
            case CONTAINER: {
                return true;
            }
        }
        return false;
    }

    public boolean isMultiValue() {
        switch (this.getType()) {
            case DROP_DOWN: 
            case POP_UP: 
            case RADIO_SET: 
            case CHECKBOX_SET: {
                return true;
            }
        }
        return false;
    }

    public boolean isSortable() {
        boolean bl = false;
        switch (this.getType()) {
            case PORTAL: 
            case CONTAINER: {
                bl = false;
                break;
            }
            default: {
                bl = this.isField() ? this.getFieldType() != LayoutFieldType.INVALID : true;
            }
        }
        return bl;
    }

    private boolean canExecuteScript() {
        return !this.getType().equals((Object)LayoutObjectType.GROUP) && !this.getType().equals((Object)LayoutObjectType.SEGMENTED_BAR);
    }

    public boolean hasScript() {
        return this.getScriptObjectId() > 0;
    }

    public LayoutObjectType getType() {
        String string = this.getStringForKey("c43");
        if (string == null) {
            return LayoutObjectType.LAYOUT;
        }
        return typeMap.get(string);
    }

    public int getIntForKey(String string) {
        if (this.jsonObject.containsKey(string)) {
            Integer n = (Integer)this.jsonObject.get(string);
            return n;
        }
        return 0;
    }

    public Integer getIDForKey(String string) {
        if (this.jsonObject.containsKey(string)) {
            Integer n = (Integer)this.jsonObject.get(string);
            return n;
        }
        return 0;
    }

    public boolean getBoolForKey(String string) {
        if (this.jsonObject.containsKey(string)) {
            Boolean bl = (Boolean)this.jsonObject.get(string);
            return bl;
        }
        return false;
    }

    public String getStringForKey(String string) {
        if (this.jsonObject.containsKey(string)) {
            return (String)this.jsonObject.get(string);
        }
        return null;
    }

    protected boolean containsKey(String string) {
        return this.jsonObject.containsKey(string);
    }

    protected boolean getBoolForAttribute(int n) {
        boolean bl = false;
        long l = this.getStateBitwise();
        if (l > 0L) {
            long l2 = 1L << n;
            bl = (l & l2) > 0L;
        }
        return bl;
    }

    private long getStateBitwise() {
        if (this.stateBitwise == -1L) {
            String string = this.getStringForKey("st-bw");
            if (string != null) {
                try {
                    this.stateBitwise = Long.parseLong(string);
                }
                catch (NumberFormatException numberFormatException) {
                    this.stateBitwise = 0L;
                }
            } else {
                this.stateBitwise = 0L;
            }
        }
        return this.stateBitwise;
    }

    public int getLayoutId() {
        return this.getIDForKey("c19");
    }

    public long getModCount() {
        if (this.jsonObject.containsKey("c24")) {
            Object obj = this.jsonObject.get("c24");
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof Long) {
                return (Long)obj;
            }
        }
        return -1L;
    }

    public String getName() {
        return this.getStringForKey("c25");
    }

    public int getObjectId() {
        return this.getIDForKey("c26");
    }

    public int getFieldId() {
        return this.getIDForKey("c6");
    }

    public int getTableId() {
        return this.getIDForKey("c39");
    }

    public String getTableName() {
        return this.getStringForKey("c40");
    }

    public String getFieldName(boolean bl) {
        String string = this.getStringForKey("c7");
        return bl ? Utilities.encodeHTML(string) : string;
    }

    public String getFieldNameAliasForExport(boolean bl) {
        String string = this.getStringForKey("c77");
        return bl ? Utilities.encodeHTML(string) : string;
    }

    public String getFieldNameAliasForSort(boolean bl) {
        String string = this.getStringForKey("c81");
        return bl ? Utilities.encodeHTML(string) : string;
    }

    public String getTooltip() {
        return this.getStringForKey("c41");
    }

    public boolean hasMergeTooltip() {
        return this.getBoolForAttribute(34);
    }

    public boolean isGlobalField() {
        return this.getBoolForAttribute(21);
    }

    public boolean isSelectAllOnEntry() {
        return this.getBoolForAttribute(43);
    }

    public int getTopAsInt() {
        return this.getIntForKey("e1");
    }

    public int getLeftAsInt() {
        return this.getIntForKey("e2");
    }

    public int getBottomAsInt() {
        return this.getIntForKey("e3");
    }

    public int getRightAsInt() {
        return this.getIntForKey("e13");
    }

    public boolean isAutoResizeVertical() {
        return this.containsKey("e1") && this.containsKey("e3");
    }

    public boolean isAutoResizeHorizontal() {
        return this.containsKey("e2") && this.containsKey("e13");
    }

    public int getGlobalTopAsInt() {
        return this.getIntForKey("c13");
    }

    public int getGlobalLeftAsInt() {
        return this.getIntForKey("c12");
    }

    public String getHeight() {
        return this.getHeightAsInt() + "px";
    }

    public int getHeightAsInt() {
        return this.getIntForKey("c17");
    }

    public String getWidth() {
        return this.getWidthAsInt() + "px";
    }

    public int getWidthAsInt() {
        return this.getIntForKey("c45");
    }

    public String getMinHeight() {
        return this.getMinHeightAsInt() + "px";
    }

    public int getMinHeightAsInt() {
        return this.getIntForKey("c47");
    }

    public String getMinWidth() {
        return this.getMinWidthAsInt() + "px";
    }

    public int getMinWidthAsInt() {
        return this.getIntForKey("c46");
    }

    public String getLeftBorderWidth() {
        return this.getLeftBorderWidthAsInt() + "px";
    }

    public int getLeftBorderWidthAsInt() {
        return this.getIntForKey("c20");
    }

    public String getRightBorderWidth() {
        return this.getRightBorderWidthAsInt() + "px";
    }

    public int getRightBorderWidthAsInt() {
        return this.getIntForKey("c34");
    }

    public String getTopBorderWidth() {
        return this.getTopBorderWidthAsInt() + "px";
    }

    public int getTopBorderWidthAsInt() {
        return this.getIntForKey("c42");
    }

    public String getBottomBorderWidth() {
        return this.getBottomBorderWidthAsInt() + "px";
    }

    public int getBottomBorderWidthAsInt() {
        return this.getIntForKey("c1");
    }

    public String getSource() {
        return this.getStringForKey("c48");
    }

    public boolean hasLocalStyles() {
        return this.getBoolForAttribute(31);
    }

    public int getTabOrder(short s) {
        if (this.jsonObject.containsKey("c38")) {
            Object object;
            if (this.tabOrders == null) {
                object = (String)this.jsonObject.get("c38");
                this.tabOrders = new HashMap<Short, Integer>();
                if (!this.hasRepetition()) {
                    this.tabOrders.put((short)1, Integer.valueOf((String)object));
                } else {
                    String[] stringArray = ((String)object).split(",");
                    short s2 = this.getStartRepetition();
                    for (String string : stringArray) {
                        short s3 = s2;
                        s2 = (short)(s2 + 1);
                        this.tabOrders.put(s3, Integer.valueOf(string));
                    }
                }
            }
            if ((object = this.tabOrders.get(s)) == null) {
                return 0;
            }
            return (Integer)object;
        }
        return 0;
    }

    public short getRepetitionCount() {
        if (this.jsonObject.containsKey("c33")) {
            Integer n = (Integer)this.jsonObject.get("c33");
            return (short)n.intValue();
        }
        return 1;
    }

    public short getStartRepetition() {
        if (this.jsonObject.containsKey("c37")) {
            Integer n = (Integer)this.jsonObject.get("c37");
            return (short)n.intValue();
        }
        return 1;
    }

    public boolean isRepetitionVertical() {
        return this.getBoolForAttribute(39);
    }

    public void setFixedPart(boolean bl) {
        this.fixedPart = bl;
    }

    public boolean isFixedPart() {
        return this.getBoolForAttribute(18) || this.fixedPart;
    }

    public boolean hasNoBody() {
        return this.getBoolForAttribute(59);
    }

    public int getPartIndex() {
        return this.getIntForKey("c28");
    }

    public String getTypeSelector() {
        String string = "";
        if (this.isTextyField()) {
            string = "iwps_text_box";
        } else {
            switch (this.getType()) {
                case BUTTON: 
                case POPOVER_BUTTON: {
                    string = this.isSegmentedObject() ? "iwps_button_bar_segment" : "iwps_button";
                    break;
                }
                case CALENDAR: {
                    string = this.hasIcon() ? "iwps_calendar" : "iwps_edit_box";
                    break;
                }
                case CHART: {
                    string = "iwps_chart";
                    break;
                }
                case CHECKBOX_SET: {
                    string = "iwps_checkbox_set";
                    break;
                }
                case CONTAINER: {
                    string = "iwps_container";
                    break;
                }
                case DOT_CONTROL: {
                    string = "iwps_dot_control";
                    break;
                }
                case DOT_PANEL: {
                    string = "iwps_dot_panel";
                    break;
                }
                case DROP_DOWN: {
                    string = this.hasIcon() ? "iwps_drop_down" : "iwps_edit_box";
                    break;
                }
                case EDIT_BOX: {
                    string = this.hasScrollbar() ? "iwps_text_area" : "iwps_edit_box";
                    break;
                }
                case SECURE_TEXT: {
                    string = "iwps_edit_box";
                    break;
                }
                case GROUP: {
                    string = "iwps_group";
                    break;
                }
                case IMAGE: {
                    string = "iwps_graphics";
                    break;
                }
                case LABEL: {
                    string = "iwps_text_box";
                    break;
                }
                case LINE: {
                    string = "iwps_line";
                    break;
                }
                case OVAL: {
                    string = "iwps_oval";
                    break;
                }
                case POP_UP: {
                    string = this.hasIcon() ? "iwps_pop_up" : "iwps_edit_box";
                    break;
                }
                case POPOVER: {
                    string = "iwps_popover";
                    break;
                }
                case PORTAL: {
                    string = "iwps_portal";
                    break;
                }
                case RADIO_SET: {
                    string = "iwps_radio_set";
                    break;
                }
                case RECTANGLE: {
                    string = "iwps_rectangle";
                    break;
                }
                case ROUNDED_RECTANGLE: {
                    string = "iwps_rounded";
                    break;
                }
                case SEGMENTED_BAR: {
                    string = "iwps_button_bar";
                    break;
                }
                case TAB_CONTROL: {
                    string = "iwps_tab_control";
                    break;
                }
                case TAB_ITEM: {
                    string = "iwps_tab_panel";
                    break;
                }
                case WEB_VIEWER: {
                    string = "iwps_web_viewer";
                    break;
                }
                case TOP_NAV_PART: {
                    string = "iwps_top_nav_part";
                    break;
                }
                case TITLE_HEADER: {
                    string = "iwps_title_header";
                    break;
                }
                case HEADER: {
                    string = "iwps_header";
                    break;
                }
                case LEADING_GRAND_SUM: {
                    string = "iwps_leading_grand_summary";
                    break;
                }
                case LEADING_SUB_SUM: {
                    if (this.useDefaultName() && !this.hasLocalStyles()) {
                        string = "iwps_leading_sub_summary";
                        break;
                    }
                    string = this.getName();
                    break;
                }
                case BODY: {
                    string = "iwps_body";
                    break;
                }
                case TRAILING_SUB_SUM: {
                    if (this.useDefaultName() && !this.hasLocalStyles()) {
                        string = "iwps_trailing_sub_summary";
                        break;
                    }
                    string = this.getName();
                    break;
                }
                case TRAILING_GRAND_SUM: {
                    string = "iwps_trailing_grand_summary";
                    break;
                }
                case FOOTER: {
                    string = "iwps_footer";
                    break;
                }
                case TITLE_FOOTER: {
                    string = "iwps_title_footer";
                    break;
                }
                case BOTTOM_NAV_PART: {
                    string = "iwps_bottom_nav_part";
                    break;
                }
            }
        }
        return string;
    }

    public String getUniqueObjectSelector() {
        if (this.uniqueObjectSelector == null) {
            this.uniqueObjectSelector = this.isPart() ? this.getTypeSelector() + "_pid_" + this.getPartIndex() : "fm_object_" + this.getObjectId();
        }
        return this.uniqueObjectSelector;
    }

    public boolean hasRepetition() {
        if (this.getRepetitionCount() > 1) {
            return true;
        }
        return this.getStartRepetition() > 1;
    }

    public boolean isLookupField() {
        return this.getBoolForAttribute(32);
    }

    public boolean isMergeField() {
        return this.getBoolForAttribute(33);
    }

    public boolean hasConditionalFormatting() {
        return this.getBoolForAttribute(7);
    }

    public boolean hasDataFormatting() {
        return this.getBoolForAttribute(9);
    }

    public boolean allowBrowseDataEntry() {
        return this.getBoolForAttribute(6);
    }

    public boolean allowFindDataEntry() {
        return this.getBoolForAttribute(16);
    }

    public boolean dontOverrideFormattingWithValueList() {
        return this.getBoolForAttribute(55);
    }

    public String getPositionCss() {
        if (this.positionCss == null) {
            LayoutObjectType layoutObjectType;
            StringBuilder stringBuilder = new StringBuilder();
            if (this.containsKey("e1")) {
                stringBuilder.append("top:").append(this.getTopAsInt()).append("px;");
            }
            if (this.containsKey("e2")) {
                stringBuilder.append("left:").append(this.getLeftAsInt()).append("px;");
            }
            if (this.containsKey("e3")) {
                stringBuilder.append("bottom:").append(this.getBottomAsInt()).append("px;");
            }
            if (this.containsKey("e13")) {
                stringBuilder.append("right:").append(this.getRightAsInt()).append("px;");
            }
            if (this.containsKey("c47") && this.isAutoResizeVertical()) {
                stringBuilder.append("min-height:").append(this.getMinHeightAsInt()).append("px;");
            }
            if (this.containsKey("c46") && this.isAutoResizeHorizontal()) {
                stringBuilder.append("min-width:").append(this.getMinWidthAsInt()).append("px;");
            }
            if ((layoutObjectType = this.getType()) != LayoutObjectType.EDIT_BOX && layoutObjectType != LayoutObjectType.DROP_DOWN && layoutObjectType != LayoutObjectType.POP_UP && layoutObjectType != LayoutObjectType.CALENDAR && layoutObjectType != LayoutObjectType.GROUP && layoutObjectType != LayoutObjectType.RECTANGLE && layoutObjectType != LayoutObjectType.ROUNDED_RECTANGLE && layoutObjectType != LayoutObjectType.LINE && layoutObjectType != LayoutObjectType.OVAL && layoutObjectType != LayoutObjectType.LABEL && layoutObjectType != LayoutObjectType.BUTTON) {
                stringBuilder.append("position:absolute;");
            }
            this.positionCss = stringBuilder.toString();
        }
        return this.positionCss;
    }

    public Map<Integer, FieldObjectMetaDataModel> getSortableFieldNames(boolean bl) {
        if (this.sortableFieldNames != null) {
            return this.sortableFieldNames;
        }
        this.sortableFieldNames = new HashMap<Integer, FieldObjectMetaDataModel>();
        List<ObjectMetaData> list = this.getChilds();
        ArrayList<ObjectMetaData> arrayList = new ArrayList<ObjectMetaData>();
        for (ObjectMetaData objectMetaData : list) {
            if (!objectMetaData.isSortable() || arrayList.contains(objectMetaData)) continue;
            arrayList.add(objectMetaData);
        }
        this.fill(arrayList, this.sortableFieldNames, true, bl);
        return this.sortableFieldNames;
    }

    public ObjectMetaData getBodyMetaData() {
        return this.getMetaData(LayoutObjectType.BODY);
    }

    private LayoutObjectType findContainingLayoutPartType() {
        LayoutObjectType layoutObjectType = null;
        for (ObjectMetaData objectMetaData = this; objectMetaData != null && objectMetaData.getType() != LayoutObjectType.LAYOUT; objectMetaData = objectMetaData.getParent()) {
            layoutObjectType = objectMetaData.getType();
        }
        return layoutObjectType;
    }

    public boolean isIn(LayoutObjectType layoutObjectType) {
        boolean bl = true;
        for (ObjectMetaData objectMetaData = this; objectMetaData != null && objectMetaData.getType() != layoutObjectType; objectMetaData = objectMetaData.getParent()) {
            bl = false;
        }
        return bl;
    }

    public boolean isInBody() {
        return this.getContainingPartType() == LayoutObjectType.BODY;
    }

    public ObjectMetaData getMetaData(LayoutObjectType layoutObjectType) {
        ObjectMetaData objectMetaData = this.objectTypeToMetaDataMap.get((Object)layoutObjectType);
        if (objectMetaData != null) {
            return objectMetaData;
        }
        if (this.getType() == LayoutObjectType.LAYOUT) {
            for (ObjectMetaData objectMetaData2 : this.getChilds()) {
                if (layoutObjectType != objectMetaData2.getType()) continue;
                this.objectTypeToMetaDataMap.put(layoutObjectType, objectMetaData2);
                return objectMetaData2;
            }
        }
        return null;
    }

    public ObjectMetaData getMetaDataByPartId(int n) {
        ObjectMetaData objectMetaData = this.partIdToMetaDataMap.get(n);
        if (objectMetaData != null) {
            return objectMetaData;
        }
        if (this.getType() == LayoutObjectType.LAYOUT) {
            for (ObjectMetaData objectMetaData2 : this.getChilds()) {
                if (n != objectMetaData2.getPartIndex()) continue;
                this.partIdToMetaDataMap.put(n, objectMetaData2);
                return objectMetaData2;
            }
        }
        return null;
    }

    public ObjectMetaData getMetaDataByPopoverId(int n) {
        ObjectMetaData objectMetaData = this.popoverIdToMetaDataMap.get(n);
        if (objectMetaData != null) {
            return objectMetaData;
        }
        if (this.getType() == LayoutObjectType.LAYOUT) {
            for (ObjectMetaData objectMetaData2 : this.getChilds()) {
                for (ObjectMetaData objectMetaData3 : objectMetaData2.getChilds()) {
                    if (!objectMetaData3.isPopover() || n != objectMetaData3.getObjectId()) continue;
                    this.popoverIdToMetaDataMap.put(n, objectMetaData3);
                    return objectMetaData3;
                }
            }
        }
        return null;
    }

    public List<ObjectMetaData> getAllPartsMetaData() {
        if (this.partsMetaDataList == null) {
            this.partsMetaDataList = new ArrayList<ObjectMetaData>();
            if (this.getType() == LayoutObjectType.LAYOUT) {
                for (ObjectMetaData objectMetaData : this.getChilds()) {
                    if (!ObjectMetaData.isPart(objectMetaData.getType())) continue;
                    this.partsMetaDataList.add(objectMetaData);
                }
            }
        }
        return this.partsMetaDataList;
    }

    public boolean hasRelatedFields() {
        if (this.getType() == LayoutObjectType.LAYOUT) {
            return this.isRelatedField(this.getTableId(), this);
        }
        return false;
    }

    public void postProcess() {
    }

    private void fill(List<ObjectMetaData> list, Map<Integer, FieldObjectMetaDataModel> map, boolean bl, boolean bl2) {
        for (ObjectMetaData objectMetaData : list) {
            if (objectMetaData.isField() && (!bl || bl && objectMetaData.isSortable())) {
                FieldObjectMetaDataModel fieldObjectMetaDataModel = new FieldObjectMetaDataModel(objectMetaData, bl2);
                map.put(objectMetaData.getObjectId(), fieldObjectMetaDataModel);
            }
            if (!objectMetaData.isContainerComponent()) continue;
            this.fill(objectMetaData.getChilds(), map, bl, bl2);
        }
    }

    private boolean isRelatedField(int n, ObjectMetaData objectMetaData) {
        if (objectMetaData.getTableId() != 0 && objectMetaData.getTableId() != n) {
            return true;
        }
        if (objectMetaData.getChilds().size() > 0) {
            for (ObjectMetaData objectMetaData2 : objectMetaData.getChilds()) {
                if (!this.isRelatedField(n, objectMetaData2)) continue;
                return true;
            }
        }
        return false;
    }

    public final void performPostProcess() {
        this.performPostProcess(this.childs);
    }

    private final void performPostProcess(List<ObjectMetaData> list) {
        for (ObjectMetaData objectMetaData : list) {
            objectMetaData.postProcess();
            this.performPostProcess(objectMetaData.getChilds());
        }
    }

    public String getObjectIdPrefix() {
        if (this.objectIdPrefix == null) {
            StringBuilder stringBuilder = new StringBuilder("b").append(0);
            stringBuilder.append("p").append(this.findPartIndex());
            stringBuilder.append("o").append(this.getObjectId());
            this.objectIdPrefix = stringBuilder.toString();
        }
        return this.objectIdPrefix;
    }

    private int findPartIndex() {
        ObjectMetaData objectMetaData = this;
        do {
            if (!objectMetaData.isPart()) continue;
            return objectMetaData.getPartIndex();
        } while ((objectMetaData = objectMetaData.getParent()) != null);
        throw new IllegalArgumentException();
    }

    public ObjectMetaData getScriptObject() {
        if (this.cachedScriptObject_resolved) {
            return this.cachedScriptObject;
        }
        LayoutObjectType layoutObjectType = this.getType();
        if (layoutObjectType == LayoutObjectType.BUTTON && this.jsonObject.containsKey("c35")) {
            this.cachedScriptObject = this;
            this.cachedScriptObject_resolved = true;
            return this;
        }
        if (layoutObjectType == LayoutObjectType.GROUP && this.jsonObject.containsKey("c35")) {
            this.cachedScriptObject = this;
            this.cachedScriptObject_resolved = true;
            return this;
        }
        ObjectMetaData objectMetaData = this.getParent();
        if (objectMetaData != null) {
            ObjectMetaData objectMetaData2;
            this.cachedScriptObject = objectMetaData2 = objectMetaData.getScriptObject();
            this.cachedScriptObject_resolved = true;
            return this.cachedScriptObject;
        }
        this.cachedScriptObject = null;
        this.cachedScriptObject_resolved = true;
        return null;
    }

    public int getScriptObjectId() {
        ObjectMetaData objectMetaData = this.getScriptObject();
        if (objectMetaData != null) {
            return objectMetaData.getObjectId();
        }
        return 0;
    }

    public boolean isWebViewerReadOnly() {
        return this.getBoolForAttribute(38);
    }

    public boolean hasValidAndExecutableScript() {
        return this.canExecuteScript() && this.hasScript();
    }

    public boolean hasKeyTrigger() {
        return this.getBoolForAttribute(62);
    }

    public boolean hasModifyTrigger() {
        return this.getBoolForAttribute(47);
    }

    public boolean hasEnterTriggers() {
        return this.getBoolForAttribute(48);
    }

    public boolean hasExitTriggers() {
        return this.getBoolForAttribute(49);
    }

    public VAlign getVAlign() {
        String string = this.getStringForKey("c44");
        if (string != null) {
            if (string.equals("e1")) {
                return VAlign.TOP_ALIGN;
            }
            if (string.equals("e3")) {
                return VAlign.BOTTOM_ALIGN;
            }
        }
        return VAlign.MIDDLE_ALIGN;
    }

    public HAlign getHAlign() {
        String string = this.getStringForKey("c16");
        if (string != null) {
            if (string.equals("e2")) {
                return HAlign.LEFT_ALIGN;
            }
            if (string.equals("e13")) {
                return HAlign.RIGHT_ALIGN;
            }
        }
        return HAlign.CENTER_ALIGN;
    }

    public int getContainerMaxSize() {
        if (this.jsonObject.containsKey("c22")) {
            Integer n = (Integer)this.jsonObject.get("c22");
            return n;
        }
        return -1;
    }

    public boolean hasContainerMaxSize() {
        return this.jsonObject.containsKey("c22");
    }

    public int getPortalRowHeight() {
        return this.getIntForKey("c32");
    }

    public boolean isValidateStrict() {
        return this.getBoolForAttribute(54);
    }

    public LayoutFieldType getFieldType() {
        String string = this.getStringForKey("c8");
        if (string.length() > 0) {
            return IWPUtilities.getFieldTypeFromString(string);
        }
        return null;
    }

    public LayoutFieldDataType getFieldDataType() {
        String string = this.getStringForKey("c9");
        if (string.length() > 0) {
            return IWPUtilities.getFieldDataTypeFromString(string);
        }
        return null;
    }

    public boolean isAutoPlayAV() {
        return this.getBoolForAttribute(5);
    }

    public boolean isPreservePDFTransparency() {
        return this.getBoolForAttribute(37);
    }

    public boolean displayWebviewerContentInFindMode() {
        return this.getBoolForAttribute(17);
    }

    public boolean hasHideCondition() {
        return this.getBoolForAttribute(26);
    }

    public boolean hasHideConditionInFindMode() {
        return this.getBoolForAttribute(27);
    }

    public boolean quickFindDisabled() {
        return this.getBoolForAttribute(11);
    }

    public ArrayList<String> getCustomStyles() {
        return (ArrayList)this.jsonObject.get("d5");
    }

    public boolean hasIcon() {
        return this.getBoolForAttribute(23);
    }

    public boolean hasScrollbar() {
        return this.getBoolForAttribute(29);
    }

    public boolean hasNegativeColor() {
        return this.getBoolForAttribute(35);
    }

    public boolean useDefaultName() {
        return this.getBoolForAttribute(52);
    }

    public LineOrientation getLineOrientation() {
        String string = this.getStringForKey("c21");
        if (string != null) {
            if (string.equals("e7")) {
                return LineOrientation.DIAGONAL;
            }
            if (string.equals("e17")) {
                return LineOrientation.VERTICAL;
            }
        }
        return LineOrientation.HORIZONTAL;
    }

    public boolean hasValidation() {
        return this.getBoolForAttribute(54);
    }

    private Rectangle getBoundsByString(String string) {
        String[] stringArray = string.split(",");
        int n = Integer.valueOf(stringArray[0]);
        int n2 = Integer.valueOf(stringArray[1]);
        int n3 = Integer.valueOf(stringArray[2]);
        int n4 = Integer.valueOf(stringArray[3]);
        return new Rectangle(n, n2, n3, n4);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.print(stringBuilder, this, "\n\t");
        if (this.childs != null) {
            for (ObjectMetaData objectMetaData : this.childs) {
                stringBuilder.append(objectMetaData.toString());
            }
        }
        return stringBuilder.toString();
    }

    private void print(StringBuilder stringBuilder, ObjectMetaData objectMetaData, String string) {
        stringBuilder.append("type:").append((Object)objectMetaData.getType()).append(", part id:").append(objectMetaData.getPartIndex()).append(", table id:").append(objectMetaData.getTableId()).append(", table name: ").append(objectMetaData.getTableName()).append(", object id: ").append(objectMetaData.getObjectId()).append(", field id: ").append(objectMetaData.getFieldId()).append(", field name: ").append(objectMetaData.getFieldName(false)).append(string);
    }

    public LayoutObjectType getContainingPartType() {
        if (this.containingPartType == null) {
            this.setContainingPartType(this.findContainingLayoutPartType());
        }
        return this.containingPartType;
    }

    public void setContainingPartType(LayoutObjectType layoutObjectType) {
        this.containingPartType = layoutObjectType;
    }

    public boolean hasAutoSizingObjects() {
        return this.getBoolForAttribute(28);
    }

    public boolean isClientSideAutoSizing() {
        return this.getBoolForAttribute(56);
    }

    public boolean layoutHorizontalAutoSizing() {
        return this.getBoolForAttribute(57);
    }

    public boolean layoutVerticalAutoSizing() {
        return this.getBoolForAttribute(58);
    }

    public String getContainerMaxSizeError() {
        return this.getStringForKey("c23");
    }

    public boolean isInsidePopoverContent() {
        return this.getBoolForAttribute(30);
    }

    public boolean isTextyField() {
        return this.getBoolForAttribute(50);
    }

    public boolean checkIfDataMaskNeeded() {
        return this.getBoolForAttribute(8);
    }

    public String getFontName() {
        return this.getStringForKey("c10");
    }

    public boolean IsFontItalic() {
        return this.getBoolForAttribute(20);
    }

    public boolean IsFontBold() {
        return this.getBoolForAttribute(19);
    }

    public int getFontSize() {
        return this.getIntForKey("c11");
    }

    public int getContentRectWidthAsInt() {
        return this.getIntForKey("c2");
    }

    public int getContentRectHeightAsInt() {
        return this.getIntForKey("c3");
    }

    public boolean getExitOnTAB() {
        return this.getBoolForAttribute(13);
    }

    public boolean getExitOnRETURN() {
        return this.getBoolForAttribute(14);
    }

    public boolean getExitOnENTER() {
        return this.getBoolForAttribute(15);
    }

    public boolean hasPlaceholderText() {
        return this.getBoolForAttribute(24);
    }

    public boolean getUseAutoComplete() {
        return this.getBoolForAttribute(51);
    }

    public int getGlyphPosition() {
        return this.getIntForKey("c14");
    }

    public int getGlyphSize() {
        return this.getIntForKey("c15");
    }

    public boolean isSegmentedBarVertical() {
        return this.getBoolForAttribute(41);
    }

    public boolean isSegmentedBarCalc() {
        return this.getBoolForAttribute(42);
    }

    public boolean isSegmentedObject() {
        return this.getBoolForAttribute(40);
    }

    public Rectangle getSegmentedBarBounds() {
        String string = this.getStringForKey("e14");
        if (string != null) {
            return this.getBoundsByString(string);
        }
        return null;
    }

    public Rectangle getSegmentedDividerBounds() {
        String string = this.getStringForKey("e15");
        if (string != null) {
            return this.getBoundsByString(string);
        }
        return null;
    }

    public void setDateFormat(DateOrder dateOrder) {
        this.dateFormat = dateOrder;
    }

    public DateOrder getDateFormat() {
        return this.dateFormat;
    }

    public static ObjectMetaData generateLayoutMetaData(App app, String string, DateOrder dateOrder) throws AppRuntimeException {
        ObjectMetaData objectMetaData = null;
        try {
            boolean bl;
            Serializable serializable;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2 = (LinkedHashMap)defaultMapper.readValue(string, LinkedHashMap.class);
            if (linkedHashMap2.containsKey("d2") && (linkedHashMap = (LinkedHashMap)linkedHashMap2.get("d2")).containsKey("precanned") && ((String)linkedHashMap.get("precanned")).equals("no-access")) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("{\"").append("d2").append("\":{\"").append("c17").append("\":234,\"").append("c25").append("\":\"no access\",\"").append("c39").append("\":1065108,\"").append("c40").append("\":\"no access\",\"").append("c45").append("\":612},\"").append("d3").append("\":[{\"").append("c17").append("\":234,\"").append("c27").append("\":0,\"").append("c45").append("\":368,\"").append("c43").append("\":\"").append("a1").append("\",\"").append("d4").append("\":[{\"").append("c12").append("\":225,\"").append("c13").append("\":112,\"").append("c17").append("\":21,\"").append("e2").append("\":225,\"").append("c25").append("\":\"&lt;No Access&gt;\",\"").append("c26").append("\":1,\"").append("e1").append("\":112,\"").append("c45").append("\":143,\"").append("c43").append("\":\"").append("b14").append("\"}]}]}");
                string = ((StringBuilder)serializable).toString();
                linkedHashMap2 = (LinkedHashMap)defaultMapper.readValue(string, LinkedHashMap.class);
            }
            boolean bl2 = bl = (objectMetaData = new ObjectMetaData(linkedHashMap2)).getBodyMetaData() != null;
            if (!bl) {
                serializable = new LinkedHashMap<String, String>();
                ((HashMap)serializable).put("c43", "a1");
                if (objectMetaData.isContainerComponent()) {
                    ((HashMap)serializable).put("c45", objectMetaData.getWidthAsInt());
                    ((HashMap)serializable).put("c17", ObjectMetaData.getDummyBodyHeight(objectMetaData));
                }
                PartMetaData partMetaData = new PartMetaData((LinkedHashMap<String, ?>)serializable);
                partMetaData.parent = objectMetaData;
                partMetaData.layoutRoot = objectMetaData;
                objectMetaData.addChild(partMetaData);
            }
            objectMetaData.setDateFormat(dateOrder);
            app.getLayoutDataModel().update(objectMetaData);
        }
        catch (JsonParseException jsonParseException) {
            jsonParseException.printStackTrace();
            throw new AppRuntimeException(jsonParseException);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new AppRuntimeException(iOException);
        }
        return objectMetaData;
    }

    private static int getDummyBodyHeight(ObjectMetaData objectMetaData) {
        int n = 0;
        ObjectMetaData objectMetaData2 = objectMetaData.getMetaData(LayoutObjectType.LEADING_SUB_SUM);
        if (objectMetaData2 != null) {
            n = objectMetaData2.getHeightAsInt();
        } else {
            objectMetaData2 = objectMetaData.getMetaData(LayoutObjectType.TRAILING_SUB_SUM);
            if (objectMetaData2 != null) {
                n = objectMetaData2.getHeightAsInt();
            }
        }
        return n;
    }

    public boolean allowJSCommunication() {
        return this.getBoolForAttribute(61);
    }

    public Integer getTouchKeyboardType() {
        if (this.jsonObject.containsKey("keyboardType")) {
            Integer n = (Integer)this.jsonObject.get("keyboardType");
            return n;
        }
        return 0;
    }

    public boolean isContextMenuDisabled() {
        return this.getBoolForAttribute(53);
    }

    public String getAccLabel() {
        return this.getStringForKey("c80");
    }

    public String getAccTitle() {
        return this.getStringForKey("c78");
    }

    public String getAccHelp() {
        return this.getStringForKey("c79");
    }

    static {
        typeMap.put("d2", LayoutObjectType.LAYOUT);
        typeMap.put("a8", LayoutObjectType.TITLE_HEADER);
        typeMap.put("a5", LayoutObjectType.HEADER);
        typeMap.put("a10", LayoutObjectType.TOP_NAV_PART);
        typeMap.put("a2", LayoutObjectType.BOTTOM_NAV_PART);
        typeMap.put("a6", LayoutObjectType.LEADING_GRAND_SUM);
        typeMap.put("a7", LayoutObjectType.LEADING_SUB_SUM);
        typeMap.put("a1", LayoutObjectType.BODY);
        typeMap.put("a12", LayoutObjectType.TRAILING_SUB_SUM);
        typeMap.put("a11", LayoutObjectType.TRAILING_GRAND_SUM);
        typeMap.put("a4", LayoutObjectType.FOOTER);
        typeMap.put("a9", LayoutObjectType.TITLE_FOOTER);
        typeMap.put("b14", LayoutObjectType.LABEL);
        typeMap.put("b25", LayoutObjectType.TAB_CONTROL);
        typeMap.put("b26", LayoutObjectType.TAB_ITEM);
        typeMap.put("b21", LayoutObjectType.PORTAL);
        typeMap.put("b10", LayoutObjectType.EDIT_BOX);
        typeMap.put("b30", LayoutObjectType.SECURE_TEXT);
        typeMap.put("b9", LayoutObjectType.DROP_DOWN);
        typeMap.put("b18", LayoutObjectType.POP_UP);
        typeMap.put("b4", LayoutObjectType.CHECKBOX_SET);
        typeMap.put("b22", LayoutObjectType.RADIO_SET);
        typeMap.put("b2", LayoutObjectType.CALENDAR);
        typeMap.put("b5", LayoutObjectType.CONTAINER);
        typeMap.put("b1", LayoutObjectType.BUTTON);
        typeMap.put("b3", LayoutObjectType.CHART);
        typeMap.put("b28", LayoutObjectType.WEB_VIEWER);
        typeMap.put("b12", LayoutObjectType.IMAGE);
        typeMap.put("b16", LayoutObjectType.LINE);
        typeMap.put("b17", LayoutObjectType.OVAL);
        typeMap.put("b23", LayoutObjectType.RECTANGLE);
        typeMap.put("b24", LayoutObjectType.ROUNDED_RECTANGLE);
        typeMap.put("b11", LayoutObjectType.GROUP);
        typeMap.put("b20", LayoutObjectType.POPOVER_BUTTON);
        typeMap.put("b19", LayoutObjectType.POPOVER);
        typeMap.put("b7", LayoutObjectType.DOT_CONTROL);
        typeMap.put("b8", LayoutObjectType.DOT_PANEL);
        typeMap.put("b29", LayoutObjectType.SEGMENTED_BAR);
    }
}

