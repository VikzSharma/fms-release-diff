/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  javolution.xml.stream.XMLOutputFactory
 *  javolution.xml.stream.XMLStreamException
 *  javolution.xml.stream.XMLStreamWriter
 */
package com.filemaker.jwpc.xml.response;

import com.filemaker.jwpc.businessobject.DataSource;
import com.filemaker.jwpc.businessobject.LayoutMetaData;
import com.filemaker.jwpc.businessobject.ProductInfo;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.MultiLinkedHashMap;
import com.filemaker.jwpc.xml.XMLDocument;
import com.filemaker.jwpc.xml.XMLResult;
import java.io.PrintWriter;
import java.io.Writer;
import javolution.xml.stream.XMLOutputFactory;
import javolution.xml.stream.XMLStreamException;
import javolution.xml.stream.XMLStreamWriter;

public class FMPXMLLAYOUTDocument
extends XMLDocument {
    static JWPCLogger logger = JWPCLogger.getLogger(FMPXMLLAYOUTDocument.class);
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    XMLStreamWriter writer = null;
    protected XMLResult resultSet;

    public FMPXMLLAYOUTDocument(Writer writer, XMLResult xMLResult) {
        this.resultSet = xMLResult;
        try {
            this.writer = this.outputFactory.createXMLStreamWriter(writer);
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("FMPXMLLAYOUTDocument() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    public FMPXMLLAYOUTDocument() {
    }

    protected void writeLayoutDataSource() {
        try {
            this.writer.writeStartElement((CharSequence)"LAYOUT");
            DataSource dataSource = this.resultSet.getDataSource();
            if (dataSource != null) {
                this.writer.writeAttribute((CharSequence)"DATABASE", (CharSequence)dataSource.getDatabase());
                this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)dataSource.getLayout());
                LayoutMetaData layoutMetaData = this.resultSet.getLayoutMetaData();
                if (layoutMetaData != null) {
                    for (LayoutMetaData.FieldLayoutInfo fieldLayoutInfo : layoutMetaData.getLayoutInfo()) {
                        this.writer.writeStartElement((CharSequence)"FIELD");
                        this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)fieldLayoutInfo.getFieldName());
                        this.writer.writeStartElement((CharSequence)"STYLE");
                        this.writer.writeAttribute((CharSequence)"TYPE", (CharSequence)fieldLayoutInfo.getStyleType());
                        String string = "";
                        if (fieldLayoutInfo.isValueListDisplayed()) {
                            string = fieldLayoutInfo.getValueListName();
                        }
                        this.writer.writeAttribute((CharSequence)"VALUELIST", (CharSequence)string);
                        this.writer.writeEndElement();
                        this.writer.writeEndElement();
                    }
                }
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeLayoutDataSource() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
    }

    @Override
    public void generateResponse() {
        logger.debugEntering("generateResponse");
        try {
            String string = "<!DOCTYPE FMPXMLLAYOUT PUBLIC \"-//FMI//DTD FMPXMLLAYOUT//EN\" \"/fmi/xml/FMPXMLLAYOUT.dtd\">";
            this.writer.writeProcessingInstruction((CharSequence)"xml", (CharSequence)"version =\"1.0\" encoding=\"UTF-8\" standalone=\"no\"");
            this.writer.writeDTD((CharSequence)string);
            this.writer.writeStartElement((CharSequence)"FMPXMLLAYOUT");
            this.writer.writeAttribute((CharSequence)"xmlns", (CharSequence)this.getNameSpace());
            this.writeErrorCode();
            this.writeProductInfo();
            this.writeLayoutDataSource();
            this.writeValueLists();
            this.writer.writeEndElement();
            this.writer.flush();
            this.writer.close();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("generateResponse() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
        }
        logger.debugExiting("generateResponse");
    }

    private void writeValueLists() {
        try {
            this.writer.writeStartElement((CharSequence)"VALUELISTS");
            MultiLinkedHashMap<String, MultiLinkedHashMap<String, String>> multiLinkedHashMap = this.resultSet.getValueLists();
            for (MultiLinkedHashMap.NVPair<String, MultiLinkedHashMap<String, String>> nVPair : multiLinkedHashMap.getData()) {
                this.writer.writeStartElement((CharSequence)"VALUELIST");
                this.writer.writeAttribute((CharSequence)"NAME", (CharSequence)nVPair.getKey());
                MultiLinkedHashMap<String, String> multiLinkedHashMap2 = nVPair.getValue();
                for (MultiLinkedHashMap.NVPair<String, String> nVPair2 : multiLinkedHashMap2.getData()) {
                    this.writer.writeStartElement((CharSequence)"VALUE");
                    this.writer.writeAttribute((CharSequence)"DISPLAY", (CharSequence)nVPair2.getKey());
                    this.writer.writeCharacters((CharSequence)nVPair2.getValue());
                    this.writer.writeEndElement();
                }
                this.writer.writeEndElement();
            }
            this.writer.writeEndElement();
        }
        catch (XMLStreamException xMLStreamException) {
            logger.debug("writeValueLists() caught an exception " + xMLStreamException.getMessage(), xMLStreamException);
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

    @Override
    public void getDTD(PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!ELEMENT FMPXMLLAYOUT (ERRORCODE,PRODUCT,LAYOUT,VALUELISTS)>\r\n");
        stringBuilder.append("        <!ATTLIST FMPXMLLAYOUT\r\n");
        stringBuilder.append("            xmlns CDATA #FIXED \"http://www.filemaker.com/fmpxmllayout\">\r\n");
        stringBuilder.append("<!ELEMENT ERRORCODE (#PCDATA)>\r\n");
        stringBuilder.append("<!ELEMENT PRODUCT EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST PRODUCT\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED\r\n");
        stringBuilder.append("        VERSION CDATA #REQUIRED\r\n");
        stringBuilder.append("        BUILD CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT LAYOUT (FIELD*)>\r\n");
        stringBuilder.append("    <!ATTLIST LAYOUT\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED\r\n");
        stringBuilder.append("        DATABASE CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT FIELD (STYLE)>\r\n");
        stringBuilder.append("    <!ATTLIST FIELD\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT STYLE EMPTY>\r\n");
        stringBuilder.append("    <!ATTLIST STYLE\r\n");
        stringBuilder.append("        TYPE (POPUPLIST|POPUPMENU|CHECKBOX|RADIOBUTTONS|SCROLLTEXT|SELECTIONLIST|EDITTEXT|CALENDAR) #IMPLIED\r\n");
        stringBuilder.append("        VALUELIST CDATA #IMPLIED>\r\n");
        stringBuilder.append("<!ELEMENT VALUELISTS (VALUELIST)*>\r\n");
        stringBuilder.append("<!ELEMENT VALUELIST (VALUE)*>\r\n");
        stringBuilder.append("    <!ATTLIST VALUELIST\r\n");
        stringBuilder.append("        NAME CDATA #REQUIRED>\r\n");
        stringBuilder.append("<!ELEMENT VALUE (#PCDATA)>\r\n");
        stringBuilder.append("    <!ATTLIST VALUE\r\n");
        stringBuilder.append("        DISPLAY CDATA #IMPLIED>");
        printWriter.write(stringBuilder.toString());
    }

    @Override
    public String getNameSpace() {
        return "http://www.filemaker.com/fmpxmllayout";
    }
}

