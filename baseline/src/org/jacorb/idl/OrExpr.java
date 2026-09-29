/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.XorExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class OrExpr
extends IdlSymbol {
    public OrExpr or_expr = null;
    public XorExpr xor_expr;

    public OrExpr(int n) {
        super(n);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.xor_expr.setDeclaration(constDecl);
    }

    public void print(PrintWriter printWriter) {
        if (this.or_expr != null) {
            this.or_expr.print(printWriter);
            printWriter.print(" | ");
        }
        this.xor_expr.print(printWriter);
        printWriter.flush();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.or_expr != null) {
            this.or_expr.setPackage(string);
        }
        this.xor_expr.setPackage(string);
    }

    public void parse() {
        if (this.or_expr != null) {
            this.or_expr.parse();
        }
        this.xor_expr.parse();
    }

    int pos_int_const() {
        return this.xor_expr.pos_int_const();
    }

    public String value() {
        String string = "";
        if (this.or_expr != null) {
            string = this.or_expr.value() + " | ";
        }
        return string + this.xor_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.or_expr != null) {
            string = this.or_expr + " | ";
        }
        return string + this.xor_expr;
    }

    public str_token get_token() {
        return this.xor_expr.get_token();
    }
}

