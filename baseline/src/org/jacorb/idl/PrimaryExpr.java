/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.ConstExprEvaluator;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.Literal;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.parser;
import org.jacorb.idl.str_token;

public class PrimaryExpr
extends IdlSymbol {
    public IdlSymbol symbol;

    public PrimaryExpr(int n) {
        super(n);
    }

    public void print(PrintWriter printWriter) {
        if (this.symbol instanceof ConstExpr) {
            printWriter.print("(");
            this.symbol.print(printWriter);
            printWriter.print(")");
        } else if (this.symbol instanceof ScopedName) {
            printWriter.print(((ScopedName)this.symbol).resolvedName());
        } else {
            this.symbol.print(printWriter);
        }
    }

    public void parse() {
        this.symbol.parse();
    }

    public void setDeclaration(ConstDecl constDecl) {
        if (this.symbol instanceof Literal) {
            ((Literal)this.symbol).setDeclaration(constDecl);
        }
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.symbol.setPackage(string);
    }

    int pos_int_const() {
        if (this.symbol instanceof ConstExpr) {
            return ((ConstExpr)this.symbol).pos_int_const();
        }
        if (this.symbol instanceof ScopedName) {
            ConstExprEvaluator constExprEvaluator = new ConstExprEvaluator(ConstDecl.namedValue((ScopedName)this.symbol));
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("PrimaryExpr: returning value " + constExprEvaluator.getValue().intValue());
            }
            return constExprEvaluator.getValue().intValue();
        }
        return Integer.parseInt(((Literal)this.symbol).toString());
    }

    public String value() {
        if (this.symbol instanceof ConstExpr) {
            return "(" + ((ConstExpr)this.symbol).value() + ")";
        }
        if (this.symbol instanceof ScopedName) {
            return ConstDecl.namedValue((ScopedName)this.symbol);
        }
        return ((Literal)this.symbol).toString();
    }

    public String toString() {
        if (this.symbol instanceof ConstExpr) {
            return "(" + ((ConstExpr)this.symbol).toString() + ")";
        }
        if (this.symbol instanceof ScopedName) {
            return ((ScopedName)this.symbol).resolvedName();
        }
        return ((Literal)this.symbol).toString();
    }

    public str_token get_token() {
        return this.symbol.get_token();
    }
}

