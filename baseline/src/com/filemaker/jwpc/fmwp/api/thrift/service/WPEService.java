/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.iwp.thrift.common.Credentials
 *  com.filemaker.jwpc.iwp.thrift.common.DatabaseNamesResult
 *  org.apache.thrift.AsyncProcessFunction
 *  org.apache.thrift.EncodingUtils
 *  org.apache.thrift.ProcessFunction
 *  org.apache.thrift.TApplicationException
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseAsyncProcessor
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TBaseProcessor
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.TProcessor
 *  org.apache.thrift.TSerializable
 *  org.apache.thrift.TServiceClient
 *  org.apache.thrift.TServiceClientFactory
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.async.AsyncMethodCallback
 *  org.apache.thrift.async.TAsyncClient
 *  org.apache.thrift.async.TAsyncClientFactory
 *  org.apache.thrift.async.TAsyncClientManager
 *  org.apache.thrift.async.TAsyncMethodCall
 *  org.apache.thrift.async.TAsyncMethodCall$State
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMessage
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.protocol.TProtocolFactory
 *  org.apache.thrift.protocol.TProtocolUtil
 *  org.apache.thrift.protocol.TStruct
 *  org.apache.thrift.protocol.TTupleProtocol
 *  org.apache.thrift.scheme.IScheme
 *  org.apache.thrift.scheme.SchemeFactory
 *  org.apache.thrift.scheme.StandardScheme
 *  org.apache.thrift.scheme.TupleScheme
 *  org.apache.thrift.server.AbstractNonblockingServer$AsyncFrameBuffer
 *  org.apache.thrift.transport.TIOStreamTransport
 *  org.apache.thrift.transport.TMemoryInputTransport
 *  org.apache.thrift.transport.TNonblockingTransport
 *  org.apache.thrift.transport.TTransport
 *  org.apache.thrift.transport.TTransportException
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.ContainerParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLConfigParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLContainerData;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLNameSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet;
import com.filemaker.jwpc.fmwp.api.thrift.service.RequestParam;
import com.filemaker.jwpc.iwp.thrift.common.Credentials;
import com.filemaker.jwpc.iwp.thrift.common.DatabaseNamesResult;
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
import org.apache.thrift.AsyncProcessFunction;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.ProcessFunction;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseAsyncProcessor;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TBaseProcessor;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TSerializable;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.TServiceClientFactory;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClient;
import org.apache.thrift.async.TAsyncClientFactory;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.async.TAsyncMethodCall;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.server.AbstractNonblockingServer;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WPEService {

    public static class dump_result
    implements TBase<dump_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<dump_result> {
        private static final TStruct STRUCT_DESC = new TStruct("dump_result");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new dump_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new dump_resultTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public dump_result() {
        }

        public dump_result(dump_result dump_result2) {
        }

        public dump_result deepCopy() {
            return new dump_result(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof dump_result) {
                return this.equals((dump_result)object);
            }
            return false;
        }

        public boolean equals(dump_result dump_result2) {
            if (dump_result2 == null) {
                return false;
            }
            if (this == dump_result2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(dump_result dump_result2) {
            if (!this.getClass().equals(dump_result2.getClass())) {
                return this.getClass().getName().compareTo(dump_result2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            dump_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            dump_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("dump_result(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(dump_result.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class dump_resultStandardSchemeFactory
        implements SchemeFactory {
            private dump_resultStandardSchemeFactory() {
            }

            public dump_resultStandardScheme getScheme() {
                return new dump_resultStandardScheme();
            }
        }

        private static class dump_resultTupleSchemeFactory
        implements SchemeFactory {
            private dump_resultTupleSchemeFactory() {
            }

            public dump_resultTupleScheme getScheme() {
                return new dump_resultTupleScheme();
            }
        }

        private static class dump_resultTupleScheme
        extends TupleScheme<dump_result> {
            private dump_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, dump_result dump_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, dump_result dump_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class dump_resultStandardScheme
        extends StandardScheme<dump_result> {
            private dump_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, dump_result dump_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                dump_result2.validate();
            }

            public void write(TProtocol tProtocol, dump_result dump_result2) throws TException {
                dump_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class dump_args
    implements TBase<dump_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<dump_args> {
        private static final TStruct STRUCT_DESC = new TStruct("dump_args");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new dump_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new dump_argsTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public dump_args() {
        }

        public dump_args(dump_args dump_args2) {
        }

        public dump_args deepCopy() {
            return new dump_args(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof dump_args) {
                return this.equals((dump_args)object);
            }
            return false;
        }

        public boolean equals(dump_args dump_args2) {
            if (dump_args2 == null) {
                return false;
            }
            if (this == dump_args2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(dump_args dump_args2) {
            if (!this.getClass().equals(dump_args2.getClass())) {
                return this.getClass().getName().compareTo(dump_args2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            dump_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            dump_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("dump_args(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(dump_args.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class dump_argsStandardSchemeFactory
        implements SchemeFactory {
            private dump_argsStandardSchemeFactory() {
            }

            public dump_argsStandardScheme getScheme() {
                return new dump_argsStandardScheme();
            }
        }

        private static class dump_argsTupleSchemeFactory
        implements SchemeFactory {
            private dump_argsTupleSchemeFactory() {
            }

            public dump_argsTupleScheme getScheme() {
                return new dump_argsTupleScheme();
            }
        }

        private static class dump_argsTupleScheme
        extends TupleScheme<dump_args> {
            private dump_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, dump_args dump_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, dump_args dump_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class dump_argsStandardScheme
        extends StandardScheme<dump_args> {
            private dump_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, dump_args dump_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                dump_args2.validate();
            }

            public void write(TProtocol tProtocol, dump_args dump_args2) throws TException {
                dump_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class force_quit_result
    implements TBase<force_quit_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<force_quit_result> {
        private static final TStruct STRUCT_DESC = new TStruct("force_quit_result");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new force_quit_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new force_quit_resultTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public force_quit_result() {
        }

        public force_quit_result(force_quit_result force_quit_result2) {
        }

        public force_quit_result deepCopy() {
            return new force_quit_result(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof force_quit_result) {
                return this.equals((force_quit_result)object);
            }
            return false;
        }

        public boolean equals(force_quit_result force_quit_result2) {
            if (force_quit_result2 == null) {
                return false;
            }
            if (this == force_quit_result2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(force_quit_result force_quit_result2) {
            if (!this.getClass().equals(force_quit_result2.getClass())) {
                return this.getClass().getName().compareTo(force_quit_result2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            force_quit_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            force_quit_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("force_quit_result(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(force_quit_result.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class force_quit_resultStandardSchemeFactory
        implements SchemeFactory {
            private force_quit_resultStandardSchemeFactory() {
            }

            public force_quit_resultStandardScheme getScheme() {
                return new force_quit_resultStandardScheme();
            }
        }

        private static class force_quit_resultTupleSchemeFactory
        implements SchemeFactory {
            private force_quit_resultTupleSchemeFactory() {
            }

            public force_quit_resultTupleScheme getScheme() {
                return new force_quit_resultTupleScheme();
            }
        }

        private static class force_quit_resultTupleScheme
        extends TupleScheme<force_quit_result> {
            private force_quit_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, force_quit_result force_quit_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, force_quit_result force_quit_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class force_quit_resultStandardScheme
        extends StandardScheme<force_quit_result> {
            private force_quit_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, force_quit_result force_quit_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                force_quit_result2.validate();
            }

            public void write(TProtocol tProtocol, force_quit_result force_quit_result2) throws TException {
                force_quit_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class force_quit_args
    implements TBase<force_quit_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<force_quit_args> {
        private static final TStruct STRUCT_DESC = new TStruct("force_quit_args");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new force_quit_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new force_quit_argsTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public force_quit_args() {
        }

        public force_quit_args(force_quit_args force_quit_args2) {
        }

        public force_quit_args deepCopy() {
            return new force_quit_args(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof force_quit_args) {
                return this.equals((force_quit_args)object);
            }
            return false;
        }

        public boolean equals(force_quit_args force_quit_args2) {
            if (force_quit_args2 == null) {
                return false;
            }
            if (this == force_quit_args2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(force_quit_args force_quit_args2) {
            if (!this.getClass().equals(force_quit_args2.getClass())) {
                return this.getClass().getName().compareTo(force_quit_args2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            force_quit_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            force_quit_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("force_quit_args(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(force_quit_args.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class force_quit_argsStandardSchemeFactory
        implements SchemeFactory {
            private force_quit_argsStandardSchemeFactory() {
            }

            public force_quit_argsStandardScheme getScheme() {
                return new force_quit_argsStandardScheme();
            }
        }

        private static class force_quit_argsTupleSchemeFactory
        implements SchemeFactory {
            private force_quit_argsTupleSchemeFactory() {
            }

            public force_quit_argsTupleScheme getScheme() {
                return new force_quit_argsTupleScheme();
            }
        }

        private static class force_quit_argsTupleScheme
        extends TupleScheme<force_quit_args> {
            private force_quit_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, force_quit_args force_quit_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, force_quit_args force_quit_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class force_quit_argsStandardScheme
        extends StandardScheme<force_quit_args> {
            private force_quit_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, force_quit_args force_quit_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                force_quit_args2.validate();
            }

            public void write(TProtocol tProtocol, force_quit_args force_quit_args2) throws TException {
                force_quit_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class quit_result
    implements TBase<quit_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<quit_result> {
        private static final TStruct STRUCT_DESC = new TStruct("quit_result");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new quit_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new quit_resultTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public quit_result() {
        }

        public quit_result(quit_result quit_result2) {
        }

        public quit_result deepCopy() {
            return new quit_result(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof quit_result) {
                return this.equals((quit_result)object);
            }
            return false;
        }

        public boolean equals(quit_result quit_result2) {
            if (quit_result2 == null) {
                return false;
            }
            if (this == quit_result2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(quit_result quit_result2) {
            if (!this.getClass().equals(quit_result2.getClass())) {
                return this.getClass().getName().compareTo(quit_result2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            quit_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            quit_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("quit_result(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(quit_result.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class quit_resultStandardSchemeFactory
        implements SchemeFactory {
            private quit_resultStandardSchemeFactory() {
            }

            public quit_resultStandardScheme getScheme() {
                return new quit_resultStandardScheme();
            }
        }

        private static class quit_resultTupleSchemeFactory
        implements SchemeFactory {
            private quit_resultTupleSchemeFactory() {
            }

            public quit_resultTupleScheme getScheme() {
                return new quit_resultTupleScheme();
            }
        }

        private static class quit_resultTupleScheme
        extends TupleScheme<quit_result> {
            private quit_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, quit_result quit_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, quit_result quit_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class quit_resultStandardScheme
        extends StandardScheme<quit_result> {
            private quit_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, quit_result quit_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                quit_result2.validate();
            }

            public void write(TProtocol tProtocol, quit_result quit_result2) throws TException {
                quit_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class quit_args
    implements TBase<quit_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<quit_args> {
        private static final TStruct STRUCT_DESC = new TStruct("quit_args");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new quit_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new quit_argsTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public quit_args() {
        }

        public quit_args(quit_args quit_args2) {
        }

        public quit_args deepCopy() {
            return new quit_args(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof quit_args) {
                return this.equals((quit_args)object);
            }
            return false;
        }

        public boolean equals(quit_args quit_args2) {
            if (quit_args2 == null) {
                return false;
            }
            if (this == quit_args2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(quit_args quit_args2) {
            if (!this.getClass().equals(quit_args2.getClass())) {
                return this.getClass().getName().compareTo(quit_args2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            quit_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            quit_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("quit_args(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(quit_args.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class quit_argsStandardSchemeFactory
        implements SchemeFactory {
            private quit_argsStandardSchemeFactory() {
            }

            public quit_argsStandardScheme getScheme() {
                return new quit_argsStandardScheme();
            }
        }

        private static class quit_argsTupleSchemeFactory
        implements SchemeFactory {
            private quit_argsTupleSchemeFactory() {
            }

            public quit_argsTupleScheme getScheme() {
                return new quit_argsTupleScheme();
            }
        }

        private static class quit_argsTupleScheme
        extends TupleScheme<quit_args> {
            private quit_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, quit_args quit_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, quit_args quit_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class quit_argsStandardScheme
        extends StandardScheme<quit_args> {
            private quit_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, quit_args quit_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                quit_args2.validate();
            }

            public void write(TProtocol tProtocol, quit_args quit_args2) throws TException {
                quit_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class ping_result
    implements TBase<ping_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<ping_result> {
        private static final TStruct STRUCT_DESC = new TStruct("ping_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 10, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ping_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ping_resultTupleSchemeFactory();
        private long success;
        private static final int __SUCCESS_ISSET_ID = 0;
        private byte __isset_bitfield = 0;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public ping_result() {
        }

        public ping_result(long l) {
            this();
            this.success = l;
            this.setSuccessIsSet(true);
        }

        public ping_result(ping_result ping_result2) {
            this.__isset_bitfield = ping_result2.__isset_bitfield;
            this.success = ping_result2.success;
        }

        public ping_result deepCopy() {
            return new ping_result(this);
        }

        public void clear() {
            this.setSuccessIsSet(false);
            this.success = 0L;
        }

        public long getSuccess() {
            return this.success;
        }

        public void setSuccess(long l) {
            this.success = l;
            this.setSuccessIsSet(true);
        }

        public void unsetSuccess() {
            this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
        }

        public boolean isSetSuccess() {
            return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
        }

        public void setSuccessIsSet(boolean bl) {
            this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((Long)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof ping_result) {
                return this.equals((ping_result)object);
            }
            return false;
        }

        public boolean equals(ping_result ping_result2) {
            if (ping_result2 == null) {
                return false;
            }
            if (this == ping_result2) {
                return true;
            }
            boolean bl = true;
            boolean bl2 = true;
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (this.success != ping_result2.success) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + TBaseHelper.hashCode((long)this.success);
            return n;
        }

        @Override
        public int compareTo(ping_result ping_result2) {
            if (!this.getClass().equals(ping_result2.getClass())) {
                return this.getClass().getName().compareTo(ping_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), ping_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((long)this.success, (long)ping_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            ping_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            ping_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ping_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            stringBuilder.append(this.success);
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, new FieldValueMetaData(10)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(ping_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class ping_resultStandardSchemeFactory
        implements SchemeFactory {
            private ping_resultStandardSchemeFactory() {
            }

            public ping_resultStandardScheme getScheme() {
                return new ping_resultStandardScheme();
            }
        }

        private static class ping_resultTupleSchemeFactory
        implements SchemeFactory {
            private ping_resultTupleSchemeFactory() {
            }

            public ping_resultTupleScheme getScheme() {
                return new ping_resultTupleScheme();
            }
        }

        private static class ping_resultTupleScheme
        extends TupleScheme<ping_result> {
            private ping_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, ping_result ping_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (ping_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (ping_result2.isSetSuccess()) {
                    tTupleProtocol.writeI64(ping_result2.success);
                }
            }

            public void read(TProtocol tProtocol, ping_result ping_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    ping_result2.success = tTupleProtocol.readI64();
                    ping_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class ping_resultStandardScheme
        extends StandardScheme<ping_result> {
            private ping_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, ping_result ping_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 10) {
                                ping_result2.success = tProtocol.readI64();
                                ping_result2.setSuccessIsSet(true);
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
                ping_result2.validate();
            }

            public void write(TProtocol tProtocol, ping_result ping_result2) throws TException {
                ping_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (ping_result2.isSetSuccess()) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    tProtocol.writeI64(ping_result2.success);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class ping_args
    implements TBase<ping_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<ping_args> {
        private static final TStruct STRUCT_DESC = new TStruct("ping_args");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ping_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ping_argsTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public ping_args() {
        }

        public ping_args(ping_args ping_args2) {
        }

        public ping_args deepCopy() {
            return new ping_args(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof ping_args) {
                return this.equals((ping_args)object);
            }
            return false;
        }

        public boolean equals(ping_args ping_args2) {
            if (ping_args2 == null) {
                return false;
            }
            if (this == ping_args2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(ping_args ping_args2) {
            if (!this.getClass().equals(ping_args2.getClass())) {
                return this.getClass().getName().compareTo(ping_args2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            ping_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            ping_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ping_args(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(ping_args.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class ping_argsStandardSchemeFactory
        implements SchemeFactory {
            private ping_argsStandardSchemeFactory() {
            }

            public ping_argsStandardScheme getScheme() {
                return new ping_argsStandardScheme();
            }
        }

        private static class ping_argsTupleSchemeFactory
        implements SchemeFactory {
            private ping_argsTupleSchemeFactory() {
            }

            public ping_argsTupleScheme getScheme() {
                return new ping_argsTupleScheme();
            }
        }

        private static class ping_argsTupleScheme
        extends TupleScheme<ping_args> {
            private ping_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, ping_args ping_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, ping_args ping_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class ping_argsStandardScheme
        extends StandardScheme<ping_args> {
            private ping_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, ping_args ping_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                ping_args2.validate();
            }

            public void write(TProtocol tProtocol, ping_args ping_args2) throws TException {
                ping_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class configure_result
    implements TBase<configure_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<configure_result> {
        private static final TStruct STRUCT_DESC = new TStruct("configure_result");
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new configure_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new configure_resultTupleSchemeFactory();
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public configure_result() {
        }

        public configure_result(configure_result configure_result2) {
        }

        public configure_result deepCopy() {
            return new configure_result(this);
        }

        public void clear() {
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            _Fields2.ordinal();
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean isSet(_Fields _Fields2) {
            if (_Fields2 == null) {
                throw new IllegalArgumentException();
            }
            _Fields2.ordinal();
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof configure_result) {
                return this.equals((configure_result)object);
            }
            return false;
        }

        public boolean equals(configure_result configure_result2) {
            if (configure_result2 == null) {
                return false;
            }
            if (this == configure_result2) {
                return true;
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            return n;
        }

        @Override
        public int compareTo(configure_result configure_result2) {
            if (!this.getClass().equals(configure_result2.getClass())) {
                return this.getClass().getName().compareTo(configure_result2.getClass().getName());
            }
            boolean bl = false;
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            configure_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            configure_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("configure_result(");
            boolean bl = true;
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
            EnumMap enumMap = new EnumMap(_Fields.class);
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(configure_result.class, metaDataMap);
        }

        public static final class _Fields
        extends Enum<_Fields>
        implements TFieldIdEnum {
            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;
            private static final /* synthetic */ _Fields[] $VALUES;

            public static _Fields[] values() {
                return (_Fields[])$VALUES.clone();
            }

            public static _Fields valueOf(String string) {
                return Enum.valueOf(_Fields.class, string);
            }

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    default: 
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

            private static /* synthetic */ _Fields[] $values() {
                return new _Fields[0];
            }

            static {
                $VALUES = _Fields.$values();
                byName = new HashMap<String, _Fields>();
                for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                    byName.put(_Fields2.getFieldName(), _Fields2);
                }
            }
        }

        private static class configure_resultStandardSchemeFactory
        implements SchemeFactory {
            private configure_resultStandardSchemeFactory() {
            }

            public configure_resultStandardScheme getScheme() {
                return new configure_resultStandardScheme();
            }
        }

        private static class configure_resultTupleSchemeFactory
        implements SchemeFactory {
            private configure_resultTupleSchemeFactory() {
            }

            public configure_resultTupleScheme getScheme() {
                return new configure_resultTupleScheme();
            }
        }

        private static class configure_resultTupleScheme
        extends TupleScheme<configure_result> {
            private configure_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, configure_result configure_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }

            public void read(TProtocol tProtocol, configure_result configure_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            }
        }

        private static class configure_resultStandardScheme
        extends StandardScheme<configure_result> {
            private configure_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, configure_result configure_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        default: 
                    }
                    TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    tProtocol.readFieldEnd();
                }
                tProtocol.readStructEnd();
                configure_result2.validate();
            }

            public void write(TProtocol tProtocol, configure_result configure_result2) throws TException {
                configure_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class configure_args
    implements TBase<configure_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<configure_args> {
        private static final TStruct STRUCT_DESC = new TStruct("configure_args");
        private static final TField PARAM_FIELD_DESC = new TField("param", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new configure_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new configure_argsTupleSchemeFactory();
        @Nullable
        private IDLConfigParam param;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public configure_args() {
        }

        public configure_args(IDLConfigParam iDLConfigParam) {
            this();
            this.param = iDLConfigParam;
        }

        public configure_args(configure_args configure_args2) {
            if (configure_args2.isSetParam()) {
                this.param = new IDLConfigParam(configure_args2.param);
            }
        }

        public configure_args deepCopy() {
            return new configure_args(this);
        }

        public void clear() {
            this.param = null;
        }

        @Nullable
        public IDLConfigParam getParam() {
            return this.param;
        }

        public void setParam(@Nullable IDLConfigParam iDLConfigParam) {
            this.param = iDLConfigParam;
        }

        public void unsetParam() {
            this.param = null;
        }

        public boolean isSetParam() {
            return this.param != null;
        }

        public void setParamIsSet(boolean bl) {
            if (!bl) {
                this.param = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetParam();
                        break;
                    }
                    this.setParam((IDLConfigParam)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getParam();
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
                    return this.isSetParam();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof configure_args) {
                return this.equals((configure_args)object);
            }
            return false;
        }

        public boolean equals(configure_args configure_args2) {
            if (configure_args2 == null) {
                return false;
            }
            if (this == configure_args2) {
                return true;
            }
            boolean bl = this.isSetParam();
            boolean bl2 = configure_args2.isSetParam();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.param.equals(configure_args2.param)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetParam() ? 131071 : 524287);
            if (this.isSetParam()) {
                n = n * 8191 + this.param.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(configure_args configure_args2) {
            if (!this.getClass().equals(configure_args2.getClass())) {
                return this.getClass().getName().compareTo(configure_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetParam(), configure_args2.isSetParam());
            if (n != 0) {
                return n;
            }
            if (this.isSetParam() && (n = TBaseHelper.compareTo((Comparable)this.param, (Comparable)configure_args2.param)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            configure_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            configure_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("configure_args(");
            boolean bl = true;
            stringBuilder.append("param:");
            if (this.param == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.param);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.param != null) {
                this.param.validate();
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
            enumMap.put(_Fields.PARAM, new FieldMetaData("param", 3, (FieldValueMetaData)new StructMetaData(12, IDLConfigParam.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(configure_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            PARAM(1, "param");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return PARAM;
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

        private static class configure_argsStandardSchemeFactory
        implements SchemeFactory {
            private configure_argsStandardSchemeFactory() {
            }

            public configure_argsStandardScheme getScheme() {
                return new configure_argsStandardScheme();
            }
        }

        private static class configure_argsTupleSchemeFactory
        implements SchemeFactory {
            private configure_argsTupleSchemeFactory() {
            }

            public configure_argsTupleScheme getScheme() {
                return new configure_argsTupleScheme();
            }
        }

        private static class configure_argsTupleScheme
        extends TupleScheme<configure_args> {
            private configure_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, configure_args configure_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (configure_args2.isSetParam()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (configure_args2.isSetParam()) {
                    configure_args2.param.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, configure_args configure_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    configure_args2.param = new IDLConfigParam();
                    configure_args2.param.read((TProtocol)tTupleProtocol);
                    configure_args2.setParamIsSet(true);
                }
            }
        }

        private static class configure_argsStandardScheme
        extends StandardScheme<configure_args> {
            private configure_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, configure_args configure_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                configure_args2.param = new IDLConfigParam();
                                configure_args2.param.read(tProtocol);
                                configure_args2.setParamIsSet(true);
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
                configure_args2.validate();
            }

            public void write(TProtocol tProtocol, configure_args configure_args2) throws TException {
                configure_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (configure_args2.param != null) {
                    tProtocol.writeFieldBegin(PARAM_FIELD_DESC);
                    configure_args2.param.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getContainerData_result
    implements TBase<getContainerData_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getContainerData_result> {
        private static final TStruct STRUCT_DESC = new TStruct("getContainerData_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 12, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getContainerData_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getContainerData_resultTupleSchemeFactory();
        @Nullable
        private IDLContainerData success;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getContainerData_result() {
        }

        public getContainerData_result(IDLContainerData iDLContainerData) {
            this();
            this.success = iDLContainerData;
        }

        public getContainerData_result(getContainerData_result getContainerData_result2) {
            if (getContainerData_result2.isSetSuccess()) {
                this.success = new IDLContainerData(getContainerData_result2.success);
            }
        }

        public getContainerData_result deepCopy() {
            return new getContainerData_result(this);
        }

        public void clear() {
            this.success = null;
        }

        @Nullable
        public IDLContainerData getSuccess() {
            return this.success;
        }

        public void setSuccess(@Nullable IDLContainerData iDLContainerData) {
            this.success = iDLContainerData;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean bl) {
            if (!bl) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((IDLContainerData)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getContainerData_result) {
                return this.equals((getContainerData_result)object);
            }
            return false;
        }

        public boolean equals(getContainerData_result getContainerData_result2) {
            if (getContainerData_result2 == null) {
                return false;
            }
            if (this == getContainerData_result2) {
                return true;
            }
            boolean bl = this.isSetSuccess();
            boolean bl2 = getContainerData_result2.isSetSuccess();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.success.equals(getContainerData_result2.success)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetSuccess() ? 131071 : 524287);
            if (this.isSetSuccess()) {
                n = n * 8191 + this.success.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getContainerData_result getContainerData_result2) {
            if (!this.getClass().equals(getContainerData_result2.getClass())) {
                return this.getClass().getName().compareTo(getContainerData_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), getContainerData_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((Comparable)this.success, (Comparable)getContainerData_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getContainerData_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getContainerData_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getContainerData_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            if (this.success == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.success);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.success != null) {
                this.success.validate();
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, (FieldValueMetaData)new StructMetaData(12, IDLContainerData.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getContainerData_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class getContainerData_resultStandardSchemeFactory
        implements SchemeFactory {
            private getContainerData_resultStandardSchemeFactory() {
            }

            public getContainerData_resultStandardScheme getScheme() {
                return new getContainerData_resultStandardScheme();
            }
        }

        private static class getContainerData_resultTupleSchemeFactory
        implements SchemeFactory {
            private getContainerData_resultTupleSchemeFactory() {
            }

            public getContainerData_resultTupleScheme getScheme() {
                return new getContainerData_resultTupleScheme();
            }
        }

        private static class getContainerData_resultTupleScheme
        extends TupleScheme<getContainerData_result> {
            private getContainerData_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, getContainerData_result getContainerData_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getContainerData_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getContainerData_result2.isSetSuccess()) {
                    getContainerData_result2.success.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getContainerData_result getContainerData_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getContainerData_result2.success = new IDLContainerData();
                    getContainerData_result2.success.read((TProtocol)tTupleProtocol);
                    getContainerData_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class getContainerData_resultStandardScheme
        extends StandardScheme<getContainerData_result> {
            private getContainerData_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, getContainerData_result getContainerData_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 12) {
                                getContainerData_result2.success = new IDLContainerData();
                                getContainerData_result2.success.read(tProtocol);
                                getContainerData_result2.setSuccessIsSet(true);
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
                getContainerData_result2.validate();
            }

            public void write(TProtocol tProtocol, getContainerData_result getContainerData_result2) throws TException {
                getContainerData_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getContainerData_result2.success != null) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    getContainerData_result2.success.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getContainerData_args
    implements TBase<getContainerData_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getContainerData_args> {
        private static final TStruct STRUCT_DESC = new TStruct("getContainerData_args");
        private static final TField REQ_FIELD_DESC = new TField("req", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getContainerData_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getContainerData_argsTupleSchemeFactory();
        @Nullable
        private ContainerParam req;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getContainerData_args() {
        }

        public getContainerData_args(ContainerParam containerParam) {
            this();
            this.req = containerParam;
        }

        public getContainerData_args(getContainerData_args getContainerData_args2) {
            if (getContainerData_args2.isSetReq()) {
                this.req = new ContainerParam(getContainerData_args2.req);
            }
        }

        public getContainerData_args deepCopy() {
            return new getContainerData_args(this);
        }

        public void clear() {
            this.req = null;
        }

        @Nullable
        public ContainerParam getReq() {
            return this.req;
        }

        public void setReq(@Nullable ContainerParam containerParam) {
            this.req = containerParam;
        }

        public void unsetReq() {
            this.req = null;
        }

        public boolean isSetReq() {
            return this.req != null;
        }

        public void setReqIsSet(boolean bl) {
            if (!bl) {
                this.req = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetReq();
                        break;
                    }
                    this.setReq((ContainerParam)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getReq();
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
                    return this.isSetReq();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getContainerData_args) {
                return this.equals((getContainerData_args)object);
            }
            return false;
        }

        public boolean equals(getContainerData_args getContainerData_args2) {
            if (getContainerData_args2 == null) {
                return false;
            }
            if (this == getContainerData_args2) {
                return true;
            }
            boolean bl = this.isSetReq();
            boolean bl2 = getContainerData_args2.isSetReq();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.req.equals(getContainerData_args2.req)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetReq() ? 131071 : 524287);
            if (this.isSetReq()) {
                n = n * 8191 + this.req.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getContainerData_args getContainerData_args2) {
            if (!this.getClass().equals(getContainerData_args2.getClass())) {
                return this.getClass().getName().compareTo(getContainerData_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetReq(), getContainerData_args2.isSetReq());
            if (n != 0) {
                return n;
            }
            if (this.isSetReq() && (n = TBaseHelper.compareTo((Comparable)this.req, (Comparable)getContainerData_args2.req)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getContainerData_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getContainerData_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getContainerData_args(");
            boolean bl = true;
            stringBuilder.append("req:");
            if (this.req == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.req);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.req != null) {
                this.req.validate();
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
            enumMap.put(_Fields.REQ, new FieldMetaData("req", 3, (FieldValueMetaData)new StructMetaData(12, ContainerParam.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getContainerData_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            REQ(1, "req");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return REQ;
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

        private static class getContainerData_argsStandardSchemeFactory
        implements SchemeFactory {
            private getContainerData_argsStandardSchemeFactory() {
            }

            public getContainerData_argsStandardScheme getScheme() {
                return new getContainerData_argsStandardScheme();
            }
        }

        private static class getContainerData_argsTupleSchemeFactory
        implements SchemeFactory {
            private getContainerData_argsTupleSchemeFactory() {
            }

            public getContainerData_argsTupleScheme getScheme() {
                return new getContainerData_argsTupleScheme();
            }
        }

        private static class getContainerData_argsTupleScheme
        extends TupleScheme<getContainerData_args> {
            private getContainerData_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, getContainerData_args getContainerData_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getContainerData_args2.isSetReq()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getContainerData_args2.isSetReq()) {
                    getContainerData_args2.req.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getContainerData_args getContainerData_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getContainerData_args2.req = new ContainerParam();
                    getContainerData_args2.req.read((TProtocol)tTupleProtocol);
                    getContainerData_args2.setReqIsSet(true);
                }
            }
        }

        private static class getContainerData_argsStandardScheme
        extends StandardScheme<getContainerData_args> {
            private getContainerData_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, getContainerData_args getContainerData_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                getContainerData_args2.req = new ContainerParam();
                                getContainerData_args2.req.read(tProtocol);
                                getContainerData_args2.setReqIsSet(true);
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
                getContainerData_args2.validate();
            }

            public void write(TProtocol tProtocol, getContainerData_args getContainerData_args2) throws TException {
                getContainerData_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getContainerData_args2.req != null) {
                    tProtocol.writeFieldBegin(REQ_FIELD_DESC);
                    getContainerData_args2.req.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class performRecordRequest_result
    implements TBase<performRecordRequest_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<performRecordRequest_result> {
        private static final TStruct STRUCT_DESC = new TStruct("performRecordRequest_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 12, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new performRecordRequest_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new performRecordRequest_resultTupleSchemeFactory();
        @Nullable
        private IDLResultSet success;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public performRecordRequest_result() {
        }

        public performRecordRequest_result(IDLResultSet iDLResultSet) {
            this();
            this.success = iDLResultSet;
        }

        public performRecordRequest_result(performRecordRequest_result performRecordRequest_result2) {
            if (performRecordRequest_result2.isSetSuccess()) {
                this.success = new IDLResultSet(performRecordRequest_result2.success);
            }
        }

        public performRecordRequest_result deepCopy() {
            return new performRecordRequest_result(this);
        }

        public void clear() {
            this.success = null;
        }

        @Nullable
        public IDLResultSet getSuccess() {
            return this.success;
        }

        public void setSuccess(@Nullable IDLResultSet iDLResultSet) {
            this.success = iDLResultSet;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean bl) {
            if (!bl) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((IDLResultSet)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof performRecordRequest_result) {
                return this.equals((performRecordRequest_result)object);
            }
            return false;
        }

        public boolean equals(performRecordRequest_result performRecordRequest_result2) {
            if (performRecordRequest_result2 == null) {
                return false;
            }
            if (this == performRecordRequest_result2) {
                return true;
            }
            boolean bl = this.isSetSuccess();
            boolean bl2 = performRecordRequest_result2.isSetSuccess();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.success.equals(performRecordRequest_result2.success)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetSuccess() ? 131071 : 524287);
            if (this.isSetSuccess()) {
                n = n * 8191 + this.success.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(performRecordRequest_result performRecordRequest_result2) {
            if (!this.getClass().equals(performRecordRequest_result2.getClass())) {
                return this.getClass().getName().compareTo(performRecordRequest_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), performRecordRequest_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((Comparable)this.success, (Comparable)performRecordRequest_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            performRecordRequest_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            performRecordRequest_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("performRecordRequest_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            if (this.success == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.success);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.success != null) {
                this.success.validate();
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, (FieldValueMetaData)new StructMetaData(12, IDLResultSet.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(performRecordRequest_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class performRecordRequest_resultStandardSchemeFactory
        implements SchemeFactory {
            private performRecordRequest_resultStandardSchemeFactory() {
            }

            public performRecordRequest_resultStandardScheme getScheme() {
                return new performRecordRequest_resultStandardScheme();
            }
        }

        private static class performRecordRequest_resultTupleSchemeFactory
        implements SchemeFactory {
            private performRecordRequest_resultTupleSchemeFactory() {
            }

            public performRecordRequest_resultTupleScheme getScheme() {
                return new performRecordRequest_resultTupleScheme();
            }
        }

        private static class performRecordRequest_resultTupleScheme
        extends TupleScheme<performRecordRequest_result> {
            private performRecordRequest_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, performRecordRequest_result performRecordRequest_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (performRecordRequest_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (performRecordRequest_result2.isSetSuccess()) {
                    performRecordRequest_result2.success.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, performRecordRequest_result performRecordRequest_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    performRecordRequest_result2.success = new IDLResultSet();
                    performRecordRequest_result2.success.read((TProtocol)tTupleProtocol);
                    performRecordRequest_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class performRecordRequest_resultStandardScheme
        extends StandardScheme<performRecordRequest_result> {
            private performRecordRequest_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, performRecordRequest_result performRecordRequest_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 12) {
                                performRecordRequest_result2.success = new IDLResultSet();
                                performRecordRequest_result2.success.read(tProtocol);
                                performRecordRequest_result2.setSuccessIsSet(true);
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
                performRecordRequest_result2.validate();
            }

            public void write(TProtocol tProtocol, performRecordRequest_result performRecordRequest_result2) throws TException {
                performRecordRequest_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (performRecordRequest_result2.success != null) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    performRecordRequest_result2.success.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class performRecordRequest_args
    implements TBase<performRecordRequest_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<performRecordRequest_args> {
        private static final TStruct STRUCT_DESC = new TStruct("performRecordRequest_args");
        private static final TField REQ_FIELD_DESC = new TField("req", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new performRecordRequest_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new performRecordRequest_argsTupleSchemeFactory();
        @Nullable
        private RequestParam req;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public performRecordRequest_args() {
        }

        public performRecordRequest_args(RequestParam requestParam) {
            this();
            this.req = requestParam;
        }

        public performRecordRequest_args(performRecordRequest_args performRecordRequest_args2) {
            if (performRecordRequest_args2.isSetReq()) {
                this.req = new RequestParam(performRecordRequest_args2.req);
            }
        }

        public performRecordRequest_args deepCopy() {
            return new performRecordRequest_args(this);
        }

        public void clear() {
            this.req = null;
        }

        @Nullable
        public RequestParam getReq() {
            return this.req;
        }

        public void setReq(@Nullable RequestParam requestParam) {
            this.req = requestParam;
        }

        public void unsetReq() {
            this.req = null;
        }

        public boolean isSetReq() {
            return this.req != null;
        }

        public void setReqIsSet(boolean bl) {
            if (!bl) {
                this.req = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetReq();
                        break;
                    }
                    this.setReq((RequestParam)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getReq();
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
                    return this.isSetReq();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof performRecordRequest_args) {
                return this.equals((performRecordRequest_args)object);
            }
            return false;
        }

        public boolean equals(performRecordRequest_args performRecordRequest_args2) {
            if (performRecordRequest_args2 == null) {
                return false;
            }
            if (this == performRecordRequest_args2) {
                return true;
            }
            boolean bl = this.isSetReq();
            boolean bl2 = performRecordRequest_args2.isSetReq();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.req.equals(performRecordRequest_args2.req)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetReq() ? 131071 : 524287);
            if (this.isSetReq()) {
                n = n * 8191 + this.req.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(performRecordRequest_args performRecordRequest_args2) {
            if (!this.getClass().equals(performRecordRequest_args2.getClass())) {
                return this.getClass().getName().compareTo(performRecordRequest_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetReq(), performRecordRequest_args2.isSetReq());
            if (n != 0) {
                return n;
            }
            if (this.isSetReq() && (n = TBaseHelper.compareTo((Comparable)this.req, (Comparable)performRecordRequest_args2.req)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            performRecordRequest_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            performRecordRequest_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("performRecordRequest_args(");
            boolean bl = true;
            stringBuilder.append("req:");
            if (this.req == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.req);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.req != null) {
                this.req.validate();
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
            enumMap.put(_Fields.REQ, new FieldMetaData("req", 3, (FieldValueMetaData)new StructMetaData(12, RequestParam.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(performRecordRequest_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            REQ(1, "req");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return REQ;
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

        private static class performRecordRequest_argsStandardSchemeFactory
        implements SchemeFactory {
            private performRecordRequest_argsStandardSchemeFactory() {
            }

            public performRecordRequest_argsStandardScheme getScheme() {
                return new performRecordRequest_argsStandardScheme();
            }
        }

        private static class performRecordRequest_argsTupleSchemeFactory
        implements SchemeFactory {
            private performRecordRequest_argsTupleSchemeFactory() {
            }

            public performRecordRequest_argsTupleScheme getScheme() {
                return new performRecordRequest_argsTupleScheme();
            }
        }

        private static class performRecordRequest_argsTupleScheme
        extends TupleScheme<performRecordRequest_args> {
            private performRecordRequest_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, performRecordRequest_args performRecordRequest_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (performRecordRequest_args2.isSetReq()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (performRecordRequest_args2.isSetReq()) {
                    performRecordRequest_args2.req.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, performRecordRequest_args performRecordRequest_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    performRecordRequest_args2.req = new RequestParam();
                    performRecordRequest_args2.req.read((TProtocol)tTupleProtocol);
                    performRecordRequest_args2.setReqIsSet(true);
                }
            }
        }

        private static class performRecordRequest_argsStandardScheme
        extends StandardScheme<performRecordRequest_args> {
            private performRecordRequest_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, performRecordRequest_args performRecordRequest_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                performRecordRequest_args2.req = new RequestParam();
                                performRecordRequest_args2.req.read(tProtocol);
                                performRecordRequest_args2.setReqIsSet(true);
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
                performRecordRequest_args2.validate();
            }

            public void write(TProtocol tProtocol, performRecordRequest_args performRecordRequest_args2) throws TException {
                performRecordRequest_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (performRecordRequest_args2.req != null) {
                    tProtocol.writeFieldBegin(REQ_FIELD_DESC);
                    performRecordRequest_args2.req.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getScriptNames_result
    implements TBase<getScriptNames_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getScriptNames_result> {
        private static final TStruct STRUCT_DESC = new TStruct("getScriptNames_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 12, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getScriptNames_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getScriptNames_resultTupleSchemeFactory();
        @Nullable
        private IDLNameSet success;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getScriptNames_result() {
        }

        public getScriptNames_result(IDLNameSet iDLNameSet) {
            this();
            this.success = iDLNameSet;
        }

        public getScriptNames_result(getScriptNames_result getScriptNames_result2) {
            if (getScriptNames_result2.isSetSuccess()) {
                this.success = new IDLNameSet(getScriptNames_result2.success);
            }
        }

        public getScriptNames_result deepCopy() {
            return new getScriptNames_result(this);
        }

        public void clear() {
            this.success = null;
        }

        @Nullable
        public IDLNameSet getSuccess() {
            return this.success;
        }

        public void setSuccess(@Nullable IDLNameSet iDLNameSet) {
            this.success = iDLNameSet;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean bl) {
            if (!bl) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((IDLNameSet)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getScriptNames_result) {
                return this.equals((getScriptNames_result)object);
            }
            return false;
        }

        public boolean equals(getScriptNames_result getScriptNames_result2) {
            if (getScriptNames_result2 == null) {
                return false;
            }
            if (this == getScriptNames_result2) {
                return true;
            }
            boolean bl = this.isSetSuccess();
            boolean bl2 = getScriptNames_result2.isSetSuccess();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.success.equals(getScriptNames_result2.success)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetSuccess() ? 131071 : 524287);
            if (this.isSetSuccess()) {
                n = n * 8191 + this.success.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getScriptNames_result getScriptNames_result2) {
            if (!this.getClass().equals(getScriptNames_result2.getClass())) {
                return this.getClass().getName().compareTo(getScriptNames_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), getScriptNames_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((Comparable)this.success, (Comparable)getScriptNames_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getScriptNames_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getScriptNames_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getScriptNames_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            if (this.success == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.success);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.success != null) {
                this.success.validate();
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, (FieldValueMetaData)new StructMetaData(12, IDLNameSet.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getScriptNames_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class getScriptNames_resultStandardSchemeFactory
        implements SchemeFactory {
            private getScriptNames_resultStandardSchemeFactory() {
            }

            public getScriptNames_resultStandardScheme getScheme() {
                return new getScriptNames_resultStandardScheme();
            }
        }

        private static class getScriptNames_resultTupleSchemeFactory
        implements SchemeFactory {
            private getScriptNames_resultTupleSchemeFactory() {
            }

            public getScriptNames_resultTupleScheme getScheme() {
                return new getScriptNames_resultTupleScheme();
            }
        }

        private static class getScriptNames_resultTupleScheme
        extends TupleScheme<getScriptNames_result> {
            private getScriptNames_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, getScriptNames_result getScriptNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getScriptNames_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getScriptNames_result2.isSetSuccess()) {
                    getScriptNames_result2.success.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getScriptNames_result getScriptNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getScriptNames_result2.success = new IDLNameSet();
                    getScriptNames_result2.success.read((TProtocol)tTupleProtocol);
                    getScriptNames_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class getScriptNames_resultStandardScheme
        extends StandardScheme<getScriptNames_result> {
            private getScriptNames_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, getScriptNames_result getScriptNames_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 12) {
                                getScriptNames_result2.success = new IDLNameSet();
                                getScriptNames_result2.success.read(tProtocol);
                                getScriptNames_result2.setSuccessIsSet(true);
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
                getScriptNames_result2.validate();
            }

            public void write(TProtocol tProtocol, getScriptNames_result getScriptNames_result2) throws TException {
                getScriptNames_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getScriptNames_result2.success != null) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    getScriptNames_result2.success.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getScriptNames_args
    implements TBase<getScriptNames_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getScriptNames_args> {
        private static final TStruct STRUCT_DESC = new TStruct("getScriptNames_args");
        private static final TField REQ_FIELD_DESC = new TField("req", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getScriptNames_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getScriptNames_argsTupleSchemeFactory();
        @Nullable
        private RequestParam req;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getScriptNames_args() {
        }

        public getScriptNames_args(RequestParam requestParam) {
            this();
            this.req = requestParam;
        }

        public getScriptNames_args(getScriptNames_args getScriptNames_args2) {
            if (getScriptNames_args2.isSetReq()) {
                this.req = new RequestParam(getScriptNames_args2.req);
            }
        }

        public getScriptNames_args deepCopy() {
            return new getScriptNames_args(this);
        }

        public void clear() {
            this.req = null;
        }

        @Nullable
        public RequestParam getReq() {
            return this.req;
        }

        public void setReq(@Nullable RequestParam requestParam) {
            this.req = requestParam;
        }

        public void unsetReq() {
            this.req = null;
        }

        public boolean isSetReq() {
            return this.req != null;
        }

        public void setReqIsSet(boolean bl) {
            if (!bl) {
                this.req = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetReq();
                        break;
                    }
                    this.setReq((RequestParam)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getReq();
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
                    return this.isSetReq();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getScriptNames_args) {
                return this.equals((getScriptNames_args)object);
            }
            return false;
        }

        public boolean equals(getScriptNames_args getScriptNames_args2) {
            if (getScriptNames_args2 == null) {
                return false;
            }
            if (this == getScriptNames_args2) {
                return true;
            }
            boolean bl = this.isSetReq();
            boolean bl2 = getScriptNames_args2.isSetReq();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.req.equals(getScriptNames_args2.req)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetReq() ? 131071 : 524287);
            if (this.isSetReq()) {
                n = n * 8191 + this.req.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getScriptNames_args getScriptNames_args2) {
            if (!this.getClass().equals(getScriptNames_args2.getClass())) {
                return this.getClass().getName().compareTo(getScriptNames_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetReq(), getScriptNames_args2.isSetReq());
            if (n != 0) {
                return n;
            }
            if (this.isSetReq() && (n = TBaseHelper.compareTo((Comparable)this.req, (Comparable)getScriptNames_args2.req)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getScriptNames_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getScriptNames_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getScriptNames_args(");
            boolean bl = true;
            stringBuilder.append("req:");
            if (this.req == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.req);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.req != null) {
                this.req.validate();
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
            enumMap.put(_Fields.REQ, new FieldMetaData("req", 3, (FieldValueMetaData)new StructMetaData(12, RequestParam.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getScriptNames_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            REQ(1, "req");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return REQ;
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

        private static class getScriptNames_argsStandardSchemeFactory
        implements SchemeFactory {
            private getScriptNames_argsStandardSchemeFactory() {
            }

            public getScriptNames_argsStandardScheme getScheme() {
                return new getScriptNames_argsStandardScheme();
            }
        }

        private static class getScriptNames_argsTupleSchemeFactory
        implements SchemeFactory {
            private getScriptNames_argsTupleSchemeFactory() {
            }

            public getScriptNames_argsTupleScheme getScheme() {
                return new getScriptNames_argsTupleScheme();
            }
        }

        private static class getScriptNames_argsTupleScheme
        extends TupleScheme<getScriptNames_args> {
            private getScriptNames_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, getScriptNames_args getScriptNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getScriptNames_args2.isSetReq()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getScriptNames_args2.isSetReq()) {
                    getScriptNames_args2.req.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getScriptNames_args getScriptNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getScriptNames_args2.req = new RequestParam();
                    getScriptNames_args2.req.read((TProtocol)tTupleProtocol);
                    getScriptNames_args2.setReqIsSet(true);
                }
            }
        }

        private static class getScriptNames_argsStandardScheme
        extends StandardScheme<getScriptNames_args> {
            private getScriptNames_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, getScriptNames_args getScriptNames_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                getScriptNames_args2.req = new RequestParam();
                                getScriptNames_args2.req.read(tProtocol);
                                getScriptNames_args2.setReqIsSet(true);
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
                getScriptNames_args2.validate();
            }

            public void write(TProtocol tProtocol, getScriptNames_args getScriptNames_args2) throws TException {
                getScriptNames_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getScriptNames_args2.req != null) {
                    tProtocol.writeFieldBegin(REQ_FIELD_DESC);
                    getScriptNames_args2.req.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getLayoutNames_result
    implements TBase<getLayoutNames_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getLayoutNames_result> {
        private static final TStruct STRUCT_DESC = new TStruct("getLayoutNames_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 12, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getLayoutNames_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getLayoutNames_resultTupleSchemeFactory();
        @Nullable
        private IDLNameSet success;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getLayoutNames_result() {
        }

        public getLayoutNames_result(IDLNameSet iDLNameSet) {
            this();
            this.success = iDLNameSet;
        }

        public getLayoutNames_result(getLayoutNames_result getLayoutNames_result2) {
            if (getLayoutNames_result2.isSetSuccess()) {
                this.success = new IDLNameSet(getLayoutNames_result2.success);
            }
        }

        public getLayoutNames_result deepCopy() {
            return new getLayoutNames_result(this);
        }

        public void clear() {
            this.success = null;
        }

        @Nullable
        public IDLNameSet getSuccess() {
            return this.success;
        }

        public void setSuccess(@Nullable IDLNameSet iDLNameSet) {
            this.success = iDLNameSet;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean bl) {
            if (!bl) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((IDLNameSet)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getLayoutNames_result) {
                return this.equals((getLayoutNames_result)object);
            }
            return false;
        }

        public boolean equals(getLayoutNames_result getLayoutNames_result2) {
            if (getLayoutNames_result2 == null) {
                return false;
            }
            if (this == getLayoutNames_result2) {
                return true;
            }
            boolean bl = this.isSetSuccess();
            boolean bl2 = getLayoutNames_result2.isSetSuccess();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.success.equals(getLayoutNames_result2.success)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetSuccess() ? 131071 : 524287);
            if (this.isSetSuccess()) {
                n = n * 8191 + this.success.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getLayoutNames_result getLayoutNames_result2) {
            if (!this.getClass().equals(getLayoutNames_result2.getClass())) {
                return this.getClass().getName().compareTo(getLayoutNames_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), getLayoutNames_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((Comparable)this.success, (Comparable)getLayoutNames_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getLayoutNames_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getLayoutNames_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getLayoutNames_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            if (this.success == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.success);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.success != null) {
                this.success.validate();
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, (FieldValueMetaData)new StructMetaData(12, IDLNameSet.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getLayoutNames_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class getLayoutNames_resultStandardSchemeFactory
        implements SchemeFactory {
            private getLayoutNames_resultStandardSchemeFactory() {
            }

            public getLayoutNames_resultStandardScheme getScheme() {
                return new getLayoutNames_resultStandardScheme();
            }
        }

        private static class getLayoutNames_resultTupleSchemeFactory
        implements SchemeFactory {
            private getLayoutNames_resultTupleSchemeFactory() {
            }

            public getLayoutNames_resultTupleScheme getScheme() {
                return new getLayoutNames_resultTupleScheme();
            }
        }

        private static class getLayoutNames_resultTupleScheme
        extends TupleScheme<getLayoutNames_result> {
            private getLayoutNames_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, getLayoutNames_result getLayoutNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getLayoutNames_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getLayoutNames_result2.isSetSuccess()) {
                    getLayoutNames_result2.success.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getLayoutNames_result getLayoutNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getLayoutNames_result2.success = new IDLNameSet();
                    getLayoutNames_result2.success.read((TProtocol)tTupleProtocol);
                    getLayoutNames_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class getLayoutNames_resultStandardScheme
        extends StandardScheme<getLayoutNames_result> {
            private getLayoutNames_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, getLayoutNames_result getLayoutNames_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 12) {
                                getLayoutNames_result2.success = new IDLNameSet();
                                getLayoutNames_result2.success.read(tProtocol);
                                getLayoutNames_result2.setSuccessIsSet(true);
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
                getLayoutNames_result2.validate();
            }

            public void write(TProtocol tProtocol, getLayoutNames_result getLayoutNames_result2) throws TException {
                getLayoutNames_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getLayoutNames_result2.success != null) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    getLayoutNames_result2.success.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getLayoutNames_args
    implements TBase<getLayoutNames_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getLayoutNames_args> {
        private static final TStruct STRUCT_DESC = new TStruct("getLayoutNames_args");
        private static final TField REQ_FIELD_DESC = new TField("req", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getLayoutNames_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getLayoutNames_argsTupleSchemeFactory();
        @Nullable
        private RequestParam req;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getLayoutNames_args() {
        }

        public getLayoutNames_args(RequestParam requestParam) {
            this();
            this.req = requestParam;
        }

        public getLayoutNames_args(getLayoutNames_args getLayoutNames_args2) {
            if (getLayoutNames_args2.isSetReq()) {
                this.req = new RequestParam(getLayoutNames_args2.req);
            }
        }

        public getLayoutNames_args deepCopy() {
            return new getLayoutNames_args(this);
        }

        public void clear() {
            this.req = null;
        }

        @Nullable
        public RequestParam getReq() {
            return this.req;
        }

        public void setReq(@Nullable RequestParam requestParam) {
            this.req = requestParam;
        }

        public void unsetReq() {
            this.req = null;
        }

        public boolean isSetReq() {
            return this.req != null;
        }

        public void setReqIsSet(boolean bl) {
            if (!bl) {
                this.req = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetReq();
                        break;
                    }
                    this.setReq((RequestParam)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getReq();
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
                    return this.isSetReq();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getLayoutNames_args) {
                return this.equals((getLayoutNames_args)object);
            }
            return false;
        }

        public boolean equals(getLayoutNames_args getLayoutNames_args2) {
            if (getLayoutNames_args2 == null) {
                return false;
            }
            if (this == getLayoutNames_args2) {
                return true;
            }
            boolean bl = this.isSetReq();
            boolean bl2 = getLayoutNames_args2.isSetReq();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.req.equals(getLayoutNames_args2.req)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetReq() ? 131071 : 524287);
            if (this.isSetReq()) {
                n = n * 8191 + this.req.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getLayoutNames_args getLayoutNames_args2) {
            if (!this.getClass().equals(getLayoutNames_args2.getClass())) {
                return this.getClass().getName().compareTo(getLayoutNames_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetReq(), getLayoutNames_args2.isSetReq());
            if (n != 0) {
                return n;
            }
            if (this.isSetReq() && (n = TBaseHelper.compareTo((Comparable)this.req, (Comparable)getLayoutNames_args2.req)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getLayoutNames_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getLayoutNames_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getLayoutNames_args(");
            boolean bl = true;
            stringBuilder.append("req:");
            if (this.req == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.req);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.req != null) {
                this.req.validate();
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
            enumMap.put(_Fields.REQ, new FieldMetaData("req", 3, (FieldValueMetaData)new StructMetaData(12, RequestParam.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getLayoutNames_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            REQ(1, "req");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return REQ;
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

        private static class getLayoutNames_argsStandardSchemeFactory
        implements SchemeFactory {
            private getLayoutNames_argsStandardSchemeFactory() {
            }

            public getLayoutNames_argsStandardScheme getScheme() {
                return new getLayoutNames_argsStandardScheme();
            }
        }

        private static class getLayoutNames_argsTupleSchemeFactory
        implements SchemeFactory {
            private getLayoutNames_argsTupleSchemeFactory() {
            }

            public getLayoutNames_argsTupleScheme getScheme() {
                return new getLayoutNames_argsTupleScheme();
            }
        }

        private static class getLayoutNames_argsTupleScheme
        extends TupleScheme<getLayoutNames_args> {
            private getLayoutNames_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, getLayoutNames_args getLayoutNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getLayoutNames_args2.isSetReq()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getLayoutNames_args2.isSetReq()) {
                    getLayoutNames_args2.req.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getLayoutNames_args getLayoutNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getLayoutNames_args2.req = new RequestParam();
                    getLayoutNames_args2.req.read((TProtocol)tTupleProtocol);
                    getLayoutNames_args2.setReqIsSet(true);
                }
            }
        }

        private static class getLayoutNames_argsStandardScheme
        extends StandardScheme<getLayoutNames_args> {
            private getLayoutNames_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, getLayoutNames_args getLayoutNames_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                getLayoutNames_args2.req = new RequestParam();
                                getLayoutNames_args2.req.read(tProtocol);
                                getLayoutNames_args2.setReqIsSet(true);
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
                getLayoutNames_args2.validate();
            }

            public void write(TProtocol tProtocol, getLayoutNames_args getLayoutNames_args2) throws TException {
                getLayoutNames_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getLayoutNames_args2.req != null) {
                    tProtocol.writeFieldBegin(REQ_FIELD_DESC);
                    getLayoutNames_args2.req.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getDatabaseNames_result
    implements TBase<getDatabaseNames_result, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getDatabaseNames_result> {
        private static final TStruct STRUCT_DESC = new TStruct("getDatabaseNames_result");
        private static final TField SUCCESS_FIELD_DESC = new TField("success", 12, 0);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getDatabaseNames_resultStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getDatabaseNames_resultTupleSchemeFactory();
        @Nullable
        private DatabaseNamesResult success;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getDatabaseNames_result() {
        }

        public getDatabaseNames_result(DatabaseNamesResult databaseNamesResult) {
            this();
            this.success = databaseNamesResult;
        }

        public getDatabaseNames_result(getDatabaseNames_result getDatabaseNames_result2) {
            if (getDatabaseNames_result2.isSetSuccess()) {
                this.success = new DatabaseNamesResult(getDatabaseNames_result2.success);
            }
        }

        public getDatabaseNames_result deepCopy() {
            return new getDatabaseNames_result(this);
        }

        public void clear() {
            this.success = null;
        }

        @Nullable
        public DatabaseNamesResult getSuccess() {
            return this.success;
        }

        public void setSuccess(@Nullable DatabaseNamesResult databaseNamesResult) {
            this.success = databaseNamesResult;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean bl) {
            if (!bl) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetSuccess();
                        break;
                    }
                    this.setSuccess((DatabaseNamesResult)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getSuccess();
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
                    return this.isSetSuccess();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getDatabaseNames_result) {
                return this.equals((getDatabaseNames_result)object);
            }
            return false;
        }

        public boolean equals(getDatabaseNames_result getDatabaseNames_result2) {
            if (getDatabaseNames_result2 == null) {
                return false;
            }
            if (this == getDatabaseNames_result2) {
                return true;
            }
            boolean bl = this.isSetSuccess();
            boolean bl2 = getDatabaseNames_result2.isSetSuccess();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.success.equals(getDatabaseNames_result2.success)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetSuccess() ? 131071 : 524287);
            if (this.isSetSuccess()) {
                n = n * 8191 + this.success.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getDatabaseNames_result getDatabaseNames_result2) {
            if (!this.getClass().equals(getDatabaseNames_result2.getClass())) {
                return this.getClass().getName().compareTo(getDatabaseNames_result2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetSuccess(), getDatabaseNames_result2.isSetSuccess());
            if (n != 0) {
                return n;
            }
            if (this.isSetSuccess() && (n = TBaseHelper.compareTo((Comparable)this.success, (Comparable)getDatabaseNames_result2.success)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getDatabaseNames_result.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getDatabaseNames_result.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getDatabaseNames_result(");
            boolean bl = true;
            stringBuilder.append("success:");
            if (this.success == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.success);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.success != null) {
                this.success.validate();
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
            enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, (FieldValueMetaData)new StructMetaData(12, DatabaseNamesResult.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getDatabaseNames_result.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            SUCCESS(0, "success");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 0: {
                        return SUCCESS;
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

        private static class getDatabaseNames_resultStandardSchemeFactory
        implements SchemeFactory {
            private getDatabaseNames_resultStandardSchemeFactory() {
            }

            public getDatabaseNames_resultStandardScheme getScheme() {
                return new getDatabaseNames_resultStandardScheme();
            }
        }

        private static class getDatabaseNames_resultTupleSchemeFactory
        implements SchemeFactory {
            private getDatabaseNames_resultTupleSchemeFactory() {
            }

            public getDatabaseNames_resultTupleScheme getScheme() {
                return new getDatabaseNames_resultTupleScheme();
            }
        }

        private static class getDatabaseNames_resultTupleScheme
        extends TupleScheme<getDatabaseNames_result> {
            private getDatabaseNames_resultTupleScheme() {
            }

            public void write(TProtocol tProtocol, getDatabaseNames_result getDatabaseNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getDatabaseNames_result2.isSetSuccess()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getDatabaseNames_result2.isSetSuccess()) {
                    getDatabaseNames_result2.success.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getDatabaseNames_result getDatabaseNames_result2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getDatabaseNames_result2.success = new DatabaseNamesResult();
                    getDatabaseNames_result2.success.read((TProtocol)tTupleProtocol);
                    getDatabaseNames_result2.setSuccessIsSet(true);
                }
            }
        }

        private static class getDatabaseNames_resultStandardScheme
        extends StandardScheme<getDatabaseNames_result> {
            private getDatabaseNames_resultStandardScheme() {
            }

            public void read(TProtocol tProtocol, getDatabaseNames_result getDatabaseNames_result2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 0: {
                            if (tField.type == 12) {
                                getDatabaseNames_result2.success = new DatabaseNamesResult();
                                getDatabaseNames_result2.success.read(tProtocol);
                                getDatabaseNames_result2.setSuccessIsSet(true);
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
                getDatabaseNames_result2.validate();
            }

            public void write(TProtocol tProtocol, getDatabaseNames_result getDatabaseNames_result2) throws TException {
                getDatabaseNames_result2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getDatabaseNames_result2.success != null) {
                    tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
                    getDatabaseNames_result2.success.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class getDatabaseNames_args
    implements TBase<getDatabaseNames_args, _Fields>,
    Serializable,
    Cloneable,
    Comparable<getDatabaseNames_args> {
        private static final TStruct STRUCT_DESC = new TStruct("getDatabaseNames_args");
        private static final TField CRED_FIELD_DESC = new TField("cred", 12, 1);
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new getDatabaseNames_argsStandardSchemeFactory();
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new getDatabaseNames_argsTupleSchemeFactory();
        @Nullable
        private Credentials cred;
        public static final Map<_Fields, FieldMetaData> metaDataMap;

        public getDatabaseNames_args() {
        }

        public getDatabaseNames_args(Credentials credentials) {
            this();
            this.cred = credentials;
        }

        public getDatabaseNames_args(getDatabaseNames_args getDatabaseNames_args2) {
            if (getDatabaseNames_args2.isSetCred()) {
                this.cred = new Credentials(getDatabaseNames_args2.cred);
            }
        }

        public getDatabaseNames_args deepCopy() {
            return new getDatabaseNames_args(this);
        }

        public void clear() {
            this.cred = null;
        }

        @Nullable
        public Credentials getCred() {
            return this.cred;
        }

        public void setCred(@Nullable Credentials credentials) {
            this.cred = credentials;
        }

        public void unsetCred() {
            this.cred = null;
        }

        public boolean isSetCred() {
            return this.cred != null;
        }

        public void setCredIsSet(boolean bl) {
            if (!bl) {
                this.cred = null;
            }
        }

        public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    if (object == null) {
                        this.unsetCred();
                        break;
                    }
                    this.setCred((Credentials)object);
                }
            }
        }

        @Nullable
        public Object getFieldValue(_Fields _Fields2) {
            switch (_Fields2.ordinal()) {
                case 0: {
                    return this.getCred();
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
                    return this.isSetCred();
                }
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object object) {
            if (object instanceof getDatabaseNames_args) {
                return this.equals((getDatabaseNames_args)object);
            }
            return false;
        }

        public boolean equals(getDatabaseNames_args getDatabaseNames_args2) {
            if (getDatabaseNames_args2 == null) {
                return false;
            }
            if (this == getDatabaseNames_args2) {
                return true;
            }
            boolean bl = this.isSetCred();
            boolean bl2 = getDatabaseNames_args2.isSetCred();
            if (bl || bl2) {
                if (!bl || !bl2) {
                    return false;
                }
                if (!this.cred.equals(getDatabaseNames_args2.cred)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int n = 1;
            n = n * 8191 + (this.isSetCred() ? 131071 : 524287);
            if (this.isSetCred()) {
                n = n * 8191 + this.cred.hashCode();
            }
            return n;
        }

        @Override
        public int compareTo(getDatabaseNames_args getDatabaseNames_args2) {
            if (!this.getClass().equals(getDatabaseNames_args2.getClass())) {
                return this.getClass().getName().compareTo(getDatabaseNames_args2.getClass().getName());
            }
            int n = 0;
            n = Boolean.compare(this.isSetCred(), getDatabaseNames_args2.isSetCred());
            if (n != 0) {
                return n;
            }
            if (this.isSetCred() && (n = TBaseHelper.compareTo((Comparable)this.cred, (Comparable)getDatabaseNames_args2.cred)) != 0) {
                return n;
            }
            return 0;
        }

        @Nullable
        public _Fields fieldForId(int n) {
            return _Fields.findByThriftId(n);
        }

        public void read(TProtocol tProtocol) throws TException {
            getDatabaseNames_args.scheme(tProtocol).read(tProtocol, (TBase)this);
        }

        public void write(TProtocol tProtocol) throws TException {
            getDatabaseNames_args.scheme(tProtocol).write(tProtocol, (TBase)this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("getDatabaseNames_args(");
            boolean bl = true;
            stringBuilder.append("cred:");
            if (this.cred == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.cred);
            }
            bl = false;
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void validate() throws TException {
            if (this.cred != null) {
                this.cred.validate();
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
            enumMap.put(_Fields.CRED, new FieldMetaData("cred", 3, (FieldValueMetaData)new StructMetaData(12, Credentials.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(getDatabaseNames_args.class, metaDataMap);
        }

        public static enum _Fields implements TFieldIdEnum
        {
            CRED(1, "cred");

            private static final Map<String, _Fields> byName;
            private final short _thriftId;
            private final String _fieldName;

            @Nullable
            public static _Fields findByThriftId(int n) {
                switch (n) {
                    case 1: {
                        return CRED;
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

        private static class getDatabaseNames_argsStandardSchemeFactory
        implements SchemeFactory {
            private getDatabaseNames_argsStandardSchemeFactory() {
            }

            public getDatabaseNames_argsStandardScheme getScheme() {
                return new getDatabaseNames_argsStandardScheme();
            }
        }

        private static class getDatabaseNames_argsTupleSchemeFactory
        implements SchemeFactory {
            private getDatabaseNames_argsTupleSchemeFactory() {
            }

            public getDatabaseNames_argsTupleScheme getScheme() {
                return new getDatabaseNames_argsTupleScheme();
            }
        }

        private static class getDatabaseNames_argsTupleScheme
        extends TupleScheme<getDatabaseNames_args> {
            private getDatabaseNames_argsTupleScheme() {
            }

            public void write(TProtocol tProtocol, getDatabaseNames_args getDatabaseNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = new BitSet();
                if (getDatabaseNames_args2.isSetCred()) {
                    bitSet.set(0);
                }
                tTupleProtocol.writeBitSet(bitSet, 1);
                if (getDatabaseNames_args2.isSetCred()) {
                    getDatabaseNames_args2.cred.write((TProtocol)tTupleProtocol);
                }
            }

            public void read(TProtocol tProtocol, getDatabaseNames_args getDatabaseNames_args2) throws TException {
                TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
                BitSet bitSet = tTupleProtocol.readBitSet(1);
                if (bitSet.get(0)) {
                    getDatabaseNames_args2.cred = new Credentials();
                    getDatabaseNames_args2.cred.read((TProtocol)tTupleProtocol);
                    getDatabaseNames_args2.setCredIsSet(true);
                }
            }
        }

        private static class getDatabaseNames_argsStandardScheme
        extends StandardScheme<getDatabaseNames_args> {
            private getDatabaseNames_argsStandardScheme() {
            }

            public void read(TProtocol tProtocol, getDatabaseNames_args getDatabaseNames_args2) throws TException {
                tProtocol.readStructBegin();
                while (true) {
                    TField tField = tProtocol.readFieldBegin();
                    if (tField.type == 0) break;
                    switch (tField.id) {
                        case 1: {
                            if (tField.type == 12) {
                                getDatabaseNames_args2.cred = new Credentials();
                                getDatabaseNames_args2.cred.read(tProtocol);
                                getDatabaseNames_args2.setCredIsSet(true);
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
                getDatabaseNames_args2.validate();
            }

            public void write(TProtocol tProtocol, getDatabaseNames_args getDatabaseNames_args2) throws TException {
                getDatabaseNames_args2.validate();
                tProtocol.writeStructBegin(STRUCT_DESC);
                if (getDatabaseNames_args2.cred != null) {
                    tProtocol.writeFieldBegin(CRED_FIELD_DESC);
                    getDatabaseNames_args2.cred.write(tProtocol);
                    tProtocol.writeFieldEnd();
                }
                tProtocol.writeFieldStop();
                tProtocol.writeStructEnd();
            }
        }
    }

    public static class AsyncProcessor<I extends AsyncIface>
    extends TBaseAsyncProcessor<I> {
        private static final Logger _LOGGER = LoggerFactory.getLogger((String)AsyncProcessor.class.getName());

        public AsyncProcessor(I i) {
            super(i, AsyncProcessor.getProcessMap(new HashMap()));
        }

        protected AsyncProcessor(I i, Map<String, AsyncProcessFunction<I, ? extends TBase, ?, ? extends TBase>> map) {
            super(i, AsyncProcessor.getProcessMap(map));
        }

        private static <I extends AsyncIface> Map<String, AsyncProcessFunction<I, ? extends TBase, ?, ? extends TBase>> getProcessMap(Map<String, AsyncProcessFunction<I, ? extends TBase, ?, ? extends TBase>> map) {
            map.put("getDatabaseNames", new getDatabaseNames());
            map.put("getLayoutNames", new getLayoutNames());
            map.put("getScriptNames", new getScriptNames());
            map.put("performRecordRequest", new performRecordRequest());
            map.put("getContainerData", new getContainerData());
            map.put("configure", new configure());
            map.put("ping", new ping());
            map.put("quit", new quit());
            map.put("force_quit", new force_quit());
            map.put("dump", new dump());
            return map;
        }

        public static class getDatabaseNames<I extends AsyncIface>
        extends AsyncProcessFunction<I, getDatabaseNames_args, DatabaseNamesResult, getDatabaseNames_result> {
            public getDatabaseNames() {
                super("getDatabaseNames");
            }

            public getDatabaseNames_result getEmptyResultInstance() {
                return new getDatabaseNames_result();
            }

            public getDatabaseNames_args getEmptyArgsInstance() {
                return new getDatabaseNames_args();
            }

            public AsyncMethodCallback<DatabaseNamesResult> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final getDatabaseNames getDatabaseNames2 = this;
                return new AsyncMethodCallback<DatabaseNamesResult>(){

                    public void onComplete(DatabaseNamesResult databaseNamesResult) {
                        getDatabaseNames_result getDatabaseNames_result2 = new getDatabaseNames_result();
                        getDatabaseNames_result2.success = databaseNamesResult;
                        try {
                            getDatabaseNames2.sendResponse(asyncFrameBuffer, (TSerializable)getDatabaseNames_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        getDatabaseNames_result getDatabaseNames_result2 = new getDatabaseNames_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            getDatabaseNames2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, getDatabaseNames_args getDatabaseNames_args2, AsyncMethodCallback<DatabaseNamesResult> asyncMethodCallback) throws TException {
                i.getDatabaseNames(getDatabaseNames_args2.cred, asyncMethodCallback);
            }
        }

        public static class getLayoutNames<I extends AsyncIface>
        extends AsyncProcessFunction<I, getLayoutNames_args, IDLNameSet, getLayoutNames_result> {
            public getLayoutNames() {
                super("getLayoutNames");
            }

            public getLayoutNames_result getEmptyResultInstance() {
                return new getLayoutNames_result();
            }

            public getLayoutNames_args getEmptyArgsInstance() {
                return new getLayoutNames_args();
            }

            public AsyncMethodCallback<IDLNameSet> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final getLayoutNames getLayoutNames2 = this;
                return new AsyncMethodCallback<IDLNameSet>(){

                    public void onComplete(IDLNameSet iDLNameSet) {
                        getLayoutNames_result getLayoutNames_result2 = new getLayoutNames_result();
                        getLayoutNames_result2.success = iDLNameSet;
                        try {
                            getLayoutNames2.sendResponse(asyncFrameBuffer, (TSerializable)getLayoutNames_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        getLayoutNames_result getLayoutNames_result2 = new getLayoutNames_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            getLayoutNames2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, getLayoutNames_args getLayoutNames_args2, AsyncMethodCallback<IDLNameSet> asyncMethodCallback) throws TException {
                i.getLayoutNames(getLayoutNames_args2.req, asyncMethodCallback);
            }
        }

        public static class getScriptNames<I extends AsyncIface>
        extends AsyncProcessFunction<I, getScriptNames_args, IDLNameSet, getScriptNames_result> {
            public getScriptNames() {
                super("getScriptNames");
            }

            public getScriptNames_result getEmptyResultInstance() {
                return new getScriptNames_result();
            }

            public getScriptNames_args getEmptyArgsInstance() {
                return new getScriptNames_args();
            }

            public AsyncMethodCallback<IDLNameSet> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final getScriptNames getScriptNames2 = this;
                return new AsyncMethodCallback<IDLNameSet>(){

                    public void onComplete(IDLNameSet iDLNameSet) {
                        getScriptNames_result getScriptNames_result2 = new getScriptNames_result();
                        getScriptNames_result2.success = iDLNameSet;
                        try {
                            getScriptNames2.sendResponse(asyncFrameBuffer, (TSerializable)getScriptNames_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        getScriptNames_result getScriptNames_result2 = new getScriptNames_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            getScriptNames2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, getScriptNames_args getScriptNames_args2, AsyncMethodCallback<IDLNameSet> asyncMethodCallback) throws TException {
                i.getScriptNames(getScriptNames_args2.req, asyncMethodCallback);
            }
        }

        public static class performRecordRequest<I extends AsyncIface>
        extends AsyncProcessFunction<I, performRecordRequest_args, IDLResultSet, performRecordRequest_result> {
            public performRecordRequest() {
                super("performRecordRequest");
            }

            public performRecordRequest_result getEmptyResultInstance() {
                return new performRecordRequest_result();
            }

            public performRecordRequest_args getEmptyArgsInstance() {
                return new performRecordRequest_args();
            }

            public AsyncMethodCallback<IDLResultSet> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final performRecordRequest performRecordRequest2 = this;
                return new AsyncMethodCallback<IDLResultSet>(){

                    public void onComplete(IDLResultSet iDLResultSet) {
                        performRecordRequest_result performRecordRequest_result2 = new performRecordRequest_result();
                        performRecordRequest_result2.success = iDLResultSet;
                        try {
                            performRecordRequest2.sendResponse(asyncFrameBuffer, (TSerializable)performRecordRequest_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        performRecordRequest_result performRecordRequest_result2 = new performRecordRequest_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            performRecordRequest2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, performRecordRequest_args performRecordRequest_args2, AsyncMethodCallback<IDLResultSet> asyncMethodCallback) throws TException {
                i.performRecordRequest(performRecordRequest_args2.req, asyncMethodCallback);
            }
        }

        public static class getContainerData<I extends AsyncIface>
        extends AsyncProcessFunction<I, getContainerData_args, IDLContainerData, getContainerData_result> {
            public getContainerData() {
                super("getContainerData");
            }

            public getContainerData_result getEmptyResultInstance() {
                return new getContainerData_result();
            }

            public getContainerData_args getEmptyArgsInstance() {
                return new getContainerData_args();
            }

            public AsyncMethodCallback<IDLContainerData> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final getContainerData getContainerData2 = this;
                return new AsyncMethodCallback<IDLContainerData>(){

                    public void onComplete(IDLContainerData iDLContainerData) {
                        getContainerData_result getContainerData_result2 = new getContainerData_result();
                        getContainerData_result2.success = iDLContainerData;
                        try {
                            getContainerData2.sendResponse(asyncFrameBuffer, (TSerializable)getContainerData_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        getContainerData_result getContainerData_result2 = new getContainerData_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            getContainerData2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, getContainerData_args getContainerData_args2, AsyncMethodCallback<IDLContainerData> asyncMethodCallback) throws TException {
                i.getContainerData(getContainerData_args2.req, asyncMethodCallback);
            }
        }

        public static class configure<I extends AsyncIface>
        extends AsyncProcessFunction<I, configure_args, Void, configure_result> {
            public configure() {
                super("configure");
            }

            public configure_result getEmptyResultInstance() {
                return new configure_result();
            }

            public configure_args getEmptyArgsInstance() {
                return new configure_args();
            }

            public AsyncMethodCallback<Void> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final configure configure2 = this;
                return new AsyncMethodCallback<Void>(){

                    public void onComplete(Void void_) {
                        configure_result configure_result2 = new configure_result();
                        try {
                            configure2.sendResponse(asyncFrameBuffer, (TSerializable)configure_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        configure_result configure_result2 = new configure_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            configure2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, configure_args configure_args2, AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
                i.configure(configure_args2.param, asyncMethodCallback);
            }
        }

        public static class ping<I extends AsyncIface>
        extends AsyncProcessFunction<I, ping_args, Long, ping_result> {
            public ping() {
                super("ping");
            }

            public ping_result getEmptyResultInstance() {
                return new ping_result();
            }

            public ping_args getEmptyArgsInstance() {
                return new ping_args();
            }

            public AsyncMethodCallback<Long> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final ping ping2 = this;
                return new AsyncMethodCallback<Long>(){

                    public void onComplete(Long l) {
                        ping_result ping_result2 = new ping_result();
                        ping_result2.success = l;
                        ping_result2.setSuccessIsSet(true);
                        try {
                            ping2.sendResponse(asyncFrameBuffer, (TSerializable)ping_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        ping_result ping_result2 = new ping_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            ping2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, ping_args ping_args2, AsyncMethodCallback<Long> asyncMethodCallback) throws TException {
                i.ping(asyncMethodCallback);
            }
        }

        public static class quit<I extends AsyncIface>
        extends AsyncProcessFunction<I, quit_args, Void, quit_result> {
            public quit() {
                super("quit");
            }

            public quit_result getEmptyResultInstance() {
                return new quit_result();
            }

            public quit_args getEmptyArgsInstance() {
                return new quit_args();
            }

            public AsyncMethodCallback<Void> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final quit quit2 = this;
                return new AsyncMethodCallback<Void>(){

                    public void onComplete(Void void_) {
                        quit_result quit_result2 = new quit_result();
                        try {
                            quit2.sendResponse(asyncFrameBuffer, (TSerializable)quit_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        quit_result quit_result2 = new quit_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            quit2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, quit_args quit_args2, AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
                i.quit(asyncMethodCallback);
            }
        }

        public static class force_quit<I extends AsyncIface>
        extends AsyncProcessFunction<I, force_quit_args, Void, force_quit_result> {
            public force_quit() {
                super("force_quit");
            }

            public force_quit_result getEmptyResultInstance() {
                return new force_quit_result();
            }

            public force_quit_args getEmptyArgsInstance() {
                return new force_quit_args();
            }

            public AsyncMethodCallback<Void> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final force_quit force_quit2 = this;
                return new AsyncMethodCallback<Void>(){

                    public void onComplete(Void void_) {
                        force_quit_result force_quit_result2 = new force_quit_result();
                        try {
                            force_quit2.sendResponse(asyncFrameBuffer, (TSerializable)force_quit_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        force_quit_result force_quit_result2 = new force_quit_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            force_quit2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, force_quit_args force_quit_args2, AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
                i.force_quit(asyncMethodCallback);
            }
        }

        public static class dump<I extends AsyncIface>
        extends AsyncProcessFunction<I, dump_args, Void, dump_result> {
            public dump() {
                super("dump");
            }

            public dump_result getEmptyResultInstance() {
                return new dump_result();
            }

            public dump_args getEmptyArgsInstance() {
                return new dump_args();
            }

            public AsyncMethodCallback<Void> getResultHandler(final AbstractNonblockingServer.AsyncFrameBuffer asyncFrameBuffer, final int n) {
                final dump dump2 = this;
                return new AsyncMethodCallback<Void>(){

                    public void onComplete(Void void_) {
                        dump_result dump_result2 = new dump_result();
                        try {
                            dump2.sendResponse(asyncFrameBuffer, (TSerializable)dump_result2, (byte)2, n);
                        }
                        catch (TTransportException tTransportException) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", (Throwable)tTransportException);
                            asyncFrameBuffer.close();
                        }
                        catch (Exception exception) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception);
                            this.onError(exception);
                        }
                    }

                    public void onError(Exception exception) {
                        TApplicationException tApplicationException;
                        byte by = 2;
                        dump_result dump_result2 = new dump_result();
                        if (exception instanceof TTransportException) {
                            _LOGGER.error("TTransportException inside handler", (Throwable)exception);
                            asyncFrameBuffer.close();
                            return;
                        }
                        if (exception instanceof TApplicationException) {
                            _LOGGER.error("TApplicationException inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = (TApplicationException)exception;
                        } else {
                            _LOGGER.error("Exception inside handler", (Throwable)exception);
                            by = 3;
                            tApplicationException = new TApplicationException(6, exception.getMessage());
                        }
                        try {
                            dump2.sendResponse(asyncFrameBuffer, (TSerializable)tApplicationException, by, n);
                        }
                        catch (Exception exception2) {
                            _LOGGER.error("Exception writing to internal frame buffer", (Throwable)exception2);
                            asyncFrameBuffer.close();
                        }
                    }
                };
            }

            public boolean isOneway() {
                return false;
            }

            public void start(I i, dump_args dump_args2, AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
                i.dump(asyncMethodCallback);
            }
        }
    }

    public static class Processor<I extends Iface>
    extends TBaseProcessor<I>
    implements TProcessor {
        private static final Logger _LOGGER = LoggerFactory.getLogger((String)Processor.class.getName());

        public Processor(I i) {
            super(i, Processor.getProcessMap(new HashMap<String, ProcessFunction<I, ? extends TBase, ? extends TBase>>()));
        }

        protected Processor(I i, Map<String, ProcessFunction<I, ? extends TBase, ? extends TBase>> map) {
            super(i, Processor.getProcessMap(map));
        }

        private static <I extends Iface> Map<String, ProcessFunction<I, ? extends TBase, ? extends TBase>> getProcessMap(Map<String, ProcessFunction<I, ? extends TBase, ? extends TBase>> map) {
            map.put("getDatabaseNames", new getDatabaseNames());
            map.put("getLayoutNames", new getLayoutNames());
            map.put("getScriptNames", new getScriptNames());
            map.put("performRecordRequest", new performRecordRequest());
            map.put("getContainerData", new getContainerData());
            map.put("configure", new configure());
            map.put("ping", new ping());
            map.put("quit", new quit());
            map.put("force_quit", new force_quit());
            map.put("dump", new dump());
            return map;
        }

        public static class getDatabaseNames<I extends Iface>
        extends ProcessFunction<I, getDatabaseNames_args, getDatabaseNames_result> {
            public getDatabaseNames() {
                super("getDatabaseNames");
            }

            public getDatabaseNames_args getEmptyArgsInstance() {
                return new getDatabaseNames_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public getDatabaseNames_result getEmptyResultInstance() {
                return new getDatabaseNames_result();
            }

            public getDatabaseNames_result getResult(I i, getDatabaseNames_args getDatabaseNames_args2) throws TException {
                getDatabaseNames_result getDatabaseNames_result2 = this.getEmptyResultInstance();
                getDatabaseNames_result2.success = i.getDatabaseNames(getDatabaseNames_args2.cred);
                return getDatabaseNames_result2;
            }
        }

        public static class getLayoutNames<I extends Iface>
        extends ProcessFunction<I, getLayoutNames_args, getLayoutNames_result> {
            public getLayoutNames() {
                super("getLayoutNames");
            }

            public getLayoutNames_args getEmptyArgsInstance() {
                return new getLayoutNames_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public getLayoutNames_result getEmptyResultInstance() {
                return new getLayoutNames_result();
            }

            public getLayoutNames_result getResult(I i, getLayoutNames_args getLayoutNames_args2) throws TException {
                getLayoutNames_result getLayoutNames_result2 = this.getEmptyResultInstance();
                getLayoutNames_result2.success = i.getLayoutNames(getLayoutNames_args2.req);
                return getLayoutNames_result2;
            }
        }

        public static class getScriptNames<I extends Iface>
        extends ProcessFunction<I, getScriptNames_args, getScriptNames_result> {
            public getScriptNames() {
                super("getScriptNames");
            }

            public getScriptNames_args getEmptyArgsInstance() {
                return new getScriptNames_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public getScriptNames_result getEmptyResultInstance() {
                return new getScriptNames_result();
            }

            public getScriptNames_result getResult(I i, getScriptNames_args getScriptNames_args2) throws TException {
                getScriptNames_result getScriptNames_result2 = this.getEmptyResultInstance();
                getScriptNames_result2.success = i.getScriptNames(getScriptNames_args2.req);
                return getScriptNames_result2;
            }
        }

        public static class performRecordRequest<I extends Iface>
        extends ProcessFunction<I, performRecordRequest_args, performRecordRequest_result> {
            public performRecordRequest() {
                super("performRecordRequest");
            }

            public performRecordRequest_args getEmptyArgsInstance() {
                return new performRecordRequest_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public performRecordRequest_result getEmptyResultInstance() {
                return new performRecordRequest_result();
            }

            public performRecordRequest_result getResult(I i, performRecordRequest_args performRecordRequest_args2) throws TException {
                performRecordRequest_result performRecordRequest_result2 = this.getEmptyResultInstance();
                performRecordRequest_result2.success = i.performRecordRequest(performRecordRequest_args2.req);
                return performRecordRequest_result2;
            }
        }

        public static class getContainerData<I extends Iface>
        extends ProcessFunction<I, getContainerData_args, getContainerData_result> {
            public getContainerData() {
                super("getContainerData");
            }

            public getContainerData_args getEmptyArgsInstance() {
                return new getContainerData_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public getContainerData_result getEmptyResultInstance() {
                return new getContainerData_result();
            }

            public getContainerData_result getResult(I i, getContainerData_args getContainerData_args2) throws TException {
                getContainerData_result getContainerData_result2 = this.getEmptyResultInstance();
                getContainerData_result2.success = i.getContainerData(getContainerData_args2.req);
                return getContainerData_result2;
            }
        }

        public static class configure<I extends Iface>
        extends ProcessFunction<I, configure_args, configure_result> {
            public configure() {
                super("configure");
            }

            public configure_args getEmptyArgsInstance() {
                return new configure_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public configure_result getEmptyResultInstance() {
                return new configure_result();
            }

            public configure_result getResult(I i, configure_args configure_args2) throws TException {
                configure_result configure_result2 = this.getEmptyResultInstance();
                i.configure(configure_args2.param);
                return configure_result2;
            }
        }

        public static class ping<I extends Iface>
        extends ProcessFunction<I, ping_args, ping_result> {
            public ping() {
                super("ping");
            }

            public ping_args getEmptyArgsInstance() {
                return new ping_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public ping_result getEmptyResultInstance() {
                return new ping_result();
            }

            public ping_result getResult(I i, ping_args ping_args2) throws TException {
                ping_result ping_result2 = this.getEmptyResultInstance();
                ping_result2.success = i.ping();
                ping_result2.setSuccessIsSet(true);
                return ping_result2;
            }
        }

        public static class quit<I extends Iface>
        extends ProcessFunction<I, quit_args, quit_result> {
            public quit() {
                super("quit");
            }

            public quit_args getEmptyArgsInstance() {
                return new quit_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public quit_result getEmptyResultInstance() {
                return new quit_result();
            }

            public quit_result getResult(I i, quit_args quit_args2) throws TException {
                quit_result quit_result2 = this.getEmptyResultInstance();
                i.quit();
                return quit_result2;
            }
        }

        public static class force_quit<I extends Iface>
        extends ProcessFunction<I, force_quit_args, force_quit_result> {
            public force_quit() {
                super("force_quit");
            }

            public force_quit_args getEmptyArgsInstance() {
                return new force_quit_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public force_quit_result getEmptyResultInstance() {
                return new force_quit_result();
            }

            public force_quit_result getResult(I i, force_quit_args force_quit_args2) throws TException {
                force_quit_result force_quit_result2 = this.getEmptyResultInstance();
                i.force_quit();
                return force_quit_result2;
            }
        }

        public static class dump<I extends Iface>
        extends ProcessFunction<I, dump_args, dump_result> {
            public dump() {
                super("dump");
            }

            public dump_args getEmptyArgsInstance() {
                return new dump_args();
            }

            public boolean isOneway() {
                return false;
            }

            protected boolean rethrowUnhandledExceptions() {
                return false;
            }

            public dump_result getEmptyResultInstance() {
                return new dump_result();
            }

            public dump_result getResult(I i, dump_args dump_args2) throws TException {
                dump_result dump_result2 = this.getEmptyResultInstance();
                i.dump();
                return dump_result2;
            }
        }
    }

    public static class AsyncClient
    extends TAsyncClient
    implements AsyncIface {
        public AsyncClient(TProtocolFactory tProtocolFactory, TAsyncClientManager tAsyncClientManager, TNonblockingTransport tNonblockingTransport) {
            super(tProtocolFactory, tAsyncClientManager, tNonblockingTransport);
        }

        @Override
        public void getDatabaseNames(Credentials credentials, AsyncMethodCallback<DatabaseNamesResult> asyncMethodCallback) throws TException {
            this.checkReady();
            getDatabaseNames_call getDatabaseNames_call2 = new getDatabaseNames_call(credentials, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = getDatabaseNames_call2;
            this.___manager.call((TAsyncMethodCall)getDatabaseNames_call2);
        }

        @Override
        public void getLayoutNames(RequestParam requestParam, AsyncMethodCallback<IDLNameSet> asyncMethodCallback) throws TException {
            this.checkReady();
            getLayoutNames_call getLayoutNames_call2 = new getLayoutNames_call(requestParam, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = getLayoutNames_call2;
            this.___manager.call((TAsyncMethodCall)getLayoutNames_call2);
        }

        @Override
        public void getScriptNames(RequestParam requestParam, AsyncMethodCallback<IDLNameSet> asyncMethodCallback) throws TException {
            this.checkReady();
            getScriptNames_call getScriptNames_call2 = new getScriptNames_call(requestParam, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = getScriptNames_call2;
            this.___manager.call((TAsyncMethodCall)getScriptNames_call2);
        }

        @Override
        public void performRecordRequest(RequestParam requestParam, AsyncMethodCallback<IDLResultSet> asyncMethodCallback) throws TException {
            this.checkReady();
            performRecordRequest_call performRecordRequest_call2 = new performRecordRequest_call(requestParam, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = performRecordRequest_call2;
            this.___manager.call((TAsyncMethodCall)performRecordRequest_call2);
        }

        @Override
        public void getContainerData(ContainerParam containerParam, AsyncMethodCallback<IDLContainerData> asyncMethodCallback) throws TException {
            this.checkReady();
            getContainerData_call getContainerData_call2 = new getContainerData_call(containerParam, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = getContainerData_call2;
            this.___manager.call((TAsyncMethodCall)getContainerData_call2);
        }

        @Override
        public void configure(IDLConfigParam iDLConfigParam, AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
            this.checkReady();
            configure_call configure_call2 = new configure_call(iDLConfigParam, asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = configure_call2;
            this.___manager.call((TAsyncMethodCall)configure_call2);
        }

        @Override
        public void ping(AsyncMethodCallback<Long> asyncMethodCallback) throws TException {
            this.checkReady();
            ping_call ping_call2 = new ping_call(asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = ping_call2;
            this.___manager.call((TAsyncMethodCall)ping_call2);
        }

        @Override
        public void quit(AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
            this.checkReady();
            quit_call quit_call2 = new quit_call(asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = quit_call2;
            this.___manager.call((TAsyncMethodCall)quit_call2);
        }

        @Override
        public void force_quit(AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
            this.checkReady();
            force_quit_call force_quit_call2 = new force_quit_call(asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = force_quit_call2;
            this.___manager.call((TAsyncMethodCall)force_quit_call2);
        }

        @Override
        public void dump(AsyncMethodCallback<Void> asyncMethodCallback) throws TException {
            this.checkReady();
            dump_call dump_call2 = new dump_call(asyncMethodCallback, this, this.___protocolFactory, this.___transport);
            this.___currentMethod = dump_call2;
            this.___manager.call((TAsyncMethodCall)dump_call2);
        }

        public static class getDatabaseNames_call
        extends TAsyncMethodCall<DatabaseNamesResult> {
            private Credentials cred;

            public getDatabaseNames_call(Credentials credentials, AsyncMethodCallback<DatabaseNamesResult> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.cred = credentials;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("getDatabaseNames", 1, 0));
                getDatabaseNames_args getDatabaseNames_args2 = new getDatabaseNames_args();
                getDatabaseNames_args2.setCred(this.cred);
                getDatabaseNames_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public DatabaseNamesResult getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_getDatabaseNames();
            }
        }

        public static class getLayoutNames_call
        extends TAsyncMethodCall<IDLNameSet> {
            private RequestParam req;

            public getLayoutNames_call(RequestParam requestParam, AsyncMethodCallback<IDLNameSet> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.req = requestParam;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("getLayoutNames", 1, 0));
                getLayoutNames_args getLayoutNames_args2 = new getLayoutNames_args();
                getLayoutNames_args2.setReq(this.req);
                getLayoutNames_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public IDLNameSet getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_getLayoutNames();
            }
        }

        public static class getScriptNames_call
        extends TAsyncMethodCall<IDLNameSet> {
            private RequestParam req;

            public getScriptNames_call(RequestParam requestParam, AsyncMethodCallback<IDLNameSet> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.req = requestParam;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("getScriptNames", 1, 0));
                getScriptNames_args getScriptNames_args2 = new getScriptNames_args();
                getScriptNames_args2.setReq(this.req);
                getScriptNames_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public IDLNameSet getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_getScriptNames();
            }
        }

        public static class performRecordRequest_call
        extends TAsyncMethodCall<IDLResultSet> {
            private RequestParam req;

            public performRecordRequest_call(RequestParam requestParam, AsyncMethodCallback<IDLResultSet> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.req = requestParam;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("performRecordRequest", 1, 0));
                performRecordRequest_args performRecordRequest_args2 = new performRecordRequest_args();
                performRecordRequest_args2.setReq(this.req);
                performRecordRequest_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public IDLResultSet getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_performRecordRequest();
            }
        }

        public static class getContainerData_call
        extends TAsyncMethodCall<IDLContainerData> {
            private ContainerParam req;

            public getContainerData_call(ContainerParam containerParam, AsyncMethodCallback<IDLContainerData> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.req = containerParam;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("getContainerData", 1, 0));
                getContainerData_args getContainerData_args2 = new getContainerData_args();
                getContainerData_args2.setReq(this.req);
                getContainerData_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public IDLContainerData getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_getContainerData();
            }
        }

        public static class configure_call
        extends TAsyncMethodCall<Void> {
            private IDLConfigParam param;

            public configure_call(IDLConfigParam iDLConfigParam, AsyncMethodCallback<Void> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
                this.param = iDLConfigParam;
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("configure", 1, 0));
                configure_args configure_args2 = new configure_args();
                configure_args2.setParam(this.param);
                configure_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public Void getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                new Client(tProtocol).recv_configure();
                return null;
            }
        }

        public static class ping_call
        extends TAsyncMethodCall<Long> {
            public ping_call(AsyncMethodCallback<Long> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("ping", 1, 0));
                ping_args ping_args2 = new ping_args();
                ping_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public Long getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                return new Client(tProtocol).recv_ping();
            }
        }

        public static class quit_call
        extends TAsyncMethodCall<Void> {
            public quit_call(AsyncMethodCallback<Void> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("quit", 1, 0));
                quit_args quit_args2 = new quit_args();
                quit_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public Void getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                new Client(tProtocol).recv_quit();
                return null;
            }
        }

        public static class force_quit_call
        extends TAsyncMethodCall<Void> {
            public force_quit_call(AsyncMethodCallback<Void> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("force_quit", 1, 0));
                force_quit_args force_quit_args2 = new force_quit_args();
                force_quit_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public Void getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                new Client(tProtocol).recv_force_quit();
                return null;
            }
        }

        public static class dump_call
        extends TAsyncMethodCall<Void> {
            public dump_call(AsyncMethodCallback<Void> asyncMethodCallback, TAsyncClient tAsyncClient, TProtocolFactory tProtocolFactory, TNonblockingTransport tNonblockingTransport) throws TException {
                super(tAsyncClient, tProtocolFactory, tNonblockingTransport, asyncMethodCallback, false);
            }

            public void write_args(TProtocol tProtocol) throws TException {
                tProtocol.writeMessageBegin(new TMessage("dump", 1, 0));
                dump_args dump_args2 = new dump_args();
                dump_args2.write(tProtocol);
                tProtocol.writeMessageEnd();
            }

            public Void getResult() throws TException {
                if (this.getState() != TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(this.getFrameBuffer().array());
                TProtocol tProtocol = this.client.getProtocolFactory().getProtocol((TTransport)tMemoryInputTransport);
                new Client(tProtocol).recv_dump();
                return null;
            }
        }

        public static class Factory
        implements TAsyncClientFactory<AsyncClient> {
            private TAsyncClientManager clientManager;
            private TProtocolFactory protocolFactory;

            public Factory(TAsyncClientManager tAsyncClientManager, TProtocolFactory tProtocolFactory) {
                this.clientManager = tAsyncClientManager;
                this.protocolFactory = tProtocolFactory;
            }

            public AsyncClient getAsyncClient(TNonblockingTransport tNonblockingTransport) {
                return new AsyncClient(this.protocolFactory, this.clientManager, tNonblockingTransport);
            }
        }
    }

    public static class Client
    extends TServiceClient
    implements Iface {
        public Client(TProtocol tProtocol) {
            super(tProtocol, tProtocol);
        }

        public Client(TProtocol tProtocol, TProtocol tProtocol2) {
            super(tProtocol, tProtocol2);
        }

        @Override
        public DatabaseNamesResult getDatabaseNames(Credentials credentials) throws TException {
            this.send_getDatabaseNames(credentials);
            return this.recv_getDatabaseNames();
        }

        public void send_getDatabaseNames(Credentials credentials) throws TException {
            getDatabaseNames_args getDatabaseNames_args2 = new getDatabaseNames_args();
            getDatabaseNames_args2.setCred(credentials);
            this.sendBase("getDatabaseNames", getDatabaseNames_args2);
        }

        public DatabaseNamesResult recv_getDatabaseNames() throws TException {
            getDatabaseNames_result getDatabaseNames_result2 = new getDatabaseNames_result();
            this.receiveBase(getDatabaseNames_result2, "getDatabaseNames");
            if (getDatabaseNames_result2.isSetSuccess()) {
                return getDatabaseNames_result2.success;
            }
            throw new TApplicationException(5, "getDatabaseNames failed: unknown result");
        }

        @Override
        public IDLNameSet getLayoutNames(RequestParam requestParam) throws TException {
            this.send_getLayoutNames(requestParam);
            return this.recv_getLayoutNames();
        }

        public void send_getLayoutNames(RequestParam requestParam) throws TException {
            getLayoutNames_args getLayoutNames_args2 = new getLayoutNames_args();
            getLayoutNames_args2.setReq(requestParam);
            this.sendBase("getLayoutNames", getLayoutNames_args2);
        }

        public IDLNameSet recv_getLayoutNames() throws TException {
            getLayoutNames_result getLayoutNames_result2 = new getLayoutNames_result();
            this.receiveBase(getLayoutNames_result2, "getLayoutNames");
            if (getLayoutNames_result2.isSetSuccess()) {
                return getLayoutNames_result2.success;
            }
            throw new TApplicationException(5, "getLayoutNames failed: unknown result");
        }

        @Override
        public IDLNameSet getScriptNames(RequestParam requestParam) throws TException {
            this.send_getScriptNames(requestParam);
            return this.recv_getScriptNames();
        }

        public void send_getScriptNames(RequestParam requestParam) throws TException {
            getScriptNames_args getScriptNames_args2 = new getScriptNames_args();
            getScriptNames_args2.setReq(requestParam);
            this.sendBase("getScriptNames", getScriptNames_args2);
        }

        public IDLNameSet recv_getScriptNames() throws TException {
            getScriptNames_result getScriptNames_result2 = new getScriptNames_result();
            this.receiveBase(getScriptNames_result2, "getScriptNames");
            if (getScriptNames_result2.isSetSuccess()) {
                return getScriptNames_result2.success;
            }
            throw new TApplicationException(5, "getScriptNames failed: unknown result");
        }

        @Override
        public IDLResultSet performRecordRequest(RequestParam requestParam) throws TException {
            this.send_performRecordRequest(requestParam);
            return this.recv_performRecordRequest();
        }

        public void send_performRecordRequest(RequestParam requestParam) throws TException {
            performRecordRequest_args performRecordRequest_args2 = new performRecordRequest_args();
            performRecordRequest_args2.setReq(requestParam);
            this.sendBase("performRecordRequest", performRecordRequest_args2);
        }

        public IDLResultSet recv_performRecordRequest() throws TException {
            performRecordRequest_result performRecordRequest_result2 = new performRecordRequest_result();
            this.receiveBase(performRecordRequest_result2, "performRecordRequest");
            if (performRecordRequest_result2.isSetSuccess()) {
                return performRecordRequest_result2.success;
            }
            throw new TApplicationException(5, "performRecordRequest failed: unknown result");
        }

        @Override
        public IDLContainerData getContainerData(ContainerParam containerParam) throws TException {
            this.send_getContainerData(containerParam);
            return this.recv_getContainerData();
        }

        public void send_getContainerData(ContainerParam containerParam) throws TException {
            getContainerData_args getContainerData_args2 = new getContainerData_args();
            getContainerData_args2.setReq(containerParam);
            this.sendBase("getContainerData", getContainerData_args2);
        }

        public IDLContainerData recv_getContainerData() throws TException {
            getContainerData_result getContainerData_result2 = new getContainerData_result();
            this.receiveBase(getContainerData_result2, "getContainerData");
            if (getContainerData_result2.isSetSuccess()) {
                return getContainerData_result2.success;
            }
            throw new TApplicationException(5, "getContainerData failed: unknown result");
        }

        @Override
        public void configure(IDLConfigParam iDLConfigParam) throws TException {
            this.send_configure(iDLConfigParam);
            this.recv_configure();
        }

        public void send_configure(IDLConfigParam iDLConfigParam) throws TException {
            configure_args configure_args2 = new configure_args();
            configure_args2.setParam(iDLConfigParam);
            this.sendBase("configure", configure_args2);
        }

        public void recv_configure() throws TException {
            configure_result configure_result2 = new configure_result();
            this.receiveBase(configure_result2, "configure");
        }

        @Override
        public long ping() throws TException {
            this.send_ping();
            return this.recv_ping();
        }

        public void send_ping() throws TException {
            ping_args ping_args2 = new ping_args();
            this.sendBase("ping", ping_args2);
        }

        public long recv_ping() throws TException {
            ping_result ping_result2 = new ping_result();
            this.receiveBase(ping_result2, "ping");
            if (ping_result2.isSetSuccess()) {
                return ping_result2.success;
            }
            throw new TApplicationException(5, "ping failed: unknown result");
        }

        @Override
        public void quit() throws TException {
            this.send_quit();
            this.recv_quit();
        }

        public void send_quit() throws TException {
            quit_args quit_args2 = new quit_args();
            this.sendBase("quit", quit_args2);
        }

        public void recv_quit() throws TException {
            quit_result quit_result2 = new quit_result();
            this.receiveBase(quit_result2, "quit");
        }

        @Override
        public void force_quit() throws TException {
            this.send_force_quit();
            this.recv_force_quit();
        }

        public void send_force_quit() throws TException {
            force_quit_args force_quit_args2 = new force_quit_args();
            this.sendBase("force_quit", force_quit_args2);
        }

        public void recv_force_quit() throws TException {
            force_quit_result force_quit_result2 = new force_quit_result();
            this.receiveBase(force_quit_result2, "force_quit");
        }

        @Override
        public void dump() throws TException {
            this.send_dump();
            this.recv_dump();
        }

        public void send_dump() throws TException {
            dump_args dump_args2 = new dump_args();
            this.sendBase("dump", dump_args2);
        }

        public void recv_dump() throws TException {
            dump_result dump_result2 = new dump_result();
            this.receiveBase(dump_result2, "dump");
        }

        public static class Factory
        implements TServiceClientFactory<Client> {
            public Client getClient(TProtocol tProtocol) {
                return new Client(tProtocol);
            }

            public Client getClient(TProtocol tProtocol, TProtocol tProtocol2) {
                return new Client(tProtocol, tProtocol2);
            }
        }
    }

    public static interface AsyncIface {
        public void getDatabaseNames(Credentials var1, AsyncMethodCallback<DatabaseNamesResult> var2) throws TException;

        public void getLayoutNames(RequestParam var1, AsyncMethodCallback<IDLNameSet> var2) throws TException;

        public void getScriptNames(RequestParam var1, AsyncMethodCallback<IDLNameSet> var2) throws TException;

        public void performRecordRequest(RequestParam var1, AsyncMethodCallback<IDLResultSet> var2) throws TException;

        public void getContainerData(ContainerParam var1, AsyncMethodCallback<IDLContainerData> var2) throws TException;

        public void configure(IDLConfigParam var1, AsyncMethodCallback<Void> var2) throws TException;

        public void ping(AsyncMethodCallback<Long> var1) throws TException;

        public void quit(AsyncMethodCallback<Void> var1) throws TException;

        public void force_quit(AsyncMethodCallback<Void> var1) throws TException;

        public void dump(AsyncMethodCallback<Void> var1) throws TException;
    }

    public static interface Iface {
        public DatabaseNamesResult getDatabaseNames(Credentials var1) throws TException;

        public IDLNameSet getLayoutNames(RequestParam var1) throws TException;

        public IDLNameSet getScriptNames(RequestParam var1) throws TException;

        public IDLResultSet performRecordRequest(RequestParam var1) throws TException;

        public IDLContainerData getContainerData(ContainerParam var1) throws TException;

        public void configure(IDLConfigParam var1) throws TException;

        public long ping() throws TException;

        public void quit() throws TException;

        public void force_quit() throws TException;

        public void dump() throws TException;
    }
}

