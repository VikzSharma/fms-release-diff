/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.PrimaryExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class UnaryExpr
extends IdlSymbol {
    public String unary_op = "";
    public PrimaryExpr primary_expr;

    public UnaryExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        printWriter.print(this.unary_op);
        this.primary_expr.print(printWriter);
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.primary_expr.setDeclaration(constDecl);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.primary_expr.setPackage(string);
    }

    public void parse() {
        this.primary_expr.parse();
    }

    int pos_int_const() {
        int n = this.primary_expr.pos_int_const();
        if (!this.unary_op.equals("")) {
            if (this.unary_op.equals("-")) {
                return n * -1;
            }
            return n;
        }
        return n;
    }

    public String value() {
        return this.unary_op + this.primary_expr.value();
    }

    public String toString() {
        return this.unary_op.toString() + this.primary_expr.toString();
    }

    public str_token get_token() {
        return this.primary_expr.get_token();
    }
}

