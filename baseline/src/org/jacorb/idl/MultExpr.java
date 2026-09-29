/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.UnaryExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class MultExpr
extends IdlSymbol {
    public String operator;
    public MultExpr mult_expr = null;
    public UnaryExpr unary_expr;

    public MultExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.mult_expr != null) {
            this.mult_expr.print(printWriter);
            printWriter.print(this.operator);
        }
        this.unary_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.unary_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        if (this.mult_expr != null) {
            this.mult_expr.setPackage(string);
        }
        this.unary_expr.setPackage(string);
    }

    public void parse() {
        if (this.mult_expr != null) {
            this.mult_expr.parse();
        }
        this.unary_expr.parse();
    }

    int pos_int_const() {
        int n = this.unary_expr.pos_int_const();
        if (this.mult_expr != null) {
            int n2 = this.mult_expr.pos_int_const();
            if (this.operator.equals("*")) {
                n *= n2;
            } else if (this.operator.equals("/")) {
                n /= n2;
            } else if (this.operator.equals("%")) {
                n %= n2;
            }
        }
        return n;
    }

    public String value() {
        String string = "";
        if (this.mult_expr != null) {
            string = this.mult_expr.value() + this.operator;
        }
        return string + this.unary_expr.value();
    }

    public String toString() {
        String string = "";
        if (this.mult_expr != null) {
            string = this.mult_expr.toString() + ' ' + this.operator + ' ';
        }
        return string + this.unary_expr.toString();
    }

    public str_token get_token() {
        return this.unary_expr.get_token();
    }
}

