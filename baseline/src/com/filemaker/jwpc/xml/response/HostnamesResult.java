/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javolution.util.FastList
 *  javolution.xml.stream.XMLStreamException
 */
package com.filemaker.jwpc.xml.response;

import com.filemaker.jwpc.xml.response.FMResultSetDocument;
import java.io.PrintWriter;
import java.util.List;
import javolution.util.FastList;
import javolution.xml.stream.XMLStreamException;

public class HostnamesResult
extends FMResultSetDocument {
    private List<String> hostNames = new FastList();

    public HostnamesResult(PrintWriter printWriter) {
        super(printWriter);
    }

    public HostnamesResult(PrintWriter printWriter, List<String> list) {
        this(printWriter);
        this.hostNames.addAll(list);
    }

    @Override
    protected void writeResultSet() {
        try {
            if (this.writer != null) {
                this.writer.writeStartElement((CharSequence)"resultset");
                this.writer.writeAttribute((CharSequence)"count", (CharSequence)Integer.toString(this.hostNames.size()));
                this.writer.writeAttribute((CharSequence)"fetch-size", (CharSequence)Integer.toString(this.hostNames.size()));
                this.writer.writeStartElement((CharSequence)"record");
                this.writer.writeAttribute((CharSequence)"mod-id", (CharSequence)"0");
                this.writer.writeAttribute((CharSequence)"record-id", (CharSequence)"0");
                this.writer.writeStartElement((CharSequence)"field");
                this.writer.writeAttribute((CharSequence)"name", (CharSequence)"HOST_NAME");
                for (String string : this.hostNames) {
                    this.writer.writeStartElement((CharSequence)"data");
                    this.writer.writeCharacters((CharSequence)string);
                    this.writer.writeEndElement();
                }
                this.writer.writeEndElement();
                this.writer.writeEndElement();
                this.writer.writeEndElement();
            }
        }
        catch (XMLStreamException xMLStreamException) {
            xMLStreamException.printStackTrace();
        }
    }

    @Override
    protected void writeMetaData() {
    }
}

