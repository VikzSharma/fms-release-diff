/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.AndExpr;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class XorExpr
extends IdlSymbol {
    public XorExpr xor_expr = null;
    public AndExpr and_expr;

    public XorExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.xor_expr != null) {
            this.xor_expr.print(printWriter);
            printWriter.print(" ^ ");
        }
        this.and_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.and_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.xor_expr != null) {
            this.xor_expr.setPackage(string);
        }
        this.and_expr.setPackage(string);
    }

    public void parse() {
        if (this.xor_expr != null) {
            this.xor_expr.parse();
        }
        this.and_expr.parse();
    }

    int pos_int_const() {
        return this.and_expr.pos_int_const();
    }

    public String value() {
        String string = "";
        if (this.xor_expr != null) {
            string = this.xor_expr.value() + "^";
        }
        return string + this.and_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.xor_expr != null) {
            string = this.xor_expr + "^";
        }
        return string + this.and_expr;
    }

    public str_token get_token() {
        return this.and_expr.get_token();
    }
}

