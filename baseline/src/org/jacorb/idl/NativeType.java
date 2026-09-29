/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.parser;

public class NativeType
extends TypeDeclaration {
    SimpleDeclarator declarator;

    public NativeType(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        NativeType nativeType = new NativeType(NativeType.new_num());
        nativeType.declarator = this.declarator;
        nativeType.pack_name = this.pack_name;
        return nativeType;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public TypeDeclaration declaration() {
        return this;
    }

    public String typeName() {
        if (this.pack_name.length() > 0) {
            return ScopedName.unPseudoName(this.pack_name + "." + this.name);
        }
        return ScopedName.unPseudoName(this.name);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
    }

    public boolean basic() {
        return true;
    }

    public String toString() {
        return this.typeName();
    }

    public void set_included(boolean bl) {
        this.included = bl;
    }

    public void parse() {
        this.name = this.declarator.name();
        this.is_pseudo = true;
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(NativeType.new_num());
        try {
            constrTypeSpec.c_type_spec = this;
            NameTable.define(this.full_name(), "native");
            TypeMap.typedef(this.full_name(), constrTypeSpec);
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.fatal_error("Name already defined", this.token);
        }
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printReadExpression(String string) {
        return this.full_name() + "Helper.read(" + string + ")";
    }

    public String printWriteStatement(String string, String string2) {
        return this.full_name() + "Helper.write(" + string2 + "," + string + ");";
    }

    public void print(PrintWriter printWriter) {
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitNative(this);
    }
}

