/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.filemaker.jwpc.fmwp.datatype.FieldMetaData
 *  com.filemaker.jwpc.fmwp.datatype.FieldValidationSet
 *  com.filemaker.jwpc.fmwp.datatype.PortalFieldMetaData
 *  com.filemaker.jwpc.fmwp.datatype.PortalRecord
 *  javax.ws.rs.core.UriBuilder
 *  javolution.util.FastList
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
import com.filemaker.jwpc.fmwp.datatype.FieldValidationSet;
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
import javolution.util.FastList;
import javolution.xml.stream.XMLOutputFactory;
import javolution.xml.stream.XMLStreamException;
import javolution.xml.stream.XMLStreamWriter;

public class FMPXMLRESULTDocument
extends XMLDocument {
    static JWPCLogger logger = JWPCLogger.getLogger(FMPXMLRESULTDocument.class);
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    XMLStreamWriter writer = null;
    protected XMLResult resultSet;

    public FMPXMLRESULTDocument(Writer writer, XMLResult xMLResult) {
        this.resultSet = xMLResult;
        try {
            this.writer = this.outputFactory.createXMLStreamWriter(writer);
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("FMPXMLRESULTDocument() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    public FMPXMLRESULTDocument() {
    }

    @Override
    public void generateResponse() {
        logger.debugEntering("generateResponse");
        try {
            String string = "<!DOCTYPE FMPXMLRESULT PUBLIC \"-//FMI//DTD FMPXMLRESULT//EN\" \"/fmi/xml/FMPXMLRESULT.dtd\">";
            this.writer.writeProcessingInstruction((CharSequence)"xml", (CharSequence)"version =\"1.0\" encoding=\"UTF-8\" standalone=\"no\"");
            this.writer.writeDTD((CharSequence)string);
            this.writer.writeStartElement((CharSequence)"FMPXMLRESULT");
            this.writer.writeAttribute((CharSequence)"xmlns", (CharSequence)this.getNameSpace());
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

    private void writeRecordsResultSet() {
        try {
            this.writer.writeStartElement((CharSequence)"RESULTSET");
            this.writer.writeAttribute((CharSequence)"FOUND", (CharSequence)Long.toString(this.resultSet.getCount()));
            if (this.resultSet.getRecords() != null) {
                this.writeRecordSet(this.resultSet.getRecords());
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeRecordsResultSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
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

    private void writeDBItemResultSet() {
        WPCResult.ResultType resultType = this.resultSet.getResultType();
        List<IDLItemInfo> list = this.resultSet.getItems();
        try {
            this.writer.writeStartElement((CharSequence)"RESULTSET");
            this.writer.writeAttribute((CharSequence)"FOUND", (CharSequence)Integer.toString(list.size()));
            String string = "0";
            String string2 = "0";
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); ++i) {
                    IDLItemInfo iDLItemInfo = list.get(i);
                    if (resultType == WPCResult.ResultType.LAYOUT_NAME) {
                        string = Long.toString(iDLItemInfo.getModCount());
                        string2 = Long.toString(iDLItemInfo.getItemId());
                    }
                    this.writer.writeStartElement((CharSequence)"ROW");
                    this.writer.writeAttribute((CharSequence)"MODID", (CharSequence)string);
                    this.writer.writeAttribute((CharSequence)"RECORDID", (CharSequence)string2);
                    this.writer.writeStartElement((CharSequence)"COL");
                    this.writer.writeStartElement((CharSequence)"DATA");
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
                this.writer.writeStartElement((CharSequence)"RESULTSET");
                this.writer.writeAttribute((CharSequence)"FOUND", (CharSequence)Integer.toString(list.size()));
                for (String string : list) {
                    this.writer.writeStartElement((CharSequence)"ROW");
                    this.writer.writeAttribute((CharSequence)"MODID", (CharSequence)"0");
                    this.writer.writeAttribute((CharSequence)"RECORDID", (CharSequence)"0");
                    this.writer.writeStartElement((CharSequence)"COL");
                    this.writer.writeStartElement((CharSequence)"DATA");
                    logger.debug("writeResultSet() DB = " + string);
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

    private void writeRecordSet(WPCRecord[] wPCRecordArray) {
        try {
            if (wPCRecordArray != null) {
                for (WPCRecord wPCRecord : wPCRecordArray) {
                    this.writer.writeStartElement((CharSequence)"ROW");
                    this.writer.writeAttribute((CharSequence)"MODID", (CharSequence)Long.toString(wPCRecord.getModCount()));
                    this.writer.writeAttribute((CharSequence)"RECORDID", (CharSequence)wPCRecord.getRecordId());
                    this.generateFieldData(wPCRecord);
                    MultiLinkedHashMap<String, PortalRecord> multiLinkedHashMap = wPCRecord.getPortalsMap();
                    for (MultiLinkedHashMap.NVPair<String, PortalRecord> nVPair : multiLinkedHashMap.getData()) {
                        this.generatePortalFieldData(nVPair.getValue().getRecords());
                    }
                    this.writer.writeEndElement();
                }
            }
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeRecordSet() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void generateFieldData(WPCRecord wPCRecord) throws XMLStreamException {
        MultiLinkedHashMap<String, String[]> multiLinkedHashMap = wPCRecord.getFieldsValues(this.resultSet.getMetaData(), this.resultSet.getDataSource());
        for (MultiLinkedHashMap.NVPair<String, String[]> nVPair : multiLinkedHashMap.getData()) {
            this.writer.writeStartElement((CharSequence)"COL");
            List<String> list = this.processFieldValues(nVPair.getValue(), nVPair.getKey(), wPCRecord.getRecordId());
            this.writeFieldData(list);
            this.writer.writeEndElement();
        }
    }

    private void generatePortalFieldData(WPCRecord[] wPCRecordArray) throws XMLStreamException {
        if (wPCRecordArray.length > 0) {
            int n = wPCRecordArray[0].getNumFields();
            FastList[] fastListArray = new FastList[n];
            for (int i = 0; i < n; ++i) {
                fastListArray[i] = new FastList();
            }
            for (WPCRecord wPCRecord : wPCRecordArray) {
                List<MultiLinkedHashMap.NVPair<String, String[]>> list = wPCRecord.getFieldsValues(this.resultSet.getMetaData(), this.resultSet.getDataSource()).getData();
                String string = wPCRecord.getRecordId();
                for (int i = 0; i < n; ++i) {
                    List<String> list2 = this.processFieldValues(list.get(i).getValue(), list.get(i).getKey(), string);
                    fastListArray[i].addAll(list2);
                }
            }
            for (WPCRecord wPCRecord : fastListArray) {
                this.writer.writeStartElement((CharSequence)"COL");
                this.writeFieldData((List<String>)((Object)wPCRecord));
                this.writer.writeEndElement();
            }
        } else {
            this.writer.writeStartElement((CharSequence)"COL");
            this.writer.writeEndElement();
        }
    }

    private List<String> processFieldValues(String[] stringArray, String string, String string2) {
        FastList fastList = new FastList();
        for (int i = 0; i < stringArray.length; ++i) {
            String string3 = stringArray[i];
            if (string3 != null && string3.length() > 0) {
                if (this.resultSet.getMetaData().isFieldContainer(string) && !Utilities.isFilePathData(string3)) {
                    if (RemoteContainerUtilities.isCWPCRemoteContainerURL(string3)) {
                        fastList.add(RemoteContainerUtilities.createStreamingURL(string3));
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
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
                    stringBuilder.append(string2);
                    stringBuilder.append("&-field=");
                    try {
                        stringBuilder.append(UriBuilder.fromPath((String)"{field}").build(new Object[]{string}).toString());
                    }
                    catch (Exception exception) {
                        stringBuilder.append(string);
                    }
                    stringBuilder.append("(");
                    stringBuilder.append(i + 1);
                    stringBuilder.append(")");
                    fastList.add(stringBuilder.toString());
                    continue;
                }
                fastList.add(string3.replaceAll("[\\u0001-\\u0008\\u000B-\\u000C\\u000E-\\u001F]", ""));
                continue;
            }
            fastList.add("");
        }
        return fastList;
    }

    private void writeFieldData(List<String> list) throws XMLStreamException {
        for (String string : list) {
            this.writer.writeStartElement((CharSequence)"DATA");
            if (string != null && string.length() > 0) {
                this.writer.writeCharacters((CharSequence)string);
            }
            this.writer.writeEndElement();
        }
    }

    protected void writeMetaData() {
        if (this.resultSet.getResultType() == WPCResult.ResultType.RECORDS) {
            this.writeRecordsMetaData();
        } else {
            this.writeNamesMetaData();
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
            this.writer.writeStartElement((CharSequence)"METADATA");
            this.writer.writeStartElement((CharSequence)"FIELD");
            this.writer.writeAttribute((CharSequence)"EMPTYOK", (CharSequence)"NO");
            this.writer.writeAttribute((CharSequence)"MAXREPEAT", (CharSequence)"1");
            this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)string);
            this.writer.writeAttribute((CharSequence)"TYPE", (CharSequence)"TEXT");
            this.writer.writeEndElement();
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeNamesMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeRecordsMetaData() {
        try {
            this.writer.writeStartElement((CharSequence)"METADATA");
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
                    for (FieldMetaData fieldMetaData : portalFieldMetaData.getFields()) {
                        this.writeFieldMetaData(fieldMetaData);
                    }
                }
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeRecordsMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    private void writeFieldMetaData(FieldMetaData fieldMetaData) {
        try {
            this.writer.writeStartElement((CharSequence)"FIELD");
            this.writer.writeAttribute((CharSequence)"EMPTYOK", (CharSequence)(fieldMetaData.hasNotEmptyValidation().equals(FieldValidationSet.NO) ? "YES" : "NO"));
            this.writer.writeAttribute((CharSequence)"MAXREPEAT", (CharSequence)fieldMetaData.getMaxRepeatValue());
            this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)fieldMetaData.getName());
            this.writer.writeAttribute((CharSequence)"TYPE", (CharSequence)fieldMetaData.getDataType().toUpperCase());
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeFieldMetaData() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeDataSource() {
        try {
            this.writer.writeStartElement((CharSequence)"DATABASE");
            DataSource dataSource = this.resultSet.getDataSource();
            if (dataSource != null) {
                this.writer.writeAttribute((CharSequence)"DATEFORMAT", (CharSequence)dataSource.getDateFormat());
                this.writer.writeAttribute((CharSequence)"LAYOUT", (CharSequence)dataSource.getLayout());
                this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)dataSource.getDatabase());
                this.writer.writeAttribute((CharSequence)"RECORDS", (CharSequence)Long.toString(dataSource.getTotalCount()));
                this.writer.writeAttribute((CharSequence)"TIMEFORMAT", (CharSequence)dataSource.getTimeFormat());
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeDataSource() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeProductInfo() {
        if (this.resultSet.getWPCErrorCode() == ErrorCode.TechnologyDisabled.getErrorCode()) {
            return;
        }
        try {
            this.writer.writeStartElement((CharSequence)"PRODUCT");
            ProductInfo productInfo = this.resultSet.getProductInfo();
            if (productInfo != null) {
                this.writer.writeAttribute((CharSequence)"BUILD", (CharSequence)productInfo.getBuild());
                this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)productInfo.getName());
                this.writer.writeAttribute((CharSequence)"VERSION", (CharSequence)productInfo.getVersion());
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeProductInfo() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    protected void writeErrorCode() {
        try {
            this.writer.writeStartElement((CharSequence)"ERRORCODE");
            this.writer.writeCharacters((CharSequence)Integer.toString(this.resultSet.getWPCErrorCode()));
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeErrorCode() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    @Override
    public void getDTD(PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!ELEMENT FMPXMLRESULT (ERRORCODE,PRODUCT,DATABASE,METADATA,RESULTSET)>\r\n");
        stringBuilder.append("   <!ATTLIST FMPXMLRESULT\r\n");
        stringBuilder.append("        xmlns CDATA #FIXED \"http://www.filemaker.com/fmpxmlresult\">\r\n");
        stringBuilder.append("<!ELEMENT ERRORCODE (#PCDATA)>\r\n");
        stringBuilder.append("<!ELEMENT PRODUCT EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST PRODUCT\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED\r\n");
        stringBuilder.append("        VERSION CDATA #REQUIRED\r\n");
        stringBuilder.append("        BUILD CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT DATABASE EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST DATABASE\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED\r\n");
        stringBuilder.append("        RECORDS CDATA #REQUIRED\r\n");
        stringBuilder.append("        DATEFORMAT CDATA #REQUIRED\r\n");
        stringBuilder.append("        TIMEFORMAT CDATA #REQUIRED\r\n");
        stringBuilder.append("        LAYOUT CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT METADATA (FIELD)*>\r\n");
        stringBuilder.append("<!ELEMENT FIELD EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST FIELD\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED\r\n");
        stringBuilder.append("        TYPE (TEXT|NUMBER|DATE|TIME|TIMESTAMP|CONTAINER) #REQUIRED\r\n");
        stringBuilder.append("        EMPTYOK (YES|NO) #REQUIRED\r\n");
        stringBuilder.append("        MAXREPEAT CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT RESULTSET (ROW)*>\r\n");
        stringBuilder.append("    <!ATTLIST RESULTSET\r\n");
        stringBuilder.append("        FOUND CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT ROW (COL)*>\r\n");
        stringBuilder.append("    <!ATTLIST ROW\r\n");
        stringBuilder.append("        RECORDID CDATA #REQUIRED\r\n");
        stringBuilder.append("        MODID CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT COL (DATA)*>\r\n");
        stringBuilder.append("<!ELEMENT DATA (#PCDATA)>");
        printWriter.write(stringBuilder.toString());
    }

    @Override
    public String getNameSpace() {
        return "http://www.filemaker.com/fmpxmlresult";
    }
}

