/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.OrExpr;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class ConstExpr
extends IdlSymbol {
    public OrExpr or_expr;

    public ConstExpr(int n) {
        super(n);
    }

    public void parse() {
        this.or_expr.parse();
    }

    public void setDeclaration(ConstDecl constDecl) {
        this.or_expr.setDeclaration(constDecl);
    }

    public void print(PrintWriter printWriter) {
        this.or_expr.print(printWriter);
    }

    public int pos_int_const() {
        return this.or_expr.pos_int_const();
    }

    public String toString() {
        return this.or_expr.toString();
    }

    public str_token get_token() {
        return this.or_expr.get_token();
    }

    public String value() {
        return this.or_expr.value();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.or_expr.setPackage(string);
    }
}

