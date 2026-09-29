/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.FixedArraySize;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ArrayDeclarator
extends Declarator {
    public SymbolList fixed_array_size_list;
    private int[] dimensions = null;

    public ArrayDeclarator(int n) {
        super(n);
    }

    public String name() {
        return this.name;
    }

    public void escapeName() {
        if (!this.name.startsWith("_") && lexer.strictJavaEscapeCheck(this.name)) {
            this.name = "_" + this.name;
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        Enumeration enumeration = this.fixed_array_size_list.v.elements();
        while (enumeration.hasMoreElements()) {
            ((FixedArraySize)enumeration.nextElement()).setPackage(string);
        }
    }

    String full_name() {
        if (this.name.length() == 0) {
            return null;
        }
        if (this.pack_name.length() > 0) {
            return this.pack_name + "." + this.name;
        }
        return this.name;
    }

    public void parse() {
        Enumeration enumeration = this.fixed_array_size_list.v.elements();
        while (enumeration.hasMoreElements()) {
            ((FixedArraySize)enumeration.nextElement()).parse();
        }
        enumeration = this.fixed_array_size_list.v.elements();
        while (enumeration.hasMoreElements()) {
            ((FixedArraySize)enumeration.nextElement()).parse();
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public IdlSymbol getEnclosingSymbol() {
        return this.enclosing_symbol;
    }

    public int[] dimensions() {
        if (this.dimensions == null) {
            Vector<Integer> vector = new Vector<Integer>();
            Enumeration enumeration = this.fixed_array_size_list.v.elements();
            while (enumeration.hasMoreElements()) {
                vector.addElement(new Integer(((FixedArraySize)enumeration.nextElement()).value()));
            }
            this.dimensions = new int[vector.size()];
            for (int i = 0; i < this.dimensions.length; ++i) {
                this.dimensions[i] = (Integer)vector.elementAt(i);
            }
        }
        return this.dimensions;
    }

    public String toString() {
        return this.name();
    }

    public void print(PrintWriter printWriter) {
    }
}

