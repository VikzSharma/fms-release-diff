/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.MultExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class AddExpr
extends IdlSymbol {
    public AddExpr add_expr = null;
    public String operator;
    public MultExpr mult_expr;

    public AddExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.add_expr != null) {
            this.add_expr.print(printWriter);
            printWriter.print(this.operator);
        }
        this.mult_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.mult_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.add_expr != null) {
            this.add_expr.setPackage(string);
        }
        this.mult_expr.setPackage(string);
    }

    public void parse() {
        if (this.add_expr != null) {
            this.add_expr.parse();
        }
        this.mult_expr.parse();
    }

    int pos_int_const() {
        int n = this.mult_expr.pos_int_const();
        if (this.add_expr != null) {
            int n2 = this.add_expr.pos_int_const();
            if (this.operator.equals("-")) {
                n2 *= -1;
            }
            return n2 + n;
        }
        return n;
    }

    public String value() {
        String string = "";
        if (this.add_expr != null) {
            string = this.add_expr.value() + this.operator;
        }
        return string + this.mult_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.add_expr != null) {
            string = this.add_expr.toString() + ' ' + this.operator + ' ';
        }
        return string + this.mult_expr;
    }

    public str_token get_token() {
        return this.mult_expr.get_token();
    }
}

