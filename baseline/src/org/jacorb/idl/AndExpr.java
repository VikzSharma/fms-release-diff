/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ShiftExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class AndExpr
extends IdlSymbol {
    public AndExpr and_expr = null;
    public ShiftExpr shift_expr;

    public AndExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.and_expr != null) {
            this.and_expr.print(printWriter);
            printWriter.print(" & ");
        }
        this.shift_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.shift_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.and_expr != null) {
            this.and_expr.setPackage(string);
        }
        this.shift_expr.setPackage(string);
    }

    public void parse() {
        if (this.and_expr != null) {
            this.and_expr.parse();
        }
        this.shift_expr.parse();
    }

    int pos_int_const() {
        return this.shift_expr.pos_int_const();
    }

    public String value() {
        String string = "";
        if (this.and_expr != null) {
            string = this.and_expr.value() + "&";
        }
        return string + this.shift_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.and_expr != null) {
            string = this.and_expr + "&";
        }
        return string + this.shift_expr;
    }

    public str_token get_token() {
        return this.shift_expr.get_token();
    }
}

