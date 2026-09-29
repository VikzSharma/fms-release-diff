/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class TypeDeclarator
extends IdlSymbol {
    public TypeSpec type_spec;
    public SymbolList declarators;

    public TypeDeclarator(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.type_spec.setPackage(string);
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            Declarator declarator = (Declarator)enumeration.nextElement();
            declarator.setPackage(string);
        }
    }

    public void parse() {
        throw new RuntimeException("This method may not be used!");
    }

    public TypeSpec type_spec() {
        return this.type_spec.typeSpec();
    }

    public String typeName() {
        return this.type_spec.typeName();
    }

    public void print(PrintWriter printWriter) {
        this.type_spec.print(printWriter);
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            ((Declarator)enumeration.nextElement()).print(printWriter);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        this.enclosing_symbol = idlSymbol;
        this.type_spec.setEnclosingSymbol(idlSymbol);
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            ((Declarator)enumeration.nextElement()).setEnclosingSymbol(idlSymbol);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.type_spec.toString());
        Enumeration enumeration = this.declarators.v.elements();
        while (enumeration.hasMoreElements()) {
            stringBuffer.append(enumeration.nextElement());
        }
        return stringBuffer.toString();
    }
}

