/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.EncodingUtils
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.EnumMetaData
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.protocol.TProtocolException
 *  org.apache.thrift.protocol.TProtocolUtil
 *  org.apache.thrift.protocol.TStruct
 *  org.apache.thrift.protocol.TTupleProtocol
 *  org.apache.thrift.scheme.IScheme
 *  org.apache.thrift.scheme.SchemeFactory
 *  org.apache.thrift.scheme.StandardScheme
 *  org.apache.thrift.scheme.TupleScheme
 *  org.apache.thrift.transport.TIOStreamTransport
 *  org.apache.thrift.transport.TTransport
 */
package com.filemaker.jwpc.iwp.thrift.context;

import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class Context
implements TBase<Context, _Fields>,
Serializable,
Cloneable,
Comparable<Context> {
    private static final TStruct STRUCT_DESC = new TStruct("Context");
    private static final TField SESSION_ID_FIELD_DESC = new TField("sessionID", 8, 1);
    private static final TField WINDOW_ID_FIELD_DESC = new TField("windowID", 8, 2);
    private static final TField DATABASE_NAME_FIELD_DESC = new TField("databaseName", 11, 3);
    private static final TField USER_NAME_FIELD_DESC = new TField("userName", 11, 4);
    private static final TField ACCOUNT_NAME_FIELD_DESC = new TField("accountName", 11, 5);
    private static final TField LAYOUT_NAME_FIELD_DESC = new TField("layoutName", 11, 6);
    private static final TField LAYOUT_ID_FIELD_DESC = new TField("layoutID", 8, 7);
    private static final TField LAYOUT_MOD_COUNT_FIELD_DESC = new TField("layoutModCount", 10, 8);
    private static final TField VIEW_STYLE_FIELD_DESC = new TField("viewStyle", 8, 9);
    private static final TField MODE_FIELD_DESC = new TField("mode", 8, 10);
    private static final TField STATUS_AREA_TOOLBAR_VISIBLE_FIELD_DESC = new TField("statusAreaToolbarVisible", 2, 11);
    private static final TField MENUBAR_VISIBLE_FIELD_DESC = new TField("menubarVisible", 2, 12);
    private static final TField TASK_ID_FIELD_DESC = new TField("taskId", 10, 13);
    private static final TField GUEST_ENABLED_FIELD_DESC = new TField("guestEnabled", 2, 14);
    private static final TField NOTIFY_PORT_FIELD_DESC = new TField("notifyPort", 8, 15);
    private static final TField LAST_ACTION_FIELD_DESC = new TField("lastAction", 11, 16);
    private static final TField HIDE_LOCAL_ACCOUNT_ENTRY_FIELD_DESC = new TField("hideLocalAccountEntry", 2, 17);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ContextStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ContextTupleSchemeFactory();
    private int sessionID;
    private int windowID;
    @Nullable
    private String databaseName;
    @Nullable
    private String userName;
    @Nullable
    private String accountName;
    @Nullable
    private String layoutName;
    private int layoutID;
    private long layoutModCount;
    @Nullable
    private LayoutViewStyle viewStyle;
    @Nullable
    private LayoutMode mode;
    private boolean statusAreaToolbarVisible;
    private boolean menubarVisible;
    private long taskId;
    private boolean guestEnabled;
    private int notifyPort;
    @Nullable
    private String lastAction;
    private boolean hideLocalAccountEntry;
    private static final int __SESSIONID_ISSET_ID = 0;
    private static final int __WINDOWID_ISSET_ID = 1;
    private static final int __LAYOUTID_ISSET_ID = 2;
    private static final int __LAYOUTMODCOUNT_ISSET_ID = 3;
    private static final int __STATUSAREATOOLBARVISIBLE_ISSET_ID = 4;
    private static final int __MENUBARVISIBLE_ISSET_ID = 5;
    private static final int __TASKID_ISSET_ID = 6;
    private static final int __GUESTENABLED_ISSET_ID = 7;
    private static final int __NOTIFYPORT_ISSET_ID = 8;
    private static final int __HIDELOCALACCOUNTENTRY_ISSET_ID = 9;
    private short __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Context() {
        this.viewStyle = LayoutViewStyle.FORM;
        this.mode = LayoutMode.BROWSE;
    }

    public Context(int n, int n2, String string, String string2, String string3, String string4, int n3, long l, LayoutViewStyle layoutViewStyle, LayoutMode layoutMode, boolean bl, boolean bl2, long l2, boolean bl3, int n4, String string5, boolean bl4) {
        this();
        this.sessionID = n;
        this.setSessionIDIsSet(true);
        this.windowID = n2;
        this.setWindowIDIsSet(true);
        this.databaseName = string;
        this.userName = string2;
        this.accountName = string3;
        this.layoutName = string4;
        this.layoutID = n3;
        this.setLayoutIDIsSet(true);
        this.layoutModCount = l;
        this.setLayoutModCountIsSet(true);
        this.viewStyle = layoutViewStyle;
        this.mode = layoutMode;
        this.statusAreaToolbarVisible = bl;
        this.setStatusAreaToolbarVisibleIsSet(true);
        this.menubarVisible = bl2;
        this.setMenubarVisibleIsSet(true);
        this.taskId = l2;
        this.setTaskIdIsSet(true);
        this.guestEnabled = bl3;
        this.setGuestEnabledIsSet(true);
        this.notifyPort = n4;
        this.setNotifyPortIsSet(true);
        this.lastAction = string5;
        this.hideLocalAccountEntry = bl4;
        this.setHideLocalAccountEntryIsSet(true);
    }

    public Context(Context context) {
        this.__isset_bitfield = context.__isset_bitfield;
        this.sessionID = context.sessionID;
        this.windowID = context.windowID;
        if (context.isSetDatabaseName()) {
            this.databaseName = context.databaseName;
        }
        if (context.isSetUserName()) {
            this.userName = context.userName;
        }
        if (context.isSetAccountName()) {
            this.accountName = context.accountName;
        }
        if (context.isSetLayoutName()) {
            this.layoutName = context.layoutName;
        }
        this.layoutID = context.layoutID;
        this.layoutModCount = context.layoutModCount;
        if (context.isSetViewStyle()) {
            this.viewStyle = context.viewStyle;
        }
        if (context.isSetMode()) {
            this.mode = context.mode;
        }
        this.statusAreaToolbarVisible = context.statusAreaToolbarVisible;
        this.menubarVisible = context.menubarVisible;
        this.taskId = context.taskId;
        this.guestEnabled = context.guestEnabled;
        this.notifyPort = context.notifyPort;
        if (context.isSetLastAction()) {
            this.lastAction = context.lastAction;
        }
        this.hideLocalAccountEntry = context.hideLocalAccountEntry;
    }

    public Context deepCopy() {
        return new Context(this);
    }

    public void clear() {
        this.setSessionIDIsSet(false);
        this.sessionID = 0;
        this.setWindowIDIsSet(false);
        this.windowID = 0;
        this.databaseName = null;
        this.userName = null;
        this.accountName = null;
        this.layoutName = null;
        this.setLayoutIDIsSet(false);
        this.layoutID = 0;
        this.setLayoutModCountIsSet(false);
        this.layoutModCount = 0L;
        this.viewStyle = LayoutViewStyle.FORM;
        this.mode = LayoutMode.BROWSE;
        this.setStatusAreaToolbarVisibleIsSet(false);
        this.statusAreaToolbarVisible = false;
        this.setMenubarVisibleIsSet(false);
        this.menubarVisible = false;
        this.setTaskIdIsSet(false);
        this.taskId = 0L;
        this.setGuestEnabledIsSet(false);
        this.guestEnabled = false;
        this.setNotifyPortIsSet(false);
        this.notifyPort = 0;
        this.lastAction = null;
        this.setHideLocalAccountEntryIsSet(false);
        this.hideLocalAccountEntry = false;
    }

    public int getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(int n) {
        this.sessionID = n;
        this.setSessionIDIsSet(true);
    }

    public void unsetSessionID() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSessionID() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)0);
    }

    public void setSessionIDIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getWindowID() {
        return this.windowID;
    }

    public void setWindowID(int n) {
        this.windowID = n;
        this.setWindowIDIsSet(true);
    }

    public void unsetWindowID() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)1);
    }

    public boolean isSetWindowID() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)1);
    }

    public void setWindowIDIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName(@Nullable String string) {
        this.databaseName = string;
    }

    public void unsetDatabaseName() {
        this.databaseName = null;
    }

    public boolean isSetDatabaseName() {
        return this.databaseName != null;
    }

    public void setDatabaseNameIsSet(boolean bl) {
        if (!bl) {
            this.databaseName = null;
        }
    }

    @Nullable
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(@Nullable String string) {
        this.userName = string;
    }

    public void unsetUserName() {
        this.userName = null;
    }

    public boolean isSetUserName() {
        return this.userName != null;
    }

    public void setUserNameIsSet(boolean bl) {
        if (!bl) {
            this.userName = null;
        }
    }

    @Nullable
    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(@Nullable String string) {
        this.accountName = string;
    }

    public void unsetAccountName() {
        this.accountName = null;
    }

    public boolean isSetAccountName() {
        return this.accountName != null;
    }

    public void setAccountNameIsSet(boolean bl) {
        if (!bl) {
            this.accountName = null;
        }
    }

    @Nullable
    public String getLayoutName() {
        return this.layoutName;
    }

    public void setLayoutName(@Nullable String string) {
        this.layoutName = string;
    }

    public void unsetLayoutName() {
        this.layoutName = null;
    }

    public boolean isSetLayoutName() {
        return this.layoutName != null;
    }

    public void setLayoutNameIsSet(boolean bl) {
        if (!bl) {
            this.layoutName = null;
        }
    }

    public int getLayoutID() {
        return this.layoutID;
    }

    public void setLayoutID(int n) {
        this.layoutID = n;
        this.setLayoutIDIsSet(true);
    }

    public void unsetLayoutID() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)2);
    }

    public boolean isSetLayoutID() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)2);
    }

    public void setLayoutIDIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public long getLayoutModCount() {
        return this.layoutModCount;
    }

    public void setLayoutModCount(long l) {
        this.layoutModCount = l;
        this.setLayoutModCountIsSet(true);
    }

    public void unsetLayoutModCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)3);
    }

    public boolean isSetLayoutModCount() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)3);
    }

    public void setLayoutModCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    @Nullable
    public LayoutViewStyle getViewStyle() {
        return this.viewStyle;
    }

    public void setViewStyle(@Nullable LayoutViewStyle layoutViewStyle) {
        this.viewStyle = layoutViewStyle;
    }

    public void unsetViewStyle() {
        this.viewStyle = null;
    }

    public boolean isSetViewStyle() {
        return this.viewStyle != null;
    }

    public void setViewStyleIsSet(boolean bl) {
        if (!bl) {
            this.viewStyle = null;
        }
    }

    @Nullable
    public LayoutMode getMode() {
        return this.mode;
    }

    public void setMode(@Nullable LayoutMode layoutMode) {
        this.mode = layoutMode;
    }

    public void unsetMode() {
        this.mode = null;
    }

    public boolean isSetMode() {
        return this.mode != null;
    }

    public void setModeIsSet(boolean bl) {
        if (!bl) {
            this.mode = null;
        }
    }

    public boolean isStatusAreaToolbarVisible() {
        return this.statusAreaToolbarVisible;
    }

    public void setStatusAreaToolbarVisible(boolean bl) {
        this.statusAreaToolbarVisible = bl;
        this.setStatusAreaToolbarVisibleIsSet(true);
    }

    public void unsetStatusAreaToolbarVisible() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)4);
    }

    public boolean isSetStatusAreaToolbarVisible() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)4);
    }

    public void setStatusAreaToolbarVisibleIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public boolean isMenubarVisible() {
        return this.menubarVisible;
    }

    public void setMenubarVisible(boolean bl) {
        this.menubarVisible = bl;
        this.setMenubarVisibleIsSet(true);
    }

    public void unsetMenubarVisible() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)5);
    }

    public boolean isSetMenubarVisible() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)5);
    }

    public void setMenubarVisibleIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long l) {
        this.taskId = l;
        this.setTaskIdIsSet(true);
    }

    public void unsetTaskId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)6);
    }

    public boolean isSetTaskId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)6);
    }

    public void setTaskIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    public boolean isGuestEnabled() {
        return this.guestEnabled;
    }

    public void setGuestEnabled(boolean bl) {
        this.guestEnabled = bl;
        this.setGuestEnabledIsSet(true);
    }

    public void unsetGuestEnabled() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)7);
    }

    public boolean isSetGuestEnabled() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)7);
    }

    public void setGuestEnabledIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    public int getNotifyPort() {
        return this.notifyPort;
    }

    public void setNotifyPort(int n) {
        this.notifyPort = n;
        this.setNotifyPortIsSet(true);
    }

    public void unsetNotifyPort() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)8);
    }

    public boolean isSetNotifyPort() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)8);
    }

    public void setNotifyPortIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)8, (boolean)bl);
    }

    @Nullable
    public String getLastAction() {
        return this.lastAction;
    }

    public void setLastAction(@Nullable String string) {
        this.lastAction = string;
    }

    public void unsetLastAction() {
        this.lastAction = null;
    }

    public boolean isSetLastAction() {
        return this.lastAction != null;
    }

    public void setLastActionIsSet(boolean bl) {
        if (!bl) {
            this.lastAction = null;
        }
    }

    public boolean isHideLocalAccountEntry() {
        return this.hideLocalAccountEntry;
    }

    public void setHideLocalAccountEntry(boolean bl) {
        this.hideLocalAccountEntry = bl;
        this.setHideLocalAccountEntryIsSet(true);
    }

    public void unsetHideLocalAccountEntry() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)9);
    }

    public boolean isSetHideLocalAccountEntry() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)9);
    }

    public void setHideLocalAccountEntryIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)9, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSessionID();
                    break;
                }
                this.setSessionID((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetWindowID();
                    break;
                }
                this.setWindowID((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetDatabaseName();
                    break;
                }
                this.setDatabaseName((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetUserName();
                    break;
                }
                this.setUserName((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetAccountName();
                    break;
                }
                this.setAccountName((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetLayoutName();
                    break;
                }
                this.setLayoutName((String)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetLayoutID();
                    break;
                }
                this.setLayoutID((Integer)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetLayoutModCount();
                    break;
                }
                this.setLayoutModCount((Long)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetViewStyle();
                    break;
                }
                this.setViewStyle((LayoutViewStyle)((Object)object));
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetMode();
                    break;
                }
                this.setMode((LayoutMode)((Object)object));
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetStatusAreaToolbarVisible();
                    break;
                }
                this.setStatusAreaToolbarVisible((Boolean)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetMenubarVisible();
                    break;
                }
                this.setMenubarVisible((Boolean)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetTaskId();
                    break;
                }
                this.setTaskId((Long)object);
                break;
            }
            case 13: {
                if (object == null) {
                    this.unsetGuestEnabled();
                    break;
                }
                this.setGuestEnabled((Boolean)object);
                break;
            }
            case 14: {
                if (object == null) {
                    this.unsetNotifyPort();
                    break;
                }
                this.setNotifyPort((Integer)object);
                break;
            }
            case 15: {
                if (object == null) {
                    this.unsetLastAction();
                    break;
                }
                this.setLastAction((String)object);
                break;
            }
            case 16: {
                if (object == null) {
                    this.unsetHideLocalAccountEntry();
                    break;
                }
                this.setHideLocalAccountEntry((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSessionID();
            }
            case 1: {
                return this.getWindowID();
            }
            case 2: {
                return this.getDatabaseName();
            }
            case 3: {
                return this.getUserName();
            }
            case 4: {
                return this.getAccountName();
            }
            case 5: {
                return this.getLayoutName();
            }
            case 6: {
                return this.getLayoutID();
            }
            case 7: {
                return this.getLayoutModCount();
            }
            case 8: {
                return this.getViewStyle();
            }
            case 9: {
                return this.getMode();
            }
            case 10: {
                return this.isStatusAreaToolbarVisible();
            }
            case 11: {
                return this.isMenubarVisible();
            }
            case 12: {
                return this.getTaskId();
            }
            case 13: {
                return this.isGuestEnabled();
            }
            case 14: {
                return this.getNotifyPort();
            }
            case 15: {
                return this.getLastAction();
            }
            case 16: {
                return this.isHideLocalAccountEntry();
            }
        }
        throw new IllegalStateException();
    }

    public boolean isSet(_Fields _Fields2) {
        if (_Fields2 == null) {
            throw new IllegalArgumentException();
        }
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isSetSessionID();
            }
            case 1: {
                return this.isSetWindowID();
            }
            case 2: {
                return this.isSetDatabaseName();
            }
            case 3: {
                return this.isSetUserName();
            }
            case 4: {
                return this.isSetAccountName();
            }
            case 5: {
                return this.isSetLayoutName();
            }
            case 6: {
                return this.isSetLayoutID();
            }
            case 7: {
                return this.isSetLayoutModCount();
            }
            case 8: {
                return this.isSetViewStyle();
            }
            case 9: {
                return this.isSetMode();
            }
            case 10: {
                return this.isSetStatusAreaToolbarVisible();
            }
            case 11: {
                return this.isSetMenubarVisible();
            }
            case 12: {
                return this.isSetTaskId();
            }
            case 13: {
                return this.isSetGuestEnabled();
            }
            case 14: {
                return this.isSetNotifyPort();
            }
            case 15: {
                return this.isSetLastAction();
            }
            case 16: {
                return this.isSetHideLocalAccountEntry();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Context) {
            return this.equals((Context)object);
        }
        return false;
    }

    public boolean equals(Context context) {
        if (context == null) {
            return false;
        }
        if (this == context) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.sessionID != context.sessionID) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.windowID != context.windowID) {
                return false;
            }
        }
        boolean bl5 = this.isSetDatabaseName();
        boolean bl6 = context.isSetDatabaseName();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.databaseName.equals(context.databaseName)) {
                return false;
            }
        }
        boolean bl7 = this.isSetUserName();
        boolean bl8 = context.isSetUserName();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.userName.equals(context.userName)) {
                return false;
            }
        }
        boolean bl9 = this.isSetAccountName();
        boolean bl10 = context.isSetAccountName();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.accountName.equals(context.accountName)) {
                return false;
            }
        }
        boolean bl11 = this.isSetLayoutName();
        boolean bl12 = context.isSetLayoutName();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.layoutName.equals(context.layoutName)) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.layoutID != context.layoutID) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.layoutModCount != context.layoutModCount) {
                return false;
            }
        }
        boolean bl17 = this.isSetViewStyle();
        boolean bl18 = context.isSetViewStyle();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.viewStyle.equals((Object)context.viewStyle)) {
                return false;
            }
        }
        boolean bl19 = this.isSetMode();
        boolean bl20 = context.isSetMode();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.mode.equals((Object)context.mode)) {
                return false;
            }
        }
        boolean bl21 = true;
        boolean bl22 = true;
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (this.statusAreaToolbarVisible != context.statusAreaToolbarVisible) {
                return false;
            }
        }
        boolean bl23 = true;
        boolean bl24 = true;
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (this.menubarVisible != context.menubarVisible) {
                return false;
            }
        }
        boolean bl25 = true;
        boolean bl26 = true;
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (this.taskId != context.taskId) {
                return false;
            }
        }
        boolean bl27 = true;
        boolean bl28 = true;
        if (bl27 || bl28) {
            if (!bl27 || !bl28) {
                return false;
            }
            if (this.guestEnabled != context.guestEnabled) {
                return false;
            }
        }
        boolean bl29 = true;
        boolean bl30 = true;
        if (bl29 || bl30) {
            if (!bl29 || !bl30) {
                return false;
            }
            if (this.notifyPort != context.notifyPort) {
                return false;
            }
        }
        boolean bl31 = this.isSetLastAction();
        boolean bl32 = context.isSetLastAction();
        if (bl31 || bl32) {
            if (!bl31 || !bl32) {
                return false;
            }
            if (!this.lastAction.equals(context.lastAction)) {
                return false;
            }
        }
        boolean bl33 = true;
        boolean bl34 = true;
        if (bl33 || bl34) {
            if (!bl33 || !bl34) {
                return false;
            }
            if (this.hideLocalAccountEntry != context.hideLocalAccountEntry) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.sessionID;
        n = n * 8191 + this.windowID;
        n = n * 8191 + (this.isSetDatabaseName() ? 131071 : 524287);
        if (this.isSetDatabaseName()) {
            n = n * 8191 + this.databaseName.hashCode();
        }
        n = n * 8191 + (this.isSetUserName() ? 131071 : 524287);
        if (this.isSetUserName()) {
            n = n * 8191 + this.userName.hashCode();
        }
        n = n * 8191 + (this.isSetAccountName() ? 131071 : 524287);
        if (this.isSetAccountName()) {
            n = n * 8191 + this.accountName.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutName() ? 131071 : 524287);
        if (this.isSetLayoutName()) {
            n = n * 8191 + this.layoutName.hashCode();
        }
        n = n * 8191 + this.layoutID;
        n = n * 8191 + TBaseHelper.hashCode((long)this.layoutModCount);
        n = n * 8191 + (this.isSetViewStyle() ? 131071 : 524287);
        if (this.isSetViewStyle()) {
            n = n * 8191 + this.viewStyle.getValue();
        }
        n = n * 8191 + (this.isSetMode() ? 131071 : 524287);
        if (this.isSetMode()) {
            n = n * 8191 + this.mode.getValue();
        }
        n = n * 8191 + (this.statusAreaToolbarVisible ? 131071 : 524287);
        n = n * 8191 + (this.menubarVisible ? 131071 : 524287);
        n = n * 8191 + TBaseHelper.hashCode((long)this.taskId);
        n = n * 8191 + (this.guestEnabled ? 131071 : 524287);
        n = n * 8191 + this.notifyPort;
        n = n * 8191 + (this.isSetLastAction() ? 131071 : 524287);
        if (this.isSetLastAction()) {
            n = n * 8191 + this.lastAction.hashCode();
        }
        n = n * 8191 + (this.hideLocalAccountEntry ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(Context context) {
        if (!this.getClass().equals(context.getClass())) {
            return this.getClass().getName().compareTo(context.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSessionID(), context.isSetSessionID());
        if (n != 0) {
            return n;
        }
        if (this.isSetSessionID() && (n = TBaseHelper.compareTo((int)this.sessionID, (int)context.sessionID)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetWindowID(), context.isSetWindowID());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowID() && (n = TBaseHelper.compareTo((int)this.windowID, (int)context.windowID)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDatabaseName(), context.isSetDatabaseName());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabaseName() && (n = TBaseHelper.compareTo((String)this.databaseName, (String)context.databaseName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUserName(), context.isSetUserName());
        if (n != 0) {
            return n;
        }
        if (this.isSetUserName() && (n = TBaseHelper.compareTo((String)this.userName, (String)context.userName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccountName(), context.isSetAccountName());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccountName() && (n = TBaseHelper.compareTo((String)this.accountName, (String)context.accountName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutName(), context.isSetLayoutName());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutName() && (n = TBaseHelper.compareTo((String)this.layoutName, (String)context.layoutName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutID(), context.isSetLayoutID());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutID() && (n = TBaseHelper.compareTo((int)this.layoutID, (int)context.layoutID)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutModCount(), context.isSetLayoutModCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutModCount() && (n = TBaseHelper.compareTo((long)this.layoutModCount, (long)context.layoutModCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetViewStyle(), context.isSetViewStyle());
        if (n != 0) {
            return n;
        }
        if (this.isSetViewStyle() && (n = TBaseHelper.compareTo((Comparable)((Object)this.viewStyle), (Comparable)((Object)context.viewStyle))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMode(), context.isSetMode());
        if (n != 0) {
            return n;
        }
        if (this.isSetMode() && (n = TBaseHelper.compareTo((Comparable)((Object)this.mode), (Comparable)((Object)context.mode))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStatusAreaToolbarVisible(), context.isSetStatusAreaToolbarVisible());
        if (n != 0) {
            return n;
        }
        if (this.isSetStatusAreaToolbarVisible() && (n = TBaseHelper.compareTo((boolean)this.statusAreaToolbarVisible, (boolean)context.statusAreaToolbarVisible)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMenubarVisible(), context.isSetMenubarVisible());
        if (n != 0) {
            return n;
        }
        if (this.isSetMenubarVisible() && (n = TBaseHelper.compareTo((boolean)this.menubarVisible, (boolean)context.menubarVisible)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTaskId(), context.isSetTaskId());
        if (n != 0) {
            return n;
        }
        if (this.isSetTaskId() && (n = TBaseHelper.compareTo((long)this.taskId, (long)context.taskId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGuestEnabled(), context.isSetGuestEnabled());
        if (n != 0) {
            return n;
        }
        if (this.isSetGuestEnabled() && (n = TBaseHelper.compareTo((boolean)this.guestEnabled, (boolean)context.guestEnabled)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNotifyPort(), context.isSetNotifyPort());
        if (n != 0) {
            return n;
        }
        if (this.isSetNotifyPort() && (n = TBaseHelper.compareTo((int)this.notifyPort, (int)context.notifyPort)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLastAction(), context.isSetLastAction());
        if (n != 0) {
            return n;
        }
        if (this.isSetLastAction() && (n = TBaseHelper.compareTo((String)this.lastAction, (String)context.lastAction)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideLocalAccountEntry(), context.isSetHideLocalAccountEntry());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideLocalAccountEntry() && (n = TBaseHelper.compareTo((boolean)this.hideLocalAccountEntry, (boolean)context.hideLocalAccountEntry)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Context.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Context.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Context(");
        boolean bl = true;
        stringBuilder.append("sessionID:");
        stringBuilder.append(this.sessionID);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("windowID:");
        stringBuilder.append(this.windowID);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("databaseName:");
        if (this.databaseName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.databaseName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("userName:");
        if (this.userName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.userName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accountName:");
        if (this.accountName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accountName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutName:");
        if (this.layoutName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutID:");
        stringBuilder.append(this.layoutID);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutModCount:");
        stringBuilder.append(this.layoutModCount);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("viewStyle:");
        if (this.viewStyle == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.viewStyle);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("mode:");
        if (this.mode == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.mode);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("statusAreaToolbarVisible:");
        stringBuilder.append(this.statusAreaToolbarVisible);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("menubarVisible:");
        stringBuilder.append(this.menubarVisible);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("taskId:");
        stringBuilder.append(this.taskId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("guestEnabled:");
        stringBuilder.append(this.guestEnabled);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("notifyPort:");
        stringBuilder.append(this.notifyPort);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("lastAction:");
        if (this.lastAction == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.lastAction);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideLocalAccountEntry:");
        stringBuilder.append(this.hideLocalAccountEntry);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (!this.isSetSessionID()) {
            throw new TProtocolException("Required field 'sessionID' is unset! Struct:" + this.toString());
        }
        if (!this.isSetWindowID()) {
            throw new TProtocolException("Required field 'windowID' is unset! Struct:" + this.toString());
        }
        if (!this.isSetDatabaseName()) {
            throw new TProtocolException("Required field 'databaseName' is unset! Struct:" + this.toString());
        }
        if (!this.isSetUserName()) {
            throw new TProtocolException("Required field 'userName' is unset! Struct:" + this.toString());
        }
        if (!this.isSetAccountName()) {
            throw new TProtocolException("Required field 'accountName' is unset! Struct:" + this.toString());
        }
        if (!this.isSetLayoutName()) {
            throw new TProtocolException("Required field 'layoutName' is unset! Struct:" + this.toString());
        }
        if (!this.isSetLayoutID()) {
            throw new TProtocolException("Required field 'layoutID' is unset! Struct:" + this.toString());
        }
        if (!this.isSetLayoutModCount()) {
            throw new TProtocolException("Required field 'layoutModCount' is unset! Struct:" + this.toString());
        }
        if (!this.isSetViewStyle()) {
            throw new TProtocolException("Required field 'viewStyle' is unset! Struct:" + this.toString());
        }
        if (!this.isSetMode()) {
            throw new TProtocolException("Required field 'mode' is unset! Struct:" + this.toString());
        }
        if (!this.isSetStatusAreaToolbarVisible()) {
            throw new TProtocolException("Required field 'statusAreaToolbarVisible' is unset! Struct:" + this.toString());
        }
        if (!this.isSetMenubarVisible()) {
            throw new TProtocolException("Required field 'menubarVisible' is unset! Struct:" + this.toString());
        }
        if (!this.isSetTaskId()) {
            throw new TProtocolException("Required field 'taskId' is unset! Struct:" + this.toString());
        }
        if (!this.isSetNotifyPort()) {
            throw new TProtocolException("Required field 'notifyPort' is unset! Struct:" + this.toString());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            this.write((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((OutputStream)objectOutputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = 0;
            this.read((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((InputStream)objectInputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private static <S extends IScheme> S scheme(TProtocol tProtocol) {
        return (S)(StandardScheme.class.equals((Object)tProtocol.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }

    static {
        EnumMap<_Fields, FieldMetaData> enumMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData("sessionID", 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.WINDOW_ID, new FieldMetaData("windowID", 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.DATABASE_NAME, new FieldMetaData("databaseName", 1, new FieldValueMetaData(11)));
        enumMap.put(_Fields.USER_NAME, new FieldMetaData("userName", 1, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ACCOUNT_NAME, new FieldMetaData("accountName", 1, new FieldValueMetaData(11)));
        enumMap.put(_Fields.LAYOUT_NAME, new FieldMetaData("layoutName", 1, new FieldValueMetaData(11)));
        enumMap.put(_Fields.LAYOUT_ID, new FieldMetaData("layoutID", 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.LAYOUT_MOD_COUNT, new FieldMetaData("layoutModCount", 1, new FieldValueMetaData(10)));
        enumMap.put(_Fields.VIEW_STYLE, new FieldMetaData("viewStyle", 1, (FieldValueMetaData)new EnumMetaData(-1, LayoutViewStyle.class)));
        enumMap.put(_Fields.MODE, new FieldMetaData("mode", 1, (FieldValueMetaData)new EnumMetaData(-1, LayoutMode.class)));
        enumMap.put(_Fields.STATUS_AREA_TOOLBAR_VISIBLE, new FieldMetaData("statusAreaToolbarVisible", 1, new FieldValueMetaData(2)));
        enumMap.put(_Fields.MENUBAR_VISIBLE, new FieldMetaData("menubarVisible", 1, new FieldValueMetaData(2)));
        enumMap.put(_Fields.TASK_ID, new FieldMetaData("taskId", 1, new FieldValueMetaData(10)));
        enumMap.put(_Fields.GUEST_ENABLED, new FieldMetaData("guestEnabled", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.NOTIFY_PORT, new FieldMetaData("notifyPort", 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.LAST_ACTION, new FieldMetaData("lastAction", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.HIDE_LOCAL_ACCOUNT_ENTRY, new FieldMetaData("hideLocalAccountEntry", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Context.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SESSION_ID(1, "sessionID"),
        WINDOW_ID(2, "windowID"),
        DATABASE_NAME(3, "databaseName"),
        USER_NAME(4, "userName"),
        ACCOUNT_NAME(5, "accountName"),
        LAYOUT_NAME(6, "layoutName"),
        LAYOUT_ID(7, "layoutID"),
        LAYOUT_MOD_COUNT(8, "layoutModCount"),
        VIEW_STYLE(9, "viewStyle"),
        MODE(10, "mode"),
        STATUS_AREA_TOOLBAR_VISIBLE(11, "statusAreaToolbarVisible"),
        MENUBAR_VISIBLE(12, "menubarVisible"),
        TASK_ID(13, "taskId"),
        GUEST_ENABLED(14, "guestEnabled"),
        NOTIFY_PORT(15, "notifyPort"),
        LAST_ACTION(16, "lastAction"),
        HIDE_LOCAL_ACCOUNT_ENTRY(17, "hideLocalAccountEntry");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SESSION_ID;
                }
                case 2: {
                    return WINDOW_ID;
                }
                case 3: {
                    return DATABASE_NAME;
                }
                case 4: {
                    return USER_NAME;
                }
                case 5: {
                    return ACCOUNT_NAME;
                }
                case 6: {
                    return LAYOUT_NAME;
                }
                case 7: {
                    return LAYOUT_ID;
                }
                case 8: {
                    return LAYOUT_MOD_COUNT;
                }
                case 9: {
                    return VIEW_STYLE;
                }
                case 10: {
                    return MODE;
                }
                case 11: {
                    return STATUS_AREA_TOOLBAR_VISIBLE;
                }
                case 12: {
                    return MENUBAR_VISIBLE;
                }
                case 13: {
                    return TASK_ID;
                }
                case 14: {
                    return GUEST_ENABLED;
                }
                case 15: {
                    return NOTIFY_PORT;
                }
                case 16: {
                    return LAST_ACTION;
                }
                case 17: {
                    return HIDE_LOCAL_ACCOUNT_ENTRY;
                }
            }
            return null;
        }

        public static _Fields findByThriftIdOrThrow(int n) {
            _Fields _Fields2 = _Fields.findByThriftId(n);
            if (_Fields2 == null) {
                throw new IllegalArgumentException("Field " + n + " doesn't exist!");
            }
            return _Fields2;
        }

        @Nullable
        public static _Fields findByName(String string) {
            return byName.get(string);
        }

        private _Fields(short s, String string2) {
            this._thriftId = s;
            this._fieldName = string2;
        }

        public short getThriftFieldId() {
            return this._thriftId;
        }

        public String getFieldName() {
            return this._fieldName;
        }

        static {
            byName = new HashMap<String, _Fields>();
            for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                byName.put(_Fields2.getFieldName(), _Fields2);
            }
        }
    }

    private static class ContextStandardSchemeFactory
    implements SchemeFactory {
        private ContextStandardSchemeFactory() {
        }

        public ContextStandardScheme getScheme() {
            return new ContextStandardScheme();
        }
    }

    private static class ContextTupleSchemeFactory
    implements SchemeFactory {
        private ContextTupleSchemeFactory() {
        }

        public ContextTupleScheme getScheme() {
            return new ContextTupleScheme();
        }
    }

    private static class ContextTupleScheme
    extends TupleScheme<Context> {
        private ContextTupleScheme() {
        }

        public void write(TProtocol tProtocol, Context context) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            tTupleProtocol.writeI32(context.sessionID);
            tTupleProtocol.writeI32(context.windowID);
            tTupleProtocol.writeString(context.databaseName);
            tTupleProtocol.writeString(context.userName);
            tTupleProtocol.writeString(context.accountName);
            tTupleProtocol.writeString(context.layoutName);
            tTupleProtocol.writeI32(context.layoutID);
            tTupleProtocol.writeI64(context.layoutModCount);
            tTupleProtocol.writeI32(context.viewStyle.getValue());
            tTupleProtocol.writeI32(context.mode.getValue());
            tTupleProtocol.writeBool(context.statusAreaToolbarVisible);
            tTupleProtocol.writeBool(context.menubarVisible);
            tTupleProtocol.writeI64(context.taskId);
            tTupleProtocol.writeI32(context.notifyPort);
            BitSet bitSet = new BitSet();
            if (context.isSetGuestEnabled()) {
                bitSet.set(0);
            }
            if (context.isSetLastAction()) {
                bitSet.set(1);
            }
            if (context.isSetHideLocalAccountEntry()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (context.isSetGuestEnabled()) {
                tTupleProtocol.writeBool(context.guestEnabled);
            }
            if (context.isSetLastAction()) {
                tTupleProtocol.writeString(context.lastAction);
            }
            if (context.isSetHideLocalAccountEntry()) {
                tTupleProtocol.writeBool(context.hideLocalAccountEntry);
            }
        }

        public void read(TProtocol tProtocol, Context context) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            context.sessionID = tTupleProtocol.readI32();
            context.setSessionIDIsSet(true);
            context.windowID = tTupleProtocol.readI32();
            context.setWindowIDIsSet(true);
            context.databaseName = tTupleProtocol.readString();
            context.setDatabaseNameIsSet(true);
            context.userName = tTupleProtocol.readString();
            context.setUserNameIsSet(true);
            context.accountName = tTupleProtocol.readString();
            context.setAccountNameIsSet(true);
            context.layoutName = tTupleProtocol.readString();
            context.setLayoutNameIsSet(true);
            context.layoutID = tTupleProtocol.readI32();
            context.setLayoutIDIsSet(true);
            context.layoutModCount = tTupleProtocol.readI64();
            context.setLayoutModCountIsSet(true);
            context.viewStyle = LayoutViewStyle.findByValue(tTupleProtocol.readI32());
            context.setViewStyleIsSet(true);
            context.mode = LayoutMode.findByValue(tTupleProtocol.readI32());
            context.setModeIsSet(true);
            context.statusAreaToolbarVisible = tTupleProtocol.readBool();
            context.setStatusAreaToolbarVisibleIsSet(true);
            context.menubarVisible = tTupleProtocol.readBool();
            context.setMenubarVisibleIsSet(true);
            context.taskId = tTupleProtocol.readI64();
            context.setTaskIdIsSet(true);
            context.notifyPort = tTupleProtocol.readI32();
            context.setNotifyPortIsSet(true);
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                context.guestEnabled = tTupleProtocol.readBool();
                context.setGuestEnabledIsSet(true);
            }
            if (bitSet.get(1)) {
                context.lastAction = tTupleProtocol.readString();
                context.setLastActionIsSet(true);
            }
            if (bitSet.get(2)) {
                context.hideLocalAccountEntry = tTupleProtocol.readBool();
                context.setHideLocalAccountEntryIsSet(true);
            }
        }
    }

    private static class ContextStandardScheme
    extends StandardScheme<Context> {
        private ContextStandardScheme() {
        }

        public void read(TProtocol tProtocol, Context context) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            context.sessionID = tProtocol.readI32();
                            context.setSessionIDIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            context.windowID = tProtocol.readI32();
                            context.setWindowIDIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            context.databaseName = tProtocol.readString();
                            context.setDatabaseNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            context.userName = tProtocol.readString();
                            context.setUserNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            context.accountName = tProtocol.readString();
                            context.setAccountNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            context.layoutName = tProtocol.readString();
                            context.setLayoutNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            context.layoutID = tProtocol.readI32();
                            context.setLayoutIDIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 10) {
                            context.layoutModCount = tProtocol.readI64();
                            context.setLayoutModCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 8) {
                            context.viewStyle = LayoutViewStyle.findByValue(tProtocol.readI32());
                            context.setViewStyleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 8) {
                            context.mode = LayoutMode.findByValue(tProtocol.readI32());
                            context.setModeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 2) {
                            context.statusAreaToolbarVisible = tProtocol.readBool();
                            context.setStatusAreaToolbarVisibleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 2) {
                            context.menubarVisible = tProtocol.readBool();
                            context.setMenubarVisibleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 10) {
                            context.taskId = tProtocol.readI64();
                            context.setTaskIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 14: {
                        if (tField.type == 2) {
                            context.guestEnabled = tProtocol.readBool();
                            context.setGuestEnabledIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 15: {
                        if (tField.type == 8) {
                            context.notifyPort = tProtocol.readI32();
                            context.setNotifyPortIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 16: {
                        if (tField.type == 11) {
                            context.lastAction = tProtocol.readString();
                            context.setLastActionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 17: {
                        if (tField.type == 2) {
                            context.hideLocalAccountEntry = tProtocol.readBool();
                            context.setHideLocalAccountEntryIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    default: {
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    }
                }
                tProtocol.readFieldEnd();
            }
            tProtocol.readStructEnd();
            context.validate();
        }

        public void write(TProtocol tProtocol, Context context) throws TException {
            context.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(SESSION_ID_FIELD_DESC);
            tProtocol.writeI32(context.sessionID);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(WINDOW_ID_FIELD_DESC);
            tProtocol.writeI32(context.windowID);
            tProtocol.writeFieldEnd();
            if (context.databaseName != null) {
                tProtocol.writeFieldBegin(DATABASE_NAME_FIELD_DESC);
                tProtocol.writeString(context.databaseName);
                tProtocol.writeFieldEnd();
            }
            if (context.userName != null) {
                tProtocol.writeFieldBegin(USER_NAME_FIELD_DESC);
                tProtocol.writeString(context.userName);
                tProtocol.writeFieldEnd();
            }
            if (context.accountName != null) {
                tProtocol.writeFieldBegin(ACCOUNT_NAME_FIELD_DESC);
                tProtocol.writeString(context.accountName);
                tProtocol.writeFieldEnd();
            }
            if (context.layoutName != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAME_FIELD_DESC);
                tProtocol.writeString(context.layoutName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(LAYOUT_ID_FIELD_DESC);
            tProtocol.writeI32(context.layoutID);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(LAYOUT_MOD_COUNT_FIELD_DESC);
            tProtocol.writeI64(context.layoutModCount);
            tProtocol.writeFieldEnd();
            if (context.viewStyle != null) {
                tProtocol.writeFieldBegin(VIEW_STYLE_FIELD_DESC);
                tProtocol.writeI32(context.viewStyle.getValue());
                tProtocol.writeFieldEnd();
            }
            if (context.mode != null) {
                tProtocol.writeFieldBegin(MODE_FIELD_DESC);
                tProtocol.writeI32(context.mode.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(STATUS_AREA_TOOLBAR_VISIBLE_FIELD_DESC);
            tProtocol.writeBool(context.statusAreaToolbarVisible);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MENUBAR_VISIBLE_FIELD_DESC);
            tProtocol.writeBool(context.menubarVisible);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(TASK_ID_FIELD_DESC);
            tProtocol.writeI64(context.taskId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(GUEST_ENABLED_FIELD_DESC);
            tProtocol.writeBool(context.guestEnabled);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(NOTIFY_PORT_FIELD_DESC);
            tProtocol.writeI32(context.notifyPort);
            tProtocol.writeFieldEnd();
            if (context.lastAction != null) {
                tProtocol.writeFieldBegin(LAST_ACTION_FIELD_DESC);
                tProtocol.writeString(context.lastAction);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_LOCAL_ACCOUNT_ENTRY_FIELD_DESC);
            tProtocol.writeBool(context.hideLocalAccountEntry);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

