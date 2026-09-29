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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
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
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class UserPrivileges
implements TBase<UserPrivileges, _Fields>,
Serializable,
Cloneable,
Comparable<UserPrivileges> {
    private static final TStruct STRUCT_DESC = new TStruct("UserPrivileges");
    private static final TField RECORD_ACCESS_FIELD_DESC = new TField("recordAccess", 8, 1);
    private static final TField FIELD_ACCESS_FIELD_DESC = new TField("fieldAccess", 8, 2);
    private static final TField LAYOUT_ACCESS_FIELD_DESC = new TField("layoutAccess", 8, 3);
    private static final TField VALUE_LIST_ACCESS_FIELD_DESC = new TField("valueListAccess", 8, 4);
    private static final TField SCRIPT_ACCESS_FIELD_DESC = new TField("scriptAccess", 8, 5);
    private static final TField VIEW_STYLE_ACCESS_FIELD_DESC = new TField("viewStyleAccess", 8, 6);
    private static final TField EXPORT_ACCESS_FIELD_DESC = new TField("exportAccess", 2, 7);
    private static final TField PRINT_ACCESS_FIELD_DESC = new TField("printAccess", 2, 8);
    private static final TField PW_ACCESS_FIELD_DESC = new TField("pwAccess", 2, 9);
    private static final TField RECORD_PRIV_SET_FIELD_DESC = new TField("recordPrivSet", 8, 10);
    private static final TField MODE_PRIV_SET_FIELD_DESC = new TField("modePrivSet", 8, 11);
    private static final TField FIND_PRIV_SET_FIELD_DESC = new TField("findPrivSet", 8, 12);
    private static final TField MISC_PRIV_SET_FIELD_DESC = new TField("miscPrivSet", 8, 13);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new UserPrivilegesStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new UserPrivilegesTupleSchemeFactory();
    private int recordAccess;
    @Nullable
    private DBAccessLevel fieldAccess;
    @Nullable
    private DBAccessLevel layoutAccess;
    @Nullable
    private DBAccessLevel valueListAccess;
    @Nullable
    private DBAccessLevel scriptAccess;
    private int viewStyleAccess;
    private boolean exportAccess;
    private boolean printAccess;
    private boolean pwAccess;
    private int recordPrivSet;
    private int modePrivSet;
    private int findPrivSet;
    private int miscPrivSet;
    private static final int __RECORDACCESS_ISSET_ID = 0;
    private static final int __VIEWSTYLEACCESS_ISSET_ID = 1;
    private static final int __EXPORTACCESS_ISSET_ID = 2;
    private static final int __PRINTACCESS_ISSET_ID = 3;
    private static final int __PWACCESS_ISSET_ID = 4;
    private static final int __RECORDPRIVSET_ISSET_ID = 5;
    private static final int __MODEPRIVSET_ISSET_ID = 6;
    private static final int __FINDPRIVSET_ISSET_ID = 7;
    private static final int __MISCPRIVSET_ISSET_ID = 8;
    private short __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public UserPrivileges() {
        this.recordAccess = 0;
        this.fieldAccess = DBAccessLevel.UnknownAccess;
        this.layoutAccess = DBAccessLevel.UnknownAccess;
        this.valueListAccess = DBAccessLevel.UnknownAccess;
        this.scriptAccess = DBAccessLevel.UnknownAccess;
        this.viewStyleAccess = 0;
    }

    public UserPrivileges(int n, DBAccessLevel dBAccessLevel, DBAccessLevel dBAccessLevel2, DBAccessLevel dBAccessLevel3, DBAccessLevel dBAccessLevel4, int n2, boolean bl, boolean bl2, boolean bl3, int n3, int n4, int n5, int n6) {
        this();
        this.recordAccess = n;
        this.setRecordAccessIsSet(true);
        this.fieldAccess = dBAccessLevel;
        this.layoutAccess = dBAccessLevel2;
        this.valueListAccess = dBAccessLevel3;
        this.scriptAccess = dBAccessLevel4;
        this.viewStyleAccess = n2;
        this.setViewStyleAccessIsSet(true);
        this.exportAccess = bl;
        this.setExportAccessIsSet(true);
        this.printAccess = bl2;
        this.setPrintAccessIsSet(true);
        this.pwAccess = bl3;
        this.setPwAccessIsSet(true);
        this.recordPrivSet = n3;
        this.setRecordPrivSetIsSet(true);
        this.modePrivSet = n4;
        this.setModePrivSetIsSet(true);
        this.findPrivSet = n5;
        this.setFindPrivSetIsSet(true);
        this.miscPrivSet = n6;
        this.setMiscPrivSetIsSet(true);
    }

    public UserPrivileges(UserPrivileges userPrivileges) {
        this.__isset_bitfield = userPrivileges.__isset_bitfield;
        this.recordAccess = userPrivileges.recordAccess;
        if (userPrivileges.isSetFieldAccess()) {
            this.fieldAccess = userPrivileges.fieldAccess;
        }
        if (userPrivileges.isSetLayoutAccess()) {
            this.layoutAccess = userPrivileges.layoutAccess;
        }
        if (userPrivileges.isSetValueListAccess()) {
            this.valueListAccess = userPrivileges.valueListAccess;
        }
        if (userPrivileges.isSetScriptAccess()) {
            this.scriptAccess = userPrivileges.scriptAccess;
        }
        this.viewStyleAccess = userPrivileges.viewStyleAccess;
        this.exportAccess = userPrivileges.exportAccess;
        this.printAccess = userPrivileges.printAccess;
        this.pwAccess = userPrivileges.pwAccess;
        this.recordPrivSet = userPrivileges.recordPrivSet;
        this.modePrivSet = userPrivileges.modePrivSet;
        this.findPrivSet = userPrivileges.findPrivSet;
        this.miscPrivSet = userPrivileges.miscPrivSet;
    }

    public UserPrivileges deepCopy() {
        return new UserPrivileges(this);
    }

    public void clear() {
        this.recordAccess = 0;
        this.fieldAccess = DBAccessLevel.UnknownAccess;
        this.layoutAccess = DBAccessLevel.UnknownAccess;
        this.valueListAccess = DBAccessLevel.UnknownAccess;
        this.scriptAccess = DBAccessLevel.UnknownAccess;
        this.viewStyleAccess = 0;
        this.setExportAccessIsSet(false);
        this.exportAccess = false;
        this.setPrintAccessIsSet(false);
        this.printAccess = false;
        this.setPwAccessIsSet(false);
        this.pwAccess = false;
        this.setRecordPrivSetIsSet(false);
        this.recordPrivSet = 0;
        this.setModePrivSetIsSet(false);
        this.modePrivSet = 0;
        this.setFindPrivSetIsSet(false);
        this.findPrivSet = 0;
        this.setMiscPrivSetIsSet(false);
        this.miscPrivSet = 0;
    }

    public int getRecordAccess() {
        return this.recordAccess;
    }

    public void setRecordAccess(int n) {
        this.recordAccess = n;
        this.setRecordAccessIsSet(true);
    }

    public void unsetRecordAccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)0);
    }

    public boolean isSetRecordAccess() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)0);
    }

    public void setRecordAccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public DBAccessLevel getFieldAccess() {
        return this.fieldAccess;
    }

    public void setFieldAccess(@Nullable DBAccessLevel dBAccessLevel) {
        this.fieldAccess = dBAccessLevel;
    }

    public void unsetFieldAccess() {
        this.fieldAccess = null;
    }

    public boolean isSetFieldAccess() {
        return this.fieldAccess != null;
    }

    public void setFieldAccessIsSet(boolean bl) {
        if (!bl) {
            this.fieldAccess = null;
        }
    }

    @Nullable
    public DBAccessLevel getLayoutAccess() {
        return this.layoutAccess;
    }

    public void setLayoutAccess(@Nullable DBAccessLevel dBAccessLevel) {
        this.layoutAccess = dBAccessLevel;
    }

    public void unsetLayoutAccess() {
        this.layoutAccess = null;
    }

    public boolean isSetLayoutAccess() {
        return this.layoutAccess != null;
    }

    public void setLayoutAccessIsSet(boolean bl) {
        if (!bl) {
            this.layoutAccess = null;
        }
    }

    @Nullable
    public DBAccessLevel getValueListAccess() {
        return this.valueListAccess;
    }

    public void setValueListAccess(@Nullable DBAccessLevel dBAccessLevel) {
        this.valueListAccess = dBAccessLevel;
    }

    public void unsetValueListAccess() {
        this.valueListAccess = null;
    }

    public boolean isSetValueListAccess() {
        return this.valueListAccess != null;
    }

    public void setValueListAccessIsSet(boolean bl) {
        if (!bl) {
            this.valueListAccess = null;
        }
    }

    @Nullable
    public DBAccessLevel getScriptAccess() {
        return this.scriptAccess;
    }

    public void setScriptAccess(@Nullable DBAccessLevel dBAccessLevel) {
        this.scriptAccess = dBAccessLevel;
    }

    public void unsetScriptAccess() {
        this.scriptAccess = null;
    }

    public boolean isSetScriptAccess() {
        return this.scriptAccess != null;
    }

    public void setScriptAccessIsSet(boolean bl) {
        if (!bl) {
            this.scriptAccess = null;
        }
    }

    public int getViewStyleAccess() {
        return this.viewStyleAccess;
    }

    public void setViewStyleAccess(int n) {
        this.viewStyleAccess = n;
        this.setViewStyleAccessIsSet(true);
    }

    public void unsetViewStyleAccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)1);
    }

    public boolean isSetViewStyleAccess() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)1);
    }

    public void setViewStyleAccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isExportAccess() {
        return this.exportAccess;
    }

    public void setExportAccess(boolean bl) {
        this.exportAccess = bl;
        this.setExportAccessIsSet(true);
    }

    public void unsetExportAccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)2);
    }

    public boolean isSetExportAccess() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)2);
    }

    public void setExportAccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isPrintAccess() {
        return this.printAccess;
    }

    public void setPrintAccess(boolean bl) {
        this.printAccess = bl;
        this.setPrintAccessIsSet(true);
    }

    public void unsetPrintAccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)3);
    }

    public boolean isSetPrintAccess() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)3);
    }

    public void setPrintAccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public boolean isPwAccess() {
        return this.pwAccess;
    }

    public void setPwAccess(boolean bl) {
        this.pwAccess = bl;
        this.setPwAccessIsSet(true);
    }

    public void unsetPwAccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)4);
    }

    public boolean isSetPwAccess() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)4);
    }

    public void setPwAccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getRecordPrivSet() {
        return this.recordPrivSet;
    }

    public void setRecordPrivSet(int n) {
        this.recordPrivSet = n;
        this.setRecordPrivSetIsSet(true);
    }

    public void unsetRecordPrivSet() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)5);
    }

    public boolean isSetRecordPrivSet() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)5);
    }

    public void setRecordPrivSetIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public int getModePrivSet() {
        return this.modePrivSet;
    }

    public void setModePrivSet(int n) {
        this.modePrivSet = n;
        this.setModePrivSetIsSet(true);
    }

    public void unsetModePrivSet() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)6);
    }

    public boolean isSetModePrivSet() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)6);
    }

    public void setModePrivSetIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    public int getFindPrivSet() {
        return this.findPrivSet;
    }

    public void setFindPrivSet(int n) {
        this.findPrivSet = n;
        this.setFindPrivSetIsSet(true);
    }

    public void unsetFindPrivSet() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)7);
    }

    public boolean isSetFindPrivSet() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)7);
    }

    public void setFindPrivSetIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    public int getMiscPrivSet() {
        return this.miscPrivSet;
    }

    public void setMiscPrivSet(int n) {
        this.miscPrivSet = n;
        this.setMiscPrivSetIsSet(true);
    }

    public void unsetMiscPrivSet() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)8);
    }

    public boolean isSetMiscPrivSet() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)8);
    }

    public void setMiscPrivSetIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)8, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRecordAccess();
                    break;
                }
                this.setRecordAccess((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetFieldAccess();
                    break;
                }
                this.setFieldAccess((DBAccessLevel)((Object)object));
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetLayoutAccess();
                    break;
                }
                this.setLayoutAccess((DBAccessLevel)((Object)object));
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetValueListAccess();
                    break;
                }
                this.setValueListAccess((DBAccessLevel)((Object)object));
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetScriptAccess();
                    break;
                }
                this.setScriptAccess((DBAccessLevel)((Object)object));
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetViewStyleAccess();
                    break;
                }
                this.setViewStyleAccess((Integer)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetExportAccess();
                    break;
                }
                this.setExportAccess((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetPrintAccess();
                    break;
                }
                this.setPrintAccess((Boolean)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetPwAccess();
                    break;
                }
                this.setPwAccess((Boolean)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetRecordPrivSet();
                    break;
                }
                this.setRecordPrivSet((Integer)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetModePrivSet();
                    break;
                }
                this.setModePrivSet((Integer)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetFindPrivSet();
                    break;
                }
                this.setFindPrivSet((Integer)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetMiscPrivSet();
                    break;
                }
                this.setMiscPrivSet((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRecordAccess();
            }
            case 1: {
                return this.getFieldAccess();
            }
            case 2: {
                return this.getLayoutAccess();
            }
            case 3: {
                return this.getValueListAccess();
            }
            case 4: {
                return this.getScriptAccess();
            }
            case 5: {
                return this.getViewStyleAccess();
            }
            case 6: {
                return this.isExportAccess();
            }
            case 7: {
                return this.isPrintAccess();
            }
            case 8: {
                return this.isPwAccess();
            }
            case 9: {
                return this.getRecordPrivSet();
            }
            case 10: {
                return this.getModePrivSet();
            }
            case 11: {
                return this.getFindPrivSet();
            }
            case 12: {
                return this.getMiscPrivSet();
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
                return this.isSetRecordAccess();
            }
            case 1: {
                return this.isSetFieldAccess();
            }
            case 2: {
                return this.isSetLayoutAccess();
            }
            case 3: {
                return this.isSetValueListAccess();
            }
            case 4: {
                return this.isSetScriptAccess();
            }
            case 5: {
                return this.isSetViewStyleAccess();
            }
            case 6: {
                return this.isSetExportAccess();
            }
            case 7: {
                return this.isSetPrintAccess();
            }
            case 8: {
                return this.isSetPwAccess();
            }
            case 9: {
                return this.isSetRecordPrivSet();
            }
            case 10: {
                return this.isSetModePrivSet();
            }
            case 11: {
                return this.isSetFindPrivSet();
            }
            case 12: {
                return this.isSetMiscPrivSet();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof UserPrivileges) {
            return this.equals((UserPrivileges)object);
        }
        return false;
    }

    public boolean equals(UserPrivileges userPrivileges) {
        if (userPrivileges == null) {
            return false;
        }
        if (this == userPrivileges) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.recordAccess != userPrivileges.recordAccess) {
                return false;
            }
        }
        boolean bl3 = this.isSetFieldAccess();
        boolean bl4 = userPrivileges.isSetFieldAccess();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.fieldAccess.equals((Object)userPrivileges.fieldAccess)) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayoutAccess();
        boolean bl6 = userPrivileges.isSetLayoutAccess();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layoutAccess.equals((Object)userPrivileges.layoutAccess)) {
                return false;
            }
        }
        boolean bl7 = this.isSetValueListAccess();
        boolean bl8 = userPrivileges.isSetValueListAccess();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.valueListAccess.equals((Object)userPrivileges.valueListAccess)) {
                return false;
            }
        }
        boolean bl9 = this.isSetScriptAccess();
        boolean bl10 = userPrivileges.isSetScriptAccess();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.scriptAccess.equals((Object)userPrivileges.scriptAccess)) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.viewStyleAccess != userPrivileges.viewStyleAccess) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.exportAccess != userPrivileges.exportAccess) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.printAccess != userPrivileges.printAccess) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.pwAccess != userPrivileges.pwAccess) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.recordPrivSet != userPrivileges.recordPrivSet) {
                return false;
            }
        }
        boolean bl21 = true;
        boolean bl22 = true;
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (this.modePrivSet != userPrivileges.modePrivSet) {
                return false;
            }
        }
        boolean bl23 = true;
        boolean bl24 = true;
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (this.findPrivSet != userPrivileges.findPrivSet) {
                return false;
            }
        }
        boolean bl25 = true;
        boolean bl26 = true;
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (this.miscPrivSet != userPrivileges.miscPrivSet) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.recordAccess;
        n = n * 8191 + (this.isSetFieldAccess() ? 131071 : 524287);
        if (this.isSetFieldAccess()) {
            n = n * 8191 + this.fieldAccess.getValue();
        }
        n = n * 8191 + (this.isSetLayoutAccess() ? 131071 : 524287);
        if (this.isSetLayoutAccess()) {
            n = n * 8191 + this.layoutAccess.getValue();
        }
        n = n * 8191 + (this.isSetValueListAccess() ? 131071 : 524287);
        if (this.isSetValueListAccess()) {
            n = n * 8191 + this.valueListAccess.getValue();
        }
        n = n * 8191 + (this.isSetScriptAccess() ? 131071 : 524287);
        if (this.isSetScriptAccess()) {
            n = n * 8191 + this.scriptAccess.getValue();
        }
        n = n * 8191 + this.viewStyleAccess;
        n = n * 8191 + (this.exportAccess ? 131071 : 524287);
        n = n * 8191 + (this.printAccess ? 131071 : 524287);
        n = n * 8191 + (this.pwAccess ? 131071 : 524287);
        n = n * 8191 + this.recordPrivSet;
        n = n * 8191 + this.modePrivSet;
        n = n * 8191 + this.findPrivSet;
        n = n * 8191 + this.miscPrivSet;
        return n;
    }

    @Override
    public int compareTo(UserPrivileges userPrivileges) {
        if (!this.getClass().equals(userPrivileges.getClass())) {
            return this.getClass().getName().compareTo(userPrivileges.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRecordAccess(), userPrivileges.isSetRecordAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordAccess() && (n = TBaseHelper.compareTo((int)this.recordAccess, (int)userPrivileges.recordAccess)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldAccess(), userPrivileges.isSetFieldAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldAccess() && (n = TBaseHelper.compareTo((Comparable)((Object)this.fieldAccess), (Comparable)((Object)userPrivileges.fieldAccess))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutAccess(), userPrivileges.isSetLayoutAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutAccess() && (n = TBaseHelper.compareTo((Comparable)((Object)this.layoutAccess), (Comparable)((Object)userPrivileges.layoutAccess))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueListAccess(), userPrivileges.isSetValueListAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueListAccess() && (n = TBaseHelper.compareTo((Comparable)((Object)this.valueListAccess), (Comparable)((Object)userPrivileges.valueListAccess))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptAccess(), userPrivileges.isSetScriptAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptAccess() && (n = TBaseHelper.compareTo((Comparable)((Object)this.scriptAccess), (Comparable)((Object)userPrivileges.scriptAccess))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetViewStyleAccess(), userPrivileges.isSetViewStyleAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetViewStyleAccess() && (n = TBaseHelper.compareTo((int)this.viewStyleAccess, (int)userPrivileges.viewStyleAccess)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetExportAccess(), userPrivileges.isSetExportAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetExportAccess() && (n = TBaseHelper.compareTo((boolean)this.exportAccess, (boolean)userPrivileges.exportAccess)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPrintAccess(), userPrivileges.isSetPrintAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetPrintAccess() && (n = TBaseHelper.compareTo((boolean)this.printAccess, (boolean)userPrivileges.printAccess)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPwAccess(), userPrivileges.isSetPwAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetPwAccess() && (n = TBaseHelper.compareTo((boolean)this.pwAccess, (boolean)userPrivileges.pwAccess)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecordPrivSet(), userPrivileges.isSetRecordPrivSet());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordPrivSet() && (n = TBaseHelper.compareTo((int)this.recordPrivSet, (int)userPrivileges.recordPrivSet)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModePrivSet(), userPrivileges.isSetModePrivSet());
        if (n != 0) {
            return n;
        }
        if (this.isSetModePrivSet() && (n = TBaseHelper.compareTo((int)this.modePrivSet, (int)userPrivileges.modePrivSet)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFindPrivSet(), userPrivileges.isSetFindPrivSet());
        if (n != 0) {
            return n;
        }
        if (this.isSetFindPrivSet() && (n = TBaseHelper.compareTo((int)this.findPrivSet, (int)userPrivileges.findPrivSet)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMiscPrivSet(), userPrivileges.isSetMiscPrivSet());
        if (n != 0) {
            return n;
        }
        if (this.isSetMiscPrivSet() && (n = TBaseHelper.compareTo((int)this.miscPrivSet, (int)userPrivileges.miscPrivSet)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        UserPrivileges.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        UserPrivileges.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserPrivileges(");
        boolean bl = true;
        stringBuilder.append("recordAccess:");
        stringBuilder.append(this.recordAccess);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldAccess:");
        if (this.fieldAccess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.fieldAccess);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutAccess:");
        if (this.layoutAccess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.layoutAccess);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueListAccess:");
        if (this.valueListAccess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.valueListAccess);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptAccess:");
        if (this.scriptAccess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.scriptAccess);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("viewStyleAccess:");
        stringBuilder.append(this.viewStyleAccess);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("exportAccess:");
        stringBuilder.append(this.exportAccess);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("printAccess:");
        stringBuilder.append(this.printAccess);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("pwAccess:");
        stringBuilder.append(this.pwAccess);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("recordPrivSet:");
        stringBuilder.append(this.recordPrivSet);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("modePrivSet:");
        stringBuilder.append(this.modePrivSet);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("findPrivSet:");
        stringBuilder.append(this.findPrivSet);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("miscPrivSet:");
        stringBuilder.append(this.miscPrivSet);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
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
        enumMap.put(_Fields.RECORD_ACCESS, new FieldMetaData("recordAccess", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIELD_ACCESS, new FieldMetaData("fieldAccess", 3, (FieldValueMetaData)new EnumMetaData(-1, DBAccessLevel.class)));
        enumMap.put(_Fields.LAYOUT_ACCESS, new FieldMetaData("layoutAccess", 3, (FieldValueMetaData)new EnumMetaData(-1, DBAccessLevel.class)));
        enumMap.put(_Fields.VALUE_LIST_ACCESS, new FieldMetaData("valueListAccess", 3, (FieldValueMetaData)new EnumMetaData(-1, DBAccessLevel.class)));
        enumMap.put(_Fields.SCRIPT_ACCESS, new FieldMetaData("scriptAccess", 3, (FieldValueMetaData)new EnumMetaData(-1, DBAccessLevel.class)));
        enumMap.put(_Fields.VIEW_STYLE_ACCESS, new FieldMetaData("viewStyleAccess", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.EXPORT_ACCESS, new FieldMetaData("exportAccess", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.PRINT_ACCESS, new FieldMetaData("printAccess", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.PW_ACCESS, new FieldMetaData("pwAccess", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.RECORD_PRIV_SET, new FieldMetaData("recordPrivSet", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MODE_PRIV_SET, new FieldMetaData("modePrivSet", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIND_PRIV_SET, new FieldMetaData("findPrivSet", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MISC_PRIV_SET, new FieldMetaData("miscPrivSet", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(UserPrivileges.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RECORD_ACCESS(1, "recordAccess"),
        FIELD_ACCESS(2, "fieldAccess"),
        LAYOUT_ACCESS(3, "layoutAccess"),
        VALUE_LIST_ACCESS(4, "valueListAccess"),
        SCRIPT_ACCESS(5, "scriptAccess"),
        VIEW_STYLE_ACCESS(6, "viewStyleAccess"),
        EXPORT_ACCESS(7, "exportAccess"),
        PRINT_ACCESS(8, "printAccess"),
        PW_ACCESS(9, "pwAccess"),
        RECORD_PRIV_SET(10, "recordPrivSet"),
        MODE_PRIV_SET(11, "modePrivSet"),
        FIND_PRIV_SET(12, "findPrivSet"),
        MISC_PRIV_SET(13, "miscPrivSet");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RECORD_ACCESS;
                }
                case 2: {
                    return FIELD_ACCESS;
                }
                case 3: {
                    return LAYOUT_ACCESS;
                }
                case 4: {
                    return VALUE_LIST_ACCESS;
                }
                case 5: {
                    return SCRIPT_ACCESS;
                }
                case 6: {
                    return VIEW_STYLE_ACCESS;
                }
                case 7: {
                    return EXPORT_ACCESS;
                }
                case 8: {
                    return PRINT_ACCESS;
                }
                case 9: {
                    return PW_ACCESS;
                }
                case 10: {
                    return RECORD_PRIV_SET;
                }
                case 11: {
                    return MODE_PRIV_SET;
                }
                case 12: {
                    return FIND_PRIV_SET;
                }
                case 13: {
                    return MISC_PRIV_SET;
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

    private static class UserPrivilegesStandardSchemeFactory
    implements SchemeFactory {
        private UserPrivilegesStandardSchemeFactory() {
        }

        public UserPrivilegesStandardScheme getScheme() {
            return new UserPrivilegesStandardScheme();
        }
    }

    private static class UserPrivilegesTupleSchemeFactory
    implements SchemeFactory {
        private UserPrivilegesTupleSchemeFactory() {
        }

        public UserPrivilegesTupleScheme getScheme() {
            return new UserPrivilegesTupleScheme();
        }
    }

    private static class UserPrivilegesTupleScheme
    extends TupleScheme<UserPrivileges> {
        private UserPrivilegesTupleScheme() {
        }

        public void write(TProtocol tProtocol, UserPrivileges userPrivileges) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (userPrivileges.isSetRecordAccess()) {
                bitSet.set(0);
            }
            if (userPrivileges.isSetFieldAccess()) {
                bitSet.set(1);
            }
            if (userPrivileges.isSetLayoutAccess()) {
                bitSet.set(2);
            }
            if (userPrivileges.isSetValueListAccess()) {
                bitSet.set(3);
            }
            if (userPrivileges.isSetScriptAccess()) {
                bitSet.set(4);
            }
            if (userPrivileges.isSetViewStyleAccess()) {
                bitSet.set(5);
            }
            if (userPrivileges.isSetExportAccess()) {
                bitSet.set(6);
            }
            if (userPrivileges.isSetPrintAccess()) {
                bitSet.set(7);
            }
            if (userPrivileges.isSetPwAccess()) {
                bitSet.set(8);
            }
            if (userPrivileges.isSetRecordPrivSet()) {
                bitSet.set(9);
            }
            if (userPrivileges.isSetModePrivSet()) {
                bitSet.set(10);
            }
            if (userPrivileges.isSetFindPrivSet()) {
                bitSet.set(11);
            }
            if (userPrivileges.isSetMiscPrivSet()) {
                bitSet.set(12);
            }
            tTupleProtocol.writeBitSet(bitSet, 13);
            if (userPrivileges.isSetRecordAccess()) {
                tTupleProtocol.writeI32(userPrivileges.recordAccess);
            }
            if (userPrivileges.isSetFieldAccess()) {
                tTupleProtocol.writeI32(userPrivileges.fieldAccess.getValue());
            }
            if (userPrivileges.isSetLayoutAccess()) {
                tTupleProtocol.writeI32(userPrivileges.layoutAccess.getValue());
            }
            if (userPrivileges.isSetValueListAccess()) {
                tTupleProtocol.writeI32(userPrivileges.valueListAccess.getValue());
            }
            if (userPrivileges.isSetScriptAccess()) {
                tTupleProtocol.writeI32(userPrivileges.scriptAccess.getValue());
            }
            if (userPrivileges.isSetViewStyleAccess()) {
                tTupleProtocol.writeI32(userPrivileges.viewStyleAccess);
            }
            if (userPrivileges.isSetExportAccess()) {
                tTupleProtocol.writeBool(userPrivileges.exportAccess);
            }
            if (userPrivileges.isSetPrintAccess()) {
                tTupleProtocol.writeBool(userPrivileges.printAccess);
            }
            if (userPrivileges.isSetPwAccess()) {
                tTupleProtocol.writeBool(userPrivileges.pwAccess);
            }
            if (userPrivileges.isSetRecordPrivSet()) {
                tTupleProtocol.writeI32(userPrivileges.recordPrivSet);
            }
            if (userPrivileges.isSetModePrivSet()) {
                tTupleProtocol.writeI32(userPrivileges.modePrivSet);
            }
            if (userPrivileges.isSetFindPrivSet()) {
                tTupleProtocol.writeI32(userPrivileges.findPrivSet);
            }
            if (userPrivileges.isSetMiscPrivSet()) {
                tTupleProtocol.writeI32(userPrivileges.miscPrivSet);
            }
        }

        public void read(TProtocol tProtocol, UserPrivileges userPrivileges) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(13);
            if (bitSet.get(0)) {
                userPrivileges.recordAccess = tTupleProtocol.readI32();
                userPrivileges.setRecordAccessIsSet(true);
            }
            if (bitSet.get(1)) {
                userPrivileges.fieldAccess = DBAccessLevel.findByValue(tTupleProtocol.readI32());
                userPrivileges.setFieldAccessIsSet(true);
            }
            if (bitSet.get(2)) {
                userPrivileges.layoutAccess = DBAccessLevel.findByValue(tTupleProtocol.readI32());
                userPrivileges.setLayoutAccessIsSet(true);
            }
            if (bitSet.get(3)) {
                userPrivileges.valueListAccess = DBAccessLevel.findByValue(tTupleProtocol.readI32());
                userPrivileges.setValueListAccessIsSet(true);
            }
            if (bitSet.get(4)) {
                userPrivileges.scriptAccess = DBAccessLevel.findByValue(tTupleProtocol.readI32());
                userPrivileges.setScriptAccessIsSet(true);
            }
            if (bitSet.get(5)) {
                userPrivileges.viewStyleAccess = tTupleProtocol.readI32();
                userPrivileges.setViewStyleAccessIsSet(true);
            }
            if (bitSet.get(6)) {
                userPrivileges.exportAccess = tTupleProtocol.readBool();
                userPrivileges.setExportAccessIsSet(true);
            }
            if (bitSet.get(7)) {
                userPrivileges.printAccess = tTupleProtocol.readBool();
                userPrivileges.setPrintAccessIsSet(true);
            }
            if (bitSet.get(8)) {
                userPrivileges.pwAccess = tTupleProtocol.readBool();
                userPrivileges.setPwAccessIsSet(true);
            }
            if (bitSet.get(9)) {
                userPrivileges.recordPrivSet = tTupleProtocol.readI32();
                userPrivileges.setRecordPrivSetIsSet(true);
            }
            if (bitSet.get(10)) {
                userPrivileges.modePrivSet = tTupleProtocol.readI32();
                userPrivileges.setModePrivSetIsSet(true);
            }
            if (bitSet.get(11)) {
                userPrivileges.findPrivSet = tTupleProtocol.readI32();
                userPrivileges.setFindPrivSetIsSet(true);
            }
            if (bitSet.get(12)) {
                userPrivileges.miscPrivSet = tTupleProtocol.readI32();
                userPrivileges.setMiscPrivSetIsSet(true);
            }
        }
    }

    private static class UserPrivilegesStandardScheme
    extends StandardScheme<UserPrivileges> {
        private UserPrivilegesStandardScheme() {
        }

        public void read(TProtocol tProtocol, UserPrivileges userPrivileges) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            userPrivileges.recordAccess = tProtocol.readI32();
                            userPrivileges.setRecordAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            userPrivileges.fieldAccess = DBAccessLevel.findByValue(tProtocol.readI32());
                            userPrivileges.setFieldAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            userPrivileges.layoutAccess = DBAccessLevel.findByValue(tProtocol.readI32());
                            userPrivileges.setLayoutAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            userPrivileges.valueListAccess = DBAccessLevel.findByValue(tProtocol.readI32());
                            userPrivileges.setValueListAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            userPrivileges.scriptAccess = DBAccessLevel.findByValue(tProtocol.readI32());
                            userPrivileges.setScriptAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            userPrivileges.viewStyleAccess = tProtocol.readI32();
                            userPrivileges.setViewStyleAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            userPrivileges.exportAccess = tProtocol.readBool();
                            userPrivileges.setExportAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 2) {
                            userPrivileges.printAccess = tProtocol.readBool();
                            userPrivileges.setPrintAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 2) {
                            userPrivileges.pwAccess = tProtocol.readBool();
                            userPrivileges.setPwAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 8) {
                            userPrivileges.recordPrivSet = tProtocol.readI32();
                            userPrivileges.setRecordPrivSetIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 8) {
                            userPrivileges.modePrivSet = tProtocol.readI32();
                            userPrivileges.setModePrivSetIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 8) {
                            userPrivileges.findPrivSet = tProtocol.readI32();
                            userPrivileges.setFindPrivSetIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 8) {
                            userPrivileges.miscPrivSet = tProtocol.readI32();
                            userPrivileges.setMiscPrivSetIsSet(true);
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
            userPrivileges.validate();
        }

        public void write(TProtocol tProtocol, UserPrivileges userPrivileges) throws TException {
            userPrivileges.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(RECORD_ACCESS_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.recordAccess);
            tProtocol.writeFieldEnd();
            if (userPrivileges.fieldAccess != null) {
                tProtocol.writeFieldBegin(FIELD_ACCESS_FIELD_DESC);
                tProtocol.writeI32(userPrivileges.fieldAccess.getValue());
                tProtocol.writeFieldEnd();
            }
            if (userPrivileges.layoutAccess != null) {
                tProtocol.writeFieldBegin(LAYOUT_ACCESS_FIELD_DESC);
                tProtocol.writeI32(userPrivileges.layoutAccess.getValue());
                tProtocol.writeFieldEnd();
            }
            if (userPrivileges.valueListAccess != null) {
                tProtocol.writeFieldBegin(VALUE_LIST_ACCESS_FIELD_DESC);
                tProtocol.writeI32(userPrivileges.valueListAccess.getValue());
                tProtocol.writeFieldEnd();
            }
            if (userPrivileges.scriptAccess != null) {
                tProtocol.writeFieldBegin(SCRIPT_ACCESS_FIELD_DESC);
                tProtocol.writeI32(userPrivileges.scriptAccess.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VIEW_STYLE_ACCESS_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.viewStyleAccess);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(EXPORT_ACCESS_FIELD_DESC);
            tProtocol.writeBool(userPrivileges.exportAccess);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PRINT_ACCESS_FIELD_DESC);
            tProtocol.writeBool(userPrivileges.printAccess);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PW_ACCESS_FIELD_DESC);
            tProtocol.writeBool(userPrivileges.pwAccess);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RECORD_PRIV_SET_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.recordPrivSet);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MODE_PRIV_SET_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.modePrivSet);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FIND_PRIV_SET_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.findPrivSet);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MISC_PRIV_SET_FIELD_DESC);
            tProtocol.writeI32(userPrivileges.miscPrivSet);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

