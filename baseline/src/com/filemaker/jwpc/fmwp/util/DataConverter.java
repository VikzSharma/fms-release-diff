/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.log.JWPCLogger
 *  com.filemaker.jwpc.util.Utilities
 */
package com.filemaker.jwpc.fmwp.util;

import com.filemaker.jwpc.fmwp.api.thrift.service.DataType;
import com.filemaker.jwpc.fmwp.api.thrift.service.ErrorData;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLField;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldsParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLLayoutSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLRecord;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLResultSet;
import com.filemaker.jwpc.fmwp.datatype.ComplexParam;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.FieldOptionSet;
import com.filemaker.jwpc.fmwp.datatype.FieldParam;
import com.filemaker.jwpc.fmwp.datatype.FieldValidationSet;
import com.filemaker.jwpc.fmwp.datatype.FieldsParam;
import com.filemaker.jwpc.fmwp.datatype.WPCError;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.Utilities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DataConverter {
    private static JWPCLogger logger = JWPCLogger.getLogger(DataConverter.class);
    public static String hostAddress = Utilities.getHostIpAddress();

    private DataConverter() {
    }

    public static String fromUniString(short[] sArray) {
        if (sArray == null) {
            return "";
        }
        return Utilities.stripInvalidXMLChars((String)new String(DataConverter.shortArrayToCharArray(sArray)));
    }

    public static ErrorData initErrorData(ErrorData errorData) {
        logger.debug("initErrorData()");
        if (errorData == null) {
            errorData = new ErrorData();
        }
        return errorData;
    }

    public static ErrorData initErrorData() {
        return DataConverter.initErrorData(null);
    }

    public static WPCError toWPCError(ErrorData errorData) {
        WPCError wPCError = errorData.isScriptError() ? new WPCError(ErrorCode.fromValue(errorData.getError()), null, errorData.isScriptError(), errorData.getFileName(), errorData.getScriptName(), errorData.getScriptStepName(), errorData.getTimestamp()) : new WPCError(errorData.getError());
        return wPCError;
    }

    public static ErrorCode fromEventError(ErrorData errorData) {
        return ErrorCode.fromValue(errorData.getError());
    }

    public static ErrorData toEventError(ErrorCode errorCode) {
        ErrorData errorData = new ErrorData();
        errorData.setError(errorCode.getErrorCode());
        return errorData;
    }

    public static void toEventError(ErrorCode errorCode, ErrorData errorData) {
        errorData.setError(errorCode.getErrorCode());
    }

    public static String convertFromStringArray(String[] stringArray) {
        int n = stringArray.length;
        StringBuilder stringBuilder = new StringBuilder();
        if (n != 0) {
            for (int i = 0; i < n; ++i) {
                stringBuilder.append('\u007f');
                stringBuilder.append(stringArray[i]);
            }
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.append('\u007f');
        }
        return stringBuilder.toString();
    }

    public static byte[] intToByteArray(int n) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(n);
            dataOutputStream.flush();
        }
        catch (IOException iOException) {
            logger.debug("intToByteArray() gets an IOException when converting long to a byte array.", (Throwable)iOException);
        }
        byte[] byArray = byteArrayOutputStream.toByteArray();
        return byArray;
    }

    public static int byteArrayToInt(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        int n = -1;
        try {
            n = dataInputStream.readInt();
        }
        catch (EOFException eOFException) {
            logger.debug("byteArrayToInt() gets an EOFException when converting long to a byte array.", (Throwable)eOFException);
        }
        catch (IOException iOException) {
            logger.debug("byteArrayToInt() gets an IOException when converting long to a byte array.", (Throwable)iOException);
        }
        return n;
    }

    public static char[] shortArrayToCharArray(short[] sArray) {
        char[] cArray = new char[sArray.length];
        for (int i = 0; i < cArray.length; ++i) {
            cArray[i] = (char)sArray[i];
        }
        return cArray;
    }

    public static short[] charArrayToShortArray(char[] cArray) {
        short[] sArray = new short[cArray.length];
        for (int i = 0; i < sArray.length; ++i) {
            sArray[i] = (short)cArray[i];
        }
        return sArray;
    }

    public static short[] stringToShortArray(String string) {
        if (string == null) {
            return DataConverter.charArrayToShortArray("".toCharArray());
        }
        return DataConverter.charArrayToShortArray(string.toCharArray());
    }

    private static IDLFieldParam convertFieldParamToIDLFieldParam(FieldParam fieldParam) {
        return new IDLFieldParam(fieldParam.getName(), fieldParam.getValue(), fieldParam.getRepetition());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<IDLFieldParam> fromFieldParamListToIDLFieldParamList(List<FieldParam> list) {
        ArrayList<IDLFieldParam> arrayList = new ArrayList<IDLFieldParam>();
        if (list != null && !list.isEmpty()) {
            List<FieldParam> list2 = list;
            synchronized (list2) {
                ListIterator<FieldParam> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    FieldParam fieldParam = listIterator.next();
                    arrayList.add(DataConverter.convertFieldParamToIDLFieldParam(fieldParam));
                }
            }
        }
        return arrayList;
    }

    private static IDLComplexParam convertComplexParamToIDLComplexParam(ComplexParam complexParam) {
        return new IDLComplexParam(complexParam.getField(), complexParam.getTable(), complexParam.getRecordId());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<IDLComplexParam> fromComplexParamListToIDLComplexParamList(List<ComplexParam> list) {
        ArrayList<IDLComplexParam> arrayList = new ArrayList<IDLComplexParam>();
        if (list != null && !list.isEmpty()) {
            List<ComplexParam> list2 = list;
            synchronized (list2) {
                ListIterator<ComplexParam> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    ComplexParam complexParam = listIterator.next();
                    arrayList.add(DataConverter.convertComplexParamToIDLComplexParam(complexParam));
                }
            }
        }
        return arrayList;
    }

    public static IDLFieldsParam convertToIDLFieldsParam(FieldsParam fieldsParam) {
        return new IDLFieldsParam(fieldsParam.getFindType(), DataConverter.fromFieldParamListToIDLFieldParamList(fieldsParam.getFields()), DataConverter.fromComplexParamListToIDLComplexParamList(fieldsParam.getRelatedFields()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<IDLFieldsParam> fromFieldsParamListToIDLFieldsParamList(List<FieldsParam> list) {
        ArrayList<IDLFieldsParam> arrayList = new ArrayList<IDLFieldsParam>();
        if (list != null && !list.isEmpty()) {
            List<FieldsParam> list2 = list;
            synchronized (list2) {
                ListIterator<FieldsParam> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    FieldsParam fieldsParam = listIterator.next();
                    arrayList.add(DataConverter.convertToIDLFieldsParam(fieldsParam));
                }
            }
        }
        return arrayList;
    }

    public static String getRecordFieldAttributes(IDLFieldSpec iDLFieldSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        FieldOptionSet fieldOptionSet = new FieldOptionSet(iDLFieldSpec.getOptions());
        FieldValidationSet fieldValidationSet = new FieldValidationSet(iDLFieldSpec.getValidations());
        stringBuffer.append("<field-definition auto-enter=\"");
        stringBuffer.append(fieldOptionSet.hasFlagSet(FieldOptionSet.OptionBit.AutoEnter));
        stringBuffer.append("\" ");
        stringBuffer.append("four-digit-year=\"");
        stringBuffer.append(fieldValidationSet.hasFlagSet(FieldValidationSet.ValidationFlag.StrictFourDigitYear));
        stringBuffer.append("\" ");
        stringBuffer.append("global=\"");
        stringBuffer.append(fieldOptionSet.hasFlagSet(FieldOptionSet.OptionBit.GlobalStorage));
        stringBuffer.append("\" ");
        stringBuffer.append("max-repeat=\"");
        stringBuffer.append(iDLFieldSpec.getMaxRepeat());
        stringBuffer.append("\" ");
        stringBuffer.append("name=\"");
        stringBuffer.append(iDLFieldSpec.getName());
        stringBuffer.append("\" ");
        stringBuffer.append("not-empty=\"");
        stringBuffer.append(fieldValidationSet.hasFlagSet(FieldValidationSet.ValidationFlag.ValidateNotEmpty));
        stringBuffer.append("\" ");
        stringBuffer.append("numeric-only=\"");
        stringBuffer.append(fieldValidationSet.hasFlagSet(FieldValidationSet.ValidationFlag.StrictNumber));
        stringBuffer.append("\" ");
        stringBuffer.append("result=\"");
        stringBuffer.append(iDLFieldSpec.getDataType() == DataType.DTBoolean ? "boolean" : iDLFieldSpec.getDataType().toString());
        stringBuffer.append(iDLFieldSpec.getDataType() == DataType.DTBoolean ? "boolean" : iDLFieldSpec.getDataType().toString());
        stringBuffer.append("\" ");
        stringBuffer.append("time-of-day=\"");
        stringBuffer.append(fieldValidationSet.hasFlagSet(FieldValidationSet.ValidationFlag.StrictTimeOfDay));
        stringBuffer.append("\" ");
        stringBuffer.append("type=\"");
        stringBuffer.append(iDLFieldSpec.getType().toString());
        stringBuffer.append("\" />");
        return stringBuffer.toString();
    }

    public static String getDataSource(long l, IDLLayoutSpec iDLLayoutSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datasource database=\"");
        stringBuffer.append(iDLLayoutSpec.getDatabaseName());
        stringBuffer.append("\" ");
        stringBuffer.append("date-format=\"MM/dd/yyyy\" ");
        stringBuffer.append("layout=\"");
        stringBuffer.append(iDLLayoutSpec.getLayoutInfo().getItemName());
        stringBuffer.append("\" ");
        stringBuffer.append("table=\"");
        stringBuffer.append(iDLLayoutSpec.getTableName());
        stringBuffer.append("\" ");
        stringBuffer.append("time-format=\"HH:mm:ss\" timestamp-format=\"MM/dd/yyyy HH:mm:ss\" ");
        stringBuffer.append("total-count=\"");
        stringBuffer.append(l);
        stringBuffer.append("\">");
        stringBuffer.append("<metadata>");
        int n = iDLLayoutSpec.getFieldSpecsSize();
        for (int i = 0; i < n; ++i) {
            stringBuffer.append(DataConverter.getRecordFieldAttributes(iDLLayoutSpec.getFieldSpecs().get(i)));
        }
        stringBuffer.append("</metadata>");
        return stringBuffer.toString();
    }

    public static String getRecordData(IDLRecord iDLRecord) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<record mod-id=\"");
        stringBuffer.append(iDLRecord.getRecord().getModCount());
        stringBuffer.append("\" ");
        stringBuffer.append("record-id=\"");
        stringBuffer.append(iDLRecord.getRecord().getRecordId());
        stringBuffer.append("\">");
        int n = iDLRecord.getRecord().getFieldsSize();
        for (int i = 0; i < n; ++i) {
            IDLField iDLField = iDLRecord.getRecord().getFields().get(i);
            stringBuffer.append("<field name=\"");
            stringBuffer.append(iDLField.getName());
            stringBuffer.append("\">");
            int n2 = iDLField.getValuesSize();
            if (n2 > 0 && iDLField.getValues().get(0).length() > 0) {
                stringBuffer.append("<data>");
                stringBuffer.append(iDLField.getValues().get(0));
                stringBuffer.append("</data>");
            } else {
                stringBuffer.append("<data />");
            }
            stringBuffer.append("</field>");
        }
        stringBuffer.append("</record>");
        return stringBuffer.toString();
    }

    public static String getResultSetData(IDLResultSet iDLResultSet) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = iDLResultSet.getRecordsSize();
        stringBuffer.append("<resultset count=\"");
        stringBuffer.append(iDLResultSet.getTotalFound());
        stringBuffer.append("\" ");
        stringBuffer.append("fetch-size=\"");
        stringBuffer.append(n);
        stringBuffer.append("\">");
        if (n > 0) {
            for (int i = 0; i < n; ++i) {
                stringBuffer.append(DataConverter.getRecordData(iDLResultSet.getRecords().get(i)));
            }
        }
        stringBuffer.append("</resultset>");
        return stringBuffer.toString();
    }

    public static String fromDataTypeToString(DataType dataType) {
        switch (dataType) {
            case DTUnknown: {
                return "DTUnknown";
            }
            case DTText: {
                return "text";
            }
            case DTNumber: {
                return "number";
            }
            case DTDate: {
                return "date";
            }
            case DTTime: {
                return "time";
            }
            case DTTimestamp: {
                return "timestamp";
            }
            case DTContainer: {
                return "container";
            }
            case DTBoolean: {
                return "boolean";
            }
        }
        return "DTUnknown";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<WPCError> fromErrorDataListToWPCErrorList(List<ErrorData> list) {
        ArrayList<WPCError> arrayList = new ArrayList<WPCError>();
        if (list != null && !list.isEmpty()) {
            List<ErrorData> list2 = list;
            synchronized (list2) {
                ListIterator<ErrorData> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    ErrorData errorData = listIterator.next();
                    arrayList.add(new WPCError(errorData));
                }
            }
        }
        return arrayList;
    }
}

