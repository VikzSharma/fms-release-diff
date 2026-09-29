/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.AddExpr;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class ShiftExpr
extends IdlSymbol {
    public ShiftExpr shift_expr = null;
    public AddExpr add_expr;
    public String operator;

    public ShiftExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.shift_expr != null) {
            this.shift_expr.print(printWriter);
            printWriter.print(this.operator);
        }
        this.add_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.add_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.shift_expr != null) {
            this.shift_expr.setPackage(string);
        }
        this.add_expr.setPackage(string);
    }

    public void parse() {
        if (this.shift_expr != null) {
            this.shift_expr.parse();
        }
        this.add_expr.parse();
    }

    int pos_int_const() {
        return this.add_expr.pos_int_const();
    }

    public String value() {
        String string = "";
        if (this.shift_expr != null) {
            string = this.shift_expr.value() + this.operator;
        }
        return string + this.add_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.shift_expr != null) {
            string = this.shift_expr + this.operator;
        }
        return string + this.add_expr;
    }

    public str_token get_token() {
        return this.add_expr.get_token();
    }
}

