/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.FieldMetaData
 *  com.filemaker.jwpc.fmwp.datatype.PortalFieldMetaData
 *  com.filemaker.jwpc.fmwp.datatype.PortalRecord
 *  javax.ws.rs.core.UriBuilder
 *  javolution.xml.stream.XMLOutputFactory
 *  javolution.xml.stream.XMLStreamException
 *  javolution.xml.stream.XMLStreamWriter
 */
package com.filemaker.jwpc.xml.response;

import com.filemaker.jwpc.businessobject.DataSource;
import com.filemaker.jwpc.businessobject.MetaData;
import com.filemaker.jwpc.businessobject.ProductInfo;
import com.filemaker.jwpc.businessobject.WPCRecord;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.fmwp.datatype.FieldMetaData;
import com.filemaker.jwpc.fmwp.datatype.PortalFieldMetaData;
import com.filemaker.jwpc.fmwp.datatype.PortalRecord;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.response.WPCResult;
import com.filemaker.jwpc.util.MultiLinkedHashMap;
import com.filemaker.jwpc.util.RemoteContainerUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.filemaker.jwpc.xml.XMLDocument;
import com.filemaker.jwpc.xml.XMLResult;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.UriBuilder;
import javolution.xml.stream.XMLOutputFactory;
import javolution.xml.stream.XMLStreamException;
import javolution.xml.stream.XMLStreamWriter;

public class FMResultSetDocument
extends XMLDocument {
    static JWPCLogger logger = JWPCLogger.getLogger(FMResultSetDocument.class);
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    XMLStreamWriter writer = null;
    protected XMLResult resultSet;

    public FMResultSetDocument(Writer writer, XMLResult xMLResult) {
        this.resultSet = xMLResult;
        try {
            this.writer = this.outputFactory.createXMLStreamWriter(writer);
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("FMResultSetDocument() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    public FMResultSetDocument(PrintWriter printWriter) {
        this(printWriter, null);
    }

    @Override
    public void generateResponse() {
        logger.debugEntering("generateResponse");
        try {
            String string = "<!DOCTYPE fmresultset PUBLIC \"-//FMI//DTD fmresultset//EN\" \"/fmi/xml/fmresultset.dtd\">";
            this.writer.writeProcessingInstruction((CharSequence)"xml", (CharSequence)"version =\"1.0\" encoding=\"UTF-8\" standalone=\"no\"");
            this.writer.writeDTD((CharSequence)string);
            this.writer.writeStartElement((CharSequence)"fmresultset");
            this.writer.writeAttribute((CharSequence)"xmlns", (CharSequence)this.getNameSpace());
            this.writer.writeAttribute((CharSequence)"version", (CharSequence)"1.0");
            this.writeErrorCode();
            this.writeProductInfo();
            this.writeDataSource();
            this.writeMetaData();
            this.writeResultSet();
            this.writer.writeEndElement();
            this.writer.flush();
            this.writer.close();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("generateResponse() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
        logger.debugExiting("generateResponse");
    }

    protected void writeErrorCode() {
        try {
            this.writer.writeStartElement((CharSequence)"error");
            this.writer.writeAttribute((CharSequence)"code", (CharSequence)Integer.toString(this.resultSet.getWPCErrorCode()));
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeErrorCode() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeProductInfo() {
        if (this.resultSet.getWPCErrorCode() == ErrorCode.TechnologyDisabled.getErrorCode()) {
            return;
        }
        try {
            this.writer.writeStartElement((CharSequence)"product");
            ProductInfo productInfo = this.resultSet.getProductInfo();
            if (productInfo != null) {
                this.writer.writeAttribute((CharSequence)"build", (CharSequence)productInfo.getBuild());
                this.writer.writeAttribute((CharSequence)"name", (CharSequence)productInfo.getName());
                this.writer.writeAttribute((CharSequence)"version", (CharSequence)productInfo.getVersion());
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeProductInfo() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeDataSource() {
        try {
            this.writer.writeStartElement((CharSequence)"datasource");
            DataSource dataSource = this.resultSet.getDataSource();
            if (dataSource != null) {
                this.writer.writeAttribute((CharSequence)"database", (CharSequence)dataSource.getDatabase());
                this.writer.writeAttribute((CharSequence)"date-format", (CharSequence)dataSource.getDateFormat());
                this.writer.writeAttribute((CharSequence)"layout", (CharSequence)dataSource.getLayout());
                this.writer.writeAttribute((CharSequence)"table", (CharSequence)dataSource.getTable());
                this.writer.writeAttribute((CharSequence)"time-format", (CharSequence)dataSource.getTimeFormat());
                this.writer.writeAttribute((CharSequence)"timestamp-format", (CharSequence)dataSource.getTimestampFormat());
                this.writer.writeAttribute((CharSequence)"total-count", (CharSequence)Long.toString(dataSource.getTotalCount()));
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeDataSource() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeMetaData() {
        if (this.resultSet.getResultType() == WPCResult.ResultType.RECORDS) {
            this.writeRecordsMetaData();
        } else {
            this.writeNamesMetaData();
        }
    }

    protected void writeResultSet() {
        switch (this.resultSet.getResultType()) {
            case DATABASE_NAME: {
                this.writeDBNamesResultSet();
                break;
            }
            case LAYOUT_NAME: 
            case SCRIPT_NAME: {
                this.writeDBItemResultSet();
                break;
            }
            case RECORDS: {
                this.writeRecordsResultSet();
            }
        }
    }

    private void writeRecordSet(WPCRecord[] wPCRecordArray, String string) {
        block23: {
            try {
                if (wPCRecordArray == null) break block23;
                boolean bl = Utilities.isValidRecordID(string);
                for (WPCRecord wPCRecord : wPCRecordArray) {
                    String string2 = wPCRecord.getRecordId();
                    this.writer.writeStartElement((CharSequence)"record");
                    this.writer.writeAttribute((CharSequence)"mod-id", (CharSequence)Long.toString(wPCRecord.getModCount()));
                    this.writer.writeAttribute((CharSequence)"record-id", (CharSequence)string2);
                    MultiLinkedHashMap<String, String[]> multiLinkedHashMap = wPCRecord.getFieldsValues(this.resultSet.getMetaData(), this.resultSet.getDataSource());
                    for (MultiLinkedHashMap.NVPair<String, String[]> nVPair : multiLinkedHashMap.getData()) {
                        this.writer.writeStartElement((CharSequence)"field");
                        this.writer.writeAttribute((CharSequence)"name", (CharSequence)nVPair.getKey());
                        String[] stringArray = nVPair.getValue();
                        for (int i = 0; i < stringArray.length; ++i) {
                            this.writer.writeStartElement((CharSequence)"data");
                            String string3 = stringArray[i];
                            if (string3 != null && string3.length() > 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                if (this.resultSet.getMetaData().isFieldContainer(nVPair.getKey()) && !Utilities.isFilePathData(string3)) {
                                    if (RemoteContainerUtilities.isCWPCRemoteContainerURL(string3)) {
                                        stringBuilder.append(RemoteContainerUtilities.createStreamingURL(string3));
                                    } else {
                                        stringBuilder.append("/fmi/xml/cnt/");
                                        try {
                                            stringBuilder.append(UriBuilder.fromPath((String)"{filename}").build(new Object[]{string3}).toString());
                                        }
                                        catch (Exception exception) {
                                            stringBuilder.append(string3);
                                        }
                                        stringBuilder.append("?-db=");
                                        try {
                                            stringBuilder.append(UriBuilder.fromPath((String)"{db}").build(new Object[]{this.resultSet.getDataSource().getDatabase()}).toString());
                                        }
                                        catch (Exception exception) {
                                            stringBuilder.append(this.resultSet.getDataSource().getDatabase());
                                        }
                                        stringBuilder.append("&-lay=");
                                        try {
                                            stringBuilder.append(UriBuilder.fromPath((String)"{layout}").build(new Object[]{this.resultSet.getDataSource().getLayout()}).toString());
                                        }
                                        catch (Exception exception) {
                                            stringBuilder.append(this.resultSet.getDataSource().getLayout());
                                        }
                                        stringBuilder.append("&-recid=");
                                        if (bl) {
                                            stringBuilder.append(string);
                                        } else {
                                            stringBuilder.append(string2);
                                        }
                                        stringBuilder.append("&-field=");
                                        try {
                                            stringBuilder.append(UriBuilder.fromPath((String)"{field}").build(new Object[]{nVPair.getKey()}).toString());
                                        }
                                        catch (Exception exception) {
                                            stringBuilder.append(nVPair.getKey());
                                        }
                                        stringBuilder.append("(");
                                        stringBuilder.append(i + 1);
                                        stringBuilder.append(")");
                                        if (bl) {
                                            stringBuilder.append(".");
                                            stringBuilder.append(string2);
                                        }
                                    }
                                } else {
                                    stringBuilder.append(string3.replaceAll("[\\u0000-\\u0008\\u000B-\\u000C\\u000E-\\u001F]", ""));
                                }
                                this.writer.writeCharacters((CharSequence)stringBuilder);
                            }
                            this.writer.writeEndElement();
                        }
                        this.writer.writeEndElement();
                    }
                    MultiLinkedHashMap<String, PortalRecord> multiLinkedHashMap2 = wPCRecord.getPortalsMap();
                    for (String[] stringArray : multiLinkedHashMap2.getData()) {
                        this.writer.writeStartElement((CharSequence)"relatedset");
                        this.writer.writeAttribute((CharSequence)"count", (CharSequence)Long.toString(((PortalRecord)stringArray.getValue()).getTotalRecords()));
                        this.writer.writeAttribute((CharSequence)"table", (CharSequence)stringArray.getKey());
                        if (!bl) {
                            string = string2;
                        }
                        this.writeRecordSet(((PortalRecord)stringArray.getValue()).getRecords(), string);
                        this.writer.writeEndElement();
                    }
                    this.writer.writeEndElement();
                }
            }
            catch (XMLStreamException xMLStreamException) {
                logger.debug("writeRecordSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
            }
        }
    }

    private void writeRecordsResultSet() {
        try {
            this.writer.writeStartElement((CharSequence)"resultset");
            this.writer.writeAttribute((CharSequence)"count", (CharSequence)Long.toString(this.resultSet.getCount()));
            this.writer.writeAttribute((CharSequence)"fetch-size", (CharSequence)Long.toString(this.resultSet.getFetchSize()));
            if (this.resultSet.getRecords() != null) {
                this.writeRecordSet(this.resultSet.getRecords(), "");
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeRecordsResultSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeDBItemResultSet() {
        WPCResult.ResultType resultType = this.resultSet.getResultType();
        List<IDLItemInfo> list = this.resultSet.getItems();
        try {
            this.writer.writeStartElement((CharSequence)"resultset");
            this.writer.writeAttribute((CharSequence)"count", (CharSequence)Integer.toString(list.size()));
            this.writer.writeAttribute((CharSequence)"fetch-size", (CharSequence)Integer.toString(list.size()));
            String string = "0";
            String string2 = "0";
            String string3 = resultType.toString();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); ++i) {
                    IDLItemInfo iDLItemInfo = list.get(i);
                    if (resultType == WPCResult.ResultType.LAYOUT_NAME) {
                        string = Long.toString(iDLItemInfo.getModCount());
                        string2 = Long.toString(iDLItemInfo.getItemId());
                    }
                    this.writer.writeStartElement((CharSequence)"record");
                    this.writer.writeAttribute((CharSequence)"mod-id", (CharSequence)string);
                    this.writer.writeAttribute((CharSequence)"record-id", (CharSequence)string2);
                    this.writer.writeStartElement((CharSequence)"field");
                    this.writer.writeAttribute((CharSequence)"name", (CharSequence)string3);
                    this.writer.writeStartElement((CharSequence)"data");
                    this.writer.writeCharacters((CharSequence)iDLItemInfo.getItemName());
                    this.writer.writeEndElement();
                    this.writer.writeEndElement();
                    this.writer.writeEndElement();
                }
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeDBItemResultSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeDBNamesResultSet() {
        try {
            if (this.writer != null) {
                List<String> list = this.resultSet.getDBNames();
                this.writer.writeStartElement((CharSequence)"resultset");
                this.writer.writeAttribute((CharSequence)"count", (CharSequence)Integer.toString(list.size()));
                this.writer.writeAttribute((CharSequence)"fetch-size", (CharSequence)Integer.toString(list.size()));
                for (String string : list) {
                    this.writer.writeStartElement((CharSequence)"record");
                    this.writer.writeAttribute((CharSequence)"mod-id", (CharSequence)"0");
                    this.writer.writeAttribute((CharSequence)"record-id", (CharSequence)"0");
                    this.writer.writeStartElement((CharSequence)"field");
                    this.writer.writeAttribute((CharSequence)"name", (CharSequence)"DATABASE_NAME");
                    this.writer.writeStartElement((CharSequence)"data");
                    this.writer.writeCharacters((CharSequence)string);
                    this.writer.writeEndElement();
                    this.writer.writeEndElement();
                    this.writer.writeEndElement();
                }
                this.writer.writeEndElement();
            }
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeDBNamesResultSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeFieldMetaData(FieldMetaData fieldMetaData) {
        try {
            this.writer.writeStartElement((CharSequence)"field-definition");
            this.writer.writeAttribute((CharSequence)"auto-enter", (CharSequence)fieldMetaData.isAutoEnterField());
            this.writer.writeAttribute((CharSequence)"four-digit-year", (CharSequence)fieldMetaData.hasFourDigitYearValidation());
            this.writer.writeAttribute((CharSequence)"global", (CharSequence)fieldMetaData.usesGlobalStorage());
            if (fieldMetaData.isMaxCharsValidation()) {
                this.writer.writeAttribute((CharSequence)"max-characters", (CharSequence)fieldMetaData.getMaxCharacters());
            }
            this.writer.writeAttribute((CharSequence)"max-repeat", (CharSequence)fieldMetaData.getMaxRepeatValue());
            this.writer.writeAttribute((CharSequence)"name", (CharSequence)fieldMetaData.getName());
            this.writer.writeAttribute((CharSequence)"not-empty", (CharSequence)fieldMetaData.hasNotEmptyValidation());
            this.writer.writeAttribute((CharSequence)"numeric-only", (CharSequence)fieldMetaData.hasNumericOnlyValidation());
            this.writer.writeAttribute((CharSequence)"result", (CharSequence)fieldMetaData.getDataType());
            this.writer.writeAttribute((CharSequence)"time-of-day", (CharSequence)fieldMetaData.hasTimeOfDayValidation());
            this.writer.writeAttribute((CharSequence)"type", (CharSequence)fieldMetaData.getFieldType());
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeFieldMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeRecordsMetaData() {
        try {
            this.writer.writeStartElement((CharSequence)"metadata");
            MetaData metaData = this.resultSet.getMetaData();
            if (metaData != null) {
                List<FieldMetaData> list = metaData.getFieldDefinitions();
                for (FieldMetaData object2 : list) {
                    this.writeFieldMetaData(object2);
                }
                List<PortalFieldMetaData> list2 = metaData.getPortalDefinitions();
                Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    PortalFieldMetaData portalFieldMetaData = (PortalFieldMetaData)iterator.next();
                    this.writer.writeStartElement((CharSequence)"relatedset-definition");
                    this.writer.writeAttribute((CharSequence)"table", (CharSequence)portalFieldMetaData.getTableName());
                    for (FieldMetaData fieldMetaData : portalFieldMetaData.getFields()) {
                        this.writeFieldMetaData(fieldMetaData);
                    }
                    this.writer.writeEndElement();
                }
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeRecordsMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeNamesMetaData() {
        try {
            String string = switch (this.resultSet.getResultType()) {
                case WPCResult.ResultType.DATABASE_NAME -> "DATABASE_NAME";
                case WPCResult.ResultType.LAYOUT_NAME -> "LAYOUT_NAME";
                case WPCResult.ResultType.SCRIPT_NAME -> "SCRIPT_NAME";
                default -> null;
            };
            this.writer.writeStartElement((CharSequence)"metadata");
            this.writer.writeStartElement((CharSequence)"field-definition");
            this.writer.writeAttribute((CharSequence)"auto-enter", (CharSequence)"no");
            this.writer.writeAttribute((CharSequence)"four-digit-year", (CharSequence)"no");
            this.writer.writeAttribute((CharSequence)"global", (CharSequence)"no");
            this.writer.writeAttribute((CharSequence)"max-repeat", (CharSequence)"1");
            this.writer.writeAttribute((CharSequence)"name", (CharSequence)string);
            this.writer.writeAttribute((CharSequence)"not-empty", (CharSequence)"yes");
            this.writer.writeAttribute((CharSequence)"numeric-only", (CharSequence)"no");
            this.writer.writeAttribute((CharSequence)"result", (CharSequence)"text");
            this.writer.writeAttribute((CharSequence)"time-of-day", (CharSequence)"no");
            this.writer.writeAttribute((CharSequence)"type", (CharSequence)"normal");
            this.writer.writeEndElement();
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeNamesMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    @Override
    public void getDTD(PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!ELEMENT fmresultset (error,product,datasource,metadata,resultset)>\r\n");
        stringBuilder.append("    <!ATTLIST fmresultset\r\n");
        stringBuilder.append("        version CDATA #REQUIRED\r\n");
        stringBuilder.append("        xmlns CDATA #FIXED \"http://www.filemaker.com/xml/fmresultset\">\r\n");
        stringBuilder.append("<!ELEMENT error (#PCDATA)>\r\n");
        stringBuilder.append("    <!ATTLIST error\r\n");
        stringBuilder.append("        code CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT product EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST product\r\n");
        stringBuilder.append("        name CDATA #REQUIRED\r\n");
        stringBuilder.append("        version CDATA #REQUIRED\r\n");
        stringBuilder.append("        build CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT datasource EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST datasource\r\n");
        stringBuilder.append("        database CDATA #REQUIRED\r\n");
        stringBuilder.append("        total-count CDATA #REQUIRED\r\n");
        stringBuilder.append("        date-format CDATA #REQUIRED\r\n");
        stringBuilder.append("        time-format CDATA #REQUIRED\r\n");
        stringBuilder.append("        timestamp-format CDATA #REQUIRED\r\n");
        stringBuilder.append("        layout CDATA #IMPLIED\r\n");
        stringBuilder.append("        table CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT metadata (field-definition|relatedset-definition)*>\r\n");
        stringBuilder.append("<!ELEMENT field-definition EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST field-definition\r\n");
        stringBuilder.append("        name CDATA #REQUIRED\r\n");
        stringBuilder.append("        type (normal|calculation|summary) #REQUIRED\r\n");
        stringBuilder.append("        result (text|number|date|time|timestamp|container) #REQUIRED\r\n");
        stringBuilder.append("        global (yes|no) #REQUIRED\r\n");
        stringBuilder.append("        not-empty (yes|no) #REQUIRED\r\n");
        stringBuilder.append("\t\t numeric-only (yes|no) #REQUIRED\r\n");
        stringBuilder.append("\t\t max-characters CDATA #IMPLIED\r\n");
        stringBuilder.append("\t\t four-digit-year (yes|no) #REQUIRED\r\n");
        stringBuilder.append("\t\t time-of-day (yes|no) #REQUIRED\r\n");
        stringBuilder.append("        max-repeat CDATA #REQUIRED\r\n");
        stringBuilder.append("        auto-enter (yes|no) #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT relatedset-definition (field-definition)*>\r\n");
        stringBuilder.append("    <!ATTLIST relatedset-definition\r\n");
        stringBuilder.append("        table CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT resultset (record)*>\r\n");
        stringBuilder.append("    <!ATTLIST resultset\r\n");
        stringBuilder.append("        count CDATA #REQUIRED\r\n");
        stringBuilder.append("        fetch-size CDATA #IMPLIED>\r\n");
        stringBuilder.append("<!ELEMENT record (field|relatedset)*>\r\n");
        stringBuilder.append("    <!ATTLIST record\r\n");
        stringBuilder.append("        record-id CDATA #REQUIRED\r\n");
        stringBuilder.append("        mod-id CDATA #IMPLIED>\r\n");
        stringBuilder.append("<!ELEMENT field (data)*>\r\n");
        stringBuilder.append("    <!ATTLIST field\r\n");
        stringBuilder.append("        name CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT relatedset (record)*>\r\n");
        stringBuilder.append("    <!ATTLIST relatedset\r\n");
        stringBuilder.append("        count CDATA #REQUIRED\r\n");
        stringBuilder.append("        table CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT data (#PCDATA)>");
        printWriter.write(stringBuilder.toString());
    }

    @Override
    public String getNameSpace() {
        return "http://www.filemaker.com/xml/fmresultset";
    }
}

