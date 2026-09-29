/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.parser;

public class SymbolList
extends IdlSymbol {
    Vector v = new Vector();

    public SymbolList(int n) {
        super(n);
    }

    public SymbolList(SimpleDeclarator simpleDeclarator) {
        this(SymbolList.new_num());
        this.v.add(simpleDeclarator);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setPackage(string);
        }
    }

    public int size() {
        return this.v.size();
    }

    public Enumeration elements() {
        return this.v.elements();
    }

    public void parse() {
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).parse();
        }
    }

    public void print(PrintWriter printWriter) {
        Enumeration enumeration = this.v.elements();
        if (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).print(printWriter);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(",");
            ((IdlSymbol)enumeration.nextElement()).print(printWriter);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumeration = this.v.elements();
        if (enumeration.hasMoreElements()) {
            stringBuffer.append((IdlSymbol)enumeration.nextElement());
        }
        while (enumeration.hasMoreElements()) {
            stringBuffer.append("," + (IdlSymbol)enumeration.nextElement());
        }
        return stringBuffer.toString();
    }
}

