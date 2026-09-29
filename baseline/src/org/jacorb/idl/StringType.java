/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class StringType
extends TemplateTypeSpec {
    public ConstExpr max = null;
    private boolean wide = false;

    public StringType(int n) {
        super(n);
    }

    public boolean isWide() {
        return this.wide;
    }

    public void setWide() {
        this.wide = true;
    }

    public Object clone() {
        StringType stringType = new StringType(StringType.new_num());
        stringType.max = this.max;
        if (this.wide) {
            stringType.setWide();
        }
        stringType.parse();
        return stringType;
    }

    public String typeName() {
        return "java.lang.String";
    }

    public String getIDLTypeName() {
        return this.wide ? "wstring" : "string";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public int getTCKind() {
        return 18;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public void print(PrintWriter printWriter) {
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        if (this.max != null) {
            this.max.setPackage(string);
        }
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.StringHolder";
    }

    public String getTypeCodeExpression() {
        if (this.wide) {
            return "org.omg.CORBA.ORB.init().create_wstring_tc(" + (this.max == null ? 0 : this.max.pos_int_const()) + ')';
        }
        return "org.omg.CORBA.ORB.init().create_string_tc(" + (this.max == null ? 0 : this.max.pos_int_const()) + ')';
    }

    public String printReadExpression(String string) {
        if (this.wide) {
            return string + ".read_wstring()";
        }
        return string + ".read_string()";
    }

    public String printReadStatement(String string, String string2) {
        if (this.wide) {
            return string + "=" + string2 + ".read_wstring();";
        }
        return string + "=" + string2 + ".read_string();";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.wide) {
            return string2 + ".write_wstring(" + string + ");";
        }
        return string2 + ".write_string(" + string + ");";
    }

    public String printInsertExpression() {
        if (this.wide) {
            return "insert_wstring";
        }
        return "insert_string";
    }

    public String printExtractExpression() {
        if (this.wide) {
            return "extract_wstring";
        }
        return "extract_string";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }

    public void setSize(ConstExpr constExpr) {
        this.max = constExpr;
    }

    public ConstExpr getSize() {
        return this.max;
    }
}

