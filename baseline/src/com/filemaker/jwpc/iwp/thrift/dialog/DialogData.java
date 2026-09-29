/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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
package com.filemaker.jwpc.iwp.thrift.dialog;

import com.filemaker.jwpc.iwp.thrift.dialog.DialogButtonObject;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogFieldObject;
import com.filemaker.jwpc.iwp.thrift.dialog.DialogSizeAndPos;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class DialogData
implements TBase<DialogData, _Fields>,
Serializable,
Cloneable,
Comparable<DialogData> {
    private static final TStruct STRUCT_DESC = new TStruct("DialogData");
    private static final TField TITLE_FIELD_DESC = new TField("title", 11, 1);
    private static final TField MESSAGE_FIELD_DESC = new TField("message", 11, 2);
    private static final TField FIELD_OBJECTS_FIELD_DESC = new TField("fieldObjects", 15, 3);
    private static final TField BUTTON_OBJECTS_FIELD_DESC = new TField("buttonObjects", 15, 4);
    private static final TField SIZE_AND_POS_FIELD_DESC = new TField("SizeAndPos", 15, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DialogDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DialogDataTupleSchemeFactory();
    @Nullable
    private String title;
    @Nullable
    private String message;
    @Nullable
    private List<DialogFieldObject> fieldObjects;
    @Nullable
    private List<DialogButtonObject> buttonObjects;
    @Nullable
    private List<DialogSizeAndPos> SizeAndPos;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DialogData() {
    }

    public DialogData(String string, String string2, List<DialogFieldObject> list, List<DialogButtonObject> list2, List<DialogSizeAndPos> list3) {
        this();
        this.title = string;
        this.message = string2;
        this.fieldObjects = list;
        this.buttonObjects = list2;
        this.SizeAndPos = list3;
    }

    public DialogData(DialogData dialogData) {
        ArrayList<DialogFieldObject> arrayList;
        if (dialogData.isSetTitle()) {
            this.title = dialogData.title;
        }
        if (dialogData.isSetMessage()) {
            this.message = dialogData.message;
        }
        if (dialogData.isSetFieldObjects()) {
            arrayList = new ArrayList<DialogFieldObject>(dialogData.fieldObjects.size());
            for (DialogFieldObject comparable : dialogData.fieldObjects) {
                arrayList.add(new DialogFieldObject(comparable));
            }
            this.fieldObjects = arrayList;
        }
        if (dialogData.isSetButtonObjects()) {
            arrayList = new ArrayList(dialogData.buttonObjects.size());
            for (DialogButtonObject dialogButtonObject : dialogData.buttonObjects) {
                arrayList.add((DialogFieldObject)((Object)new DialogButtonObject(dialogButtonObject)));
            }
            this.buttonObjects = arrayList;
        }
        if (dialogData.isSetSizeAndPos()) {
            arrayList = new ArrayList(dialogData.SizeAndPos.size());
            for (DialogSizeAndPos dialogSizeAndPos : dialogData.SizeAndPos) {
                arrayList.add((DialogFieldObject)((Object)new DialogSizeAndPos(dialogSizeAndPos)));
            }
            this.SizeAndPos = arrayList;
        }
    }

    public DialogData deepCopy() {
        return new DialogData(this);
    }

    public void clear() {
        this.title = null;
        this.message = null;
        this.fieldObjects = null;
        this.buttonObjects = null;
        this.SizeAndPos = null;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    public void setTitle(@Nullable String string) {
        this.title = string;
    }

    public void unsetTitle() {
        this.title = null;
    }

    public boolean isSetTitle() {
        return this.title != null;
    }

    public void setTitleIsSet(boolean bl) {
        if (!bl) {
            this.title = null;
        }
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable String string) {
        this.message = string;
    }

    public void unsetMessage() {
        this.message = null;
    }

    public boolean isSetMessage() {
        return this.message != null;
    }

    public void setMessageIsSet(boolean bl) {
        if (!bl) {
            this.message = null;
        }
    }

    public int getFieldObjectsSize() {
        return this.fieldObjects == null ? 0 : this.fieldObjects.size();
    }

    @Nullable
    public Iterator<DialogFieldObject> getFieldObjectsIterator() {
        return this.fieldObjects == null ? null : this.fieldObjects.iterator();
    }

    public void addToFieldObjects(DialogFieldObject dialogFieldObject) {
        if (this.fieldObjects == null) {
            this.fieldObjects = new ArrayList<DialogFieldObject>();
        }
        this.fieldObjects.add(dialogFieldObject);
    }

    @Nullable
    public List<DialogFieldObject> getFieldObjects() {
        return this.fieldObjects;
    }

    public void setFieldObjects(@Nullable List<DialogFieldObject> list) {
        this.fieldObjects = list;
    }

    public void unsetFieldObjects() {
        this.fieldObjects = null;
    }

    public boolean isSetFieldObjects() {
        return this.fieldObjects != null;
    }

    public void setFieldObjectsIsSet(boolean bl) {
        if (!bl) {
            this.fieldObjects = null;
        }
    }

    public int getButtonObjectsSize() {
        return this.buttonObjects == null ? 0 : this.buttonObjects.size();
    }

    @Nullable
    public Iterator<DialogButtonObject> getButtonObjectsIterator() {
        return this.buttonObjects == null ? null : this.buttonObjects.iterator();
    }

    public void addToButtonObjects(DialogButtonObject dialogButtonObject) {
        if (this.buttonObjects == null) {
            this.buttonObjects = new ArrayList<DialogButtonObject>();
        }
        this.buttonObjects.add(dialogButtonObject);
    }

    @Nullable
    public List<DialogButtonObject> getButtonObjects() {
        return this.buttonObjects;
    }

    public void setButtonObjects(@Nullable List<DialogButtonObject> list) {
        this.buttonObjects = list;
    }

    public void unsetButtonObjects() {
        this.buttonObjects = null;
    }

    public boolean isSetButtonObjects() {
        return this.buttonObjects != null;
    }

    public void setButtonObjectsIsSet(boolean bl) {
        if (!bl) {
            this.buttonObjects = null;
        }
    }

    public int getSizeAndPosSize() {
        return this.SizeAndPos == null ? 0 : this.SizeAndPos.size();
    }

    @Nullable
    public Iterator<DialogSizeAndPos> getSizeAndPosIterator() {
        return this.SizeAndPos == null ? null : this.SizeAndPos.iterator();
    }

    public void addToSizeAndPos(DialogSizeAndPos dialogSizeAndPos) {
        if (this.SizeAndPos == null) {
            this.SizeAndPos = new ArrayList<DialogSizeAndPos>();
        }
        this.SizeAndPos.add(dialogSizeAndPos);
    }

    @Nullable
    public List<DialogSizeAndPos> getSizeAndPos() {
        return this.SizeAndPos;
    }

    public void setSizeAndPos(@Nullable List<DialogSizeAndPos> list) {
        this.SizeAndPos = list;
    }

    public void unsetSizeAndPos() {
        this.SizeAndPos = null;
    }

    public boolean isSetSizeAndPos() {
        return this.SizeAndPos != null;
    }

    public void setSizeAndPosIsSet(boolean bl) {
        if (!bl) {
            this.SizeAndPos = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetTitle();
                    break;
                }
                this.setTitle((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetMessage();
                    break;
                }
                this.setMessage((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldObjects();
                    break;
                }
                this.setFieldObjects((List)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetButtonObjects();
                    break;
                }
                this.setButtonObjects((List)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetSizeAndPos();
                    break;
                }
                this.setSizeAndPos((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getTitle();
            }
            case 1: {
                return this.getMessage();
            }
            case 2: {
                return this.getFieldObjects();
            }
            case 3: {
                return this.getButtonObjects();
            }
            case 4: {
                return this.getSizeAndPos();
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
                return this.isSetTitle();
            }
            case 1: {
                return this.isSetMessage();
            }
            case 2: {
                return this.isSetFieldObjects();
            }
            case 3: {
                return this.isSetButtonObjects();
            }
            case 4: {
                return this.isSetSizeAndPos();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DialogData) {
            return this.equals((DialogData)object);
        }
        return false;
    }

    public boolean equals(DialogData dialogData) {
        if (dialogData == null) {
            return false;
        }
        if (this == dialogData) {
            return true;
        }
        boolean bl = this.isSetTitle();
        boolean bl2 = dialogData.isSetTitle();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.title.equals(dialogData.title)) {
                return false;
            }
        }
        boolean bl3 = this.isSetMessage();
        boolean bl4 = dialogData.isSetMessage();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.message.equals(dialogData.message)) {
                return false;
            }
        }
        boolean bl5 = this.isSetFieldObjects();
        boolean bl6 = dialogData.isSetFieldObjects();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fieldObjects.equals(dialogData.fieldObjects)) {
                return false;
            }
        }
        boolean bl7 = this.isSetButtonObjects();
        boolean bl8 = dialogData.isSetButtonObjects();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.buttonObjects.equals(dialogData.buttonObjects)) {
                return false;
            }
        }
        boolean bl9 = this.isSetSizeAndPos();
        boolean bl10 = dialogData.isSetSizeAndPos();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.SizeAndPos.equals(dialogData.SizeAndPos)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetTitle() ? 131071 : 524287);
        if (this.isSetTitle()) {
            n = n * 8191 + this.title.hashCode();
        }
        n = n * 8191 + (this.isSetMessage() ? 131071 : 524287);
        if (this.isSetMessage()) {
            n = n * 8191 + this.message.hashCode();
        }
        n = n * 8191 + (this.isSetFieldObjects() ? 131071 : 524287);
        if (this.isSetFieldObjects()) {
            n = n * 8191 + this.fieldObjects.hashCode();
        }
        n = n * 8191 + (this.isSetButtonObjects() ? 131071 : 524287);
        if (this.isSetButtonObjects()) {
            n = n * 8191 + this.buttonObjects.hashCode();
        }
        n = n * 8191 + (this.isSetSizeAndPos() ? 131071 : 524287);
        if (this.isSetSizeAndPos()) {
            n = n * 8191 + this.SizeAndPos.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(DialogData dialogData) {
        if (!this.getClass().equals(dialogData.getClass())) {
            return this.getClass().getName().compareTo(dialogData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetTitle(), dialogData.isSetTitle());
        if (n != 0) {
            return n;
        }
        if (this.isSetTitle() && (n = TBaseHelper.compareTo((String)this.title, (String)dialogData.title)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMessage(), dialogData.isSetMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetMessage() && (n = TBaseHelper.compareTo((String)this.message, (String)dialogData.message)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldObjects(), dialogData.isSetFieldObjects());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldObjects() && (n = TBaseHelper.compareTo(this.fieldObjects, dialogData.fieldObjects)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetButtonObjects(), dialogData.isSetButtonObjects());
        if (n != 0) {
            return n;
        }
        if (this.isSetButtonObjects() && (n = TBaseHelper.compareTo(this.buttonObjects, dialogData.buttonObjects)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSizeAndPos(), dialogData.isSetSizeAndPos());
        if (n != 0) {
            return n;
        }
        if (this.isSetSizeAndPos() && (n = TBaseHelper.compareTo(this.SizeAndPos, dialogData.SizeAndPos)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DialogData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DialogData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DialogData(");
        boolean bl = true;
        stringBuilder.append("title:");
        if (this.title == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.title);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("message:");
        if (this.message == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.message);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldObjects:");
        if (this.fieldObjects == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldObjects);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("buttonObjects:");
        if (this.buttonObjects == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.buttonObjects);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("SizeAndPos:");
        if (this.SizeAndPos == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.SizeAndPos);
        }
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
        enumMap.put(_Fields.TITLE, new FieldMetaData("title", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.MESSAGE, new FieldMetaData("message", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_OBJECTS, new FieldMetaData("fieldObjects", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, DialogFieldObject.class))));
        enumMap.put(_Fields.BUTTON_OBJECTS, new FieldMetaData("buttonObjects", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, DialogButtonObject.class))));
        enumMap.put(_Fields.SIZE_AND_POS, new FieldMetaData("SizeAndPos", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, DialogSizeAndPos.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DialogData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TITLE(1, "title"),
        MESSAGE(2, "message"),
        FIELD_OBJECTS(3, "fieldObjects"),
        BUTTON_OBJECTS(4, "buttonObjects"),
        SIZE_AND_POS(5, "SizeAndPos");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TITLE;
                }
                case 2: {
                    return MESSAGE;
                }
                case 3: {
                    return FIELD_OBJECTS;
                }
                case 4: {
                    return BUTTON_OBJECTS;
                }
                case 5: {
                    return SIZE_AND_POS;
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

    private static class DialogDataStandardSchemeFactory
    implements SchemeFactory {
        private DialogDataStandardSchemeFactory() {
        }

        public DialogDataStandardScheme getScheme() {
            return new DialogDataStandardScheme();
        }
    }

    private static class DialogDataTupleSchemeFactory
    implements SchemeFactory {
        private DialogDataTupleSchemeFactory() {
        }

        public DialogDataTupleScheme getScheme() {
            return new DialogDataTupleScheme();
        }
    }

    private static class DialogDataTupleScheme
    extends TupleScheme<DialogData> {
        private DialogDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, DialogData dialogData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dialogData.isSetTitle()) {
                bitSet.set(0);
            }
            if (dialogData.isSetMessage()) {
                bitSet.set(1);
            }
            if (dialogData.isSetFieldObjects()) {
                bitSet.set(2);
            }
            if (dialogData.isSetButtonObjects()) {
                bitSet.set(3);
            }
            if (dialogData.isSetSizeAndPos()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (dialogData.isSetTitle()) {
                tTupleProtocol.writeString(dialogData.title);
            }
            if (dialogData.isSetMessage()) {
                tTupleProtocol.writeString(dialogData.message);
            }
            if (dialogData.isSetFieldObjects()) {
                tTupleProtocol.writeI32(dialogData.fieldObjects.size());
                for (DialogFieldObject comparable : dialogData.fieldObjects) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (dialogData.isSetButtonObjects()) {
                tTupleProtocol.writeI32(dialogData.buttonObjects.size());
                for (DialogButtonObject dialogButtonObject : dialogData.buttonObjects) {
                    dialogButtonObject.write((TProtocol)tTupleProtocol);
                }
            }
            if (dialogData.isSetSizeAndPos()) {
                tTupleProtocol.writeI32(dialogData.SizeAndPos.size());
                for (DialogSizeAndPos dialogSizeAndPos : dialogData.SizeAndPos) {
                    dialogSizeAndPos.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, DialogData dialogData) throws TException {
            Comparable<DialogFieldObject> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                dialogData.title = tTupleProtocol.readString();
                dialogData.setTitleIsSet(true);
            }
            if (bitSet.get(1)) {
                dialogData.message = tTupleProtocol.readString();
                dialogData.setMessageIsSet(true);
            }
            if (bitSet.get(2)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                dialogData.fieldObjects = new ArrayList<DialogFieldObject>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new DialogFieldObject();
                    ((DialogFieldObject)comparable).read((TProtocol)tTupleProtocol);
                    dialogData.fieldObjects.add((DialogFieldObject)comparable);
                }
                dialogData.setFieldObjectsIsSet(true);
            }
            if (bitSet.get(3)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                dialogData.buttonObjects = new ArrayList<DialogButtonObject>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new DialogButtonObject();
                    ((DialogButtonObject)comparable).read((TProtocol)tTupleProtocol);
                    dialogData.buttonObjects.add((DialogButtonObject)comparable);
                }
                dialogData.setButtonObjectsIsSet(true);
            }
            if (bitSet.get(4)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                dialogData.SizeAndPos = new ArrayList<DialogSizeAndPos>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new DialogSizeAndPos();
                    ((DialogSizeAndPos)comparable).read((TProtocol)tTupleProtocol);
                    dialogData.SizeAndPos.add((DialogSizeAndPos)comparable);
                }
                dialogData.setSizeAndPosIsSet(true);
            }
        }
    }

    private static class DialogDataStandardScheme
    extends StandardScheme<DialogData> {
        private DialogDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, DialogData dialogData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            dialogData.title = tProtocol.readString();
                            dialogData.setTitleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            dialogData.message = tProtocol.readString();
                            dialogData.setMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        Comparable<DialogFieldObject> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            dialogData.fieldObjects = new ArrayList<DialogFieldObject>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new DialogFieldObject();
                                ((DialogFieldObject)comparable).read(tProtocol);
                                dialogData.fieldObjects.add((DialogFieldObject)comparable);
                            }
                            tProtocol.readListEnd();
                            dialogData.setFieldObjectsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        Comparable<DialogFieldObject> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            dialogData.buttonObjects = new ArrayList<DialogButtonObject>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new DialogButtonObject();
                                ((DialogButtonObject)comparable).read(tProtocol);
                                dialogData.buttonObjects.add((DialogButtonObject)comparable);
                            }
                            tProtocol.readListEnd();
                            dialogData.setButtonObjectsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        Comparable<DialogFieldObject> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            dialogData.SizeAndPos = new ArrayList<DialogSizeAndPos>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new DialogSizeAndPos();
                                ((DialogSizeAndPos)comparable).read(tProtocol);
                                dialogData.SizeAndPos.add((DialogSizeAndPos)comparable);
                            }
                            tProtocol.readListEnd();
                            dialogData.setSizeAndPosIsSet(true);
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
            dialogData.validate();
        }

        public void write(TProtocol tProtocol, DialogData dialogData) throws TException {
            dialogData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (dialogData.title != null) {
                tProtocol.writeFieldBegin(TITLE_FIELD_DESC);
                tProtocol.writeString(dialogData.title);
                tProtocol.writeFieldEnd();
            }
            if (dialogData.message != null) {
                tProtocol.writeFieldBegin(MESSAGE_FIELD_DESC);
                tProtocol.writeString(dialogData.message);
                tProtocol.writeFieldEnd();
            }
            if (dialogData.fieldObjects != null) {
                tProtocol.writeFieldBegin(FIELD_OBJECTS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, dialogData.fieldObjects.size()));
                for (DialogFieldObject comparable : dialogData.fieldObjects) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (dialogData.buttonObjects != null) {
                tProtocol.writeFieldBegin(BUTTON_OBJECTS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, dialogData.buttonObjects.size()));
                for (DialogButtonObject dialogButtonObject : dialogData.buttonObjects) {
                    dialogButtonObject.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (dialogData.SizeAndPos != null) {
                tProtocol.writeFieldBegin(SIZE_AND_POS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, dialogData.SizeAndPos.size()));
                for (DialogSizeAndPos dialogSizeAndPos : dialogData.SizeAndPos) {
                    dialogSizeAndPos.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

