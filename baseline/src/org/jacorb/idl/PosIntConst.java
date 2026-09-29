/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class PosIntConst
extends IdlSymbol {
    private int value = -1;
    ConstExpr const_expr;

    public PosIntConst(int n) {
        super(n);
    }

    void setExpression(ConstExpr constExpr) {
        this.const_expr = constExpr;
    }

    public void parse() {
        this.const_expr.parse();
    }

    public int value() {
        if (this.value == -1) {
            this.value = this.const_expr.pos_int_const();
            if (this.value <= 0) {
                lexer.restorePosition(this.myPosition);
                parser.fatal_error("Integer constant value must be greater 0.", this.token);
            }
        }
        return this.value;
    }

    public String toString() {
        return this.const_expr.toString();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.const_expr.setPackage(string);
    }
}

